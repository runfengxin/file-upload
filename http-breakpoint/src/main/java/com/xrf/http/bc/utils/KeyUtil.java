package com.xrf.http.bc.utils;

import java.util.Random;

public class KeyUtil {

    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer num = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(num);
    }
}
