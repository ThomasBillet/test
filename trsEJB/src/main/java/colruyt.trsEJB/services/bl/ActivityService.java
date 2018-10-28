package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.services.dl.WorkActivityDlService;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ejb.Stateless;
import java.time.LocalDateTime;



@Stateless
public class ActivityService {

    protected static final Logger LOGGER = LogManager.getLogger( ActivityService.class.getName() );



    private WorkActivityDlService workActivityDlService;

    public void create (
            LocalDateTime start, LocalDateTime end,
            String activity, ProjectBo project,
            PersonBo authenticatedPerson
    ) throws OutsideWorkdayTimeBoundariesException {
        LOGGER.traceEntry(
                "create( start: {}, end: {}, activity: {}, project: {}, persID: {}",
                start, end, activity, project.getName(), authenticatedPerson.getPersId()
        );

        // validate activity start & end (date/time) boundaries

        workActivityDlService.create(start, end, activity, project, authenticatedPerson);

        LOGGER.traceExit("{}", "create()");
    }
}
