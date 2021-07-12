package ru.netology.manager;

import ru.netology.domain.TicketToFind;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {

    private TicketRepository ticketRepository;

    public TicketManager(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;

    }


    public TicketToFind[] findAll(String from, String to) {
        int tmp = 0;
        for (TicketToFind item : ticketRepository.findAll()) {
            if ((item.getDeparture().equals(from)) && (item.getArrival().equals(to))) {
                tmp++;
            }
        }
        TicketToFind[] result = new TicketToFind[tmp];

        int i = 0;
        for (TicketToFind item : ticketRepository.findAll()) {
            if ((item.getDeparture().equals(from)) && (item.getArrival().equals(to))) {
                result[i] = item;
                i++;
            }
        }
        Arrays.sort(result);
        return result;
    }

}