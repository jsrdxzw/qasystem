package com.laosiji.qasystem.util;


import cn.hutool.http.HttpUtil;
import org.springframework.stereotype.Component;

import java.util.Map;
/**
 * @author huangxingming
 * @date 2021/10/29
 */
@Component
public class HttpUtils {

    public String doPost(String url, Map<String, Object> paramMap){
        String post = HttpUtil.post(url, paramMap);
        return post;
    }

}
