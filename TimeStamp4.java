package timestamp;

import java.util.Date;

public class TimeStamp4 {
    public static void main(String[] arcs){
        long time1 = (long)45*365*24*60*60*1000 + 11*24*60*60*1000 - 9*60*60*1000;
        long time2 = (long)46*365*24*60*60*1000 + 11*24*60*60*1000 - 9*60*60*1000 - 1000;
        Date dat =  new Date(time1);
        Date dat2 =  new Date(time2);
        System.out.println(dat);
        System.out.println(dat2);
        System.out.println("その差\t" + (time2 - time1) + "ミリ秒");
    }
}
