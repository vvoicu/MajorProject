package bmo5.bmo5tests.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class DateUtils {

    
    public static String GetUTCdatetimeAsString()
    {
        final SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");
        date.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime = date.format(new Date());

        return utcTime;
    }
}
