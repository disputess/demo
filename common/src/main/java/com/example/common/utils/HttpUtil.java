package com.example.common.utils;


import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.KeyStore;
import java.util.Map;
import java.util.Map.Entry;

public class HttpUtil {
    
    public static String https(String url, Map<String, Object> params) {
        
        URL u = null;
        HttpURLConnection con = null;
        
        // 构建请求参数
        StringBuffer sb = new StringBuffer();
        if (params != null) {
            for (Entry<String, Object> e : params.entrySet()) {
                sb.append(e.getKey());
                sb.append("=");
                sb.append(e.getValue());
                sb.append("&");
            }
            
            sb.substring(0, sb.length() - 1);
        }
        
        //System.out.println("send_url:" + url);
        //System.out.println("send_data:" + sb.toString());
        // 尝试发送请求
        try {
            u = new URL(url);
            con = (HttpURLConnection)u.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            con.setDoInput(true);
            con.setUseCaches(false);
            con.setConnectTimeout(20 * 1000);
            con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            OutputStreamWriter osw = new OutputStreamWriter(con.getOutputStream(), "UTF-8");
            osw.write(sb.toString());
            osw.flush();
            osw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            
            if (con != null) {
                con.disconnect();
            }
        }
        
        // 读取返回内容
        StringBuffer buffer = new StringBuffer();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
            String temp;
            while ((temp = br.readLine()) != null) {
                buffer.append(temp);
                buffer.append("\n");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
        
    }

    
    
}
