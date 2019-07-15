package com.example.fork27.cnj;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BasePresenter<V> {

    private V mView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();

    protected V getView() {
        return mView;
    }

    public void attachView(V view) {
        mView = view;
    }

    public void detachView() {
        mView = null;
        mCompositeDisposable.dispose();
    }

    protected void addDisposable(Disposable disposable) {
        mCompositeDisposable.add(disposable);
    }
}
