package utils;

import org.junit.jupiter.api.Test;
import utilizadores.Cliente;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorKmTest {

    @Test
    void compareIguais() {
        ComparadorKm tester = new ComparadorKm();
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setNKM(300);
        c2.setNKM(300);

        assertEquals(0, tester.compare(c1,c2));
    }

    @Test
    void compareMenores() {
        ComparadorKm tester = new ComparadorKm();
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setNKM(200);
        c2.setNKM(300);

        assertEquals(1, tester.compare(c1,c2));
    }

    @Test
    void compareMaiores() {
        ComparadorKm tester = new ComparadorKm();
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setNKM(300);
        c2.setNKM(200);

        assertEquals(-1, tester.compare(c1,c2));
    }
}