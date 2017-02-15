package asywalul.finddifferen.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

import asywalul.finddifferen.android.utility.Prefs;

public class HomeActivity extends Activity{
	private int mLevelDuration;			//Max Duration of the level in seconds
	private ImageView mBtnResume;
	private Button mBtnStart;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);				
		setContentView(R.layout.activity_home);		
		mLevelDuration = getResources().getInteger(R.integer.levelDuration);		
		mLevelDuration = mLevelDuration * 1000;
		
		mBtnStart = (Button)findViewById(R.id.btnStart);
		mBtnStart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Prefs.clearPref(getApplicationContext());
				Prefs.setStagePref(getApplicationContext(), 1);
				Intent play = new Intent(HomeActivity.this,
						PlayActivity.class);						
				startActivity(play);
			}
		});
		
		mBtnResume = (ImageView)findViewById(R.id.btnResume);
		mBtnResume.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent play = new Intent(HomeActivity.this,
						PlayActivity.class);						
				startActivity(play);
			}
		});			
		
		if(Prefs.getResumePref(getApplicationContext()) == mLevelDuration) {		
			mBtnResume.setVisibility(View.INVISIBLE);			
		}
		else {
			mBtnResume.setVisibility(View.VISIBLE);
		}
	}	
	
	@Override
	protected void onRestart() {
	    super.onRestart();
		//Show/hide resume button 
	    if(Prefs.getResumePref(getApplicationContext()) == mLevelDuration) {		
			mBtnResume.setVisibility(View.INVISIBLE);
		}
		else {
			mBtnResume.setVisibility(View.VISIBLE);
		}

	}
	
}
