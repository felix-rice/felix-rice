package com.felix.rice.core.pattern.singleton;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2023-01-18
 */
public class SafeDoubleCheckSingleton {
    /**
     * 使用volatile关键词，对象实力例化四个阶段
     * 1. 类加载
     * 2. 在堆上申请空间
     * 3. 执行构造方法，创建对象
     * 4. 将堆地址分配给对象引用
     * 指令会重排序，当4在3之前执行，此时认为对象已经创建完毕，但是实际对象还未初始化，导致获取的对象为null
     */
    private static volatile SafeDoubleCheckSingleton safeDoubleCheckSingleton;
    private SafeDoubleCheckSingleton() {}

    /**
     * 是否Lazy加载：是
     * 是否线程安全：是
     * 优点：线程安全的懒加载单例模式，仅仅在创建的时候加锁
     * 缺点：无缺点
     * @return 单例对象
     */
    public static SafeDoubleCheckSingleton getInstance() {
        if (safeDoubleCheckSingleton == null) {
            synchronized (SafeDoubleCheckSingleton.class) {
                /*
                 * 判空，因为如果有两个线程A、B请求获取单例对象
                 * 1. safeDoubleCheckSingleton == null
                 * 2. A获取单例 B获取单例
                 * 3. A拿到锁，创建对象，B阻塞
                 * 4. A执行完毕，B获取锁
                 * 5. 如果无判空，B此时还会创建一个对象，则无法保证单例；此时判空，则B不会创建对象
                 */
                if (safeDoubleCheckSingleton == null) {
                    safeDoubleCheckSingleton = new SafeDoubleCheckSingleton();
                }
            }
        }
        return safeDoubleCheckSingleton;
    }
}
