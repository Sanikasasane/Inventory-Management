package com.example.inventorymanagement.ui.categories;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.inventorymanagement.Category;
import com.example.inventorymanagement.CategoryAdapter;
import com.example.inventorymanagement.R;

import java.util.ArrayList;
import java.util.List;

public class CategoriesFragment extends Fragment {

    private CategoriesViewModel mViewModel;

    public static CategoriesFragment newInstance() {
        return new CategoriesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_categories, container, false);

        GridView categoriesGrid = view.findViewById(R.id.categories_grid);

// Assuming you have a list of category objects (replace with your data source)
        List<Category> categoryList = getCategories(); // Implement your logic to get category data

        CategoryAdapter adapter = new CategoryAdapter(getActivity(), categoryList);
        categoriesGrid.setAdapter(adapter);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);
        // TODO: Use the ViewModel
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


}