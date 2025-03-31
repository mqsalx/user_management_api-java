package com.usermanagement.services.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ServiceUtils {

  public static String generateUniqueId() {

    LocalDateTime now = LocalDateTime.now();
    String dateTimeNow = now.format(DateTimeFormatter.ofPattern("yyMMddHHmmss"));

    Random random = new Random();
    int sortedValue = random.nextInt(0x10000);
    String hexValue = String.format("%04X", sortedValue);

    return dateTimeNow + hexValue;
  }
}
