package com.faris.service;

import com.faris.dao.ProdukDao;
import com.faris.dao.impl.ProdukDaoImpl;
import com.faris.entity.Produk;

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
    }

