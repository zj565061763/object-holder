package com.sd.lib.holder.object;

import java.lang.ref.WeakReference;

/**
 * 弱引用对象holder
 *
 * @param <T>
 */
public class FWeakObjectHolder<T> extends BaseObjectHolder<T>
{
    private WeakReference<T> mWeakReference;

    @Override
    protected boolean saveObject(T object)
    {
        mWeakReference = object == null ? null : new WeakReference<>(object);
        return true;
    }

    @Override
    public T get()
    {
        return mWeakReference == null ? null : mWeakReference.get();
    }
}
