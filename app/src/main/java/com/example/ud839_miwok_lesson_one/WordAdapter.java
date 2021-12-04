package com.example.ud839_miwok_lesson_one;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

        ImageView icon = listItemView.findViewById(R.id.image);
        TextView miwokText = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        TextView defaultText = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Populate the data into the template view using the data object
//        if(word.getImageResourceId()==0){
//           icon.setVisibility(View.GONE);
//        }else {
//            icon.setImageResource(word.getImageResourceId());
//        }

        if(word.hasImage()){
            icon.setImageResource(word.getImageResourceId());
            icon.setVisibility(View.VISIBLE);
        }else {
            icon.setVisibility(View.GONE);
        }

        defaultText.setText(word.getDefaultTranslation());
        miwokText.setText(word.getMiwokTranslation());
        // Return the completed view to render on screen
        return listItemView;
    }
}
