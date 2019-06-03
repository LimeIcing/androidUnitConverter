package com.example.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TAG = "MainActivity";
    private final String WEIGHT = "WEIGHT";
    private final String TEMP = "TEMP";
    private EditText weightFrom, weightTo, tempFrom, tempTo;
    private Button toLb, toKg, toF, toC;
    private float weight, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        if (savedInstanceState != null) {
            weightTo.setText(String.valueOf(savedInstanceState.getFloat(WEIGHT, 0f)));
            tempTo.setText(String.valueOf(savedInstanceState.getFloat(TEMP, 0f)));
        }
    }

    private void init() {
        Log.d(TAG, "initialized");

        weightFrom = findViewById(R.id.fieldFromWeight);
        weightTo = findViewById(R.id.fieldToWeight);
        tempFrom = findViewById(R.id.fieldFromTemp);
        tempTo = findViewById(R.id.fieldToTemp);

        toLb = findViewById(R.id.btnToLB);
        toKg = findViewById(R.id.btnToKg);
        toF = findViewById(R.id.btnToF);
        toC = findViewById(R.id.btnToC);

        toLb.setOnClickListener(this);
        toKg.setOnClickListener(this);
        toF.setOnClickListener(this);
        toC.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick() called");

        switch (v.getId()) {
            case R.id.btnToLB:
                weight = Float.parseFloat(weightFrom.getText().toString()) * 2.204623f;
                weightTo.setText(String.valueOf(weight));
                break;

            case R.id.btnToKg:
                weight = Float.parseFloat(weightFrom.getText().toString()) * 0.4535924f;
                weightTo.setText(String.valueOf(weight));
                break;

            case R.id.btnToF:
                temp = Float.parseFloat(tempFrom.getText().toString()) * 9f / 5f + 32f;
                tempTo.setText(String.valueOf(temp));
                break;

            case R.id.btnToC:
                temp = Float.parseFloat(tempFrom.getText().toString()) - 32f / (9f/5f);
                tempTo.setText(String.valueOf(temp));
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "weight = " + weight + "; temp = " + temp);

        outState.putFloat(WEIGHT, weight);
        outState.putFloat(TEMP, temp);
    }
}
