package time.fool.proof;

import time.fool.proof.CurrentDateFactory;

public class Time {

    private final int[] dateTime = new int[6];

    public Time(int hh, int mm, int ss, int DD, int MM, int YY) {
        if (hh < 0 || hh > 24) {
            throw new IllegalTimeFormatException("hh (hours) must be in the range [0, 24]");
        }
        if (mm < 0 || mm > 60) {
            throw new IllegalTimeFormatException("mm (minutes) must be in the range [0, 60]");
        }
        if (ss < 0 || ss > 60) {
            throw new IllegalTimeFormatException("ss (seconds) must be in the range [0, 60]");
        }
        if (DD < 1 || DD > 31) {
            throw new IllegalTimeFormatException("DD (days) must be in the range [1, 31]");
        }
        if (MM < 1 || MM > 12) {
            throw new IllegalTimeFormatException("MM (months) must be in the range [1, 12]");
        }
        if (YY < 1) {
            throw new IllegalTimeFormatException("YY (year) must be a positive integer");
        }
        if ((DD == 29 && MM == 2) && (YY % 100 == 0 || YY % 4 != 0)) {
            throw new IllegalTimeFormatException(YY + " is not a leap year and day: " + DD
                    + ",month: " + MM + " are not possible");
        }
        // all kinds of special cases... and so on...
        
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
