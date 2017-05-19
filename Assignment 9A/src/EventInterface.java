/**
 * Created by sedward3 on 10/19/2016.
 */


/*
Purpose:	Create a personal calendar with event scheduling

Event class:

(2)	Event is a date, time, and duration.
(1)	Name & Description.
*	Notes (local)
(3)	place/location/modality (&) hosting.
(5)	Attendance list.
(4)	Event type (open invite, RSVP, private, assembly)
(6)	Priority (w.r.t. multipe events)
	Reminder/notification
(7)	Costs (related to event type)
		entertainment
		props
		rentals
		foods & drinks

Rev #1:
(A)	Event is a date, time, and duration.
(B)	Notes (can contain place & event particulars as necessary)
(C)	Name & Description


Operations:
* Create
* Delete
* Update/Edit
* Overlapping with other event(s)

*/


public interface EventInterface {

//  EventType is not part of
//    public enum EventType { UNDEFINED, USER_DEFINED, EXTERNAL };

    //  Event class Variables
    //private Date      eventDate;      // Date of event
    //private Time      eventTime;      // Start time on specified date
    //private Time      spanTime;       // Duration of the event (in Time)

    //private   String  eventName;      // Event name (text, not necessarily an unique ID)
    //private   String  eventDesc;      // Event description
    //private   String  eventNotes;     // Notes about the event
    //pivate    EventType   eventType;





    // Default values for variables
    static final Date   DEFAULT_DATE    =   new Date();
    static final Time   DEFAULT_TIME    =   new Time();
    static final Time   DEFAULT_SPAN    =   new Time();
    static final String DEFAULT_NAME    =   "Undefined";
    static final String DEFAULT_DESC    =   "";
    static final String DEFAULT_NOTES   =   "";


    // Constructors
    //  public  Event();
    //  public  Event(class Event);
    //  public   Event(Date date, Time time, Time duration);


    public  boolean isValidEvent();
    public  boolean isValidEvent(Date date, Time time, Time duration);
    public  boolean isValidEvent(Event event);

    public  boolean setDate(Date date);                 // Date of event
    public  boolean setDate(int mon, int day, int year);
    public  Date    getDate();

    public  boolean setTime(Time time);                 // Start time on specified date
    public  boolean setTime(int hour, int min, int sec);
    public  Time    getTime();

    // First rev - only allow 24 hour time span for event.
    public  boolean setDuration(Time spanTime);         // Duration of the event (in Time)
    public  boolean setDuration(int hour, int min, int sec);
    public  Time    getDuration();

    public  boolean setName(String name);
    public  String  getName();

    public  boolean setDesc(String desc);
    public  String  getDesc();

    public  boolean setNotes(String notes);
    public  String  getNotes();

//    public  boolean setEventType(EventType eventTye);
//    public  EventType getEventType();


    public  boolean isOverlap(Date date);               // True if "date" is same as event date(s) time span
    public  boolean isOverlap(Time time);               // True if "time" is within event's time span
    public  boolean isOverlap(Date date, Time time);    // True if same "date" and "time" within event's time span
    public  boolean isOverlap(Event otherEvent);        // True if "otherEvent" is within our event's date & time span



    /////////////////////////////////////////////////////////////////////////////////////////////
    // 2016-10-26 EventInterface.java Updates
    /////////////////////////////////////////////////////////////////////////////////////////////

    // 1) Add code to initialize Event.signature to EVENT_SIGNATURE in constructors

    //  public int signature;              // make public for external testing purposes

    public static final int     TIME_SIGNATURE      =   0x5aa555AA;

    // 2) Add code to validate valid class instance before access variables (e.g., check for null)  You can use "assertNotNull(this);"

    // 3) Add code to validate signature valid before setting any value - use assertEquals()

    // 4) Add code to validate signature valid before getting any value - use assertEquals()

    // 5) Add following comparison routines.  return follows:
    //      '-1' if this' date is less than parameter's date
    //      '0' if this' date is equal to parameter's date
    //      '+1' if this' date is greater than parameter's date

    public int compareTo(Date date, Time time, Time duration);
    public int compareTo(Event event);



}   //  end interface EventInterface