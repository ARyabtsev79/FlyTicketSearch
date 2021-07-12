package manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketToFind;
import ru.netology.manager.TicketManager;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TicketManagerTest {
    private TicketToFind[] tickets;
    private TicketToFind ticketRepository = new TicketToFind();
    private TicketManager ticketManager = new TicketManager(ticketRepository);

    @Test
    public void shouldFindOneResult() {
        tickets = new TicketToFind[3];
        tickets[0] = new TicketToFind(1, 110, "led", "vko", 90);
        tickets[1] = new TicketToFind(2, 100, "led", "dme", 88);
        tickets[2] = new TicketToFind(3, 130, "dme", "vko", 10);

        for (int i = 0; i < 3; i++) {
            ticketRepository.save(tickets[i]);
        }

        TicketToFind[] actual = ticketManager.findAll("led", "vko");
        TicketToFind[] expected = {new TicketToFind(1, 110, "led", "vko", 90)};
        assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindSeveralResults() {
        tickets = new TicketToFind[6];
        tickets[0] = new TicketToFind(1, 110, "dme", "led", 90);
        tickets[1] = new TicketToFind(2, 100, "led", "dme", 88);
        tickets[2] = new TicketToFind(3, 130, "dme", "vko", 10);
        tickets[3] = new TicketToFind(4, 150, "dme", "led", 96);
        tickets[4] = new TicketToFind(5, 100, "led", "dme", 82);
        tickets[5] = new TicketToFind(6, 98, "dme", "led", 112);

        for (int i = 0; i < 6; i++) {
            ticketRepository.save(tickets[i]);
        }

        TicketToFind[] actual = ticketManager.findAll("dme", "led");

        TicketToFind[] expected = {new TicketToFind(6, 98, "dme", "led", 112),
                new TicketToFind(1, 110, "dme", "led", 90),
                new TicketToFind(4, 150, "dme", "led", 96)};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindNothing() {
        tickets = new TicketToFind[3];
        tickets[0] = new TicketToFind(1, 110, "led", "vko", 90);
        tickets[1] = new TicketToFind(2, 100, "led", "dme", 88);
        tickets[2] = new TicketToFind(3, 130, "dme", "vko", 10);

        for (int i = 0; i < 3; i++) {
            ticketRepository.save(tickets[i]);
        }

        TicketToFind[] actual = ticketManager.findAll("vko", "led");
        TicketToFind[] expected = new TicketToFind[0];
        assertArrayEquals(expected, actual);

    }

}