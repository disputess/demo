package com.example.service.datasources;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.google.common.collect.ImmutableList;
import io.shardingsphere.api.config.ShardingRuleConfiguration;
import io.shardingsphere.api.config.TableRuleConfiguration;
import io.shardingsphere.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingsphere.core.keygen.DefaultKeyGenerator;
import io.shardingsphere.core.rule.ShardingRule;
import io.shardingsphere.core.rule.TableRule;
import io.shardingsphere.shardingjdbc.api.ShardingDataSourceFactory;
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
import java.sql.SQLException;
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
    private final static String order = "share_op_stat";
    
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
    public DynamicDataSource dataSource(DataSource firstDataSource, DataSource secondDataSource, DataSource shardingDataSource) {
        Map<String, DataSource> targetDataSources = new HashMap<>();
        targetDataSources.put(DataSourceNames.FIRST, firstDataSource);
        targetDataSources.put(DataSourceNames.SECOND, secondDataSource);
        targetDataSources.put(DataSourceNames.SHARDING, shardingDataSource);
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
    
  @Bean("shardingDataSource")
    public DataSource shardingDataSource() throws SQLException {
        ShardingRuleConfiguration shardingRuleConfig = new ShardingRuleConfiguration();
        TableRuleConfiguration tableRule = new TableRuleConfiguration();
        tableRule.setLogicTable("share_op_stat");
        tableRule.setActualDataNodes("ds.share_op_stat_$->{0..1}");
        tableRule.setKeyGeneratorColumnName("id");
        long workId = getWorkIdByHostIp();
        logger.error("KeyGenerator workId:{}", workId);
        DefaultKeyGenerator.setWorkerId(workId);
        tableRule.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("share_id", new BikeOpStatTableShardingAlgorithm(), null));
        shardingRuleConfig.getTableRuleConfigs().add(tableRule);
        DataSource firstDataSource = (DataSource) applicationContext.getBean("firstDataSource");
        Map<String, DataSource> dataSourceMap = new HashMap<>();
        dataSourceMap.put("ds", firstDataSource);
        Properties props = new Properties();
//        props.put("sql.show", true);
        return ShardingDataSourceFactory.createDataSource(dataSourceMap, shardingRuleConfig, new HashMap<String, Object>(), props);
    }
    
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
    /*private TableRule getOrderTableRule() throws SQLException {
        String[] uns = new String[2];
        for (int i = 0; i < 2; i++) {
            uns[i] = order.concat("_").concat(String.valueOf(i));
        }
        TableRule tableRule = TableRule.build
                .actualTables(Arrays.asList(uns))
                .dataSourceRule("")
                .tableShardingStrategy(new TableShardingStrategy("order_sn", new BikeOpStatTableShardingAlgorithm()))
                .build();
        return tableRule;
    }
    private ShardingRule shardingRule() throws SQLException {
        ShardingRule shardingRule = ShardingRule.builder()
                .dataSourceRule(getDataSourceRule())
                .tableRules(Arrays.asList(getOrderTableRule())).build();
        return shardingRule;
    }*/
}
