package com.example.lastnamebouncing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;

public class Actor {
	// Fields for Actor
	private Point p; // for Location
	private int c; // for color
	private int s; // for size
	private int dx; // for change in x speed
	private int dy; // for change in y speed
	private Paint paint; // Paint object to hold painter
	
	// ints for width and height
	private int w; // width
	private int h; // height
	
	// boolean is visable to check if draw
	private boolean isVisable = true;
	
	// Context so Actor can get at graphic resources
	private Context aContext;
	
	// Integer for Drawable resource
	private int costume;
	
	// Stores Graphic for Costume
	private BitmapDrawable graphic;
	
	// Constructor
	public Actor(Context context, int x, int y, int col, int size) {
		// Initialize Values
		p = new Point(x, y); // set the x and y position
		c = col; // set the color
		s = size;  // sets the size
		w = s; // set width
		h = s; // set height
		paint = new Paint(); // creates Paint object
		paint.setColor(c); // sets Paint color
		dx = 0; // sets x speed to 0
		dy = 0; // sets y speed to 0
		
		// Set the Context
		aContext = context;
		
	} // end Constructor
	
	// Functions - What Actor can do
	
	// Accessors or 'Getters' - get values
	
	public int getX() {
		return p.x;
	} // end getX()
	
	public int getY() {
		return p.y;
	} // end getY()
	
	// Returns h and w
	public int getHeight() {
		return h;
	}
	
	public int getWidth() {
		return w;
	}
	
	public Paint getPaint() {
		return paint;
	} // end getPaint()
	
	public int getSize() {
		return s;
	} // end getSize()
	
	public boolean getVisable() {
		return isVisable;
	}
	
	// Modifiers - Change data inside Actor
	public void setColor(int col) {
		c = col;
		paint.setColor(c);
	}
	
	public void goTo(int x, int y) {
		p.x = x;
		p.y = y;
	}
	
	public void setDX(int speed) {
		dx = speed;
	}
	
	public void setDY(int speed) {
		dy = speed;
	}
	
	public void changeDX(float a) {
		dx += a;
	}
	
	public void changeDY(float a) {
		dy += a;
	}
	
	// Modifiers for Width and Height
	public void setWidth(int width){
		w = width;
	}
	
	public void setHeight(int height) {
		h = height;
	}
	
	public void setVisable(boolean v) {
		isVisable = v;
	}
	
	public void move() {
		p.x += dx;
		p.y += dy;
	}
	
	public void bounce(Canvas c) {
		if (p.x > c.getWidth() || p.x < 0) {
			dx = dx * -1;
		}
		if (p.y > c.getHeight() || p.y < 0) {
			dy = dy * -1;
		}
	}
	
	// Bounce Off Function
	public void bounceOff() {
		dx = dx * -1;
		dy = dy * -1;
	}
	
	// Bounce Up Function
	public void bounceUp() {
		dy = dy * -1;
	}
	
	public void bounceActor(Actor a) {
		// Leave empty for now
	}
	
	// Function to return true or false if touching another Actor
	public boolean isTouching(Actor a) {
		boolean result = false;
		
		if ((p.x + w > a.getX() && p.x < a.getX() + a.getWidth()) &&
		    (p.y + h > a.getY() && p.y+h < a.getY() + a.getHeight())) {
			result = true;
		}
		
		return result;
	}
	
	public void drawCircle(Canvas c) {
		c.drawCircle(p.x, p.y, s, paint);
	}
	
	public void drawSquare(Canvas c) {
		c.drawRect(p.x, p.y, p.x + s, p.y+s, paint);
	}
	
	// Function to draw a Rectangle
	public void drawRect(Canvas c) {
		if (isVisable) {
			c.drawRect(p.x, p.y, p.x+w, p.y+h, paint);
		}
	}
	
	// Setters and Getters for Graphics
	
	public void setCostume(int cost) {
		costume = cost;
		graphic = (BitmapDrawable)aContext.getResources().getDrawable(costume);
		// Set width and height based on graphic
		w = graphic.getBitmap().getWidth();
		h = graphic.getBitmap().getHeight();
	}
	
	public Bitmap getBitmap() {
		return graphic.getBitmap();
	}
	
	public void draw(Canvas c) {
		if (isVisable) {
			c.drawBitmap(getBitmap(), p.x, p.y, paint);
		}
	}
	
	public void passThrough(Canvas c) {
		// X Portion
		if (p.x > c.getWidth()){
			p.x = 0;
		}
		if (p.x < 0) {
			p.x = c.getWidth();
		}
		// Y Portion
		if (p.y > c.getHeight()) {
			p.y = 0;
		}
		if (p.y < 0) {
			p.y = c.getHeight();
		}
	} // end passThrough
	
} // end class Actor



