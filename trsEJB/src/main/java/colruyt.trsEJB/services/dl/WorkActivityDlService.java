package colruyt.trsEJB.services.dl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.entities.TimePunch;
import colruyt.trsEJB.entities.WorkActivity;
import colruyt.trsEJB.services.bl.ActivityService;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

@Stateless
public class WorkActivityDlService extends BaseDlService<WorkActivity> {


    protected static final Logger LOGGER = LogManager.getLogger( ActivityService.class.getName() );

    public WorkActivityDlService(EntityManager entityManager) {
        super(entityManager);
    }

    public void create (
            LocalDateTime start, LocalDateTime end,
            String activity, ProjectBo project,
            PersonBo authenticatedPerson
    ) throws OutsideWorkdayTimeBoundariesException {

        LOGGER.traceEntry(
                "create( start: {}, end: {}, activity: {}, project: {}, persID: {}",
                start, end, activity, project.getName(), authenticatedPerson.getPersId()
        );

        // TODO: 2implement => converter

       
    }

    
    @Override
    public Optional<WorkActivity> getById(String id) {
         try{
            
            this.getEntityManager().getTransaction().begin();
            WorkActivity p = this.getEntityManager().find(WorkActivity.class, id);
            this.getEntityManager().getTransaction().commit();
            this.getEntityManager().close();
            
         return Optional.of(p);
            
        }catch(Exception e){
            throw e;
            
        }
        finally{
            this.getEntityManager().getTransaction().rollback();
      
            
        }

    }

    @Override
    public List<WorkActivity> getAll() {
        
        try{
            
            this.getEntityManager().getTransaction().begin();
            List<WorkActivity> listWorkActivity = this.getEntityManager().createQuery(
            "SELECT p FROM WorkActivity p").getResultList();
            this.getEntityManager().getTransaction().commit();
           
            
            return listWorkActivity;
            
        }catch(Exception e){
            throw e;
            
        }
        finally{
            this.getEntityManager().getTransaction().rollback();
           
            
            
        }
          
    }

    @Override
    public void save(WorkActivity t) {
     
         executeInsideTransaction(
                entityManager -> entityManager.persist(t)
           );
    }

    @Override
    public void update(WorkActivity t) {
      
         executeInsideTransaction(
                entityManager -> entityManager.merge(t)
           );
    }

    @Override
    public void delete(WorkActivity t) {
        
            
              executeInsideTransaction(
                entityManager -> entityManager.remove(t)

              );

    }
    
    
    
    
}

 
