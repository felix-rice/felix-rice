package com.felix.rice.core.pattern.singleton;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-01-18
 */
public class UnsafeLazyLoadingSingleton {
    private static UnsafeLazyLoadingSingleton unsafeLazyLoadingSingleton;
    private UnsafeLazyLoadingSingleton() {}

    /**
     * 是否Lazy加载：是
     * 是否线程安全：否
     * 优点：线程不安全安全的懒加载单例模式
     * 缺点：线程不安全
     * @return 单例对象
     */
    public static UnsafeLazyLoadingSingleton getInstance() {
        if (unsafeLazyLoadingSingleton == null) {
            unsafeLazyLoadingSingleton = new UnsafeLazyLoadingSingleton();
        }
        return unsafeLazyLoadingSingleton;
    }
}
