package com.example.inventorymanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

public class DisplayItemAdapter extends RecyclerView.Adapter<DisplayItemAdapter.ViewHolder> {

    private List<DisplayItem> items;

    public DisplayItemAdapter(List<DisplayItem> items) {
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.dispaly_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        DisplayItem item = items.get(position);

        // Load image using an image loading library (consider using Glide or Picasso)
//        Glide.with(holder.itemView.getContext()).load(item.getImageUrl())
//                .into(holder.imageView);


        holder.priceTextView.setText(item.getPrice()); // Format price with 2 decimal places
        holder.nameTextView.setText(item.getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ShapeableImageView imageView;
        TextView priceTextView;
        TextView nameTextView;
        Button addToCartButton;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.category_image);
            priceTextView = itemView.findViewById(R.id.item_price);
            nameTextView = itemView.findViewById(R.id.item_name);
            addToCartButton = itemView.findViewById(R.id.add_to_cart); // Assuming you have an Add button

            // Handle button clicks or other interactions here (optional)
        }
    }
}

