package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.repository.TicketRepository;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TicketToFind extends TicketRepository implements Comparable<TicketToFind> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int travelTime;

    @Override
    public int compareTo(TicketToFind t) {
        return price - t.price;
    }
}