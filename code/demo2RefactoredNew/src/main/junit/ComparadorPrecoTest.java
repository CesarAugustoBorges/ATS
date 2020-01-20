package utils;

import carros.Veiculo;

import static org.junit.jupiter.api.Assertions.*;

class ComparadorPrecoTest {

    @org.junit.jupiter.api.Test
    void compareIguais(){
        ComparadorPreco tester = new ComparadorPreco();
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();

        v1.setPreco(10.0);
        v2.setPreco(10.0);

        assertEquals(0, tester.compare(v1,v2));
    }

    @org.junit.jupiter.api.Test
    void compareMaior(){
        ComparadorPreco tester = new ComparadorPreco();
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();

        v1.setPreco(20.0);
        v2.setPreco(10.0);

        assertEquals(1, tester.compare(v1,v2));
    }

    @org.junit.jupiter.api.Test
    void compareMenor(){
        ComparadorPreco tester = new ComparadorPreco();
        Veiculo v1 = new Veiculo();
        Veiculo v2 = new Veiculo();

        v1.setPreco(10.0);
        v2.setPreco(20.0);

        assertEquals(-1, tester.compare(v1,v2));
    }


}