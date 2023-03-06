package com.contacts.app.screen.home.contact_detail;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.contacts.app.R;
import com.contacts.app.databinding.FragmentContactDetailBinding;
import com.contacts.app.screen.home.contact_detail.ContactDetailContract.*;
import com.contacts.base.BaseFragment;
import com.contacts.data.model.contacts.Contact;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class ContactDetailFragment extends BaseFragment<FragmentContactDetailBinding, Presenter> implements View {

    private ContactDetailFragmentArgs args = null;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_contact_detail;
    }

    @Override
    public void onViewCreated(@NonNull android.view.View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        initListeners();
    }

    private void initData() {
        args = ContactDetailFragmentArgs.fromBundle(getArguments());
        presenter.fetchContact(args.getUid());
    }

    private void initListeners() {
        binding.btnBack.setOnClickListener(view -> {
            getNavController().popBackStack();
        });
    }

    @Override
    public void handleContact(Contact contact) {
        binding.setContact(contact);
        setupAvatar(contact);
    }

    private void setupAvatar(Contact contact) {
        Glide.with(getContext()).load(contact.avatar)
                .placeholder(R.drawable.ic_person).into(binding.ivAvatar);
    }
}
