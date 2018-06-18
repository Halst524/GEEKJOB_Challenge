package timestamp;

import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;

public class TimeStamp2 {
    public static void main(String[] arcs){
        Calendar now = Calendar.getInstance();
        Date kyou = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒");
        String today = sdf.format(kyou);
        System.out.println(today);
    }
}
