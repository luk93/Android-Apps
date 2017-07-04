package com.example.lukasz.konwersja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity
{
    EditText et;
    RadioButton rb1,rb2,rb3,rb4;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        rb4 = (RadioButton)findViewById(R.id.radioButton4);
        et = (EditText)findViewById(R.id.editText);
    }
    public void onClick(View view)
    {
        double x,y;
        try
        {
            x = Double.parseDouble(et.getText().toString());
            if (rb1.isChecked())
            {
                y = 32 + (1.8*x);
                et.setText(String.valueOf(y));
            }
            if (rb2.isChecked())
            {
                y =(x-32)* 0.5556;
                et.setText(String.valueOf(y));
            }
            if (rb3.isChecked())
            {
                y = x/3.6;
                et.setText(String.valueOf(y));
            }
            if (rb4.isChecked())
            {
                y = 3.6 * x;
                et.setText(String.valueOf(y));
            }
        }
        catch (NumberFormatException wyjatek)
        {
            et.setText("Nieprawidłowe dane wejsciowe");
        }
    }


}
