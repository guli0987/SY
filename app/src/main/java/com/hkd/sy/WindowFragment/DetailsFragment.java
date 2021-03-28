package com.hkd.sy.WindowFragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
/*import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;*/
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.hkd.sy.Activity_window_data;
import com.hkd.sy.R;

public class DetailsFragment extends Fragment {
    private TextView window_details_introduction;
    String window_introduction;
    public DetailsFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_window_details, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*Bundle bundle=this.getArguments();
        String mess=null;
        if(bundle!=null){
            mess=bundle.getString("fragment_details_introduction");
        }
        window_details_introduction=getView().findViewById(R.id.window_details_introduction);
        window_details_introduction.setText(mess);*/
        window_details_introduction=getView().findViewById(R.id.window_details_introduction);
        window_details_introduction.setText(window_introduction);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        window_introduction=((Activity_window_data)context).getWindowIntroduction();
    }
}
