package colruyt.trsEJB.bo;

import java.time.LocalDateTime;

public class TimePunchBo extends BaseBo {

    private LocalDateTime punch;

    private PersonBo person;

    /* CONSTRUCTORS */

    public TimePunchBo(LocalDateTime punch, PersonBo person) {
        LOGGER.traceEntry(
            "Time punch: {} for: {}",
            punch.toLocalTime(), person.getPersId()
        );

        this.punch = punch;
        this.person = person;
    }
    /* GETTERS & SETTERS */

    public LocalDateTime getPunch() {
        return punch;
    }

    public void setPunch(LocalDateTime punch) {
        this.punch = punch;
    }

    public PersonBo getPerson() {
        return person;
    }

    public void setPerson(PersonBo person) {
        this.person = person;
    }
}
