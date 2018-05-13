package com.moremoregreen.a4_1bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView tvBMI, tvResult;
    private Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        findViews();
        Bundle bundle = this.getIntent().getExtras();
        Double height = bundle.getDouble("Height");
        Double weight = bundle.getDouble("Weight");
        Double BMI = weight / height / height;
        tvBMI.setText("BMI：" + BMI);

        if (BMI >= 24){
            tvResult.setText("太胖囉!");
        }else if(BMI <= 18.5){
            tvResult.setText("太瘦了哦!!");
        }else if (height <= 0 || weight <= 0){
            tvResult.setText("請重新輸入身高體重");
        }else {
            tvResult.setText("你不錯!身材很標準");
        }
    }

    private void findViews() {
        tvBMI = findViewById(R.id.tvBMI);
        tvResult = findViewById(R.id.tvResult);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainIntent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(MainIntent);
            }
        });
    }
}
