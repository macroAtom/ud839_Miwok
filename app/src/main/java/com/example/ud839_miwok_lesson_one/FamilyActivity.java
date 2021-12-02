package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

//        创建Family 类型的数组列表
        ArrayList<Family> family = new ArrayList<Family>();
//      添加family 对象到Family数组列表中
        family.add(new Family("father","әpә"));
        family.add(new Family("mother","әṭa"));
        family.add(new Family("son","angsi"));
        family.add(new Family("daughter","tune"));
        family.add(new Family("older brother","taachi"));
        family.add(new Family("younger brother","chalitti"));
        family.add(new Family("older sister","teṭe"));
        family.add(new Family("younger sister","kolliti"));
        family.add(new Family("grandmother","ama"));
        family.add(new Family("grandfather","paapa"));

//      创建适配器,传入参数,this和数组列表(family类型)
        FamilyAdapter familyAdapter = new FamilyAdapter(this,family);
//      创建ListView 对象
        ListView listFamilyView = findViewById(R.id.list);
        listFamilyView.setAdapter(familyAdapter);

    }
}