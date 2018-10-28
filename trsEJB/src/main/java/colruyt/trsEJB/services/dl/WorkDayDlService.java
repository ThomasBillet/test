/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colruyt.trsEJB.services.dl;

import colruyt.trsEJB.entities.Person;
import colruyt.trsEJB.entities.WorkDay;
import colruyt.trsEJB.services.dl.BaseDlService;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author tho
 */
public class WorkDayDlService extends BaseDlService<WorkDay>{

    public WorkDayDlService(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Optional<WorkDay> getById(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<WorkDay> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public Optional<WorkDay> getCurrentWorkDayFor(Person p){
        
        //TODO: Date = Today && User = p
       return Optional.ofNullable((WorkDay) this.getEntityManager().createNamedQuery("Select wd from WorkDay wd where p.person = :person")
                                                                    .setParameter("person", p)
                                                                     .getSingleResult()
       
        
        );
    }
    
    public Optional<List<WorkDay>> getWorkDaysFor(Person p){
        
         return Optional.ofNullable((List<WorkDay>) this.getEntityManager().createNamedQuery("Select wd from WorkDay wd where p.person = :person")
                                                                    .setParameter("person", p)
                                                                     .getResultList()
                                    );
        
    }

    @Override
    public void save(WorkDay t) {
           executeInsideTransaction(
                entityManager -> entityManager.persist(t)

              );
            
    }

    @Override
    public void update(WorkDay t) {
   executeInsideTransaction(
                entityManager -> entityManager.merge(t)

              );
                }

    @Override
    public void delete(WorkDay t) {

               executeInsideTransaction(
                entityManager -> entityManager.remove(t)

              );
            
    }
    
}
