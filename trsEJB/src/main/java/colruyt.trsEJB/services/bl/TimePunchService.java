package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.entities.Person;
import colruyt.trsEJB.entities.TimePunch;
import colruyt.trsEJB.entities.WorkActivity;
import colruyt.trsEJB.entities.WorkDay;
import colruyt.trsEJB.services.dl.TimePunchDlService;
import colruyt.trsEJB.services.dl.WorkDayDlService;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.ejb.EJB;


public class TimePunchService {

    /* SERVICES */
    
   //Niveau Up
   // private PersonBoConverter personConverter = new PersonBoConverter();

    @EJB
    private TimePunchDlService dlService;
    
    @EJB
    private WorkDayDlService workDl;
    
    
    /* API */

    public void punch(Person person) {
        
        this.addToWorkActivity(new TimePunch(LocalDateTime.now(),person));
        
    }
    
    
    
    private void addToWorkActivity(TimePunch p) {
        
       WorkDay day = this.getWorkingDayFor(p.getPerson());
        //Kijk of de working day al een Project van dit heeft met een lege ending
       WorkActivity wa = day.getDayActivities().stream().filter(x-> x.getProject().equals(p.getProject()) && x.getStop() == null ).collect(Collectors.toList()).get(0);
       if(wa != null){
           wa.setStop(p.getPunch());
           workDl.update(day);
           
       }
       else{
       // Anders gaan we er Eentje aanmaken
       day.getDayActivities().add(new WorkActivity(p.getPunch(),null,p.getProject(),"Comment...;"));
       workDl.update(day);
           
       }
       
       
    }
    
    private WorkDay getWorkingDayFor(Person P){
        
        Optional<WorkDay> day = workDl.getCurrentWorkDayFor(P);
        if(day.isPresent()){
            return day.get();
        }
        else
        {
            // Create WorkDay
            WorkDay work = new WorkDay();
            this.workDl.save(work);
            return work;
            }
           
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
   
    
    
    
    
    
}
