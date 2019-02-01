package com.yairn.wics.basics;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class CardAdapter extends RecyclerView.Adapter<CardHolder> {

    private ArrayList<TypeData> container = null;

    /*
     * The constructor of the adapter requires a container
     */
    public CardAdapter(ArrayList<TypeData> container) {
        this.container = container;
    }

    /*
     * The KittenItemHolder method inflates/creates the Kitten Items based on the kitten_item_card layout
     */
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View cardView = layoutInflater.inflate(R.layout.item_card, parent, false);
        return new CardHolder(cardView);
    }

    /*
     * The onBindViewHolder method, binds the position of the item in the RecycleView with its own data.
     */
    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {

        holder.setType(container.get(position));
        holder.setText();

        holder.setButtonOnClick();

        if(container.get(position).type == Type.Image) {
            holder.setImage();
        } else {
            holder.setImage(container.get(position).resource);
        }
    }

    /* The getItemCount returns the number of items in the Adapter */
    @Override
    public int getItemCount() {
        return container.size();
    }
}
