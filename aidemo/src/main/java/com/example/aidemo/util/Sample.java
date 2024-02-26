package com.example.aidemo.util;

import com.baidu.aip.ocr.AipOcr;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * @author: 孔金涛
 * @Date: 2024年02月19日 15:26
 */
public class Sample {



    public static void main(String[] args) {
        //设置APPID/AK/SK
        String APP_ID = "52128584";
        String API_KEY = "nGGNYBQjypU4sfCAc4ITHirS";
        String SECRET_KEY = "Ad4rX3k4TsLsDfEvwDCkwTsDHBiqsFFt";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        String path = "C:\\Users\\Administrator\\Desktop\\微信图片_20230609211049.jpg";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));
    }
}