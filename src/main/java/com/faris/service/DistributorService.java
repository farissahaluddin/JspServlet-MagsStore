package com.faris.service;

import com.faris.dao.DistributorDao;
import com.faris.dao.impl.DistributorDaoImpl;
import com.faris.entity.Distributor;

import java.util.List;

public class DistributorService implements BaseDistributor {

    private DistributorDao distributorDao = new DistributorDaoImpl();

    @Override
    public Distributor Save(Distributor entity) {
        if (entity.getId_distributor() == 0) {
            entity = distributorDao.Save(entity);
        } else {
            entity = distributorDao.update(entity);
        }
        return entity;
    }

    @Override
    public List<Distributor> find() {
        return distributorDao.find();
    }

    @Override
    public Distributor findByName(String nama_distributor) {
        return distributorDao.findByName(nama_distributor);
    }

    @Override
    public String delete(int id_distributor) {
        return distributorDao.delete(id_distributor);
    }
}
