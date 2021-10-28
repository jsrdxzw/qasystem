package com.laosiji.qasystem.util;

import cn.hutool.json.JSONUtil;
import com.laosiji.qasystem.domain.ro.PostRo;
import com.laosiji.qasystem.domain.vo.FilterVo;
import com.laosiji.qasystem.domain.vo.GetCategoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangxingming
 * @date 2021/10/29
 */
@Component
public class CommonUtils {

    @Autowired
    private HttpUtils httpUtils;

    /**
     * 基础路径
     */
    private static final String BASE_URL = "http://124.70.184.116:5000/";

    /**
     * 过滤接口
     */
    private static final String FILTER_URL = "qasystem_ai/filter";

    /**
     * 获取标签接口
     */
    private static final String GET_CATEGORY = "qasystem_ai/category";
    /**
     * 其他类型的分类
     */
    private static final String OTHER_CATEGORY = "其他";

    /**
     * 获取过滤后的内容
     *
     * @param content
     * @return
     */
    public String getContentAfterFilter(String content) {
        String result = "";
        String comment = content;
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("content", comment);
        String s = httpUtils.doPost(BASE_URL + FILTER_URL, paramMap);
        if (StringUtils.hasText(s)) {
            FilterVo filterVo = JSONUtil.toBean(s, FilterVo.class);
            result = filterVo.getData();
        }
        return result;
    }

    /**
     * 获取标签
     *
     * @param postRo
     * @return
     */
    public String getCategory(PostRo postRo) {
        String result = "";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("content", postRo.getContent());
        String s = httpUtils.doPost(BASE_URL + GET_CATEGORY, paramMap);
        if (StringUtils.hasText(s)) {
            GetCategoryVo getCategoryVo = JSONUtil.toBean(s, GetCategoryVo.class);
            if (getCategoryVo != null && getCategoryVo.getData() != null) {
                result = getCategoryVo.getData().getCategory();
            }
        }
        if (!StringUtils.hasText(result)) {
            result = OTHER_CATEGORY;
        }
        return result;
    }
}
