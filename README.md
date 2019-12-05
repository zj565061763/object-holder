# About
这个库的功能主要是用来做对象持有者，当对象持有者里面的对象发生变更的时候会通知回调对象，便于做一些初始化和释放的操作<br>

目前的实现类有：
* FStrongObjectHolder<T> 强引用Holder
* FWeakObjectHolder<T>   弱引用Holder

# Gradle
[![](https://jitpack.io/v/zj565061763/object-holder.svg)](https://jitpack.io/#zj565061763/object-holder)


# 接口
```java
public interface ObjectHolder<T>
{
    /**
     * 添加回调
     *
     * @param callback
     */
    void addCallback(Callback<T> callback);

    /**
     * 移除回调
     *
     * @param callback
     */
    void removeCallback(Callback<T> callback);

    /**
     * 设置对象
     *
     * @param object
     */
    void set(T object);

    /**
     * 获得对象
     *
     * @return
     */
    T get();

    interface Callback<T>
    {
        /**
         * 对象变更回调
         *
         * @param oldObject 旧的对象，可能为null
         * @param newObject 新设置的对象，可能为null
         */
        void onObjectChanged(T oldObject, T newObject);
    }
}
```