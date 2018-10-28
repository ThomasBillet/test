package colruyt.trsEJB.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class TimePunch  {

    private LocalDateTime punch;
    
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    private Person person;
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="TPID")
	private String id;

    /* CONSTRUCTORS */

    public TimePunch(LocalDateTime punch, Person person) {

        this.punch = punch;
        this.person = person;
    }
    /* GETTERS & SETTERS */

    public LocalDateTime getPunch() {
        return punch;
    }

    public void setPunch(LocalDateTime punch) {
        this.punch = punch;
    }

   public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
