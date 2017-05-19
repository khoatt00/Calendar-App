/**
 * Created by sedward3 on 10/11/2016.
 *
 * This Java interface fully describes the Time class ("public" API)

 */
public interface TimeInterface {

    // Private variables are not allowed in "interfaces"
    //private int hours;                  //  b
    //private int minutes;                //  0..59
    //private int seconds;                //  0..59

    public  static final int MIN_VALID_HOUR     =   0;
    public  static final int MAX_VALID_HOUR     =   23;

    public  static final int MIN_VALID_MINUTE   =   0;
    public  static final int MAX_VALID_MINUTE   =   59;

    public  static final int MIN_VALID_SECOND   =   0;
    public  static final int MAX_VALID_SECOND   =   59;

    public  static final int    DEFAULT_HOUR    =   MIN_VALID_HOUR;
    public  static final int    DEFAULT_MINUTE  =   MIN_VALID_MINUTE;
    public  static final int    DEFAULT_SECOND  =   MIN_VALID_SECOND;

    //------public  static final int MIN_VALID_DELTA    =   -100;   //-- removed (duplicate)
    //------public  static final int MAX_VALID_DELTA    =   +100;   //-- removed (duplicate)

    public  static final int MIN_DELTA_VALUE    =   -100;
    public  static final int MAX_DELTA_VALUE    =   +100;

    public static final int MIN_DELTA_HOURS     =   MIN_DELTA_VALUE;
    public static final int MAX_DELTA_HOURS     =   MAX_DELTA_VALUE;

    public static final int MIN_DELTA_MINUTES   =   MIN_DELTA_VALUE;
    public static final int MAX_DELTA_MINUTES   =   MAX_DELTA_VALUE;

    public static final int MIN_DELTA_SECONDS   =   MIN_DELTA_VALUE;
    public static final int MAX_DELTA_SECONDS   =   MAX_DELTA_VALUE;




    /////////////////////////////////////////////////////////////////////////////////////////////
    // Constructors
    /////////////////////////////////////////////////////////////////////////////////////////////

    //  Reuired Constructors (but not allowed in "interface" file)
    //public Time();
    //public Time(int hr, int min, int sec);
    //public Time(Time time);


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Following validateXXX() routines:  Check value appropriately and return result.  Do NOT update internal
    //      corresponding variable.
    /////////////////////////////////////////////////////////////////////////////////////////////

    public  boolean     validateHour();
    public  boolean     validateHour(int hour);

    public  boolean     validateMinute();
    public  boolean     validateMinute(int mins);

    public  boolean     validateSecond();
    public  boolean     validateSecond(int secs);

    public  boolean     validateTime();
    public  boolean     validateTime(int hr, int min, int sec);


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Following setXXX() routines:  Validate value(s) appropriately.
    //   If valid, store value(s).  if !valid, set value(s) to default value;
    /////////////////////////////////////////////////////////////////////////////////////////////

    public boolean      setHour(int hours);

    public boolean      setMinute(int minutes);

    public boolean      setSecond(int seconds);

    public boolean      setTime(int hr, int min, int sec);


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Following getXXX() routines return appropiate stored/current values
    /////////////////////////////////////////////////////////////////////////////////////////////

    public int          getHour();

    public int          getMinute();

    public int          getSecond();


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Return a Time class starting from current values and then updated by
    //    the current values as specified by "delta" values
    /////////////////////////////////////////////////////////////////////////////////////////////

    public Time         calcDeltaTime(int deltaH, int deltaM, int deltaS);


    /////////////////////////////////////////////////////////////////////////////////////////////
    //  Update the current values with indicated deltas.  Invalid delta values cause no changes
    /////////////////////////////////////////////////////////////////////////////////////////////

    public boolean      updateSeconds(int deltaS);

    public boolean      updateMinutes(int deltaM);

    public boolean      updateHours(int deltaH);

    public boolean      updateTime(int deltaH, int deltaM, int deltaS);




    /////////////////////////////////////////////////////////////////////////////////////////////
    // 2016-10-26 TimeInterface.java Updates
    /////////////////////////////////////////////////////////////////////////////////////////////

    // 1) Add code to initialize Time.signature to TIME_SIGNATURE in constructors

    //  public int signature;              // make public for external testing purposes

    public static final int     TIME_SIGNATURE      =   0xAA5aa555;

    // 2) Add code to validate valid class instance before access variables (e.g., check for null)  You can use "assertNotNull(this);"

    // 3) Add code to validate signature valid before setting any value - use assertEquals()

    // 4) Add code to validate signature valid before getting any value - use assertEquals()

    // 5) Add following comparison routines.  return follows:
    //      '-1' if this' date is less than parameter's date
    //      '0' if this' date is equal to parameter's date
    //      '+1' if this' date is greater than parameter's date

    public int compareTo(int hr, int min, int sec);
    public int compareTo(Time time);

    // 6) Add additional overloads to existing functions
    public Time         calcDeltaTime(Time deltaTime);
    public boolean      updateTime(Time deltaTime);



}   //  end TimeInterface

