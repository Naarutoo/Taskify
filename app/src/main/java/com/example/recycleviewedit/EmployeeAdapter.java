package com.example.recycleviewedit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeViewHolder> {
ArrayList<Employee> employeeList;
ItemClickListner itemClickListner;
public  EmployeeAdapter(ArrayList<Employee> employeeList,ItemClickListner itemClickListner){
    this.employeeList=employeeList;
    this.itemClickListner = itemClickListner;
}
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
 return new EmployeeViewHolder(view,itemClickListner);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
Employee employee = employeeList.get(position);
holder.setData(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
}
