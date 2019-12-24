package com.bin.shop.user.service.mapper;


import com.bin.shop.api.user.beans.UmsMember;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<UmsMember>{

    List<UmsMember> selectAllUser();

}
