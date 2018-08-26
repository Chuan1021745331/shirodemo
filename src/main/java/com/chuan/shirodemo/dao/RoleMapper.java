package com.chuan.shirodemo.dao;

import com.chuan.shirodemo.domain.RoleDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {
    int save(RoleDO role);

    RoleDO get(int id);

    List<RoleDO> list(Map<String,Object> param);

    List<RoleDO> listByUserId(int userId);
}
