package com.faris.dao;

import com.faris.entity.Barang;

import java.util.List;

public interface BarangDao {
    Barang Save(Barang entity);

    List<Barang> find();

    String delete(int id_barang);
}
