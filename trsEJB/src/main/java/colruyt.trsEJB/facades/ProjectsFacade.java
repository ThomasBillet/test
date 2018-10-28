package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.ProjectBo;

public interface ProjectsFacade {

    ProjectBo getById(int id);

    ProjectBo getByName(String name);
}
