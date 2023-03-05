package com.contacts.app.screen.home.favorites;

import androidx.fragment.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;

@Module
@InstallIn(FragmentComponent.class)
public abstract class FavoritesModule {

    @Provides
    static FavoritesFragment provideFragment(Fragment fragment) {
        return (FavoritesFragment) fragment;
    }

    @Binds
    abstract FavoritesContract.View bindFragment(FavoritesFragment fragment);

    @Binds
    abstract FavoritesContract.Presenter bindPresenter(FavoritesPresenter presenter);

}
