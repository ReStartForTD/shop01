package com.bin.shop.manage.service.mapper;

import com.bin.shop.api.manage.bean.PmsBaseAttrValue;
import org.apache.ibatis.annotations.Delete;
import tk.mybatis.mapper.common.BaseMapper;

public interface PmsBaseAttrValueMapper extends BaseMapper<PmsBaseAttrValue> {

    @Delete("delete from pms_base_attr_value  where attr_id =#{attrId}")
    int deleteAttrValue(String attrId);
}
