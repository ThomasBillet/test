package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.services.dl.TimePunchDlService;

import javax.ejb.EJB;


public class TimePunchService {

    /* SERVICES */

    @EJB
    private TimePunchService service;

    @EJB
    private TimePunchDlService dlService;

    /* API */

    public void punch(PersonBo person) {
        dlService.punch(person);
    }
}
