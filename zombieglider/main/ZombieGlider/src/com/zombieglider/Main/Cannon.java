package com.zombieglider.Main;

import com.badlogic.gdx.physics.box2d.Body;
import com.zombieglider.Global;
import com.zombieglider.Main.Mini.MiniBasic;

import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
//
//  Cannon.m
//  TurtlesHuh
//
//  Created by  on 2012/5/23.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//

//ByRCH#import "Cannon.h"
//ByRCH#import "GamePlayGlobal.h"
//ByRCH#import "animationDefs.h"
//ByRCH#import "Global.h"
//ByRCH#import "MainGamePlayGlobal.h"

public class Cannon extends CCNode
{
	//typedef enum{
	public static final int kCannonStatus_Idle = 0;
	public static final int kCannonStatus_Shooting = 1;
	//}eCannonStatus;

	//typedef enum{
	public static final int kCannonPart_Back = 0;
	public static final int kCannonPart_Body = 1;
	public static final int kCannonPart_Front = 2;
	public static final int kCannonPart_Wood = 3;
	//}eCannonPart;

	
    CCSprite s_Cannon_Back;
    CCSprite s_Cannon_Body;
    CCSprite s_Cannon_Front;
    CCSprite s_Cannon_Wood;
    
    float cannon_Back_x;
    float cannon_Body_x;
    float cannon_Front_x;
    float cannon_Wood_x;
    float cannon_Back_y;
    float cannon_Body_y;
    float cannon_Front_y;
    float cannon_Wood_y;
    
    float cannon_X;
    float cannon_Y;
    
    int cannon_aniTime;
    boolean cannon_isAni;
    int cannon_status;
    
    MiniBasic delegate;
    
    
    float oriRadius_Body[] = new float[10];
    float oriRadius_Back[] = new float[10];
    float oriRadius_Front[] = new float[10];
    //float oriRadius_Wood;
    
    float oriAngle_Body;
    float oriAngle_Back;
    float oriAngle_Front;
    //float oriAngle_Wood;
    
    float rotateDegreeAngle;
    
    int idNumber;
    
    boolean MAIN_SHOOT;
    boolean MAIN_SHOOTSHOOT;
    int MAIN_TIMER;
    int MAIN_STARTSHOOTTIMER;
    float MAIN_PRESHOOTSPEED;

    float superFuxkAngleDiff;
    float superFuxkOriX;
    float superFuxkOriY;
    float superFuxkOffsetX;
    float superFuxkOffsetY;
    
    float cannon_Front_Begin_x = 181.5f;
    float cannon_Body_Begin_x = 74;
    float cannon_Back_Begin_x = -43.75f;
    
    float cannon_Front_Final_x = 114.4f;
    float cannon_Body_Final_x = 37.8f;
    float cannon_Back_Final_x = -53.75f;
    
    float cannon_Front_Final_sx = 1.0f;
    float cannon_Body_Final_sx = 0.651f;
    float cannon_Back_Final_sx = 1.541f;
    
    float cannon_Front_Final_sy = 1.162f;
    float cannon_Body_Final_sy = 1.176f;
    float cannon_Back_Final_sy = 1.955f;
    
    float cannon_MAIN_Front_aniX;
    float cannon_MAIN_Body_aniX;
    float cannon_MAIN_Back_aniX;
    float cannon_MAIN_Front_aniSX;
    float cannon_MAIN_Body_aniSX;
    float cannon_MAIN_Back_aniSX;
    float cannon_MAIN_Front_aniSY;
    float cannon_MAIN_Body_aniSY;
    float cannon_MAIN_Back_aniSY;
    
	public void  setIdNumber( int _idNumber)
	{
	    idNumber = _idNumber;
	}
	
	public void  setDelegate( MiniBasic _delegate)
	{
	    delegate = _delegate;
	}
	
	public void  setX( float _x)
	{
	    cannon_X = _x;
	    
	    if(!Global.isPlayingMiniGame){
	        return;
	    }
	    
	    
	    superFuxkOffsetX = (float) (-58 * Math.cos(rotateDegreeAngle * Math.PI/180 + Math.PI/2));
	    superFuxkOffsetY = (float) (58 * Math.sin(rotateDegreeAngle * Math.PI/180 + Math.PI/2) - 58);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Back_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Back_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Body_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Body_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Front_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Front_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Wood_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Wood_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	}
	
	public void  setY( float _y)
	{
	    cannon_Y = _y;
	    
	    if(!Global.isPlayingMiniGame){
	        return;
	    }
	    
	    superFuxkOffsetX = (float) (-58 * Math.cos(rotateDegreeAngle * Math.PI/180 + Math.PI/2));
	    superFuxkOffsetY = (float) (58 * Math.sin(rotateDegreeAngle * Math.PI/180 + Math.PI/2) - 58);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Back_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Back_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Body_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Body_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Front_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Front_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + cannon_aniTime].x * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + cannon_aniTime].y * Global.wholeCannonScaleFromSocurce;
	    cannon_Wood_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	    cannon_Wood_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	}
	
	public float  x()
	{
	    return cannon_X;
	}
	
	public float  y()
	{
	    return cannon_Y;
	}
	
	public float  cannonFrontX()
	{
	    return s_Cannon_Front.getPosition().x;
	}
	
	public float  cannonFrontY()
	{
	    return s_Cannon_Front.getPosition().y;
	}
	
	public void  setRotateDegree( float _angle)
	{
	    rotateDegreeAngle = _angle;
	
	    if(cannon_status == kCannonStatus_Idle){
	        this.setCannonStatus(kCannonStatus_Idle);
	    }
	}
	
	public void  setReverse()
	{
	    s_Cannon_Back.setScaleX(1.0f/Global.g_Scale*-1);
	    s_Cannon_Body.setScaleX(1.0f/Global.g_Scale*-1);
	    s_Cannon_Front.setScaleX(1.0f/Global.g_Scale*-1);
	    s_Cannon_Wood.setScaleX(1.0f/Global.g_Scale*-1);
	}
	
	public void  initOriValues()
	{
	    rotateDegreeAngle = 0;	 
	}
	
	public void  MAIN_SETSHOOT()
	{
	    MAIN_SHOOT = true;
	}
	
	public Cannon()
	{
		// always call "super" init
		// Apple recommends to re-assign "this" with the "super" return value
		super();
	    
        delegate = null;
        MAIN_SHOOT = false;
        MAIN_SHOOTSHOOT = false;
        MAIN_TIMER = 0;
        
        this.initOriValues();
        
        cannon_status = kCannonStatus_Idle;
        
        if(Global.isPlayingMiniGame){
            s_Cannon_Back = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(106/2*Global.g_Scale,610/2*Global.g_Scale,42/2*Global.g_Scale,42/2*Global.g_Scale));
            s_Cannon_Body = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1430/2*Global.g_Scale,370/2*Global.g_Scale,212/2*Global.g_Scale,112/2*Global.g_Scale));
            s_Cannon_Front = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1648/2*Global.g_Scale,370/2*Global.g_Scale,30/2*Global.g_Scale,110/2*Global.g_Scale));
            s_Cannon_Wood = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1430/2*Global.g_Scale,486/2*Global.g_Scale,114/2*Global.g_Scale,118/2*Global.g_Scale));
        }else{
            
            /*s_Cannon_Back = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1926/2,828/2,42/2,42/2));
            s_Cannon_Body = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1330/2,0/2,212/2,112/2));
            s_Cannon_Front = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1548/2,0/2,30/2,110/2));
            s_Cannon_Wood = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1582/2,0/2,114/2,118/2));*/
            
            s_Cannon_Back = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1646/2*Global.g_Scale,464/2*Global.g_Scale,42/2*Global.g_Scale,40/2*Global.g_Scale));
            s_Cannon_Body = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1328/2*Global.g_Scale,0/2*Global.g_Scale,214/2*Global.g_Scale,118/2*Global.g_Scale));
            s_Cannon_Front = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1546/2*Global.g_Scale,0/2*Global.g_Scale,54/2*Global.g_Scale,110/2*Global.g_Scale));
            s_Cannon_Wood = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1290/2*Global.g_Scale,1494/2*Global.g_Scale,116/2*Global.g_Scale,118/2*Global.g_Scale));
            
    
            if(Global.playerCannon == 1){
                s_Cannon_Body.setTextureRect(CGRect.make(1328/2*Global.g_Scale,0/2*Global.g_Scale,214/2*Global.g_Scale,118/2*Global.g_Scale));
                s_Cannon_Front.setTextureRect(CGRect.make(1546/2*Global.g_Scale,0/2*Global.g_Scale,54/2*Global.g_Scale,110/2*Global.g_Scale));
                s_Cannon_Wood.setTextureRect(CGRect.make(1290/2*Global.g_Scale,1494/2*Global.g_Scale,116/2*Global.g_Scale,118/2*Global.g_Scale));
            }
            if(Global.playerCannon == 2){
                s_Cannon_Body.setTextureRect(CGRect.make(1328/2*Global.g_Scale,0/2*Global.g_Scale,214/2*Global.g_Scale,118/2*Global.g_Scale));
                s_Cannon_Front.setTextureRect(CGRect.make(1688/2*Global.g_Scale,1118/2*Global.g_Scale,54/2*Global.g_Scale,110/2*Global.g_Scale));
                s_Cannon_Wood.setTextureRect(CGRect.make(992/2*Global.g_Scale,1366/2*Global.g_Scale,116/2*Global.g_Scale,118/2*Global.g_Scale));
            }
            if(Global.playerCannon == 3){
                s_Cannon_Body.setTextureRect(CGRect.make(1114/2*Global.g_Scale,1366/2*Global.g_Scale,212/2*Global.g_Scale,116/2*Global.g_Scale));
                s_Cannon_Front.setTextureRect(CGRect.make(1330/2*Global.g_Scale,1366/2*Global.g_Scale,54/2*Global.g_Scale,110/2*Global.g_Scale));
                s_Cannon_Wood.setTextureRect(CGRect.make(992/2*Global.g_Scale,1366/2*Global.g_Scale,116/2*Global.g_Scale,118/2*Global.g_Scale));
            }
            if(Global.playerCannon == 4){
                s_Cannon_Body.setTextureRect(CGRect.make(1392/2*Global.g_Scale,1366/2*Global.g_Scale,212/2*Global.g_Scale,116/2*Global.g_Scale));
                s_Cannon_Front.setTextureRect(CGRect.make(1630/2*Global.g_Scale,1072/2*Global.g_Scale,54/2*Global.g_Scale,110/2*Global.g_Scale));
                s_Cannon_Wood.setTextureRect(CGRect.make(1572/2*Global.g_Scale,950/2*Global.g_Scale,116/2*Global.g_Scale,118/2*Global.g_Scale));
            }
            if(Global.playerCannon == 5){
                s_Cannon_Body.setTextureRect(CGRect.make(1392/2*Global.g_Scale,1244/2*Global.g_Scale,212/2*Global.g_Scale,118/2*Global.g_Scale));
                s_Cannon_Front.setTextureRect(CGRect.make(1572/2*Global.g_Scale,1072/2*Global.g_Scale,54/2*Global.g_Scale,110/2*Global.g_Scale));
                s_Cannon_Wood.setTextureRect(CGRect.make(1272/2*Global.g_Scale,1244/2*Global.g_Scale,116/2*Global.g_Scale,118/2*Global.g_Scale));
            }

            
            s_Cannon_Front.setAnchorPoint(CGPoint.ccp(37.0/54.0,0.5));
            
            if(Global.playerCannon == 0){
                s_Cannon_Body.setTextureRect(CGRect.make(1052/2*Global.g_Scale,1244/2*Global.g_Scale,212/2*Global.g_Scale,112/2*Global.g_Scale));
                s_Cannon_Wood.setTextureRect(CGRect.make(936/2*Global.g_Scale,1244/2*Global.g_Scale,114/2*Global.g_Scale,118/2*Global.g_Scale));
                s_Cannon_Front.setTextureRect(CGRect.make(900/2*Global.g_Scale,1244/2*Global.g_Scale,32/2*Global.g_Scale,110/2*Global.g_Scale));
                s_Cannon_Front.setAnchorPoint(CGPoint.ccp(0.5,0.5));
            }
        }
        
        
        // s_Cannon_Back.setAnchorPoint(CGPoint.ccp());
        
        Global.ss_Character.addChild(s_Cannon_Back,Global.kDeapth_Bg_Element1);
        Global.ss_Character.addChild(s_Cannon_Body,Global.kDeapth_Bg_Element1);
        Global.ss_Character.addChild(s_Cannon_Front,Global.kDeapth_Bg_Element1);
        Global.ss_Character.addChild(s_Cannon_Wood,Global.kDeapth_Bg_Element1);
        
        if(Global.currentChosenMiniGame == 5){
            cannon_X = 80;
            cannon_Y = 7;
        }
        if(Global.currentChosenMiniGame == 3){
            cannon_X = 70000;
            cannon_Y = 7;
        }
	}
	
	
	public void  setCannonStatus( int _cannonStatus)
	{
	    superFuxkOffsetX = (float) (-58 * Math.cos(rotateDegreeAngle * Math.PI/180 + Math.PI/2));
	    superFuxkOffsetY = (float) (58 * Math.sin(rotateDegreeAngle * Math.PI/180 + Math.PI/2) - 58);
	    
	    if(_cannonStatus == kCannonStatus_Idle){
	        superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	        superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + 0].x * Global.wholeCannonScaleFromSocurce;
	        superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + 0].y * Global.wholeCannonScaleFromSocurce;
	        cannon_Back_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	        cannon_Back_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	        
	        superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	        superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + 0].x * Global.wholeCannonScaleFromSocurce;
	        superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + 0].y * Global.wholeCannonScaleFromSocurce;
	        cannon_Body_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	        cannon_Body_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	        
	        superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	        superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + 0].x * Global.wholeCannonScaleFromSocurce;
	        superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + 0].y * Global.wholeCannonScaleFromSocurce;
	        cannon_Front_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	        cannon_Front_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	        
	        superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	        superFuxkOriX = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + 0].x * Global.wholeCannonScaleFromSocurce;
	        superFuxkOriY = Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + 0].y * Global.wholeCannonScaleFromSocurce;
	        cannon_Wood_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	        cannon_Wood_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	        
	        
	        /*s_Cannon_Back.setPosition(CGPoint.ccp(cannon_X + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame].x * Global.wholeCannonScaleFromSocurce,
	                                       cannon_Y + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame].y * Global.wholeCannonScaleFromSocurce));
	        s_Cannon_Body.setPosition(CGPoint.ccp(cannon_X + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame].x * Global.wholeCannonScaleFromSocurce,
	                                       cannon_Y + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame].y * Global.wholeCannonScaleFromSocurce));
	        s_Cannon_Front.setPosition(CGPoint.ccp(cannon_X + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame].x * Global.wholeCannonScaleFromSocurce,
	                                        cannon_Y + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame].y * Global.wholeCannonScaleFromSocurce));
	        s_Cannon_Wood.setPosition(CGPoint.ccp(cannon_X + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame].x * Global.wholeCannonScaleFromSocurce,
	                                       cannon_Y + Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame].y * Global.wholeCannonScaleFromSocurce));*/
	        
	        s_Cannon_Back.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame].rotation * 180/Math.PI + rotateDegreeAngle));
	        s_Cannon_Body.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame].rotation * 180/Math.PI + rotateDegreeAngle));
	        s_Cannon_Front.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame].rotation * 180/Math.PI + rotateDegreeAngle));
	        s_Cannon_Wood.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame].rotation * 180/Math.PI));
	        
	        s_Cannon_Back.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame].scaleX * Global.wholeCannonScaleFromSocurce * 2);
	        s_Cannon_Body.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame].scaleX * Global.wholeCannonScaleFromSocurce * 2);
	        s_Cannon_Front.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame].scaleX * Global.wholeCannonScaleFromSocurce * 2);
	        s_Cannon_Wood.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame].scaleX * Global.wholeCannonScaleFromSocurce * 2);
	        
	        s_Cannon_Back.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame].scaleY * Global.wholeCannonScaleFromSocurce * 2);
	        s_Cannon_Body.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame].scaleY * Global.wholeCannonScaleFromSocurce * 2);
	        s_Cannon_Front.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame].scaleY * Global.wholeCannonScaleFromSocurce * 2);
	        s_Cannon_Wood.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame].scaleY * Global.wholeCannonScaleFromSocurce * 2);
	        
	    }
	    if(_cannonStatus == kCannonStatus_Shooting){
	        cannon_isAni = true;
	        cannon_aniTime = 0;
	    }
	    
	    cannon_status = _cannonStatus;
	}
	
	public void  manage()
	{
	    
	    if(cannon_isAni){
	        cannon_aniTime++;
	        
	        if(cannon_aniTime == 3){
	            if(delegate != null){
	                delegate.cannonShootBall(idNumber);
	                Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,1.0);
	            }
	        }
	
	        
	        s_Cannon_Back.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + cannon_aniTime].rotation * 180/Math.PI + rotateDegreeAngle));
	        s_Cannon_Body.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + cannon_aniTime].rotation * 180/Math.PI + rotateDegreeAngle));
	        s_Cannon_Front.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + cannon_aniTime].rotation * 180/Math.PI + rotateDegreeAngle));
	        s_Cannon_Wood.setRotation((float) (Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + cannon_aniTime].rotation * 180/Math.PI));
	        
	        s_Cannon_Back.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + cannon_aniTime].scaleX);
	        s_Cannon_Body.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + cannon_aniTime].scaleX);
	        s_Cannon_Front.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + cannon_aniTime].scaleX);
	        s_Cannon_Wood.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + cannon_aniTime].scaleX);
	        
	        s_Cannon_Back.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Back].firstFrame + cannon_aniTime].scaleY);
	        s_Cannon_Body.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Body].firstFrame + cannon_aniTime].scaleY);
	        s_Cannon_Front.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Front].firstFrame + cannon_aniTime].scaleY);
	        s_Cannon_Wood.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + cannon_aniTime].scaleY);
	        
	        if(cannon_aniTime == 9){
	            cannon_isAni = false;
	            cannon_aniTime = 0;
	            this.setCannonStatus(kCannonStatus_Idle);
	        }
	        
	    }
	    
	    if(Global.currentChosenMiniGame == 7){
	        cannon_Wood_x = 99999;
	        cannon_Back_x = 99999;
	    }
	    
	    s_Cannon_Body.setPosition(CGPoint.ccp(cannon_Body_x,cannon_Body_y));
	    s_Cannon_Front.setPosition(CGPoint.ccp(cannon_Front_x,cannon_Front_y));
	    s_Cannon_Wood.setPosition(CGPoint.ccp(cannon_Wood_x,cannon_Wood_y));
	    s_Cannon_Back.setPosition(CGPoint.ccp(cannon_Back_x,cannon_Back_y));
	    
	    
	    if(Global.currentChosenMiniGame == 102){
	        if(Global.isPlayingMiniGame){
	             s_Cannon_Wood.setPosition(CGPoint.ccp(cannon_Wood_x-3,cannon_Wood_y));
	        }
	    }
	}
	
	public void  setMAINSTARTSHOOTTIMER( int _startTimer)
	{
	    MAIN_STARTSHOOTTIMER = _startTimer;
	}
	
	public void  setMAINPRESHOOTSPEED( float _speed)
	{
	    MAIN_PRESHOOTSPEED = _speed;
	}
	
	public void  manageMAIN()
	{
	    
	    
	    
	    // static float superFuxkOffsetX;
	   // static float superFuxkOffsetY;
	    
	    if(MAIN_TIMER == 0){
	        cannon_MAIN_Front_aniX = cannon_Front_Begin_x;
	        cannon_MAIN_Body_aniX = cannon_Body_Begin_x;
	        cannon_MAIN_Back_aniX = cannon_Back_Begin_x;
	        
	        cannon_MAIN_Front_aniSX = 1.0f;
	        cannon_MAIN_Body_aniSX = 1.0f;
	        cannon_MAIN_Back_aniSX = 1.0f;
	        cannon_MAIN_Front_aniSY = 1.0f;
	        cannon_MAIN_Body_aniSY = 1.0f;
	        cannon_MAIN_Back_aniSY = 1.0f;
	        
	    }
	    
	    if(MAIN_SHOOT){
	        
	        if(!MAIN_SHOOTSHOOT){
	            
	            cannon_MAIN_Front_aniX += (cannon_Front_Final_x - cannon_MAIN_Front_aniX)/MAIN_PRESHOOTSPEED;
	            cannon_MAIN_Body_aniX += (cannon_Body_Final_x - cannon_MAIN_Body_aniX)/MAIN_PRESHOOTSPEED;
	            cannon_MAIN_Back_aniX += (cannon_Back_Final_x - cannon_MAIN_Back_aniX)/MAIN_PRESHOOTSPEED;
	            
	            cannon_MAIN_Front_aniSX += (cannon_Front_Final_sx - cannon_MAIN_Front_aniSX)/MAIN_PRESHOOTSPEED;
	            cannon_MAIN_Body_aniSX += (cannon_Body_Final_sx - cannon_MAIN_Body_aniSX)/MAIN_PRESHOOTSPEED;
	            cannon_MAIN_Back_aniSX += (cannon_Back_Final_sx - cannon_MAIN_Back_aniSX)/MAIN_PRESHOOTSPEED;
	            
	            cannon_MAIN_Front_aniSY += (cannon_Front_Final_sy - cannon_MAIN_Front_aniSY)/MAIN_PRESHOOTSPEED;
	            cannon_MAIN_Body_aniSY += (cannon_Body_Final_sy - cannon_MAIN_Body_aniSY)/MAIN_PRESHOOTSPEED;
	            cannon_MAIN_Back_aniSY += (cannon_Back_Final_sy - cannon_MAIN_Back_aniSY)/MAIN_PRESHOOTSPEED;
	            
	                        
	        }else{
	        
	            if(MAIN_TIMER == MAIN_STARTSHOOTTIMER+1){
	                cannon_MAIN_Front_aniSX = 368.6f - 212.5f;
	                cannon_MAIN_Body_aniX = 272.2f - 212.5f;
	                cannon_MAIN_Back_aniX = 163.4f - 212.5f;
	                
	                cannon_MAIN_Front_aniSX = 1.0f;
	                cannon_MAIN_Front_aniSY = 0.995f;
	                cannon_MAIN_Body_aniSX = 0.962f;
	                cannon_MAIN_Body_aniSY = 1.029f;
	                cannon_MAIN_Back_aniSX = 1.261f;
	                cannon_MAIN_Back_aniSY = 1.524f;
	            }
	            if(MAIN_TIMER == MAIN_STARTSHOOTTIMER+2){
	                cannon_MAIN_Front_aniSX = 410.05f - 212.5f;
	                cannon_MAIN_Body_aniX = 294.0f - 212.5f;
	                cannon_MAIN_Back_aniX = 168.05f - 212.5f;
	                
	                cannon_MAIN_Front_aniSX = 1.0f;
	                cannon_MAIN_Front_aniSY = 0.829f;
	                cannon_MAIN_Body_aniSX = 1.073f;
	                cannon_MAIN_Body_aniSY = 0.882f;
	                cannon_MAIN_Back_aniSX = 0.983f;
	                cannon_MAIN_Back_aniSY = 1.096f;
	            }
	            if(MAIN_TIMER == MAIN_STARTSHOOTTIMER+3){
	                cannon_MAIN_Front_aniSX = 441.1f - 212.5f;
	                cannon_MAIN_Body_aniX = 310.35f - 212.5f;
	                cannon_MAIN_Back_aniX = 171.5f - 212.5f;
	                
	                cannon_MAIN_Front_aniSX = 1.0f;
	                cannon_MAIN_Front_aniSY = 0.704f;
	                cannon_MAIN_Body_aniSX = 1.23f;
	                cannon_MAIN_Body_aniSY = 0.772f;
	                cannon_MAIN_Back_aniSX = 0.775f;
	                cannon_MAIN_Back_aniSY = 0.775f;
	            }
	            if(MAIN_TIMER == MAIN_STARTSHOOTTIMER+4){
	                cannon_MAIN_Front_aniSX = 423.3f - 212.5f;
	                cannon_MAIN_Body_aniX = 301.35f - 212.5f;
	                cannon_MAIN_Back_aniX = 170.45f - 212.5f;
	                
	                cannon_MAIN_Front_aniSX = 1.0f;
	                cannon_MAIN_Front_aniSY = 0.816f;
	                cannon_MAIN_Body_aniSX = 1.143f;
	                cannon_MAIN_Body_aniSY = 0.858f;
	                cannon_MAIN_Back_aniSX = 0.86f;
	                cannon_MAIN_Back_aniSY = 0.86f;
	            }
	            if(MAIN_TIMER == MAIN_STARTSHOOTTIMER+5){
	                cannon_MAIN_Front_aniSX = 405.6f - 212.5f;
	                cannon_MAIN_Body_aniX = 292.35f - 212.5f;
	                cannon_MAIN_Back_aniX = 169.45f - 212.5f;
	                
	                cannon_MAIN_Front_aniSX = 1.0f;
	                cannon_MAIN_Front_aniSY = 0.927f;
	                cannon_MAIN_Body_aniSX = 1.057f;
	                cannon_MAIN_Body_aniSY = 0.944f;
	                cannon_MAIN_Back_aniSX = 0.944f;
	                cannon_MAIN_Back_aniSY = 0.944f;
	            }
	            
	            if(MAIN_TIMER == MAIN_STARTSHOOTTIMER+6){
	                cannon_MAIN_Front_aniX = cannon_Front_Begin_x;
	                cannon_MAIN_Body_aniX = cannon_Body_Begin_x;
	                cannon_MAIN_Back_aniX = cannon_Back_Begin_x;
	                
	                cannon_MAIN_Front_aniSX = 1.0f;
	                cannon_MAIN_Body_aniSX = 1.0f;
	                cannon_MAIN_Back_aniSX = 1.0f;
	                cannon_MAIN_Front_aniSY = 1.0f;
	                cannon_MAIN_Body_aniSY = 1.0f;
	                cannon_MAIN_Back_aniSY = 1.0f;
	                
	                MAIN_SHOOT = false;
	
	            }
	        }
	        
	        if(MAIN_TIMER == MAIN_STARTSHOOTTIMER){
	            MAIN_SHOOTSHOOT = true;
	            
	            if(delegate != null){
	                delegate.cannonShootBall(idNumber);
	                Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,1.0);
	            }
	        }
	        
	        
	        MAIN_TIMER++;
	    }
	    
	    
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = cannon_MAIN_Back_aniX * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = (float) (17.85 * Global.wholeCannonScaleFromSocurce);
	    cannon_Back_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff));
	    cannon_Back_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff));
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = cannon_MAIN_Body_aniX * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = (float) (17.85 * Global.wholeCannonScaleFromSocurce);
	    cannon_Body_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff));
	    cannon_Body_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff));
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = cannon_MAIN_Front_aniX * Global.wholeCannonScaleFromSocurce;
	    superFuxkOriY = (float) (17.85 * Global.wholeCannonScaleFromSocurce);
	    cannon_Front_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff));
	    cannon_Front_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff));
	    
	    superFuxkAngleDiff = (float) (-rotateDegreeAngle * Math.PI/180);
	    superFuxkOriX = (float) (24.6 * Global.wholeCannonScaleFromSocurce);
	    superFuxkOriY = 0;
	    cannon_Wood_x = (float) (cannon_X + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff));
	    cannon_Wood_y = (float) (cannon_Y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff));
	    
	    
	    if(MAIN_SHOOT && !MAIN_SHOOTSHOOT){
	        //TEMP//delegate.setScreenOffsetXFromExternal(-9999);
	        //TEMP//delegate.setScreenOffsetYFromExternal(-9999);
	    }
	
	    
	    
	    s_Cannon_Back.setRotation(rotateDegreeAngle);
	    s_Cannon_Body.setRotation(rotateDegreeAngle);
	    s_Cannon_Front.setRotation(rotateDegreeAngle);
	    s_Cannon_Wood.setRotation(0);
	
	    
	    s_Cannon_Body.setPosition(CGPoint.ccp(cannon_Body_x,cannon_Body_y));
	    s_Cannon_Front.setPosition(CGPoint.ccp(cannon_Front_x,cannon_Front_y));
	    s_Cannon_Wood.setPosition(CGPoint.ccp(cannon_Wood_x,cannon_Wood_y));
	    s_Cannon_Back.setPosition(CGPoint.ccp(cannon_Back_x,cannon_Back_y));
	    
	    s_Cannon_Back.setScaleX(1.0f/Global.g_Scale*cannon_MAIN_Back_aniSX);
	    s_Cannon_Body.setScaleX(1.0f/Global.g_Scale*cannon_MAIN_Body_aniSX);
	    s_Cannon_Front.setScaleX(1.0f/Global.g_Scale*cannon_MAIN_Front_aniSX);
	    
	    s_Cannon_Back.setScaleY(1.0f/Global.g_Scale*cannon_MAIN_Back_aniSY);
	    s_Cannon_Body.setScaleY(1.0f/Global.g_Scale*cannon_MAIN_Front_aniSY);
	    s_Cannon_Front.setScaleY(1.0f/Global.g_Scale*cannon_MAIN_Body_aniSY);
	    
	    s_Cannon_Wood.setScaleX(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + 0].scaleX);
	    s_Cannon_Wood.setScaleY(1.0f/Global.g_Scale*Global.frameData[Global.CannonShootAnim.spriteData[kCannonPart_Wood].firstFrame + 0].scaleY);
	    
	}

}
