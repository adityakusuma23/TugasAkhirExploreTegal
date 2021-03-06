package net.aditkus.exploretegal.ViewHolder;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import net.aditkus.exploretegal.Interface.ItemClickListener;
import net.aditkus.exploretegal.Model.Food;
import net.aditkus.exploretegal.R;

/**
 * Created by Aditya on 20-Dec-17.
 */

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView food_name;
    public ImageView food_Image;

    private ItemClickListener itemClickListener;
    public void setItemClickListener (ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    public FoodViewHolder(View itemView){
        super(itemView);
        food_name = (TextView)itemView.findViewById(R.id.food_name);
        food_Image = (ImageView)itemView.findViewById(R.id.food_image);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
