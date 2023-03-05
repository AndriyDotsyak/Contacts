package com.contacts.app.screen.home.favorites;

import com.contacts.base.BasePresenter;
import com.contacts.app.screen.home.favorites.FavoritesContract.*;

import javax.inject.Inject;

public class FavoritesPresenter extends BasePresenter<View> implements Presenter {

    @Inject
    public FavoritesPresenter(View view) {
        super(view);
    }

}
