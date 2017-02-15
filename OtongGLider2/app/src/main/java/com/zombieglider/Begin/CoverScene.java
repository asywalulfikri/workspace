package com.zombieglider.Begin;


import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;
import org.cocos2d.Cocos2D;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
//
//  CoverScene.m
//  TurtlesHuh
//
//  Created by  on 2012/6/30.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//

import com.zombieglider.GameActivity;
import com.zombieglider.Global;
import com.zombieglider.Options.OptionsScene;
import com.zombieglider.SelectMinigame.SelectMiniGameScene2;

public class CoverScene extends CCLayer
{
    float freeOpacity;
    boolean freeIncreaingO;
    
    int moreGameTimer;
    int beginTimer;


	public static CCScene    scene()
	{
		// 'scene' is an autorelease object.
		CCScene  scene = CCScene.node();
		
		// 'layer' is an autorelease object.
		CoverScene  layer = new CoverScene();
		
		// add layer as a child to scene
		scene.addChild( layer);
		
		// return the scene
		return scene;
	}
	
	CoverScene()
	{
		// always call "super" init
		// Apple recommends to re-assign "this" with the "super" return value
		super();
		    
        moreGameTimer = 0;
        
        CCSprite  s_bg = CCSprite.sprite("images/Cover/cover_bg.png");
        s_bg.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2, Global.VIRT_HEIGHT/2));
        s_bg.setScale(1.0f/Global.g_Scale);
        this.addChild(s_bg);

        Global.musicController.initForPlay();
        Global.musicController.initForBegin();
        beginTimer = 0;
       // this.initMenu();
        
        CCSprite  s_bg2 = CCSprite.sprite("images/Cover/cover_bg2.png");
        s_bg2.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2, Global.VIRT_HEIGHT/2));
        s_bg2.setScale(1.0f/Global.g_Scale);
        this.addChild(s_bg2);
        
        freeIncreaingO = true;
        freeOpacity = 60;
        this.schedule("gameStep");
    
	}
	
	public void  gameStep( float  dt)
	{
	    beginTimer++;
	    if(beginTimer == 2){
	        this.initMenu();
	    }
	    
	    if(freeIncreaingO){
	            freeOpacity+=1.5;
	    }else{
	        freeOpacity -= 1.5;
	    }
	    
	    
	    if(freeOpacity < 60){
	        freeOpacity = 60;
	        freeIncreaingO = true;
	    }
	    
	    if(freeOpacity > 300){
	        freeOpacity =300;
	        freeIncreaingO = false;
	    }
	    
	}
	
	public void  initMenu()
	{
	    CCMenuItem  mMain = CCMenuItemImage.item("images/Cover/cover_btn_play_off.png","images/Cover/cover_btn_play_on.png",this,"mMainCallback");
	    CCMenuItem  mOption = CCMenuItemImage.item("images/Cover/cover_btn_options_off.png","images/Cover/cover_btn_options_on.png",this,"mOptionCallback");

	    mMain.setPosition(CGPoint.ccp(0, -106));
	    mMain.setScale(1.0f/Global.g_Scale);
	    mOption.setPosition(CGPoint.ccp(-180, -107));
	    mOption.setScale(1.0f/Global.g_Scale);
	  	CCMenu  menu = CCMenu.menu(mMain,mOption);
		this.addChild(menu);
	       
	}
	
	public void  gameStepffff( float  dt)
	{
	    moreGameTimer++;
	    if(moreGameTimer == 600){
	        if(Global.ad_isDirectLoaded){
	            Global.ad_isDirectLoaded = false;
	        }
	        
	        moreGameTimer = 0;
	        this.unschedule("gameStepffff");
	    }
	}
	
	public void  mMainCallback(Object sender)
	{
	    Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    
	    CCDirector.sharedDirector().replaceScene( SelectMiniGameScene2.scene());
	    
	    GameActivity.app.showInterstitialAds();
	}
	
	public void  mOptionCallback(Object sender)
	{
		Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
		Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    CCDirector.sharedDirector().replaceScene( OptionsScene.scene());
	}
}
