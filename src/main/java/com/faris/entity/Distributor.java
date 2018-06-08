package com.faris.entity;

public class Distributor {

    private int id_distributor;
    private String nama_distributor;
    private String alamat_distributor;
    private String email;
    private String telepon;

    public Distributor() {
    }

    public int getId_distributor() {
        return id_distributor;
    }

    public void setId_distributor(int id_distributor) {
        this.id_distributor = id_distributor;
    }

    public String getNama_distributor() {
        return nama_distributor;
    }

    public void setNama_distributor(String nama_distributor) {
        this.nama_distributor = nama_distributor;
    }

    public String getAlamat_distributor() {
        return alamat_distributor;
    }

    public void setAlamat_distributor(String alamat_distributor) {
        this.alamat_distributor = alamat_distributor;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "id_distributor=" + id_distributor +
                ", nama_distributor='" + nama_distributor + '\'' +
                ", alamat_distributor='" + alamat_distributor + '\'' +
                ", email='" + email + '\'' +
                ", telepon='" + telepon + '\'' +
                '}';
    }
}
