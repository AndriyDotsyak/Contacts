package com.contacts.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;

import javax.inject.Inject;

import timber.log.Timber;

public abstract class BaseFragment<VDB extends ViewDataBinding, P extends BaseContract.Presenter>
        extends Fragment implements BaseContract.View {

    @Inject
    protected P presenter;
    protected VDB binding = null;

    protected abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onProgress(boolean isProgress) {
        // TODO Progress
    }

    public void navigate(NavDirections navDirections) {
        try {
            NavHostFragment.findNavController(this).navigate(navDirections);
        } catch (Exception error) {
            Timber.e(error);
        }
    }

    @Override
    public void showToast(String text) {
        Toast.makeText(getContext(), text, Toast.LENGTH_LONG).show();
    }

}
