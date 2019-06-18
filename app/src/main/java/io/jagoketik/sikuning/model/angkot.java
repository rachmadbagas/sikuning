package io.jagoketik.sikuning.model;

import java.util.ArrayList;

public class angkot {
    private int id;
    private String kode;
    ArrayList<Object> trayek = new ArrayList<Object>();

    public angkot(int id, String kode, ArrayList<Object> trayek) {
        this.id = id;
        this.kode = kode;
        this.trayek = trayek;
    }

    public int getId() {
        return id;
    }

    public String getKode() {
        return kode;
    }

    public ArrayList<Object> getTrayek() {
        return trayek;
    }
}
