package com.designPattern.StructuralModel.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface UserService{
    public void registerUser();
    public void deleteUser();
}

class UserServiceImpl implements UserService{

    @Override
    public void registerUser() {
        //System.out.println("权限校验...");

        System.out.println("注册一个用户");

        //System.out.println("日志记录...");
    }

    @Override
    public void deleteUser() {

        //System.out.println("权限校验...");

        System.out.println("删除一个用户");

        //System.out.println("日志记录...");
    }

}

/**
 *  动态代理的概述和实现
 */
public class DynamicProxy {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

/**		动态代理概述
		1.代理：本来应该自己做的事情，请了别人来做，被请的人就是代理对象。
		举例：春节回家买票让人代买

		2.在Java中java.lang.reflect包下提供了一个Proxy类和一个InvocationHandler接口
		3.通过使用这个类和接口就可以生成动态代理对象。

		4.JDK提供的代理只能针对接口做代理。

		5.我们有更强大的代理cglib
		6.Proxy类中的方法创建动态代理类对象
			Proxy 通过 newProxyInstance(loader,interfaces,h)创建代理对象
		    InvocationHandler的invoke(proxy,method, args)方法会拦截方法的调用
*/

        //1.创建对象
        UserServiceImpl usi = new UserServiceImpl();
/*		usi.registerUser();
		usi.deleteUser();*/

        //2.创建代理对象

        UserService proxy = (UserService) Proxy.newProxyInstance(usi.getClass().getClassLoader(),
                usi.getClass().getInterfaces(),
                new InvocationHandler() {

                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        // TODO Auto-generated method stub
                        System.out.println(method);
                        System.out.println("权限检验...");

                        //拦截了方法
                        Object returnObj = method.invoke(usi, args);

                        System.out.println("日志记录");
                        return returnObj;
                    }
                });

        //System.out.println(proxy.getClass());
        proxy.registerUser();
        proxy.deleteUser();


    }
}
