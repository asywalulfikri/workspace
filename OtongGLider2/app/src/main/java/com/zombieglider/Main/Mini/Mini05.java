package com.zombieglider.Main.Mini;


import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.Cannon;
import com.zombieglider.Main.ControlLayer;
import com.zombieglider.Main.Penguin;
import com.zombieglider.Main.Turtle;

import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCSprite;

public class Mini05 extends MiniBasic
{
	public static final int kBtnColor_Brown = 0;
	public static final int kBtnColor_Red = 1;
	public static final int kBtnColor_Green = 2;
	public static final int kBtnColor_Blue = 3;
	
    Turtle turtle[] = new Turtle[12];
    Penguin penguin;
    
    int maxTurtle;
    int turtleIdx;
    
    float shellPosX[] = new float[12];
    float shellPosY[] = new float[12];
    float shellFixPosX[] = new float[12];
    float shellFixPosY;
    int shellToFixIdx[] = new int[12];
    float shellColor[] = new float[12];
    
    float shellMovingSpeed;
    
    Cannon cannon;
    
    
    CCSprite s_Cannon_Ball[] = new CCSprite[8];
    int maxCannonBall;
    float cannonBall_X[] = new float[8];
    float cannonBall_Y[] = new float[8];
    boolean cannonBall_isAni[] = new boolean[8];
    int cannonBall_Timer[] = new int[8];
    int cannonBallIdx;
    
    boolean isPrepareShooting;
    int prepareShootingColor;
    
    int ranShellLevel;
    
    boolean isAniWrong;
    int wrongTimer;
    
    float wrongScale;
    
    int SecondLevelShellAppearRatio;
    int ranSecondShellRatio;
    
    float fuckAngle;
    
    CCSprite s_shadow_cannon;
    CCSprite s_shadow_penguin;
	
	
	public void  updateGameLevel()
	{
	
	    if(Global.gameRound < 10){
	        SecondLevelShellAppearRatio = 0;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.005;
	    }else if(Global.gameRound < 20){
	        SecondLevelShellAppearRatio = 0;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.007;
	    }else if(Global.gameRound < 35){
	        SecondLevelShellAppearRatio = 10;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.009;
	    }else if(Global.gameRound < 50){
	        SecondLevelShellAppearRatio = 15;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.012;
	    }else if(Global.gameRound < 65){
	        SecondLevelShellAppearRatio = 20;
	        Global.comoboReduceSpeed =comboReduceSpeedAccum +  0.014;
	    }else if(Global.gameRound < 85){
	        SecondLevelShellAppearRatio = 30;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.016;
	    }else if(Global.gameRound < 110){
	        SecondLevelShellAppearRatio = 30;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.018;
	    }else if(Global.gameRound < 150){
	        SecondLevelShellAppearRatio = 20;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.02;
	    }else if(Global.gameRound < 190){
	        SecondLevelShellAppearRatio = 15;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.024;
	    }else if(Global.gameRound < 230){
	        SecondLevelShellAppearRatio = 5;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.027;
	    }else if(Global.gameRound < 270){
	        SecondLevelShellAppearRatio = 0;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.03;
	    }else if(Global.gameRound < 300){
	        SecondLevelShellAppearRatio = 0;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.035;
	    }
	    
	    if(comboReduceSpeedAccum < 0){
	        comboReduceSpeedAccum += comboReduceSpeedAccumSpeed/20;  //0.006/20
	    }else{
	        comboReduceSpeedAccum = 0;
	    }
	    
	    if(Global.comoboReduceSpeed < 0.005){
	        Global.comoboReduceSpeed = 0.005;
	    }
	}
	
	public void  restart()
	{
	    
	    super.restart();
	    
	    for(int i = 1 ; i < maxTurtle ; i++){
	        this.setShellColor(i);
	    }
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        ranSecondShellRatio = (int) ((Math.random()*65535) % 100);
	        if(ranSecondShellRatio < SecondLevelShellAppearRatio){
	            ranShellLevel = 2;
	        }else{
	            ranShellLevel = 1;
	        }
	        turtle[i].setShellLevel(ranShellLevel);
	    }
	    
	}
	
	public void  initControlLayer()
	{
	    controlLayer = new ControlLayer();
		this.addChild(controlLayer,Global.kDeapth_Btns);
	    controlLayer.setDelegate(this);
	}
	
	public Mini05()
	{
		super();
	        
        Global.comboColorLimit[0] = 0;
        Global.comboColorLimit[1] = 12;
        Global.comboColorLimit[2] = 24;
        Global.comboColorLimit[3] = 36;
        Global.comboColorLimit[4] = 48;
        Global.comboColorLimit[5] = 60;
        Global.comboColorLimit[6] = 72;
        Global.comboColorLimit[7] = 84;
        Global.comboColorLimit[8] = 96;
        Global.comboColorLimit[9] = 108;
        Global.comboColorLimit[10] = 120;
        
        Global.maxTime = 30;
        Global.timeRemain = Global.maxTime;
        
        Global.cannonAngle = 0;
        fuckAngle = 30;
        
        Global.gameRoundFromBegin = 0;
        SecondLevelShellAppearRatio = 0;
        
        isAniWrong = false;
        
        s_bg = CCSprite.sprite("images/Main/mini 05/mini_05_bg.png");
        s_bg.setPosition(CGPoint.ccp(240,160));
        s_bg.setScale( 1.0f/Global.g_Scale );
		this.addChild(s_bg);
        
        if(Global.isIphone5){
            CCSprite  s_temp_bg = CCSprite.sprite("images/Main/mini 05/mini_05_bg.png");
            s_temp_bg.setPosition(CGPoint.ccp(479,160));
            s_temp_bg.setAnchorPoint(CGPoint.ccp(1,0.5));
            s_temp_bg.setScaleX(-1);
            this.addChild(s_temp_bg);
        }
        
        Global.wholeCannonScaleFromSocurce = 0.5f;
        Global.wholeTurtleScaleFromSocurce = 0.5f;
        Global.wholePenguinScaleFromSocurce = 0.55f;
        
        this.initShadows();
        this.initCharacters();
        this.initCannon();
        this.initCannonBalls();
        this.initShellPos();
        this.initShellColors();
        
        Global.gameLevel = 0;
        numberTapToNextRound = 0;
        remainTapToNextRound = 0;
        
        isPrepareShooting = false;
        
        cannon.setCannonStatus(Cannon.kCannonStatus_Idle);
        
        this.initControlLayer();
        
        this.updateGameLevel();
	        
	}
	
	public void  initShadows()
	{
	    s_shadow_cannon = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1550/2, 640/2, 366/2, 28/2));
	    s_shadow_penguin = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1550/2, 610/2, 204/2, 26/2));
	    
	    Global.ss_Character.addChild(s_shadow_cannon);
	    Global.ss_Character.addChild(s_shadow_penguin);
	    
	    s_shadow_penguin.setPosition(CGPoint.ccp(28,12));
	    s_shadow_cannon.setPosition(CGPoint.ccp(90,6));
	}
	
	public void  initShellColors()
	{
	    int ranColor;
	    ranColor = (int) ((Math.random()*65535) % 4);
	    shellColor[0] = ranColor;
	    turtle[0].setColor(ranColor);
	    
	    for(int i = 1 ; i < maxTurtle ; i++){
	        this.setShellColor(i);
	    }
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        ranSecondShellRatio = (int) ((Math.random()*65535) % 100);
	        if(ranSecondShellRatio < SecondLevelShellAppearRatio){
	            ranShellLevel = 2;
	        }else{
	            ranShellLevel = 1;
	        }
	        turtle[i].setShellLevel(ranShellLevel);
	    }
	}
	
	public void  initShellPos()
	{
	    shellMovingSpeed = -10;
	    
	    float shellStartX = 210;
	    float shellStartY = 200;
	    float shellOffsetX = 70;
	    
	    shellFixPosY = shellStartY;
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        shellToFixIdx[i] = i;
	        shellFixPosX[i] = shellStartX + shellOffsetX * i;
	        
	        shellPosX[i] = shellFixPosX[i];
	        shellPosY[i] = shellFixPosY;
	    }
	}
	
	public void  initCharacters()
	{
	    penguin = new Penguin();
	    penguin.setX(25);
	    penguin.setY(14);
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	    penguin.setDelegate(this);
	    
	    maxTurtle = 12;
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i] = new Turtle();
	        turtle[i].setX(10000);
	        turtle[i].setY(10000);
	        turtle[i].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	        turtle[i].setIdNumber(i);
	        turtle[i].setDelegate(this);
	        turtle[i].setBombOutType(Turtle.kTurtleBombOutType_bombOutOffScreen);
	        turtle[i].bombOutOffScreenDirection(Turtle.kBombOutOffScreenDirection_Right);
	    }
	    
	    turtleIdx = 0;
	}
	
	public void  initCannonBalls()
	{
	    maxCannonBall = 8;
	    for(int i = 0 ; i < maxCannonBall ; i++){
	        s_Cannon_Ball[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2,0/2,0/2,0/2));
	        s_Cannon_Ball[i].setPosition(CGPoint.ccp(1000,100000));
	        Global.ss_Character.addChild(s_Cannon_Ball[i],Global.kDeapth_Extra2);
	        
	        cannonBall_isAni[i] = false;
	    }
	    cannonBallIdx = 0;
	}
	
	public void  initCannon()
	{
	    cannon = new Cannon();
	    cannon.setDelegate(this);
	}
	
	public void  manageCannonBalls()
	{
	
	    for(int i = 0 ; i < maxCannonBall ; i++){
	        if(cannonBall_isAni[i]){
	            
	            if(cannonBall_Timer[i] == 0){
	                cannonBall_X[i] = cannon.x() + 20;
	                cannonBall_Y[i] = cannon.y() + 15;
	            }
	            
	            cannonBall_X[i] += 40;
	            cannonBall_Y[i] += 30;
	            
	            cannonBall_Timer[i]++;
	
	            
	            if(cannonBall_Timer[i] == 1){
	                cannonBall_isAni[i] = false;
	                cannonBall_Timer[i] = 0;
	
	                s_Cannon_Ball[i].setPosition(CGPoint.ccp(10000,10000));
	                
	                turtle[turtleIdx].tap2();
	                
	                if((turtle[turtleIdx].hurtTime() == 1 && turtle[turtleIdx].shellLevel() == 1) || (turtle[turtleIdx].hurtTime() == 2 && turtle[turtleIdx].shellLevel() == 2)){
	                    this.rearrageShellPos();
	                    
	                    turtle[turtleIdx].resetHurtTime();
	                    
	                    turtleIdx++;
	                    if(turtleIdx == maxTurtle){
	                        turtleIdx = 0;
	                    }
	                }
	                
	            }
	        }
	    }
	}
	
	public void  manageShells()
	{
	    for(int i = 0 ; i < maxTurtle ; i++){
	            if(shellPosX[i] > shellFixPosX[shellToFixIdx[i]]){
	                shellPosX[i] += shellMovingSpeed;
	            }else{
	                shellPosX[i] = shellFixPosX[shellToFixIdx[i]];
	            }
	            
	        if(turtle[i].status() == Turtle.kTurtleAniStatus_Normal_In){
	            turtle[i].setX(shellPosX[i]);
	            turtle[i].setY(shellPosY[i]);
	        }
	    }
	}
	
	public void  manageWrong()
	{
	    if(isAniWrong){
	        if(wrongTimer == 0){
	            wrongScale = 1;
	        }
	        
	        wrongTimer++;
	        
	        int ranX;
	        int ranY;
	        
	        if(wrongTimer < 20){
	            wrongScale += 0.01;
	        }else{
	            wrongScale -= 0.01;
	        }
	        
	        for(int i = 0 ; i < maxTurtle ; i++){
	            if(wrongTimer < 10 || wrongTimer > 30){
	                ranX = (int) ((Math.random()*65535)% 2 - 1);
	                ranY = (int) ((Math.random()*65535)%2 - 1);
	            }else{
	                ranX = (int) ((Math.random()*65535)% 4 - 2);
	                ranY = (int) ((Math.random()*65535)%4 - 2);
	            }
	            
	            
	            turtle[i].setWholeScale(wrongScale);
	            turtle[i].setX(shellPosX[i] + ranX);
	            turtle[i].setY(shellPosY[i] + ranX);
	        }
	        
	        
	        if(wrongTimer == 40){
	            
	            wrongScale = 1;
	            for(int i = 0 ; i < maxTurtle ; i++){
	                turtle[i].setWholeScale(1.0f);
	                turtle[i].setX(shellPosX[i]);
	                turtle[i].setY(shellPosY[i]);
	            }
	            
	            isAniWrong = false;
	        }
	    }
	}
	
	public void  setShellColor( int _shellIdx)
	{
	    int prevShellIdx;
	    prevShellIdx = _shellIdx - 1;
	    if(prevShellIdx < 0){
	        prevShellIdx = maxTurtle - 1;
	    }
	    
	    int ranColor;
	    boolean hasCollide;
	    
	    do{
	        hasCollide = false;
	        ranColor = (int) ((Math.random()*65535) % 4);
	        
	        if(ranColor == shellColor[prevShellIdx]){
	            hasCollide = true;
	        }
	        
	    }while(hasCollide);
	    
	    shellColor[_shellIdx] = ranColor;
	    turtle[_shellIdx].setColor(ranColor);
	    
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
	    
	    return true;
	}
	
	public void  btnIsTappedInControlLayer( int _btnIdx)
	{
	    if(_btnIdx == 0){
	        this.tapButton(kBtnColor_Brown);
	    }
	    if(_btnIdx == 1){
	        this.tapButton(kBtnColor_Red);
	    }
	    if(_btnIdx == 2){
	        this.tapButton(kBtnColor_Green);
	    }
	    if(_btnIdx == 3){
	        this.tapButton(kBtnColor_Blue);
	    }
	}
	
	public void  manage( float  dt)
	{
	    for ( int i = 0 ; i < maxTurtle ; i++){
	        turtle[i].manage(dt);
	    }
	    
	    penguin.manage();
	    
	    cannon.manage();
	    this.manageCannonBalls();
	    this.manageShells();
	    this.manageWrong();
	    
	    
	    if(Global.isTapWronglyAndDisableBtns){
	    	Global.tapWronglyAndDisableBtnsTimer++;
	        
	        if(Global.tapWronglyAndDisableBtnsTimer == 40){
	        	Global.isTapWronglyAndDisableBtns = false;
	        }
	    }
	}
	
	public void  tapButton( int _btnColor)
	{
	    if(isPrepareShooting){
	        return;
	    }
	    
	    this.updateGameLevel();
	    
	    if(_btnColor == shellColor[turtleIdx]){
	        prepareShootingColor = _btnColor;
	        isPrepareShooting = true;
	        cannon.setCannonStatus(Cannon.kCannonStatus_Shooting);
	        Global.counterForAchivement++;
	    }else{
	        this.tapWrongly();
	    }
	}
	
	public void  setCannonBallTexture( int _cannonColor)
	{
	    if(_cannonColor == kBtnColor_Brown){
	        s_Cannon_Ball[cannonBallIdx].setTextureRect(CGRect.make(504/2, 724/2, 60/2, 58/2));
	    }
	    if(_cannonColor == kBtnColor_Red){
	        s_Cannon_Ball[cannonBallIdx].setTextureRect(CGRect.make(568/2, 724/2, 60/2, 58/2));
	    }
	    if(_cannonColor == kBtnColor_Green){
	        s_Cannon_Ball[cannonBallIdx].setTextureRect(CGRect.make(646/2, 662/2, 60/2, 58/2));
	    }
	    if(_cannonColor == kBtnColor_Blue){
	        s_Cannon_Ball[cannonBallIdx].setTextureRect(CGRect.make(646/2, 724/2, 60/2, 58/2));
	    }
	}
	
	public void  shootCannon( int _cannonColor)
	{
	    cannonBall_isAni[cannonBallIdx] = true;
	    cannonBall_Timer[cannonBallIdx] = 0;
	    
	    cannonBallIdx++;
	    if(cannonBallIdx == maxCannonBall){
	        cannonBallIdx = 0;
	    }
	}
	
	public void  thisTurtleIsBombOutOffScreen( int _turtleIdx)
	{
	    this.setShellColor(_turtleIdx);
	    ranSecondShellRatio = (int) ((Math.random()*65535) % 100);
	    if(ranSecondShellRatio < SecondLevelShellAppearRatio){
	        ranShellLevel = 2;
	    }else{
	        ranShellLevel = 1;
	    }
	    turtle[_turtleIdx].setShellLevel(ranShellLevel);
	}
	
	public void  rearrageShellPos()
	{
	    int firstTempFixIdx;
	    firstTempFixIdx = shellToFixIdx[maxTurtle - 1];
	    
	    for(int j = maxTurtle - 1 ; j >= 1  ; j--){
	        shellToFixIdx[j] = shellToFixIdx[j-1];
	    }
	    shellToFixIdx[0] = firstTempFixIdx;
	}
	
	
	public void  tapWrongly()
	{
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.006;
	        if(comboReduceSpeedAccum < -0.01){
	            comboReduceSpeedAccum = -0.01f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	    
	    Global.uILayer.lostCombo();
	    
	    Global.isTapWronglyAndDisableBtns = true;
	    Global.tapWronglyAndDisableBtnsTimer = 0;
	    
	    isAniWrong = true;
	    wrongTimer = 0;
	    Global.gameRoundFromBegin = 0;
	
	    
	}
	
	public void  cannonShootBall( int _fromId)
	{
	    this.setCannonBallTexture(prepareShootingColor);
	    this.shootCannon(prepareShootingColor);
	    Global.playLayer.setToBombingCannon(cannon.x(),cannon.y());
	    isPrepareShooting = false;
	}
	
	public void  beforeLoseComboWhenComboRemainGoesToZero()
	{
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.006;
	        if(comboReduceSpeedAccum < -0.01){
	            comboReduceSpeedAccum = -0.01f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	
	}

}
