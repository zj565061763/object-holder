package com.sd.lib.holder.object;

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
     * @return
     */
    boolean set(T object);

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
