package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

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

        family.add(new Word(R.drawable.family_father, "father", "әpә", R.raw.family_father));
        family.add(new Word(R.drawable.family_mother, "mother", "әṭa", R.raw.family_mother));
        family.add(new Word(R.drawable.family_son, "son", "angsi", R.raw.family_son));
        family.add(new Word(R.drawable.family_daughter, "daughter", "tune", R.raw.family_daughter));
        family.add(new Word(R.drawable.family_older_brother, "older brother", "taachi", R.raw.family_older_brother));
        family.add(new Word(R.drawable.family_younger_brother, "younger brother", "chalitti", R.raw.family_younger_brother));
        family.add(new Word(R.drawable.family_older_sister, "older sister", "teṭe", R.raw.family_older_sister));
        family.add(new Word(R.drawable.family_younger_sister, "younger sister", "kolliti", R.raw.family_younger_sister));
        family.add(new Word(R.drawable.family_grandmother, "grandmother", "ama", R.raw.family_grandmother));
        family.add(new Word(R.drawable.family_grandfather, "grandfather", "paapa", R.raw.family_grandfather));

//      创建适配器,传入参数,this和数组列表(family类型)
        WordAdapter familyAdapter = new WordAdapter(this, family, R.color.category_family);
//      创建ListView 对象
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(familyAdapter);

        //      设置播放单词音频
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = family.get(position);
                MediaPlayer mp = MediaPlayer.create(FamilyActivity.this, word.getMiwokVoice());
                mp.start();
            }
        });
    }
}