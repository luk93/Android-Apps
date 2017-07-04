package com.example.stefan.allert;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void open(View view)
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Jestes pewny decyzji?");
        alertDialogBuilder.setPositiveButton("TAK", new DialogInterface.OnClickListener()
        {
                            @Override
                            public void onClick(DialogInterface arg0,int arg1) {
                                Toast.makeText(MainActivity.this,"Wybrales przycisk TAK",Toast.LENGTH_LONG).show();
                            }
                        });
        alertDialogBuilder.setNegativeButton("NO",new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
