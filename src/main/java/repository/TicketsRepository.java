package repository;

import info.Ticket;

public class TicketsRepository {
    private Ticket[] tickets = new Ticket[0];

    public void add(Ticket item) {
        int length = tickets.length + 1;
        Ticket[] tmp = new Ticket[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int index = tmp.length - 1;
        tmp[index] = item;
        tickets = tmp;
    }

    public void removeTicket(int id) {
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int index = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }

    public Ticket[] findAll() {
        return tickets;
    }

}
