package cn.llsmpdroid.belief.base;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;

import java.util.LinkedList;

import cn.llsmpdroid.belief.utils.CrashUtils;
import cn.llsmpdroid.belief.utils.LogUtils;
import cn.llsmpdroid.belief.utils.Utils;

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

    private static XApplication appContext;

    private RefWatcher mRefWatcher;

    public static XApplication getInstance() {
        return appContext;
    }

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
        // 内存泄露检查工具
        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        mRefWatcher = LeakCanary.install(this);
        appContext = this;
        Utils.init(appContext);
        CrashUtils.getInstance().init();
        LogUtils.getBuilder().setTag(getPackageName()).setLog2FileSwitch(true).create();

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

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }
}
