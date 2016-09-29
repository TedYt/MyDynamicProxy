package com.ted.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

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
 */
public class DynamicProxy implements InvocationHandler {

    // 被代理类的实例
    Object obj = null;

    // 被代理类的实例传进动态代理类的构造函数中
    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    /**
     * 覆盖InvocationHandler 接口中的方法invoke() 方法
     *
     * 更重要的是，动态代理模式可以使得我们在不改变原来已有代码结构的情况下，对原来的
     * “真实方法”进行扩展，增强其功能，并且可以达到控制被代理对象的行为，
     * 下面的before，after就是我们可以进行特殊代码切入的扩展点
     *
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        /*
         * before: do something
         */
        Object result = method.invoke(this.obj, args);

        /*
         * after: do something
         */
        return result;
    }
}
