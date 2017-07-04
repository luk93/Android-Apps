package com.example.stefan.app2;

import android.content.Intent;
import android.support.annotation.FloatRange;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button b;
    RadioButton rb1,rb2,rb3,rb4;
    EditText et1, et2;
    int operacja=0;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.button);
        rb1 = (RadioButton)findViewById(R.id.radioButton);
        rb2 = (RadioButton)findViewById(R.id.radioButton2);
        rb3 = (RadioButton)findViewById(R.id.radioButton3);
        rb4 = (RadioButton)findViewById(R.id.radioButton4);
        et1 = (EditText)findViewById(R.id.editText);
        et2 = (EditText)findViewById(R.id.editText2);
    }
    public void onClick(View view)
    {
        float x=0,y=0,z=0;
        try
        {
            x = Float.parseFloat(et1.getText().toString());
            y = Float.parseFloat(et2.getText().toString());

            if (rb1.isChecked())
            {
                z=x+y;
                operacja = 1;
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("wynik",z);
                intent.putExtra("operacja",operacja);
                startActivity(intent);
            }
            if (rb2.isChecked())
            {
                z=x-y;
                operacja = 2;
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("wynik",z);
                intent.putExtra("operacja",operacja);
                startActivity(intent);
            }
            if (rb3.isChecked())
            {
                z=x*y;
                operacja = 3;
                Intent intent = new Intent(this, MainActivity2.class);
                intent.putExtra("wynik",z);
                intent.putExtra("operacja",operacja);
                startActivity(intent);
            }
            if (rb4.isChecked())
            {
                if (y!=0)
                {
                    z=x/y;
                    operacja = 4;
                    Intent intent = new Intent(this, MainActivity2.class);
                    intent.putExtra("wynik",z);
                    intent.putExtra("operacja",operacja);
                    startActivity(intent);
                }
                else Toast.makeText(this, "Błąd dzielenia przez 0!", Toast.LENGTH_SHORT).show();
            }


        }
        catch (NumberFormatException wyjatek)
        {
            Toast.makeText(this, "Podano zły typ danych!", Toast.LENGTH_SHORT).show();
        }
    }

}
