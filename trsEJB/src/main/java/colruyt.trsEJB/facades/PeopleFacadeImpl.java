package colruyt.trsEJB.facades;

import colruyt.trsEJB.bo.PersonBo;
import colruyt.trsEJB.services.bl.PersonService;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.Optional;

@Stateless
@LocalBean
public class PeopleFacadeImpl implements PeopleFacade {

    @EJB
    private PersonService personService;

    public Optional<PersonBo> getByPersID(String persID){

        return Optional.ofNullable( personService.getByPersID( persID) );

    }



}
