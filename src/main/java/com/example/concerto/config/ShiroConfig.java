package com.example.concerto.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authc.pam.AtLeastOneSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        //设置安全管理器
        bean.setSecurityManager(securityManager);

        /**
         * Shiro内置过滤器，可以实现权限相关的拦截
         *    常用的过滤器：
         *       anon:无需认证（登录）可以访问
         *       authc:必须认证才可以访问
         *       user:如果使用rememberMe的功能可以直接访问
         *       perms:该资源必须得到资源权限才可以访问
         *       role:该资源必须得到角色权限才可以访问
         */

        Map<String,String> filter = new LinkedHashMap<String,String>();
        //授权  正常情况下未授权会跳转到未授权页面
        filter.put("/*","anon");
        filter.put("/wx/*","anon");
        filter.put("/login","anon");
        filter.put("/register","anon");
        filter.put("/*", "authc");
        bean.setFilterChainDefinitionMap(filter);
        //没有权限的话设置登录页请求
        bean.setLoginUrl("/toLogin");
        bean.setUnauthorizedUrl(("/noAuth"));
        return bean;
    }

    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("clientRealm") ClientRealm clientRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //关联realm(单个realm)
        //securityManager.setRealm(userRealm);
        //设置realm（需要在realm定义之前）
        securityManager.setAuthenticator(modularRealmAuthenticator());
        //添加多个realms
        List<Realm> realms =new ArrayList<Realm>();
        realms.add(clientRealm);
        realms.add(courierRealm());
        realms.add(managerRealm());
        securityManager.setRealms(realms);
        return securityManager;
    }

    @Bean
    public ClientRealm clientRealm(){
        ClientRealm clientRealm = new ClientRealm();
        clientRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return clientRealm;
    }

    @Bean
    public CourierRealm courierRealm(){
        CourierRealm courierRealm = new CourierRealm();
        courierRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return courierRealm;
    }

    @Bean
    public ManagerRealm managerRealm(){
        ManagerRealm managerRealm = new ManagerRealm();
        managerRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return managerRealm;
    }

    /**
     * 配置 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了,
     * 所以我们需要修改下中的代码;）
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置加密算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //设置加密次数，比如两次，相当于md5(md5())
        hashedCredentialsMatcher.setHashIterations(1024);
        return hashedCredentialsMatcher;
    }

    /**
     * 系统自带的Realm管理，主要针对多realm
     */
    @Bean
    public ModularRealmAuthenticator modularRealmAuthenticator(){
        //自己重写的ModularRealmAuthenticator
        UserModularRealmAuthenticator modularRealmAuthenticator = new UserModularRealmAuthenticator();
        //设置认证策略
        modularRealmAuthenticator.setAuthenticationStrategy(new AtLeastOneSuccessfulStrategy());
        //ModularRealmAuthenticator modularRealmAuthenticator = new ModularRealmAuthenticator();
        //设置认证策略
        //modularRealmAuthenticator.setAuthenticationStrategy(new AllSuccessfulStrategy());
        return modularRealmAuthenticator;
    }

    //加入注解的使用
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }
}
