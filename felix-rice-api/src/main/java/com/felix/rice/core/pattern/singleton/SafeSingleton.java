package com.felix.rice.core.pattern.singleton;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-01-18
 */
public class SafeSingleton {
    private static final SafeSingleton safeSingleton = new SafeSingleton();
    private SafeSingleton() {}

    /**
     * 是否Lazy加载：是
     * 是否线程安全：是
     * 优点：线程安全的懒加载单例模式
     * 缺点：非懒加载
     * @return 单例对象
     */
    public static SafeSingleton getInstance() {
        return safeSingleton;
    }
}
