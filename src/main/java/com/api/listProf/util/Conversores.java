package com.api.listProf.util;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class Conversores {

    String pattern = "MMM dd, yyyy HH:mm:ss.SSSSSSSS";
    String timestampAsString = "Nov 12, 2018 13:02:56.12345678";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
    LocalDateTime localDateTime = LocalDateTime.from(formatter.parse(timestampAsString));
    Timestamp timestamp = Timestamp.valueOf(localDateTime);
}