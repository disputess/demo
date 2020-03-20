package com.example.service.datasources;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 分表算法
 */
public class TableAlg implements PreciseShardingAlgorithm<String> {
    private static Logger LOG = LoggerFactory.getLogger(TableAlg.class);
    /**
     * 该表每个库分5张表
     */
    @Override
    public String doSharding(Collection<String> names, PreciseShardingValue<String> value) {
        LOG.debug("分表算法参数 {},{}",names,value);
        for (String tableName : names){
            if (tableName.endsWith(Long.valueOf(value.getValue()) % 2+ "")){
                return tableName;
            }
        }
        throw new UnsupportedOperationException();
    }
}
