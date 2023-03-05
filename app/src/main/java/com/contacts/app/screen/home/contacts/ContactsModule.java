package com.contacts.app.screen.home.contacts;

import androidx.fragment.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;

@Module
@InstallIn(FragmentComponent.class)
public abstract class ContactsModule {

    @Provides
    static ContactsFragment provideFragment(Fragment fragment) {
        return (ContactsFragment) fragment;
    }

    @Binds
    abstract ContactsContract.View bindFragment(ContactsFragment fragment);

    @Binds
    abstract ContactsContract.Presenter bindPresenter(ContactsPresenter presenter);

}
