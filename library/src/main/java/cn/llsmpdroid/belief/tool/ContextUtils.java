package cn.llsmpdroid.belief.tool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */
public class ContextUtils {


    private static LayoutInflater inflater;

    public static View inflate(Context context, int res) {
        if (inflater == null) {
            inflater = LayoutInflater.from(context);
        }
        return inflater.inflate(res, null);
    }

    /**
     * 获取屏幕宽
     * @param context 上下文
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }

    /**
     * 获取屏幕高
     *
     * @param context 上下文
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getHeight();
    }

    /**
     * 获取当前手机的状态栏的高度
     *
     * @param context 上下文对象
     * @return 当前手机的状态栏的高度
     */
    public static Integer getStatusBarHeight(Context context) {
        Integer height = 0;
        Integer resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0)
            height = context.getResources().getDimensionPixelSize(resourceId);
        return height;
    }
}
