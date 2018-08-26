package com.chuan.shirodemo.shiro;

import com.chuan.shirodemo.domain.RoleDO;
import com.chuan.shirodemo.domain.UserDO;
import com.chuan.shirodemo.service.RoleService;
import com.chuan.shirodemo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @类名:
 * @包名: com.chuan.shirodemo.shiro
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/8/25 22:30
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        UserDO user = (UserDO) principals.getPrimaryPrincipal();
        //通过userId获取角色
        List<RoleDO> roleList = roleService.list(user.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> roleStrSet = roleList.stream().map(role -> role.getName()).collect(Collectors.toSet());
        info.setRoles(roleStrSet);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取token信息
        String username = (String) token.getPrincipal();
        String password = new String((char[])token.getCredentials());
        //验证
        if(StringUtils.isEmpty(username)||StringUtils.isEmpty(password)){
            throw new UnknownAccountException("账号或密码不正确");
        }
        //通过username获取用户信息
        Map<String,Object> param=new HashMap<>();
        param.put("username",username);
        List<UserDO> userList = userService.list(param);
        if(userList==null||userList.size()==0){
            throw  new AuthenticationException("用户名不存在 ");
        }
        //加盐
        ByteSource passwordSolt = ByteSource.Util.bytes(username);
        UserDO user = userList.get(0);
        //验证密码
        /*if(!password.equals(user.getPassword())){
            throw new AuthenticationException("账号或密码不正确");
        }*/
        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(), passwordSolt, getName());
        return simpleAuthenticationInfo;
    }
}
