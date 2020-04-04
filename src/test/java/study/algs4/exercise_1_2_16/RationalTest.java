package study.algs4.exercise_1_2_16;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class RationalTest {

    @Test
    void plus() {
        assertEquals(new Rational(5, 4), new Rational(1, 2).plus(new Rational(3, 4)));
        assertEquals(new Rational(14, 15), new Rational(3, 5).plus(new Rational(1, 3)));
        assertEquals(new Rational(47, 10), new Rational(6, 5).plus(new Rational(7, 2)));
        assertEquals(new Rational(78, 28), new Rational(9, 7).plus(new Rational(6, 4)));
        assertEquals(new Rational(86, 18), new Rational(8, 2).plus(new Rational(7, 9)));
        assertEquals(new Rational(16, 3), new Rational(3, 1).plus(new Rational(7, 3)));
        assertEquals(new Rational(32, 5), new Rational(5, 1).plus(new Rational(7, 5)));
        assertEquals(new Rational(43, 15), new Rational(1, 5).plus(new Rational(8, 3)));
        assertEquals(new Rational(43, 24), new Rational(5, 3).plus(new Rational(1, 8)));
        assertEquals(new Rational(3, 8), new Rational(2, 8).plus(new Rational(1, 8)));
        assertEquals(new Rational(4, 3), new Rational(1, 3).plus(new Rational(1, 1)));
        assertEquals(new Rational(19, 18), new Rational(5, 6).plus(new Rational(2, 9)));
    }

    @Test
    void minus() {
        assertEquals(new Rational(19, 3), new Rational(7, 1).minus(new Rational(6, 9)));
        assertEquals(new Rational(-3, 2), new Rational(9, 3).minus(new Rational(9, 2)));
        assertEquals(new Rational(7, 4), new Rational(5, 2).minus(new Rational(3, 4)));
        assertEquals(new Rational(11, 12), new Rational(9, 4).minus(new Rational(8, 6)));
        assertEquals(new Rational(1, 4), new Rational(6, 6).minus(new Rational(6, 8)));
        assertEquals(new Rational(7, 12), new Rational(8, 6).minus(new Rational(6, 8)));
        assertEquals(new Rational(-47, 8), new Rational(9, 8).minus(new Rational(7, 1)));
        assertEquals(new Rational(-10, 7), new Rational(4, 7).minus(new Rational(4, 2)));
        assertEquals(new Rational(5, 6), new Rational(7, 3).minus(new Rational(9, 6)));
        assertEquals(new Rational(65, 36), new Rational(9, 4).minus(new Rational(4, 9)));
    }

    @Test
    void times() {
        assertEquals(new Rational(3, 8), new Rational(1, 8).times(new Rational(9, 3)));
        assertEquals(new Rational(35, 36), new Rational(5, 4).times(new Rational(7, 9)));
        assertEquals(new Rational(18, 5), new Rational(8, 4).times(new Rational(9, 5)));
        assertEquals(new Rational(5, 12), new Rational(5, 9).times(new Rational(3, 4)));
        assertEquals(new Rational(5, 54), new Rational(5, 6).times(new Rational(1, 9)));
        assertEquals(new Rational(2, 7), new Rational(2, 7).times(new Rational(6, 6)));
        assertEquals(new Rational(4, 15), new Rational(4, 6).times(new Rational(2, 5)));
        assertEquals(new Rational(4, 1), new Rational(9, 3).times(new Rational(4, 3)));
        assertEquals(new Rational(35, 27), new Rational(5, 9).times(new Rational(7, 3)));
        assertEquals(new Rational(1, 9), new Rational(1, 4).times(new Rational(4, 9)));
    }

    @Test
    void dividedBy() {
        assertEquals(new Rational(7, 20), new Rational(1, 5).dividedBy(new Rational(4, 7)));
        assertEquals(new Rational(5, 12), new Rational(5, 2).dividedBy(new Rational(6, 1)));
        assertEquals(new Rational(6, 5), new Rational(4, 5).dividedBy(new Rational(2, 3)));
        assertEquals(new Rational(4, 9), new Rational(8, 9).dividedBy(new Rational(8, 4)));
        assertEquals(new Rational(15, 2), new Rational(6, 2).dividedBy(new Rational(2, 5)));
        assertEquals(new Rational(20, 3), new Rational(8, 2).dividedBy(new Rational(3, 5)));
        assertEquals(new Rational(32, 9), new Rational(4, 1).dividedBy(new Rational(9, 8)));
        assertEquals(new Rational(1, 6), new Rational(1, 4).dividedBy(new Rational(6, 4)));
        assertEquals(new Rational(12, 7), new Rational(8, 7).dividedBy(new Rational(2, 3)));
        assertEquals(new Rational(1, 6), new Rational(1, 3).dividedBy(new Rational(6, 3)));
    }

    @Test
    void testEquals() {
        assertEquals(new Rational(0, 2), new Rational(0, 3));
        assertEquals(new Rational(4, 4), new Rational(5, 5));
        assertEquals(new Rational(6, 6), new Rational(9, 9));
        assertEquals(new Rational(3, 3), new Rational(3, 3));
        assertEquals(new Rational(5, 5), new Rational(7, 7));
        assertEquals(new Rational(8, 4), new Rational(2, 1));
        assertEquals(new Rational(3, 6), new Rational(1, 2));
        assertEquals(new Rational(8, 7), new Rational(8, 7));
        assertEquals(new Rational(7, 3), new Rational(7, 3));
        assertEquals(new Rational(2, 1), new Rational(6, 3));
        assertEquals(new Rational(8, 6), new Rational(4, 3));

        assertNotEquals(new Rational(1, 2), new Rational(3, 4));
        assertNotEquals(new Rational(3, 3), new Rational(1, 8));
        assertNotEquals(new Rational(9, 3), new Rational(6, 5));
        assertNotEquals(new Rational(6, 4), new Rational(4, 6));
        assertNotEquals(new Rational(1, 8), new Rational(4, 4));
        assertNotEquals(new Rational(3, 5), new Rational(9, 5));
        assertNotEquals(new Rational(6, 9), new Rational(1, 6));
        assertNotEquals(new Rational(4, 2), new Rational(2, 4));
    }

    @Test
    void testHashCode() {
        assertEquals(new Rational(17, 16).hashCode(), new Rational(17, 16).hashCode());
        assertEquals(new Rational(5, 15).hashCode(), new Rational(3, 9).hashCode());
        assertEquals(new Rational(5, 12).hashCode(), new Rational(5, 12).hashCode());
        assertEquals(new Rational(2, 12).hashCode(), new Rational(3, 18).hashCode());
        assertEquals(new Rational(17, 3).hashCode(), new Rational(17, 3).hashCode());
        assertEquals(new Rational(11, 4).hashCode(), new Rational(11, 4).hashCode());
        assertEquals(new Rational(11, 1).hashCode(), new Rational(11, 1).hashCode());
        assertEquals(new Rational(2, 16).hashCode(), new Rational(2, 16).hashCode());
        assertEquals(new Rational(6, 6).hashCode(), new Rational(9, 9).hashCode());
        assertEquals(new Rational(14, 2).hashCode(), new Rational(7, 1).hashCode());

        assertNotEquals(new Rational(16, 5).hashCode(), new Rational(15, 10).hashCode());
        assertNotEquals(new Rational(5, 3).hashCode(), new Rational(14, 16).hashCode());
        assertNotEquals(new Rational(4, 11).hashCode(), new Rational(8, 14).hashCode());
        assertNotEquals(new Rational(1, 10).hashCode(), new Rational(17, 4).hashCode());
        assertNotEquals(new Rational(18, 18).hashCode(), new Rational(5, 18).hashCode());
        assertNotEquals(new Rational(9, 11).hashCode(), new Rational(18, 13).hashCode());
        assertNotEquals(new Rational(18, 16).hashCode(), new Rational(7, 8).hashCode());
        assertNotEquals(new Rational(6, 4).hashCode(), new Rational(1, 19).hashCode());
        assertNotEquals(new Rational(10, 14).hashCode(), new Rational(2, 7).hashCode());
    }
}
