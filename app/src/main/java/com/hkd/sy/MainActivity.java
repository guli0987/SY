package com.hkd.sy;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;


import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager.widget.ViewPager;

import android.view.MenuItem;

import android.view.Menu;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.hkd.sy.Internet.Login.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    /**
     * 菜单标题
     */
    private final int[] TAB_TITLE = new int[]{R.string.action_index,R.string.action_order,R.string.action_myself};
    /**
     * 菜单图标
     */
    private final int[] TAB_IMG = new int[]{R.drawable.tab_main_index_selector,R.drawable.tab_main_order_selector,R.drawable.tab_main_myself_selector};
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    /**
     * 页卡适配器
     */
    private MainFragmentAdapter adapter;
    //三级联动
    private Spinner spinner_xq;
    private Spinner spinner_st;
    private Spinner spinner_lc;
    ArrayAdapter<String> campusAdapter;
    ArrayAdapter<String> canteenAdapter;
    ArrayAdapter<String> floorAdapter;
    private static int campusPosition=0;
    //校区
    private String []campus=new String[]{"西苑","开元"};
    //食堂
    private String [][]canteen=new String[][]{{"第一食堂","重庆饭店"},{"乾园","嘉园","德园","菁园"}};
    //楼层
    private String [][][]floor=new String[][][]
            {
                    {
                            {"一层","二层"},
                            {"一层"}
                    },
                    {
                            {"一层","二层","三层"},
                            {"一层","二层"},
                            {"一层","二层"},
                            {"一层","二层"}
                    }


    };
    View view;
    Menu mMenu;
    //nav_header_main.xml事件
    private ImageView img_headImg;
    private TextView tv_headName;
    private TextView tv_headAccountNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ButterKnife.bind(this);
        initPager();
        setTabs(tabLayout, getLayoutInflater(), TAB_TITLE, TAB_IMG);
        //select
        //spinner_xq=findViewById(R.id.spinner_xq);
        //spinner_st=findViewById(R.id.spinner_st);
        //头像点击事件'
        View headView=navigationView.getHeaderView(0);
        img_headImg=headView.findViewById(R.id.img_headImg);
        tv_headName=headView.findViewById(R.id.tv_headName);
        tv_headAccountNumber=headView.findViewById(R.id.tv_headAccountNumber);
        img_headImg.setOnClickListener(this);
        MyData();

        /*//三级联动
        view= LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_toobar,null,false);
        spinner_xq=view.findViewById(R.id.spinner_xq);
        spinner_st=view.findViewById(R.id.spinner_st);
        spinner_lc=view.findViewById(R.id.spinner_lc);
        setSpinner();*/
    }

    private void setSpinner() {
        campusAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,campus);
        spinner_xq.setAdapter(campusAdapter);
        canteenAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,canteen[0]);
        spinner_st.setAdapter(canteenAdapter);
        floorAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,floor[0][0]);
        spinner_lc.setAdapter(floorAdapter);
        spinner_xq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                canteenAdapter=new ArrayAdapter(MainActivity.this,android.R.layout.simple_spinner_item,canteen[position]);
                spinner_st.setAdapter(canteenAdapter);
                campusPosition=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinner_st.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                floorAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,floor[campusPosition][position]);
                spinner_lc.setAdapter(floorAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void MyData(){
        Intent intent=getIntent();
        String AccountName=intent.getStringExtra("AccountName");
        if(AccountName!=null){
        tv_headName.setText("暂无昵称");
        tv_headAccountNumber.setText(AccountName);
        }
    }
    private void initPager() {
        adapter = new MainFragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        // 关联切换
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        //tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                // 取消平滑切换
                viewPager.setCurrentItem(tab.getPosition(), false);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //Log.d("MainActivity","111111111");
    }
    /**
     * 设置页卡显示效果
     * @param tabLayout
     * @param inflater
     * @param tabTitle
     * @param tabImg
     */
    private void setTabs(TabLayout tabLayout, LayoutInflater inflater, int[] tabTitle, int[] tabImg) {
        for (int i = 0; i < tabImg.length; i++) {
            TabLayout.Tab tab = tabLayout.newTab();
            View view = inflater.inflate(R.layout.item_main_menu, null);
            tab.setCustomView(view);
            //一定要带view.
            TextView tvTitle = view.findViewById(R.id.tv_tab);
            tvTitle.setText(tabTitle[i]);
            ImageView imgTab = view.findViewById(R.id.iv_tab);
            imgTab.setImageResource(tabImg[i]);

            tabLayout.addTab(tab);
            //Log.d("MainActivity",tabTitle[0]+"---"+tabImg[0]+"--");
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar, menu);
        mMenu=menu;
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id== R.id.action_selectPosition) {
            SelectPosition();
        }
        return super.onOptionsItemSelected(item);
    }

    //选择框
    public void SelectPosition(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(MainActivity.this);
        dialog.setTitle("请选择");
        //三级联动
        view= LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_toobar,null,false);
        spinner_xq=view.findViewById(R.id.spinner_xq);
        spinner_st=view.findViewById(R.id.spinner_st);
        spinner_lc=view.findViewById(R.id.spinner_lc);
        setSpinner();
        dialog.setView(view);
        dialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                MenuItem menuItem=mMenu.findItem(R.id.action_showPosition);
                String xq=spinner_xq.getSelectedItem().toString();
                String st=spinner_st.getSelectedItem().toString();
                String lc=spinner_lc.getSelectedItem().toString();
                menuItem.setTitle(xq+"-"+st+"-"+lc);
            }
        });
        dialog.setNegativeButton("取消", null);
        dialog.show();
    }
    //spinner_xq.setSelection(0,true);
    //spinner_st_ky.setVisibility(View.GONE);
    //spinner_st_xy.setVisibility(View.VISIBLE);

    /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update) {
            Intent intent=new Intent(MainActivity.this,Activity_update.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.img_headImg:
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
        }
    }
}
