package com.example.ud839_miwok_lesson_one;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class FamilyAdapter extends ArrayAdapter<Family> {

// FamilyAdapter 构造函数,参数:context,this,用于布局的根layout,objects,用于呈现的数据源.
    public FamilyAdapter(@NonNull Context context, @NonNull List<Family> objects) {
        super(context, 0, objects);
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Family family = getItem(position);
//       check if an existing view is being reused, otherwise inflate the view;
        if(convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

//      创建textview 对象通过textview ID

        TextView familyDefaultText = convertView.findViewById(R.id.default_text_view);
        TextView miwokText = convertView.findViewById(R.id.miwok_text_view);
//      设置layout 中的text值
        familyDefaultText.setText(family.getDefaultTranslation());
        miwokText.setText(family.getMiwokTranslation());

        return convertView;

    }


}
