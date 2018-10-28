package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.services.bl.ProjectService;

import javax.ejb.EJB;

public class ProjectsFacadeImpl implements ProjectsFacade {

    @EJB
    ProjectService projectService;

    @Override
    public ProjectBo getById(int id) {
        // TODO: 2implement
        return new ProjectBo("yello");
    }


    @Override
    public ProjectBo getByName(String name) {
        // TODO: 2implement
        return new ProjectBo("yello");
    }
}
