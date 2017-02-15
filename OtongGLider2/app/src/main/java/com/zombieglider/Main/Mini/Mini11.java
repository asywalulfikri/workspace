package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.Cannon;
import com.zombieglider.Main.ControlLayer;
import com.zombieglider.Main.Penguin;

public class Mini11 extends MiniBasic
{
	static final int kChainType_Constant = 0;
	static final int kChainType_Middle = 1;
	static final int kChainType_Behine = 2;
	static final int kChainType_SlowToFast = 3;
	static final int kChainType_FastToSlow = 4;
	
    Penguin penguin;
    Cannon cannon;
    
    float PCVX;
    float PCAX;
    float PCX;
    float PCY;
    float PCPOffsetX;
    
    CCSprite s_shell[] = new CCSprite[20];
    float shellX[] = new float[20];
    float shellY[] = new float[20];
    float shellScale[] = new float[20];
    boolean shellIsAppearing[] = new boolean[20];
    int shellAppearingTimer[] = new int[20];
    boolean shellIsOnScreen[] = new boolean[20];
    int maxShell;
    int shellIdx;
    int maxShellGen;
    
    boolean isUsingFirstNowIsShellOnScreen;
    boolean nowIsShellOnScreen[] = new boolean[20];
    boolean nowIsShellOnScreen2[] = new boolean[20];
    
    boolean shellIsFuckingPenguin[] = new boolean[20];
    int shellIsFuckingpenguinTimer[] = new int[20];
    
    CCSprite s_Cannon_Ball[] = new CCSprite[2];
    int maxCannonBall;
    int cannonBallIdx;
    
    float cannonForce;
    float cannonAdditionalForceY;
    float cannonGravity;
    float cannonFriction;
    
    float cannonBall_VX[] = new float[2];
    float cannonBall_VY[] = new float[2];
    float cannonBall_X[] = new float[2];
    float cannonBall_Y[] = new float[2];
    boolean cannonBall_isAni[] = new boolean[2];
    int cannonBall_Timer[] = new int[2];
    boolean cannBall_isHittingFirstChain;
    boolean cannonBallIsGoingDown[] = new boolean[2];
    
    boolean hasShotOnceAndTakeRestForNextFuck;
    int hasShotOnceAndTakeRestForNextFuckTimer;
    
    float cannonFinalAngle;
    float cannonAngleInterval;
    float cannonRotationSpeed;
    boolean isClockwise;
    
    boolean isTappingLeft;
    boolean isTappingRight;
    
    float detectCannonBallRadius;
    float detectShellRadius;
    
     float fuxkCannonBombX;
     float fuxkCannonBombY;
    
    int shootCannonTimer;
    boolean isShootingCannon;
    boolean hasShotCannonBeforeNextChain;
    
    boolean penguinIsJumping;
    boolean penguinJumpingToRight;
    int penguinJumpTimer;
    float penguinJumpingExternalStartX;
    
     
    int chainType;
    int chainIntervalSelect[] = new int[15];
    
    //change update values
    int cannonMinAngle;
    int cannonMaxAngle;
    int cannonAngleRange;
    
    int chainAverageInterval;
    int chainMinInterval;
    int chainMaxInterval;
    int chainMaxShellAppear;
    int chainTypeAppearRatio[] = new int[5];
    
    float genX[] = new float[20];
    float genY[] = new float[20];
    
    boolean isFuckedAndLoseCombo;
    
    CCSprite s_carriage;
    CCSprite s_carriageWheel[] = new CCSprite[2];
    float carriage_X;
    float carriage_Y;
    float carriage_wheelR;
    float carriage_wheelVR;
    float carriage_wheelAR;

	
	public void  restart()
	{
	    super.restart();
	    
	    Global.gameLevel = 0;
	    comboReduceSpeedAccum = 0;
	    Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.003;
	    
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
	    Global.timeToBeGained = 6;
	    
	    for(int i = 0 ; i < maxShell ; i++){
	        if(nowIsShellOnScreen[i]){
	            nowIsShellOnScreen[i] = false;
	            this.setThisShellFuckBackPenguin(i);
	        }
	        if(nowIsShellOnScreen2[i]){
	            nowIsShellOnScreen2[i] = false;
	            this.setThisShellFuckBackPenguin(i);
	        }
	    }
	    
	    isUsingFirstNowIsShellOnScreen = !isUsingFirstNowIsShellOnScreen;
	    hasShotCannonBeforeNextChain = true;
	    isShootingCannon = true;
	    shootCannonTimer = 0;
	}
	
	public void  updategameLevel()
	{
	    
	    if(Global.gameRound < 15){
	        Global.gameLevel = 0;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.003;
	    }else if(Global.gameRound < 30){
	        Global.gameLevel = 1;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.004;
	    }else if(Global.gameRound < 60){
	        Global.gameLevel = 2;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.005;
	    }else if(Global.gameRound < 90){
	        Global.gameLevel = 3;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.0065;
	    }else if(Global.gameRound < 120){
	        Global.gameLevel = 4;
	        Global.comoboReduceSpeed =comboReduceSpeedAccum +  0.008;
	    }else if(Global.gameRound < 160){
	        Global.gameLevel = 5;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.01;
	    }else if(Global.gameRound < 200){
	        Global.gameLevel = 6;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.012;
	    }else if(Global.gameRound < 230){
	        Global.gameLevel = 7;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.014;
	    }else if(Global.gameRound < 260){
	        Global.gameLevel = 8;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.015;
	    }else if(Global.gameRound < 300){
	        Global.gameLevel = 9;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.016;
	    }else if(Global.gameRound < 350){
	        Global.gameLevel = 10;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.017;
	    }else if(Global.gameRound < 400){
	        Global.gameLevel = 11;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.018;
	    }else if(Global.gameRound < 450){
	        Global.gameLevel = 12;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.02;
	    }else if(Global.gameRound < 500){
	        Global.gameLevel = 13;
	        Global.comoboReduceSpeed = comboReduceSpeedAccum + 0.023;
	    }
	
	    
	    if(comboReduceSpeedAccum < 0){
	        comboReduceSpeedAccum += comboReduceSpeedAccumSpeed/20;  //0.004/20
	    }else{
	        comboReduceSpeedAccum = 0;
	    }
	    
	    if(Global.comoboReduceSpeed < 0.003){
	        Global.comoboReduceSpeed = 0.003;
	    }
	    
	    cannonMinAngle = 30;
	    cannonMaxAngle = 75;
	    
	    chainAverageInterval = 8;
	    chainMaxShellAppear = 8;
	    
	    chainMinInterval = 5;
	    chainMaxInterval = 10;
	    
	    if(Global.gameLevel <= 1){
	        chainTypeAppearRatio[0] = 100;
	        chainTypeAppearRatio[1] = 100;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	        
	        chainAverageInterval = 6;
	        cannonMinAngle = 40;
	        cannonMaxAngle = 65;
	    }
	
	    if(Global.gameLevel == 2){
	        chainTypeAppearRatio[0] = 100;
	        chainTypeAppearRatio[1] = 100;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	        
	        chainAverageInterval = 6;
	        cannonMinAngle = 40;
	        cannonMaxAngle = 65;
	    }
	    if(Global.gameLevel == 3){
	        chainTypeAppearRatio[0] = 100;
	        chainTypeAppearRatio[1] = 100;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	        
	        chainAverageInterval = 7;
	        cannonMinAngle = 40;
	        cannonMaxAngle = 65;
	    }
	    if(Global.gameLevel == 4){
	        chainTypeAppearRatio[0] = 80;
	        chainTypeAppearRatio[1] = 100;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	        
	        cannonMinAngle = 35;
	        cannonMaxAngle = 68;
	    }
	    if(Global.gameLevel == 5){
	        chainTypeAppearRatio[0] = 75;
	        chainTypeAppearRatio[1] = 95;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	        
	        cannonMinAngle = 30;
	        cannonMaxAngle = 70;
	    }
	    if(Global.gameLevel == 6){
	        chainTypeAppearRatio[0] = 70;
	        chainTypeAppearRatio[1] = 90;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	    }
	    if(Global.gameLevel == 7){
	        chainTypeAppearRatio[0] = 60;
	        chainTypeAppearRatio[1] = 80;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	    }
	    if(Global.gameLevel == 8){
	        chainTypeAppearRatio[0] = 50;
	        chainTypeAppearRatio[1] = 73;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	    }
	    
	    if(Global.gameLevel >= 9){
	        chainTypeAppearRatio[0] = 33;
	        chainTypeAppearRatio[1] = 66;
	        chainTypeAppearRatio[2] = 100;
	        chainTypeAppearRatio[3] = 100;
	        chainTypeAppearRatio[4] = 100;
	        
	        chainAverageInterval = 9;
	        cannonMinAngle = 30;
	        cannonMaxAngle = 80;
	    }
	    
	    cannonAngleRange = cannonMaxAngle - cannonMinAngle;
	    
	    this.reInitColorComboLimit();
	   
	}
	
	public void  reInitColorComboLimit()
	{
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
	        Global.timeToBeGained = 6;
	    }
	    if(Global.gameLevel == 6){
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
	        Global.timeToBeGained = 6;
	    }
	    if(Global.gameLevel == 8){
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
	        Global.timeToBeGained = 6;
	    }
	
	}
	
	
	public Mini11()
	{
		super();
        
		Global.timeToBeGained = 6;
		Global.maxTime = 60;
		Global.timeRemain = Global.maxTime;
        
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
        
        Global.wholeCannonScaleFromSocurce = 0.44f;
        Global.wholePenguinScaleFromSocurce = 0.48f;
        
        Global.cannonAngle = -135;
        cannonFinalAngle = -45;
        cannonRotationSpeed = 2.5f;
        
        cannonForce = 20;
        cannonAdditionalForceY = 1;
        cannonFriction = 0.98f;
        cannonGravity = -1.2f;
        
        maxShellGen = 8;
        shootCannonTimer = 0;
        isShootingCannon = false;
        hasShotCannonBeforeNextChain = false;
        hasShotOnceAndTakeRestForNextFuck = false;
        isFuckedAndLoseCombo = false;
    
        isTappingLeft = false;
        isTappingRight = false;
        
        detectCannonBallRadius = 30/2;
        detectShellRadius = 54/2;
        
        PCAX = 0.5f;
        PCVX = 0;
        PCX = 150;
        PCY = 15;
       
        this.initControlLayer();
        this.initCharacters();
        this.initCannon();
        this.initCannonBalls();
        this.updatePCPosition();
        this.initCarriage();
        
        isClockwise = false;
        cannBall_isHittingFirstChain = true;
        this.genNextShellChain();	    
	}
	
	public void  initCarriage()
	{
	    s_carriage = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1550/2*Global.g_Scale, 672/2*Global.g_Scale, 244/2*Global.g_Scale, 14/2*Global.g_Scale));
	    Global.ss_Character.addChild(s_carriage,Global.kDeapth_Bg_Element1);
	    s_carriage.setScale( 1.0f/Global.g_Scale );
	    s_carriageWheel[0] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1806/2*Global.g_Scale, 672/2*Global.g_Scale, 54/2*Global.g_Scale, 52/2*Global.g_Scale));
	    s_carriageWheel[1] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1806/2*Global.g_Scale, 672/2*Global.g_Scale, 54/2*Global.g_Scale, 52/2*Global.g_Scale));
	    s_carriageWheel[0].setScale( 1.0f/Global.g_Scale );
	    s_carriageWheel[1].setScale( 1.0f/Global.g_Scale );
	    Global.ss_Character.addChild(s_carriageWheel[0],Global.kDeapth_Bg_Element1);
	    Global.ss_Character.addChild(s_carriageWheel[1],Global.kDeapth_Bg_Element1);
	}
	
	public void  initControlLayer()
	{
	    controlLayer = new ControlLayer();
		this.addChild(controlLayer,Global.kDeapth_Btns);
	    controlLayer.setDelegate(this);
	}
	
	public void  initCharacters()
	{
	    penguin = new Penguin();
	    penguin.setX(25);
	    penguin.setY(14);
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	    
	    shellIdx = 0;
	    maxShell = 20;
	    for(int i = 0 ; i < maxShell ; i++){
	        s_shell[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(948/2*Global.g_Scale, 370/2*Global.g_Scale, 108/2*Global.g_Scale, 76/2*Global.g_Scale));
	        Global.ss_Character.addChild(s_shell[i]);
	        s_shell[i].setPosition(CGPoint.ccp(-10000,-10000));
	        s_shell[i].setScale( 1.0f/Global.g_Scale );
	        shellIsOnScreen[i] = false;
	        shellX[i] = 10000;
	        shellY[i] = 10000;
	        
	        shellIsAppearing[i] = false;
	        
	        isUsingFirstNowIsShellOnScreen = false;
	        nowIsShellOnScreen[i] = false;
	        nowIsShellOnScreen2[i] = false;
	        shellIsFuckingPenguin[i] = false;
	    }
	}
	
	public void  initCannonBalls()
	{
	    maxCannonBall = 2;
	    for(int i = 0 ; i < maxCannonBall ; i++){
	        s_Cannon_Ball[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(504/2*Global.g_Scale, 724/2*Global.g_Scale, 60/2*Global.g_Scale, 58/2*Global.g_Scale));
	        s_Cannon_Ball[i].setPosition(CGPoint.ccp(1000,100000));
	        Global.ss_Character.addChild(s_Cannon_Ball[i],Global.kDeapth_Extra2);
	        s_Cannon_Ball[i].setScale(1.12f/Global.g_Scale);
	        cannonBall_isAni[i] = false;
	    }
	    cannonBallIdx = 0;
	}
	
	public void  initCannon()
	{
	    cannon = new Cannon();
	    cannon.setDelegate(this);
	}
	
	public void  genOneShellAtX( int _x, int _y)
	{
	    shellIsAppearing[shellIdx] = true;
	    shellIsOnScreen[shellIdx] = true;
	    shellAppearingTimer[shellIdx] = 0;
	    
	    shellScale[shellIdx] = 0;
	    shellX[shellIdx] = _x;
	    shellY[shellIdx] = _y;
	    
	    if(isUsingFirstNowIsShellOnScreen){
	         nowIsShellOnScreen[shellIdx] = true;
	    }else{
	         nowIsShellOnScreen2[shellIdx] = true;
	    }
	   
	    
	    shellIdx++;
	    if(shellIdx == maxShell){
	        shellIdx = 0;
	    }
	}
	
	public void  genNextShellChain()
	{
	    this.updategameLevel();
	    
	    isUsingFirstNowIsShellOnScreen = !isUsingFirstNowIsShellOnScreen;
	    
	    int simulateTimer;
	    float simulateX;
	    float simulateY;
	    float simulateVX;
	    float simulateVY;
	    float simulateAngle;
	    int simulateShellHasGen;
	    
	    float superFuxkAngleDiff;
	    float superFuxkOriX;
	    float superFuxkOriY;
	    float superFuxkOffsetX;
	    float superFuxkOffsetY;
	    float superFuxkFuxkX;
	    float superFuxkFuxkY;
	    int ranChainStartX;
	    
	    int ranFinalAngle;
	    ranFinalAngle = (int) ((Math.random()*65535) % cannonAngleRange);
	    ranFinalAngle += cannonMinAngle;
	    
	    if(isClockwise){
	        cannonFinalAngle = -180 + ranFinalAngle;
	        ranChainStartX = (int) ((Math.random()*65535)%160);
	        
	        if(Global.isIphone5){
	            ranChainStartX += 240 + 88;
	        }else{
	            ranChainStartX += 240;
	        }
	        
	        
	    }else{
	        cannonFinalAngle = -ranFinalAngle;
	        ranChainStartX = (int) ((Math.random()*65535)%160);
	        ranChainStartX += 80;
	    }
	    
	    superFuxkOffsetX = (float) (-58 * Math.cos(cannonFinalAngle * Math.PI/180 + Math.PI/2));
	    superFuxkOffsetY = (float) (58 * Math.sin(cannonFinalAngle * Math.PI/180 + Math.PI/2) - 58);
	    
	    superFuxkAngleDiff = (float) (-cannonFinalAngle * Math.PI/180);
	    superFuxkOriX = 91 * Global.wholeCannonScaleFromSocurce * 2;
	    superFuxkOriY = 35 * Global.wholeCannonScaleFromSocurce * 2;
	    superFuxkFuxkX = (float) (ranChainStartX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    superFuxkFuxkY = (float) (cannon.y() + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    simulateTimer = 0;
	    simulateShellHasGen = 0;
	    simulateAngle = cannonFinalAngle;
	    
	    simulateX = superFuxkFuxkX;
	    simulateY = superFuxkFuxkY; 
	    
	    simulateVX = (float) (cannonForce * Math.cos(-simulateAngle * Math.PI/180));
	    simulateVY = (float) (cannonForce * Math.sin(-simulateAngle * Math.PI/180) * cannonAdditionalForceY);
	    
	    
	    
	    int shellHasGen;
	    int hasFuckTime;
	    
	    hasFuckTime = 0;
	    do{
	        
	        simulateTimer = 0;
	        shellHasGen = 0;
	        simulateShellHasGen = 0;
	        this.getChainType();
	        
	        
	        simulateX = superFuxkFuxkX;
	        simulateY = superFuxkFuxkY; 
	        simulateVX = (float) (cannonForce * Math.cos(-simulateAngle * Math.PI/180));
	        simulateVY = (float) (cannonForce * Math.sin(-simulateAngle * Math.PI/180) * cannonAdditionalForceY);
	
	        
	        do{
	            simulateX += simulateVX;
	            simulateY += simulateVY;
	            simulateVY += cannonGravity;
	            simulateVX *= cannonFriction;
	            
	            simulateTimer++;
	            
	            int boundaryY;
	            if(Global.isIphone5){
	                boundaryY = 455 + 88;
	            }else{
	                boundaryY = 455;
	            }
	            
	            if(simulateX > 25 && simulateX < boundaryY){
	                if(simulateY > 70){
	                    if(simulateTimer == chainIntervalSelect[shellHasGen]){
	                        genX[shellHasGen] = simulateX;
	                        genY[shellHasGen] = simulateY;
	                        
	                        simulateShellHasGen++;
	                        shellHasGen++;
	                    }
	                }
	            }
	            
	                
	        }while(simulateY > 69 && simulateShellHasGen < maxShellGen);
	        
	        hasFuckTime++;
	        if(hasFuckTime == 20){
	            isUsingFirstNowIsShellOnScreen = !isUsingFirstNowIsShellOnScreen;
	            this.genNextShellChain();
	            return;
	        }
	    
	    }while (shellHasGen <= 1);
	    
	    for(int i = 0 ; i < shellHasGen ; i++){
	        this.genOneShellAtX((int)genX[i],(int)genY[i]);
	    }
	
	    
	    cannonAngleInterval = cannonFinalAngle - Global.cannonAngle;
	    isClockwise = !isClockwise;
	}
	
	public void  getChainType()
	{
	    int ranChainType;
	    ranChainType = (int) ((Math.random()*65535)%100);
	    if(ranChainType < chainTypeAppearRatio[0]){
	        ranChainType = 0;
	    }else  if(ranChainType < chainTypeAppearRatio[1]){
	        ranChainType = 1;
	    }else  if(ranChainType < chainTypeAppearRatio[2]){
	        ranChainType = 2;
	    }else  if(ranChainType < chainTypeAppearRatio[3]){
	        ranChainType = 3;
	    }else  if(ranChainType < chainTypeAppearRatio[4]){
	        ranChainType = 4;
	    }
	    
	    for(int i = 0 ; i < 15 ; i++){
	        chainIntervalSelect[i] = -1;
	    }
	    
	    int chainSimulateTimer;
	    int chainOIntervalHasSelected;
	    int ranCut = 0;
	    int chainCalInterval = 0;
	    
	    chainSimulateTimer = 0;
	    chainOIntervalHasSelected = 0;
	
	    if(ranChainType == kChainType_Constant){
	        ranCut = 0;
	        chainCalInterval = chainAverageInterval;
	    }
	    
	    if(ranChainType == kChainType_Middle){
	        ranCut = (int) ((Math.random()*65535) % 2);
	        ranCut += 1;
	        chainCalInterval = chainAverageInterval - 1;
	    }
	    if(ranChainType == kChainType_Behine){
	        ranCut = (int) ((Math.random()*65535) % 3);
	        ranCut += 3;
	        chainCalInterval = chainAverageInterval - 2;
	    }
	    
	    if(ranChainType == kChainType_Constant || ranChainType == kChainType_Middle || ranChainType == kChainType_Behine){
	        do{
	            if(chainSimulateTimer % chainCalInterval == 0 && chainSimulateTimer != 0){
	                if(chainOIntervalHasSelected - ranCut >= 0){
	                    chainIntervalSelect[chainOIntervalHasSelected - ranCut] = chainSimulateTimer;
	                }
	                
	                chainOIntervalHasSelected++;
	            }
	            
	            chainSimulateTimer++;
	        }while(chainOIntervalHasSelected < chainMaxShellAppear);
	    }
	    
	}
	
	
	public void  manage( float  dt)
	{
	    this.manageCannon();
	    this.manageCannonBalls();
	    this.manageShells();
	    this.manageShootToNextChain();
	    this.managePenguinJump();
	    this.updatePCPosition();
	    
	    cannon.manage();
	    penguin.manage();
	     this.manageCarriage();
	}
	
	public void  manageCarriage()
	{
	    carriage_X = cannon.x();
	    carriage_Y = cannon.y()-2;
	    
	    s_carriage.setPosition(CGPoint.ccp(carriage_X, carriage_Y));
	    s_carriageWheel[0].setPosition(CGPoint.ccp(carriage_X - 30, carriage_Y));
	    s_carriageWheel[1].setPosition(CGPoint.ccp(carriage_X + 30, carriage_Y));
	    
	    float whellCircumfunce = 84.8230016f; // 27 X PI
	    carriage_wheelVR = PCVX / whellCircumfunce * 360;
	    carriage_wheelR += carriage_wheelVR;
	    
	    s_carriageWheel[0].setRotation(carriage_wheelR);
	    s_carriageWheel[1].setRotation(carriage_wheelR);
	    
	}
	
	public void  manageShells()
	{
	    for(int i = 0 ; i < maxShell ; i++){
	        if(shellIsAppearing[i]){
	            
	            if(shellAppearingTimer[i] < 10){
	                shellScale[i] += 0.1;
	            }else{
	                shellScale[i] += (0.8 -  shellScale[i])/12;
	            }
	            
	            s_shell[i].setPosition(CGPoint.ccp(shellX[i], shellY[i]));
	            s_shell[i].setScale(shellScale[i]/Global.g_Scale);
	            
	            shellAppearingTimer[i]++;
	        }
	        
	        if(shellIsFuckingPenguin[i]){
	            int ranFuckPenguinX;
	            int ranFuckPenguinY;
	            
	            if(shellIsFuckingpenguinTimer[i] < 3){
	                ranFuckPenguinX = (int) ((Math.random()*65535) % 2);
	                ranFuckPenguinX -= 1;
	                
	                ranFuckPenguinY = (int) ((Math.random()*65535) % 2);
	                ranFuckPenguinY -= 1;
	            }else{
	                ranFuckPenguinX = (int) ((Math.random()*65535) % 4);
	                ranFuckPenguinX -= 2;
	                
	                ranFuckPenguinY = (int) ((Math.random()*65535) % 4);
	                ranFuckPenguinY -= 2;
	            }
	            
	            s_shell[i].setPosition(CGPoint.ccp(shellX[i] + ranFuckPenguinX, shellY[i] + ranFuckPenguinY));
	            
	            shellScale[i] += 0.05;
	            s_shell[i].setScale(shellScale[i]/Global.g_Scale);
	            
	            if(shellIsFuckingpenguinTimer[i] == 15){
	                shellIsFuckingPenguin[i] = false;
	                
	                Global.playLayer.setToBombing(shellX[i],shellY[i]);
	                shellX[i] = 10000;
	                shellY[i] = 10000;
	                s_shell[i].setPosition(CGPoint.ccp(-10000,-10000));
	                shellIsOnScreen[i] = false;
	                shellIsAppearing[i] = false;
	                
	                Global.musicController.playThisSound(Global.kSound_TurtleExplode03,false,1.0);
	                
	            }
	            
	            shellIsFuckingpenguinTimer[i]++;
	        }
	    }
	}
	
	public void  manageCannon()
	{
	    if(hasShotOnceAndTakeRestForNextFuck){
	        hasShotOnceAndTakeRestForNextFuckTimer++;
	        if(hasShotOnceAndTakeRestForNextFuckTimer == 30){
	            hasShotOnceAndTakeRestForNextFuck = false;
	        }
	    }
	    
	    Global.cannonAngle += cannonAngleInterval/4;
	    if(!isClockwise){
	        if(Global.cannonAngle < cannonFinalAngle){
	        	Global.cannonAngle = cannonFinalAngle;
	        }
	    }else{
	        if(Global.cannonAngle > cannonFinalAngle){
	        	Global.cannonAngle = cannonFinalAngle;
	        }
	    }
	    
	    cannon.setRotateDegree(Global.cannonAngle + 50.4801941f);
	}
	
	
	
	public void  manageCannonBalls()
	{
	    
	    for(int i = 0 ; i < maxCannonBall ; i++){
	        if(cannonBall_isAni[i]){
	            cannonBall_X[i] += cannonBall_VX[i];
	            cannonBall_Y[i] += cannonBall_VY[i];
	            
	            cannonBall_VY[i] += cannonGravity;
	            cannonBall_VX[i] *= cannonFriction;
	            
	            s_Cannon_Ball[i].setPosition(CGPoint.ccp(cannonBall_X[i],cannonBall_Y[i]));
	            
	            if(cannonBall_VY[i] > 0){
	                cannonBallIsGoingDown[i] = false;
	            }else{
	                cannonBallIsGoingDown[i] = true;
	            }
	            
	            
	            if(cannonBall_Y[i] < -20){
	                cannonBall_isAni[i] = false;
	                
	                if(isFuckedAndLoseCombo){
	                    if(Global.currentCombo >= 5){
	                        comboReduceSpeedAccum -= 0.004;
	                        if(comboReduceSpeedAccum < -0.01){
	                            comboReduceSpeedAccum = -0.01f;
	                        }
	                        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	                    }
	                    
	                    Global.uILayer.lostCombo();
	                    isFuckedAndLoseCombo = false;
	                    
	                }
	            }
	        }
	        
	        
	    }
	
	    for(int j = 0 ; j < maxShell ; j++){
	        if(shellIsOnScreen[j] && !shellIsFuckingPenguin[j]){
	            for(int i = 0 ; i < maxCannonBall ; i++){
	                if(cannonBall_isAni[i]){
	                    float ballShellDiffX;
	                    float ballShellDiffY;
	                    float ballShellDiff;
	                    ballShellDiffX = cannonBall_X[i] - shellX[j];
	                    ballShellDiffY = cannonBall_Y[i] - shellY[j];
	                    ballShellDiff = (float) Math.sqrt(ballShellDiffX*ballShellDiffX + ballShellDiffY*ballShellDiffY);
	                    
	                    
	                    if(ballShellDiff < detectShellRadius + detectCannonBallRadius){
	                        if((i == 0 && nowIsShellOnScreen[j]) || (i == 1 && nowIsShellOnScreen2[j])){
	                            this.thisShellIsBeingShot(j);
	                        }
	                    }
	                    
	                   
	                    if(cannonBallIsGoingDown[i] && cannonBall_Y[i] - shellY[j] < -40 && i == 0 && nowIsShellOnScreen[j]){
	                        nowIsShellOnScreen[j] = false;
	                         this.setThisShellFuckBackPenguin(j);
	                    }
	                    
	                    if(cannonBallIsGoingDown[i] && cannonBall_Y[i] - shellY[j] < -40 && i == 1 && nowIsShellOnScreen2[j]){
	                         nowIsShellOnScreen2[j] = false;
	                         this.setThisShellFuckBackPenguin(j);
	                    }
	                }
	                
	            }
	        }
	    }
	}
	
	public void  thisShellIsBeingShot( int _shellIdx)
	{
		Global.uILayer.gainCombo(1);
		Global.playLayer.setToBombing(shellX[_shellIdx],shellY[_shellIdx]);
	    shellX[_shellIdx] = 10000;
	    shellY[_shellIdx] = 10000;
	    s_shell[_shellIdx].setPosition(CGPoint.ccp(10000,10000));
	    shellIsOnScreen[_shellIdx] = false;
	    shellIsAppearing[_shellIdx] = false;
	    
	    nowIsShellOnScreen[_shellIdx] = false;
	    nowIsShellOnScreen2[_shellIdx] = false;
	    
	    Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_CrackShell,false,0.7);
	    
	    Global.gameRound++;
	    Global.counterForAchivement++;
	}
	
	public void  btnIsTappedInControlLayer( int _btnIdx)
	{
	    if(_btnIdx == 0){
	        isTappingRight = false;
	        isTappingLeft = true;
	    }
	    if(_btnIdx == 3){
	        isTappingLeft = false;
	        isTappingRight = true;
	    }
	}
	
	public void  btnIsReleasedInControlLayer( int _btnIdx)
	{
	    if(_btnIdx == 0){
	        isTappingLeft = false;
	    }
	    if(_btnIdx == 3){
	        isTappingRight = false;
	    }
	}
	
	public  boolean ccTouchesEnded( MotionEvent event)
	{
	    if(Global.isStopping){
	        return true;
	    }
	    
	    if(Global.isTapWronglyAndDisableBtns){
	    	Global.isTapWronglyAndDisableBtns = false;
	    	Global.isFuckingShootFirstTime = false;
	        return true;
	    }
	    
	    return true;
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
	 
	    for( int i = 0; i < event.getPointerCount(); i++ ) {
			CGPoint location = CGPoint.ccp(event.getX(i), event.getY(i));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        int boundaryY;
	        if(Global.isIphone5){
	            boundaryY = 396 + 88;
	        }else{
	            boundaryY = 396;
	        }
	        
	        if(location.y < 90){
	            if(location.x > 84 && location.x < boundaryY){
	                this.shootCannon();
	            } 
	        }
	        
	        if(location.y < 258 && location.y > 90){
	                this.shootCannon();
	        }
	    }
		return true;
	
	}
	
	public void  shootCannon()
	{
	    if(hasShotOnceAndTakeRestForNextFuck){
	        return;
	    }
	    
	    hasShotOnceAndTakeRestForNextFuck = true;
	    hasShotOnceAndTakeRestForNextFuckTimer = 0;
	    
	    float superFuxkAngleDiff;
	    float superFuxkOriX;
	    float superFuxkOriY;
	    float superFuxkOffsetX;
	    float superFuxkOffsetY;
	    float superFuxkFuxkX;
	    float superFuxkFuxkY;
	    
	    superFuxkOffsetX = (float) (-58 * Math.cos(Global.cannonAngle * Math.PI/180 + Math.PI/2));
	    superFuxkOffsetY = (float) (58 * Math.sin(Global.cannonAngle * Math.PI/180 + Math.PI/2) - 58);
	    
	    superFuxkAngleDiff = (float) (-Global.cannonAngle * Math.PI/180);
	    superFuxkOriX = 91 * Global.wholeCannonScaleFromSocurce * 2;
	    superFuxkOriY = 35 * Global.wholeCannonScaleFromSocurce * 2;
	    superFuxkFuxkX = (float) (cannon.x() + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    superFuxkFuxkY = (float) (cannon.y() + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    
	    cannonBall_X[cannonBallIdx] = superFuxkFuxkX;
	    cannonBall_Y[cannonBallIdx] = superFuxkFuxkY; 
	    
	    cannonBall_VX[cannonBallIdx] = (float) (cannonForce * Math.cos(-Global.cannonAngle * Math.PI/180));
	    cannonBall_VY[cannonBallIdx] = (float) (cannonForce * Math.sin(-Global.cannonAngle * Math.PI/180) * cannonAdditionalForceY);
	    
	    cannonBall_isAni[cannonBallIdx] = true;
	    cannonBall_Timer[cannonBallIdx] = 0;
	    
	    cannonBallIdx++;
	    if(cannonBallIdx == maxCannonBall){
	        cannonBallIdx = 0;
	    }
	    
	    Global.playLayer.setToBombingCannon(cannon.x(),cannon.y());
	    
	    if(!hasShotCannonBeforeNextChain){
	        hasShotCannonBeforeNextChain = true;
	        isShootingCannon = true;
	        shootCannonTimer = 0;
	    }
	    
	    Global.musicController.playThisSound(Global.kSound_TurtleExplode01,false,1.0);
	}
	
	public void  manageShootToNextChain()
	{
	    if(isShootingCannon){
	        
	        this.changePenguinPosition();
	        shootCannonTimer++;
	        
	        if(shootCannonTimer == 20){
	            hasShotCannonBeforeNextChain = false;
	            this.genNextShellChain();
	        }
	        
	        if(shootCannonTimer == 40){
	            isShootingCannon = false;
	            cannBall_isHittingFirstChain = !cannBall_isHittingFirstChain;
	        }
	        
	    }
	}
	
	public void  checkToAnyRemainShellHasntHitted()
	{
	    if(!isUsingFirstNowIsShellOnScreen){
	        for(int i = 0 ; i < maxShell ; i++){
	            if(nowIsShellOnScreen[i]){
	                nowIsShellOnScreen[i] = false;
	                this.setThisShellFuckBackPenguin(i);
	            }
	        }
	    }else{
	        for(int i = 0 ; i < maxShell ; i++){
	            if(nowIsShellOnScreen2[i]){
	                nowIsShellOnScreen2[i] = false;
	                this.setThisShellFuckBackPenguin(i);
	            }
	        }
	    }
	}
	
	public void  setThisShellFuckBackPenguin( int _shellIdx)
	{
	    shellIsFuckingPenguin[_shellIdx] = true;
	    shellIsFuckingpenguinTimer[_shellIdx] = 0;
	    isFuckedAndLoseCombo = true;
	}
	
	public void  changePenguinPosition()
	{
	    if(shootCannonTimer == 20){
	        if(!isClockwise){
	            this.setPenguinJump(true);
	        }else{
	            this.setPenguinJump(false);
	        }
	    }
	    
	}
	
	public void  managePenguinJump()
	{
	    if(!penguinIsJumping){
	        return;
	    }
	    
	    if(penguinJumpTimer == 0){
	        if(!isClockwise){
	        	Global.penguinJumpFinalX = penguin.x() + 65;
	        }else{
	        	Global.penguinJumpFinalX = penguin.x() - 65;
	        }
	        
	        Global.penguinJumpFinalY = penguin.y();
	        
	        penguin.setJump(Penguin.kPenguinJump_jumpTo1TurtleShell);
	        
	        penguinJumpingExternalStartX = PCX;
	    }
	    
	    if(penguinJumpTimer == 4){
	        if(isClockwise){
	            penguin.setFacingRight(true);
	        }else{
	            penguin.setFacingRight(false);
	        }
	    }
	    
	    if(penguinJumpTimer == 8){
	        if(isClockwise){
	            PCPOffsetX = 0;
	        }else{
	            PCPOffsetX = 65;
	        }
	        
	        penguinIsJumping = false;
	    }
	    
	    penguinJumpTimer++;
	    
	}
	             
	public void  setPenguinJump( boolean _isJumpingToRight)
	{
	    penguinJumpingToRight = _isJumpingToRight;
	    penguinJumpTimer = 0;
	    penguinIsJumping = true;
	}
	
	public void  updatePCPosition()
	{
	    if(isTappingRight){
	        PCVX+=PCAX;
	    }else if(isTappingLeft){
	        PCVX-=PCAX;
	    }else{
	        PCVX += (0.0 - PCVX)/8.0;
	    }
	    
	    
	    PCX += PCVX;
	    
	    int boundaryY;
	    
	    
	    if(isClockwise){
	        if(PCX < 7){
	            PCX = 7;
	            PCVX = 0;
	        }
	        
	        if(Global.isIphone5){
	            boundaryY = 414 + 88;
	        }else{
	            boundaryY = 414;
	        }
	        
	        if(PCX > 414){
	            PCX = 414;
	            PCVX = 0;
	        }
	    }else{
	        if(PCX < -14){
	            PCX = -14;
	            PCVX = 0;
	        }
	        
	        if(Global.isIphone5){
	            boundaryY = 390 + 88;
	        }else{
	            boundaryY = 390;
	        }
	        
	        if(PCX > 390){
	            PCX = 390;
	            PCVX = 0;
	        }
	    }
	    
	    penguin.setX(PCX+PCPOffsetX);
	    penguin.setY((int)PCY);
	
	    
	    cannon.setX(PCX + 40);
	    cannon.setY(PCY);
	    
	   
	}
	
	public void  beforeLoseComboWhenComboRemainGoesToZero()
	{
	    if(Global.currentCombo >= 5){
	        comboReduceSpeedAccum -= 0.004;
	        if(comboReduceSpeedAccum < -0.01){
	            comboReduceSpeedAccum = -0.01f;
	        }
	        comboReduceSpeedAccumSpeed = -comboReduceSpeedAccum;
	    }
	    
	}
}
