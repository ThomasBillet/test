package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;

import java.time.LocalDateTime;

public interface PunchClockFacade {

    void registerActivity(
            LocalDateTime start, LocalDateTime end, String activity, ProjectBo project, PersonBo authenticatedPerson
    ) throws OutsideWorkdayTimeBoundariesException;

    void punch(PersonBo personBo) ;

}
