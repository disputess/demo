package com.example.service.impl;

import com.example.domain.entity.*;
import com.example.service.ShareOpStatService;
import com.example.service.datasources.DynamicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.dao.TestDao;
import com.example.service.TestService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("testService")
public class TestServiceImpl implements TestService {

    @Autowired
    private TestDao testDao;
    @Autowired
    private ShareOpStatService shareOpStatService;
    @Autowired
    @Qualifier("firstDataSourceTemplate")
    private JdbcTemplate firstDataSourceTemplate ;

    @Autowired
    @Qualifier("secondDataSourceTemplate")
    private JdbcTemplate secondDataSourceTemplate ;

    @Autowired
    @Qualifier("thirdDataSourceTemplate")
    private JdbcTemplate thirdDataSourceTemplate ;
    @Override
    public List<TestEntity> getAll() {
        return testDao.getAll();
    }

    @Override
    public List<UsersEntity> changeDatasource() {
        List<UsersEntity> list  =new ArrayList<>();
        try {
            DynamicDataSource.setDataSource("second");
            list = testDao.changeDatasource();
        } catch (Exception e) {
            System.out.println("根据车辆{},车型查询配套配件异常{}"+ e);
        } finally {
            DynamicDataSource.clearDataSource();
        }
        return list;
    }

    @Override
    public void test(ShareOpStatEntity shareOpStatEntity) {
        System.out.println("shareOpStatEntity = [" + shareOpStatEntity.toString() + "]");
        shareOpStatService.insertShareOpStat(shareOpStatEntity);
    }

    @Override
    public void createTable() {
        for (int i = 5 ; i <= 9 ; i++){
            String executeSQL = "CREATE TABLE share_"+i+" (\n" +
                    "  `id` int(11) NOT NULL  COMMENT '主键ID',\n" +
                    "  `phone` varchar(20) NOT NULL COMMENT '手机号',\n" +
                    "  `back_one` varchar(50) DEFAULT NULL COMMENT '备用1',\n" +
                    "  `back_two` varchar(50) DEFAULT NULL COMMENT '备用2',\n" +
                    "  `back_three` varchar(50) DEFAULT NULL COMMENT '备用3',\n" +
                    "  `share_id` int(50) DEFAULT NULL COMMENT '分表id',\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  KEY `phoneIndex` (`phone`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;" ;
            //secondDataSourceTemplate.execute(executeSQL);
            thirdDataSourceTemplate.execute(executeSQL);
        }
    }

    @Override
    public void insertList() {
        for (int i = 1 ; i < 10000 ; i++){
            ShareDatasourcesTableEntity tableOne = new ShareDatasourcesTableEntity() ;
            tableOne.setPhone("phone"+i);
            tableOne.setBackOne("back_one"+i);
            tableOne.setBackTwo("back_two"+i);
            tableOne.setBackThree("back_three"+i);
            tableOne.setShareId(i);
            testDao.insertShareDataSourcesTable(tableOne);
        }
    }
}
