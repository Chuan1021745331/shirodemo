package com.chuan.shirodemo.dao;

import com.chuan.shirodemo.domain.UserDO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int save(UserDO user);

    UserDO get(int id);

    List<UserDO> list(Map<String,Object> param);
}
