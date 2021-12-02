package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);


//        创建color 数据列表
        ArrayList<Colors> color = new ArrayList<Colors>();

//        添加color对象
        color.add(new Colors("red", "weṭeṭṭi"));
        color.add(new Colors("green", "chokokki"));
        color.add(new Colors("brown", "ṭakaakki"));
        color.add(new Colors("gray", "ṭopoppi"));
        color.add(new Colors("black", "kululli"));
        color.add(new Colors("white", "kelelli"));
        color.add(new Colors("dusty yellow", "ṭopiisә"));
        color.add(new Colors("mustard yellow", "chiwiiṭә"));

//        创建color 适配器对象,并填入参数this,和color 数据源
        ColorsAdapter colorsAdapter = new ColorsAdapter(this, color);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(colorsAdapter);
    }

}