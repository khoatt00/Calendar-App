import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


/* 	Programmer: 		Michael A Gardner
 * 	Class:				CPT - 236-001
 *	Last Modified:		2 November 2016
 *	Assignment: 		Assignment 9A
 */


public class Date implements DateInterface{
    // ** Variables **
    private int
            month = 0,      // Private month variable used to store the day value.
            day = 0,        // Private day variable used to store the day value.
            year = 0;       // Private year variable used to store the year value.


    public static final int MIN_VALID_MONTH = 1;
    public static final int MAX_VALID_MONTH = 12;
    public static final int MIN_VALID_DAY = 1;
    public static final int MAX_VALID_DAY = 31;
    public static final int MIN_VALID_YEAR = 1700;
    public static final int MAX_VALID_YEAR = 2600;
    public static final int MIN_DELTA_YEAR = -24;
    public static final int MAX_DELTA_YEAR = 24;
    public static final int MIN_DELTA_MONTH = -18;
    public static final int MAX_DELTA_MONTH = 18;
    public static final int MIN_DELTA_DAY = -100;
    public static final int MAX_DELTA_DAY = 100;
    public static final String INVALID_DATE_STRING_FMT_MMDDYY = "00/00/00";
    public static final String INVALID_DATE_STRING_FMT_MMDDYYYY = "00/00/0000";
    public static final String INVALID_DATE_STRING_FMT_MondDYYYY = "INV 0, 0000";





    // ** Constructors  **
    Date() {                // Default constructor that doesn't require any parameters.
    }
    /**
     * @param m
     * @param d
     * @param y
     */
    Date(int m, int d, int y){          // Constructor that gets parameters month, day, and year.
        if(validateMonth(m) && validateYear(y) && validateDay(d)){
        month = m; day = d; year = y;
    }}
    /** @param copy
     */
    Date(Date copy){                    // Constructor that copies the data from another date object.
        day = copy.day;
        month = copy.month;
        year = copy.year;
    }
    Date(boolean setDate) {
        if(setDate) setToCurrentDate();
    }

    public enum DateFormat {
        FMT_MMDDYY,         // Used to define a date with the format "MM/DD/YY"
        FMT_MMDDYYYY,       // Used to define a date with the format "MM/DD/YYYY"
        FMT_MondDYYYY         // Used to define a date with the format "Month D, YYYY"
    }  // end DateFormat();
    public enum DayOfWeek {
        SUNDAY,
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY
    }
    public boolean setToCurrentDate() {  // Used to get the current date on the host machine. Timezone may need to be set to the correct timezone on the host computer.
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int year = date.getYear();
        int day = date.getDayOfMonth();
        if(setDate(month,day,year)) return true;
        else return false;
    }
    public Date getFirstDayOfWeek() {
        LocalDate date = LocalDate.now();
        while(date.getDayOfWeek().name() != "Sunday") {
            date = date.plus(1, ChronoUnit.DAYS);
        }
        int month = date.getMonthValue();
        int year = date.getYear();
        int day = date.getDayOfMonth();
        Date returnDate = new Date(month, day, year);

            return returnDate;
    }
    /**
     *
     * @return
     */
    public boolean isLeapYear() {
        if (this.month == 0 && this.year == 0 && this.day == 0)return false;
            if (this.year % 4 != 0) {
                return false;
            } else if (this.year % 400 == 0) {
                return true;
            } else if (this.year % 100 == 0) {
                return false;
            } else {
                return true;
            }
    }

    /**
     *
     * @param year
     * @return
     */

    @Override
    public boolean isLeapYear(int year) {
        return false;
    }

    /**
     * @param month
     * @return
     */
    public String getMonthName(int month){  //Returns the name of the month according to the month parameter
        String[] Month = {"0 PlaceHolder","Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sept", "Oct", "Nov", "Dec"};
        if(validateMonth(month)) {
            return Month[month];
        }else return "INV";


    }  // end getMonthName();

    /**
     *
     * @param dateFormat
     * @return
     */

    @Override
    public String getFormattedDate(DateInterface.DateFormat dateFormat) {
        return null;
    }

    /**  getFormattedDate()  **
     *  This function returns a string that is a properly formatted date.
     * @param dateformat
     * @return
     */

    public String getFormattedDate(DateFormat dateformat){                               // This function returns a formatted date
        int year2 = getYear();
            if(year > 0) year2 = Integer.parseInt(Integer.toString(year2).substring(2));              // This is used to take off the last two numbers of the year to get the correctly formatted date! :)
        switch(dateformat) {
            case FMT_MMDDYY:
                return String.format("%02d%s%02d%s%02d", month,"/", day,"/", year2);             // Returns Format "MM/DD/YY"
            case FMT_MMDDYYYY:
                return String.format("%02d%s%02d%s%04d", month, "/", day,"/", year);             // Returns Format "MM/DD/YYYY"
            case FMT_MondDYYYY:
                return String.format("%s%s%d%s%04d", getMonthName(month), " ", day, ", ", year); // Returns Format "Month D, YYYY"
            default:
                return String.format("%02d%s%02d%s%02d", month, "/", day,"/", year);             // Default Format "00/00/0000"
        }
    }  // end getFormattedDate();

    /**
     *
     * @return
     */
    @Override
    public boolean validateMonth() {
        return false;
    }

    /**  MONTH  **
     * Validate, Get, and Set the Month Variable using the functions below
     * @param month
     * @return
     */
    public boolean validateMonth(int month) {
        if (month < MIN_VALID_MONTH || month > MAX_VALID_MONTH) {           // Check months and make sure that it is between 1 and 12.
            return false;                       // Return false If the months variable is not in the correct range.
        }
        return true;                            // Return True if the months variable is in the correct range.
    } // end validateMonth()

    /**
     *
     * @return
     */
    @Override
    public boolean validateDay() {
        return false;
    }

    /**
     *
     * @param month
     * @return
     */
    public boolean setMonth(int month) {
        if (!validateMonth(month)) {            // Check if month is correct 1..12.
            this.month = 0;                     // Set this.month to 0 if it is not.
            return false;                       // Return False if month is not between 1..12.
        }
        this.month  =   month;                  // Set this.month to months value if validation returns true.
        return true;                            // Return true the month was correct and it was set equal to this.month.
    } // End setHours()

    /**  Get Month **
     *   Gets the current month in the Date Class.
     * @return
     */
    public int getMonth() {     // Returns the value stored in month.
        return this.month;
    }//end getMonth()

    /**  DAY  **
     * Functions relating to Setting, validating, and getting the day variable.
     */
    public int getNumberDaysInMonth(){
        int[] isleapyear = {0,31,29,31,30,31,30,31,31,30,31,30,31};
        int[] isNotleapyear = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int year = getYear();
        int month = getMonth();
        if (isLeapYear()){
            return isleapyear[month];
        }else return isNotleapyear[month];

    }

    /**  Validate Day
     * This function uses the constants to verify if the correct data is in the Day field in the date object.
     * @param day
     * @return
     */

    public boolean validateDay(int day) {       // Used to validate Day must be 1..30.
        if (day < MIN_VALID_DAY || day > MAX_VALID_DAY) {  // BEFORE ASSIGNMENT #6 I had this check the bounds of the actual month insted of 31 example "if (day < MIN_VALID_DAY || day > getNumberDaysInMonth())"
            return false;                       // If day isn't between 1..30 return false.
        }
        return true;                            // IF day is between 1..30 return true.
    }// End ValidateDate()

    /**  Validate Year  **
     *  This function validates the Year
     * @return
     */
    @Override
    public boolean validateYear() {
        return false;
    }

    public boolean setDay(int day) {            // Used to set the day variable.
        if (!validateDay(day)) {                // Validate day must be between 1..30.
            this.day = 0;                       // If validation fails set this.day to 0.
            return false;                       // Then return 0.
        }
        this.day = day;                         // If Validation succeeds then set this.day to day.
        return true;                            // return true this.day has been set to day
    } // End setDay()

    public int getDay() {                       // Returns the value stored in day.
        return this.day;
    } // end getDay()


    /**  YEAR  **
     * Functions relating to Setting, validating, and getting the year variable.
     * @param year
     * @return
     */
    public boolean validateYear(int year) {         // Used to Validate the value in year must between 2000..2025.
        if (year < MIN_VALID_YEAR || year > MAX_VALID_YEAR) {
            return false;                           // Return False if Validation fails.
        }
        return true;                                // Return True if Validation Succeeds.
    } // end validateYear()

    public boolean setYear(int year) {              // Used to Store a value in this.year.
        if(!validateYear(year)) {                   // Validates the data in year (year must be 2000..2025).
            this.year = 0;                          // If Validation fails set this.year to 0.
            return false;                           // Then return false.
        }
        this.year = year;                           // If Validation succeeds the set this.year to equal year
        return true;                                // Then return true.
    }// end setYear

    public int getYear() {                          // Used to return a integer value that is stored in this.year.
        return this.year;
    }// end getYear()

    /**  SET Date(), VALIDATE DATE() **
     * Functions relating to setting and validating an entire date at once.
     * @return
     */

    public boolean validateDate(){      // Used to validate all date variables at once.

        if (!validateMonth(this.month))                  // Validate Month is in range of 1..12.
            return false;                           // If Validation of month fails return false.
        else if (!validateDay(this.day))                 // Validate Day is in range of 1..30.
            return false;                           // If Validation of day fails return false.
        else if (!validateYear(this.year))               // Validate Year is in range of 2000..2025.
            return false;                           // If Validation of year fails return false.
        return true;                    // If validation of month, day, and year succeed return true.
    }  // end validateDate();

    @Override
    public boolean validateDate(int month, int day, int year) {
        return false;
    }

    public boolean setDate(int month, int day , int year) {         // Used to Store data in month, day, and year at once.
        this.month = month;     // If validation succeeds then set this.month to month
        this.day = day;         // this.day to day
        this.year = year;       // this.year to year
        if (!validateDate()) {    // Validate all data is in the correct constraints.
            this.month = 0;     // set all data to 0 if constraints are not met.
            this.day = 0;
            this.year = 0;
            return false;       // Then return False
        }
        return true;            // then return true.

    }  // end setDate();

    /**  Add TO Month  **
     * This function takes a value "delta" and adds it to the current date.
     * @param delta
     * @return
     */
    public boolean addToMonth(int delta) {
        if(delta >= MIN_DELTA_MONTH && delta <= MAX_DELTA_MONTH){
            int m = getMonth();
            int years;
            if (delta > 0){
                for(int i = 0; i < delta; i++){
                    m++;
                    if (m == 13){
                        m = 1;
                        this. year++;
                    }
                }
            } else {
                for(int i = 0; i >delta; i-- ){
                    m--;
                    if (m == 0){
                        m = 12;
                        this.year--;
                    }
                }
            }
            this.month = m;
            return true;
        }else {
            return false;
        }
    }

    /**  Add To Day  **
     *  This function takes the 'delta' value and adds it to the current date.
     * @param delta
     * @return
     */
    public boolean addToDay(int delta) {
        if(delta >= MIN_DELTA_DAY && delta <= MAX_DELTA_DAY){
            int month = getMonth();
            int day = getDay();
            int year = getYear();
            if (delta >=0){
                for(int i = 0; i < delta; i++){
                    if (day >= getNumberDaysInMonth()){
                        day = 1;
                        addToMonth(1);
                    }
                    day++;
                }
                setDay(day);
            }
            if (delta < 0) {
                for(int i = 0; i > delta; i--){
                    if (day <= 0){
                        addToMonth(-1);
                        day = getNumberDaysInMonth();
                    }
                    day--;
                }
                setDay(day);
            }
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean addToDate(int deltaMonth, int deltaDay, int deltaYear) {
        return false;
    }

    @Override
    public DateInterface.DayOfWeek getDayOfWeek() {
        return null;
    }

    @Override
    public DateInterface.DayOfWeek getDayOfWeek(int month, int day, int year) {
        return null;
    }

    @Override
    public DateInterface.DayOfWeek getMonthsFirstDayOfWeek() {
        return null;
    }

    @Override
    public DateInterface.DayOfWeek getMonthsFirstDayOfWeek(int month, int day, int year) {
        return null;
    }

    @Override
    public int compareTo(int month, int day, int year) {
        return 0;
    }

    @Override
    public int compareTo(Date date) {
        return 0;
    }

    @Override
    public DateInterface.DayOfWeek getDayOfWeek(Date date) {
        return null;
    }

    @Override
    public DateInterface.DayOfWeek getMonthsFirstDayOfWeek(Date date) {
        return null;
    }

    /**  Add To Year **
     * This function takes the value of 'delta' and adds that to the current year in date.
     * @param delta
     * @return
     */
    public boolean addToYear(int delta) {
        if(delta >= MIN_DELTA_YEAR && delta <= MAX_DELTA_YEAR){
            this.year = this.year + delta;
            return true;
        }else {
            return false;
        }
    }


} // end Date();

