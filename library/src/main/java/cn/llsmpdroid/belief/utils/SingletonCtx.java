package cn.llsmpdroid.belief.utils;

import android.content.Context;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */

public abstract class SingletonCtx<T> {

    private T instance;

    protected abstract T newInstance(Context context);

    public final T getInstance(Context context) {
        if (instance == null) {
            synchronized (SingletonCtx.class) {
                if (instance == null) {
                    instance = newInstance(context);
                }
            }
        }
        return instance;
    }
}
