package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;

public interface AccountancyFacade {

    void getBillableHoursFor(PersonBo person);

    void getBillableHoursFor(ProjectBo project);

}
