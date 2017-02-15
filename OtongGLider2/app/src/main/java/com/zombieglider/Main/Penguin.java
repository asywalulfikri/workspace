package com.zombieglider.Main;


import com.zombieglider.Global;
import com.zombieglider.Main.Mini.MiniBasic;

import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
//
//  Penguin.m
//  TurtlesHuh
//
//  Created by  on 2012/4/29.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//

//ByRCH#import "Penguin.h"
//ByRCH#import "animationDefs.h"
//ByRCH#import "GamePlayGlobal.h"

public class Penguin extends CCNode
{
	//typedef enum{
	public static final int kPenguinPart_BackLeg = 0;
	public static final int kPenguinPart_Body = 1;
	public static final int kPenguinPart_Wing = 2;
	public static final int kPenguinPart_Eye = 3;
	public static final int kPenguinPart_Mouth = 4;
	public static final int kPenguinPart_FrontLeg = 5;
	//}ePenguinPart;

	//typedef enum{
	public static final int kPenguinJump_jumpTo1TurtleShell = 0;
	public static final int kPenguinJump_jumpTo2TurtleShell = 1;
	public static final int kPenguinJump_jumpToDYNAMICTurtleShell = 2;
	//}ePenguinJump;

	//typedef enum{
	public static final int kPenguinAniStatus_Idle = 0;
	public static final int kPenguinAniStatus_Jumping = 1;
	public static final int kPenguinAniStatus_JumpingWithGravity = 2;
	public static final int kPenguinAniStatus_Bombing = 3;
	//}ePenguinAniStatus;

	//typedef enum{
	public static final int kBombOutOffScreenDirection_Left_Penguin = 0;
	public static final int kBombOutOffScreenDirection_Right_Penguin = 1;
	//}eBombOutOffScreenDirectionPenguin;

	
    int status;
    int jumpType;
    
    boolean isJumping;
    int jumpingTimer;
    
    int idNumber;

    float x;
    float y;
    float jumpXLengthInterval;
    //float jumpY_vy;
    //float jumpY_ay;
    float jumpY_extraY;
    float jumpY_maxY;
    float jumpY_angleInterval;
    float jumpY_angle;
    
    CCSprite s_Body;
    CCSprite s_Eye;
    CCSprite s_FrontLeg;
    CCSprite s_BackLeg;
    CCSprite s_Mouth;
    CCSprite s_Wing;
    
    double body_x;
    double eye_x;
    double frontLeg_x;
    double backLeg_x;
    double mouth_x;
    double wing_x;
    
    double body_y;
    double eye_y;
    double frontLeg_y;
    double backLeg_y;
    double mouth_y;
    double wing_y;
    
    int aniStep;
    int aniStep2;
    int jumpingAniStep;
    
    boolean isFacingRight;
    boolean temp_isFast;
    
    float useThisEyeX;
    float useThisEyeY;
    float useThisEyeR;
    float useThisWingX;
    float useThisWingY;
    float useThisWingR;
        
    MiniBasic delegate;
    
    double idle_x[] = new double[6];
    double idle_y[] = new double[6];
    double idle_r[] = new double[6];
    double idle_sx[] = new double[6];
    double idle_sy[] = new double[6];
    
    float externalOffsetX;
    float externalOffsetY;
    float externalOffsetX2;
    float externalOffsetY2;
    float externalOffsetFinalX;
    float externalOffsetFinalY;
    
     int bombOutOffScreenDirection;
     int bombAniStep;
    
    
    float bomb_force;
    float bomb_x;
    float bomb_y;
    float bomb_vx;
    float bomb_vy;
    float bomb_oriVy;
    double bomb_ay;
    boolean bomb_isRotatingClockrise;
    double bomb_vr;

    float turtleRotation;
    
    double superFuxkAngleDiff;
    double superFuxkOriX;
    double superFuxkOriY;

    boolean isNotInGame;
    
    float penguinScale;
    
    boolean MAIN_ISCOLLIDING;
    

    float MAIN_COLLIDE_EYE_X;
    float MAIN_COLLIDE_EYE_Y;
    float MAIN_COLLIDE_WING_X;
    float MAIN_COLLIDE_WING_Y;
    float MAIN_COLLIDE_EYE_R;
    float MAIN_COLLIDE_WING_R;

    float MAIN_COLLIDE_EYE_VX;
    float MAIN_COLLIDE_EYE_VY;
    float MAIN_COLLIDE_WING_VX;
    float MAIN_COLLIDE_WING_VY;
    float MAIN_COLLIDE_EYE_VR;
    float MAIN_COLLIDE_WING_VR;

	
	
	public int  jumpingAniStep()
	{
	    return jumpingAniStep;
	}
	
	public void  bombOutOffScreenDirection( int _bomOutOffScreenDirection)
	{
	    bombOutOffScreenDirection = _bomOutOffScreenDirection;
	}
	
	public void  setOpacity( int _opacity)
	{
	    s_Body.setOpacity(_opacity);
	    s_Eye.setOpacity(_opacity);
	    s_FrontLeg.setOpacity(_opacity);
	    s_BackLeg.setOpacity(_opacity);
	    s_Mouth.setOpacity(_opacity);
	    s_Wing.setOpacity(_opacity);
	}
	
	public boolean  facingRight()
	{
	    return isFacingRight;
	}
	
	public float x()
	{
	    return x;
	}
	
	public float y()
	{
	    return y;
	}
	
	public float jumpingX()
	{
	    return x + jumpXLengthInterval * aniStep;
	}
	
	public void  setDelegate( MiniBasic _delegate)
	{
	    delegate = _delegate;
	}
	
	public void  setIDNumber( int _number)
	{
	    idNumber = _number;
	}
	
	public void  setFacingRight( boolean _isRight)
	{
	    
	    if(isFacingRight != _isRight){
	        s_Body.setScaleX(1.0f/Global.g_Scale*-s_Body.getScaleX());
	        s_Eye.setScaleX(1.0f/Global.g_Scale*-s_Eye.getScaleX());
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*-s_FrontLeg.getScaleX());
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*-s_BackLeg.getScaleX());
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*-s_Mouth.getScaleX());
	        s_Wing.setScaleX(1.0f/Global.g_Scale*-s_Wing.getScaleX());
	    }
	    
	    isFacingRight = _isRight;
	}
	
	public void  setIsNotInGame( boolean _notInGame)
	{
	    isNotInGame = _notInGame;
	}
	
	public void  setPenguinScale( float _scale)
	{
	    penguinScale = _scale;
	    
	    if(isFacingRight){
	        superFuxkAngleDiff = (float) (-turtleRotation * Math.PI/180);
	        superFuxkOriX = idle_x[kPenguinPart_Body] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * penguinScale;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Eye] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * penguinScale;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_FrontLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * penguinScale;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_BackLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * penguinScale;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Mouth] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * penguinScale;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Wing] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * penguinScale;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    }else{
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Body] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * penguinScale;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Eye] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * penguinScale;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_FrontLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * penguinScale;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_BackLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * penguinScale;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Mouth] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * penguinScale;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Wing] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * penguinScale;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    }
	    
	    
	    idle_sx[kPenguinPart_BackLeg] = penguinScale * 2;
	    idle_sy[kPenguinPart_BackLeg] = penguinScale * 2;
	    idle_sx[kPenguinPart_Body] = penguinScale * 2;
	    idle_sy[kPenguinPart_Body] = penguinScale * 2;
	    idle_sx[kPenguinPart_Eye] = penguinScale * 2;
	    idle_sy[kPenguinPart_Eye] = penguinScale * 2;
	    idle_sx[kPenguinPart_Mouth] = penguinScale * 2;
	    idle_sy[kPenguinPart_Mouth] = penguinScale * 2;
	    idle_sx[kPenguinPart_FrontLeg] = penguinScale * 2;
	    idle_sy[kPenguinPart_FrontLeg] = penguinScale * 2;
	    
	    if(!Global.isPlayingMiniGame){
	        idle_sx[kPenguinPart_Eye] = penguinScale * 2;
	        idle_sy[kPenguinPart_Eye] = (float) (penguinScale * 2 * 1.161);
	    }
	    
	    if(isFacingRight){
	        s_Body.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Body]);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Eye]);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_FrontLeg]);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_BackLeg]);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Mouth]);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Wing]);
	        
	        s_Body.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Body]);
	        s_Eye.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Eye]);
	        s_FrontLeg.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_FrontLeg]);
	        s_BackLeg.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_BackLeg]);
	        s_Mouth.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Mouth]);
	        s_Wing.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Wing]);
	    }else{
	        s_Body.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Body]);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Eye]);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_FrontLeg]);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_BackLeg]);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Mouth]);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Wing]);
	        
	        s_Body.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Body]);
	        s_Eye.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Eye]);
	        s_FrontLeg.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_FrontLeg]);
	        s_BackLeg.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_BackLeg]);
	        s_Mouth.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Mouth]);
	        s_Wing.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Wing]);
	    }
	
	
	}
	
	public Penguin()
	{
		// always call "super" init
		// Apple recommends to re-assign "this" with the "super" return value
		super();
	    delegate = null;
        
        penguinScale = Global.wholePenguinScaleFromSocurce;
        
         body_x = 9999;
         eye_x = 9999;
         frontLeg_x = 9999;
         backLeg_x = 9999;
         mouth_x = 9999;
         wing_x = 9999;
        
         body_y = 9999;
         eye_y = 9999;
         frontLeg_y = 9999;
         backLeg_y = 9999;
         mouth_y = 9999;
         wing_y = 9999;
        
        aniStep = 0;
        aniStep2 = 0;
        
        isFacingRight = true;
        isNotInGame = false;

        
   
        if(Global.isPlayingMiniGame){
            s_Body = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0*Global.g_Scale,392/2*Global.g_Scale,100/2*Global.g_Scale,151/2*Global.g_Scale));
            s_Eye = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(134/2*Global.g_Scale,506/2*Global.g_Scale,16/2*Global.g_Scale,26/2*Global.g_Scale));
            //RMS
            //s_FrontLeg = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(100/2,484/2,57/2,17/2));
            s_FrontLeg = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(23/2*Global.g_Scale,984/2*Global.g_Scale,76/2*Global.g_Scale,26/2*Global.g_Scale));
            //RMS
            s_BackLeg = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(102/2*Global.g_Scale,484/2*Global.g_Scale,55/2*Global.g_Scale,17/2*Global.g_Scale));
            s_Mouth = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(102/2*Global.g_Scale,506/2*Global.g_Scale,29/2*Global.g_Scale,31/2*Global.g_Scale));
            s_Wing = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(102/2*Global.g_Scale,392/2*Global.g_Scale,52/2*Global.g_Scale,70/2*Global.g_Scale));
            
            Global.ss_Character.addChild(s_Body,Global.kDeapth_Penguin_Body);
            Global.ss_Character.addChild(s_Eye,Global.kDeapth_Penguin_Eye);
            Global.ss_Character.addChild(s_FrontLeg,Global.kDeapth_Penguin_FrongLeg);
            Global.ss_Character.addChild(s_BackLeg,Global.kDeapth_Penguin_BackLeg);
            Global.ss_Character.addChild(s_Mouth,Global.kDeapth_Penguin_Mouth);
            Global.ss_Character.addChild(s_Wing,Global.kDeapth_Penguin_Wing);
            
            s_Body.setAnchorPoint(CGPoint.ccp(49.0/99.0, 1.0 - 76.0/151.0));
            s_Eye.setAnchorPoint(CGPoint.ccp(8.0/16.0, 1.0 - 13.0/26.0));
            //RMS
            //s_FrontLeg.setAnchorPoint(CGPoint.ccp(27.0/55.0, 1.0 - 8.0/17.0));
            s_FrontLeg.setAnchorPoint(CGPoint.ccp(38.0/76.0, 1.0 - 13.0/26.0));
            //RMS
            s_BackLeg.setAnchorPoint(CGPoint.ccp(27.0/55.0, 1.0 - 8/17.0));
            s_Mouth.setAnchorPoint(CGPoint.ccp(14.0/29.0, 1.0 - 17.0/31.0));
            s_Wing.setAnchorPoint(CGPoint.ccp(26.0/51.0, 1.0 - 35.0/69.0));
            
        }else{
            //EYE FOR ROPE
            //WING FOR ROCKET
            
            s_Body = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1260/2*Global.g_Scale,150/2*Global.g_Scale,154/2*Global.g_Scale,100/2*Global.g_Scale));
            s_Eye = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(616/2*Global.g_Scale+726/2*Global.g_Scale, 824/2*Global.g_Scale-132/2*Global.g_Scale, 42/2*Global.g_Scale,118/2*Global.g_Scale));
            s_FrontLeg = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2,0/2,0/2,0/2));
            s_BackLeg = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2,0/2,0/2,0/2));
            s_Mouth = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2,0/2,0/2,0/2));
            s_Wing = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(398/2*Global.g_Scale+726/2*Global.g_Scale,824/2*Global.g_Scale-132/2*Global.g_Scale,216/2*Global.g_Scale,88/2*Global.g_Scale));
            
            Global.ss_Character.addChild(s_Body,Global.kDeapth_Penguin_MAIN);
            Global.ss_Character.addChild(s_Wing,Global.kDeapth_Penguin_MAIN);
            Global.ss_Character.addChild(s_Eye,Global.kDeapth_Penguin_MAIN);
            Global.ss_Character.addChild(s_FrontLeg,Global.kDeapth_Penguin_MAIN);
            Global.ss_Character.addChild(s_BackLeg,Global.kDeapth_Penguin_MAIN);
            Global.ss_Character.addChild(s_Mouth,Global.kDeapth_Penguin_MAIN);
            
            
            s_Body.setAnchorPoint(CGPoint.ccp(49.0/99.0, 1.0 - 76.0/151.0));
            s_Eye.setAnchorPoint(CGPoint.ccp(39.0/79.0,118.0/236.0));
            s_Wing.setAnchorPoint(CGPoint.ccp(207.0/428.0,90.0/175.0));
            
        }
        
        //RMS
        s_Mouth.setVisible(false);
        s_BackLeg.setVisible(false);
        //RMS
        
        if(Global.isPlayingMiniGame){
            idle_x[kPenguinPart_BackLeg] = 7.100000000000023f;
            idle_y[kPenguinPart_BackLeg] = 6.550000000000011f;
            idle_r[kPenguinPart_BackLeg] = 0;
            idle_sx[kPenguinPart_BackLeg] = penguinScale * 2;
            idle_sy[kPenguinPart_BackLeg] = penguinScale * 2;
            
            //RMS
            //idle_x[kPenguinPart_Body] = 18.19999999999999;
            idle_x[kPenguinPart_Body] = 0;
            //RMS
            idle_y[kPenguinPart_Body] = 76.15;
            idle_r[kPenguinPart_Body] = 0;
            idle_sx[kPenguinPart_Body] = penguinScale * 2;
            idle_sy[kPenguinPart_Body] = penguinScale * 2;
            
            idle_x[kPenguinPart_Wing] = 11.850000000000023;
            idle_y[kPenguinPart_Wing] = 58.69999999999999;
            idle_r[kPenguinPart_Wing] = 0;
            idle_sx[kPenguinPart_Wing] = penguinScale * 2;
            idle_sy[kPenguinPart_Wing] = penguinScale * 2;
            
            idle_x[kPenguinPart_Eye] = 30.5 / 2;
            idle_y[kPenguinPart_Eye] = 121.05;
            idle_r[kPenguinPart_Eye] = 0;
            idle_sx[kPenguinPart_Eye] = penguinScale * 2;
            idle_sy[kPenguinPart_Eye] = penguinScale * 2;
            
            idle_x[kPenguinPart_Mouth] = 35.80000000000001;
            idle_y[kPenguinPart_Mouth] = 105.1;
            idle_r[kPenguinPart_Mouth] = 0;
            idle_sx[kPenguinPart_Mouth] = penguinScale * 2;
            idle_sy[kPenguinPart_Mouth] = penguinScale * 2;
            
            idle_x[kPenguinPart_FrontLeg] = 0.14999999999997726;
            idle_y[kPenguinPart_FrontLeg] = 6.550000000000011;
            idle_r[kPenguinPart_FrontLeg] = 0;
            idle_sx[kPenguinPart_FrontLeg] = penguinScale * 2;
            idle_sy[kPenguinPart_FrontLeg] = penguinScale * 2;
        }else{
            

            
            idle_x[kPenguinPart_Body] = 18.19999999999999 - 18.19999999999999;
            idle_y[kPenguinPart_Body] = 76.15 - 76.15;
            idle_r[kPenguinPart_Body] = 0;
            idle_sx[kPenguinPart_Body] = -penguinScale * 2;
            idle_sy[kPenguinPart_Body] = penguinScale * 2;
            
            idle_x[kPenguinPart_Wing] = 11.850000000000023 - 2 - 18.19999999999999;
            idle_y[kPenguinPart_Wing] = 133 - 76.15;
            idle_r[kPenguinPart_Wing] = 0;
            idle_sx[kPenguinPart_Wing] = -penguinScale * 2;
            idle_sy[kPenguinPart_Wing] = penguinScale * 2;
            
            idle_x[kPenguinPart_Eye] = 2 - 18.19999999999999;
            idle_y[kPenguinPart_Eye] = 94 - 76.15;
            idle_r[kPenguinPart_Eye] = 0;
            idle_sx[kPenguinPart_Eye] = -penguinScale * 2;
            idle_sy[kPenguinPart_Eye] = penguinScale * 2 * 1.161;
            
            
            idle_x[kPenguinPart_FrontLeg] = 0;
            idle_y[kPenguinPart_FrontLeg] = 0;
            idle_r[kPenguinPart_FrontLeg] = 0;
            idle_sx[kPenguinPart_FrontLeg] = 0;
            idle_sy[kPenguinPart_FrontLeg] = 0;
            
            idle_x[kPenguinPart_Mouth] = 0;
            idle_y[kPenguinPart_Mouth] = 0;
            idle_r[kPenguinPart_Mouth] = 0;
            idle_sx[kPenguinPart_Mouth] = 0;
            idle_sy[kPenguinPart_Mouth] = 0;
            
            idle_x[kPenguinPart_BackLeg] = 0;
            idle_y[kPenguinPart_BackLeg] = 0;
            idle_r[kPenguinPart_BackLeg] = 0;
            idle_sx[kPenguinPart_BackLeg] = 0;
            idle_sy[kPenguinPart_BackLeg] = 0;
            
        }
	}
	
	public int  status()
	{
	    return status;
	}
	
	public void  setR( float _r)
	{
	    turtleRotation = _r;
	    
	    if(Global.isPlayingMiniGame){
	        s_Body.setRotation((float) (idle_r[kPenguinPart_Body] * 180/Math.PI + turtleRotation));
	        s_Eye.setRotation((float) (idle_r[kPenguinPart_Eye] * 180/Math.PI + turtleRotation));
	        s_FrontLeg.setRotation((float) (idle_r[kPenguinPart_FrontLeg] * 180/Math.PI + turtleRotation));
	        s_BackLeg.setRotation((float) (idle_r[kPenguinPart_BackLeg] * 180/Math.PI + turtleRotation));
	        s_Mouth.setRotation((float) (idle_r[kPenguinPart_Mouth] * 180/Math.PI + turtleRotation));
	        s_Wing.setRotation((float) (idle_r[kPenguinPart_Wing] * 180/Math.PI + turtleRotation));
	    }else{
	      //  s_Body.setRotation(idle_r[kPenguinPart_Body] * 180/Math.PI + turtleRotation);
	      //  s_Eye.setRotation(idle_r[kPenguinPart_Eye] * 180/Math.PI + turtleRotation);
	      //  s_Wing.setRotation(idle_r[kPenguinPart_Wing] * 180/Math.PI + turtleRotation);
	    }
	    
	
	}
	
	public void  setX( float _x)
	{
	    x = _x;
	    
	    if(!Global.isPlayingMiniGame){
	        return;
	    }
	    
	    if(isFacingRight){
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Body] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * penguinScale;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Eye] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * penguinScale;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_FrontLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * penguinScale;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_BackLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * penguinScale;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Mouth] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * penguinScale;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Wing] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * penguinScale;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    }else{
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Body] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * penguinScale;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Eye] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * penguinScale;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_FrontLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * penguinScale;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_BackLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * penguinScale;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Mouth] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * penguinScale;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Wing] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * penguinScale;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    }
	    
	}
	
	public void  setY( float _y)
	{
	    y = _y;
	    
	    if(!Global.isPlayingMiniGame){
	        return;
	    }
	    
	    if(isFacingRight){
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Body] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * penguinScale;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Eye] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * penguinScale;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_FrontLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * penguinScale;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_BackLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * penguinScale;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Mouth] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * penguinScale;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Wing] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * penguinScale;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    }else{
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Body] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * penguinScale;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Eye] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * penguinScale;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_FrontLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * penguinScale;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_BackLeg] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * penguinScale;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Mouth] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * penguinScale;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Wing] * penguinScale;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * penguinScale;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    }
	}
	
	public void  setExternalOffsetFinalXALL( float _ex)
	{
	    externalOffsetFinalX = _ex;
	    externalOffsetX2 = _ex;
	}
	
	
	public void  setExternalOffsetFinalX( float _ex)
	{
	    externalOffsetFinalX = _ex;
	}
	
	public void  setExternalOffsetFinalY( float _ey)
	{
	    externalOffsetFinalY = _ey;
	}
	
	public void  setStatus( int  _status)
	{
	    status = _status;
	    
	    if(_status == kPenguinAniStatus_Idle){
	        aniStep = 0;
	        turtleRotation = 0;
	        
	        if(isFacingRight){
	            body_x = x + idle_x[kPenguinPart_Body] * penguinScale;
	            eye_x = x + idle_x[kPenguinPart_Eye] * penguinScale;
	            frontLeg_x = x + idle_x[kPenguinPart_FrontLeg] * penguinScale;
	            backLeg_x = x + idle_x[kPenguinPart_BackLeg] * penguinScale;
	            mouth_x = x + idle_x[kPenguinPart_Mouth] * penguinScale;
	            wing_x = x + idle_x[kPenguinPart_Wing] * penguinScale;
	            
	            body_y = y + idle_y[kPenguinPart_Body] * penguinScale;
	            eye_y = y + idle_y[kPenguinPart_Eye] * penguinScale;
	            frontLeg_y = y + idle_y[kPenguinPart_FrontLeg] * penguinScale;
	            backLeg_y = y + idle_y[kPenguinPart_BackLeg] * penguinScale;
	            mouth_y = y + idle_y[kPenguinPart_Mouth] * penguinScale;
	            wing_y = y + idle_y[kPenguinPart_Wing] * penguinScale;
	
	        }else{
	            body_x = x - idle_x[kPenguinPart_Body] * penguinScale;
	            eye_x = x - idle_x[kPenguinPart_Eye] * penguinScale;
	            frontLeg_x = x - idle_x[kPenguinPart_FrontLeg] * penguinScale;
	            backLeg_x = x - idle_x[kPenguinPart_BackLeg] * penguinScale;
	            mouth_x = x - idle_x[kPenguinPart_Mouth] * penguinScale;
	            wing_x = x - idle_x[kPenguinPart_Wing] * penguinScale;
	            
	            body_y = y + idle_y[kPenguinPart_Body] * penguinScale;
	            eye_y = y + idle_y[kPenguinPart_Eye] * penguinScale;
	            frontLeg_y = y + idle_y[kPenguinPart_FrontLeg] * penguinScale;
	            backLeg_y = y + idle_y[kPenguinPart_BackLeg] * penguinScale;
	            mouth_y = y + idle_y[kPenguinPart_Mouth] * penguinScale;
	            wing_y = y + idle_y[kPenguinPart_Wing] * penguinScale;
	        }
	        
	        
	        s_Body.setRotation((float) (idle_r[kPenguinPart_Body] * 180/Math.PI));
	        s_Eye.setRotation((float) (idle_r[kPenguinPart_Eye] * 180/Math.PI));
	        s_FrontLeg.setRotation((float) (idle_r[kPenguinPart_FrontLeg] * 180/Math.PI));
	        s_BackLeg.setRotation((float) (idle_r[kPenguinPart_BackLeg] * 180/Math.PI));
	        s_Mouth.setRotation((float) (idle_r[kPenguinPart_Mouth] * 180/Math.PI));
	        s_Wing.setRotation((float) (idle_r[kPenguinPart_Wing] * 180/Math.PI));
	        
	        if(isFacingRight){
	            s_Body.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Body]);
	            s_Eye.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Eye]);
	            s_FrontLeg.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_FrontLeg]);
	            s_BackLeg.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_BackLeg]);
	            s_Mouth.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Mouth]);
	            s_Wing.setScaleX(1.0f/Global.g_Scale*idle_sx[kPenguinPart_Wing]);
	        }else{
	            s_Body.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Body]);
	            s_Eye.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Eye]);
	            s_FrontLeg.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_FrontLeg]);
	            s_BackLeg.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_BackLeg]);
	            s_Mouth.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Mouth]);
	            s_Wing.setScaleX(1.0f/Global.g_Scale*-idle_sx[kPenguinPart_Wing]);
	        }
	        
	        
	        s_Body.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Body]);
	        s_Eye.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Eye]);
	        s_FrontLeg.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_FrontLeg]);
	        s_BackLeg.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_BackLeg]);
	        s_Mouth.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Mouth]);
	        s_Wing.setScaleY(1.0f/Global.g_Scale*idle_sy[kPenguinPart_Wing]);
	        
	        
	        if(Global.next_hasNext){
	            Global.isGoingToNext = true;
	        }
	    }
	    
	    if(status == kPenguinAniStatus_Jumping){
	        aniStep = 0;
	        aniStep2 = 0;
	        jumpingAniStep = 0;
	    }
	    
	    if(status == kPenguinAniStatus_JumpingWithGravity){
	        aniStep = 0;
	        aniStep2 = 0;
	        jumpingAniStep = 0;
	    }
	
	    
	    if(_status == kPenguinAniStatus_Bombing){
	        bombAniStep = 0;
	    }
	}
	
	public void  setJump( int _jump)
	{
	    if(status == kPenguinAniStatus_Jumping){
	        return;
	    }
	    
	    if(_jump == kPenguinJump_jumpTo1TurtleShell){
	        jumpY_maxY = 25;
	    }
	    if(_jump == kPenguinJump_jumpTo2TurtleShell){
	        jumpY_maxY = 50;
	    }
	    if(_jump == kPenguinJump_jumpToDYNAMICTurtleShell){
	        jumpY_maxY = Global.penguin_DynmaicJumpY;
	    }
	    
	    jumpXLengthInterval = (Global.penguinJumpFinalX - x)/9;
	    jumpY_angle = 0;
	    jumpY_angleInterval = (float) (Math.PI/9);
	
	    
	    jumpType = _jump;
	    this.setStatus(kPenguinAniStatus_Jumping);
	}
	
	public void  setJumpWithGravity()
	{
	    this.setStatus(kPenguinAniStatus_JumpingWithGravity);
	}
	
	
	
	public void  manage()
	{
	    this.checkAndRunAni();
	    
	    if(Global.isGoingToNext){
	        isFacingRight = Global.next_isFacingRight;
	        
	        aniStep = 0;
	        aniStep2 = 0;
	        
	        Global.next_hasNext = false;
	        
	        if(delegate != null && Global.isPlayingMiniGame){
	            delegate.gotoNextJump();
	        }
	        
	        
	        this.setJump(Global.next_jumpType);
	
	        
	        Global.isGoingToNext = false;
	    }
	    
	    /*if(Global.currentChosenMiniGame == 4){
	        externalOffsetX += (externalOffsetFinalX-externalOffsetX)/10;
	        externalOffsetY += (externalOffsetFinalY-externalOffsetY)/10;
	    }*/
	    
	    
	    externalOffsetX2 += (externalOffsetFinalX-externalOffsetX2)/100;
	    externalOffsetY2 += (externalOffsetFinalY-externalOffsetY2)/100;
	    
	    if(Global.currentChosenMiniGame == 10){
	        if(!isFacingRight){
	            s_Body.setPosition(CGPoint.ccp(body_x + externalOffsetX2+7, body_y + externalOffsetY2));
	            s_Eye.setPosition(CGPoint.ccp(eye_x + externalOffsetX2+7, eye_y + externalOffsetY2));
	            s_FrontLeg.setPosition(CGPoint.ccp(frontLeg_x + externalOffsetX2+7, frontLeg_y + externalOffsetY2));
	            s_BackLeg.setPosition(CGPoint.ccp(backLeg_x + externalOffsetX2+7, backLeg_y + externalOffsetY2));
	            s_Mouth.setPosition(CGPoint.ccp(mouth_x + externalOffsetX2+7, mouth_y + externalOffsetY2));
	            s_Wing.setPosition(CGPoint.ccp(wing_x + externalOffsetX2+7, wing_y + externalOffsetY2));
	        }else{
	            s_Body.setPosition(CGPoint.ccp(body_x + externalOffsetX2, body_y + externalOffsetY2));
	            s_Eye.setPosition(CGPoint.ccp(eye_x + externalOffsetX2, eye_y + externalOffsetY2));
	            s_FrontLeg.setPosition(CGPoint.ccp(frontLeg_x + externalOffsetX2, frontLeg_y + externalOffsetY2));
	            s_BackLeg.setPosition(CGPoint.ccp(backLeg_x + externalOffsetX2, backLeg_y + externalOffsetY2));
	            s_Mouth.setPosition(CGPoint.ccp(mouth_x + externalOffsetX2, mouth_y + externalOffsetY2));
	            s_Wing.setPosition(CGPoint.ccp(wing_x + externalOffsetX2, wing_y + externalOffsetY2));
	        }
	    }else if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 102){
	        if(!isFacingRight){
	            s_Body.setPosition(CGPoint.ccp(body_x + externalOffsetX2+12, body_y + externalOffsetY2));
	            s_Eye.setPosition(CGPoint.ccp(eye_x + externalOffsetX2+12, eye_y + externalOffsetY2));
	            s_FrontLeg.setPosition(CGPoint.ccp(frontLeg_x + externalOffsetX2+12, frontLeg_y + externalOffsetY2));
	            s_BackLeg.setPosition(CGPoint.ccp(backLeg_x + externalOffsetX2+12, backLeg_y + externalOffsetY2));
	            s_Mouth.setPosition(CGPoint.ccp(mouth_x + externalOffsetX2+12, mouth_y + externalOffsetY2));
	            s_Wing.setPosition(CGPoint.ccp(wing_x + externalOffsetX2+12, wing_y + externalOffsetY2));
	        }else{
	            s_Body.setPosition(CGPoint.ccp(body_x + externalOffsetX2, body_y + externalOffsetY2));
	            s_Eye.setPosition(CGPoint.ccp(eye_x + externalOffsetX2, eye_y + externalOffsetY2));
	            s_FrontLeg.setPosition(CGPoint.ccp(frontLeg_x + externalOffsetX2, frontLeg_y + externalOffsetY2));
	            s_BackLeg.setPosition(CGPoint.ccp(backLeg_x + externalOffsetX2, backLeg_y + externalOffsetY2));
	            s_Mouth.setPosition(CGPoint.ccp(mouth_x + externalOffsetX2, mouth_y + externalOffsetY2));
	            s_Wing.setPosition(CGPoint.ccp(wing_x + externalOffsetX2, wing_y + externalOffsetY2));
	        }
	    }else{
	        s_Body.setPosition(CGPoint.ccp(body_x + externalOffsetX2, body_y + externalOffsetY2));
	        s_Eye.setPosition(CGPoint.ccp(eye_x + externalOffsetX2, eye_y + externalOffsetY2));
	        s_FrontLeg.setPosition(CGPoint.ccp(frontLeg_x + externalOffsetX2, frontLeg_y + externalOffsetY2));
	        s_BackLeg.setPosition(CGPoint.ccp(backLeg_x + externalOffsetX2, backLeg_y + externalOffsetY2));
	        s_Mouth.setPosition(CGPoint.ccp(mouth_x + externalOffsetX2, mouth_y + externalOffsetY2));
	        s_Wing.setPosition(CGPoint.ccp(wing_x + externalOffsetX2, wing_y + externalOffsetY2));
	    }
	}
	
	public void  checkAndRunAni()
	{
	    if(isNotInGame){
	        if(status == kPenguinAniStatus_Jumping){
	            this.penguinJump();
	        }
	        return;
	    }
	    
	    if(Global.isPlayingMiniGame){
	        if(status == kPenguinAniStatus_Jumping){
	            this.penguinJump();
	        }
	        if(status == kPenguinAniStatus_JumpingWithGravity){
	            this.penguinJumpWithGravity();
	        }
	        if(status == kPenguinAniStatus_Bombing){
	            this.BombOffScreen();
	        }
	
	    }else{
	        if(status == kPenguinAniStatus_Jumping){
	            this.penguinJumpForMain();
	        }
	    }
	}
	
	public void  setToBombing()
	{
	    x += jumpXLengthInterval * aniStep;
	    y += jumpY_extraY;
	    this.setStatus(kPenguinAniStatus_Bombing);
	}
	
	public void  BombOffScreen()
	{
	    
	    if(bombAniStep == 0){
	        
	        if(Global.currentChosenMiniGame == 13){
	            bomb_force = 15;
	            
	            bomb_x = 0;
	            bomb_y = 0;
	            
	            bomb_vx = 14;
	            bomb_vy = 20;
	            bomb_oriVy = bomb_vy;
	            bomb_ay = -1.35;
	            
	            turtleRotation = 0;
	            
	        }else{
	            bomb_force = 10;
	            
	            bomb_x = 0;
	            bomb_y = 0;
	            
	            bomb_vx = 7;
	            bomb_vy = 14;
	            bomb_oriVy = bomb_vy;
	            bomb_ay = -0.85;
	        }
	       
	
	        
	        int ranR;
	        ranR = (int) (Math.random() * 65535 % 100);
	        
	       // turtleRotation = 0;
	        bomb_vr = bomb_force * 0.5;
	        bomb_isRotatingClockrise = true;
	        
	        if(bombOutOffScreenDirection == kBombOutOffScreenDirection_Left_Penguin){
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
	    
	    if(isFacingRight){
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Body] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * Global.wholeTurtleScaleFromSocurce;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Eye] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * Global.wholeTurtleScaleFromSocurce;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_FrontLeg] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * Global.wholeTurtleScaleFromSocurce;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_BackLeg] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * Global.wholeTurtleScaleFromSocurce;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Mouth] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * Global.wholeTurtleScaleFromSocurce;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = idle_x[kPenguinPart_Wing] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * Global.wholeTurtleScaleFromSocurce;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	    }else{
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Body] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Body] * Global.wholeTurtleScaleFromSocurce;
	        body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Eye] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Eye] * Global.wholeTurtleScaleFromSocurce;
	        eye_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        eye_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_FrontLeg] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_FrontLeg] * Global.wholeTurtleScaleFromSocurce;
	        frontLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        frontLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_BackLeg] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_BackLeg] * Global.wholeTurtleScaleFromSocurce;
	        backLeg_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        backLeg_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Mouth] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Mouth] * Global.wholeTurtleScaleFromSocurce;
	        mouth_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        mouth_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	        superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	        superFuxkOriX = -idle_x[kPenguinPart_Wing] * Global.wholeTurtleScaleFromSocurce;
	        superFuxkOriY = idle_y[kPenguinPart_Wing] * Global.wholeTurtleScaleFromSocurce;
	        wing_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) + bomb_x;
	        wing_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) + bomb_y;
	        
	    }
	    
	    
	
	    
	    s_Body.setRotation((float) (idle_r[kPenguinPart_Body] * 180/Math.PI + turtleRotation));
	    s_Eye.setRotation((float) (idle_r[kPenguinPart_Eye] * 180/Math.PI + turtleRotation));
	    s_FrontLeg.setRotation((float) (idle_r[kPenguinPart_FrontLeg] * 180/Math.PI + turtleRotation));
	    s_BackLeg.setRotation((float) (idle_r[kPenguinPart_BackLeg] * 180/Math.PI + turtleRotation));
	    s_Mouth.setRotation((float) (idle_r[kPenguinPart_Mouth] * 180/Math.PI + turtleRotation));
	    s_Wing.setRotation((float) (idle_r[kPenguinPart_Wing] * 180/Math.PI + turtleRotation));
	     
	    bombAniStep++;
	    
	
	}
	
	public void  penguinJump()
	{
	    aniStep++;
	    jumpingAniStep++;
	   
	    if(isFacingRight){
	        s_Body.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Eye.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_FrontLeg.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_BackLeg.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Mouth.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Wing.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].rotation * 180/Math.PI);
	    }else{
	        s_Body.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Eye.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_FrontLeg.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_BackLeg.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Mouth.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Wing.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].rotation * 180/Math.PI);
	    }
	    
	    
	    if(isFacingRight){
	        s_Body.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	    }else{
	        s_Body.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	    }
	    
	    
	    s_Body.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Eye.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_FrontLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_BackLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Mouth.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Wing.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    
	    
	    if(jumpType == kPenguinJump_jumpTo1TurtleShell){
	        if(aniStep == 1){
	           // jumpXLengthInterval = (penguinJumpFinalX - x)/35;
	            
	           // jumpY_maxY = 20;
	          //  jumpY_angle = 0;
	           // jumpY_angleInterval = Math.PI/35;
	
	        }
	    }
	    
	    
	    if(aniStep >= 9){
	        
	        if(delegate != null){
	            delegate.tapTurtle();
	        }
	        
	        if(Global.currentChosenMiniGame != 11 && Global.currentChosenMiniGame != 102){
	            this.setX((int) Global.penguinJumpFinalX);
	            setY((int) Global.penguinJumpFinalY);
	        }
	        
	        this.setStatus(kPenguinAniStatus_Idle);
	        
	        aniStep = 0;
	        jumpY_extraY = 0;
	        
	    }else{
	        
	        jumpY_angle = jumpY_angleInterval * aniStep;
	        jumpY_extraY = (float) (jumpY_maxY * Math.sin(jumpY_angle));
	        
	        if(isFacingRight){
	            body_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            eye_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            frontLeg_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            backLeg_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            mouth_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            wing_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            
	            body_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            eye_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            frontLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            backLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            mouth_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            wing_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            
	        }else{
	            body_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            eye_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            frontLeg_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            backLeg_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            mouth_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            wing_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            
	            body_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            eye_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            frontLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            backLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            mouth_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            wing_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	        }
	        
	    }
	    
	    
	    
	    if(temp_isFast){
	        aniStep+=2;
	        
	        if(aniStep >= 8){
	            aniStep = 8;
	        }
	    }
	    
	}
	
	public void  penguinJumpWithGravity()
	{
	
	    aniStep2++;
	    
	        aniStep++;
	        jumpingAniStep++;
	    
	   
	    
	    if(aniStep >= 8){
	        aniStep = 8;
	    }
	    
	    
	    if(isFacingRight){
	        s_Body.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Eye.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_FrontLeg.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_BackLeg.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Mouth.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Wing.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].rotation * 180/Math.PI);
	    }else{
	        s_Body.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Eye.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_FrontLeg.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_BackLeg.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Mouth.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Wing.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].rotation * 180/Math.PI);
	    }
	    
	    
	    if(isFacingRight){
	        s_Body.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	    }else{
	        s_Body.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	    }
	    
	    
	    s_Body.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Eye.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_FrontLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_BackLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Mouth.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Wing.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    
	
	    if(aniStep >= 9){
	 
	              
	    }else{
	        
	        jumpY_angle = 0;
	        jumpY_extraY = 0;
	        
	        if(isFacingRight){
	            body_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            eye_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            frontLeg_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            backLeg_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            mouth_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            wing_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            
	            body_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            eye_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            frontLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            backLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            mouth_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            wing_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            
	        }else{
	            body_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            eye_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            frontLeg_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            backLeg_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            mouth_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            wing_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            
	            body_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            eye_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            frontLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            backLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            mouth_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            wing_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	        }
	        
	    }
	    
	}
	
	public void  penguinJumpForMain()
	{
	    aniStep2++;
	     if(aniStep2 % 2 == 1){
	         aniStep++;
	         jumpingAniStep++;
	     }
	    
	    
	    if(isFacingRight){
	        s_Body.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Eye.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_FrontLeg.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_BackLeg.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Mouth.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Wing.setRotation(Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].rotation * 180/Math.PI);
	    }else{
	        s_Body.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Eye.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_FrontLeg.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_BackLeg.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Mouth.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].rotation * 180/Math.PI);
	        s_Wing.setRotation(-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].rotation * 180/Math.PI);
	    }
	    
	    
	    if(isFacingRight){
	        s_Body.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	    }else{
	        s_Body.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Eye.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_FrontLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_BackLeg.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Mouth.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	        s_Wing.setScaleX(1.0f/Global.g_Scale*-Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleX);
	    }
	    
	    
	    s_Body.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Eye.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_FrontLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_BackLeg.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Mouth.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    s_Wing.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].scaleY);
	    
	    if(aniStep >= 9){
	        
	        this.setStatus(kPenguinAniStatus_Idle);
	        
	        aniStep = 0;
	        jumpY_extraY = 0;
	        
	    }else{
	        
	        jumpY_angle = jumpY_angleInterval * aniStep;
	        jumpY_extraY = (float) (jumpY_maxY * Math.sin(jumpY_angle));
	        
	        if(isFacingRight){
	            body_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            eye_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            frontLeg_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            backLeg_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            mouth_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            wing_x = x + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            
	            body_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            eye_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            frontLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            backLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            mouth_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            wing_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            
	        }else{
	            body_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            eye_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            frontLeg_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            backLeg_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            mouth_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            wing_x = x - Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].x * penguinScale + jumpXLengthInterval * aniStep;
	            
	            body_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Body].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            eye_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Eye].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            frontLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_FrontLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            backLeg_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_BackLeg].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            mouth_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Mouth].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	            wing_y = y + Global.frameData[Global.PenguinJumpAnim.spriteData[kPenguinPart_Wing].firstFrame + aniStep].y * penguinScale + jumpY_extraY;
	        }
	        
	    }
	    
	    
	    
	    if(temp_isFast){
	        aniStep+=2;
	        
	        if(aniStep >= 8){
	            aniStep = 8;
	        }
	    }
	    
	}
	
	public void  tempSetFast( boolean _isFast)
	{
	    temp_isFast = false;
	}
	
	public boolean  setNext( int _jumpType, boolean _isFacingRight)
	{
	    
	    if(aniStep < 3){
	        return false;
	    }
	    
	    Global.next_jumpType = _jumpType;
	    Global.next_isFacingRight = _isFacingRight;
	    Global.next_hasNext = true;
	    
	    return true;
	}
	
	public void  setOutside()
	{
	    s_Body.setPosition(CGPoint.ccp(10000, body_y));
	    s_Eye.setPosition(CGPoint.ccp(10000, eye_y));
	    s_FrontLeg.setPosition(CGPoint.ccp(10000, frontLeg_y));
	    s_BackLeg.setPosition(CGPoint.ccp(10000, backLeg_y));
	    s_Mouth.setPosition(CGPoint.ccp(10000, mouth_y));
	    s_Wing.setPosition(CGPoint.ccp(10000, wing_y));
	}
	
	
	
	public void  SETMAINISCOLLDING( boolean _isColliding)
	{
	    
	    MAIN_ISCOLLIDING = _isColliding;
	    
	    
	    MAIN_COLLIDE_EYE_X = 0;
	    MAIN_COLLIDE_EYE_Y = 0;
	    MAIN_COLLIDE_WING_X = 0;
	    MAIN_COLLIDE_WING_Y = 0;
	    MAIN_COLLIDE_EYE_R = 0;
	    MAIN_COLLIDE_WING_R = 0;
	    
	    MAIN_COLLIDE_EYE_VX = 1.5f;
	    MAIN_COLLIDE_EYE_VY = 2.0f;
	    MAIN_COLLIDE_WING_VX = 1.0f;
	    MAIN_COLLIDE_WING_VY = 1.5f;
	    MAIN_COLLIDE_EYE_VR = Global.objVInCollision*1.5f;
	    MAIN_COLLIDE_WING_VR = Global.objVInCollision*1.25f;
	    
	}
	
	public void  MAINMANAGE()
	{
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX = -idle_x[kPenguinPart_Body] * penguinScale;
	    superFuxkOriY = idle_y[kPenguinPart_Body] * penguinScale;
	    body_x = x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    body_y = y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    
	    if(!MAIN_ISCOLLIDING){
	        useThisEyeX = x;
	        useThisEyeY = y;
	        useThisWingX = x;
	        useThisWingY = y;
	        useThisEyeR = turtleRotation;
	        useThisWingR = turtleRotation;
	        
	        
	    }else{
	        useThisEyeX = x + MAIN_COLLIDE_EYE_X;
	        useThisEyeY = y + MAIN_COLLIDE_EYE_Y;
	        useThisEyeR = turtleRotation + MAIN_COLLIDE_EYE_R;
	        
	        useThisWingX = x + MAIN_COLLIDE_WING_X;
	        useThisWingY = y + MAIN_COLLIDE_WING_Y;
	        useThisWingR = turtleRotation + MAIN_COLLIDE_WING_R;
	
	        MAIN_COLLIDE_EYE_X += MAIN_COLLIDE_EYE_VX;
	        MAIN_COLLIDE_EYE_Y += MAIN_COLLIDE_EYE_VY;
	        MAIN_COLLIDE_EYE_R += MAIN_COLLIDE_EYE_VR;
	        
	        MAIN_COLLIDE_WING_X += MAIN_COLLIDE_WING_VX;
	        MAIN_COLLIDE_WING_Y += MAIN_COLLIDE_WING_VY;
	        MAIN_COLLIDE_WING_R += MAIN_COLLIDE_WING_VR;
	        
	        MAIN_COLLIDE_EYE_VR *= 0.94;
	        MAIN_COLLIDE_WING_VR *= 0.94;
	        
	    }
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX = -idle_x[kPenguinPart_Eye] * penguinScale;
	    superFuxkOriY = idle_y[kPenguinPart_Eye] * penguinScale;
	    eye_x = useThisEyeX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    eye_y = useThisEyeY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    superFuxkAngleDiff = -turtleRotation * Math.PI/180;
	    superFuxkOriX = -idle_x[kPenguinPart_Wing] * penguinScale;
	    superFuxkOriY = idle_y[kPenguinPart_Wing] * penguinScale;
	    wing_x = useThisWingX + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff);
	    wing_y = useThisWingY + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff);
	    
	    
	    s_Body.setPosition(CGPoint.ccp(body_x, body_y));
	    s_Eye.setPosition(CGPoint.ccp(eye_x, eye_y));
	    s_Wing.setPosition(CGPoint.ccp(wing_x, wing_y));
	    
	    s_Body.setRotation(idle_r[kPenguinPart_Body] * 180/Math.PI + turtleRotation);
	    s_Eye.setRotation(idle_r[kPenguinPart_Eye] * 180/Math.PI + useThisEyeR);
	    s_Wing.setRotation(idle_r[kPenguinPart_Wing] * 180/Math.PI + useThisWingR);
	    
	}
	
	public void  setMAINX( int _x)
	{
	    x = _x;
	}
	
	public void  setMAINY( int _y)
	{
	    y = _y;
	}
	
	public void  setMAINR( float _r)
	{
	    turtleRotation = _r;
	}
}
