package com.sd.lib.holder.object;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 对象改变可以被监听的holder
 *
 * @param <T>
 */
public abstract class BaseObjectHolder<T> implements ObjectHolder<T>
{
    private final Map<Callback<T>, byte[]> mCallbacks = new ConcurrentHashMap<>();

    @Override
    public synchronized final void addCallback(Callback<T> callback)
    {
        if (callback == null)
            return;

        mCallbacks.put(callback, null);
    }

    @Override
    public synchronized final void removeCallback(Callback<T> callback)
    {
        mCallbacks.remove(callback);
    }

    @Override
    public synchronized final boolean set(T object)
    {
        final T old = get();
        if (old != object)
        {
            if (saveObject(object))
            {
                for (Callback item : mCallbacks.keySet())
                {
                    item.onObjectChanged(old, object);
                }
                return true;
            }
        }
        return false;
    }

    /**
     * 保存对象
     *
     * @param object
     * @return
     */
    protected abstract boolean saveObject(T object);
}
