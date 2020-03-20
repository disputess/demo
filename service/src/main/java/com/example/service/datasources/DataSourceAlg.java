package com.example.service.datasources;/**
 * @title: DataSourceAlg
 * @projectName demo
 * @description: TODO
 * @author 123
 * @date 2020/3/1917:11
 */

/**
 *@ClassName DataSourceAlg
 *@Description TODO
 *@Author 宋超杰
 *@Date 2020/3/19 17:11
 *@Version 1.0
 **/

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.concurrent.locks.Lock;

/**
 * 数据库映射计算
 */
public class DataSourceAlg implements PreciseShardingAlgorithm<Long> {

    private static Logger LOG = LoggerFactory.getLogger(DataSourceAlg.class);
    @Override
    public String doSharding(Collection<String> names, PreciseShardingValue<Long> value) {
        /*LOG.debug("分库算法参数 {},{}",names,value);
        for (String dataSourcesName : names){
            if (dataSourcesName.endsWith(value.getValue() % 2+ "")){
                return dataSourcesName;
            }
        }*/
        for (String dataSourcesName : names) {
            int i = 2;
            if (value.getValue() % 2 != 0) {
                i = 3;
            }
            if (dataSourcesName.endsWith(i + "")) {
                return dataSourcesName;
            }
        }
        throw new UnsupportedOperationException();
    }
}
