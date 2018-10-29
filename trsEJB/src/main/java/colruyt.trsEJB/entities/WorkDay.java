package colruyt.trsEJB.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class WorkDay{
    
   
    private LocalDate date;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WDID")
	private String id;
    
    
    private List<WorkActivity> dayActivities;

    /* CONSTRUCTORS */

    public WorkDay(List <WorkActivity> dayActivities) {
      
    
        this.dayActivities = dayActivities;
    }
    
     public WorkDay() {
      
    
        this.dayActivities = new ArrayList<WorkActivity>();
    }

    /* GETTERS & SETTERS */

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
     

    public List<WorkActivity> getDayActivities() {
        return dayActivities;
    }

    public void setDayActivities( List<WorkActivity> dayActivities ) {
        this.dayActivities = dayActivities;
    }
}
