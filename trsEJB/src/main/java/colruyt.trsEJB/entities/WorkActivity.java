package colruyt.trsEJB.entities;


import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
public class WorkActivity {

    private LocalDateTime start;

    private LocalDateTime stop;

    private Project project;

    private String workDescription;

    private Person person;

    /* CONSTRUCTORS */

    public WorkActivity(LocalDateTime start, LocalDateTime stop, Project project, String workDescription) {

       
      

        this.start = start;
        this.stop = stop;
        this.project = project;
        this.workDescription = workDescription;
    }

    public WorkActivity() {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getWorkDescription() {
        return workDescription;
    }

    public void setWorkDescription(String workDescription) {
        this.workDescription = workDescription;
    }

    public Person getPersonBo() {
        return person;
    }

    public void setPersonBo(Person personBo) {
        this.person = personBo;
    }
}
