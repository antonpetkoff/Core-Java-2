package time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

    private int hh, mm, ss;
    private int DD, MM, YY;
    
    public Time(int hh, int mm, int ss, int DD, int MM, int YY) {
        this.hh = hh;
        this.mm = mm;
        this.ss = ss;
        this.DD = DD;
        this.MM = MM;
        this.YY = YY;
    }
    
    public String now() {
        return getCurrentDateAndTime();
    }
    
    private String getCurrentDateAndTime() {
        return (new SimpleDateFormat("hh:mm:ss dd.MM.YY")).format(new Date());
    }
    
    @Override
    public String toString() {
        return String.format("%d:%d:%d %d.%d.%d", hh, mm, ss, DD, MM, YY);
    }
    
    
    public static void main(String[] args) {
        Time time = new Time(11, 21, 38, 27, 3, 2015);
        System.out.println(time.now());
        System.out.println(time.toString());
    }
    
}
