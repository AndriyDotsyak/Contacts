package com.contacts.app.screen.home;

import com.contacts.app.screen.home.HomeContract.*;
import com.contacts.base.BasePresenter;

import javax.inject.Inject;

public class HomePresenter extends BasePresenter<View> implements Presenter {

    @Inject
    HomePresenter(HomeContract.View view) {
        super(view);
    }
}
