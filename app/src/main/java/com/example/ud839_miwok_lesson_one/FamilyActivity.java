package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class FamilyActivity extends AppCompatActivity {
    /**
     * 设置mediaPlayer 成员变量
     */
    private MediaPlayer mMediaPlayer;

    private AudioManager mAudioManager;

    /**
     * 设置focus change 监听器
     */

    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();
                    }
                    else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        // Pause playback
                        mMediaPlayer.pause();
                        /**
                         * 将音频的声音重置
                         */
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        mMediaPlayer.start();
                    }
                }
            };


    /**
     * 音频播放完成监听器
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };

    /**
     * 应用启动是的入口，重载父类方法
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        /**
         * 创建audio manager 对象，用于管理andio focus
         */
        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        /**
         * 创建Family 类型的数组列表
         */
        ArrayList<Word> family = new ArrayList<Word>();

        /**
         * 添加family 对象到Family数组列表中
         */
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

        /**
         * 创建适配器,传入参数,this和数组列表(family类型)
         */
        WordAdapter familyAdapter = new WordAdapter(this, family, R.color.category_family);

        /**
         * 创建ListView 对象
         */
        ListView listView = findViewById(R.id.list);

        /**
         * 绑定listView 与 适配器
         */
        listView.setAdapter(familyAdapter);

        /**
         * 监听事件点击，并添加反馈步骤
         */

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                Word word = family.get(position);

                /**
                 * 当资源释放，并且mediaplayer 创建之前，请求andio fucus
                 */

                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);


                if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){

                    mMediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getMiwokVoice());
                    mMediaPlayer.start();
                    /**
                     * 当音频播放完成时调用
                     */
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
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        /**
         * If the media player is not null, then it may be currently playing a sound.
         */
        if (mMediaPlayer != null) {
            /**
             * Regardless of the current state of the media player, release its resources
             * because we no longer need it.
             */
            mMediaPlayer.release();

            /**
             * Set the media player back to null. For our code, we've decided that
             * setting the media player to null is an easy way to tell that the media player
             * is not configured to play an audio file at the moment.
             */
            mMediaPlayer = null;

            /**
             * 释放andio focus 当结束的时候
             */
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

}