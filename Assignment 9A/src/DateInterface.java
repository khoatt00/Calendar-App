/**
 * Created by sedward3 on 10/11/2016.
 *
 * This Java interface fully describes the Date class ("public" API)
 */

public interface DateInterface {

    // Private variables are not allowed in "interfaces"
    //  private int month;
    //  private int day;
    //  private int year;

    /////////////////////////////////////////////////////////////////////////////////////////////
    // Below are constants to be used by calling functions (as nedded)
    /////////////////////////////////////////////////////////////////////////////////////////////

    public static final int     FEBRUARY            =   2;

    public static final int     DEFAULT_MONTH       =   0;      // Used to set month upon set request of invalid value
    public static final int     DEFAULT_DAY         =   0;      //  same/similiar
    public static final int     DEFAULT_YEAR        =   0;      //  same/similiar

    public  static final int    MIN_VALID_MONTH    =   1;
    public  static final int    MAX_VALID_MONTH    =   12;

    public  static final int    MIN_VALID_DAY      =   1;
    public  static final int    MAX_VALID_DAY      =   31;         // Needs to be coordinated with month/year..

    public  static final int    MIN_VALID_YEAR     =   1700;
    public  static final int    MAX_VALID_YEAR     =   2600;

    public  static final int    MIN_DELTA_MONTH   =    -18;
    public  static final int    MAX_DELTA_MONTH   =    +18;
    public  static final int    MIN_DELTA_DAY     =   -100;
    public  static final int    MAX_DELTA_DAY     =   +100;
    public  static final int    MIN_DELTA_YEAR    =    -24;
    public  static final int    MAX_DELTA_YEAR    =    +24;

    // Default string constants for invalid dates
    public static final String  INVALID_DATE_STRING_FMT_MMDDYY      =   "00/00/00";         ///	"09/01/16"
    public static final String  INVALID_DATE_STRING_FMT_MMDDYYYY    =   "00/00/0000";       //	"09/01/2016"
    public static final String  INVALID_DATE_STRING_FMT_MondDYYYY   =   "INV 0, 0000";      //  "Sept 1, 2016"





    // Define the Date Format types.  W/in Date class, use "DateInterface.FMT_xxx" to specify
    public enum DateFormat {
        FMT_MMDDYY,     //	"09/01/16"
        FMT_MMDDYYYY,   //	"09/01/2016"
        FMT_MondDYYYY,  //	:Sept 1, 2016"	(Common 3 or 4 character month names)

        NUM_FMT_VALUES  //  Number of previous entries

    }   //  end enum DateFormat


    public enum DayOfWeek {
        SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, NotValidDayOfWeek;
    }




    /////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    /////////////////////////////////////////////////////////////////////////////////////////////

    //  Reuired Constructors (but not allowed in "interface" file)
    //public Date();
    //public Date (Date from);
    //public Date (int month, int day, int year);


    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////
    // Class member functions
    //  Boolean return:  True: success, False: unsuccessful
    /////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Following validateXXX() routines:  Check value appropriately and return result.  Do NOT update internal
    //      corresponding variable.
    /////////////////////////////////////////////////////////////////////////////////////////////

    public  boolean     validateMonth();
    public  boolean     validateMonth(int month);

    public  boolean     validateDay();
    public  boolean     validateDay(int day);

    public  boolean     validateYear();
    public  boolean     validateYear(int year);

    public  boolean     validateDate();
    public  boolean     validateDate(int month, int day, int year);


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Following setXXX() routines:  Validate value(s) appropriately.
    //   If valid, store value(s).  if !valid, set value(s) to default value;
    /////////////////////////////////////////////////////////////////////////////////////////////

    public  boolean     setMonth(int month);

    public  boolean     setDay(int day);

    public  boolean     setYear(int year);

    public  boolean     setDate (int month, int day, int year);


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Following getXXX() routines return appropiate stored/current values
    /////////////////////////////////////////////////////////////////////////////////////////////

    public  int         getMonth();

    public  int         getDay();

    public  int         getYear();



    public  String      getMonthName(int month);

    public  String      getFormattedDate(DateFormat dateFormat);


    public  boolean     isLeapYear();
    public  boolean     isLeapYear(int year);

    public  int         getNumberDaysInMonth();


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Routines to update/manipulate dates
    /////////////////////////////////////////////////////////////////////////////////////////////

    public  boolean     addToYear(int deltaYear);

    public  boolean     addToMonth(int deltaMonth);

    public  boolean     addToDay(int deltaDay);

    public  boolean     addToDate(int deltaMonth, int deltaDay, int deltaYear);


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Routines to return days of week
    /////////////////////////////////////////////////////////////////////////////////////////////

    public  DayOfWeek   getDayOfWeek();
    public  DayOfWeek   getDayOfWeek(int month, int day, int year);              // Don't update internal variables
//    public  DayOfWeek   getDayOfWeek(Date date);                                 // Don't update internal variables

    public  DayOfWeek   getMonthsFirstDayOfWeek();
    public  DayOfWeek   getMonthsFirstDayOfWeek(int month, int day, int year);   // Don't update internal variables
//    public  DayOfWeek   getMonthsFirstDayOfWeek(Date date);                      // Don't update internal variables


    /////////////////////////////////////////////////////////////////////////////////////////////
    // 2016-10-26 DateInterface.java Updates
    /////////////////////////////////////////////////////////////////////////////////////////////

    // 1) Add code to initialize Date.signature to DATE_SIGNATURE in constructors

    //  public int signature;              // make public for external testing purposes

    public static final int     DATE_SIGNATURE      =   0x55AA5aa5;

    // 2) Add code to validate valid class instance before access variables (e.g., check for null)  You can use "assertNotNull(this);"

    // 3) Add code to validate signature valid before setting any value - use assertEquals()

    // 4) Add code to validate signature valid before getting any value - use assertEquals()

    // 5) Add following comparison routines.  return follows:
    //      '-1' if this' date is less than parameter's date
    //      '0' if this' date is equal to parameter's date
    //      '+1' if this' date is greater than parameter's date

    public int compareTo(int month, int day, int year);
    public int compareTo(Date date);


    // 6) Add additional overloads to existing functions
    public  DayOfWeek   getDayOfWeek(Date date);                                 // Don't update internal variables
    public  DayOfWeek   getMonthsFirstDayOfWeek(Date date);                      // Don't update internal variables



}   //  end class DateInterface