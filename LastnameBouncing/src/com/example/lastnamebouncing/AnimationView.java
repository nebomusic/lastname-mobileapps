package com.example.lastnamebouncing;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class AnimationView extends View {
	
	private Paint paint; // For Text
	
	// Create some Actors
	private Actor joshua;
	private Actor rebecca;
	private Actor sandy;
	private Actor tardis;
	private Actor car;
	
	// Breakout Actors
	private Actor paddle;
	private Actor ball;
	
	// Array List for Bricks
	private List <Actor> bricks;
	private List <Actor> bricks1;
	private List <Actor> bricks2;
	
	// values to hold the Accel Data
	private float ax = 0;
	private float ay = 0;
	private float az = 0;
	
	// Create the Handler for animation
	private Handler h;
	private int RATE = 30;  // about 30 Frames a Second
	
	private boolean isRunning; // whether the animation runs

	public AnimationView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		
		isRunning = true;
		
		// Breakout Actors
		ball = new Actor(context, 200, 500, Color.BLUE, 25);
		paddle = new Actor(context, 300, 300, Color.RED, 40);
		
		paddle.setWidth(150);
		paddle.setHeight(40);
		
		ball.setDX(10);
		ball.setDY(10);
		
		// Initialize the brick list
		bricks = new ArrayList <Actor> (0); // Creates a List of 6
		bricks1 = new ArrayList <Actor> (0);
		bricks2 = new ArrayList <Actor> (0);
		 
		// For Loop to initialize bricks as Actors (create 6)
		for (int i = 0; i < 6; i++) {
			bricks.add(new Actor(context, i*80, 100, Color.GREEN, 40));
			bricks1.add(new Actor(context, i*80, 175, Color.RED, 40));
			bricks2.add(new Actor(context, i*80, 250, Color.MAGENTA, 40));
		}
		
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).setWidth(75);
			bricks1.get(i).setWidth(75);
			bricks2.get(i).setWidth(75);
			
		}
		
		// Initialize the Actors
		joshua = new Actor(context, 100, 100, Color.RED, 40);
		rebecca = new Actor(context, 200, 200, Color.BLUE, 50);
		sandy = new Actor(context, 300, 200, Color.GREEN, 100);
		
		// Initialize the tardis
		tardis = new Actor(context, 300, 300, Color.BLUE, 50);
		tardis.setCostume(R.drawable.tardis);
		
		car = new Actor(context, 200, 0, Color.RED, 50);
		car.setCostume(R.drawable.tardis);
		car.setDY(5);
		
		joshua.setDX(20);
		joshua.setDY(20);
		
		rebecca.setDX(15);
		rebecca.setDY(-15);
		
		sandy.setDX(10);
		sandy.setDY(10);
		
		paint = new Paint(); // Initialize Paint
		paint.setColor(Color.RED); // Set color to RED
		paint.setTextSize(100);
		
		
		// Initialize the Handler
		h = new Handler();
		
	} // end onCreate
	
	// Create the onDraw Method - in all View Classes
	public void onDraw(Canvas c) {
		// Actors for Breakout
		
		c.drawText("Hello", 100, 100, paint); // Test Painting Text
		
		paddle.drawRect(c);
		ball.drawCircle(c);
		car.draw(c);
		
		// Adjust brick size for Screen Width
		
		// Bricks Draw Rectangles - in onDraw()
		for (int i = 0; i < bricks.size(); i++) {
			// Set Brick Width for Screen
			bricks.get(i).setWidth((c.getWidth()/6)-3);
			// Set the x position for the bricks
			int xPos = i * (c.getWidth()/6);
			// goTo and Draw the Bricks
			bricks.get(i).goTo(xPos, 100);
			bricks.get(i).drawRect(c);
			
			// Check for Collisions and Erase Bricks
			if (ball.isTouching(bricks.get(i))) {
				if (bricks.get(i).getVisable() == true) {
					ball.bounceUp();
					bricks.get(i).setVisable(false);
				} // end if
			} // end if
			
		} // end for loop for bricks
		
		// Bricks Draw Rectangles - in onDraw()
		for (int i = 0; i < bricks1.size(); i++) {
			// Set Brick Width for Screen
			bricks1.get(i).setWidth((c.getWidth()/6)-3);
			// Set the x position for the bricks
			int xPos = i * (c.getWidth()/6);
			// goTo and Draw the Bricks
			bricks1.get(i).goTo(xPos, 175);
			bricks1.get(i).drawRect(c);
			
			// Check for Collisions and Erase Bricks
			if (ball.isTouching(bricks1.get(i))) {
				if (bricks1.get(i).getVisable() == true) {
					ball.bounceUp();
					bricks1.get(i).setVisable(false);
				} // end if
			} // end if
			
		} // end for loop for bricks
		
		// Bricks Draw Rectangles - in onDraw()
		for (int i = 0; i < bricks2.size(); i++) {
			// Set Brick Width for Screen
			bricks2.get(i).setWidth((c.getWidth()/6)-3);
			// Set the x position for the bricks
			int xPos = i * (c.getWidth()/6);
			// goTo and Draw the Bricks
			bricks2.get(i).goTo(xPos, 250);
			bricks2.get(i).drawRect(c);
			
			// Check for Collisions and Erase Bricks
			if (ball.isTouching(bricks2.get(i))) {
				if (bricks2.get(i).getVisable() == true) {
					ball.bounceUp();
					bricks2.get(i).setVisable(false);
				} // end if
			} // end if
			
		} // end for loop for bricks
		
		ball.move();
		ball.bounce(c);
		if (ball.isTouching(paddle)) {
			ball.bounceUp();
		}

		if (isRunning) {
		// Call the Runnable for Animation
			h.postDelayed(r, RATE);
		}
		
		//String total = String.valueOf(paddle.getScore()) + " - " + String.valueOf(paddle2.getScore());
		//c.drawText(total, 100, 100, paint);
		
		
	} // End onDraw
	
	// Create the Runnable
	private Runnable r = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			// Call the Invalidate Method to reDraw
			invalidate();
		}
		
	};
	
	// Function to Grab touch event data
	public boolean onTouchEvent(MotionEvent event) {
		// Fetch data from touch event
		int action = event.getActionMasked(); // get type of action
		int actionIdex = event.getActionIndex(); // get index of action
		
		// set Position of paddle to touch data
		paddle.goTo((int)event.getX(), 750); 
		
		return true;
	} // end onTouchEvent

	// Modifier fields for acceleration data on x, y, and z
	public void setAX(float x) {
		ax = x;
	}
	
	public void setAY(float y) {
		ay = y;
	}
	
	public void setAZ(float z) {
		az = z;
	}
	
	private void gameLogicA(Canvas c) {
		// Actors Move
		joshua.move();
		rebecca.move();
		joshua.bounce(c);
		rebecca.bounce(c);
				
		// Bounce off the Sandy Actor
		if (joshua.isTouching(sandy)) {
					joshua.bounceOff();
		}
				
		if (joshua.isTouching(rebecca)) {
			joshua.bounceOff();
		}
				
				
		if (rebecca.isTouching(sandy)) {
			rebecca.bounceOff();
		}
				
		if (rebecca.isTouching(joshua)) {
			rebecca.bounceOff();
		}
				
		if (tardis.isTouching(sandy)) {
			tardis.bounceOff();
		}
				
		// sandy.move();
		// sandy.bounce(c);
				
		// Read Accel data and move the tardis
		tardis.changeDX(ax * -1); // read the x acceleration
		tardis.changeDY(ay);      // read the y acceleration
		tardis.move();            // Move
		tardis.bounce(c);         // Bounce
				
		// have the Actors draw themselves
		joshua.drawCircle(c);
		rebecca.drawSquare(c);
		sandy.drawSquare(c);
		tardis.draw(c);
				
		// Car as Tardis
		car.move();
		car.passThrough(c);
		if (car.isTouching(sandy)) {
			car.bounceOff();
		}
		car.draw(c);		
		
	}
	
	public void reset() {
		for (int i = 0; i < bricks.size(); i++) {
			bricks.get(i).setVisable(true);
			bricks1.get(i).setVisable(true);
			bricks2.get(i).setVisable(true);
		}
	}

} // end class AnimationView


