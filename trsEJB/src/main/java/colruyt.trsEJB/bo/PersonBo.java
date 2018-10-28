package colruyt.trsEJB.bo;

public class PersonBo extends BaseBo {

    private String firstName, lastName;
    private String persId;

    /* CONSTRUCTORS */

    public PersonBo(String persId) {

        LOGGER.traceEntry(
                "PersonBo was created: {}", persId
        );

        this.persId = persId;
    }

    public PersonBo(String persId, String password) {

        LOGGER.traceEntry(
                "PersonBo was created: {}", persId
        );

        this.persId = persId;
    }

    /* GETTERS & SETTERS */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersId() {
        return persId;
    }

    public void setPersId(String persId) {
        this.persId = persId;
    }

}
