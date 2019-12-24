package com.bin.shop.api.manage.service;

import com.bin.shop.api.manage.bean.PmsProductInfo;

import java.util.List;

public interface PmsProductService {
    List<PmsProductInfo> getSpuList(String catalog3Id);

    int saveSpuInfo(PmsProductInfo pmsProductInfo);
}
