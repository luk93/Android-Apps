package com.example.stefan.aktywnosci;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private static final int REQUEST_CODE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void onClick(View view)
    {
        EditText text = (EditText) findViewById(R.id.inputforintent);
        String value = text.getText().toString();
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("klucz", value);
        startActivity(intent);
        startActivityForResult(intent, REQUEST_CODE);
    }
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE)
        {
            if (data.hasExtra("klucz zwrotny"))
            {
                String result = data.getExtras().getString("klucz zwrotny");
                if (result != null && result.length() > 0)
                {
                    Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
}