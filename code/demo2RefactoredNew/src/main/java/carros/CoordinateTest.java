package carros;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {

    @Test
    public void getLatitude() {
        Coordinate a =new Coordinate(3,4);
        assertEquals(3,a.getLatitude(),0);
    }

    @Test
    public void getLongitude() {
        Coordinate a =new Coordinate(3,4);
        assertEquals(4,a.getLongitude(),0);
    }

    @Test
    public void setLatitude() {
        Coordinate a =new Coordinate(3,4);
        a.setLatitude(10);
        assertEquals(10,a.getLatitude(),0);
    }

    @Test
    public void setLongitude() {
        Coordinate a =new Coordinate(3,4);
        a.setLongitude(10);
        assertEquals(10,a.getLongitude(),0);
    }

    @Test
    public void getDistancia() {
        Coordinate c1 = new Coordinate(4, 3);
        Coordinate c2 = new Coordinate(0, 0);

        assertEquals(5.0, c1.getDistancia(c2), 0.1);
    }

    @Test
    public void compareTo1() {
        Coordinate c1 = new Coordinate(4,4);
        Coordinate c2 = new Coordinate(4,4);

        assertEquals(0, c1.compareTo(c2));
    }

    @Test
    public void compareTo2() {
        Coordinate c1 = new Coordinate(4,4);
        Coordinate c2 = new Coordinate(4,3);

        assertEquals(1, c1.compareTo(c2));
    }

    @Test
    public void compareTo3(){
        Coordinate c1 = new Coordinate(2,5);
        Coordinate c2 = new Coordinate(4,4);

        assertEquals(-1, c1.compareTo(c2));
    }
}