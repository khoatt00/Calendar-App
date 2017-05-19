/* 	Programmer: 		Michael A Gardner
 * 	Class:				CPT - 236-001
 *	Date:				2 November 2016
 *	Assignment: 		Assignment 9A
 */

import java.util.ArrayList;

public class Calendar implements CalendarInterface {

    // Variables
    //private Array of Event  events  =   NULL;

    //---NotNeeded---public    Date    currentDate;        // Set to "today's" date
    //---NotNeeded---public    Time    currentTime;        // Set to "today's" time

    public Date displayDate;                        // active date for operations;  set to current date in constructor (unless otherwise specified)
    public Time displayTIme;                        // active time for operations   set to start-of-day in constructor (unless otherwise specified)

    public ArrayList<Event> eventUserList;      // Sorted or not - your choice
    public ArrayList<Event> eventExtList;       // Sorted or not - your choice


    // Constructors
    public Calendar() {                                // Set to current date & time
        setDisplayDateToCurrent();
        setDisplayTimeToCurrent();
    }

    public Calendar(Date displayDate){
        setDisplayDate(displayDate);
    }

    public Calendar(Date displayDate, Time displayTime){
        setDisplayDate(displayDate);
        setDisplayTime(displayTime);
    }


    // The following routines add/del/modify an event w.r.t. event's internally defined "eventType"
    public boolean addEvent(Event event) {                          // Add event
        eventUserList.add(event);
        return true;
    }
    public boolean deleteEvent(Event event) {                       // Delete event
        eventUserList.remove(event);
        return true;
    }
    public boolean updateEvent(Event event) {                       // Modify/Update an event
        eventUserList.add(event);
        return true;
    }

    public ArrayList<Event> getEventList() {                             // Get ALL events defined (sorted) for current Date
        return eventUserList;
    }
    public ArrayList<Event> getEventList(Time startTime) {               // Get ALL events defined (sorted) for current Date  using specified starting time
        return eventUserList;
    }
    public ArrayList<Event> getEventList(Date date) {                    // Get ALL events defined (sorted) for specified Date

        return eventUserList;
    }
    public ArrayList<Event> getEventList(Date date, Time startTime) {    // Get ALL events defined (sorted) for specified Date using specified starting time
        return eventUserList;
    }
    public ArrayList<Event> getEventList(Event.EventType eventType) {    // Get ALL events defined (sorted) for specified eventType for current Date
        return eventUserList;
    }
    public ArrayList<Event> getEventList(Event.EventType eventType, Time startTime) {
        return eventUserList;
    }
    // Get ALL events defined (sorted) for specified eventType for current Date using specified starting time
    public ArrayList<Event> getEventList(Event.EventType eventType, Date date) {
        return eventUserList;
    }
    // Get ALL events defined (sorted) for specified eventType for specified Date
    public ArrayList<Event> getEventList(Event.EventType eventType, Date date, Time startTime) {
        return eventUserList;
    }

    // Get ALL events defined (sorted) for specified eventType for specified Date at specified starting time


    public boolean isOverlap(Event event1, Event event2) {          // Check overlap between 2 events
        return true;
    }
    public boolean isOverlap(Event event) {                         // Check overlap between event and eventUserList
        //  (not including specified event in eventUserList)
        return true;
    }
    public boolean isOverlap(Event event, Event.EventType eventType) { // Check overlap between event and specified list
        //  (false --> "user", true --> "Ext")
        //  (not including specified event in specified list)
        return true;
    }

    public Date getCurrentDate() {                              // returns current date
        Date currentDate = new Date(true);
        return currentDate;
    }

    public Time getCurrentTime() {                               // returns current time
        Time currentTime = new Time(true);
        return currentTime;
    }

    public Date getDisplayDate() {                               // Get current displayDate
        return this.displayDate;
    }

    public Time getDisplayTime() {                              // Get current displayTime
        return this.displayTIme;
    }

    public boolean setDisplayDateToCurrent() {                      // sets displayDate to current date
        if (setDisplayDate(getCurrentDate())) return true;
        else return false;
    }

    public boolean setDisplayTimeToCurrent() {                      // sets displayTime to current time
        if (setDisplayTime(getCurrentTime())) return true;
        else return false;
    }

    public boolean setDisplayDate(Date date) {                      // sets displayDate to current date
        if (date.validateDate()) {
            this.displayDate = date;
            return true;
        } else return false;
    }

    public boolean setDisplayTime(Time time) {                      // sets displayTime to current time
        if (time.validateTime(time)) {
            this.displayTIme = time;
            return true;
        } else return false;
    }


    public boolean addToYear(int deltaYear) {                       // adjust displayDate
        Date date = new Date(getCurrentDate());
        if (date.addToYear(deltaYear)) {
            setDisplayDate(date);
            return true;
        } else return false;
    }

    public boolean addToMonth(int deltaMonth) {                     // adjust displayDate
        Date date = new Date(getCurrentDate());
        if (date.addToMonth(deltaMonth)) {
            setDisplayDate(date);
            return true;
        } else return false;
    }

    public boolean addToDay(int deltaDay) {                         // adjust displayDate
        Date date = new Date(getCurrentDate());
        if (date.addToDay(deltaDay)) {
            setDisplayDate(date);
            return true;
        } else return false;

    }

    public boolean addToDate(int deltaMonth, int deltaDay, int deltaYear) {
        Date date = new Date(getCurrentDate());
        if (date.addToDate(deltaMonth, deltaDay, deltaYear)) {
            setDisplayDate(date);
            return true;
        } else return false;
    }


    // adjust displayTime

    public boolean updateSeconds(int deltaS) {                      // adjust displayTime
        Time time = new Time(getDisplayTime());
        if (time.setSecond(deltaS)) {
            setDisplayTime(time);
            return true;
        } else return false;
    }

    public boolean updateMinutes(int deltaM) {                      // adjust displayTime
        Time time = new Time(getDisplayTime());
        if (time.setMinute(deltaM)) {
            setDisplayTime(time);
            return true;
        } else return false;
    }

    public boolean updateHours(int deltaH) {                        // adjust displayTime
        Time time = new Time(getDisplayTime());
        if (time.setHours(deltaH)) {
            setDisplayTime(time);
            return true;
        } else return false;
    }

    public boolean updateTime(int deltaH, int deltaM, int deltaS) { // adjust displayTime
        Time time = new Time(getDisplayTime());
        if (time.updateTime(deltaH, deltaM, deltaS)) {
            setDisplayTime(time);
            return true;
        } else return false;
    }


    public String getMonthName() {                                 // uses displayDate
        Date date = new Date(getDisplayDate());
        return date.getMonthName(date.getMonth());
    }

    public String getMonthName(Date date) {                        // uses specified date (no not update displayDate)
        return date.getMonthName(date.getMonth());
    }

    public int getNumberOfDaysInMonth() {                       // uses displayDate
        Date date = new Date(getDisplayDate());
        return date.getNumberDaysInMonth();
    }

    public int getNumberOfDaysInMonth(Date date) {              // uses specified date (no not update displayDate)
        return date.getNumberDaysInMonth();
    }

    public Date getDateForFirstDayOfWeek() {                    // uses displayDate to get Date for "Sunday"
        Date date = new Date(getDisplayDate());
        return date.getFirstDayOfWeek();
    }

    public Date getDateForFirstDayOfWeek(Date date) {            // uses specified date (no not update displayDate)
        return date.getFirstDayOfWeek();
    }

    public boolean loadExternalEvents(){           // Details to be provided.  Return "true" for no-error for moment.
        return true;        // Details haven't been provided as of November 2 2016!!
    }
}