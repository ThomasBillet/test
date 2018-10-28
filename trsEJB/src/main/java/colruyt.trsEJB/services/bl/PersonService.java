package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
@LocalBean
public class PersonService {

    private static final Logger LOGGER = LogManager.getLogger( PersonService.class.getName() );

    private PersonBo dummyP = new PersonBo("user","password");

    public PersonService() { LOGGER.trace("Service constructed");  }

    public Optional<PersonBo> getByCredentials(String persId, String password) {

        LOGGER.traceEntry("getByCredentials( PersID = {}, Password = {} )", persId, password);

        // TODO: 2Implement! => DL service
        Optional<PersonBo> optionalPersonBO = Optional.ofNullable( dummyP );

        LOGGER.traceExit( "getByCredentials() with: {}", optionalPersonBO );

        return optionalPersonBO;
    }

    public PersonBo getByPersID(String persID) {
        // TODO: 2Implement!
        return null;
    }
}
