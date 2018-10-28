/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.entities.Person;
import colruyt.trsEJB.entities.WorkDay;
import colruyt.trsEJB.services.dl.WorkDayDlService;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author tho
 */

@Stateless
public class WorkDayService {
    
    
    @EJB
    private WorkDayDlService workDl;
    
    public List<WorkDay> getWorkingDaysFor(Person p){
        //Todo:check if null
        return this.workDl.getWorkDaysFor(p).get();
    }
    
    
}
