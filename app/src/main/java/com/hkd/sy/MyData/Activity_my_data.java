package com.hkd.sy.MyData;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.hkd.sy.R;

public class Activity_my_data extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout layout_myData_headerImage;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_my_data);
        layout_myData_headerImage=findViewById(R.id.layout_myData_headerImage);
        layout_myData_headerImage.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_myData_headerImage:
                Intent intent=new Intent(Activity_my_data.this,Activity_my_data_avatar.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
