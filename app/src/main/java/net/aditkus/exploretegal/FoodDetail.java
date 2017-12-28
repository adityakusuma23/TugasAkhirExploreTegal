package net.aditkus.exploretegal;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import net.aditkus.exploretegal.Model.Food;

public class FoodDetail extends AppCompatActivity {

    TextView food_name,food_description;
    ImageView food_image;
    CollapsingToolbarLayout collapsingToolbarLayout;

    String foodId="";

    FirebaseDatabase database;
    DatabaseReference foods;
    Food currentFood;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);


        //firebase
        database = FirebaseDatabase.getInstance();
        foods = database.getReference("Foods");

        food_description = (TextView)findViewById(R.id.food_description);
        food_name = (TextView)findViewById(R.id.food_name);
        food_image = (ImageView)findViewById(R.id.img_food);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing);
        collapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppbar);
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedAppbar);

        //mengambil food id dari intent

        if (getIntent()!=null)
            foodId= getIntent().getStringExtra("FoodId");
            Log.d("Food Detail", "ID " + foodId);
        if (!foodId.isEmpty())
        {
            getDetailFood(foodId);
        }
    }


    private  void getDetailFood(String foodId){
        foods.child(foodId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                currentFood = dataSnapshot.getValue(Food.class);
                Log.d("Food Detail", currentFood.getImages());
                //menyetel gambar

                Picasso.with(getBaseContext()).load(currentFood.getImages()).into(food_image);
                collapsingToolbarLayout.setTitle(currentFood.getName());

                food_name.setText(currentFood.getName());
                food_description.setText(currentFood.getDescription());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
