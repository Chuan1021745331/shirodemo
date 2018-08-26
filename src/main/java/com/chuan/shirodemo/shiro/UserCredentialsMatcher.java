package com.chuan.shirodemo.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * @类名:
 * @包名: com.chuan.shirodemo.shiro
 * @描述: (用一句话描述该文件做什么)
 * @日期: 2018/8/26 13:52
 */
public class UserCredentialsMatcher extends SimpleCredentialsMatcher {
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String password = new String((char[])token.getCredentials());
        String credentials = (String) getCredentials(info);
        return password.equals(credentials);
    }
}
