import org.junit.Test;

import static org.junit.Assert.*;

/* 	Programmer: 		Michael A Gardner
 * 	Class:				CPT - 236-001
 *	Date:				24 October 2016
 *	Assignment: 		Assignment 8B
 */
public class DateTest {
    @Test
    public void getMonthName() throws Exception {
        Date dateClass     =   new Date();
        assertEquals("Jan", dateClass.getMonthName(1));
        assertEquals("Mar", dateClass.getMonthName(3));
        assertEquals("July", dateClass.getMonthName(7));
        assertEquals("Sept", dateClass.getMonthName(9));
        assertEquals("Dec", dateClass.getMonthName(12));
    }

    @Test
    public void getFormattedDate() throws Exception {
        Date dateClass     =   new Date(9,19,2016);
        assertEquals("09/19/16", dateClass.getFormattedDate(Date.DateFormat.FMT_MMDDYY));
        assertEquals("09/19/2016", dateClass.getFormattedDate(Date.DateFormat.FMT_MMDDYYYY));
        assertEquals("Sept 19, 2016", dateClass.getFormattedDate(Date.DateFormat.FMT_MondDYYYY));
    }

    @Test
    public void validateMonth() throws Exception {
        Date dateClass     =   new Date();
        assertFalse(dateClass.validateMonth(-1));
        assertFalse(dateClass.validateMonth(0));
        assertFalse(dateClass.validateMonth(13));
        assertTrue(dateClass.validateMonth(1));
        assertTrue(dateClass.validateMonth(3));
        assertTrue(dateClass.validateMonth(7));
        assertTrue(dateClass.validateMonth(12));
    }



    @Test
    public void setMonth() throws Exception {
        Date dateClass     =   new Date();
        assertFalse(dateClass.setMonth(-1));
        assertFalse(dateClass.setMonth(0));
        assertFalse(dateClass.setMonth(13));
        assertTrue(dateClass.setMonth(1));
        assertTrue(dateClass.setMonth(3));
        assertTrue(dateClass.setMonth(7));
        assertTrue(dateClass.setMonth(12));
    }

    @Test
    public void getMonth() throws Exception {
        Date dateClass     =   new Date(9,19,2016);
        assertEquals(9,dateClass.getMonth());
        dateClass.setMonth(12);
        assertEquals(12,dateClass.getMonth());
        dateClass.setMonth(13);
        assertEquals(0,dateClass.getMonth());
    }

    @Test
    public void validateDay() throws Exception {
        Date dateClass     =   new Date();
        assertFalse(dateClass.validateDay(-1));
        assertFalse(dateClass.validateDay(31));
        assertFalse(dateClass.validateDay(0));
        assertTrue(dateClass.validateDay(1));
        assertTrue(dateClass.validateDay(5));
        assertTrue(dateClass.validateDay(12));
        assertTrue(dateClass.validateDay(18));
        assertTrue(dateClass.validateDay(30));
    }

    @Test
    public void setDay() throws Exception {
        Date dateClass     =   new Date();
        assertFalse(dateClass.setDay(-1));
        assertFalse(dateClass.setDay(31));
        assertFalse(dateClass.setDay(0));
        assertTrue(dateClass.setDay(1));
        assertTrue(dateClass.setDay(5));
        assertTrue(dateClass.setDay(12));
        assertTrue(dateClass.setDay(18));
        assertTrue(dateClass.setDay(30));
    }

    @Test
    public void getDay() throws Exception {
        Date dateClass     =   new Date(9,19,2016);
        assertEquals(19,dateClass.getDay());
        dateClass.setDay(30);
        assertEquals(30,dateClass.getDay());
        dateClass.setDay(50);
        assertEquals(0,dateClass.getDay());
    }

    @Test
    public void validateYear() throws Exception {
        Date dateClass     =   new Date();
        assertFalse(dateClass.validateYear(-1));
        assertFalse(dateClass.validateYear(1999));
        assertFalse(dateClass.validateYear(2026));
        assertTrue(dateClass.validateYear(2000));
        assertTrue(dateClass.validateYear(2016));
        assertTrue(dateClass.validateYear(2025));
    }

    @Test
    public void setYear() throws Exception {
        Date dateClass     =   new Date();
        assertFalse(dateClass.setYear(-1));
        assertFalse(dateClass.setYear(1999));
        assertFalse(dateClass.setYear(2026));
        assertTrue(dateClass.setYear(2000));
        assertTrue(dateClass.setYear(2016));
        assertTrue(dateClass.setYear(2025));
    }

    @Test
    public void getYear() throws Exception {
        Date dateClass     =   new Date(9,19,2016);
        assertEquals(2016,dateClass.getYear());
        dateClass.setYear(2025);
        assertEquals(2025,dateClass.getYear());
        dateClass.setYear(2026);
        assertEquals(0,dateClass.getYear());
    }


    @Test
    public void setDate() throws Exception {
        Date dateClass     =   new Date();
        assertEquals(0,dateClass.getMonth());
        assertFalse(dateClass.setDate(55,19,2016));
        assertTrue(dateClass.setDate(9,19,2016));

    }

    public DateTest() {}
    @Test
    public void isLeapYear() throws Exception {
        Date dateClass     =   new Date();

    }
    @Test
    public void addToMonth() throws Exception {
        Date dateClass     =   new Date(9,19,2016);
        assertTrue(dateClass.addToMonth(18));
        assertTrue(dateClass.addToMonth(-18));
        assertTrue(dateClass.addToMonth(10));
        assertTrue(dateClass.addToMonth(15));
        assertFalse(dateClass.addToMonth(-19));
        assertFalse(dateClass.addToMonth(19));
        assertFalse(dateClass.addToMonth(2000));
    }
    @Test
    public void addToDay() throws Exception {
        Date dateClass     =   new Date(9,19,2016);
        assertTrue(dateClass.addToDay(100));
        assertTrue(dateClass.addToDay(50));
        assertTrue(dateClass.addToDay(30));
        assertTrue(dateClass.addToDay(10));
        assertFalse(dateClass.addToDay(-101));
        assertFalse(dateClass.addToDay(101));
        assertFalse(dateClass.addToDay(2000));
    }
    @Test
    public void addToYear() throws Exception {
        Date dateClass     =   new Date(9,19,2016);
        assertTrue(dateClass.addToYear(24));
        assertTrue(dateClass.addToYear(-24));
        assertTrue(dateClass.addToYear(10));
        assertTrue(dateClass.addToYear(1));
        assertFalse(dateClass.addToYear(-25));
        assertFalse(dateClass.addToYear(25));
        assertFalse(dateClass.addToYear(265888));



    }

} // DateClassTest
