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
//        family.add(new Word(R.drawable.one,"father","әpә"));

        family.add(new Word(R.drawable.family_father,"father","әpә"));
        family.add(new Word(R.drawable.family_mother,"mother","әṭa"));
        family.add(new Word(R.drawable.family_son,"son","angsi"));
        family.add(new Word(R.drawable.family_daughter,"daughter","tune"));
        family.add(new Word(R.drawable.family_older_brother,"older brother","taachi"));
        family.add(new Word(R.drawable.family_younger_brother,"younger brother","chalitti"));
        family.add(new Word(R.drawable.family_older_sister,"older sister","teṭe"));
        family.add(new Word(R.drawable.family_younger_sister,"younger sister","kolliti"));
        family.add(new Word(R.drawable.family_grandmother,"grandmother","ama"));
        family.add(new Word(R.drawable.family_grandfather,"grandfather","paapa"));

//      创建适配器,传入参数,this和数组列表(family类型)
        WordAdapter familyAdapter = new WordAdapter(this,family);
//      创建ListView 对象
        ListView listFamilyView = findViewById(R.id.list);
        listFamilyView.setAdapter(familyAdapter);

    }
}