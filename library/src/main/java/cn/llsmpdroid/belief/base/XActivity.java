package cn.llsmpdroid.belief.base;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.WindowManager;

import butterknife.Unbinder;
import cn.llsmpdroid.belief.R;
import cn.llsmpdroid.belief.manager.event.BusFactory;
import cn.llsmpdroid.belief.kit.KnifeKit;
import cn.llsmpdroid.belief.utils.SystemBarTintManager;


/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */

public abstract class XActivity extends AppCompatActivity implements UiCallback {

    /**
     * main thread
     */
    private long mUIThreadId;
    protected Activity context;
    protected UiDelegate uiDelegate;
    private Unbinder unbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUIThreadId = android.os.Process.myTid();
        this.context = this;
        isAlive = true;
        resolveIntentValue(getIntent());
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
            unbinder = KnifeKit.bind(this);
        }

        if (getSupportToolBar() != null)
            setSupportActionBar(getSupportToolBar());
        initWindow();
        setListener();
        this.onInitialization(savedInstanceState);
        this.onInitDataRemote();
    }


    @Override
    public void onInitDataRemote() {
    }

    protected void resolveIntentValue(Intent intent) {
    }

    protected Toolbar getSupportToolBar() {
        return null;
    }


    protected UiDelegate getUiDelegate() {
        if (uiDelegate == null) {
            uiDelegate = UiDelegateBase.create(this);
        }
        return uiDelegate;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (useEventBus()) {
            BusFactory.getBus().register(this);
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        getUiDelegate().resume();
        isRunning = true;
    }


    @Override
    protected void onPause() {
        super.onPause();
        getUiDelegate().pause();
        isRunning = false;
    }

    @Override
    protected void onStop() {
        super.onStop();
        BusFactory.getBus().unregister(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isAlive = false;
        isRunning = false;
        progressDialog = null;
        KnifeKit.unbind(unbinder);
        getUiDelegate().dispose();
    }

    /**
     * @return UI线程ID
     */
    public long getUIThreadId() {
        return mUIThreadId;
    }

    private SystemBarTintManager tintManager;

    @TargetApi(19)
    private void initWindow() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && isSetStatusBar()) {
            getWindow().addFlags(
                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintEnabled(true);
            tintManager.setStatusBarTintResource(R.color.x_blue);
        }
    }

    protected void setStatusBarTintRes(int color) {
        if (tintManager != null) {
            tintManager.setStatusBarTintResource(color);
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        mUIThreadId = android.os.Process.myTid();
        super.onNewIntent(intent);
    }

    /**
     * 是否设置沉浸式
     *
     * @return true
     */
    protected boolean isSetStatusBar() {
        return true;
    }

    private static final String TAG = "XActivity";
    private boolean isAlive = false;
    private boolean isRunning = false;

    protected ProgressDialog progressDialog = null;

    public void showProgressDialog(int stringResId) {
        try {
            showProgressDialog(null, context.getResources().getString(stringResId));
        } catch (Exception e) {
            Log.e(TAG, "showProgressDialog  showProgressDialog(null, context.getResources().getString(stringResId));");
        }
    }

    /**
     * @param dialogMessage msg
     */
    public void showProgressDialog(String dialogMessage) {
        showProgressDialog(null, dialogMessage);
    }

    /**
     * @param dialogTitle   标题
     * @param dialogMessage 信息
     */
    public void showProgressDialog(final String dialogTitle, final String dialogMessage) {
        runUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog == null) {
                    progressDialog = new ProgressDialog(context);
                }
                if (progressDialog.isShowing()) {
                    progressDialog.dismiss();
                }
                if (dialogTitle != null && !"".equals(dialogTitle.trim())) {
                    progressDialog.setTitle(dialogTitle);
                }
                if (dialogMessage != null && !"".equals(dialogMessage.trim())) {
                    progressDialog.setMessage(dialogMessage);
                }
                progressDialog.setCanceledOnTouchOutside(false);
                progressDialog.show();
            }
        });
    }


    /**
     * 隐藏加载进度
     */
    public void dismissProgressDialog() {
        runUiThread(new Runnable() {
            @Override
            public void run() {
                if (progressDialog == null || !progressDialog.isShowing()) {
                    Log.w(TAG, "dismissProgressDialog  progressDialog == null" +
                            " || progressDialog.isShowing() == false >> return;");
                    return;
                }
                progressDialog.dismiss();
            }
        });
    }

    public final void runUiThread(Runnable action) {
        if (!isAlive()) {
            Log.w(TAG, "runUiThread  isAlive() == false >> return;");
            return;
        }
        runOnUiThread(action);
    }


    public boolean isAlive() {
        return isAlive;
    }


    public final boolean isRunning() {
        return isRunning & isAlive();
    }

}
