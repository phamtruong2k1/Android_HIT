package com.example.phamtruong.haui.buoi5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Type;
import java.util.List;

public class RecyAdapter extends RecyclerView.Adapter<RecyAdapter.ViewHolder> {
    Context context;
    List<User> list;
    Click_recy click_recy;


    public RecyAdapter(List<User> list,Context context,Click_recy click_recy) {
        this.list = list;
        this.context = context;
        this.click_recy = click_recy;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    int type1,type2;


    @Override
    public int getItemViewType(int position) {
        if (position%2==0)
            return 1;
        else
            return 2;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view;
        if (viewType ==1){
            view = layoutInflater.inflate(R.layout.item_recy,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }
        if (viewType ==2){
            view = layoutInflater.inflate(R.layout.item_recy_2,parent,false);
            ViewHolder viewHolder = new ViewHolder(view);
            return viewHolder;
        }
        return null;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = list.get(position);

        holder.ma.setText(user.getMa());
        holder.ten.setText(user.getTen());

//        holder.ma.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context,user.getMa(),Toast.LENGTH_SHORT).show();
//            }
//        });
        if (getItemViewType(position)==1){
            holder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }

    }


    @Override
    public int getItemCount() {
        return list==null?0:list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView ma, ten;
        LinearLayout layout;
        Button button;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            button=itemView.findViewById(R.id.xoa);
            layout=itemView.findViewById(R.id.line);
            ma= itemView.findViewById(R.id.ma);
            ten= itemView.findViewById(R.id.ten);
        }

    }
}
