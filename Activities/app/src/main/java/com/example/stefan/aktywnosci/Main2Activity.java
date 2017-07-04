package com.example.stefan.aktywnosci;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView view = (TextView) findViewById(R.id.displayintentextra);
        Bundle extras = getIntent().getExtras();
        String inputString = extras.getString("klucz");
        view.setText(inputString);
    }
    public void finish()
    {
        Intent intent = new Intent();
        EditText editText = (EditText) findViewById(R.id.returnValue);
        String string = editText.getText().toString();
        intent.putExtra("klucz zwrotny", string);
        setResult(RESULT_OK, intent);
        super.finish();
    }
}
