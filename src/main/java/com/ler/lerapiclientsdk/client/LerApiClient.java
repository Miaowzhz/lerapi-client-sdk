package com.ler.lerapiclientsdk.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.ler.lerapiclientsdk.model.User;
import java.util.HashMap;
import java.util.Map;

import static com.ler.lerapiclientsdk.utils.SignUtils.genSign;

/**
 * 调用第三方API接口的客户端
 *
 * @author ler
 */
public class LerApiClient {
    private String accessKey;
    private String secretKey;

    public LerApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getNameByGet(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.get("http://localhost:9999/api/name/", paramMap);
        // System.out.println(result);
        return result;
    }
    public String getNameByPost(String name) {
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        String result = HttpUtil.post("http://localhost:9999/api/name/", paramMap);
        // System.out.println(result);
        return result;
    }

    private Map<String,String> getHeaderMap(String body){
        Map<String,String> hashMap = new HashMap<>();
        hashMap.put("accessKey",accessKey);
        // hashMap.put("secretKey",secretKey);
        hashMap.put("body",body);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", genSign(body, secretKey));
        return hashMap;
    }

    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post("http://localhost:9999/api/name/user")
                .addHeaders(getHeaderMap(json))
                .body(json)
                .execute();
        System.out.println(httpResponse.getStatus());
        String result = httpResponse.body();
        System.out.println(result);
        return result;
    }
}
