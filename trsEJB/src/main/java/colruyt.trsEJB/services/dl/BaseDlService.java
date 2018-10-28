package colruyt.trsEJB.services.dl;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;
import java.util.function.Consumer;


public abstract class BaseDlService<T> implements IBaseDlService<T> {
	
	private EntityManager entityManager;

	public BaseDlService(EntityManager entityManager) {
		super();
		this.setEntityManager(entityManager);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	protected List<T> query(Query q){
		return q.getResultList();
	}
	
	protected void executeInsideTransaction(Consumer<EntityManager> action) { 
      
		final EntityTransaction tx = entityManager.getTransaction(); 
		
		try { 
			tx.begin(); 
			action.accept(entityManager); 
			tx.commit();  
		} 
		catch (RuntimeException e) { 
		    tx.rollback(); 
		    throw e; 
		} 
	}     

}
