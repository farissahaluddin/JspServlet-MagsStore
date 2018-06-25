package com.faris.service;

import com.faris.dao.ProdukDao;
import com.faris.dao.impl.ProdukDaoImpl;
import com.faris.entity.Produk;

import java.util.List;

public class ProdukService implements BaseProduk {

        private ProdukDao produkDao = new ProdukDaoImpl();

        @Override
        public Produk Save(Produk entity) {
            if (entity.getId_produk() == 0){
                entity= produkDao.Save(entity);
            }else {
                System.out.println("update");
            }
            return entity;
        }

    @Override
    public List<Produk> find() {
        return produkDao.find();
    }

    @Override
    public String delete(int id_produk) {
        return produkDao.delete(id_produk);
    }
}

