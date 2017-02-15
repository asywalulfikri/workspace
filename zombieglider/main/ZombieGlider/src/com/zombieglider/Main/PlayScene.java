package com.zombieglider.Main;


import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.types.ccColor4B;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.GameActivity;
import com.zombieglider.Global;
import com.zombieglider.sBombingAniStruct;
//
//  PlayScene.m
//  BombTheTurtle
//
//  Created by  on 2012/4/13.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//
import com.zombieglider.Main.Mini.Mini01;
import com.zombieglider.Main.Mini.Mini02;
import com.zombieglider.Main.Mini.Mini03;
import com.zombieglider.Main.Mini.Mini04;
import com.zombieglider.Main.Mini.Mini05;
import com.zombieglider.Main.Mini.Mini07;
import com.zombieglider.Main.Mini.Mini10;
import com.zombieglider.Main.Mini.MiniBasic;
import com.zombieglider.Main.Mini.Mini11;
import com.zombieglider.Main.Mini.Mini12;
import com.zombieglider.Main.Mini.Mini13;
import com.zombieglider.ScoreShown.ScoreShownScene;
public class PlayScene extends CCLayer
{
    MiniBasic miniGame;
    
    int gameoverTimer;
    float gameover_scale;
    boolean hasGameover;
    
    BombScript bombScript;
    BombScript2 bombScript2;
    
    int gameoverBombTimer;
    
    int readyTimer;
    float readyBlacklayerOpacity;
    CCSprite s_ready;
    float readyX;
    float readyY;
    float readyScale;
    
    
    int palyTimer;
    
    CCSprite finishOne_colorLayer;
    float finishOne_colorLayerOpacity;
    CCSprite s_transition;
    int transitionTimer;
    boolean isTransitioning;
    float transitionOpacity;
    float transitionGain;
    

    int ranGameoverX;
    int ranGameoverY;    
	
	public static CCScene    scene()
	{
		// 'scene' is an autorelease object.
		CCScene  scene = CCScene.node();
		
		// 'layer' is an autorelease object.
		PlayScene  layer = new PlayScene();
	    Global.playLayer = layer;
		
		// add layer as a child to scene
		scene.addChild( layer);
		
		// return the scene
		return scene;
	}
	
	public void  initInstruction()
	{
	    
	}
	
	public void  showInstruction()
	{
	    Global.isShowingInstruction = true;
	    
	    if(Global.currentChosenMiniGame == 1){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini01.png");
	    }
	    if(Global.currentChosenMiniGame == 4){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini02.png");
	    }
	    if(Global.currentChosenMiniGame == 2){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini03.png");
	    }
	    if(Global.currentChosenMiniGame == 3){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini04.png");
	    }
	    if(Global.currentChosenMiniGame == 10){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini05.png");
	    }
	    if(Global.currentChosenMiniGame == 5){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini06.png");
	    }
	    if(Global.currentChosenMiniGame == 11){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini07.png");
	    }
	    if(Global.currentChosenMiniGame == 13){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini08.png");
	    }
	    
	    if(Global.currentChosenMiniGame == 103){
	        Global.s_ingameInstruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini09.png");
	    }
	    
	    Global.s_ingameInstruction.setAnchorPoint(CGPoint.ccp(0.5,1.0));
	    
	    Global.s_ingameInstruction.setPosition(CGPoint.ccp(2400000, 255));
	    Global.s_ingameInstruction.setScale( 1.0f/Global.g_Scale );
	    this.addChild(Global.s_ingameInstruction,Global.kDeapth_Menu);
	
	    
	    Global.s_ingameInstruction.setPosition(CGPoint.ccp(240, 255));
	}
	
	public void  removeInstruction()
	{
	    Global.isShowingInstruction = false;
	    Global.s_ingameInstruction.setPosition(CGPoint.ccp(240000, 255));
	    this.removeChild(Global.s_ingameInstruction,true);
	}
	
	
	// on "init" you need to initialize your instance
	PlayScene()
	{
		super();
	    
        Global.ad_isInGaming = true;
        Global.musicController.initForPlay();
    
        palyTimer = 0;
        
        Global.isPlayingMiniGame = true;
        Global.isStopping = false;
        Global.isShowingMenu = false;
        Global.isShowingInstruction = false;
        hasGameover = false;
        
        Global.turtle_detectHalfLeft = 25+25;
        Global.turtle_detectHalfRight = 25+25;
        Global.turtle_detectHalfUp = 60+20;
        Global.turtle_detectHalfDown = -5+20;
        
        Global.turtleCoinShinning_angleSpeed = 0.65f;
        Global.turtleCoinShinning_angleAcceleration = 0.65f;
        
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
        
        Global.currentTurtleCoin = 0;
        Global.maxTime = 30;
        Global.timeRemain = Global.maxTime;
        
        Global.comoboReduceSpeed = 0.005f;
        Global.comboRemain = 0;
        
        Global.currentCombo = 0;
        Global.maxCombo = 0;
        Global.comboLevel = 0;
        
        Global.currentTurtleOnScreen = 0;
        
        gameoverTimer = 0;
        gameover_scale = 0;
        
        Global.ss_Gameover  = CCSprite.sprite("images/Main/menu/s_menu_gameOver.png");
        this.addChild(Global.ss_Gameover,Global.kDeapth_Menu);
        
        Global.ss_Character  = CCSprite.sprite("images/Main/whole_turtle.png");
        Global.ss_Character.setAnchorPoint(0,0);
        Global.ss_Character.setOpacity(0);
        this.addChild(Global.ss_Character,Global.kDeapth_ssCharacter);
        
        if(Global.currentChosenMiniGame == 4 || Global.currentChosenMiniGame == 10 || Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7 || Global.currentChosenMiniGame == 101 || Global.currentChosenMiniGame == 102){
            Global.ss_Extra  = CCSprite.sprite("images/Main/mini 04/mini_04_extraTexture.png");
            this.addChild(Global.ss_Extra,Global.kDeapth_ssExtra);
        }
        
        if(Global.currentChosenMiniGame == 13){
            Global.ss_Extra  = CCSprite.sprite("images/Main/mini 13/mini_13_extraTexture.png");
            this.addChild(Global.ss_Extra,Global.kDeapth_ssExtra);
        }
        
        this.initBombScripts();
        this.initUI();
        this.initMiniGame();
        this.initBomobingAni();
        
        this.setComboExtraValues();
        
        String ss = android.os.Build.VERSION.RELEASE;
	    if (ss.startsWith("4"))
	    	this.schedule("gameStep",0.025f);
	    else
	    	this.schedule("gameStep");
        
        this.initMenu();
        
        Global.musicController.playThisSound(Global.kSound_TimeRunOutSlow,true,0.0);
        Global.musicController.playThisSound(Global.kSound_TimeRunOutFast,true,0.0);
        
        if(Global.currentChosenMiniGame == 2){
            Global.comboToStart = 3;
        }else{
        	Global.comboToStart = 5;
        }
        
        this.initTransition();
        this.initInstruction();
	}
	
	public void  initTransition()
	{
	    finishOne_colorLayer= CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2));
	    Global.ss_Character.addChild(finishOne_colorLayer,Global.kDeapth_Gameover);
	    finishOne_colorLayer.setPosition(CGPoint.ccp(10000,10000));
	    
	    finishOne_colorLayer.setTextureRect(CGRect.make(728/2, 326/2, 2, 2));
	    finishOne_colorLayer.setScaleX(1.0f/Global.g_Scale*300);
	    finishOne_colorLayer.setScaleY(1.0f/Global.g_Scale*200);
	    finishOne_colorLayer.setColor(ccColor3B.ccc3(0, 0, 0));
	    finishOne_colorLayer.setOpacity(255);
	    finishOne_colorLayerOpacity = 255;
	    finishOne_colorLayer.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2, Global.VIRT_HEIGHT/2));
	    
	    isTransitioning = false;
	    
	}
	
	
	public void  gotoRestart()
	{
	    CCDirector.sharedDirector().replaceScene( NullScene.scene());
	}
	
	public void  initBombScripts()
	{
	    bombScript = new BombScript();
	    bombScript2 = new BombScript2();
	}
	
	public void  initMenu()
	{
	    Global.s_blackTranspancy_bg = CCColorLayer.node(ccColor4B.ccc4(0, 0, 0, 200));
	    this.addChild(Global.s_blackTranspancy_bg,Global.kDeapth_Menu1);
	    Global.s_blackTranspancy_bg.setPosition(CGPoint.ccp(1000,10000));
	    
	    Global.s_menu_instruction = CCSprite.sprite("images/Main/menu/s_menu_instruction_off.png");
	    Global.s_menu_resume = CCSprite.sprite("images/Main/menu/s_menu_resume_off.png");
	    Global.s_menu_restart = CCSprite.sprite("images/Main/menu/s_menu_restart_off.png");
	    Global.s_menu_exit = CCSprite.sprite("images/Main/menu/s_menu_exit_off.png");
	    Global.s_gameover = CCSprite.sprite(Global.ss_Gameover.getTexture(),CGRect.make(0,0,326/2*Global.g_Scale,80/2*Global.g_Scale));
	    
	    Global.s_menu_instruction.setScale( 1.0f/Global.g_Scale );
	    Global.s_menu_resume.setScale( 1.0f/Global.g_Scale );
	    Global.s_menu_restart.setScale( 1.0f/Global.g_Scale );
	    Global.s_menu_exit.setScale( 1.0f/Global.g_Scale );
	    
	    this.addChild(Global.s_menu_instruction,Global.kDeapth_Menu);
	    this.addChild(Global.s_menu_resume,Global.kDeapth_Menu);
	    this.addChild(Global.s_menu_restart,Global.kDeapth_Menu);
	    this.addChild(Global.s_menu_exit,Global.kDeapth_Menu);
	    Global.ss_Gameover.setAnchorPoint(0,0);
	    Global.ss_Gameover.setOpacity(0);
	    Global.ss_Gameover.addChild(Global.s_gameover,Global.kDeapth_Gameover);
	    
	    Global.s_menu_instruction.setPosition(CGPoint.ccp(10000,10000));
	    Global.s_menu_resume.setPosition(CGPoint.ccp(10000,10000));
	    Global.s_menu_restart.setPosition(CGPoint.ccp(10000,10000));
	    Global.s_menu_exit.setPosition(CGPoint.ccp(10000,10000));
	    Global.s_gameover.setPosition(CGPoint.ccp(10000,10000));
	}
	
	public void  initUI()
	{
		Global.uILayer = new UILayer();
	}
	
	public void  initMiniGame()
	{
	    if(Global.currentChosenMiniGame == 1){
	    	miniGame = new Mini01();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 2){
	        miniGame = new Mini02();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 3){
	        miniGame = new Mini03();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 4){
	        miniGame = new Mini04();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 5){
	        miniGame = new Mini05();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 7){
	        miniGame = new Mini07();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 10){
	        miniGame = new Mini10();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 11){
	        miniGame = new Mini11();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 12){
	        miniGame = new Mini12();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	    if(Global.currentChosenMiniGame == 13){
	        miniGame = new Mini13();
	        this.addChild(miniGame,Global.kDeapth_miniBasic);
	    }
	}
	
	public void  gameover()
	{
	    Global.s_blackTranspancy_bg.setPosition(CGPoint.ccp(0,0));
	    
	    gameover_scale += (1 - gameover_scale)/7;
	    
	    
	    if(gameoverTimer < 15){
	        ranGameoverX = (int) (Math.random() * 65535 % 16 - 8);
	        ranGameoverY = (int) (Math.random() * 65535 % 16 - 8);
	    }else if(gameoverTimer < 30){
	        ranGameoverX = (int) (Math.random() * 65535 % 8 - 4);
	        ranGameoverY = (int) (Math.random() * 65535 % 8 - 4);
	    }else if(gameoverTimer < 45){
	        ranGameoverX = (int) (Math.random() * 65535 % 4 - 2);
	        ranGameoverY = (int) (Math.random() * 65535 % 4 - 2);
	    }else{
	        ranGameoverX = 0;
	        ranGameoverY = 0;
	    }
	    
	    Global.s_gameover.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2 + ranGameoverX,Global.VIRT_HEIGHT/2 + ranGameoverY));
	    Global.s_gameover.setScale(gameover_scale/Global.g_Scale);
	    
	    
	    gameoverTimer++;
	    
	    
	    Global.timeRunOut_Fast_Gain -= 0.05;
	
	    if(Global.timeRunOut_Fast_Gain < 0){
	    	Global.timeRunOut_Fast_Gain = 0;
	        Global.musicController.stopThisSound(Global.kSound_TimeRunOutSlow);
	        Global.musicController.stopThisSound(Global.kSound_TimeRunOutFast);
	    }
	    
	    Global.musicController.changeGain(Global.kSound_TimeRunOutFast,Global.timeRunOut_Fast_Gain*Global.timeRunOut_Fast_MaxGain);
	    
	    Global.isTapWronglyAndDisableBtns = true;
	    
	    if(gameoverTimer == 50){
	        this.afterGameOver();
	    }
	}
	
	public void  afterGameOver()
	{
		Global.p4rc_isInMiniGame = true;
		Global.p4rc_canDisplayScore = true;

		CCFadeTransition f = CCFadeTransition.transition( 0.5f,ScoreShownScene.scene(),ccColor3B.ccc3(255,255,255) );
	    CCDirector.sharedDirector().replaceScene( f );
	}
	
	public void  ready()
	{
	    /*if(readyBlacklayerOpacity > 170){
	        readyBlacklayerOpacity-=5;
	    }
	    
	    //if(readyTimer == -
	    readyTimer++;*/
	}
	
	public void  gameStep( float  dt)
	{
	    
	    //ADDED LATER
	    if(Global.currentCombo < Global.comboToStart){
	    	Global.comboRemain = 1;
	    }
	     
	    if(hasGameover){
	        this.gameover();
	        this.manageBombGameoverAni();
	    }else{
	        if(Global.currentChosenMiniGame == 3 || Global.currentChosenMiniGame == 10  || Global.currentChosenMiniGame == 1 || Global.currentChosenMiniGame == 13 || Global.currentChosenMiniGame == 2 || Global.currentChosenMiniGame == 103){
	            this.manageBombGameoverAni();
	        }
	    }
	    
	    if(Global.isStopping){
	        return;
	    }
	    
	    palyTimer++;
	    if(palyTimer < 60){
	        finishOne_colorLayerOpacity -= 10;
	        if(finishOne_colorLayerOpacity < 0){
	            if(finishOne_colorLayerOpacity >= -10){
	                finishOne_colorLayer.setScaleX(1.0f/Global.g_Scale*0);
	                finishOne_colorLayer.setScaleY(1.0f/Global.g_Scale*0);
	            }
	            finishOne_colorLayerOpacity = -99999;
	        }else{
	            finishOne_colorLayer.setOpacity(finishOne_colorLayerOpacity);
	        }
	    }
	    
	    Global.cannotPlayTurtleHeadOutSound = false;
	    
	    if(Global.currentChosenMiniGame != 10){
	    	Global.timeRemain -= dt;
	    }
	    
	    if(Global.timeRemain < 0){
	    	Global.timeRemain = 0;
	    	Global.isStopping = true;
	        //this.gameover();
	        //this.manageBombGameoverAni();
	        
	        if(!hasGameover){
	            hasGameover = true;
	            this.setToBombingGameover();
	            Global.musicController.playThisSound(Global.kSound_GameOver,false,1.0);
	            
	            Global.ad_howmanyGamesPlayed++;
	        }
	    }
	    
	   /* this.manageBombAni();
	    this.manageBombComboAni();
	    this.manageBombShakeAni();
	    this.managePlusTimeAni();
	    this.manageBombCannonAni();*/
	    
	    String ss = android.os.Build.VERSION.RELEASE;
	    if (ss.startsWith("2") && Global.currentChosenMiniGame != 8)
	    {
	    	Global.uILayer.manage(dt);
		    miniGame.manage(dt);
		    
		    bombScript.manage();
		    bombScript2.manage();
	    }
	    
	    Global.uILayer.manage(dt);
	    miniGame.manage(dt);
	    
	    bombScript.manage();
	    bombScript2.manage();	    
	}
	
	public  boolean ccTouchesEnded( MotionEvent event )
	{
		for( int i = 0; i < event.getPointerCount(); i++ ) {
			CGPoint location = CGPoint.ccp(event.getX(i),event.getY(i));
			location = CCDirector.sharedDirector().convertToGL( location);
	
	       /* if(Global.currentChosenMiniGame == 1){
	            if(currentCombo < 10){
	                turtleCoinShinning_angleSpeed += 0.3;
	            }else{
	                turtleCoinShinning_angleSpeed += 0.5;
	            }
	            uILayer.gainCombo(1);
	        }
	        if(Global.currentChosenMiniGame == 4){
	            
	        }*/
	        
	    }
		return true;
	}
	
	
	public void  initBomobingAni()
	{
	    sBombingAniStruct.bombingAniIdx = 0;
	    sBombingAniStruct.bombingAniMax = 10;
	    
	    for(int i = 0 ; i < sBombingAniStruct.bombingAniMax+1 ; i++){
	        sBombingAniStruct.bombingAniStruct[i] = new sBombingAniStruct();
	        
	        sBombingAniStruct.bombingAniStruct[i].aniTimer = 0;
	        sBombingAniStruct.bombingAniStruct[i].isAni = false;
	         sBombingAniStruct.bombingAniStruct[i].isAniCombo = false;
	         sBombingAniStruct.bombingAniStruct[i].isAniShake = false;
	        sBombingAniStruct.bombingAniStruct[i].isAniCannon = false;
	        
	        
	        if(i == sBombingAniStruct.bombingAniMax){
	            float fuckOffsetX;
	            float fuckOffsetY;
	            fuckOffsetX = 504/2*Global.g_Scale;
	            fuckOffsetY = 454/2*Global.g_Scale - 80/2*Global.g_Scale;
	            sBombingAniStruct.bombingAniStruct[i].s_buum = CCSprite.sprite(Global.ss_Gameover.getTexture(),CGRect.make(504/2*Global.g_Scale - fuckOffsetX,454/2*Global.g_Scale - fuckOffsetY,140/2*Global.g_Scale,134/2*Global.g_Scale));
	            sBombingAniStruct.bombingAniStruct[i].s_blick = CCSprite.sprite(Global.ss_Gameover.getTexture(),CGRect.make(504/2*Global.g_Scale - fuckOffsetX,590/2*Global.g_Scale - fuckOffsetY,128/2*Global.g_Scale,128/2*Global.g_Scale));
	            sBombingAniStruct.bombingAniStruct[i].s_wave = CCSprite.sprite(Global.ss_Gameover.getTexture(),CGRect.make(646/2*Global.g_Scale - fuckOffsetX,454/2*Global.g_Scale - fuckOffsetY,106/2*Global.g_Scale,108/2*Global.g_Scale));
	            
	            sBombingAniStruct.bombingAniStruct[i].s_buum.setScale( 1.0f/Global.g_Scale );
	            sBombingAniStruct.bombingAniStruct[i].s_blick.setScale( 1.0f/Global.g_Scale );
	            sBombingAniStruct.bombingAniStruct[i].s_wave.setScale( 1.0f/Global.g_Scale );
	            
	            for(int j = 0 ; j < 3 ; j++){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[j] = CCSprite.sprite(Global.ss_Gameover.getTexture(),CGRect.make(720/2*Global.g_Scale - fuckOffsetX,590/2*Global.g_Scale - fuckOffsetY,22/2*Global.g_Scale,14/2*Global.g_Scale));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[j].setScale( 1.0f/Global.g_Scale );
	            }
	            
	            for(int j = 0 ; j < 8 ; j++){
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j] = CCSprite.sprite(Global.ss_Gameover.getTexture(),CGRect.make(646/2*Global.g_Scale - fuckOffsetX,590/2*Global.g_Scale - fuckOffsetY,72/2*Global.g_Scale,70/2*Global.g_Scale));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j].setScale( 1.0f/Global.g_Scale );
	            }
	            
	            for(int j = 0 ; j < 5 ; j++){
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j] = CCSprite.sprite(Global.ss_Gameover.getTexture(),CGRect.make(720/2*Global.g_Scale - fuckOffsetX,606/2*Global.g_Scale - fuckOffsetY,26/2*Global.g_Scale,28/2*Global.g_Scale));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j].setScale( 1.0f/Global.g_Scale );
	            }
	
	            
	            for(int j = 0 ; j < 5 ; j++){
	                Global.ss_Gameover.addChild(sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j],Global.kDeapth_Turtle_Bombing2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j].setPosition(CGPoint.ccp(10000,10000));
	            }
	            
	            Global.ss_Gameover.addChild(sBombingAniStruct.bombingAniStruct[i].s_wave,Global.kDeapth_Turtle_Bombing2);
	            sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(10000,10000));
	            
	            for(int j = 0 ; j < 8 ; j++){
	                Global.ss_Gameover.addChild(sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j],Global.kDeapth_Turtle_Bombing2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j].setPosition(CGPoint.ccp(10000,10000));
	            }
	            
	            for(int j = 0 ; j < 3 ; j++){
	                Global.ss_Gameover.addChild(sBombingAniStruct.bombingAniStruct[i].s_debris[j],Global.kDeapth_Turtle_Bombing2);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[j].setPosition(CGPoint.ccp(10000,10000));
	            }
	            
	            Global.ss_Gameover.addChild(sBombingAniStruct.bombingAniStruct[i].s_blick,Global.kDeapth_Turtle_Bombing2);
	            Global.ss_Gameover.addChild(sBombingAniStruct.bombingAniStruct[i].s_buum,Global.kDeapth_Turtle_Bombing2);
	        }else{
	            int bombDepth;
	            if(Global.currentChosenMiniGame == 11){
	                bombDepth = Global.kDeapth_Penguin_Bombing;
	            }else{
	                bombDepth = Global.kDeapth_Turtle_Bombing;
	            }
	            
	            
	            sBombingAniStruct.bombingAniStruct[i].s_buum = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(504/2*Global.g_Scale,454/2*Global.g_Scale,140/2*Global.g_Scale,134/2*Global.g_Scale));
	            sBombingAniStruct.bombingAniStruct[i].s_blick = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(504/2*Global.g_Scale,590/2*Global.g_Scale,128/2*Global.g_Scale,128/2*Global.g_Scale));
	            sBombingAniStruct.bombingAniStruct[i].s_wave = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(646/2*Global.g_Scale,454/2*Global.g_Scale,106/2*Global.g_Scale,108/2*Global.g_Scale));
	            
	            sBombingAniStruct.bombingAniStruct[i].s_buum.setScale( 1.0f/Global.g_Scale );
	            sBombingAniStruct.bombingAniStruct[i].s_blick.setScale( 1.0f/Global.g_Scale );
	            sBombingAniStruct.bombingAniStruct[i].s_wave.setScale( 1.0f/Global.g_Scale );
	            
	            for(int j = 0 ; j < 3 ; j++){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[j] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(720/2*Global.g_Scale,590/2*Global.g_Scale,22/2*Global.g_Scale,14/2*Global.g_Scale));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[j].setScale( 1.0f/Global.g_Scale );
	            }
	            
	            for(int j = 0 ; j < 8 ; j++){
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(646/2*Global.g_Scale,590/2*Global.g_Scale,72/2*Global.g_Scale,70/2*Global.g_Scale));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j].setScale( 1.0f/Global.g_Scale );
	            }
	            
	            for(int j = 0 ; j < 5 ; j++){
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(720/2*Global.g_Scale,606/2*Global.g_Scale,26/2*Global.g_Scale,28/2*Global.g_Scale));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j].setScale( 1.0f/Global.g_Scale );
	            }
	
	            
	            for(int j = 0 ; j < 5 ; j++){
	                Global.ss_Character.addChild(sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j],bombDepth);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[j].setPosition(CGPoint.ccp(10000,10000));
	            }
	            
	            Global.ss_Character.addChild(sBombingAniStruct.bombingAniStruct[i].s_wave,Global.kDeapth_Turtle_Bombing);
	            sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(10000,10000));
	            
	            for(int j = 0 ; j < 8 ; j++){
	                Global.ss_Character.addChild(sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j],bombDepth);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[j].setPosition(CGPoint.ccp(10000,10000));
	            }
	            
	            for(int j = 0 ; j < 3 ; j++){
	                Global.ss_Character.addChild(sBombingAniStruct.bombingAniStruct[i].s_debris[j],bombDepth);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[j].setPosition(CGPoint.ccp(10000,10000));
	            }
	            
	            Global.ss_Character.addChild(sBombingAniStruct.bombingAniStruct[i].s_blick,bombDepth);
	            Global.ss_Character.addChild(sBombingAniStruct.bombingAniStruct[i].s_buum,bombDepth);
	        }
	       
	        
	        sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(10000,10000));
	        sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(10000,10000));
	    }
	}
	
	public void  setToShakingBomb( float _turtleX, float _turtleY)
	{
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].isAniShake = true;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniTimer = 0;
	    
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniX = _turtleX - 350;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniY = _turtleY + 269;
	    
	    sBombingAniStruct.bombingAniIdx++;
	    if(sBombingAniStruct.bombingAniIdx == sBombingAniStruct.bombingAniMax){
	        sBombingAniStruct.bombingAniIdx = 0;
	    }
	}
	
	public void  setToBombing( float _turtleX, float _turtleY)
	{
	    
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].isAni = true;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniTimer = 0;
	    
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniX = _turtleX - 350;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniY = _turtleY + 269;
	    
	    sBombingAniStruct.bombingAniIdx++;
	    if(sBombingAniStruct.bombingAniIdx == sBombingAniStruct.bombingAniMax){
	        sBombingAniStruct.bombingAniIdx = 0;
	    }
	}
	
	public void  setComboExtraValues()
	{
	    
	}
	
	public void  setToBombingCannon( float _x, float _y)
	{
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].isAniCannon = true;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniTimer = 0;
	    
	    if(Global.currentChosenMiniGame == 3 || Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
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
	        superFuxkFuxkX = (float) (_x + superFuxkOriX * Math.cos(superFuxkAngleDiff) - superFuxkOriY * Math.sin(superFuxkAngleDiff) - superFuxkOffsetX * Global.wholeCannonScaleFromSocurce);
	        superFuxkFuxkY = (float) (_y + superFuxkOriY * Math.cos(superFuxkAngleDiff) + superFuxkOriX * Math.sin(superFuxkAngleDiff) - superFuxkOffsetY * Global.wholeCannonScaleFromSocurce);
	        
	        sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniX = superFuxkFuxkX - 350;
	        sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniY = superFuxkFuxkY + 269;
	    }else{
	        sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniX = _x - 350 + 70;
	        sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniY = _y + 269 + 75;
	    }
	    
	    
	    sBombingAniStruct.bombingAniIdx++;
	    if(sBombingAniStruct.bombingAniIdx == sBombingAniStruct.bombingAniMax){
	        sBombingAniStruct.bombingAniIdx = 0;
	    }
	    
	    this.setComboExtraValues();
	}
	
	public void  setToBombingTimePlus( float _x, float _y)
	{
	    if(Global.currentChosenMiniGame == 3){
	        return;
	    }
	    
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].isAniPlusTime = true;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniTimer = 0;
	    
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniX = _x - 350;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniY = _y + 269;
	    
	    sBombingAniStruct.bombingAniIdx++;
	    if(sBombingAniStruct.bombingAniIdx == sBombingAniStruct.bombingAniMax){
	        sBombingAniStruct.bombingAniIdx = 0;
	    }
	}
	
	public void setToBombingCombo()
	{
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].isAniCombo = true;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniTimer = 0;
	    
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniX = 374 - 350;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniIdx].aniY = 282 + 269;
	    
	    sBombingAniStruct.bombingAniIdx++;
	    if(sBombingAniStruct.bombingAniIdx == sBombingAniStruct.bombingAniMax){
	        sBombingAniStruct.bombingAniIdx = 0;
	    }
	    
	    this.setComboExtraValues();
	}
	
	public void  setToBombingGameover()
	{
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].isAniGameover = true;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer = 0;
	
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniX = Global.VIRT_WIDTH/2 - 350;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniY = 150 + 269;
	}
	
	
	public void  setToBombingGameoverWithPos( int _x, int _y)
	{
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].isAniGameover = true;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer = 0;
	    
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniX = _x - 350;
	    sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniY = _y + 269;
	}
	
	
	public void  manageBombGameoverAni()
	{
	    gameoverBombTimer++;
	    if(gameoverBombTimer % 2 == 0){
	        return;
	    }
	    
	    float wholeBombOffsetX = 0;
	    float wholeBombOffsetY = 0;
	    
	    float fuckBombGameoverScale = 1.75f;
	    
	    if(hasGameover){
	        fuckBombGameoverScale = 1.75f;
	    }else{
	        //for min igame 03
	        fuckBombGameoverScale = 3.0f;
	        
	        if(Global.currentChosenMiniGame == 2){
	            gameoverBombTimer++;
	        }
	    }
	    
	        
	        if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].isAniGameover){
	            
	            wholeBombOffsetX = sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniX;
	            wholeBombOffsetY = sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniY;
	            
	            sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer++;
	            
	            //Frame 3
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 1){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setPosition(CGPoint.ccp(356.4 + wholeBombOffsetX, -259.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setRotation(25.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setScaleX(1.0f/Global.g_Scale*0.522 * 1.537 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setScaleY(1.0f/Global.g_Scale*0.522 * 1.537 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleX(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleY(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*0.335 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*0.335 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(39.0/100.0 * 255.0);
	            }
	            
	            //Frame 4
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 2){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setPosition(CGPoint.ccp(360.1 + wholeBombOffsetX, -264.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setRotation(51.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setScaleX(1.0f/Global.g_Scale*0.859 * 1.537 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setScaleY(1.0f/Global.g_Scale*0.859 * 1.537 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleX(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleY(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*0.5 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*0.5 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            //Frame 5
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 3){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -266.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setRotation(86.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setScaleX(1.0f/Global.g_Scale*0.534 * 1.537 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setScaleY(1.0f/Global.g_Scale*0.534 * 1.537 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleX(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleY(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*0.554 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*0.554 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(75/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -267.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(139.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.419 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -254.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-124.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(367.8 + wholeBombOffsetX, -254.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 6
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 4){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_buum.setPosition(CGPoint.ccp(353000, 10000));
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleX(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleY(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*0.639 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*0.639 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(71.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(335.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(138.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(338.6 + wholeBombOffsetX, -239.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-123.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(384.5 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(364.1 + wholeBombOffsetX, -265.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(113.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.1113 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.1113 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(364.7 + wholeBombOffsetX, -248.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(51.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.528 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.528 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(346.6 + wholeBombOffsetX, -245.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(51.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.973 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.973 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.4 + wholeBombOffsetX, -272.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(144.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.559 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.559 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(335.6 + wholeBombOffsetX, -249.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.529 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.527 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(-21.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.289 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.289 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(22.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-10.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.1185 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.1185 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(22.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 7
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 5){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleX(1.0f/Global.g_Scale*0.994 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setScaleY(1.0f/Global.g_Scale*0.994 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*0.753 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*0.753 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(324.1 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(137.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(77.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(331.1 + wholeBombOffsetX, -224.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-121.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(402.1 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(367.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(113.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.598 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.598 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(367.6 + wholeBombOffsetX, -247.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(43.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.091 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.091 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(345.4 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(43.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.321 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.321 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(79/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -277.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(151.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.117 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.117 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(330.0 + wholeBombOffsetX, -247.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-9.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.015 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.015 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(-14.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.613 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.613 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-22.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.499 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.499 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(46.0/100.0 * 255.0);
	            }
	            
	            //Frame 8
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 6){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_blick.setPosition(CGPoint.ccp(10000 , 261.5));
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*0.89 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*0.89 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(313.1 + wholeBombOffsetX, -286.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(136.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.405 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(65.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(323.6 + wholeBombOffsetX, -209.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-119.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.925 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(73/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(419.8 + wholeBombOffsetX, -217.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(368.9 + wholeBombOffsetX, -277.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(113.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.856 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.856 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(369.2 + wholeBombOffsetX, -247.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(39.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.392 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.392 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(344.7 + wholeBombOffsetX, -246.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(39.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.508 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.508 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(154.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.414 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.414 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(327.1 + wholeBombOffsetX, -246.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-12.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.273 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.273 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(-8.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.915 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.915 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-33.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.797 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.797 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(69.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(339 + wholeBombOffsetX, -258.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(47.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.801 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.801 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(347.0 + wholeBombOffsetX, -263.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-62.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.606 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.606 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(350.8 + wholeBombOffsetX, -245 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(78.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.956 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.956 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -251.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-130.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.226 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.226 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(358.8 + wholeBombOffsetX, -253.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.223 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.223 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 9
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 7){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*1.045 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*1.015 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(302.4 + wholeBombOffsetX, -293.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(136.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.401 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(316.1 + wholeBombOffsetX, -194.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-118.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.934 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(437 + wholeBombOffsetX, -205.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(57.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(370.6 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(116.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.8 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.8 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(370.3 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(35.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.342 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.342 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(344.+ + wholeBombOffsetX, -244.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(35.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.479 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.479 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -281.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(157.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.365 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.365 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(325.2 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-14.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.227 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.227 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(-3.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.151 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.151 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(88.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-42.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.04 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.04 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(88.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(333.4 + wholeBombOffsetX, -258.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(53.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.722 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.722 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(344.6 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-64.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.57 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.57 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -241.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(83.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.91 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.91 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(337.1 + wholeBombOffsetX, -248.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-130.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.168 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.168 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(362.6 + wholeBombOffsetX, -253.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-4.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.174 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.174 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(96.0/100.0 * 255.0);
	            }
	            
	            //Frame 10
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 8){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*1.213 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*1.213 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(292.1 + wholeBombOffsetX, -299.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(135.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.397 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(42.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(308.8 + wholeBombOffsetX, -179.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-116.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.943 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(55.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(453.8 + wholeBombOffsetX, -193.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(372.6 + wholeBombOffsetX, -283.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(121.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.734 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.734 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -244.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(29.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.26 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.26 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(344.4 + wholeBombOffsetX, -241.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(29.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.431 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.431 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -283.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(163.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.281 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.281 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(321.9 + wholeBombOffsetX, -244.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-19.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.146 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.146 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.309 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.309 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-49.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.208 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.208 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -258.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(60.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.638 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.638 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(341.7 + wholeBombOffsetX, -267.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-67.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.531 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.531 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -237.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(89.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.858 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.858 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(334.1 + wholeBombOffsetX, -245.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-130.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.105 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.105 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(367.1 + wholeBombOffsetX, -253.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-9.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.11 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.11 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(93.0/100.0 * 255.0);
	            }
	            
	            //Frame 11
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 9){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*1.386 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*1.386 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(282.2 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(134.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.393 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(301.6 + wholeBombOffsetX, -164.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-115.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.952 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(46.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(469.9 + wholeBombOffsetX, -181.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(375.0 + wholeBombOffsetX, -286.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(127.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.657 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.657 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(374.9 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(20.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.153 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.153 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(344.1 + wholeBombOffsetX, -236.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(20.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.37 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.37 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -287.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(170.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.173 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.173 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -243.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-24.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.043 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.043 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(1.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.334 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.334 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-50.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.226 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.226 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(319.6 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(68.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.543 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.543 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(338.5 + wholeBombOffsetX, -269.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-70.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.487 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.487 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(351.2 + wholeBombOffsetX, -233.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(95.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.78 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.78 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(330.7 + wholeBombOffsetX, -241.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-130.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.034 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.034 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -252.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-15.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.038 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.038 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(89.0/100.0 * 255.0);
	            }
	            
	            //Frame 12
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 10){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*1.558 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*1.558 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(18.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(273.1 + wholeBombOffsetX, -310.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(133.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.389 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(22.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -150.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-113.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.96 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(485.1 + wholeBombOffsetX, -170.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(377.6 + wholeBombOffsetX, -290.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(134.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.568 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.568 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(378 + wholeBombOffsetX, -240.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(11.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.029 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.029 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(343.8 + wholeBombOffsetX, -232.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(11.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.299 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.299 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -291.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(178.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.048 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.048 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -241.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-31.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.922 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.922 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(3.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.366 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.366 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-53.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.262 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.262 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(311.4 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(76.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.437 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.437 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(334.9 + wholeBombOffsetX, -271.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-74.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.438 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.438 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(351.4 + wholeBombOffsetX, -228.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(102.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.731 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.731 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -236.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-130.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.955 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.955 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(84/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(377.8 + wholeBombOffsetX, -252.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-21.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.959 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.959 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(84.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 13
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 11){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleX(1.0f/Global.g_Scale*1.72 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setScaleY(1.0f/Global.g_Scale*1.72 * 2.099 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(264.8 + wholeBombOffsetX, -315.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(133.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.386 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(288.1 + wholeBombOffsetX, -137.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-112.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.969 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(30.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(499.4 + wholeBombOffsetX, -160.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(380.8 + wholeBombOffsetX, -294.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(141.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.471 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.471 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(381.1 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(0.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.892 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.892 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(343.4 + wholeBombOffsetX, -226.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(0.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.22 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.22 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -296.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-172.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.908 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.908 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(306.9 + wholeBombOffsetX, -239.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-38.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.792 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.792 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(6.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.402 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.402 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-53.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.312 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.312 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(302.6 + wholeBombOffsetX, -257.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(86.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.32 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.32 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(330.9 + wholeBombOffsetX, -274.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-77.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.384 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.384 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -223.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(110.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.658 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.658 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(322.8 + wholeBombOffsetX, -232.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-131.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.868 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.868 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(383.9 + wholeBombOffsetX, -251.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-28.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.872 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.872 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 14
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 12){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_wave.setPosition(CGPoint.ccp(10000 , 265));
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(257.8 + wholeBombOffsetX, -319.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setRotation(132.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.383 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(281.9 + wholeBombOffsetX, -125.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-111.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.976 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(23.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(512.2 + wholeBombOffsetX, -151.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(11.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(394.1 + wholeBombOffsetX, -298.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(149.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.361 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.361 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(385.1 + wholeBombOffsetX, -234.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-11.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.742 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.742 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(343.1 + wholeBombOffsetX, -220.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-11.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.133 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.133 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.3 + wholeBombOffsetX, -301.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-162.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.75 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.75 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(300.9 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-46.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.647 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.647 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(8.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.444 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.444 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-60.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.375 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.375 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(293.1 + wholeBombOffsetX, -257.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(96.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.196 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.196 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(326.6 + wholeBombOffsetX, -276.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-81.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.327 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.327 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -217.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(118.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.58 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.58 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(318.3 + wholeBombOffsetX, -226.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-131.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.775 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.775 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(390.6 + wholeBombOffsetX, -251.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-36.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.778 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.778 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(73.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 15
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 13){
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[0].setPosition(CGPoint.ccp(10000, 319.5));
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -113.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-109.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.984 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(16.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(523.0 + wholeBombOffsetX, -143.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setRotation(-32.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setOpacity(5.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(387.9 + wholeBombOffsetX, -303.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(158.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(389.1 + wholeBombOffsetX, -230.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-23.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.583 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.583 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(342.7 + wholeBombOffsetX, -214.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-23.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.041 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.041 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -306.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-151.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.595 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.595 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -234.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-54.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.496 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.496 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(13.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.492 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.495 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-65.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.453 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.453 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(282.9 + wholeBombOffsetX, -257.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(107.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.06 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.06 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(322.1 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-86.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.265 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.265 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -211.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(127.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.497 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.497 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(313.6 + wholeBombOffsetX, -221.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-131.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.676 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.676 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(397.6 + wholeBombOffsetX, -250.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-44.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.678 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.678 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(-34.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*0.859 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*0.859 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(27.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 16
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 14){
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(270.9 + wholeBombOffsetX, -102.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-108.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.99 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[2].setPosition(CGPoint.ccp(10000 , 143.9));
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(391.6 + wholeBombOffsetX, -309.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(167.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.118 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.118 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(72.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(393.1 + wholeBombOffsetX, -227.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-36.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.416 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.416 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(342.2 + wholeBombOffsetX, -208.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-36.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.946 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.946 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -312.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-140.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.427 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.427 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(287.8 + wholeBombOffsetX, -232.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-63.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.338 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.338 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(15.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.542 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.542 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-71.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.535 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.535 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(86.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(272.1 + wholeBombOffsetX, -257.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(118.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.918 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.918 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -282.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-90.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.20 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.20 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(352.3 + wholeBombOffsetX, -205.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(137.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.409 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.409 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(308.4 + wholeBombOffsetX, -215.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-131.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.571 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.571 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(405.1 + wholeBombOffsetX, -250.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-52.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.574 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.574 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(-20.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.131 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.131 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(56.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 17
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 15){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -93.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setRotation(-107.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.996 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setOpacity(4.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(395.9 + wholeBombOffsetX, -314.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(177.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.983 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.983 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(62.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(397.4 + wholeBombOffsetX, -223.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-50.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(341.9 + wholeBombOffsetX, -201.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-50.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.846 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.846 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.7 + wholeBombOffsetX, -318.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-129.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.253 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.253 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(280.9 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-72.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.174 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.174 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(19.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.596 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.596 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-77.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.627 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.627 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(72.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(260.9 + wholeBombOffsetX, -257.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(130.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.771 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.771 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -285.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-95.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.132 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.132 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(352.6 + wholeBombOffsetX, -199.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(147.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.318 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.318 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(303.2 + wholeBombOffsetX, -209.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-131.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.462 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.462 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(412.8 + wholeBombOffsetX, -249.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-61.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.465 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.465 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(-8.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.37 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.37 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(82.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 18
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 16){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_debris[1].setPosition(CGPoint.ccp(10000, 93.9));
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(400.4 + wholeBombOffsetX, -321.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(171.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.84 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.84 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(51.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(401.8 + wholeBombOffsetX, -219.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-64.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.066 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.066 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(341.3 + wholeBombOffsetX, -194.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-64.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.744 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.744 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -324.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-117.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.074 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.074 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(273.8 + wholeBombOffsetX, -227.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-82.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.005 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.005 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(22.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.654 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.654 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-84.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.722 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.722 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(57.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(249.3 + wholeBombOffsetX, -257.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(142.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.619 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.619 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(307.3 + wholeBombOffsetX, -288.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-100.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.062 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.062 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(352.8 + wholeBombOffsetX, -192.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(157.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.225 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.225 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(297.9 + wholeBombOffsetX, -203.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-132.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.35 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.35 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(420.7 + wholeBombOffsetX, -248.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-71);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.353 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.353 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.544 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.544 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(100.0/100.0 * 255.0);
	                
	            }
	            
	            
	            
	            //Frame 19
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 17){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(404.9 + wholeBombOffsetX, -327.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(160.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.688 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.688 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(406.4 + wholeBombOffsetX, -215.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-78.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.884 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.884 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(340.9 + wholeBombOffsetX, -187.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-78.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.639 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.639 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(351.9 + wholeBombOffsetX, -330.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-104.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.889 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.889 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -224.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-91.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.83 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.83 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(26.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.713 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.713 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-90.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.818 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.818 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(41.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(237.7 + wholeBombOffsetX, -257.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(155.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.466 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.466 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(302.1 + wholeBombOffsetX, -292.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-105.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.99 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.99 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(353.1 + wholeBombOffsetX, -185.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(167.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.13 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.13 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(292.4 + wholeBombOffsetX, -197.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-132.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.236 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.236 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(428.8 + wholeBombOffsetX, -248.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-80.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.239 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.239 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.592 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.592 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(91.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 20
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 18){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(409.9 + wholeBombOffsetX, -334.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(-148.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.529 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.529 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(27.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(411.1 + wholeBombOffsetX, -212.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-93.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.696 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.696 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(340.3 + wholeBombOffsetX, -180.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-93.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.531 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.531 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -336.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-92.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.699 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.699 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(258.8 + wholeBombOffsetX, -222.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-101.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.65 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.65 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(30.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.773 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.773 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(44.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-96.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.909 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.909 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(27.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(225.8 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(167.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.312 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.312 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(296.9 + wholeBombOffsetX, -295.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-110.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.919 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.919 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(353.4 + wholeBombOffsetX, -178.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(178.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.035 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.035 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(286.9 + wholeBombOffsetX, -190.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-132.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.122 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.122 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(436.9 + wholeBombOffsetX, -247.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-89.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.125 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.125 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(18.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.657 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.657 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(79.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 21
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 19){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(415.0 + wholeBombOffsetX, -341.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setRotation(-136.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.364 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.364 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setOpacity(14.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(415.8 + wholeBombOffsetX, -207.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setRotation(-108.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.503 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.503 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -172.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setRotation(-108.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.42 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.42 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -343.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setRotation(-79.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.505 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.505 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(251.0 + wholeBombOffsetX, -219.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setRotation(-111.5);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.466 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.466 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(34.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.532 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.532 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setRotation(-102.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.995 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.995 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setOpacity(13.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(214.0 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(180);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.158 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.158 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(291.6 + wholeBombOffsetX, -298.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-115.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.847 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.847 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -171.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(171.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.939 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.939 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(281.4 + wholeBombOffsetX, -184.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-132.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.007 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.007 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(445.0 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-98.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.01 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.01 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(318);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.734 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.734 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(65.0/100.0 * 255.0);
	                
	            }
	            
	            
	            
	            //Frame 22
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 20){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[0].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[1].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[2].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[3].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[4].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[6].setPosition(CGPoint.ccp(41500.0, -341.1));
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(38.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.889 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.889 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(21.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(202.5 + wholeBombOffsetX, -256.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(167.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.006 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.006 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(286.6 + wholeBombOffsetX, -302.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-119.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.777 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.777 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -164.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(161.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.844 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.844 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -178.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-132.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.895 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.895 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(453.0 + wholeBombOffsetX, -246.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-107.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.897 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.897 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(46.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.822 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.822 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(49.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 23
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 21){
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setRotation(41.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.944 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.944 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setOpacity(10.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(191.2 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(155.7);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.858 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.858 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(281.6 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-124.6);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.709 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.709 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -158.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(151.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.753 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.753 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(270.8 + wholeBombOffsetX, -172.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-133.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.786 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.786 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(460.8 + wholeBombOffsetX, -245.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-116.8);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.787 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.787 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(61.9);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.916 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.916 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(32.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 24
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 22){
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[5].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(180.5 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setRotation(144.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.716 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.716 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(276.8 + wholeBombOffsetX, -308.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setRotation(-129.1);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.644 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.644 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -151.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setRotation(142.4);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.665 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.665 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(265.8 + wholeBombOffsetX, -166.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setRotation(-133.2);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.681 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.681 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(468.2 + wholeBombOffsetX, -244.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setRotation(-125.3);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.682 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.682 * 0.527 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setRotation(77.0);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*2.008 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*2.008 * 0.492 * fuckBombGameoverScale);
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setOpacity(15.0/100.0 * 255.0);
	                
	            }
	            
	            
	            if(sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].aniTimer == 23){
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[0].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[1].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[2].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[3].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_smallClouds[4].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].s_bigClouds[7].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                sBombingAniStruct.bombingAniStruct[sBombingAniStruct.bombingAniMax].isAniGameover = false;
	            }
	            
	        }//end if bombingAniStrut i isAni
	}

}
