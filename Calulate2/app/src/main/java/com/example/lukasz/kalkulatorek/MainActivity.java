package com.example.lukasz.kalkulatorek;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends Activity
{
    Button b;
    TextView tv;
    EditText et1, et2;
    CheckBox cb;
    RadioButton rb1,rb2,rb3,rb4;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        tv = (TextView) findViewById(R.id.textView);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
        cb = (CheckBox)findViewById(R.id.checkBox);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        rb4 = (RadioButton)findViewById(R.id.radioButton4);

    }
    public void onClick(View view)
    {
        float x=0,y=0,z=0;
        x = Float.parseFloat(et1.getText().toString());
        y = Float.parseFloat(et2.getText().toString());

        if(rb4.isChecked())
        {
            z=x+y;
            if (cb.isChecked())
            {
                tv.setText("Suma = "+String.valueOf(Math.round(z)));
            }
            else
            {
                tv.setText("Suma = "+String.valueOf(z));
            }
        }
        if(rb3.isChecked())
        {
            z=x-y;
            if (cb.isChecked())
            {
                tv.setText("Roznica = "+String.valueOf(Math.round(z)));
            }
            else
            {
                tv.setText("Roznica = "+String.valueOf(z));
            }
        }
        if(rb2.isChecked())
        {
            if(y!=0)
            {
                z = x / y;
                if (cb.isChecked())
                {
                    tv.setText("Iloraz = " + String.valueOf(Math.round(z)));
                }
                else
                {
                    tv.setText("Iloraz = " + String.valueOf(z));
                }
            }
            else tv.setText("Błąd dzielenia przez 0!");
        }
        if(rb1.isChecked())
        {
            z=x*y;
            if (cb.isChecked())
            {
                tv.setText("Iloczyn = "+String.valueOf(Math.round(z)));
            }
            else
            {
                tv.setText("Iloczyn = "+String.valueOf(z));
            }
        }
    }
}
