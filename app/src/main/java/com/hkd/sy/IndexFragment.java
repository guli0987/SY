package com.hkd.sy;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.hkd.sy.Banner.GlideImageLoader;
import com.hkd.sy.Recommend.RecommendAdapter;
import com.hkd.sy.Recommend.RecommendList;
import com.hkd.sy.Recommend.SpacesItemDecoration;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

public class IndexFragment extends Fragment implements View.OnClickListener {
    private LinearLayout L1;
    private LinearLayout L2;
    private LinearLayout L3;
    private LinearLayout L4;
    private List<Integer> images=new ArrayList<>();
    private List<RecommendList> reList=new ArrayList<RecommendList>();
    public IndexFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_index2, container, false);
    }
    RecommendAdapter recommendAdapter;
    RefreshLayout refresh_all;
    RecyclerView recyclerView;
    RefreshLayout refreshLayout;
    NestedScrollView nes_scroll;
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //IndexFragment
        images.clear();
        images.add(R.drawable.recommend1);
        images.add(R.drawable.recommend2);
        images.add(R.drawable.recommend3);
        images.add(R.drawable.recommend4);
        //获取
        refresh_all=getView().findViewById(R.id.refresh_all);
        recyclerView=getView().findViewById(R.id.rv_list);
        refreshLayout = getView().findViewById(R.id.refreshLayout);
        initRecommends();
        recommendAdapter=new RecommendAdapter(reList);
        //scroll
        nes_scroll=getView().findViewById(R.id.nes_scroll);
        nes_scroll.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                    if(scrollY==(v.getChildAt(0).getMeasuredHeight()-v.getMeasuredHeight())){
                        addInitRecommends();
                        recommendAdapter.notifyDataSetChanged();
                        refreshLayout.finishLoadMore(2000);
                        Toast.makeText(getActivity(),"到达底部",Toast.LENGTH_SHORT).show();
                    }
            }
        });
        //recommend
        //recyclerView=getView().findViewById(R.id.rv_list);
        LinearLayoutManager layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        /*initRecommends();
        recommendAdapter=new RecommendAdapter(reList);*/
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setHasFixedSize(true);
        //recyclerView.setNestedScrollingEnabled(false);
        //设置间距
        recyclerView.addItemDecoration(new SpacesItemDecoration(40));
        recyclerView.setAdapter(recommendAdapter);
        //刷新【加载】
        //refreshLayout = getView().findViewById(R.id.refreshLayout);
        refreshLayout.setEnableRefresh(false);
        //refreshLayout.setEnableLoadMore(false);
        refreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                addInitRecommends();
                recommendAdapter.notifyDataSetChanged();
                refreshLayout.finishLoadMore(2000);
               /* Message message=new Message();
                message.what=0;
                mHandler.sendMessageDelayed(message,2000);*/
            }
        });
        //刷新【刷新】
        //取消上拉加载
        refresh_all.setEnableLoadMore(false);
        refresh_all.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                Toast.makeText(getActivity(),"刷新完成",Toast.LENGTH_SHORT).show();
            }
        });
        //
        Banner banner=getView().findViewById(R.id.banner);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        //设置轮播时间
        banner.setDelayTime(2000);
        banner.start();
        L1=getView().findViewById(R.id.L1);
        L2=getView().findViewById(R.id.L2);
        L3=getView().findViewById(R.id.L3);
        L4=getView().findViewById(R.id.L4);
        L1.setOnClickListener(this);
        L2.setOnClickListener(this);
        L3.setOnClickListener(this);
        L4.setOnClickListener(this);


    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            switch (msg.what){
                case 0:         //加载更多
                    refreshLayout.finishLoadMore(true);
                    break;
            }
            return false;
        }
    });
    private void addInitRecommends() {
        for(int i=0;i<1;i++) {
            RecommendList r6=new RecommendList(6,R.drawable.st6,"窗口六","进店",R.drawable.eat2,R.drawable.eat9,R.drawable.eat4,"炒菜","炒菜经验丰富");
            RecommendList r7=new RecommendList(7,R.drawable.st7,"窗口七","进店",R.drawable.eat6,R.drawable.eat3,R.drawable.eat2,"炒菜","蛋炒饭");
            reList.add(r6);
            reList.add(r7);
        }
    }

    private void initRecommends() {
        reList.clear();
        for(int i=0;i<1;i++) {
            RecommendList r1=new RecommendList(1,R.drawable.st1,"窗口一","进店",R.drawable.eat1,R.drawable.eat2,R.drawable.eat3,"炒菜","炒菜经验丰富");
            RecommendList r2=new RecommendList(2,R.drawable.st2,"窗口二","进店",R.drawable.eat4,R.drawable.eat5,R.drawable.eat6,"炒菜","炒菜经验丰富");
            RecommendList r3=new RecommendList(3,R.drawable.st3,"窗口三","进店",R.drawable.eat7,R.drawable.eat8,R.drawable.eat9,"炒菜","炒菜经验丰富");
            RecommendList r4=new RecommendList(4,R.drawable.st4,"窗口四","进店",R.drawable.eat3,R.drawable.eat7,R.drawable.eat8,"炒菜","炒菜经验丰富");
            RecommendList r5=new RecommendList(5,R.drawable.st5,"窗口五","进店",R.drawable.eat5,R.drawable.eat4,R.drawable.eat1,"炒菜","炒菜经验丰富");
            reList.add(r1);
            reList.add(r2);
            reList.add(r3);
            reList.add(r4);
            reList.add(r5);

        }

    }

    @Override
    public void onClick(View v) {
        int code=v.getId();
        switch (code){
            case R.id.L1:
                Intent intent=new Intent(new Intent(getActivity(), Activity_food.class));
                startActivity(intent);
                break;
            case R.id.L2:
                Intent intent2=new Intent(new Intent(getActivity(), Activity_drink.class));
                startActivity(intent2);
                break;
            case R.id.L3:
                Intent intent3=new Intent(new Intent(getActivity(), Activity_fruit.class));
                startActivity(intent3);
                break;
            case R.id.L4:
                Intent intent4=new Intent(new Intent(getActivity(), Activity_other.class));
                startActivity(intent4);
                break;
            default:
                break;
        }
    }
}
