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
//    private MediaPlayer mMediaPlayer;
//    private AudioManager mAudioManager;
//    private Handler handler = new Handler();
//
//    //    监听器
//    private AudioManager.OnAudioFocusChangeListener mOnAndioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
//        @Override
//        public void onAudioFocusChange(int focusChange) {
////                Toast.makeText(ColorsActivity.this,"request andio focus!", Toast.LENGTH_SHORT).show();
//
//
//            if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
//                // Permanent loss of audio focus
//                // Pause playback immediately
//                releaseMediaPlayer();
//            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
//                // Pause playback
//                mMediaPlayer.pause();
//                mMediaPlayer.seekTo(0);
//            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
//                // Your app has been granted audio focus again
//                // Raise volume to normal, restart playback if necessary
//                mMediaPlayer.start();
//            }
//
//        }
//    };
//
////    mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
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
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new ColorsFragment())
                .commit();

    }

//    /**
//     * when swatch app,stop the app
//     */
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Toast.makeText(ColorsActivity.this, "Stop Resource!", Toast.LENGTH_SHORT).show();
//        releaseMediaPlayer();
//
//    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Toast.makeText(ColorsActivity.this, "Destroy Resource!", Toast.LENGTH_SHORT).show();
//
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
//            /**
//             * 释放andio focus 当结束的时候
//             */
//            mAudioManager.abandonAudioFocus(mOnAndioFocusChangeListener);
//
//        }
//    }

}