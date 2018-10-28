package colruyt.trsEJB.services.dl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import colruyt.trsEJB.services.bl.ActivityService;

public class TimePunchDlService {

    protected static final Logger LOGGER = LogManager.getLogger( ActivityService.class.getName() );

    private static TimePunchDlService service;

    public static TimePunchDlService getService() {

        if (service == null) {
            service = new TimePunchDlService();
        }

        return service;
    }

}
