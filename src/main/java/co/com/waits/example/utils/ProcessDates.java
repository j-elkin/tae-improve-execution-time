package co.com.waits.example.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.MonthDay;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ProcessDates {


    public static  boolean dateOneBeforeThanDateTwo (String date1, String date2) {
        try {
            SimpleDateFormat sdformat = new SimpleDateFormat("dd-MM-yyyy");
            Date dateOne = sdformat.parse(date1);
            Date dateTwo = sdformat.parse(date2);
            System.out.println("Date-1: " + sdformat.format(dateOne) + " | Date-2: "+ sdformat.format(dateTwo));

            return dateOne.before(dateTwo);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     *
     * @param monthYear1
     * @param monthYear2
     * @return:
     * the value 0 if the argument Date is equal to this Date;
     * a value less than 0 if this Date is before the Date argument;
     * and a value greater than 0 if this Date is after the Date argument.
     */
    public static int isEqualMonthAndYear (String monthYear1, String monthYear2) {
        int isEqual = 0;
        try {
            SimpleDateFormat sdformat = new SimpleDateFormat("MM-yyyy");
            Date dateOne = sdformat.parse(monthYear1);
            Date dateTwo = sdformat.parse(monthYear2);
            System.out.println("Date-1: " + sdformat.format(dateOne) + " | Date-2: "+ sdformat.format(dateTwo));

            return dateOne.compareTo(dateTwo);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return isEqual;
    }

    public static int monthNameToNumber (String monthName) {
        return Month.valueOf(monthName.toUpperCase()).getValue();
    }

    public static String convertNameMonthYearToDateNumber (String nameDate) {
        String [] separatedDate = nameDate.split(" ");
        int monthNumber = monthNameToNumber(separatedDate[0]);
        return monthNumber+"-"+separatedDate[1];
    }


    public static void main (String [] args) {
        System.out.println("Starting...");
        //System.out.println("date before: "+ processDates.dateOneBeforeThanDateTwo("2022-08-12", "2022-08-23"));
        //System.out.println("date before: "+ ProcessDates.dateOneBeforeThanDateTwo("12-8-2022", "24-08-2022"));

        //System.out.println("es menor: "+ProcessDates.isEqualMonthAndYear("June-2022", "09-2022"));
        System.out.println("Substring: "+ "15-08-2022".substring(3));
        System.out.println( ProcessDates.convertNameMonthYearToDateNumber("July 2022") );
    }
}
