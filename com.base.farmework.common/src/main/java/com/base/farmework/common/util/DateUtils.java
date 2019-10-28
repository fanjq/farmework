package com.base.farmework.common.util;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author     ：fjq
 * @date       ：Created in ${DATE} ${TIME}
 * @description：${description}
 * @modified By：
 * @version:     $version$
 */
public class DateUtils {

    private static final SimpleDateFormat DATE_FORMAT_YYYYMMDD =  new SimpleDateFormat("yyyy-MM-dd");

    public static String getYearDate(Date date){
        if(ObjectUtils.isEmpty(date)){
            return "";
        }
        return DATE_FORMAT_YYYYMMDD.format(date);
    }

    public static String getNowYearDate(){
        return getYearDate(new Date());
    }

}
