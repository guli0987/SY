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
import com.hkd.sy.Window.WindowEvaluationAdapter;
import com.hkd.sy.Window.WindowEvaluationList;
import com.hkd.sy.Window.WindowSpacesItemDecoration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EvaluationFragment extends Fragment {
    private List<WindowEvaluationList> eList = new ArrayList<WindowEvaluationList>();
    WindowEvaluationAdapter weAdapter;
    RecyclerView recyclerView;
    int window_id;
    public EvaluationFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_window_evaluation, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //recommend
        recyclerView = getView().findViewById(R.id.rv_list_window_evaluation);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        initEvaluation();
        weAdapter = new WindowEvaluationAdapter(eList);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setNestedScrollingEnabled(false);
        //设置间距
        //new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        //new WindowSpacesItemDecoration(35)
        recyclerView.addItemDecoration(new WindowSpacesItemDecoration(5));
        recyclerView.setAdapter(weAdapter);
    }

    private void initEvaluation() {
        eList.clear();
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
            Date date=new Date();
            WindowEvaluationList wEList1=new WindowEvaluationList(1,"张扬1",date,9,"这么好吃，下次还来");
            WindowEvaluationList wEList2=new WindowEvaluationList(2,"呼吸时苦1",date,7,"还好");
            WindowEvaluationList wEList3=new WindowEvaluationList(3,"还有海1",date,2,"额");
            WindowEvaluationList wEList4=new WindowEvaluationList(4,"门清1",date,1,"比翔还难吃");
            WindowEvaluationList wEList5=new WindowEvaluationList(5,"是哒1",date,6,"一般一般");
            WindowEvaluationList wEList6=new WindowEvaluationList(6,"乖乖1",date,4,"不咋地");
            WindowEvaluationList wEList7=new WindowEvaluationList(7,"常年在搬砖1",date,7,"还不错");
            WindowEvaluationList wEList8=new WindowEvaluationList(8,"气人1",date,8,"铁粉无疑");
            WindowEvaluationList wEList9=new WindowEvaluationList(9,"哇哇哇1",date,4,"可以可以。。。才怪");
            eList.add(wEList1);
            eList.add(wEList2);
            eList.add(wEList3);
            eList.add(wEList4);
            eList.add(wEList5);
            eList.add(wEList6);
            eList.add(wEList7);
            eList.add(wEList8);
            eList.add(wEList9);
        }
    }
    private void window2(){
        for (int i = 0; i < 1; i++) {
            Date date=new Date();
            WindowEvaluationList wEList1=new WindowEvaluationList(1,"张扬2",date,9,"这么好吃，下次还来");
            WindowEvaluationList wEList2=new WindowEvaluationList(2,"呼吸时苦2",date,7,"还好");
            WindowEvaluationList wEList3=new WindowEvaluationList(3,"还有海2",date,2,"额");
            WindowEvaluationList wEList4=new WindowEvaluationList(4,"门清2",date,1,"比翔还难吃");
            WindowEvaluationList wEList5=new WindowEvaluationList(5,"是哒2",date,6,"一般一般");
            WindowEvaluationList wEList6=new WindowEvaluationList(6,"乖乖2",date,4,"不咋地");
            WindowEvaluationList wEList7=new WindowEvaluationList(7,"常年在搬砖2",date,7,"还不错");
            WindowEvaluationList wEList8=new WindowEvaluationList(8,"气人2",date,8,"铁粉无疑");
            WindowEvaluationList wEList9=new WindowEvaluationList(9,"哇哇哇2",date,4,"可以可以。。。才怪");
            eList.add(wEList1);
            eList.add(wEList2);
            eList.add(wEList3);
            eList.add(wEList4);
            eList.add(wEList5);
            eList.add(wEList6);
            eList.add(wEList7);
            eList.add(wEList8);
            eList.add(wEList9);
        }
    }
    private void window3(){
        for (int i = 0; i < 1; i++) {
            Date date=new Date();
            WindowEvaluationList wEList1=new WindowEvaluationList(1,"张扬3",date,9,"这么好吃，下次还来");
            WindowEvaluationList wEList2=new WindowEvaluationList(2,"呼吸时苦3",date,7,"还好");
            WindowEvaluationList wEList3=new WindowEvaluationList(3,"还有海3",date,2,"额");
            WindowEvaluationList wEList4=new WindowEvaluationList(4,"门清3",date,1,"比翔还难吃");
            WindowEvaluationList wEList5=new WindowEvaluationList(5,"是哒3",date,6,"一般一般");
            WindowEvaluationList wEList6=new WindowEvaluationList(6,"乖乖3",date,4,"不咋地");
            WindowEvaluationList wEList7=new WindowEvaluationList(7,"常年在搬砖3",date,7,"还不错");
            WindowEvaluationList wEList8=new WindowEvaluationList(8,"气人3",date,8,"铁粉无疑");
            WindowEvaluationList wEList9=new WindowEvaluationList(9,"哇哇哇3",date,4,"可以可以。。。才怪");
            eList.add(wEList1);
            eList.add(wEList2);
            eList.add(wEList3);
            eList.add(wEList4);
            eList.add(wEList5);
            eList.add(wEList6);
            eList.add(wEList7);
            eList.add(wEList8);
            eList.add(wEList9);
        }
    }
    private void window4(){
        for (int i = 0; i < 1; i++) {
            Date date=new Date();
            WindowEvaluationList wEList1=new WindowEvaluationList(1,"张扬4",date,9,"这么好吃，下次还来");
            WindowEvaluationList wEList2=new WindowEvaluationList(2,"呼吸时苦4",date,7,"还好");
            WindowEvaluationList wEList3=new WindowEvaluationList(3,"还有海4",date,2,"额");
            WindowEvaluationList wEList4=new WindowEvaluationList(4,"门清4",date,1,"比翔还难吃");
            WindowEvaluationList wEList5=new WindowEvaluationList(5,"是哒4",date,6,"一般一般");
            WindowEvaluationList wEList6=new WindowEvaluationList(6,"乖乖4",date,4,"不咋地");
            WindowEvaluationList wEList7=new WindowEvaluationList(7,"常年在搬砖4",date,7,"还不错");
            WindowEvaluationList wEList8=new WindowEvaluationList(8,"气人4",date,8,"铁粉无疑");
            WindowEvaluationList wEList9=new WindowEvaluationList(9,"哇哇哇4",date,4,"可以可以。。。才怪");
            eList.add(wEList1);
            eList.add(wEList2);
            eList.add(wEList3);
            eList.add(wEList4);
            eList.add(wEList5);
            eList.add(wEList6);
            eList.add(wEList7);
            eList.add(wEList8);
            eList.add(wEList9);
        }
    }
    private void window5(){
        for (int i = 0; i < 1; i++) {
            Date date=new Date();
            WindowEvaluationList wEList1=new WindowEvaluationList(1,"张扬5",date,9,"这么好吃，下次还来");
            WindowEvaluationList wEList2=new WindowEvaluationList(2,"呼吸时苦5",date,7,"还好");
            WindowEvaluationList wEList3=new WindowEvaluationList(3,"还有海5",date,2,"额");
            WindowEvaluationList wEList4=new WindowEvaluationList(4,"门清5",date,1,"比翔还难吃");
            WindowEvaluationList wEList5=new WindowEvaluationList(5,"是哒5",date,6,"一般一般");
            WindowEvaluationList wEList6=new WindowEvaluationList(6,"乖乖5",date,4,"不咋地");
            WindowEvaluationList wEList7=new WindowEvaluationList(7,"常年在搬砖5",date,7,"还不错");
            WindowEvaluationList wEList8=new WindowEvaluationList(8,"气人5",date,8,"铁粉无疑");
            WindowEvaluationList wEList9=new WindowEvaluationList(9,"哇哇哇5",date,4,"可以可以。。。才怪");
            eList.add(wEList1);
            eList.add(wEList2);
            eList.add(wEList3);
            eList.add(wEList4);
            eList.add(wEList5);
            eList.add(wEList6);
            eList.add(wEList7);
            eList.add(wEList8);
            eList.add(wEList9);
        }
    }
    private void window6(){
        for (int i = 0; i < 1; i++) {
            Date date=new Date();
            WindowEvaluationList wEList1=new WindowEvaluationList(1,"张扬6",date,9,"这么好吃，下次还来");
            WindowEvaluationList wEList2=new WindowEvaluationList(2,"呼吸时苦6",date,7,"还好");
            WindowEvaluationList wEList3=new WindowEvaluationList(3,"还有海6",date,2,"额");
            WindowEvaluationList wEList4=new WindowEvaluationList(4,"门清6",date,1,"比翔还难吃");
            WindowEvaluationList wEList5=new WindowEvaluationList(5,"是哒6",date,6,"一般一般");
            WindowEvaluationList wEList6=new WindowEvaluationList(6,"乖乖6",date,4,"不咋地");
            WindowEvaluationList wEList7=new WindowEvaluationList(7,"常年在搬砖6",date,7,"还不错");
            WindowEvaluationList wEList8=new WindowEvaluationList(8,"气人6",date,8,"铁粉无疑");
            WindowEvaluationList wEList9=new WindowEvaluationList(9,"哇哇哇6",date,4,"可以可以。。。才怪");
            eList.add(wEList1);
            eList.add(wEList2);
            eList.add(wEList3);
            eList.add(wEList4);
            eList.add(wEList5);
            eList.add(wEList6);
            eList.add(wEList7);
            eList.add(wEList8);
            eList.add(wEList9);
        }
    }
    private void window7(){
        for (int i = 0; i < 1; i++) {
            Date date=new Date();
            WindowEvaluationList wEList1=new WindowEvaluationList(1,"张扬7",date,9,"这么好吃，下次还来");
            WindowEvaluationList wEList2=new WindowEvaluationList(2,"呼吸时苦7",date,7,"还好");
            WindowEvaluationList wEList3=new WindowEvaluationList(3,"还有海7",date,2,"额");
            WindowEvaluationList wEList4=new WindowEvaluationList(4,"门清7",date,1,"比翔还难吃");
            WindowEvaluationList wEList5=new WindowEvaluationList(5,"是哒7",date,6,"一般一般");
            WindowEvaluationList wEList6=new WindowEvaluationList(6,"乖乖7",date,4,"不咋地");
            WindowEvaluationList wEList7=new WindowEvaluationList(7,"常年在搬砖7",date,7,"还不错");
            WindowEvaluationList wEList8=new WindowEvaluationList(8,"气人7",date,8,"铁粉无疑");
            WindowEvaluationList wEList9=new WindowEvaluationList(9,"哇哇哇7",date,4,"可以可以。。。才怪");
            eList.add(wEList1);
            eList.add(wEList2);
            eList.add(wEList3);
            eList.add(wEList4);
            eList.add(wEList5);
            eList.add(wEList6);
            eList.add(wEList7);
            eList.add(wEList8);
            eList.add(wEList9);
        }
    }
}
