package colruyt.trsEJB.bo;

import java.util.List;

public class WorkDayBo extends BaseBo{

    private TimePunchBo startPunch;

    private TimePunchBo endPunch;

    private List<WorkActivityBo> dayActivities;

    /* CONSTRUCTORS */

    public WorkDayBo(TimePunchBo startPunch, TimePunchBo endPunch, List <WorkActivityBo> dayActivities) {
        LOGGER.traceEntry(
                "WorkDayBo constructed: {} activities | {} => {}",
                dayActivities.size(), startPunch, endPunch
        );

        this.startPunch = startPunch;
        this.endPunch = endPunch;
        this.dayActivities = dayActivities;
    }

    /* GETTERS & SETTERS */

    public TimePunchBo getStartPunch() {
        return startPunch;
    }

    public void setStartPunch(TimePunchBo startPunch) {
        this.startPunch = startPunch;
    }

    public TimePunchBo getEndPunch() {
        return endPunch;
    }

    public void setEndPunch(TimePunchBo endPunch) {
        this.endPunch = endPunch;
    }

    public List<WorkActivityBo> getDayActivities() {
        return dayActivities;
    }

    public void setDayActivities( List<WorkActivityBo> dayActivities ) {
        this.dayActivities = dayActivities;
    }
}
