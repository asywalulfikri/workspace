package com.zombieglider.SelectMinigame;


import org.cocos2d.menus.CCMenu;
import org.cocos2d.menus.CCMenuItemImage;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.layers.CCLayer;
import org.cocos2d.layers.CCScene;
import org.cocos2d.types.CGPoint;
import org.cocos2d.types.ccColor4B;
import org.cocos2d.menus.CCMenuItem;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCLabelAtlas;
import org.cocos2d.nodes.CCSprite;
import android.view.MotionEvent;

import com.zombieglider.GameActivity;
import com.zombieglider.Global;
import com.zombieglider.Begin.CoverScene;
import com.zombieglider.Main.PlayScene;



class eTurtleCoinAniStruct2{
	CCSprite s_graphic[] = new CCSprite[10];
    float posX[] = new float[10];
    float posY[] = new float[10];
    float vx[] = new float[10];
    float vy[] = new float[10];
    float rv[] = new float[10];
    float opacity[] = new float[10];
    float ov[] = new float[10];
    int aniTimer;
    boolean isAni;
    int numElements;
}



public class SelectMiniGameScene2 extends CCLayer
{
	
    CCLabelAtlas l_minigame;
    
    CCLabelAtlas l_grade;
    CCLabelAtlas l_score;
    
    CCSprite acivementIcon[] = new CCSprite[5];
    CCSprite s_content[] = new CCSprite[Global.maxTotalMiniChosen];
    CCSprite s_block;
    
    int idx;
    
    int blockStartIdx;
    
    int selectPosX;
    int selectPosY;
    int selectOffsetX;
    CCSprite s_selectOff[] = new CCSprite[Global.maxTotalMiniChosen];
    CCSprite s_selectOn;
    
    int achivementSelectIdx;  //actual achivement idx
    int generalAchviementPosIdx; //pos from 0 - 11
    int achivementIdx[] = new int[5];
    float iconPosX[] = new float[5];
    float iconPosY;
    
    
    CCSprite s_transition;
    int transitionTimer;
    boolean isTransitioning;
    boolean isTraitionDisappearing;
    float transitionOpacity;
    float transitionGain;
    
    float scoreLimitToGrade[] = new float[10];
    
    
    
    CCMenu menu;
    
    boolean isPoppingUp;
    boolean isShowingInstruction;
    
    CCSprite s_instruction;
    CCColorLayer s_dot;	
	
	public static CCScene    scene()
	{
		// 'scene' is an autorelease object.
		CCScene  scene = CCScene.node();
		
		// 'layer' is an autorelease object.
		SelectMiniGameScene2  layer = new SelectMiniGameScene2();
		
		// add layer as a child to scene
		scene.addChild( layer);
		
		// return the scene
		return scene;
	}
	
	public void  updateDisplay()
	{
	    if(idx == Global.maxTotalMiniChosen - 1){
	        s_block.setPosition(CGPoint.ccp(100000,200));
	        
	        for(int i = 0 ; i < Global.maxTotalMiniChosen ; i++){
	            if(i == idx){
	                s_selectOn.setPosition(CGPoint.ccp(selectPosX + selectOffsetX * i,selectPosY));
	                s_selectOff[i].setPosition(CGPoint.ccp(10000,100000));
	                s_content[i].setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,169));
	            }else{
	                s_selectOff[i].setPosition(CGPoint.ccp(selectPosX + selectOffsetX * i,selectPosY));
	                s_content[i].setPosition(CGPoint.ccp(10000,100000));
	            }
	        }
	        
	        Global.currentChosenMiniGame =  -999;
	        
	         l_minigame.setString("");
	        return;
	    }
	    
	    s_block.setPosition(CGPoint.ccp(100000,200));
	    
	    for(int i = 0 ; i < Global.maxTotalMiniChosen - 2 ; i++){
	        if(i == idx){
	            s_selectOn.setPosition(CGPoint.ccp(selectPosX + selectOffsetX * i,selectPosY));
	            s_selectOff[i].setPosition(CGPoint.ccp(10000,100000));
	            s_content[i].setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,169));
	            
	            if(i >= blockStartIdx){
	                s_block.setPosition(CGPoint.ccp(240-1,s_content[i].getPosition().y + 4));
	                
	                if(Global.isIphone5){
	                    s_block.setPosition(CGPoint.ccp(s_block.getPosition().x + 44, s_block.getPosition().y));
	                }
	            }
	            
	        }else{
	            s_selectOff[i].setPosition(CGPoint.ccp(selectPosX + selectOffsetX * i,selectPosY));
	            s_content[i].setPosition(CGPoint.ccp(10000,100000));
	        }
	    }
	    
	    Global.currentChosenMiniGame =  Global.miniGameOrder[idx];
	    
	    l_minigame.setString(String.format("%d", idx+1));

	    int bestGrade;
	    
	    l_score.setString(String.format("%d", Global.g_bestScore[idx]));
	    
	    if(Global.g_bestScore[idx] <= 9){
	        l_score.setPosition(CGPoint.ccp(277,72));
	    }else{
	         l_score.setPosition(CGPoint.ccp(273,72));
	    }
	    
	    if(Global.isIphone5){
	        l_score.setPosition(CGPoint.ccp(l_score.getPosition().x + 44, l_score.getPosition().y));
	    }
	    
	    if(Global.currentChosenMiniGame == 1){
	        scoreLimitToGrade[0] = 50;
	        scoreLimitToGrade[1] = 100;
	        scoreLimitToGrade[2] = 200;
	        scoreLimitToGrade[3] = 400;
	        scoreLimitToGrade[4] = 700;
	        scoreLimitToGrade[5] = 950;
	    }
	    if(Global.currentChosenMiniGame == 2){
	        scoreLimitToGrade[0] = 40;
	        scoreLimitToGrade[1] = 150;
	        scoreLimitToGrade[2] = 280;
	        scoreLimitToGrade[3] = 400;
	        scoreLimitToGrade[4] = 600;
	        scoreLimitToGrade[5] = 660;
	    }
	    if(Global.currentChosenMiniGame == 3){
	        scoreLimitToGrade[0] = 60;
	        scoreLimitToGrade[1] = 150;
	        scoreLimitToGrade[2] = 250;
	        scoreLimitToGrade[3] = 450;
	        scoreLimitToGrade[4] = 650;
	        scoreLimitToGrade[5] = 800;
	    }
	    if(Global.currentChosenMiniGame == 4){
	        scoreLimitToGrade[0] = 30;
	        scoreLimitToGrade[1] = 70;
	        scoreLimitToGrade[2] = 150;
	        scoreLimitToGrade[3] = 340;
	        scoreLimitToGrade[4] = 550;
	        scoreLimitToGrade[5] = 900;
	    }
	    if(Global.currentChosenMiniGame == 5){
	        scoreLimitToGrade[0] = 50;
	        scoreLimitToGrade[1] = 100;
	        scoreLimitToGrade[2] = 200;
	        scoreLimitToGrade[3] = 350;
	        scoreLimitToGrade[4] = 600;
	        scoreLimitToGrade[5] = 700;
	    }
	    if(Global.currentChosenMiniGame == 10){
	        scoreLimitToGrade[0] = 60;
	        scoreLimitToGrade[1] = 180;
	        scoreLimitToGrade[2] = 250;
	        scoreLimitToGrade[3] = 420;
	        scoreLimitToGrade[4] = 660;
	        scoreLimitToGrade[5] = 900;
	    }
	    if(Global.currentChosenMiniGame == 11){
	        scoreLimitToGrade[0] = 70;
	        scoreLimitToGrade[1] = 120;
	        scoreLimitToGrade[2] = 230;
	        scoreLimitToGrade[3] = 350;
	        scoreLimitToGrade[4] = 530;
	        scoreLimitToGrade[5] = 730;
	    }
	    if(Global.currentChosenMiniGame == 13){
	        scoreLimitToGrade[0] = 40;
	        scoreLimitToGrade[1] = 90;
	        scoreLimitToGrade[2] = 190;
	        scoreLimitToGrade[3] = 350;
	        scoreLimitToGrade[4] = 650;
	        scoreLimitToGrade[5] = 900;
	    }
	    if(Global.currentChosenMiniGame == 103){
	        scoreLimitToGrade[0] = 40;
	        scoreLimitToGrade[1] = 75;
	        scoreLimitToGrade[2] = 170;
	        scoreLimitToGrade[3] = 300;
	        scoreLimitToGrade[4] = 600;
	        scoreLimitToGrade[5] = 850;
	    }
	    
	    
	    if(Global.g_bestScore[idx] < scoreLimitToGrade[0]){
	        bestGrade = Global.kGrade_F;
	    }else if(Global.g_bestScore[idx] < scoreLimitToGrade[1]){
	        bestGrade = Global.kGrade_E;
	    }else if(Global.g_bestScore[idx] < scoreLimitToGrade[2]){
	        bestGrade = Global.kGrade_D;
	    }else if(Global.g_bestScore[idx] < scoreLimitToGrade[3]){
	        bestGrade = Global.kGrade_C;
	    }else if(Global.g_bestScore[idx] < scoreLimitToGrade[4]){
	        bestGrade = Global.kGrade_B;
	    }else if(Global.g_bestScore[idx] < scoreLimitToGrade[5]){
	        bestGrade = Global.kGrade_A;
	    }else{
	        bestGrade = Global.kGrade_S;
	    }
	    
	    if(bestGrade == Global.kGrade_F){
	        if(Global.g_bestScore[Global.miniGameIdx] == 0){
	            l_grade.setString("X");
	        }else{
	            l_grade.setString("F");
	        }
	    }
	    
	    if(bestGrade == Global.kGrade_E){
	        l_grade.setString("E");
	    }  
	    if(bestGrade == Global.kGrade_D){
	        l_grade.setString("D");
	    } 
	    if(bestGrade == Global.kGrade_C){
	        l_grade.setString("C");
	    } 
	    if(bestGrade == Global.kGrade_B){
	        l_grade.setString("B");
	    } 
	    if(bestGrade == Global.kGrade_A){
	        l_grade.setString("A");
	    } 
	    if(bestGrade == Global.kGrade_S){
	        l_grade.setString("S");
	    } 
	    if(bestGrade == Global.kGrade_SS){
	        l_grade.setString("SS");
	    } 
	}
	
	public void  initContent()
	{
	    s_block = CCSprite.sprite("images/selectMini/selectMini_lock.png");
	    s_content[0] = CCSprite.sprite("images/selectMini/selectMini_content01.png");
	     s_content[1] = CCSprite.sprite("images/selectMini/selectMini_content02.png");
	     s_content[2] = CCSprite.sprite("images/selectMini/selectMini_content03.png");
	     s_content[3] = CCSprite.sprite("images/selectMini/selectMini_content04.png");
	     s_content[4] = CCSprite.sprite("images/selectMini/selectMini_content05.png");
	     s_content[5] = CCSprite.sprite("images/selectMini/selectMini_content06.png");
	     s_content[6] = CCSprite.sprite("images/selectMini/selectMini_content07.png");
	     s_content[7] = CCSprite.sprite("images/selectMini/selectMini_content08.png");
	    
	    
	    for(int i = 0 ; i < Global.maxTotalMiniChosen - 2 ; i++){
	        this.addChild(s_content[i]);
	        s_content[i].setPosition(CGPoint.ccp(10001,100000));
	        s_content[i].setScale(1.0f/Global.g_Scale);
	    }
	    
	    this.addChild(s_block);
	    s_block.setPosition(CGPoint.ccp(10001,100000));
	    s_block.setScale(1.0f/Global.g_Scale);
	    
	    
	    selectPosX = 382/2 - 15;
	    selectPosY = 320 - 452/2 - 5;
	    selectOffsetX = 17;
	    
	    if(Global.isIphone5){
	        selectPosX += 44;
	    }
	    
	    for(int i = 0 ; i < Global.maxTotalMiniChosen - 2 ; i++){
	        s_selectOff[i] = CCSprite.sprite("images/selectMini/selectMini_selectOff.png");
	        this.addChild(s_selectOff[i]);
	        s_selectOff[i].setPosition(CGPoint.ccp(10000,100000));
	        s_selectOff[i].setScale(1.0f/Global.g_Scale);
	    }
	    
	    s_selectOn = CCSprite.sprite("images/selectMini/selectMini_selectOn.png");
	    this.addChild(s_selectOn);
	    s_selectOn.setPosition(CGPoint.ccp(10000,100000));
	    s_selectOn.setScale(1.0f/Global.g_Scale);
	}
	
	public void  initLabels()
	{
	    l_minigame = CCLabelAtlas.label("0","font/fontV4.png",20*Global.g_Scale,23*Global.g_Scale,'0');
	    l_minigame.setPosition(CGPoint.ccp(326,267));
	    l_minigame.setScale(1.0f/Global.g_Scale);
	    this.addChild(l_minigame);
	    
	    l_grade = CCLabelAtlas.label("0","font/fontV1.png",12*Global.g_Scale,14*Global.g_Scale,'0');
	    l_grade.setPosition(CGPoint.ccp(301,65));
	    l_grade.setScale( 1.0f/Global.g_Scale );
	    
	    l_score = CCLabelAtlas.label("0","font/fontV1.png",12*Global.g_Scale,14*Global.g_Scale,'0');
	    l_score.setPosition(CGPoint.ccp(273,72));
	    l_score.setScale( 1.0f/Global.g_Scale );
	    this.addChild(l_score);
	    
	    if(Global.isIphone5){
	        l_grade.setPosition(CGPoint.ccp(l_grade.getPosition().x + 44, l_grade.getPosition().y));
	        l_score.setPosition(CGPoint.ccp(l_score.getPosition().x + 44, l_score.getPosition().y));
	        l_minigame.setPosition(CGPoint.ccp(l_minigame.getPosition().x + 44, l_minigame.getPosition().y));
	    }
	    
	    l_score.setAnchorPoint(CGPoint.ccp(0.0,0.5));
	}
	
	SelectMiniGameScene2()
	{
		super();

        setIsTouchEnabled(true);
        isPoppingUp = false;
        isShowingInstruction = false;
        Global.musicController.initForBegin();
        
        CCSprite  s_bg = CCSprite.sprite("images/selectMini/mainMission_bg.png");
        s_bg.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,160));
        s_bg.setScale( 1.0f/Global.g_Scale );
        this.addChild(s_bg);
        
        
        CCSprite  s_bg2 = CCSprite.sprite("images/selectMini/selectMini_bg.png");
        s_bg2.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,160));
        s_bg2.setScale( 1.0f/Global.g_Scale );
        this.addChild(s_bg2);
        
        
        this.initContent();
        this.initMenu();
        this.initLabels();

        
        idx = 0;
        blockStartIdx = 1;
        if(Global.isGoingToNextMiniGame){
            idx = Global.miniGameIdx + 1;
            Global.isGoingToNextMiniGame = false;
        }else{
            idx = Global.miniGameIdx;
        }
        
        for(int i = 0 ; i < 9 ; i++){
            if ( Global.g_DebugAll ) Global.hasPlayedMiniGames[i] = true;

            if(Global.hasPlayedMiniGames[i]){
                blockStartIdx++;
            }
        }
        
        if(Global.isGoingSelectMIniAfterPlay){
        	Global.isGoingSelectMIniAfterPlay = false;
            if(blockStartIdx != Global.maxTotalMiniChosen){
                idx = blockStartIdx - 1;
            }
            
            isTraitionDisappearing = false;
            isTransitioning = true;
            transitionGain = 0;
            transitionTimer = 0;
            transitionOpacity = 255;
            Global.isGoingFromMainPlayScene = false;
            s_transition.setPosition(CGPoint.ccp(240,160));
        }      
        
        if (idx == 8) idx--;
        
        this.updateDisplay();
        
        this.initTransition();
        this.schedule("gameStep");
	}
	
	public void  initMenu()
	{
		CCMenuItem  mLeft = CCMenuItemImage.item("images/ScoreShown/ScoreShown_btn_restartPlay_off.png","images/ScoreShown/ScoreShown_btn_restartPlay_on.png",this,"mLeftCallback");
		CCMenuItem  mRight = CCMenuItemImage.item("images/ScoreShown/ScoreShown_btn_restartPlay_off.png","images/ScoreShown/ScoreShown_btn_restartPlay_on.png",this,"mRightCallback");
		CCMenuItem  mInstruction = CCMenuItemImage.item("images/ScoreShown/ScoreShown_btn_instruction_off.png","images/ScoreShown/ScoreShown_btn_instruction_on.png",this,"mInstructionCallback");
		CCMenuItem  mBack = CCMenuItemImage.item("images/ScoreShown/ScoreShown_btn_restart_off.png","images/ScoreShown/ScoreShown_btn_restart_on.png",this,"mBackCallback");
		
	    mLeft.setPosition(CGPoint.ccp(-181, 0));
		mLeft.setScale( -1.0f/Global.g_Scale );
	    mRight.setPosition(CGPoint.ccp(181, 0));
	    mRight.setScale( 1.0f/Global.g_Scale );
	    mInstruction.setPosition(CGPoint.ccp(204, 125));
	    mBack.setPosition(CGPoint.ccp(-204, 125));
	    
	    mInstruction.setScale(0.79f/Global.g_Scale);
	    mBack.setScale(0.79f/Global.g_Scale);
	    
	    if(Global.isIphone5){
	        mBack.setPosition(CGPoint.ccp(-204 - 44, 125));
	        mInstruction.setPosition(CGPoint.ccp(204 + 44, 125));
	    }
	    
	    menu = CCMenu.menu(mLeft,mInstruction,mRight,mBack);
	    
		this.addChild(menu);
	}
	
	public void  mLeftCallback(Object sender)
	{
	    Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    
	    if(isPoppingUp || isShowingInstruction){
	        return;
	    }
	    
	    idx--;
	    if(idx < 0){
	        idx = Global.maxTotalMiniChosen - 3;
	    }
	    this.updateDisplay();
	}
	
	public void  mRightCallback(Object sender)
	{
	    Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    
	    if(isPoppingUp || isShowingInstruction){
	        return;
	    }
	    
	    idx++;
	    if(idx >= Global.maxTotalMiniChosen - 2){
	        idx = 0;
	    }
	    this.updateDisplay();
	}
	
	public void  mInstructionCallback(Object sender)
	{
	    Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    
	    if(isPoppingUp || isShowingInstruction){
	        return;
	    }
	    
	    if(idx == Global.maxTotalMiniChosen - 1){
	        return;
	    }
	    
	    this.initInstruction();
	    this.showInstruction();
	}
	
	public void  mBackCallback(Object sender)
	{
	    Global.musicController.playThisSound(Global.kSound_ButtonTap,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_ButtonTap2,false,0.2);
	    
	    if(isPoppingUp || isShowingInstruction){
	        return;
	    }
	    
	    CCDirector.sharedDirector().replaceScene( CoverScene.scene());
	}
	
	
	public void  initInstruction()
	{
	    s_dot = CCColorLayer.node(ccColor4B.ccc4(0, 0, 0, 190));
	    this.addChild(s_dot);
	    s_dot.setPosition(CGPoint.ccp(1000,10000));
	    s_dot.setScale( 1.0f/Global.g_Scale );
	    
	    if(idx == 0){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini01.png");
	    }
	    if(idx == 1){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini02.png");
	    }
	    if(idx == 2){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini03.png");
	    }
	    if(idx == 3){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini04.png");
	    }
	    if(idx == 4){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini05.png");
	    }
	    if(idx == 5){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini06.png");
	    }
	    if(idx == 6){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini07.png");
	    }
	    if(idx == 7){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini08.png");
	    }
	    if(idx == 8){
	        s_instruction = CCSprite.sprite("images/Instruction/miniInstruction/instruction_mini09.png");
	    }
	    
	    s_instruction.setAnchorPoint(CGPoint.ccp(0.5,1.0));
	    
	    s_instruction.setPosition(CGPoint.ccp(10000, 10000));
	    s_instruction.setScale( 1.0f/Global.g_Scale );
	    this.addChild(s_instruction);
	}
	public void  showInstruction()
	{
	    isShowingInstruction = true;
	     s_instruction.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2, 255));
	    s_dot.setPosition(CGPoint.ccp(0, 0));
	}
	
	public void  removeInstruction()
	{
	    isShowingInstruction = false;
	    this.removeChild(s_instruction,true);
	    this.removeChild(s_dot,true);
	}
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    if(isPoppingUp){
	        return true;
	    }
	    
	    for( int ii = 0; ii < event.getPointerCount(); ii++ ) {
			CGPoint location = CGPoint.ccp(event.getX(ii), event.getY(ii));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        if(isShowingInstruction){
	            this.removeInstruction();
	            
	            return true;
	        }
	        
	        if(location.x > 107 && location.x < 391){
	            if(location.y > 99 && location.y < 259){
	                if(idx >= blockStartIdx){
	                    return true;
	                }
	                
	                if(isTraitionDisappearing){
	                    return true;
	                }
	                
	                if(idx == Global.maxTotalMiniChosen - 1){
	                    return true;
	                }
	                
	                transitionTimer = 0;
	                isTransitioning = true;
	                isTraitionDisappearing = true;
	            }
	        }
	    }
		return true;
	}
	
	public void  initTransition()
	{
	    isTransitioning = false;
	    s_transition = CCSprite.sprite("blackDot.png");
	    this.addChild(s_transition);
	    s_transition.setScaleX(300);
	    s_transition.setScaleY(200);
	    s_transition.setPosition(CGPoint.ccp(10000,100000));
	    transitionOpacity = 0;
	    transitionGain = 1;
	}
	
	public void  gameStep( float  dt)
	{
	    this.manageTransition();
	}
	
	public void  manageTransition()
	{
	    if(isTransitioning){
	        if(isTraitionDisappearing){
	            transitionOpacity+=20;
	            if(transitionOpacity >= 255){
	                transitionOpacity = 255;
	                isTransitioning = false;
	                
	                Global.miniGameIdx = idx;
	                if(idx == 8){
	                    Global.currentChosenMiniGame = 103;
	                }
	                CCDirector.sharedDirector().replaceScene( PlayScene.scene());
	            }else{
	                
	                transitionGain -= 0.02;
	                if(transitionGain < 0){
	                    transitionGain = 0;
	                }
	                
	                Global.musicController.setmusicGain(transitionGain);
	                
	            }
	            
	            s_transition.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2, Global.VIRT_HEIGHT/2));
	            s_transition.setOpacity(transitionOpacity);
	        }else{
	            transitionOpacity-=15;
	            if(transitionOpacity <= 0){
	                transitionOpacity = 0;
	                isTransitioning = false;
	            }
	            
	            s_transition.setPosition(CGPoint.ccp(240,160));
	            s_transition.setOpacity(transitionOpacity);
	
	        }
	        
	        
	    }
	}
}
