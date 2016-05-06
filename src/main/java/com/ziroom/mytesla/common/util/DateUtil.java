package com.ziroom.mytesla.common.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author liumy  .
 * @time 2016/5/6　11:56
 * @email　 liumy46@ziroom.com
 */
public class DateUtil {

    private final static transient Log logger = LogFactory.getLog(DateUtil.class);

    public static final String DATE_FORMAT_STR = "yyMMdd";


    /**
     * 格式化日期
     * @param format
     * @return
     */
    public static String sysDateToStr(String format) {
        return dateToStr(getCurrSysDate(), format);
    }

    public static String dateToStr(Date date, String format) {
        String dateStr = null;
        if (date != null) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
            dateStr = simpleDateFormat.format(date);
        }
        return dateStr;
    }

    /**
     * 获取当前时间戳
     * @return
     */
    private static Timestamp getCurrSysDate() {
        Timestamp currTime = new Timestamp(System.currentTimeMillis());
        return currTime;
    }

}
