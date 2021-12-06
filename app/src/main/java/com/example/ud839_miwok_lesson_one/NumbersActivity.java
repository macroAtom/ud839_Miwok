package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
//                mp.release();
//                mp = null;
//                        Toast.makeText(NumbersActivity.this,"I'm done!", Toast.LENGTH_SHORT).show();
            releaseMediaPlayer();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

//     示例1: LinearLayout +ArrayList+ for循环方式布局到screen. 缺点:没有内存控制
//        ArrayList<String> words = new ArrayList<String>();
//        words.add("one");
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");
//        LinearLayout rootView = findViewById(R.id.rootView);
//        for (int i = 0; i < 10; i++) {
//            TextView wordView = new TextView(this);
//            wordView.setText(words.get(i));
//            rootView.addView(wordView);
//        }


/** 示例2：ListView + ArrayAdapter 模式*/
////      创建一个字符串类型数组列表并存储到变量words中
//        ArrayList<String> words = new ArrayList<String>();
//        words.add("two");
//        words.add("three");
//        words.add("four");
//        words.add("five");
//        words.add("six");
//        words.add("seven");
//        words.add("eight");
//        words.add("nine");
//        words.add("ten");
//
//        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, words);
//        ListView listView = findViewById(R.id.list);
//        listView.setAdapter(itemsAdapter);


        /**练习1: 自定义适配器加ListView+ArrayAdapter 模式*/

        ArrayList<Word> words = new ArrayList<Word>();
        // 添加两个word 类型的list
//        words.add(new Word(R.drawable.one,"one","lutti"));

        words.add(new Word(R.drawable.number_one, "one", "lutti", R.raw.number_one));
        words.add(new Word(R.drawable.number_two, "two", "otiiko", R.raw.number_two));
        words.add(new Word(R.drawable.number_three, "three", "tolookosu", R.raw.number_three));
        words.add(new Word(R.drawable.number_four, "four", "oyyisa", R.raw.number_four));
        words.add(new Word(R.drawable.number_five, "five", "massokka", R.raw.number_five));
        words.add(new Word(R.drawable.number_six, "six", "temmokka", R.raw.number_six));
        words.add(new Word(R.drawable.number_seven, "seven", "kenekaku", R.raw.number_seven));
        words.add(new Word(R.drawable.number_eight, "eight", "kawinta", R.raw.number_eight));
        words.add(new Word(R.drawable.number_nine, "nine", "wo'e", R.raw.number_nine));
        words.add(new Word(R.drawable.number_ten, "ten", "na'aacha", R.raw.number_ten));


// 创建自定的适配器对象，参数为this(当前的NumberActivity，R.layout.list_time:数据要详细展示的layout，words:ArrayList<Word> 类型的对象)
//        WordAdapter itemsAdapter = new WordAdapter(this, R.layout.list_item, words);
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_numbers);
//      从view hierarchy 中找到要布局的id,并存储为List 对象
        ListView listView = findViewById(R.id.list);
//      展示到当前的Activity 布局页面上
        listView.setAdapter(adapter);

//      设置播放单词音频
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                releaseMediaPlayer();
                Word word = words.get(position);
                Log.i("NumberActivity", "word: " + word);

                Log.i("NumberActivity", "word.toString(): " + word.toString());

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mMediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getMiwokVoice());
                // Start the audio file
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