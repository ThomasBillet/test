package colruyt.trsEJB.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity

public class WorkDay{
    
    private TimePunch startPunch;

    private TimePunch endPunch;
    
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="WDID")
	private String id;
    
    
    private List<WorkActivity> dayActivities;

    /* CONSTRUCTORS */

    public WorkDay(TimePunch startPunch, TimePunch endPunch, List <WorkActivity> dayActivities) {
      
        this.startPunch = startPunch;
        this.endPunch = endPunch;
        this.dayActivities = dayActivities;
    }

    /* GETTERS & SETTERS */

    public TimePunch getStartPunch() {
        return startPunch;
    }

    public void setStartPunch(TimePunch startPunch) {
        this.startPunch = startPunch;
    }

    public TimePunch getEndPunch() {
        return endPunch;
    }

    public void setEndPunch(TimePunch endPunch) {
        this.endPunch = endPunch;
    }

    public List<WorkActivity> getDayActivities() {
        return dayActivities;
    }

    public void setDayActivities( List<WorkActivity> dayActivities ) {
        this.dayActivities = dayActivities;
    }
}
