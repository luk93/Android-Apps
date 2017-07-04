package com.example.lukasz.myapplication3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity
{
    Button b;
    TextView tv;
    EditText et;
    String str;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        tv = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        str = et.getText().toString();
        tv.setText(str);

    }
    public void onClick(View view)
    {
        tv = (TextView)findViewById(R.id.textView);
        et = (EditText)findViewById(R.id.editText);
        str = et.getText().toString();
        tv.setText(str);
    }
}
