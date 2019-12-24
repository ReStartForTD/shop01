package com.bin.shop.manage.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.bin.shop.api.manage.bean.PmsBaseAttrInfo;
import com.bin.shop.api.manage.bean.PmsBaseAttrValue;
import com.bin.shop.api.manage.service.PmsBaseAttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@CrossOrigin
public class PmsBaseAttrController {

    @Reference
    PmsBaseAttrService pmsBaseAttrService;

    @RequestMapping("/attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrInfoList(String catalog3Id){
       return  pmsBaseAttrService.getBaseAttrInfo(catalog3Id);
    }

    @RequestMapping("/getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
       return   pmsBaseAttrService.getAttrValueList(attrId);
    }
    @RequestMapping("/saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){

       if(pmsBaseAttrInfo.getId()!= null && !"".equals(pmsBaseAttrInfo.getId())){
           int a = pmsBaseAttrService.update(pmsBaseAttrInfo);
           int b= pmsBaseAttrService.deleteAttrValue(pmsBaseAttrInfo.getId());
       }else{
           int a = pmsBaseAttrService.saveAttrInfo(pmsBaseAttrInfo);
           pmsBaseAttrInfo.setId(a+"");
       }
       for (PmsBaseAttrValue pmsBaseAttrValue:pmsBaseAttrInfo.getAttrValueList()){
            pmsBaseAttrValue.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrService.saveAttrValue(pmsBaseAttrValue);
       }
           return "success";
   }
}
