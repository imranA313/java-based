package Webzent.student_management_service.util;

import Webzent.student_management_service.error.exception.InvalidDateFormatException;
import lombok.extern.slf4j.Slf4j;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.apache.commons.lang3.StringUtils;

@Slf4j
public class DateUtil {

    public static Date convertStringToSqlDate(String date){
        try {
            if(StringUtils.isEmpty(date)){
                return null;
            }
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date jdate = sdf.parse(date);
            return new Date(jdate.getTime());
        }catch (ParseException ex){
            log.error("Invalid Date String: " + date, ex);
            throw new InvalidDateFormatException("request.invalid.date");
        }
    }
}
