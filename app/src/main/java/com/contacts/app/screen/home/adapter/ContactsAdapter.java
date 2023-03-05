package com.contacts.app.screen.home.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.contacts.app.R;
import com.contacts.app.databinding.ItemContactBinding;
import com.contacts.base.adapter.BaseRecyclerAdapter;
import com.contacts.base.adapter.BaseViewHolder;
import com.contacts.app.screen.home.adapter.ContactsAdapter.ContactsViewHolder;
import com.contacts.data.model.contacts.Contact;

public class ContactsAdapter extends BaseRecyclerAdapter<Contact, ContactsViewHolder> {

    private OnClickListener onClickListener = null;

    public interface OnClickListener {
        void onClickItem(Contact item);
        void onClickFavorite(Contact item, boolean isFavorite);
    }

    @NonNull
    @Override
    public ContactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ContactsViewHolder(layoutInflate(R.layout.item_contact, parent));
    }

    public void setOnClickListeners(OnClickListener listener) {
        onClickListener = listener;
    }

    public class ContactsViewHolder extends BaseViewHolder<Contact> {

        private Contact item = null;
        private ItemContactBinding binding = ItemContactBinding.bind(itemView);

        public ContactsViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        @Override
        protected void bindItem(Contact item) {
            this.item = item;

            initBinding();
            initUI();
            initListeners();
        }

        private void initBinding() {
            binding.setContact(item);
        }

        private void initUI() {
            setupAvatar();
        }

        private void initListeners() {
            binding.getRoot().setOnClickListener(v -> {
                onClickListener.onClickItem(item);
            });
            binding.cbFavorite.setOnCheckedChangeListener((buttonView, isChecked) -> {
                onClickListener.onClickFavorite(item, isChecked);
            });
        }

        private void setupAvatar() {
            Glide.with(getContext()).load(item.avatar)
                    .placeholder(R.drawable.ic_person).into(binding.ivAvatar);
        }

    }
}
