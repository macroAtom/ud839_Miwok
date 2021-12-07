package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ColorsActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private Handler handler = new Handler();

    //    监听器
    private AudioManager.OnAudioFocusChangeListener mOnAndioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
//                Toast.makeText(ColorsActivity.this,"request andio focus!", Toast.LENGTH_SHORT).show();


            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // Permanent loss of audio focus
                // Pause playback immediately
                releaseMediaPlayer();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // Pause playback
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // Your app has been granted audio focus again
                // Raise volume to normal, restart playback if necessary
                mMediaPlayer.start();
            }

        }
    };

//    mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

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
        //        设置 audio focus
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
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

// audio focus 应该在 资源release之后 在 media 创建之前
                int res = mAudioManager.requestAudioFocus(mOnAndioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (res == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mMediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getMiwokVoice());
                    mMediaPlayer.start();
                    //                当音频播放完成时调用
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }

            }
        });

    }

    /**
     * when swatch app,stop the app
     */
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(ColorsActivity.this, "Stop Resource!", Toast.LENGTH_SHORT).show();
        releaseMediaPlayer();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(ColorsActivity.this, "Destroy Resource!", Toast.LENGTH_SHORT).show();

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

            /**
             * 释放andio focus 当结束的时候
             */
            mAudioManager.abandonAudioFocus(mOnAndioFocusChangeListener);

        }
    }

}