package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

//        创建color 数据列表
        ArrayList<Word> color = new ArrayList<Word>();

//        添加color对象
        color.add(new Word(R.drawable.color_red, "red", "weṭeṭṭi", R.raw.color_red));
        color.add(new Word(R.drawable.color_green, "green", "chokokki", R.raw.color_green));
        color.add(new Word(R.drawable.color_brown, "brown", "ṭakaakki", R.raw.color_brown));
        color.add(new Word(R.drawable.color_gray, "gray", "ṭopoppi", R.raw.color_gray));
        color.add(new Word(R.drawable.color_black, "black", "kululli", R.raw.color_black));
        color.add(new Word(R.drawable.color_white, "white", "kelelli", R.raw.color_white));
        color.add(new Word(R.drawable.color_dusty_yellow, "dusty yellow", "ṭopiisә", R.raw.color_dusty_yellow));
        color.add(new Word(R.drawable.color_mustard_yellow, "mustard yellow", "chiwiiṭә", R.raw.color_mustard_yellow));

//        创建color 适配器对象,并填入参数this,和color 数据源
        WordAdapter colorsAdapter = new WordAdapter(this, color, R.color.category_colors);
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(colorsAdapter);

        //      设置播放单词音频
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                Word word = color.get(position);
                mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getMiwokVoice());
                mMediaPlayer.start();

                //                当音频播放完成时调用
                mMediaPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}