package com.moremoregreen.a4_1bmi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edH,edW;
    private Button btnCal,btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        
    }

    private void findViews() {
        edH = findViewById(R.id.edH);
        edW = findViewById(R.id.edW);
        btnCal = findViewById(R.id.btnCal);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent(MainActivity.this, ResultActivity.class);

                Bundle bundle = new Bundle();
                try {
                    double height = Double.parseDouble(edH.getText().toString().trim());  //trim() = 頭尾去空格
                    double weight = Double.parseDouble(edW.getText().toString().trim());

                    bundle.putDouble("Height", height);
                    bundle.putDouble("Weight", weight);

                }catch (Exception e){
                   String error =  e.getMessage();
                    Toast.makeText(MainActivity.this, error, Toast.LENGTH_SHORT).show();
                }

                resultIntent.putExtras(bundle);
                startActivity(resultIntent);
            }
        });
        btnClear = findViewById(R.id.btnClear);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edH.setText("");
                edW.setText("");
            }
        });
    }


}
