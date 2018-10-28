package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.services.bl.ActivityService;
import colruyt.trsEJB.services.bl.PersonService;
import colruyt.trsEJB.services.bl.TimePunchService;
import colruyt.trsEJB.util.exceptions.CredentialNotFoundException;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.time.LocalDateTime;
import java.util.Optional;

@Stateless
@LocalBean
public class PunchClockFacadeImpl implements PunchClockFacade {

    protected final Logger LOGGER = LogManager.getLogger( this.getClass().getName() );

    private PersonBo authenticatedPerson;

    /* SERVICES */

    // TODO: Inject
    private PersonService personService = PersonService.getService();

    // TODO: Inject
    private TimePunchService timePunchService = TimePunchService.getService();

    private ActivityService activityService = ActivityService.getService();

    /* CONSTRUCTORS */
    public PunchClockFacadeImpl() { LOGGER.trace("PunchClockFacade constructed"); }

    /* PUBLIC ENTRIES */

    @Override
    public void registerActivity(
            LocalDateTime start, LocalDateTime end,
            String activity, ProjectBo project
    ) throws OutsideWorkdayTimeBoundariesException {

        LOGGER.traceEntry(
                "registerActivity( start: {}, end: {}, activity: {}, project: {}",
                start, end, activity, project.getName()
        );


        activityService.create(start, end, activity, project, authenticatedPerson);

        LOGGER.traceExit("{}","registerActivity()");
    }

    @Override
    public void punch(String persId, String password) throws CredentialNotFoundException {

        LOGGER.traceEntry( "punch( PersID = {}, Password = {} )", persId, password );
        //TODO: Zie Authenticate return ( dubbele assign);
        authenticatedPerson = authenticate(persId, password);

        try {
            LOGGER.info(
                    "passing the 'punch' to persistence layer for persID: {}",
                    persId
            );
            timePunchService.punch( authenticatedPerson );
        }
        catch (Exception e) {
            LOGGER.fatal("CredentialNotFoundException");
            LOGGER.catching(e);
            // TODO: Exception handling?
        }
        LOGGER.info("Punch was accepted for the persID: {}", persId);

        LOGGER.traceExit("{}","punch()");
    }

    @Override
    public PersonBo authenticate(String persId, String password) throws CredentialNotFoundException {
        LOGGER.traceEntry(
                "Authenticating persID: {}", persId
        );

        // query person => is never Null => will be empty obj: Optional if no person was found
        Optional<PersonBo> optionalPersonBO = personService.getByCredentials(persId, password);

        LOGGER.info("Optional object = '{}' was provided by the service", optionalPersonBO);

        // if no person was found => Exception : CredentialNotFoundException
        if ( !optionalPersonBO.isPresent() ) {

            LOGGER.warn("Object Optional<Person> is empty");

            throw new CredentialNotFoundException();
        }
        return this.authenticatedPerson = optionalPersonBO.get();
    }

    @Override
    public PersonBo getAuthenticatedPerson() throws CredentialNotFoundException {
        if(this.authenticatedPerson == null) {
            throw new CredentialNotFoundException();
        }
        return this.authenticatedPerson;
    }
}
