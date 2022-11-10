package com.example.concerto.config;

import com.example.concerto.pojo.Client;
import com.example.concerto.pojo.Courier;
import com.example.concerto.service.CourierServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class CourierRealm extends AuthorizingRealm {

    @Autowired
    CourierServiceImpl courierService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject= SecurityUtils.getSubject();
        Courier courier = (Courier) subject.getPrincipal();
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //编写shiro 判断逻辑，判断用户名和密码
        //1.判断用户名
        UsernamePasswordToken userToken=(UsernamePasswordToken) token;
        //根据用户名获取用户信息
        //userToken.getUsername() 实际保存的是 tel
        Courier courierInfo=courierService.getCourierInfoByTel(userToken.getUsername());

        if(courierInfo == null){
            //用户不存在 shiro底层会抛出 UNknowAccountException
            return null;
        }
        //2.判断密码     第一个参数:需要返回给 subject.login方法的数据   第二个参数：数据库密码       第三个参数：realm的名字
        // return new SimpleAuthenticationInfo(user, user.getPassword(), "");

        //根据用户的情况，来构建AuthenticationInfo对像并返回，通常使用的实现类是SimpleAuthenticationInfo
        //以下信息是从数据库获取的
        //1).principal:认证的实体类信息。可以是username，也可以是数据表对应的用户的体类对象
        Object principal=courierInfo;
        //2).credentials:密码（数据库获取的用户的密码）
        Object credentials=courierInfo.getPassword();
        //3).realmName：当前realm对象的name，调用父类的getName()方法即可
        String realmName=getName();
        //4).盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(courierInfo.getSalt());//盐值 要唯一
        return new SimpleAuthenticationInfo(principal, credentials, credentialsSalt,realmName);
    }
}
