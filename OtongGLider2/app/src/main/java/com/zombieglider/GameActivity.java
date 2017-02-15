package com.zombieglider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.cocos2d.nodes.CCDirector;
import org.cocos2d.opengl.CCGLSurfaceView;
import org.cocos2d.opengl.CCTexture2D;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.graphics.Bitmap.Config;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.Toast;

import asywalul.otongglider.android.R;

public class GameActivity extends Activity{

	private CCGLSurfaceView mGLSurfaceView;
	public static GameActivity app;
	 
	//<!-- Admob Ads Using Google Play Services SDK -->
		private static final String AD_UNIT_ID ="ca-app-pub-4914903732265878/2963701740";
		private static final String AD_INTERSTITIAL_UNIT_ID ="ca-app-pub-4914903732265878/5552508549";
		

		/** The Admob ad. */
		private InterstitialAd interstitialAd = null;
		public AdView adView = null;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	
		app = this;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		mGLSurfaceView = new CCGLSurfaceView(this);
		
		//Ads ----------------
				// Create the adView
		 		RelativeLayout layout = new RelativeLayout(this);
		 		layout.setLayoutParams(new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));

		 		//<!-- Ads Using Google Play Services SDK -->
		 		adView = new AdView(this);
		 	    adView.setAdSize(AdSize.SMART_BANNER);
		 	    adView.setAdUnitId(AD_UNIT_ID);
		 	    
		 		// Add the adView to it
		 		RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
		 				LayoutParams.WRAP_CONTENT,
		 				LayoutParams.WRAP_CONTENT);
		 		params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
		 		params.addRule(RelativeLayout.CENTER_HORIZONTAL, RelativeLayout.TRUE);
		 		
		 		adView.setLayoutParams(params);
		 		
		 		layout.addView(mGLSurfaceView);
		 		layout.addView(adView);
		 		
		 		setContentView(layout);
		 		//New AdRequest 
		 		AdRequest adRequest = new AdRequest.Builder().build();
		 		adView.loadAd(adRequest);
		 		//-----------------------------------------------------Interstitial Add
		 		// Create an Interstitial ad.
		 	    interstitialAd = new InterstitialAd(this);
		 	    interstitialAd.setAdUnitId(AD_INTERSTITIAL_UNIT_ID);
		 		interstitialAd.setAdListener(new AdListener() {
		 		      @Override
		 		      public void onAdLoaded() {
		 		  	    interstitialAd.show();
		 		      }

		 		      @Override
		 		      public void onAdFailedToLoad(int errorCode) {
		 		    	  Toast.makeText(getApplicationContext(), "Interstitial Ads loading failed", Toast.LENGTH_SHORT).show();
		 		      }
		 		});
		 		 // Load the interstitial ad.
		 	    //showInterstitialAds();

		 		//----------------------
        
        // attach the OpenGL view to a window
        CCDirector.sharedDirector().attachInView(mGLSurfaceView);
        
        CCDirector.sharedDirector().setDisplayFPS(false);
		CCDirector.sharedDirector().setAnimationInterval(1.0f / 60);
		
		CCTexture2D.setDefaultAlphaPixelFormat(Config.ARGB_8888);
		
		CCDirector.sharedDirector().setDeviceOrientation(CCDirector.kCCDeviceOrientationLandscapeLeft);
		CCDirector.sharedDirector().setScreenSize(Global.VIRT_WIDTH, Global.VIRT_HEIGHT);
        
		Global.initialize();
		
	    initMiniGameOrder();
	    initDB();

	    if ( Global.g_DebugAll )
	    {
	    	int i;
	    	for ( i = 0; i < Global.maxAchivements; i++ )
	    		Global.hasFinishedThisAchivements[i] = true;
	    }
		
		// Make the Scene active
	    CCDirector.sharedDirector().runWithScene(SplashLayer.scene());
	    //CCDirector.sharedDirector().runWithScene(ScoreShownScene.scene());
	}

	private void initMiniGameOrder() {
		// TODO Auto-generated method stub
	    Global.miniGameOrder[0] = 1;
	    Global.miniGameOrder[1] = 4;
	    Global.miniGameOrder[2] = 2;
	    Global.miniGameOrder[3] = 3;
	    Global.miniGameOrder[4] = 10;
	    Global.miniGameOrder[5] = 5;
	    Global.miniGameOrder[6] = 11;
	    Global.miniGameOrder[7] = 13;
	    Global.miniGameOrder[8] = 103;
	}

	private void initDB() {
		// TODO Auto-generated method stub
		loadSettings();
	}

	protected void onDestroy()
	{
		SimpleAudioEngine.sharedEngine().realesAllSounds();
		SimpleAudioEngine.sharedEngine().realesAllEffects();
		
		// Destroy the AdView.
	    if (adView != null) {
	      adView.destroy();
	    }
	    
		super.onDestroy();		
		
		saveSettings();
	}

	 @Override
	    public void onPause()
	    {
	    	if (adView != null) {
			      adView.pause();
			    }
	    	
	        super.onPause();
	        CCDirector.sharedDirector().onPause();
	    }

	    @Override
	    public void onResume()
	    {
	        super.onResume();
	        
	        if (adView != null) {
		        adView.resume();
		      }
	        
	        CCDirector.sharedDirector().onResume();
	    }

	    
	    
	@Override
	protected Dialog onCreateDialog(int id)
	{
		switch (id)
		{
		case 1:
		{
			String str = "Data in Game will be reset. Reset data?";
			return new AlertDialog.Builder(this)
		        .setTitle(R.string.app_name)
		        .setMessage(str)
		        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		            public void onClick(DialogInterface dialog, int whichButton) {
		                /* User clicked OK so do some stuff */
		            	resetData();
		            }
		        })
		        .setNegativeButton("No", new DialogInterface.OnClickListener() {
		        	public void onClick(DialogInterface dialog, int whichButton) {
		        		/* User clicked cancel so do some stuff */
		        	}
		        })
		        .create();
		}
		}
		return null;		
	}

	public void  resetData()
	{
	    //story
		GameActivity.app.getPreferences(0).edit().putBoolean("main_hasPlayedBeginStory",false);
	    GameActivity.app.getPreferences(0).edit().putBoolean("main_hasPlayedEndStory",false);
	    GameActivity.app.getPreferences(0).edit().putBoolean("main_hasPlayedInstruction",false);
	    
	    //missions
	    GameActivity.app.getPreferences(0).edit().putInt("currentMissionIdx_00",0);
	    GameActivity.app.getPreferences(0).edit().putInt("currentMissionIdx_01",1);
	    GameActivity.app.getPreferences(0).edit().putInt("currentMissionIdx_02",2);
	    
	    for(int i = 0 ; i < Global.maxMissions ; i++){
	        
	        String  key = String.format("mission_%02d", i);
	         GameActivity.app.getPreferences(0).edit().putBoolean(key,false);
	    }
	    
	    
	    for(int i = 0 ; i < Global.maxMissions ; i++){
	        
	        String  key = String.format("missionPlayed_%02d", i);
	        GameActivity.app.getPreferences(0).edit().putBoolean(key,false);
	    }
	    
	    //items
	    for(int i = 0 ; i < Global.maxUpgradeItems ; i++){
	         String  key = String.format("upgrade_itemLevel_%02d", i);
	        if( i == 0 || i == 1){
	        	GameActivity.app.getPreferences(0).edit().putInt(key,1);
	        }else{
	        	GameActivity.app.getPreferences(0).edit().putInt(key,0);
	        }
	    }
	    
	    GameActivity.app.getPreferences(0).edit().commit();
	    
	    for ( int i = 0; i < Global.maxAchivements; i++ )
    		Global.hasFinishedThisAchivements[i] = false;
	    
	    for ( int i = 0; i < Global.maxTotalMiniChosen; i++ )
	    {
	    	Global.g_bestScore[i] = 0;
	    	Global.hasPlayedMiniGames[i] = false;
	    }
	    Global.miniGameIdx = 0;
	}
	
	public void loadSettings()
	{
		FileInputStream f;
		try {
			f = new FileInputStream(getCacheDir()+"/zombie_pref.dat");
			Global.isMusic = f.read() != 0;
			Global.isSound = f.read() != 0;
			for ( int i = 0; i < 9; i++ )
			{
				Global.g_bestScore[i] =  f.read();	
			}
			
			for(int i = 0 ; i < Global.maxMiniGames ; i++){
				Global.hasPlayedMiniGames[i] = f.read() != 0;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void saveSettings()
	{
		FileOutputStream f;
		try {
			f = new FileOutputStream(getCacheDir()+"/zombie_pref.dat");
			if ( Global.isMusic ) f.write(1);
			else f.write(0);
			if ( Global.isSound ) f.write(1);
			else f.write(0);
			for ( int i = 0; i < 9; i++ )
			{
				f.write(Global.g_bestScore[i]);	
			}
			for(int i = 0 ; i < Global.maxMiniGames ; i++){
				if (Global.hasPlayedMiniGames[i]) f.write(1);
				else f.write(0);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
        	exitGameDialog();
			return false;
        }
		return super.onKeyDown(keyCode, event);
	}

    public void exitGameDialog()
    {
		Builder builder = new AlertDialog.Builder(this)
		.setIcon(R.drawable.ic_launcher)
        .setTitle("Exit the Game?")
        .setMessage("Are you sure?")
        .setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        })
        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            	finish();
            }
        });
		builder.create().show();
    }

    public void showInterstitialAds()
	{
		runOnUiThread(new Runnable() {
		    public void run() {
		    	 AdRequest interstitialAdRequest = new AdRequest.Builder().build();
		    	 interstitialAd.loadAd(interstitialAdRequest);
		    }
		});
	}
}
