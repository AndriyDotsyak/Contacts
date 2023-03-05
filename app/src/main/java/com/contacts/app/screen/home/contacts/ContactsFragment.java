package com.contacts.app.screen.home.contacts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.contacts.app.R;
import com.contacts.app.databinding.FragmentContactsBinding;
import com.contacts.app.screen.home.contacts.ContactsContract.*;
import com.contacts.base.BaseFragment;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ContactsFragment extends BaseFragment<FragmentContactsBinding, Presenter> implements View {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contacts;
    }

    @Override
    public void onViewCreated(@NonNull android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
