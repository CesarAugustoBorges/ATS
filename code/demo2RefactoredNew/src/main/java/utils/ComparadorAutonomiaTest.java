package utils;

import carros.Veiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorAutonomiaTest {

    @Test
    void compareIguais() {
        ComparadorAutonomia tester = new ComparadorAutonomia();
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();

        v1.setAutonomia(80);
        v2.setAutonomia(80);

        assertEquals(0, tester.compare(v1,v2));
    }

    @Test
    void compareMenores() {
        ComparadorAutonomia tester = new ComparadorAutonomia();
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();

        v1.setAutonomia(70);
        v2.setAutonomia(80);

        assertEquals(-1, tester.compare(v1,v2));
    }

    @Test
    void compareMaiores() {
        ComparadorAutonomia tester = new ComparadorAutonomia();
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();

        v1.setAutonomia(90);
        v2.setAutonomia(80);

        assertEquals(1, tester.compare(v1,v2));
    }
}