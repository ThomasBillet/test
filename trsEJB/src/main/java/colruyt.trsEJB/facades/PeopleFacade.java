package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.PersonBo;

import java.util.Optional;

public interface PeopleFacade {

    Optional<PersonBo> getByPersID(String persID);

}
