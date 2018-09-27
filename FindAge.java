import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Asus on 21 Sep 2018.
 *
 * Problem: User inputs date in MM/dd/yyyy format. Print age in years, month(s), day(s) old.
 * If user inputs date greater than the current date, return 0 for all.
 */
public class FindAge {

    public static void main(String[] args) {

        String inputString = "";

        try {

            System.out.print("Enter birthday in MM/dd/yyyy: ");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            inputString = reader.readLine();

            Date currentDate = removeTime(new Date());
            Date inputDate = convertToDate(inputString);

            if(currentDate.compareTo(inputDate) <= 0) {
                System.out.println("Age is 0");
            } else {
                Calendar age = getDifference(new Date(), inputDate);
                System.out.print("Age is " + age.get(Calendar.YEAR) + " years, " + age.get(Calendar.MONTH) + " month(s), "
                        + age.get(Calendar.DAY_OF_MONTH) + ", days old.");
            }
        } catch (Exception e) {
            System.out.println("Input is invalid: " + inputString);
            e.printStackTrace();
        }

    }

    public static Date removeTime(Date date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        return sdf.parse(sdf.format(date));
    }

    public static Date convertToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdf.parse(dateStr);
        return date;
    }

    public static Calendar getDifference(Date date1, Date date2) {
        long date1Ms = date1.getTime();
        long date2Ms = date2.getTime();

        long timeDifference = date1Ms - date2Ms;
        Date diffDate = new Date(timeDifference);

        Calendar c = Calendar.getInstance();
        c.setTime(diffDate);
        c.add(Calendar.YEAR, -1970);

        return c;
    }
}
