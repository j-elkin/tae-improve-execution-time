package co.com.waits.example.tasks;

import co.com.waits.example.interactions.Pause;
import co.com.waits.example.utils.ProcessDates;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.waits.example.userinterfaces.CalendarPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isCurrentlyVisible;

public class SelectDates implements Task {

    private static String FIRST_VISIBLE_MONTH = "2";
    private static String SECOND_VISIBLE_MONTH = "3";

    private String firstDateToSelect;
    private String secondDateToSelect;

    public SelectDates(String fDateToSelect, String sDateToSelect) {
        this.firstDateToSelect = fDateToSelect;
        this.secondDateToSelect = sDateToSelect;
    }

    public static SelectDates inDatePicker (String firstDateToSelect, String secondDateToSelect) {
        return Tasks.instrumented(SelectDates.class, firstDateToSelect, secondDateToSelect);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(MONTH_ONE, isCurrentlyVisible()));
        String firstMonthName = MONTH_ONE.resolveFor(actor).getText().split("\\n")[0];
        String monthYearInCalendarNumberOne = ProcessDates.convertNameMonthYearToDateNumber(firstMonthName);
        int isEqualMonthAndYear = ProcessDates.isEqualMonthAndYear(monthYearInCalendarNumberOne, firstDateToSelect.substring(3));
        while (isEqualMonthAndYear != 0) {
            actor.attemptsTo(Click.on( isEqualMonthAndYear < 0 ? NEXT_MONTH : PREVIOUS_MONTH));
            actor.attemptsTo(Pause.forTime(500));//It's necessary
            firstMonthName = MONTH_ONE.resolveFor(actor).getText().split("\\n")[0];
            monthYearInCalendarNumberOne = ProcessDates.convertNameMonthYearToDateNumber(firstMonthName);
            isEqualMonthAndYear = ProcessDates.isEqualMonthAndYear(monthYearInCalendarNumberOne, firstDateToSelect.substring(3));
        }
        String dayToSelect = firstDateToSelect.split("-")[0];
        dayToSelect = dayToSelect.startsWith("0") ? dayToSelect.replace("0", "") : dayToSelect ;
        actor.attemptsTo(Click.on(DAY_OF_MONTH.of(FIRST_VISIBLE_MONTH, dayToSelect)) );
        actor.attemptsTo(Pause.forTime(500));

        //Selecting the second date
        String secondMonthName = MONTH_TWO.resolveFor(actor).getText().split("\\n")[0];
        String monthYearInCalendarNumberTwo = ProcessDates.convertNameMonthYearToDateNumber(secondMonthName);
        dayToSelect = secondDateToSelect.split("-")[0];
        dayToSelect = dayToSelect.startsWith("0") ? dayToSelect.replace("0", "") : dayToSelect ;

        if(ProcessDates.isEqualMonthAndYear(monthYearInCalendarNumberOne, secondDateToSelect.substring(3)) == 0) {
            actor.attemptsTo(Click.on(DAY_OF_MONTH.of(FIRST_VISIBLE_MONTH, dayToSelect)));
        } else {
            isEqualMonthAndYear = ProcessDates.isEqualMonthAndYear(monthYearInCalendarNumberTwo, secondDateToSelect.substring(3));
            while (isEqualMonthAndYear != 0) {
                actor.attemptsTo(Click.on(isEqualMonthAndYear < 0 ? NEXT_MONTH : PREVIOUS_MONTH));
                actor.attemptsTo(Pause.forTime(500));//It's necessary
                secondMonthName = MONTH_TWO.resolveFor(actor).getText().split("\\n")[0];
                monthYearInCalendarNumberTwo = ProcessDates.convertNameMonthYearToDateNumber(secondMonthName);
                isEqualMonthAndYear = ProcessDates.isEqualMonthAndYear(monthYearInCalendarNumberTwo, secondDateToSelect.substring(3));
            }
            actor.attemptsTo(Click.on(DAY_OF_MONTH.of(SECOND_VISIBLE_MONTH, dayToSelect)));
        }

    }
}
