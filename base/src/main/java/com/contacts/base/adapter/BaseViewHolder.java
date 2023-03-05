package com.contacts.base.adapter;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BaseViewHolder<I> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    protected abstract void bindItem(I item);

    public Context getContext()  {
        return itemView.getContext();
    }

    public String getString(@StringRes int resId) {
        return getContext().getString(resId);
    }

    public String getString(@StringRes int resId, Object... formatArgs) {
        return getContext().getString(resId, formatArgs);
    }

}