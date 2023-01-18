package com.felix.rice.core.pattern.singleton;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-01-18
 */
public class SafeStaticInnerClassSingleton {
    private SafeStaticInnerClassSingleton() {}
    private static class SingletonHolder {
        /*
         * 利用类加载机制，一个类只会被加载1次，因为静态内部类仅仅在被调用的时候，才会被加载
         * 1. 只有在调用外部的getInstance方法之后，才会加载静态内部类
         * 2. 静态变量只会加载一次
         */
        private static final SafeStaticInnerClassSingleton safeStaticInnerClassSingleton
                = new SafeStaticInnerClassSingleton();
    }

    public static SafeStaticInnerClassSingleton getInstance() {
        return SingletonHolder.safeStaticInnerClassSingleton;
    }
}
