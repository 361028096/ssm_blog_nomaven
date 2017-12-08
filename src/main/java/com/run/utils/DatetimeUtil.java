package com.run.utils;

import java.text.ParseException;
import java.util.Date;

/**
 * @author : hewei
 * @date : 2017/11/20 16:45
 */
public class DatetimeUtil {
    static public long getDistinceDay(Date beforedate, Date afterdate)
            throws ParseException {
        long dayCount = 0;
        try {
            Date d1 = beforedate;
            Date d2 = afterdate;

            dayCount = (d2.getTime() - d1.getTime()) / (24 * 60 * 60 * 1000);

        } catch (Exception e) {
            System.out.println("Date parse error!");
            // throw e;
        }
        return dayCount;
    }
}
