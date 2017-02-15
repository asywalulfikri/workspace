package asywalul.finddifferen.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import java.io.InputStream;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import asywalul.finddifferen.android.db.DBHelper;
import asywalul.finddifferen.android.db.StatusInfoDB;
import asywalul.finddifferen.android.utility.Common;
import asywalul.finddifferen.android.utility.DifferencePoint;
import asywalul.finddifferen.android.utility.DifferencesInfo;
import asywalul.finddifferen.android.utility.DifferencesXMLHandler;
import asywalul.finddifferen.android.utility.Prefs;
import asywalul.finddifferen.android.utility.SaundProgressBar;

public class PlayActivity extends Activity{
	
	private String mSourceXML;		// Image Location source
	private ArrayList<DifferencesInfo> mDiffList;	//List of all differences
	private int mCurStage = 1;		//Current stage played
	private int mNumOfDifferencs = 0;	//Number of differences for stage
	private ArrayList<Integer> mHitPoints;		//Number of differences detected
	private int mNumOfErrors = 0;		//Number of Errors left per stage
	private int mNumOfHints = 0;		//Total number of hints for all stages 
	private int mTotalScore = 0;		//Total score for all stages
	private DifferencesInfo mDiffinfo;	//Difference info container class
	private DifferencePoint mDiffPoint;	//Difference point container class
	private int mLevelDuration;			//Max Duration of the level in seconds 
	private int mResumeAt;				//Start time at position
	private boolean mPlaySound;			//Play sound
	private int scaledHeight, scaledWidth;	// Image dimensions after draw
	private CountDownTimer mGameTimer;	//Game Countdown timer
	private int mHitHeight;
	private int mHitWidth;
	private float ROTATE_FROM;			//Rotate error image from
	private float ROTATE_TO;			//Rotate error image to * number of times
	private int mScoreIncrement;
	private  AdView adView;
	//Flags
	private boolean mPauseFlag;	
	
	//Animation
	private Animation mAnimateHit;
	private RotateAnimation mAnimateError;
	
	//Resources
	private RelativeLayout rlImage1;		//Top image layout
	private RelativeLayout rlImage2;		//Bottom image layout
	private SaundProgressBar mProgressBar;	//Timer Progress bar
	private TouchImage mImageV1;			//Top image
	private TouchImage mImageV2;			//Bottom image
	private Bitmap mImageB1;				//Top image as bitmap
	private Bitmap mImageB2;				//Bottom image as bitmap
	private ImageView mErrorV1;				//Top image error view
	private ImageView mErrorV2;				//Bottom image error view
	private LayoutParams mErrorLParams;
	private ImageView mBtnSound;
	private ImageView mBtnHint;	
	private TextView mTxtHintCount;
	private TextView mTxtScoreCount;
	private TextView mTxtHitCount;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_play);
		LoadConfigParams();
		LoadSharedPreferences();
		LoadResources();
		LoadListeners();
		LoadStage(mCurStage);
		LoadAds();


	}
	@Override
	public void onPause()
	{
		super.onPause();
		mGameTimer.cancel();
		SaveSharedPreferences();
		if(!mPauseFlag)
		{
			mPauseFlag = !mPauseFlag;
			finish();
		}

	}

	@Override
	protected void onRestart() {
		super.onRestart();
		LoadConfigParams();
		LoadSharedPreferences();
		LoadResources();
		LoadListeners();
		LoadStage(mCurStage);
	}



	protected void onActivityResult(int requestCode, int resultCode,
									Intent data) {
		if (requestCode == 0) {
			LoadStage(mCurStage);
			mPauseFlag = false;
		}
	}

	/**
	 * Load the images to stage.
	 * Also handles start new or resume activity
	 *
	 * @param stage
	 */
	private void LoadStage(int stage)
	{
		//Reset the image layouts. remove all hits
		if(mResumeAt == mLevelDuration)
		{
			rlImage1.removeViewsInLayout(rlImage1.getChildCount()-mHitPoints.size(), mHitPoints.size());
			rlImage2.removeViewsInLayout(rlImage2.getChildCount()-mHitPoints.size(), mHitPoints.size());
		}

		//Set the current different information
		mDiffinfo = mDiffList.get(stage - 1);
		mNumOfDifferencs = mDiffinfo.getPointsCount();

		// Load the Bitmap from Assets
		mImageB1 = Common.loadImageFromAsset(this,mDiffinfo.getImageLocation1());
		mImageB2 = Common.loadImageFromAsset(this,mDiffinfo.getImageLocation2());

		// Set the bitmap to the ImageViews
		setImageViewBitmap(mImageV1, mImageB1);
		setImageViewBitmap(mImageV2, mImageB2);

		//Show hits if Resume from Pause
		if(mResumeAt != mLevelDuration)
		{
			for(int i=0; i<mHitPoints.size();i++)
			{
				mDiffPoint = mDiffinfo.getPoint(mHitPoints.get(i));
				mDiffinfo.getPoint(mHitPoints.get(i)).setDetected(true);
				AnimateHit(mDiffPoint,false);
				//AnimateHit(rlImage1,mImageB1,mDiffPoint.getPosX(),mDiffPoint.getPosY(),false);
				//AnimateHit(rlImage2,mImageB2,mDiffPoint.getPosX(),mDiffPoint.getPosY(),false);
			}
		}

		//Set the values on screen
		SetGameStatusOnScreen();

		//Initialize and start game countdown
		InitializeGameTimer(mResumeAt, 100);
		mGameTimer.start();
	}

	/**
	 * Set the values in the status bar
	 */
	private void SetGameStatusOnScreen()
	{
		mTxtHintCount.setText(Integer.toString(mNumOfHints));
		mTxtScoreCount.setText(getResources().getString(R.string.score)
				+ " : " + Integer.toString(mTotalScore));
		mTxtHitCount.setText(getResources().getString(R.string.found)
				+ " : " + Integer.toString(mHitPoints.size())
				+ "/" + Integer.toString(mNumOfDifferencs));
		if(mPlaySound)
			mBtnSound.setImageResource(R.drawable.ic_volume_up_black_24dp);
		else
			mBtnSound.setImageResource(R.drawable.ic_volume_off_black_24dp);
	}

	/**
	 * Load all the resources
	 */
	private void LoadAds()
	{
		LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayoutAdmob);

		// Create the adView
		adView = new AdView(this);
		adView.setAdSize(AdSize.SMART_BANNER);
		adView.setAdUnitId("ca-app-pub-4914903732265878/6677060942");
		// Add the adView to it
		layout.addView(adView);

		// Initiate a generic request to load it with an ad

		AdRequest adRequest = new AdRequest.Builder()
				.addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
				.addTestDevice("0C179D00E6B9B79C492DCCA6A64B1FA9") //gotten from running as Debug and reading logcat
				.build();

		// Start loading the ad in the background.
		adView.loadAd(adRequest);
	}


	/**
	 * Load all the resources
	 */
	private void LoadResources()
	{
		parseXML(getResources().getString(R.string.imageLocation));
		readDBData();
		//Set the timer in seconds
		mProgressBar = (SaundProgressBar) findViewById(R.id.progressBar);
		mProgressBar.setMax(mLevelDuration);

		//Layouts
		rlImage1 = (RelativeLayout)findViewById(R.id.rlayout1);
		rlImage2 = (RelativeLayout)findViewById(R.id.rlayout2);

		//Status bar buttons
		mBtnSound = (ImageView)findViewById(R.id.imgSound);
		mTxtHintCount = (TextView)findViewById(R.id.hintCount);
		mBtnHint = (ImageView)findViewById(R.id.imgHint);
		mTxtScoreCount = (TextView)findViewById(R.id.scoreCount);
		mTxtHitCount = (TextView)findViewById(R.id.hitCount);

		//Game params
		mErrorV1 = (ImageView) findViewById(R.id.errorimage1);
		mErrorV2 = (ImageView) findViewById(R.id.errorimage2);
		mErrorLParams = (LayoutParams) mErrorV1.getLayoutParams();
		mImageV1 = (TouchImage) findViewById(R.id.gameimage1);
		mImageV2 = (TouchImage) findViewById(R.id.gameimage2);
	}

	/**
	 * Load all the animations, and listeners
	 */
	private void LoadListeners()
	{
		mAnimateError = new RotateAnimation(ROTATE_FROM, ROTATE_TO,
				Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
				0.5f);
		mAnimateError.setDuration(getResources().getInteger(R.integer.errorDuration));
		mAnimateError.setRepeatCount(0);
		mAnimateError.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {

				if(mPlaySound)
				{
					MediaPlayer mp = MediaPlayer.create(PlayActivity.this, R.raw.error);
					mp.setOnCompletionListener(new OnCompletionListener() {

						@Override
						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							mp.release();
						}

					});
					mp.start();
				}
				mErrorV1.setVisibility(View.VISIBLE);
				mErrorV2.setVisibility(View.VISIBLE);
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				mErrorV1.setVisibility(View.INVISIBLE);
				mErrorV2.setVisibility(View.INVISIBLE);

				//No more errors, game over
				if(mNumOfErrors<1)
				{

					Prefs.clearPref(getApplicationContext());
					Prefs.setStagePref(getApplicationContext(), mCurStage);
					LoadSharedPreferences();
					mGameTimer.cancel();

					Intent lostGame = new Intent(PlayActivity.this,
							LostActivity.class);
					startActivity(lostGame);
					finish();

				}
			}
		});
		//This animation is called for the last hit
		mAnimateHit = AnimationUtils.loadAnimation(this, R.anim.scale_down);
		mAnimateHit.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
				// TODO Auto-generated method stub
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				//Check if all hints have been found
				if(mHitPoints.size() >= mNumOfDifferencs)
				{
					int duration = (int)((mLevelDuration-mResumeAt)/1000);
					if(!mDiffList.get(mCurStage-1).isCompleted() ||
							mDiffList.get(mCurStage-1).getDuration() >= duration)
					{
						SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
						mDiffList.get(mCurStage-1).setCompleted(true);
						mDiffList.get(mCurStage-1).setDatePlayed(sdf.format(new Date()));
						mDiffList.get(mCurStage-1).setDuration(duration);
						mDiffList.get(mCurStage-1).setErrors(getResources().getInteger(R.integer.errorsAllowed)-mNumOfErrors);

						//DBHelper.setScore(getApplicationContext(), m, updateDate, duration, errors);
						DBHelper.setScore(getApplicationContext(), mCurStage-1,
								mDiffList.get(mCurStage-1).getDatePlayed(),
								mDiffList.get(mCurStage-1).getDuration(),
								mDiffList.get(mCurStage-1).getErrors());
					}

					rlImage1.removeViewsInLayout(rlImage1.getChildCount()-mHitPoints.size(), mHitPoints.size());
					rlImage2.removeViewsInLayout(rlImage2.getChildCount()-mHitPoints.size(), mHitPoints.size());
					mGameTimer.cancel();	//Stop the timer
					mHitPoints.clear();		//Clear the points

					//Check if its the last Image = Game over
					mCurStage++;
					if(mCurStage > mDiffList.size())
					{
//						Intent summary = new Intent(PlayActivity.this,
//								SummaryActivity.class);

//						startActivity(summary);
//						finish();

						int nHighScore = getSharedPreferences("FIND_DIFF", Context.MODE_PRIVATE).getInt("HIGHSCORE", 0);
						String title = getString(R.string.success_title);
						Object[] args = { mTotalScore, nHighScore };
						String message = MessageFormat.format(getString(R.string.success), args );
						int icon = R.drawable.win;
						if (mTotalScore > nHighScore)
						{
							title = getString(R.string.hiscore_title);
							message = MessageFormat.format(getString(R.string.hiscore), args );
							icon = R.drawable.hiscore;

							SharedPreferences.Editor editor = getSharedPreferences("FIND_DIFF", Context.MODE_PRIVATE).edit();
							editor.putInt("HIGHSCORE", mTotalScore);
							editor.commit();
						}

						AlertDialog.Builder altDialog= new AlertDialog.Builder(PlayActivity.this);
						altDialog.setMessage(message); // here add your message
						altDialog.setTitle(title);
						altDialog.setIcon(icon);
						altDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog, int which) {
								Intent intent = new Intent(PlayActivity.this,
										HomeActivity.class);

								startActivity(intent);
								finish();
							}
						});
						altDialog.show();

						Prefs.clearPref(getApplicationContext());
						LoadSharedPreferences();
					}
					else
					{
						Intent NextGame = new Intent(PlayActivity.this,
								NextGameActivity.class);
						Prefs.clearPref(getApplicationContext());
						Prefs.setStagePref(getApplicationContext(), mCurStage);
						Prefs.setHintsPref(getApplicationContext(), mNumOfHints);
						Prefs.setTotalsPref(getApplicationContext(), mTotalScore);
						LoadSharedPreferences();
						mPauseFlag = true;
						startActivityForResult(NextGame,0);
					}
				}
			}
		});

		mImageV1.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						mDiffPoint = CheckForDetection(mImageB1, mImageB2,
								(int) event.getX(), (int) event.getY());
						if (mDiffPoint != null) {
							mHitPoints.add(mDiffPoint.getID());
							mTotalScore = mTotalScore + mScoreIncrement;
							AnimateHit(mDiffPoint,true);
						} else {
							mNumOfErrors--;
							AnimateError((int) event.getX(),(int) event.getY());
						}
						v.onTouchEvent(event);
				}
				return true;
			}
		});

		mImageV2.setOnTouchListener(new OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				switch (event.getAction()) {
					case MotionEvent.ACTION_DOWN:
						mDiffPoint = CheckForDetection(mImageB1, mImageB2,
								(int) event.getX(), (int) event.getY());
						if (mDiffPoint != null) {
							mHitPoints.add(mDiffPoint.getID());
							mTotalScore = mTotalScore + mScoreIncrement;
							AnimateHit(mDiffPoint,true);
						} else {
							mNumOfErrors--;
							AnimateError((int) event.getX(),(int) event.getY());
						}
						v.onTouchEvent(event);
				}
				return true;
			}
		});

		mBtnSound.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mPlaySound = !mPlaySound;
				if(mPlaySound)
					mBtnSound.setImageResource(R.drawable.sound);
				else
					mBtnSound.setImageResource(R.drawable.sound_mute);
				Prefs.setSoundPref(getApplicationContext(), mPlaySound);
			}
		});

		mBtnHint.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mNumOfHints > 0)
				{
					try
					{
						mNumOfHints--;
						mDiffPoint = mDiffinfo.getNonDetectedPoint(true);
						mHitPoints.add(mDiffPoint.getID());

						//Save shared preferences since change happened
						SaveSharedPreferences();

						//Animate the hit
						AnimateHit(mDiffPoint,true);

						//Set the values on screen
						SetGameStatusOnScreen();
					}catch(Exception ex)
					{

					}
				}
			}
		});
	}

	/**
	 * Load Configuration values
	 */
	private void LoadConfigParams()
	{
		mPauseFlag = false;
		ROTATE_FROM = 0.0f;
		ROTATE_TO = getResources().getInteger(R.integer.errorNumRotations) * 360.0f;
		mSourceXML = getResources().getString(R.string.imageLocation);
		mScoreIncrement = getResources().getInteger(R.integer.scoreIncrement);
		mLevelDuration = getResources().getInteger(R.integer.levelDuration);
		mLevelDuration = mLevelDuration * 1000;
		mHitHeight = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, getResources().getInteger(R.integer.hitCircle), getResources().getDisplayMetrics());
		mHitWidth = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, getResources().getInteger(R.integer.hitCircle), getResources().getDisplayMetrics());
		mNumOfErrors = getResources().getInteger(R.integer.errorsAllowed);
	}

	/**
	 * Load saved values from preferences
	 */
	private void LoadSharedPreferences()
	{
		mResumeAt = Prefs.getResumePref(getApplicationContext());
		mCurStage = Prefs.getStagePref(getApplicationContext());
		mHitPoints = Prefs.getPointsPref(getApplicationContext());
		mPlaySound = Prefs.getSoundPref(getApplicationContext());
		mNumOfErrors = Prefs.getErrorsPref(getApplicationContext());
		mNumOfHints = Prefs.getHintsPref(getApplicationContext());
		scaledHeight = Prefs.getScaleHPref(getApplicationContext());
		scaledWidth = Prefs.getScaleWPref(getApplicationContext());
		mTotalScore = Prefs.getTotalsPref(getApplicationContext());
	}

	/**
	 * Save Shared preferences
	 */
	private void SaveSharedPreferences()
	{
		Prefs.setResumePref(getApplicationContext(), mResumeAt);
		Prefs.setStagePref(getApplicationContext(), mCurStage);
		Prefs.setSoundPref(getApplicationContext(), mPlaySound);
		Prefs.setPointsPref(getApplicationContext(), mHitPoints);
		Prefs.setErrorsPref(getApplicationContext(), mNumOfErrors);
		Prefs.setHintsPref(getApplicationContext(), mNumOfHints);
		Prefs.setScaleHPref(getApplicationContext(), scaledHeight);
		Prefs.setScaleWPref(getApplicationContext(), scaledWidth);
		Prefs.setTotalsPref(getApplicationContext(), mTotalScore);
	}

	/**
	 * Check if there is some difference detected
	 *
	 * @param b1
	 * @param b2
	 * @param x
	 * @param y
	 * @return true if point is in radius, or false if otherwise
	 */
	private DifferencePoint CheckForDetection(Bitmap b1, Bitmap b2, int x, int y) {
		float scaleX = (float) b1.getWidth() / (float) scaledWidth;
		float scaleY = (float) b1.getHeight() / (float) scaledHeight;
		x = (int) (x * scaleX);
		y = (int) (y * scaleY);
		return mDiffinfo.isPointInRadius(x, y, true);
	}

	/**
	 * Main function for Animate, that also handles game rules
	 *
	 * @param point
	 * @param animate
	 */
	private void AnimateHit(DifferencePoint point, boolean animate)
	{
		if(mPlaySound)
		{
			MediaPlayer mp = MediaPlayer.create(PlayActivity.this, R.raw.hit);
			mp.setOnCompletionListener(new OnCompletionListener() {

				@Override
				public void onCompletion(MediaPlayer mp) {
					// TODO Auto-generated method stub
					mp.release();
				}

			});
			mp.start();
		}

		//Set the values on screen
		SetGameStatusOnScreen();
		//Animate Hit
		AnimateHit(rlImage1,mImageB1,point.getPosX(),point.getPosY(),animate);
		AnimateHit(rlImage2,mImageB2,point.getPosX(),point.getPosY(),animate);
	}



	/**
	 * Animate image hit on top and bottom image at specific location
	 * @param rl
	 * @param bmp
	 * @param x
	 * @param y
	 * @param animate
	 */
	private void AnimateHit(RelativeLayout rl, Bitmap bmp, int x, int y, boolean animate)
	{
		float scaleX = (float) scaledWidth/(float) bmp.getWidth();
		float scaleY = (float) scaledHeight/(float) bmp.getHeight();
		x = (int) (x * scaleX);
		y = (int) (y * scaleY);

		ImageView imageView = new ImageView(this);
		imageView.setImageResource(R.drawable.hit);
		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
		//params.setMargins(left, top, right, bottom)
		params.setMargins(x - (mHitWidth / 2),
				y - (mHitHeight / 2),
				(int)(scaleX*bmp.getWidth()) - (x+(mHitWidth / 2)),
				(int)(scaleY*bmp.getHeight()) - (y+(mHitHeight / 2)));
		imageView.setLayoutParams(params);

		if(animate)
		{
			if(mHitPoints.size() >= mNumOfDifferencs)
				imageView.startAnimation(mAnimateHit);
			else
				imageView.startAnimation(AnimationUtils.loadAnimation(this, R.anim.scale_down));
		}
		rl.addView(imageView);
	}

	/**
	 * Display the animation error, in case missed.
	 *
	 * @param x
	 * @param y
	 */
	private void AnimateError(int x, int y)
	{
		mErrorLParams.leftMargin = x - (mErrorV1.getWidth() / 2);
		mErrorLParams.topMargin = y - (mErrorV1.getHeight() / 2);
		mErrorV1.setLayoutParams(mErrorLParams);
		mErrorV1.startAnimation(mAnimateError);
		mErrorV2.setLayoutParams(mErrorLParams);
		mErrorV2.startAnimation(mAnimateError);
	}

	/**
	 *  Initialize the Rest Timer
	 */
	private void InitializeGameTimer(long millisInFuture, long countDownInterval) {
		// ...Initialize the countdowntimer
		mGameTimer = new CountDownTimer(millisInFuture, countDownInterval) {

			@Override
			public void onTick(long millisUntilFinished) {
				// ...Timers and progress bar
				mProgressBar.setProgress((int)millisUntilFinished);
				mResumeAt = (int)millisUntilFinished;
			}

			@Override
			public void onFinish() {
				if(!mPauseFlag)
				{
					Prefs.clearPref(getApplicationContext());
					Prefs.setStagePref(getApplicationContext(), mCurStage);
					LoadSharedPreferences();
					/*AlertDialog.Builder altDialog= new AlertDialog.Builder(PlayActivity.this);
					altDialog.setMessage(R.string.youlose); // here add your message
					altDialog.setNeutralButton("OK", new DialogInterface.OnClickListener() {
					   
					   @Override
					   public void onClick(DialogInterface dialog, int which) {
						   Intent intent = new Intent(PlayActivity.this,
								   HomeActivity.class);
									
							 startActivity(intent);
							 finish();
					   }
					  });
					altDialog.show();*/
					Intent lostGame = new Intent(PlayActivity.this,
							LostActivity.class);
					startActivity(lostGame);
					finish();
				}
			}
		};
	}

	/**
	 * Set the Bitmap to the to the Image view
	 * @param touchView
	 * @param bmp
	 */
	private void setImageViewBitmap(final TouchImage touchView, Bitmap bmp) {
		touchView.setImageBitmap(bmp);
		touchView.getViewTreeObserver().addOnPreDrawListener(
				new ViewTreeObserver.OnPreDrawListener() {
					@Override
					public boolean onPreDraw() {
						Rect rect = touchView.getDrawable().getBounds();
						scaledHeight = rect.height();
						scaledWidth = rect.width();
						touchView.getViewTreeObserver()
								.removeOnPreDrawListener(this);
						return true;
					}
				});
	}

	private void readDBData()
	{
		try {

			StatusInfoDB siDB = new StatusInfoDB(getApplicationContext());
			siDB.open();
			for(int i=0; i<mDiffList.size();i++)
			{
				Cursor dbScoreCursor = siDB.getScore(i);
				if(dbScoreCursor!=null)
				{
					if(dbScoreCursor.getCount() > 0)
					{
						mDiffList.get(i).setDatePlayed(
								dbScoreCursor.getString(dbScoreCursor.getColumnIndex(StatusInfoDB.LAST_UPDATE)));
						mDiffList.get(i).setDuration(
								dbScoreCursor.getInt(dbScoreCursor.getColumnIndex(StatusInfoDB.MIN_DURATION)));
						mDiffList.get(i).setErrors(
								dbScoreCursor.getInt(dbScoreCursor.getColumnIndex(StatusInfoDB.NUM_ERRORS)));
						mDiffList.get(i).setCompleted(true);
						mDiffList.get(i).setUnlocked(true);
						dbScoreCursor.close();
					}
					else
					{
						mDiffList.get(i).setUnlocked(true);
						i = mDiffList.size();
					}
				}
			}
			siDB.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Parse the xml with image information
	 * @param xmlFile
	 */
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

			mDiffList = myXMLHandler.getDiffList();

			is.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
	}
}
