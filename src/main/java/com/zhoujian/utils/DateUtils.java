package com.zhoujian.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    //日期转换成字符串
    public static String date2String(Date date,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        String format = simpleDateFormat.format(date);
        return format;
    }
    //字符串转换为日期
    public Date string2Date(String str,String patt){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  parse;
    }
}
