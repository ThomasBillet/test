package colruyt.trsEJB.services.dl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.services.bl.ActivityService;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;

import java.time.LocalDateTime;

public class WorkActivityDlService {

    protected static final Logger LOGGER = LogManager.getLogger( ActivityService.class.getName() );

    private static WorkActivityDlService service;

    public static WorkActivityDlService getService() {

        if (service == null) {
            service = new WorkActivityDlService();
        }

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

        // TODO: 2implement => converter

        LOGGER.traceExit("{}", "create()");
    }
}
