package com.contacts.app.screen.home.contacts;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.contacts.app.R;
import com.contacts.app.databinding.FragmentContactsBinding;
import com.contacts.app.screen.home.adapter.ContactsAdapter;
import com.contacts.app.screen.home.contacts.ContactsContract.*;
import com.contacts.base.BaseFragment;
import com.contacts.data.model.contacts.Contact;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ContactsFragment extends BaseFragment<FragmentContactsBinding, Presenter> implements View {

    private final ContactsAdapter contactsAdapter = new ContactsAdapter();

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contacts;
    }

    @Override
    public void onViewCreated(@NonNull android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        initUI();
        initListeners();
    }

    private void initData() {
        presenter.fetchContacts();
    }

    private void initUI() {
        setupContactsAdapter();
    }

    private void initListeners() {
        contactsAdapter.setOnClickListeners(new ContactsAdapter.OnClickListener() {
            @Override
            public void onClickItem(Contact item) {
                // TODO Show detail contact
            }

            @Override
            public void onClickFavorite(Contact item, boolean isFavorite) {
                if (isFavorite) {
                    presenter.addFavorite(item);
                } else {
                    presenter.removeFavorite(item);
                }
            }
        });
    }

    private void setupContactsAdapter() {
        binding.rvContacts.setAdapter(contactsAdapter);
    }

    @Override
    public void handleContacts(List<Contact> contacts) {
        contactsAdapter.replaceItems(contacts);
    }
}
