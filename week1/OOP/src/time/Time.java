package time;

public class Time {

    private final int[] dateTime = new int[6];

    public Time(int hh, int mm, int ss, int DD, int MM, int YY) {
        this.dateTime[0] = hh;
        this.dateTime[1] = mm;
        this.dateTime[2] = ss;
        this.dateTime[3] = DD;
        this.dateTime[4] = MM;
        this.dateTime[5] = YY;
    }

    public String now() {
        return CurrentDateFactory.getCurrentDate();
    }

    @Override
    public String toString() {
        String[] pieces = new String[6];
        
        for (int i = 0; i < dateTime.length; i++) {
            pieces[i] = toTwoDigits(dateTime[i]);
        }
        
        return String.format("%s:%s:%s %s.%s.%s", (Object[]) pieces);
    }
    
    private static String toTwoDigits(int number) {
        String result = String.valueOf(number);
        
        if (result.length() == 2) {
            return result;
        } else if (result.length() < 2) {
            return "0" + result;
        }
        return result.substring(result.length() - 2, result.length());
    }

    public static void main(String[] args) {
        Time time = new Time(23, 21, 38, 16, 12, 1878);
        System.out.println(time.now());
        System.out.println(time.toString());
    }

}
