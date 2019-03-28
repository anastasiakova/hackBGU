package Model;

import java.util.Date;

public class CalendarSession {
    public List<CompactUser> participants;
    public Date beginTime;
    public Date endTime;
    public int price;

    public CalendarSession(List<CompactUser> participants, Date beginTime, Date endTime, int price) {
        this.participants = participants;
        this.beginTime = beginTime;
        this.endTime = endTime;
        this.price = price;
    }
}
