package com.contacts.base;

import io.reactivex.disposables.CompositeDisposable;

public abstract class BasePresenter<V extends BaseContract.View> implements BaseContract.Presenter {

    protected V view;
    protected CompositeDisposable compositeDisposable = new CompositeDisposable();

    public BasePresenter(V view) {
        this.view = view;
    }

    @Override
    public void onCreate() { }

    @Override
    public void onStart() { }

    @Override
    public void onStop() { }

    @Override
    public void onDestroy() {
        compositeDisposable.clear();
    }

}
