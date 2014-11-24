package com.example.lastnamebouncing;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class Main extends Activity {
	
	// Field for Animation View
	private AnimationView animationView;
	
	// Sensor Manager for Accelerometer
	private SensorManager sensorManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Initialize the Animation View
		animationView = (AnimationView)findViewById(R.id.animationView);
		
		// Enable the listener - We will write this later in the class
		enableAccelerometerListening();
		
	} // end onCreate
	
	protected void onResume() {
		super.onResume();
		animationView.reset();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	// Define the enableAccelerometerListening function
	private void enableAccelerometerListening() {
		// Initialize the Sensor Manager
		sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sensorManager.registerListener(sensorEventListener, 
				sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	private SensorEventListener sensorEventListener = 
			new SensorEventListener() {

				@Override
				public void onAccuracyChanged(Sensor arg0, int arg1) {
					// TODO Auto-generated method stub
					// Not USed
				}

				@Override
				public void onSensorChanged(SensorEvent event) {
					// Gather the x, y, and z values from the accellerometer
					float x = event.values[0];
					float y = event.values[1];
					float z = event.values[2];
					
					// pass the values to the AnimationView object
					animationView.setAX(x);
					animationView.setAY(y);
					animationView.setAZ(z);
					
				}
		
	}; // end SensorEventListener

}
