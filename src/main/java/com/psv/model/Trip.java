package com.psv.model;

public class Trip {

    private String vehicleRegno;
    private boolean completeStatus;

    public String getVehicleRegno() {
        return vehicleRegno;
    }

    public void setVehicleRegno(String vehicleRegno) {
        this.vehicleRegno = vehicleRegno;
    }

    public boolean isCompleteStatus() {
        return completeStatus;
    }

    public void setCompleteStatus(boolean completeStatus) {
        this.completeStatus = completeStatus;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    private int availableSeats;
}
