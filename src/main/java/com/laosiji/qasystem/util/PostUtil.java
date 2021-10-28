package com.laosiji.qasystem.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author zhangyixiao
 * @date 2021/10/28
 */
public class PostUtil {
    /**
     * 生成编号
     *
     * @return 编号
     */
    public static String generateZhContractNo() {
        // 14位时间
        String timeString = convertDateTimeToString(LocalDateTime.now(), "yyyyMMddHHmmss");
        // 5位随机数
        int randomNum = ThreadLocalRandom.current().nextInt(1, 99999);
        // 不足5位向上补0
        return String.format("%s%05d", timeString, randomNum);
    }


    /**
     * LocalDateTime to String 默认："yyyy-MM-dd HH:mm:ss"
     *
     * @param dateTime 时间
     * @param pattern  格式
     * @return
     */
    public static String convertDateTimeToString(LocalDateTime dateTime, String pattern) {
        if (pattern == null) {
            pattern = "yyyy-MM-dd HH:mm:ss";
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(pattern);
        return dateTime.format(dateTimeFormatter);
    }

    public static boolean dateInDateInterval(LocalDate date, LocalDate startDate, LocalDate endDate) {
        return (date.isAfter(startDate) || date.isEqual(startDate))
                && (date.isBefore(endDate) || date.isEqual(endDate));
    }
}
