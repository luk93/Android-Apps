package com.example.lukasz.funkcja;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    Button b;
    EditText eta,etb,etc;
    TextView tvx1, tvx2, tvy,tva,tvb,tvc,tvd;





    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        eta = (EditText)findViewById(R.id.edita);
        etb = (EditText)findViewById(R.id.editb);
        etc = (EditText)findViewById(R.id.editc);
        tvx1 = (TextView)findViewById(R.id.textx1);
        tvx2 = (TextView)findViewById(R.id.textx2);
        tvy = (TextView)findViewById(R.id.texty);
        tva = (TextView)findViewById(R.id.texta);
        tvb = (TextView)findViewById(R.id.textb);
        tvc = (TextView)findViewById(R.id.textc);
        tvd = (TextView)findViewById(R.id.textd);
    }
    public void onClick (View view)
    {

        double a=0,b=0,c=0,x1=0,x2=0,delta=0;
        try
        {
            a = Double.parseDouble(eta.getText().toString());
            b = Double.parseDouble(etb.getText().toString());
            c = Double.parseDouble(etc.getText().toString());
            tvy.setText("y ="+String.valueOf(a)+"x^2 +"+String.valueOf(b)+"x +"+String.valueOf(c));
            delta = (b*b)-(4*a*c);
            tvd.setText("delta: "+String.valueOf(delta));
            if (delta<0)
            {
                tvx1.setText("Funkcja ta nie ma pierwiastkow");
                tvx2.setText("");
            }
            else if(delta==0)
            {
                x1 = -b/(2*a);

                tvx1.setText("x1: "+String.valueOf(x1));
                tvx2.setText("");
            }
            else if(delta>0)
            {
                x1 = (-b - Math.sqrt(delta))/(2*a);
                x2 = (-b + Math.sqrt(delta))/(2*a);
                tvx1.setText("x1: "+String.valueOf(x1));
                tvx2.setText("x2: "+String.valueOf(x2));
            }
        }
        catch (NumberFormatException wyjatek)
        {
            tvy.setText("y = ax^2 + bx +c");
            tvd.setText("");
            tvx1.setText("BLEDNY TYP DANYCH a, b lub c");
            tvx2.setText("");
        }
    }
}
