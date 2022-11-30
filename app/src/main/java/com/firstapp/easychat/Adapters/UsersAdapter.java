package com.firstapp.easychat.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firstapp.easychat.ChatDetailActivity;
import com.firstapp.easychat.Models.Users;
import com.firstapp.easychat.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.Viewholder> {
    ArrayList<Users> list;
    Context context;

    public UsersAdapter(ArrayList<Users> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.sample_show_user , parent , false);

        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
     Users users = list.get(position);
    Picasso.get() .load(users.getProfilepic()).placeholder(R.drawable.user_account_person_avatar_svgrepo_com)
            .into(holder.image);
    holder.userName.setText(users.getUsername());

    holder.itemView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context , ChatDetailActivity.class);
            intent.putExtra("userID" , users.getUserId());
            intent.putExtra("profilePic" , users.getProfilepic());
            intent.putExtra("userName" , users.getUsername());
            context.startActivity(intent);
        }
    });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Viewholder extends RecyclerView.ViewHolder {


         ImageView image;
         TextView userName, LastMessage;
        public Viewholder(@NonNull View itemView) {
            super(itemView);

            image= itemView.findViewById(R.id.profile_image);
            userName= itemView.findViewById(R.id.userName);
            LastMessage= itemView.findViewById(R.id.LastMessage);
        }
    }


}

