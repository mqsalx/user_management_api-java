// /src/main/java/com/usermanagement/utils/LoggerUtil.java

package com.usermanagement.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerUtil {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private LoggerUtil() {
        // Private constructor to prevent instantiation
    }

    public static void info(String message) {
        String timestamp = LocalDateTime.now().format(FORMATTER);
        System.out.println("[" + timestamp + "] - " + message);
    }
}
