package co.com.waits.example.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

public class CalendarPage {

    public static final Target PREVIOUS_MONTH = Target.the("Go to the previous month")
            .locatedBy("//div[@aria-label='Move backward to switch to the previous month.']");

    public static final Target NEXT_MONTH = Target.the("Go to next month")
            .locatedBy("//div[@aria-label='Move forward to switch to the next month.']");

    public static final Target DATEPICKER = Target.the("Full calendar with two months")
            .locatedBy("//div[@class='DayPicker_focusRegion DayPicker_focusRegion_1']");

    public static final Target MONTH_ONE = Target.the("The first visible month")
            .locatedBy("(//div[@class='CalendarMonth CalendarMonth_1'])[2]");

    public static final Target DAY_OF_MONTH = Target.the("Day of the first visible month")
            .locatedBy("(//div[@class='CalendarMonth CalendarMonth_1'])[{0}]//td[starts-with(@class,'CalendarDay') and text()='{1}']");

    public static final Target MONTH_TWO = Target.the("The second visible month")
            .locatedBy("(//div[@class='CalendarMonth CalendarMonth_1'])[3]");

    public static final Target DAY_OF_MONTH_TWO = Target.the("Day of the first visible month")
            .locatedBy("(//div[@class='CalendarMonth CalendarMonth_1'])[3]//td[starts-with(@class,'CalendarDay') and text()='{0}']");

    public static final Target CLOSE_CALENDAR = Target.the("Close the calendar")
            .locatedBy("//div[@class='text-center margin-b10 text-light-gray ']");
}
