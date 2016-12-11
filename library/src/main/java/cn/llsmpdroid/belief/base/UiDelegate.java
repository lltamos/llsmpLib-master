package cn.llsmpdroid.belief.base;

import android.view.View;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */

public interface UiDelegate {

    void resume();
    void pause();
    void dispose();

    void visible(boolean flag, View view);
    void gone(boolean flag, View view);
    void inVisible(View view);

    void toastShort(String msg);
    void toastLong(String msg);

}
