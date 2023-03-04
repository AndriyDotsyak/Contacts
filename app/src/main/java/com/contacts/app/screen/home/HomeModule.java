package com.contacts.app.screen.home;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ActivityComponent;

@Module
@InstallIn(ActivityComponent.class)
public abstract class HomeModule {

    @Provides
    static HomeActivity provideActivity(Activity activity) {
        return (HomeActivity) activity;
    }

    @Binds
    abstract HomeContract.View bindActivity(HomeActivity activity);

    @Binds
    abstract HomeContract.Presenter bindPresenter(HomePresenter presenter);

}
