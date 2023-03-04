package com.contacts.base;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import javax.inject.Inject;

import timber.log.Timber;

public abstract class BaseActivity<VDB extends ViewDataBinding, P extends BaseContract.Presenter>
        extends AppCompatActivity implements BaseContract.View {

    @Inject
    protected P presenter;
    protected VDB binding = null;

    protected NavController navController = findNavController(getFragmentContainerId());

    protected abstract int getLayoutId();

    private int getFragmentContainerId() {
        return -1;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = getDtaBinding();
        presenter.onCreate();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    private VDB getDtaBinding() {
        return DataBindingUtil.setContentView(this, getLayoutId());
    }

    private NavController findNavController(@IdRes int fragmentContainerId) {
        Fragment fragment = getSupportFragmentManager().findFragmentById(fragmentContainerId);
        if (fragment != null) {
            return ((NavHostFragment) fragment).getNavController();
        } else {
            return null;
        }
    }

    public void navigate(NavDirections navDirections) {
        try {
            navController.navigate(navDirections);
        } catch (Exception error) {
            Timber.e(error);
        }
    }

    @Override
    public void onProgress(boolean isProgress) {
        // TODO Progress
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }
}
