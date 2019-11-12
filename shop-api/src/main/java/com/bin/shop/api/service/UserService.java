package com.bin.shop.api.service;


import com.bin.shop.api.beans.UmsMember;
import com.bin.shop.api.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
