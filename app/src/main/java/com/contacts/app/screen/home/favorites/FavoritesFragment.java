package com.contacts.app.screen.home.favorites;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.contacts.app.R;
import com.contacts.app.databinding.FragmentFavoritesBinding;
import com.contacts.base.BaseFragment;
import com.contacts.app.screen.home.favorites.FavoritesContract.*;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FavoritesFragment extends BaseFragment<FragmentFavoritesBinding, Presenter> implements View {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_favorites;
    }

    @Override
    public void onViewCreated(@NonNull android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
