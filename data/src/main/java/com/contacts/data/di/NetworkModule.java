package com.contacts.data.di;

import com.contacts.data.BuildConfig;
import com.contacts.data.network.api.ContactsApi;
import com.contacts.data.util.NetworkUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import okhttp3.OkHttpClient;

@Module
@InstallIn(SingletonComponent.class)
public class NetworkModule {

    @Provides
    ContactsApi provideAuthenticationApi(OkHttpClient httpClient) {
        return NetworkUtil.buildRetrofit(BuildConfig.ENDPOINT, httpClient)
                .create(ContactsApi.class);
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {
        return NetworkUtil.getOkHttpBuilder().build();
    }

}
