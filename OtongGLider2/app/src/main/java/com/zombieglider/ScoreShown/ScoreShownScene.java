package com.zombieglider.ScoreShown;


import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.transitions.CCFadeTransition;
import org.cocos2d.types.ccColor3B;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabelAtlas;
import org.cocos2d.nodes.CCSprite;
import android.view.MotionEvent;

import com.zombieglider.GameActivity;
import com.zombieglider.Global;
import com.zombieglider.eTurtleCoinAniStruct;
import com.zombieglider.Begin.CoverScene;
import com.zombieglider.SelectMinigame.SelectMiniGameScene2;
public class ScoreShownScene extends CCLayer
{
	String  scoreShown_totalPriceChar = null;
    eTurtleCoinAniStruct turtleCoinAniStruct;
    eTurtleCoinAniStruct turtleCoinAniStructForReward;
    float turtleCoinForReward_X;
     float turtleCoinForReward_Y;
    
    float score;
    int grade;
    
    int displayScore;
    int displayGrade;
    
    
    int bestGrade;
    
    CCLabelAtlas l_score;
    CCLabelAtlas l_turtleTapped;
    CCLabelAtlas l_combo;
    CCLabelAtlas l_bestScore;
    
    CCLabelAtlas l_multiplier_FirstDigit;
    CCLabelAtlas l_multiplier_SecondDigit;
    CCSprite l_multiplier_Dot;
    
    CCSprite s_gradeBadge;
    CCSprite s_badge_letter[] = new CCSprite[7];
    int badge_letterIdx;
    int badge_prevousLetterIdx;
    boolean isChangingBadgeGrade;
    int chaningBadeGradeTimer;
    float badge_x;
    float badge_y;
    float badge_startX;
    float badge_scale;
    float badge_previousLetterScale;
    float badge_letterScale;
    float badge_previousLetterOpacity;
    
    
    int achivementSelectIdx;  //actual achivement idx
    int generalAchviementPosIdx; //pos from 0 - 11
    int achivementIdx[] = new int[5];
    CCSprite s_icon[] = new CCSprite[5];  
    CCSprite s_icon_bg[] = new CCSprite[5];  
    float iconPosX[] = new float[5];
    float iconPosY;
    
    CCSprite s_gradeBar_left;
    CCSprite s_gradeBar_center;
    CCSprite s_gradeBar_highlight;
    float gradeBarMaxPercentage;
    float gradeBarPercentage;
    float gradeBarDisplayPercentage;
    
    float scoreLimitToGrade[] = new float[10];
    
    int numTapped;
    double multipier;
    int multipier_FirstDigit;
    int multipier_SecondDigit;
    
    int finalTurtleCoin;
    int displayTurtleCoin;
    
    boolean startUpdatingDigits;
    int isGoingToUpdateDigitsTimer;
    int finalUpdateTimer;
    
    float detectChangeGradebarPercentage;
    
    boolean isRunning;
    boolean hasClickedToStop;
    
    boolean isPoppingUp;
    
    int howmanyAchivement;
    
    boolean achivementHasUnblocked[] = new boolean[5];
    boolean achivementHasUnblockedBeforeFuckingLongTimeAgo[] = new boolean[5];
    int howmanyCompletedWillBeShown;
    int showCompletedIdx[] = new int[5];
    int showCompletedIdxReferToPositionIdx[] = new int[5];
    
    boolean isShowingCompleted;
    int showCompletedCurrentIdx;
    int showCompletedCurrentTimer;
   
    boolean hasGainedAchivementCoin;
    
     int save_bestScore;
     int save_coins;
    int save_unblockAchivementIdx[] = new int[5];
    int save_unblockCurrentIdx;

    boolean isPlayingAchivementAni;
    
    boolean isProtecting;
    int protectingTimer;
    
    
    
    CCSprite ss_Font03;
    String turtleCoinString;
    int totalPrice;
    int maxCoinWords;
    
    int sentense01_AccumOffset;
    int setense01_offsetX;
    int startToFuckIdx;
    int fontTexture_numInRow;
    int fontTexture_offsetX;
    int fontTexture_offsetY;
    int fontTexture_startX;
    int fontTexture_howmanyCol;
    int fontTexture_chosenRow;
    int fontTexture_chosenCol;
    
    
    
    boolean isUnblockingMainGame;
    CCSprite s_unblockMainDialog;
    CCMenu m_unblockMainBtn;
    
    int sendLevel;
    
    boolean p4rc_isRemovedSpin;
    int p4rc_spinningTimer;
    
    CCMenuItem heyzap;
	
	public static CCScene    scene()
	{
		// 'scene' is an autorelease object.
		CCScene  scene = CCScene.node();
		
		// 'layer' is an autorelease object.
		ScoreShownScene  layer = new ScoreShownScene();
		
		// add layer as a child to scene
		scene.addChild( layer);
		
		// return the scene
		return scene;
	}
	
	public void  getMultiplier()
	{
	    multipier = 1.0f;
	    
	    if(Global.maxCombo < 40){
	        multipier = 1.0f;
	    }else if(Global.maxCombo < 80){
	        multipier = 1.5;
	    }else if(Global.maxCombo < 120){
	        multipier = 2.0;
	    }else if(Global.maxCombo < 160){
	        multipier = 2.5;
	    }else if(Global.maxCombo < 200){
	        multipier = 3.0;
	    }else if(Global.maxCombo < 250){
	        multipier = 3.5;
	    }else if(Global.maxCombo < 290){
	        multipier = 4.0;
	    }else if(Global.maxCombo < 10020){
	        multipier = 5.0;
	    }
	    
	    if(Global.currentChosenMiniGame == 1){
	        multipier = 0.5;
	        
	        if(Global.maxCombo < 100){
	            multipier = 0.5;
	            multipier = 0.0 + (1.0 - 0.0) * (Global.maxCombo - 0)/(100 - 0);
	        }else if(Global.maxCombo < 150){
	            multipier = 1.0;
	            multipier = 1.0 + (1.3 - 1.0) * (Global.maxCombo - 100)/(150 - 100);
	        }else if(Global.maxCombo < 200){
	            multipier = 1.3;
	            multipier = 1.3 + (1.7 - 1.3) * (Global.maxCombo - 150)/(200 - 150);  
	        }else if(Global.maxCombo < 250){
	            multipier = 1.7;
	             multipier = 1.7 + (2.0 - 1.7) * (Global.maxCombo - 200)/(250 - 200);
	        }else if(Global.maxCombo < 300){
	            multipier = 2;
	             multipier = 2.0 + (2.2 - 2.0) * (Global.maxCombo - 250)/(300 - 250);
	        }else if(Global.maxCombo < 350){
	            multipier = 2.2;
	             multipier = 2.2 + (2.5 - 2.2) * (Global.maxCombo - 300)/(350 - 300);
	        }else if(Global.maxCombo < 400){
	            multipier = 2.5;
	             multipier = 2.5 + (3.0 - 2.5) * (Global.maxCombo - 350)/(400 - 350);
	        }else if(Global.maxCombo < 10020){
	            multipier = 3.0;
	        }
	        
	        if(multipier < 1.0){
	            multipier = 1.0;
	        }
	
	    }
	    
	    if(Global.currentChosenMiniGame == 2){
	        multipier = 1.0;
	        
	        if(Global.maxCombo < 10){
	            multipier = 1.0;
	            multipier = 0.0 + (2.0 - 0.0) * (Global.maxCombo - 0)/(10 - 0);
	        }else if(Global.maxCombo < 15){
	            multipier = 2.0;
	            multipier = 2.0 + (3.5 - 2.0) * (Global.maxCombo - 10)/(15 - 10);
	        }else if(Global.maxCombo < 20){
	            multipier = 3.5;
	            multipier = 3.5 + (5.0 - 3.5) * (Global.maxCombo - 15)/(20 - 15);
	        }else if(Global.maxCombo < 25){
	            multipier = 5;
	            multipier = 5.0 + (6.5 - 5.0) * (Global.maxCombo - 20)/(25 - 20);
	        }else if(Global.maxCombo < 30){
	            multipier = 6.5;
	            multipier = 6.5 + (8.0 - 6.5) * (Global.maxCombo - 25)/(30 - 25);
	        }else if(Global.maxCombo < 35){
	            multipier = 8.0;
	             multipier = 8.0 + (9.0 - 8.0) * (Global.maxCombo - 30)/(35 - 30);
	        }else if(Global.maxCombo < 40){
	            multipier = 9.0;
	             multipier = 9.0 + (10.0 - 9.0) * (Global.maxCombo - 35)/(40 - 35);
	        }else if(Global.maxCombo < 45){
	            multipier = 10.0;
	             multipier = 10.0 + (11.0 - 10.0) * (Global.maxCombo - 40)/(45 - 40);
	        }else if(Global.maxCombo < 50){
	            multipier = 11.0;
	            multipier = 11.0 + (12.0 - 11.0) * (Global.maxCombo - 45)/(50 - 45);
	        }else if(Global.maxCombo < 5099999){
	            multipier = 12.0;
	        }
	    
	    }
	    
	    if(Global.currentChosenMiniGame == 3){
	        multipier = 2.0;
	    }
	    
	    
	    if(Global.currentChosenMiniGame == 4){
	        multipier = 0.5;
	        
	        if(Global.maxCombo < 30){
	            multipier = 0.5;
	             multipier = 0.0 + (0.5 - 0.0) * (Global.maxCombo - 0)/(30 - 0);
	        }else if(Global.maxCombo < 50){
	            multipier = 0.5;
	             multipier = 0.5 + (0.65 - 0.5) * (Global.maxCombo - 30)/(50 - 30);
	        }else if(Global.maxCombo < 80){
	            multipier = 0.65;
	            multipier = 0.65 + (0.85 - 0.65) * (Global.maxCombo - 50)/(80 - 50);
	        }else if(Global.maxCombo < 100){
	            multipier = 0.85;
	            multipier = 0.85 + (1.0 - 0.85) * (Global.maxCombo - 80)/(100 - 80);
	        }else if(Global.maxCombo < 150){
	            multipier = 1.0;
	            multipier = 1.0 + (1.2 - 1.0) * (Global.maxCombo - 100)/(150 - 100);
	        }else if(Global.maxCombo < 200){
	            multipier = 1.2;
	            multipier = 1.2 + (1.5 - 1.2) * (Global.maxCombo - 150)/(200 - 150);
	        }else if(Global.maxCombo < 250){
	            multipier = 1.5;
	            multipier = 1.5 + (1.65 - 1.5) * (Global.maxCombo - 200)/(250 - 200);
	        }else if(Global.maxCombo < 300){
	            multipier = 1.65;
	             multipier = 1.65 + (1.85 - 1.65) * (Global.maxCombo - 250)/(300 - 250);
	        }else if(Global.maxCombo < 350){
	            multipier = 1.85;
	            multipier = 1.85 + (2.0 - 1.85) * (Global.maxCombo - 300)/(350 - 300);
	        }else if(Global.maxCombo < 400){
	            multipier = 2.0;
	             multipier = 2.0 + (3.0 - 2.0) * (Global.maxCombo - 350)/(400 - 350);
	        }else if(Global.maxCombo < 450000){
	            multipier = 3.0;
	        }
	        
	        if(multipier < 1.0){
	            multipier = 1.0;
	        }
	    
	    }
	    
	    
	    if(Global.currentChosenMiniGame == 5){
	        multipier = 1.0;
	        
	        if(Global.maxCombo < 40){
	            multipier = 1.0;
	            multipier = 0.0 + (1.3 - 0.0) * (Global.maxCombo - 0)/(40 - 0);
	        }else if(Global.maxCombo < 80){
	            multipier = 1.3;
	            multipier = 1.3 + (1.6 - 1.3) * (Global.maxCombo - 40)/(80 - 40);
	        }else if(Global.maxCombo < 120){
	            multipier = 1.6;
	            multipier = 1.6 + (1.9 - 1.6) * (Global.maxCombo - 80)/(120 - 80);
	        }else if(Global.maxCombo < 160){
	            multipier = 1.9;
	            multipier = 1.9 + (2.2 - 1.9) * (Global.maxCombo - 120)/(160 - 120);
	        }else if(Global.maxCombo < 200){
	            multipier = 2.2;
	            multipier = 2.2 + (2.5 - 2.2) * (Global.maxCombo - 160)/(200 - 160);
	        }else if(Global.maxCombo < 250){
	            multipier = 2.5;
	            multipier = 2.5 + (2.8 - 2.5) * (Global.maxCombo - 200)/(250 - 200);
	        }else if(Global.maxCombo < 280){
	            multipier = 2.8;
	            multipier = 2.8 + (3.0 - 2.8) * (Global.maxCombo - 250)/(280 - 250);
	        }else if(Global.maxCombo < 10020){
	            multipier = 3.0;
	        }
	
	        
	        if(multipier < 1.0){
	            multipier = 1.0;
	        }
	    }
	    
	    if(Global.currentChosenMiniGame == 10){
	        multipier = 6.0;
	    }
	    
	    if(Global.currentChosenMiniGame == 11){
	        multipier = 1.0;
	        
	        if(Global.maxCombo < 50){
	            multipier = 0.3;
	            multipier = 0.0 + (0.6 - 0.0) * (Global.maxCombo - 0)/(50 - 0);
	        }else if(Global.maxCombo < 100){
	            multipier = 0.6; 
	            multipier = 0.6 + (0.65 - 0.6) * (Global.maxCombo - 50)/(100 - 50);
	        }else if(Global.maxCombo < 130){
	            multipier = 0.65;
	            multipier = 0.65 + (0.9 - 0.65) * (Global.maxCombo - 100)/(130 - 100);
	        }else if(Global.maxCombo < 160){
	            multipier = 0.9;
	            multipier = 0.9 + (1.0 - 0.9) * (Global.maxCombo - 130)/(160 - 130);
	        }else if(Global.maxCombo < 200){
	            multipier = 1.0;
	            multipier = 1.0 + (1.5 - 1.0) * (Global.maxCombo - 160)/(200 - 160);
	        }else if(Global.maxCombo < 250){
	            multipier = 1.5;
	            multipier = 1.5 + (1.7 - 1.5) * (Global.maxCombo - 200)/(250 - 200);
	        }else if(Global.maxCombo < 300){
	            multipier = 1.7;
	            multipier = 1.7 + (2.0 - 1.7) * (Global.maxCombo - 250)/(300 - 250);
	        }else if(Global.maxCombo < 10020){
	            multipier = 2.0;
	        }
	        
	        multipier += 0.3;
	        
	    }
	    
	    if(Global.currentChosenMiniGame == 13){
	        multipier = 1.0;
	        
	        if(Global.maxCombo < 100){
	            multipier = 1.4;
	             multipier = 0.0 + (1.7 - 0.0) * (Global.maxCombo - 0)/(100 - 0);
	        }else if(Global.maxCombo < 140){
	            multipier = 1.7;
	            multipier = 1.7 + (2.0 - 1.7) * (Global.maxCombo - 100)/(140 - 100);
	        }else if(Global.maxCombo < 170){
	            multipier = 2.0;
	            multipier = 2.0 + (2.2 - 2.0) * (Global.maxCombo - 140)/(170 -140);
	        }else if(Global.maxCombo < 200){
	            multipier = 2.2;
	            multipier = 2.2 + (2.5 - 2.2) * (Global.maxCombo - 170)/(200 - 170);
	        }else if(Global.maxCombo < 250){
	            multipier = 2.5;
	            multipier = 2.5 + (2.7 - 2.5) * (Global.maxCombo - 200)/(250 - 200);
	        }else if(Global.maxCombo < 300){
	            multipier = 3.0;
	            multipier = 2.7 + (3.0 - 2.7) * (Global.maxCombo - 250)/(300 - 250);
	        }else if(Global.maxCombo < 40000){
	            multipier = 3.0;
	        }
	        
	        if(multipier < 1.4){
	            multipier = 1.4;
	        }
	        
	    }
	    
	    if(Global.currentChosenMiniGame == 103){
	        multipier = 1.5;
	        
	        
	        if(Global.maxCombo < 20){
	            multipier = 1.5;
	            multipier = 1.5 + (2.0 - 1.5) * (Global.maxCombo - 0)/(20 - 0);
	        }else if(Global.maxCombo < 25){
	            multipier = 2.0;
	            multipier = 2.0 + (2.2 - 2.0) * (Global.maxCombo - 20)/(25 - 20);
	        }else if(Global.maxCombo < 50){
	            multipier = 2.2;
	            multipier = 2.2 + (2.5 - 2.2) * (Global.maxCombo - 25)/(50 - 25);
	        }else if(Global.maxCombo < 75){
	            multipier = 2.5;
	            multipier = 2.5 + (2.7 - 2.5) * (Global.maxCombo - 50)/(75 - 50);
	        }else if(Global.maxCombo < 100){
	            multipier = 2.7;
	            multipier = 2.7 + (3.0 - 2.7) * (Global.maxCombo - 75)/(100 - 75);
	        }else if(Global.maxCombo < 125){
	            multipier = 3.0;
	            multipier = 3.0 + (3.2 - 3.0) * (Global.maxCombo - 100)/(125 - 100);
	        }else if(Global.maxCombo < 150){
	            multipier = 3.2;
	            multipier = 3.2 + (3.5 - 3.2) * (Global.maxCombo - 125)/(150 - 125);
	        }else if(Global.maxCombo < 175){
	            multipier = 3.5;
	            multipier = 3.5 + (3.7 - 3.5) * (Global.maxCombo - 150)/(175 - 150);
	        }else if(Global.maxCombo < 200){
	            multipier = 3.7;
	            multipier = 3.7 + (4.0 - 3.7) * (Global.maxCombo - 175)/(200 - 175);
	        }else if(Global.maxCombo < 10020){
	            multipier = 4.0;
	        }
	        
	        
	        if(multipier < 1.5){
	            multipier = 1.5;
	        }
	        
	    }
	    double floatM;
	    int intM;
	    floatM = multipier * 10;
	    intM = (int)floatM;
	    multipier = (float)intM/10;
	}
	
	public void  gainAchivementCoin()
	{
	    if(hasGainedAchivementCoin){
	        return;
	    }
	    
	    isPlayingAchivementAni = false;
	    hasGainedAchivementCoin = true;
	    
	    int coinFromAchivement;
	    int currentShownIdx;
	    coinFromAchivement = 0;
	    currentShownIdx = 0;
	    if(howmanyCompletedWillBeShown != 0){
	        do{
	            coinFromAchivement += Global.ahievementReward[showCompletedIdx[currentShownIdx]];
	            
	            currentShownIdx++;
	        }while(currentShownIdx < howmanyCompletedWillBeShown);
	    }
	    
	    Global.turtleCoinAccum += coinFromAchivement;
	    this.setCoinAniForRewardAtX(445,270);
	}
	
	public boolean  checkToShowThisAchivementToBeUnlboked( int _achivementPos)
	{
	    if(achivementIdx[_achivementPos] == 0){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_01",0);
	        counterLeft = 400 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 1){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_01",0);
	        counterLeft = 4000 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 2){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 3){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 4){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	
	    //MINI 02
	    if(achivementIdx[_achivementPos] == 5){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_04",0);
	        counterLeft = 400 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 6){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_04",0);
	        counterLeft = 3500 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 7){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 8){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 9){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	    
	    //MINI 03
	    if(achivementIdx[_achivementPos] == 10){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_02",0);
	        counterLeft = 400 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 11){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_02",0);
	        counterLeft = 2000 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 12){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 13){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 14){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	    
	    //MINI 04
	    if(achivementIdx[_achivementPos] == 15){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_03",0);
	        counterLeft = 400 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 16){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_03",0);
	        counterLeft = 1500 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 17){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 18){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 19){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	    
	    //MINI 05
	    if(achivementIdx[_achivementPos] == 20){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_10",0);
	        counterLeft = 200 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 21){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_10",0);
	        counterLeft = 1200 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 22){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 23){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 24){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	    
	    //MINI 06
	    if(achivementIdx[_achivementPos] == 25){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_05",0);
	        counterLeft = 400 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 26){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_05",0);
	        counterLeft = 3000 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 27){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 28){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 29){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	    
	    //MINI 07
	    if(achivementIdx[_achivementPos] == 30){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_11",0);
	        counterLeft = 800 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 31){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_11",0);
	        counterLeft = 4000 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 32){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 33){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 34){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	    
	    //MINI 08
	    if(achivementIdx[_achivementPos] == 35){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_13",0);
	        counterLeft = 400 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 36){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_13",0);
	        counterLeft = 3000 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 37){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 38){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 39){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	    
	    
	    //MINI 09
	    if(achivementIdx[_achivementPos] == 40){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_103",0);
	        counterLeft = 400 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 41){
	        int counterLeft;
	        int counter;
	        
	        counter = GameActivity.app.getPreferences(0).getInt("counter_mini_103",0);
	        counterLeft = 3000 - counter;
	        
	        if(counterLeft < 0){
	            return true;
	        }
	    }
	    
	    if(achivementIdx[_achivementPos] == 42){
	        if(grade >=  Global.kGrade_B){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 43){
	        if(grade >=  Global.kGrade_A){
	            return true;
	        }
	    }
	    if(achivementIdx[_achivementPos] == 44){
	        if(grade >=  Global.kGrade_S){
	            return true;
	        }
	    }
	
	    
	    
	    return false;
	}
	
	public void  initHowmanyCompletedWIllBeShown()
	{
	    howmanyCompletedWillBeShown = 0;
	    showCompletedCurrentTimer = 0;
	    showCompletedCurrentIdx = 0;
	    isShowingCompleted = false;
	    
	    isPlayingAchivementAni = false;
	    
	    for(int i = 0 ; i < howmanyAchivement ; i++){
	        achivementHasUnblockedBeforeFuckingLongTimeAgo[i] = false;
	        
	        if(achivementIdx[i] >= 0){
	            if(!Global.hasFinishedThisAchivements[achivementIdx[i]]){
	                
	                if(this.checkToShowThisAchivementToBeUnlboked(i)){
	                    
	                    achivementHasUnblockedBeforeFuckingLongTimeAgo[i] = true;
	                    showCompletedIdx[howmanyCompletedWillBeShown] = achivementIdx[i];
	                    showCompletedIdxReferToPositionIdx[howmanyCompletedWillBeShown] = i;
	                    howmanyCompletedWillBeShown++;
	                    isShowingCompleted = true;
	                    isPlayingAchivementAni = true;
	                    
	                    save_unblockAchivementIdx[save_unblockCurrentIdx] = achivementIdx[i];
	                    save_unblockCurrentIdx++;
	                    
	                    //NEW
	                    Global.hasFinishedThisAchivements[achivementIdx[i]] = true;
	
	                }
	            }
	        }
	       
	    }
	    
	    if(howmanyCompletedWillBeShown != 0){
	        showCompletedCurrentTimer = -20;
	    }
	    
	}
	
	public void  setCoinAniForRewardAtX( float _x, float _y)
	{
	    turtleCoinForReward_X = _x;
	    turtleCoinForReward_Y = _y;
	    this.setTurtleCoinAniForReward();
	}
	
	ScoreShownScene()
	{
		super();
 
		Global.ad_isInGaming = false;
        
        this.saveToDBPre();
        
        isUnblockingMainGame = false;
        isProtecting = true;
        protectingTimer = 0;
        
        save_unblockAchivementIdx[0] = -1;
        save_unblockAchivementIdx[1] = -1;
        save_unblockAchivementIdx[2] = -1;
        save_unblockAchivementIdx[3] = -1;
        save_unblockAchivementIdx[4] = -1;
        save_unblockCurrentIdx = 0;
        
        isPoppingUp = false;
        setIsTouchEnabled(true);
        
        hasGainedAchivementCoin = false;
        isRunning = true;
        hasClickedToStop = false;
                
        Global.musicController.initForBegin();
        
        badge_letterScale = 1.0f;
        
        CCSprite  s_bg = CCSprite.sprite("images/ScoreShown/ScoreShown_bg2.png");
        s_bg.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2, 160));
        s_bg.setScale( 1.0f/Global.g_Scale );
        this.addChild(s_bg);
        

        
        numTapped = Global.currentTurtleCoin;
        startUpdatingDigits = false;
        
        this.checkIfGoToNextMiniGame();
        this.getMultiplier();
        
        this.getScoreAndGrade();
        this.initMenu();
        this.initLetters();
        this.initTurtleCoinAniStruct();
        
        this.initHowmanyCompletedWIllBeShown();
        
        detectChangeGradebarPercentage = 20.0f;
        finalUpdateTimer = 0;
        startUpdatingDigits = false;
        isGoingToUpdateDigitsTimer = 0;
        this.schedule("gameStep");
        
        this.saveToDB();     
	}
	
	public void  initLetters()
	{
	    l_score = CCLabelAtlas.label("0","font/fontV2.png",22*Global.g_Scale,27*Global.g_Scale,'0');
	    l_turtleTapped = CCLabelAtlas.label("0","font/fontV2.png",22*Global.g_Scale,27*Global.g_Scale,'0');
	    l_combo = CCLabelAtlas.label("0","font/fontV1.png",12*Global.g_Scale,14*Global.g_Scale,'0');
	    l_bestScore = CCLabelAtlas.label("0","font/fontV1.png",12*Global.g_Scale,14*Global.g_Scale,'0');
	    l_multiplier_FirstDigit = CCLabelAtlas.label("0","font/fontV2.png",22*Global.g_Scale,27*Global.g_Scale,'0');
	    l_multiplier_SecondDigit = CCLabelAtlas.label("0","font/fontV2.png",22*Global.g_Scale,27*Global.g_Scale,'0');
	    l_multiplier_Dot = CCSprite.sprite("images/ScoreShown/ScoreShown_multiplierDot.png");
	    
	    l_combo.setColor(ccColor3B.ccc3(48, 94, 173));
	    l_bestScore.setColor(ccColor3B.ccc3(48, 94, 173));
	    
	    int fuckOffset = -70;
	    int iPhone5OffsetX;
	    if (Global.isIphone5) {
	        iPhone5OffsetX = 44;
	    }else{
	        iPhone5OffsetX = 0;
	    }
	    
	    l_score.setPosition(CGPoint.ccp(332 + iPhone5OffsetX,215 + fuckOffset));
	     l_turtleTapped.setPosition(CGPoint.ccp(129 + iPhone5OffsetX,215 + fuckOffset));
	     l_combo.setPosition(CGPoint.ccp(218 + iPhone5OffsetX,245 + fuckOffset));
	     l_bestScore.setPosition(CGPoint.ccp(350 + iPhone5OffsetX,181 + fuckOffset));
	     l_multiplier_FirstDigit.setPosition(CGPoint.ccp(195 + iPhone5OffsetX,215 + fuckOffset));
	     l_multiplier_SecondDigit.setPosition(CGPoint.ccp(225 + iPhone5OffsetX,215 + fuckOffset));
	     l_multiplier_Dot.setPosition(CGPoint.ccp(220 + iPhone5OffsetX,223 + fuckOffset));
	    
	    
	    
	    l_score.setAnchorPoint(CGPoint.ccp(0.5,0));
	    l_turtleTapped.setAnchorPoint(CGPoint.ccp(0.5,0));
	    l_combo.setAnchorPoint(CGPoint.ccp(0.5,0));
	    l_bestScore.setAnchorPoint(CGPoint.ccp(1.0,0));
	    
	    l_turtleTapped.setScale(0.85f);
	    l_multiplier_FirstDigit.setScale(0.85f);
	    l_multiplier_SecondDigit.setScale(0.85f);
	    
	    this.addChild(l_score);
	    this.addChild(l_turtleTapped);
	    this.addChild(l_combo);
	    this.addChild(l_bestScore);
	    this.addChild(l_multiplier_FirstDigit);
	    this.addChild(l_multiplier_SecondDigit);
	    this.addChild(l_multiplier_Dot);
	    
	    l_score.setScale(1.0f/Global.g_Scale);
	    l_turtleTapped.setScale(1.0f/Global.g_Scale);
	    l_combo.setScale(1.0f/Global.g_Scale);
	    l_bestScore.setScale(1.0f/Global.g_Scale);
	    l_multiplier_FirstDigit.setScale(1.0f/Global.g_Scale);
	    l_multiplier_SecondDigit.setScale(1.0f/Global.g_Scale);
	    l_multiplier_Dot.setScale(1.0f/Global.g_Scale);
	    
	    
	    this.updateLetters();
	
	}
	
	public void  gameStep( float  dt)
	{
	    if(isProtecting){
	        protectingTimer++;
	        if(protectingTimer == 30){
	            isProtecting = false;
	        }
	    }
	    
	    
	    if(!startUpdatingDigits){
	        isGoingToUpdateDigitsTimer++;
	        if(isGoingToUpdateDigitsTimer == 25){
	            startUpdatingDigits = true;
	        }
	        
	        return;
	    }
	    this.updateGradeBar();
	    this.updateScoreAndCoin();
	    this.updateLetters();
	    this.turtleCoinAniManage();
	    this.turtleCoinAniManageForReward();
	    
	}
		
	public void  updateLetters()
	{
	    l_score.setString(String.format("%d", displayScore));
	    l_turtleTapped.setString(String.format("%d", numTapped));
	    l_combo.setString(String.format("%d", Global.maxCombo));
	    if ( displayScore > Global.g_bestScore[Global.miniGameIdx] )
	    	l_bestScore.setString(String.format("%d", displayScore));
	    else
	    	l_bestScore.setString(String.format("%d", Global.g_bestScore[Global.miniGameIdx]));
	    
	    double multiplierUseForCal;
	    
	    if(multipier < 10){
	        multiplierUseForCal = multipier * 10;
	        multipier_FirstDigit = (int) (multiplierUseForCal / 10);
	        multipier_SecondDigit = (int) (multiplierUseForCal - multipier_FirstDigit * 10);
	    }else{
	        multiplierUseForCal = multipier;
	        multipier_FirstDigit = (int) (multipier / 10);
	        multipier_SecondDigit =(int) (multipier - multipier_FirstDigit * 10);
	        
	        l_multiplier_Dot.setPosition(CGPoint.ccp(2999920,223));
	        
	        l_multiplier_FirstDigit.setPosition(CGPoint.ccp(195+5,215+18));
	        l_multiplier_SecondDigit.setPosition(CGPoint.ccp(225-5,215+18));
	    }
	    
	      
	    l_multiplier_FirstDigit.setString(String.format("%d", multipier_FirstDigit));
	    l_multiplier_SecondDigit.setString(String.format("%d", multipier_SecondDigit));
	}
	
	public void  updateGradeBar()
	{
	    double diffGradePercentage;
	    double applyGradeInterval;
	    double scoreMusicInterval;
	    double scoreMusicAccumToInterval = 0;
	    
	    if(gradeBarPercentage == 0){
	        scoreMusicAccumToInterval = 0;
	        this.playOneScoreSound();
	    } 
	    
	    diffGradePercentage = gradeBarMaxPercentage - gradeBarPercentage;
	    if(diffGradePercentage > 80){
	        applyGradeInterval = 0.9f;
	        scoreMusicInterval = 2.0f;
	    }else if(diffGradePercentage > 60){
	        applyGradeInterval = 0.75;
	        scoreMusicInterval = 2.0;
	    }else if(diffGradePercentage > 40){
	        applyGradeInterval = 0.6;
	        scoreMusicInterval = 2.0;
	    }else if(diffGradePercentage > 22){
	        applyGradeInterval = 0.5;
	        scoreMusicInterval = 2.0;
	    }else if(diffGradePercentage > 12){
	        applyGradeInterval = 0.4;
	        scoreMusicInterval = 2.0;
	    }else{
	        applyGradeInterval = 0.3;
	        scoreMusicInterval = 2.1;
	    }
	    
	    applyGradeInterval *= 0.8;
	    
	    if(diffGradePercentage < 7){
	        
	        gradeBarPercentage += (gradeBarMaxPercentage - gradeBarPercentage)/30;
	        
	        finalUpdateTimer++;
	        if(finalUpdateTimer == 90){
	            gradeBarPercentage = gradeBarMaxPercentage;
	            this.playOneScoreSound();
	            isRunning = false;
	        }
	        
	        
	        if(gradeBarMaxPercentage - gradeBarPercentage > 2.2){
	            scoreMusicInterval = 2.2;
	        }else{
	            scoreMusicInterval = 2000.2;
	        }
	        
	        scoreMusicAccumToInterval += (gradeBarMaxPercentage - gradeBarPercentage)/30;
	        if(scoreMusicAccumToInterval >= scoreMusicInterval){
	            scoreMusicAccumToInterval = 0;
	            this.playOneScoreSound();
	        }
	        
	    }else{
	        gradeBarPercentage += applyGradeInterval;
	        
	        scoreMusicAccumToInterval += applyGradeInterval;
	        if(scoreMusicAccumToInterval >= scoreMusicInterval){
	            scoreMusicAccumToInterval = 0;
	            this.playOneScoreSound();
	        }
	    }
	    
	    
	    
	    if(gradeBarPercentage > gradeBarMaxPercentage){
	        gradeBarPercentage = gradeBarMaxPercentage;
	    }
	}
	
	public void  playOneScoreSound()
	{
	    if(score == 0){
	        return;
	    }
	    
	    if((Math.random() * 65535) % 3 == 0){
	        Global.musicController.playThisSound(Global.kSound_Score2,false,0.65);
	    }else{
	        Global.musicController.playThisSound(Global.kSound_Score,false,0.65);
	    }
	}
	
	public void  updateScoreAndCoin()
	{
	    displayScore = (int) (gradeBarPercentage / gradeBarMaxPercentage * score);
	}
	
	
	public void  initMenu()
	{
		CCMenuItem  mNext = CCMenuItemImage.item("images/ScoreShown/ScoreShown_btn_restartPlay_off.png","images/ScoreShown/ScoreShown_btn_restartPlay_on.png",this,"mNextCallback");
	
	    mNext.setPosition(CGPoint.ccp(200, -122));
	    
	    if(Global.isIphone5){
	        mNext.setPosition(CGPoint.ccp(244, -122));
	    }
	    mNext.setScale(1.0f/Global.g_Scale);
	    CCMenu  menu = CCMenu.menu(mNext);
		this.addChild(menu);
	}
		
	public void  mNextCallback(Object sender)
	{
	    saveToDB();
	    
	    Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
	     Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    if(isProtecting){
	        return;
	    }

	    if(isPoppingUp){
	        return;
	    }
	    
	    if(isRunning){
	        this.clickToStop();
	        return;
	    }
	    
	    if(Global.miniGameIdx == Global.maxTotalMiniChosen - 3){
	        if(!GameActivity.app.getPreferences(0).getBoolean("main_hasPlayedBeginStory",false)){
	        	CCFadeTransition f = CCFadeTransition.transition( 2.0f,CoverScene.scene(),ccColor3B.ccc3(255,255,255) );
	    		CCDirector.sharedDirector().replaceScene(f); 
	            return;
	        }
	    }
	    	    
	    Global.p4rc_canDisplayScore = false;
	    Global.hasPlayedMiniGames[Global.miniGameIdx + 1] = true;
	    
	    CCDirector.sharedDirector().replaceScene( SelectMiniGameScene2.scene());
	}
		
	public void  clickToStopCompleted()
	{
	    showCompletedCurrentIdx++;
	    showCompletedCurrentTimer = 0;
	    
	    if(showCompletedCurrentIdx == howmanyCompletedWillBeShown){
	        isShowingCompleted = false;
	    }
	}
	
	public void  clickToStop()
	{
	    gradeBarPercentage = gradeBarMaxPercentage;
	    isRunning = false;
	    hasClickedToStop = true;
	    badge_letterIdx = grade;
	    
	    isChangingBadgeGrade = true;
	    chaningBadeGradeTimer = 0;
	    badge_prevousLetterIdx = badge_letterIdx;
	    badge_previousLetterScale = 1.0f;
	    badge_letterScale = 0.0f;
	    badge_scale = 1.0f;
	    badge_previousLetterOpacity = 255;
	    this.setTurtleCoinAni();
	}
	
	public void  getScoreAndGrade()
	{
	    score = (float) (numTapped * multipier);
	    
	    
	    if(gradeBarMaxPercentage <= 0.5){
	        gradeBarMaxPercentage = 0.5f;
	    }
	
	    
	    gradeBarPercentage = 0;
	}
	
	public void  initTurtleCoinAniStruct()
	{
	    turtleCoinAniStruct = new eTurtleCoinAniStruct();
	    turtleCoinAniStruct.numElements = 10;
	    turtleCoinAniStruct.aniTimer = 0;
	    turtleCoinAniStruct.isAni = false;
	    
	    for(int i = 0 ; i < turtleCoinAniStruct.numElements ; i++){
	        turtleCoinAniStruct.s_graphic[i] = CCSprite.sprite("images/ScoreShown/badge/ScoreShown_Badge_Shine.png");
	        turtleCoinAniStruct.s_graphic[i].setScale(1.0f/Global.g_Scale);
	        turtleCoinAniStruct.posX[i] = 99999;
	        
	        this.addChild(turtleCoinAniStruct.s_graphic[i]);
	        turtleCoinAniStruct.s_graphic[i].setPosition(CGPoint.ccp(10000,10000));
	    }
	    
	    turtleCoinAniStructForReward = new eTurtleCoinAniStruct();
	    turtleCoinAniStructForReward.numElements = 10;
	    turtleCoinAniStructForReward.aniTimer = 0;
	    turtleCoinAniStructForReward.isAni = false;
	    
	    for(int i = 0 ; i < turtleCoinAniStructForReward.numElements ; i++){
	        turtleCoinAniStructForReward.s_graphic[i] = CCSprite.sprite("images/ScoreShown/badge/ScoreShown_Badge_Shine.png");
	        turtleCoinAniStructForReward.s_graphic[i].setScale(1.0f/Global.g_Scale);
	        turtleCoinAniStructForReward.posX[i] = 99999;
	        
	        this.addChild(turtleCoinAniStructForReward.s_graphic[i],Global.kDeapth_Turtle_Bombing2);
	        turtleCoinAniStructForReward.s_graphic[i].setPosition(CGPoint.ccp(10000,10000));
	    }
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
	    
	    int ranNumber;
	    
	    if(turtleCoinAniStruct.aniTimer == 0){
	        for(int i = 0 ; i <  turtleCoinAniStruct.numElements ; i++){
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStruct.vx[i] = (float) ((float)ranNumber/50.0);
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStruct.vy[i] = (float) ((float)ranNumber/30.0);
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStruct.rv[i] = (float) ((float)ranNumber/50.0);
	            
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStruct.ov[i] = (float) ((float)ranNumber/20.0 + 10.0);
	            
	            if((Math.random() * 65535)%2 == 0){
	                turtleCoinAniStruct.rv[i] *= -1;
	                turtleCoinAniStruct.vx[i] *= -1;
	            }
	            
	            turtleCoinAniStruct.posX[i] = badge_x;
	            turtleCoinAniStruct.posY[i] = badge_y;
	            
	            turtleCoinAniStruct.opacity[i] = 255;
	            turtleCoinAniStruct.s_graphic[i].setScale(2.0f);
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
	
	public void  turtleCoinAniManageForReward()
	{
	    if(!turtleCoinAniStructForReward.isAni){
	        return;
	    }
	
	    if( turtleCoinAniStructForReward.aniTimer > 26){
	        turtleCoinAniStructForReward.aniTimer++;
	        if( turtleCoinAniStructForReward.aniTimer > 26){
	            turtleCoinAniStructForReward.isAni = false;
	            for(int i = 0 ; i < turtleCoinAniStructForReward.numElements ; i++){
	                turtleCoinAniStructForReward.s_graphic[i].setPosition(CGPoint.ccp(10000,10000));
	            }
	        }
	        return;
	    }
	    
	    int ranNumber;
	    
	    if(turtleCoinAniStructForReward.aniTimer == 0){
	        for(int i = 0 ; i <  turtleCoinAniStructForReward.numElements ; i++){
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStructForReward.vx[i] = (float) ((float)ranNumber/25.0);
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStructForReward.vy[i] = (float) ((float)ranNumber/15.0);
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStructForReward.rv[i] = (float) ((float)ranNumber/25.0);
	            
	            ranNumber = (int) ((Math.random() * 65535)%100);
	            turtleCoinAniStructForReward.ov[i] = (float) ((float)ranNumber/10.0 + 5.0);
	            
	            if((Math.random() * 65535)%2 == 0){
	                turtleCoinAniStructForReward.rv[i] *= -1;
	                turtleCoinAniStructForReward.vx[i] *= -1;
	            }
	            
	            turtleCoinAniStructForReward.posX[i] = turtleCoinForReward_X;
	            turtleCoinAniStructForReward.posY[i] = turtleCoinForReward_Y;
	            
	            turtleCoinAniStructForReward.opacity[i] = 255;
	            turtleCoinAniStructForReward.s_graphic[i].setScale(2.0f);
	        }
	    }
	    
	    for(int i = 0 ; i <  turtleCoinAniStructForReward.numElements ; i++){
	        turtleCoinAniStructForReward.s_graphic[i].setPosition(CGPoint.ccp(turtleCoinAniStructForReward.posX[i], turtleCoinAniStructForReward.posY[i]));
	        turtleCoinAniStructForReward.s_graphic[i].setOpacity(turtleCoinAniStructForReward.opacity[i]);
	        
	        turtleCoinAniStructForReward.posX[i] += turtleCoinAniStructForReward.vx[i];
	        turtleCoinAniStructForReward.posY[i] += turtleCoinAniStructForReward.vy[i];
	        turtleCoinAniStructForReward.opacity[i] -= turtleCoinAniStructForReward.ov[i];
	        
	        if(turtleCoinAniStructForReward.opacity[i] < 0 ){
	            turtleCoinAniStructForReward.opacity[i] = 0;
	        }
	        
	        turtleCoinAniStructForReward.vy[i] -= 0.2;
	    }
	    
	    
	    turtleCoinAniStructForReward.aniTimer++;
	}
	
	public void  setTurtleCoinAni()
	{
	    if(turtleCoinAniStruct.isAni){
	        return;
	    }
	    
	    turtleCoinAniStruct.aniTimer = 0;
	    turtleCoinAniStruct.isAni = true;
	}
	
	public void  setTurtleCoinAniForReward()
	{
	    if(turtleCoinAniStructForReward.isAni){
	        return;
	    }
	 
	    turtleCoinAniStructForReward.aniTimer = 0;
	    turtleCoinAniStructForReward.isAni = true;
	}
	
	
	public void  removePopup()
	{
	    isPoppingUp = false;
	     heyzap.setPosition(CGPoint.ccp(-135-10,-60-7-6));
	}
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    if(isPoppingUp){
	        return true;
	    }
	    
	    for( int ii = 0; ii < event.getPointerCount(); ii++ ) {
			CGPoint location = CGPoint.ccp(event.getX(ii), event.getY(ii));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        for(int i = 0 ; i < 5 ; i++){
	            if(location.x > iconPosX[i] - 30 && location.x <  iconPosX[i] + 30){
	                if(location.y > iconPosY - 30 && location.y <  iconPosY + 30){
	                    generalAchviementPosIdx = i;
	                    achivementSelectIdx =  achivementIdx[i];
	                    return true;
	                }
	            }
	        }
	        
	        
	        
	    }
		return true;
	}
	
	
	public void  saveToDBPre()
	{
	    String miniCounterString = new String();
	    miniCounterString = "counter_mini_";
	        
	    if(Global.currentChosenMiniGame <= 9){
	        miniCounterString += ("0");
	    }
	    
	    miniCounterString += String.format("%d", Global.currentChosenMiniGame);
	    
	    int preCounterAchivement;
	    preCounterAchivement = GameActivity.app.getPreferences(0).getInt(miniCounterString,0);
	    preCounterAchivement += Global.counterForAchivement;
	    
	    GameActivity.app.getPreferences(0).edit().putInt(miniCounterString,preCounterAchivement);
	    GameActivity.app.getPreferences(0).edit().commit();
	}
	
	public void  saveToDB()
	{
	    save_bestScore = (int) score;
	    
	    int saveTurtleCoinAccum = Global.turtleCoinAccum;
	    
	    for(int i = 0 ; i < howmanyAchivement ; i++){
	        if(save_unblockAchivementIdx[i] != -1){
	            
	            saveTurtleCoinAccum += Global.ahievementReward[save_unblockAchivementIdx[i]];
	            
	            
	            String achivementString = new String();
	            achivementString = ("achivement_");
	            
	            if(save_unblockAchivementIdx[i] < 9){
	                achivementString += ("0");
	            }
	            
	            achivementString += String.format("%d", save_unblockAchivementIdx[i]+1);
	            
	            GameActivity.app.getPreferences(0).edit().putBoolean(achivementString,true);
	    	    GameActivity.app.getPreferences(0).edit().commit();	            
	        }
	    }
	    
	    if(save_bestScore > Global.g_bestScore[Global.miniGameIdx]){
	    	Global.g_bestScore[Global.miniGameIdx] = save_bestScore;
	        String scoreString = new String();
	        
	        scoreString = ("score_mini_");
	        
	        if(Global.currentChosenMiniGame <= 9){
	            scoreString += ("0");
	        }
	        
	        scoreString += String.format("%d", Global.miniGameIdx);
	        
	        GameActivity.app.getPreferences(0).edit().putInt(scoreString,save_bestScore);
    	    GameActivity.app.getPreferences(0).edit().commit();	            
        }
	    
	}
	
	
	
	public void  initTurtleCoins()
	{
	    maxCoinWords = 10;
	    
	    ss_Font03  = CCSprite.sprite("font/fontV3.png");
	    this.addChild(ss_Font03,Global.kDeapth_Turtle_Bombing2);
	    ss_Font03.setAnchorPoint(0,0);
	    ss_Font03.setOpacity(0);
	       
	}
		
	public void  checkIfGoToNextMiniGame()
	{
	    if(Global.miniGameIdx == Global.maxTotalMiniChosen - 2){
	    	Global.isGoingToNextMiniGame = false;
	        
	    	GameActivity.app.getPreferences(0).edit().putBoolean("main_hasUnblocked",true);
	        
	        String  key2 = String.format("mini_hasPlayed_%02d", Global.currentChosenMiniGame);
	        GameActivity.app.getPreferences(0).edit().putBoolean(key2,true);
	        GameActivity.app.getPreferences(0).edit().commit();
	        
	        return;
	    }
	    
	    Global.isGoingToNextMiniGame = false;
	    
	    String  key2 = String.format("mini_hasPlayed_%02d", Global.currentChosenMiniGame);
	    String  key = String.format("mini_hasPlayed_%02d", Global.miniGameOrder[Global.miniGameIdx+1]);
	    GameActivity.app.getPreferences(0).edit().putBoolean(key, true);
	    GameActivity.app.getPreferences(0).edit().commit();
	    
	    boolean nextHasPlayed;
	    nextHasPlayed = GameActivity.app.getPreferences(0).getBoolean(key,false);
	    
	    if(!nextHasPlayed){
	    	Global.isGoingToNextMiniGame = true;
	    }
	}
}
