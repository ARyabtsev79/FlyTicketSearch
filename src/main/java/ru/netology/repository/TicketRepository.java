package ru.netology.repository;

import ru.netology.domain.TicketToFind;

public class TicketRepository {

    private TicketToFind[] tickets = new TicketToFind[0];

    public void save(TicketToFind ticket) {
        int length = tickets.length + 1;
        TicketToFind[] tmp = new TicketToFind[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        tmp[length - 1] = ticket;
        tickets = tmp;
    }

    public TicketToFind[] findAll() {
        return tickets;
    }

    public void delete(int id) {
        int length = tickets.length - 1;
        TicketToFind[] tmp = new TicketToFind[length];
        int index = 0;
        for (TicketToFind item : tickets) {
            if (item.getId() != id) {
                tmp[index] = item;
            }
        }
        tickets = tmp;
    }


}