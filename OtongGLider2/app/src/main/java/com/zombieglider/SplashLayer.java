package com.zombieglider;

import org.cocos2d.actions.base.CCFiniteTimeAction;
import org.cocos2d.actions.instant.CCCallFunc;
import org.cocos2d.actions.interval.CCDelayTime;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.CGSize;
import org.cocos2d.types.ccColor3B;

import com.zombieglider.Begin.CoverScene;
import com.zombieglider.ScoreShown.ScoreShownScene;
import com.zombieglider.SelectMinigame.SelectMiniGameScene2;

public class SplashLayer extends CCLayer
{
	static CCScene scene()
	{
		CCScene scene = CCScene.node();
		CCLayer layer = new SplashLayer();
		scene.addChild(layer);
		return scene;
	}
	
	// on "init" you need to initialize your instance
	SplashLayer()
	{
	    //////////////////////////////
	    // 1. super init first
	    super();

	    CGSize s;
	    
	    CGSize visibleSize = CCDirector.sharedDirector().winSize();
	    	
	    // add "SplashLayer" splash screen"

	    CCSprite pSprite = CCSprite.sprite(Global.getResPath("images/Cover/loading.png"));
	    pSprite.setPosition(CGPoint.ccp(visibleSize.width/2, visibleSize.height/2));
	    pSprite.setScale(1.0f/Global.g_Scale);
	    addChild(pSprite, 1);
	    
		CCCallFunc f = CCCallFunc.action(this,"goStartLayer");
		CCFiniteTimeAction seq = CCSequence.actions(CCDelayTime.action(2.0f),f);
		pSprite.runAction(seq);
	}
	
	public void goStartLayer()
	{
		Global.initSound();
		CCFadeTransition f = CCFadeTransition.transition( 2.0f,CoverScene.scene(),ccColor3B.ccc3(255,255,255) );
		//CCFadeTransition f = CCFadeTransition.transition( 2.0f,ScoreShownScene.scene(),ccColor3B.ccc3(255,255,255) );
		CCDirector.sharedDirector().replaceScene(f);
		
		//Global.currentChosenMiniGame = 13;
		//CCDirector.sharedDirector().replaceScene(PlayScene.scene());
	}
}