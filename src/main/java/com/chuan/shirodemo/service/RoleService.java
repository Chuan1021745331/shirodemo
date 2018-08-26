package com.chuan.shirodemo.service;

import com.chuan.shirodemo.domain.RoleDO;

import java.util.List;
import java.util.Map;

public interface RoleService {
    int save(RoleDO role);

    RoleDO get(int id);

    List<RoleDO> list(Map<String,Object> param);

    List<RoleDO> list(int userId);
}
