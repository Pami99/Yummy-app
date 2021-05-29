package com.example.cookingrecipe;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class SearchFoodAdapter extends RecyclerView.Adapter<SearchFoodAdapter.ViewHolder> implements Filterable {

    private static final String TAG = "RecyclerAdapter";
    List<FoodItem>foodItems;
    List<FoodItem>foodItemsAll;
    private Context mcontext;


    public SearchFoodAdapter(Context context, List<FoodItem> foodItems) {
        this.foodItems=foodItems;
        this.mcontext = context;
        ////////////////
        this.foodItemsAll=new ArrayList<>(foodItems);
        ///////////////
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.search_food_holder1, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // holder.rowCountTextView.setText(String.valueOf(position));
        // holder.textView.setText((CharSequence) foodItems.get(position));
        final FoodItem temp = foodItems.get(position);

        holder.time.setText(String.format("%d mins ", foodItems.get(position).getTime()));
        holder.image.setImageResource(foodItems.get(position).getImage());
        holder.title.setText(foodItems.get(position).getName());
        holder.ratingBar.setRating(foodItems.get(position).getRating());
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mcontext,Recipe.class);
                intent.putExtra("title",temp.getName());
                intent.putExtra("image",temp.getImage());
                intent.putExtra("ratingBar",temp.getRating() );
                intent.putExtra("time",temp.getTime());
                intent.putExtra("clicked_foodName",temp.getName());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mcontext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodItems.size();
    }
    ///////////////////////////////////
    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter=new Filter(){

        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {

            List<FoodItem> filteredList = new ArrayList<>();

            if (charSequence == null || charSequence.length() == 0) {
                filteredList.addAll(foodItemsAll);
            } else {
                //  String filterPattern = charSequence.toString().toLowerCase().trim();
                for (FoodItem foodItem: foodItemsAll) {
                    if (foodItem.getName().toLowerCase().contains(charSequence.toString().toLowerCase())) {
                        filteredList.add(foodItem);
                    }
                }
            }

            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            foodItems.clear();
            foodItems.addAll((Collection<? extends FoodItem>) filterResults.values);
            notifyDataSetChanged();
        }









    };
    ///////////////////////////////////////////////////
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // public ImageSwitcher image;
        ImageView image;
        TextView title, time;
        RatingBar ratingBar;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.imageView);
            title = itemView.findViewById(R.id.textView);
            ratingBar=itemView.findViewById(R.id.rating);
            time= itemView.findViewById(R.id.rowCountTextView);
            //  rating=itemView.findViewById(R.id.rating);
            itemView.setOnClickListener(this);

            itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    foodItems.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    return true;
                }
            });

        }

        @Override
        public void onClick(View view) {
           // Toast.makeText(view.getContext(), (CharSequence) foodItems.get(getAdapterPosition()), Toast.LENGTH_SHORT).show();
        }
    }
}

















