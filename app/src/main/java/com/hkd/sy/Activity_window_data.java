package com.hkd.sy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import androidx.viewpager.widget.ViewPager;


import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Activity_window_data extends AppCompatActivity {
    /**
     * 窗口标题
     */
    private final int[] Window_TITLE = new int[]{R.string.action_window_OrderDishes,R.string.action_window_Details,R.string.action_window_Evaluation};
    @BindView(R.id.view_window_pager)
    ViewPager window_viewPager;
    @BindView(R.id.tab_window_layout)
    TabLayout window_tabLayout;
    /**
     * 窗口页卡适配器
     */
    private WindowMainFragmentAdapter window_adapter;
    private TextView tv_show_window;
    private ImageView img_windowAvatar;
    private TextView return_one;
    private TextView tv_window_theme;
    String data_introduction;
    int data_id;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_window_data);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
        img_windowAvatar=findViewById(R.id.img_windowAvatar);
        tv_show_window=findViewById(R.id.tv_show_window);
        tv_window_theme=findViewById(R.id.tv_window_theme);
        return_one=findViewById(R.id.return_one);
        windowAttributes();
        //tab window
        ButterKnife.bind(this);
        window_initPager();
        window_setTabs(window_tabLayout, getLayoutInflater(), Window_TITLE);
        return_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Activity_window_data.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
    private void windowAttributes(){
        Intent intent=getIntent();
        data_id=intent.getIntExtra("window_id",-1);
        int data_avatar=intent.getIntExtra("window_avatar",-1);
        String data_theme=intent.getStringExtra("window_theme");
        data_introduction=intent.getStringExtra("window_introduction");
        //String datas=String.valueOf(data);
        tv_show_window.setText("窗口"+data_id);
        tv_window_theme.setText(data_theme);
        //介绍没有
        img_windowAvatar.setImageResource(data_avatar);
        //DetailsFragment df= (DetailsFragment) getSupportFragmentManager().findFragmentById(R.id.layout_fragment_detailes);
        //FragmentManager fragmentManager=n
        /*DetailsFragment df=new DetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString("fragment_details_introduction",data_introduction);
        df.setArguments(bundle);*/
        //getSupportFragmentManager().beginTransaction().replace(R.id.layout_fragment_detailes,df).commit();

    }
    private void window_initPager() {
        window_adapter = new WindowMainFragmentAdapter(getSupportFragmentManager());
        window_viewPager.setAdapter(window_adapter);
        // 关联切换
        window_viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(window_tabLayout));
        window_tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(window_viewPager));
    }
    /**
     * 设置页卡显示效果
     * @param windowLayout
     * @param windowInflater
     * @param windowTitle
     */
    private void window_setTabs(TabLayout windowLayout, LayoutInflater windowInflater, int[] windowTitle) {
        for (int i = 0; i < windowTitle.length; i++) {
            TabLayout.Tab window_tab = windowLayout.newTab();
            View window_view = windowInflater.inflate(R.layout.item_window_menu, null);
            window_tab.setCustomView(window_view);
            //一定要带view.
            TextView tvTitle = window_view.findViewById(R.id.tv_window_tab);
            tvTitle.setText(windowTitle[i]);
            windowLayout.addTab(window_tab);
            //Log.d("MainActivity",tabTitle[0]+"---"+tabImg[0]+"--");
        }
    }
    public String getWindowIntroduction(){
        return data_introduction;
    }
    public int getWindowId(){
        return data_id;
    }
}
