/***
 * CopyRight(C), 2018-2020
 * FileName:   userRealm
 * Author:     
 * Date:       2020/2/4 23:30
 * Description:   
 *  <author>       <time>           <version>
 *  作者名字       修改时间          版本
 */
package com.hl.realm;
import com.hl.entity.permission;
import com.hl.entity.user;
import com.hl.mapper.Impl.userMapperImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class userRealm extends AuthorizingRealm {


    @Autowired
    userMapperImpl userDao;

    @Override
    public String getName() {
        return "userRealm";
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        user user = (com.hl.entity.user) principalCollection.getPrimaryPrincipal();
        if(user==null){
            return null;
        }
        List<String> permission =new ArrayList<>();
        if("zhangsan".equals(user.getUsername())){
            permission.add("employee:save");
        }else if("admin".equals(user.getUsername())){
            permission.add("*:*");
        }
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.addStringPermissions(permission);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();

        user user = userDao.selectByUserName(username);
        if(user==null){
            return null;
        }else{
            //第一个参数为对象，第二个为数据库中的密码,第三个是盐，第四个是改类的名字
            SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, user.getPassword(),ByteSource.Util.bytes("黄林"), this.getName());
            return info;
        }
    }

    //清除缓存
    public void clearCached() {
        //获取当前等的用户凭证，然后清除
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }
}
