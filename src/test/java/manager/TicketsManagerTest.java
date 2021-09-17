package manager;

import info.Ticket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import repository.TicketsRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketsManagerTest {
    private TicketsRepository repository = new TicketsRepository();
    private TicketsManager manager = new TicketsManager(repository);
    Ticket t1 = new Ticket(1, "EGO", "DME", 1660, 75);
    Ticket t2 = new Ticket(2, "MOW", "DME", 125, 36);
    Ticket t3 = new Ticket(3, "GOJ", "KUF", 200, 68);
    Ticket t4 = new Ticket(4, "RHV", "OGZ", 6000, 500);
    Ticket t5 = new Ticket(5, "LED", "DME", 5200, 500);
    Ticket t6 = new Ticket(6, "KUF", "FRU", 7000, 654);
    Ticket t7 = new Ticket(7, "KUF", "FRU", 6272, 657);
    Ticket t8 = new Ticket(8, "EGO", "DME", 110, 75);
    Ticket t9 = new Ticket(9, "EGO", "DME", 4520, 75);

    @BeforeEach
    private void setup() {
        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);
        manager.add(t9);
    }
    // Проверка поиска билета по аэропорту отправления и прибытия
    @Test
    public void shouldSearchByFromAndTO() {
        assertArrayEquals(new Ticket[]{t2}, manager.searchFromTO("MOW", "DME"));
    }
    // Проверка возможности поиска только по двум критериям (Отправлениe и прибытиe)
    @Test
    public void shouldNotSearchByFrom(){
        assertArrayEquals(new Ticket[0],manager.searchFromTO("MOW","123"));
        assertArrayEquals(new Ticket[0],manager.searchFromTO("123","DME"));
    }
    // Проверка несуществующих билетов
    @Test
    public void shouldShowNothing(){
        assertArrayEquals(new Ticket[0],manager.searchFromTO("123","123"));
    }
    // Проверка поиска одинаковых билетов по Отправлению и Прибытию
    @Test
    public void shouldSearchSimilarFromAndTo() {
        assertArrayEquals(new Ticket[]{t7, t6}, manager.searchFromTO("KUF", "FRU"));
    }

    // Проверка сортировки по цене от меньшего к большему
    @Test
    public void shouldGiveWithLowerPrice() {
        assertArrayEquals(new Ticket[]{t8, t1, t9}, manager.searchFromTO("EGO", "DME"));
    }
}