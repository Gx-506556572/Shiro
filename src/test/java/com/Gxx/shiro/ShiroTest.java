package com.Gxx.shiro;

import com.gxx.common.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;
import sun.security.provider.MD5;

public class ShiroTest  {
    @Test
    public void test(){
        //初始化shiro安全管理器
        DefaultSecurityManager securityManager=new DefaultSecurityManager();
        //设置用户权限信息到安全管理器
        Realm realm=new IniRealm("classpath:shiro.ini");
        securityManager.setRealm(realm);
        //使用SecurityUtils将securityManager设置到运行环境
        SecurityUtils.setSecurityManager(securityManager);
        //创建一个subject实例
        Subject subject=SecurityUtils.getSubject();
        //创建用于认证的token,记录用户的身份和凭证
        AuthenticationToken token=new UsernamePasswordToken("gxx","123456");
        //主体登陆
        subject.login(token);
        //用户认证状态
        System.out.println("用户认证状态："+subject.isAuthenticated());
        System.out.println("是否拥有admin角色："+subject.hasRole("admin"));
        System.out.println("是否拥有delete权限："+subject.isPermitted("product:delete"));
        System.out.println("用户名："+subject.getPrincipal());
        subject.logout();
        System.out.println("用户认证状态："+subject.isAuthenticated());

    }
    @Test
    public void test2(){
        Subject subject=ShiroUtil.login("gxx","123456");
        System.out.println("检查新增用户权限"+subject.isPermitted("sys:user:create"));
        System.out.println("检查是否是运维角色"+subject.hasRole("运维"));
    }

    @Test
    public void test03(){
        //加密
        String Md5=new Md5Hash("1111").toString();
        System.out.println(Md5);
        String Md5_salt=new Md5Hash("1111","abc").toString();
        System.out.println(Md5_salt);
        String Md5_salt_c=new Md5Hash("1111","abc",5).toString();
        System.out.println(Md5_salt_c);
    }

}
