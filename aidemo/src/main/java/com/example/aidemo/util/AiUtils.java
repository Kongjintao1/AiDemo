package com.example.aidemo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author: 孔金涛
 * @Date: 2024年02月19日 15:45
 */
public class AiUtils {
    public static String word(MultipartFile file) throws IOException {
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
        //String path = "C:\\Users\\Administrator\\Desktop\\微信图片_20230609211049.jpg";
        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray jsonArray = res.getJSONArray("words_result");
        StringBuffer sb = new StringBuffer();
        for (int i = 0;i<jsonArray.length();i++){
            sb.append(jsonArray.getJSONObject(i).getString("words"))
                    .append("\n");
        }
        return sb.toString();
    }

    public static String img(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "52135508";
        String API_KEY = "qYox4xpSjREPCqh71LOa7Fcj";
        String SECRET_KEY = "zxxBog6uoX3HLXozN6wGdk9ssdT7az5f";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
        //String path = "C:\\Users\\Administrator\\Desktop\\1.jpeg";
        JSONObject res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        JSONObject result = res.getJSONArray("result").getJSONObject(0);
        String s = "这张图" + result.getDouble("score")*100 + "%的可能是" + result.getString("root") + "-" +result.getString("keyword");
        return s;
    }

    public static String nlp(String text){
        //设置APPID/AK/SK
        String APP_ID = "52136421";
        String API_KEY = "cWO4puv3ObSkwv1Gd2j8dGLw";
        String SECRET_KEY = "e4sHG6ySuZhKlNhVsMr7UKU0ZWG7wGR9";
        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);
        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        // 调用接口
//        String text = "百度是一家只能高科技公司";
        JSONObject res = client.ecnet(text, null);
        String res1 = res.getJSONObject("item").getString("correct_query");
        return res1;
    }

    public static void main(String[] args) {
        String text = "百度是一家只能高科技公司";
        System.out.println(nlp(text));
    }
}
