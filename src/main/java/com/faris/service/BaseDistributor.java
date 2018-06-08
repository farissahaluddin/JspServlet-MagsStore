package com.faris.service;

import com.faris.entity.Distributor;

import java.util.List;

public interface BaseDistributor {

    Distributor Save(Distributor entity);

    List<Distributor> find();

    Distributor findByName(String nama_distributor);

    String delete(int id_distributor);
}
