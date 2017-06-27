package com.moby.apply.dagger.module;

import com.moby.apply.network.CoreApi;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by patel on 6/26/2017.
 */

@Module
public class ApiModule {
    String mBaseUrl;

    public ApiModule(String baseUrl) {
        this.mBaseUrl = baseUrl;
    }

    // Provides OkHttpClient object through dependency injection
    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        builder = builder.addInterceptor(interceptor);
        builder = builder.connectTimeout(60, TimeUnit.SECONDS);

        return builder.build();
    }

    // Provides CoreApi object through dependency injection
    @Provides
    @Singleton
    CoreApi provideRetrofit(OkHttpClient okHttpClient) {
        CoreApi retrofit = new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(CoreApi.class);
        return retrofit;
    }
}
