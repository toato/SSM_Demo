package com.toato.ssm.utls;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Toato E-mail:1135684438@qq.com
 * @create 2019/8/18 10:58
 */
public class DateUtils {



    /**
     * 日期转换为字符串
     * @param date          待转换的日期
     * @param formatStr     日期格式
     * @return              转换完成的字符串形式的日期
     */
    public static String date2String(Date date, String formatStr) {

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        String format = sdf.format(date);
        return format;

    }


    /**
     * 字符串转日期
     * @param dateStr
     * @param formatStr
     * @return
     */
    public static Date string2Date(String dateStr, String formatStr) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(formatStr);
        Date date = sdf.parse(dateStr);
        return date;

    }

}
