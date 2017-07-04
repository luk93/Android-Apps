package com.example.lukasz.obrazek;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity
{
    Button button;
    ImageView iv;
    int i=1;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        iv = (ImageView) findViewById(R.id.imageView);
    }
    public void onClick(View view)
    {
        if(i==1)
        {
            iv.setImageResource(R.drawable.a2);
            i = 2;
        }
        else if(i==2)
        {
            iv.setImageResource(R.drawable.a1);
            i = 3;
        }
        else if(i==3)
        {
            iv.setImageResource(R.drawable.a3);
            i = 4;
        }
        else if(i==4)
        {
            iv.setImageResource(R.drawable.a1);
            i = 1;
        }

    }
}
