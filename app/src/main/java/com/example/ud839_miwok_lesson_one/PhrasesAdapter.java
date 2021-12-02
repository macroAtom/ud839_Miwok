package com.example.ud839_miwok_lesson_one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.List;

public class PhrasesAdapter extends ArrayAdapter<Phrases> {

//    phrases 适配的构造函数 需要context,和数据源对象
    public PhrasesAdapter(@NonNull Context context, @NonNull List<Phrases> objects) {
        super(context, 0, objects);
    }

//    重载getView 以便布局到ListView 下
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Phrases phrases = getItem(position);
        //       check if an existing view is being reused, otherwise inflate the view;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        TextView defaultTextView = convertView.findViewById(R.id.default_text_view);
        TextView miwokTextView = convertView.findViewById(R.id.miwok_text_view);
        defaultTextView.setText(phrases.getDefaultTranslation());
        miwokTextView.setText(phrases.getMiwokTranslation());
        return convertView;
    }




}
