package com.example.carva.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

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
        EditText input2 = (EditText) findViewById(R.id.resultTxt);
        String txt = input.getText().toString();
        String txt2 = input2.getText().toString();
        if(txt.matches("")) {
            Toast.makeText(this,"No entry",Toast.LENGTH_SHORT).show();
        }
        else {
            txt = txt.substring(0, txt.length()-1);
            txt2 = txt;
            input.setText("");
            input.append(txt);
            input2.setText("");
            input2.append(txt);
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

    public boolean checkOperator(String opt){
        if (opt.equals("-")){
            return true;
        }
        if (opt.equals("+")){
            return true;
        }
        if (opt.equals("*")){
            return true;
        }
        if (opt.equals("/")){
            return true;
        }
        if (opt.equals("^")){
            return true;
        }
        return false;
    }

    public boolean isRightAssociative(String x){
        if(x.equals("^") || x.equals("+") || x.equals("-") || x.equals("/") || x.equals("*")){
            return false;
        }
        return true;
    }

    public boolean isOperator(char input){
        if(input=='-'||input=='+'||input=='/'||input=='*'||input=='^')
        {
            return true;
        }
        return false;
    }

    public boolean zeroDiv(String input){
        int cnt = 0;
        for (int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '/'){
                cnt = i;
                break;
            }
        }
        if(cnt!= 0 && input.charAt(cnt+1) == '0'){
            return true;
        }
        return false;
    }
    public int getOperatorValue(String x){
        int value = -1;
        if(x.equals("+") || x.equals("-")){
            value = 1;
        }
        if(x.equals("*") || x.equals("/")){
            value = 2;
        }

        if(x.equals("^")){
            value = 3;
        }
        return value;
    }

    void calcOperation(String input, Stack<Double> temp){
        double left, right, result;
        result = 0;
        right = temp.pop();
        left = temp.pop();
        if (input == "-")
        {
            result = left - right;
        }
        if (input == "+")
        {
            result = left + right;
        }
        if (input == "*"){
            result = left*right;
        }
        if (input == "/"){
            result = left/right;
        }
        if (input == "^"){
            result = Math.pow(left,right);
        }
        temp.push(result);
    }

    public boolean priority(String x, String y){
        int value, value2;
        value = getOperatorValue(x);
        value2 = getOperatorValue(y);

        if(value == value2){
            if(true){
                return false;
            }
            else{
                return  true;
            }
        }
        if(value > value2){
            return  true;
        }
        else{
            return false;
        }
    }

}
