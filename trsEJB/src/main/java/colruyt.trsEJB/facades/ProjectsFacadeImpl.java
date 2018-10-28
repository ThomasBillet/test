package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.ProjectBo;



public class ProjectsFacadeImpl implements ProjectsFacade {

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
