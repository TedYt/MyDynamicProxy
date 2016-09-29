package com.ted.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Copyright (C) 2008 The Android Open Source Project
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * <p/>
 * Created by Ted.Yt on 9/29/16.
 *
 *
 * 测试类
 */
public class Client {

    public static void test(){

        // 被代理类的实例
        AbstractSubject realSubject = new RealSubject();

        // 获得被代理类的类加载器，使得JVM能够加载并找到被代理类的内部结构，以及已实现的interface
        ClassLoader loader = realSubject.getClass().getClassLoader();

        // 获得被代理类已实现的所有接口interface，
        Class<?>[] interfaces = realSubject.getClass().getInterfaces();

        // 用被代理类的实例创建动态代理类的实例，用于真正调用处理程序
        InvocationHandler handler = new DynamicProxy(realSubject);

        // 用上面三个参数获得 代理类的对象，
        // >>>>>这里既是动态获取代理类<<<<<<
        AbstractSubject proxy = (AbstractSubject) Proxy.newProxyInstance(
                loader,interfaces,handler);

        proxy.request();

        //打印出该代理实例的名称
        System.out.println(proxy.getClass().getName());
    }
}
