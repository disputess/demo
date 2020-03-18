package com.example.service.datasources;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.google.common.collect.ImmutableList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 配置多数据源
 * @author xukaisheng
 * @email 18511430131@163.com
 * @date 2017/8/19 0:41
 */
@Configuration
public class DynamicDataSourceConfig implements ApplicationContextAware {
    
    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceConfig.class);
    
    private ApplicationContext applicationContext;

    private ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.first")
    public DataSource firstDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.second")
    public DataSource secondDataSource(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    @Primary
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        List<DataSource> dsList= ImmutableList.of(firstDataSource,secondDataSource);
        scheduledExecutorService.scheduleAtFixedRate(()->{
            for(DataSource ds:dsList){
                try{
                    if(DruidDataSource.class.isAssignableFrom(ds.getClass())){
                        if(((DruidDataSource)ds).isInited()){
                            logger.trace("dataSource monitor:"+ ((DruidDataSource)ds).getStatDataForMBean());
                        }
                    }
                }catch (Exception e){
                    //ignore
                }
            }
        },30L,30L, TimeUnit.SECONDS);
        return new DynamicDataSource(firstDataSource, targetDataSources);
    }
    
    /*@Bean("shardingDataSource")
    public DataSource shardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        TableRuleConfiguration tableRule = new TableRuleConfiguration();
        tableRule.setLogicTable("bike_op_stat");
        tableRule.setActualDataNodes("ds.bike_op_stat_$->{0..9}");
        tableRule.setKeyGeneratorColumnName("id");
        long workId = getWorkIdByHostIp();
        logger.error("KeyGenerator workId:{}", workId);
        DefaultKeyGenerator.setWorkerId(workId);
        
        tableRule.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("bike_id", new BikeOpStatTableShardingAlgorithm(), null));
        shardingRuleConfig.getTableRuleConfigs().add(tableRule);
        
        DataSource firstDataSource = (DataSource) applicationContext.getBean("firstDataSource");
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds", firstDataSource);
        Properties props = new Properties();
//        props.put("sql.show", true);
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new HashMap<String, Object>(), props);
    }*/
    
    private static long getWorkIdByHostIp(){
        try{
            Enumeration<NetworkInterface> allNetInterfaces = NetworkInterface.getNetworkInterfaces();
            while (allNetInterfaces.hasMoreElements()){
                NetworkInterface netInterface = (NetworkInterface) allNetInterfaces.nextElement();
                Enumeration<InetAddress> addresses = netInterface.getInetAddresses();
                while (addresses.hasMoreElements()){
                    InetAddress ip = (InetAddress) addresses.nextElement();
                    if (ip != null 
                            && ip instanceof Inet4Address
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1){
                        logger.error("本机的IP地址:{}", ip.getHostAddress());
                        return Long.parseLong(ip.getHostAddress().toString().split("\\.")[3]);
                    } 
                }
            }
        }catch(Exception e){
            logger.error("获取本机IP地址时发生异常", e);
        }
        return (long)new Random().nextInt(1000);
    }
    
}
