package com.moby.apply.network;

import com.moby.apply.models.Applicant;
import com.moby.apply.utils.Constants;

import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by patel on 6/26/2017.
 */

public interface CoreApi {

    @POST(Constants.REGISTER)
    public void register(@Body Applicant data);

    @POST(Constants.AUTHENTICATE)
    public void login(@Body Applicant data);
}
