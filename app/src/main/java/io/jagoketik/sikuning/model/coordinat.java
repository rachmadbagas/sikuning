package io.jagoketik.sikuning.model;

public class coordinat {
    private double latitude;
    private double longtitude;

    public coordinat(double latitude, double longtitude) {
        this.latitude = latitude;
        this.longtitude = longtitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }
}
