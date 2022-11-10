package com.example.concerto.config;

import com.example.concerto.pojo.Client;
import com.example.concerto.service.ClientServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class ClientRealm extends AuthorizingRealm {

    @Autowired
    ClientServiceImpl clientService;
    /**
     * 执行授权逻辑
     * 当访问到页面的时候，链接配置了相应的权限或者shiro标签才会执行此方法否则不会执行
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //添加资源的授权字符串
        //info.addStringPermission("user:add");

        //导数据库查询当前登录用户的授权字符串
        //获取当前登录用户
        Subject subject= SecurityUtils.getSubject();

        Client client = (Client) subject.getPrincipal();

        //Client clientInfo=clientService.getClientInfoById(client.getId());

        //info.addStringPermission(memberInfo.getPerms());
        return info;
    }

    /**
     * 执行认证逻辑
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        //编写shiro 判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        //根据用户名获取用户信息
        //userToken.getUsername() 实际保存的是 tel
        Client clientInfo=clientService.getClientInfoByTel(userToken.getUsername());

        if(clientInfo == null){
            //用户不存在 shiro底层会抛出 UNknowAccountException
            return null;
        }
        //2.判断密码     第一个参数:需要返回给 subject.login方法的数据   第二个参数：数据库密码       第三个参数：realm的名字
        // return new SimpleAuthenticationInfo(user, user.getPassword(), "");

        //根据用户的情况，来构建AuthenticationInfo对像并返回，通常使用的实现类是SimpleAuthenticationInfo
        //以下信息是从数据库获取的
        //1).principal:认证的实体类信息。可以是username，也可以是数据表对应的用户的体类对象
        Object principal=clientInfo;
        //2).credentials:密码（数据库获取的用户的密码）
        Object credentials=clientInfo.getPassword();
        //3).realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName=getName();
        //4).盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(clientInfo.getSalt());//盐值 要唯一
        return new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,realmName);
    }
}
