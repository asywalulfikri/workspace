package asywalul.finddifferen.android.utility;

import java.util.ArrayList;

import android.content.Context;
import android.content.SharedPreferences;

import asywalul.finddifferen.android.R;

public class Prefs {
    private static String MY_STAGE_PREF = "stage";
    private static String MY_POINTS_PREF = "points";
    private static String MY_HINTS_PREF = "hints";
    private static String MY_ERRORS_PREF = "errors";
    private static String MY_SOUND_PREF = "sound";
    private static String MY_RESUME_PREF = "resume";
    private static String MY_SCALEW_PREF = "scaleW";
    private static String MY_SCALEH_PREF = "scaleH";
    private static String MY_TOTALS_PREF = "totals";
    private static String MY_ISRESUME_PREF = "isresumed";
    

    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences("com.innobee.finddifferences", 0);
    }
    public static void clearPref(Context context) {
        //getPrefs(context).edit().clear().commit();
    	setPointsPref(context, null);
    	setResumePref(context, context.getResources().getInteger(R.integer.levelDuration)*1000);
    	setStagePref(context, 1);
    	setScaleWPref(context, 0);
    	setScaleHPref(context, 0);
    	setHintsPref(context,context.getResources().getInteger(R.integer.hintsAllowed));
    	setErrorsPref(context,context.getResources().getInteger(R.integer.errorsAllowed));
    	setTotalsPref(context, 0);
    	setIsResumedPref(context,false);    	
    }
    
    public static boolean isResumed(Context context) {
        return getPrefs(context).getBoolean(MY_ISRESUME_PREF, false);
    }
    
    public static int getTotalsPref(Context context) {
        return getPrefs(context).getInt(MY_TOTALS_PREF, 0);
    }
    
    public static int getStagePref(Context context) {
        return getPrefs(context).getInt(MY_STAGE_PREF, 1);
    }

    public static int getResumePref(Context context) {
        return getPrefs(context).getInt(MY_RESUME_PREF, 
        		context.getResources().getInteger(R.integer.levelDuration)*1000);
    }
    
    public static ArrayList<Integer> getPointsPref(Context context)
    {
    	ArrayList<Integer> myList  = new ArrayList<Integer>();
    	String value = getPrefs(context).getString(MY_POINTS_PREF, "");
    	for(String str : value.split(","))
    	{
    		if(!str.equalsIgnoreCase(""))
    			myList.add(Integer.valueOf(str));
    	}
    	return myList;
    }
    
    public static boolean getSoundPref(Context context) {
        return getPrefs(context).getBoolean(MY_SOUND_PREF, true);
    }
    
    public static int getErrorsPref(Context context) {
        return getPrefs(context).getInt(MY_ERRORS_PREF,
        		context.getResources().getInteger(R.integer.errorsAllowed));
    }
    
    
    public static int getHintsPref(Context context) {
        return getPrefs(context).getInt(MY_HINTS_PREF, 
        		context.getResources().getInteger(R.integer.hintsAllowed));
    }
    
    public static int getScaleWPref(Context context) {
        return getPrefs(context).getInt(MY_SCALEW_PREF,1);
    }
    
    public static int getScaleHPref(Context context) {
        return getPrefs(context).getInt(MY_SCALEH_PREF, 1);
    }

    public static void setStagePref(Context context, int value) {
        // perform validation etc..
        getPrefs(context).edit().putInt(MY_STAGE_PREF, value).commit();
    }
    
    public static void setIsResumedPref(Context context, boolean value) {
        // perform validation etc..
        getPrefs(context).edit().putBoolean(MY_ISRESUME_PREF, value).commit();
    }
    
    public static void setTotalsPref(Context context, int value) {
        // perform validation etc..
        getPrefs(context).edit().putInt(MY_TOTALS_PREF, value).commit();
    }

    public static void setResumePref(Context context, int value) {
        // perform validation etc..
        getPrefs(context).edit().putInt(MY_RESUME_PREF, value).commit();
    }
    
    public static void setPointsPref(Context context, ArrayList<Integer> points) 
    {
    	String value = "";
    	if(points != null)
    	{
	    	for(int i=0;i<points.size();i++)
	    	{
    			if(value.equalsIgnoreCase(""))
    				value = Integer.toString(points.get(i));
    			else
    				value = value + "," + Integer.toString(points.get(i));	    		
	    	}
    	}
        getPrefs(context).edit().putString(MY_POINTS_PREF, value).commit();
    }
    
    public static void setSoundPref(Context context, boolean value) {
        // perform validation etc..
        getPrefs(context).edit().putBoolean(MY_SOUND_PREF, value).commit();
    }
    
    public static  void setErrorsPref(Context context, int value) {
    	getPrefs(context).edit().putInt(MY_ERRORS_PREF,value).commit();
    }
    
    public static  void setHintsPref(Context context, int value) {
    	getPrefs(context).edit().putInt(MY_HINTS_PREF, value).commit();
    }
    
    public static  void setScaleWPref(Context context, int value) {
    	getPrefs(context).edit().putInt(MY_SCALEW_PREF, value).commit();
    }
    
    public static  void setScaleHPref(Context context, int value) {
    	getPrefs(context).edit().putInt(MY_SCALEH_PREF, value).commit();
    }
}
