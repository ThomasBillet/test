package colruyt.trsEJB.services.dl;

import java.util.List;
import java.util.Optional;

/**
 * Base interface for CRUD operations and common queries
 */
public interface IBaseDlService<T> {
	
	Optional<T> getById(String id);
    
    List<T> getAll();
    
    void save(T t);
    
    void update(T t);
    
    void delete(T t);
     
    /**
     * Get list by criteria
     * 
     * @param detachedCriteria the domain query criteria, include condition and the orders.
     * @return List<T>
     */
//    public List<T> getListByCriteria(DetachedCriteria detachedCriteria);
//     
//    public List<T> getListByCriteria(DetachedCriteria detachedCriteria, int offset, int size);   
}
