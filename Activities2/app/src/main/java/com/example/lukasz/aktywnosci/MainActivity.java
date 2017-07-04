package com.example.lukasz.aktywnosci;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private static final int REQUEST_CODE = 1;
    EditText et1, et2, sumaet, roznicaet, iloczynet, ilorazet;
    Button b;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button)findViewById(R.id.button);
        et1 = (EditText)findViewById(R.id.pierwszaliczba1et);
        et2 = (EditText)findViewById(R.id.drugaliczba1et);
        sumaet = (EditText)findViewById(R.id.sumaet);
        roznicaet = (EditText)findViewById(R.id.roznicaet);
        iloczynet = (EditText)findViewById(R.id.iloczynet);
        ilorazet = (EditText)findViewById(R.id.ilorazet);

    }
    public void onClick(View view)
    {
        try  //to "pozytywna wersja" wyjatku
        {
            float x = Float.parseFloat(et1.getText().toString()); //konwersujesz stringa we float,  bo to co otrzymasz z pola edycyjnego
                                                                  //bedzie w stringu a chcemy float
            float y = Float.parseFloat(et2.getText().toString());
            Intent i1 = new Intent(this, MainActivity2.class);//tworzy Intent o wlasnej nazwie (tu i1)
            i1.putExtra("key1", x); //rozwija intent o parametr, ktorego wskaznikiem bedzie key1 (typu string) i bedzie mial wartosc x
            i1.putExtra("key2", y); // tu drugi parametr. wskaznik key2 (pamietaj, ze mozesz nazwac jak chcesz tylko musi byc string)
                                    // wartosc y
            startActivityForResult(i1, REQUEST_CODE); //wywolujesz intent w "poszukiwaniu danych", jesli tak ja wylowujesz
                                                        //to pozniej musisz ustawic parametr REQUEST_OK
        }
        catch (NumberFormatException wyjatek) //tu bedzie "negatywna wersja wyjatku - to co zrobi program jak podasz zly typ danych
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this); //builder allerta ("modul" do tworzenia allertow)
            alertDialogBuilder.setMessage("Podano zły typ danych"); //uzywajac tego modulu ustawiamy komunikat allertu
            AlertDialog alertDialog = alertDialogBuilder.create(); // tworzenie alertu za pomocą w.w. modulu
            alertDialog.show(); //wywolanie allertu
        }
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) //funkcja, ktorą wywola w tym wypadku zmiana parametru
    {                                                                             //RESULT_OK (zmienia ją funkcja finish() z mainactivity2.java)
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE)
        {
            if (data.hasExtra("returnkey1")&&data.hasExtra("returnkey2")) //waruneczek, czy masz te 2 parametry z i2 (tu nazwane zwrotnymi ale mozesz nazwac jak chcesz)
            {
                float x = Float.parseFloat(data.getExtras().getString("returnkey1")); //znowu ta konwersja
                float y = Float.parseFloat(data.getExtras().getString("returnkey2"));
                Toast.makeText(this, "WYKONANO OBLICZENIA DLA LICZB: "+String.valueOf(x)+" i "+String.valueOf(y), Toast.LENGTH_SHORT).show(); //toast wyjebuje
                //tu te obliczenia
                sumaet.setText(String.valueOf(x+y));
                roznicaet.setText(String.valueOf(x-y));
                iloczynet.setText(String.valueOf(x*y));
                if(y!=0) //warunek dzielenia przez 0
                {
                 ilorazet.setText(String.valueOf(x/y));
                }
                else ilorazet.setText("Błąd dzielenia!");

            }
        }
    }//tam nizej nieistotne jeszcze z tym kombinuje
    /*public void open(View view)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Podano zły typ danych");
        alertDialogBuilder.setPositiveButton("Podaj jeszcze raz", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface arg0, int arg1)
            {
                et1.setText("Bledny typ danych");
                et2.setText("Bledny typ danych");
            }

        });
        alertDialogBuilder.setNegativeButton("Wyjdź", new DialogInterface.OnClickListener()
        {
            public void onClick(DialogInterface dialog, int which)
            {
                finish();
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }*/

}
