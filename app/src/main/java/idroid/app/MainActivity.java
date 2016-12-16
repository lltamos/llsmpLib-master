package idroid.app;

import android.os.Bundle;

import cn.llsmpdroid.belief.base.XActivity;

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
}
