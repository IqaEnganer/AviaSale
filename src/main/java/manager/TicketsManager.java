package manager;

import info.Ticket;
import repository.TicketsRepository;

import java.util.Arrays;

public class TicketsManager {
    TicketsRepository repository;

    public TicketsManager(TicketsRepository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public void remove(int id) {
        repository.removeTicket(id);
    }

    public void findAll() {
        repository.findAll();
    }


    public Ticket[] searchFromTO(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from) && ticket.getTo().contains(to)) {
            return true;
        }
        return false;
    }

}
