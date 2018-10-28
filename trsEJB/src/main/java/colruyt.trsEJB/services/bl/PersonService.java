package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class PersonService {

    private static final Logger LOGGER = LogManager.getLogger( PersonService.class.getName() );

    private static PersonBo dummyP = new PersonBo("user","password");

    private static PersonService service;

    public PersonService() { LOGGER.trace("Service constructed");  }

    public static PersonService getService() {
        LOGGER.traceEntry("getService()");

        // singleton
        if (service == null) {
            service = new PersonService();
        }

        LOGGER.traceExit("getService() with: {}", service.getClass().getName());
        return service;
    }

    public Optional<PersonBo> getByCredentials(String persId, String password) {

        LOGGER.traceEntry("getByCredentials( PersID = {}, Password = {} )", persId, password);

        // TODO: 2Implement! => DL service
        Optional<PersonBo> optionalPersonBO = Optional.ofNullable( dummyP );

        LOGGER.traceExit( "getByCredentials() with: {}", optionalPersonBO );

        return optionalPersonBO;
    }
}
