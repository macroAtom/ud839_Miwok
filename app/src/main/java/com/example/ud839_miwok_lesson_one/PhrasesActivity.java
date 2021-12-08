package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PhrasesActivity extends AppCompatActivity {
//    private MediaPlayer mMediaPlayer;
//
//    private AudioManager mAudioManager;
//
//    /**
//     * 创建监听器对象
//     */
//
//    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
//            new AudioManager.OnAudioFocusChangeListener() {
//                public void onAudioFocusChange(int focusChange) {
//                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                        // Permanent loss of audio focus
//                        // Pause playback immediately
//                        mMediaPlayer.release();
//                    }
//                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                        // Pause playback
//                        mMediaPlayer.pause();
//                        mMediaPlayer.seekTo(0);
//
//                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                        // Your app has been granted audio focus again
//                        // Raise volume to normal, restart playback if necessary
//                        mMediaPlayer.start();
//                    }
//                }
//            };
//
//    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
//        @Override
//        public void onCompletion(MediaPlayer mp) {
//            releaseMediaPlayer();
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new PhrasesFragment()).commit();


//        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
//        ArrayList<Word> phrases = new ArrayList<Word>();
//
////        添加Phrases 对象到 phrases的数据列表中
//        phrases.add(new Word("Where are you going?", "minto wuksus",
//                R.raw.phrase_where_are_you_going));
//        phrases.add(new Word("What is your name?", "tinnә oyaase'nә", R.raw.phrase_what_is_your_name));
//        phrases.add(new Word("My name is...", "oyaaset...", R.raw.phrase_my_name_is));
//        phrases.add(new Word("How are you feeling?", "michәksәs?", R.raw.phrase_how_are_you_feeling));
//        phrases.add(new Word("I’m feeling good.", "kuchi achit", R.raw.phrase_im_feeling_good));
//        phrases.add(new Word("Are you coming?", "әәnәs'aa?", R.raw.phrase_are_you_coming));
//        phrases.add(new Word("Yes, I’m coming.", "hәә’ әәnәm", R.raw.phrase_yes_im_coming));
//        phrases.add(new Word("I’m coming.", "әәnәm", R.raw.phrase_im_coming));
//        phrases.add(new Word("Let’s go.", "yoowutis", R.raw.phrase_lets_go));
//        phrases.add(new Word("Come here.", "әnni'nem", R.raw.phrase_come_here));
//
//        // 创建phrases 的适配器对象,并填入当前的Activity,使用this参数,还需填入数据源对象phrases;
//        WordAdapter phrasesAdapter = new WordAdapter(this, phrases, R.color.category_phrases);
//        ListView listView = findViewById(R.id.list);
//        listView.setAdapter(phrasesAdapter);
//
////      设置播放单词音频
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                releaseMediaPlayer();
//                Word word = phrases.get(position);
//
//
//                // Request audio focus for playback
//                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
//                        // Use the music stream.
//                        AudioManager.STREAM_MUSIC,
//                        // Request permanent focus.
//                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
//
//                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
//                    mMediaPlayer = MediaPlayer.create(PhrasesActivity.this, word.getMiwokVoice());
//                    mMediaPlayer.start();
//                    //                当音频播放完成时调用
//                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
//                }
//
//            }
//        });

    }

//    /**
//     * when swatch app,stop the app
//     */
//    @Override
//    protected void onStop() {
//        super.onStop();
//        releaseMediaPlayer();
//    }

//    /**
//     * Clean up the media player by releasing its resources.
//     */
//    private void releaseMediaPlayer() {
//        // If the media player is not null, then it may be currently playing a sound.
//        if (mMediaPlayer != null) {
//            // Regardless of the current state of the media player, release its resources
//            // because we no longer need it.
//            mMediaPlayer.release();
//
//            // Set the media player back to null. For our code, we've decided that
//            // setting the media player to null is an easy way to tell that the media player
//            // is not configured to play an audio file at the moment.
//            mMediaPlayer = null;
//
//            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
//        }
//    }

}