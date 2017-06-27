package com.moby.apply.presenters;

import com.moby.apply.network.CoreApi;

import javax.inject.Inject;

/**
 * Created by patel on 6/26/2017.
 */

public class RegistrationPresenter extends BasePresenter<RegistrationPresenter.RegistrationView> {

    CoreApi mCoreApi;

    @Inject
    public RegistrationPresenter(CoreApi coreApi) {
        mCoreApi = coreApi;
    }

    public interface RegistrationView {

    }
}
