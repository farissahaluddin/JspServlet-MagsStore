package com.faris.dao;

import com.faris.entity.Distributor;

import java.util.List;

public interface DistributorDao {

    Distributor Save(Distributor entity);

    Distributor update(Distributor entity);

    List<Distributor> find();

    Distributor findByName(String nama_distributor);

    String delete(int id_distributor);

}
