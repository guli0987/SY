package com.hkd.sy.Window;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hkd.sy.Activity_window_data;
import com.hkd.sy.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class WindowEvaluationAdapter extends RecyclerView.Adapter<WindowEvaluationAdapter.ViewHolder> {
    private List<WindowEvaluationList> mList;
    static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView tv_eUsername;
        private TextView tv_eCommentTime;
        private TextView tv_eFavorability;
        private TextView tv_eEvaluation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_eUsername=itemView.findViewById(R.id.tv_eUsername);
            tv_eCommentTime=itemView.findViewById(R.id.tv_eCommentTime);
            tv_eFavorability=itemView.findViewById(R.id.tv_eFavorability);
            tv_eEvaluation= itemView.findViewById(R.id.tv_eEvaluation);
        }
    }
    public WindowEvaluationAdapter(List<WindowEvaluationList> recommendList){
        mList=recommendList;
    }
    @NonNull
    @Override
    public WindowEvaluationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.window_data_evaluation,viewGroup,false);
        final ViewHolder holder=new ViewHolder(view);
        //评论暂时不设置点击事件
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull WindowEvaluationAdapter.ViewHolder viewHolder, int i) {
        WindowEvaluationList wList=mList.get(i);
          viewHolder.tv_eUsername.setText("用户："+wList.getUsername());
          Date date=new Date();
          //SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            String CommentTime=sdf.format(date);
            viewHolder.tv_eCommentTime.setText(""+CommentTime);
            viewHolder.tv_eFavorability.setText("|-好感度_|"+wList.getFavorability());
            viewHolder.tv_eEvaluation.setText(""+wList.getComment());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
