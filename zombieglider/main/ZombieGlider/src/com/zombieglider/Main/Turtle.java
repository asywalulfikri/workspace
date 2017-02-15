package com.zombieglider.Main;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.config.ccMacros;
import org.cocos2d.nodes.CCSprite;

import com.zombieglider.Global;
import com.zombieglider.Main.Mini.MiniBasic;

public class Turtle
{
	static final int kTurtleShellColor_Brown = 0;
	static final int kTurtleShellColor_Red = 1;
	static final int kTurtleShellColor_Green = 2;
	static final int kTurtleShellColor_Blue = 3;
	static final int kTurtleShellColor_BrownOri = 4;
	
	static final int kTurtlePart_Shadow = 0;
	static final int kTurtlePart_Neck = 1;
	static final int kTurtlePart_Head = 2;
	    
	static final int kTurtlePart_Eye = 3;
	static final int kTurtlePart_Jaw = 4;
	    
	static final int kTurtlePart_Tail = 5;
	static final int kTurtlePart_Shell = 6;
	static final int kTurtlePart_LeftLeg = 7;
	static final int kTurtlePart_RightLeg = 8;
	    
	static final int kTurtlePart_Glide = 9;
	static final int kTurtlePart_Line = 10;
	static final int kTurtlePart_Rocket = 11;
	static final int kTurtlePart_Helmet = 12;
	static final int kTurtlePart_Rope = 13;
	
	public static final int kTurtleAniStatus_Normal_Out = 0;
	public static final int kTurtleAniStatus_Normal_In = 1;
	public static final int kTurtleAniStatus_Idle = 2;
	public static final int kTurtleAniStatus_In = 3;
	public static final int kTurtleAniStatus_Out = 4;
	public static final int kTurtleAniStatus_Bombing = 5;
	public static final int kTurtleAniStatus_Shaking = 6;
	public static final int kTurtleAniStatus_Flying = 7;
	public static final int kTurtleAniStatus_Colliding = 8;
	
	
	public static final int kTurtleBombOutType_backToOri = 0;
	public static final int kTurtleBombOutType_bombOutOffScreen = 1;
	public static final int kTurtleBombOutType_bombOutOffScreenWithGravity = 2;
	
	
	public static final int kBombOutOffScreenDirection_Left = 0;
	public static final int kBombOutOffScreenDirection_Right = 1;
	
    int status;
    
    int color;
    
    boolean isWinking;
    int winkingTimer;

    int turtleAniSte;
    int turtleAniStep;
    int turtleAniStep2;
    int turtleBombAniStep;
    
    float bomb_force;
    float bomb_x;
    float bomb_y;
    float bomb_vx;
    float bomb_vy;
    float bomb_oriVy;
    float bomb_ay;
    float bomb_floorY;
    boolean bomb_isHittedFloor;
    boolean bomb_hasOnceHittedFloor;
    int bomb_hitFloorTimer;
    boolean bomb_isRotatingClockrise;
    float bomb_vr;
    float bomb_shadowOpacity;
    float bomb_shadowScaleY;
    
    float turtleOriX;
    float turtleOriY;
    float turtleX;
    float turtleY;
    float turtleRotation;
    float prevTurtleRotation;
    
    float turtleAX;
    float turtleAY;
    float turtleVX;
    float turtleVY;
    float turtleVR;
    float turtleAR;
    boolean isGravity;
    
    CCSprite s_Turtle_HeadAndNeck;
    CCSprite s_Turtle_Head;
    CCSprite s_Turtle_Jaw;
    CCSprite s_Turtle_Neck;
    CCSprite s_Turtle_Shell;
    CCSprite s_Turtle_LeftLeg;
    CCSprite s_Turtle_RightLeg;
    CCSprite s_Turtle_Tail;
    CCSprite s_Turtle_Shadow;
    CCSprite s_Turtle_Eye;
    CCSprite s_Turtle_Spike[] = new CCSprite[4];
    
    double turtle_HeadAndNeck_r;
    double turtle_Head_r;
    double turtle_Jaw_r;
    double turtle_Neck_r;
    double turtle_Shell_r;
    double turtle_LeftLeg_r;
    double turtle_RightLeg_r;
    double turtle_Tail_r;
    double turtle_Shadow_r;
    double turtle_Eye_r;
    float turtle_Spike_r[] = new float[4];
    
    double turtle_HeadAndNeck_x;
    double turtle_Head_x;
    double turtle_Jaw_x;
    double turtle_Neck_x;
    double turtle_Shell_x;
    double turtle_LeftLeg_x;
    double turtle_RightLeg_x;
    double turtle_Tail_x;
    double turtle_Shadow_x;
    double turtle_Eye_x;
    float turtle_Spike_x[] = new float[4];
    
    double turtle_HeadAndNeck_y;
    double turtle_Head_y;
    double turtle_Jaw_y;
    double turtle_Neck_y;
    double turtle_Shell_y;
    double turtle_LeftLeg_y;
    double turtle_RightLeg_y;
    double turtle_Tail_y;
    double turtle_Shadow_y;
    double turtle_Eye_y;
    float turtle_Spike_y[] = new float[4];
    
    float turtle_Shell_scaleX;
    float turtle_Shell_scaleY;
    
    boolean isFacingRight;
    
    int shellLevel;
    int hurtTime;
    boolean hasSpike;
    int spikeRemoveAniTimer;
    boolean spikeRemoveIsAni;
    float spikePosX[] = new float[4];
    float spikePosY[] = new float[4];
    float spikeOpacity;
    
    int bombOutType;
    
    boolean isCountAlready;
    
    float externalOffsetX;
    float externalOffsetY;
    float externalOffsetX2;
    float externalOffsetY2;
    float externalOffsetFinalX;
    float externalOffsetFinalY;
    boolean isExternalOffseting;
    
    MiniBasic delegate;
    
    int idNumber;
    float showingHeadTime;
    int momentIdx;
    
    int bombOutOffScreenDirection;
    
    boolean isChangingWholeScale;
    
     double superFuxkAngleDiff;
     double superFuxkOriX;
     double superFuxkOriY;
    
    
    boolean isBombShell;
    
    boolean isYellowHurt;
    int yellowHurtTimer;

	
	public void  setScaleYForShell( float _scaleY)
	{
	    turtle_Shell_scaleY = _scaleY;
	}
	
	public void  setScaleXForShell( float _scaleX)
	{
	    turtle_Shell_scaleX = _scaleX;
	}
	
	public float  rotation()
	{
	    return turtleRotation;
	}
	
	public void  collisionOnWall()
	{
	    turtleVX *= -1;
	}
	
	public void  resetHurtTime()
	{
	    hurtTime = 0;
	}
	
	public void  setRotation( float _rotation)
	{
	    turtleRotation = _rotation;
	}
	
	public void  setWholeScale( float _wholeScale)
	{
	    Global.wholeTurtleScaleFromSocurce = (float) (_wholeScale * 0.5);
	    isChangingWholeScale = true;
	}
	
	
	public void  setDelegate( MiniBasic _delegate)
	{
	    delegate = _delegate;
	}
	
	public int  shellLevel()
	{
	    return shellLevel;
	}
	
	public int  hurtTime()
	{
	    return hurtTime;
	}
	
	public float  x()
	{
	    return turtleX;
	}
	public float  y()
	{
	    return turtleY;
	}
	
	public int  color()
	{
	    return color;
	}
	
	public int  idNumber()
	{
	    return idNumber;
	}
	
	public void  setFacingRight( boolean _isRight)
	{
	    isFacingRight = _isRight;
	}
	
	public void  setExternalOffsetFinalX( float _ex)
	{
	    externalOffsetFinalX = _ex;
	}
	
	public void  setExternalOffsetFinalY( float _ey)
	{
	    externalOffsetFinalY = _ey;
	}
	
	public void  setExternalOffsetFinalXALL( float _ex)
	{
	    externalOffsetFinalX = _ex;
	    externalOffsetX2 = _ex;
	}
	
	public void  setIdNumber( int _idNumber)
	{
	    idNumber = _idNumber;
	}
	
	public void  setMomentIdx( int _momentIdx)
	{
	    momentIdx = _momentIdx;
	}
	
	public void  setColor( int _color)
	{
	    color = _color;
	
	}
	
	public void  setGravity( boolean _gravity)
	{
	    isGravity = _gravity;
	    
	     turtleAX = 0;
	     turtleAY = -0.75f;
	     turtleVX = 0;
	     turtleVY = 0;
	     turtleVR = 0;
	     turtleAR = 0;
	}
	
	public void  bombOutOffScreenDirection( int _bomOutOffScreenDirection)
	{
	    bombOutOffScreenDirection = _bomOutOffScreenDirection;
	}
	
	public Turtle()
	{
		super();
        delegate = null;
        
        isBombShell = false;
        
        isGravity = false;
        
        isChangingWholeScale = false;
        
        color = kTurtleShellColor_BrownOri;
        
        turtleRotation = 0;
        
        isFacingRight = false;
        isYellowHurt = false;
        
        turtle_HeadAndNeck_x = 9999;
        turtle_Head_x = 9999;
        turtle_Jaw_x = 9999;
        turtle_Neck_x = 9999;
        turtle_Shell_x = 9999;
        turtle_LeftLeg_x = 9999;
        turtle_RightLeg_x = 9999;
        turtle_Tail_x = 9999;
        turtle_Shadow_x = 9999;
        turtle_Eye_x = 9999;
        turtle_Spike_x[0] = 9999;
        turtle_Spike_x[1] = 9999;
        turtle_Spike_x[2] = 9999;
        turtle_Spike_x[3] = 9999;
        
        turtle_HeadAndNeck_y = 9999;
        turtle_Head_y = 9999;
        turtle_Jaw_y = 9999;
        turtle_Neck_y = 9999;
        turtle_Shell_y = 9999;
        turtle_LeftLeg_y = 9999;
        turtle_RightLeg_y = 9999;
        turtle_Tail_y = 9999;
        turtle_Shadow_y = 9999;
        turtle_Eye_y = 9999;
        turtle_Spike_y[0] = 9999;
        turtle_Spike_y[1] = 9999;
        turtle_Spike_y[2] = 9999;
        turtle_Spike_y[3] = 9999;
        
       
        
        s_Turtle_HeadAndNeck = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0,0,0,0));
        s_Turtle_HeadAndNeck.setAnchorPoint(0,0);
        s_Turtle_Head = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(213/2*Global.g_Scale,162/2*Global.g_Scale,104/2*Global.g_Scale,107/2*Global.g_Scale));
        s_Turtle_Neck = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(340/2*Global.g_Scale,221/2*Global.g_Scale,50/2*Global.g_Scale,63/2*Global.g_Scale));
        s_Turtle_Shell = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(396/2*Global.g_Scale,200/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
        s_Turtle_LeftLeg = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(360/2*Global.g_Scale,162/2*Global.g_Scale,34/2*Global.g_Scale,38/2*Global.g_Scale));
        s_Turtle_RightLeg = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(360/2*Global.g_Scale,162/2*Global.g_Scale,34/2*Global.g_Scale,38/2*Global.g_Scale));
        s_Turtle_Tail = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(396/2*Global.g_Scale,162/2*Global.g_Scale,44/2*Global.g_Scale,29/2*Global.g_Scale));
        s_Turtle_Shadow = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(226/2*Global.g_Scale,278/2*Global.g_Scale,152/2*Global.g_Scale,12/2*Global.g_Scale));
        s_Turtle_Eye = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(226/2*Global.g_Scale,278/2*Global.g_Scale,0/2,0/2));
        s_Turtle_Jaw = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1976/2*Global.g_Scale,320/2*Global.g_Scale,58/2*Global.g_Scale,51/2*Global.g_Scale));
        
        Global.ss_Character.addChild(s_Turtle_HeadAndNeck,Global.kDeapth_Turtle_HeadAndNeck);
        Global.ss_Character.addChild(s_Turtle_Head,Global.kDeapth_Turtle_Head);
        Global.ss_Character.addChild(s_Turtle_Neck,Global.kDeapth_Turtle_Neck);
        Global.ss_Character.addChild(s_Turtle_Shell,Global.kDeapth_Turtle_Shell);
        Global.ss_Character.addChild(s_Turtle_LeftLeg,Global.kDeapth_Turtle_LeftLeg);
        Global.ss_Character.addChild(s_Turtle_RightLeg,Global.kDeapth_Turtle_RightLeg);
        Global.ss_Character.addChild(s_Turtle_Tail,Global.kDeapth_Turtle_Tail);
        Global.ss_Character.addChild(s_Turtle_Shadow,Global.kDeapth_Turtle_Shadow);
        Global.ss_Character.addChild(s_Turtle_Eye,Global.kDeapth_Turtle_Eye);
        Global.ss_Character.addChild(s_Turtle_Jaw,Global.kDeapth_Turtle_Eye);
        
        s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 46.0/71.0));
        s_Turtle_LeftLeg.setAnchorPoint(CGPoint.ccp(33.0/67.0, 1.0 - 38.0/76.0));
        s_Turtle_RightLeg.setAnchorPoint(CGPoint.ccp(33.0/67.0, 1.0 - 38.0/76.0));
        s_Turtle_Tail.setAnchorPoint(CGPoint.ccp(44.0/88.0, 1.0 - 28.0/57.0));
        s_Turtle_Shadow.setAnchorPoint(CGPoint.ccp(152.0/304.0, 1.0 - 12.0/26.0));
        s_Turtle_HeadAndNeck.setAnchorPoint(CGPoint.ccp(100.0/200.0, 1.0 - 108.0/110.0));
        s_Turtle_Head.setAnchorPoint(CGPoint.ccp(60.0/104.0, 1.0-100.0/107.0));
        s_Turtle_Neck.setAnchorPoint(CGPoint.ccp(25.0/50.0, 1.0-60.0/63.0));
        s_Turtle_Eye.setAnchorPoint(CGPoint.ccp(20.0/48.0, 1.0-63.0/98.0));
        s_Turtle_Jaw.setAnchorPoint(CGPoint.ccp(57.0/113.0, 1.0-52.0/102.0));
        
        s_Turtle_HeadAndNeck.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_Head.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_Neck.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_Shell.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_LeftLeg.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_RightLeg.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_Tail.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_Shadow.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_Eye.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        s_Turtle_Jaw.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2); 
        
        
        s_Turtle_Spike[0] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(106/2*Global.g_Scale,562/2*Global.g_Scale,20/2*Global.g_Scale,20/2*Global.g_Scale));
        s_Turtle_Spike[1] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(134/2*Global.g_Scale,562/2*Global.g_Scale,24/2*Global.g_Scale,24/2*Global.g_Scale));
        s_Turtle_Spike[2] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(106/2*Global.g_Scale,588/2*Global.g_Scale,18/2*Global.g_Scale,18/2*Global.g_Scale));
        s_Turtle_Spike[3] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(134/2*Global.g_Scale,588/2*Global.g_Scale,18/2*Global.g_Scale,16/2*Global.g_Scale));
        
        Global.ss_Character.addChild(s_Turtle_Spike[0],Global.kDeapth_Turtle_Spike);
        Global.ss_Character.addChild(s_Turtle_Spike[1],Global.kDeapth_Turtle_Spike);
        Global.ss_Character.addChild(s_Turtle_Spike[2],Global.kDeapth_Turtle_Spike);
        Global.ss_Character.addChild(s_Turtle_Spike[3],Global.kDeapth_Turtle_Spike);
        
        s_Turtle_Spike[0].setPosition(CGPoint.ccp(1000,10000));
        s_Turtle_Spike[1].setPosition(CGPoint.ccp(1000,10000));
        s_Turtle_Spike[2].setPosition(CGPoint.ccp(1000,10000));
        s_Turtle_Spike[3].setPosition(CGPoint.ccp(1000,10000));
        
        s_Turtle_HeadAndNeck.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_Head.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_Neck.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_Shell.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_LeftLeg.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_RightLeg.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_Tail.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_Shadow.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_Eye.setPosition(CGPoint.ccp(10000,10000));
        s_Turtle_Jaw.setPosition(CGPoint.ccp(10000,10000));
        
        s_Turtle_LeftLeg.setVisible(false);
        s_Turtle_RightLeg.setVisible(false);
        s_Turtle_Jaw.setVisible(false);
        s_Turtle_Tail.setVisible(false);
        s_Turtle_Spike[0].setVisible(false);
        s_Turtle_Spike[1].setVisible(false);
        s_Turtle_Spike[2].setVisible(false);
        s_Turtle_Spike[3].setVisible(false);
	    
	}
	
	public int  status()
	{
	    return status;
	}
	
	public void  setX( float _x)
	{
	    turtleX = _x;
	    
	    if(!Global.isPlayingMiniGame){
	        return;
	    }
	    
	    if(status == kTurtleAniStatus_Normal_In){
	        superFuxkAngleDiff = (float) (-turtleRotation * Math.PI/180);
	        superFuxkOriX =  Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shell_x =  (float) (turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff));
	        turtle_Shell_y =  (float) (turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff));
	    }else{
	        if(Global.currentChosenMiniGame == 13){
	            superFuxkAngleDiff = (float) (-turtleRotation * Math.PI/180);
	            superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        }
	    }
	        
	        
	}
	
	public void  setY( float _y)
	{
	    turtleY = _y;
	    
	    if(Global.isPlayingMiniGame){
	        if(status == kTurtleAniStatus_Normal_In){
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        }
	    }else{
	        return;
	    }
	    
	}
	
	public void  setStatus( int  _status)
	{
	    if(_status == kTurtleAniStatus_Normal_Out){
	        
	        if(!isFacingRight){
	 
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Shadow_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Shadow_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	
	            turtle_Shell_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_LeftLeg_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_RightLeg_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_Tail_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_Shadow_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            
	            s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            
	            s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Shadow.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	
	            
	        }else{
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Head_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Head_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Neck_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Neck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Shadow_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Shadow_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            turtle_Head_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_Neck_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_Shell_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_LeftLeg_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_RightLeg_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_Tail_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            turtle_Shadow_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	            
	            s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            
	            s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Shadow.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	
	        }
	        
	                
	        showingHeadTime = 0;
	        
	    }
	    
	    if(_status == kTurtleAniStatus_Normal_In){
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	   
	        turtleRotation = 0;
	        turtle_Shell_r = turtleRotation;
	        
	        turtle_HeadAndNeck_x = 9999;
	        turtle_Head_x = 9999;
	        turtle_Jaw_x = 9999;
	        turtle_Neck_x = 9999;
	        turtle_LeftLeg_x = 9999;
	        turtle_RightLeg_x = 9999;
	        turtle_Tail_x = 9999;
	        turtle_Eye_x = 9999;
	        
	        turtle_HeadAndNeck_y = 9999;
	        turtle_Head_y = 9999;
	        turtle_Jaw_y = 9999;
	        turtle_Neck_y = 9999;
	        turtle_LeftLeg_y = 9999;
	        turtle_RightLeg_y = 9999;
	        turtle_Tail_y = 9999;
	        turtle_Eye_y = 9999;
	        
	
	        if(Global.currentChosenMiniGame != 5){
	            s_Turtle_Shell.setTextureRect(CGRect.make(396/2*Global.g_Scale,200/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	        }
	        
	        
	    }
	    
	    if(_status == kTurtleAniStatus_Out){
	        isBombShell = false;
	        
	        if(status == kTurtleAniStatus_Idle){
	            this.endIdle();
	        }
	        
	        hurtTime = 0;
	        
	        turtleAniStep = 0;
	        turtleAniStep2 = 0;
	        
	        turtleRotation = 0;
	        
	        isCountAlready = false;
	        Global.currentTurtleOnScreen++;
	        
	        if(!Global.cannotPlayTurtleHeadOutSound){
	        	Global.cannotPlayTurtleHeadOutSound = true;
	        }
	        
	    }
	    
	    if(_status == kTurtleAniStatus_In){
	        if(status == kTurtleAniStatus_Idle){
	            this.endIdle();
	        }
	        
	        turtleAniStep = 0;
	        turtleAniStep2 = 0;
	        
	        if(!isCountAlready){
	        	Global.currentTurtleOnScreen--;
	            isCountAlready = true;
	        }
	        
	        if(Global.currentChosenMiniGame == 4){
	            if(idNumber == 0 && delegate != null){
	                delegate.setExternalValues(0);
	            }
	        }
	        
	    }
	    
	    if(_status == kTurtleAniStatus_Idle){
	        if(status != kTurtleAniStatus_Idle){
	            turtleAniStep = 0;
	            turtleAniStep2 = 0;
	            
	            //ADD FROM MINI 13
	            turtle_HeadAndNeck_x = 99999;
	        }
	    }
	    
	    
	    if(_status == kTurtleAniStatus_Bombing){
	        if(status == kTurtleAniStatus_Idle){
	            this.endIdle();
	        }
	        
	        turtleAniStep = 0;
	        turtleAniStep2 = 0;
	        turtleBombAniStep = 0;
	        bomb_isHittedFloor = false;
	        bomb_hitFloorTimer = 0;
	        
	        if(Global.currentChosenMiniGame == 4){
	            if(idNumber == 0 && delegate != null){
	                delegate.setExternalValues(0);
	            }
	        }
	        
	    }
	    
	    if(_status == kTurtleAniStatus_Shaking){
	        turtleAniStep = 0;
	        turtleAniStep2 = 0;
	        
	        turtleOriX = turtleX;
	        turtleOriY = turtleY;
	        
	        Global.playLayer.setToShakingBomb(turtleX,turtleY);
	    }
	    
	    status = _status;
	    
	}
	
	public void  manageMovement()
	{
	    if(Global.isPlayingMiniGame){
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shadow_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shadow_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Head_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Head_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Neck_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Neck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        turtle_Shell_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_LeftLeg_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_RightLeg_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_Tail_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shadow_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_Head_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_Neck_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        
	    }else{
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Head_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Head_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =  -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Neck_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Neck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        turtle_Shell_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_LeftLeg_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_RightLeg_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_Tail_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_Head_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        turtle_Neck_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	        
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        
	         turtle_Shadow_x =  10000;
	    }
	   
	    
	}
	
	public void  manageNormalInMovement()
	{
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	    turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    turtle_Shell_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].rotation * 180/Math.PI + turtleRotation;
	}
	
	public void  mainManage( float  dt)
	{
	    this.checkAndRunAni();
	    this.manageSpike();
	    this.manageBombAni();
	}
	
	public void  manage( float  dt)
	{
	
	    if(Global.currentChosenMiniGame == 4){
	        isExternalOffseting = true;
	    }
	    
	    this.checkAndRunAni();
	    this.manageSpike();
	    this.manageBombAni();

	    if(isGravity){
	        turtleVX += turtleAX;
	        turtleVY += turtleAY;
	        
	        turtleX += turtleVX;
	        turtleY += turtleVY;
	        
	        turtleVR += turtleAR;
	        turtleRotation += turtleVR;
	        
	        turtleAR /= 10;
	        
	        if(turtleY < -100){
	            turtleX = -999999;
	        }
	        
	        if(turtleVY < -10){
	            turtleVY = -10;
	        }
	    }
	
	
	    if(Global.isPlayingMiniGame){
	        if(Global.currentChosenMiniGame == 3){
	            if(status == kTurtleAniStatus_Normal_Out){
	                this.manageMovement();
	            }
	            if(status == kTurtleAniStatus_Normal_In){
	                this.manageNormalInMovement();
	            }
	            
	        }else{
	            if(prevTurtleRotation != turtleRotation){
	                if(status == kTurtleAniStatus_Normal_Out){
	                    this.manageMovement();
	                }
	                prevTurtleRotation = turtleRotation;
	            }
	        }
	
	    }
	    externalOffsetX2 += (externalOffsetFinalX-externalOffsetX2)/100;
	    externalOffsetY2 += (externalOffsetFinalY-externalOffsetY2)/100;
	    
	    if(!isBombShell){
	        s_Turtle_HeadAndNeck.setPosition(CGPoint.ccp(turtle_HeadAndNeck_x + externalOffsetX2, turtle_HeadAndNeck_y + externalOffsetY2));
	        s_Turtle_Head.setPosition(CGPoint.ccp(turtle_Head_x + externalOffsetX2, turtle_Head_y + externalOffsetY2));
	        s_Turtle_Jaw.setPosition(CGPoint.ccp(turtle_Jaw_x + externalOffsetX2, turtle_Jaw_y + externalOffsetY2));
	        s_Turtle_Neck.setPosition(CGPoint.ccp(turtle_Neck_x + externalOffsetX2, turtle_Neck_y + externalOffsetY2));
	        s_Turtle_Shell.setPosition(CGPoint.ccp(turtle_Shell_x + externalOffsetX2, turtle_Shell_y + externalOffsetY2));
	        s_Turtle_LeftLeg.setPosition(CGPoint.ccp(turtle_LeftLeg_x + externalOffsetX2, turtle_LeftLeg_y + externalOffsetY2));
	        s_Turtle_RightLeg.setPosition(CGPoint.ccp(turtle_RightLeg_x + externalOffsetX2, turtle_RightLeg_y + externalOffsetY2));
	        s_Turtle_Tail.setPosition(CGPoint.ccp(turtle_Tail_x + externalOffsetX2, turtle_Tail_y + externalOffsetY2));
	        s_Turtle_Eye.setPosition(CGPoint.ccp(turtle_Eye_x + externalOffsetX2, turtle_Eye_y + externalOffsetY2));
	    }else{
	        float tempYYY = 10;
	        s_Turtle_HeadAndNeck.setPosition(CGPoint.ccp(turtle_HeadAndNeck_x + externalOffsetX2, turtle_HeadAndNeck_y + externalOffsetY2 - tempYYY));
	        s_Turtle_Head.setPosition(CGPoint.ccp(turtle_Head_x + externalOffsetX2, turtle_Head_y + externalOffsetY2 - tempYYY));
	        s_Turtle_Jaw.setPosition(CGPoint.ccp(turtle_Jaw_x + externalOffsetX2, turtle_Jaw_y + externalOffsetY2 - tempYYY));
	        s_Turtle_Neck.setPosition(CGPoint.ccp(turtle_Neck_x + externalOffsetX2, turtle_Neck_y + externalOffsetY2 - tempYYY));
	        s_Turtle_Shell.setPosition(CGPoint.ccp(turtle_Shell_x + externalOffsetX2, turtle_Shell_y + externalOffsetY2 - tempYYY));
	        s_Turtle_LeftLeg.setPosition(CGPoint.ccp(turtle_LeftLeg_x + externalOffsetX2, turtle_LeftLeg_y + externalOffsetY2 - tempYYY));
	        s_Turtle_RightLeg.setPosition(CGPoint.ccp(turtle_RightLeg_x + externalOffsetX2, turtle_RightLeg_y + externalOffsetY2 - tempYYY));
	        s_Turtle_Tail.setPosition(CGPoint.ccp(turtle_Tail_x + externalOffsetX2, turtle_Tail_y + externalOffsetY2 - tempYYY));
	        s_Turtle_Eye.setPosition(CGPoint.ccp(turtle_Eye_x + externalOffsetX2, turtle_Eye_y + externalOffsetY2 - tempYYY));
	    }
	    
	    for(int i = 0 ; i < 4 ; i++){
	        s_Turtle_Spike[i].setPosition(CGPoint.ccp(turtle_Spike_x[i] + externalOffsetX2, turtle_Spike_y[i] + externalOffsetY2));
	        s_Turtle_Spike[i].setRotation(turtleRotation);
	    }
	    
	    if(status == kTurtleAniStatus_Normal_In){
	        turtle_HeadAndNeck_r = turtleRotation;
	        turtle_Head_r = turtleRotation;
	        turtle_Jaw_r = turtleRotation;
	        turtle_Neck_r = turtleRotation;
	        turtle_Shell_r = turtleRotation;
	        turtle_LeftLeg_r = turtleRotation;
	        turtle_RightLeg_r = turtleRotation;
	        turtle_Tail_r = turtleRotation;
	        turtle_Eye_r = turtleRotation;
	        turtle_Shadow_r = turtleRotation;
	    }
	    
	    s_Turtle_HeadAndNeck.setRotation(turtle_HeadAndNeck_r);
	    s_Turtle_Head.setRotation(turtle_Head_r);
	    s_Turtle_Jaw.setRotation(turtle_Jaw_r);
	    s_Turtle_Neck.setRotation(turtle_Neck_r);
	    s_Turtle_Shell.setRotation(turtle_Shell_r);
	    s_Turtle_LeftLeg.setRotation(turtle_LeftLeg_r);
	    s_Turtle_RightLeg.setRotation(turtle_RightLeg_r);
	    s_Turtle_Tail.setRotation(turtle_Tail_r);
	    s_Turtle_Eye.setRotation(turtle_Eye_r);
	    
	    
	    if(isChangingWholeScale){
	        isChangingWholeScale = false;
	        
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    }
	    
	    if(Global.currentChosenMiniGame == 10 || Global.currentChosenMiniGame == 2){
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*turtle_Shell_scaleX);
	        s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*turtle_Shell_scaleY);
	    }
	    
	    if(Global.currentChosenMiniGame == 5 || Global.currentChosenMiniGame == 3 || Global.currentChosenMiniGame == 13){
	        s_Turtle_Shadow.setPosition(CGPoint.ccp(10000, 10000));
	    }else{
	        s_Turtle_Shadow.setPosition(CGPoint.ccp(turtle_Shadow_x + externalOffsetX2, turtle_Shadow_y + externalOffsetY2));
	        s_Turtle_Shadow.setRotation(turtle_Shadow_r);
	    }
	    
	    
	    if(status == kTurtleAniStatus_Normal_Out){
	        showingHeadTime += dt;
	    }
	       
	
	}
	
	public void  checkAndRunAni()
	{
	    if(status == kTurtleAniStatus_Flying){
	        this.turtleFlying();
	    }
	    
	    if(status == kTurtleAniStatus_Out){
	        this.turtleOut();
	    }
	    if(status == kTurtleAniStatus_In){
	        this.turtleIn();
	    }
	    if(status == kTurtleAniStatus_Bombing){
	        if(bombOutType == kTurtleBombOutType_backToOri){
	             this.turtleInFromBombing_BackToOri();
	        }
	        if(bombOutType == kTurtleBombOutType_bombOutOffScreen){
	            this.turtleInFromBombing_BombOffScreen();
	        }
	    }
	    
	    if(status == kTurtleAniStatus_Idle){
	        this.turtleIdle();
	        this.turtleWink();
	    }
	    
	    if(status == kTurtleAniStatus_Shaking){
	        this.turtleShake();
	    }
	}
	
	public void  turtleShake()
	{
	    turtleAniStep2++;
	    if(turtleAniStep2 % 2 == 0){
	        return;
	    }
	    
	    turtleAniStep++;
	    
	    if(turtleAniStep == 1){
	        turtleRotation = 0;
	        s_Turtle_Shell.setScale(1.0f/Global.g_Scale*1);
	    }
	    
	    int shakeOffsetRanX;
	    int shakeOffsetRanY;
	    int shakeOffsetAngle;
	    
	    shakeOffsetRanX = (int) (Math.random()*65536% 6 - 3);
	    shakeOffsetRanY = (int) (Math.random()*65536%4 - 2);
	    shakeOffsetAngle = (int) (Math.random()*65536%12 - 6);
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  shakeOffsetRanX + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  shakeOffsetRanY + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + 12].y * Global.wholeTurtleScaleFromSocurce;
	    turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	
	    turtle_Shell_r = shakeOffsetAngle + turtleRotation;
	       
	    if(turtleAniStep == 8){
	        this.setStatus(kTurtleAniStatus_Normal_In);
	    }
	}
	
	public void  turtleOut()
	{
	    turtleAniStep2++;
	    if(turtleAniStep2 % 2 == 0){
	        return;
	    }
	    
	    turtleAniStep++;
	    
	    if(!isFacingRight){
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shadow_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shadow_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	
	        
	        turtle_Shell_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_LeftLeg_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_RightLeg_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Tail_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shadow_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	
	        
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        
	    }else{
	
	        turtle_Shell_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_LeftLeg_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_RightLeg_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Tail_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shadow_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        
	    }
	    
	    s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Shadow.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    
	    float turtleAppearAniWidth_Out = 200/2*Global.g_Scale;
	    float turtleAppearAniHeight_Out = 133/2*Global.g_Scale;
	    int turtleAppearAniCurrentRow_Out;
	    int turtleAppearAniCurrentCol_Out;
	    
        turtleAppearAniCurrentCol_Out = 0;
        turtleAppearAniCurrentRow_Out = turtleAniStep;
    
	    if(turtleAniStep <= 5){
	        s_Turtle_HeadAndNeck.setTextureRect(CGRect.make(turtleAppearAniCurrentRow_Out * turtleAppearAniWidth_Out, turtleAppearAniCurrentCol_Out * turtleAppearAniHeight_Out, turtleAppearAniWidth_Out, turtleAppearAniHeight_Out));
	        
	        if(!isFacingRight){
	            s_Turtle_HeadAndNeck.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2);
	        }else{
	            s_Turtle_HeadAndNeck.setScaleX(1.0f/Global.g_Scale*-Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_HeadAndNeck.setScaleY(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2);
	        }
	        
	        turtle_HeadAndNeck_x = turtleX;
	        turtle_HeadAndNeck_y = turtleY + 25;
	        turtle_HeadAndNeck_r = turtleRotation;
	        
	        turtle_Head_x = 99999;
	        turtle_Neck_x = 99999;
	        turtle_Head_y = 99999;
	        turtle_Neck_y = 99999;
	    }else{
	        
	        if(!isFacingRight){
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriX += 30;
	            turtle_Head_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Head_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriX += 20;
	            superFuxkOriY += 0;
	            turtle_Neck_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Neck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            turtle_Head_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Neck_r = Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            
	            s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        }else{
	            
	            turtle_Head_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Neck_r = -Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            
	            s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            
	        }
	        
	        s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleOutAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        
	        turtle_HeadAndNeck_x = 9999;
	        turtle_HeadAndNeck_y = 9999;
	    }
	    
	    
	    if(turtleAniStep == 12){
	        this.setStatus(kTurtleAniStatus_Normal_Out);
	    }
	    
	    
	}
	
	public void  turtleIn()
	{
	    turtleAniStep++;
	    if(turtleAniStep < 8){
	        
	        
	        if(isFacingRight){
	            turtle_LeftLeg_x = turtleX + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            turtle_RightLeg_x = turtleX + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            turtle_Tail_x = turtleX + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            
	            turtle_LeftLeg_y = turtleY + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_RightLeg_y = turtleY + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Tail_y = turtleY + Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            
	            turtle_LeftLeg_r = -Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_RightLeg_r = -Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Tail_r = -Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	                
	            s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        }else{
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	            turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	
	            
	            turtle_LeftLeg_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_RightLeg_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Tail_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            
	            s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        }
	        
	        s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        
	    }else{
	        turtle_LeftLeg_x = 9999;
	        turtle_RightLeg_x = 9999;
	        turtle_Tail_x = 9999;
	        
	        turtle_LeftLeg_y = 9999;
	        turtle_RightLeg_y = 9999;
	        turtle_Tail_y = 9999;
	 
	    }
	    
	    if(!isFacingRight){
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shadow_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shadow_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	        
	        turtle_Shell_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shadow_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	
	        
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	    }else{
	        
	        turtle_Shell_r = -Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shadow_r = -Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	    }
	    
	    s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Shadow.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);

	    float turtleAppearAniWidth_In = 200/2*Global.g_Scale;
	    float turtleAppearAniHeight_In = 133/2*Global.g_Scale;
	    
	    if(turtleAniStep > 3){
	        
	        if(turtleAniStep < 8){
	            s_Turtle_HeadAndNeck.setTextureRect(CGRect.make(500/2*Global.g_Scale + (turtleAniStep - 3) * turtleAppearAniWidth_In, 140/2*Global.g_Scale, turtleAppearAniWidth_In, turtleAppearAniHeight_In));
	            if(!isFacingRight){
	                
	                turtle_HeadAndNeck_x = turtleX;
	                turtle_HeadAndNeck_y = turtleY + 25;
	
	                s_Turtle_HeadAndNeck.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2);
	                turtle_HeadAndNeck_r = turtleRotation;
	            }else{
	                s_Turtle_HeadAndNeck.setScaleX(1.0f/Global.g_Scale*-Global.wholeTurtleScaleFromSocurce * 2);
	                s_Turtle_HeadAndNeck.setScaleY(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2);
	            }
	            
	            turtle_Head_x = 9999;
	            turtle_Neck_x = 9999;
	            turtle_Head_y = 9999;
	            turtle_Neck_y = 9999;
	        }else{
	            turtle_HeadAndNeck_x = 9999;
	            turtle_Head_x = 9999;
	            turtle_Neck_x = 9999;
	            
	            turtle_HeadAndNeck_y = 9999;
	            turtle_Head_y = 9999;
	            turtle_Neck_y = 9999;
	        }
	        
	        
	    }else{
	        
	        if(!isFacingRight){
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriX += 30;
	            turtle_Head_x =  turtleX;
	            turtle_Head_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY =   Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriX += 20;
	            superFuxkOriY += 0;
	            turtle_Neck_x =  turtleX;
	            turtle_Neck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	            
	            turtle_Head_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Neck_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	
	            s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX *Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        }else{
	            
	            turtle_Head_r = -Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Neck_r = -Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            
	            s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        }
	        
	        
	        s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        
	         turtle_HeadAndNeck_x = 9999;
	         turtle_HeadAndNeck_y = 9999;
	
	    }
	    
	    
	    if(turtleAniStep == 12){
	        this.checkIfLostComboWhenTurtleIn();
	        this.setStatus(kTurtleAniStatus_Normal_In);
	    }
	    
	}
	
	public void  checkIfLostComboWhenTurtleIn()
	{
	    boolean isLostCombo;
	    isLostCombo = true;
	    if(shellLevel == 0){
	        if(hurtTime == 1){
	            isLostCombo = false;
	        }
	    }
	    
	    if(shellLevel == 1){
	        if(hurtTime == 2){
	            isLostCombo = false;
	        }
	    }
	    
	    if(shellLevel == 2){
	        if(hurtTime == 3){
	            isLostCombo = false;
	        }
	    }
	    
	    if(isLostCombo){
	        Global.uILayer.lostCombo();
	    }
	}
	
	public void  turtleInFromBombing_BombOffScreenWithGravity()
	{
	       
	}
	
	public void  turtleInFromBombing_BombOffScreen()
	{
	    if(turtleBombAniStep == 0){
	        if(Global.currentChosenMiniGame == 10){
	        
	        }else{
	        
	        }
	        bomb_force = 10;
	        
	        bomb_x = 0;
	        bomb_y = 0;
	        
	        bomb_vx = 7;
	        bomb_vy = 12;
	        bomb_oriVy = bomb_vy;
	        bomb_ay = -0.75f;
	        bomb_floorY = turtleY;
	        
	        int ranR;
	        ranR = (int) (Math.random()*65536 % 100);
	        
	        bomb_vr = bomb_force * 0.5f;
	        bomb_isRotatingClockrise = true;
	
	        if(bombOutOffScreenDirection == kBombOutOffScreenDirection_Left){
	            bomb_vx *= -1;
	            bomb_isRotatingClockrise = false;
	        }
	    }
	    
	    bomb_vy += bomb_ay;
	    bomb_y += bomb_vy;
	    bomb_x += bomb_vx;
	    
	    if(bomb_isRotatingClockrise){
	         turtleRotation += bomb_vr;
	    }else{
	         turtleRotation += -bomb_vr;
	    }
	    
	    s_Turtle_Shadow.setOpacity(bomb_shadowOpacity);
	    s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*bomb_shadowScaleY);
	    
	    if(turtleAniStep < 8){
	        if(isFacingRight){
	            
	        }else{
	            
	            if(status == kTurtleAniStatus_Normal_Out){
	                superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	                superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	                superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	                turtle_LeftLeg_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	                turtle_LeftLeg_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	                
	                superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	                superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	                superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	                turtle_RightLeg_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	                turtle_RightLeg_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	                
	                
	                
	                superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	                superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	                superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	                turtle_Tail_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	                turtle_Tail_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	                
	                
	                turtle_LeftLeg_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	                turtle_RightLeg_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	                turtle_Tail_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	
	                s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	                s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	                s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            }
	            
	        }
	        
	        if(status == kTurtleAniStatus_Normal_Out){
	            s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        }
	        
	        
	    }else{
	        turtle_LeftLeg_x = 9999;
	        turtle_RightLeg_x = 9999;
	        turtle_Tail_x = 9999;
	        
	        turtle_LeftLeg_y = 9999;
	        turtle_RightLeg_y = 9999;
	        turtle_Tail_y = 9999;
	        
	    }
	    
	    
	    
	    
	    if(!isFacingRight){
	        
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX;
	        superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY;
	        turtle_Shell_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        turtle_Shell_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        turtle_Shell_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	    }else{
	        
	    }
	    
	    s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    
	    float turtleAppearAniWidth_In = 200/2*Global.g_Scale;
	    float turtleAppearAniHeight_In = 133/2*Global.g_Scale;
	    
	    if(turtleAniStep > 3){
	        
	        if(turtleAniStep < 8){
	            if(status == kTurtleAniStatus_Normal_Out){
	                s_Turtle_HeadAndNeck.setTextureRect(CGRect.make(500/2*Global.g_Scale + (turtleAniStep - 3) * turtleAppearAniWidth_In, 140/2*Global.g_Scale, turtleAppearAniWidth_In, turtleAppearAniHeight_In));
	                if(!isFacingRight){
	                    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	                    superFuxkOriX =   bomb_x;
	                    superFuxkOriY =   bomb_y;
	                    turtle_HeadAndNeck_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	                    turtle_HeadAndNeck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	                    
	                    s_Turtle_HeadAndNeck.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2);
	                    turtle_HeadAndNeck_r = turtleRotation;
	                }else{
	                    
	                }
	            }
	            
	            
	            turtle_Head_x = 9999;
	            turtle_Neck_x = 9999;
	            turtle_Head_y = 9999;
	            turtle_Neck_y = 9999;
	            
	        }else{
	            turtle_HeadAndNeck_x = 9999;
	            turtle_Head_x = 9999;
	            turtle_Neck_x = 9999;
	            
	            turtle_HeadAndNeck_y = 9999;
	            turtle_Head_y = 9999;
	            turtle_Neck_y = 9999;
	            
	        }
	        
	        
	    }else{
	        
	        if(!isFacingRight){
	            if(status == kTurtleAniStatus_Normal_Out){
	                superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	                superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX;
	                superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY;
	                turtle_Head_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	                turtle_Head_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	                
	                
	                superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	                superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX;
	                superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY;
	                turtle_Neck_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	                turtle_Neck_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	                
	                turtle_Head_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	                turtle_Neck_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	
	                s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	                s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	
	            }
	        }else{
	            
	        }
	        
	        if(status == kTurtleAniStatus_Normal_Out){
	            s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        }
	        
	        
	        turtle_HeadAndNeck_x = 9999;
	        turtle_HeadAndNeck_y = 9999;
	    }
	    
	    
	    turtleBombAniStep++;
	    
	    if(s_Turtle_Shell.getPosition().y < -30){
	        
	        turtleX = 9999;
	        this.setStatus(kTurtleAniStatus_Normal_In);
	        
	        if(delegate != null){
	            delegate.thisTurtleIsBombOutOffScreen(idNumber);
	        }
	        
	        if(!isCountAlready){
	            Global.currentTurtleOnScreen--;
	            isCountAlready = true;
	        }
	    }
	    
	}
	
	public void  turtleInFromBombing_BackToOri()
	{
	    
	    
	    if(turtleAniStep < 12){
	        turtleAniStep++;
	    }
	    
	    
	    if(turtleBombAniStep == 0){
	        bomb_x = 0;
	        bomb_y = 0;
	        
	        bomb_vy = 10;
	        bomb_oriVy = bomb_vy;
	        bomb_ay = -0.75f;
	        bomb_floorY = turtleY;
	        
	        bomb_vr = 15.9f;
	        bomb_isRotatingClockrise = true;
	        
	        bomb_shadowOpacity = 255;
	        bomb_shadowScaleY = s_Turtle_Shadow.getScaleY();
	        
	        bomb_hasOnceHittedFloor = false;
	    }
	    
	    bomb_vy += bomb_ay;
	    bomb_y += bomb_vy;
	    
	    if(bomb_y < 0){
	        bomb_y = 0;
	        bomb_isHittedFloor = true;
	        
	        if(!bomb_hasOnceHittedFloor){
	            s_Turtle_Shell.setTextureRect(CGRect.make(396/2*Global.g_Scale,200/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 46.0/71.0));
	        }
	        
	        bomb_hasOnceHittedFloor = true;
	    }
	    
	    if(bomb_isHittedFloor){
	        bomb_oriVy /= 3;
	        bomb_vy =bomb_oriVy;
	        bomb_y = 0;
	        
	        bomb_vr /= 3;
	        
	        bomb_isRotatingClockrise = !bomb_isRotatingClockrise;
	        
	        bomb_isHittedFloor = false; 
	    }else{
	        
	    }
	    
	    if(bomb_isRotatingClockrise){
	        turtleRotation += bomb_vr;
	    }else{
	        turtleRotation -= bomb_vr;
	    }
	    
	    if(bomb_vy > 0){
	        
	        
	    }else{
	        
	    }
	    
	    if(!bomb_hasOnceHittedFloor){
	        
	        bomb_shadowOpacity -= 15;
	        if(bomb_shadowOpacity < 0){
	            bomb_shadowOpacity = 0;
	        }
	        
	        bomb_shadowScaleY -= 0.1;
	        if(bomb_shadowScaleY < 0){
	            bomb_shadowScaleY = 0;
	        }
	        
	    }else{
	        
	        bomb_shadowOpacity += 35;
	        if(bomb_shadowOpacity > 255){
	            bomb_shadowOpacity = 255;
	        }
	        
	        bomb_shadowScaleY += 0.1;
	        if(bomb_shadowScaleY > 0.6396328003115613){
	            bomb_shadowScaleY = 0.6396328003115613f;
	        }
	        
	        turtle_Shadow_x = turtleX + 0.35000000000002274 * Global.wholeTurtleScaleFromSocurce;
	        turtle_Shadow_y = turtleY - 21.899999999999977 * Global.wholeTurtleScaleFromSocurce;
	        
	    }
	    
	    s_Turtle_Shadow.setOpacity(bomb_shadowOpacity);
	    s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*bomb_shadowScaleY);
	    
	    if(turtleBombAniStep  == 40){
	        this.setStatus(kTurtleAniStatus_Normal_In);
	        
	        if(!isCountAlready){
	            Global.currentTurtleOnScreen--;
	            isCountAlready = true;
	        }
	    }
	    
	    if(turtleAniStep < 8){
	        
	        
	        if(isFacingRight){
	            
	        }else{
	            
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_LeftLeg_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	            turtle_LeftLeg_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	                     
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_RightLeg_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	            turtle_RightLeg_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	            
	            
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	            superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	            turtle_Tail_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	            turtle_Tail_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	      
	            turtle_LeftLeg_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_RightLeg_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Tail_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	 
	            s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        }
	        
	        s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        
	    }else{
	        turtle_LeftLeg_x = 9999;
	        turtle_RightLeg_x = 9999;
	        turtle_Tail_x = 9999;
	        
	        turtle_LeftLeg_y = 9999;
	        turtle_RightLeg_y = 9999;
	        turtle_Tail_y = 9999;
	
	    }
	    
	    
	    
	    
	    if(!isFacingRight){
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX;
	        superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY;
	        turtle_Shell_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        turtle_Shell_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	
	        turtle_Shell_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	    }else{
	        
	    }
	    
	    s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    
	    float turtleAppearAniWidth_In = 200/2*Global.g_Scale;
	    float turtleAppearAniHeight_In = 133/2*Global.g_Scale;
	    
	    if(turtleAniStep > 3){
	        
	        if(turtleAniStep < 8){
	            s_Turtle_HeadAndNeck.setTextureRect(CGRect.make(500/2*Global.g_Scale + (turtleAniStep - 3) * turtleAppearAniWidth_In, 140/2*Global.g_Scale, turtleAppearAniWidth_In, turtleAppearAniHeight_In));
	            if(!isFacingRight){
	                turtle_HeadAndNeck_x = turtleX + bomb_x;
	                turtle_HeadAndNeck_y = turtleY + bomb_y;
	                turtle_HeadAndNeck_y = turtleY + bomb_y + 25;
	                
	                s_Turtle_HeadAndNeck.setScale(1.0f/Global.g_Scale*Global.wholeTurtleScaleFromSocurce * 2);
	                turtle_HeadAndNeck_r = turtleRotation;
	            }else{
	                
	            }
	            
	            turtle_Head_x = 9999;
	            turtle_Neck_x = 9999;
	            turtle_Head_y = 9999;
	            turtle_Neck_y = 9999;
	
	        }else{
	            turtle_HeadAndNeck_x = 9999;
	            turtle_Head_x = 9999;
	            turtle_Neck_x = 9999;
	            
	            turtle_HeadAndNeck_y = 9999;
	            turtle_Head_y = 9999;
	            turtle_Neck_y = 9999;
	            
	        }
	        
	        
	    }else{
	        
	        if(!isFacingRight){
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX;
	            superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY;
	            superFuxkOriX += 30;
	            turtle_Head_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	            turtle_Head_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	                 
	            
	            superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	            superFuxkOriX = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX;
	            superFuxkOriY = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY;
	            superFuxkOriX += 20;
	            turtle_Neck_x = turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	            turtle_Neck_y = turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	            
	            turtle_Head_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            turtle_Neck_r = Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	            
	            s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	            s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        }else{
	        }
	        
	        
	        s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.turtleInAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	        
	        turtle_HeadAndNeck_x = 9999;
	        turtle_HeadAndNeck_y = 9999;
	    }
	    
	    
	    turtleBombAniStep++;
	    
	}
	
	public void  turtleTempIdle()
	{
	   
	}
	
	
	
	public void  turtleIdle()
	{
	    if(Global.currentChosenMiniGame == 13){
	        turtleAniStep2++;
	        if(turtleAniStep2 % 2 == 1){
	            turtleAniStep++;
	        }
	        
	        
	    }else{
	        turtleAniStep2++;
	        if(turtleAniStep2 % 2 == 0){
	            return;
	        }
	        
	        turtleAniStep++;
	    }
	    
	    
	    
	    float idleOffsetX = 0;
	    float idleOffsetY = 0;
	    
	    if(turtleAniStep == 1){
	        s_Turtle_Head.setTextureRect(CGRect.make(1555/2*Global.g_Scale,162/2*Global.g_Scale,104/2*Global.g_Scale,107/2*Global.g_Scale));
	        s_Turtle_Eye.setTextureRect(CGRect.make(1688/2*Global.g_Scale,162/2*Global.g_Scale,48/2*Global.g_Scale,98/2*Global.g_Scale));
	        
	        idleOffsetX = -175 * Global.wholeTurtleScaleFromSocurce * 2;
	        idleOffsetY = 140 * Global.wholeTurtleScaleFromSocurce * 2;
	    }
	    
	    
	    if(!isFacingRight){
	    	float deltaX = -190;
	    	float deltaY = 150;
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        if ( superFuxkOriY >= 0 )
	        {
	        	deltaX = deltaY = 0;
	        }
	        
	        superFuxkOriX += (deltaX+20);
	        superFuxkOriY += deltaY;
	        turtle_Neck_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Neck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY += deltaY;
	        superFuxkOriX += deltaX;
	        turtle_Jaw_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Jaw_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriX += (deltaX + 36);
	        superFuxkOriY += (deltaY+6);
	        turtle_Eye_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Eye_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        
	        superFuxkOriX += (deltaX+30);
	        superFuxkOriY += deltaY;
	        
	        turtle_Head_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Head_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);

	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        
	        superFuxkOriX += deltaX;
	        superFuxkOriY += deltaY;
	        
	        turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        
	        superFuxkOriX += deltaX;
	        superFuxkOriY += deltaY;
	        
	        turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriX += deltaX;
	        superFuxkOriY += deltaY;
	        turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriX += deltaX;
	        superFuxkOriY += deltaY;
	        turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idleOffsetX + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idleOffsetY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriX += deltaX;
	        superFuxkOriY += deltaY;
	        turtle_Shadow_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        turtle_Shadow_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	    
	        turtle_Neck_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Jaw_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Eye_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Head_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shell_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_LeftLeg_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_RightLeg_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Tail_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shadow_r = Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        
	        s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Jaw.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Eye.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        
	    }else{
	        s_Turtle_Neck.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                       idleOffsetY + turtleY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        s_Turtle_Jaw.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - (Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].x + 1) * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                      idleOffsetY + turtleY + (Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].y - 1) * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        s_Turtle_Eye.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - (Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].x + 1) * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                      idleOffsetY + turtleY + (Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].y - 2) * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        s_Turtle_Head.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                       idleOffsetY + turtleY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        
	        s_Turtle_Shell.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                        idleOffsetY + turtleY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        s_Turtle_LeftLeg.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                          idleOffsetY + turtleY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        s_Turtle_RightLeg.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                           idleOffsetY + turtleY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        s_Turtle_Tail.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                       idleOffsetY + turtleY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        s_Turtle_Shadow.setPosition(CGPoint.ccp(-idleOffsetX + turtleX - Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce + externalOffsetX,
	                                         idleOffsetY + turtleY + Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce + externalOffsetY));
	        
	 
	        turtle_Neck_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Jaw_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Eye_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Head_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shell_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_LeftLeg_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_RightLeg_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Tail_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        turtle_Shadow_r = -Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation;
	        
	        s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Jaw.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Eye.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	        s_Turtle_Shadow.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2);
	    }
	    
	    s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Jaw.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Jaw].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Eye.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Eye].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    s_Turtle_Shadow.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.IdleTurtleAnim.spriteData[kTurtlePart_Shadow].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2);
	    
	    if(turtleAniStep == 45){
	        this.endIdle();
	        this.setStatus(kTurtleAniStatus_Normal_Out);
	        //status = kTurtleAniStatus_Normal_Out;
	    }
	    
	    if(turtleAniStep < 40){
	        if(Math.random()*65536 % 20 == 0){
	            isWinking = true;
	            winkingTimer = 0;
	        }
	    }
	    
	    
	    if(isBombShell){
	        turtle_HeadAndNeck_x = 100000;
	        turtle_Head_x = 100000;
	        turtle_Jaw_x = 100000;
	        turtle_Neck_x = 100000;
	        turtle_LeftLeg_x = 100000;
	        turtle_RightLeg_x = 100000;
	        turtle_Tail_x = 100000;
	        turtle_Eye_x = 100000;
	    }
	}
	
	public void  turtleWink()
	{
	    if(!isWinking){
	        return;
	    }
	    
	    winkingTimer++;
	    if(winkingTimer % 2 == 0){
	        return;
	    }
	    
	    if(winkingTimer == 1){
	        
	        s_Turtle_Head.setTextureRect(CGRect.make(1555/2*Global.g_Scale,162/2*Global.g_Scale,104/2*Global.g_Scale,107/2*Global.g_Scale));
	        s_Turtle_Eye.setTextureRect(CGRect.make(1736/2*Global.g_Scale,162/2*Global.g_Scale,48/2*Global.g_Scale,98/2*Global.g_Scale));
	        
	    }
	    if(winkingTimer == 3){
	        s_Turtle_Eye.setTextureRect(CGRect.make(1784/2*Global.g_Scale,162/2*Global.g_Scale,48/2*Global.g_Scale,98/2*Global.g_Scale));
	    }
	    if(winkingTimer == 5){
	        s_Turtle_Eye.setTextureRect(CGRect.make(1736/2*Global.g_Scale,162/2*Global.g_Scale,48/2*Global.g_Scale,98/2*Global.g_Scale));
	    }
	    
	    
	    if(winkingTimer == 7){
	        s_Turtle_Eye.setTextureRect(CGRect.make(1688/2*Global.g_Scale,162/2*Global.g_Scale,48/2*Global.g_Scale,98/2*Global.g_Scale));
	        this.endWink();
	        // status = kTurtleAniStatus_Normal_Out;
	    }
	    
	}
	
	public void  endIdle()
	{
	    if(isWinking){
	        this.endWink();
	    }
	    turtle_Eye_x = 9999;
	    turtle_Jaw_x = 9999;
	    turtle_Eye_y = 9999;
	    turtle_Jaw_y = 9999;
	    
	    s_Turtle_Head.setTextureRect(CGRect.make(213/2*Global.g_Scale,162/2*Global.g_Scale,104/2*Global.g_Scale,107/2*Global.g_Scale));
	    
	}
	
	public void  endWink()
	{
	    isWinking = false;
	    winkingTimer = 0;
	}
	
	public void  setShellLevel( int _shellLevel)
	{
	    shellLevel = _shellLevel;
	    
	    if(shellLevel == 0){
	        if(color == kTurtleShellColor_BrownOri){
	            
	            s_Turtle_Shell.setTextureRect(CGRect.make(396/2*Global.g_Scale,200/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	            
	        }
	        if(color == kTurtleShellColor_Brown){
	            
	            s_Turtle_Shell.setTextureRect(CGRect.make(396/2*Global.g_Scale,200/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	            
	        }
	        if(color == kTurtleShellColor_Red){
	            s_Turtle_Shell.setTextureRect(CGRect.make(756/2*Global.g_Scale,642/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Green){
	            s_Turtle_Shell.setTextureRect(CGRect.make(756/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Blue){
	            s_Turtle_Shell.setTextureRect(CGRect.make(756/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	        }        
	        
	        s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 46.0/71.0));
	    }
	    
	    if(shellLevel == 1){
	        if(color == kTurtleShellColor_BrownOri){
	            s_Turtle_Shell.setTextureRect(CGRect.make(948/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Brown){
	            s_Turtle_Shell.setTextureRect(CGRect.make(1938/2*Global.g_Scale,380/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Red){
	            s_Turtle_Shell.setTextureRect(CGRect.make(866/2*Global.g_Scale,642/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Green){
	            s_Turtle_Shell.setTextureRect(CGRect.make(866/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Blue){
	            s_Turtle_Shell.setTextureRect(CGRect.make(866/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	        }
	        
	        s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	    }
	    
	    if(shellLevel == 2){
	        hasSpike = true;
	        if(color == kTurtleShellColor_BrownOri){
	            s_Turtle_Shell.setTextureRect(CGRect.make(836/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,86/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Brown){
	            s_Turtle_Shell.setTextureRect(CGRect.make(1700/2*Global.g_Scale,380/2*Global.g_Scale,108/2*Global.g_Scale,86/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Red){
	            s_Turtle_Shell.setTextureRect(CGRect.make(1090/2*Global.g_Scale,642/2*Global.g_Scale,108/2*Global.g_Scale,86/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Green){
	            s_Turtle_Shell.setTextureRect(CGRect.make(1090/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,86/2*Global.g_Scale));
	        }
	        if(color == kTurtleShellColor_Blue){
	            s_Turtle_Shell.setTextureRect(CGRect.make(1090/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,86/2*Global.g_Scale));
	        }
	        
	        s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 62.0/86.0));
	    }
	}
	
	public void  tap()
	{
	
	    if(status == kTurtleAniStatus_Normal_In || status == kTurtleAniStatus_Shaking || status == kTurtleAniStatus_Bombing){
	        
	        if(Global.currentChosenMiniGame == 3){
	            this.setToBombing();
	        }else{
	            if(delegate != null){
	                delegate.tapWrongly();
	            }
	            
	            Global.uILayer.lostCombo();
	            this.setStatus(kTurtleAniStatus_Shaking);
	            
	            Global.musicController.playThisSound(Global.kSound_TapWrongly,false,1.0);
	        }
	        
	        
	        
	        return;
	    }
	    
	    if(status == kTurtleAniStatus_Bombing){
	        return;
	    }
	    
	    hurtTime++;
	      
	    
	    Global.uILayer.gainCombo(1);
	    Global.counterForAchivement++;
	    
	    if(hasSpike){
	        hasSpike = false;
	        spikeRemoveAniTimer = 0;
	        spikeRemoveIsAni = true;
	    }
	    
	    if(shellLevel == 0){
	        if(hurtTime == 1){
	            this.setToBombing();
	        }
	    }
	    
	    if(shellLevel == 1){
	        if(hurtTime == 1){
	            if(color == kTurtleShellColor_BrownOri){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1058/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Brown){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1058/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Red){
	                s_Turtle_Shell.setTextureRect(CGRect.make(978/2*Global.g_Scale,642/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Green){
	                s_Turtle_Shell.setTextureRect(CGRect.make(978/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Blue){
	                s_Turtle_Shell.setTextureRect(CGRect.make(978/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	            
	            Global.musicController.playThisSound(Global.kSound_CrackShell,false,1.0);
	        }
	        
	        if(hurtTime == 2){
	            this.setToBombing();
	        }
	    }
	    
	    if(shellLevel == 2){
	        if(hurtTime == 1){
	            if(color == kTurtleShellColor_BrownOri){
	                s_Turtle_Shell.setTextureRect(CGRect.make(614/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Brown){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Red){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,642/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Green){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Blue){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	           
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	            
	            Global.musicController.playThisSound(Global.kSound_CrackShell,false,1.0);
	        }
	        
	        if(hurtTime == 2){
	            if(color == kTurtleShellColor_BrownOri){
	                s_Turtle_Shell.setTextureRect(CGRect.make(724/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Brown){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Red){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,640/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Green){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Blue){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	            
	            Global.musicController.playThisSound(Global.kSound_CrackShell,false,1.0);
	        }
	        
	        if(hurtTime == 3){
	            this.setToBombing();
	        }
	    }
	    
	}
	
	public void  tap2()
	{
	    
	    hurtTime++;
	
	    if(Global.currentChosenMiniGame != 10){
	    	Global.uILayer.gainCombo(1);
	        Global.counterForAchivement++;
	    }
	    
	    
	    if(hasSpike){
	        hasSpike = false;
	        spikeRemoveAniTimer = 0;
	        spikeRemoveIsAni = true;
	    }
	    
	    if(shellLevel == 0){
	        if(hurtTime == 1){
	            this.setToBombing();
	        }
	    }
	    
	    if(shellLevel == 1){
	        if(hurtTime == 1){
	            this.setToBombing();
	        }
	    }
	    
	    if(shellLevel == 2){
	        if(hurtTime == 1){
	            
	            this.setStatus(kTurtleAniStatus_Shaking);
	            
	            if(color == kTurtleShellColor_BrownOri){
	                s_Turtle_Shell.setTextureRect(CGRect.make(724/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Brown){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1816/2*Global.g_Scale,380/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Red){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,640/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Green){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Blue){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	        }
	        
	        if(hurtTime == 2){
	            this.setToBombing();
	        }
	        
	    }
	    
	}
	
	public void  bombButLoseCombo()
	{
	    hurtTime = 0;
	    
	    Global.playLayer.setToBombing(turtleX,turtleY);
	    this.setY(-99999);
	}
	
	public void  tap3()
	{
	    
	    hurtTime++;
	    
	    Global.uILayer.gainCombo(1);
	    Global.counterForAchivement++;
	    
	    
	    if(hasSpike){
	        hasSpike = false;
	        spikeRemoveAniTimer = 0;
	        spikeRemoveIsAni = true;
	    }
	    
	    if(shellLevel == 0){
	        if(hurtTime == 1){
	            this.setToBombing();
	            this.setY(-99999);
	        }
	    }
	    
	    if(shellLevel == 1){
	        if(hurtTime == 1){
	            if(color == kTurtleShellColor_BrownOri){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1058/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Brown){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1058/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Red){
	                s_Turtle_Shell.setTextureRect(CGRect.make(978/2*Global.g_Scale,642/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Green){
	                s_Turtle_Shell.setTextureRect(CGRect.make(978/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Blue){
	                s_Turtle_Shell.setTextureRect(CGRect.make(978/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	            
	            Global.musicController.playThisSound(Global.kSound_CrackShell,false,0.5);
	            
	            this.setToBombingForMiniGame03();
	        }
	        
	        if(hurtTime == 2){
	            this.setToBombing();
	            this.setY(-99999);
	        }
	    }
	    
	    if(shellLevel == 2){
	        if(hurtTime == 1){
	            if(color == kTurtleShellColor_BrownOri){
	                s_Turtle_Shell.setTextureRect(CGRect.make(614/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Brown){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Red){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,642/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Green){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Blue){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1202/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	            
	            Global.musicController.playThisSound(Global.kSound_CrackShell,false,0.5);
	            
	            this.setToBombingForMiniGame03();
	        }
	        
	        if(hurtTime == 2){
	            if(color == kTurtleShellColor_BrownOri){
	                s_Turtle_Shell.setTextureRect(CGRect.make(724/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Brown){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Red){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,640/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Green){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,460/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            if(color == kTurtleShellColor_Blue){
	                s_Turtle_Shell.setTextureRect(CGRect.make(1314/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	            }
	            
	            s_Turtle_Shell.setAnchorPoint(CGPoint.ccp(54/108.0, 1.0 - 52.0/76.0));
	            
	            Global.musicController.playThisSound(Global.kSound_CrackShell,false,0.5);
	            
	            this.setToBombingForMiniGame03();
	        }
	        
	        if(hurtTime == 3){
	            this.setToBombing();
	            this.setY(-99999);
	        }
	    }
	    
	}
	
	
	
	public void  manageSpike()
	{
	    if(!spikeRemoveIsAni){
	        return;
	    }
	    
	    if(spikeRemoveAniTimer == 0){
	        spikePosX[0] = s_Turtle_Shell.getPosition().x - 32 * Global.wholeTurtleScaleFromSocurce;
	        spikePosX[1] = s_Turtle_Shell.getPosition().x + 2 * Global.wholeTurtleScaleFromSocurce;
	        spikePosX[2] = s_Turtle_Shell.getPosition().x + 32 * Global.wholeTurtleScaleFromSocurce;
	        spikePosX[3] = s_Turtle_Shell.getPosition().x + 0 * Global.wholeTurtleScaleFromSocurce;
	        
	        spikePosY[0] = s_Turtle_Shell.getPosition().y + 34 * Global.wholeTurtleScaleFromSocurce;
	        spikePosY[1] = s_Turtle_Shell.getPosition().y + 53 * Global.wholeTurtleScaleFromSocurce;
	        spikePosY[2] = s_Turtle_Shell.getPosition().y + 30 * Global.wholeTurtleScaleFromSocurce;
	        spikePosY[3] = s_Turtle_Shell.getPosition().y + 15 * Global.wholeTurtleScaleFromSocurce;
	        
	        spikeOpacity = 255;
	    }
	    
	    
	    spikeOpacity -= 30;
	    if(spikeOpacity < 0){
	        spikeOpacity = 0;
	    }
	    
	    spikePosY[0] += 1.0;
	    spikePosY[1] += 1.0;
	    spikePosY[2] += 1.0;
	    spikePosY[3] += 1.0;
	    
	    spikePosX[0] += -1.0;
	    spikePosX[1] += 0;
	    spikePosX[2] += 1.0;
	    spikePosX[3] += 0;
	    
	    for(int i = 0 ; i < 4 ; i++){
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX =   spikePosX[i];
	        superFuxkOriY =   spikePosY[i];
	        turtle_Spike_x[i] =    (float) (superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff));
	        turtle_Spike_y[i] =    (float) (superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff));
	        
	        s_Turtle_Spike[i].setOpacity(spikeOpacity);
	    }
	    
	    
	    spikeRemoveAniTimer++;
	}
	
	public void  setToBombing()
	{
	    if(Global.currentChosenMiniGame != 10){
	    	Global.gameRound++;
	    	Global.gameRoundFromBegin++;
	    }
	    
	    if(Global.currentChosenMiniGame == 4 || Global.currentChosenMiniGame == 1 || Global.currentChosenMiniGame == 13){
	        if(status != kTurtleAniStatus_In){
	            if(delegate != null){
	                delegate.turtleBombed(momentIdx);
	            }
	            
	        }
	    }
	    
	    if(Global.currentChosenMiniGame == 3){
	        delegate.turtleBombed(momentIdx);
	    }
	    
	    Global.playLayer.setToBombing(turtleX,turtleY);
	    if(Global.currentChosenMiniGame != 3){
	        this.setStatus(kTurtleAniStatus_Bombing);
	    }
	   
	    if(Global.currentChosenMiniGame == 3){
	        Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,0.75);
	        Global.musicController.playThisSound(Global.kSound_CrackShell,false,0.2);
	    }else{
	        Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,1.0);
	        Global.musicController.playThisSound(Global.kSound_CrackShell,false,0.3);
	    }
	    
	}
	
	public void  setToBombingForMiniGame03()
	{
	    Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_CrackShell,false,0.3);
	    
	    Global.playLayer.setToShakingBomb(turtleX,turtleY);
	    
	    if(bombOutType == kTurtleBombOutType_bombOutOffScreenWithGravity){
	        int ranV;
	        ranV = (int) (Math.random()*65536%3);
	        
	        turtleVY = (360 - turtleY)/16;
	        if(turtleVY > 15){
	            turtleVY = 15;
	        }
	        if(turtleVY < 10){
	            turtleVY = 10;
	        }
	       
	        
	        ranV = (int) (Math.random()*65536%100);
	        turtleVX *= 0.5 + 0.1 * ranV/100;
	    }
	}
	
	public void  setBombOutType( int _bombOutType)
	{
	    bombOutType = _bombOutType;
	}
	
	public void  manageBombAni()
	{
	    
	}
	
	public void  shotFromCannonAtX( float _x, float _y, float _force, float _angle)
	{
	    int ranXRatio;
	    ranXRatio = (int) (Math.random()*65536%100);
	    
	    setX(_x);
	    setY(_y);
	    turtleVX = (float) (_force * Math.cos(-_angle * Math.PI/180) * ( 1 + 0.5 * ranXRatio/100));
	    turtleVY = (float) (_force * Math.sin(-_angle * Math.PI/180) * 2.5);
	    
	    turtleVR = 0;
	    turtleAR = (float) (_force/4.0);
	}
	
	public void  changeToBombShell()
	{
	    s_Turtle_Shell.setTextureRect(CGRect.make(1434/2*Global.g_Scale,610/2*Global.g_Scale,110/2*Global.g_Scale,86/2*Global.g_Scale));
	    isBombShell = true;
	    
	    turtle_HeadAndNeck_x = 100000;
	    turtle_Head_x = 100000;
	    turtle_Jaw_x = 100000;
	    turtle_Neck_x = 100000;
	    turtle_LeftLeg_x = 100000;
	    turtle_RightLeg_x = 100000;
	    turtle_Tail_x = 100000;
	    turtle_Eye_x = 100000;
	}
	
	public void  changeToNormalShell()
	{
	    s_Turtle_Shell.setTextureRect(CGRect.make(396/2*Global.g_Scale,200/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	    
	    isBombShell = true;
	    
	    turtle_HeadAndNeck_x = 100000;
	    turtle_Head_x = 100000;
	    turtle_Jaw_x = 100000;
	    turtle_Neck_x = 100000;
	    turtle_LeftLeg_x = 100000;
	    turtle_RightLeg_x = 100000;
	    turtle_Tail_x = 100000;
	    turtle_Eye_x = 100000;
	}
	
	
	public void  setYellowHurt()
	{
	    isYellowHurt = true;
	    yellowHurtTimer = 0;
	}
	
	public void  manageYellowHurt()
	{
	    int rr;
	    int gg;
	    int bb;
	    
	    if(isYellowHurt){
	        if(yellowHurtTimer == 0){
	            
	            rr = 255;
	            gg = 195;
	            bb = 124;
	            
	            s_Turtle_HeadAndNeck.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Head.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Jaw.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Neck.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Shell.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_LeftLeg.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_RightLeg.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Tail.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Shadow.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Eye.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[0].setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[1].setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[2].setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[3].setColor(ccColor3B.ccc3(rr, gg, bb));
	        }
	        
	        yellowHurtTimer++;
	        if(yellowHurtTimer == 2){
	            isYellowHurt = false;
	            
	            rr = 255;
	            gg = 255;
	            bb = 255;
	            
	            s_Turtle_HeadAndNeck.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Head.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Jaw.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Neck.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Shell.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_LeftLeg.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_RightLeg.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Tail.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Shadow.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Eye.setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[0].setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[1].setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[2].setColor(ccColor3B.ccc3(rr, gg, bb));
	            s_Turtle_Spike[3].setColor(ccColor3B.ccc3(rr, gg, bb));
	            
	        }
	    }
	}
	
	
	//FOR MAIN
	public void  turtleFlying()
	{
	    turtleAniStep = Global.characterFlyingStep;
	    
	    float fuckScale =  1.37119664f;
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	    
	    superFuxkOriX -= 15;
	    superFuxkOriY += 0;
	    
	    turtle_Neck_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_Neck_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	    
	    superFuxkOriX -= 3;
	    superFuxkOriY -= 1;
	    
	    turtle_Head_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_Head_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	    
	    superFuxkOriY += 2;
	    
	    turtle_Shell_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_Shell_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	    turtle_LeftLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_LeftLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	    turtle_RightLeg_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_RightLeg_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].x * Global.wholeTurtleScaleFromSocurce;
	    superFuxkOriY =  Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].y * Global.wholeTurtleScaleFromSocurce;
	    turtle_Tail_x =  turtleX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    turtle_Tail_y =  turtleY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	   
	    turtle_Neck_r = Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation + 180;
	    turtle_Head_r = Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation + 180;
	    turtle_Shell_r = Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation + 180;
	    turtle_LeftLeg_r = Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation + 180;
	    turtle_RightLeg_r = Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation + 180;
	    turtle_Tail_r = Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].rotation * 180/Math.PI + turtleRotation + 180;
	    
	    s_Turtle_Neck.setRotation(turtle_Neck_r);
	    s_Turtle_Head.setRotation(turtle_Head_r);
	    s_Turtle_Shell.setRotation(turtle_Shell_r);
	    s_Turtle_LeftLeg.setRotation(turtle_LeftLeg_r);
	    s_Turtle_RightLeg.setRotation(turtle_RightLeg_r);
	    s_Turtle_Tail.setRotation(turtle_Tail_r);
	
	   
	    s_Turtle_Neck.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_Head.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_Shell.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_LeftLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_RightLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_Tail.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleX * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    
	    s_Turtle_Neck.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Neck].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_Head.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Head].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_Shell.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Shell].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_LeftLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_LeftLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_RightLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_RightLeg].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    s_Turtle_Tail.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.RocketAnim.spriteData[kTurtlePart_Tail].firstFrame + turtleAniStep].scaleY * Global.wholeTurtleScaleFromSocurce * 2 * fuckScale);
	    
	    s_Turtle_Neck.setPosition(CGPoint.ccp(turtle_Neck_x + externalOffsetX2, turtle_Neck_y + externalOffsetY2));
	    s_Turtle_Head.setPosition(CGPoint.ccp(turtle_Head_x + externalOffsetX2, turtle_Head_y + externalOffsetY2));
	    s_Turtle_Shell.setPosition(CGPoint.ccp(turtle_Shell_x + externalOffsetX2, turtle_Shell_y + externalOffsetY2));
	    s_Turtle_LeftLeg.setPosition(CGPoint.ccp(turtle_LeftLeg_x + externalOffsetX2, turtle_LeftLeg_y + externalOffsetY2));
	    s_Turtle_RightLeg.setPosition(CGPoint.ccp(turtle_RightLeg_x + externalOffsetX2, turtle_RightLeg_y + externalOffsetY2));
	    s_Turtle_Tail.setPosition(CGPoint.ccp(turtle_Tail_x + externalOffsetX2, turtle_Tail_y + externalOffsetY2));
	   
	}

}
