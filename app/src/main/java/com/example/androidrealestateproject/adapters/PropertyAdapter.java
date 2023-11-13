package com.example.androidrealestateproject.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidrealestateproject.R;
import com.example.androidrealestateproject.entity.Property;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PropertyAdapter extends RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(Property property);
    }
    public interface OnItemLongClickListener {
        void onItemLongClick(Property property);
    }

    private OnItemLongClickListener onItemLongClickListener;

    private List<Property> propertyList;
    private OnItemClickListener listener;

    public PropertyAdapter(List<Property> propertyList, OnItemClickListener listener) {
        this.propertyList = propertyList;
        this.listener = listener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener listener) {
        this.onItemLongClickListener = listener;
    }

    @NonNull
    @Override
    public PropertyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        GridLayout itemView = (GridLayout) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_property, parent, false);
        return new PropertyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PropertyViewHolder holder, int position) {
        final Property property = propertyList.get(position);

        holder.bind(property);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onItemClick(property);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (onItemLongClickListener != null) {
                    onItemLongClickListener.onItemLongClick(property);
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        return propertyList.size();
    }

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
                Picasso.get().load(firstImageUrl).into(propertyImageView, new Callback() {
                    @Override
                    public void onSuccess() {
                        // Image loaded successfully
                    }

                    @Override
                    public void onError(Exception e) {
                        propertyImageView.setImageResource(R.drawable.baseline_house);
                    }
                });
            }
        }
    }
}


