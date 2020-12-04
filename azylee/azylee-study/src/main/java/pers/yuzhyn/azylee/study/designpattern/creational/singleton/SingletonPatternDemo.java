package pers.yuzhyn.azylee.study.designpattern.creational.singleton;


import pers.yuzhyn.sugar.common.utils.designpattern.creational.singleton.enums.Singleton;

/**
 * 经验之谈：
 * 一般情况下，不建议使用第 1、懒汉式，线程不安全 种和第 2、懒汉式，线程安全 种懒汉方式，建议使用第 3、饿汉式 种饿汉方式。
 * <p>
 * 只有在要明确实现 lazy loading 效果时，才会使用第 5、登记式/静态内部类 种登记方式。
 * <p>
 * 如果涉及到反序列化创建对象时，可以尝试使用第 6、枚举 种枚举方式。
 * <p>
 * 如果有其他特殊的需求，可以考虑使用第 4、双检锁/双重校验锁（DCL，即 double-checked locking） 种双检锁方式。
 */
public class SingletonPatternDemo {
    public static void main(String[] args) {

        //不合法的构造函数
        //编译时错误：构造函数 SingleObject() 是不可见的
        //SingleObject object = new SingleObject();

        //获取唯一可用的对象
        Singleton object = Singleton.INSTANCE;

        //显示消息
        object.whateverMethod();
    }
}