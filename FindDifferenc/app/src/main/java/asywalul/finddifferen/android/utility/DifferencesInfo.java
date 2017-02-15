package asywalul.finddifferen.android.utility;

import java.util.ArrayList;

import android.util.Log;

public class DifferencesInfo {
	
	private String imageLoc1;
	private String imageLoc2;
	private ArrayList<DifferencePoint> points;
	private String datePlayed = "";
	private int duration = 0;
	private int errors = 0;
	private boolean unlocked = false;
	private boolean completed = false;
	
	/*Constructor*/
	public DifferencesInfo()
	{
		points = new ArrayList<DifferencePoint>();
	}
	
	public String getDatePlayed() {
		return datePlayed;
	}
	public void setDatePlayed(String date) {
		this.datePlayed = date;
	}
	
	public int getDuration()
	{
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public int getErrors()
	{
		return errors;
	}
	public void setErrors(int errors) {
		this.errors = errors;
	}
	
	public boolean isUnlocked()
	{
		return unlocked;
	}
	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}
	public boolean isCompleted()
	{
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public String getImageLocation1() {
		return imageLoc1;
	}

	public void setImageLocation1(String image) {
		this.imageLoc1 = image;
	}
	
	public String getImageLocation2() {
		return imageLoc2;
	}

	public void setImageLocation2(String image) {
		this.imageLoc2 = image;
	}

	public void addPoint(DifferencePoint point) {
		point.setID(points.size());
		points.add(point);
	}
	
	public DifferencePoint getPoint(int index) {
		return points.get(index);
	}
	
	public ArrayList<DifferencePoint> getPoints() {
		return points;
	}
	
	public int getPointsCount()
	{
		return points.size();
	}
	
	/**
	 * Check if the point x,y is n radius of any other point.
	 * Based on the mark value, mark it as true if found
	 * @param x
	 * @param y
	 * @param mark Mark as true if found
	 * @return
	 */
	public DifferencePoint isPointInRadius(int x, int y, boolean mark)
	{
		int square_dist = 0;
		int val1 = 0;
		int val2 = 0;
		
		for(DifferencePoint point : points)
		{
			if(!point.isDetected())
			{
				val1= (int)Math.pow(Math.abs(x-point.getPosX()),2);
				val2= (int)Math.pow(Math.abs(y-point.getPosY()),2);
				square_dist = val1+val2;
				if(square_dist < Math.pow(point.getRadius(),2))
				{
					point.setDetected(true);
					return point;
				}
			}
		}
		return null;
	}
	
	/**
	 * Get a next point that is Detected=false, and mark as needed.
	 * @param mark
	 * @return
	 */
	public DifferencePoint getNonDetectedPoint(boolean mark)
	{
		for(DifferencePoint point : points)
		{
			if(!point.isDetected())
			{
				point.setDetected(mark);
				return point;
			}
		}
		return null;
	}
}


