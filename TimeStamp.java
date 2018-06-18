package timestamp;

import java.util.Date;

public class TimeStamp {

    public static void main(String[] args) {
        Date dat = new Date((long)46*365*24*60*60*1000 + 11*24*60*60*1000 - 9*60*60*1000);
        System.out.println(dat);
    }

}