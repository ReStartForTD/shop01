package com.bin.shop.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bin.shop.api.manage.bean.PmsBaseCatalog1;
import com.bin.shop.api.manage.bean.PmsBaseCatalog2;
import com.bin.shop.api.manage.bean.PmsBaseCatalog3;
import com.bin.shop.api.manage.service.PmsBaseCatalogService;
import com.bin.shop.manage.service.mapper.PmsBaseCatalogMapper1;
import com.bin.shop.manage.service.mapper.PmsBaseCatalogMapper2;
import com.bin.shop.manage.service.mapper.PmsBaseCatalogMapper3;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsBaseCatalogServiceImpl implements PmsBaseCatalogService{

    @Autowired
    PmsBaseCatalogMapper1 pmsBaseCatalogMapper1;
    @Autowired
    PmsBaseCatalogMapper2 pmsBaseCatalogMapper2;
    @Autowired
    PmsBaseCatalogMapper3 pmsBaseCatalogMapper3;

    @Override
    public List<PmsBaseCatalog1> getAllPmsBaseCatalog1() {
        List<PmsBaseCatalog1> pmsBaseCatalog1List=pmsBaseCatalogMapper1.selectAll();
        return pmsBaseCatalog1List;
    }

    @Override
    public List<PmsBaseCatalog2> getPmsBaseCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pmsBaseCatalog2 =new PmsBaseCatalog2();
        pmsBaseCatalog2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog1List=pmsBaseCatalogMapper2.select(pmsBaseCatalog2);
        return pmsBaseCatalog1List;
    }

    @Override
    public List<PmsBaseCatalog3> getPmsBaseCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 =new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog1List=pmsBaseCatalogMapper3.select(pmsBaseCatalog3);
        return pmsBaseCatalog1List;
    }


}

