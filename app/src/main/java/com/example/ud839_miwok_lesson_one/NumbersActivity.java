package com.example.ud839_miwok_lesson_one;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class NumbersActivity extends AppCompatActivity {

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
        words.add(new Word("one","lutti"));
        words.add(new Word("two","otiiko"));
        words.add(new Word("three","tolookosu"));
        words.add(new Word("four","oyyisa"));
        words.add(new Word("five","massokka"));
        words.add(new Word("six","temmokka"));
        words.add(new Word("seven","kenekaku"));
        words.add(new Word("eight","kawinta"));
        words.add(new Word("nine","wo'e"));
        words.add(new Word("ten","na'aacha"));
// 创建自定的适配器对象，参数为this(当前的NumberActivity，R.layout.list_time:数据要详细展示的layout，words:ArrayList<Word> 类型的对象)
//        WordAdapter itemsAdapter = new WordAdapter(this, R.layout.list_item, words);
        WordAdapter adapter = new WordAdapter(this, words);
//      从view hierarchy 中找到要布局的id,并存储为List 对象
        ListView listView = findViewById(R.id.list);
//      展示到当前的Activity 布局页面上
        listView.setAdapter(adapter);




    }

}