package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Word> phrases = new ArrayList<Word>();

//        添加Phrases 对象到 phrases的数据列表中
//        phrases.add(new Word(R.drawable.one,"Where are you going?", "minto wuksus"));

        phrases.add(new Word("Where are you going?", "minto wuksus"));
        phrases.add(new Word("What is your name?", "tinnә oyaase'nә"));
        phrases.add(new Word("My name is...", "oyaaset..."));
        phrases.add(new Word("How are you feeling?", "michәksәs?"));
        phrases.add(new Word("I’m feeling good.", "kuchi achit"));
        phrases.add(new Word("Are you coming?", "әәnәs'aa?"));
        phrases.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        phrases.add(new Word("I’m coming.", "әәnәm"));
        phrases.add(new Word("Let’s go.", "yoowutis"));
        phrases.add(new Word("Come here.", "әnni'nem"));

        // 创建phrases 的适配器对象,并填入当前的Activity,使用this参数,还需填入数据源对象phrases;
        WordAdapter phrasesAdapter = new WordAdapter(this, phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(phrasesAdapter);



    }
}