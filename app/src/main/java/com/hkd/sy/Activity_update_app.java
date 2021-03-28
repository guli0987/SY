package com.hkd.sy;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_update_app extends AppCompatActivity {
    private TextView tv_think;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_app);
        tv_think=findViewById(R.id.tv_think);
        tv_think.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
