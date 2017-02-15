
package com.zombieglider;

import java.io.IOException;
import org.cocos2d.sound.SoundEngine;

public class SimpleAudioEngine extends SoundEngine
{
	static SimpleAudioEngine s_SharedEngine;
	boolean isPlaying;
	GameActivity _acti = GameActivity.app; 

	Float soundVolume = new Float(0.5);
	Float effectVolume = new Float(2.0);
	
	public SimpleAudioEngine()
	{
		setSoundVolume(soundVolume);
		setEffectsVolume(effectVolume);
		s_SharedEngine = this;
	}
    public static SimpleAudioEngine sharedEngine()
	{
    	if ( s_SharedEngine == null ) s_SharedEngine = new SimpleAudioEngine();
		return s_SharedEngine;
	}
	
	public void end()
	{
	    realesAllSounds();
	    realesAllEffects();
	}
	
	//////////////////////////////////////////////////////////////////////////
	// BackgroundMusic
	//////////////////////////////////////////////////////////////////////////
	
	public void playBackgroundMusic(int resID, boolean bLoop) throws IOException
	{
		this.playSound(_acti, resID, bLoop);
		isPlaying = true;
	}
	
	public void stopBackgroundMusic()
	{
		realesAllSounds();
		isPlaying = false;
	}
	
	public void pauseBackgroundMusic()
	{
		pauseSound();
		isPlaying = false;
	}
	
	public void resumeBackgroundMusic()
	{
		resumeSound();	  
		isPlaying = true;
	}
	
	public void rewindBackgroundMusic()
	{
		isPlaying = true;
	}
	
	public boolean willPlayBackgroundMusic()
	{
	    return false;
	}
	
	public boolean isBackgroundMusicPlaying()
	{
		return isPlaying;
	}
	
	//////////////////////////////////////////////////////////////////////////
	// effect function
	//////////////////////////////////////////////////////////////////////////
	
	public void playEffect(int resID, boolean bLoop)
	{
		this.playEffect(_acti, resID);            
	}
	
	public void stopEffect(int resId) {
		// TODO Auto-generated method stub
		stopEffect(_acti,resId);
	}
}	
