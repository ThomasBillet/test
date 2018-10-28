package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.entities.Person;
import colruyt.trsEJB.services.dl.PersonDlService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
@LocalBean
public class PersonService {

    private static final Logger LOGGER = LogManager.getLogger( PersonService.class.getName() );

    @EJB
    PersonDlService personDlService;

    private PersonBo dummyP = new PersonBo("user","password");

    public PersonService() { LOGGER.trace("Service constructed");  }

    public Optional<PersonBo> getByCredentials(String persId, String password) {

        LOGGER.traceEntry("getByCredentials( PersID = {}, Password = {} )", persId, password);

        // TODO: 2Implement! => DL service
        Optional<PersonBo> optionalPersonBO = Optional.ofNullable( dummyP );

        LOGGER.traceExit( "getByCredentials() with: {}", optionalPersonBO );

        return optionalPersonBO;
    }

    public PersonBo getByPersID( String persID ) {

        // get entity
        Optional<Person> entity = personDlService.getById(persID);

        //TODO: convert it

        //TODO: return it
        return null;

    }
}
