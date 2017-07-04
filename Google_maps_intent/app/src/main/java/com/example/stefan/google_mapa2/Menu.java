package com.example.stefan.google_mapa2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button b1, b2, b3;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }
    public void onClick1(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("miasto", 1);

    }
    public void onClick2(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("miasto", 2);
    }
    public void onClick3(View view)
    {
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("miasto", 3);
    }
}
