package com.example.aidemo.util;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

/**
 * @author: 孔金涛
 * @Date: 2024年02月19日 15:41
 */
public class SampleNlp {

    public static void main(String[] args) {
        //设置APPID/AK/SK
        String APP_ID = "**";
        String API_KEY = "**";
        String SECRET_KEY = "**";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        String text = "百度是一家只能高科技公司";
        JSONObject res = client.ecnet(text, null);
        System.out.println(res.toString(2));
    }
}
