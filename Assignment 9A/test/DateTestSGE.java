        /**
        * Created by sedward3 on 9/22/2016.
        *
        * Scott G. Edwards
        * CPT 236 Java
        * TDD File for Date class as specified by Assignment #4 & #6
        */




        import org.junit.Test;

        import static org.junit.Assert.*;

public class DateTestSGE {

    // Helper function to check to see if current date w/in class is same as parameterized date
    private boolean verifyDateIsSetTo(Date date, int month, int day, int year ) {
        return ((month == date.getMonth()) && (day == date.getDay()) && (year == date.getYear()));
    }   //  end verifyDateIsSetTo()



    @Test
    public void TestDateConstructorDefault() {

        Date    date    =   new Date();

        assertTrue ( verifyDateIsSetTo(date, 0, 0, 0) );

    }   //  end  TestDateConstructorDefault()


    @Test
    public void TestDateConstructorWithValues() {

        Date    date    =   new Date(9, 1, 2016);
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2016) );

        Date    date2   =   new Date(5, 4, 2001);
        assertTrue ( verifyDateIsSetTo(date2, 5, 4, 2001) );

        Date    date3   =   new Date(5, 0, 2001);
        assertTrue ( verifyDateIsSetTo(date3, 0, 0, 0) );

    }   //  end  TestDateConstructorWithValues()


    @Test
    public void TestDateConstructorCopy() {

        Date    date    =   new Date(9, 1, 2016);
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2016) );

        Date    date2   =   new Date(date);
        assertTrue ( verifyDateIsSetTo(date2, 9, 1, 2016) );

        Date    date3   =   new Date(5, 4, 2001);
        assertTrue ( verifyDateIsSetTo(date3, 5, 4, 2001) );

        Date    date4    =   new Date(date3);
        assertTrue ( verifyDateIsSetTo(date4, 5, 4, 2001) );

    }   //  end  TestDateConstructorCopy()


    @Test
    public void TestSetMonth() {
        int     month;
        Date    date    =   new Date(9, 1, 2016);
        assertEquals( date.getMonth(), 9);

        assertTrue ( date.setMonth( (month = 12) ) );
        assertEquals( month,    date.getMonth() );
        assertTrue ( date.setMonth( (month = 6) ) );
        assertEquals( month,    date.getMonth() );
        assertTrue ( date.setMonth( (month = 1) ) );
        assertEquals( month,    date.getMonth() );
        assertFalse (  date.setMonth( (month = (Date.MIN_VALID_MONTH-1) ) ) );
        assertEquals( 0,        date.getMonth() );      // month set to 0 w/ invalid value
        assertFalse ( date.setMonth( (month = (Date.MAX_VALID_MONTH+1) ) ));
        assertEquals( 0,        date.getMonth() );      // month set to 0 w/ invalid value

    }   //  end TestSetMonth()


    @Test
    public void TestSetDay() {
        int     day;
        Date    date    =   new Date(9, 1, 2016);
        assertEquals( date.getDay(), 1);       // Note - max day will depend on month/year selected!

        assertTrue ( date.setDay( (day = 30) ) );
        assertEquals( day,      date.getDay() );
        assertTrue ( date.setDay( (day = 30) ) );
        assertEquals( day,      date.getDay() );
        assertTrue ( date.setDay( (day = 30) ) );
        assertEquals( day,      date.getDay() );
        assertFalse ( date.setDay( (day = Date.MIN_VALID_DAY-1) ) );
        assertEquals( 0,        date.getDay() );      // Day set to 0  w/ invalid value
        assertFalse ( date.setDay( (day = Date.MAX_VALID_DAY + 1) ) );   //  date.getNumberDaysInMonth()+1) );
        assertEquals( 0,        date.getDay() );      // Day set to 0  w/ invalid value

    }   //  end TestSetDay()


    @Test
    public void TestSetYear() {
        int     year;
        Date    date    =   new Date(9, 1, 2016);
        assertEquals( date.getYear(), 2016);       // Note - max Year will depend on month/year selected!

        assertTrue ( date.setYear( (year = 2000) ) );
        assertEquals( year,     date.getYear() );
        assertTrue ( date.setYear( (year = 2015) ) );
        assertEquals( year,     date.getYear() );
        assertTrue ( date.setYear( (year = 2020) ) );
        assertEquals( year,     date.getYear() );
        assertFalse ( date.setYear( (year = (Date.MIN_VALID_YEAR-1) ) ) );
        assertEquals( 0,        date.getYear() );      // Year set to 0 w/ invalid value
        assertFalse ( date.setYear( (year = (Date.MAX_VALID_YEAR+1) ) ) );
        assertEquals( 0,        date.getYear() );      // Year set to 0 w/ invalid value

    }   //  end TestSetYear()


    @Test
    public void TestSetDate() {

        TestSetMonth();     // Make sure that date.setMonth() works
        TestSetDay();       // Make sure that date.setDay() works
        TestSetYear();      // Make sure that date.setYear() works

        Date date = new Date();
        assertTrue(verifyDateIsSetTo(date, 0, 0, 0));

        assertFalse(date.setDate(1, 0, 0));
        assertTrue(verifyDateIsSetTo(date, 0, 0, 0));

        assertFalse(date.setDate(0, 1, 0));
        assertTrue(verifyDateIsSetTo(date, 0, 0, 0));

        assertFalse(date.setDate(0, 0, 1));
        assertTrue(verifyDateIsSetTo(date, 0, 0, 0));

        assertFalse(date.setDate(0, 0, 1));
        assertTrue(verifyDateIsSetTo(date, 0, 0, 0));

        assertTrue(date.setDate(1, 1, 2016));
        assertTrue(verifyDateIsSetTo(date, 1, 1, 2016));

        assertTrue(date.setDate(12, 31, 2010));
        assertTrue(verifyDateIsSetTo(date, 12, 31, 2010));

    }   //  end TestSetDate()


    @Test
    public void TestValidateDate() {
        Date    date    =   new Date();

        assertFalse( date.validateDate() );     // All vars are invalid ==> invalid date

        assertTrue( date.setMonth(1) );
        assertFalse( date.validateDate() );     // Only month valid ==> invalid date

        assertTrue( date.setDay(1) );
        assertFalse( date.validateDate() );      // Month & Day valid ==> invalid date

        assertTrue( date.setYear(2016) );         // Month & Day & Year valid
        assertTrue( date.validateDate() );     // So should be valid date now

    }   //  end TestValidateDate()


    @Test
    public void TestGetFormattedDate() {
        Date    date    =   new Date();

        assertEquals( Date.INVALID_DATE_STRING_FMT_MMDDYY,      date.getFormattedDate(Date.DateFormat.FMT_MMDDYY) );
        assertEquals( Date.INVALID_DATE_STRING_FMT_MMDDYYYY,    date.getFormattedDate(Date.DateFormat.FMT_MMDDYYYY) );
        assertEquals( Date.INVALID_DATE_STRING_FMT_MondDYYYY,   date.getFormattedDate(Date.DateFormat.FMT_MondDYYYY) );

        assertTrue( date.setDate(9, 1, 2016) );
        assertEquals( "09/01/16",                               date.getFormattedDate(Date.DateFormat.FMT_MMDDYY) );
        assertEquals( "09/01/2016",                             date.getFormattedDate(Date.DateFormat.FMT_MMDDYYYY) );
        assertEquals( ( date.getMonthName(9) + " 1, 2016" ),    date.getFormattedDate(Date.DateFormat.FMT_MondDYYYY) );

        assertTrue( date.setDate(12, 30, 2016) );
        assertEquals( "12/30/16",                               date.getFormattedDate(Date.DateFormat.FMT_MMDDYY) );
        assertEquals( "12/30/2016",                             date.getFormattedDate(Date.DateFormat.FMT_MMDDYYYY) );
        assertEquals( ( date.getMonthName(12) + " 30, 2016" ),  date.getFormattedDate(Date.DateFormat.FMT_MondDYYYY) );

        for (int mon=1; mon<=12; mon++) {
            String  compareDateStr  =   date.getMonthName(mon) + " 15, 2016";
            assertTrue( date.setDate(mon, 15, 2016) );
            assertEquals( compareDateStr,                       date.getFormattedDate(Date.DateFormat.FMT_MondDYYYY) );
        }   //  end for (mon)

    }   //  end TestGetFormattedDate()


    private boolean TestLeapYearStatus(Date date, int year, boolean expectedResult) {

        if ( !date.setYear(year) )
            return (false);

        boolean calcResult  =   date.isLeapYear();

//--        System.out.println("Year: " + year + "  CalcLeapYear: " + calcResult + "  ExpectedResult: " + expectedResult);

        return ( calcResult == expectedResult );

    }   //  end TestLeapYearStatus)


    // Define arrays of years to check for Leap Years (gently borrowed from Microsoft URL listed below)
    private static int years1[] = {1988, 1992, 1996};                                   // Leap years
    private static int years2[] = {1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600};     // Not Leap years
    private static int years3[] = {1988, 1992, 1996};                                   // Leap years


    @Test
    public void TestIsLeapYear() {
        Date    invalid =   new Date();
        assertFalse( invalid.isLeapYear() );        // Check for invalid date not being a leap year

        Date    date    =   new Date(9, 1, 2016);
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2016) );

        assertTrue( TestLeapYearStatus(date, 1997, false) );         // 1997 is not a leap year
        assertTrue( TestLeapYearStatus(date, 2012, true ) );         // 2012 is a leap year
        assertTrue( TestLeapYearStatus(date, 2000, true ) );         // 2000 is a leap year
        assertTrue( TestLeapYearStatus(date, 1900, false) );         // 1990 is not a leap year


        // Reference:  https://support.microsoft.com/en-us/kb/214019

        // Any year that is evenly divisible by 4 is a leap year: for example, 1988, 1992, and 1996 are leap years.
        for (int y1 : years1) {
            assertTrue( TestLeapYearStatus(date, y1, true ) );
        }

        // Not Leap years because they are evenly divisible by 100 but not by 400.
        //      1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600
        for (int y2 : years2) {
            assertTrue( TestLeapYearStatus(date, y2, false ) );
        }

        //  The following years are leap years (because they are evenly divisible by both 100 and 400.):
        //  1600, 2000, 2400
        for (int y3 : years3) {
            assertTrue( TestLeapYearStatus(date, y3, true  ) );
        }

    }   //  end TestIsLeapYear()

    // Following array is to do sanity check on Date class' number of days
    //----------------------------------------------Jan Feb Mar Apr May Jun Jul Aug Sep Oct Nov Dec
    private static int NUMBER_DAYS_IN_MONTH[] = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    private static int FEBRUARY = 2;

    @Test
    public void TestGetNumberDaysInMonth() {
        // Before anything else, make sure that LeapYear is working.
        TestIsLeapYear();       // do above test to ensure leap year is working

        Date    date    =   new Date(9, 1, years2[0]);      // Set year to non-leap year.
        assertTrue ( verifyDateIsSetTo(date, 9, 1, years2[0]) );

        for (int mon = 1; mon<=12; mon++) {         // Not leap year
            assertTrue( date.setMonth(mon) );
            assertEquals( NUMBER_DAYS_IN_MONTH[mon],    date.getNumberDaysInMonth() );

        }   //  for (mon)

        assertTrue( date.setYear( years1[0] ) );    // Set for a known/documented leap year
        for (int mon2 = 1; mon2<=12; mon2++) {
            assertTrue( date.setMonth(mon2) );
            int expected    =   NUMBER_DAYS_IN_MONTH[mon2];     // Leap Year entry from above
            if ( ( mon2 == FEBRUARY ) && date.isLeapYear() )
                expected++;
            assertEquals( expected,    date.getNumberDaysInMonth() );

        }   //  for (mon2)

    }   //  end TestGetNumberDaysInMonth()


    @Test
    public void TestAddToYear() {

        Date    date    =   new Date(9, 1, 2015);
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2015) );

        assertFalse ( date.addToYear( Date.MIN_DELTA_YEAR-1 ) );
        assertFalse ( date.addToYear( Date.MAX_DELTA_YEAR+1 ) );

        assertTrue ( date.addToYear(1) );
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2016) );

        assertTrue ( date.addToYear(10) );
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2026) );

        assertTrue ( date.addToYear(-10) );
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2016) );

        assertTrue ( date.addToYear(-1) );
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2015) );

    }   //  end TestAddToYear()

    @Test
    public void TestAddToMonth() {

        Date    date    =   new Date(9, 1, 2015);
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2015) );

        assertFalse ( date.addToMonth( Date.MIN_DELTA_MONTH-1 ) );
        assertFalse ( date.addToMonth( Date.MAX_DELTA_MONTH+1 ) );

        assertTrue ( date.addToMonth(1) );
        assertTrue ( verifyDateIsSetTo(date, 10, 1, 2015) );

        assertTrue ( date.addToMonth(2) );
        assertTrue ( verifyDateIsSetTo(date, 12, 1, 2015) );

        assertTrue ( date.addToMonth(1) );
        assertTrue ( verifyDateIsSetTo(date, 1, 1, 2016) );

        assertTrue ( date.addToMonth(12) );
        assertTrue ( verifyDateIsSetTo(date, 1, 1, 2017) );

        assertTrue ( date.addToMonth(-12) );
        assertTrue ( verifyDateIsSetTo(date, 1, 1, 2016) );

        assertTrue ( date.addToMonth(-1) );
        assertTrue ( verifyDateIsSetTo(date, 12, 1, 2015) );


    }   //  end TestAddToMonth()


    @Test
    public void TestAddToDay() {

        Date    date    =   new Date(9, 1, 2015);
        assertTrue ( verifyDateIsSetTo(date, 9, 1, 2015) );

        assertFalse ( date.addToMonth( Date.MIN_DELTA_DAY-1 ) );
        assertFalse ( date.addToMonth( Date.MAX_DELTA_DAY+1 ) );

        assertTrue ( date.addToDay(1) );
        assertTrue ( verifyDateIsSetTo(date, 9, 2, 2015) );

        assertTrue ( date.addToDay(2) );
        assertTrue ( verifyDateIsSetTo(date, 9, 4, 2015) );

        assertTrue ( date.addToDay(1) );
        assertTrue ( verifyDateIsSetTo(date, 9, 5, 2015) );

        assertTrue ( date.addToDay(12) );
        assertTrue ( verifyDateIsSetTo(date, 9, 17, 2015) );

        assertTrue ( date.addToDay(-12) );
        assertTrue ( verifyDateIsSetTo(date, 9, 5, 2015) );

        assertTrue ( date.addToDay(-1) );
        assertTrue ( verifyDateIsSetTo(date, 9, 4, 2015) );


        //  Many, Many, Many more tests to be provided.  Have to test the edge cases!

    }   //  end TestAddToDay()



}   //  end class DateTestSGE