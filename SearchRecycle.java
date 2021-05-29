package com.example.cookingrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


public class SearchRecycle extends AppCompatActivity {

    ////RecyclerView recyclerView;
    SearchFoodAdapter recyclerAdapter;
    RecyclerView recyclerItems;
    EditText txt_Search;

    List<FoodItem> foodItems ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchrecycle);


        foodItems = new ArrayList<>();
        setFoodItems(0);
        recyclerItems= findViewById(R.id.recyclerView);
        txt_Search=(EditText)findViewById(R.id.txt_searchtext);
        recyclerAdapter = new  SearchFoodAdapter(this,foodItems);


        recyclerItems.setLayoutManager(new LinearLayoutManager(this));

        recyclerItems.setAdapter(recyclerAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerItems.addItemDecoration(dividerItemDecoration);

        // setFoodItems(0);
        txt_Search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // recyclerAdapter.getFilter().filter(charSequence.toString());
                recyclerAdapter.getFilter().filter(charSequence.toString());
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //   recyclerAdapter.getFilter().filter(editable.toString());

                //  notifyDataSetChanged();
            }
        });





    }

  /* @Override
  public boolean onCreateOptionsMenu(Menu menu) {
      getMenuInflater().inflate(R.menu.main_menu1, menu);
        MenuItem menuItem = menu.findItem(R.id.search_bar);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
              recyclerAdapter.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
*/








    private void setFoodItems(int pos){
        //    List<FoodItem> foodItems = new ArrayList<>();

        FoodItem foodItem = new FoodItem("Chicken Fried rice", 4.5f, 60, R.drawable.chickenfriedrice);
        FoodItem foodItem2 = new FoodItem("Nasi goreng", 3.5f, 60, R.drawable.nasi_goreng);
        FoodItem foodItem3 = new FoodItem("Biriyani", 4.0f, 60, R.drawable.biriyani);
        FoodItem foodItem4 = new FoodItem("Egg Fried rice", 3.8f, 60, R.drawable.eggfriedrice);
        FoodItem foodItem5 = new FoodItem("Mongolian rice", 4.3f, 60, R.drawable.mongolian_rice);


        foodItems.add(foodItem);
        foodItems.add(foodItem2);
        foodItems.add(foodItem3);
        foodItems.add(foodItem4);
        foodItems.add(foodItem5);

        FoodItem foodItem6 = new FoodItem("Dhal curry", 4.5f, 60, R.drawable.dhalcurry);
        FoodItem foodItem7 = new FoodItem("Chicken curry", 4.0f, 60, R.drawable.chickencurry);
        FoodItem foodItem8 = new FoodItem("Fish curry", 3.8f, 60, R.drawable.fishcurry);
        FoodItem foodItem9 = new FoodItem("Polos curry", 4.3f, 60, R.drawable.poloscurry);
        FoodItem foodItem10 = new FoodItem("Pumpkin curry", 4.3f, 60, R.drawable.pumpkin_curry);


        foodItems.add(foodItem6);
        foodItems.add(foodItem7);
        foodItems.add(foodItem8);
        foodItems.add(foodItem9);
        foodItems.add(foodItem10);

        FoodItem foodItem11 = new FoodItem("Macaroni", 4.5f, 60, R.drawable.macaroni);
        FoodItem foodItem12 = new FoodItem("Spaghetti", 3.5f, 60, R.drawable.spaghetti);
        FoodItem foodItem13 = new FoodItem("Egg Noodle", 4.0f, 60, R.drawable.egg_noodles);
        FoodItem foodItem14 = new FoodItem("Chicken Noodle", 3.8f, 60, R.drawable.chicken_noodles);
        FoodItem foodItem15 = new FoodItem("Rice Noodle", 4.3f, 60, R.drawable.rice_noodles);


        foodItems.add(foodItem11);
        foodItems.add(foodItem12);
        foodItems.add(foodItem13);
        foodItems.add(foodItem14);
        foodItems.add(foodItem15);

        FoodItem foodItem16 = new FoodItem("Patty", 4.5f, 60, R.drawable.patty);
        FoodItem foodItem17 = new FoodItem("Rolls", 3.5f, 60, R.drawable.rolls);
        FoodItem foodItem18 = new FoodItem("Samosa", 4.0f, 60, R.drawable.samosa);
        FoodItem foodItem19 = new FoodItem("Sandwiches", 3.8f, 60, R.drawable.sandwich);
        FoodItem foodItem20 = new FoodItem("Cutlet", 4.3f, 60, R.drawable.cutlet);

        foodItems.add(foodItem16);
        foodItems.add(foodItem17);
        foodItems.add(foodItem18);
        foodItems.add(foodItem19);
        foodItems.add(foodItem20);

        FoodItem foodItem21 = new FoodItem("Custard Pudding", 4.5f, 60, R.drawable.custardpudding);
        FoodItem foodItem22 = new FoodItem("Watalappan", 3.5f, 60, R.drawable.watalappan);
        FoodItem foodItem23 = new FoodItem("Fruit Salad", 4.0f, 60, R.drawable.fruitsalad);
        FoodItem foodItem24 = new FoodItem("Chocolate Brownies", 3.8f, 60, R.drawable.chocolatebrownie);
        FoodItem foodItem25 = new FoodItem("Ice Cream", 4.3f, 60, R.drawable.icecream);

        foodItems.add(foodItem21);
        foodItems.add(foodItem22);
        foodItems.add(foodItem23);
        foodItems.add(foodItem24);
        foodItems.add(foodItem25);

    }



    //recyclerItems.setLayoutManager(new LinearLayoutManager(SearchRecycle.this,RecyclerView.HORIZONTAL,false));
    // recyclerItems.setAdapter(foodAdapter);

}


