package com.faris.entity;

public class Barang {

    private int id_barang;
    private String nama_barang;
    private int harga_barang;
    private String foto_barang;

    public Barang() {
    }

    public int getId_barang() {
        return id_barang;
    }

    public void setId_barang(int id_barang) {
        this.id_barang = id_barang;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public int getHarga_barang() {
        return harga_barang;
    }

    public void setHarga_barang(int harga_barang) {
        this.harga_barang = harga_barang;
    }

    public String getFoto_barang() {
        return foto_barang;
    }

    public void setFoto_barang(String foto_barang) {
        this.foto_barang = foto_barang;
    }

    @Override
    public String toString() {
        return "Barang{" +
                "id=" + id_barang +
                ", nama_barang='" + nama_barang + '\'' +
                ", harga_barang=" + harga_barang +
                ", foto_barang='" + foto_barang + '\'' +
                '}';
    }
}
