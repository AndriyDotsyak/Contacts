package com.contacts.base.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<I, VH extends BaseViewHolder<I>> extends RecyclerView.Adapter<VH> {

    protected ArrayList<I> items = new ArrayList<>();

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.bindItem(items.get(position));
    }

    public View layoutInflate(@LayoutRes int resource, ViewGroup parent) {
        return LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);
    }

    public void addItems(List<I> items) {
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void addItem(I item) {
        int position = items.size();
        items.add(position, item);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        items.remove(position);
        notifyItemRemoved(position);
    }

    public void replaceItems(List<I> items) {
        this.items.clear();
        this.items.addAll(items);
        notifyDataSetChanged();
    }

    public void updateItem(I item, int index) {
        items.set(index, item);
        notifyItemChanged(index, item);
    }

    public void updateItem(I item) {
        int itemIndex = getIndex(item);
        if (itemIndex != RecyclerView.NO_POSITION) {
            updateItem(item, itemIndex);
        }
    }

    public void clear() {
        items.clear();
        notifyDataSetChanged();
    }

    public int getIndex(I item) {
        return items.indexOf(item);
    }

    public I getItem(int index) {
        return items.get(index);
    }

    public List<I> items() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

}

