/**
 * Created by sedward3 on 10/20/2016.
 */


import org.omg.CORBA.TIMEOUT;

import java.util.ArrayList;

/*************************************************************************

 -----------------------------
 2016-10-31 Work In Progress
 -----------------------------



 Calendar Interface:
 -----------------------------
 Get current date
 Get eventList for date

 Check event overlap(s) by events or eventList

 EventsUser[]	user defined	 - stored
 EventsExt[]	external defined - transitory not stored

 LoadExternalEvents	- ignore if already defined (external & D/T/N "identical")

 InsertEvent(event)             // insert event into EventUsers[] and sort
 DeleteEvent(event)
 UpdateEvent(event);        // May have to keep copy "pre-edited" event in order to update


 Get events[] for specified date	(check all event lists for appropriate events)




 Calendar Application (GUI & user interface to add/modify/delete events)
 -----------------------------

 Display support:

 Get current date ==> starting point
 Get number of days in month
 Get first day of month
 Get name of month

 Month Forward/Backward
 Year Forward/Backward

 SetCalendarDate()
 SetCalendarMonth()

 AdjustCalendarMonth(int +/-)
 AdjustCalendarDay(int +/-)
 AdjustCalendarYear(int +/-)

 ArrayList<Event> GetEventsForDay(Date date);                    // Get all events for specified date
 ArrayList<Event> GetEventsForDay(Date date, Time startTime);    // Get all events for specified date --AND-- on/after starting time


 variables:
 workingDate			// Current "highlighted" date being displayed
 workingTime			// Used for reminder, possibly affect Week/Day form
 useExternalEvents
 ArrayList<Event>   eventList;


 Calendar Application
 Form CalendarMonth
 Form CalendarWeek	??
 Form CalendarDay	??
 Form Event view/add/update/delete
 Form Add External Events (aka holidays)

 *** Update Event.interface also!



 Calendar Application Steps
 1) Set current date (setting or adjusting)             ==> Date.SetToCurrentDate()
 1.a) get number of days in month                    ==> Date.GetDateForFirstDayOfMonth()
 1.b) get first day of month

 2) Render the month/week/day  (GUI function based on #1)


 3) Pull event list for current rendering (month/week/day)


 4) Render events with current month/week/day display  (application display ==> GUI)


 5) select event to view/edit/delete


 *******************************************************************************/


public interface CalendarInterface {

    // Variables
    //private Array of Event  events  =   NULL;

    //---NotNeeded---public    Date    currentDate;        // Set to "today's" date
    //---NotNeeded---public    Time    currentTime;        // Set to "today's" time

    //public    Date    displayDate;                        // active date for operations;  set to current date in constructor (unless otherwise specified)
    //public    Time    displayTIme;                        // active time for operations   set to start-of-day in constructor (unless otherwise specified)

    //public    ArrayList<Event>    eventUserList;      // Sorted or not - your choice
    //public    ArrayList<Event>    eventExtList;       // Sorted or not - your choice


    // Constructors
    //public Calendar();                                // Set to current date & time
    //public Calendar(Date displayDate);
    //public Calendar(Date displayDate, Time displayTime);



    // The following routines add/del/modify an event w.r.t. event's internally defined "eventType"
    boolean     addEvent(Event event);                          // Add event
    boolean     deleteEvent(Event event);                       // Delete event
    boolean     updateEvent(Event event);                       // Modify/Update an event


    ArrayList<Event> getEventList();                             // Get ALL events defined (sorted) for current Date
    ArrayList<Event> getEventList(Time startTime);               // Get ALL events defined (sorted) for current Date  using specified starting time
    ArrayList<Event> getEventList(Date date);                    // Get ALL events defined (sorted) for specified Date
    ArrayList<Event> getEventList(Date date, Time startTime);    // Get ALL events defined (sorted) for specified Date using specified starting time

    ArrayList<Event> getEventList(Event.EventType eventType);    // Get ALL events defined (sorted) for specified eventType for current Date
    ArrayList<Event> getEventList(Event.EventType eventType, Time startTime);
    // Get ALL events defined (sorted) for specified eventType for current Date using specified starting time
    ArrayList<Event> getEventList(Event.EventType eventType, Date date);
    // Get ALL events defined (sorted) for specified eventType for specified Date
    ArrayList<Event> getEventList(Event.EventType eventType, Date date, Time startTime);
    // Get ALL events defined (sorted) for specified eventType for specified Date at specified starting time


    boolean     isOverlap(Event event1, Event event2);          // Check overlap between 2 events
    boolean     isOverlap(Event event);                         // Check overlap between event and eventUserList
    //  (not including specified event in eventUserList)

    boolean     isOverlap(Event event, Event.EventType eventType); // Check overlap between event and specified list
    //  (false --> "user", true --> "Ext")
    //  (not including specified event in specified list)



    Date        getCurrentDate();                               // returns current date
    Time        getCurrentTime();                               // returns current time

    Date        getDisplayDate();                               // Get current displayDate
    Time        getDisplayTime();                               // Get current displayTime

    boolean     setDisplayDateToCurrent();                      // sets displayDate to current date
    boolean     setDisplayTimeToCurrent();                      // sets displayTime to current time

    boolean     setDisplayDate(Date date);                      // sets displayDate to current date
    boolean     setDisplayTime(Time time);                      // sets displayTime to current time


    boolean     addToYear(int deltaYear);                       // adjust displayDate
    boolean     addToMonth(int deltaMonth);                     // adjust displayDate
    boolean     addToDay(int deltaDay);                         // adjust displayDate
    boolean     addToDate(int deltaMonth, int deltaDay, int deltaYear);
    // adjust displayTime

    boolean      updateSeconds(int deltaS);                      // adjust displayTime
    boolean      updateMinutes(int deltaM);                      // adjust displayTime
    boolean      updateHours(int deltaH);                        // adjust displayTime
    boolean      updateTime(int deltaH, int deltaM, int deltaS); // adjust displayTime


    String      getMonthName();                                 // uses displayDate
    String      getMonthName(Date date);                        // uses specified date (no not update displayDate)

    int         getNumberOfDaysInMonth();                       // uses displayDate
    int         getNumberOfDaysInMonth(Date date);              // uses specified date (no not update displayDate)

    Date        getDateForFirstDayOfWeek();                     // uses displayDate to get Date for "Sunday"
    Date        getDateForFirstDayOfWeek(Date date);            // uses specified date (no not update displayDate)



    boolean     loadExternalEvents();           // Details to be provided.  Return "true" for no-error for moment.



}   //  end interface CalendarInterface