package com.example.cookingrecipe;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class Recipe extends AppCompatActivity {

    int g = 0;
    String clickedFood, ing, ins, time, wt, a, b;
    String[] foods = {"Chicken Fried rice", "Nasi goreng", "Biriyani", "Egg Fried rice", "Mongolian rice", "Dhal curry", "Chicken curry", "Fish curry", "Polos curry", "Pumpkin curry", "Macaroni", "Spaghetti", "Egg Noodle", "Chicken Noodle", "Rice Noodle", "Patty", "Rolls", "Samosa", "Sandwiches", "Cutlet", "Custard Pudding", "Watalappan", "Fruit Salad", "Chocolate Brownies", "Ice Cream"};


    ImageView img;
    TextView tv1, tv2, tv3, tv4, ingredients, instructions;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        img = (ImageView) findViewById(R.id.image);
        tv1 = (TextView) findViewById(R.id.title);
        tv3 = (TextView) findViewById(R.id.time);
        ingredients = findViewById(R.id.ingredientsContent);
        instructions = findViewById(R.id.instructionsContent);


        img.setImageResource(getIntent().getIntExtra("image", 0));
        tv1.setText(getIntent().getStringExtra("title"));
        tv3.setText(getIntent().getStringExtra("time"));

        clickedFood = getIntent().getStringExtra("clicked_foodName").toString();
        parseXML();


    }

    private void parseXML() {
        XmlPullParserFactory parserFactory;
        try {
            parserFactory = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserFactory.newPullParser();
            InputStream in = getAssets().open("foodRecipes.xml");
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);

            processParsing(parser);

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void processParsing(XmlPullParser parser) throws IOException, XmlPullParserException {
        ArrayList<FoodRecipes> foodRecipes = new ArrayList<>();
        int eventType = parser.getEventType();
        //System.out.println(eventType);
        System.out.println(clickedFood);
        FoodRecipes clickedItemDetails = null;
        FoodRecipes list = null;

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String elName = null;

            switch (eventType) {
                case XmlPullParser.START_TAG:
                    elName = parser.getName();
                    //System.out.println(elName);

                    if ("Name".equals(elName)) {

                        if (parser.nextText().equals(clickedFood)) {
                            g = 1;

                            while (!elName.equals("Item") && eventType != 1) {

                                switch (eventType) {
                                    case XmlPullParser.START_TAG:
                                        elName = parser.getName();
                                        //System.out.println("STTTTTTTTT" + elName);

                                        if ("Ingredients".equals(elName) && eventType == 2) {
                                            ingredients.setText(parser.nextText());


                                        } else if ("Instructions".equals(elName) && eventType == 2) {
                                            instructions.setText(parser.nextText());


                                        } else if ("Preparation_time".equals(elName) && eventType == 2) {
                                            tv3.setText(parser.nextText());

                                        }
                                        break;

                                    default:

                                }

                                eventType = parser.next();
                                //System.out.println("ENDDDDDDD"+elName);
                                //System.out.println(eventType);

                            }

                            break;


                        }

                        break;


                    } else {

                    }

                    break;

                default:

            }

            if (g == 1) {
                eventType = 1;

            } else {
                eventType = parser.next();
                //System.out.println(eventType);
            }

        }


    }




}