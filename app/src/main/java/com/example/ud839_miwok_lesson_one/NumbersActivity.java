package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);


//        String[] words = {"one","two","three","four","five","six","seven","eight","nine","ten"};

        ArrayList<String> words = new ArrayList<String>();

        // initialize first element
        words.add("one");
        words.add("two");
        words.add("three");
        words.add("four");
        words.add("five");
        words.add("six");
        words.add("seven");
        words.add("eight");
        words.add("nine");
        words.add("ten");

        for(int i=0; i<10;i++){
            Log.v("NumbersActivity", "word at index "+i+" "+words.get(i));
        }

//        ArrayList<String> restaurantsToTry = new ArrayList<String>();
//
//        restaurantsToTry.add("Morning Cafe");
//        Log.i("ArrayList", "add Morning Cafe: "+restaurantsToTry);
//        restaurantsToTry.add("BBQ Time");
//        Log.i("ArrayList", "add BBQ Time: "+restaurantsToTry);
////        restaurantsToTry.remove("Morning Cafe");
//        restaurantsToTry.remove(0);
//        Log.i("ArrayList", "remove Morning Cafe: "+restaurantsToTry);
//        int numberOfRestaurants = restaurantsToTry.size();
//        Log.i("ArrayList", "length: "+numberOfRestaurants);
    }
}