package com.taylorngo.calculatorapp;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdd = findViewById(R.id.addBtn);
        Button btnSub = findViewById(R.id.subtractBtn);
        Button btnMul = findViewById(R.id.multiplyBtn);
        Button btnDiv = findViewById(R.id.divideBtn);

        btnAdd.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnMul.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View v) {

        EditText firstNumberText = findViewById(R.id.firstNumberText);
        EditText secondNumberText = findViewById(R.id.secondNumberText);
        TextView answerText = findViewById(R.id.answerText);
        double firstNumber;
        double secondNumber;

        try{
            firstNumber = Double.parseDouble(firstNumberText.getText().toString());
            secondNumber = Double.parseDouble(secondNumberText.getText().toString());
        }
        catch (NumberFormatException e){
            answerText.setText("Invalid Input(s).");
            return;
        }
        try{
            switch(v.getId()){
                case R.id.addBtn:
                    answerText.setText("Answer: " + Math.round((firstNumber + secondNumber) * 100.0) / 100.0);
                    break;
                case R.id.subtractBtn:
                    answerText.setText("Answer: " + Math.round((firstNumber - secondNumber) * 100.0) / 100.0);
                    break;
                case R.id.multiplyBtn:
                    answerText.setText("Answer: " + Math.round((firstNumber * secondNumber) * 100.0) / 100.0);
                    break;
                case R.id.divideBtn:
                    if(secondNumber == 0){
                        throw new ArithmeticException("Error: Cannot divide by 0");
                    }
                    answerText.setText("Answer: " + Math.round((firstNumber / secondNumber) * 100.0) / 100.0);
                    break;
                default:
                    break;
            }
        }
        catch (ArithmeticException e){
            if(secondNumber == 0 && v.getId() == R.id.divideBtn)
                answerText.setText(e.getMessage());
            else{
                answerText.setText("Invalid Input(s).");
            }
        }
    }
}