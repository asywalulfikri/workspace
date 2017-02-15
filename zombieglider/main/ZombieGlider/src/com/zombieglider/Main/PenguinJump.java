package com.zombieglider.Main;


import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.types.CGPoint;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;

import com.zombieglider.Global;
//
//  PenguinJump.m
//  TurtlesHuh
//
//  Created by  on 2012/5/21.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//
import com.zombieglider.Main.Mini.MiniBasic;

//ByRCH#import "PenguinJump.h"
//ByRCH#import "GamePlayGlobal.h"
//ByRCH#import "Penguin.h"

public class PenguinJump extends CCNode
{
    Penguin penguin;
    Turtle turtle[] = new Turtle[15];
    
    int howmanyTurtleShells;
    int idx;
    
    MiniBasic delegate;
    
    int shellDisplayX;
    int shellOffsetX;
    int shellPosStartX;
    int shellPosX;
    int shellPosY;
    
    boolean isClickingRight;

	
	public void  setDelegate( MiniBasic _delegate)
	{
	    delegate = _delegate;
	}
	
	PenguinJump()
	{
		// always call "super" init
		// Apple recommends to re-assign "this" with the "super" return value
		super();
	    Global.ss_Character  = CCSprite.sprite("whole_turtle.png");
        this.addChild(Global.ss_Character,Global.kDeapth_ssCharacter);
	}
	
	public void  initShellPos()
	{
	    shellPosX = 100;
	    shellPosStartX = shellPosX;
	    shellDisplayX = shellPosX;
	    shellPosY = 70;
	    shellOffsetX = 76;
	    
	    Global.penguinJumpFinalX = shellPosX;
	    Global.penguinJumpFinalY = shellPosY;
	}
	
	public void  initCharacters()
	{
		Global.wholeTurtleScaleFromSocurce = 0.435f;
		Global.wholePenguinScaleFromSocurce = 0.5f;
	    
	    for(int i = 0 ; i < howmanyTurtleShells ; i++){
	        turtle[i] = new Turtle();
	        turtle[i].setX(10000);
	        turtle[i].setY(10000);
	        turtle[i].setStatus(Global.kTurtleAniStatus_Normal_In);
	        turtle[i].setIdNumber(i);
	       // turtle[i].setDelegate(this);
	    }
	    
	    penguin = new Penguin();
	    penguin.setX(shellPosX);
	    penguin.setY(shellPosY);
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	   // penguin.setDelegate(this);
	}
	
	
	public void  initMenu()
	{
	    CCMenuItem  mLeft = CCMenuItemImage.item("penguinJump_btn_left_Off.png","penguinJump_btn_left_On.png",this,"mLeftCallback");
	    
		CCMenuItem  mRight = CCMenuItemImage.item("penguinJump_btn_left_Off.png","penguinJump_btn_left_On.png",this,"mRightCallback");
		
	    mLeft.setScaleX(-1);
		
		mLeft.setPosition(CGPoint.ccp(-200, -125));
	    mRight.setPosition(CGPoint.ccp(200, -125));
	    
		CCMenu  menu = CCMenu.menu(mRight,mLeft);
		this.addChild(menu);
	}
	
	public void  setHowmanyTurtlesAndInit( int _howmanyTurtles)
	{
	    howmanyTurtleShells = _howmanyTurtles;
	    this.initMenu();
	    this.initShellPos();
	    this.initCharacters();
	    this.setShellsToFinalPosition();
	}
	
	public void  mLeftCallback(Object sender)
	{
	    idx--;
	    if(idx < 0){
	        idx = 0;
	    }
	    
	    isClickingRight = false;
	    
	    this.update();
	}
	
	public void  mRightCallback(Object sender)
	{
	    idx++;
	    if(idx >= howmanyTurtleShells){
	        idx = howmanyTurtleShells - 1;
	    }
	    
	    isClickingRight = true;
	    
	    this.update();
	}
	
	public void  update()
	{
	    if(isClickingRight){
	        penguin.setJump(Penguin.kPenguinJump_jumpTo1TurtleShell);
	        penguin.setFacingRight(true);
	    }else{
	        penguin.setJump(Penguin.kPenguinJump_jumpTo1TurtleShell);
	        penguin.setFacingRight(false);
	    }
	    
	    this.setShellsToFinalPosition();
	    
	    shellPosX = shellPosStartX - shellOffsetX * idx;
	    
	    //TEMP//delegate.hasTappedThisIdx(idx);
	}
	
	public void  setShellsToFinalPosition()
	{
	    for(int i = 0 ; i < howmanyTurtleShells ; i++){
	        turtle[i].setX(shellPosX + shellOffsetX * i);
	        turtle[i].setY(shellPosY);
	    }
	}
	
	public void  manage( float  dt)
	{
	    if(shellPosX - shellDisplayX > 5){
	        shellDisplayX += 8;
	        if(shellDisplayX > shellPosX){
	            shellDisplayX = shellPosX;
	        }
	    }
	    if(shellDisplayX - shellPosX > 5){
	        shellDisplayX -= 8;
	        if(shellDisplayX < shellPosX){
	            shellDisplayX = shellPosX;
	        }
	    }
	    
	    for(int i = 0 ; i < howmanyTurtleShells ; i++){
	        turtle[i].setX(shellDisplayX + shellOffsetX * i);
	        turtle[i].setY(shellPosY);
	        turtle[i].manage(dt);
	    }
	    
	    penguin.manage();
	    
	}


}
