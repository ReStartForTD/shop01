package com.bin.shop.api.user.service;


import com.bin.shop.api.user.beans.UmsMember;
import com.bin.shop.api.user.beans.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {

    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemberId(String memberId);
}
