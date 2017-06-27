package com.moby.apply.dagger.component;

import com.moby.apply.activities.LoginActivity;
import com.moby.apply.activities.RegistrationActivity;
import com.moby.apply.dagger.module.ApiModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by patel on 6/26/2017.
 */

@Singleton
@Component(modules = {ApiModule.class})
public interface CoreComponent {
    void inject(LoginActivity activity);
    void inject(RegistrationActivity activity);
}
