package com.thuonght.lab5api;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView tvKQ;
    Button btn;
    Context context=this;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=findViewById(R.id.btndata);
        tvKQ=findViewById(R.id.tvKQ1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                VolleyFn2 fn2=new VolleyFn2();
                fn2.getAllDataFromAPI(context,tvKQ);
            }
        });


    }
}