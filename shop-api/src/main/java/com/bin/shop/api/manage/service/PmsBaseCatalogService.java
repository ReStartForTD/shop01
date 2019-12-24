package com.bin.shop.api.manage.service;

import com.bin.shop.api.manage.bean.PmsBaseCatalog1;
import com.bin.shop.api.manage.bean.PmsBaseCatalog2;
import com.bin.shop.api.manage.bean.PmsBaseCatalog3;

import java.util.List;

public interface PmsBaseCatalogService {

    public List<PmsBaseCatalog1> getAllPmsBaseCatalog1();
    

    List<PmsBaseCatalog2> getPmsBaseCatalog2(String catalog1Id);

    List<PmsBaseCatalog3> getPmsBaseCatalog3(String catalog2Id);
}
