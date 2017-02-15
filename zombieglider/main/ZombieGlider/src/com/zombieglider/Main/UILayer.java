package com.zombieglider.Main;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
//
//  UILayer.m
//  BombTheTurtle
//
//  Created by  on 2012/4/13.
//  Copyright 2012__MyCompanyName__. All rights reserved.
//

import com.zombieglider.Global;
import com.zombieglider.eTurtleCoinAniStruct;
import com.zombieglider.Main.Mini.MiniBasic;

public class UILayer extends CCNode
{
    CCSprite s_instruction;
    
    eTurtleCoinAniStruct turtleCoinAniStruct;
    
    CCSprite s_comboBar_text;
    CCSprite s_comboBar_combo[] = new CCSprite[4];
    CCSprite s_comboBar_Icon;
    CCSprite s_comboBar_Bar;
    CCSprite s_comboBar_BarLifeLeft;
    CCSprite s_comboBar_BarLife;
    float comboBar_posX;
    float comboBar_posY;
    float comboBar_BarLifeLength;
    float comboRemainPercentage;
    
    CCSprite s_timeBar_text;
    CCSprite s_timeBar_Icon;
    CCSprite s_timeBar_Bar;
    CCSprite s_timeBar_BarLife;
    CCSprite s_timeBar_BarLifeLeft;
    float timeBar_posX;
    float timeBar_posY;
    float timeBar_BarLifeLength;
    float timeRemainPercentage;
    float timeRemainPercentageShow;
    boolean timeBarBlood_isAni;
    int timeBarBlood_aniTimer;
    float timeBarBlood_Opacity;
    boolean timeBarBlood_isDeceasingOpacity;
    float timeBarBlood_iconExtraScale;
    boolean timeBarBlood_isDeceasingIconExtraScale;
    int timeBarBlood_offsetX;
    int timeBarBlood_offsetY;
    int timeBarBlood_offsetRotation;
    
    float timeBarIcon_finalX;
    float timeBarIcon_finalY;
    float timeBarIcon_showX;
    
    CCSprite s_timeBar_BarLeft_Blood;
    CCSprite s_timeBar_BarLife_Blood;
    
    CCSprite s_btn_Stop;
    CCSprite s_turtleCoin;
    CCSprite s_turtleCoinShine;
    
    CCSprite s_turtleCoinText[] = new CCSprite[4];
    float turtlCoinText_textureX;
    float turtlCoinText_textureY;
    float turtlCoinText_width;
    float turtlCoinText_height;
    int turtleCoin_displayCurrent;
    int turtleCoin_displayCurrentTimer;
    boolean turtleCoin_startToDisplay;
    float turtleCoinX;
    float turtleCoinY;
    int turtleCoin_displayToHowmany[] = new int[4];
    
    int comboCoin_displayCurrent;
    int comboCoin_displayCurrentTimer;
     int comboCoin_disappearingTimer;
    boolean comboCoin_startToDisplay;
    boolean comboCoin_startToDisplay_Digit;
    boolean comboCoin_startToDisplay_DigitEach[] = new boolean[4];
    boolean comboCoin_disappearing_Digit;
    int comboCoin_displayToHowmany;
    int comboCoin_displayToHowmany_Digit[] = new int[4];
    float comboX;
    float comboY;
    float comboScaleX;
    float comboScaleY;
    
    int comboCoin_displayCurrentTimer_Digit;
    int comboCoin_displayCurrentTimer_DigitEach[] = new int[4];
    boolean comboCoin_Digit_changingDigit[] = new boolean[4];
    float comboCoin_Digit_offsetX[] = new float[4];
    float comboCoin_Digit_offsetY[] = new float[4];
    float comboCoin_Digit_Opacity[] = new float[4];
    
    boolean turtleCoinShinning_isAni;
    int turtleCoinShinning_aniTimer;
    float turtleCoinShinningAngle;
    float turtleCoinShinningOpacity;
    
    int ranNumber;
    
    
    int comboTextureX[] = new int[11];
    int comboTextureY[] = new int[11];
    int comboDigitTextureX[][] = new int[10][11];
    int comboDigitTextureY[] = new int[11];
    int comboWidth[] = new int[11];
    int comboHeight[] = new int[11];
    int comboDigitWidth[] = new int[11];
    int comboDigitHeight[] = new int[11];
    
    
    
    boolean isChangingComboLevel;
    float chaningComboLevelScale;
    int changingComboLevelTimer;
    float changingComboLevelOffsetX;
    
    CCSprite s_plusTime;
    boolean isAniPlusTime;
    int plusTimeTimer;
    float plusTimeX;
    float plusTimeY;
    float plusTimeSX;
    float plusTimeSY;
    float plusTimeOpacity;
    
    MiniBasic delegate;
    
    int timeBarOffsetX;
    int comboOffsetX;
    
    float prevTimeRemainPercentage;
    boolean isPlayingFastTimeOut;
    
    float finalTimeRemain;
	
	public void  setDelegate( MiniBasic _delegate)
	{
	    delegate = _delegate;
	}
	
	public void  showMenu()
	{
	    Global.isShowingMenu = true;
	    Global.isShowingInstruction = false;
	    Global.s_blackTranspancy_bg.setPosition(CGPoint.ccp(0,0));
	    Global.s_menu_instruction.setPosition(CGPoint.ccp(240,270));
	    Global.s_menu_resume.setPosition(CGPoint.ccp(240,(270-50)/3*2+50));
	    Global.s_menu_restart.setPosition(CGPoint.ccp(240,(270-50)/3+50));
	    Global.s_menu_exit.setPosition(CGPoint.ccp(240,50));
	    
	    if(Global.isIphone5){
	    	Global.s_menu_instruction.setPosition(CGPoint.ccp(240 + 44,270));
	    	Global.s_menu_resume.setPosition(CGPoint.ccp(240 + 44,(270-50)/3*2+50));
	    	Global.s_menu_restart.setPosition(CGPoint.ccp(240 + 44,(270-50)/3+50));
	    	Global.s_menu_exit.setPosition(CGPoint.ccp(240 + 44,50));
	    }
	}
	
	public void  removeMenu()
	{
		Global.isShowingMenu = false;
		Global.isStopping = false;
		Global.s_menu_instruction.setPosition(CGPoint.ccp(10000,10000));
		Global.s_blackTranspancy_bg.setPosition(CGPoint.ccp(10000,10000));
		Global.s_menu_resume.setPosition(CGPoint.ccp(10000,10000));
		Global.s_menu_restart.setPosition(CGPoint.ccp(10000,10000));
		Global.s_menu_exit.setPosition(CGPoint.ccp(10000,10000));
	}
	
	
	public void  restart()
	{
	    comboCoin_startToDisplay = false;
	    comboCoin_startToDisplay_Digit = false;
	    isChangingComboLevel = false;
	    
	    comboCoin_startToDisplay_DigitEach[0] = false;
	    comboCoin_startToDisplay_DigitEach[1] = false;
	    comboCoin_startToDisplay_DigitEach[2] = false;
	    comboCoin_startToDisplay_DigitEach[3] = false;
	    
	    
	    
	    s_comboBar_combo[0].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_combo[1].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_combo[2].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_combo[3].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_text.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_Bar.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_BarLife.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_BarLifeLeft.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_Icon.setPosition(CGPoint.ccp(10000,100000));
	    
	    s_turtleCoinText[0].setPosition(CGPoint.ccp(45000 , 280));
	    s_turtleCoinText[1].setPosition(CGPoint.ccp(45000 , 280));
	    s_turtleCoinText[2].setPosition(CGPoint.ccp(45000 , 280));
	    s_turtleCoinText[3].setPosition(CGPoint.ccp(45000 , 280));
	    
	    this.gainCoin(0);
	
	}
	
	UILayer()
	{
		super();
	
        timeBarOffsetX = 7;
        comboOffsetX = 5;
        
        isChangingComboLevel = false;

        Global.turtleCoinShinning_angleSpeed = 0;
        turtleCoinShinningOpacity = 255;
        turtleCoin_displayCurrent = -1;
        this.initUI();
    }
	
	public void  initTurtleCoinAniStruct()
	{
	    turtleCoinAniStruct = new eTurtleCoinAniStruct();
	    turtleCoinAniStruct.numElements = 10;
	    turtleCoinAniStruct.aniTimer = 0;
	    turtleCoinAniStruct.isAni = false;
	    
	    for(int i = 0 ; i < turtleCoinAniStruct.numElements ; i++){
	        turtleCoinAniStruct.s_graphic[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1934/2*Global.g_Scale, 260/2*Global.g_Scale, 49/2*Global.g_Scale, 48/2*Global.g_Scale));
	        turtleCoinAniStruct.posX[i] = 99999;
	        
	        Global.ss_Character.addChild(turtleCoinAniStruct.s_graphic[i],Global.kDeapth_Top);
	        turtleCoinAniStruct.s_graphic[i].setScale( 1.0f/Global.g_Scale );
	        turtleCoinAniStruct.s_graphic[i].setPosition(CGPoint.ccp(10000,10000));
	    }
	}
	
	public void  initPlusTime()
	{
	    s_plusTime = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1170/2*Global.g_Scale, 370/2*Global.g_Scale, 244/2*Global.g_Scale, 76/2*Global.g_Scale));
	    
	    Global.ss_Character.addChild(s_plusTime,Global.kDeapth_Top);
	    s_plusTime.setScale( 1.0f/Global.g_Scale );
	    s_plusTime.setPosition(CGPoint.ccp(100000,10000));
	    
	    isAniPlusTime = false;
	}
	
	public void  setPlusTimeAni()
	{
	    Global.musicController.playThisSound(Global.kSound_ComboTime,false,0.5);
	    
	    if(Global.currentChosenMiniGame == 10 || Global.currentChosenMiniGame == 3){
	        return;
	    }
	    
	    isAniPlusTime = true;
	    plusTimeTimer = 0;
	}
	
	public void  initUI()
	{
	    this.initTurtleCoin();
	    this.initTimeBar();
	    this.initComboBar();
	    this.initTurtleCoinAniStruct();
	    this.initComboColor();
	    this.initPlusTime();
	    
	    s_btn_Stop = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1270/2*Global.g_Scale, 734/2*Global.g_Scale, 91/2*Global.g_Scale, 88/2*Global.g_Scale));
	    
	    Global.ss_Character.addChild(s_btn_Stop,Global.kDeapth_Top);
	    s_btn_Stop.setScale( 1.0f/Global.g_Scale );
	    s_btn_Stop.setPosition(CGPoint.ccp(Global.VIRT_WIDTH - 35, 284));
	}
	
	public void  initComboColor()
	{
	    
	    changingComboLevelOffsetX = 0;
	    
	    comboTextureX[0] = 1438/2*Global.g_Scale;
	    comboTextureY[0] = 320/2*Global.g_Scale;
	    
	    for(int j = 0 ; j < 10 ; j++){
	        comboDigitTextureX[j][0] = 1540/2*Global.g_Scale + 30/2*Global.g_Scale * j;
	    }
	    comboDigitTextureY[0] = 320/2*Global.g_Scale;
	    
	    
	    for(int i = 1 ; i < 11; i++){
	        comboTextureX[i] = 0;
	        comboTextureY[i] = 560/2*Global.g_Scale + 13*Global.g_Scale * (i-1);
	        
	        comboDigitTextureY[i] = 370/2*Global.g_Scale + 42/2*Global.g_Scale * (i-1);
	        for(int j = 0 ; j < 10 ; j++){
	            comboDigitTextureX[j][i] = 160/2*Global.g_Scale + 34/2*Global.g_Scale * j;
	        }
	        
	    }
	
	    comboWidth[0] = 98/2*Global.g_Scale;
	    comboHeight[0] = 20/2*Global.g_Scale;
	    for(int i = 1 ; i < 11 ; i++){
	        comboWidth[i] = 102/2*Global.g_Scale;
	        comboHeight[i] = 26/2*Global.g_Scale;
	    }
	    
	    comboDigitWidth[0] = 30/2*Global.g_Scale;
	    comboDigitHeight[0] = 36/2*Global.g_Scale;
	    for(int i = 1 ; i < 11 ; i++){
	        comboDigitWidth[i] = 34/2*Global.g_Scale;
	        comboDigitHeight[i] = 42/2*Global.g_Scale;
	    }
	}
	
	public void  initTimeBar()
	{
	    s_timeBar_Icon = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 320/2*Global.g_Scale, 79/2*Global.g_Scale, 62/2*Global.g_Scale));
	    s_timeBar_text = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(720/2*Global.g_Scale, 732/2*Global.g_Scale, 96/2*Global.g_Scale, 30/2*Global.g_Scale));
	    
	    
	    s_timeBar_Bar = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(382/2*Global.g_Scale, 320/2*Global.g_Scale, 400/2*Global.g_Scale, 43/2*Global.g_Scale));
	    s_timeBar_BarLife = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(810/2*Global.g_Scale, 320/2*Global.g_Scale, 357/2*Global.g_Scale, 43/2*Global.g_Scale));
	    s_timeBar_BarLifeLeft = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(784/2*Global.g_Scale, 320/2*Global.g_Scale, 23/2*Global.g_Scale, 43/2*Global.g_Scale));
	    
	    s_timeBar_BarLeft_Blood = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1842/2*Global.g_Scale, 320/2*Global.g_Scale, 18/2*Global.g_Scale, 43/2*Global.g_Scale));
	    s_timeBar_BarLife_Blood = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1862/2*Global.g_Scale, 320/2*Global.g_Scale, 106/2*Global.g_Scale, 43/2*Global.g_Scale));
	    
	    
	    Global.ss_Character.addChild(s_timeBar_Bar,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_timeBar_BarLife,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_timeBar_BarLifeLeft,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_timeBar_BarLeft_Blood,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_timeBar_BarLife_Blood,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_timeBar_text,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_timeBar_Icon,Global.kDeapth_Top);
	    
	    s_timeBar_Bar.setScale( 1.0f/Global.g_Scale );
	    s_timeBar_BarLife.setScale( 1.0f/Global.g_Scale );
	    s_timeBar_BarLifeLeft.setScale( 1.0f/Global.g_Scale );
	    s_timeBar_BarLeft_Blood.setScale( 1.0f/Global.g_Scale );
	    s_timeBar_BarLife_Blood.setScale( 1.0f/Global.g_Scale );
	    s_timeBar_text.setScale( 1.0f/Global.g_Scale );
	    s_timeBar_Icon.setScale( 1.0f/Global.g_Scale );
	    
	
	    s_timeBar_BarLife.setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_timeBar_BarLifeLeft.setAnchorPoint(CGPoint.ccp(1,0.5));
	    s_timeBar_Bar.setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_timeBar_BarLeft_Blood.setAnchorPoint(CGPoint.ccp(1,0.5));
	    s_timeBar_BarLife_Blood.setAnchorPoint(CGPoint.ccp(0,0.5));
	   
	    timeBar_posX = 134 + timeBarOffsetX;
	    timeBar_posY = 290;
	
	    s_timeBar_Bar.setPosition(CGPoint.ccp(timeBar_posX-11 , timeBar_posY));
	    s_timeBar_BarLifeLeft.setPosition(CGPoint.ccp(timeBar_posX , timeBar_posY));
	    s_timeBar_BarLife.setPosition(CGPoint.ccp(timeBar_posX , timeBar_posY));
	    
	    s_timeBar_BarLeft_Blood.setPosition(CGPoint.ccp(10000 , timeBar_posY));
	    s_timeBar_BarLife_Blood.setPosition(CGPoint.ccp(10000 , timeBar_posY));
	    
	    timeBar_BarLifeLength = 357/2;
	    timeRemainPercentage = 1;
	    timeRemainPercentageShow = timeRemainPercentage;
	    timeBarIcon_finalX = timeBar_posX + timeBar_BarLifeLength * timeRemainPercentage;
	    timeBarIcon_showX = timeBarIcon_finalX;
	    
	    s_timeBar_BarLife.setScaleX(timeRemainPercentage);
	    
	    s_timeBar_text.setPosition(CGPoint.ccp(timeBar_posX - 38 , timeBar_posY));
	    s_timeBar_Icon.setPosition(CGPoint.ccp(timeBar_posX + timeBar_BarLifeLength * timeRemainPercentage , timeBar_posY));
	    
	    if(Global.currentChosenMiniGame == 10 || Global.currentChosenMiniGame == 3){
	        s_timeBar_text.setPosition(CGPoint.ccp(10000,10000));
	    }
	    
	}
	
	public void  initComboBar()
	{
	    s_comboBar_text = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1438/2*Global.g_Scale, 320/2*Global.g_Scale, 98/2*Global.g_Scale, 20/2*Global.g_Scale));
	    s_comboBar_Icon = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(2000/2*Global.g_Scale, 260/2*Global.g_Scale, 32/2*Global.g_Scale, 30/2*Global.g_Scale));
	    s_comboBar_Bar = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1298/2*Global.g_Scale, 320/2*Global.g_Scale, 136/2*Global.g_Scale, 22/2*Global.g_Scale));
	    s_comboBar_BarLife = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1186/2*Global.g_Scale, 320/2*Global.g_Scale, 109/2*Global.g_Scale, 22/2*Global.g_Scale));
	    s_comboBar_BarLifeLeft = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1170/2*Global.g_Scale, 320/2*Global.g_Scale, 14/2*Global.g_Scale, 22/2*Global.g_Scale));
	    
	    s_comboBar_combo[0] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2)); 
	    s_comboBar_combo[1] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2)); 
	    s_comboBar_combo[2] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2)); 
	    s_comboBar_combo[3] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2)); 
	    
	    s_comboBar_Bar.setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_comboBar_BarLife.setAnchorPoint(CGPoint.ccp(0,0.5));
	    s_comboBar_BarLifeLeft.setAnchorPoint(CGPoint.ccp(1,0.5));
	    
	    Global.ss_Character.addChild(s_comboBar_text,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_Bar,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_BarLife,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_BarLifeLeft,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_Icon,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_combo[0],Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_combo[1],Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_combo[2],Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_comboBar_combo[3],Global.kDeapth_Top);
	    
	    s_comboBar_text.setScale( 1.0f/Global.g_Scale );
	    s_comboBar_Bar.setScale( 1.0f/Global.g_Scale );
	    s_comboBar_BarLife.setScale( 1.0f/Global.g_Scale );
	    s_comboBar_BarLifeLeft.setScale( 1.0f/Global.g_Scale );
	    s_comboBar_Icon.setScale( 1.0f/Global.g_Scale );
	    s_comboBar_combo[0].setScale( 1.0f/Global.g_Scale );
	    s_comboBar_combo[1].setScale( 1.0f/Global.g_Scale );
	    s_comboBar_combo[2].setScale( 1.0f/Global.g_Scale );
	    s_comboBar_combo[3].setScale( 1.0f/Global.g_Scale );
	    
	    comboBar_posX = 347 + comboOffsetX;
	    comboBar_posY = 270;
	    comboX = comboBar_posX + 28;
	    comboY = comboBar_posY + 14;
	    
	    comboBar_BarLifeLength = 109/2;
	    comboRemainPercentage = 0;
	    Global.comboRemain = 0;
	    
	    s_comboBar_text.setPosition(CGPoint.ccp(comboX + 35 , comboY + 20+10000));
	    s_comboBar_Icon.setPosition(CGPoint.ccp(comboBar_posX + comboBar_BarLifeLength * comboRemainPercentage , comboBar_posY+10000));
	    
	    s_comboBar_Bar.setPosition(CGPoint.ccp(comboBar_posX-7 , comboBar_posY+10000));
	    s_comboBar_BarLifeLeft.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY+10000));
	    s_comboBar_BarLife.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY+10000));
	    
	    s_comboBar_text.setOpacity(255*0.9);
	    
	    s_comboBar_combo[0].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_combo[1].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_combo[2].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_combo[3].setPosition(CGPoint.ccp(100000,10000));
	    s_comboBar_text.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_Bar.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_BarLife.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_BarLifeLeft.setPosition(CGPoint.ccp(10000,100000));
	    s_comboBar_Icon.setPosition(CGPoint.ccp(10000,100000));
	}
	
	public void  initTurtleCoin()
	{
	    turtlCoinText_textureX = 820/2*Global.g_Scale;
	    turtlCoinText_textureY = 732/2*Global.g_Scale;
	    turtlCoinText_width = 36/2*Global.g_Scale;
	    turtlCoinText_height = 42/2*Global.g_Scale;
	    
	    s_turtleCoin = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1560/2*Global.g_Scale, 494/2*Global.g_Scale, 104/2*Global.g_Scale, 108/2*Global.g_Scale));
	    s_turtleCoinShine = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1934/2*Global.g_Scale, 260/2*Global.g_Scale, 49/2*Global.g_Scale, 48/2*Global.g_Scale));
	    
	    s_turtleCoinText[0] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2));
	    s_turtleCoinText[1] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2));
	    s_turtleCoinText[2] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2));
	    s_turtleCoinText[3] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0/2, 0/2, 0/2, 0/2));
	    
	    Global.ss_Character.addChild(s_turtleCoin,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_turtleCoinShine,Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_turtleCoinText[0],Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_turtleCoinText[1],Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_turtleCoinText[2],Global.kDeapth_Top);
	    Global.ss_Character.addChild(s_turtleCoinText[3],Global.kDeapth_Top);
	    
	    s_turtleCoin.setScale( 1.0f/Global.g_Scale );
	    s_turtleCoinShine.setScale( 1.0f/Global.g_Scale );
	    s_turtleCoinText[0].setScale( 1.0f/Global.g_Scale );
	    s_turtleCoinText[1].setScale( 1.0f/Global.g_Scale );
	    s_turtleCoinText[2].setScale( 1.0f/Global.g_Scale );
	    s_turtleCoinText[3].setScale( 1.0f/Global.g_Scale );

	    s_turtleCoin.setPosition(CGPoint.ccp(40,287));
	    s_turtleCoinText[0].setPosition(CGPoint.ccp(45 , 280));
	    
	    
	    turtleCoinX = s_turtleCoin.getPosition().x + 1;
	    turtleCoinY = s_turtleCoin.getPosition().y - 18;
	    
	    turtleCoin_displayCurrentTimer = 9999;
	    turtleCoin_startToDisplay = true;
	    
	
	
	    s_turtleCoinShine.setPosition(CGPoint.ccp(s_turtleCoin.getPosition().x + 1 + 21 * Math.cos(-90*Math.PI/180) + 99999, s_turtleCoin.getPosition().y - 1 + 21 * Math.sin(-90*Math.PI/180)));
	    
	    s_turtleCoinText[1].setPosition(CGPoint.ccp(45000 , 280));
	    s_turtleCoinText[2].setPosition(CGPoint.ccp(45000 , 280));
	    s_turtleCoinText[3].setPosition(CGPoint.ccp(45000 , 280));
	}
	
	public void  manage( float  dt)
	{
	    this.timeManage(dt);
	    this.comboManage(dt);
	    this.turtleCoinDisplayManage();
	    this.turtleCoinAniManage();
	    this.plusTimeManage();
	}
	
	public void  plusTimeManage()
	{
	    if(isAniPlusTime){
	        if(plusTimeTimer == 0){
	            plusTimeOpacity = 255;
	            plusTimeSX = 0;
	            plusTimeSY = 0;
	            if(Global.currentChosenMiniGame == 5){
	                plusTimeX = 100;
	                plusTimeY = 230;
	            }else{
	                plusTimeX = 230;
	                plusTimeY = 250;
	            }
	            
	            
	        }
	        
	        if(plusTimeTimer < 10){
	            plusTimeSX += 0.1;
	            plusTimeSY += 0.1;
	        }
	        
	        if(plusTimeTimer <= 18 && plusTimeTimer >= 10){
	            plusTimeSX -= 0.02;
	            plusTimeSY -= 0.02;
	        }
	        if(plusTimeTimer <= 25 && plusTimeTimer > 18){
	            plusTimeSX += 0.02;
	            plusTimeSY += 0.02;
	        }
	        if(plusTimeTimer <= 33 && plusTimeTimer > 25){
	            plusTimeSX -= 0.02;
	            plusTimeSY -= 0.02;
	        }
	        if(plusTimeTimer <= 41 && plusTimeTimer > 33){
	            plusTimeSX += 0.02;
	            plusTimeSY += 0.02;
	        }
	        if(plusTimeTimer <= 50 && plusTimeTimer > 41){
	            plusTimeSX -= 0.02;
	            plusTimeSY -= 0.02;
	        }
	        
	        if(plusTimeTimer < 100 && plusTimeTimer > 50){
	            plusTimeY += 7;
	            plusTimeSX += 0.05;
	            plusTimeSY += 0.05;
	            plusTimeOpacity -= 22;
	            if(plusTimeOpacity< 0){
	                plusTimeOpacity = 0;
	            }
	        }
	        
	        s_plusTime.setPosition(CGPoint.ccp(plusTimeX,plusTimeY));
	        s_plusTime.setOpacity(plusTimeOpacity);
	        s_plusTime.setScaleX(1.0f/Global.g_Scale*plusTimeSX);
	        s_plusTime.setScaleY(1.0f/Global.g_Scale*plusTimeSY);
	        
	        if(plusTimeTimer == 100){
	            s_plusTime.setPosition(CGPoint.ccp(10000,10000));
	            isAniPlusTime = false;
	        }
	        
	        plusTimeTimer++;
	    }
	}
	
	public void  timeManage( float  dt)
	{
	    timeRemainPercentage = Global.timeRemain/Global.maxTime;
	    timeRemainPercentageShow += (timeRemainPercentage - timeRemainPercentageShow)/10;
	    s_timeBar_BarLife.setScaleX(1.0f/Global.g_Scale*timeRemainPercentageShow);
	    
	    if(timeBarBlood_isAni){
	        if(timeRemainPercentage > 0.3){
	        	Global.timeRunOut_Slow_Gain -= 0.05;
	        	Global.timeRunOut_Fast_Gain -= 0.05;
	            
	            if(Global.timeRunOut_Slow_Gain < 0){
	            	Global.timeRunOut_Slow_Gain = 0;
	            }
	            if(Global.timeRunOut_Fast_Gain < 0){
	            	Global.timeRunOut_Fast_Gain = 0;
	            }
	
	            
	            if(timeBarBlood_Opacity <= 0){
	                timeBarBlood_isAni = false;
	                
	                s_timeBar_BarLeft_Blood.setPosition(CGPoint.ccp(10000 , comboBar_posY));
	                s_timeBar_BarLife_Blood.setPosition(CGPoint.ccp(10000 , comboBar_posY));
	                
	                timeBarIcon_finalX = timeBar_posX + timeBar_BarLifeLength * timeRemainPercentage;
	                timeBarIcon_finalY = timeBar_posY;
	                s_timeBar_Icon.setRotation(0);
	                s_timeBar_Icon.setScale(1.0f/Global.g_Scale);
	                
	                Global.musicController.changeGain(Global.kSound_TimeRunOutSlow,0);
	                Global.musicController.changeGain(Global.kSound_TimeRunOutFast,0);
	            }   
	        }else{
	            if(isPlayingFastTimeOut){
	            	Global.timeRunOut_Fast_Gain += 0.05;
	                
	                if(Global.timeRunOut_Fast_Gain > 1){
	                	Global.timeRunOut_Fast_Gain = 1;
	                }
	                
	                Global.timeRunOut_Slow_Gain -= 0.05;
	                
	                if(Global.timeRunOut_Slow_Gain < 0){
	                	Global.timeRunOut_Slow_Gain = 0;
	                }
	            }else{
	            	Global.timeRunOut_Slow_Gain += 0.05;
	
	                if(Global.timeRunOut_Slow_Gain > 1){
	                	Global.timeRunOut_Slow_Gain = 1;
	                }
	                
	                Global.timeRunOut_Fast_Gain -= 0.05;
	                
	                if(Global.timeRunOut_Fast_Gain < 0){
	                	Global.timeRunOut_Fast_Gain = 0;
	                }
	            }
	            
	        }
	        
	        if(Global.currentChosenMiniGame == 10 || Global.currentChosenMiniGame == 3){
	        	Global. timeRunOut_Slow_MaxGain = 0;
	        	Global.timeRunOut_Fast_MaxGain = 0;
	        }
	        
	        Global.musicController.changeGain(Global.kSound_TimeRunOutSlow,Global.timeRunOut_Slow_Gain * Global.timeRunOut_Slow_MaxGain);
	        Global.musicController.changeGain(Global.kSound_TimeRunOutFast,Global.timeRunOut_Fast_Gain * Global.timeRunOut_Fast_MaxGain);
	        
	        if(timeBarBlood_isDeceasingOpacity){
	            timeBarBlood_Opacity -= 4;
	            if(timeBarBlood_Opacity <= 0){
	                timeBarBlood_Opacity = 0;
	                timeBarBlood_isDeceasingOpacity = false;
	            }
	        }else{
	            timeBarBlood_Opacity += 4;
	            if(timeBarBlood_Opacity >= 255){
	                timeBarBlood_Opacity = 255;
	                timeBarBlood_isDeceasingOpacity = true;
	            }
	        }
	        
	        s_timeBar_BarLife_Blood.setScaleX(1.0f/Global.g_Scale*timeRemainPercentage*3.333333);
	        
	        s_timeBar_BarLife_Blood.setOpacity(timeBarBlood_Opacity);
	        s_timeBar_BarLeft_Blood.setOpacity(timeBarBlood_Opacity);
	        
	        if(timeBarBlood_isDeceasingIconExtraScale){
	            if(timeRemainPercentage < 0.15){
	                timeBarBlood_iconExtraScale -= 8;
	            }else{
	                timeBarBlood_iconExtraScale -= 4;
	            }
	            
	            if(timeBarBlood_iconExtraScale <= 0){
	                timeBarBlood_iconExtraScale = 0;
	                timeBarBlood_isDeceasingIconExtraScale = false;
	            }
	        }else{
	            if(timeRemainPercentage < 0.15){
	                timeBarBlood_iconExtraScale += 8;
	            }else{
	                timeBarBlood_iconExtraScale += 4;
	            }
	            
	            if(timeBarBlood_iconExtraScale >= 255){
	                timeBarBlood_iconExtraScale = 255;
	                timeBarBlood_isDeceasingIconExtraScale = true;
	            }
	        }
	        
	        s_timeBar_Icon.setScale( (float) (1.0f/Global.g_Scale*(1.0 + timeBarBlood_iconExtraScale/255 * 0.1)));
	        
	        if(timeRemainPercentage < 0.15){
	            if(timeBarBlood_aniTimer % 2 == 0){
	                timeBarBlood_offsetX = (int) ((Math.random()*65535)% 4 - 2);
	                timeBarBlood_offsetY = (int) ((Math.random()*65535)% 4 - 2);
	                timeBarBlood_offsetRotation = (int) ((Math.random()*65535)% 10 - 5); 
	            } 
	            
	            if(prevTimeRemainPercentage >= 0.15){
	                isPlayingFastTimeOut = true;
	            }
	            
	        }else{
	            if(timeBarBlood_aniTimer % 3 == 0){
	                timeBarBlood_offsetX = (int) ((Math.random()*65535)% 3 - 1);
	                timeBarBlood_offsetY = (int) ((Math.random()*65535)% 3 - 1);
	            } 
	            if(timeBarBlood_aniTimer % 3 == 0){
	                timeBarBlood_offsetRotation = (int) ((Math.random()*65535)% 8 - 4); 
	            } 
	            
	            if(prevTimeRemainPercentage < 0.15){
	                isPlayingFastTimeOut = false;
	            }
	        }
	         
	        
	        timeBarIcon_finalX = timeBar_posX + timeBar_BarLifeLength * timeRemainPercentage + timeBarBlood_offsetX;
	        timeBarIcon_finalY = timeBar_posY + timeBarBlood_offsetY;
	        s_timeBar_Icon.setRotation(timeBarBlood_offsetRotation);
	        
	        prevTimeRemainPercentage = timeRemainPercentage;
	        timeBarBlood_aniTimer++;
	        
	    }else{
	        if(timeRemainPercentage <= 0.3){
	            timeBarBlood_isAni = true;
	            timeBarBlood_isDeceasingOpacity = true;
	            timeBarBlood_Opacity = 0;
	            
	            s_timeBar_BarLeft_Blood.setPosition(CGPoint.ccp(timeBar_posX , timeBar_posY));
	            s_timeBar_BarLife_Blood.setPosition(CGPoint.ccp(timeBar_posX  , timeBar_posY));
	            
	            s_timeBar_BarLife_Blood.setOpacity(timeBarBlood_Opacity);
	            s_timeBar_BarLeft_Blood.setOpacity(timeBarBlood_Opacity);
	            
	            timeBarBlood_iconExtraScale = 0;
	            timeBarBlood_isDeceasingIconExtraScale = false;
	            
	            timeBarBlood_aniTimer = 0;
	            
	            prevTimeRemainPercentage = 999;
	            Global.timeRunOut_Slow_Gain = 1;
	            Global.timeRunOut_Fast_Gain = 0;
	            Global.timeRunOut_Fast_MaxGain = 0.75f;
	            Global.timeRunOut_Slow_MaxGain = 0.75f;
	            
	            isPlayingFastTimeOut = false;
	        }
	        
	        timeBarIcon_finalX = timeBar_posX + timeBar_BarLifeLength * timeRemainPercentage;
	        timeBarIcon_finalY = timeBar_posY;
	    }
	    
	    timeBarIcon_showX += (timeBarIcon_finalX - timeBarIcon_showX)/10;
	    s_timeBar_Icon.setPosition(CGPoint.ccp(timeBarIcon_showX , timeBarIcon_finalY));
	    
	}
	
	public void  comboManage( float  dt)
	{
	    if(comboCoin_disappearing_Digit){
	       
	        if(comboCoin_disappearingTimer == 6){
	            comboScaleY = 0.85f;
	            comboScaleX = 1.0f;
	        }
	        if(comboCoin_disappearingTimer == 5){
	            comboScaleY = 0.68f;
	            comboScaleX = 1.0f;
	        }
	        if(comboCoin_disappearingTimer == 4){
	            comboScaleY = 0.5f;
	            comboScaleX = 1.0f;
	        }
	        
	        if(comboCoin_disappearingTimer == 3){
	            comboScaleY = 1.2f;
	            comboScaleX = 1.2f;
	        }
	        
	        if(comboCoin_disappearingTimer == 2){
	            comboScaleY = 1.1f;
	            comboScaleX = 1.1f;
	        }
	        if(comboCoin_disappearingTimer == 1){
	            comboScaleY = 1.05f;
	            comboScaleX = 1.05f;
	        }
	        
	        if(comboCoin_disappearingTimer == 0){
	            comboScaleY = 1.0f;
	            comboScaleX = 1.0f;
	        }
	        
	        if(comboCoin_disappearingTimer == 7){
	            comboScaleY = 0.93f;
	            comboScaleX = 1.0f;
	            
	            s_comboBar_Icon.setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_text.setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_BarLifeLeft.setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_Bar.setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_BarLife.setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_combo[0].setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_combo[1].setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_combo[2].setPosition(CGPoint.ccp(10000 , 10000));
	            s_comboBar_combo[3].setPosition(CGPoint.ccp(10000 , 10000));
	            
	            comboCoin_disappearing_Digit = false;
	            
	            comboCoin_displayToHowmany_Digit[0] = 0;
	            comboCoin_displayToHowmany_Digit[1] = 0;
	            comboCoin_displayToHowmany_Digit[2] = 0;
	            comboCoin_displayToHowmany_Digit[3] = 0;
	            
	            comboCoin_displayCurrentTimer_DigitEach[0] = 0;
	            comboCoin_displayCurrentTimer_DigitEach[1] = 0;
	            comboCoin_displayCurrentTimer_DigitEach[2] = 0;
	            comboCoin_displayCurrentTimer_DigitEach[3] = 0;
	            
	            comboCoin_startToDisplay_DigitEach[0] = false;
	            comboCoin_startToDisplay_DigitEach[1] = false;
	            comboCoin_startToDisplay_DigitEach[2] = false;
	            comboCoin_startToDisplay_DigitEach[3] = false;
	            
	            if(isChangingComboLevel){
	                chaningComboLevelScale = 1.0f;
	                changingComboLevelOffsetX = 0;
	                
	                s_comboBar_combo[0].setScale(0);
	                s_comboBar_combo[1].setScale(0);
	                s_comboBar_combo[2].setScale(0);
	                s_comboBar_combo[3].setScale(0);
	            }
	            
	        }
	
	        s_comboBar_BarLife.setScaleX(1.0f/Global.g_Scale*comboRemainPercentage * comboScaleX);
	        s_comboBar_Icon.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	        s_comboBar_text.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	        s_comboBar_BarLifeLeft.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	        s_comboBar_Bar.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	        s_comboBar_combo[0].setScaleX(1.0f/Global.g_Scale*comboScaleX);
	        
	        s_comboBar_BarLife.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	        s_comboBar_Icon.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	        s_comboBar_text.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	        s_comboBar_BarLifeLeft.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	        s_comboBar_Bar.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	        s_comboBar_combo[0].setScaleY(1.0f/Global.g_Scale*comboScaleY);
	        
	        comboCoin_disappearingTimer++;
	        
	        return;
	    }
	    
	    if(!comboCoin_startToDisplay){
	        return;
	    }
	    
	    if(comboCoin_displayCurrentTimer == 0){
	        comboScaleY = 0.93f;
	        comboScaleX = 1.0f;
	    }
	    if(comboCoin_displayCurrentTimer == 1){
	        comboScaleY = 0.85f;
	        comboScaleX = 1.0f;
	    }
	    if(comboCoin_displayCurrentTimer == 2){
	        comboScaleY = 0.68f;
	        comboScaleX = 1.0f;
	    }
	    if(comboCoin_displayCurrentTimer == 3){
	        comboScaleY = 0.5f;
	        comboScaleX = 1.0f;
	    }
	    
	    if(comboCoin_displayCurrentTimer == 4){
	        comboScaleY = 1.2f;
	        comboScaleX = 1.2f;
	    }
	    
	    if(comboCoin_displayCurrentTimer == 5){
	        comboScaleY = 1.1f;
	        comboScaleX = 1.1f;
	    }
	    if(comboCoin_displayCurrentTimer == 6){
	        comboScaleY = 1.05f;
	        comboScaleX = 1.05f;
	    }
	    if(comboCoin_displayCurrentTimer == 7){
	        comboScaleY = 1.0f;
	        comboScaleX = 1.0f;
	    }
	
	    Global.comboRemain -= Global.comoboReduceSpeed;
	    
	    comboRemainPercentage += (Global.comboRemain - comboRemainPercentage)/3;
	    
	    if(Global.comboRemain <= 0){
	        delegate.beforeLoseComboWhenComboRemainGoesToZero();
	        this.lostCombo();
	
	        return;
	    }
	    
	    s_comboBar_Icon.setPosition(CGPoint.ccp(comboBar_posX + comboBar_BarLifeLength * comboRemainPercentage , comboBar_posY));
	    s_comboBar_text.setPosition(CGPoint.ccp(comboX-2, comboY));
	    s_comboBar_BarLifeLeft.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY));
	    s_comboBar_Bar.setPosition(CGPoint.ccp(comboBar_posX-7 , comboBar_posY));
	    s_comboBar_BarLife.setPosition(CGPoint.ccp(comboBar_posX , comboBar_posY));
	    
	    s_comboBar_BarLife.setScaleX(1.0f/Global.g_Scale*comboRemainPercentage * comboScaleX);
	    s_comboBar_Icon.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	    s_comboBar_text.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	    s_comboBar_BarLifeLeft.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	    s_comboBar_Bar.setScaleX(1.0f/Global.g_Scale*comboScaleX);
	    s_comboBar_combo[0].setScaleX(1.0f/Global.g_Scale*comboScaleX);
	    
	    s_comboBar_BarLife.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	    s_comboBar_Icon.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	    s_comboBar_text.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	    s_comboBar_BarLifeLeft.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	    s_comboBar_Bar.setScaleY(1.0f/Global.g_Scale*comboScaleY);
	    s_comboBar_combo[0].setScaleY(1.0f/Global.g_Scale*comboScaleY);
	    
	    
	    comboCoin_displayCurrentTimer++;
	    
	    if(isChangingComboLevel){
	        if(changingComboLevelTimer == 0){
	            chaningComboLevelScale = 2.8f;
	            changingComboLevelOffsetX = 100;
	        }
	        
	        if(changingComboLevelTimer < 5){
	            chaningComboLevelScale += 0.7;
	            changingComboLevelOffsetX += 2;
	        }else{
	            chaningComboLevelScale -= 1.0;
	            changingComboLevelOffsetX -= 2;
	        }
	        
	        if(changingComboLevelTimer == 10){
	
	            isChangingComboLevel = false;
	            s_comboBar_combo[0].setScale(1.0f/Global.g_Scale);
	            s_comboBar_combo[1].setScale(1.0f/Global.g_Scale);
	            s_comboBar_combo[2].setScale(1.0f/Global.g_Scale);
	            
	            changingComboLevelOffsetX = 0;
	            
	            this.setComboDigitValues();
	            
	        }else{
	            s_comboBar_combo[0].setScale(1.0f/Global.g_Scale*chaningComboLevelScale);
	            s_comboBar_combo[1].setScale(1.0f/Global.g_Scale*chaningComboLevelScale);
	            s_comboBar_combo[2].setScale(1.0f/Global.g_Scale*chaningComboLevelScale);
	            
	        }
	        
	        changingComboLevelTimer++;
	    }
	
	    
	    
	    //---------------RUN DIGIT ANI
	 
	    if(!comboCoin_startToDisplay_Digit){
	        return;
	    }
	    
	    if(comboCoin_startToDisplay_DigitEach[0]){
	        if(comboCoin_displayCurrentTimer_DigitEach[0] == 0){
	            comboCoin_Digit_offsetX[0] = 0;
	            comboCoin_Digit_offsetY[0] = 2;
	            comboCoin_Digit_Opacity[0] = 210;
	        }
	        if(comboCoin_displayCurrentTimer_DigitEach[0] == 1){
	            comboCoin_Digit_offsetX[0] = 0;
	            comboCoin_Digit_offsetY[0] = 5.5f;
	            comboCoin_Digit_Opacity[0] = 150;
	        }
	        if(comboCoin_displayCurrentTimer_DigitEach[0] == 2){
	            comboCoin_Digit_offsetX[0] = 0;
	            comboCoin_Digit_offsetY[0] = 10;
	            comboCoin_Digit_Opacity[0] = 80;
	        }
	        if(comboCoin_displayCurrentTimer_DigitEach[0] == 3){
	            comboCoin_Digit_offsetX[0] = 0;
	            comboCoin_Digit_offsetY[0] = 5.5f;
	            comboCoin_Digit_Opacity[0] = 150;
	        }
	        if(comboCoin_displayCurrentTimer_DigitEach[0] == 4){
	            comboCoin_Digit_offsetX[0] = 0;
	            comboCoin_Digit_offsetY[0] = 2;
	            comboCoin_Digit_Opacity[0] = 210;
	        }
	        if(comboCoin_displayCurrentTimer_DigitEach[0] == 5){
	            comboCoin_Digit_offsetX[0] = 0;
	            comboCoin_Digit_offsetY[0] = 0;
	            comboCoin_Digit_Opacity[0] = 255;
	        }
	        comboCoin_displayCurrentTimer_DigitEach[0]++;
	    }
	   
	    
	    if(comboCoin_startToDisplay_DigitEach[1]){
	        if(comboCoin_Digit_changingDigit[1]){
	             
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 0){
	                comboCoin_Digit_offsetX[1] = 0;
	                comboCoin_Digit_offsetY[1] = 2;
	                comboCoin_Digit_Opacity[1] = 210;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 1){
	                comboCoin_Digit_offsetX[1] = 0;
	                comboCoin_Digit_offsetY[1] = 5.5f;
	                comboCoin_Digit_Opacity[1] = 150;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 2){
	                comboCoin_Digit_offsetX[1] = 0;
	                comboCoin_Digit_offsetY[1] = 10;
	                comboCoin_Digit_Opacity[1] = 80;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 3){
	                comboCoin_Digit_offsetX[1] = 0;
	                comboCoin_Digit_offsetY[1] = 4;
	                comboCoin_Digit_Opacity[1] = 165;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 4){
	                comboCoin_Digit_offsetX[1] = 0;
	                comboCoin_Digit_offsetY[1] = 0;
	                comboCoin_Digit_Opacity[1] = 255;
	                
	                comboCoin_Digit_changingDigit[1] = false;
	                comboCoin_displayCurrentTimer_DigitEach[1] = -1;
	                comboCoin_startToDisplay_DigitEach[1] = false;
	            }
	            
	        }else{
	            
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 1){
	                comboCoin_Digit_offsetY[1] = 0.5f;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 2){
	                comboCoin_Digit_offsetY[1] = 1.5f;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 3){
	                comboCoin_Digit_offsetY[1] = 0.5f;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[1] == 4){
	                comboCoin_Digit_offsetY[1] = 0;
	                
	                comboCoin_Digit_changingDigit[1] = false;
	                comboCoin_startToDisplay_DigitEach[1] = false;
	            }
	        }
	        comboCoin_displayCurrentTimer_DigitEach[1]++;
	    }
	    
	    if(comboCoin_startToDisplay_DigitEach[2]){
	        if(comboCoin_Digit_changingDigit[2]){
	            
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 0){
	                comboCoin_Digit_offsetX[2] = 0;
	                comboCoin_Digit_offsetY[2] = 2;
	                comboCoin_Digit_Opacity[2] = 210;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 1){
	                comboCoin_Digit_offsetX[2] = 0;
	                comboCoin_Digit_offsetY[2] = 5.5f;
	                comboCoin_Digit_Opacity[2] = 150;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 2){
	                comboCoin_Digit_offsetX[2] = 0;
	                comboCoin_Digit_offsetY[2] = 10;
	                comboCoin_Digit_Opacity[2] = 80;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 3){
	                comboCoin_Digit_offsetX[2] = 0;
	                comboCoin_Digit_offsetY[2] = 4;
	                comboCoin_Digit_Opacity[2] = 165;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 4){
	                comboCoin_Digit_offsetX[2] = 0;
	                comboCoin_Digit_offsetY[2] = 0;
	                comboCoin_Digit_Opacity[2] = 255;
	                
	                comboCoin_Digit_changingDigit[2] = false;
	                comboCoin_displayCurrentTimer_DigitEach[2] = -1;
	                comboCoin_startToDisplay_DigitEach[2] = false;
	            }
	            
	        }else{
	            
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 1){
	                comboCoin_Digit_offsetY[2] = 0.5f;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 2){
	                comboCoin_Digit_offsetY[2] = 1.5f;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 3){
	                comboCoin_Digit_offsetY[2] = 0.5f;
	            }
	            if(comboCoin_displayCurrentTimer_DigitEach[2] == 4){
	                comboCoin_Digit_offsetY[2] = 0;
	                
	                comboCoin_Digit_changingDigit[2] = false;
	                comboCoin_startToDisplay_DigitEach[2] = false;
	            }
	        }
	        comboCoin_displayCurrentTimer_DigitEach[2]++;
	    }
	    
	
	    if(comboCoin_displayCurrentTimer_Digit == 0){
	        comboCoin_displayToHowmany++;
	        
	        comboCoin_startToDisplay_DigitEach[0] = true;
	        
	        if(comboCoin_displayToHowmany >= 10){
	            comboCoin_startToDisplay_DigitEach[1] = true;
	        }
	        
	        if(comboCoin_displayToHowmany >= 100){
	            comboCoin_startToDisplay_DigitEach[2] = true;
	        }
	    }
	    
	    if(comboCoin_displayCurrentTimer_Digit == 2){
	        
	        int comb_digit0;
	        int comb_digit1;
	        int comb_digit2;
	        
	        if(comboCoin_displayToHowmany < 10){
	            s_comboBar_combo[0].setTextureRect(CGRect.make(comboDigitTextureX[comboCoin_displayToHowmany][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	        }else if(comboCoin_displayToHowmany < 100){
	            comb_digit1 = comboCoin_displayToHowmany/10;
	            comb_digit0 = comboCoin_displayToHowmany - comb_digit1*10;
	            
	            s_comboBar_combo[0].setTextureRect(CGRect.make(comboDigitTextureX[comb_digit0][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	            s_comboBar_combo[1].setTextureRect(CGRect.make(comboDigitTextureX[comb_digit1][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	            
	            if(comboCoin_displayToHowmany_Digit[1] != comb_digit1){
	                comboCoin_Digit_changingDigit[1] = true;
	            }
	            
	            comboCoin_displayToHowmany_Digit[1] = comb_digit1;
	            comboCoin_displayToHowmany_Digit[0] = comb_digit0;
	        }else if(comboCoin_displayToHowmany < 1000){
	            comb_digit2 = comboCoin_displayToHowmany/100;
	            comb_digit1 = (comboCoin_displayToHowmany - comb_digit2*100)/10;
	            comb_digit0 = comboCoin_displayToHowmany - comb_digit2*100 - comb_digit1*10;
	            
	            s_comboBar_combo[0].setTextureRect(CGRect.make(comboDigitTextureX[comb_digit0][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	            s_comboBar_combo[1].setTextureRect(CGRect.make(comboDigitTextureX[comb_digit1][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	            s_comboBar_combo[2].setTextureRect(CGRect.make(comboDigitTextureX[comb_digit2][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	            
	            if(comboCoin_displayToHowmany_Digit[2] != comb_digit1){
	                comboCoin_Digit_changingDigit[2] = true;
	            }
	            
	            comboCoin_displayToHowmany_Digit[2] = comb_digit2;
	            comboCoin_displayToHowmany_Digit[1] = comb_digit1;
	            comboCoin_displayToHowmany_Digit[0] = comb_digit0;
	        }
	        
	        s_comboBar_text.setTextureRect(CGRect.make(comboTextureX[Global.comboLevel], comboTextureY[Global.comboLevel], comboWidth[Global.comboLevel], comboHeight[Global.comboLevel]));
	        
	        
	    }
	    
	    if(comboCoin_displayCurrentTimer_Digit == 5){
	        if(Global.currentCombo < 10){
	            comboCoin_displayCurrentTimer_Digit = -1;
	            if(comboCoin_displayToHowmany == Global.currentCombo){
	                comboCoin_startToDisplay_Digit = false;
	                comboCoin_displayCurrentTimer_DigitEach[0] = 0;
	            }
	        }
	    }
	    
	    if(comboCoin_displayCurrentTimer_Digit == 8){
	        if(Global.currentCombo >= 10){
	            comboCoin_displayCurrentTimer_Digit = -1;
	            if(comboCoin_displayToHowmany == Global.currentCombo){
	                comboCoin_startToDisplay_Digit = false;
	                comboCoin_displayCurrentTimer_DigitEach[0] = 0;
	                comboCoin_displayCurrentTimer_DigitEach[1] = 0;
	            }
	        }
	    }
	    
	    if(comboCoin_displayCurrentTimer_Digit == 10){
	        if(Global.currentCombo >= 100){
	            comboCoin_displayCurrentTimer_Digit = -1;
	            if(comboCoin_displayToHowmany == Global.currentCombo){
	                comboCoin_startToDisplay_Digit = false;
	                comboCoin_displayCurrentTimer_DigitEach[0] = 0;
	                comboCoin_displayCurrentTimer_DigitEach[1] = 0;
	                comboCoin_displayCurrentTimer_DigitEach[2] = 0;
	            }
	        }
	    }
	    
	    
	    this.setComboDigitValues();
	    
	    
	        
	    
	    comboCoin_displayCurrentTimer_Digit++;
	}
	
	public void  setComboDigitValues()
	{
	    if(comboCoin_displayToHowmany < 10){
	        s_comboBar_combo[0].setPosition(CGPoint.ccp(comboX-2 + comboCoin_Digit_offsetX[0], comboY + 17 + comboCoin_Digit_offsetY[0]));
	        s_comboBar_combo[0].setOpacity(comboCoin_Digit_Opacity[0]*0.85);
	    }else if(comboCoin_displayToHowmany < 100){
	        if(Global.comboLevel < 1){
	            s_comboBar_combo[0].setPosition(CGPoint.ccp(comboX-2+6 + comboCoin_Digit_offsetX[0] + changingComboLevelOffsetX/2, comboY + 17 + comboCoin_Digit_offsetY[0]));
	            s_comboBar_combo[0].setOpacity(comboCoin_Digit_Opacity[0]*0.85);
	            
	            s_comboBar_combo[1].setPosition(CGPoint.ccp(comboX-2-7 + comboCoin_Digit_offsetX[1] - changingComboLevelOffsetX/2, comboY + 17 + comboCoin_Digit_offsetY[1]));
	            s_comboBar_combo[1].setOpacity(comboCoin_Digit_Opacity[1]*0.85);
	        }else{
	            s_comboBar_combo[0].setPosition(CGPoint.ccp(comboX-2+7 + comboCoin_Digit_offsetX[0] + changingComboLevelOffsetX/2, comboY + 17 + comboCoin_Digit_offsetY[0]));
	            s_comboBar_combo[0].setOpacity(comboCoin_Digit_Opacity[0]*0.85);
	            
	            s_comboBar_combo[1].setPosition(CGPoint.ccp(comboX-2-8 + comboCoin_Digit_offsetX[1] - changingComboLevelOffsetX/2, comboY + 17 + comboCoin_Digit_offsetY[1]));
	            s_comboBar_combo[1].setOpacity(comboCoin_Digit_Opacity[1]*0.85);
	        }
	        
	    }else if(comboCoin_displayToHowmany < 1000){
	        s_comboBar_combo[0].setPosition(CGPoint.ccp(comboX-2+15 + comboCoin_Digit_offsetX[0] + changingComboLevelOffsetX, comboY + 17 + comboCoin_Digit_offsetY[0]));
	        s_comboBar_combo[0].setOpacity(comboCoin_Digit_Opacity[0]*0.85);
	        
	        s_comboBar_combo[1].setPosition(CGPoint.ccp(comboX-2 + comboCoin_Digit_offsetX[1], comboY + 17 + comboCoin_Digit_offsetY[1]));
	        s_comboBar_combo[1].setOpacity(comboCoin_Digit_Opacity[1]*0.85);
	        
	        s_comboBar_combo[2].setPosition(CGPoint.ccp(comboX-2-15 + comboCoin_Digit_offsetX[1] - changingComboLevelOffsetX, comboY + 17 + comboCoin_Digit_offsetY[1]));
	        s_comboBar_combo[2].setOpacity(comboCoin_Digit_Opacity[1]*0.85);
	    }
	}
	
	public void  turtleCoinDisplayManage()
	{
	    if(!turtleCoin_startToDisplay){
	        return;
	    }
	    
	    if(turtleCoin_displayCurrentTimer == 0){
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*0.93);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*0.93);
	    }
	    if(turtleCoin_displayCurrentTimer == 1){
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*0.85);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*0.85);
	    }
	    if(turtleCoin_displayCurrentTimer == 2){
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*0.68);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*0.68);
	    }
	    if(turtleCoin_displayCurrentTimer == 3){
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*0.5);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*0.5);
	    }
	    
	    if(turtleCoin_displayCurrentTimer == 4){
	        if(Global.currentTurtleCoin < 10){
	            turtleCoin_displayToHowmany[0] = Global.currentTurtleCoin;
	        }else  if(Global.currentTurtleCoin < 100){
	            turtleCoin_displayToHowmany[1] = Global.currentTurtleCoin/10;
	            turtleCoin_displayToHowmany[0] = Global.currentTurtleCoin - turtleCoin_displayToHowmany[1] * 10;
	        }else  if(Global.currentTurtleCoin < 1000){
	            turtleCoin_displayToHowmany[2] = Global.currentTurtleCoin/100;
	            turtleCoin_displayToHowmany[1] = (Global.currentTurtleCoin - turtleCoin_displayToHowmany[2] * 100)/10;
	            turtleCoin_displayToHowmany[0] = Global.currentTurtleCoin - turtleCoin_displayToHowmany[2] * 100 - turtleCoin_displayToHowmany[1] * 10;
	        }else{
	            turtleCoin_displayToHowmany[3] = Global.currentTurtleCoin/1000;
	            turtleCoin_displayToHowmany[2] = (Global.currentTurtleCoin - turtleCoin_displayToHowmany[3] * 1000)/100;
	            turtleCoin_displayToHowmany[1] = (Global.currentTurtleCoin - turtleCoin_displayToHowmany[3] * 1000 - turtleCoin_displayToHowmany[2] * 100)/10;
	            turtleCoin_displayToHowmany[0] = Global.currentTurtleCoin - turtleCoin_displayToHowmany[3] * 1000 - turtleCoin_displayToHowmany[2] * 100 - turtleCoin_displayToHowmany[1] * 10;
	        }
	        
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*1.2);
	        s_turtleCoinText[0].setScaleX(1.0f/Global.g_Scale*1.2);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*1.2);
	        s_turtleCoinText[1].setScaleX(1.0f/Global.g_Scale*1.2);
	        s_turtleCoinText[2].setScaleY(1.0f/Global.g_Scale*1.2);
	        s_turtleCoinText[2].setScaleX(1.0f/Global.g_Scale*1.2);
	        s_turtleCoinText[3].setScaleY(1.0f/Global.g_Scale*1.2);
	        s_turtleCoinText[3].setScaleX(1.0f/Global.g_Scale*1.2);
	    }
	    
	    
	    if(turtleCoin_displayCurrentTimer == 5){
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*1.1);
	        s_turtleCoinText[0].setScaleX(1.0f/Global.g_Scale*1.1);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*1.1);
	        s_turtleCoinText[1].setScaleX(1.0f/Global.g_Scale*1.1);
	        s_turtleCoinText[2].setScaleY(1.0f/Global.g_Scale*1.1);
	        s_turtleCoinText[2].setScaleX(1.0f/Global.g_Scale*1.1);
	        s_turtleCoinText[3].setScaleY(1.0f/Global.g_Scale*1.1);
	        s_turtleCoinText[3].setScaleX(1.0f/Global.g_Scale*1.1);
	    }
	    if(turtleCoin_displayCurrentTimer == 6){
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*1.05);
	        s_turtleCoinText[0].setScaleX(1.0f/Global.g_Scale*1.05);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*1.05);
	        s_turtleCoinText[1].setScaleX(1.0f/Global.g_Scale*1.05);
	        s_turtleCoinText[2].setScaleY(1.0f/Global.g_Scale*1.05);
	        s_turtleCoinText[2].setScaleX(1.0f/Global.g_Scale*1.05);
	        s_turtleCoinText[3].setScaleY(1.0f/Global.g_Scale*1.05);
	        s_turtleCoinText[3].setScaleX(1.0f/Global.g_Scale*1.05);
	    }
	    if(turtleCoin_displayCurrentTimer == 7){
	        s_turtleCoinText[0].setScaleY(1.0f/Global.g_Scale*1.0);
	        s_turtleCoinText[0].setScaleX(1.0f/Global.g_Scale*1.0);
	        s_turtleCoinText[1].setScaleY(1.0f/Global.g_Scale*1.0);
	        s_turtleCoinText[1].setScaleX(1.0f/Global.g_Scale*1.0);
	        s_turtleCoinText[2].setScaleY(1.0f/Global.g_Scale*1.0);
	        s_turtleCoinText[2].setScaleX(1.0f/Global.g_Scale*1.0);
	        s_turtleCoinText[3].setScaleY(1.0f/Global.g_Scale*1.0);
	        s_turtleCoinText[3].setScaleX(1.0f/Global.g_Scale*1.0);
	    }
	    
	    if(Global.currentTurtleCoin < 10){
	        s_turtleCoinText[0].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[0] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[0].setPosition(CGPoint.ccp(turtleCoinX, turtleCoinY - 7));
	    }else if(Global.currentTurtleCoin < 100){
	        s_turtleCoinText[0].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[0] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[0].setPosition(CGPoint.ccp(turtleCoinX + 10 -3, turtleCoinY - 7));
	        
	        s_turtleCoinText[1].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[1] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[1].setPosition(CGPoint.ccp(turtleCoinX - 5 -3, turtleCoinY - 7));
	    }else if(Global.currentTurtleCoin < 1000){
	        s_turtleCoinText[0].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[0] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[0].setPosition(CGPoint.ccp(turtleCoinX + 17 - 3, turtleCoinY - 7));
	        
	        s_turtleCoinText[1].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[1] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[1].setPosition(CGPoint.ccp(turtleCoinX + 3 - 3, turtleCoinY - 7));
	        
	        s_turtleCoinText[2].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[2] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[2].setPosition(CGPoint.ccp(turtleCoinX - 12 - 3, turtleCoinY - 7));
	        
	    }else if(Global.currentTurtleCoin < 10000){
	        s_turtleCoinText[0].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[0] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[0].setPosition(CGPoint.ccp(turtleCoinX + 24 - 3, turtleCoinY - 7));
	        
	        s_turtleCoinText[1].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[1] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[1].setPosition(CGPoint.ccp(turtleCoinX + 10 - 3, turtleCoinY - 7));
	        
	        s_turtleCoinText[2].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[2] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[2].setPosition(CGPoint.ccp(turtleCoinX - 5 - 3, turtleCoinY - 7));
	        
	        s_turtleCoinText[3].setTextureRect(CGRect.make(turtlCoinText_textureX + turtleCoin_displayToHowmany[3] * turtlCoinText_width, turtlCoinText_textureY, turtlCoinText_width, turtlCoinText_height));
	        s_turtleCoinText[3].setPosition(CGPoint.ccp(turtleCoinX - 19 - 3, turtleCoinY - 7));
	    }
	   
	    
	    turtleCoin_displayCurrentTimer++;
	    
	    if(turtleCoin_displayCurrentTimer >= 30){
	        turtleCoin_startToDisplay = false;
	    }
	    
	}
	
	public void  turtleCoinShineManage()
	{
	    
	    if((Math.random()*65535)%6 == 0){
	        if((Math.random()*65535)%3 == 0){
	            turtleCoinShinningOpacity -= (Math.random()*65535) % 50;
	        }else{
	            turtleCoinShinningOpacity += (Math.random()*65535) % 50;
	        }
	        
	        if(turtleCoinShinningOpacity < 150){
	            turtleCoinShinningOpacity = 150;
	        }
	        
	        if(turtleCoinShinningOpacity > 255){
	            turtleCoinShinningOpacity = 255;
	        }
	
	        
	        s_turtleCoinShine.setOpacity(turtleCoinShinningOpacity);
	    }
	   
	    
	    turtleCoinShinningAngle += (Global.turtleCoinShinning_angleSpeed - turtleCoinShinningAngle)/10;
	    
	    s_turtleCoinShine.setPosition(CGPoint.ccp(s_turtleCoin.getPosition().x + 1 + 21 * Math.cos(-90*Math.PI/180 - turtleCoinShinningAngle), s_turtleCoin.getPosition().y - 1 + 21 * Math.sin(-90*Math.PI/180 - turtleCoinShinningAngle)));
	    
	
	    
	    if(turtleCoinShinningAngle >= Math.PI * 2){
	        turtleCoinShinningAngle -= Math.PI * 2;
	        Global.turtleCoinShinning_angleSpeed -= Math.PI * 2;
	        this.gainCoin(1);
	    }
	
	    
	    turtleCoinShinning_aniTimer++;
	}
	
	public void  turtleCoinAniManage()
	{
	    
	    if(!turtleCoinAniStruct.isAni){
	        return;
	    }
	    
	    if( turtleCoinAniStruct.aniTimer > 26){
	        turtleCoinAniStruct.aniTimer++;
	        if( turtleCoinAniStruct.aniTimer > 26){
	            turtleCoinAniStruct.isAni = false;
	            for(int i = 0 ; i < turtleCoinAniStruct.numElements ; i++){
	                turtleCoinAniStruct.s_graphic[i].setPosition(CGPoint.ccp(10000,10000));
	            }
	        }
	        return;
	    }
	    
	    if(turtleCoinAniStruct.aniTimer == 0){
	        for(int i = 0 ; i <  turtleCoinAniStruct.numElements ; i++){
	            ranNumber = (int) ((Math.random()*65535)%100);
	            turtleCoinAniStruct.vx[i] = (float) (ranNumber/50.0);
	            ranNumber = (int) ((Math.random()*65535)%100);
	            turtleCoinAniStruct.vy[i] = (float)ranNumber/30.0f;
	            ranNumber = (int) ((Math.random()*65535)%100);
	            turtleCoinAniStruct.rv[i] = (float)ranNumber/50.0f;
	            
	            ranNumber = (int) ((Math.random()*65535)%100);
	            turtleCoinAniStruct.ov[i] = (float) ((float)ranNumber/20.0 + 10.0);
	            
	            if((Math.random()*65535)%2 == 0){
	                turtleCoinAniStruct.rv[i] *= -1;
	                turtleCoinAniStruct.vx[i] *= -1;
	            }
	            
	            turtleCoinAniStruct.posX[i] = s_turtleCoinShine.getPosition().x;
	            turtleCoinAniStruct.posY[i] = s_turtleCoinShine.getPosition().y;
	            
	            turtleCoinAniStruct.opacity[i] = 255;
	        }
	    }
	    
	    for(int i = 0 ; i <  turtleCoinAniStruct.numElements ; i++){
	        turtleCoinAniStruct.s_graphic[i].setPosition(CGPoint.ccp(turtleCoinAniStruct.posX[i], turtleCoinAniStruct.posY[i]));
	        turtleCoinAniStruct.s_graphic[i].setOpacity(turtleCoinAniStruct.opacity[i]);
	        
	        turtleCoinAniStruct.posX[i] += turtleCoinAniStruct.vx[i];
	        turtleCoinAniStruct.posY[i] += turtleCoinAniStruct.vy[i];
	        turtleCoinAniStruct.opacity[i] -= turtleCoinAniStruct.ov[i];
	        
	        if(turtleCoinAniStruct.opacity[i] < 0 ){
	            turtleCoinAniStruct.opacity[i] = 0;
	        }
	        
	        turtleCoinAniStruct.vy[i] -= 0.2;
	    }
	   
	    
	    turtleCoinAniStruct.aniTimer++;
	}
	
	public void  gainCoin( int _coin)
	{
	    this.setTurtleCoinAni();
	    
	    Global.currentTurtleCoin += _coin;
	    
	    turtleCoin_displayCurrentTimer = 0;
	    turtleCoin_startToDisplay = true;
	}
	
	public void  gainTime( float _time)
	{
		Global.timeRemain += _time;
	    if( Global.timeRemain > Global.maxTime){
	    	Global.timeRemain = Global.maxTime;
	    }
	}
	
	public void  gainCombo( int _combo)
	{
		Global.turtleCoinShinning_angleSpeed += Global.turtleCoinShinning_angleAcceleration;
	    this.getOneTurtleDefeat();
	    
	    Global.currentCombo += _combo;
	    
	    if(Global.comboLevel <= 9){
	        
	        if(Global.currentCombo == Global.comboColorLimit[Global.comboLevel+1]){
	        	Global.comboLevel++;
	            Global.playLayer.setToBombingCombo();
	            
	            if(Global.currentChosenMiniGame == 1){
	                this.gainTime(Global.timeToBeGained);
	            }else if(Global.currentChosenMiniGame == 2){
	                this.gainTime(6.0f);
	            }else if(Global.currentChosenMiniGame == 3){
	                this.gainTime(Global.timeToBeGained);
	            }else if(Global.currentChosenMiniGame == 4){
	                this.gainTime(Global.timeToBeGained);
	            }else if(Global.currentChosenMiniGame == 5){
	                this.gainTime(3.5f);
	            }else if(Global.currentChosenMiniGame == 11){
	                this.gainTime(Global.timeToBeGained);
	            }else if(Global.currentChosenMiniGame == 13){
	                this.gainTime(Global.timeToBeGained);
	            }else{
	                this.gainTime(6);
	            }
	            
	            isChangingComboLevel = true;
	            changingComboLevelTimer = 0;
	            this.setPlusTimeAni();
	            
	            if(Global.currentChosenMiniGame == 5){
	                Global.playLayer.setToBombingTimePlus(100,230);
	            }else{
	                Global.playLayer.setToBombingTimePlus(230,250);
	            }
	            
	        }
	    }else{
	        
	        int extraComboLimit;
	        if(Global.currentChosenMiniGame == 11){
	            extraComboLimit = 40;
	        }else if(Global.currentChosenMiniGame == 2){
	            extraComboLimit = 3;
	        }else if(Global.currentChosenMiniGame == 103){
	            extraComboLimit = 10;
	        }else{
	            extraComboLimit = 20;
	        }
	        
	        if(Global.currentCombo % extraComboLimit == 0){
	            
	            if(Global.currentChosenMiniGame == 5){
	                this.gainTime(3.5f);
	            }else{
	                this.gainTime(6);
	            }
	            
	            isChangingComboLevel = true;
	            changingComboLevelTimer = 0;
	            this.setPlusTimeAni();
	            
	            if(Global.currentChosenMiniGame == 5){
	                Global.playLayer.setToBombingTimePlus(100,230);
	            }else{
	                Global.playLayer.setToBombingTimePlus(230,250);
	            }
	            
	        }
	    }
	    
	    
	    //FUCK DO IT IN MINIBASIC
	    if(Global.currentChosenMiniGame == 5 || Global.currentChosenMiniGame == 3 || Global.currentChosenMiniGame == 10 || Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 13 || Global.currentChosenMiniGame == 2){
	    	Global.comboRemain = 1;
	    }
	    
	    if(Global.maxCombo < Global.currentCombo){
	    	Global.maxCombo = Global.currentCombo;
	    }
	    
	    if(Global.currentCombo >= Global.comboToStart){
	        comboCoin_startToDisplay = true;
	        comboCoin_startToDisplay_Digit = true;
	        
	        comboCoin_startToDisplay_DigitEach[0] = true;
	    }
	    
	    if(Global.currentCombo == Global.comboToStart-1){
	    	Global.comboLevel = 0;
	    }
	    
	    if(Global.currentCombo == Global.comboToStart){
	        
	        comboRemainPercentage = 1.0f;
	                
	        comboScaleX = 1;
	        comboScaleY = 1;
	        
	        comboCoin_displayToHowmany = Global.comboToStart-1;
	        comboCoin_displayCurrentTimer_Digit = 0;
	        
	        s_comboBar_combo[0].setTextureRect(CGRect.make(comboDigitTextureX[comboCoin_displayToHowmany][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	        s_comboBar_combo[1].setTextureRect(CGRect.make(comboDigitTextureX[1][Global.comboLevel], comboDigitTextureY[Global.comboLevel], comboDigitWidth[Global.comboLevel], comboDigitHeight[Global.comboLevel]));
	    }
	}
	
	
	public void  lostCombo()
	{
		Global.gameRoundFromBegin = 0;
	    
	    if(Global.currentCombo == 0){
	        return;
	    }
	    
	    if(Global.currentCombo >= 5){
	    	Global.playLayer.setToBombingCombo();
	    }
	    
	    comboCoin_startToDisplay = false;
	    comboCoin_startToDisplay_Digit = false;
	    comboCoin_disappearing_Digit = true;
	    
	    comboCoin_disappearingTimer = 0;
	    
	    Global.currentCombo = 0;
	    
	    Global.playLayer.setComboExtraValues();
	    
	    delegate.comboLost();
	    
	    Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_LoseCombo,false,0.35);
	    
	
	}
	
	public void  setTurtleCoinShineAni()
	{
	    if(turtleCoinShinning_isAni){
	        return;
	    }
	    
	    turtleCoinShinning_isAni = true;
	    turtleCoinShinning_aniTimer = 0;
	    turtleCoinShinningAngle = 0;
	}
	       
	public void  setTurtleCoinAni()
	{
	    if(turtleCoinAniStruct.isAni){
	        return;
	    }
	    
	    turtleCoinAniStruct.aniTimer = 0;
	    turtleCoinAniStruct.isAni = true;
	}
	
	public void  getOneTurtleDefeat()
	{
	    this.gainCoin(1);
	}

}
