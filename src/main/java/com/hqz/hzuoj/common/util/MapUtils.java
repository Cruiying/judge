package com.hqz.hzuoj.common.util;

import java.util.HashMap;

/**
 * MapUtils
 *
 * @author Cruiying
 * @date 2020/6/23 19:38
 * @email 2322144259@qq.com
 * @description Map工具类
 */
public class MapUtils extends HashMap<String,Object> {

    @Override
    public MapUtils put(String key, Object value) {
        super.put(key,value);
        return this;
    }
}
