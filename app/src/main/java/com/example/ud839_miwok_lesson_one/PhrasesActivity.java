package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);


        ArrayList<Phrases> phrases = new ArrayList<Phrases>();

//        添加Phrases 对象到 phrases的数据列表中
        phrases.add(new Phrases("Where are you going?", "minto wuksus"));
        phrases.add(new Phrases("What is your name?", "tinnә oyaase'nә"));
        phrases.add(new Phrases("My name is...", "oyaaset..."));
        phrases.add(new Phrases("How are you feeling?", "michәksәs?"));
        phrases.add(new Phrases("I’m feeling good.", "kuchi achit"));
        phrases.add(new Phrases("Are you coming?", "әәnәs'aa?"));
        phrases.add(new Phrases("Yes, I’m coming.", "hәә’ әәnәm"));
        phrases.add(new Phrases("I’m coming.", "әәnәm"));
        phrases.add(new Phrases("Let’s go.", "yoowutis"));
        phrases.add(new Phrases("Come here.", "әnni'nem"));

        // 创建phrases 的适配器对象,并填入当前的Activity,使用this参数,还需填入数据源对象phrases;
        PhrasesAdapter phrasesAdapter = new PhrasesAdapter(this, phrases);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(phrasesAdapter);



    }
}