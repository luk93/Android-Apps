package com.example.lukasz.myapplication4;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

public class MainActivity extends Activity
{

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RadioGroup rg = (RadioGroup) findViewById(R.id.orientation);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                switch (checkedId)
                {
                    case R.id.rb1:
                        group.setOrientation(LinearLayout.HORIZONTAL);
                        break;
                    case R.id.rb2:
                        group.setOrientation(LinearLayout.VERTICAL);
                        break;
                }
            }
        });
    }

}
