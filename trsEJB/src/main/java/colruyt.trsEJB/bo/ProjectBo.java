package colruyt.trsEJB.bo;

public class ProjectBo extends BaseBo {

    private String name;

    /* CONSTRUCTORS */

    public ProjectBo(String name) {
        LOGGER.traceEntry(
                "ProjectBo was created: {}", name
        );
        this.setName(name);
    }

    /* GETTERS & SETTERS */

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
