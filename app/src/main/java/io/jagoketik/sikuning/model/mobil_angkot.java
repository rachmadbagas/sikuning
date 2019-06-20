package io.jagoketik.sikuning.model;

import java.util.ArrayList;

public class mobil_angkot {
    private String angkot_nomor;

    private String angkot_driver_id;

    private String angkot_reversed;

    private String users_hp;

    private double angkot_long;

    private String users_name;

    private String kode;

    private String angkot_status;

    private ArrayList<Object> trayek = new ArrayList<Object>();

    private String angkot_kode_trayek;

    private String angkot_id;

    private String angkot_plat_nomor;

    private double angkot_lat;


    public mobil_angkot(String angkot_nomor, String angkot_driver_id, String angkot_reversed, String users_hp, double angkot_long, String users_name, String kode, String angkot_status, ArrayList<Object> trayek, String angkot_kode_trayek, String angkot_id, String angkot_plat_nomor, double angkot_lat) {
        this.angkot_nomor = angkot_nomor;
        this.angkot_driver_id = angkot_driver_id;
        this.angkot_reversed = angkot_reversed;
        this.users_hp = users_hp;
        this.angkot_long = angkot_long;
        this.users_name = users_name;
        this.kode = kode;
        this.angkot_status = angkot_status;
        this.trayek = trayek;
        this.angkot_kode_trayek = angkot_kode_trayek;
        this.angkot_id = angkot_id;
        this.angkot_plat_nomor = angkot_plat_nomor;
        this.angkot_lat = angkot_lat;
    }

    public String getAngkot_nomor() {
        return angkot_nomor;
    }

    public String getAngkot_driver_id() {
        return angkot_driver_id;
    }

    public String getAngkot_reversed() {
        return angkot_reversed;
    }

    public String getUsers_hp() {
        return users_hp;
    }

    public double getAngkot_long() {
        return angkot_long;
    }

    public String getUsers_name() {
        return users_name;
    }

    public String getKode() {
        return kode;
    }

    public String getAngkot_status() {
        return angkot_status;
    }

    public ArrayList<Object> getTrayek() {
        return trayek;
    }

    public String getAngkot_kode_trayek() {
        return angkot_kode_trayek;
    }

    public String getAngkot_id() {
        return angkot_id;
    }

    public String getAngkot_plat_nomor() {
        return angkot_plat_nomor;
    }

    public double getAngkot_lat() {
        return angkot_lat;
    }
}
