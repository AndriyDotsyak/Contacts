package com.contacts.app.screen.home.contact_detail;

import androidx.fragment.app.Fragment;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;

@Module
@InstallIn(FragmentComponent.class)
public abstract class ContactDetailModule {

    @Provides
    static ContactDetailFragment provideFragment(Fragment fragment) {
        return (ContactDetailFragment) fragment;
    }

    @Binds
    abstract ContactDetailContract.View bindFragment(ContactDetailFragment fragment);

    @Binds
    abstract ContactDetailContract.Presenter bindPresenter(ContactDetailPresenter presenter);

}
