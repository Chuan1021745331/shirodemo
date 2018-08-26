package com.chuan.shirodemo.service.impl;

import com.chuan.shirodemo.dao.UserMapper;
import com.chuan.shirodemo.domain.UserDO;
import com.chuan.shirodemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @类名:
 * @包名: com.chuan.shirodemo.service.impl
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/8/25 22:40
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDO get(int id) {
        return userMapper.get(id);
    }

    @Override
    public List<UserDO> list(Map<String, Object> param) {

        return userMapper.list(param);
    }
}
