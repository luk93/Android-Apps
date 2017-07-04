package com.example.stefan.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    TextView tv1, tv2, tv3;
    EditText et1, et2;
    CheckBox cb;
    Button b;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.textView);
        tv2 = (TextView)findViewById(R.id.textView2);
        tv3 = (TextView)findViewById(R.id.textView3);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
        cb = (CheckBox)findViewById(R.id.checkBox);
        b = (Button)findViewById(R.id.button);

    }
    public void onClick(View view)
    {
        float x=0, y=0, z=0;
        try
        {
            x = Float.parseFloat(et1.getText().toString());
            y = Float.parseFloat(et2.getText().toString());
            z = x + y;
            if (cb.isChecked()) {
                tv3.setText("Suma = " + String.valueOf(Math.round(z)));
            } else {
                tv3.setText("Suma = " + String.valueOf(z));
            }
        }
        catch(NumberFormatException wyjatek)
        {
            tv3.setText("Nieprawidlowy typ danych!");
        }
    }
}
