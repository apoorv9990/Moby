package com.moby.apply.activities;

import android.support.v7.app.AppCompatActivity;

import com.moby.apply.presenters.BasePresenter;

/**
 * Created by patel on 6/26/2017.
 */

public class BaseActivity extends AppCompatActivity {

    private BasePresenter mPresenter;

    protected void setPresenter(BasePresenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onDestroy() {
        if(mPresenter != null)
            mPresenter.onDestroy();

        super.onDestroy();
    }
}
