package com.example.lukasz.kalkulator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    EditText et1;
    EditText et2;
    TextView tv;
    Button b;
    CheckBox cb;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1 = (EditText) findViewById(R.id.editText);
        et2 = (EditText) findViewById(R.id.editText2);
        tv = (TextView) findViewById(R.id.textView);
        b = (Button) findViewById(R.id.button);
        cb = (CheckBox)findViewById(R.id.checkbox);
    }

        public void onClick(View view)
        {
         float x = 0, y = 0, sum = 0;
            x = (Float.parseFloat(et1.getText().toString()));
            y = (Float.parseFloat(et2.getText().toString()));
            sum = x + y;
            if (cb.isChecked())
            {
                tv.setText(String.valueOf(Math.round(sum)));
            }
            else
            {
                    tv.setText(String.valueOf(sum));
            }

        }

}
