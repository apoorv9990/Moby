package com.moby.apply.presenters;

import com.moby.apply.network.CoreApi;

import javax.inject.Inject;

/**
 * Created by patel on 6/26/2017.
 */

public class LoginPresenter extends BasePresenter<LoginPresenter.LoginView> {

    CoreApi mCoreApi;

    @Inject
    public LoginPresenter(CoreApi coreApi) {
        mCoreApi = coreApi;
    }

    public void login() {
        getView().loginSuccessful();
    }

    public interface LoginView {
        void loginSuccessful();
    }
}
