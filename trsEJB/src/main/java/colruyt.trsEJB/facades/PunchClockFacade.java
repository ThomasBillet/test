package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.bo.ProjectBo;
import colruyt.trsEJB.util.exceptions.CredentialNotFoundException;
import colruyt.trsEJB.util.exceptions.OutsideWorkdayTimeBoundariesException;

import java.time.LocalDateTime;


public interface PunchClockFacade {

    void registerActivity(
            LocalDateTime start, LocalDateTime end, String activity, ProjectBo project
    ) throws OutsideWorkdayTimeBoundariesException;

    void punch(String persId, String password) throws CredentialNotFoundException;

    void punch(PersonBo) throws CredentialNotFoundException;

    // PersonBo authenticate(String persId, String password) throws CredentialNotFoundException;

    // PersonBo getAuthenticatedPerson() throws CredentialNotFoundException;
}
