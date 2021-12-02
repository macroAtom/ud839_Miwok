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
        setContentView(R.layout.word_list);


//        创建color 数据列表
        ArrayList<Word> color = new ArrayList<Word>();

//        添加color对象
        color.add(new Word("red", "weṭeṭṭi"));
        color.add(new Word("green", "chokokki"));
        color.add(new Word("brown", "ṭakaakki"));
        color.add(new Word("gray", "ṭopoppi"));
        color.add(new Word("black", "kululli"));
        color.add(new Word("white", "kelelli"));
        color.add(new Word("dusty yellow", "ṭopiisә"));
        color.add(new Word("mustard yellow", "chiwiiṭә"));

//        创建color 适配器对象,并填入参数this,和color 数据源
        WordAdapter colorsAdapter = new WordAdapter(this, color);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(colorsAdapter);
    }

}