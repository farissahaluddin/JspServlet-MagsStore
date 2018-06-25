package com.faris.entity;

public class Produk {
    int id_produk;
    String nama_produk;
    String filename;
    String path_produk;

    public Produk() {
    }

    public int getId_produk() {
        return id_produk;
    }

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getNama_produk() {
        return nama_produk;
    }

    public void setNama_produk(String nama_produk) {
        this.nama_produk = nama_produk;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getPath_produk() {
        return path_produk;
    }

    public void setPath_produk(String path_produk) {
        this.path_produk = path_produk;
    }

    @Override
    public String toString() {
        return "Produk{" +
                "id_produk=" + id_produk +
                ", nama_produk='" + nama_produk + '\'' +
                ", filename='" + filename + '\'' +
                ", path_produk='" + path_produk + '\'' +
                '}';
    }
}
