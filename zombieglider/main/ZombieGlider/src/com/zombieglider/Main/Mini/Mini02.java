package com.zombieglider.Main.Mini;


import org.cocos2d.types.CGRect;
import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCDirector;
import org.cocos2d.nodes.CCSprite;

import android.view.MotionEvent;

import com.zombieglider.Global;
import com.zombieglider.Main.Penguin;
import com.zombieglider.Main.Turtle;

class eGeneralMini02Character{
	int idxR;
    int whichType; // 0 for turtle, 1 for penguin
    float posX;
    float posY;
    float vx;
    float vy;
    float r;
    float vr;
    boolean isAni;
    boolean isLarging;
    
    int ufoType;
    int ufoInteveral;
    int ufoIntervalTimer;
    float ufoVx;
    float ufoVy;
    float ufoSpeed;
    int ufoIdx;
};


public class Mini02 extends MiniBasic
{
    eGeneralMini02Character generalMini02Character[] = new eGeneralMini02Character[60];
    int generalCharacterIdx;
    int maxGeneralCharacter;
    
    float generalCharacterScale;
    
    Turtle turtle[] = new Turtle[30];
    Penguin penguin[] = new Penguin[30]; 
    
    int maxTurtle;
    int maxPenguin;
    
    int turtleIdx;
    int penguinIdx;
    
    
    int howmanyTurtleOnScreen;
    int howmanyPenguinOnScreen;
    
    boolean hasGen;
    int hasGenTimer;
    int genNextTimer;
    
    
    
    boolean isAllowLarging;
    int isAllowLargingTimer;
    
    boolean isLarging;
    int isLargingTimer;
    float isLargingScale;
    boolean generalCharacterIsLarging[] = new boolean[60];
    
    int sperateSpace;
    
    CCSprite s_ufo1[] = new CCSprite[20];
     CCSprite s_ufo2[] = new CCSprite[20];
     CCSprite s_ufo3[] = new CCSprite[20];
    int ufoTypeAppearRatio[] = new int[3];
    int ufo1Idx;
    int ufo2Idx;
    int ufo3Idx;
    int maxUfoInOneType;
    
    
    CCSprite s_digits[][] = new CCSprite[4][2];
    int digits[] = new int[4];
    int maxDigitNumber;
    int digit_textureX;
    int digit_textureY;
    int digit_textureWidth;
    int digit_textureHeight;
    int digit_posX[] = new int[4];
    int digit_posY[] = new int[4];
    int correctAnswer;
    int correctAnswerIdx;

    int script_howmanyUFOGenMin;
    int script_howmanyUFOGenRatio;
    
    int script_digitLowerLimit;
    int script_digitUpperLimit;
    int script_lowerUpperOffsetRatio;
    
    float script_ufo2MinV;
    float script_ufo2VxInterval;
    float script_ufo2VyInterval;
    float script_ufo2VRInterval;
    
    int script_ufo3IntervalTime;
    int script_ufo3SpeendRatio;
    float script_ufo3MinSpeed;
    
    CCSprite s_correct;
    CCSprite s_wrong;
    boolean isCorrect;
    boolean isCorrectWrongAni;
    int correctWrongAniTimer;
    
    //use for correct ani
    float plusTimeX;
    float plusTimeY;
    float plusTimeSX;
    float plusTimeSY;
    float plusTimeOpacity;
     float gameover_scale;
    float gameover_opacity;
    
    CCSprite s_tempWrongNotice;
    float wrongNoticeOpacity;
    int tapWhich;


	
	public void  updategameLevel()
	{
	    Global.comboColorLimit[0] = 0;
	    Global.comboColorLimit[1] = 3;
	    Global.comboColorLimit[2] = 6;
	    Global.comboColorLimit[3] = 9;
	    Global.comboColorLimit[4] = 12;
	    Global.comboColorLimit[5] = 15;
	    Global.comboColorLimit[6] = 18;
	    Global.comboColorLimit[7] = 21;
	    Global.comboColorLimit[8] = 24;
	    Global.comboColorLimit[9] = 27;
	    Global.comboColorLimit[10] = 30;
	    
	    if(Global.gameRound <= 4){
	        Global.gameLevel = 0;
	    }else if(Global.gameRound <= 8){
	        Global.gameLevel = 1;
	    }else if(Global.gameRound <= 14){
	        Global.gameLevel = 2;
	    }else if(Global.gameRound <= 20){
	        Global.gameLevel = 3;
	    }else if(Global.gameRound <= 26){
	        Global.gameLevel = 4;
	    }else if(Global.gameRound <= 32){
	        Global.gameLevel = 5;
	    }else if(Global.gameRound <= 40){
	        Global.gameLevel = 6;
	    }else if(Global.gameRound <= 48){
	        Global.gameLevel = 7;
	    }else if(Global.gameRound <= 56){
	        Global.gameLevel = 8;
	    }else if(Global.gameRound <= 64){
	        Global.gameLevel = 9;
	    }else if(Global.gameRound <= 75){
	        Global.gameLevel = 10;
	    }
	    script_ufo2VxInterval = 0;
	    script_ufo2VyInterval = 0;
	    script_ufo2VRInterval = 1.5f;
	    
	    if(Global.gameLevel == 0){
	        ufoTypeAppearRatio[0] = 100;
	        ufoTypeAppearRatio[1] = 100;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 2;
	        script_howmanyUFOGenRatio = 3;
	        
	        script_digitLowerLimit = 2;
	        script_digitUpperLimit = 2;
	        script_lowerUpperOffsetRatio = 2;
	    }
	    if(Global.gameLevel == 1){
	        ufoTypeAppearRatio[0] = 80;
	        ufoTypeAppearRatio[1] = 100;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 3;
	        script_howmanyUFOGenRatio = 3;
	        
	        script_digitLowerLimit = 2;
	        script_digitUpperLimit = 3;
	        script_lowerUpperOffsetRatio = 2;
	        
	        script_ufo2MinV = 0.2f;
	    }
	    if(Global.gameLevel == 2){
	        ufoTypeAppearRatio[0] = 60;
	        ufoTypeAppearRatio[1] = 100;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 3;
	        script_howmanyUFOGenRatio = 4;
	        
	        script_digitLowerLimit = 2;
	        script_digitUpperLimit = 3;
	        script_lowerUpperOffsetRatio = 2;
	        
	        script_ufo2MinV = 0.3f;
	    }
	    if(Global.gameLevel == 4){
	        ufoTypeAppearRatio[0] = 60;
	        ufoTypeAppearRatio[1] = 90;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 4;
	        script_howmanyUFOGenRatio = 5;
	        
	        script_digitLowerLimit = 3;
	        script_digitUpperLimit = 3;
	        script_lowerUpperOffsetRatio = 3;
	        
	        script_ufo2MinV = 0.4f;
	        
	        script_ufo3IntervalTime = 60;
	        script_ufo3SpeendRatio = 6;
	        script_ufo3MinSpeed = 3;
	    }
	    if(Global.gameLevel == 5){
	        ufoTypeAppearRatio[0] = 50;
	        ufoTypeAppearRatio[1] = 85;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 5;
	        script_howmanyUFOGenRatio = 5;
	        
	        script_digitLowerLimit = 3;
	        script_digitUpperLimit = 3;
	        script_lowerUpperOffsetRatio = 3;
	        
	        script_ufo2MinV = 0.4f;
	        
	        script_ufo3IntervalTime = 60;
	        script_ufo3SpeendRatio = 6;
	        script_ufo3MinSpeed = 4;
	    }
	    if(Global.gameLevel == 6){
	        ufoTypeAppearRatio[0] = 45;
	        ufoTypeAppearRatio[1] = 80;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 5;
	        script_howmanyUFOGenRatio = 7;
	        
	        script_digitLowerLimit = 2;
	        script_digitUpperLimit = 2;
	        script_lowerUpperOffsetRatio = 3;
	        
	        script_ufo2MinV = 0.5f;
	        
	        script_ufo3IntervalTime = 60;
	        script_ufo3SpeendRatio = 6;
	        script_ufo3MinSpeed = 5;
	    }
	    if(Global.gameLevel == 7){
	        ufoTypeAppearRatio[0] = 40;
	        ufoTypeAppearRatio[1] = 75;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 6;
	        script_howmanyUFOGenRatio = 8;
	        
	        script_digitLowerLimit = 2;
	        script_digitUpperLimit = 2;
	        script_lowerUpperOffsetRatio = 3;
	        
	        script_ufo2MinV = 0.5f;
	        
	        script_ufo3IntervalTime = 60;
	        script_ufo3SpeendRatio = 6;
	        script_ufo3MinSpeed = 5;
	    }
	    
	    if(Global.gameLevel == 8){
	        ufoTypeAppearRatio[0] = 33;
	        ufoTypeAppearRatio[1] = 66;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 7;
	        script_howmanyUFOGenRatio = 8;
	        
	        if((Math.random()*65535) % 2 == 0){
	            script_digitLowerLimit = 1;
	            script_digitUpperLimit = 2;
	        }else{
	            script_digitLowerLimit = 2;
	            script_digitUpperLimit = 1;
	        }
	        script_lowerUpperOffsetRatio = 4;
	        
	        script_ufo2MinV = 0.6f;
	        
	        script_ufo3IntervalTime = 60;
	        script_ufo3SpeendRatio = 6;
	        script_ufo3MinSpeed = 5;
	    }
	    if(Global.gameLevel == 9){
	        ufoTypeAppearRatio[0] = 33;
	        ufoTypeAppearRatio[1] = 66;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 8;
	        script_howmanyUFOGenRatio = 9;
	        
	        if((Math.random()*65535) % 2 == 0){
	            script_digitLowerLimit = 1;
	            script_digitUpperLimit = 2;
	        }else{
	            script_digitLowerLimit = 2;
	            script_digitUpperLimit = 1;
	        }
	        script_lowerUpperOffsetRatio = 4;
	        
	        script_ufo2MinV = 0.6f;
	        
	        script_ufo3IntervalTime = 45;
	        script_ufo3SpeendRatio = 6;
	        script_ufo3MinSpeed = 5;
	    }
	    if(Global.gameLevel == 10){
	        ufoTypeAppearRatio[0] = 33;
	        ufoTypeAppearRatio[1] = 66;
	        ufoTypeAppearRatio[2] = 100;
	        
	        script_howmanyUFOGenMin = 8;
	        script_howmanyUFOGenRatio = 12;
	        
	        if((Math.random()*65535) % 2 == 0){
	            script_digitLowerLimit = 1;
	            script_digitUpperLimit = 2;
	        }else{
	            script_digitLowerLimit = 2;
	            script_digitUpperLimit = 1;
	        }
	        script_lowerUpperOffsetRatio = 3;
	        
	        script_ufo2MinV = 0.7f;
	        
	        script_ufo3IntervalTime = 40;
	        script_ufo3SpeendRatio = 6;
	        script_ufo3MinSpeed = 7;
	    }
	    
	}
	
	public Mini02()
	{
		super();
	        
		Global.comoboReduceSpeed = 0.0005f;
	        
		Global.maxTime = 50;
		Global.timeRemain = Global.maxTime;
        
        this.updategameLevel();
        
        Global.wholeTurtleScaleFromSocurce = 1.0f;
        Global.wholePenguinScaleFromSocurce = 0.5f;
        
        s_bg = CCSprite.sprite("images/Main/mini 02/mini_02_bg.png");
        s_bg.setPosition(CGPoint.ccp(240,160));
        s_bg.setScale( 1.0f/Global.g_Scale );
		this.addChild(s_bg);
        
        if(Global.isIphone5){
            CCSprite  s_temp_bg = CCSprite.sprite("images/Main/mini 02/mini_02_bg.png");
            s_temp_bg.setPosition(CGPoint.ccp(479,160));
            s_temp_bg.setAnchorPoint(CGPoint.ccp(1,0.5));
            s_temp_bg.setScaleX(1.0f/Global.g_Scale*-1);
            this.addChild(s_temp_bg);
        }
        
        this.initGenNext();
        this.initCharacters();
        this.initGeneralCharacter();
        this.initLarging();
        this.initPanel();
        this.initCorrectWrong();
	}
	
	public void  initPanel()
	{
	    CCSprite  s_tempPanel = CCSprite.sprite("images/Main/tempPanel.png");
	    s_tempPanel.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2,39));
	    s_tempPanel.setScale( 1.0f/Global.g_Scale );
	    this.addChild(s_tempPanel,Global.kDeapth_miniBasic);
	    
	    s_tempWrongNotice = CCSprite.sprite("images/Main/tempWrongNotice.png");
	    s_tempWrongNotice.setScale( 1.0f/Global.g_Scale );
	    s_tempWrongNotice.setPosition(CGPoint.ccp(24000,41));
	    this.addChild(s_tempWrongNotice,Global.kDeapth_miniBasic);
	    
	    maxDigitNumber = 4;
	    for(int i = 0 ; i < maxDigitNumber ; i++){
	        for(int j = 0 ; j < 2 ; j++){
	            s_digits[i][j] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(0,0,0,0));
	            Global.ss_Character.addChild(s_digits[i][j]);
	            s_digits[i][j].setPosition(CGPoint.ccp(10000,10000));
	            s_digits[i][j].setScale(1.0f/Global.g_Scale*0.9f);
	        }
	    }
	    
	    digit_textureX = 1400/2*Global.g_Scale;
	    digit_textureY = 834/2*Global.g_Scale;
	    digit_textureWidth = 50/2*Global.g_Scale;
	    digit_textureHeight = 62/2*Global.g_Scale;
	    
	    digit_posX[0] = 160;
	    digit_posX[1] = 320;
	    digit_posX[2] = 160;
	    digit_posX[3] = 320;
	    
	    if(Global.isIphone5){
	        digit_posX[0] += 44;
	        digit_posX[1] += 44;
	        digit_posX[2] += 44;
	        digit_posX[3] += 44;
	    }
	    
	    digit_posY[0] = 65-5;
	    digit_posY[1] = 65-5;
	    digit_posY[2] = 20-5;
	    digit_posY[3] = 20-5;
	    
	}
	
	public void  initLarging()
	{
	    isLarging = false;
	    isAllowLarging = false;
	    isAllowLargingTimer = 0;
	    isLargingTimer = 0;
	}
	
	public void  initGenNext()
	{
	    genNextTimer = 10;
	    hasGen = false;
	}
	
	public void  initCharacters()
	{
	    maxPenguin = 0;
	    maxTurtle = 0;
	    
	    for(int i = 0 ; i < maxPenguin ; i++){
	        penguin[i] = new Penguin();
	        penguin[i].setX(99999);
	        penguin[i].setY(99999);
	        penguin[i].setStatus(Penguin.kPenguinAniStatus_Idle);
	    }
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i] = new Turtle();
	        turtle[i].setX(99999);
	        turtle[i].setY(99999);
	        turtle[i].setStatus(Turtle.kTurtleAniStatus_Normal_In);
	        turtle[i].setIdNumber(i);
	        turtle[i].setDelegate(this);
	    }
	}
	
	public void  initGeneralCharacter()
	{
	    ufo1Idx = 0;
	    ufo2Idx = 0;
	    ufo3Idx = 0;
	    maxUfoInOneType = 20;
	    
	    for(int i = 0 ; i < maxUfoInOneType ; i++){
	        s_ufo1[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(396/2*Global.g_Scale,204/2*Global.g_Scale,108/2*Global.g_Scale,70/2*Global.g_Scale));
	        Global.ss_Character.addChild( s_ufo1[i]);
	        s_ufo1[i].setPosition(CGPoint.ccp(10000,10000));
	    }
	    for(int i = 0 ; i < maxUfoInOneType ; i++){
	        s_ufo2[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(948/2*Global.g_Scale,370/2*Global.g_Scale,108/2*Global.g_Scale,76/2*Global.g_Scale));
	        Global.ss_Character.addChild( s_ufo2[i]);
	        s_ufo2[i].setPosition(CGPoint.ccp(10000,10000));
	    }
	    for(int i = 0 ; i < maxUfoInOneType ; i++){
	        s_ufo3[i] = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1090/2*Global.g_Scale,552/2*Global.g_Scale,108/2*Global.g_Scale,86/2*Global.g_Scale));
	        Global.ss_Character.addChild( s_ufo3[i]);
	        s_ufo3[i].setPosition(CGPoint.ccp(10000,10000));
	    }
	    
	    maxGeneralCharacter = 60;
	    generalCharacterIdx = 0;
	    
	    for(int i = 0 ; i < maxGeneralCharacter ; i++){
	        generalMini02Character[i] = new eGeneralMini02Character();
	        generalMini02Character[i].isAni = false;
	        generalMini02Character[i].posX = -99999;
	        generalMini02Character[i].posY = -99999;
	    }
	    
	}
	
	public void  manage( float  dt)
	{
	    this.manageGenNext();
	    this.manageGneralCharacter();
	    this.manageIsLarging();
	    
	    for(int i = 0 ; i < maxTurtle ; i++){
	        turtle[i].manage(dt);
	    }
	    
	    for(int i = 0 ; i < maxPenguin ; i++){
	        penguin[i].manage();
	    }
	    
	    this.runCorrectWrongAni();
	    
	}
	
	public void  manageIsLarging()
	{
	    if(isAllowLarging){
	        isAllowLargingTimer++;
	        
	        if(!isLarging){
	            isLargingTimer++;
	            if(isLargingTimer == 60){
	                isLarging = true;
	                isLargingTimer = 0;
	                this.genIsLarging();
	            }
	        }else{
	            isLargingTimer++;
	            if(isLargingTimer == 60){
	                isLarging = false;
	                isLargingTimer = 0;
	            }
	        }
	    }
	    
	    if(isLarging){
	        if(isLargingTimer < 10){
	            isLargingScale += 0.03;
	        }else{
	            isLargingScale += (0 - isLargingScale)/20;
	        }
	    }
	}
	
	public void  genIsLarging()
	{
	    isLargingScale = 0;
	    
	    for(int i = 0 ; i < maxGeneralCharacter ; i++){
	        if((Math.random()*65535) % 2 == 0){
	            generalCharacterIsLarging[i] = true;
	        }else{
	            generalCharacterIsLarging[i] = false;
	        }
	    }
	}
	
	public void  manageGneralCharacter()
	{
	    if(hasGen){
	        
	        if(hasGenTimer < 10){
	            generalCharacterScale += 0.13;
	        }else{
	            generalCharacterScale += ( 1 - generalCharacterScale)/5;
	        }
	        
	        hasGenTimer++;
	    }
	
	    
	    for(int i = 0 ; i < maxGeneralCharacter ; i++){
	        if(generalMini02Character[i].isAni){
	            
	            if(generalMini02Character[i].ufoType == 2){
	                generalMini02Character[i].ufoIntervalTimer++;
	                if(generalMini02Character[i].ufoIntervalTimer >= generalMini02Character[i].ufoInteveral)
	                {
	                    generalMini02Character[i].ufoIntervalTimer = 0;
	                    
	                    int fuckUFORanAngle;
	                    if(Global.isIphone5){
	                        fuckUFORanAngle = (int) ((Math.random()*65535) % 448);
	                    }else{
	                        fuckUFORanAngle = (int) ((Math.random()*65535) % 360);
	                    }
	                    
	                    generalMini02Character[i].ufoVx = (float) (generalMini02Character[i].ufoSpeed * Math.cos((float)fuckUFORanAngle * Math.PI/180));
	                    generalMini02Character[i].ufoVy = (float) (generalMini02Character[i].ufoSpeed * Math.sin((float)fuckUFORanAngle * Math.PI/180));
	                    
	                    generalMini02Character[i].vx = generalMini02Character[i].ufoVx;
	                    generalMini02Character[i].vy = generalMini02Character[i].ufoVy;
	                    
	                   
	
	                }
	                
	                generalMini02Character[i].vx += (0 - generalMini02Character[i].vx)/20;
	                generalMini02Character[i].vy += (0 - generalMini02Character[i].vy)/20;
	            }
	
	            generalMini02Character[i].posX +=  generalMini02Character[i].vx;
	            generalMini02Character[i].posY +=  generalMini02Character[i].vy;
	            generalMini02Character[i].r += generalMini02Character[i].vr;
	            
	            
	            if(generalMini02Character[i].posX < 20){
	                generalMini02Character[i].posX = 20;
	                 generalMini02Character[i].vx *= -1;
	            }
	            
	            int boundaryY;
	            if(Global.isIphone5){
	                boundaryY = 548;
	            }else{
	                boundaryY = 460;
	            }
	            if(generalMini02Character[i].posX > boundaryY){
	                generalMini02Character[i].posX = boundaryY;
	                 generalMini02Character[i].vx *= -1;
	            }
	            
	            if(generalMini02Character[i].posY < 100){
	                generalMini02Character[i].posY = 100;
	                generalMini02Character[i].vy *= -1;
	            }
	            if(generalMini02Character[i].posY > 300){
	                generalMini02Character[i].posY = 300;
	                generalMini02Character[i].vy *= -1;
	            }
	
	            float tempFuckScale = 1.15f;
	            
	            if(generalMini02Character[i].whichType == 0){
	                if(generalMini02Character[i].ufoType == 0){
	                    s_ufo1[generalMini02Character[i].ufoIdx].setPosition(CGPoint.ccp(generalMini02Character[i].posX,generalMini02Character[i].posY));
	                    s_ufo1[generalMini02Character[i].ufoIdx].setRotation(generalMini02Character[i].r);
	                    
	                    if(generalCharacterIsLarging[i]){
	                        s_ufo1[generalMini02Character[i].ufoIdx].setScale(1.0f/Global.g_Scale*(generalCharacterScale + isLargingScale) * tempFuckScale);
	                    }else{
	                        s_ufo1[generalMini02Character[i].ufoIdx].setScale(1.0f/Global.g_Scale*generalCharacterScale * tempFuckScale);
	                    }
	                }
	                
	                if(generalMini02Character[i].ufoType == 1){
	                    s_ufo2[generalMini02Character[i].ufoIdx].setPosition(CGPoint.ccp(generalMini02Character[i].posX,generalMini02Character[i].posY));
	                    s_ufo2[generalMini02Character[i].ufoIdx].setRotation(generalMini02Character[i].r);
	                    
	                    if(generalCharacterIsLarging[i]){
	                        s_ufo2[generalMini02Character[i].ufoIdx].setScale(1.0f/Global.g_Scale*(generalCharacterScale + isLargingScale) * tempFuckScale);
	                    }else{
	                        s_ufo2[generalMini02Character[i].ufoIdx].setScale(1.0f/Global.g_Scale*generalCharacterScale * tempFuckScale);
	                    }
	                }
	                
	                if(generalMini02Character[i].ufoType == 2){
	                    s_ufo3[generalMini02Character[i].ufoIdx].setPosition(CGPoint.ccp(generalMini02Character[i].posX,generalMini02Character[i].posY));
	                    s_ufo3[generalMini02Character[i].ufoIdx].setRotation(generalMini02Character[i].r);
	                    
	                    if(generalCharacterIsLarging[i]){
	                        s_ufo3[generalMini02Character[i].ufoIdx].setScale(1.0f/Global.g_Scale*(generalCharacterScale + isLargingScale) * tempFuckScale);
	                    }else{
	                        s_ufo3[generalMini02Character[i].ufoIdx].setScale(1.0f/Global.g_Scale*generalCharacterScale * tempFuckScale);
	                    }
	                }
	                
	            }
	        }
	    }
	}
	
	public void  manageGenNext()
	{
	    if(!hasGen){
	        genNextTimer--;
	        if(genNextTimer == 0){
	            hasGen = true;
	            hasGenTimer = 0;
	            this.genNext();
	        }
	    }
	}
	
	public void  genNext()
	{
	    this.updategameLevel();
	   
	    Global.musicController.playThisSound(Global.kSound_Minesweeper,false,0.65);
	    Global.musicController.playThisSound(Global.kSound_MinesweeperV2,false,0.35);
	    
	    isAllowLarging = true;
	    isAllowLargingTimer = 0;
	    isLargingTimer = 0;
	    
	    int fuckRan;
	    fuckRan = (int) ((Math.random()*65535) % script_howmanyUFOGenRatio);
	    
	    howmanyTurtleOnScreen = fuckRan + script_howmanyUFOGenMin;
	    howmanyPenguinOnScreen = 0;
	    
	    if(Global.gameRound < 2){
	        if((Math.random()*65535) % 2 == 0){
	            howmanyTurtleOnScreen = 2;
	        }else{
	            howmanyTurtleOnScreen = 3;
	        }
	    }
	        
	    
	    correctAnswer = howmanyTurtleOnScreen;
	    
	    generalCharacterScale = 0;
	    
	    int howmanyGen;
	    howmanyGen = howmanyTurtleOnScreen;
	    while (howmanyGen > 0) {
	        this.genOneGeneralCharacter(0);
	
	        howmanyGen--;
	    }
	    
	    howmanyGen = howmanyPenguinOnScreen;
	    while (howmanyGen > 0) {
	        this.genOneGeneralCharacter(1);
	
	        howmanyGen--;
	    }
	    
	    this.genDigits();
	}
	
	public void  genDigits()
	{
	    for(int i = 0 ; i < maxDigitNumber ; i++){
	        for(int j = 0 ; j < 2 ; j++){
	            s_digits[i][j].setPosition(CGPoint.ccp(10000,10000));
	        }
	    }
	    
	    int maxToMinDiff;
	    maxToMinDiff = script_digitUpperLimit + script_digitLowerLimit + 1; //1 for correctAnswer
	    
	    correctAnswerIdx = (int) ((Math.random()*65535) % maxDigitNumber);
	    
	    for(int i = 0 ; i < maxDigitNumber ; i++){
	        digits[i] = -1;
	    }
	    
	    int ranUpperLowerOffset;
	    
	    ranUpperLowerOffset = (int) ((Math.random()*65535) % script_lowerUpperOffsetRatio);
	    if((Math.random()*65535) % 2 == 0){
	        ranUpperLowerOffset *= -1;
	    }
	    
	    int hasCollideTime;
	    hasCollideTime = 0;
	    
	    for(int i = 0 ; i < maxDigitNumber ; i++){
	        if(correctAnswerIdx == i){
	            digits[i] = howmanyTurtleOnScreen;
	        }else{
	            
	            boolean hasCollide;
	            int ranDigit;
	            
	            
	            do {
	                hasCollide = false;
	                
	                ranDigit = (int) ((Math.random()*65535) % maxToMinDiff);
	                ranDigit += correctAnswer - script_digitLowerLimit;
	                      
	                ranDigit += ranUpperLowerOffset;
	                
	                if(ranDigit <= 0){
	                    hasCollide = true;
	                }
	                
	                if(ranDigit == correctAnswer){
	                    hasCollide = true;
	                }
	                
	                for(int j = 0 ; j < maxDigitNumber ; j++){
	                    if(ranDigit == digits[j]){
	                        hasCollide = true;
	                    }
	                }
	                
	                hasCollideTime++;
	                if(hasCollideTime == 100){
	                    ranUpperLowerOffset = 0;
	                }
	                
	            } while (hasCollide);
	              
	            digits[i] = ranDigit;
	        }
	    }
	    
	        
	    for(int i = 0 ; i < maxDigitNumber ; i++){
	        if(digits[i] <= 9){
	            s_digits[i][0].setTextureRect(CGRect.make(digit_textureX + digits[i] * digit_textureWidth, digit_textureY, digit_textureWidth, digit_textureHeight));
	            
	            s_digits[i][0].setPosition(CGPoint.ccp(digit_posX[i], digit_posY[i]));
	            
	        }else{
	            int firtDigit;
	            int secondDigit;
	            
	            firtDigit = digits[i]/10;
	            secondDigit = digits[i] - firtDigit * 10;
	            
	            s_digits[i][0].setTextureRect(CGRect.make(digit_textureX + secondDigit * digit_textureWidth, digit_textureY, digit_textureWidth, digit_textureHeight));
	            s_digits[i][1].setTextureRect(CGRect.make(digit_textureX + firtDigit * digit_textureWidth, digit_textureY, digit_textureWidth, digit_textureHeight));
	            
	            s_digits[i][0].setPosition(CGPoint.ccp(digit_posX[i]+10, digit_posY[i]));
	            s_digits[i][1].setPosition(CGPoint.ccp(digit_posX[i]-10, digit_posY[i]));
	            
	        }
	    }
	    
	}
	
	public void  genOneGeneralCharacter( int _whichType)
	{
	    
	    int fuckRanX;
	    int fuckRanY;
	    float simX;
	    float simY;
	    
	    generalMini02Character[generalCharacterIdx].isAni = true;
	    
	    boolean continueFuck;
	    int fuckTooManyNumber;
	    
	    fuckTooManyNumber = 0;
	    sperateSpace = 70;
	    
	    do{
	        continueFuck = false;
	        
	        fuckRanX = (int) ((Math.random()*65535)% 410);
	        fuckRanY = (int) ((Math.random()*65535)% 140);
	        simX = (float)fuckRanX + 35;
	        simY = (float)fuckRanY + 115;
	        
	        for(int i = 0 ; i < maxGeneralCharacter ; i++){
	            if( i != generalCharacterIdx){
	                if(simX - generalMini02Character[i].posX < sperateSpace && simX - generalMini02Character[i].posX > -sperateSpace){
	                    if(simY - generalMini02Character[i].posY < sperateSpace && simY - generalMini02Character[i].posY > -sperateSpace){
	                        continueFuck = true;
	                        fuckTooManyNumber++;
	                        
	                        if(fuckTooManyNumber % 4 == 0){
	                             sperateSpace--;
	                        }
	                       
	                        
	                        if(fuckTooManyNumber == 280){
	                            
	                            if(_whichType == 0){
	                                howmanyTurtleOnScreen--;
	                            }
	                            if(_whichType == 1){
	                                howmanyPenguinOnScreen--;
	                            }
	                            
	                            return;
	                        }
	                    }
	                }
	            }
	            
	        }
	        
	    }while(continueFuck);
	    
	    generalMini02Character[generalCharacterIdx].posX = simX;
	    generalMini02Character[generalCharacterIdx].posY = simY;
	    
	    generalMini02Character[generalCharacterIdx].whichType = _whichType;
	    
	    if(_whichType == 0){
	        generalMini02Character[generalCharacterIdx].idxR = turtleIdx;
	        turtleIdx++;
	        if(turtleIdx == maxTurtle){
	            turtleIdx = 0;
	        }
	    }
	    if(_whichType == 1){
	        generalMini02Character[generalCharacterIdx].idxR = penguinIdx;
	        penguinIdx++;
	        if(penguinIdx == maxPenguin){
	            penguinIdx = 0;
	        }
	    }
	    
	    int ufoRanType;
	    ufoRanType = (int) ((Math.random()*65535) % 100);
	    if(ufoRanType < ufoTypeAppearRatio[0]){
	        generalMini02Character[generalCharacterIdx].ufoType = 0;
	        generalMini02Character[generalCharacterIdx].ufoIdx = ufo1Idx;
	        
	        ufo1Idx++;
	        if(ufo1Idx >= maxUfoInOneType){
	            ufo1Idx = 0;
	        }
	    }else if(ufoRanType < ufoTypeAppearRatio[1]){
	        generalMini02Character[generalCharacterIdx].ufoType = 1;
	        generalMini02Character[generalCharacterIdx].ufoIdx = ufo2Idx;
	        
	        ufo2Idx++;
	        if(ufo2Idx >= maxUfoInOneType){
	            ufo2Idx = 0;
	        }
	    }else{
	        generalMini02Character[generalCharacterIdx].ufoType = 2;
	        generalMini02Character[generalCharacterIdx].ufoIdx = ufo3Idx;
	        
	        ufo3Idx++;
	        if(ufo3Idx >= maxUfoInOneType){
	            ufo3Idx = 0;
	        }
	    }
	    
	    
	   
	    
	    if(generalMini02Character[generalCharacterIdx].ufoType == 0){
	        generalMini02Character[generalCharacterIdx].vx = 0;
	        generalMini02Character[generalCharacterIdx].vy = 0;
	        generalMini02Character[generalCharacterIdx].r = 0;
	        generalMini02Character[generalCharacterIdx].vr = 0;
	    }
	    
	    if(generalMini02Character[generalCharacterIdx].ufoType == 1){
	        int fuckRan;
	        float fuckRanVelocity;
	        fuckRan = (int) ((Math.random()*65535)  % 100);
	        fuckRanVelocity = (float) (script_ufo2MinV + fuckRan/100.0 * script_ufo2VxInterval - script_ufo2VxInterval/2);
	        
	        float fuckRanAngle;
	        fuckRanAngle = (float) ((Math.random()*65535)  % 360);
	        generalMini02Character[generalCharacterIdx].vx = (float) (fuckRanVelocity * Math.cos(fuckRanAngle)) ;
	        generalMini02Character[generalCharacterIdx].vy = (float) (fuckRanVelocity * Math.sin(fuckRanAngle)) ;
	        
	        
	        fuckRan = (int) ((Math.random()*65535)  % 100);
	        generalMini02Character[generalCharacterIdx].r =  (float) (fuckRan/100.0 * 2);
	        
	        fuckRan = (int) ((Math.random()*65535)  % 100);
	        generalMini02Character[generalCharacterIdx].vr =   (float) (0.0 + fuckRan/100.0 * script_ufo2VRInterval);
	        
	        if ((Math.random()*65535)   % 2 == 0) 
	        {
	            generalMini02Character[generalCharacterIdx].r *= -1;
	            generalMini02Character[generalCharacterIdx].vr *= -1;
	        }
	    }
	    
	    if(generalMini02Character[generalCharacterIdx].ufoType == 2){
	        generalMini02Character[generalCharacterIdx].vx = 0;
	        generalMini02Character[generalCharacterIdx].vy = 0;
	        generalMini02Character[generalCharacterIdx].r = 0;
	        generalMini02Character[generalCharacterIdx].vr = 0;
	        
	        generalMini02Character[generalCharacterIdx].ufoIntervalTimer = 0;
	        generalMini02Character[generalCharacterIdx].ufoInteveral = script_ufo3IntervalTime;
	        
	        int fuckUFORan;
	        fuckUFORan = (int) ((Math.random()*65535) % script_ufo3SpeendRatio);
	        generalMini02Character[generalCharacterIdx].ufoSpeed = (float)fuckUFORan + script_ufo3MinSpeed;
	    }
	    Global.playLayer.setToShakingBomb(generalMini02Character[generalCharacterIdx].posX,generalMini02Character[generalCharacterIdx].posY);
	    
	    generalCharacterIdx++;
	    if(generalCharacterIdx == maxGeneralCharacter){
	        generalCharacterIdx = 0;
	    }
	    
	}
	
	public boolean  ccTouchesEnded( MotionEvent event )
	{
	    for( int i = 0; i < event.getPointerCount(); i++ ) {
			CGPoint location = CGPoint.ccp(event.getX(i), event.getY(i));
			location = CCDirector.sharedDirector().convertToGL( location);
	        
	        if(location.y < 88 && location.y > 37){
	            if(location.x < 240 && location.x > 71){
	                this.tap(0);
	            }
	            if(location.x < 444 && location.x > 240){
	                this.tap(1);
	            }
	        }
	        
	        if(location.y < 37){
	            if(location.x < 240 && location.x > 71){
	                this.tap(2);
	            }
	            if(location.x < 444 && location.x > 240){
	                this.tap(3);
	            }
	        }
	        
	    }
		return true;
	}
	
	public void  tap( int _which)
	{
	    if(isCorrectWrongAni){
	        return;
	    }
	    
	    if(!hasGen){
	        return;
	    }
	    
	    tapWhich = _which;
	    
	    if(_which == correctAnswerIdx){
	        this.correct();
	    }else{
	        this.wrong();
	    }
	}
	
	public void  initCorrectWrong()
	{
	    s_correct = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1400/2*Global.g_Scale, 732/2*Global.g_Scale, 318/2*Global.g_Scale, 68/2*Global.g_Scale));
	    s_correct.setPosition(CGPoint.ccp(10000,10000));
	    s_correct.setScale( 1.0f/Global.g_Scale );
	    Global.ss_Character.addChild(s_correct);
	    
	    s_wrong = CCSprite.sprite(Global.ss_Character.getTexture(),CGRect.make(1112/2*Global.g_Scale, 824/2*Global.g_Scale, 268/2*Global.g_Scale, 66/2*Global.g_Scale));
	    s_wrong.setPosition(CGPoint.ccp(10000,10000));
	    s_wrong.setScale( 1.0f/Global.g_Scale );
	    Global.ss_Character.addChild(s_wrong);
	}
	
	public void  correct()
	{
	    Global.counterForAchivement += correctAnswer;
	    
	    isCorrectWrongAni = true;
	    
	    correctWrongAniTimer = 0;
	    
	    isCorrect = true;
	    Global.uILayer.gainCombo(1);
	    
	    Global.musicController.playThisSound(Global.kSound_ComboTime,false,0.5);
	    Global.playLayer.setToBombingTimePlus(240,160);
	    
	    Global.gameRound++;
	}
	
	public void  wrong()
	{
	    isCorrectWrongAni = true;
	    correctWrongAniTimer = 0;
	 
	    Global.uILayer.lostCombo();
	    
	    isCorrect = false;
	    Global.playLayer.setToBombingGameoverWithPos(Global.VIRT_WIDTH/2,Global.VIRT_HEIGHT/2);
	    Global.musicController.playThisSound(Global.kSound_ComboSmoke,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_TurtleExplode02,false,1.0);
	    Global.musicController.playThisSound(Global.kSound_TurtleExplode01,false,1.0);
	    gameover_scale = 0;
	}
	
	public void  runCorrectWrongAni()
	{
	    if(isCorrectWrongAni){
	        if(isCorrect){
	            if(correctWrongAniTimer == 0){
	                plusTimeOpacity = 255;
	                plusTimeSX = 0;
	                plusTimeSY = 0;
	                
	                plusTimeX = Global.VIRT_WIDTH/2;
	                plusTimeY = Global.VIRT_HEIGHT/2;
	            }
	            
	            if(correctWrongAniTimer < 10){
	                plusTimeSX += 0.1;
	                plusTimeSY += 0.1;
	            }
	            
	            if(correctWrongAniTimer <= 18 && correctWrongAniTimer >= 10){
	                plusTimeSX -= 0.02;
	                plusTimeSY -= 0.02;
	            }
	            if(correctWrongAniTimer <= 25 && correctWrongAniTimer > 18){
	                plusTimeSX += 0.02;
	                plusTimeSY += 0.02;
	            }
	            if(correctWrongAniTimer <= 33 && correctWrongAniTimer > 25){
	                plusTimeSX -= 0.02;
	                plusTimeSY -= 0.02;
	            }
	
	            
	            if(correctWrongAniTimer < 50 && correctWrongAniTimer > 33){
	                plusTimeY += 5;
	                plusTimeSX += 0.06;
	                plusTimeSY += 0.06;
	                plusTimeOpacity -= 38;
	                if(plusTimeOpacity< 0){
	                    plusTimeOpacity = 0;
	                }
	            }
	            
	            s_correct.setPosition(CGPoint.ccp(plusTimeX,plusTimeY));
	            s_correct.setOpacity(plusTimeOpacity);
	            s_correct.setScaleX(1.0f/Global.g_Scale*plusTimeSX*1.2);
	            s_correct.setScaleY(1.0f/Global.g_Scale*plusTimeSY*1.2);
	            
	            
	        }else{
	            gameover_scale += (1 - gameover_scale)/7;
	            
	            int ranGameoverX = 0;
	            int ranGameoverY = 0;
	            
	            if(correctWrongAniTimer < 20){
	                gameover_opacity = 255;
	                ranGameoverX = (int) ((Math.random()*65535) % 8 - 4);
	                ranGameoverY = (int) ((Math.random()*65535) % 8 - 4);
	            }else if(correctWrongAniTimer < 40){
	                ranGameoverX = (int) ((Math.random()*65535) % 4 - 2);
	                ranGameoverY = (int) ((Math.random()*65535) % 4 - 2);
	            }else if(correctWrongAniTimer < 58){
	                ranGameoverX = (int) ((Math.random()*65535) % 2 - 1);
	                ranGameoverY = (int) ((Math.random()*65535) % 2 - 1);
	            }else if(correctWrongAniTimer < 65){
	                ranGameoverX = 0;
	                ranGameoverY = 0;
	            }else{
	                ranGameoverY += 4;
	                gameover_opacity -= 25;
	                if(gameover_opacity < 0){
	                    gameover_opacity = 0;
	                }
	                gameover_scale+=0.05;
	            }
	            
	            s_wrong.setPosition(CGPoint.ccp(Global.VIRT_WIDTH/2 + ranGameoverX,Global.VIRT_HEIGHT/2 + ranGameoverY));
	            s_wrong.setScale(1.0f/Global.g_Scale*gameover_scale*1.1f);
	            s_wrong.setOpacity(gameover_opacity);
	            
	            if(correctAnswerIdx == 0){
	                s_tempWrongNotice.setPosition(CGPoint.ccp(163,60));
	            }
	            if(correctAnswerIdx == 1){
	                s_tempWrongNotice.setPosition(CGPoint.ccp(319,60));
	            }
	            if(correctAnswerIdx == 2){
	                s_tempWrongNotice.setPosition(CGPoint.ccp(163,20));
	            }
	            if(correctAnswerIdx == 3){
	                s_tempWrongNotice.setPosition(CGPoint.ccp(319,20));
	            }
	            
	            if(Global.isIphone5){
	                s_tempWrongNotice.setPosition(CGPoint.ccp(s_tempWrongNotice.getPosition().x + 44, s_tempWrongNotice.getPosition().y));
	            }   
	            
	            if(correctWrongAniTimer < 10){
	                s_tempWrongNotice.setOpacity(255);
	            }else if(correctWrongAniTimer < 20){
	                s_tempWrongNotice.setOpacity(0);
	            }else if(correctWrongAniTimer < 30){
	                s_tempWrongNotice.setOpacity(255);
	            }else if(correctWrongAniTimer < 40){
	                s_tempWrongNotice.setOpacity(0);
	            }else if(correctWrongAniTimer < 60){
	                s_tempWrongNotice.setOpacity(255);
	                wrongNoticeOpacity = 255;
	            }
	            
	            if(correctWrongAniTimer > 60){
	                wrongNoticeOpacity -= 15;
	                if(wrongNoticeOpacity < 0){
	                    wrongNoticeOpacity = 0;
	                }
	                s_tempWrongNotice.setOpacity(wrongNoticeOpacity);
	            }
	            
	            
	        }
	        
	        correctWrongAniTimer++;
	        
	        if(isCorrect){
	            if(correctWrongAniTimer == 42){
	                this.prepareNextGen();
	                isCorrectWrongAni = false;
	            }
	        }else{
	            if(correctWrongAniTimer == 80){
	                this.prepareNextGen();
	                isCorrectWrongAni = false;
	            }
	        }
	        
	    }
	}
	
	public void  prepareNextGen()
	{
	    for(int i = 0 ; i < maxGeneralCharacter ; i++){
	        if(generalMini02Character[i].isAni){
	            generalMini02Character[i].isAni = false;
	            
	            if(generalMini02Character[i].ufoType == 0){
	            	Global.playLayer.setToBombing(generalMini02Character[i].posX,generalMini02Character[i].posY);
	                s_ufo1[generalMini02Character[i].ufoIdx].setPosition(CGPoint.ccp(10000,10000));
	            }
	            if(generalMini02Character[i].ufoType == 1){
	            	Global.playLayer.setToBombing(generalMini02Character[i].posX,generalMini02Character[i].posY);
	                s_ufo2[generalMini02Character[i].ufoIdx].setPosition(CGPoint.ccp(10000,10000));
	            }
	            if(generalMini02Character[i].ufoType == 2){
	            	Global.playLayer.setToBombing(generalMini02Character[i].posX,generalMini02Character[i].posY);
	                s_ufo3[generalMini02Character[i].ufoIdx].setPosition(CGPoint.ccp(10000,10000));
	            }
	            
	            generalMini02Character[i].posX = 10000;
	            generalMini02Character[i].posY = 10000;
	        }
	    }
	    
	    isAllowLarging = false;
	    isAllowLargingTimer = 0;
	    isLargingScale = 0;
	    isLarging = false;
	    
	    this.initGenNext();
	}

}
