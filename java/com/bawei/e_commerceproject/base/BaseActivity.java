package com.bawei.e_commerceproject.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bawei.e_commerceproject.contract.Contract;

import org.greenrobot.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity<P extends BasePresenter>extends AppCompatActivity implements Contract.IView {

    public P mPresenter;
    private Unbinder bind;
    private EventBus eventBus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(Layout()!=0){
            setContentView(Layout());
        }
        initView();
        bind = ButterKnife.bind(this);
        eventBus = EventBus.getDefault();
        mPresenter=initPresenter();
        if (mPresenter != null) {
            mPresenter.Attch(this);
        }
        startCoding();
    }

    public  void oninitEventBus(){
        eventBus.register(this);
    }
    protected abstract void startCoding();

    protected abstract P initPresenter();

    protected abstract void initView();

    protected abstract int Layout();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.onEnd();
        mPresenter=null;
        if(eventBus.isRegistered(this)){
            eventBus.unregister(this);
        }
        if (bind != null) {
            bind.unbind();
        }
    }
}
