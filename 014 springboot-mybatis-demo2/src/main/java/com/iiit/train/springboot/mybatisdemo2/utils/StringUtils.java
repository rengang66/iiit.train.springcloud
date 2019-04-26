package com.iiit.train.springboot.mybatisdemo2.utils;

import java.util.UUID;

/**
 * Created By Donghua.Chen on  2018/1/9
 */
public class StringUtils {

    public static String UUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
