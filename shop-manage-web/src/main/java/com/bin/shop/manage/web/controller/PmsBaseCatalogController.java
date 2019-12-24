package com.bin.shop.manage.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bin.shop.api.manage.bean.PmsBaseCatalog1;
import com.bin.shop.api.manage.bean.PmsBaseCatalog2;
import com.bin.shop.api.manage.bean.PmsBaseCatalog3;
import com.bin.shop.api.manage.service.PmsBaseCatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmsBaseCatalogController {

    @Reference
    PmsBaseCatalogService pmsBaseCatalogService;

    @ResponseBody
    @RequestMapping("/getCatalog1")
    public List<PmsBaseCatalog1> getAllCatalog(){

       return pmsBaseCatalogService.getAllPmsBaseCatalog1();
    }

    @ResponseBody
    @RequestMapping("/getCatalog2")
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){

        return pmsBaseCatalogService.getPmsBaseCatalog2(catalog1Id);
    }

    @ResponseBody
    @RequestMapping("/getCatalog3")
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){

        return pmsBaseCatalogService.getPmsBaseCatalog3(catalog2Id);
    }
}
