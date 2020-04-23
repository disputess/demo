package com.example.service.datasources;

import io.shardingsphere.api.algorithm.sharding.PreciseShardingValue;
import io.shardingsphere.api.algorithm.sharding.standard.PreciseShardingAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 分表算法
 */
public class TableAlg implements PreciseShardingAlgorithm<Integer> {
    private static Logger LOG = LoggerFactory.getLogger(TableAlg.class);
    /**
     * 该表每个库分5张表
     */
    @Override
    public String doSharding(Collection<String> names, PreciseShardingValue<Integer> value) {
        LOG.info("分表算法参数 表名集合{},表前缀{},分表字段{},分表字段值{}",names,value.getLogicTableName(),value.getColumnName(),value.getValue());
        List<Integer> list =  new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        /*for (String tableName : names){
            if(list.contains(value.getValue() % 10)){
                System.out.println("分表算法参数 {},{}"+names+value);

                return  tableName.replace(tableName.charAt(tableName.length()-1)+"","0");
            }
                return  tableName.replace(tableName.charAt(tableName.length()-1)+"","1");

        }*/
        if(list.contains(value.getValue() % 10)){
            LOG.info("实际插入数据表名{},分表字段实际值{}",value.getLogicTableName()+"_0",value.getValue());
            return  value.getLogicTableName()+"_0";
        }else{
            LOG.info("实际插入数据表名{},分表字段实际值{}",value.getLogicTableName()+"_1",value.getValue());
            return  value.getLogicTableName()+"_1";
        }

       // throw new UnsupportedOperationException();
    }
}
