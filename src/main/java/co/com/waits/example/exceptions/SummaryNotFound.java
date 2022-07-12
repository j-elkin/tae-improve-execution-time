package co.com.waits.example.exceptions;

public class SummaryNotFound extends AssertionError {

    public static final String SUMMARY_OF_CHARGES_NOT_FOUND = "Summary of charges not found";

    public SummaryNotFound(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
