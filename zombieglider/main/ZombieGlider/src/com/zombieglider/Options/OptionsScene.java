package com.zombieglider.Options;


import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.GameActivity;
//
//  OptionsScene.m
//  TurtlesHuh
//
//  Created by  on 2012/7/31.
//  Copyright 2012__MyCompanyName__. All rights reserved.
//
import com.zombieglider.Global;
import com.zombieglider.Begin.CoverScene;

public class OptionsScene extends CCLayer
{
    CCSprite s_select_music;
    CCSprite s_select_sound;
	
	
	public static CCScene    scene()
	{
		// 'scene' is an autorelease object.
		CCScene  scene = CCScene.node();
		
		// 'layer' is an autorelease object.
		OptionsScene  layer = new OptionsScene();
		
		// add layer as a child to scene
		scene.addChild( layer);
		
		// return the scene
		return scene;
	}
	
	OptionsScene()
	{
		// always call "super" init
		// Apple recommends to re-assign "this" with the "super" return value
		super();
	        
        setIsTouchEnabled(true);
        
        GameActivity appDelegate =GameActivity.app;
        
        CCSprite  s_bg = CCSprite.sprite("images/Cover/cover_bg.png");
        s_bg.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,160));
        s_bg.setScale(1.0f/Global.g_Scale);
        this.addChild(s_bg);
        
        CCSprite  s_onOff2 = CCSprite.sprite("images/Options/options_mainWord.png");
        s_onOff2.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,160));
        s_onOff2.setScale(1.0f/Global.g_Scale);
        this.addChild(s_onOff2);
        
        this.initSelect();
        
        CCSprite  s_onOff = CCSprite.sprite("images/Options/options_onOff.png");
        s_onOff.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,160));
        s_onOff.setScale(1.0f/Global.g_Scale);
        this.addChild(s_onOff);
        
        this.initMenu();
        
        this.changeSelect();
	}
	
	public void  initMenu()
	{
	    CCMenuItem  mBack = CCMenuItemImage.item("images/ScoreShown/ScoreShown_btn_restart_off.png","images/ScoreShown/ScoreShown_btn_restart_on.png",this,"mBackCallback");
	    CCMenuItem  mReset = CCMenuItemImage.item("images/Options/options_btn_reset_off.png","images/Options/options_btn_reset_on.png",this,"mResetCallback");
	
	    mBack.setPosition(CGPoint.ccp(-408/2, 246/2));
	    mBack.setScale(1.0f/Global.g_Scale);
	    mReset.setPosition(CGPoint.ccp(0/2, -110));
	    mReset.setScale(1.0f/Global.g_Scale);
	    
	    if(Global.isIphone5){
	        mBack.setPosition(CGPoint.ccp(mBack.getPosition().x - 44, mBack.getPosition().y));
	    }
	    
		CCMenu  menu = CCMenu.menu(mBack,mReset);
		this.addChild(menu);
	}
	
	public void  mBackCallback(Object sender)
	{
	    Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    
	    CCDirector.sharedDirector().replaceScene( CoverScene.scene());
	}
	
	@SuppressWarnings("deprecation")
	public void  mResetCallback(Object sender)
	{
		GameActivity.app.runOnUiThread(new Runnable() {
			public void run() {
				GameActivity.app.showDialog(1);
			}
		});
	}
	
	
	public void  initSelect()
	{
	    s_select_music = CCSprite.sprite("images/Options/options_select.png");
	    s_select_music.setScale(1.0f/Global.g_Scale);
	    this.addChild(s_select_music);
	    
	    s_select_sound = CCSprite.sprite("images/Options/options_select.png");
	    s_select_sound.setScale(1.0f/Global.g_Scale);
	    this.addChild(s_select_sound);
	}
	
	
	
	public  boolean ccTouchesEnded( MotionEvent event)
	{
	    for( int i = 0; i < event.getPointerCount(); i++ ) {
			CGPoint location = CGPoint.ccp(event.getX(i), event.getY(i));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        if(location.y > 210 && location.y < 270){
	            if(location.x > 125 && location.x < 260){
	                Global.isMusic = true;
	                this.changeSelect();
	            }
	            if(location.x > 260 && location.x < 368){
	            	Global.isMusic = false;
	                this.changeSelect();
	
	            }
	        }
	        
	        
	        if(location.y > 124 && location.y < 178){
	            if(location.x > 125 && location.x < 260){
	            	Global.isSound = true;
	                this.changeSelect();
	            }
	            if(location.x > 260 && location.x < 368){
	            	Global.isSound = false;
	                this.changeSelect();
	                
	            }
	        }	        
	    }
		return true;
	}
	
	public void  changeSelect()
	{
	    if(Global.isMusic){
	        s_select_music.setPosition(CGPoint.ccp(202, 238));
	    }else{
	        s_select_music.setPosition(CGPoint.ccp(317, 238));
	    }
	    
	    if(Global.isSound){
	        s_select_sound.setPosition(CGPoint.ccp(202, 150));
	    }else{
	        s_select_sound.setPosition(CGPoint.ccp(317, 150));
	    }
	    
	    if(Global.isIphone5){
	        s_select_music.setPosition(CGPoint.ccp(s_select_music.getPosition().x + 44, s_select_music.getPosition().y));
	        s_select_sound.setPosition(CGPoint.ccp(s_select_sound.getPosition().x + 44, s_select_sound.getPosition().y));
	    }
	
	    
	    GameActivity.app.getSharedPreferences("aaa",0).edit().putBoolean("isMusic",Global.isMusic);
	    GameActivity.app.getSharedPreferences("aaa",0).edit().putBoolean("isSound",Global.isSound);
	    
	    GameActivity.app.getSharedPreferences("aaa",0).edit().commit();
	    
	    if(Global.isMusic){
	        Global.musicController.initForBegin();
	    }else{
	        Global.musicController.stopBackgroundMusic();
	    }
	}
}
