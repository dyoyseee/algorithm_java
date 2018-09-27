import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Asus on 21 Sep 2018.
 */
public class FindAge {

    public static void main(String[] args) {

        String inputString = "";

        try {

            System.out.print("Enter birthday in MM/dd/yyyy: ");
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(System.in));
            inputString = reader.readLine();

            Date inputDate = convertToDate(inputString);
            Calendar age = getAge(inputDate);

            System.out.print("Age is " + age.get(Calendar.YEAR) + " years, " + age.get(Calendar.MONTH) + " month(s), "
                + age.get(Calendar.DAY_OF_MONTH) + ", days old.");
        } catch (Exception e) {
            System.out.println("Input is invalid: " + inputString);
            e.printStackTrace();
        }

    }

    public static Date convertToDate(String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date date = sdf.parse(dateStr);
        return date;
    }

    public static Calendar getAge(Date birthday) {
        long currentDate = Calendar.getInstance().getTimeInMillis();
        long birthdayDate = birthday.getTime();

        long timeDifference = currentDate - birthdayDate;
        Date diffDate = new Date(timeDifference);

        Calendar c = Calendar.getInstance();
        c.setTime(diffDate);
        c.add(Calendar.YEAR, -1970);

        return c;
    }
}
