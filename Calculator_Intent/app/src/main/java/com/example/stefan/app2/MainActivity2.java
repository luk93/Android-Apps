package com.example.stefan.app2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity
{
    TextView tv;


    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView) findViewById(R.id.textView3);
        Bundle wyniki = getIntent().getExtras();
        if(wyniki == null) return;
        else
        {
            float wynik = wyniki.getFloat("wynik");
            int operacja = wyniki.getInt("operacja");
            if (operacja == 1) {
                tv.setText("Suma = " + String.valueOf(wynik));
            }
            if (operacja == 2) {
                tv.setText("Roznica = " + String.valueOf(wynik));
            }
            if (operacja == 3) {
                tv.setText("Iloczyn = " + String.valueOf(wynik));
            }
            if (operacja == 4) {
                tv.setText("Iloraz = " + String.valueOf(wynik));
            }
        }

    }
}
