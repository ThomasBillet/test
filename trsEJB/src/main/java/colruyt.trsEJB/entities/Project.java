package colruyt.trsEJB.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Project {

    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="PID")
	private String id;
    

    /* CONSTRUCTORS */

    public Project(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    

    public Project(String name) {
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
