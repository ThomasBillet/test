package colruyt.trsEJB.bo;


import java.time.LocalDateTime;

public class WorkActivityBo extends BaseBo {

    private LocalDateTime start;

    private LocalDateTime stop;

    private ProjectBo project;

    private String workDescription;

    private PersonBo personBo;

    /* CONSTRUCTORS */

    public WorkActivityBo(LocalDateTime start, LocalDateTime stop, ProjectBo project, String workDescription) {

        LOGGER.traceEntry(
                "| start: {} => stop: {} | project: {} | work done: {} |",
                start, stop, project.getName(), workDescription
        );

        this.start = start;
        this.stop = stop;
        this.project = project;
        this.workDescription = workDescription;
    }

    /* GETTERS & SETTERS */

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getStop() {
        return stop;
    }

    public void setStop(LocalDateTime stop) {
        this.stop = stop;
    }

    public ProjectBo getProject() {
        return project;
    }

    public void setProject(ProjectBo project) {
        this.project = project;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public PersonBo getPersonBo() {
        return personBo;
    }

    public void setPersonBo(PersonBo personBo) {
        this.personBo = personBo;
    }
}
