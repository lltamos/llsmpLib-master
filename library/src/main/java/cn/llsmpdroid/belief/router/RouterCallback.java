package cn.llsmpdroid.belief.router;

import android.app.Activity;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */

public interface RouterCallback {

    void onBefore(Activity from, Class<?> to);

    void OnNext(Activity from, Class<?> to);

    void onError(Activity from, Class<?> to, Throwable throwable);

}
