package com.faris.dao;

import com.faris.entity.Produk;

import java.util.List;

public interface ProdukDao{

    Produk Save(Produk entity);

    List<Produk> find();

    String delete(int id_produk);
}
