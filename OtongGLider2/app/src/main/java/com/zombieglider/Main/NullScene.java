package com.zombieglider.Main;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;

import com.zombieglider.Global;
//
//  NullScene.m
//  TurtlesHuh
//
//  Created by  on 2012/6/3.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//

//ByRCH#import "NullScene.h"
//ByRCH#import "PlayScene.h"
//ByRCH#import "Global.h"

public class NullScene extends CCLayer
{
    int nextSceneTimer;

	
	public static CCScene    scene()
	{
		// 'scene' is an autorelease object.
		CCScene  scene = CCScene.node();
		
		// 'layer' is an autorelease object.
		NullScene  layer = new NullScene();
		
		// add layer as a child to scene
		scene.addChild( layer);
		
		// return the scene
		return scene;
	}
	
	// on "init" you need to initialize your instance
	NullScene()
	{
		// always call "super" init
		// Apple recommends to re-assign "this" with the "super" return value
		super();
	    
        if(Global.goToNullWithNewPlayMusic){
        	Global.goToNullWithNewPlayMusic = false;
        }else{
        	Global.returnBackToSameMusic = true;
        }
        
        nextSceneTimer = 0;
        this.schedule("gameStep");
     
	}
	
	public void  gameStep( float  dt)
	{
	    nextSceneTimer++;
	    if(nextSceneTimer == 30){
	        CCDirector.sharedDirector().replaceScene( PlayScene.scene());
	    }
	}
}
