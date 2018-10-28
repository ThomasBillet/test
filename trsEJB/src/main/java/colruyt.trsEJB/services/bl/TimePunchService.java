package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.services.dl.TimePunchDlService;



public class TimePunchService {

    /* SERVICES */

    private TimePunchService service;

    private TimePunchDlService dlService;

    /* API */

    public static TimePunchService getService() {

        if (service == null) {
            service = new TimePunchService();
        }

        return service;
    }

    public void punch(PersonBo person) {
        // TODO: 2implement => write 2 data layer
    }
}
