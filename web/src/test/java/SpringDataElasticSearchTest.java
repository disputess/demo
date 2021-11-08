//import com.example.domain.entity.User;
//import com.example.service.UserElasticSearchRepository;
import com.example.web.App;
//import org.junit.Test;
import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = App.class)
public class SpringDataElasticSearchTest {
    /*@Resource
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
   *//* @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;*//*
    @Autowired
    private UserElasticSearchRepository userElasticSearchRepository;
   // @Test
    public void testIndex(){
        // 创建索引
        //elasticsearchRestTemplate.createIndex(User.class);
        // 创建mapping字段映射
        //elasticsearchRestTemplate.putMapping(User.class);
        // 查看索引是否存在
        //boolean exists = elasticsearchRestTemplate.indexExists("user1");
        //System.out.println(exists);
        // 删除索引
        elasticsearchRestTemplate.deleteIndex("user1");
        //elasticsearchRestTemplate.createM
    }
    @Test
    public void testRepository(){
        Iterable<User> all = userElasticSearchRepository.findAll();
    all.forEach(System.out::println);
    }*/
}
