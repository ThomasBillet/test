package colruyt.trsEJB.bo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseBo {

    protected final Logger LOGGER = LogManager.getLogger( this.getClass().getName() );

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
