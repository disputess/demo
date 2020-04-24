package com.example.web.controller;

import com.example.domain.entity.ShareDatasourcesTableEntity;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.service.ShareOpStatService;
import com.example.service.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class ShareOpStatController {
    private static final Logger logger = LoggerFactory.getLogger(ShareOpStatController.class);

    @Autowired
    private ShareOpStatService shareOpStatService;

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/share/table")
    public void shareTable(){
        ShareOpStatEntity shareOpStatEntity = new ShareOpStatEntity();
        shareOpStatEntity.setShareId(55L);
        shareOpStatEntity.setName("徐辣鸡");
        shareOpStatService.insertShareOpStat(shareOpStatEntity);

        logger.info("分表成功");
    }
    @RequestMapping(value = "/create/table")
    public void createTable(){
        testService .createTable();
        logger.info("建表成功");
    }
    @RequestMapping(value = "/insert/List")
    public void insertList(){
        shareOpStatService.insertList();
        logger.info("分库分表插入成功");
    }
    @RequestMapping(value = "/select/list")
    public void selectList(){
       List<ShareDatasourcesTableEntity>  list  = shareOpStatService.selectList();
       for(ShareDatasourcesTableEntity shareDatasourcesTableEntity:list){
           System.out.println(shareDatasourcesTableEntity.toString());
       }
        logger.info("分库分表查询成功");
    }
}
