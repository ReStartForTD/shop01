package com.bin.shop.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bin.shop.api.manage.bean.PmsProductImage;
import com.bin.shop.api.manage.bean.PmsProductInfo;
import com.bin.shop.api.manage.bean.PmsProductSaleAttr;
import com.bin.shop.api.manage.bean.PmsProductSaleAttrValue;
import com.bin.shop.api.manage.service.PmsProductService;
import com.bin.shop.manage.service.mapper.PmsProductImageMapper;
import com.bin.shop.manage.service.mapper.PmsProductMapper;
import com.bin.shop.manage.service.mapper.PmsProductSaleAttrMapper;
import com.bin.shop.manage.service.mapper.PmsProductSaleAttrValueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsProductServiceImpl implements PmsProductService{

    @Autowired
    PmsProductMapper pmsProductMapper;
    @Autowired
    PmsProductSaleAttrMapper pmsProductSaleAttrMapper;
    @Autowired
    PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;
    @Autowired
    PmsProductImageMapper pmsProductImageMapper;
    @Override
    public List<PmsProductInfo> getSpuList(String catalog3Id) {
        PmsProductInfo pmsProductInfo=new PmsProductInfo();
        pmsProductInfo.setCatalog3Id(catalog3Id);
        return pmsProductMapper.select(pmsProductInfo);
    }

    @Override
    public int saveSpuInfo(PmsProductInfo pmsProductInfo) {
        //保存SPU
        pmsProductMapper.insertSelective(pmsProductInfo);
        //保存商品销售属性值
        for (PmsProductSaleAttr pmsProductSaleAttr:pmsProductInfo.getSpuSaleAttrList()){
            pmsProductSaleAttr.setProductId(pmsProductInfo.getId());
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : pmsProductSaleAttr.getSpuSaleAttrValueList()){
                pmsProductSaleAttrValue.setSaleAttrId(pmsProductSaleAttr.getId());
                pmsProductSaleAttrValue.setProductId(pmsProductInfo.getId());
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }
        //保存图片信息
        for (PmsProductImage pmsProductImage:pmsProductInfo.getSpuImageList()){
            pmsProductImage.setProductId(pmsProductInfo.getId());
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        return 0;
    }
}
