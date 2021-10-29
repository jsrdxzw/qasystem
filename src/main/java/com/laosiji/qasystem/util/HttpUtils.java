package com.laosiji.qasystem.util;


import cn.hutool.core.lang.hash.Hash;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
/**
 * @author huangxingming
 * @date 2021/10/29
 */
@Component
public class HttpUtils {

    public String doPost(String url, String param){
        String result = HttpRequest.post(url)
                .body(param)
                .execute().body();
        return result;
    }



}
