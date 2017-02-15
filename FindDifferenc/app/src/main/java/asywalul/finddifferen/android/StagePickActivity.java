package asywalul.finddifferen.android;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.PorterDuff.Mode;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import asywalul.finddifferen.android.db.StatusInfoDB;
import asywalul.finddifferen.android.utility.Common;
import asywalul.finddifferen.android.utility.CoverFlow;
import asywalul.finddifferen.android.utility.DifferencesInfo;
import asywalul.finddifferen.android.utility.DifferencesXMLHandler;
import asywalul.finddifferen.android.utility.Prefs;

public class StagePickActivity extends Activity {
	private ArrayList<DifferencesInfo> diffList;
	private TextView mLevel;
	private TextView mNumDiff;
	private TextView mDuration;
	private TextView mStatus;
	private TextView mErrorsMade;
	private TextView mDatePlayed;

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_stagepick);	
		
		parseXML(getResources().getString(R.string.imageLocation));
		readDBData();
		mLevel = (TextView)findViewById(R.id.txtLevel);
		mNumDiff = (TextView)findViewById(R.id.txtNumDiff);
		mDuration = (TextView)findViewById(R.id.txtDuration);
		mStatus = (TextView)findViewById(R.id.txtStatus);
		mErrorsMade = (TextView)findViewById(R.id.txtErrorsMade);
		mDatePlayed= (TextView)findViewById(R.id.txtDatePlayed);
		
		CoverFlow coverFlow =  (CoverFlow) findViewById(R.id.coverflow);
		ImageAdapter coverImageAdapter = new ImageAdapter(this);
		coverImageAdapter.createReflectedImages();

		coverFlow.setSpacing(-25);
		coverFlow.setSelection(0, true);
		coverFlow.setAnimationDuration(1000);
		
		coverFlow.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				Prefs.clearPref(getApplicationContext());
				Prefs.setStagePref(getApplicationContext(), (arg2+1));
				Intent play = new Intent(StagePickActivity.this,PlayActivity.class);							        
				startActivity(play);
				finish();
			}
		});
		
		coverFlow.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {

				mLevel.setText("Stage " + (arg2+1));
				mNumDiff.setText("Differences: " + diffList.get(arg2).getPointsCount());
				if(diffList.get(arg2).isUnlocked())
					mStatus.setText("UNLOCKED");
				else
					mStatus.setText("LOCKED");
				if(diffList.get(arg2).isCompleted())
				{
					mDuration.setText("Time record: " + diffList.get(arg2).getDuration() + " seconds ");
					mErrorsMade.setText("Errors made: " + diffList.get(arg2).getErrors());
					mDatePlayed.setText("Last played: " + diffList.get(arg2).getDatePlayed());
					mDuration.setVisibility(View.VISIBLE);
					mErrorsMade.setVisibility(View.VISIBLE);
					mDuration.setVisibility(View.VISIBLE);
				}
				else
				{
					mDuration.setVisibility(View.INVISIBLE);
					mErrorsMade.setVisibility(View.INVISIBLE);
					mDuration.setVisibility(View.INVISIBLE);
				}
					
			}

			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
				
		coverFlow.setBackgroundColor(getResources().getColor(R.color.transparent));
		coverFlow.setAdapter(coverImageAdapter);
	}

	public class ImageAdapter extends BaseAdapter {
		int mGalleryItemBackground;
		private Context mContext;		
		private ImageView[] mImages;

		public ImageAdapter(Context c) {
			mContext = c;			
			mImages = new ImageView[diffList.size()];
		}

		@SuppressWarnings("deprecation")
		public boolean createReflectedImages() {
			// The gap we want between the reflection and the original image
			final int reflectionGap = 4;
			//Common.loadImageFromAsset(this,mDiffinfo.getImageLocation1());
			
			int index = 0;
			//for (int imageId : mImageIds) {
			for (DifferencesInfo info : diffList) {
				//Bitmap originalImage = BitmapFactory.decodeResource(
				//		getResources(), imageId);				
				Bitmap originalImage = Common.loadImageFromAsset(getApplicationContext(),info.getImageLocation1());
				int width = originalImage.getWidth();
				int height = originalImage.getHeight();

				// This will not scale but will flip on the Y axis
				Matrix matrix = new Matrix();
				matrix.preScale(1, -1);

				// Create a Bitmap with the flip matrix applied to it.
				// We only want the bottom half of the image
				Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
						height / 2, width, height / 2, matrix, false);

				// Create a new bitmap with same width but taller to fit
				// reflection
				Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
						(height + height / 2), Config.ARGB_8888);

				// Create a new Canvas with the bitmap that's big enough for
				// the image plus gap plus reflection
				Canvas canvas = new Canvas(bitmapWithReflection);
				// Draw in the original image
				canvas.drawBitmap(originalImage, 0, 0, null);
				// Draw in the gap
				Paint deafaultPaint = new Paint();
				canvas.drawRect(0, height, width, height + reflectionGap,
						deafaultPaint);
				// Draw in the reflection
				canvas.drawBitmap(reflectionImage, 0, height + reflectionGap,
						null);

				// Create a shader that is a linear gradient that covers the
				// reflection
				Paint paint = new Paint();
				LinearGradient shader = new LinearGradient(0,
						originalImage.getHeight(), 0,
						bitmapWithReflection.getHeight() + reflectionGap,
						0x70ffffff, 0x00ffffff, TileMode.CLAMP);
				// Set the paint to use this shader (linear gradient)
				paint.setShader(shader);
				// Set the Transfer mode to be porter duff and destination in
				paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
				// Draw a rectangle using the paint with our linear gradient
				canvas.drawRect(0, height, width,
						bitmapWithReflection.getHeight() + reflectionGap, paint);

				ImageView imageView = new ImageView(mContext);
				imageView.setImageBitmap(bitmapWithReflection);
				android.widget.Gallery.LayoutParams imgLayout = new CoverFlow.LayoutParams(
						320, 480);
				imageView.setLayoutParams(imgLayout);
				imageView.setPadding(30, 100, 20, 20);
				mImages[index++] = imageView;

			}
			return true;
		}

		public int getCount() {
			return diffList.size();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		@SuppressWarnings("deprecation")
		public View getView(int position, View convertView, ViewGroup parent) {

			// Use this code if you want to load from resources
			ImageView i = new ImageView(mContext);
			//i.setImageResource(mImageIds[position]);
			i.setImageBitmap(Common.loadImageFromAsset(getApplicationContext(),diffList.get(position).getImageLocation1()));
			i.setLayoutParams(new CoverFlow.LayoutParams(380, 450));
			//i.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
			i.setScaleType(ImageView.ScaleType.FIT_XY);

			// Make sure we set anti-aliasing otherwise we get jaggies
			BitmapDrawable drawable = (BitmapDrawable) i.getDrawable();
			drawable.setAntiAlias(true);
			return i;

			// return mImages[position];
		}

		/**
		 * Returns the size (0.0f to 1.0f) of the views depending on the
		 * 'offset' to the center.
		 */
		public float getScale(boolean focused, int offset) {
			/* Formula: 1 / (2 ^ offset) */
			return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
		}				
	}
	
	private void readDBData()
	{
		try {

			StatusInfoDB siDB = new StatusInfoDB(getApplicationContext());
			siDB.open();
			for(int i=0; i<diffList.size();i++)
			{
				Cursor dbScoreCursor = siDB.getScore(i);
				if(dbScoreCursor!=null)
				{
					if(dbScoreCursor.getCount() > 0)
					{
						diffList.get(i).setDatePlayed(
								dbScoreCursor.getString(dbScoreCursor.getColumnIndex(StatusInfoDB.LAST_UPDATE)));
						diffList.get(i).setDuration(						
								dbScoreCursor.getInt(dbScoreCursor.getColumnIndex(StatusInfoDB.MIN_DURATION)));
						diffList.get(i).setErrors(						
								dbScoreCursor.getInt(dbScoreCursor.getColumnIndex(StatusInfoDB.NUM_ERRORS)));
						diffList.get(i).setCompleted(true);
						diffList.get(i).setUnlocked(true);
						dbScoreCursor.close();
					}
					else
					{
						diffList.get(i).setUnlocked(true);
						i = diffList.size();
					}
				}
			}			
			siDB.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void parseXML(String xmlFile) {
		AssetManager assetManager = getBaseContext().getAssets();
		try {
			InputStream is = assetManager.open(xmlFile);
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();

			DifferencesXMLHandler myXMLHandler = new DifferencesXMLHandler();
			xr.setContentHandler(myXMLHandler);
			InputSource inStream = new InputSource(is);
			xr.parse(inStream);

			diffList = myXMLHandler.getDiffList();

			is.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}