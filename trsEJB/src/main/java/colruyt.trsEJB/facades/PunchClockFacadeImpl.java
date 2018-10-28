package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.services.bl.ActivityService;
import colruyt.trsEJB.services.bl.PersonService;
import colruyt.trsEJB.services.bl.TimePunchService;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.time.LocalDateTime;

@Stateless
@LocalBean
public class PunchClockFacadeImpl implements PunchClockFacade {

    protected final Logger LOGGER = LogManager.getLogger( this.getClass().getName() );

    private PersonBo authenticatedPerson;

    /* SERVICES */

    @EJB
    private PersonService personService;

    @EJB
    private TimePunchService timePunchService;

    @EJB
    private ActivityService activityService;

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
    public void punch(PersonBo personBo) {
        timePunchService.punch(personBo);
    }

}
