package cn.llsmpdroid.belief.cache;

import android.content.Context;
import android.content.SharedPreferences;

import cn.llsmpdroid.belief.kit.LlsmpDroidConf;
import cn.llsmpdroid.belief.kit.SingletonCtx;


/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */

public class SharedPref extends SingletonCtx<SharedPref> implements ICache {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    static final String SP_NAME = LlsmpDroidConf.CACHE_SP_NAME;

    private SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    @Override
    protected SharedPref newInstance(Context context) {
        return new SharedPref(context);
    }

    @Override
    public void remove(String key) {
        editor.remove(key);
        editor.apply();
    }


    @Override
    public boolean contains(String key) {
        return sharedPreferences.contains(key);
    }

    @Override
    public void clear() {
        editor.clear().apply();
    }


    public void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.apply();
    }

    public int getInt(String key, int defValue) {
        return sharedPreferences.getInt(key, defValue);
    }

    public void putLong(String key, Long value) {
        editor.putLong(key, value);
        editor.apply();
    }

    public long getLong(String key, long defValue) {
        return sharedPreferences.getLong(key, defValue);
    }


    public void putBoolean(String key, Boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBoolean(String key, boolean defValue) {
        return sharedPreferences.getBoolean(key, defValue);
    }


    public void putString(String key, String value) {
        editor.putString(key, value);
        editor.apply();
    }

    public String getString(String key, String defValue) {
        return sharedPreferences.getString(key, defValue);
    }


    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public void put(String key, Object value) {

    }
}
