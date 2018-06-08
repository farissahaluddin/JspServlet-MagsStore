package com.faris.dao.impl;

import com.faris.dao.BarangDao;
import com.faris.entity.Barang;

import java.util.List;

public class BarangDaoImpl implements BarangDao{
    @Override
    public Barang Save(Barang entity) {
        return entity;
    }

    @Override
    public List<Barang> find() {
        return null;
    }

    @Override
    public String delete(int id_barang) {
        return null;
    }
}
