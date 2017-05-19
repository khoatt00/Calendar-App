/* 	Programmer: 		Michael A Gardner
 * 	Class:				CPT - 236-001
 *	Date:				2 November 2016
 *	Assignment: 		Assignment 9A
 */



public class Event implements EventInterface{

    // **  Variables  **
    private Date    eventDate =DEFAULT_DATE;
    private Time    eventTime =DEFAULT_TIME;
    private Time    spanTime = DEFAULT_SPAN;
    private String  eventName = DEFAULT_NAME;
    private String  eventDesc = DEFAULT_DESC;
    private String  eventNotes = DEFAULT_NOTES;
    private EventType eventType;


    // ** Defaults **
    private static final Date   DEFAULT_DATE    =   new Date();
    private static final Time   DEFAULT_TIME    =   new Time();
    private static final Time   DEFAULT_SPAN    =   new Time();
    private static final String DEFAULT_NAME    =   "Undefined";
    private static final String DEFAULT_DESC    =   "";
    private static final String DEFAULT_NOTES   =   "";


    // ** Constructors  **
    Event(){}
    Event(Event copy){
        setDate(copy.getDate());
    }
    Event(Date date, Time time, Time duration){
        setDate(date);
        setTime(time);
        setDuration(duration);
    }
    public EventType getEventType() {
        return eventType;
    }

    /**
     *
     * @param eventType
     */
    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    /**
     *
     */
    public enum EventType {
        EVENT_TYPE_ALL,
        EVENT_TYPE_USER,
        EVENT_TYPE_EXT

    }

    /**
     *
     * @return true if the event time is before the span time and the date isn't null.
     */
    public  boolean isValidEvent(){
        if(this.eventDate != null){
            if (
                    (this.eventTime.getMHour() < this.spanTime.getMHour())&&
                    (this.eventTime.getMinute() < this.spanTime.getMinute())&&
                    (this.eventTime.getSecond() < this.spanTime.getSecond())
                    ) return true;
        }
        return false;
    }

    /**
     *
     * @param date Required
     * @param time Required
     * @param duration Required
     * @return  ( Returns true if the time is before the duration and the date is not null.)
     */
    public  boolean isValidEvent(Date date, Time time, Time duration){
        if(date != null){
            if ((time.getMHour() < duration.getMHour())
                    && (time.getMinute() < duration.getMinute())
                    && (time.getSecond() < duration.getSecond())
                    ) return true;
        }
        return false;
    }

    @Override
    public boolean isValidEvent(Event event) {
        return false;
    }

    /**
     *
     * @param date required
     * @return Returns true the date gets set.
     */

    public  boolean setDate(Date date) {
        if(this.eventDate.setDate(date.getMonth(),date.getDay(),date.getYear())) return true;
        else return false;
    }

    /**
     *
     * @param mon required
     * @param day required
     * @param year required
     * @return Returns true the date gets set.
     */
    public  boolean setDate(int mon, int day, int year){
        if(this.eventDate.setDate(mon,day,year)) return true;
        else return false;
    }

    /**
     *
     * @return  the current date.
     */
    public  Date    getDate(){
        return this.eventDate;
    }

    /**
     *
     * @param time Required
     * @return True if all parameters of the time class are passed to the eventTime.
     */
    public  boolean setTime(Time time){
        if( this.eventTime.setMinute(time.getMinute())
            && this.eventTime.setSecond(time.getSecond())
            && this.eventTime.setHours(time.getMHour()) ) return true;
        else return false;
    }

    /**
     *
     * @param hour Required
     * @param min Required
     * @param sec Required
     * @return True if all parameters are passed to the eventTime successfully.
     */
    public  boolean setTime(int hour, int min, int sec){
        if     (  this.eventTime.setMinute(min)
                  && this.eventTime.setSecond(sec)
                  && this.eventTime.setHours(hour)
                ) return true;
        else return false;
    }

    /**
     *
     * @return the current eventTime.
     */
    public  Time    getTime(){return this.eventTime;}

    /**
     *
     * @param spanTime Required - the end time of the event.
     * @return  true if it is successfully set.
     */
    public  boolean setDuration(Time spanTime) {
        if( this.spanTime.setMinute(spanTime.getMinute())
                && this.spanTime.setSecond(spanTime.getSecond())
                && this.spanTime.setHours(spanTime.getMHour()) ) return true;
        else return false;
    }

    /**
     *
     * @param hour hour of the end of the event
     * @param min min of the end of the event
     * @param sec sec of the end of the event
     * @return true if all parameters are set to spanTime.
     */
    public  boolean setDuration(int hour, int min, int sec){
        if( this.spanTime.setMinute(min)
                && this.spanTime.setSecond(sec)
                && this.spanTime.setHours(hour) ) return true;
        else return false;
    }

    /**
     *
     * @return the current spanTime.
     */
    public  Time    getDuration(){
        return this.spanTime;
    }

    /**
     *
     * @param name This is the name of the event.
     * @return returns true if the name has been set to eventName.
     */
    public  boolean setName(String name){ this.eventName = name; return true;}
    public  String  getName(){return this.eventName;}

    /**
     *
     * @param desc  this is the description of the event.
     * @return returns true if the event has been set to the event Description.
     */
    public  boolean setDesc(String desc){this.eventDesc = desc; return true;}
    public  String  getDesc(){return this.eventDesc;}

    /**
     *
     * @param notes this is the event notes section.
     * @return true if the event notes has been set to the eventNotes variable.
     */
    public  boolean setNotes(String notes){this.eventNotes = notes; return true;}
    public  String  getNotes(){return this.eventNotes;}

    /**
     *
     * @param date Must have all variables initialized to a acceptable date or it will revert to the default date.
     * @return True if "date" is same as event date
     */
    public  boolean isOverlap(Date date) {               // True if "date" is same as event date
        if(date == this.eventDate) return true;
        else return false;
    }

    /**
     *
     * @param time Must have all variables initialized to a acceptable time or it will revert to the default time.
     * @return  True if "time" is within event's time span.
     */
    public  boolean isOverlap(Time time) {               // True if "time" is within event's time span
        if(time.getMHour() > this.eventTime.getMHour() &&
                time.getMinute() > this.eventTime.getMinute() &&
                time.getSecond() > this.eventTime.getSecond()) {

            if (time.getMHour() < this.spanTime.getMHour() &&
                    time.getMinute() < this.spanTime.getMinute() &&
                    time.getSecond() < this.spanTime.getSecond()) { return true;}
                    else return false;
        }
        return false;
    }

    /**
     *
     *
     * @param date Must have all variables initialized to a acceptable date or it will revert to the default date.
     * @param time Must have all variables initialized to a acceptable time or it will revert to the default time.
     * @return True if same "date" and "time" within event's time span.
     */
    public  boolean isOverlap(Date date, Time time) {    // True if same "date" and "time" within event's time span
        if( isOverlap(date) && isOverlap(time))return true;
        else return false;
    }

    /**
     *
     * @param otherEvent  Will be compared to the current event.
     * @return True if "otherEvent" is within our event's date & time span.
     */

    public  boolean isOverlap(Event otherEvent) {        // True if "otherEvent" is within our event's date & time span
        if (    isOverlap(otherEvent.getDate()) && isOverlap(otherEvent.getTime())  ) return true;
        else return false;
    }

    @Override
    public int compareTo(Date date, Time time, Time duration) {
        return 0;
    }

    @Override
    public int compareTo(Event event) {
        return 0;
    }


}
