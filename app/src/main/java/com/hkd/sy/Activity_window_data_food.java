package com.hkd.sy;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Activity_window_data_food extends AppCompatActivity {
    private Button btn_addOrder;
    public static final String WINDOW_ID="window_id";
    public static final String FRUIT_ID="window_fruit_id";
    public static final String FRUIT_NAME="window_fruit_name";
    public static final String FRUIT_IMAGE_ID="window_fruit_image_id";
    public static final String FRUIT_Money="window_fruit_money";
    public static final String FRUIT_Introduction="window_fruit_introduction";
    int windowId;
    int fruitId;
    String fruitName;
    int fruitImageId;
    double fruitMoney;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_window_data_food2);
        //Toast.makeText(Activity_window_data_food.this,"下单成功！",Toast.LENGTH_SHORT).show();
        Intent intent=getIntent();
        windowId=intent.getIntExtra(WINDOW_ID,0);
        fruitId=intent.getIntExtra(FRUIT_ID,0);
        fruitName=intent.getStringExtra(FRUIT_NAME);
        fruitImageId=intent.getIntExtra(FRUIT_IMAGE_ID,0);
        fruitMoney=intent.getDoubleExtra(FRUIT_Money,0);
        String fruitIntroduction=intent.getStringExtra(FRUIT_Introduction);
        //
        Toolbar window_toolbar=findViewById(R.id.window_toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout=findViewById(R.id.collapsing_toolbar);
        ImageView imageView=findViewById(R.id.fruit_image_view);
        TextView textview=findViewById(R.id.fruit_content_text);
        setSupportActionBar(window_toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(fruitName);
        Glide.with(this).load(fruitImageId).into(imageView);
        //覆盖整个介绍界面
        //String fruitContent=generateFruitContent(fruitIntroduction);
        textview.setText(fruitIntroduction);
        FloatingActionButton fab=findViewById(R.id.order_commit);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConfirmOrder();
            }
        });
    }
    private void ConfirmOrder(){
        AlertDialog.Builder dialog=new AlertDialog.Builder(Activity_window_data_food.this);
        dialog.setTitle("订单提交");
        //dialog.setView(view);
        dialog.setCancelable(false);
        dialog.setMessage("您选择了"+windowId+"号窗口"+fruitName+",单价"+fruitMoney+"元\n"+"是否提交订单？如果确认，食堂将为您准备餐食");
        dialog.setPositiveButton("提交", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent1=new Intent(Activity_window_data_food.this,Activity_window_data_order.class);
                intent1.putExtra("goods_windowId",windowId);
                intent1.putExtra("goods_windowFoodId",fruitId);
                intent1.putExtra("goods_windowFoodPhotoId",fruitImageId);
                intent1.putExtra("goods_windowFoodName",fruitName);
                intent1.putExtra("goods_windowFoodMoney",fruitMoney);
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
                String OrderTime=sdf.format(date);
                String OrderBeforeNumber=sdf2.format(date);
                intent1.putExtra("goods_windowOrderTime",OrderTime);
                Random r=new Random();
                int OrderNumber=r.nextInt(900000)+100000;
                String AllOrderNumber=OrderBeforeNumber+OrderNumber;
                intent1.putExtra("goods_windowOrderNumber",AllOrderNumber);
                startActivity(intent1);
            }
        });
        dialog.setNegativeButton("再等等", null);
        dialog.show();

    }
    private String generateFruitContent(String fruitName){
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<500;i++){
            stringBuilder.append(fruitName);
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
