package com.example.ud839_miwok_lesson_one;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    private int mColorResouceId;

    public WordAdapter(@NonNull Context context,  @NonNull List<Word> objects, int color) {
        super(context, 0, objects);
        this.mColorResouceId = color;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        Log.i("WordAdapter", "position: "+position);
        Log.i("WordAdapter", "convertView: "+convertView);
        Log.i("WordAdapter", "parent: "+parent);

        // Get the {@link Word} object located at this position in the list
        Word word = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population


//        设置颜色方式1
        LinearLayout li = listItemView.findViewById(R.id.text_container);
//        li.setBackgroundResource(mColorResouceId);

//        设置背景颜色方式2
        int color = ContextCompat.getColor(getContext(),mColorResouceId);
        li.setBackgroundColor(color);


        ImageView icon = listItemView.findViewById(R.id.image);
        TextView miwokText = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultText = (TextView) listItemView.findViewById(R.id.default_text_view);

//      设置icon，如果有图片即显示，否则不可见图片空间
        if(word.hasImage()){
            icon.setImageResource(word.getImageResourceId());
            icon.setVisibility(View.VISIBLE);
        }else {
            icon.setVisibility(View.GONE);
        }
//     set text 文本

        miwokText.setText(word.getMiwokTranslation());
        defaultText.setText(word.getDefaultTranslation());

//      设置播放音频
        //creating media player
//        final MediaPlayer mp=new MediaPlayer();
//        try{
//            //you can change the path, here path is external directory(e.g. sdcard) /Music/maine.mp3
//            Log.i("WordAdapter","setDataSource"+Environment.getExternalStorageDirectory().getPath()+"/bluetooth/karmin - i want it all.mp3");
//            mp.setDataSource(Environment.getExternalStorageDirectory().getPath()+"/bluetooth/karmin - i want it all.mp3");
//            mp.prepare();
//        }catch(Exception e){e.printStackTrace();}
//
//        defaultText.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i("WordAdapter","mp.start() start");
//                mp.start();
//                Log.i("WordAdapter","mp.start() end");
//
////                Toast.makeText(v.getContext(),"open the list of numbers", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//            public void onCompletion(MediaPlayer mMediaPlayer) {
//                mMediaPlayer.release();
//            }
//        });

        // Return the completed view to render on screen
        return listItemView;
    }
}
