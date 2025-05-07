package sit707_tasks;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateUtilTest {

    // === Student Identity Tests ===

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

    // === VALID EQUIVALENCE CLASS TESTS ===

    @Test
    public void testValidSameMonthAddition() {
        DateUtil date = new DateUtil(10, 5, 2023);
        DateUtil result = date.calculateFutureDate(5);
        assertEquals("15 May 2023", result.toString());
    }

    @Test
    public void testValidMonthBoundary() {
        DateUtil date = new DateUtil(30, 4, 2023);
        DateUtil result = date.calculateFutureDate(1);
        assertEquals("1 May 2023", result.toString());
    }

    @Test
    public void testLeapYearHandling() {
        DateUtil date = new DateUtil(28, 2, 2024);
        DateUtil result = date.calculateFutureDate(1);
        assertEquals("29 February 2024", result.toString());
    }

    @Test
    public void testYearBoundary() {
        DateUtil date = new DateUtil(31, 12, 2023);
        DateUtil result = date.calculateFutureDate(1);
        assertEquals("1 January 2024", result.toString());
    }

    @Test
    public void testNegativeDayCalculation() {
        DateUtil date = new DateUtil(1, 3, 2023);
        DateUtil result = date.calculateFutureDate(-1);
        assertEquals("28 February 2023", result.toString());
    }

    @Test
    public void testLongTermFutureDate() {
        DateUtil date = new DateUtil(1, 1, 2023);
        DateUtil result = date.calculateFutureDate(365);
        assertEquals("1 January 2024", result.toString());
    }

    // === INVALID INPUT TESTS ===

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayInApril() {
        new DateUtil(31, 4, 2023);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidFutureYear() {
        new DateUtil(15, 5, 2025);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidPastYear() {
        new DateUtil(15, 5, 1699);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidDayZero() {
        new DateUtil(0, 1, 2020);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidMonth13() {
        new DateUtil(15, 13, 2020);
    }

    // === BOUNDARY VALUE ANALYSIS ===

    @Test
    public void testMinDayBoundary() {
        DateUtil date = new DateUtil(1, 1, 2023);
        DateUtil result = date.calculateFutureDate(1);
        assertEquals("2 January 2023", result.toString());
    }

    @Test
    public void testMaxDayBoundary() {
        DateUtil date = new DateUtil(31, 1, 2023);
        DateUtil result = date.calculateFutureDate(1);
        assertEquals("1 February 2023", result.toString());
    }

    @Test
    public void testMinYearBoundary() {
        DateUtil date = new DateUtil(1, 1, 1700);
        DateUtil result = date.calculateFutureDate(1);
        assertEquals("2 January 1700", result.toString());
    }

    @Test
    public void testMaxYearBoundary() {
        DateUtil date = new DateUtil(31, 12, 2024);
        DateUtil result = date.calculateFutureDate(-1);
        assertEquals("30 December 2024", result.toString());
    }
}
