package com.zombieglider.Main;


import org.cocos2d.layers.CCLayer;
import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
//ByRCH#import "ControlLayer.h"
//ByRCH#import "GamePlayGlobal.h"
//ByRCH#import "Global.h"
import com.zombieglider.Main.Mini.MiniBasic;


class eBtnControlValue
{
	public boolean isApplyingGroup1_1;
	public boolean isApplyingGroup1_2;
	public boolean isApplyingGroup1_3;
	public boolean isApplyingGroup1_4;
}


public class ControlLayer extends CCLayer
{
	//typedef enum{
	static final int kControlBtnClick_Group1_1 = 0;
	static final int kControlBtnClick_Group1_2 = 1;
	static final int kControlBtnClick_Group1_3 = 2;
	static final int kControlBtnClick_Group1_4 = 3;
	static final int kControlBtnClick_Nth = 4;
	//}eControlBtnClick;

	
    CCSprite s_group1_1;
    CCSprite s_group1_2;
    CCSprite s_group1_3;
    CCSprite s_group1_4;
    
    CGRect	s_group1_1_rect[] = new CGRect[2];
	CGRect	s_group1_2_rect[] = new CGRect[2];
    CGRect	s_group1_3_rect[] = new CGRect[2];
    CGRect	s_group1_4_rect[] = new CGRect[2];
    
    boolean isClickingGroup1_1;
    boolean isClickingGroup1_2;
    boolean isClickingGroup1_3;
    boolean isClickingGroup1_4;
    
    int controlBtnClick;
	int controlBtnClick2;
    
    CGPoint locationPrev1;
	CGPoint locationPrev2;
	int touch1;
	int touch2;
    
    int detect_group1Left[] = new int[4];
    int detect_group1Right[] = new int[4];
    int detect_group1Up[] = new int[4];
    int detect_group1Down[] = new int[4];
    int detect_group1GeneralUp;
    
    MiniBasic delegate;
    
    int fingerHolding;
    
    
    boolean MAIN_isChangingBtn;
    int MAIN_changingBtnTimer;
    boolean MAIN_hasChangedBtn;
    float MAIN_decreaseY;
    float MAIN_increaseY;

    eBtnControlValue btnControlValue;
    
    int btnOffsetX;
    int btnStartX;
    int btnStartY;
    
    boolean hasMovingOutside;
    boolean hasCollide;
    
	public void  setDelegate( MiniBasic  _delegate)
	{
	    delegate = _delegate;
	}
	
	public void  initDetectPos()
	{
	    if(Global.isPlayingMiniGame){
	        if(Global.currentChosenMiniGame == 102){
	            detect_group1GeneralUp = 110;
	            detect_group1Left[0] = 0;
	            detect_group1Right[0] = 84;
	            detect_group1Left[1] = 84000;
	            detect_group1Right[1] = 175000;
	            detect_group1Left[2] = 30000;
	            detect_group1Right[2] = 39600;
	            detect_group1Left[3] = 396;
	            detect_group1Right[3] = 482;
	            
	            if(Global.isIphone5){
	                detect_group1Left[3] += 88;
	                detect_group1Right[3] += 88;
	            }
	        }
	        
	        if(Global.currentChosenMiniGame == 4 || Global.currentChosenMiniGame == 10){
	            detect_group1GeneralUp = 110;
	            detect_group1Left[0] = 0;
	            detect_group1Right[0] = 84;
	            detect_group1Left[1] = 84;
	            detect_group1Right[1] = 175;
	            detect_group1Left[2] = 300;
	            detect_group1Right[2] = 396;
	            detect_group1Left[3] = 396;
	            detect_group1Right[3] = 482;
	            
	            if(Global.isIphone5){
	                detect_group1Left[2] += 88;
	                detect_group1Right[2] += 88;
	                detect_group1Left[3] += 88;
	                detect_group1Right[3] += 88;
	            }
	        }
	        
	        if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
	            detect_group1GeneralUp = 90;
	            detect_group1Left[0] = 0;
	            detect_group1Right[0] = 84;
	            detect_group1Left[1] = 8400;
	            detect_group1Right[1] = 175;
	            detect_group1Left[2] = 30000;
	            detect_group1Right[2] = 396;
	            detect_group1Left[3] = 396;
	            detect_group1Right[3] = 482;
	            
	            if(Global.isIphone5){
	                detect_group1Left[3] += 88;
	                detect_group1Right[3] += 88;
	            }
	        }
	        
	        if(Global.currentChosenMiniGame == 13){
	            detect_group1GeneralUp = 130;
	            detect_group1Left[0] = 99999;
	            detect_group1Right[0] = 84;
	            detect_group1Left[1] = 0;
	            detect_group1Right[1] = 100;
	            detect_group1Left[2] = 380;
	            detect_group1Right[2] = 482;
	            detect_group1Left[3] = 999999;
	            detect_group1Right[3] = 75;
	            
	            if(Global.isIphone5){
	                detect_group1Left[2] += 88;
	                detect_group1Right[2] += 88;
	            }
	        }
	        
	        if(Global.currentChosenMiniGame == 5){
	            detect_group1GeneralUp = 84;
	            detect_group1Left[0] = 189;
	            detect_group1Right[0] = 267;
	            detect_group1Left[1] = 267;
	            detect_group1Right[1] = 344;
	            detect_group1Left[2] = 344;
	            detect_group1Right[2] = 421;
	            detect_group1Left[3] = 421;
	            detect_group1Right[3] = 481;
	            
	            if(Global.isIphone5){
	                detect_group1Left[0] += 88;
	                detect_group1Right[0] += 88;
	                detect_group1Left[1] += 88;
	                detect_group1Right[1] += 88;
	                detect_group1Left[2] += 88;
	                detect_group1Right[2] += 88;
	                detect_group1Left[3] += 88;
	                detect_group1Right[3] += 88;
	            }
	        }
	        
	    }else{
	        detect_group1GeneralUp = 130;
	        detect_group1Left[0] = 380;
	        detect_group1Right[0] = 482;
	        detect_group1Left[1] = 999999;
	        detect_group1Right[1] = 84;
	        detect_group1Left[2] = 999999;
	        detect_group1Right[2] = 482;
	        detect_group1Left[3] = 999999;
	        detect_group1Right[3] = 75;
	        
	        if(Global.isIphone5){
	            detect_group1Left[0] += 88;
	            detect_group1Right[0] += 88;
	            detect_group1Left[1] += 88;
	            detect_group1Right[1] += 88;
	            detect_group1Left[2] += 88;
	            detect_group1Right[2] += 88;
	            detect_group1Left[3] += 88;
	            detect_group1Right[3] += 88;
	        }
	    }
	    
	}
	
	public void  MAIN_manageChanging()
	{
	    if(MAIN_isChangingBtn){
	        
	        MAIN_decreaseY += (-120 - MAIN_decreaseY)/5.0;
	        MAIN_increaseY += (38 - MAIN_increaseY)/5.0;
	        
	        s_group1_1.setPosition(CGPoint.ccp(s_group1_1.getPosition().x, MAIN_decreaseY));
	        
	      //  s_group1_2.setPosition(CGPoint.ccp(s_group1_2.getPosition().x, MAIN_increaseY));
	        s_group1_3.setPosition(CGPoint.ccp(s_group1_3.getPosition().x, MAIN_increaseY));
	        
	        MAIN_changingBtnTimer++;
	        if(MAIN_changingBtnTimer == 50){
	            
	            s_group1_1.setPosition(CGPoint.ccp(s_group1_1.getPosition().x, -9999));
	            
	            //s_group1_2.setPosition(CGPoint.ccp(s_group1_2.getPosition().x, 38));
	            s_group1_3.setPosition(CGPoint.ccp(s_group1_3.getPosition().x, 38));
	
	            
	            MAIN_isChangingBtn = false;
	           // this.MAIN_setHasChangedBtn();
	        }
	    }
	}
	
	public void  MAIN_setChangingBtn()
	{
	    MAIN_changingBtnTimer = 0;
	    MAIN_isChangingBtn = true;
	    
	    MAIN_decreaseY = s_group1_1.getPosition().y;
	    MAIN_increaseY = s_group1_2.getPosition().y;
	    
	    this.MAIN_setHasChangedBtn();
	}
	
	public void  MAIN_setHasChangedBtn()
	{
	    MAIN_hasChangedBtn = true;
	    
	    detect_group1Left[0] = 9999999;
	    detect_group1Right[0] = 84;
	    detect_group1Left[1] = 0;
	    detect_group1Right[1] = 84;
	    detect_group1Left[2] = 380;
	    detect_group1Right[2] = 482;
	    
	    if(Global.isIphone5){
	        detect_group1Left[2] = 380 + 88;
	        detect_group1Right[2] = 482 + 88;
	    }
	    
	    //DELETE
	    detect_group1Left[1] = 0;
	    detect_group1Right[1] = 84;
	    detect_group1Left[3] = 84;
	    detect_group1Right[3] = 170;
	}
	
	public ControlLayer()
	{
		super();
		
		controlBtnClick = kControlBtnClick_Nth;
	    
	    MAIN_isChangingBtn = false;
	    MAIN_hasChangedBtn = false;
	    
		setIsTouchEnabled(true);
	    
		btnControlValue = new eBtnControlValue();
	    
		btnControlValue.isApplyingGroup1_1 = false;
		btnControlValue.isApplyingGroup1_2 = false;
		btnControlValue.isApplyingGroup1_3 = false;
		btnControlValue.isApplyingGroup1_4 = false;
	    
		
		isClickingGroup1_1 = false;
		isClickingGroup1_2 = false;
		isClickingGroup1_3 = false;
		isClickingGroup1_4 = false;
	    
		
		locationPrev1 = CGPoint.ccp(1000,1000);
		locationPrev2 = CGPoint.ccp(1000,1000);
		
		this.initControl();
	    this.initDetectPos();
		
	    if ( Global.ss_Extra != null )
	    {
	    	Global.ss_Extra.setAnchorPoint(0,0);
		    Global.ss_Extra.setOpacity(0);	
	    }
	}
	
	public void  initControl()
	{
	    if(!Global.isPlayingMiniGame){
	        
	        s_group1_1_rect[1] = CGRect.make(1264/2*Global.g_Scale,1614/2*Global.g_Scale,138/2*Global.g_Scale,128/2*Global.g_Scale);
	        s_group1_2_rect[0] = CGRect.make(1666/2*Global.g_Scale - 1112/2*Global.g_Scale,0/2*Global.g_Scale,138/2*Global.g_Scale,128/2*Global.g_Scale);
	        s_group1_3_rect[0] = CGRect.make(1666/2*Global.g_Scale - 1112/2*Global.g_Scale,0/2*Global.g_Scale,138/2*Global.g_Scale,128/2*Global.g_Scale);
	        s_group1_4_rect[0] = CGRect.make(0/2,0/2,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        
	        s_group1_1_rect[0] = CGRect.make(1114/2*Global.g_Scale,1614/2*Global.g_Scale,138/2*Global.g_Scale,128/2*Global.g_Scale);
	        s_group1_2_rect[1] = CGRect.make(1806/2*Global.g_Scale - 1112/2*Global.g_Scale,0/2*Global.g_Scale,138/2*Global.g_Scale,128/2*Global.g_Scale);
	        s_group1_3_rect[1] = CGRect.make(1806/2*Global.g_Scale - 1112/2*Global.g_Scale,0/2*Global.g_Scale,138/2*Global.g_Scale,128/2*Global.g_Scale);
	        s_group1_4_rect[1] = CGRect.make(0/2*Global.g_Scale,1920/2*Global.g_Scale,138/2*Global.g_Scale,138/2*Global.g_Scale);
	        
	        s_group1_1 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_1_rect[0]);
	        s_group1_2 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_2_rect[0]);
	        s_group1_3 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_3_rect[0]);
	        s_group1_4 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_4_rect[0]);
	        
	        Global.ss_Character.addChild(s_group1_1,Global.kDeapth_Btns);
	        Global.ss_Character.addChild(s_group1_2,Global.kDeapth_Btns);
	        Global.ss_Character.addChild(s_group1_3,Global.kDeapth_Btns);
	        Global.ss_Character.addChild(s_group1_4,Global.kDeapth_Btns);
	        
	        s_group1_1.setPosition(CGPoint.ccp(432, 38));
	        s_group1_2.setPosition(CGPoint.ccp(48, -120));
	        s_group1_3.setPosition(CGPoint.ccp(432, -120));
	        s_group1_4.setPosition(CGPoint.ccp(99999, 38));
	        
	        if(Global.isIphone5){
	            s_group1_1.setPosition(CGPoint.ccp(432 + 88, 38));
	            s_group1_2.setPosition(CGPoint.ccp(48 + 88, -120));
	            s_group1_3.setPosition(CGPoint.ccp(432 + 88, -120));
	        }
	        
	        
	        return;
	    }
	    
	    if(Global.currentChosenMiniGame == 102){
	        s_group1_1_rect[0] = CGRect.make(152/2,0/2,149/2,121/2);
	        s_group1_4_rect[0] = CGRect.make(152/2,0/2,149/2,121/2);
	        s_group1_3_rect[0] = CGRect.make(152/2,0/2,149/2,121/2);
	        s_group1_2_rect[0] = CGRect.make(0/2, 0/2, 0/2, 0/2);
	        
	        s_group1_1_rect[1] = CGRect.make(152/2 + 340/2,0/2,149/2,121/2);
	        s_group1_4_rect[1] = CGRect.make(152/2 + 340/2,0/2,149/2,121/2);
	        s_group1_3_rect[1] = CGRect.make(152/2 + 340/2,0/2,149/2,121/2);
	        s_group1_2_rect[1] = CGRect.make(0/2 + 0/2, 0/2, 0/2, 0/2);
	        
	        s_group1_1 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_1_rect[0]);
	        s_group1_2 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_2_rect[0]);
	        s_group1_3 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_3_rect[0]);
	        s_group1_4 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_4_rect[0]);
	        
	        Global.ss_Extra.addChild(s_group1_1,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_2,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_3,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_4,Global.kDeapth_Btns);
	        
	        s_group1_1.setScaleX(-1);
	    }
	    
	    
	    if(Global.currentChosenMiniGame == 13){
	        s_group1_1_rect[0] = CGRect.make(0/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_2_rect[0] = CGRect.make(0/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_3_rect[0] = CGRect.make(152/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_4_rect[0] = CGRect.make(99999/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        
	        s_group1_4_rect[1] = CGRect.make(99999/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_3_rect[1] = CGRect.make(152/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_2_rect[1] = CGRect.make(0/2 + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_1_rect[1] = CGRect.make(0/2 + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        
	        s_group1_1 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_1_rect[0]);
	        s_group1_2 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_2_rect[0]);
	        s_group1_3 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_3_rect[0]);
	        s_group1_4 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_4_rect[0]);
	        
	        Global.ss_Extra.addChild(s_group1_1,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_2,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_3,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_4,Global.kDeapth_Btns);
	        
	        s_group1_1.setScaleX(-1);
	        
	    }
	    
	    if(Global.currentChosenMiniGame == 4 || Global.currentChosenMiniGame == 10){
	        s_group1_1_rect[0] = CGRect.make(0/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_2_rect[0] = CGRect.make(152/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_3_rect[0] = CGRect.make(152/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_4_rect[0] = CGRect.make(0/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        
	        s_group1_4_rect[1] = CGRect.make(0/2 *Global.g_Scale+ 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_3_rect[1] = CGRect.make(152/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_2_rect[1] = CGRect.make(152/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_1_rect[1] = CGRect.make(0/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        
	        s_group1_1 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_1_rect[0]);
	        s_group1_2 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_2_rect[0]);
	        s_group1_3 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_3_rect[0]);
	        s_group1_4 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_4_rect[0]);
	        
	        Global.ss_Extra.addChild(s_group1_1,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_2,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_3,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_4,Global.kDeapth_Btns);
	        
	        s_group1_1.setScaleX(-1);
	        s_group1_2.setScaleX(-1);
	    }
	    
	    if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
	        s_group1_1_rect[0] = CGRect.make(152/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_2_rect[0] = CGRect.make(152/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_3_rect[0] = CGRect.make(152/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_4_rect[0] = CGRect.make(152/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        
	        s_group1_4_rect[1] = CGRect.make(152/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_3_rect[1] = CGRect.make(152/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_2_rect[1] = CGRect.make(152/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        s_group1_1_rect[1] = CGRect.make(152/2*Global.g_Scale + 340/2*Global.g_Scale,0/2*Global.g_Scale,149/2*Global.g_Scale,121/2*Global.g_Scale);
	        
	        s_group1_1 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_1_rect[0]);
	        s_group1_2 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_2_rect[0]);
	        s_group1_3 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_3_rect[0]);
	        s_group1_4 = CCSprite.sprite(Global.ss_Extra.getTexture(),s_group1_4_rect[0]);
	        
	        Global.ss_Extra.addChild(s_group1_1,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_2,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_3,Global.kDeapth_Btns);
	        Global.ss_Extra.addChild(s_group1_4,Global.kDeapth_Btns);
	        
	        s_group1_1.setScaleX(-1);
	        s_group1_2.setScaleX(-1);
	    }
	    
	    if(Global.currentChosenMiniGame == 5){
	        s_group1_1_rect[0] = CGRect.make(0/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        s_group1_2_rect[0] = CGRect.make(138/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        s_group1_3_rect[0] = CGRect.make(278/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        s_group1_4_rect[0] = CGRect.make(418/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        
	        s_group1_1_rect[1] = CGRect.make(0/2*Global.g_Scale + 556/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        s_group1_2_rect[1] = CGRect.make(138/2*Global.g_Scale + 556/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        s_group1_3_rect[1] = CGRect.make(278/2*Global.g_Scale + 556/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        s_group1_4_rect[1] = CGRect.make(418/2*Global.g_Scale + 556/2*Global.g_Scale, 834/2*Global.g_Scale, 136/2*Global.g_Scale, 128/2*Global.g_Scale);
	        
	        s_group1_1 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_1_rect[0]);
	        s_group1_2 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_2_rect[0]);
	        s_group1_3 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_3_rect[0]);
	        s_group1_4 = CCSprite.sprite(Global.ss_Character.getTexture(),s_group1_4_rect[0]);
	        
	        Global.ss_Character.addChild(s_group1_1,Global.kDeapth_Btns);
	        Global.ss_Character.addChild(s_group1_2,Global.kDeapth_Btns);
	        Global.ss_Character.addChild(s_group1_3,Global.kDeapth_Btns);
	        Global.ss_Character.addChild(s_group1_4,Global.kDeapth_Btns);
	    }
		
	    s_group1_1.setScaleX( s_group1_1.getScaleX()/Global.g_Scale );
        s_group1_2.setScaleX( s_group1_2.getScaleX()/Global.g_Scale );
        s_group1_3.setScaleX( s_group1_3.getScaleX()/Global.g_Scale );
        s_group1_4.setScaleX( s_group1_4.getScaleX()/Global.g_Scale );
        
        s_group1_1.setScaleY( s_group1_1.getScaleY()/Global.g_Scale );
        s_group1_2.setScaleY( s_group1_2.getScaleY()/Global.g_Scale );
        s_group1_3.setScaleY( s_group1_3.getScaleY()/Global.g_Scale );
        s_group1_4.setScaleY( s_group1_4.getScaleY()/Global.g_Scale );
	    
	    if(Global.currentChosenMiniGame == 102){
	        s_group1_1.setPosition(CGPoint.ccp(48, 38));
	        s_group1_2.setPosition(CGPoint.ccp(135, 38));
	        s_group1_3.setPosition(CGPoint.ccp(34005, 38));
	        s_group1_4.setPosition(CGPoint.ccp(432, 38));
	    }
	    if(Global.currentChosenMiniGame == 13){
	        s_group1_1.setPosition(CGPoint.ccp(48999, 38));
	        s_group1_2.setPosition(CGPoint.ccp(48, 38));
	        s_group1_3.setPosition(CGPoint.ccp(432, 38));
	        s_group1_4.setPosition(CGPoint.ccp(99999, 38));
	        
	        if(Global.isIphone5){
	            s_group1_3.setPosition(CGPoint.ccp(432 + 88, 38));
	        }
	    }
	    if(Global.currentChosenMiniGame == 4){
	        s_group1_1.setPosition(CGPoint.ccp(48, 38));
	        s_group1_2.setPosition(CGPoint.ccp(135, 38));
	        s_group1_3.setPosition(CGPoint.ccp(345, 38));
	        s_group1_4.setPosition(CGPoint.ccp(432, 38));
	        
	        if(Global.isIphone5){
	            s_group1_3.setPosition(CGPoint.ccp(345 + 88, 38));
	            s_group1_4.setPosition(CGPoint.ccp(432 + 88, 38));
	        }
	        
	    }
	    if(Global.currentChosenMiniGame == 10){
	        s_group1_1.setPosition(CGPoint.ccp(48, 35));
	        s_group1_2.setPosition(CGPoint.ccp(135, 35));
	        s_group1_3.setPosition(CGPoint.ccp(345, 35));
	        s_group1_4.setPosition(CGPoint.ccp(432, 35));
	        
	        if(Global.isIphone5){
	            s_group1_3.setPosition(CGPoint.ccp(345 + 88, 38));
	            s_group1_4.setPosition(CGPoint.ccp(432 + 88, 38));
	        }
	        
	    }
	    if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
	        s_group1_1.setPosition(CGPoint.ccp(48, 38));
	        s_group1_2.setPosition(CGPoint.ccp(13500, 38));
	        s_group1_3.setPosition(CGPoint.ccp(34500, 38));
	        s_group1_4.setPosition(CGPoint.ccp(432, 38));
	        
	        if(Global.isIphone5){
	            s_group1_4.setPosition(CGPoint.ccp(432 + 88, 38));
	        }
	
	    }
	    
		if(Global.currentChosenMiniGame == 5){
	        btnOffsetX = 70;
	        btnStartX = 199 + 136/4;
	        btnStartY = 69 - 126/4;
	        
	        if(Global.isIphone5){
	            btnStartX += 88;
	        }
	        
	        s_group1_1.setPosition(CGPoint.ccp(btnStartX + btnOffsetX * 0, btnStartY));
	        s_group1_2.setPosition(CGPoint.ccp(btnStartX + btnOffsetX * 1, btnStartY));
	        s_group1_3.setPosition(CGPoint.ccp(btnStartX + btnOffsetX * 2, btnStartY));
	        s_group1_4.setPosition(CGPoint.ccp(btnStartX + btnOffsetX * 3, btnStartY));
	        
	    }
		
		
	}
	
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    if(Global.currentChosenMiniGame == 13 || !Global.isPlayingMiniGame){
	        isClickingGroup1_1 = false;
	        isClickingGroup1_2 = false;
	        isClickingGroup1_3 = false;
	        isClickingGroup1_4 = false;
	    }
	    
	    if(Global.currentChosenMiniGame == 13){
	        
	    }else{
	        if(Global.isPlayingMiniGame){
	            if(Global.isTapWronglyAndDisableBtns){
	                return true;
	            }
	        }
	    }
	    
	    
	    if(Global.isFuckingShootFirstTime){
	    	Global.isFuckingShootFirstTime = false;
	        return true;
	    }
	    
	    for( int i = 0; i < event.getPointerCount(); i++ ) {
			CGPoint location = CGPoint.ccp( event.getX(i),event.getY(i) );
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        if(location.y < detect_group1GeneralUp){
	            if(location.x > detect_group1Left[0] && location.x < detect_group1Right[0]){
	                
	                if(isClickingGroup1_2 || isClickingGroup1_3 || isClickingGroup1_4){

	                }else{
	                    if(controlBtnClick == kControlBtnClick_Nth){
	                        touch1 = i;
	                        locationPrev1 = location;
	                        this.group1_1BtnClick();
	                    }else{
	                        touch2 = i;
	                        locationPrev2 = location;
	                        this.group1_1BtnClick2();
	                    }
	                }
	                
	                
	            }
	            
	            
	            if(location.x > detect_group1Left[1] && location.x < detect_group1Right[1]){
	                
	                if(isClickingGroup1_1 || isClickingGroup1_3 || isClickingGroup1_4){

	                }else{
	                    if(controlBtnClick == kControlBtnClick_Nth){
	                        touch1 = i;
	                        locationPrev1 = location;
	                        this.group1_2BtnClick();
	                    }else{
	                        touch2 = i;
	                        locationPrev2 = location;
	                        this.group1_2BtnClick2();
	                    }
	                }   
	                
	                
	            }
	            
	            
	            if(location.x > detect_group1Left[2] && location.x < detect_group1Right[2]){
	                
	                if(isClickingGroup1_1 || isClickingGroup1_2 || isClickingGroup1_4){

	                }else{
	                    if(controlBtnClick == kControlBtnClick_Nth){
	                        touch1 = i;
	                        locationPrev1 = location;
	                        this.group1_3BtnClick();
	                    }else{
	                        touch2 = i;
	                        locationPrev2 = location;
	                        this.group1_3BtnClick2();
	                    }
	                }
	                
	                
	            }
	            
	            if(location.x > detect_group1Left[3] && location.x < detect_group1Right[3]){
	                
	                if(isClickingGroup1_1 || isClickingGroup1_2 || isClickingGroup1_3){

	                }else{
	                    if(controlBtnClick == kControlBtnClick_Nth){
	                        touch1 = i;
	                        locationPrev1 = location;
	                        this.group1_4BtnClick();
	                    }else{
	                        touch2 = i;
	                        locationPrev2 = location;
	                        this.group1_4BtnClick2();
	                    }
	                }
	                
	                
	            }
	            
	        }
	        
	        
	    }
		return true;
	}
	
	
	public  boolean ccTouchesMoved( MotionEvent event)
	{
	    
		hasMovingOutside = false;
	    
	    for( int i = 0; i < event.getPointerCount(); i++ ) {
			CGPoint location = CGPoint.ccp( event.getX(i),event.getY(i) );
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        if(i == touch1){
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[0] || location.x >= detect_group1Right[0]){
	                if(locationPrev1.y < detect_group1GeneralUp){
	                    if(locationPrev1.x > detect_group1Left[0] && locationPrev1.x < detect_group1Right[0]){
	                        this.group1_1BtnRelease();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[1] || location.x >= detect_group1Right[1]){
	                if(locationPrev1.y < detect_group1GeneralUp){
	                    if(locationPrev1.x > detect_group1Left[1] && locationPrev1.x < detect_group1Right[1]){
	                        this.group1_2BtnRelease();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[2] || location.x >= detect_group1Right[2]){
	                if(locationPrev1.y < detect_group1GeneralUp){
	                    if(locationPrev1.x > detect_group1Left[2] && locationPrev1.x < detect_group1Right[2]){
	                        this.group1_3BtnRelease();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[3] || location.x >= detect_group1Right[3]){
	                if(locationPrev1.y < detect_group1GeneralUp){
	                    if(locationPrev1.x > detect_group1Left[3] && locationPrev1.x < detect_group1Right[3]){
	                        this.group1_4BtnRelease();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            
	            if(hasMovingOutside && !Global.isPlayingMiniGame){
	                if(location.y < detect_group1GeneralUp){
	                    if(location.x > detect_group1Left[0] && location.x < detect_group1Right[0]){
	                        locationPrev1 = location;
	                        this.group1_1BtnClick();
	                    }
	                    
	                    if(location.x > detect_group1Left[1] && location.x < detect_group1Right[1]){
	                        locationPrev1 = location;
	                        this.group1_2BtnClick();
	                    }
	                    
	                    if(location.x > detect_group1Left[2] && location.x < detect_group1Right[2]){
	                        locationPrev1 = location;
	                        this.group1_3BtnClick();
	                    }
	                    
	                    if(location.x > detect_group1Left[3] && location.x < detect_group1Right[3]){
	                        locationPrev1 = location;
	                        this.group1_4BtnClick();
	                    }
	                }
	            }
	
	        }// end if touch == touch1
	        
	        hasMovingOutside = false;
	        
	        if(i == touch2){
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[0] || location.x >= detect_group1Right[0]){
	                if(locationPrev2.y < detect_group1GeneralUp){
	                    if(locationPrev2.x > detect_group1Left[0] && locationPrev2.x < detect_group1Right[0]){
	                        this.group1_1BtnRelease2();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[1] || location.x >= detect_group1Right[1]){
	                if(locationPrev2.y < detect_group1GeneralUp){
	                    if(locationPrev2.x > detect_group1Left[1] && locationPrev2.x < detect_group1Right[1]){
	                        this.group1_2BtnRelease2();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[2] || location.x >= detect_group1Right[2]){
	                if(locationPrev2.y < detect_group1GeneralUp){
	                    if(locationPrev2.x > detect_group1Left[2] && locationPrev2.x < detect_group1Right[2]){
	                        this.group1_3BtnRelease2();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            if(location.y >= detect_group1GeneralUp || location.x <= detect_group1Left[3] || location.x >= detect_group1Right[3]){
	                if(locationPrev2.y < detect_group1GeneralUp){
	                    if(locationPrev2.x > detect_group1Left[3] && locationPrev2.x < detect_group1Right[3]){
	                        this.group1_4BtnRelease2();
	                        hasMovingOutside = true;
	                    }
	                }
	            }
	            
	            
	            if(hasMovingOutside && !Global.isPlayingMiniGame){
	                if(location.y < detect_group1GeneralUp){
	                    if(location.x > detect_group1Left[0] && location.x < detect_group1Right[0]){
	                        locationPrev2 = location;
	                        this.group1_1BtnClick2();
	                    }
	                    
	                    if(location.x > detect_group1Left[1] && location.x < detect_group1Right[1]){
	                        locationPrev2 = location;
	                        this.group1_2BtnClick2();
	                    }
	                    
	                    if(location.x > detect_group1Left[2] && location.x < detect_group1Right[2]){
	                        locationPrev2 = location;
	                        this.group1_3BtnClick2();
	                    }
	                    
	                    if(location.x > detect_group1Left[3] && location.x < detect_group1Right[3]){
	                        locationPrev2 = location;
	                        this.group1_4BtnClick2();
	                    }
	                }
	            }
	        }
	    }
		return true;
	  
	}
	
	
	
	public  boolean ccTouchesEnded( MotionEvent event)
	{
	    	
		for( int i = 0; i < event.getPointerCount(); i++ ) {
			if (touch1 == i) {
	            hasCollide = false;
	            if(locationPrev1.y < detect_group1GeneralUp){
	                if(locationPrev1.x > detect_group1Left[0] && locationPrev1.x < detect_group1Right[0]){
	                    hasCollide = true;
						this.group1_1BtnRelease();
	                }
	                if(locationPrev1.x > detect_group1Left[1] && locationPrev1.x < detect_group1Right[1] && !hasCollide){
	                    hasCollide = true;
						this.group1_2BtnRelease();
	                }
	                if(locationPrev1.x > detect_group1Left[2] && locationPrev1.x < detect_group1Right[2] && !hasCollide){
	                    hasCollide = true;
						this.group1_3BtnRelease();
	                }
	                if(locationPrev1.x > detect_group1Left[3] && locationPrev1.x < detect_group1Right[3] && !hasCollide){
	                    hasCollide = true;
						this.group1_4BtnRelease();
	                }
	            }
	            
	            touch1 = -1;
	            
	        }
	        
	        if (touch2 == i) {
	            hasCollide = false;
	            if(locationPrev2.y < detect_group1GeneralUp){
	                if(locationPrev2.x > detect_group1Left[0] && locationPrev2.x < detect_group1Right[0]){
	                    hasCollide = true;
						this.group1_1BtnRelease2();
	                }
	                if(locationPrev2.x > detect_group1Left[1] && locationPrev2.x < detect_group1Right[1] && !hasCollide){
	                    hasCollide = true;
						this.group1_2BtnRelease2();
	                }
	                if(locationPrev2.x > detect_group1Left[2] && locationPrev2.x < detect_group1Right[2] && !hasCollide){
	                    hasCollide = true;
						this.group1_3BtnRelease2();
	                }
	                if(locationPrev2.x > detect_group1Left[3] && locationPrev2.x < detect_group1Right[3] && !hasCollide){
	                    hasCollide = true;
						this.group1_4BtnRelease2();
	                }
	            }
	            
	            touch2 = -1;
	            
	        }
	    }
		return true;
	}
	
	public void  clickToStop()
	{
		touch1 = -1;
		touch2 = -1;
		this.group1_1BtnRelease();
		this.group1_2BtnRelease();
		this.group1_3BtnRelease();
		this.group1_4BtnRelease();
	    
		this.group1_1BtnRelease2();
		this.group1_2BtnRelease2();
		this.group1_3BtnRelease2();
		this.group1_4BtnRelease2();
	}
	
	public void  group1_1BtnClick()
	{
		controlBtnClick = kControlBtnClick_Group1_1;
	    
	    if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
	        isClickingGroup1_1 = false;
	    }else{
	        isClickingGroup1_1 = true;
	    }
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_1 = false;
	    }
		
		s_group1_1.setTextureRect(s_group1_1_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(0);
	}
	
	public void  group1_2BtnClick()
	{
		controlBtnClick = kControlBtnClick_Group1_2;
		isClickingGroup1_2 = true;
		s_group1_2.setTextureRect(s_group1_2_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(1);
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_2 = false;
	    }
	}
	
	public void  group1_3BtnClick()
	{
		controlBtnClick = kControlBtnClick_Group1_3;
		isClickingGroup1_3 = true;
		s_group1_3.setTextureRect(s_group1_3_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(2);
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_3 = false;
	    }
	}
	
	public void  group1_4BtnClick()
	{
		controlBtnClick = kControlBtnClick_Group1_4;
	    
	    if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
	        isClickingGroup1_4 = false;
	    }else{
	        isClickingGroup1_4 = true;
	    }
	    
		s_group1_4.setTextureRect(s_group1_4_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(3);
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_4 = false;
	    }
	}
	
	
	public void  group1_1BtnClick2()
	{
		controlBtnClick2 = kControlBtnClick_Group1_1;
	    
	    if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
	        isClickingGroup1_1 = false;
	    }else{
	        isClickingGroup1_1 = true;
	    }
	    
		s_group1_1.setTextureRect(s_group1_1_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(0);
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_1 = false;
	    }
	}
	
	public void  group1_2BtnClick2()
	{
		controlBtnClick2 = kControlBtnClick_Group1_2;
		isClickingGroup1_2 = true;
		s_group1_2.setTextureRect(s_group1_2_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(1);
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_2 = false;
	    }
	}
	
	public void  group1_3BtnClick2()
	{
		controlBtnClick2 = kControlBtnClick_Group1_3;
		isClickingGroup1_3 = true;
		s_group1_3.setTextureRect(s_group1_3_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(2);
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_3 = false;
	    }
	}
	
	public void  group1_4BtnClick2()
	{
		controlBtnClick2 = kControlBtnClick_Group1_4;
	    
	    if(Global.currentChosenMiniGame == 11 || Global.currentChosenMiniGame == 7){
	        isClickingGroup1_4 = false;
	    }else{
	        isClickingGroup1_4 = true;
	    }
	    
		s_group1_4.setTextureRect(s_group1_4_rect[1]);
		fingerHolding++;
	    delegate.btnIsTappedInControlLayer(3);
	    
	    if(!Global.isPlayingMiniGame){
	        isClickingGroup1_4 = false;
	    }
	}
	
	
	public void  group1_1BtnRelease()
	{
		controlBtnClick = kControlBtnClick_Nth;
		isClickingGroup1_1 = false;
		locationPrev1 = CGPoint.ccp(1000,1000);
		s_group1_1.setTextureRect(s_group1_1_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(0);
	}
	
	public void  group1_2BtnRelease()
	{
		controlBtnClick = kControlBtnClick_Nth;
		isClickingGroup1_2 = false;
		locationPrev1 = CGPoint.ccp(1000,1000);
		s_group1_2.setTextureRect(s_group1_2_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(1);
	}
	
	public void  group1_3BtnRelease()
	{
		controlBtnClick = kControlBtnClick_Nth;
		isClickingGroup1_3 = false;
		locationPrev1 = CGPoint.ccp(1000,1000);
		s_group1_3.setTextureRect(s_group1_3_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(2);
	}
	
	public void  group1_4BtnRelease()
	{
		controlBtnClick = kControlBtnClick_Nth;
		isClickingGroup1_4 = false;
		locationPrev1 = CGPoint.ccp(1000,1000);
		s_group1_4.setTextureRect(s_group1_4_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(3);
	}
	
	
	public void  group1_1BtnRelease2()
	{
		controlBtnClick2 = kControlBtnClick_Nth;
		isClickingGroup1_1 = false;
		locationPrev2 = CGPoint.ccp(1000,1000);
		s_group1_1.setTextureRect(s_group1_1_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(0);
	}
	
	public void  group1_2BtnRelease2()
	{
		controlBtnClick2 = kControlBtnClick_Nth;
		isClickingGroup1_2 = false;
		locationPrev2 = CGPoint.ccp(1000,1000);
		s_group1_2.setTextureRect(s_group1_2_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(1);
	}
	
	public void  group1_3BtnRelease2()
	{
		controlBtnClick2 = kControlBtnClick_Nth;
		isClickingGroup1_3 = false;
		locationPrev2 = CGPoint.ccp(1000,1000);
		s_group1_3.setTextureRect(s_group1_3_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(2);
	}
	
	public void  group1_4BtnRelease2()
	{
		controlBtnClick2 = kControlBtnClick_Nth;
		isClickingGroup1_4 = false;
		locationPrev2 = CGPoint.ccp(1000,1000);
		s_group1_4.setTextureRect(s_group1_4_rect[0]);
		fingerHolding--;
	    delegate.btnIsReleasedInControlLayer(3);
	}
	}