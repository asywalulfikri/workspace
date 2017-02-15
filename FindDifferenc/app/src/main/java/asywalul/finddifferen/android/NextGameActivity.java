package asywalul.finddifferen.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class NextGameActivity extends Activity{

	private AdView mAdView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		overridePendingTransition(R.anim.slide_in_top, R.anim.fadeout);
		setContentView(R.layout.activity_next);
		
		Button next = (Button)findViewById(R.id.btnNext);
		next.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//overridePendingTransition(R.anim.hold, R.anim.pull_out_to_left);
				finish();
			}
		});

		mAdView = (AdView)findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder()
				.build();
		mAdView.loadAd(adRequest);
		
	}	
}
