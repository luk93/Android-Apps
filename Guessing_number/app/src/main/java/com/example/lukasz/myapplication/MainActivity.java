package com.example.lukasz.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.SharedElementCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity
{
    int liczba, liczba1,proba = 0;
    TextView textView;
    TextView textView4;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView);
        textView4 = (TextView)findViewById(R.id.textView4);
        sharedPreferences = getSharedPreferences("com.example.lukasz.myapplication", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void newGame(View view)
    {
        Random rand = new Random();
        liczba = rand.nextInt((100-0)+1)+0;
        proba = 0;
        textView.setText("Ilosc prob: " +proba);
    }

    public void takeTheGuess(View view) {
        proba++;
        EditText editText = (EditText)findViewById(R.id.editText);
        liczba1 = Integer.parseInt(editText.getText().toString());
        String wiadomosc="";
        if(liczba1>liczba)
        {
            wiadomosc = "za duza liczba";
        }
        else if(liczba1<liczba)
        {
            wiadomosc = "za mala liczba";
        }
        else if(liczba1==liczba)
        {
            wiadomosc = "trafiles!";
            if(proba < sharedPreferences.getInt("Rekord: ", 100))
            {
                editor.putInt("Rekord: ", proba);
                editor.commit();
            }
        }
        int duration = Toast.LENGTH_SHORT;
        Context context = getApplicationContext();
        Toast toast = Toast.makeText(context, wiadomosc, duration);
        toast.show();
        textView.setText("Ilosc prob: " +proba);
        textView4.setText("Rekord: " + sharedPreferences.getInt("Rekord: ",100));

    }
}
