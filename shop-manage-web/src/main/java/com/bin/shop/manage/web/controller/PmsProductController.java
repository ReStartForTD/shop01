package com.bin.shop.manage.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bin.shop.api.manage.bean.PmsProductInfo;
import com.bin.shop.api.manage.service.PmsProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmsProductController {

    @Reference
    PmsProductService pmsProductService;
    @ResponseBody
    @RequestMapping("/spuList")
   public List<PmsProductInfo> getSpuList(String catalog3Id){

        return pmsProductService.getSpuList(catalog3Id);
    }


    @RequestMapping("/saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){

       int result= pmsProductService.saveSpuInfo(pmsProductInfo);
        //保存SPU
        //保存商品销售属性值
        //保存图片信息
        return "success";
    }
}
