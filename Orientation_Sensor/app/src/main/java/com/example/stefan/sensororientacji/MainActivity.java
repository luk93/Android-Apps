    package com.example.stefan.sensororientacji;

    import android.app.Activity;
    import android.hardware.Sensor;
    import android.hardware.SensorEvent;
    import android.hardware.SensorEventListener;
    import android.hardware.SensorManager;
    import android.os.Bundle;
    import android.widget.TextView;

    public class MainActivity extends Activity implements SensorEventListener {
        TextView tv1, tv2, tv3, tv4;

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            tv1 = (TextView) findViewById(R.id.textView);
            tv2 = (TextView) findViewById(R.id.textView2);
            tv3 = (TextView) findViewById(R.id.textView3);
            tv4 = (TextView) findViewById(R.id.textView4);
            SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);
            sm.registerListener(this,sm.getDefaultSensor(Sensor.TYPE_ORIENTATION), 0, null);
        }

        public void onAccuracyChanged(Sensor sensor, int accuracy) {
// TODO Auto-generated method stub
        }
        public void onSensorChanged(SensorEvent event) {
            tv1.setText("event.values[0] = " + event.values[0] + "\n" +
                    "event.values[1] = " + event.values[1] + "\n" +
                    "event.values[2] = " + event.values[2] + "\n");
            String direction = "";
            if(event.values[0] == 0) {
                direction = "North";
            } else if ((event.values[0] > 0) && (event.values[0] < 90)) {
                direction = "northeast";
            } else if (event.values[0] == 90) {
                direction = "east";
            } else if ((event.values[0] > 90) && (event.values[0] < 180)) {
                direction = "southeast";
            } else if (event.values[0] == 180) {
                direction = "south";
            } else if ((event.values[0] > 180) && (event.values[0] < 270)) {
                direction = "soutwest";
            } else if (event.values[0] == 270) {
                direction = "west";
            } else if ((event.values[0] >270) && (event.values[0] < 360)) {
                direction = "northwest";
            }
            tv2.setText("You go " + direction);
            String verticalDeviation = "";
            if(event.values[1] == 0) {
                verticalDeviation = "horizontal position";
            } else if (event.values[1] > 0) {
                verticalDeviation = "downward direction";
            } else {
                verticalDeviation = "upward direction";
            }
            tv3.setText("Vertical plane: " + verticalDeviation);
            String rotation = "";
            if(event.values[2] == 0) {
                rotation = "horizontal position";
            } else if (event.values[2] > 0) {
                rotation = "left rotation";
            } else {
                rotation = "right rotation";
            }
            tv4.setText("Rotation: " + rotation);
        }
    }
