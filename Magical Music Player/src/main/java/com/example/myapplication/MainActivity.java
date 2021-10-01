package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    MediaPlayer mp;
    SensorManager sm;
    Sensor s;
    Button b1;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        t1 = (TextView) findViewById(R.id.textView);
        mp = (MediaPlayer.create(this, R.raw.music));
        sm = (SensorManager) getSystemService(SENSOR_SERVICE);
        s = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener((SensorEventListener) this, s, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.values[0] == 0) {
            mp.pause();
            Toast.makeText(this, "pause", Toast.LENGTH_SHORT).show();
        } else {
            mp.start();
            Toast.makeText(this, "play", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}

