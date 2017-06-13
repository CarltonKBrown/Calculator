package com.example.carva.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {

    String operation ="";
    String equation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clearBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        EditText input2 = (EditText) findViewById(R.id.resultTxt);


        if((input.getText().toString().equals("") && input2.getText().toString().equals(""))){
            Toast.makeText(this,"Screen cleared",Toast.LENGTH_SHORT).show();
        }
        else{
            input.setText("");
            input2.setText("");
            operation = "";
        }

    }

    public void signBtn(View view){
        Toast.makeText(this,"operator not coded",Toast.LENGTH_SHORT).show();
    }

    public void modBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        if(!operation.equals("")){
            Toast.makeText(this,"Operator already present",Toast.LENGTH_SHORT).show();
        }

        if(input.getText().toString().equals("") && operation.equals("")){
            input.setText("%");
            operation = "%";
        }

        if(operation.equals("") && !input.getText().toString().equals("UNDEFINED")){
            input.append("%");
            operation = "%";
        }

    }

    public void delBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        EditText input2 = (EditText) findViewById(R.id.resultTxt);

        String txt = input.getText().toString();

        if(input.getText().toString().equals("UNDEFINED")){
            input.setText("");
            input2.setText("");
            operation = "";
        }

         if(!input.getText().toString().contains("+") || !input.getText().toString().contains("-") || !input.getText().toString().contains("*") || !input.getText().toString().contains("/")){
            operation = "";
        }

         if(!input.getText().toString().equals("")) {

             txt = txt.substring(0, txt.length()-1);
             input.setText("");
             input.append(txt);
        }
        else {
             Toast.makeText(this,"No entry",Toast.LENGTH_SHORT).show();
             operation = "";
        }
    }
    public void equalBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        EditText input2 = (EditText) findViewById(R.id.resultTxt);
        equation = input.getText().toString();

        double num1, num2, result;

        if(equation.substring(equation.indexOf(operation) + 1).equals(".")){
            input2.setText(equation);
            input.setText("UNDEFINED");
        }
        else if(!operation.equals("")) {
            num1 = Double.parseDouble(equation.substring(0, equation.indexOf(operation)));
            if (equation.substring(equation.indexOf(operation) + 1).equals("")) {
                num2 = Double.parseDouble(equation.substring(0, equation.indexOf(operation)));
            } else {
                num2 = Double.parseDouble(equation.substring(equation.indexOf(operation) + 1));
            }

            if (equation.equals("UNDEFINED")) {
                Toast.makeText(this, "Result is Undefined, Please clear text", Toast.LENGTH_SHORT).show();
            }

            if (operation.equals("+")) {
                result = num1 + num2;
                input2.setText(String.valueOf(num1) + "+" + String.valueOf(num2));
                input.setText(String.valueOf(result));
            }

            if (operation.equals("-")) {
                result = num1 - num2;
                input2.setText(String.valueOf(num1) + "-" + String.valueOf(num2));
                input.setText(String.valueOf(result));
            }

            if (operation.equals("*")) {
                result = num1 * num2;
                input2.setText(String.valueOf(num1) + "*" + String.valueOf(num2));
                input.setText(String.valueOf(result));
            }

            if (operation.equals("/")) {
                if (num2 == 0) {
                    input.setText("UNDEFINED");
                    input2.setText(equation);
                } else {
                    result = num1 / num2;
                    input2.setText(String.valueOf(num1) + "/" + String.valueOf(num2));
                    input.setText(String.valueOf(result));
                }

            }

            if (operation.equals("%")) {
                if (num2 == 0) {
                    input.setText("UNDEFINED");
                    input2.setText(equation);
                } else {
                    result = num1 % num2;
                    input2.setText(String.valueOf(num1) + "%" + String.valueOf(num2));
                    input.setText(String.valueOf(result));
                }

            }

            operation = "";
        }
        else
        {
            input2.setText(equation);
        }
        /*if(txt.contains("/") || txt.contains("*") || txt.contains("+") || txt.contains("-") || txt.contains("%") ){
            Toast.makeText(this,"contains operator, please implement operations",Toast.LENGTH_SHORT).show();
        }
        else {
            EditText result = (EditText) findViewById(R.id.resultTxt);
            result.setText(txt);
        }*/
    }
    public void divBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        if(!operation.equals("")){
            Toast.makeText(this,"Operator already present",Toast.LENGTH_SHORT).show();
        }

        if(input.getText().toString().equals("") && operation.equals("")){
            input.setText("/");
            operation = "/";
        }

        if(operation.equals("") && !input.getText().toString().equals("UNDEFINED")){
            input.append("/");
            operation = "/";
        }
    }
    public void mulBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        if(!operation.equals("")){
            Toast.makeText(this,"Operator already present",Toast.LENGTH_SHORT).show();
        }

        if(input.getText().toString().equals("") && operation.equals("")){
            input.setText("*");
            operation = "*";
        }

        if(operation.equals("") && !input.getText().toString().equals("UNDEFINED")){
            input.append("*");
            operation = "*";
        }
    }
    public void addBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        if(!operation.equals("")){
            Toast.makeText(this,"Operator already present",Toast.LENGTH_SHORT).show();
        }

        if(input.getText().toString().equals("") && operation.equals("")){
            input.setText("+");
            operation = "+";
        }

        if(operation.equals("") && !input.getText().toString().equals("UNDEFINED")){
            input.append("+");
            operation = "+";
        }

    }
    public void diffBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);
        if(!operation.equals("")){
            Toast.makeText(this,"Operator already present",Toast.LENGTH_SHORT).show();
        }

        if(input.getText().toString().equals("") && operation.equals("")){
            input.setText("-");
            operation = "-";
        }

        if(operation.equals("") && !input.getText().toString().equals("UNDEFINED")){
            input.append("-");
            operation = "-";
        }
    }
    public void pointBtn(View view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText(".");
        }
        else{
            input.append(".");
        }

    }

    public void btn7(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("7");
        }
        else{
            input.append("7");
        }
    }
    public void btn8(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("8");
        }
        else{
            input.append("8");
        }
    }
    public void btn9(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("9");
        }
        else{
            input.append("9");
        }
    }
    public void btn4(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("4");
        }
        else{
            input.append("4");
        }
    }
    public void btn5(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("5");
        }
        else{
            input.append("5");
        }
    }
    public void btn6(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("6");
        }
        else{
            input.append("6");
        }
    }
    public void btn1(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("1");
        }
        else{
            input.append("1");
        }
    }
    public void btn2(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("2");
        }
        else{
            input.append("2");
        }
    }
    public void btn3(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("3");
        }
        else{
            input.append("3");
        }
    }
    public void btn0(View   view){
        EditText input = (EditText) findViewById(R.id.entry);

        if(input.getText().toString().equals("") || input.getText().toString().equals("UNDEFINED")){
            input.setText("0");
        }
        else{
            input.append("0");
        }
    }

   /* public boolean checkOperator(String opt){
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
    }*/

}
