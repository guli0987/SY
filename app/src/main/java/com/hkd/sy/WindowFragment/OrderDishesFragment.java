package com.hkd.sy.WindowFragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hkd.sy.Activity_window_data;
import com.hkd.sy.R;
import com.hkd.sy.Window.WindowOrderDishesAdapter;
import com.hkd.sy.Window.WindowOrderDishesList;

import java.util.ArrayList;
import java.util.List;

public class OrderDishesFragment extends Fragment {
    private List<WindowOrderDishesList> odList = new ArrayList<WindowOrderDishesList>();
    WindowOrderDishesAdapter wodAdapter;
    RecyclerView recyclerView;
    int window_id;
    public OrderDishesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_window_orderdishes, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //recommend
        recyclerView = getView().findViewById(R.id.rv_list_window_orderDishes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        initOrderDishes();
        wodAdapter = new WindowOrderDishesAdapter(odList,window_id);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setNestedScrollingEnabled(false);
        //设置间距
        //new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        //new WindowSpacesItemDecoration(35)
        //recyclerView.addItemDecoration(new WindowSpacesItemDecoration(35));
        recyclerView.setAdapter(wodAdapter);
    }
    private void initOrderDishes() {
        odList.clear();
        //根据窗口id获取
        switch (window_id){
            case 1:
                window1();
                break;
            case 2:
                window2();
                break;
            case 3:
                window3();
                break;
            case 4:
                window4();
                break;
            case 5:
                window5();
                break;
            case 6:
                window6();
                break;
            case 7:
                window7();
                break;
            default:
                break;
        }

    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        window_id=((Activity_window_data)context).getWindowId();
    }
    private void window1(){
        for (int i = 0; i < 1; i++) {

            WindowOrderDishesList w1=new WindowOrderDishesList(1,R.drawable.eat4,"炒冷饭1",10.0,"test");
            WindowOrderDishesList w2=new WindowOrderDishesList(2,R.drawable.eat2,"热馍馍1",10.0,"test");
            WindowOrderDishesList w3=new WindowOrderDishesList(3,R.drawable.eat7,"面条1",10.0,"test");
            WindowOrderDishesList w4=new WindowOrderDishesList(4,R.drawable.eat9,"卤蛋1",10.0,"test");
            WindowOrderDishesList w5=new WindowOrderDishesList(5,R.drawable.eat1,"饺子1",10.0,"test");
            WindowOrderDishesList w6=new WindowOrderDishesList(6,R.drawable.eat3,"稀饭1",10.0,"test");
            odList.add(w1);
            odList.add(w2);
            odList.add(w3);
            odList.add(w4);
            odList.add(w5);
            odList.add(w6);
        }
    }
    private void window2(){
        for (int i = 0; i < 1; i++) {

            WindowOrderDishesList w1=new WindowOrderDishesList(1,R.drawable.eat4,"炒冷饭2",10.0,"test");
            WindowOrderDishesList w2=new WindowOrderDishesList(2,R.drawable.eat2,"热馍馍2",10.0,"test");
            WindowOrderDishesList w3=new WindowOrderDishesList(3,R.drawable.eat7,"面条2",10.0,"test");
            WindowOrderDishesList w4=new WindowOrderDishesList(4,R.drawable.eat9,"卤蛋2",10.0,"test");
            WindowOrderDishesList w5=new WindowOrderDishesList(5,R.drawable.eat1,"饺子2",10.0,"test");
            WindowOrderDishesList w6=new WindowOrderDishesList(6,R.drawable.eat3,"稀饭2",10.0,"test");
            odList.add(w1);
            odList.add(w2);
            odList.add(w3);
            odList.add(w4);
            odList.add(w5);
            odList.add(w6);
        }
    }
    private void window3(){
        for (int i = 0; i < 1; i++) {

            WindowOrderDishesList w1=new WindowOrderDishesList(1,R.drawable.eat4,"炒冷饭3",10.0,"test");
            WindowOrderDishesList w2=new WindowOrderDishesList(2,R.drawable.eat2,"热馍馍3",10.0,"test");
            WindowOrderDishesList w3=new WindowOrderDishesList(3,R.drawable.eat7,"面条3",10.0,"test");
            WindowOrderDishesList w4=new WindowOrderDishesList(4,R.drawable.eat9,"卤蛋3",10.0,"test");
            WindowOrderDishesList w5=new WindowOrderDishesList(5,R.drawable.eat1,"饺子3",10.0,"test");
            WindowOrderDishesList w6=new WindowOrderDishesList(6,R.drawable.eat3,"稀饭3",10.0,"test");
            odList.add(w1);
            odList.add(w2);
            odList.add(w3);
            odList.add(w4);
            odList.add(w5);
            odList.add(w6);
        }
    }
    private void window4(){
        for (int i = 0; i < 1; i++) {

            WindowOrderDishesList w1=new WindowOrderDishesList(1,R.drawable.eat4,"炒冷饭4",10.0,"test");
            WindowOrderDishesList w2=new WindowOrderDishesList(2,R.drawable.eat2,"热馍馍4",10.0,"test");
            WindowOrderDishesList w3=new WindowOrderDishesList(3,R.drawable.eat7,"面条4",10.0,"test");
            WindowOrderDishesList w4=new WindowOrderDishesList(4,R.drawable.eat9,"卤蛋4",10.0,"test");
            WindowOrderDishesList w5=new WindowOrderDishesList(5,R.drawable.eat1,"饺子4",10.0,"test");
            WindowOrderDishesList w6=new WindowOrderDishesList(6,R.drawable.eat3,"稀饭4",10.0,"test");
            odList.add(w1);
            odList.add(w2);
            odList.add(w3);
            odList.add(w4);
            odList.add(w5);
            odList.add(w6);
        }
    }
    private void window5(){
        for (int i = 0; i < 1; i++) {

            WindowOrderDishesList w1=new WindowOrderDishesList(1,R.drawable.eat4,"炒冷饭5",10.0,"test");
            WindowOrderDishesList w2=new WindowOrderDishesList(2,R.drawable.eat2,"热馍馍5",10.0,"test");
            WindowOrderDishesList w3=new WindowOrderDishesList(3,R.drawable.eat7,"面条5",10.0,"test");
            WindowOrderDishesList w4=new WindowOrderDishesList(4,R.drawable.eat9,"卤蛋5",10.0,"test");
            WindowOrderDishesList w5=new WindowOrderDishesList(5,R.drawable.eat1,"饺子5",10.0,"test");
            WindowOrderDishesList w6=new WindowOrderDishesList(6,R.drawable.eat3,"稀饭5",10.0,"test");
            odList.add(w1);
            odList.add(w2);
            odList.add(w3);
            odList.add(w4);
            odList.add(w5);
            odList.add(w6);
        }
    }
    private void window6(){
        for (int i = 0; i < 1; i++) {

            WindowOrderDishesList w1=new WindowOrderDishesList(1,R.drawable.eat4,"炒冷饭6",10.0,"test");
            WindowOrderDishesList w2=new WindowOrderDishesList(2,R.drawable.eat2,"热馍馍6",10.0,"test");
            WindowOrderDishesList w3=new WindowOrderDishesList(3,R.drawable.eat7,"面条6",10.0,"test");
            WindowOrderDishesList w4=new WindowOrderDishesList(4,R.drawable.eat9,"卤蛋6",10.0,"test");
            WindowOrderDishesList w5=new WindowOrderDishesList(5,R.drawable.eat1,"饺子6",10.0,"test");
            WindowOrderDishesList w6=new WindowOrderDishesList(6,R.drawable.eat3,"稀饭6",10.0,"test");
            odList.add(w1);
            odList.add(w2);
            odList.add(w3);
            odList.add(w4);
            odList.add(w5);
            odList.add(w6);
        }
    }
    private void window7(){
        for (int i = 0; i < 1; i++) {

            WindowOrderDishesList w1=new WindowOrderDishesList(1,R.drawable.eat4,"炒冷饭7",10.0,"test");
            WindowOrderDishesList w2=new WindowOrderDishesList(2,R.drawable.eat2,"热馍馍7",10.0,"test");
            WindowOrderDishesList w3=new WindowOrderDishesList(3,R.drawable.eat7,"面条7",10.0,"test");
            WindowOrderDishesList w4=new WindowOrderDishesList(4,R.drawable.eat9,"卤蛋7",10.0,"test");
            WindowOrderDishesList w5=new WindowOrderDishesList(5,R.drawable.eat1,"饺子7",10.0,"test");
            WindowOrderDishesList w6=new WindowOrderDishesList(6,R.drawable.eat3,"稀饭7",10.0,"test");
            odList.add(w2);
            odList.add(w3);
            odList.add(w4);
            odList.add(w5);
            odList.add(w6);
        }
    }
}