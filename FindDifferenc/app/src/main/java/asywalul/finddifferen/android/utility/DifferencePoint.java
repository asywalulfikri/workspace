package asywalul.finddifferen.android.utility;

public class DifferencePoint {
	private int id;
	private int x;
	private int y;
	private int radius;
	private boolean isDetected = false;

	public int getID()
	{
		return this.id;
	}
	
	public void setID(int id)
	{
		this.id = id;
	}
	
	public int getPosX() {
		return x;
	}

	public void setPosX(String x) {
		this.x = Integer.parseInt(x);
	}
	
	public int getPosY() {
		return y;
	}

	public void setPosY(String y) {
		this.y = Integer.parseInt(y);
	}
	
	public int getRadius() {
		return radius;
	}

	public void setRadius(String radius) {
		this.radius = Integer.parseInt(radius);
	}
	
	public boolean isDetected() {
		return this.isDetected;
	}

	public void setDetected(boolean detect) {
		this.isDetected = detect;
	}
}
