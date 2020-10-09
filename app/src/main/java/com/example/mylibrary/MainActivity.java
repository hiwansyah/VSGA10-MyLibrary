package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnStore, btnGetALl;
    private EditText etname;
    private DatabaseHelper databaseHelper;
    private TextView tvnames;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStore = findViewById(R.id.btnstore);
        btnGetALl = findViewById(R.id.btnget);
        etname = findViewById(R.id.etname);
        tvnames = findViewById(R.id.tvnames);
        databaseHelper = new DatabaseHelper(this);
        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.addStudentDetail(etname.getText().toString());
                etname.setText("");
                Toast.makeText(MainActivity.this, "Stored Succesfully!",Toast.LENGTH_SHORT).show();
            }
        });
        btnGetALl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList = databaseHelper.getAllStudentsList();
                tvnames.setText("");
                for (int i=0;i<arrayList.size();i++){
                    tvnames.setText(tvnames.getText().toString()+", "
                    +arrayList.get(i));
                }
            }
        });
    }
}