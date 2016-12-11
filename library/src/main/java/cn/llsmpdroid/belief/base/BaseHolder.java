package cn.llsmpdroid.belief.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * <p>Title:${type_inName}<p/>
 * <p>Description:<p/>
 * <p>Company: </p>
 *
 * @author litao
 * @mail llsmpsvn@gmail.com
 * @date on 2016/12/5
 */
public abstract class BaseHolder<T> extends RecyclerView.ViewHolder {
    protected View mView;
    protected T mData;
    protected Context mContext;

    public View getView() {
        return mView;
    }

    public BaseHolder(View view) {
        super(view);
        this.mView = view;
        mContext = this.mView.getContext();
        ButterKnife.bind(this, mView);
        init();
    }


    public void init() {

    }

    ;

    public void setData(T mData) {
        this.mData = mData;
    }
}
