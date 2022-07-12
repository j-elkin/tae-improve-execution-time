package co.com.waits.example.exceptions;

public class LoaderStillPresent extends AssertionError {

    public LoaderStillPresent(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
