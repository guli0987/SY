package com.hkd.sy;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hkd.sy.MyData.Activity_my_data;

public class MyselfFragment extends Fragment implements View.OnClickListener {
    private LinearLayout layout_update;
    private LinearLayout layout_myData;
    public MyselfFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_myself3, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        layout_update=getView().findViewById(R.id.layout_update);
        layout_update.setOnClickListener(this);
        layout_myData=getView().findViewById(R.id.layout_myData);
        layout_myData.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int code=v.getId();
        switch (code) {
            case R.id.layout_update:
                Intent intent=new Intent(new Intent(getActivity(),Activity_update.class));
                startActivity(intent);
                break;
            case R.id.layout_myData:
                Intent intent2=new Intent(new Intent(getActivity(), Activity_my_data.class));
                startActivity(intent2);
                break;
            default:
                break;


        }
    }
}
