package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.services.dl.PersonDlService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class ProjectService {

    @EJB
    PersonDlService personDlService;

    public ProjectBo getById() {

        // TODO: 2implement
        return null;
    }

    public ProjectBo getByName() {

        // TODO: 2implement
        return null;
    }


}
