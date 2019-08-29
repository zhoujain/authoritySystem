package com.zhoujian.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder cryptPasswordEncoder = new BCryptPasswordEncoder();
    //加密
    public static String encodePassword(String password){
        return cryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        //$2a$10$z44OjFL4ao3qBTFUQHTUEeV03a5hzegp/9/9Zkf91fhRCtaP0ix7a
        System.out.println(encodePassword("123"));
    }
}
