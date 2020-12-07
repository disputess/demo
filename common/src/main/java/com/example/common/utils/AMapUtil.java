package com.example.common.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.common.constant.AMapConstant;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.StringUtil;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 高德地图工具类
 * @ClassName: AMapUtil
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2017年1月7日 下午5:12:44
 *
 */
public class AMapUtil {

    private static String API = "http://restapi.amap.com/v3/geocode/geo?key=<key>&s=rsv3&address=<address>";

   // private static String KEY = "aa4a48297242d22d2b3fd6eddfe62217";
    private static String KEY = "7abde9b9270183ecadc1d43f15b0f6a7";

    private static Pattern pattern = Pattern.compile("\"location\":\"(\\d+\\.\\d+),(\\d+\\.\\d+)\"");

    static {
        init();
    }

    /**
     * 地图坐标逆编码
     * @param longitude 坐标经度
     * @param latitude      坐标纬度
     * @return
     */
    public static String getAddress(String longitude,String latitude){
        String address = "";
        if(StringUtils.isNotBlank(longitude) && StringUtils.isNotBlank(latitude)){
            Map<String, Object> params = new HashMap<String, Object>();
            params.put("key", AMapConstant.AMAP_KEY);
            params.put("location", longitude+","+latitude);
            params.put("output", "JSON");
            /*String resultStr = HttpRequest.sendPostForJson("http://restapi.amap.com/v3/geocode/regeo", params);*/
            String resultStr = HttpUtil.https("http://restapi.amap.com/v3/geocode/regeo", params);
            boolean flag = JsonUtils.isJson(resultStr);
            if(flag) {
                JSONObject jsonObject = JSONObject.parseObject(resultStr);
                //1表示true
                if (jsonObject != null && jsonObject.getIntValue("status")==1) {
                    JSONObject object = jsonObject.getJSONObject("regeocode");
                    address = object.getString("formatted_address");
                }
            }
        }
        return address;
    }

    private static void init() {
        System.out.println("高德地图工具类初始化");
        System.out.println("api: {}"+API);
        System.out.println("key: {}"+KEY);
        API = API.replaceAll("<key>", KEY);
    }


}
