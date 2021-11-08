package com.example.service.datasources;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

public class BikeOpStatTableShardingAlgorithm implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        for (String tableName : availableTargetNames)
            if (tableName.endsWith(shardingValue.getValue() % 10 + ""))
                return tableName;

        throw new UnsupportedOperationException();
    }

    /*@Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        for (String tableName : availableTargetNames)
            if (tableName.endsWith(shardingValue.getValue() % 10 + ""))
                return tableName;

        throw new UnsupportedOperationException();
    }*/
    /**
     * 功能描述  根据分表规则拼接要应该要存入的表名
     * @param availableTargetNames
     * @param shardingValue
     * @return
     * @author songchaojie
     * @Date: 2020年03月18日
     **/
    /*@Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        for (String tableName : availableTargetNames){
            if (tableName.endsWith(shardingValue.getValue() % 2+ "")){
                return tableName;
            }
        }
        throw new UnsupportedOperationException();
    }*/

}
