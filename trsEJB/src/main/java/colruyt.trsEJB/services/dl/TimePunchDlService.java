package colruyt.trsEJB.services.dl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.entities.TimePunch;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import colruyt.trsEJB.services.bl.ActivityService;
import java.util.List;
import java.util.Optional;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

@Stateless
public class TimePunchDlService extends BaseDlService<TimePunch> {

    
    // Niet nodig Miss
   
    
    public TimePunchDlService(EntityManager entityManager) {
        
        super(entityManager);
        
        
    }

    @Override
    public Optional<TimePunch> getById(String id) {
         try{
            
            this.getEntityManager().getTransaction().begin();
            TimePunch p = this.getEntityManager().find(TimePunch.class, id);
            this.getEntityManager().getTransaction().commit();
            this.getEntityManager().close();
            
         return Optional.ofNullable(p);
            
        }catch(Exception e){
            throw e;
            
        }
        finally{
            this.getEntityManager().getTransaction().rollback();
      
            
        }

    }

    @Override
    public List<TimePunch> getAll() {
        
        try{
            
            this.getEntityManager().getTransaction().begin();
            List<TimePunch> listTimePunch = this.getEntityManager().createQuery(
            "SELECT p FROM TimePunch p").getResultList();
            this.getEntityManager().getTransaction().commit();
           
            
            return listTimePunch;
            
        }catch(Exception e){
            throw e;
            
        }
        finally{
            this.getEntityManager().getTransaction().rollback();
           
            
            
        }
          
    }

    @Override
    public void save(TimePunch t) {
         
            
           executeInsideTransaction(
                entityManager -> entityManager.persist(t)
           );
         
      
    }

    @Override
    public void update(TimePunch t) {
          
            
              executeInsideTransaction(
                entityManager -> entityManager.merge(t)
        );
            
         
    
    }

    @Override
    public void delete(TimePunch t) {
        
       
               
              executeInsideTransaction(
                entityManager -> entityManager.remove(t)

              );
            
    
    }

   

   

    
}
