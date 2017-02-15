package asywalul.finddifferen.android.utility;

import java.io.IOException;
import java.io.InputStream;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import asywalul.finddifferen.android.R;


public class Common {

	
	 public static Drawable loadImageFromAsset1(Context ctx, String image) {
	    	// load image
	    	try {
		    	// get input stream
		    	InputStream ims = ctx.getAssets().open(image);
		    	// load image as Drawable
		    	return Drawable.createFromStream(ims, null);		    	
	    	}
	    	catch(IOException ex) {
	    		return ctx.getResources().getDrawable(R.drawable.ic_launcher);
	    	}
	    }
	 
	 public static Bitmap loadImageFromAsset(Context ctx, String image) {
	    	// load image
	    	try {
		    	// get input stream
		    	InputStream ims = ctx.getAssets().open(image);
		    	// load image as Drawable
		    	return BitmapFactory.decodeStream(ims); 			    
	    	}
	    	catch(IOException ex) {
	    		return BitmapFactory.decodeResource(ctx.getResources(),
                        R.drawable.ic_launcher);
	    	}
	    }
}
