package com.example.stefan.sensory_lista;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static SensorManager sensorService;
    private MyCompassView compassView;
    private Sensor sensor;

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        compassView = new MyCompassView(this);
        setContentView(compassView);
        sensorService = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorService.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if (sensor != null)
        {
            sensorService.registerListener(mySensorEventListener, sensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
        else
        {
            Toast.makeText(this, "ORIENTATION Sensor not found",Toast.LENGTH_LONG).show();
            finish();
        }
    }
    private SensorEventListener mySensorEventListener = new SensorEventListener()
    {
                @Override
                public void onAccuracyChanged(Sensor sensor, int accuracy) { }
                @Override
                public void onSensorChanged(SensorEvent event) {
                    int azimuth = (int) event.values[0];
                    compassView.updateData(azimuth);
                }
    };
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        if (sensor != null) {
            sensorService.unregisterListener(mySensorEventListener);
        }
    }
}

