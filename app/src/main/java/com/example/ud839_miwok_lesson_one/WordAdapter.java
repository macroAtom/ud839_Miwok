package com.example.ud839_miwok_lesson_one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(@NonNull Context context,  @NonNull List<Word> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Word word = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }
        // Lookup view for data population
        TextView miwokText = (TextView) convertView.findViewById(R.id.miwok_text_view);
        TextView defaultText = (TextView) convertView.findViewById(R.id.default_text_view);
        // Populate the data into the template view using the data object
        defaultText.setText(word.getDefaultTranslation());
        miwokText.setText(word.getMiwokTranslation());
        // Return the completed view to render on screen
        return convertView;
    }
}
