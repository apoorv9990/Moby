package com.moby.apply.presenters;

import android.support.annotation.CallSuper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by patel on 6/24/2017.
 */

public abstract class BasePresenter<T>{
    protected T view;

    protected T getView() {
        return view;
    }

    public void attachView(T view) {
        this.view = view;
    }

    public void onDestroy() {
        view = null;
    }
}
