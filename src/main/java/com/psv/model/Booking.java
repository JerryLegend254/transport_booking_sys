package com.psv.model;

import java.sql.Date;
public class Booking {

    private String passenger_name;
    private String veh_regno;
    private String bs_name;

    private int book_id;
    private Date booking_date;

    public Date getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(Date booking_date) {
        this.booking_date = booking_date;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public String getPassenger_name() {
        return passenger_name;
    }

    public void setPassenger_name(String passenger_name) {
        this.passenger_name = passenger_name;
    }

    public String getVeh_regno() {
        return veh_regno;
    }

    public void setVeh_regno(String veh_regno) {
        this.veh_regno = veh_regno;
    }

    public String getBs_name() {
        return bs_name;
    }

    public void setBs_name(String bs_name) {
        this.bs_name = bs_name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private float price;

}
