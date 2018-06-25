package com.faris.service;

import com.faris.entity.Produk;

import java.util.List;

public interface BaseProduk {

    Produk Save(Produk entity);

    List<Produk> find();

    String delete(int id_produk);
}
