package utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

class ParDatasTest {

    @Test
    void isAvailable1() {
        GregorianCalendar g1 = new GregorianCalendar(2018, 6, 25, 16, 16, 47);
        GregorianCalendar g2 = new GregorianCalendar( 2018, 6, 30, 16, 30, 47);
        ParDatas tester = new ParDatas(g1,g2);

        GregorianCalendar g3 = new GregorianCalendar(2018,6,23,16,46,33);
        GregorianCalendar g4 = new GregorianCalendar(2018, 7,2,16,30,56);
        ParDatas p2 = new ParDatas(g3,g4);

        Assertions.assertFalse(tester.isAvailable(p2));
    }

    @Test
    void isAvailable2() {
        GregorianCalendar g1 = new GregorianCalendar(2018, 6, 25, 16, 16, 47);
        GregorianCalendar g2 = new GregorianCalendar( 2018, 6, 30, 16, 30, 47);
        ParDatas tester = new ParDatas(g1,g2);

        GregorianCalendar g3 = new GregorianCalendar(2018,6,20,16,46,33);
        GregorianCalendar g4 = new GregorianCalendar(2018, 6,24,16,30,56);
        ParDatas p2 = new ParDatas(g3,g4);

        assertTrue(tester.isAvailable(p2));
    }

    @Test
    void isAvailable3() {
        GregorianCalendar g1 = new GregorianCalendar(2018, 6, 25, 16, 16, 47);
        GregorianCalendar g2 = new GregorianCalendar( 2018, 6, 30, 16, 30, 47);
        ParDatas tester = new ParDatas(g1,g2);

        GregorianCalendar g3 = new GregorianCalendar(2018,7,1,16,46,33);
        GregorianCalendar g4 = new GregorianCalendar(2018, 7,7,16,30,56);
        ParDatas p2 = new ParDatas(g3,g4);

        assertTrue(tester.isAvailable(p2));
    }
}