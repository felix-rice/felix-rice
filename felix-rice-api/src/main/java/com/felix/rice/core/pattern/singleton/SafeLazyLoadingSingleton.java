package com.felix.rice.core.pattern.singleton;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-01-18
 */
public class SafeLazyLoadingSingleton {
    private static SafeLazyLoadingSingleton safeLazyLoadingSingleton;
    private SafeLazyLoadingSingleton() {}

    /**
     * 是否Lazy加载：是
     * 是否线程安全：是
     * 优点：线程安全的懒加载单例模式
     * 缺点：每次获取对象都需要加锁，效率不高
     * @return 单例对象
     */
    public static synchronized SafeLazyLoadingSingleton getInstance() {
        if (safeLazyLoadingSingleton == null) {
            safeLazyLoadingSingleton = new SafeLazyLoadingSingleton();
        }
        return safeLazyLoadingSingleton;
    }
}
