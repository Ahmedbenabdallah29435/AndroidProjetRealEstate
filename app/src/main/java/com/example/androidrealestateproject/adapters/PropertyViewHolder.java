package com.example.androidrealestateproject.adapters;

import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.entity.Property;
import com.squareup.picasso.Picasso;

public class PropertyViewHolder extends RecyclerView.ViewHolder {
    private ImageView propertyImageView;
    private TextView propertyNameTextView;
    private TextView priceTextView;

    public PropertyViewHolder(@NonNull GridLayout itemView) {
        super(itemView);
        propertyImageView = itemView.findViewById(R.id.imageViewProperty);
        propertyNameTextView = itemView.findViewById(R.id.textViewPropertyName);
        priceTextView = itemView.findViewById(R.id.textViewPrice);
    }

    public void bind(Property property) {
        propertyNameTextView.setText(property.getPropertyName());
        priceTextView.setText("Price: $" + property.getPrice());

        if (property.getImageUrls() != null && property.getImageUrls().size() > 0) {
            String firstImageUrl = property.getImageUrls().get(0);
            Picasso.get().load(firstImageUrl).into(propertyImageView);
        }

    }
}

