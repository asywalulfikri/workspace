package asywalul.finddifferen.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SummaryActivity extends Activity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_summary);
		
		Button finish = (Button)findViewById(R.id.btnFinish);
		finish.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//overridePendingTransition(R.anim.hold, R.anim.pull_out_to_left);
				finish();
			}
		});
	}
}
