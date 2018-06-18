package timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp3 {
    public static void main(String[] arcs){
        Date dat = new Date((long)47*365*24*60*60*1000 - (long)46*24*60*60*1000 + 1*60*60*1000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String day3 = sdf.format(dat);
        System.out.println(dat);
        System.out.println(day3);
    }
    
}
