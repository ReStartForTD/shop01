package com.bin.shop.api.manage.service;

import com.bin.shop.api.manage.bean.PmsBaseAttrInfo;
import com.bin.shop.api.manage.bean.PmsBaseAttrValue;

import java.util.List;

public interface PmsBaseAttrService {

    public List<PmsBaseAttrInfo> getBaseAttrInfo(String catalog3Id);

    public List<PmsBaseAttrValue> getAttrValueList(String attrId);

    int saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    int saveAttrValue(PmsBaseAttrValue attrValue);

    int deleteAttrValue(String attrId);

    int update(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrInfo> getAllBaseAttrInfo();
}
