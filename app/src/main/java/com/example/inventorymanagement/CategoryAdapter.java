package com.example.inventorymanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CategoryAdapter extends BaseAdapter {

    private Context context;
    private List<Category> categories; // Replace Category with your actual data model class

    public CategoryAdapter(Context context, List<Category> categories) {
        this.context = context;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int position) {
        return categories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position; // You can implement a unique ID generation for categories if needed
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Inflate the category item layout
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.category_item, parent, false);

        // Get references to UI elements in the layout
        ImageView categoryImage = view.findViewById(R.id.category_image);
        TextView categoryName = view.findViewById(R.id.category_name);

        // Get the category data for the current position
        Category category = categories.get(position);

        // Set category image (replace with your logic to set the image based on category data)
        categoryImage.setImageResource(R.drawable.baseline_image_24); // Replace with your image resource

        // Set category name
        categoryName.setText(category.getName());

        return view;
    }
}

