package kind.time;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinutesTest {

    private final long millisInAMinute = 60000;

    public MinutesTest() {
    }

    @Test
    public void testPlusWithAMinuteMultiple() {
        final long millis = Minutes.NINETY.plus(Minutes.FIVE).getTimeInMillis();
        assertEquals(95, Minutes.toMinutes(millis));
    }

    @Test
    public void testPlusWithANegativeNumber() {
        final long millis = Minutes.NINETY.plus(-91).getTimeInMillis();
        assertEquals(-1, Minutes.toMinutes(millis));
    }

    @Test
    public void testPlus() {
        final long millis = Minutes.ONE.plus(44).getTimeInMillis();
        assertEquals(45, Minutes.toMinutes(millis));
    }

    @Test
    public void testToMinutes() {
        assertEquals(1, Minutes.toMinutes(millisInAMinute));
        assertEquals(5, Minutes.toMinutes(millisInAMinute * 5));
        assertEquals(90, Minutes.toMinutes(millisInAMinute * 90));
        assertEquals(1000, Minutes.toMinutes(millisInAMinute * 1000));
    }

    @Test
    public void testMillisInAMinute() {
        assertEquals(millisInAMinute, Minutes.MILLIS_IN_A_MINUTE);
    }

    @Test
    public void testOneMinute() {
        final long millis = millisInAMinute * 1;
        assertEquals(millis, Minutes.ONE.getTimeInMillis());
    }

    @Test
    public void testTwoMinute() {
        final long millis = millisInAMinute * 2;
        assertEquals(millis, Minutes.TWO.getTimeInMillis());

    }

    @Test
    public void testThreeMinute() {
        final long millis = millisInAMinute * 3;
        assertEquals(millis, Minutes.THREE.getTimeInMillis());

    }

    @Test
    public void testFourMinute() {
        final long millis = millisInAMinute * 4;
        assertEquals(millis, Minutes.FOUR.getTimeInMillis());
    }


    @Test
    public void testFiveMinute() {
        final long millis = millisInAMinute * 5;
        assertEquals(millis, Minutes.FIVE.getTimeInMillis());
    }

    @Test
    public void testTenMinute() {
        final long millis = millisInAMinute * 10;
        assertEquals(millis, Minutes.TEN.getTimeInMillis());
    }

    @Test
    public void testFifteenMinute() {
        final long millis = millisInAMinute * 15;
        assertEquals(millis, Minutes.FIFTEEN.getTimeInMillis());
    }

    @Test
    public void testTwentyMinute() {
        final long millis = millisInAMinute * 20;
        assertEquals(millis, Minutes.TWENTY.getTimeInMillis());
    }

    @Test
    public void testThirtyMinute() {
        final long millis = millisInAMinute * 30;
        assertEquals(millis, Minutes.THIRTY.getTimeInMillis());
    }

    @Test
    public void testSixtyMinute() {
        final long millis = millisInAMinute * 60;
        assertEquals(millis, Minutes.SIXTY.getTimeInMillis());
    }

    @Test
    public void testNinetyMinute() {
        final long millis = millisInAMinute * 90;
        assertEquals(millis, Minutes.NINETY.getTimeInMillis());
    }

    @Test
    public void testOneHundredMinute() {
        final long millis = millisInAMinute * 100;
        assertEquals(millis, Minutes.ONE_HUNDRED.getTimeInMillis());
    }

    @Test
    public void testOneHundredTwentyMinute() {
        final long millis = millisInAMinute * 120;
        assertEquals(millis, Minutes.ONE_HUNDRED_TWENTY.getTimeInMillis());
    }
}
