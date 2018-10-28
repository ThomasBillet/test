package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.WorkActivityBo;
import colruyt.trsEJB.services.bl.WorkActivityService;

import javax.ejb.EJB;

public class WorkActivityFacadeImpl implements ActivityFacade {

    @EJB
    WorkActivityService workActivityService;

    @Override
    public void register(WorkActivityBo activity) {

    }
}
