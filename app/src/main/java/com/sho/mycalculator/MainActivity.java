package com.sho.mycalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


        TextView tvScreen;
        Button btC,btDot,btBack,btDivision,btNo7,btNo6,btNo5,btNo8,btNo9,btNo4,btNo3,btNo2,btNo1,btNo0,btMultiple,btMinus,btAddition,btEqual;

        private String input,Answer;
      @SuppressLint("MissingInflatedId")
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            tvScreen = findViewById(R.id.tvScreen);
            btC = findViewById(R.id.btC);
            btAddition = findViewById(R.id.btAddition);
            btBack = findViewById(R.id.btBack);
            btDivision = findViewById(R.id.btDivision);
            btMultiple = findViewById(R.id.btMultiple);
            btMinus = findViewById(R.id.btMinus);
            btEqual = findViewById(R.id.btEqual);
            btDot = findViewById(R.id.btDot);
            btNo9 = findViewById(R.id.btNo9);
            btNo8 = findViewById(R.id.btNo8);
            btNo7 = findViewById(R.id.btNo7);
            btNo6 = findViewById(R.id.btNo6);
            btNo5 = findViewById(R.id.btNo5);
            btNo4 = findViewById(R.id.btNo4);
            btNo3 = findViewById(R.id.btNo3);
            btNo2 = findViewById(R.id.btNo2);
            btNo1 = findViewById(R.id.btNo1);
            btNo0 = findViewById(R.id.btNo0);

        }
        public void ButtonClick(View v){
            Button button = (Button) v;
            String data = button.getText().toString();
            switch (data){
                case "C":
                    input ="";
                    break;

                case "×":
                    Solve();
                    input += "*";
                    break;
                case "=":
                    Solve();
                    Answer = input;
                    break;
                case "÷":
                    Solve();
                    input +="%";
                    break;

                case "⌫":
                    String Text = input.substring(0,input.length()-1);
                    input = Text;
                    break;

                default:
                    if(input==null){
                        input ="";
                    }
                    if(input.equals("+")|| input.equals("-")||input.equals("÷")){
                        Solve();
                    }
                    input+=data;
            }
            tvScreen.setText(input);
        }
        private void Solve(){

            if(input.split("\\*").length==2) {
                String number[] = input.split("\\*");
                try {
                    Double mul = Double.parseDouble(number[0]) * Double.parseDouble(number[1]);
                    input = mul+"";
                }
                catch (Exception e){
                    System.out.println("Error");
                }
            }
            else if(input.split("\\+").length==2) {
                String number[] = input.split("\\+");
                try {
                    Double sum = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                    input = sum +"";
                }
                catch (Exception e){
                    System.out.println("Error");
                }
            }
            else if(input.split("%").length==2) {
                String number[] = input.split("%");
                try {
                    Double div = Double.parseDouble(number[0]) % Double.parseDouble(number[1]);
                    input = div+"";
                }
                catch (Exception e){
                    System.out.println("Error");
                }
            }
            else if(input.split("-").length>1) {
                String number[] = input.split("-");
                if(number[0] =="" && number.length == 3){
                    number[0] = 0+"";
                }
                try {
                    Double sub = Double.parseDouble(number[0]) - Double.parseDouble(number[1]);
                    input = sub+"";
                }
                catch (Exception e){
                    System.out.println("Error");
                }
            }
            String n[] = input.split("\\.");
            if(n.length>1){
                if(n[1].equals("0")){
                    input = n[0];
                }
            }
            tvScreen.setText(input);
        }
    }

