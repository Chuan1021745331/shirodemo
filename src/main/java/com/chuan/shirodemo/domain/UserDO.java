package com.chuan.shirodemo.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @类名:
 * @包名: com.chuan.shirodemo.domain
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/8/25 15:44
 */
@Data
public class UserDO {
    private int id;
    private String username;
    private String password;
    private List<Integer> rolesId=new ArrayList<>();
}
