import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

public class ResultTest {
    @Test
    public void conajmniejJedenSpełniaOgraniczenia() {
        Problem problem = new Problem(3, 1234, 1, 1);
        Result result = problem.solve(2);
        assertFalse(result.listaPrzedmiotow.isEmpty(), "Lista wybranych przedmiotów powinna być niepusta");
    }

    @Test
    public void zadenNieSpełniaOgraniczen() {
        Problem problem = new Problem(3, 1234, 10, 10);
        Result result = problem.solve(0);
        assertTrue(result.listaPrzedmiotow.isEmpty(), "Lista wybranych przedmiotów powinna być pusta");
    }

    @Test
    public void wartosciMieszczaSieWPrzedzialach() {
        int minValue = 1;
        int maxValue = 10;
        int numItems = 5;
        long seed = 1234;
        int capacity = 20;

        Problem problem = new Problem(numItems, seed, minValue, maxValue);
        Result result = problem.solve(capacity);

        for (int itemId : result.listaPrzedmiotow) {
            Item item = problem.itemList.get(itemId);
            assertTrue(item.waga >= minValue && item.waga <= maxValue, "Waga przedmiotu powinna być w zakresie 1-10");
            assertTrue(item.wartosc >= minValue && item.wartosc <= maxValue, "Wartość przedmiotu powinna być w zakresie 1-10");
        }
    }
    @Test
    public void konkretnaInstancja() {
        Problem problem = new Problem(5, 1234, 1, 10);
        Result result = problem.solve(8);
        for (Item item : problem.itemList) {
            System.out.println("Item ID: " + item.id + ", Value: " + item.wartosc + ", Weight: " + item.waga);
        }
        int expectedTotalWaga = 8;
        int expectedTotalWartosc = 32;

        assertEquals(expectedTotalWaga, result.totalwaga);
        assertEquals(expectedTotalWartosc, result.totalwartosc);
    }
}
