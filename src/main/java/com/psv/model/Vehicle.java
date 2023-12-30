package com.psv.model;

import java.util.ArrayList;

public class Vehicle {
    private String regNo;
    private int capacity;
    private String[] busStops;
    private boolean availability;
    private int bookingNo;

    private String busStop;

    public String getBusStop() {
        return busStop;
    }

    public void setBusStop(String busStop) {
        this.busStop = busStop;
    }

    public int getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(int bookingNo) {
        this.bookingNo = bookingNo;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public String[] getBusStops() {
        return busStops;
    }

    public void setBusStops(String[] busStops) {
        this.busStops = busStops;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
