package io.jagoketik.sikuning.model;

public class angkot {
    private String Kode;
    private String[] trayek;

    public angkot(String kode, String[] trayek) {
        Kode = kode;
        this.trayek = trayek;
    }

    public String getKode() {
        return Kode;
    }

    public String[] getTrayek() {
        return trayek;
    }
}
