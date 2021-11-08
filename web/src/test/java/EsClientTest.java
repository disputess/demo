import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class EsClientTest {
    // 服务器地址
    private final String HOSTNAME="81.70.205.10";
    // 连接方式
    private final String SCHEME="http";
    // 高级客户端
    private RestHighLevelClient client =null;
    // 节点信息(服务器地址,端口，连接方式)
    // 集群方式
    /*private HttpHost[] httpHosts = new HttpHost[] {
        new HttpHost(HOSTNAME,9200,SCHEME),
        new HttpHost(HOSTNAME,9201,SCHEME),
        new HttpHost(HOSTNAME,9202,SCHEME)
    };*/
    // 单节点方式
    private HttpHost httpHosts = new HttpHost(HOSTNAME,9200,SCHEME);
   // 初始化客户端
    @Before
    public void innit(){
        client = new RestHighLevelClient(RestClient.builder(httpHosts));
    }
    //关闭客户端
    @After
    public void close(){

            try {
                if(client!=null) {
                    client.close();
                }} catch (IOException e) {
                e.printStackTrace();
            }

    }

    @Test
    public void testCreate() throws IOException {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","仙女姐姐");
        map.put("content","真不错啊");
        IndexRequest indexRequest = new IndexRequest("ik").id("5").source(map);
        IndexResponse response =  client.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }
    @Test
    public void testGet() throws IOException {
        GetRequest getRequest =new GetRequest("ik","5");
        GetResponse response =  client.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }

    @Test
    public void testUpdate() throws IOException {
        HashMap<String,Object> map = new HashMap<>();
        map.put("name","仙女猪");
        map.put("content","真不错啊");
        map.put("age","23");
        map.put("high","161");
        UpdateRequest updateRequest = new UpdateRequest("ik","5").doc(map);
        UpdateResponse response =  client.update(updateRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }
    @Test
    public void testDelete() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("ik").id("5");
        DeleteResponse response =  client.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }
    @Test
    public void testCUD() throws IOException {
        BulkRequest bulkRequest = new BulkRequest();
        bulkRequest.add(new IndexRequest("ik").id("5").source(XContentType.JSON,"name","陈平安","名言","我是山都清水郎"));
        bulkRequest.add(new IndexRequest("ik").id("6").source(XContentType.JSON,"name","董三更","名言","携月撞蛮荒"));
        bulkRequest.add(new IndexRequest("ik").id("7").source(XContentType.JSON,"name","宁姚","名言","一剑十万个陈平安"));
        bulkRequest.add(new UpdateRequest("ik","7").doc(XContentType.JSON,"name","宁姚","名言","五彩天下第一人"));
        bulkRequest.add(new DeleteRequest("ik").id("5"));
        BulkResponse response = client.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(response);
    }
    @Test
    public void testGetAll() throws IOException {
        // 索引不存在会抛异常
        SearchRequest searchRequest = new SearchRequest("ik","user");
        SearchSourceBuilder searchSourceBuilder=  new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.matchAllQuery());
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        // 获取查询的条数
        Long result =  response.getHits().getTotalHits().value;
        if(result > 0){
            // 默认情况下只展示十条数据
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
            }
        }
        //System.out.println(response);
    }

    @Test
    public void testGetMatch() throws IOException {
        // 索引不存在会抛异常
        // 可以搜索多个索引
        SearchRequest searchRequest = new SearchRequest("ik","user");
        SearchSourceBuilder searchSourceBuilder=  new SearchSourceBuilder();
        //匹配查询
        String key = "中国";
        // 多条件匹配可以匹配多个字段
        searchSourceBuilder.query(QueryBuilders.multiMatchQuery(key,"content","userName"));
        searchRequest.source(searchSourceBuilder);
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
        // 获取查询的条数
        Long result =  response.getHits().getTotalHits().value;
        if(result > 0){
            // 默认情况下只展示十条数据
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
            }
        }
        //System.out.println(response);
    }

    @Test
    public void testGetHighLevel() throws IOException {
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
        SearchResponse response = client.search(searchRequest, RequestOptions.DEFAULT);
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
        //System.out.println(response);
    }
}
