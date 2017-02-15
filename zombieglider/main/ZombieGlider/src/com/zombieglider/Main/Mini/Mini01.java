package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.Turtle;

public class Mini01 extends MiniBasic
{
    Turtle turtle[] = new Turtle[6];
    
    int shellGoingToMoment[] = new int[6];
    int shellLevelGoingToMoment[] = new int[6];
    
    int shell_Check[] = new int[6];

	
	public void  restart()
	{
	    for(int i = 0 ; i < maxMoment ; i++){
	        if(momentRunTime[i] > 0){
	            turtle[momentTarget[i]].setStatus(Global.kTurtleAniStatus_In);
	            momentRunTime[i] = -9999;
	        }
	    }
	    
	    numberTapToNextRound = 0;
	    remainTapToNextRound = 0;
	    
	    recentMomentIdx = 0;
	    
	    super.restart();
	}
	
	public void  reInitColorComboLimit()
	{
	    if(Global.gameLevel == 5){
	    	Global.timeToBeGained = 4;
	    }
	
	    if(Global.gameLevel == 3){
	    	Global.comboColorLimit[0] = 0;
	    	Global.comboColorLimit[1] = 20;
	    	Global.comboColorLimit[2] = 40;
	    	Global.comboColorLimit[3] = 60;
	    	Global.comboColorLimit[4] = 80;
	    	Global.comboColorLimit[5] = 100;
	    	Global.comboColorLimit[6] = 120;
	    	Global.comboColorLimit[7] = 140;
	    	Global.comboColorLimit[8] = 160;
	    	Global.comboColorLimit[9] = 180;
	    	Global.comboColorLimit[10] = 200;
	    }
	    
	    if(Global.gameLevel == 6){
	    	Global.comboColorLimit[0] = 0;
	    	Global.comboColorLimit[1] = 25;
	    	Global.comboColorLimit[2] = 40;
	    	Global.comboColorLimit[3] = 60;
	    	Global.comboColorLimit[4] = 80;
	    	Global.comboColorLimit[5] = 100;
	    	Global.comboColorLimit[6] = 120;
	    	Global.comboColorLimit[7] = 140;
	    	Global.comboColorLimit[8] = 160;
	    	Global.comboColorLimit[9] = 180;
	    	Global.comboColorLimit[10] = 200;
	    }
	      
	}
	
	
	public void  updateGameLevel()
	{
	    if(Global.gameRound < 10){
	    	Global.gameLevel = 0;
	    }else if(Global.gameRound < 30){
	    	Global.gameLevel = 1;
	    }else if(Global.gameRound < 60){
	    	Global.gameLevel = 2;
	    }else if(Global.gameRound < 90){
	    	Global.gameLevel = 3;
	    }else if(Global.gameRound < 120){
	    	Global.gameLevel = 4;
	    }else if(Global.gameRound < 160){
	    	Global.gameLevel = 5;
	    }else if(Global.gameRound < 200){
	    	Global.gameLevel = 6;
	    }else if(Global.gameRound < 250){
	    	Global.gameLevel = 7;
	    }else if(Global.gameRound < 300){
	    	Global.gameLevel = 9;
	    }
	    
	    if(Global.gameRound < 10){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.006f;
	    }else if(Global.gameRound < 30){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.006f;
	    }else if(Global.gameRound < 60){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.007f;
	    }else if(Global.gameRound < 100){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.009f;
	    }else if(Global.gameRound < 130){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.01f;
	    }else if(Global.gameRound < 160){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.011f;
	    }else if(Global.gameRound < 200){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.012f;
	    }else if(Global.gameRound < 230){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.0135f;
	    }else if(Global.gameRound < 260){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.015f;
	    }else if(Global.gameRound < 300){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.017f;
	    }else if(Global.gameRound < 350){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.02f;
	    }else if(Global.gameRound < 400){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.0225f;
	    }else if(Global.gameRound < 450){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.025f;
	    }else if(Global.gameRound < 500){
	    	Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.03f;
	    }
	 
	    if(comboReduceSpeedAccum < 0){
	        comboReduceSpeedAccum += comboReduceSpeedAccumSpeed/50;  //0.003/30
	    }else{
	        comboReduceSpeedAccum = 0;
	    }
	    
	    if(Global.comoboReduceSpeed < 0.006){
	    	Global.comoboReduceSpeed = 0.006f;
	    }
	    
	    this.reInitColorComboLimit();
	    
	}
	
	
	public Mini01()
	{
		super();
	        
		Global.maxTime = 40;
		Global.timeRemain = Global.maxTime;
		Global.timeToBeGained = 3.5f;
        
         s_bg = CCSprite.sprite("images/Main/mini 01/mini_01_bg.png");
        s_bg.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2, Global.VIRT_HEIGHT/2));
        s_bg.setScale( 1.0f/Global.g_Scale );
        
		this.addChild(s_bg);
        
		Global.wholeTurtleScaleFromSocurce = 0.5f;
		Global.maxTurtleOnScreen = 3;
        
        this.initCharacters();
        

        Global.gameLevel = 0;
        numberTapToNextRound = 0;
        remainTapToNextRound = 0;
	}
	
	public void  initCharacters()
	{
	    turtle[0] = new Turtle();
	    turtle[1] = new Turtle();
	    turtle[2] = new Turtle();
	    turtle[3] = new Turtle();
	    turtle[4] = new Turtle();
	    turtle[5] = new Turtle();
	    
	    float startX = 105;
	    float startY = 60;
	    float offsetX = 150;
	    float offsetY = 100;
	    
	    if(Global.isIphone5){
	        startX = 105 + 44;
	    }
	    
	    turtle[0].setX(startX);
	    turtle[0].setY(startY);
	    turtle[0].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[1].setX(startX + offsetX);
	    turtle[1].setY(startY);
	    turtle[1].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[2].setX(startX + offsetX*2);
	    turtle[2].setY(startY);
	    turtle[2].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[3].setX(startX);
	    turtle[3].setY(startY+offsetY);
	    turtle[3].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[4].setX(startX + offsetX);
	    turtle[4].setY(startY+offsetY);
	    turtle[4].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[5].setX(startX + offsetX*2);
	    turtle[5].setY(startY+offsetY);
	    turtle[5].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[0].setBombOutType(Global.kTurtleBombOutType_backToOri);
	    turtle[1].setBombOutType(Global.kTurtleBombOutType_backToOri);
	    turtle[2].setBombOutType(Global.kTurtleBombOutType_backToOri);
	    turtle[3].setBombOutType(Global.kTurtleBombOutType_backToOri);
	    turtle[4].setBombOutType(Global.kTurtleBombOutType_backToOri);
	    turtle[5].setBombOutType(Global.kTurtleBombOutType_backToOri);
	    	    
	    turtle[0].setDelegate(this);
	    turtle[1].setDelegate(this);
	    turtle[2].setDelegate(this);
	    turtle[3].setDelegate(this);
	    turtle[4].setDelegate(this);
	    turtle[5].setDelegate(this);
	    
	    turtle[0].setIdNumber(0);
	    turtle[1].setIdNumber(1);
	    turtle[2].setIdNumber(2);
	    turtle[3].setIdNumber(3);
	    turtle[4].setIdNumber(4);
	    turtle[5].setIdNumber(5);
	}
	
	public void  manage( float  dt)
	{
	    this.manageRemainTapToNextStep();
	    this.manageMini04Type(dt);
	    
	    for ( int i = 0 ; i < 6 ; i++){
	        
	        turtle[i].manage(dt);
	        
	        if(turtle[i].status() == Global.kTurtleAniStatus_Normal_Out){
	            if((Math.random()*65535) % 50 == 0){
	                turtle[i].setStatus(Global.kTurtleAniStatus_Idle);
	            }  
	        }
	    }
	}
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    super.ccTouchesBegan(event);
	    
	    if(Global.isTapWronglyAndDisableBtns){
	        return true;
	    }
	    
	    if(Global.isStopping){
	        return true;
	    }
	    
	    if(Global.isFuckingShootFirstTime){
	    	Global.isFuckingShootFirstTime = false;
	        return true;
	    }
	    
		for( int ii = 0; ii < event.getPointerCount(); ii++ ) {
			CGPoint location = CGPoint.ccp(event.getX(ii),event.getY(ii));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        boolean fuxkHasTapTurtle;
	        fuxkHasTapTurtle = false;
	        
	        for(int i = 0 ; i < 6 ; i++){
	            float fuxkTurtleAtX;
	            float fuxkTurtleAtY;
	            float fuxkTurtleLeft;
	            float fuxkTurtleRight;
	            float fuxkTurtleUp;
	            float fuxkTurtleDown;
	            
	            fuxkTurtleAtX = turtle[i].x();
	            fuxkTurtleAtY = turtle[i].y();
	            fuxkTurtleLeft = Global.wholeTurtleScaleFromSocurce * 2 * Global.turtle_detectHalfLeft;
	            fuxkTurtleRight = Global.wholeTurtleScaleFromSocurce * 2 * Global.turtle_detectHalfRight;
	            fuxkTurtleUp = Global.wholeTurtleScaleFromSocurce * 2 * Global.turtle_detectHalfUp;
	            fuxkTurtleDown = Global.wholeTurtleScaleFromSocurce * 2 * Global.turtle_detectHalfDown;
	            
	            if(location.x > fuxkTurtleAtX - fuxkTurtleLeft  && location.x < fuxkTurtleAtX + fuxkTurtleRight){
	                if(location.y > fuxkTurtleAtY - fuxkTurtleDown  && location.y < fuxkTurtleAtY + fuxkTurtleUp){
	                    turtle[i].tap();
	                    fuxkHasTapTurtle = true;
	                    
	                    this.updateGameLevel();
	                }
	            }
	            
	        }
	    }
		return true;
	}
	
	public void  initcomboColorLimit()
	{
	    Global.comboColorLimit[0] = 0;
	    Global.comboColorLimit[1] = 15;
	    Global.comboColorLimit[2] = 30;
	    Global.comboColorLimit[3] = 60;
	    Global.comboColorLimit[4] = 90;
	    Global.comboColorLimit[5] = 120;
	    Global.comboColorLimit[6] = 150;
	    Global.comboColorLimit[7] = 180;
	    Global.comboColorLimit[8] = 200;
	    Global.comboColorLimit[9] = 250;
	    Global.comboColorLimit[10] = 300;
	}
	
	
	public void  giveNextMoment()
	{
	    for(int i = 0 ; i < 6 ; i++){
	        shellGoingToMoment[i] = -1;
	    }
	
	    int ranShellLevel;
	    int maxTurtleCount;
	    int turtleNumbers;
	    
	    for(int i = 0 ; i < 6 ; i++){
	        shell_Check[i] = -1;
	    }
	    
	    turtleNumbers = 0;
	    maxTurtleCount = Global.gameLevel+1; //5
	    
	    int gotFuckedTime;
	    gotFuckedTime = 0;
	    do{
	        boolean innerFuck;
	        do{
	            innerFuck = false;
	            
	            ranShellLevel = (int) ((Math.random()*65535)%3);
	            
	            if(Global.gameLevel == 1){
	                ranShellLevel = 0;
	            }
	            
	            if(Global.gameLevel == 2){
	                if((Math.random()*65535) % 100 < 80){
	                    ranShellLevel = 0;
	                }else{
	                    ranShellLevel = 1;
	                }
	            }
	            
	            if(Global.gameLevel == 6  && gotFuckedTime < 1){
	                ranShellLevel = 1;
	                gotFuckedTime++;
	            }
	            if(Global.gameLevel == 7  && gotFuckedTime < 1){
	                ranShellLevel = 2;
	                gotFuckedTime++;
	            }
	            
	            if(Global.gameLevel >= 8 && gotFuckedTime < 2){
	                ranShellLevel = 2;
	                gotFuckedTime ++;
	                
	            }
	            
	        }while(innerFuck);
	        
	        maxTurtleCount -= ranShellLevel + 1;
	        if(maxTurtleCount < 0){
	            ranShellLevel = maxTurtleCount + ranShellLevel;
	        }
	        
	        shell_Check[turtleNumbers] = this.genNextTargetMoment(-1,ranShellLevel,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	        turtleNumbers++;
	        
	    }while(maxTurtleCount > 0);
	
	    
	    if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	        newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	    }else{
	        numberTapToNextRound = turtleNumbers;
	        remainTapToNextRound += turtleNumbers;
	    }
	
	    for(int i = 0 ; i < 6 ; i++){
	        if(shellGoingToMoment[i] < 0){
	            //return;
	        }else{
	            
	            hasNoticedOverTime[recentMomentIdx] = false;
	            momentRunTime[recentMomentIdx] = 0;
	            momentOverTime[recentMomentIdx] = 40000;
	            
	            momentTarget[recentMomentIdx] = i;
	            turtle[i].setStatus(Global.kTurtleAniStatus_Out);
	            turtle[i].setMomentIdx(recentMomentIdx);
	            turtle[i].setShellLevel(shellLevelGoingToMoment[i]);
	            
	            recentMomentIdx++;
	            if(recentMomentIdx >= maxMoment){
	                recentMomentIdx = 0;
	            }
	            
	            newestMomentHasAppearedTime = 0;
	            this.getScript();
	            
	        }
	    }
	}
	
	public void  getScript()
	{
	    if(Global.gameLevel == 0){
	        nextMomentAppearTime = 8;
	    }
	    
	    nextMomentAppearTime = 40000;
	}
	
	public void  turtleBombed( int _momentIdx)
	{
	    super.turtleBombed(_momentIdx);
	}
	
	
	public void  manageRemainTapToNextStep()
	{
	    if(remainTapToNextRound == 0 && !isFuxking){
	        
	        if(nextMomentAppearTime - newestMomentHasAppearedTime > 0.05){
	            newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	        }
	    }
	}
	
	
	public int  genNextTargetMoment( int _shellStandPosition, int _shellLevel, int _NS1, int _NS2, int _NS3, int _NS4, int _NS5, int _NS6)
	{
	    if(_shellStandPosition < -100){
	        return -1000;
	    }
	    
	    isFuxking = false;
	    
	    boolean hasColide;
	    int momentTargetCheck;
	    int hasColideTimes;
	    
	    hasColideTimes = 0;
	    do{
	        hasColideTimes++;
	        hasColide = false;
	        
	
	        momentTargetCheck = (int) ((Math.random()*65535)%6);
	        
	        for(int j = 0 ; j < maxMoment ; j++){
	            if(momentRunTime[j] > 0){
	                if(momentTarget[j] == momentTargetCheck){
	                    hasColide = true;
	                }
	            }
	        }
	        
	        if(hasColideTimes > 100){
	            hasColide = false;
	            for(int i = 0 ; i < 6 ; i++){
	                shellGoingToMoment[i] = -1;
	            }
	            return -200;
	        }
	        
	        if(momentTargetCheck < 0 || momentTargetCheck > 5){
	            hasColide = true;
	        }else{
	            if(turtle[momentTargetCheck].status() != Global.kTurtleAniStatus_Normal_In){
	                hasColide = true;
	            }
	        }
	        
	        if(momentTargetCheck == _NS1 || momentTargetCheck == _NS2 || momentTargetCheck == _NS3 || momentTargetCheck == _NS4 || momentTargetCheck == _NS5 || momentTargetCheck == _NS6){
	            hasColide = true;
	        }
	        
	        
	    }while(hasColide);
	    
	    shellGoingToMoment[momentTargetCheck] = 1;
	    shellLevelGoingToMoment[momentTargetCheck] = _shellLevel;
	    
	    return momentTargetCheck;
	    
	}
	
	public void  thisMomentOverTime( int _momentIdx)
	{
	    turtle[momentTarget[_momentIdx]].setStatus(Global.kTurtleAniStatus_In);
	    Global.gameRound--;
	    if(Global.gameRound < 0){
	    	Global.gameRound = 0;
	    }
	    remainTapToNextRound--;
	    
	
	    
	}
	
	
	public void  tapWrongly()
	{
	    super.tapWrongly();
	    
	    boolean hasPlayedBigBomb;
	    hasPlayedBigBomb = false;
	    
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.005;
	        if(comboReduceSpeedAccum < -0.01){
	            comboReduceSpeedAccum = -0.01f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	    
	    for(int i = 0 ; i < maxMoment ; i++){
	        if(momentRunTime[i] > 0){
	            turtle[momentTarget[i]].setStatus(Global.kTurtleAniStatus_In);
	            momentRunTime[i] = -9999;
	
	            if(!hasPlayedBigBomb){
	                hasPlayedBigBomb = true;
	                Global.playLayer.setToBombingGameover();
	            }
	        }
	    }
	    
	}
	
	public void  beforeLoseComboWhenComboRemainGoesToZero()
	{
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.005;
	        if(comboReduceSpeedAccum < -0.01){
	            comboReduceSpeedAccum = -0.01f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	    
	}

}
