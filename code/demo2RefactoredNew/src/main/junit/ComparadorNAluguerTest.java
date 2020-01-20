package utils;

import org.junit.jupiter.api.Test;
import utilizadores.Cliente;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorNAluguerTest {

    @Test
    void compareIgual() {
        ComparadorNAluguer tester = new ComparadorNAluguer();
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setNAlugueres(10);
        c2.setNAlugueres(10);

        assertEquals(0, tester.compare(c1,c2));
    }

    @Test
    void compareMenor() {
        ComparadorNAluguer tester = new ComparadorNAluguer();
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setNAlugueres(10);
        c2.setNAlugueres(20);

        assertEquals(1, tester.compare(c1,c2));
    }

    @Test
    void compareMaior() {
        ComparadorNAluguer tester = new ComparadorNAluguer();
        Cliente c1 = new Cliente();
        Cliente c2 = new Cliente();

        c1.setNAlugueres(20);
        c2.setNAlugueres(10);

        assertEquals(-1, tester.compare(c1,c2));
    }
}