package com.chuan.shirodemo.service;

import com.chuan.shirodemo.domain.UserDO;

import java.util.List;
import java.util.Map;

public interface UserService {
    UserDO get(int id);

    List<UserDO> list(Map<String,Object> param);

}
