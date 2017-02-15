package com.zombieglider;

import java.io.IOException;

import asywalul.otongglider.android.R;

public class MusicController 
{
	SimpleAudioEngine soundEngine;
	int m_arrSounds[] =
		{
			R.raw.turtleheadout,
			R.raw.turtleexplode01,
			R.raw.turtleexplode02,
			R.raw.turtleexplode03,
			R.raw.timerunout_slow,
			R.raw.timerunout_medium,
			R.raw.timerunout_fast,
			R.raw.combotime,
			R.raw.crackshell,
			R.raw.combosmoke,
			R.raw.gameover,
			R.raw.tapwrongly,
			R.raw.losecombo,
			R.raw.arrows,
			R.raw.minesweeper2,
			R.raw.minesweeperv2,
			R.raw.penguinjump3,
			R.raw.achievement_unlock,
			R.raw.button_tap,
			R.raw.button_tap2,
			R.raw.reward,
			R.raw.score,
			R.raw.score2,
			R.raw.turtle_coins,
			R.raw.mainthrust,
			R.raw.maincrash,
			R.raw.diamond,
			R.raw.penguin_hit,
			R.raw.perfectlaunch,
			R.raw.redflame, 
			R.raw.yellowflame,
			R.raw.thrustboost,
			R.raw.buy,
			R.raw.perfectlaunch02
		};
	
	public MusicController()
	{
		soundEngine = new SimpleAudioEngine();
		for ( int i = 0; i < m_arrSounds.length; i++ )
			soundEngine.preloadEffect(GameActivity.app, m_arrSounds[i]);		
	}

	public void initForBegin() {
		// TODO Auto-generated method stub
	    if(!Global.isMusic){
	        return;
	    }
	    
	    if(Global.playerSoundIdx == 1){
	        return;
	    }
	    
	    Global.playerSoundIdx = 1;

		try {
			soundEngine.playBackgroundMusic(R.raw.begin, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soundEngine.setSoundVolume(0.5f);
	}

	public void playThisSound(int index, boolean bLoop, double d) {
		// TODO Auto-generated method stub
		if(!Global.isSound)
			return;
		soundEngine.playEffect(m_arrSounds[index], bLoop);
		soundEngine.setSoundVolume(2.0f);
	}

	public void initForPlay() {
		// TODO Auto-generated method stub
		if(!Global.isMusic){
	        return;
	    }
	    
	    if(Global.playerSoundIdx == 3){
	        return;
	    }
	    
	    Global.playerSoundIdx = 3;
	
	    try {
			soundEngine.playBackgroundMusic(R.raw.play, true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		soundEngine.setSoundVolume(0.5f);
	}

	public void stopThisSound(int resId) {
		// TODO Auto-generated method stub
		if(!Global.isSound)
			return;
		soundEngine.stopEffect(resId);		
	}

	public void changeGain(int ksoundTimerunoutfast, float f) {
		// TODO Auto-generated method stub
		
	}

	public void stopBackgroundMusic() {
		// TODO Auto-generated method stub
	    Global.playerSoundIdx = -1;
	    
		soundEngine.stopBackgroundMusic();
	}

	public void setmusicGain(float transitionGain) {
		// TODO Auto-generated method stub
		
	}
}
