package com.api.listProf.util;

import com.fasterxml.jackson.databind.util.Converter;
import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.convert.Jsr310Converters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static java.time.OffsetTime.ofInstant;

@Component
public class Conversores  {

}

/*
    public static long formataStringToLong(String data) {



        DateTimeFormatter dateTimeFormat =  new DateTimeFormatter(DateTimeFormatter.BASIC_ISO_DATE);

        LocalDateTime date = dateTimeFormat.parse(a, LocalDateTime::from);

        if (data == null || data.equals("")) {
            return new Long(0);
        }
        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");

        try {
            calendar.setTime(sd.parse(data));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return calendar.getTimeInMillis();
    }


}
*/