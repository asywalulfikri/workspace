package com.zombieglider.Main.Mini;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.ControlLayer;
import com.zombieglider.SelectMinigame.SelectMiniGameScene2;

public class MiniBasic extends CCLayer
{
    CCSprite s_bg;
    
    int recentMomentIdx;
    int maxMoment;
    float momentRunTime[] = new float[10];  //moment time initially set < 0, means no mement recently. no need fucking check
    int momentTarget[] = new int[10];  //for mini game 01, 04  ->which turtle
    
    float momentOverTime[] = new float[10];
    boolean hasNoticedOverTime[] = new boolean[10];
    
    float nextMomentAppearTime;
    float newestMomentHasAppearedTime;
    
    int numberTapToNextRound;
    int remainTapToNextRound;
    
    boolean isFuxking;
    
    ControlLayer controlLayer;
    
    float comboReduceSpeedAccum;
    float comboReduceSpeedAccumSpeed;
    
    float finalTimeRemain;

	
	MiniBasic()
	{
		super();
        setIsTouchEnabled(true);
        
        Global.comoboReduceSpeed = 0.002f;
        comboReduceSpeedAccum = 0;
        Global.counterForAchivement = 0;
        
        Global.isTapWronglyAndDisableBtns = false;
        Global.isFuckingShootFirstTime = false;
        
        Global.gameLevel = 0;
        Global.gameRound = 0;
        
        remainTapToNextRound = 1;
        numberTapToNextRound = 1;
        
        isFuxking = false;
        
        this.initMoments();
        this.initComboColorLimit();
        
        Global.uILayer.setDelegate(this);

	}
	
	public void  initComboColorLimit()
	{
	
	}
	
	public void  initCharacters()
	{
	
	}
	
	public void  initMoments()
	{
	    maxMoment = 10;
	    for(int i = 0 ; i < maxMoment ; i++){
	        momentRunTime[i] = -9999;
	    }
	}
	
	public void  manage( float  dt)
	{
	
	}
	
	public void  getScript()
	{
	
	}
	
	public void  finishOneRound()
	{
		Global.gameRound++;
	}
	
	public void  manageMini04Type( float  dt)
	{
	    newestMomentHasAppearedTime += dt;
	    
	    if(newestMomentHasAppearedTime >= nextMomentAppearTime){
	        this.giveNextMoment();
	    }
	    
	    for(int i = 0 ; i < maxMoment ; i++){
	        momentRunTime[i] += dt;
	        if(momentRunTime[i] > momentOverTime[i]){
	            if(!hasNoticedOverTime[i]){
	                hasNoticedOverTime[i] = true;
	                momentRunTime[i] = -9999;
	                this.thisMomentOverTime(i);
	            }
	        }
	    }
	}
	
	public void  thisMomentOverTime( int _momentIdx)
	{
	    
	}
	
	public void  giveNextMoment()
	{
	
	}
	
	public void  turtleBombed( int _momentIdx)
	{
	    hasNoticedOverTime[_momentIdx] = true;
	    momentRunTime[_momentIdx] = -9999;
	    
	    remainTapToNextRound--;
	    if(remainTapToNextRound == 0){
	    	Global.comboRemain = 1;
	    }
	    
	}
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    
	    for( int i = 0; i < event.getPointerCount(); i++ ) {
			CGPoint location = CGPoint.ccp(event.getX(i), event.getY(i));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        if(!Global.isStopping){
	            if(location.x > 418){
	                if(location.y > 258){
	                	Global.isStopping = true;
	                	Global.isFuckingShootFirstTime = true;
	                	Global.uILayer.showMenu();
	                    
	                    if(Global.currentChosenMiniGame == 11){
	                    	Global.isTapWronglyAndDisableBtns = true;
	                    }
	                }
	            }
	        }else{
	            
	            if(Global.isShowingInstruction){
	            	Global.playLayer.removeInstruction();
	            }
	            
	            if(Global.isShowingMenu){
	                if(location.x > 101 && location.x < 400){
	                    if (location.y > 239){
	                    	Global.playLayer.showInstruction();
	                    }else if (location.y > 153){
	                    	Global.uILayer.removeMenu();
	                    }else if (location.y > 83){
	                    	Global.uILayer.removeMenu();
	                    	Global.playLayer.gotoRestart();
	                    }else{
	                        Global.musicController.stopBackgroundMusic();
	                        CCDirector.sharedDirector().replaceScene( SelectMiniGameScene2.scene());
	                    }
	                }
	            }
	        }
	    }
		return true;
	}
	
	public void  tapWrongly()
	{
	    newestMomentHasAppearedTime = (float) (nextMomentAppearTime - 1.2);
	    
	    Global.gameRound-=1;
	    if(Global.gameRound < 0){
	    	Global.gameRound = 0;
	    }
	    
	    remainTapToNextRound = 0;
	    isFuxking = true;
	}
	
	public void  updateGameLevel()
	{
	
	}
	
	public void  comboLost()
	{
	  
	}
	
	public void  thisTurtleIsBombOutOffScreen( int _turtleIdx)
	{
	
	}
	
	public void  btnIsTappedInControlLayer( int _btnIdx)
	{
	
	}
	
	public void  btnIsReleasedInControlLayer( int _btnIdx)
	{
	
	}
	
	public void  restart()
	{
	    comboReduceSpeedAccum = 0;
	    this.updateGameLevel();
	}
	
	public void  cannonShootBall( int _fromId)
	{
	
	}
	
	public void  reInitColorComboLimit()
	{
	
	}
	
	public void  beforeLoseComboWhenComboRemainGoesToZero()
	{
	
	}

	public void gotoNextJump() {
		// TODO Auto-generated method stub
		
	}

	public void tapTurtle() {
		// TODO Auto-generated method stub
		
	}

}
