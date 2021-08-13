package com.example.recycleviewedit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

import static com.example.recycleviewedit.R.layout.activity_main;

public class MainActivity extends AppCompatActivity implements ItemClickListner{
ArrayList<Employee>employeeList = new ArrayList<>();
RecyclerView recyclerView;
EmployeeAdapter employeeAdapter;
CardView mEditCardview;
EditText mEtName, mEtAge,mEtAddress;
Button mBtnDone, mBtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        initview();
        buildEmployeeList();
        setRecyclerview();
        mBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEditCardview.setVisibility(View.VISIBLE);

                mBtnDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mEditCardview.setVisibility(View.GONE);

                        //edited text
                        Employee new_employee = new Employee(mEtName.getText().toString(),Integer.parseInt(mEtAge.getText().toString()),mEtAddress.getText().toString()); // edited details

                        employeeList.add(new_employee);           // replacing the new values with the help of old values
                        employeeAdapter.notifyDataSetChanged();           // notifying adapter that data has been changed
                    }
                });
            }
        });

    }



    private void setRecyclerview() {
employeeAdapter = new EmployeeAdapter(employeeList,this);
recyclerView.setAdapter(employeeAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    private void buildEmployeeList() {
        for (int i=1;i<25;i++){
            Employee employee = new Employee("Saurabh"+i,23,"House no 9"+i);
            employeeList.add(employee);
        }
    }

    private void initview() {
    recyclerView = findViewById(R.id.recyclerView);
    mEditCardview = findViewById(R.id.editCardview);
    mEtName = findViewById(R.id.etName);
    mEtAge = findViewById(R.id.etAge);
    mEtAddress = findViewById(R.id.etAddress);
    mBtnDone = findViewById(R.id.btnDone);
    mBtnAdd = findViewById(R.id.btnAdd);


    }

    @Override
    public void onItemclicked(int position, Employee employee) {
mEditCardview.setVisibility(View.VISIBLE);               // to set visiblility visible in cardview
mEtName.setText(employee.getName());                    // predefined text in the views of cardview
mEtAge.setText(employee.getAge()+"");
mEtAddress.setText(employee.getAddress());


mBtnDone.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        mEditCardview.setVisibility(View.GONE);

        //edited text
        Employee new_employee = new Employee(mEtName.getText().toString(),Integer.parseInt(mEtAge.getText().toString()),mEtAddress.getText().toString()); // edited details

        employeeList.set(position,new_employee);           // replacing the new values with the help of old values
        employeeAdapter.notifyDataSetChanged();           // notifying adapter that data has been changed
    }
});

    }
}