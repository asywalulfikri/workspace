package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.ControlLayer;
import com.zombieglider.Main.Penguin;
import com.zombieglider.Main.Turtle;

public class Mini04 extends MiniBasic
{
    Turtle turtle[] = new Turtle[6];
    Penguin penguin;
    
    CCSprite s_sea;
    CCSprite s_LeftLeft;
    CCSprite s_Left;
    CCSprite s_RightRight;
    CCSprite s_Right;
    
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
    
    
    float shellPosX[] = new float[6];
    float shellPosY;
    
    int currentStandShell;
    
    boolean hasNext;
    boolean isGoingToNext;
    
    float seaOffestX;
    float seaOffsestFinalX;
    
    int shellGoingToMoment[] = new int[6];
    int shellLevelGoingToMoment[] = new int[6];
    
     int shell_Check[] = new int[6];
    
	
	
	public void  reInitColorComboLimit()
	{
	    if(Global.gameLevel == 0){
	        Global.comboColorLimit[0] = 0;
	        Global.comboColorLimit[1] = 10;
	        Global.comboColorLimit[2] = 20;
	        Global.comboColorLimit[3] = 30;
	        Global.comboColorLimit[4] = 40;
	        Global.comboColorLimit[5] = 50;
	        Global.comboColorLimit[6] = 60;
	        Global.comboColorLimit[7] = 70;
	        Global.comboColorLimit[8] = 80;
	        Global.comboColorLimit[9] = 90;
	        Global.comboColorLimit[10] = 100;
	        Global.timeToBeGained = 5.0f;
	    }
	    
	    if(Global.gameLevel == 1){
	        Global.comboColorLimit[0] = 0;
	        Global.comboColorLimit[1] = 15;
	        Global.comboColorLimit[2] = 30;
	        Global.comboColorLimit[3] = 45;
	        Global.comboColorLimit[4] = 60;
	        Global.comboColorLimit[5] = 75;
	        Global.comboColorLimit[6] = 90;
	        Global.comboColorLimit[7] = 105;
	        Global.comboColorLimit[8] = 120;
	        Global.comboColorLimit[9] = 135;
	        Global.comboColorLimit[10] = 150;
	        Global.timeToBeGained = 4.5f;
	    }
	    
	    if(Global.gameLevel == 2){
	        Global.comboColorLimit[0] = 0;
	        Global.comboColorLimit[1] = 15;
	        Global.comboColorLimit[2] = 30;
	        Global.comboColorLimit[3] = 45;
	        Global.comboColorLimit[4] = 60;
	        Global.comboColorLimit[5] = 75;
	        Global.comboColorLimit[6] = 90;
	        Global.comboColorLimit[7] = 105;
	        Global.comboColorLimit[8] = 120;
	        Global.comboColorLimit[9] = 135;
	        Global.comboColorLimit[10] = 150;
	         Global.timeToBeGained = 4.5f;
	    }
	}
	
	public void  updateGameLevel()
	{
	    if(Global.gameRound < 10){
	        Global.gameLevel = 0;
	    }else if(Global.gameRound < 50){
	        Global.gameLevel = 1;
	    }else if(Global.gameRound < 80){
	        Global.gameLevel = 2;
	    }else if(Global.gameRound < 100){
	        Global.gameLevel = 3;
	    }else if(Global.gameRound < 135){
	        Global.gameLevel = 4;
	    }else if(Global.gameRound < 170){
	        Global.gameLevel = 5;
	    }else if(Global.gameRound < 200){
	        Global.gameLevel = 6;
	    }else if(Global.gameRound < 10000){
	        Global.gameLevel = 7;
	    }
	    
	    if(Global.gameRound < 20){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(Global.gameRound < 60){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(Global.gameRound < 100){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(Global.gameRound < 150){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(Global.gameRound < 170){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.005;
	    }else if(Global.gameRound < 200){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.006;
	    }else if(Global.gameRound < 250){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.008;
	    }else if(Global.gameRound < 300){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.01;
	    }else if(Global.gameRound < 350){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.012;
	    }else if(Global.gameRound < 400){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.015;
	    }else if(Global.gameRound < 450){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.02;
	    }else if(Global.gameRound < 500){
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.03;
	    }
	    
	    if(comboReduceSpeedAccum < 0){
	        comboReduceSpeedAccum += comboReduceSpeedAccumSpeed/50;  //0.003/30
	    }else{
	        comboReduceSpeedAccum = 0;
	    }
	    
	    if(Global.comoboReduceSpeed < 0.005){
	        Global.comoboReduceSpeed = 0.005;
	    }
	    
	    this.reInitColorComboLimit();
	    
	}
	
	
	
	public void  restart()
	{
	    for(int i = 0 ; i < maxMoment ; i++){
	        if(momentRunTime[i] > 0){
	            turtle[momentTarget[i]].setStatus(Turtle.kTurtleAniStatus_In);
	            momentRunTime[i] = -9999;
	        }
	    }
	    
	    numberTapToNextRound = 0;
	    remainTapToNextRound = 0;
	    
	    recentMomentIdx = 0;
	    
	    super.restart();
	}
	
	public void  initControlLayer()
	{
	    controlLayer = new ControlLayer();
		this.addChild(controlLayer,Global.kDeapth_Btns);
	    controlLayer.setDelegate(this);
	}
	
	public Mini04()
	{
		super();
	        
        Global.maxTime = 60;
        Global.timeRemain = Global.maxTime;
        
        s_bg = CCSprite.sprite("images/Main/mini 04/mini_04_bg.png");
        s_bg.setPosition(CGPoint.ccp(240,160));
        s_bg.setScale( 1.0f/Global.g_Scale );
		this.addChild(s_bg);
        
        if(Global.isIphone5){
            CCSprite  s_temp_bg = CCSprite.sprite("images/Main/mini 04/mini_04_bg.png");
            s_temp_bg.setPosition(CGPoint.ccp(479,160));
            s_temp_bg.setAnchorPoint(CGPoint.ccp(1,0.5));
            s_temp_bg.setScaleX(-1);
            this.addChild(s_temp_bg);
        }
        
        Global.wholeTurtleScaleFromSocurce = 0.435f;
        Global.wholePenguinScaleFromSocurce = 0.5f;
        
        float shellStartX = 45;
        float shellOffsetX = 76;
        
        if(Global.isIphone5){
            shellStartX = 45 + 44;
        }
        shellPosY = 117;
        shellPosX[0] = shellStartX + shellOffsetX*0;
        shellPosX[1] = shellStartX + shellOffsetX*1;
        shellPosX[2] = shellStartX + shellOffsetX*2;
        shellPosX[3] = shellStartX + shellOffsetX*3;
        shellPosX[4] = shellStartX + shellOffsetX*4;
        shellPosX[5] = shellStartX + shellOffsetX*5;
        
        this.initCharacters();
        this.initExtraGraphics();
        this.initBubbles();
        
        maxBubbles = 15;
        bubbleAppearedTimer = 999;
        
        Global.maxTurtleOnScreen = 3;
        
        numberTapToNextRound = 0;
        remainTapToNextRound = 0;
        
        Global.gameLevel = 0;
        this.updateGameLevel();
        
        this.initControlLayer();
	    
	}
	
	public void  initCharacters()
	{
	    turtle[0] = new Turtle();
	    turtle[1] = new Turtle();
	    turtle[2] = new Turtle();
	    turtle[3] = new Turtle();
	    turtle[4] = new Turtle();
	    turtle[5] = new Turtle();
	    
	    float startX = 47;
	    float startY = 95;
	    float offsetX = 76;
	    float offsetY = 0;
	    
	    if(Global.isIphone5){
	        startX += 44;
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
	    
	    turtle[3].setX(startX + offsetX*3);
	    turtle[3].setY(startY);
	    turtle[3].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[4].setX(startX + offsetX*4);
	    turtle[4].setY(startY+offsetY);
	    turtle[4].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    turtle[5].setX(startX + offsetX*5);
	    turtle[5].setY(startY+offsetY);
	    turtle[5].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	    
	    
	    currentStandShell = 2;
	    
	    penguin = new Penguin();
	    penguin.setX( shellPosX[currentStandShell]);
	    penguin.setY(shellPosY);
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	    
	    turtle[0].setDelegate(this);
	    turtle[1].setDelegate(this);
	    turtle[2].setDelegate(this);
	    turtle[3].setDelegate(this);
	    turtle[4].setDelegate(this);
	    turtle[5].setDelegate(this);
	    penguin.setDelegate(this);
	    
	    turtle[0].setIdNumber(0);
	    turtle[1].setIdNumber(1);
	    turtle[2].setIdNumber(2);
	    turtle[3].setIdNumber(3);
	    turtle[4].setIdNumber(4);
	    turtle[5].setIdNumber(5);
	}
	
	public void  initExtraGraphics()
	{
	    s_sea = CCSprite.sprite(Global.ss_Extra.getTexture(),CGRect.make(0/2*Global.g_Scale,128/2*Global.g_Scale,1060/2*Global.g_Scale,202/2*Global.g_Scale));

	    Global.ss_Extra.setAnchorPoint(0,0);
	    Global.ss_Extra.setOpacity(0);
	    Global.ss_Extra.addChild(s_sea);
	    
	    s_sea.setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_sea.setScale( 1.0f/Global.g_Scale );
	    s_sea.setPosition(CGPoint.ccp(0,50));
	    
	    if(Global.isIphone5){
	        s_sea.setScaleX(1.1);
	    }
	}
	
	public void  initBubbles()
	{
	    maxBubbles = 15;
	    
	    for(int i = 0 ; i < maxBubbles ; i++){
	        s_Bubble[i] = CCSprite.sprite(Global.ss_Extra.getTexture(),CGRect.make(304/2*Global.g_Scale,0/2*Global.g_Scale,31/2*Global.g_Scale,31/2*Global.g_Scale));
	        s_Bubble[i].setScale( 1.0f / Global.g_Scale );
	        Global.ss_Extra.addChild(s_Bubble[i]);
	        
	        s_Bubble[i].setPosition(CGPoint.ccp(10000,10000));
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
	    
	    return true;
	    
	}
	
	public void  manageBubbles()
	{
	    if(bubbleAppearedTimer > 40){
	        if((Math.random()*65535) % 70 == 0){
	            int bubbleAppearX;
	            
	            if(Global.isIphone5){
	                 bubbleAppearX = (int) ((Math.random()*65535)%480);
	            }else{
	                 bubbleAppearX = (int) ((Math.random()*65535)%480);
	            }
	           
	            
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
	            s_Bubble[currentBubbleAppear].setScale((float) (0.3+0.55*(float)bubbleRanScale/100));
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
	     seaOffsestFinalX = _offsetFinalX;
	    for(int i = 0 ; i < 6 ; i++){
	        turtle[i].setExternalOffsetFinalX(-seaOffsestFinalX);
	    }
	    penguin.setExternalOffsetFinalX(-seaOffsestFinalX);
	}
	
	public void  btnIsTappedInControlLayer( int _btnIdx)
	{
	    if(_btnIdx == 0){
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	            currentStandShell-=2;
	            if(currentStandShell<0){
	                currentStandShell = 0;
	            }
	            Global.penguinJumpFinalX = shellPosX[currentStandShell];
	            Global.penguinJumpFinalY = shellPosY;
	            penguin.setFacingRight(false);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo2TurtleShell);
	            
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo2TurtleShell,false);
	        }
	    }
	    if(_btnIdx == 1){
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	            currentStandShell--;
	            if(currentStandShell<0){
	                currentStandShell = 0;
	            }
	            
	            Global.penguinJumpFinalX = shellPosX[currentStandShell];
	            Global.penguinJumpFinalY = shellPosY;
	            penguin.setFacingRight(false);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo1TurtleShell);
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo1TurtleShell,false);
	        }
	    }
	    if(_btnIdx == 2){
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	            currentStandShell++;
	            if(currentStandShell > 5){
	                currentStandShell = 5;
	            }
	            
	            Global.penguinJumpFinalX = shellPosX[currentStandShell];
	            Global.penguinJumpFinalY = shellPosY;
	            penguin.setFacingRight(true);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo1TurtleShell);
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo1TurtleShell,true);
	        }
	    }
	    if(_btnIdx == 3){
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	            currentStandShell+=2;
	            if(currentStandShell > 5){
	                currentStandShell = 5;
	            }
	            
	            Global.penguinJumpFinalX = shellPosX[currentStandShell];
	            Global.penguinJumpFinalY = shellPosY;
	            penguin.setFacingRight(true);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo2TurtleShell);
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo2TurtleShell,true);
	        }
	    }
	}
	
	public void  manage( float  dt)
	{
	    this.manageRemainTapToNextStep();
	    
	    this.manageMini04Type(dt);
	    
	    if(isGoingToNext){
	        this.gotoNextDelayOneStep();
	    }
	    
	    penguin.manage();
	    this.manageBubbles();
	    
	    this.runTurtleAI();
	        
	        for ( int i = 0 ; i < 6 ; i++){
	            turtle[i].manage(dt);
	        }
	    
	    
	    
	    seaOffestX += (seaOffsestFinalX - seaOffestX)/100;
	    s_sea.setPosition(CGPoint.ccp(seaOffestX, 50));
	    
	}
	
	public void  gotoNextJump()
	{
	    if(Global.next_isFacingRight){
	        
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo1TurtleShell){
	            currentStandShell++;
	            if(currentStandShell > 5){
	                currentStandShell = 5;
	            }
	        }
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo2TurtleShell){
	            currentStandShell+=2;
	            if(currentStandShell > 5){
	                currentStandShell = 5;
	            }
	        }
	        
	        Global.penguinJumpFinalX = shellPosX[currentStandShell];
	        Global.penguinJumpFinalY = shellPosY;
	    }else{
	        
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo1TurtleShell){
	            currentStandShell--;
	            if(currentStandShell<0){
	                currentStandShell = 0;
	            }
	        }
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo2TurtleShell){
	            currentStandShell-=2;
	            if(currentStandShell<0){
	                currentStandShell = 0;
	            }
	        }
	
	        
	        Global.penguinJumpFinalX = shellPosX[currentStandShell];
	        Global.penguinJumpFinalY = shellPosY;
	        
	    }
	}
	
	public void  gotoNextDelayOneStep()
	{
	
	}
	
	public void tapTurtle()
	{
	    this.updateGameLevel();
	    
	    turtle[currentStandShell].tap();
	}
	
	public void  runTurtleAI()
	{
	    for(int i = 0 ; i < 6 ; i++){
	        
	        if(turtle[i].status() == Turtle.kTurtleAniStatus_Normal_Out){
	            if((Math.random()*65535) % 50 == 0){
	                if((Math.random()*65535) % 10 == 0){
	                }else{
	                    turtle[i].setStatus(Turtle.kTurtleAniStatus_Idle);
	                }
	            } 
	        }
	        
	    }
	    
	}
	
	public void  thisMomentOverTime( int _momentIdx)
	{
	    turtle[momentTarget[_momentIdx]].setStatus(Turtle.kTurtleAniStatus_In);
	    Global.gameRound--;
	    if(Global.gameRound < 0){
	        Global.gameRound = 0;
	    }
	    remainTapToNextRound--;
	}
	
	public void  getScript()
	{
	    if(Global.gameLevel == 0){
	        nextMomentAppearTime = 8;
	    }
	    
	    nextMomentAppearTime = 400000;
	}
	
	public int  genNextTargetMoment( int _shellStandPosition, int _shellLevel, int _NS1, int _NS2, int _NS3, int _NS4, int _NS5, int _NS6)
	{
	    if(_shellStandPosition < 0){
	        return -10;
	    }
	    
	    isFuxking = false;
	    
	    boolean hasColide;
	    int momentTargetCheck = 0;
	    int hasColideTimes;
	    
	    hasColideTimes = 0;
	    do{
	        hasColideTimes++;
	        hasColide = false;
	        
	        int ranMomentTarget;
	        ranMomentTarget = (int) ((Math.random()*65535)%4);
	        
	        if(ranMomentTarget == 0){
	            momentTargetCheck = _shellStandPosition - 2;
	            if(Global.gameLevel == 0 && Global.gameRound < 3){
	                momentTargetCheck = _shellStandPosition - 1;
	            }
	        }
	        if(ranMomentTarget == 1){
	            momentTargetCheck = _shellStandPosition - 1;
	        }
	        if(ranMomentTarget == 2){
	            momentTargetCheck = _shellStandPosition + 1;
	        }
	        if(ranMomentTarget == 3){
	            momentTargetCheck = _shellStandPosition + 2;
	            if(Global.gameLevel == 0 && Global.gameRound < 3){
	                momentTargetCheck = _shellStandPosition + 1;
	            }
	        }
	        
	        
	        
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
	            return -2;
	        }
	        
	        if(momentTargetCheck < 0 || momentTargetCheck > 5){
	            hasColide = true;
	        }else{
	            if(turtle[momentTargetCheck].status() != Turtle.kTurtleAniStatus_Normal_In){
	                hasColide = true;
	            }
	        }
	        
	        if(momentTargetCheck == currentStandShell || momentTargetCheck == _NS1 || momentTargetCheck == _NS2 || momentTargetCheck == _NS3 || momentTargetCheck == _NS4 || momentTargetCheck == _NS5 || momentTargetCheck == _NS6){
	            hasColide = true;
	        }
	        
	        
	    }while(hasColide);
	    
	    if(momentTargetCheck == 0){
	        this.setExternalValues(-22);
	    }
	    
	    shellGoingToMoment[momentTargetCheck] = 1;
	    shellLevelGoingToMoment[momentTargetCheck] = _shellLevel;
	    
	    return momentTargetCheck;
	
	}
	
	
	public void  giveNextMoment()
	{
	    for(int i = 0 ; i < 6 ; i++){
	        shellGoingToMoment[i] = -1;
	    }
	    
	    
	    for(int i = 0 ; i < 6 ; i++){
	        shell_Check[i] = -1;
	    }
	    
	    int turtleNumbers = 0;
	    int ranShellScript;
	    
	    if(Global.gameLevel == 0){
	            
	        shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	        turtleNumbers = 1;
	        
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = (float) (nextMomentAppearTime - 0.05); 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	            
	    }
	    
	    if(Global.gameLevel == 1){
	
	        
	        shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	        shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	        turtleNumbers = 2;
	        
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = (float) (nextMomentAppearTime - 0.05); 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	    }
	    
	    //NEW ADD
	    if(Global.gameLevel == 2){
	
	        shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	        shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	        turtleNumbers = 2;
	        
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	    }
	    
	    if(Global.gameLevel == 3){
	        
	        if((Math.random()*65535) % 2 == 0){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 2;
	        }else{
	            
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 2;
	        }
	                
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	
	        
	    }
	    if(Global.gameLevel == 4){
	        
	        ranShellScript = (int) ((Math.random()*65535) % 4);
	        
	        if(ranShellScript == 0){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[3] = this.genNextTargetMoment(shell_Check[2],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 4;
	        }else if(ranShellScript == 1){
	            
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 2){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 3){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }
	        
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	    }
	    
	    if(Global.gameLevel == 5){
	        
	        ranShellScript = (int) ((Math.random()*65535) % 4);
	        
	        if(ranShellScript == 0){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]);  
	            turtleNumbers = 3;
	        }else if(ranShellScript == 1){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 2;
	        }else if(ranShellScript == 2){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 3){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[3] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 4;
	        }
	        
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	        
	    }
	    
	    if(Global.gameLevel == 6){
	        
	        ranShellScript = (int) ((Math.random()*65535) % 4);
	        
	        if(ranShellScript == 0){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 2;
	        }else if(ranShellScript == 1){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 2){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 3){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[3] = this.genNextTargetMoment(shell_Check[2],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 4;
	        }
	        
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	        
	    }
	    
	    
	    if(Global.gameLevel == 7){
	        
	        ranShellScript = (int) ((Math.random()*65535) % 6);
	        
	        if(ranShellScript == 0){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 1){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 2){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[3] = this.genNextTargetMoment(shell_Check[2],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 4;
	        }else  if(ranShellScript == 3){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,2,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[0],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]);  
	            turtleNumbers = 3;
	        }else if(ranShellScript == 4){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 3;
	        }else if(ranShellScript == 5){
	            shell_Check[0] = this.genNextTargetMoment(currentStandShell,0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[1] = this.genNextTargetMoment(shell_Check[0],1,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[2] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            shell_Check[3] = this.genNextTargetMoment(shell_Check[1],0,shell_Check[0],shell_Check[1],shell_Check[2],shell_Check[3],shell_Check[4],shell_Check[5]); 
	            turtleNumbers = 4;
	        }
	        
	        if(shell_Check[0] < -1 || shell_Check[1] < -1 || shell_Check[2] < -1 || shell_Check[3] < -1 || shell_Check[4] < -1 || shell_Check[5] < -1){
	            newestMomentHasAppearedTime = nextMomentAppearTime - 0.05f; 
	        }else{
	            numberTapToNextRound = turtleNumbers;
	            remainTapToNextRound += turtleNumbers;
	        }
	        
	    }
	    
	    for(int i = 0 ; i < 6 ; i++){
	        if(shellGoingToMoment[i] < 0){
	            //return;
	        }else{
	            
	            hasNoticedOverTime[recentMomentIdx] = false;
	            momentRunTime[recentMomentIdx] = 0;
	            momentOverTime[recentMomentIdx] = 40000;
	            
	            momentTarget[recentMomentIdx] = i;
	            turtle[i].setStatus(Turtle.kTurtleAniStatus_Out);
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
	
	public void  tapWrongly()
	{
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.005;
	        if(comboReduceSpeedAccum < -0.01){
	            comboReduceSpeedAccum = -0.01f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	    
	    comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    
	    super.tapWrongly();
	    
	    for(int i = 0 ; i < maxMoment ; i++){
	        if(momentRunTime[i] > 0){
	            turtle[momentTarget[i]].setStatus(Turtle.kTurtleAniStatus_In);
	            momentRunTime[i] = -9999;
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
