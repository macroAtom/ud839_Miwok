package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

//        创建Family 类型的数组列表
        ArrayList<Word> family = new ArrayList<Word>();
//      添加family 对象到Family数组列表中
        family.add(new Word("father","әpә"));
        family.add(new Word("mother","әṭa"));
        family.add(new Word("son","angsi"));
        family.add(new Word("daughter","tune"));
        family.add(new Word("older brother","taachi"));
        family.add(new Word("younger brother","chalitti"));
        family.add(new Word("older sister","teṭe"));
        family.add(new Word("younger sister","kolliti"));
        family.add(new Word("grandmother","ama"));
        family.add(new Word("grandfather","paapa"));

//      创建适配器,传入参数,this和数组列表(family类型)
        WordAdapter familyAdapter = new WordAdapter(this,family);
//      创建ListView 对象
        ListView listFamilyView = findViewById(R.id.list);
        listFamilyView.setAdapter(familyAdapter);

    }
}