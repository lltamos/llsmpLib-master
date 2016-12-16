package cn.llsmpdroid.belief.base;

import android.os.Bundle;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */

public interface UiCallback {
    void onInitialization(Bundle savedInstanceState);

    void setListener();

    int getLayoutId();

    boolean useEventBus();

    void onInitDataRemote();
}
