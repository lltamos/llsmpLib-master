package cn.llsmpdroid.belief.base;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;

import java.util.LinkedList;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2017/1/9
 */
public abstract class XApplication extends Application {

    private static Handler mHandler = new Handler();

    // 用于存放所有启动的Activity的集合
    private LinkedList<Activity> mActivityList;

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        // 存放所有activity的集合
        mActivityList = new LinkedList<>();
    }


    public Handler getHandler() {
        return mHandler;
    }

    /**
     * 添加Activity
     */
    public void addActivity(Activity activity) {
        if (!mActivityList.contains(activity)) {
            mActivityList.addFirst(activity);
        }
    }

    /**
     * 销毁单个Activity
     */
    public void removeActivity(Activity activity) {
        if (mActivityList.contains(activity)) {
            mActivityList.remove(activity);
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }

    /**
     * 销毁所有的Activity
     */
    public void removeAllActivity() {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
