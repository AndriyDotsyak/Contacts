package com.contacts.app.screen.home;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.navigation.ui.NavigationUI;

import com.contacts.app.R;
import com.contacts.app.databinding.ActivityHomeBinding;
import com.contacts.app.screen.home.HomeContract.*;
import com.contacts.base.BaseActivity;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeActivity extends BaseActivity<ActivityHomeBinding, Presenter> implements View {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.navHostFragment;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initUI();
    }

    private void initUI() {
        NavigationUI.setupWithNavController(binding.bottomNavigation, navController);
    }

}
