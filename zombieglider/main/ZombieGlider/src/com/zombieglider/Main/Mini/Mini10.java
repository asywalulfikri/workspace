package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.ControlLayer;
import com.zombieglider.Main.Penguin;
import com.zombieglider.Main.Turtle;

public class Mini10 extends MiniBasic
{
     Penguin penguin;
    
    int columnStartX;
    int columnOffsetX;
    int maxColumn;
    int columnX[] = new int[8];
    int columnY;
    int columnIdx;
    int prevColumnIdx;
    
    boolean is2ndFucking;
    
   
    int restingTimer;
    boolean isTargeting[] = new boolean[8];
    
     boolean isAttacking;
    int attackingTimer;
    
    boolean isMinesweepering;
    int minesweeperTimer;
    int nextGenMinesweeperTime;
    
    boolean canMinesweeper;
    boolean isMinesweeper[] = new boolean[8];
    boolean isMinesweeperActiveForHurt[] = new boolean[8];
    boolean isMinesweeperIsDisappearing[] = new boolean[8];
    int isMinesweeperTimer[] = new int[8];
    int isMineseeperCanAppearingTime[] = new int[8];
    int isMinesweeperMaxAppearningTime;
    
    float shellX[] = new float[8];
    float shellY[] = new float[8];
    boolean shellIsExploding[] = new boolean[8];
    Turtle turtle[] = new Turtle[8];
    CCSprite s_arrow[] = new CCSprite[8];
    CCSprite s_minesweeper[] = new CCSprite[8];
    CCSprite s_floor[] = new CCSprite[4];
    
    float arrowOpacity[] = new float[8];
    float shellScaleY[] = new float[8];
    float shellScaleX[] = new float[8];
    
    float mineSweeperScale[] = new float[8];
    float mineSweeperX[] = new float[8];
    float mineSweeperY[] = new float[8];
    
    int restEndTime;
    float shellSpeed;
    int shellAttackTime;
    float arrowScaleVX;
    float arrowVY;
    float arrowVO;
    float shellNumberAppearRatio[] = new float[8];
    
    boolean arrowIsOnOpacity[] = new boolean[8];
    int arrowOnOffOpacityTimer[] = new int[8];
    int arrowOnOffOpacityInterval[] = new int[8];
    
    boolean canBeGainCombo;
    
    boolean isBeingAttack;
    int beingAttackTimer;
    
    boolean isResetPenguin;
    int resetPenguinTimer;
    boolean resetPenguinIsOnOpacity;
    int restPenguinOnOffOpacityTimer;
    int restPenguinOnOffOpacityInterval;
    
    int numShellsGen;
    int howmanyMinesweeperOnScreen;
    int maxHowmanyMinesweeperOnScreen;
    boolean isTapTwoStep;
    
	
	
	public void  reInitColorComboLimit()
	{
	    Global.comboColorLimit[0] = 0;
	    Global.comboColorLimit[1] = 8;
	    Global.comboColorLimit[2] = 16;
	    Global.comboColorLimit[3] = 30;
	    Global.comboColorLimit[4] = 45;
	    Global.comboColorLimit[5] = 60;
	    Global.comboColorLimit[6] = 75;
	    Global.comboColorLimit[7] = 90;
	    Global.comboColorLimit[8] = 120;
	    Global.comboColorLimit[9] = 150;
	    Global.comboColorLimit[10] = 200;
	    
	}
	
	public void  updateGameLevel()
	{
	    if(Global.gameRound < 5){
	        Global.gameLevel = 0;
	    }else if(Global.gameRound < 10){
	        Global.gameLevel = 1;
	    }else if(Global.gameRound < 20){
	        Global.gameLevel = 2;
	    }else if(Global.gameRound < 30){
	        Global.gameLevel = 3;
	    }else if(Global.gameRound < 45){
	        Global.gameLevel = 4;
	    }else if(Global.gameRound < 60){
	        Global.gameLevel = 5;
	    }else if(Global.gameRound < 75){
	        Global.gameLevel = 6;
	    }else if(Global.gameRound < 90){
	        Global.gameLevel = 7;
	    }else if(Global.gameRound < 110){
	        Global.gameLevel = 8;
	    }else if(Global.gameRound < 140){
	        Global.gameLevel = 9;
	    }else if(Global.gameRound < 180){
	        Global.gameLevel = 10;
	    }
	    
	    this.reInitColorComboLimit();
	    
	    arrowScaleVX = 0.1f;
	    arrowVY = 10;
	    arrowVO = 30;
	    
	    if(Global.gameLevel == 0){
	        restEndTime = 60; 
	        shellSpeed = 12;
	        shellAttackTime = 65;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 30;
	        shellNumberAppearRatio[3] = 60;
	        shellNumberAppearRatio[4] = 85;
	        shellNumberAppearRatio[5] = 100;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 900;
	        nextGenMinesweeperTime = 30000;
	        maxHowmanyMinesweeperOnScreen = 0;
	        
	        arrowVY = 10 * 0.5f;
	        
	    }
	    if(Global.gameLevel == 1){
	        restEndTime = 55; 
	        shellSpeed = 13;
	        shellAttackTime = 60;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 30;
	        shellNumberAppearRatio[3] = 70;
	        shellNumberAppearRatio[4] = 100;
	        shellNumberAppearRatio[5] = 100;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 900;
	        nextGenMinesweeperTime = 300;
	        maxHowmanyMinesweeperOnScreen = 3;
	        
	         arrowVY = 10 * 0.55f;
	    }
	    if(Global.gameLevel == 2){
	        restEndTime = 50; 
	        shellSpeed = 14;
	        shellAttackTime = 55;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 20;
	        shellNumberAppearRatio[3] = 45;
	        shellNumberAppearRatio[4] = 80;
	        shellNumberAppearRatio[5] = 95;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 800;
	        nextGenMinesweeperTime = 30000;
	        maxHowmanyMinesweeperOnScreen = 1;
	        
	         arrowVY = 10 * 0.62f;
	    }
	    if(Global.gameLevel == 3){
	        restEndTime = 45; 
	        shellSpeed = 15;
	        shellAttackTime = 55;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 10;
	        shellNumberAppearRatio[3] = 40;
	        shellNumberAppearRatio[4] = 80;
	        shellNumberAppearRatio[5] = 95;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 850;
	        nextGenMinesweeperTime = 500;
	        maxHowmanyMinesweeperOnScreen = 1;
	        
	         arrowVY = 10 * 0.7f;
	    }
	    if(Global.gameLevel == 4){
	        restEndTime = 40; 
	        shellSpeed = 15;
	        shellAttackTime = 55;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 0;
	        shellNumberAppearRatio[3] = 35;
	        shellNumberAppearRatio[4] = 65;
	        shellNumberAppearRatio[5] = 90;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 850;
	        nextGenMinesweeperTime = 400;
	        maxHowmanyMinesweeperOnScreen = 1;
	        
	         arrowVY = 10 * 0.8f;
	    }
	    if(Global.gameLevel == 5){
	        restEndTime = 35; 
	        shellSpeed = 16;
	        shellAttackTime = 55;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 0;
	        shellNumberAppearRatio[3] = 30;
	        shellNumberAppearRatio[4] = 60;
	        shellNumberAppearRatio[5] = 90;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 850;
	        nextGenMinesweeperTime = 400;
	        maxHowmanyMinesweeperOnScreen = 2;
	        
	         arrowVY = 10 * 0.9f;
	    }
	    if(Global.gameLevel == 6){
	        restEndTime = 30; 
	        shellSpeed = 17;
	        shellAttackTime = 50;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 0;
	        shellNumberAppearRatio[3] = 30;
	        shellNumberAppearRatio[4] = 55;
	        shellNumberAppearRatio[5] = 85;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 900;
	        nextGenMinesweeperTime = 400;
	        maxHowmanyMinesweeperOnScreen = 2;
	    }
	    
	    //FIRST INIT
	    if(Global.gameLevel == 7){
	        restEndTime = 25; 
	        shellSpeed = 17;
	        shellAttackTime = 50;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 0;
	        shellNumberAppearRatio[3] = 30;
	        shellNumberAppearRatio[4] = 55;
	        shellNumberAppearRatio[5] = 85;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 900;
	        nextGenMinesweeperTime = 300;
	        maxHowmanyMinesweeperOnScreen = 3;
	    }
	    if(Global.gameLevel == 8){
	        restEndTime = 20; 
	        shellSpeed = 18;
	        shellAttackTime = 45;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 0;
	        shellNumberAppearRatio[3] = 20;
	        shellNumberAppearRatio[4] = 50;
	        shellNumberAppearRatio[5] = 85;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 900;
	        nextGenMinesweeperTime = 300;
	        maxHowmanyMinesweeperOnScreen = 3;
	    }
	    if(Global.gameLevel == 9){
	        restEndTime = 20; 
	        shellSpeed = 20;
	        shellAttackTime = 40;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 0;
	        shellNumberAppearRatio[3] = 15;
	        shellNumberAppearRatio[4] = 45;
	        shellNumberAppearRatio[5] = 85;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 900;
	        nextGenMinesweeperTime = 300;
	        maxHowmanyMinesweeperOnScreen = 3;
	    }
	    if(Global.gameLevel == 10){
	        restEndTime = 15; 
	        shellSpeed = 25;
	        shellAttackTime = 30;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 0;
	        shellNumberAppearRatio[2] = 0;
	        shellNumberAppearRatio[3] = 10;
	        shellNumberAppearRatio[4] = 40;
	        shellNumberAppearRatio[5] = 85;
	        shellNumberAppearRatio[6] = 100;
	        
	        isMinesweeperMaxAppearningTime = 900;
	        nextGenMinesweeperTime = 300;
	        maxHowmanyMinesweeperOnScreen = 3;
	    }
	    
	    
	    if(numShellsGen == 7){
	        shellAttackTime *= 1.5;
	    }
	    
	    if(numShellsGen == 7){
	        shellAttackTime *= 1.5;
	        shellSpeed *= 1.5;
	    }
	    
	    if(numShellsGen == 6){
	        if(Global.gameLevel <= 4){
	            shellAttackTime *= 1.25;
	        }
	    }
	    
	    if(Global.gameRoundFromBegin == 0){
	        restEndTime *= 1.2;
	        shellSpeed *= 0.75;
	        shellAttackTime *= 1.2;
	        
	        shellNumberAppearRatio[0] = 0;
	        shellNumberAppearRatio[1] = 20;
	        shellNumberAppearRatio[2] = 50;
	        shellNumberAppearRatio[3] = 80;
	        shellNumberAppearRatio[4] = 100;
	        shellNumberAppearRatio[5] = 100;
	        shellNumberAppearRatio[6] = 100;
	    }
	    if(Global.gameRoundFromBegin == 1){
	        restEndTime *= 1.15;
	        shellSpeed *= 0.8;
	        shellAttackTime *= 1.15;
	    }
	    
	    if(Global.gameRoundFromBegin == 2){
	        restEndTime *= 1.1;
	        shellSpeed *= 0.85;
	        shellAttackTime *= 1.1;
	    }
	    
	    if(Global.gameRoundFromBegin == 3){
	        shellSpeed *= 0.9;
	    }
	    if(Global.gameRoundFromBegin == 4){
	        shellSpeed *= 0.95;
	    }
	}
	
	public Mini10()
	{
		super();
	    
        finalTimeRemain = Global.timeRemain;
        
        is2ndFucking = false;
        howmanyMinesweeperOnScreen = 0;
        Global.gameRoundFromBegin = 0;
        
        this.updateGameLevel();
        
        s_bg = CCSprite.sprite("images/Main/mini 10/mini_10_bg.png");
        s_bg.setPosition(CGPoint.ccp(240,160));
        s_bg.setScale(1.0f/Global.g_Scale);
		this.addChild(s_bg);
        
        if(Global.isIphone5){
            CCSprite  s_temp_bg = CCSprite.sprite("images/Main/mini 10/mini_10_bg.png");
            s_temp_bg.setPosition(CGPoint.ccp(479,160));
            s_temp_bg.setAnchorPoint(CGPoint.ccp(1,0.5));
            s_temp_bg.setScaleX(1.0f/Global.g_Scale*-1);
            this.addChild(s_temp_bg);
        }
        
        Global.wholeTurtleScaleFromSocurce = 0.435f;
        Global.wholePenguinScaleFromSocurce = 0.5f;
        
        columnIdx = 3;
        Global.gameRound = 0;
        isBeingAttack = false;
            

        this.reInitColorComboLimit();
        this.initColumnPos();
        this.initFloors();
        this.initCharacters();
        this.initLevelsAndItems();
              
        this.initControlLayer();
        
        canBeGainCombo = false;
	}
	
	public void  initFloors()
	{
	    s_floor[0] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1806/2*Global.g_Scale,490/2*Global.g_Scale,242/2*Global.g_Scale,140/2*Global.g_Scale));
	    s_floor[1] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1806/2*Global.g_Scale,490/2*Global.g_Scale,242/2*Global.g_Scale,140/2*Global.g_Scale));
	    s_floor[2] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1806/2*Global.g_Scale,490/2*Global.g_Scale,242/2*Global.g_Scale,140/2*Global.g_Scale));
	    s_floor[3] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1806/2*Global.g_Scale,490/2*Global.g_Scale,242/2*Global.g_Scale,140/2*Global.g_Scale));
	    
	    Global.ss_Character.addChild(s_floor[0],Global.kDeapth_Extra2);
	    Global.ss_Character.addChild(s_floor[1],Global.kDeapth_Extra2);
	    Global.ss_Character.addChild(s_floor[2],Global.kDeapth_Extra2);
	    Global.ss_Character.addChild(s_floor[3],Global.kDeapth_Extra2);
	    
	    s_floor[0].setScale(1.0f / Global.g_Scale);
	    s_floor[1].setScale(1.0f / Global.g_Scale);
	    s_floor[2].setScale(1.0f / Global.g_Scale);
	    s_floor[3].setScale(1.0f / Global.g_Scale);
	    
	    s_floor[0].setPosition(CGPoint.ccp(60,35));
	    s_floor[1].setPosition(CGPoint.ccp(180,35));
	    s_floor[2].setPosition(CGPoint.ccp(300,35));
	    s_floor[3].setPosition(CGPoint.ccp(420,35));
	    
	    if(Global.isIphone5){
	        s_floor[0].setPosition(CGPoint.ccp(s_floor[0].getPosition().x + 44, s_floor[0].getPosition().y));
	        s_floor[1].setPosition(CGPoint.ccp(s_floor[1].getPosition().x + 44, s_floor[1].getPosition().y));
	        s_floor[2].setPosition(CGPoint.ccp(s_floor[2].getPosition().x + 44, s_floor[2].getPosition().y));
	        s_floor[3].setPosition(CGPoint.ccp(s_floor[3].getPosition().x + 44, s_floor[3].getPosition().y));
	    }
	}
	
	
	public void  initLevelsAndItems()
	{
	    for(int i = 0 ; i < maxColumn ; i++){
	        s_minesweeper[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1434/2*Global.g_Scale,610/2*Global.g_Scale,110/2*Global.g_Scale,86/2*Global.g_Scale));
	        s_arrow[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1670/2*Global.g_Scale,490/2*Global.g_Scale,86/2*Global.g_Scale,90/2*Global.g_Scale));
	        
	        Global.ss_Character.addChild(s_minesweeper[i]);
	        Global.ss_Character.addChild(s_arrow[i],Global.kDeapth_Extra2);
	        
	        s_minesweeper[i].setPosition(CGPoint.ccp(10000,10000));
	        s_arrow[i].setPosition(CGPoint.ccp(10000,10000));
	        
	        s_minesweeper[i].setScale(1.0f / Global.g_Scale);
	        s_arrow[i].setScale(1.0f / Global.g_Scale);
	        
	        s_minesweeper[i].setAnchorPoint(CGPoint.ccp(0.5, 0.141176471));
	    }
	    
	    canMinesweeper = true;
	    minesweeperTimer = 0;
	    
	    isAttacking = false;
	    restingTimer = restEndTime;
	    
	    for(int i = 0 ; i < maxColumn ; i++){
	        isMinesweeperTimer[i] = 99999;
	        isMinesweeper[i] = false;
	        isTargeting[i] = false;
	    }
	}
	
	public void  initControlLayer()
	{
	    controlLayer = new ControlLayer();
		this.addChild(controlLayer,Global.kDeapth_Btns);
	    controlLayer.setDelegate(this);
	}
	
	
	public void  initColumnPos()
	{
	    maxColumn = 8;
	    
	      columnStartX = 25;
	      columnOffsetX = 60;
	    
	    if(Global.isIphone5){
	        columnStartX += 44;
	    }
	    
	    for(int i = 0 ; i < maxColumn ; i++){
	        columnX[i] = columnStartX + columnOffsetX * i;
	    }
	    columnY = 70;
	}
	
	public void  initCharacters()
	{
	    penguin = new Penguin();
	    penguin.setX(columnX[columnIdx]);
	    penguin.setY(columnY);
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	    penguin.setDelegate(this);
	    
	    for(int i = 0 ; i < maxColumn ; i++){
	        turtle[i] = new Turtle();
	        turtle[i].setX(10000);
	        turtle[i].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	        turtle[i].setBombOutType(Turtle.kTurtleBombOutType_bombOutOffScreen);
	        turtle[i].setIdNumber(i);
	    }
	    
	}
	
	public void  gotoNextJump()
	{
	    if(Global.next_isFacingRight){
	        
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo1TurtleShell){
	            columnIdx++;
	            if(columnIdx >= maxColumn){
	                columnIdx = 0;
	                Global.penguinJumpFinalX = columnX[maxColumn-1] + columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX += 44;
	                }
	                
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	            }
	            
	        }
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo2TurtleShell){
	            columnIdx+=2;
	            if(columnIdx == maxColumn){
	                columnIdx = 0;
	                Global.penguinJumpFinalX = columnX[maxColumn-1] + columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX += 44;
	                }
	                
	            }else if(columnIdx == maxColumn+1){
	                columnIdx = 1;
	                Global.penguinJumpFinalX = columnX[maxColumn-1] + columnOffsetX*2;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX += 44;
	                }
	                
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	            }
	        }
	        
	       
	        
	    }else{
	        
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo1TurtleShell){
	            columnIdx--;
	            if(columnIdx < 0){
	                columnIdx = maxColumn-1;
	                Global.penguinJumpFinalX = columnX[0] - columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX -= 44;
	                }
	                
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	            }
	            
	        }
	        if(Global.next_jumpType == Penguin.kPenguinJump_jumpTo2TurtleShell){
	            columnIdx-=2;
	            if(columnIdx == 0){
	                columnIdx = maxColumn-1;
	                Global.penguinJumpFinalX = columnX[0] - columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX -= 44;
	                }
	                
	            }else if(columnIdx == -2){
	                columnIdx = maxColumn-2;
	                Global.penguinJumpFinalX = columnX[0] - columnOffsetX*2;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX -= 44;
	                }
	                
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	            }
	        }
	        
	    }
	}
	
	public void  gotoNextDelayOneStep()
	{
	    
	}
	
	public void  resetPenguin()
	{
	    resetPenguinTimer = 0;
	    restPenguinOnOffOpacityTimer = 0;
	    resetPenguinIsOnOpacity = true;
	    isResetPenguin = true;
	    
	    penguin.setX(columnX[columnIdx]);
	    penguin.setY(columnY);
	    
	    penguin.setStatus(Penguin.kPenguinAniStatus_Idle);
	    
	    Global.isTapWronglyAndDisableBtns = false;
	}
	
	public void  manageResetPenguin()
	{
	    if(!isResetPenguin){
	        return;
	    }
	    
	    if(resetPenguinTimer < 20){
	        restPenguinOnOffOpacityInterval = 6;
	    }else if(resetPenguinTimer < 40){
	        restPenguinOnOffOpacityInterval = 4;
	    }if(resetPenguinTimer < 60){
	        restPenguinOnOffOpacityInterval = 3;
	    }
	    
	    restPenguinOnOffOpacityTimer++;
	    if(restPenguinOnOffOpacityTimer > restPenguinOnOffOpacityInterval){
	        restPenguinOnOffOpacityTimer = 0;
	        resetPenguinIsOnOpacity = !resetPenguinIsOnOpacity;
	    }
	    
	    if(resetPenguinIsOnOpacity){
	        penguin.setOpacity(255);
	    }else{
	        penguin.setOpacity(0);
	    }
	    
	    if(resetPenguinTimer == 60){
	        isResetPenguin = false;
	        penguin.setOpacity(255);
	    }
	    
	    resetPenguinTimer++;
	}
	
	public void  manage( float  dt)
	{
		Global.timeRemain += (finalTimeRemain - Global.timeRemain)/10;
	    
	    penguin.manage();
	    
	    for(int i = 0 ; i < maxColumn ; i++){
	        turtle[i].manage(dt);
	    }
	       
	    this.checkIfOutBoundary();
	    
	    this.manageAI();
	    this.manageResetPenguin();
	    
	    this.maangeAttacking();
	    this.manageMinesweepering();
	    
	    if(canBeGainCombo){
	    	Global.uILayer.gainCombo(1);
	        canBeGainCombo = false;
	        Global.gameRoundFromBegin++;
	    }
	}
	
	public void  manageAI()
	{
	    if(isBeingAttack){
	        beingAttackTimer--;
	        if(beingAttackTimer == 0){
	            isBeingAttack = false;
	            isAttacking = false;
	            canMinesweeper = true;
	        }
	        
	        if(beingAttackTimer == 60){
	            this.resetPenguin();
	            Global.currentCombo = 0;
	        }
	    }
	    
	    if(!isBeingAttack){
	        restingTimer--;
	        if(restingTimer == 0){
	            this.genNextAttack();
	        }
	    }
	    
	    if(canMinesweeper){
	        minesweeperTimer++;
	    }
	}
	
	public void  genNextMinesweeper( int _howmany)
	{
	    int minesweeperGenNum;
	    minesweeperGenNum = 0;
	    
	    int leftMinesweeperGened;
	    int rightMinesweeperGened;
	    int leftMinesweeperGened2;
	    int rightMinesweeperGened2;
	    
	    int fuckTime;
	    int fuckTime2;
	    fuckTime = 5;
	    fuckTime2 = 5;
	    
	    
	    int ranMinesweeperGen;
	    ranMinesweeperGen = (int) ((Math.random()*65535) % maxColumn);
	    
	    leftMinesweeperGened = ranMinesweeperGen - 1;
	    if(leftMinesweeperGened < 0){
	        leftMinesweeperGened = maxColumn-1;
	    }
	    
	    leftMinesweeperGened2 = ranMinesweeperGen - 2;
	    if(leftMinesweeperGened2 == 0){
	        leftMinesweeperGened2 = maxColumn-1;
	    }
	    if(leftMinesweeperGened2 == -1){
	        leftMinesweeperGened2 = maxColumn-2;
	    }
	    
	    rightMinesweeperGened = ranMinesweeperGen + 1;
	    if(rightMinesweeperGened >= maxColumn){
	        rightMinesweeperGened = 0;
	    }
	    
	    rightMinesweeperGened2 = ranMinesweeperGen + 2;
	    if(rightMinesweeperGened2 == maxColumn){
	        rightMinesweeperGened2 = 0;
	    }
	    if(rightMinesweeperGened2 == maxColumn+1){
	        rightMinesweeperGened2 = 1;
	    }
	    
	    if(isTargeting[ranMinesweeperGen] && !isMinesweeper[ranMinesweeperGen]  && !isMinesweeper[leftMinesweeperGened]  && !isMinesweeper[rightMinesweeperGened]){
	        if(leftMinesweeperGened == columnIdx || leftMinesweeperGened2 == columnIdx || rightMinesweeperGened == columnIdx || rightMinesweeperGened2 == columnIdx){
	            
	        }else{
	            minesweeperGenNum++;
	            howmanyMinesweeperOnScreen++;
	            
	            isMinesweeper[ranMinesweeperGen] = true;
	            isMinesweeperTimer[ranMinesweeperGen] = 0;
	            isMinesweeperActiveForHurt[ranMinesweeperGen] = false;
	            isMineseeperCanAppearingTime[ranMinesweeperGen] = isMinesweeperMaxAppearningTime;
	            isMinesweeperIsDisappearing[ranMinesweeperGen] = false;
	            
	            Global.musicController.playThisSound(Global.kSound_Minesweeper,false,1.0);
	            Global.musicController.playThisSound(Global.kSound_MinesweeperV2,false,0.65);
	        }
	    }
	    
	    
	}
	
	public void  genNextAttack()
	{
	    isAttacking = true;
	    attackingTimer = 0;
	    
	    Global.gameRound++;
	    Global.counterForAchivement++;
	    
	
	    int ranNumShells;
	    ranNumShells = (int) ((Math.random()*65535)%100);
	    int numShells = 0;
	    
	    if(ranNumShells < shellNumberAppearRatio[0]){
	        numShells = 1;
	    }else if(ranNumShells < shellNumberAppearRatio[1]){
	        numShells = 2;
	    }else if(ranNumShells < shellNumberAppearRatio[2]){
	        numShells = 3;
	    }else if(ranNumShells < shellNumberAppearRatio[3]){
	        numShells = 4;
	    }else if(ranNumShells < shellNumberAppearRatio[4]){
	        numShells = 5;
	    }else if(ranNumShells < shellNumberAppearRatio[5]){
	        numShells = 6;
	    }else if(ranNumShells < shellNumberAppearRatio[6]){
	        numShells = 7;
	    }
	    
	    int avialableColumnEscape;
	    avialableColumnEscape = maxColumn;
	    for(int i = 0 ; i < maxColumn ; i++){
	        if(isMinesweeper[i]){
	            avialableColumnEscape--;
	        }
	    }
	    
	    numShellsGen = 0;
	    
	    do{
	        
	        int ranTarget;
	        ranTarget = (int) ((Math.random()*65535) % 8);
	        
	        if(!isTargeting[ranTarget]){
	            isTargeting[ranTarget] = true;
	            arrowIsOnOpacity[ranTarget] = true;
	            arrowOnOffOpacityTimer[ranTarget] = 0;
	            numShells--;
	            numShellsGen++;
	            
	            if(!isMinesweeper[ranTarget]){
	                avialableColumnEscape--;
	            }
	        }
	    
	    }while(numShells > 0 && avialableColumnEscape > 1);
	    
	    this.updateGameLevel();
	    Global.musicController.playThisSound(Global.kSound_Arrows,false,1.0);
	
	}
	
	
	public void  maangeAttacking()
	{
	    if(!isAttacking){
	        for(int i = 0 ; i < maxColumn ; i++){
	            s_arrow[i].setOpacity(0);
	        }
	        
	        return;
	    }
	    
	    for( int i = 0 ; i < maxColumn ; i++){
	        if(isTargeting[i]){
	            if(attackingTimer == 0){
	                s_arrow[i].setPosition(CGPoint.ccp(30 + 60 * i, 240));
	                
	                if(Global.isIphone5){
	                    s_arrow[i].setPosition(CGPoint.ccp(s_arrow[i].getPosition().x + 44, s_arrow[i].getPosition().y));
	                }
	                
	                s_arrow[i].setScaleY(1.0f/Global.g_Scale*1);
	                s_arrow[i].setScaleX(1.0f/Global.g_Scale*1.3);
	                
	                shellX[i] = 30 + 60 * i;
	                shellY[i] = 350;
	                
	                if(Global.isIphone5){
	                    shellX[i] += 44;
	                }
	                
	                if(i < 4){
	                    turtle[i].bombOutOffScreenDirection(Turtle.kBombOutOffScreenDirection_Left);
	                }else{
	                    turtle[i].bombOutOffScreenDirection(Turtle.kBombOutOffScreenDirection_Right);
	                }
	                
	                arrowOpacity[i] = 255;
	                
	                shellIsExploding[i] = false;
	                
	                shellScaleY[i] = 2.0f;
	                shellScaleX[i] = 1.35f;
	            }
	            
	            
	            if(attackingTimer == shellAttackTime){
	                turtle[i].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	                turtle[i].resetHurtTime();
	                turtle[i].setRotation(180);
	            }
	
	            if(attackingTimer >= shellAttackTime){
	                arrowOpacity[i] -= arrowVO;
	                if( arrowOpacity[i] < 0){
	                    arrowOpacity[i] = 0;
	                } 
	                
	                s_arrow[i].setOpacity(arrowOpacity[i]);
	                s_arrow[i].setScaleX(s_arrow[i].getScaleX() - 1.0f/Global.g_Scale*arrowScaleVX);
	                s_arrow[i].setPosition(CGPoint.ccp(s_arrow[i].getPosition().x, s_arrow[i].getPosition().y - arrowVY));
	            }else{
	                float shellGoingAttackPercentage;
	                shellGoingAttackPercentage = (float)attackingTimer/(float)shellAttackTime;
	                
	                if(shellGoingAttackPercentage < 0.2){
	                    arrowOnOffOpacityInterval[i] = 10;
	                }else if(shellGoingAttackPercentage < 0.5){
	                    arrowOnOffOpacityInterval[i] = 8;
	                }else if(shellGoingAttackPercentage < 0.8){
	                    arrowOnOffOpacityInterval[i] = 6;
	                }else{
	                    arrowOnOffOpacityInterval[i] = 3;
	                }
	                
	                if(arrowOnOffOpacityTimer[i] >= arrowOnOffOpacityInterval[i]){
	                    arrowOnOffOpacityTimer[i] = 0;
	                    arrowIsOnOpacity[i] = !arrowIsOnOpacity[i];
	                }
	                
	                if(arrowIsOnOpacity[i]){
	                    s_arrow[i].setOpacity(255);
	                }else{
	                    s_arrow[i].setOpacity(0);
	                }
	                
	                arrowOnOffOpacityTimer[i]++;
	            }
	            
	            
	            if(attackingTimer > shellAttackTime &&  !shellIsExploding[i]){
	                shellY[i] -= shellSpeed;
	                
	                turtle[i].setX(shellX[i]);
	                turtle[i].setY(shellY[i]);
	                
	                shellScaleY[i] -= 0.1;
	                if(shellScaleY[i] < 1){
	                    shellScaleY[i] = 1;
	                }
	                
	                shellScaleX[i] -= 0.75;
	                if(shellScaleX[i] < 0.85){
	                    shellScaleX[i] = 0.85f;
	                }
	                
	                turtle[i].setScaleXForShell(shellScaleX[i]);
	                turtle[i].setScaleYForShell(shellScaleY[i]);
	            }
	            
	            if(shellY[i] < 250 && shellY[i] > 160 && isBeingAttack){
	                shellIsExploding[i] = true;
	                turtle[i].tap2();
	                turtle[i].setX(1000);
	                isTargeting[i] = false;
	                restingTimer = restEndTime;
	            }
	            
	            if(shellY[i] < 180){
	                this.checkToGiveNextMinesweeper();
	            } 
	            
	            if(shellY[i] < 120 && i == columnIdx){
	                shellIsExploding[i] = true;
	                turtle[i].tap2();
	                isTargeting[i] = false;

	                this.bombombomb();
	
	            }else{
	                if(shellY[i] < 75){
	                    shellIsExploding[i] = true;
	                    turtle[i].tap2();
	                    isAttacking = false;
	                    restingTimer = restEndTime;
	                    isTargeting[i] = false;
	                    
	                    canBeGainCombo = true;
	                    
	                }
	            }
	        }
	    }
	    
	    
	    attackingTimer++;
	}
	
	public void  manageMinesweepering()
	{
	    for(int i = 0 ; i < maxColumn ; i++){
	        if(isMinesweeper[i]){
	            
	            if(!isMinesweeperIsDisappearing[i]){
	                
	                if(isMinesweeperTimer[i] == 0){
	                    mineSweeperScale[i] = 0.1f;
	                    
	                    mineSweeperX[i] = 30 + i * 60;
	                    
	                    if(Global.isIphone5){
	                        mineSweeperX[i] += 44;
	                    }
	                    
	                    mineSweeperY[i] = 65;
	                    s_minesweeper[i].setPosition(CGPoint.ccp(mineSweeperX[i],  mineSweeperY[i]));
	                }
	                
	                if(isMinesweeperTimer[i] < 12){
	                    mineSweeperScale[i] += 0.1;
	                }else{
	                    mineSweeperScale[i] += (1 - mineSweeperScale[i])/15.0;
	                }
	                
	                s_minesweeper[i].setScale( mineSweeperScale[i]/Global.g_Scale);
	                
	                if(isMinesweeperTimer[i] == 10){
	                    isMinesweeperActiveForHurt[i] = true;
	                }
	                
	                if(isMinesweeperTimer[i] == isMineseeperCanAppearingTime[i]){
	                    for(int j = 0 ; j < maxColumn ; j++){
	                        if(isMinesweeper[j]){
	                            isMinesweeperIsDisappearing[j] = true;
	                             isMinesweeperTimer[j] = 0;
	                             isMinesweeperActiveForHurt[j] = false;
	                        }
	                    }
	                }
	            }else{
	                
	                if(isMinesweeperTimer[i] == 1){
	                    Global.playLayer.setToShakingBomb(mineSweeperX[i],mineSweeperY[i]);
	                }
	                
	                if(isMinesweeperTimer[i] < 5){
	                    mineSweeperScale[i] += 0.09;
	                }else{
	                    mineSweeperScale[i] += (0 - mineSweeperScale[i])/7.0;
	                }
	                
	                s_minesweeper[i].setScale( mineSweeperScale[i]/Global.g_Scale);
	                
	                if(isMinesweeperTimer[i] == 20){
	                    isMinesweeper[i] = false;
	                    
	                    s_minesweeper[i].setPosition(CGPoint.ccp(10000,1000));
	                    howmanyMinesweeperOnScreen--;
	                }
	            }
	            
	            isMinesweeperTimer[i]++;
	        }
	        
	        int jumpToFuckStep;
	        if(isTapTwoStep){
	            jumpToFuckStep = 6;
	        }else{
	            jumpToFuckStep = 2;
	        }
	        
	        if(penguin.jumpingAniStep() > jumpToFuckStep && !isBeingAttack){
	            if(isMinesweeperActiveForHurt[i]){
	                if(i == columnIdx){
	                    this.bombombomb();
	                }
	            }
	        }
	    }
	}
	
	public void  bombombomb()
	{
		Global.uILayer.lostCombo();
	    
	    finalTimeRemain -= 10.05;
	    Global.gameRoundFromBegin = 0;
	    
	    Global.isTapWronglyAndDisableBtns = true;
	    
	    canMinesweeper = false;
	    isBeingAttack  = true;
	    beingAttackTimer = 200;
	    restingTimer = 60;
	    
	    int bombgXPos;
	    bombgXPos = columnIdx * 60 + 30;
	    
	    Global.playLayer.setToBombingGameoverWithPos(bombgXPos,120);
	    if(penguin.facingRight()){
	        penguin.bombOutOffScreenDirection(Penguin.kBombOutOffScreenDirection_Left_Penguin);
	    }else{
	        penguin.bombOutOffScreenDirection(Penguin.kBombOutOffScreenDirection_Right_Penguin);
	    }
	    penguin.setToBombing();
	    
	    this.bombOutAllMinesweeper();
	}
	
	public void  checkToGiveNextMinesweeper()
	{
	    if(maxHowmanyMinesweeperOnScreen == 0){
	        return;
	    }
	    
	    if(minesweeperTimer >= nextGenMinesweeperTime){
	        this.genNextMinesweeper(2);
	     
	        if(howmanyMinesweeperOnScreen >= maxHowmanyMinesweeperOnScreen){
	            minesweeperTimer = 0;
	        }
	    }
	}
	
	public void  checkIfOutBoundary()
	{
	    float pneuginOutX;
	    
	    if(penguin.status() == Penguin.kPenguinAniStatus_Jumping){
	        
	        int checkOutsideBoudary;
	        if(Global.isIphone5){
	            checkOutsideBoudary = 470 + 88;
	        }else{
	            checkOutsideBoudary = 470;
	        }
	        
	        if(penguin.jumpingX() > checkOutsideBoudary && penguin.facingRight()){
	            pneuginOutX  = penguin.jumpingX() - checkOutsideBoudary;
	            
	            int apperarOffsetX;
	            if(Global.isIphone5){
	                apperarOffsetX = -44;
	            }else{
	                apperarOffsetX = 0;
	            }
	            if(is2ndFucking){
	                is2ndFucking = false;
	                penguin.setX(-pneuginOutX - 20 - columnOffsetX + apperarOffsetX);
	            }else{
	                penguin.setX(-pneuginOutX - 20 + apperarOffsetX);
	            }
	             
	            
	            Global.penguinJumpFinalX = columnX[columnIdx];
	            
	        }
	        
	        if(penguin.jumpingX() < 10 && !penguin.facingRight()){
	            pneuginOutX  = penguin.jumpingX() - 10;
	            int setXValue;
	            setXValue = 480;
	            if(Global.isIphone5){
	                setXValue = 568;
	            }
	            
	            if(is2ndFucking){
	                is2ndFucking = false;
	                penguin.setX(setXValue - pneuginOutX + 20 + columnOffsetX);
	            }else{
	                penguin.setX(setXValue - pneuginOutX + 20);
	            }
	            
	            
	            Global.penguinJumpFinalX = columnX[columnIdx];
	            
	        }
	    }
	}
	
	public  boolean ccTouchesBegan( MotionEvent event)
	{
	    super.ccTouchesBegan(event);
	    
	    if(Global.isTapWronglyAndDisableBtns){
	        return true;
	    }
	    
	    if(Global.isStopping){
	        return true;
	    }
		return true;
	}
	
	public void  btnIsTappedInControlLayer( int _btnIdx)
	{
	    Global.musicController.playThisSound(Global.kSound_PenguinJump,false,0.25);
	    
	    if(_btnIdx == 0){
	        
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	            prevColumnIdx = columnIdx;
	            isTapTwoStep = true;
	            
	            columnIdx-=2;
	            if(columnIdx == -1){
	                is2ndFucking = true;
	                columnIdx = maxColumn-1;
	                Global.penguinJumpFinalX = columnX[0] - columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX -= 44;
	                }
	                
	            }else if(columnIdx == -2){
	                columnIdx = maxColumn-2;
	                Global.penguinJumpFinalX = columnX[0] - columnOffsetX*2;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX -= 44;
	                }
	                
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	                
	            }
	            
	            penguin.setFacingRight(false);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo2TurtleShell);
	            
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo2TurtleShell,false);
	        }
	        
	    }
	    
	    
	    
	    if(_btnIdx == 1){
	        
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	             prevColumnIdx = columnIdx;
	            
	            columnIdx--;
	            if(columnIdx < 0){
	                columnIdx = maxColumn-1;
	                Global.penguinJumpFinalX = columnX[0] - columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX -= 44;
	                }
	                
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	            }
	
	            
	            penguin.setFacingRight(false);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo1TurtleShell);
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo1TurtleShell,false);
	        }
	        
	        
	    }
	    if(_btnIdx == 2){
	        
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	             prevColumnIdx = columnIdx;
	            
	            columnIdx++;
	            if(columnIdx >= maxColumn){
	                columnIdx = 0;
	                Global.penguinJumpFinalX = columnX[maxColumn-1] + columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX += 44;
	                }
	
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	            }
	            
	            
	            penguin.setFacingRight(true);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo1TurtleShell);
	            
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo1TurtleShell,true);
	        }
	
	    }
	    if(_btnIdx == 3){
	        
	        if(penguin.status() != Penguin.kPenguinAniStatus_Jumping){
	             prevColumnIdx = columnIdx;
	            isTapTwoStep = true;
	            
	            columnIdx+=2;
	            if(columnIdx == maxColumn){
	                columnIdx = 0;
	                Global.penguinJumpFinalX = columnX[maxColumn-1] + columnOffsetX;
	                Global.penguinJumpFinalY = columnY;
	                is2ndFucking = true;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX += 44;
	                }
	                
	            }else if(columnIdx == maxColumn+1){
	                columnIdx = 1;
	                Global.penguinJumpFinalX = columnX[maxColumn-1] + columnOffsetX*2;
	                Global.penguinJumpFinalY = columnY;
	                
	                if(Global.isIphone5){
	                	Global.penguinJumpFinalX += 44;
	                }
	                
	            }else{
	            	Global.penguinJumpFinalX = columnX[columnIdx];
	            	Global.penguinJumpFinalY = columnY;
	            }
	            
	            penguin.setFacingRight(true);
	            
	            penguin.setJump(Penguin.kPenguinJump_jumpTo2TurtleShell);
	            
	        }else{
	            penguin.setNext(Penguin.kPenguinJump_jumpTo2TurtleShell,true);
	        }
	    }
	}
	
	public void  tapTurtle()
	{
	
	}
	
	public void  bombOutAllMinesweeper()
	{
	    for(int i = 0 ; i < maxColumn ; i++){
	        if(isMinesweeper[i]){
	            isMinesweeperActiveForHurt[i] = false;
	            isMinesweeper[i] = false;
	            s_minesweeper[i].setPosition(CGPoint.ccp(10000,1000));
	            Global.playLayer.setToBombingTimePlus(mineSweeperX[i],mineSweeperY[i]);
	            
	            howmanyMinesweeperOnScreen--;
	        }
	    }
	}
	
	public void  restart()
	{
	    this.bombombomb();
	    super.updateGameLevel();
	    finalTimeRemain = Global.maxTime;
	}
}
