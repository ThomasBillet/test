package colruyt.trsEJB;

import colruyt.trsEJB.facades.ProjectsFacade;
import colruyt.trsEJB.facades.ProjectsFacadeImpl;
import colruyt.trsEJB.facades.PunchClockFacade;
import colruyt.trsEJB.facades.PunchClockFacadeImpl;
import colruyt.trsEJB.util.exceptions.CredentialNotFoundException;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;


public class App {

    // Logger => debugger
    private static final Logger LOGGER = LogManager.getLogger( App.class.getName() );

    private static final PunchClockFacade punchClock = new PunchClockFacadeImpl();
    private static final ProjectsFacade projectsFacade = new ProjectsFacadeImpl();

    private static String persID = "user";
    private static String password = "pass";

    public static void main(String[] args) {

        // say hi!
        LOGGER.trace("Entering application.");

        // punchTest();

        addActivity();

    }

    private static void addActivity() {

        // authenticate
        try { punchClock.authenticate(persID, password); }
        catch (CredentialNotFoundException e) {
            LOGGER.fatal("CredentialNotFoundException");
            LOGGER.catching(e);
            //TODO: => exception handling??
        }

        // addActivity
        try {
            punchClock.registerActivity(
                    LocalDateTime.now().minusHours(2),
                    LocalDateTime.now().minusMinutes(30),
                    "Did Some Work",
                    projectsFacade.getByName("yello")
            );
        } catch (OutsideWorkdayTimeBoundariesException e) {
            LOGGER.fatal("CredentialNotFoundException");
            LOGGER.catching(e);
            //TODO: => exception handling??
        }
    }

    private static void punchTest() {

        try { punchClock.punch(persID, password); }
        catch (CredentialNotFoundException e) {
            LOGGER.fatal("CredentialNotFoundException");
            LOGGER.catching(e);
            //TODO: => exception handling??
        }
    }

}
