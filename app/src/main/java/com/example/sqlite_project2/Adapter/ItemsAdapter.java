package com.example.sqlite_project2.Adapter;

import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sqlite_project2.ItemsModel;
import com.example.sqlite_project2.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder> {


    private  final RecyclerViewClickListener recyclerViewClickListener;

    private final ArrayList<ItemsModel>itemsModels;

    // Constructor creating

    public ItemsAdapter (ArrayList<ItemsModel>itemsModels,
                         RecyclerViewClickListener recyclerViewClickListener){

        this.itemsModels=itemsModels;

        this.recyclerViewClickListener=recyclerViewClickListener;

    }



    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).
                inflate(R.layout.signle_item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int position) {

        ItemsModel itemsModel=itemsModels.get(position);
        holder.textName.setText(itemsModel.getName());
        holder.textDescription.setText(itemsModel.getDescription());


        Uri image=itemsModel.getImage();
        if(image != null){
            holder.imageView.setImageURI(image);
        }



    }

    @Override
    public int getItemCount() {
        return itemsModels.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        //to set data in onbind at first we need to code on this
        CircleImageView imageView;
        TextView textName, textDescription;

        public ItemViewHolder(View itemView){
            super(itemView);
            // We have connected on create of this adapter with signle so we are using the ides used on it
            imageView= itemView.findViewById(R.id.item_img);
            textName=itemView.findViewById(R.id.item_name);
            textDescription=itemView.findViewById(R.id.item_description);

            itemView.setOnClickListener(this::itemViewClick);

        }
        public void itemViewClick(View view){

            recyclerViewClickListener.onItemClick(view,getAdapterPosition());
        }

    }
}
