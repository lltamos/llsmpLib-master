package idroid.app.ui;

import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.llsmpdroid.belief.base.XActivity;
import cn.llsmpdroid.belief.manager.log.XLog;
import cn.llsmpdroid.belief.utils.LogUtils;
import idroid.app.R;

public class MainActivity extends XActivity {


    @Override
    public void onInitialization(Bundle savedInstanceState) {

    }

    @Override
    public void setListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public boolean useEventBus() {
        return false;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
    }

    @Override
    protected void initVariables() {

    }

    @OnClick(R.id.btn1)
    public void onClick() {
        XLog.d("xxxx", "aaa");

        LogUtils.i("xxxxxxxxxccc");

    }
}
