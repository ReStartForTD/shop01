package com.bin.shop.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.bin.shop.api.manage.bean.PmsBaseAttrInfo;
import com.bin.shop.api.manage.bean.PmsBaseAttrValue;
import com.bin.shop.api.manage.service.PmsBaseAttrService;
import com.bin.shop.manage.service.mapper.PmsBaseAttrMapper;
import com.bin.shop.manage.service.mapper.PmsBaseAttrValueMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class PmsBaseAttrServiceImpl implements PmsBaseAttrService{

    @Autowired
    PmsBaseAttrMapper pmsBaseAttrMapper;

    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Override
    public List<PmsBaseAttrInfo> getBaseAttrInfo(String catalog3Id) {
        PmsBaseAttrInfo pmsBaseAttrInfo=new PmsBaseAttrInfo();
        pmsBaseAttrInfo.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pmsBaseAttrInfos=pmsBaseAttrMapper.select(pmsBaseAttrInfo);
        return pmsBaseAttrInfos;
    }

    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pmsBaseAttrValue=new PmsBaseAttrValue();
        pmsBaseAttrValue.setAttrId(attrId);
        List<PmsBaseAttrValue>  pmsBaseAttrValueList=  pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
        return pmsBaseAttrValueList;
    }

    @Override
    public int saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        int i = pmsBaseAttrMapper.insertSelective(pmsBaseAttrInfo);
        if (i>=1){
            Integer id =Integer.parseInt(pmsBaseAttrInfo.getId());
            return id;
        }
       return i;
    }

    @Override
    public int saveAttrValue(PmsBaseAttrValue attrValue) {
        return pmsBaseAttrValueMapper.insert(attrValue);
    }

    @Override
    public int deleteAttrValue(String attrId) {

        return pmsBaseAttrValueMapper.deleteAttrValue(attrId);
    }

    @Override
    public int update(PmsBaseAttrInfo pmsBaseAttrInfo) {
        return pmsBaseAttrMapper.updateByPrimaryKeySelective(pmsBaseAttrInfo);
    }
}
