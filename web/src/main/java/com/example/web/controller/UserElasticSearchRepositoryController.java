package com.example.web.controller;

import com.example.service.UserElasticSearchRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.Map;


@RestController
@RequestMapping("/es")
public class UserElasticSearchRepositoryController {
   /* @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    *//* @Autowired
     private ElasticsearchTemplate elasticsearchTemplate;*//*
    //@Autowired
   // private UserElasticSearchRepository userElasticSearchRepository;

    @RequestMapping(value = "/createIndex")
    public void testIndex() {
        // 创建索引
        //elasticsearchRestTemplate.createIndex(User.class);
        // 创建mapping字段映射
        //elasticsearchRestTemplate.putMapping(User.class);
        // 查看索引是否存在
        //boolean exists = elasticsearchRestTemplate.indexExists("user1");
        //System.out.println(exists);
        // 删除索引
        *//*elasticsearchRestTemplate.deleteIndex("user1");
        //elasticsearchRestTemplate.createM
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        //查询运营区域
        boolQueryBuilder.must(QueryBuilders.termQuery("userId","3"));
        boolQueryBuilder.must(QueryBuilders.termQuery("userName","李狗胖"));
        //时间范围
        boolQueryBuilder.filter(QueryBuilders.rangeQuery("时间字段")
                .from(new Date())
                .to(new Date())
                .includeLower(true)
                .includeUpper(true));
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        nativeSearchQueryBuilder.withIndices("user1");
        nativeSearchQueryBuilder.withTypes("doc");
        //生产NativeSearchQuery
        NativeSearchQuery query = nativeSearchQueryBuilder.build();

        long count = elasticsearchRestTemplate.count(query);
        SearchQuery query1 = nativeSearchQueryBuilder.build();
        Object[] o  elasticsearchRestTemplate.query(query1, response -> {
            Object[] objects = Arrays.stream(response.getHits().getHits()).toArray();
            return objects;
        });
        // 索引不存在会抛异常
        SearchRequest searchRequest = new SearchRequest("user");
        SearchSourceBuilder searchSourceBuilder=  new SearchSourceBuilder();
        //匹配查询
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery("狗子胖","userName"));
        // 分页 from里面放的是开始分页开始条数size是每页条数
        searchSourceBuilder.from(0).size(3);
        // 分数排序默认是倒序排
        // searchSourceBuilder.sort(SortBuilders.scoreSort().order(SortOrder.ASC));
        // 指定字段排序(默认分数排序失效)
        searchSourceBuilder.sort(SortBuilders.fieldSort("userId").order(SortOrder.DESC));
        // 设置高亮信息
        HighlightBuilder highlightBuilder = new HighlightBuilder().field("userName").preTags("<p style=''color:red>").postTags("</p>");
        searchSourceBuilder.highlighter(highlightBuilder);
        searchRequest.source(searchSourceBuilder);
        //SearchResponse response = elasticsearchRestTemplate.search(searchRequest, RequestOptions.DEFAULT);
        // 获取查询的条数
        Long result =  response.getHits().getTotalHits().value;
        if(result > 0){
            // 默认情况下只展示十条数据
            // 解析查询的数据数据
            SearchHit[] hits = response.getHits().getHits();
            for (SearchHit hit:hits) {
                String index =hit.getIndex();
                System.out.println("index"+"======="+index);
                float score = hit.getScore();
                System.out.println("score"+"======="+score);
                String id = hit.getId();
                System.out.println("id"+"======="+id);
                Map<String,Object> map = hit.getSourceAsMap();
                map.forEach((k,v)->System.out.println(k+"======="+v));
                System.out.println("88888888888888888888888888888888");
                // 高亮信息要处理一下

                System.out.println("hi"+String.valueOf(hit.getHighlightFields().get("userName").fragments()[0]));
            }
        }
    }*//*
    }*/
}