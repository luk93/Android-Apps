package com.example.lukasz.aktywnosci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity
{
    EditText et1,et2;
    float x,y;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        et1 = (EditText)findViewById(R.id.pierwszaliczbaet2);
        et2 = (EditText)findViewById(R.id.drugaliczbaet2);

        Bundle extras = getIntent().getExtras(); //wybierasz parametru intentu i zapisujesz w bundle'u o nazwie extras(tez wlasna nazwa)
                                                //bundle sluzy do przenoszenia danych z intentu do intentu
        x = extras.getFloat("key1");  //teraz wybierasz konkretne dane z bundle o nazwie extras, czyli zmienna na ktora wskazuje wskaznik key1 (wczesniej nazwana x, teraz w sumie tez ale to nie ma znaczenia mozesz nazwac inaczej)
        y = extras.getFloat("key2");
        et1.setText(String.valueOf(x));
        et2.setText(String.valueOf(y));
    }
    public void finish() {
        Intent i2 = new Intent(); //tworzysz nowy intent
        i2.putExtra("returnkey1", String.valueOf(x)); //dodajesz te parametry do intentu, jak wczesniej
        i2.putExtra("returnkey2", String.valueOf(y));
        setResult(RESULT_OK, i2); //no i tu wazne ustawiaz parametr RESULT_OK na 1
        super.finish(); //wywolujesz funkcje finish z klasy nadrzednej (czyli mainactivity)
    }
}
