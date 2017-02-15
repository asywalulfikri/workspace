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
import com.zombieglider.Main.Turtle;


public class Mini07 extends MiniBasic
{
    Turtle turtle[] = new Turtle[20];
    Penguin penguin[] = new Penguin[20];
    Cannon cannon;
    
    CCSprite s_Cannon_Ball[] = new CCSprite[2];
    int maxCannonBall;
    int cannonBallIdx;
    
    float cannonBall_VX[] = new float[2];
    float cannonBall_VY[] = new float[2];
    float cannonBall_X[] = new float[2];
    float cannonBall_Y[] = new float[2];
    boolean cannonBall_isAni[] = new boolean[2];
    int cannonBall_Timer[] = new int[2];
    
    int maxTurtle;
    int maxPenguin;
    
    boolean isTappingLeft;
    boolean isTappingRight;
    
    float PCVX;
    float PCAX;
    float PCX;
    float PCY;
    float PCPOffsetX;
    
    int shootCannonTimer;
    boolean isShootingCannon;
    boolean hasShotOnceAndTakeRestForNextFuck;
    int hasShotOnceAndTakeRestForNextFuckTimer;
	
	
	
	public Mini07()
	{
		super();
	        
        s_bg = CCSprite.sprite("images/Main/mini 05/mini_05_bg.png");
        s_bg.setPosition(CGPoint.ccp(240,160));
        s_bg.setScale( 1.0f/Global.g_Scale );
		this.addChild(s_bg);
        
        Global.wholeCannonScaleFromSocurce = 0.5f;
        Global.wholePenguinScaleFromSocurce = 0.5f;
        Global.wholeTurtleScaleFromSocurce = 0.5f;
        
        maxTurtle = 20;
        maxPenguin = 20;
        
        PCAX = 0.5f;
        PCVX = 0;
        PCX = 150;
        PCY = 15;
        
        isTappingLeft = false;
        isTappingRight = false;
       
        this.initControlLayer();
        this.initCharacters();
        this.initCannon();
        this.initCannonBalls();
	    
	}
	
	public void  initCannon()
	{
		Global.cannonAngle = 90;
	    shootCannonTimer = 0;
	    isShootingCannon = false;
	    hasShotOnceAndTakeRestForNextFuck = false;
	    
	    cannon = new Cannon();
	    cannon.setDelegate(this);
	    
	    cannon.setCannonStatus(Cannon.kCannonStatus_Idle);
	    
	    cannon.setRotateDegree(Global.cannonAngle + 50.4801941f);
	    
	    cannon.setX(240);
	    cannon.setY(250);
	}
	
	public void  initCannonBalls()
	{
	    maxCannonBall = 2;
	    for(int i = 0 ; i < maxCannonBall ; i++){
	        s_Cannon_Ball[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(504/2, 724/2, 60/2, 58/2));
	        s_Cannon_Ball[i].setPosition(CGPoint.ccp(1000,100000));
	        Global.ss_Character.addChild(s_Cannon_Ball[i],Global.kDeapth_Extra2);
	        s_Cannon_Ball[i].setScale(1.12f);
	        cannonBall_isAni[i] = false;
	    }
	    cannonBallIdx = 0;
	}
	
	public void  initControlLayer()
	{
	    controlLayer = new ControlLayer();
		this.addChild(controlLayer,Global.kDeapth_Btns);
	    controlLayer.setDelegate(this);
	}
	
	public void  initCharacters()
	{
	    for(int i = 0 ; i < maxPenguin ; i++){
	        penguin[i] = new Penguin();
	        penguin[i].setX(25);
	        penguin[i].setY(14);
	        penguin[i].setStatus(Penguin.kPenguinAniStatus_Idle);
	    }
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i] = new Turtle();
	        turtle[i].setX(-9999);
	        turtle[i].setY(-9999);
	        turtle[i].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	        turtle[i].setIdNumber(i);
	        turtle[i].setDelegate(this);
	        turtle[i].setBombOutType(Turtle.kTurtleBombOutType_bombOutOffScreenWithGravity);
	        turtle[i].bombOutOffScreenDirection(Turtle.kBombOutOffScreenDirection_Right);
	        turtle[i].setGravity(true);
	    }
	    
	}
	
	public void  manage( float  dt)
	{
	    this.manageCannon();
	    this.manageCannonBalls();
	    this.updatePCPosition();
	    
	    cannon.manage();
	    
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i].manage(dt);
	    }
	    
	    for(int i = 0 ; i < maxPenguin ; i++){
	        penguin[i].manage();
	    }
	
	}
	
	public void  manageCannonBalls()
	{
	    
	    for(int i = 0 ; i < maxCannonBall ; i++){
	        if(cannonBall_isAni[i]){
	            cannonBall_X[i] += cannonBall_VX[i];
	            cannonBall_Y[i] += cannonBall_VY[i];
	            
	            s_Cannon_Ball[i].setPosition(CGPoint.ccp(cannonBall_X[i],cannonBall_Y[i]));
	            
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
	    
	    cannonBall_VY[cannonBallIdx] = -15;
	    cannonBall_VX[cannonBallIdx] = 0;
	    
	    cannonBall_isAni[cannonBallIdx] = true;
	    cannonBall_Timer[cannonBallIdx] = 0;
	    
	    cannonBallIdx++;
	    if(cannonBallIdx == maxCannonBall){
	        cannonBallIdx = 0;
	    }
	    
	    Global.playLayer.setToBombingCannon(cannon.x(),cannon.y());
	    
	    Global.musicController.playThisSound(Global.kSound_TurtleExplode01,false,1.0);
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
	
	public void  updatePCPosition()
	{
	    if(isTappingRight){
	        PCVX = 7;
	    }else if(isTappingLeft){
	        PCVX = -7;
	    }else{
	        PCVX = 0;
	    }
	    
	    
	    PCX += PCVX;
	    
	    if(PCX < 7){
	        PCX = 7;
	        PCVX = 0;
	    }
	    if(PCX > 414){
	        PCX = 414;
	        PCVX = 0;
	    }
	   
	    
	    cannon.setX(PCX);
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
	        
	        if(location.y < 90){
	            if(location.x > 84 && location.x < 396){
	                this.shootCannon();
	            } 
	        }
	        
	        if(location.y < 258 && location.y > 90){
	            this.shootCannon();
	        }
	    }
		return true;
	    
	}


}
