/* 	Programmer: 		Michael A Gardner
 * 	Class:				CPT - 236-001
 *	Date:				2 November 2016
 *	Assignment: 		Assignment 9A
 */


import java.time.LocalDateTime;

/**
 *
 */
public class Time {

    private int
            hours,
            minutes,
            seconds;

    Time() {}

    /**
     *
     * @param hour
     * @param minute
     * @param sec
     */
    Time(int hour, int minute, int sec) {
        hours = hour;
        minutes = minute;
        seconds = sec;
    }

    /**
     *
     * @param copy
     */
    Time(Time copy){
        hours = copy.hours;
        minutes = copy.minutes;
        seconds = copy.seconds;
    }

    /**
     *
     * @param setCurrentTime
     */
    Time(boolean setCurrentTime){
        if (setCurrentTime) setToCurrentTime();
    }



    /**
     * @return
     */
    public boolean setToCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        if(setHours(currentTime.getHour()) &&
        setMinute(currentTime.getMinute()) &&
        setSecond(currentTime.getSecond())
                )return true;
        else return false;
    }
    /**
     *
     * @param hour checks if hour is between 0 and 24.
     * @return true if it is
     */
    public boolean validateHour(int hour) {
        if (hour < 0 && hour > 24) {
            return true;
        } return false;
    }

    /**
     *
     * @param min  checks if min is between 0 and 60.
     * @return returns True if it is.
     */
    public boolean validateMinute(int min){
        if (min < 0 && min > 60){
            return true;
        }return false;
    }

    /**
     *
     * @param sec used to check if sec is between 0 and 60.
     * @return True if it is
     */
    public boolean validateSecond(int sec) {
        if (sec < 0 && sec > 60){
            return true;
        }return false;
    }

    /**
     *
     * @param val Validate all Time within a time class.
     * @return Return true if all data in a Time class is valid.
     */
    public boolean validateTime(Time val) {
        if (validateHour(val.hours) && validateMinute(val.minutes) && validateSecond(val.seconds)){
            return true;
        }return false;
    }

    /**
     *
     * @param hour Value to set for hour
     * @return True if it is set.
     */
    public boolean setHours(int hour) {
        if (validateHour(hour)){
            this.hours = hour;
            return true;
        }return false;
    }

    /**
     *
     * @param min Value to set for Min.
     * @return True when it is set.
     */
    public boolean setMinute(int min) {
        if (validateMinute(min)){
            this.minutes = min;
            return true;
        }return false;
    }

    /**
     *
     * @param sec Value to set for Sec
     * @return True when sec has been set.
     */
    public boolean setSecond(int sec) {
        if (validateSecond(sec)){
            this.seconds = sec;
            return true;
        }return false;
    }

    /**
     *
     * @return Mins
     */
    public int getMinute() {
        return this.minutes;
    }

    /**
     *
     * @return seconds
     */
    public int getSecond() {
        return this.seconds;
    }

    /**
     *
     * @return hours
     */
    public int getMHour() {
        return this.hours;
    }

    /**
     *
     * @param deltaH    Hours
     * @param deltaM    Minutes
     * @param deltaS    Seconds
     * @return Returns a time class with all the information in it.
     */
    public Time calcDeltaTime(int deltaH, int deltaM, int deltaS){
        Time now = new Time();

        if(deltaH < 100 && deltaH > -100 && deltaM < 100 && deltaM > -100 && deltaS < 100 && deltaS > -100){
            now.setMinute(deltaM);
            now.setSecond(deltaS);
            now.hours = deltaH;
            return now;
        }
        return now;
    }

    /**
     *
     * @param deltaH hours
     * @param deltaM minutes
     * @param deltaS seconds
     * @return True if all the values are set correctly.
     */
    public boolean updateTime(int deltaH, int deltaM, int deltaS){
        if(deltaH < 100 && deltaH > -100 && deltaM < 100 && deltaM > -100 && deltaS < 100 && deltaS > -100) {
            this.setMinute(deltaM);
            this.setSecond(deltaS);
            this.hours = deltaH;
            return true;
        }return false;
    }





























}

