/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colruyt.trsEJB.services.dl;

import colruyt.trsEJB.entities.Project;
import colruyt.trsEJB.services.dl.BaseDlService;
import colruyt.trsEJB.services.dl.BaseDlService;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;

/**
 *
 * @author tho
 */
public class ProjectDlService extends BaseDlService<Project>{

    public ProjectDlService(EntityManager entityManager) {
        super(entityManager);
    }

   
    @Override
    public Optional<Project> getById(String id) {
         try{
            
            this.getEntityManager().getTransaction().begin();
            Project p = this.getEntityManager().find(Project.class, id);
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
    public List<Project> getAll() {
        
        try{
            
            this.getEntityManager().getTransaction().begin();
            List<Project> listProject = this.getEntityManager().createQuery(
            "SELECT p FROM Project p").getResultList();
            this.getEntityManager().getTransaction().commit();
           
            
            return listProject;
            
        }catch(Exception e){
            throw e;
            
        }
        finally{
            this.getEntityManager().getTransaction().rollback();
           
            
            
        }
          
    }

    @Override
    public void save(Project t) {
       
             executeInsideTransaction(
                entityManager -> entityManager.persist(t)
                 

              );
    }

    @Override
    public void update(Project t) {
      
        executeInsideTransaction(
                entityManager -> entityManager.merge(t)
                 

              );
            
    }

    @Override
    public void delete(Project t) {
        
         executeInsideTransaction(
                entityManager -> entityManager.remove(t)
                 

              );
            

    }

    
    
}
