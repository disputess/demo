package com.example.web.controller;
import com.example.domain.entity.ShareOpStatEntity;
import com.example.domain.entity.TestEntity;
import com.example.domain.entity.UsersEntity;
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
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private TestService testService;
    @Autowired
    private ShareOpStatService shareOpStatService;
    @RequestMapping(value = "/getAll")
   public String getAll(){
       List<TestEntity> list = testService.getAll();
       return list.get(0).toString();
   }

    @RequestMapping(value = "/change/datasource")
    public String changeDatasource(){
        List<UsersEntity> list = testService.changeDatasource();
        return list.toString();
    }
    @RequestMapping(value = "/share/table")
    public void shareTable(){

            ShareOpStatEntity  shareOpStatEntity = new ShareOpStatEntity();
            shareOpStatEntity.setUid(System.currentTimeMillis());
            shareOpStatEntity.setShareId(55L);
            shareOpStatEntity.setName("徐辣鸡");
            testService.test(shareOpStatEntity);
            shareOpStatService.insertShareOpStat(shareOpStatEntity);

        logger.info("分表成功");
    }

}
