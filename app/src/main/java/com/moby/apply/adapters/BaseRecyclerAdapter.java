package com.moby.apply.adapters;

import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by patel on 6/4/2017.
 *
 * Used as a base RecyclerAdapter
 */

public abstract class BaseRecyclerAdapter<T, E extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<E> {

    private List<T> mItems;

    public BaseRecyclerAdapter(){
        mItems = new ArrayList<>();
    }

    public T getItem(int index) {

        if(mItems == null) {
            return null;
        }

        if(index >= mItems.size()) {
            return null;
        }

        return mItems.get(index);
    }

    @Override
    public int getItemCount() {

        if(mItems == null) {
            return 0;
        }

        return mItems.size();
    }

    public void removeItem(int position) {
       if(mItems != null) {
           mItems.remove(position);
           notifyDataSetChanged();
       }
    }

    public void setItems(List<T> items) {
        mItems = items;
        notifyDataSetChanged();
    }
}
