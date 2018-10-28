package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.converters.PersonBoConverter;
import colruyt.trsEJB.entities.Person;
import colruyt.trsEJB.entities.TimePunch;
import colruyt.trsEJB.services.dl.TimePunchDlService;
import colruyt.trsEJB.services.dl.WorkActivityDlService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.ejb.EJB;


public class TimePunchService {

    /* SERVICES */
    
   //Niveau Up
   // private PersonBoConverter personConverter = new PersonBoConverter();

    @EJB
    private TimePunchDlService dlService;
    
    @EJB
    private WorkActivityDlService workActivityDl;
    

    /* API */

    public void punch(Person person) {
        
        dlService.save(new TimePunch(LocalDateTime.now(),person));
    }
    
    
    
    
    
    
    
    
   
    
    
    
    
    
}
