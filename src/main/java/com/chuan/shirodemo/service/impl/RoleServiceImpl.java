package com.chuan.shirodemo.service.impl;

import com.chuan.shirodemo.dao.RoleMapper;
import com.chuan.shirodemo.domain.RoleDO;
import com.chuan.shirodemo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @类名:
 * @包名: com.chuan.shirodemo.service.impl
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/8/26 13:10
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public int save(RoleDO role) {
        return roleMapper.save(role);
    }

    @Override
    public RoleDO get(int id) {

        return roleMapper.get(id);
    }

    @Override
    public List<RoleDO> list(Map<String, Object> param) {
        return roleMapper.list(param);
    }

    @Override
    public List<RoleDO> list(int userId){
        return roleMapper.listByUserId(userId);
    }
}
