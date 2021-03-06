package info;

import lombok.Data;

@Data
public class Ticket implements Comparable<Ticket> {
    private int id;
    private String from;
    private String to;
    private int price;
    private int travelTimeMin;


    public Ticket() {
    }

    public Ticket(int id, String from, String to, int price, int travelTime) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.price = price;
        this.travelTimeMin = travelTime;

    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }

}
