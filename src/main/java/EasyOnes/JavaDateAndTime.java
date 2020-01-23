package EasyOnes;

import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class JavaDateAndTime {
    public static void main(String[] args) {
        String dayOfWeek = findDay(8, 5, 2015);
        System.out.printf("%S", dayOfWeek);
    }

    static String findDay(int month, int day, int year) {
        Calendar c = Calendar.getInstance();
        c.set(year, month - 1, day);
        return c.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.getDefault());

        /*
        String dateString = month + "/" + day + "/" + year;
        try {
            c.setTime(new SimpleDateFormat("mm/dd/yyyy").parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        String date = month + "/" + day + "/" + year;
        SimpleDateFormat sdf = new SimpleDateFormat("EEEE, mm dd yyyy");
        try {
            c.setTime(sdf.parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return c.;

        String date = month + "/" + day + "/" + year;
        try {
            c.setTime(new SimpleDateFormat("mm/dd/yyyy").parse(date));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return c.getDisplayName(dayOfWeek, Calendar.LONG, Locale.getDefault());

        c.set(year, month, day);
        int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        return String.valueOf(dayOfWeek);
        */
    }
}
