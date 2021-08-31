package com.example.recycleviewfromfirestore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.myViewHolder>
{
    ArrayList<model> dataList;

    public myAdapter(ArrayList<model> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.singalrow,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {

        holder.firstName.setText(dataList.get(position).getFirstName());
        holder.lastName.setText(dataList.get(position).getLastName());
        holder.Age.setText(String.valueOf(dataList.get(position).getAge()));



    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class myViewHolder extends RecyclerView.ViewHolder
    {
        TextView firstName, lastName, Age;
        public myViewHolder(@NonNull View itemView) {
            super(itemView);
            firstName = itemView.findViewById(R.id.firstNameET);
            lastName = itemView.findViewById(R.id.lastNameET);
            Age = itemView.findViewById(R.id.ageET);
        }
    }
}
