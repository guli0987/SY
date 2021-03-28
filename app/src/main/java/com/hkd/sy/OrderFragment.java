package com.hkd.sy;

import android.os.Bundle;


import androidx.annotation.Nullable;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hkd.sy.Order.OrderAdapter;
import com.hkd.sy.Order.OrderList;
import com.hkd.sy.Order.OrderSpacesItemDecoration;


import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {
    private List<OrderList> oList = new ArrayList<OrderList>();
    OrderAdapter oAdapter;
    RecyclerView recyclerView;
    public OrderFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_order, container, false);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //recommend
        recyclerView = getView().findViewById(R.id.rv_list_order);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        initOrder();
        oAdapter = new OrderAdapter(oList);
        //recyclerView.setHasFixedSize(true);
        //recyclerView.setNestedScrollingEnabled(false);
        //设置间距
        //new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        //new WindowSpacesItemDecoration(35)
        recyclerView.addItemDecoration(new OrderSpacesItemDecoration(20));
        recyclerView.setAdapter(oAdapter);
    }

    private void initOrder() {
        for (int i = 0; i < 1; i++) {
            OrderList o1=new OrderList(1654354211,R.drawable.eat6,"大闸蟹","未支付");
            OrderList o2=new OrderList(1565845845,R.drawable.eat7,"狗不理包子","已支付");
            OrderList o3=new OrderList(1564988865,R.drawable.eat1,"蛋黄卷","已支付");
            OrderList o4=new OrderList(1157491551,R.drawable.eat4,"肉粽子","已支付");
            oList.add(o1);
            oList.add(o2);
            oList.add(o3);
            oList.add(o4);
        }
    }
}
