package time;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CurrentDateFactory {

    public static String getCurrentDate() {
        return (new SimpleDateFormat("hh:mm:ss dd.MM.YY")).format(new Date());
    }
    
}
