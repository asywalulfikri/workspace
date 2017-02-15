package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.Cannon;
import com.zombieglider.Main.Penguin;
import com.zombieglider.Main.Turtle;

public class Mini03 extends MiniBasic
{
    Turtle turtle[] = new Turtle[10];
    Penguin penguin[] = new Penguin[2];
    Cannon cannon[] = new Cannon[2];
    CCSprite s_bomb[] = new CCSprite[10];
    
    float bomb_x[] = new float[10];
    float bomb_y[] = new float[10];
    float bomb_vx[] = new float[10];
    float bomb_vy[] = new float[10];
    float bomb_r[] = new float[10];
    float bomb_vr[] = new float[10];
    float bomb_ar[] = new float[10];
    
    int maxTurtle;
    int maxPenguin;
    int maxBomb;
    
    int turtleShootIdx;
    int penguinShootIdx;
    int bombShootIdx;
    
    float cannonFinalAngle;
    float cannonFinalRanAngle;
    float cannonDiffAngle;
    boolean cannonIsRotatingClockwise;
    
    int nextShootTimer;
    int minShootTime[] = new int[3];
    int shootInterval[] = new int[3];
    int ranShootIntrval;
    int bombShootRatio;
    
    int turtleAppearRatio;
    int ranAnimalRatio;
    
    float detectTurtleRadius;
    float detectBombRadius;
    
    int maxShellLevel;
    int shellLevelAppearRatio[] = new int[3];
    int nextShellGen;
    
    boolean isTappingTurtle;
    
    boolean canShootBomb;
    int hasDeadTimer;
    boolean hasDead;
    
    CCSprite s_shadow_cannon;
    CCSprite s_shadow_penguin;

	
	public void  reInitColorComboLimit()
	{
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
	    Global.timeToBeGained = 6.0f;
	    
	}
	
	public void  updategameLevel()
	{
	    
	    Global.comoboReduceSpeed = 0.003f;
	    
	    if(Global.gameRound < 6){
	        Global.gameLevel = 0;
	    }else if(Global.gameRound < 12){
	        Global.gameLevel = 1;
	    }else if(Global.gameRound < 25){
	        Global.gameLevel = 2;
	    }else if(Global.gameRound < 40){
	        Global.gameLevel = 3;
	    }else if(Global.gameRound < 60){
	        Global.gameLevel = 4;
	    }else if(Global.gameRound < 90){
	        Global.gameLevel = 5;
	    }else if(Global.gameRound < 120){
	        Global.gameLevel = 6;
	    }else if(Global.gameRound < 150){
	        Global.gameLevel = 7;
	    }else if(Global.gameRound < 190){
	        Global.gameLevel = 8;
	    }else if(Global.gameRound < 240){
	        Global.gameLevel = 9;
	    }else if(Global.gameRound < 300){
	        Global.gameLevel = 10;
	    }else if(Global.gameRound < 360){
	        Global.gameLevel = 11;
	    }
	
	    
	    if(Global.gameLevel == 0){
	        shellLevelAppearRatio[0] = 100;
	        shellLevelAppearRatio[1] = 100;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 40;
	        shootInterval[0] = 50;
	        
	        bombShootRatio = 999999;
	    }
	    if(Global.gameLevel == 1){
	        shellLevelAppearRatio[0] = 100;
	        shellLevelAppearRatio[1] = 100;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 35;
	        shootInterval[0] = 40;
	        
	        bombShootRatio = 999999;
	    }
	    
	    if(Global.gameLevel == 2){
	        shellLevelAppearRatio[0] = 90;
	        shellLevelAppearRatio[1] = 100;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 35;
	        shootInterval[0] = 35;
	        
	        minShootTime[1] = 60;
	        shootInterval[1] = 50;
	        
	        bombShootRatio = 1000;
	    }
	    
	    if(Global.gameLevel == 3){
	        shellLevelAppearRatio[0] = 80;
	        shellLevelAppearRatio[1] = 95;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 30;
	        shootInterval[0] = 35;
	        
	        minShootTime[1] = 55;
	        shootInterval[1] = 45;
	        
	        minShootTime[2] = 70;
	        shootInterval[2] = 50;
	        
	        bombShootRatio = 800;
	    }
	    
	    if(Global.gameLevel == 4){
	        shellLevelAppearRatio[0] = 70;
	        shellLevelAppearRatio[1] = 90;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 25;
	        shootInterval[0] = 30;
	        
	        minShootTime[1] = 50;
	        shootInterval[1] = 40;
	        
	        minShootTime[2] = 65;
	        shootInterval[2] = 45;
	        
	        bombShootRatio = 550;
	    }
	    
	    if(Global.gameLevel == 5){
	        shellLevelAppearRatio[0] = 60;
	        shellLevelAppearRatio[1] = 85;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 20;
	        shootInterval[0] = 25;
	        
	        minShootTime[1] = 45;
	        shootInterval[1] = 35;
	        
	        minShootTime[2] = 60;
	        shootInterval[2] = 40;
	        
	        bombShootRatio = 300;
	    }
	    
	    if(Global.gameLevel == 6){
	        shellLevelAppearRatio[0] = 55;
	        shellLevelAppearRatio[1] = 85;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 20;
	        shootInterval[0] = 20;
	        
	        minShootTime[1] = 45;
	        shootInterval[1] = 30;
	        
	        minShootTime[2] = 60;
	        shootInterval[2] = 25;
	        
	        bombShootRatio = 200;
	    }
	    
	    //FIRST
	    if(Global.gameLevel == 7){
	        shellLevelAppearRatio[0] = 50;
	        shellLevelAppearRatio[1] = 80;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 20;
	        shootInterval[0] = 15;
	        
	        minShootTime[1] = 40;
	        shootInterval[1] = 25;
	        
	        minShootTime[2] = 55;
	        shootInterval[2] = 25;
	        
	        bombShootRatio = 100;
	    }
	    
	    if(Global.gameLevel == 8){
	        shellLevelAppearRatio[0] = 45;
	        shellLevelAppearRatio[1] = 75;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 20;
	        shootInterval[0] = 10;
	        
	        minShootTime[1] = 40;
	        shootInterval[1] = 20;
	        
	        minShootTime[2] = 55;
	        shootInterval[2] = 20;
	        
	        bombShootRatio = 90;
	    }
	    
	    if(Global.gameLevel == 9){
	        shellLevelAppearRatio[0] = 45;
	        shellLevelAppearRatio[1] = 75;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 15;
	        shootInterval[0] = 10;
	        
	        minShootTime[1] = 35;
	        shootInterval[1] = 20;
	        
	        minShootTime[2] = 50;
	        shootInterval[2] = 20;
	        
	        bombShootRatio = 80;
	    }
	    
	    if(Global.gameLevel == 10){
	        shellLevelAppearRatio[0] = 45;
	        shellLevelAppearRatio[1] = 75;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 10;
	        shootInterval[0] = 10;
	        
	        minShootTime[1] = 30;
	        shootInterval[1] = 20;
	        
	        minShootTime[2] = 45;
	        shootInterval[2] = 20;
	        
	        bombShootRatio = 70;
	    }
	    
	    if(Global.gameLevel == 11){
	        shellLevelAppearRatio[0] = 45;
	        shellLevelAppearRatio[1] = 75;
	        shellLevelAppearRatio[2] = 100;
	        
	        minShootTime[0] = 10;
	        shootInterval[0] = 5;
	        
	        minShootTime[1] = 30;
	        shootInterval[1] = 15;
	        
	        minShootTime[2] = 45;
	        shootInterval[2] = 15;
	        
	        bombShootRatio = 55;
	    }
	    
	    comboReduceSpeedAccum-=3;
	    
	    if(comboReduceSpeedAccum < 0 ){
	        comboReduceSpeedAccum = 0;
	    }
	    
	    minShootTime[0] += comboReduceSpeedAccum;
	    minShootTime[1] += comboReduceSpeedAccum;
	    minShootTime[2] += comboReduceSpeedAccum;
	    
	    shootInterval[0] += comboReduceSpeedAccum;
	    shootInterval[1] += comboReduceSpeedAccum;
	    shootInterval[2] += comboReduceSpeedAccum;
	    
	   this.reInitColorComboLimit();
	
	}
	
	
	public Mini03()
	{
		super();
        
		Global.maxTime = 30;
		Global.timeRemain = Global.maxTime;
        finalTimeRemain = Global.timeRemain;
        hasDead = false;
        
        this.updategameLevel();
        
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
        
        canShootBomb = false;
        isTappingTurtle = false;
        nextShootTimer= 15;
        
        Global.wholeTurtleScaleFromSocurce = 0.5f;
        Global.wholePenguinScaleFromSocurce = 0.5f;
        Global.wholeCannonScaleFromSocurce = 0.5f;
        
        Global.cannonAngle = -45;
        
                
        turtleAppearRatio = 100;
        
        detectTurtleRadius = 53;
        detectBombRadius = 40;
        
        nextShellGen = 0;
        nextShootTimer = 50;
        
        this.initShadows();
        this.initCharacters();
        this.initCannon();
        this.initBombs();

	}
	
	public void  initShadows()
	{
	    s_shadow_cannon = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1550/2*Global.g_Scale, 640/2*Global.g_Scale, 366/2*Global.g_Scale, 28/2*Global.g_Scale));
	    s_shadow_penguin = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1550/2*Global.g_Scale, 610/2*Global.g_Scale, 204/2*Global.g_Scale, 26/2*Global.g_Scale));
	    
	    Global.ss_Character.addChild(s_shadow_cannon);
	    Global.ss_Character.addChild(s_shadow_penguin);
	    s_shadow_penguin.setScale(1.0f/Global.g_Scale);
	    s_shadow_cannon.setScale(1.0f/Global.g_Scale);
	    s_shadow_penguin.setPosition(CGPoint.ccp(20,12));
	    s_shadow_cannon.setPosition(CGPoint.ccp(62,6));
	}
	
	public void  initBombs()
	{
	    maxBomb = 10;
	    bombShootIdx = 0;
	    
	    for(int i = 0 ; i < maxBomb ; i++){
	        s_bomb[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1948/2*Global.g_Scale, 636/2*Global.g_Scale, 100/2*Global.g_Scale, 106/2*Global.g_Scale));
	        Global.ss_Character.addChild(s_bomb[i],Global.kDeapth_Bg_Element1);
	        s_bomb[i].setScale(1.0f/Global.g_Scale);
	        s_bomb[i].setPosition(CGPoint.ccp(1000,10000));
	    }
	}
	
	public void  initCharacters()
	{
	    maxTurtle = 10;
	    maxPenguin = 10;
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i] = new Turtle();
	        turtle[i].setX(-9999);
	        turtle[i].setY(-9999);
	        turtle[i].setStatus(Global.kTurtleAniStatus_Normal_In);
	        turtle[i].setIdNumber(i);
	        turtle[i].setDelegate(this);
	        turtle[i].setBombOutType(Global.kTurtleBombOutType_bombOutOffScreenWithGravity);
	        turtle[i].bombOutOffScreenDirection(Global.kBombOutOffScreenDirection_Right);
	        turtle[i].setGravity(true);
	    }
	    
	    penguin[0] = new Penguin();
	    penguin[0].setX(15);
	    penguin[0].setY(14);
	    penguin[0].setStatus(Penguin.kPenguinAniStatus_Idle);
	    penguin[0].setDelegate(this);
	    
	    penguin[1] = new Penguin();
	    penguin[1].setX(465000);
	    penguin[1].setY(14);
	    penguin[1].setStatus(Penguin.kPenguinAniStatus_Idle);
	    penguin[1].setDelegate(this);
	    penguin[1].setFacingRight(false);
	}
	
	public void  initCannon()
	{	
	    cannon[0] = new Cannon();
	    cannon[0].setDelegate(this);
	    cannon[0].setCannonStatus(Cannon.kCannonStatus_Idle);
	    cannon[0].setIdNumber(0);
	    cannon[0].setX(55);
	    cannon[0].setY(7);
	    
	    cannon[1] = new Cannon();
	    cannon[1].setDelegate(this);
	    cannon[1].setCannonStatus(Cannon.kCannonStatus_Idle);
	    cannon[1].setIdNumber(1);
	    cannon[1].setX(450000);
	    cannon[1].setY(7);
	    
	}
	
	public void  cannonShootBall( int _fromId)
	{
	    Global.playLayer.setToBombingCannon(cannon[_fromId].x(),cannon[_fromId].y());
	}
	
	public void  manage( float  dt)
	{
	    Global.timeRemain += (finalTimeRemain - Global.timeRemain)/10;
	    
	    for ( int i = 0 ; i < maxTurtle ; i++){
	        turtle[i].manage(dt);
	    }
	    
	    for ( int i = 0 ; i < 2 ; i++){
	        penguin[i].manage();
	    }
	    
	    
	    cannon[0].manage();
	    cannon[1].manage();
	    cannon[0].setRotateDegree((float) (Global.cannonAngle + 50.4801941));
	  
	    
	    this.manageTurtleHeadOut();
	    
	    this.genNextShoot();
	    
	    this.mangeCannonAI();
	    this.manageBomb();
	    
	    this.checkCollisionOnWall();
	    
	    if(hasDead){
	        hasDeadTimer++;
	        if(hasDeadTimer >= 99){
	            hasDead = false;
	        }
	    }
	  
	}
	
	public void  manageTurtleHeadOut()
	{
	    
	}
	
	public void  genNextShoot()
	{
	    nextShootTimer--;
	    
	    if(nextShootTimer < 0){
	        ranShootIntrval = (int) ((Math.random()*65535) % shootInterval[nextShellGen]);
	        nextShootTimer = ranShootIntrval + minShootTime[nextShellGen];
	        
	        turtleAppearRatio = 100;
	        this.shootAnAnimal(0);
	    }else{
	        if((Math.random()*65535)%bombShootRatio == 0 && canShootBomb){
	            turtleAppearRatio = 0;
	            this.shootAnAnimal(0);
	        }
	    }
	    
	}
	
	public void  shootAnAnimal( int _cannonIdx)
	{
	    this.updategameLevel();
	    
	    canShootBomb = true;
	    
	    float ranForce = 0;
	
	    ranAnimalRatio = (int) ((Math.random()*65535)%100);
	    if(ranAnimalRatio < turtleAppearRatio){
	
	        ranForce = (float) ((Math.random()*65535) % 9);
	        ranForce+=5;
	        turtle[turtleShootIdx].resetHurtTime();
	        turtle[turtleShootIdx].setRotation(45);
	        turtle[turtleShootIdx].shotFromCannonAtX(cannon[_cannonIdx].cannonFrontX(),cannon[_cannonIdx].cannonFrontY(),7,Global.cannonAngle);
	        cannon[_cannonIdx].setCannonStatus(Cannon.kCannonStatus_Shooting);
	        
	        
	        turtle[turtleShootIdx].setShellLevel(nextShellGen);
	        
	        int ranShellLevel;
	        ranShellLevel = (int) ((Math.random()*65535)%100);
	        if(ranShellLevel < shellLevelAppearRatio[0]){
	            nextShellGen = 0;
	        }else if(ranShellLevel < shellLevelAppearRatio[1]){
	            nextShellGen = 1;
	        }else{
	            nextShellGen = 2;
	        }
	        
	        turtleShootIdx++;
	        if(turtleShootIdx >= maxTurtle){
	            turtleShootIdx = 0;
	        }
	        
	    }else{
	        
	        ranForce = (float) ((Math.random()*65535) % 9);
	        ranForce+=5;
	        this.shotFromCannonAtX(cannon[_cannonIdx].cannonFrontX(),cannon[_cannonIdx].cannonFrontY(),9,Global.cannonAngle);
	        cannon[_cannonIdx].setCannonStatus(Cannon.kCannonStatus_Shooting);
	        
	        bombShootIdx++;
	        if(bombShootIdx >= maxBomb){
	            bombShootIdx = 0;
	        }
	    }
	}
	
	public void  shotFromCannonAtX( float _x, float _y, float _force, float _angle)
	{
	    bomb_x[bombShootIdx] = _x;
	    bomb_y[bombShootIdx] = _y;
	    
	    bomb_vx[bombShootIdx] = (float) (_force * Math.cos(-_angle * Math.PI/180));
	    bomb_vy[bombShootIdx] = (float) (_force * Math.sin(-_angle * Math.PI/180) * 2.5);
	    
	    bomb_ar[bombShootIdx] = _force/5.5f;
	}
	
	public void  manageBomb()
	{
	    for(int i = 0 ; i < maxBomb ; i++){
	        bomb_vx[i] += 0;
	        bomb_vy[i] += -0.75;
	        
	        bomb_x[i] += bomb_vx[i];
	        bomb_y[i] +=  bomb_vy[i];
	        
	        bomb_vr[i] += bomb_ar[i];
	        bomb_r[i] += bomb_vr[i];
	        
	        bomb_ar[i] /= 10;
	        
	        
	        s_bomb[i].setPosition(CGPoint.ccp(bomb_x[i], bomb_y[i]));
	        s_bomb[i].setRotation(bomb_r[i]);
	    }
	}
	
	public void  mangeCannonAI()
	{
	    if(nextShootTimer == 10){
	        
	        cannonFinalRanAngle = (float) ((Math.random()*65535) % 30);
	        cannonFinalAngle = -30 - cannonFinalRanAngle;
	        
	        if(Global.gameLevel == 0){
	            if(cannonFinalAngle > -45){
	                cannonFinalAngle = -45;
	            }
	        }
	        if(Global.gameLevel == 1){
	            if(cannonFinalAngle > -40){
	                cannonFinalAngle = -40;
	            }
	        }
	        if(Global.gameLevel == 2){
	            if(cannonFinalAngle > -35){
	                cannonFinalAngle = -35;
	            }
	        }
	        
	        
	        cannonDiffAngle = cannonFinalAngle - Global.cannonAngle;
	        if(cannonDiffAngle > 0){
	            cannonIsRotatingClockwise = true;
	        }else{
	            cannonIsRotatingClockwise = false;
	        }
	    }
	    if(nextShootTimer < 10 && nextShootTimer > 0){
	    	Global.cannonAngle += cannonDiffAngle / 3;
	        
	        if(cannonIsRotatingClockwise){
	            if(Global.cannonAngle - cannonFinalAngle > 0){
	            	Global.cannonAngle = cannonFinalAngle;
	            }
	        }else{
	            if(Global.cannonAngle - cannonFinalAngle < 0){
	            	Global.cannonAngle = cannonFinalAngle;
	            }
	        }
	        
	        cannon[0].setRotation(Global.cannonAngle + 50.4801941f);
	    }
	    
	}
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    if(!isTappingTurtle){
	        super.ccTouchesBegan(event);
	        isTappingTurtle = false;
	    }
	    
	    
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
	    
	    float fuxkTurtleAtX;
	    float fuxkTurtleAtY;
	    
	    float fuxkDistanceDiff;
	    float fuxkDistanceDiffX;
	    float fuxkDistanceDiffY;
	    
	    isTappingTurtle = false;
		for( int ii = 0; ii < event.getPointerCount(); ii++ ) {
			CGPoint location = CGPoint.ccp(event.getX(ii), event.getY(ii));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        
	        for(int i = 0 ; i < maxTurtle ; i++){
	            
	            fuxkTurtleAtX = turtle[i].x();
	            fuxkTurtleAtY = turtle[i].y();
	            
	            if(fuxkTurtleAtX > 0 && fuxkTurtleAtX < 480){
	                if(fuxkTurtleAtY > 0 && fuxkTurtleAtY < 320){
	                    
	                    fuxkDistanceDiffX = (float) (fuxkTurtleAtX - 11 * Math.cos(turtle[i].rotation() * Math.PI/180) - location.x);
	                    fuxkDistanceDiffY = (float) (fuxkTurtleAtY + 11 * Math.sin(turtle[i].rotation() * Math.PI/180) - location.y);
	                    fuxkDistanceDiff = (float) Math.sqrt(fuxkDistanceDiffX*fuxkDistanceDiffX + fuxkDistanceDiffY*fuxkDistanceDiffY);
	                    
	                    if(fuxkDistanceDiff < detectTurtleRadius){
	                        isTappingTurtle = true;
	                        turtle[i].tap3();
	                    }else{
	                        fuxkDistanceDiffX = (float) (fuxkTurtleAtX + 11 * Math.cos(turtle[i].rotation() * Math.PI/180) - location.x);
	                        fuxkDistanceDiffY = (float) (fuxkTurtleAtY - 11 * Math.sin(turtle[i].rotation() * Math.PI/180) - location.y);
	                        fuxkDistanceDiff = (float) Math.sqrt(fuxkDistanceDiffX*fuxkDistanceDiffX + fuxkDistanceDiffY*fuxkDistanceDiffY);
	                        
	                        if(fuxkDistanceDiff < detectTurtleRadius){
	                            isTappingTurtle = true;
	                            turtle[i].tap3();
	                        }else{
	                            fuxkDistanceDiffX = fuxkTurtleAtX - location.x;
	                            fuxkDistanceDiffY = fuxkTurtleAtY - location.y;
	                            fuxkDistanceDiff = (float) Math.sqrt(fuxkDistanceDiffX*fuxkDistanceDiffX + fuxkDistanceDiffY*fuxkDistanceDiffY);
	                            
	                            if(fuxkDistanceDiff < detectTurtleRadius){
	                                isTappingTurtle = true;
	                                turtle[i].tap3();
	                            }
	                        }
	                    }
	                    
	                }
	            }
	
	        }
	        
	        
	        for(int i = 0 ; i < maxBomb ; i++){
	            
	            fuxkTurtleAtX = bomb_x[i];
	            fuxkTurtleAtY = bomb_y[i];
	            
	            fuxkDistanceDiffX = fuxkTurtleAtX - location.x;
	            fuxkDistanceDiffY = fuxkTurtleAtY - location.y;
	            fuxkDistanceDiff = (float) Math.sqrt(fuxkDistanceDiffX*fuxkDistanceDiffX + fuxkDistanceDiffY*fuxkDistanceDiffY);
	            
	            if(fuxkDistanceDiff < detectBombRadius){
	                this.tapThisBomb(i);
	            }
	            
	        }
	        
	    }
		return true;
	    
	    
	}
	
	public void  checkCollisionOnWall()
	{
	    for(int i = 0 ; i < maxTurtle ; i++){
	        if(turtle[i].x() > 460 || turtle[i].x() < 20){
	            turtle[i].collisionOnWall();
	        }
	        
	        if(turtle[i].y() < -20 && turtle[i].y() > -100){
	            Global.uILayer.lostCombo();
	            turtle[i].setY(-99999);
	            
	            if(!hasDead){
	                comboReduceSpeedAccum = 30;
	                finalTimeRemain -= 10.05;
	                hasDead = true;
	            }
	            
	            nextShootTimer = 100;
	            canShootBomb = false;
	        }
	    }
	}
	
	public void  tapThisBomb( int _bombIdx)
	{
		Global.playLayer.setToBombing(bomb_x[_bombIdx],bomb_y[_bombIdx]);
		Global.playLayer.setToBombingGameover();
	    bomb_x[_bombIdx] = 99999;
	    nextShootTimer = 100;
	    canShootBomb = false;
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        if(turtle[i].y() > 0 && turtle[i].y() < 320){
	            turtle[i].bombButLoseCombo();
	        }
	    }
	    
	    Global.uILayer.lostCombo();
	    
	    if(!hasDead){
	        comboReduceSpeedAccum = 30;
	        finalTimeRemain -= 10.05;
	        hasDead = true;
	    }
	    
	}
	
	public void  turtleBombed( int _momentIdx)
	{
	}
}
