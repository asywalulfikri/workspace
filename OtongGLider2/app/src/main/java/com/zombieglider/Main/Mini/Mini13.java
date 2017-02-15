package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.ControlLayer;
import com.zombieglider.Main.Penguin;
import com.zombieglider.Main.Turtle;


public class Mini13 extends MiniBasic
{
    Penguin penguin;
    Turtle turtle[] = new Turtle[10];
    boolean thisTurtleIsBombShell[] = new boolean[10];
    boolean thisTurtleHasBeenFuckedByPenguin[] = new boolean[10];
    int actualShellIdx[] = new int[10];
    int virtualShellIdx[] = new int[10];
    int acutalShellGenIdx;
    int maxTurtle;
    int lastBombShellIdx;
    int lastShellIdx;
    float shellOffsetX;
    
    int maxScriptShell;
    int scriptShellApply[] = new int[20];
    int scriptShellGenIdx;
    int scriptShellApplying;   //the last script shell
    int scriptShellDetectingIdx; // the fisrt script shell
    int scriptRatio[] = new int[4]; //0 remain same , 1 increase 1, 2 increase 2, 3 random
    int scriptPreApply;
    

    CCSprite s_LeftLeft;
    CCSprite s_Left;
    CCSprite s_RightRight;
    CCSprite s_Right;
    
    CCSprite s_sea[] = new CCSprite[2];
    float seaOffset;
    int seaCurrentIdx;
    int seaNextIdx;
    float seaOffsetXCal;
    float seaRatio;
    float seaPosX[] = new float[2];
    
    
    CCSprite s_bg2[] = new CCSprite[2];
    float bgOffset;
    int bgCurrentIdx;
    int bgNextIdx;
    float bgOffsetXCal;
    float bgRatio;
    float bgPosX[] = new float[2];
    
    CCSprite s_Bubble[] = new CCSprite[15];
    int bubble_Timer[] = new int[15];
    boolean bubble_isAni[] = new boolean[15];
    float bubble_x[] = new float[15];
    float bubble_y[] = new float[15];
    float bubble_vy[] = new float[15];
    float bubble_Opacity[] = new float[15];
    int maxBubbles;
    int bubbleAppearedTimer;
    int currentBubbleAppear;
    
    
    float shellPosX[] = new float[10];
    float shellPosY;
    
    int currentStandShell;
    
    boolean hasNext;
    boolean isGoingToNext;
    
    
    int shellGoingToMoment[] = new int[10];
    int shellLevelGoingToMoment[] = new int[10];
    
    int shell_Check[] = new int[6];
    
    boolean isTappingLeft;
    
    
    boolean isPenguinJumping;
    int isPenguinJumpingTimer;
    float wholeBgOffsetX;
    float wholeBgOffsetXCal;
    
    
    float turtleOriX[] = new float[10];
    float turtleOriY[] = new float[10];
    
    int penguinJump_maxStep;
    int penguinJump_currentStep;
    int penguinJump_finalStep;
    int penguinJump_howmanyStep;
    float penguinJump_jumpY;
    float penguinJump_oriY;
    
    CCSprite s_comboBar_Icon;
    CCSprite s_comboBar_Bar;
    CCSprite s_comboBar_BarLifeLeft;
    CCSprite s_comboBar_BarLife;
    float comboBar_posX;
    float comboBar_posY;
    float comboBar_BarLifeLength;
    float comboRemainPercentage;
    
    
    int bombombombIdx;
    
    boolean isBeingAttack;
    int beingAttackTimer;
    
    boolean isResetPenguin;
    int resetPenguinTimer;
    boolean resetPenguinIsOnOpacity;
    int restPenguinOnOffOpacityTimer;
    int restPenguinOnOffOpacityInterval;
    
    boolean goingToNextJump;
    int goingToNextJump_whichPower;
    
    
    CCSprite s_jumpNotice;
    CCSprite s_jumpTurtle;
    boolean jumpNoticeDisappearing;
    float jumpNoticeOpacity;


	
	public void  updategameLevel()
	{
	    
	    if(scriptShellApplying < 20){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(scriptShellApplying < 60){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(scriptShellApplying < 100){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(scriptShellApplying < 150){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.006;
	    }else if(scriptShellApplying < 170){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.008;
	    }else if(scriptShellApplying < 200){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.01;
	    }else if(scriptShellApplying < 250){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.015;
	    }else if(scriptShellApplying < 300){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.018;
	    }else if(scriptShellApplying < 350){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.02;
	    }else if(scriptShellApplying < 400){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.02;
	    }else if(scriptShellApplying < 450){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.02;
	    }else if(scriptShellApplying < 500){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.022;
	    }else if(scriptShellApplying < 550){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.024;
	    }else if(scriptShellApplying < 600){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.027;
	    }else if(scriptShellApplying < 700){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.03;
	    }else if(scriptShellApplying < 800){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.04;
	    }else if(scriptShellApplying < 900){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.05;
	    }
	    
	    if(scriptShellApplying < 70){
	        scriptRatio[0] = 70;
	        scriptRatio[1] = 100;
	        scriptRatio[2] = 100;
	        scriptRatio[3] = 100;
	    }else if(scriptShellApplying < 450){
	        scriptRatio[0] = 50;
	        scriptRatio[1] = 100;
	        scriptRatio[2] = 100;
	        scriptRatio[3] = 100;
	    }else{
	        scriptRatio[0] = 0;
	        scriptRatio[1] = 0;
	        scriptRatio[2] = 0;
	        scriptRatio[3] = 100;
	        Global.comoboReduceSpeed -= 0.01;
	    }
	    
	    if(comboReduceSpeedAccum < 0){
	        comboReduceSpeedAccum += comboReduceSpeedAccumSpeed/50;  //0.003/30
	    }else{
	        comboReduceSpeedAccum = 0;
	    }
	    
	    if(Global.comoboReduceSpeed < 0.005){
	        Global.comoboReduceSpeed = 0.005;
	    }
	    
	}
	
	public void  manageBg()
	{
	    seaPosX[seaCurrentIdx] -= seaRatio * wholeBgOffsetXCal;
	    seaOffsetXCal = seaRatio * wholeBgOffsetXCal;
	    
	    s_sea[seaCurrentIdx].setPosition(CGPoint.ccp(s_sea[seaCurrentIdx].getPosition().x - seaOffsetXCal, 50));
	    s_sea[seaNextIdx].setPosition(CGPoint.ccp(s_sea[seaCurrentIdx].getPosition().x + seaOffset , 50));
	    
	    if(s_sea[seaCurrentIdx].getPosition().x < -520){
	        if(seaCurrentIdx == 0){
	            seaCurrentIdx = 1;
	            seaNextIdx = 0;
	        }else{
	            seaCurrentIdx = 0;
	            seaNextIdx = 1;
	        }
	    }
	    
	    
	    bgPosX[bgCurrentIdx] -= bgRatio * wholeBgOffsetXCal;
	    bgOffsetXCal = bgRatio * wholeBgOffsetXCal;
	    
	    s_bg2[bgCurrentIdx].setPosition(CGPoint.ccp(s_bg2[bgCurrentIdx].getPosition().x - bgOffsetXCal, 160));
	    s_bg2[bgNextIdx].setPosition(CGPoint.ccp(s_bg2[bgCurrentIdx].getPosition().x + bgOffset , 160));
	    
	    if(s_bg2[bgCurrentIdx].getPosition().x < -480){
	        if(bgCurrentIdx == 0){
	            bgCurrentIdx = 1;
	            bgNextIdx = 0;
	        }else{
	            bgCurrentIdx = 0;
	            bgNextIdx = 1;
	        }
	    }
	}
	
	public Mini13()
	{
		super();
        
        Global.maxTime = 40;
        Global.timeRemain = Global.maxTime;
        Global.timeToBeGained = 4.0f;
        
         maxTurtle = 10;
        penguinJump_maxStep = 4;
        penguinJump_currentStep = 2;
        isBeingAttack = false;
        goingToNextJump = false;
        
        Global.wholeTurtleScaleFromSocurce = (float) (0.435+0.1);
        Global.wholePenguinScaleFromSocurce = 0.5f;
        
        float shellStartX = 70;
        shellOffsetX = 76;
        
        shellPosY = 95;
        for(int i = 0 ; i < maxTurtle ; i++){
            shellPosX[i] = shellStartX + shellOffsetX * i;
        }
    
        isPenguinJumping = false;
        
        this.initCharacters();
        this.initScript();
        this.initExtraGraphics();
        this.initBubbles();
        this.initPowerBar();
        this.updatePowerBar();
        
        maxBubbles = 15;
        bubbleAppearedTimer = 999;
    
        
        numberTapToNextRound = 0;
        remainTapToNextRound = 0;
        
        Global.gameLevel = 0;
        this.updategameLevel();
        
        this.initControlLayer();
	}
	public void  initControlLayer()
	{
	    controlLayer = new ControlLayer();
		this.addChild(controlLayer,Global.kDeapth_Btns);
	    controlLayer.setDelegate(this);
	}
	
	public void  initCharacters()
	{
	    Global.ss_Character.setAnchorPoint(0,0);
	    Global.ss_Character.setOpacity(0);
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i] = new Turtle();
	        turtle[i].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	        turtle[i].setX(99999);
	        turtle[i].setDelegate(this);
	        turtle[i].setIdNumber(i);
	    }
	
	  
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i].setX(shellPosX[i]);
	        turtle[i].setY(shellPosY);
	    }
	    
	      
	    currentStandShell = 0;
	    
	    penguin = new Penguin();
	    penguin.setX(shellPosX[currentStandShell]);
	    penguin.setY(shellPosY+25);
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	
	    penguin.setDelegate(this);
	
	}
	
	public void  initExtraGraphics()
	{
		Global.ss_Extra.setAnchorPoint(0,0);
		Global.ss_Extra.setOpacity(0);
	    s_sea[0] = CCSprite.sprite(Global.ss_Extra.getTexture(),CGRect.make(0/2*Global.g_Scale,128/2*Global.g_Scale,980/2*Global.g_Scale,202/2*Global.g_Scale));
	    s_sea[1] = CCSprite.sprite(Global.ss_Extra.getTexture(),CGRect.make(0/2*Global.g_Scale,128/2*Global.g_Scale,980/2*Global.g_Scale,202/2*Global.g_Scale));
	    
	    if ( s_Left != null ) s_Left.setScaleX(-1/Global.g_Scale);
	    if ( s_LeftLeft != null ) s_LeftLeft.setScaleX(-1/Global.g_Scale);
	    
	    Global.ss_Extra.addChild(s_sea[0]);
	    Global.ss_Extra.addChild(s_sea[1]);
	    s_sea[0].setScale(1.0f/Global.g_Scale);
	    s_sea[1].setScale(1.0f/Global.g_Scale);
	     
	    seaCurrentIdx = 0;
	    seaNextIdx = 1;
	    s_sea[0].setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_sea[1].setAnchorPoint(CGPoint.ccp(0,0.5));
	    
	    
	    seaOffset = 980/2;
	    seaRatio = 1.0f;    
	    
	    seaPosX[0] = 0;
	        
	    
	    s_bg2[0] = CCSprite.sprite("images/Main/mini 04/mini_04_bg.png");
	    s_bg2[1] = CCSprite.sprite("images/Main/mini 04/mini_04_bg.png");
	    
	    this.addChild(s_bg2[0]);
	    this.addChild(s_bg2[1]);
	    s_bg2[0].setScale(1.0f/Global.g_Scale);
	    s_bg2[1].setScale(1.0f/Global.g_Scale);
	    bgCurrentIdx = 0;
	    bgNextIdx = 1;
	    s_bg2[0].setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_bg2[1].setAnchorPoint(CGPoint.ccp(0,0.5));
	    
	    
	    bgOffset = 960/2 - 2;
	    bgRatio = 0.05f;    
	    
	    bgPosX[0] = 0;
	    
	}
	
	public void  initBubbles()
	{
	    
	    for(int i = 0 ; i < maxBubbles ; i++){
	        s_Bubble[i] = CCSprite.sprite(Global.ss_Extra.getTexture(),CGRect.make(304/2*Global.g_Scale,0/2*Global.g_Scale,31/2*Global.g_Scale,31/2*Global.g_Scale));
	        
	        Global.ss_Extra.addChild(s_Bubble[i]);
	        s_Bubble[i].setScale(1.0f/Global.g_Scale);
	        s_Bubble[i].setPosition(CGPoint.ccp(10000,10000));
	    }
	}
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    return super.ccTouchesBegan(event);
	}
	
	public void  manageBubbles()
	{
	    if(bubbleAppearedTimer > 40){
	        if((Math.random()*65535) % 70 == 0){
	            int bubbleAppearX;
	            bubbleAppearX = (int) ((Math.random()*65535)%480);
	            
	            int bubbleRanVy;
	            bubbleRanVy = (int) ((Math.random()*65535)%100);
	            bubble_vy[currentBubbleAppear] = (float) (0.2 + 0.6 * (float)bubbleRanVy/100.0);
	            
	            bubble_x[currentBubbleAppear] = bubbleAppearX;
	            bubble_y[currentBubbleAppear] = -20;
	            bubble_Opacity[currentBubbleAppear] = 255;
	            bubble_Timer[currentBubbleAppear] = 0;
	            bubble_isAni[currentBubbleAppear] = true;
	            
	            currentBubbleAppear++;
	            if(currentBubbleAppear >= 15){
	                currentBubbleAppear = 0;
	            }
	            
	            int bubbleRanScale;
	            bubbleRanScale = (int) ((Math.random()*65535)%100);
	            s_Bubble[currentBubbleAppear].setScale(1.0f/Global.g_Scale*(float) (0.3+0.55*(float)bubbleRanScale/100));
	        }
	    }
	    
	    bubbleAppearedTimer++;
	    
	    for(int i = 0 ; i < maxBubbles ; i++){
	        if(bubble_isAni[i]){
	            s_Bubble[i].setPosition(CGPoint.ccp(bubble_x[i], bubble_y[i]));
	            s_Bubble[i].setOpacity(bubble_Opacity[i]);
	            
	            bubble_y[i] += bubble_vy[i];
	            
	            if(bubble_y[i] < 20){
	                bubble_Opacity[i] -= 0;
	            }else  if(bubble_y[i] < 50){
	                bubble_Opacity[i] -= 2;
	            }else  if(bubble_y[i] < 75){
	                bubble_Opacity[i] -= 4;
	            }else  if(bubble_y[i] < 1000){
	                bubble_Opacity[i] -= 6;
	            }
	            
	            if(bubble_Opacity[i] < 0){
	                bubble_Opacity[i] = 0;
	                
	                bubble_isAni[i] = false;
	                
	                s_Bubble[i].setPosition(CGPoint.ccp(10000, 10000));
	            }
	            
	        }
	    }
	    
	}
	
	
	public void  setExternalValues( float _offsetFinalX)
	{
	    return;
	}
	
	public void  btnIsTappedInControlLayer( int _btnIdx)
	{
	    if(_btnIdx == 0){
	        
	        penguinJump_currentStep--;
	        if(penguinJump_currentStep < 1){
	            penguinJump_currentStep = penguinJump_maxStep - 1;
	        }
	        this.updatePowerBar();
	    }
	    if(_btnIdx == 1){
	            
	        penguinJump_currentStep++;
	        if(penguinJump_currentStep == penguinJump_maxStep){
	            penguinJump_currentStep = 1;
	        }
	        this.updatePowerBar();
	        
	    }
	    
	    if(_btnIdx == 2){
	        if(Global.isTapWronglyAndDisableBtns){
	            return;
	        }
	        
	        this.setPenguinJumping();
	    }
	}
	
	public void  btnIsReleasedInControlLayer( int _btnIdx)
	{
	
	}
	
	public void  manage( float  dt)
	{
	    
	    wholeBgOffsetXCal = 0;
	    
	    this.manageMini04Type(dt);
	
	    
	    penguin.manage();
	    this.managePenguinJumping();
	    this.manageBubbles();
	    this.managePenguinDieing();
	    this.manageResetPenguin();
	    
	    this.runTurtleAI();
	    
	    for ( int i = 0 ; i < maxTurtle ; i++){
	        turtle[i].manage(dt);
	        turtle[i].manageYellowHurt();
	    }
	    
	    this.manageBg();
	    this.manageJumpNotice();
	
	}
	
	
	public void  tapTurtleDelay()
	{
	    int detectWHichTurtleIsCurentStanding = 0;
	    for(int i = 0 ; i < maxTurtle ; i++){
	        if(turtle[i].x() - shellPosX[0] < 5 && turtle[i].x() - shellPosX[0] > -5){
	            detectWHichTurtleIsCurentStanding = i;
	        }
	    }
	    
	    if(!thisTurtleIsBombShell[detectWHichTurtleIsCurentStanding]){
	        turtle[detectWHichTurtleIsCurentStanding].tap();
	        thisTurtleHasBeenFuckedByPenguin[detectWHichTurtleIsCurentStanding] = true;
	        Global.gameRound++;
	        Global.counterForAchivement++;
	    }else{
	        this.bombTurtleByThisBombShell(detectWHichTurtleIsCurentStanding);
	    }
	    
	    
	    if(Global.gameRound == 0){
	    	Global.gameRound = 1;
	    }
	    
	    this.updategameLevel();
	}
	
	public void  initScript()
	{
	    acutalShellGenIdx = 0;
	    
	    thisTurtleHasBeenFuckedByPenguin[0] = false;
	    thisTurtleIsBombShell[0] = true;
	    actualShellIdx[0] = acutalShellGenIdx;
	    virtualShellIdx[0] = 0;
	    acutalShellGenIdx++;
	    lastShellIdx = maxTurtle - 1;
	    
	    for(int i = 1 ; i < maxTurtle ; i++){
	        thisTurtleIsBombShell[i] = true;
	        thisTurtleHasBeenFuckedByPenguin[i] = false;
	        turtle[i].changeToBombShell();
	        actualShellIdx[i] = acutalShellGenIdx;
	        virtualShellIdx[i] = i;
	        acutalShellGenIdx++;
	    }
	    
	    maxScriptShell = 20;
	    for(int i = 0 ; i < maxScriptShell ; i++){
	        scriptShellApply[i] = -1;
	    }
	    
	    
	    
	    scriptShellDetectingIdx = 1;
	    this.giveNextMoment222(2);
	     scriptShellGenIdx++;
	
	    
	    scriptShellDetectingIdx = 2;
	    this.giveNextMoment222(4);
	     scriptShellGenIdx++;
	    
	    scriptShellDetectingIdx = 3;
	    this.giveNextMoment222(7);
	     scriptShellGenIdx++;
	    
	    scriptShellDetectingIdx = 4;
	    this.giveNextMoment222(8);
	    scriptShellGenIdx++;
	    
	    
	    scriptShellDetectingIdx = 5;
	    this.giveNextMoment222(9);
	    scriptShellGenIdx++;
	    
	    scriptShellApplying = 9;
	    scriptPreApply = 1;
	}
	
	public void  genNextScript()
	{
	    while (scriptShellApplying -actualShellIdx[currentStandShell] < 20) {
	        int ranNextShell;
	        ranNextShell = (int) ((Math.random()*65535)%3);
	        ranNextShell += 1;
	        
	        int scriptRanRatio;
	        scriptRanRatio = (int) ((Math.random()*65535) % 100);
	        
	        if(scriptRanRatio < scriptRatio[0]){
	            ranNextShell = scriptPreApply;
	        }else  if(scriptRanRatio < scriptRatio[1]){
	            int calNextApply;
	            calNextApply = scriptPreApply + 1;
	            if(calNextApply == 4){
	                calNextApply = 1;
	            }
	            ranNextShell = calNextApply;
	        }else  if(scriptRanRatio < scriptRatio[2]){
	            int calNextApply;
	            calNextApply = scriptPreApply + 2;
	            if(calNextApply >= 4){
	                calNextApply -= 3;
	            }
	            ranNextShell = calNextApply;
	        }
	        
	        scriptShellApplying += ranNextShell;
	        scriptPreApply = ranNextShell;
	        
	        scriptShellApply[scriptShellGenIdx] = scriptShellApplying;
	        
	        scriptShellGenIdx++;
	        if(scriptShellGenIdx == maxScriptShell){
	            scriptShellGenIdx = 0;
	        }
	    }
	    
	    int futureShellPos;
	    futureShellPos = 6;
	    for(int i = 0 ; i < maxTurtle ; i++)
	    {
	        if(turtle[i].x() < -20){ 
	            virtualShellIdx[i] = futureShellPos;
	            actualShellIdx[i] = acutalShellGenIdx;
	            thisTurtleHasBeenFuckedByPenguin[i] = false;
	            
	            turtle[i].setX(turtle[lastShellIdx].x() + shellOffsetX);
	            
	            lastShellIdx = i;
	            
	            acutalShellGenIdx++;
	            futureShellPos++;
	            
	            if(actualShellIdx[i] == scriptShellApply[scriptShellDetectingIdx]){
	                this.giveNextMoment222(i);
	                thisTurtleIsBombShell[i] = false;
	                
	                scriptShellDetectingIdx++;
	                if(scriptShellDetectingIdx == maxScriptShell){
	                    scriptShellDetectingIdx = 0;
	                }
	                
	            }else{
	                turtle[i].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	                turtle[i].changeToBombShell();
	                thisTurtleIsBombShell[i] = true;
	            }
	        }
	    }
	}
	
	public void  bombTurtleByThisBombShell( int _shellIdx)
	{
		Global.playLayer.setToBombing(turtle[_shellIdx].x(),turtle[_shellIdx].y());
	    bombombombIdx = _shellIdx;
	    this.bombombomb();
	}
	
	
	public void  runTurtleAI()
	{
	    for(int i = 0 ; i < maxTurtle ; i++){
	        if(turtle[i].status() != Turtle.kTurtleAniStatus_Bombing && !thisTurtleHasBeenFuckedByPenguin[i]){
	            if(Global.gameRound == 0 && i == 0){
	                
	            }else{
	                turtle[i].setStatus(Turtle.kTurtleAniStatus_Idle);
	            }
	        }
	    }
	}
	
	
	public void  thisMomentOverTime( int _momentIdx)
	{
	
	}
	
	
	public void  giveNextMoment()
	{
	    return;
	}
	
	public void  getScript()
	{
	    nextMomentAppearTime = 400000;
	}
	
	
	
	
	public void  turtleBombed( int _momentIdx)
	{
	    super.turtleBombed(_momentIdx);
	    
	}
	
	public void  giveNextMoment222( int _whichShell)
	{
	    turtle[_whichShell].setStatus(Turtle.kTurtleAniStatus_Out);
	    turtle[_whichShell].setShellLevel(0);
	    thisTurtleIsBombShell[_whichShell] = false;
	}
	
	public void  setPenguinJumping()
	{
	    if(isPenguinJumping){
	        goingToNextJump_whichPower = penguinJump_currentStep;
	        penguin.setNext(Penguin.kPenguinJump_jumpToDYNAMICTurtleShell,true);
	        return;
	    }
	    
	    if(!goingToNextJump){
	        penguinJump_finalStep = penguinJump_currentStep;
	    }else{
	        penguinJump_finalStep = goingToNextJump_whichPower;
	    }
	    
	    
	    Global.penguinJumpFinalX = penguin.x();
	    Global.penguinJumpFinalY = penguin.y();
	     
	    Global.penguin_DynmaicJumpY = 25 * penguinJump_finalStep;
	    penguin.setJump(Penguin.kPenguinJump_jumpToDYNAMICTurtleShell);
	    
	    
	    if(!goingToNextJump){
	        currentStandShell += penguinJump_currentStep;
	    }else{
	        currentStandShell += goingToNextJump_whichPower;
	    }
	    
	    if(currentStandShell >= maxTurtle){
	        currentStandShell -= maxTurtle;
	    }
	    
	    isPenguinJumping = true;
	    isPenguinJumpingTimer = 0;
	    wholeBgOffsetX = 0;
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtleOriX[i] = turtle[i].x();
	        turtleOriY[i] = turtle[i].y();
	    }
	    
	    penguinJump_howmanyStep = 9;
	    penguinJump_jumpY = 0;
	    penguinJump_oriY = penguin.y();
	}
	
	public void  gotoNextJump()
	{
	    goingToNextJump = true;
	}
	
	public void  managePenguinJumping()
	{
	    if(isPenguinJumping){
	        wholeBgOffsetXCal = (float) ((76.0/9.0) * penguinJump_finalStep);
	        wholeBgOffsetX -= wholeBgOffsetXCal;
	        for(int i = 0 ; i < maxTurtle ; i++){
	            turtle[i].setX(turtleOriX[i] + wholeBgOffsetX);
	        }
	    
	        isPenguinJumpingTimer++;
	        if(isPenguinJumpingTimer == penguinJump_howmanyStep){
	            isPenguinJumping = false;
	            for(int i = 0 ; i < maxTurtle ; i++){
	                if(turtle[i].x() - shellPosX[i] < 5 && turtle[i].x() - shellPosX[i] > -5){
	                	turtle[i].setX(shellPosX[i]);
	                	turtle[i].setY(shellPosY);	                    
	                }
	            }
	            
	            this.updategameLevel();
	            this.genNextScript();
	            penguin.setY(penguinJump_oriY);
	            this.tapTurtleDelay();
	            
	            if(goingToNextJump){
	                this.setPenguinJumping();
	                goingToNextJump = false;
	            }
	        }
	    }
	}
	
	
	public void  initPowerBar()
	{
	    //INIT POWER BAR
	    s_comboBar_Icon = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(2000/2*Global.g_Scale, 260/2*Global.g_Scale, 32/2*Global.g_Scale, 30/2*Global.g_Scale));
	    s_comboBar_Bar = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1298/2*Global.g_Scale, 320/2*Global.g_Scale, 136/2*Global.g_Scale, 22/2*Global.g_Scale));
	    s_comboBar_BarLife = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1186/2*Global.g_Scale, 320/2*Global.g_Scale, 109/2*Global.g_Scale, 22/2*Global.g_Scale));
	    s_comboBar_BarLifeLeft = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1170/2*Global.g_Scale, 320/2*Global.g_Scale, 14/2*Global.g_Scale, 22/2*Global.g_Scale));
	    
	    s_comboBar_Bar.setRotation(-90);
	    s_comboBar_BarLife.setRotation(-90);
	    s_comboBar_BarLifeLeft.setRotation(-90);
	    
	    s_comboBar_Bar.setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_comboBar_BarLife.setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_comboBar_BarLifeLeft.setAnchorPoint(CGPoint.ccp(1,0.5));
	    
	    Global.ss_Character.addChild(s_comboBar_Bar,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_BarLife,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_BarLifeLeft,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_Icon,Global.kDeapth_Top);
	    
	    s_comboBar_Bar.setScale(1.0f/Global.g_Scale);
	    s_comboBar_BarLife.setScale(1.0f/Global.g_Scale);
	    s_comboBar_BarLifeLeft.setScale(1.0f/Global.g_Scale);
	    s_comboBar_Icon.setScale(1.0f/Global.g_Scale);
	    
	    comboBar_posX = 40;
	    comboBar_posY = 125;
	    
	    comboBar_BarLifeLength = 109/2;
	    comboRemainPercentage = 0;
	    Global.comboRemain = 0;
	    
	    s_comboBar_Bar.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_BarLife.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_BarLifeLeft.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_Icon.setPosition(CGPoint.ccp(10000,100000));
	    
	    s_comboBar_BarLife.setScaleX(0);
	    
	    s_jumpTurtle = CCSprite.sprite(Global.ss_Extra.getTexture(),CGRect.make(650/2*Global.g_Scale,0/2*Global.g_Scale,152/2*Global.g_Scale,20/2*Global.g_Scale));
	    s_jumpNotice = CCSprite.sprite(Global.ss_Extra.getTexture(),CGRect.make(810/2*Global.g_Scale,0/2*Global.g_Scale,84/2*Global.g_Scale,48/2*Global.g_Scale));
	    
	    s_jumpNotice.setAnchorPoint(CGPoint.ccp(0,0));
	    s_jumpTurtle.setAnchorPoint(CGPoint.ccp(0,0));
	    
	    s_jumpTurtle.setPosition(CGPoint.ccp(120-10,10));
	    s_jumpNotice.setPosition(CGPoint.ccp(127-10,20));
	    
	     Global.ss_Extra.addChild(s_jumpTurtle);
	     Global.ss_Extra.addChild(s_jumpNotice);
	     s_jumpTurtle.setScale(1.0f/Global.g_Scale);
	     s_jumpNotice.setScale(1.0f/Global.g_Scale);
	    jumpNoticeOpacity = 255;
	    jumpNoticeDisappearing = false;
	    
	}
	
	public void  updatePowerBar()
	{
	
	    comboRemainPercentage = (float) (((float)penguinJump_currentStep-1.0)/((float)penguinJump_maxStep-2.0));
	    
	    s_comboBar_Icon.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY +  + comboBar_BarLifeLength * comboRemainPercentage));
	    s_comboBar_BarLifeLeft.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY));
	    s_comboBar_Bar.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY-7));
	    s_comboBar_BarLife.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY));
	    
	    s_comboBar_BarLife.setScaleX(comboRemainPercentage/Global.g_Scale);
	    
	    if(penguinJump_currentStep == 1){
	        s_jumpNotice.setTextureRect(CGRect.make(810/2*Global.g_Scale,52/2*Global.g_Scale,50/2*Global.g_Scale,28/2*Global.g_Scale));
	    }
	    if(penguinJump_currentStep == 2){
	        s_jumpNotice.setTextureRect(CGRect.make(810/2*Global.g_Scale,0/2,94/2*Global.g_Scale,48/2*Global.g_Scale));
	    }
	    if(penguinJump_currentStep == 3){
	        s_jumpNotice.setTextureRect(CGRect.make(650/2*Global.g_Scale,30/2*Global.g_Scale,130/2*Global.g_Scale,64/2*Global.g_Scale));
	    }
	    
	}
	
	public void  manageJumpNotice()
	{
	    if(jumpNoticeDisappearing){
	        jumpNoticeOpacity -= 1.5;
	        if(jumpNoticeOpacity < 0){
	            jumpNoticeOpacity = 0;
	        }
	        
	        s_jumpNotice.setOpacity(jumpNoticeOpacity);
	        s_jumpTurtle.setOpacity(jumpNoticeOpacity);
	    }
	}
		
	public void  bombombomb()
	{
		Global.uILayer.lostCombo();
	    
		Global.isTapWronglyAndDisableBtns = true;
	    
	    isBeingAttack  = true;
	    beingAttackTimer = 200;
	    
	    Global.playLayer.setToBombingGameoverWithPos((int) turtle[bombombombIdx].x(),90);
	    penguin.bombOutOffScreenDirection(Penguin.kBombOutOffScreenDirection_Right_Penguin);
	    penguin.setToBombing();
	    
	    Global.musicController.playThisSound(Global.kSound_TurtleExplode03,false,1.0);
	    
	    
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.005;
	        if(comboReduceSpeedAccum < -0.01){
	            comboReduceSpeedAccum = -0.01f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	}
	
	public void  managePenguinDieing()
	{
	    if(isBeingAttack){
	        beingAttackTimer--;
	        if(beingAttackTimer == 0){
	            isBeingAttack = false;
	        }
	        
	        if(beingAttackTimer == 130){
	            this.resetPenguin();
	            turtle[bombombombIdx].changeToNormalShell();
	            Global.playLayer.setToBombing(turtle[bombombombIdx].x(),turtle[bombombombIdx].y());
	            Global.currentCombo = 0;
	        }
	    }
	}
	
	public void  resetPenguin()
	{
	    resetPenguinTimer = 0;
	    restPenguinOnOffOpacityTimer = 0;
	    resetPenguinIsOnOpacity = true;
	    isResetPenguin = true;
	    
	    penguin.setX(shellPosX[0]);
	    penguin.setY(shellPosY+20);
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	    
	    Global.isTapWronglyAndDisableBtns = false;
	}
	
	public void  manageResetPenguin()
	{
	    if(!isResetPenguin){
	        return;
	    }
	    
	    if(resetPenguinTimer < 10){
	        restPenguinOnOffOpacityInterval = 6;
	    }else if(resetPenguinTimer < 20){
	        restPenguinOnOffOpacityInterval = 4;
	    }if(resetPenguinTimer < 30){
	        restPenguinOnOffOpacityInterval = 3;
	    }
	    
	    restPenguinOnOffOpacityTimer++;
	    if(restPenguinOnOffOpacityTimer > restPenguinOnOffOpacityInterval){
	        restPenguinOnOffOpacityTimer = 0;
	        resetPenguinIsOnOpacity = !resetPenguinIsOnOpacity;
	    }
	    
	    if(resetPenguinIsOnOpacity){
	        penguin.setOpacity(255);
	    }else{
	        penguin.setOpacity(0);
	    }
	    
	    if(resetPenguinTimer == 30){
	        isResetPenguin = false;
	        penguin.setOpacity(255);
	    }
	    
	    resetPenguinTimer++;
	}
	
	
	public void  beforeLoseComboWhenComboRemainGoesToZero()
	{
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.006;
	        if(comboReduceSpeedAccum < -0.015){
	            comboReduceSpeedAccum = -0.015f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	    
	}
	
	public void  fuckfuck()
	{
	    jumpNoticeDisappearing = true;
	}
	

}
