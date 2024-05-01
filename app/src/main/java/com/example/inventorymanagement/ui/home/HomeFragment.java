package com.example.inventorymanagement.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.inventorymanagement.Category;
import com.example.inventorymanagement.CategoryAdapter;
import com.example.inventorymanagement.DisplayItem;
import com.example.inventorymanagement.DisplayItemAdapter;
import com.example.inventorymanagement.R;
import com.example.inventorymanagement.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        LinearLayout categoryContainer = root.findViewById(R.id.category_container);
        LinearLayout recentBuyContainer = root.findViewById(R.id.recent_buy_container);
        HorizontalScrollView recentBuyScroll = root.findViewById(R.id.recent_buy_scroll);




        // Get the list of categories (replace with your data source)
        List<Category> categories = getCategories(); // Implement your logic to get categories

        // Add category views dynamically
        for (Category category : categories) {
            View categoryView = createCategoryView(category); // Implement this method to create a view for each category
            categoryContainer.addView(categoryView);
        }

        List<DisplayItem> recentBuyItems = getRecentBuyItems(); // Implement your logic to get recent buy items
        DisplayItemAdapter adapter = new DisplayItemAdapter(recentBuyItems);

        // Inside your onCreateView method, after getting references:
        recentBuyContainer.removeView(recentBuyContainer); // Remove the LinearLayout

        // Inside your onCreateView method, after getting references:
        recentBuyScroll.removeView(recentBuyContainer); // Remove the LinearLayout

        RecyclerView recentBuyRecyclerView = new RecyclerView(getContext());
        recentBuyRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false)); // Set horizontal layout manager
        recentBuyScroll.addView(recentBuyRecyclerView); // Add RecyclerView to HorizontalScrollView

        recentBuyRecyclerView.setAdapter(adapter); // Set the adapter to the RecyclerView

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    // Implement this method to create a view (e.g., TextView or Button) for each category
    public View createCategoryView(Category category) {

        // Get the fragment's LayoutInflater
        LayoutInflater inflater = getLayoutInflater();

        // Inflate the category item layout (category_item.xml)
        View categoryView = inflater.inflate(R.layout.category_item, null);

        // Get references to UI elements within the layout
        TextView categoryName = categoryView.findViewById(R.id.category_name);
        ImageView categoryImage = categoryView.findViewById(R.id.category_image); // Assuming you have an image view in category_item.xml

        // Set category data
        categoryName.setText(category.getName());

        // Set category image (replace with your logic to set the image based on category data)
        categoryImage.setImageResource(R.drawable.baseline_image_24); // Replace with placeholder or actual image URL

        return categoryView;
    }



    public List<Category> getCategories() {
        List<Category> categories = new ArrayList<>();

        categories.add(new Category(1, "Fruits", "A variety of delicious and healthy fruits", "https://via.placeholder.com/150"));
        categories.add(new Category(2, "Vegetables", "Nutritious vegetables for your meals", "https://via.placeholder.com/150"));
        categories.add(new Category(3, "Spices", "Spices to add flavor to your dishes", "https://via.placeholder.com/150"));
        categories.add(new Category(4, "Grains", "Nutritious grains for your diet", "https://via.placeholder.com/150"));
        categories.add(new Category(5, "Dairy", "Dairy products for various uses", "https://via.placeholder.com/150"));
        categories.add(new Category(6, "Meat", "Variety of meats for your meals", "https://via.placeholder.com/150"));
        categories.add(new Category(7, "Seafood", "Fresh and delicious seafood options", "https://via.placeholder.com/150"));
        categories.add(new Category(8, "Bakery", "Freshly baked goods and breads", "https://via.placeholder.com/150"));
        categories.add(new Category(9, "Condiments", "Sauces, dressings, and other condiments", "https://via.placeholder.com/150"));
        categories.add(new Category(10, "Beverages", "Drinks and beverages for all occasions", "https://via.placeholder.com/150"));
        categories.add(new Category(11, "Snacks", "Quick and convenient snacks", "https://via.placeholder.com/150"));
        categories.add(new Category(12, "Candy", "Sweet treats for everyone", "https://via.placeholder.com/150"));
        categories.add(new Category(13, "Frozen Food", "Frozen meals and ingredients for convenience", "https://via.placeholder.com/150"));
        categories.add(new Category(14, "Pasta", "Varieties of pasta for your dishes", "https://via.placeholder.com/150"));
        categories.add(new Category(15, "Rice", "Different types of rice for your meals", "https://via.placeholder.com/150"));
        categories.add(new Category(16, "Beans", "A variety of nutritious beans", "https://via.placeholder.com/150"));
        categories.add(new Category(17, "Nuts & Seeds", "Healthy nuts and seeds for snacking", "https://via.placeholder.com/150"));
        categories.add(new Category(18, "Oils & Vinegars", "Cooking oils and vinegars", "https://via.placeholder.com/150"));

        return categories;
    }

    public List<DisplayItem> getRecentBuyItems() {
        List<DisplayItem> recentBuyItems = new ArrayList<>();

        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Fresh Apples",
                "2.50"
        ));
        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Organic Broccoli",
                "1.99"
        ));
        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Olive Oil",
                "7.99"
        ));
        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Whole Wheat Bread",
                "3.25"
        ));
        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Gala Apples",
                "1.99"
        ));
        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Red Bell Pepper",
                "0.75"
        ));
        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Brown Rice",
                "4.25"
        ));
        recentBuyItems.add(new DisplayItem(
                "https://via.placeholder.com/150",
                "Oatmeal",
                "3.50"
        ));

        return recentBuyItems;
    }


}