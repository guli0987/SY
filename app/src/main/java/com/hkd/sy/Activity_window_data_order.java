package com.hkd.sy;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_window_data_order extends AppCompatActivity {
    private TextView order_foodPosition;
    private ImageView order_foodImage;
    private TextView order_foodName;
    private TextView order_foodMoney;
    private TextView order_foodQuantity;
    private TextView order_foodMoneyEnsure;
    private TextView order_orderAllMoney;
    private TextView order_DiscountCard;
    private TextView order_EndMoney;
    private TextView order_orderTime;
    private TextView order_orderNumber;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_window_data_food_order);
        order_foodPosition=findViewById(R.id.order_foodPosition);
        order_foodImage=findViewById(R.id.order_foodImage);
        order_foodName=findViewById(R.id.order_foodName);
        order_foodMoney=findViewById(R.id.order_foodMoney);
        order_foodQuantity=findViewById(R.id.order_foodQuantity);
        order_foodMoneyEnsure=findViewById(R.id.order_foodMoneyEnsure);
        order_orderAllMoney=findViewById(R.id.order_orderAllMoney);
        order_DiscountCard=findViewById(R.id.order_DiscountCard);
        order_EndMoney=findViewById(R.id.order_EndMoney);
        order_orderTime=findViewById(R.id.order_orderTime);
        order_orderNumber=findViewById(R.id.order_orderNumber);
        init();

    }
    public void init(){
        Intent intent=getIntent();
        order_foodPosition.setText("西苑>第一食堂一楼>窗口"+intent.getIntExtra("goods_windowId",0));
        order_foodImage.setImageResource(intent.getIntExtra("goods_windowFoodPhotoId",0));
        order_foodName.setText(intent.getStringExtra("goods_windowFoodName"));
        order_foodMoney.setText("￥"+intent.getDoubleExtra("goods_windowFoodMoney",0));
        order_foodQuantity.setText("1");
        order_foodMoneyEnsure.setText("￥"+intent.getDoubleExtra("goods_windowFoodMoney",0));
        order_orderAllMoney.setText("￥"+intent.getDoubleExtra("goods_windowFoodMoney",0));
        order_DiscountCard.setText("无");
        order_EndMoney.setText("￥"+intent.getDoubleExtra("goods_windowFoodMoney",0));
        order_orderTime.setText(intent.getStringExtra("goods_windowOrderTime"));
        order_orderNumber.setText(intent.getStringExtra("goods_windowOrderNumber"));
    }

}
