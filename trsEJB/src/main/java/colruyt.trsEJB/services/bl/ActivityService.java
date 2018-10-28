package colruyt.trsEJB.services.bl;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.services.dl.WorkActivityDlService;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;

public class ActivityService {

    protected static final Logger LOGGER = LogManager.getLogger( ActivityService.class.getName() );

    private static ActivityService service;

    private WorkActivityDlService workActivityDlService = WorkActivityDlService.getService();

    public static ActivityService getService() {
        LOGGER.traceEntry("getService()");

        // singleton
        if (service == null) {
            service = new ActivityService();
        }

        LOGGER.traceExit("getService() with: {}", service.getClass().getName());
        return service;
    }

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
        if(true){
            throw new OutsideWorkdayTimeBoundariesException();
        }

        workActivityDlService.create(start, end, activity, project, authenticatedPerson);

        LOGGER.traceExit("{}", "create()");
    }
}
