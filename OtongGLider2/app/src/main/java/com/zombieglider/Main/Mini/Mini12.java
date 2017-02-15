package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
//
//  Mini12.m
//  TurtlesHuh
//
//  Created by  on 2012/6/14.
//  Copyright 2012__MyCompanyName__. All rights reserved.
//

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.Turtle;

//ByRCH#import "Mini12.h"
//ByRCH#import "GamePlayGlobal.h"
//ByRCH#import "Global.h"

public class Mini12 extends MiniBasic
{
    Turtle turtle;

	
	public Mini12()
	{
		// always call "super" init
		// Apple recommends to re-assign "this" with the "super" return value
		super();
        
              
        s_bg = CCSprite.sprite("images/Main/mini 01/mini_01_bg.png");
        s_bg.setPosition(CGPoint.ccp(240,160));
        s_bg.setScale( 1.0f/Global.g_Scale );
		this.addChild(s_bg);
        
        // wholeTurtleScaleFromSocurce = 0.25;
		Global.wholeTurtleScaleFromSocurce = 0.8f;
      
        this.initCharacters();
	}
	
	public void  initCharacters()
	{
	    turtle = new Turtle();
	    
	    turtle.setX(240);
	    turtle.setY(80);
	    turtle.setStatus(Turtle.kTurtleAniStatus_Out);
	
	    turtle.setBombOutType(Turtle.kTurtleBombOutType_bombOutOffScreenWithGravity);
	    turtle.setDelegate(this);
	    turtle.setIdNumber(0);
	
	}
	
	public void  manage( float  dt)
	{
	    turtle.manage(dt);
	    turtle.manageYellowHurt();
	    this.runTurtleAI();
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
			CGPoint location = CGPoint.ccp(event.getX(i),event.getY(i));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        this.fuckTurtle();
	    }
		return true;
	}
	
	public void  fuckTurtle()
	{
	    turtle.setYellowHurt();
	    Global.playLayer.setToShakingBomb(turtle.x(),turtle.y());
	    
	    if( (Math.random()*65535) % 8 == 0){
	        Global.musicController.playThisSound(Global.kSound_CrackShell,false,1.0);
	    }else{
	        Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,0.5);
	    }
	    
	}
	
	public void  runTurtleAI()
	{
	    if(turtle.status() == Turtle.kTurtleAniStatus_Normal_Out){
	        if((Math.random()*65535) % 50 == 0){
	            if((Math.random()*65535) % 10 == 0){
	                
	            }else{
	                turtle.setStatus(Turtle.kTurtleAniStatus_Idle);
	            }
	        }
	    }
	    
	}
}
