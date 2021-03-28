package com.hkd.sy.Window;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hkd.sy.Activity_window_data_food;
import com.hkd.sy.R;

import java.util.List;

public class WindowOrderDishesAdapter extends RecyclerView.Adapter<WindowOrderDishesAdapter.ViewHolder> {
    private List<WindowOrderDishesList> mRecommendList;
    private int mWindowId;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_DishesPhoto;
        private TextView tv_DishesName;
        private TextView tv_DishesMoney;
        private LinearLayout layout_window_od;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_DishesPhoto=itemView.findViewById(R.id.img_DishesPhoto);
            tv_DishesName=itemView.findViewById(R.id.tv_DishesName);
            tv_DishesMoney=itemView.findViewById(R.id.tv_DishesMoney);
            layout_window_od= itemView.findViewById(R.id.layout_window_od);
        }
    }
    public WindowOrderDishesAdapter(List<WindowOrderDishesList> recommendList, int window_id){
        mRecommendList=recommendList;
        mWindowId=window_id;
    }
    @NonNull
    @Override
    public WindowOrderDishesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.window_data_orderdishes,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.layout_window_od.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                WindowOrderDishesList windowOrderDishesList=mRecommendList.get(position);
                int window_OD_Id=windowOrderDishesList.getWindowODId();
                //进入食物大图，没做
                Intent intent=new Intent(v.getContext(), Activity_window_data_food.class);
                intent.putExtra("window_id",mWindowId);
                intent.putExtra("window_fruit_id",window_OD_Id);
                intent.putExtra("window_fruit_name",windowOrderDishesList.getWindowODName());
                intent.putExtra("window_fruit_image_id",windowOrderDishesList.getWindowODImage());
                intent.putExtra("window_fruit_money",windowOrderDishesList.getWindowODMoney());
                intent.putExtra("window_fruit_introduction",windowOrderDishesList.getWindowODIntroduction());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WindowOrderDishesAdapter.ViewHolder viewHolder, int i) {
        WindowOrderDishesList windowOrderDishesList=mRecommendList.get(i);
            viewHolder.img_DishesPhoto.setImageResource(windowOrderDishesList.getWindowODImage());
            viewHolder.tv_DishesName.setText(windowOrderDishesList.getWindowODName());
            double dMoney=windowOrderDishesList.getWindowODMoney();
            viewHolder.tv_DishesMoney.setText("￥"+dMoney);
    }

    @Override
    public int getItemCount() {
        return mRecommendList.size();
    }

}
