package sit707_tasks;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateUtilTest {

    // Identity Tests
    @Test
    public void testStudentIdentity() {
        String studentId = "s223796895";
        assertNotNull("Student ID is null", studentId);
    }

    @Test
    public void testStudentName() {
        String studentName = "Sireesha Akurathi";
        assertNotNull("Student name is null", studentName);
    }

    // === VALID EQUIVALENCE CLASSES ===

    // Day: 1-28 (D1), Month: Jan (M2), Year: 2023 (Y2)
    @Test
    public void testValidDay28_NonLeapYear() {
        DateUtil date = new DateUtil(28, 1, 2023);
        date.increment();
        assertEquals("29 January 2023", date.toString());
    }

    // Day: 29 (D2), Month: Feb (M3), Year: 2024 (Y1 - Leap)
    @Test
    public void testLeapYearFeb29() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        assertEquals("1 March 2024", date.toString());
    }

    // Day: 30 (D3), Month: Apr (M1), Year: 2022 (Y2)
    @Test
    public void testApril30toMay1() {
        DateUtil date = new DateUtil(30, 4, 2022);
        date.increment();
        assertEquals("1 May 2022", date.toString());
    }

    // Day: 31 (D4), Month: Dec (M2), Year: 2023 (Y2)
    @Test
    public void testDec31toJan1() {
        DateUtil date = new DateUtil(31, 12, 2023);
        date.increment();
        assertEquals("1 January 2024", date.toString());
    }

    // Decrement on 1 March (Non-leap year)
    @Test
    public void testDecrementToFeb28_NonLeap() {
        DateUtil date = new DateUtil(1, 3, 2023);
        date.decrement();
        assertEquals("28 February 2023", date.toString());
    }

    // Decrement on 1 March (Leap year)
    @Test
    public void testDecrementToFeb29_Leap() {
        DateUtil date = new DateUtil(1, 3, 2024);
        date.decrement();
        assertEquals("29 February 2024", date.toString());
    }

    // === INVALID CASES ===

    // Day 31 in April (Invalid day)
    @Test(expected = RuntimeException.class)
    public void testInvalidDayInApril() {
        new DateUtil(31, 4, 2023);
    }

    // Year > 2024 (Invalid)
    @Test(expected = RuntimeException.class)
    public void testInvalidFutureYear() {
        new DateUtil(15, 5, 2025);
    }

    // Year < 1700 (Invalid)
    @Test(expected = RuntimeException.class)
    public void testInvalidPastYear() {
        new DateUtil(15, 5, 1699);
    }

    // Day = 0 (Invalid)
    @Test(expected = RuntimeException.class)
    public void testInvalidDayZero() {
        new DateUtil(0, 1, 2020);
    }

    // Month = 13 (Invalid)
    @Test(expected = RuntimeException.class)
    public void testInvalidMonth13() {
        new DateUtil(15, 13, 2020);
    }
}
