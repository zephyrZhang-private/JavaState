package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static Date toDate(String time,String patten){
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        try {
           Date date = sdf.parse(time);
            return date;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static String toString(Date time,String patten){
        SimpleDateFormat sdf = new SimpleDateFormat(patten);
        return sdf.format(time);
    }
}

