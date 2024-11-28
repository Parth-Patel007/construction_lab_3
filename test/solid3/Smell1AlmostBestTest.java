package solid3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Smell1AlmostBestTest {

    @Test
    void zeroPowerTest()
    {
                 assertEquals(1, Smell1AlmostBest.toPower(7, 0), "a^0 will always be 1.");
    }

    @Test
    void cachingTest() {int res1 = Smell1AlmostBest.toPower(7, 77);



        int res2 = Smell1AlmostBest.toPower(7, 77);
        assertEquals(res1, res2, "results should same because of caching");
    }

    @Test
    void negativePowerTest() {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> Smell1AlmostBest.toPower(2, -3),
                "-ve power not supported , throwing exception");
        assertNotNull(e);
    }

    @Test
    void zeroBaseTest() { assertEquals(0, Smell1AlmostBest.toPower(0, 7), "0 base to any power is 0, obviously");
    }

    @Test
    void positivePowerTest() { assertEquals(823543, Smell1AlmostBest.toPower(7, 7), "7^7 should always be 823543");


    }
    @Test
    void largePowerTest() {
        assertEquals(282475249, Smell1AlmostBest.toPower(7, 10), "7^7 should be equal to 282475249");
    }

    @Test
    void baseOneTest() {
        assertEquals(1, Smell1AlmostBest.toPower(1, 7000), "1 raised to any power should be 1");
    }






}
