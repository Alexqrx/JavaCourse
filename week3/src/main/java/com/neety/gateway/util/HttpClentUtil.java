package com.neety.gateway.util;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.ProtocolException;
import org.apache.hc.core5.http.io.entity.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

public class HttpClentUtil {
    public static void main(String[] args) {

        // 创建HttpClient
        CloseableHttpClient httpClient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
        //创建HttpGet
        HttpGet httpGet = new HttpGet("http://127.0.0.1:8888/");
        System.out.println("请求地址:"+httpGet.getUri());
        //执行get请求
        response = httpClient.execute(httpGet);
        //获取响应实体
        HttpEntity entity = response.getEntity();
        //打印响应状态
        if(entity!=null){
            System.out.println("报文长度："+entity.getContentLength());
            System.out.println("响应报文："+EntityUtils.toString(entity));
            System.out.println("相应报文头："+response.getHeader("respose-header"));
        }
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } finally{
            try {
                response.close();
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
