package com.example.ud839_miwok_lesson_one;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class NumbersClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),
                "open the list of numbers", Toast.LENGTH_SHORT).show();

    }
}
