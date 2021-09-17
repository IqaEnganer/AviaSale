package comparator;

import info.Ticket;

import java.util.Comparator;

public class TicketByTimeAscComparator implements Comparator<Ticket> {
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTravelTimeMin() - o2.getTravelTimeMin();
    }
}
