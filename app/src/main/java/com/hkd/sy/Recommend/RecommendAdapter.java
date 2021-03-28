package com.hkd.sy.Recommend;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hkd.sy.R;
import com.hkd.sy.Activity_window_data;

import java.util.List;

public class RecommendAdapter extends RecyclerView.Adapter<RecommendAdapter.ViewHolder> {
    private List<RecommendList> mRecommendList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView img_windowAvatar;
        private ImageView img_windowImageA;
        private ImageView img_windowImageB;
        private ImageView img_windowImageC;
        private Button btn_windowBtn;
        private TextView tv_windowName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_windowAvatar=itemView.findViewById(R.id.img_windowAvatar);
            img_windowImageA=itemView.findViewById(R.id.img_windowImageA);
            img_windowImageB=itemView.findViewById(R.id.img_windowImageB);
            img_windowImageC=itemView.findViewById(R.id.img_windowImageC);
            btn_windowBtn=itemView.findViewById(R.id.btn_windowBtn);
            tv_windowName=itemView.findViewById(R.id.tv_windowName);
        }
    }
    public RecommendAdapter(List<RecommendList> recommendList){
        mRecommendList=recommendList;
    }
    @NonNull
    @Override
    public RecommendAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recommend_item,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        holder.btn_windowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position=holder.getAdapterPosition();
                RecommendList recommendList=mRecommendList.get(position);
                int windowId=recommendList.getWindowId();
                Intent intent=new Intent(v.getContext(), Activity_window_data.class);
                intent.putExtra("window_id",windowId);
                intent.putExtra("window_avatar",recommendList.getWindowAvatar());
                intent.putExtra("window_theme",recommendList.getWindowTheme());
                intent.putExtra("window_introduction",recommendList.getWindowIntroduction());
                v.getContext().startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendAdapter.ViewHolder viewHolder, int i) {
            RecommendList recommendlist=mRecommendList.get(i);
            viewHolder.img_windowAvatar.setImageResource(recommendlist.getWindowAvatar());
            viewHolder.img_windowImageA.setImageResource(recommendlist.getWindowImageA());
            viewHolder.img_windowImageB.setImageResource(recommendlist.getWindowImageB());
            viewHolder.img_windowImageC.setImageResource(recommendlist.getWindowImageC());
            viewHolder.tv_windowName.setText(recommendlist.getWindowName());
            viewHolder.btn_windowBtn.setText(recommendlist.getWindowBtn());
    }

    @Override
    public int getItemCount() {
        return mRecommendList.size();
    }

}
