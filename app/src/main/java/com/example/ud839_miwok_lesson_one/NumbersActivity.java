package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        String[] wordString = new String[10];
//
        wordString[0] = "one";
        wordString[1] = "two";
        wordString[2] = "three";
        wordString[3] = "four";

//      创建一个字符串类型数组列表并存储到变量words中
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

//        LinearLayout rootView = findViewById(R.id.rootView);
////        for loop
//        for (int i = 0; i < 10; i++) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }

//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, words);
//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
//        ListView listView = findViewById(R.id.list);
        ListView listView = (ListView) findViewById(R.id.list);
//        listView.setAdapter(itemsAdapter);
        listView.setAdapter(itemsAdapter);
    }
}
