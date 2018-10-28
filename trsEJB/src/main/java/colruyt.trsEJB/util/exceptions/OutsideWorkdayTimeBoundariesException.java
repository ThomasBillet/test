package colruyt.trsEJB.util.exceptions;

public class OutsideWorkdayTimeBoundariesException extends Throwable {
    public OutsideWorkdayTimeBoundariesException() {
        super();
    }

    public OutsideWorkdayTimeBoundariesException(String message) {
        super(message);
    }
}
