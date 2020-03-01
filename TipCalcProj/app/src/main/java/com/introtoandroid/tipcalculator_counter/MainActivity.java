package com.introtoandroid.tipcalculator_counter;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import static android.view.Gravity.*;

public class MainActivity extends AppCompatActivity {

    EditText amountInput;
    EditText numPeopleInput;
    EditText otherTip;
    Button ten;
    Button fifteen;
    Button twenty;
    Button otherButton;
    Button res;
    Button calc;
    TextView tip;
    TextView total;
    TextView totalPerPerson;
    double enteredTotal;
    double enteredPeople;
    double tipCalc;
    double totalWithTip;
    double tpp;
    double otherPerc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        amountInput = findViewById(R.id.amountInput);
        numPeopleInput = findViewById(R.id.splitInput);
        otherTip = findViewById(R.id.otherInput);
        ten = findViewById(R.id.percent10);
        fifteen = findViewById(R.id.percent15);
        twenty = findViewById(R.id.percent20);
        otherButton = findViewById(R.id.otherPercent);
        res = findViewById(R.id.reset);
        calc = findViewById(R.id.calculate);
        tip = findViewById(R.id.tipOutput);
        total = findViewById(R.id.totalOutput);
        totalPerPerson = findViewById(R.id.ppOutput);

        Toast.makeText(getApplicationContext(),"Enter a percentage before clicking the OTHER PERCENT button", Toast.LENGTH_LONG).show();

        ten.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enteredTotal = Integer.parseInt(amountInput.getText().toString());
                enteredPeople = Integer.parseInt(numPeopleInput.getText().toString());
                tipCalc = enteredTotal * .10;
                totalWithTip = enteredTotal + tipCalc;
                tpp = totalWithTip / enteredPeople;
            }
        });

        fifteen.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enteredTotal = Integer.parseInt(amountInput.getText().toString());
                enteredPeople = Integer.parseInt(numPeopleInput.getText().toString());
                tipCalc = enteredTotal * .15;
                totalWithTip = enteredTotal + tipCalc;
                tpp = totalWithTip / enteredPeople;
            }
        });

        twenty.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                enteredTotal = Integer.parseInt(amountInput.getText().toString());
                enteredPeople = Integer.parseInt(numPeopleInput.getText().toString());
                tipCalc = enteredTotal * .20;
                totalWithTip = enteredTotal + tipCalc;
                tpp = totalWithTip / enteredPeople;
            }
        });

        otherButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                otherPerc = Integer.parseInt(otherTip.getText().toString());
                enteredTotal = Integer.parseInt(amountInput.getText().toString());
                enteredPeople = Integer.parseInt(numPeopleInput.getText().toString());
                tipCalc = enteredTotal * (otherPerc / 100);
                totalWithTip = enteredTotal + tipCalc;
                tpp = totalWithTip / enteredPeople;
            }
        });

        res.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                totalWithTip = 0;
                tipCalc = 0;
                tpp = 0;
                total.setText("");
                tip.setText("");
                totalPerPerson.setText("");
                amountInput.setText("");
                numPeopleInput.setText("");
                otherTip.setText("");
            }
        });

        calc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                total.setText(String.valueOf(totalWithTip));
                tip.setText(String.valueOf(tipCalc));
                totalPerPerson.setText(String.valueOf(tpp));
            }
        });

    }

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        String value1 = tip.getText().toString();
        String value2 = total.getText().toString();
        String value3 = totalPerPerson.getText().toString();
        String value4 = amountInput.getText().toString();
        String value5 = numPeopleInput.getText().toString();
        String value6 = otherTip.getText().toString();

        outState.putString("key1", value1);
        outState.putString("key2", value2);
        outState.putString("key3", value3);
        outState.putString("key4", value4);
        outState.putString("key5", value5);
        outState.putString("key6", value6);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String value1 = savedInstanceState.getString("key1");
        tip.setText(value1);
        String value2 = savedInstanceState.getString("key2");
        total.setText(value2);
        String value3 = savedInstanceState.getString("key3");
        totalPerPerson.setText(value3);
        String value4 = savedInstanceState.getString("key4");
        amountInput.setText(value4);
        String value5 = savedInstanceState.getString("key5");
        numPeopleInput.setText(value5);
        String value6 = savedInstanceState.getString("key6");
        otherTip.setText(value6);
    }
}
