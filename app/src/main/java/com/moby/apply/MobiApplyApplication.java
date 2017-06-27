package com.moby.apply;

import android.app.Application;

import com.moby.apply.dagger.component.CoreComponent;
import com.moby.apply.dagger.component.DaggerCoreComponent;
import com.moby.apply.dagger.module.ApiModule;

/**
 * Created by patel on 6/26/2017.
 */

public class MobiApplyApplication extends Application {
    private CoreComponent mCoreComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mCoreComponent = DaggerCoreComponent.builder()
                .apiModule(new ApiModule(getResources().getString(R.string.base_url)))
                .build();
    }

    public CoreComponent getCoreComponent() {
        return mCoreComponent;
    }
}
