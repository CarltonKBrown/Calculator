package com.example.carva.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clearBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        EditText input2 = (EditText) findViewById(R.id.resultTxt);
        input.setText("");
        input2.setText("");

        if(input.getText().toString().equals("")){
            Toast.makeText(this,"Screen cleared",Toast.LENGTH_SHORT).show();
        }

    }

    public void signBtn(View view){

    }

    public void modBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("%");
    }

    public void delBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        String txt = input.getText().toString();
        if(txt.matches("")) {
            Toast.makeText(this,"No entry",Toast.LENGTH_SHORT).show();
        }
        else {
            txt = txt.substring(0, txt.length()-1);
            input.setText("");
            input.append(txt);
        }
    }
    public void equalBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        String txt = input.getText().toString();
        if(txt.contains("/") || txt.contains("*") || txt.contains("+") || txt.contains("-") || txt.contains("%") ){
            Toast.makeText(this,"contains operator, please implement operations",Toast.LENGTH_SHORT).show();
        }
        else {
            EditText result = (EditText) findViewById(R.id.resultTxt);
            result.setText(txt);
        }
    }
    public void divBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("/");
    }
    public void mulBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("*");
    }
    public void addBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("+");
    }
    public void diffBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("-");
    }
    public void pointBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append(".");
    }

    public void btn7(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("7");
    }
    public void btn8(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("8");
    }
    public void btn9(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("9");
    }
    public void btn4(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("4");
    }
    public void btn5(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("5");
    }
    public void btn6(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("6");
    }
    public void btn1(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("1");
    }
    public void btn2(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("2");
    }
    public void btn3(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("3");
    }
    public void btn0(View   view){
        EditText input = (EditText) findViewById(R.id.entry);
        input.append("0");
    }

}
