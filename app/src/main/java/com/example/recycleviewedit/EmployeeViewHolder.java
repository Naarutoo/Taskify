package com.example.recycleviewedit;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class EmployeeViewHolder extends RecyclerView.ViewHolder {
TextView mTvName, mTvAge, mTvAddress;
ImageView mIvEdit;
ItemClickListner itemClickListner;
    public EmployeeViewHolder(@NonNull View itemView,ItemClickListner itemClickListner) {
        super(itemView);
        initView(itemView);
        this.itemClickListner = itemClickListner;
    }

    private void initView(View itemView) {
    mTvName = itemView.findViewById(R.id.tvName);
    mTvAge = itemView.findViewById(R.id.tvAge);
    mTvAddress = itemView.findViewById(R.id.tvAddress);
    mIvEdit = itemView.findViewById(R.id.ivEdit);
    }

    public void setData(Employee employee){
        mTvName.setText(employee.getName());
        mTvAge.setText(employee.getAge()+"");
        mTvAddress.setText(employee.getAddress());

        mIvEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListner.onItemclicked(getAdapterPosition(),employee);
            }
        });
    }
}
