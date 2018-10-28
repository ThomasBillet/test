package colruyt.trsEJB.services.dl;


import colruyt.trsEJB.entities.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;


@Stateless
public class PersonDlService extends BaseDlService<Person> implements IBaseDlService<Person> {
	
	private enum Queries {
	    GET_ALL("SELECT e FROM Person e");

	    private String query;

		Queries(String query) {
	        this.query = query;
	    }

	    public String query() {
	        return query;
	    }
	}
	
	public PersonDlService(EntityManager entityManager) {
		super(entityManager);
	}

	public Optional<Person> getById(String id) {
				
		return Optional
					.ofNullable(
						this.getEntityManager()
							.find(
								Person.class, (int)id
							
									)
					);
	}

	@SuppressWarnings("unchecked")
	public List<Person> getAll() {
		
		return getEntityManager()
					.createQuery( 
						Queries.GET_ALL.query()
					)
					.getResultList();
	}
	
	public void save(Person person) {
		executeInsideTransaction(
				entityManager -> entityManager.persist( person )
			);
	}

	public void update(Person person) {
		// TODO: validation ?
        executeInsideTransaction(
        			entityManager -> entityManager.merge( person )
        		);
	}

	public void delete(Person person) {
		executeInsideTransaction(
					entityManager -> entityManager.remove( person )
				);
	}

}
