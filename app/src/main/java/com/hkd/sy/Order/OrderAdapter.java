package com.hkd.sy.Order;

import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.hkd.sy.Activity_window_data_order;
import com.hkd.sy.R;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {
    private List<OrderList> moList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout_order_data;
        private ImageView food_img;
        private TextView food_name;
        private TextView food_order_status;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            food_img=itemView.findViewById(R.id.food_img);
            food_name=itemView.findViewById(R.id.food_name);
            food_order_status=itemView.findViewById(R.id.food_order_status);
            layout_order_data=itemView.findViewById(R.id.layout_order_data);
        }
    }
    public OrderAdapter(List<OrderList> recommendList){
        moList=recommendList;
    }
    @NonNull
    @Override
    public OrderAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.window_data_order_details,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.layout_order_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                OrderList orderList=moList.get(position);
                int orderId=orderList.getOrderNumber();
                Intent intent=new Intent(v.getContext(), Activity_window_data_order.class);
                intent.putExtra("goods_windowId",3);
                intent.putExtra("goods_windowFoodId",4);
                intent.putExtra("goods_windowFoodPhotoId",R.drawable.eat6);
                intent.putExtra("goods_windowFoodName","河豚");
                intent.putExtra("goods_windowFoodMoney",9.9);
                Date date=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat sdf2=new SimpleDateFormat("yyyyMMdd");
                String OrderTime=sdf.format(date);
                String OrderBeforeNumber=sdf2.format(date);
                intent.putExtra("goods_windowOrderTime",OrderTime);
                Random r=new Random();
                int OrderNumber=r.nextInt(900000)+100000;
                String AllOrderNumber=OrderBeforeNumber+OrderNumber;
                intent.putExtra("goods_windowOrderNumber",AllOrderNumber);
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderAdapter.ViewHolder viewHolder, int i) {
            OrderList orderList=moList.get(i);
            viewHolder.food_img.setImageResource(orderList.getFoodImage());
            viewHolder.food_name.setText(orderList.getFoodName());
            viewHolder.food_order_status.setText(orderList.getOrderStatus());
    }

    @Override
    public int getItemCount() {
        return moList.size();
    }

}
