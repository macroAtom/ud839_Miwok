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

public class ColorsAdapter extends ArrayAdapter<Colors> {

    public ColorsAdapter(@NonNull Context context, @NonNull List<Colors> objects) {
        super(context,0,objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Colors color = getItem(position);

        //check if an existing view is being reused, otherwise inflate the view;
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);

        }

        TextView defaultTextTranslation = convertView.findViewById(R.id.default_text_view);
        TextView miwokTextTranslation = convertView.findViewById(R.id.miwok_text_view);

        defaultTextTranslation.setText(color.getDefaultTranslation());
        miwokTextTranslation.setText(color.getMiwokTranslation());

        return  convertView;
    }
}
