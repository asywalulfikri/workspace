package com.zombieglider;

import org.cocos2d.nodes.CCSprite;

public class sBombingAniStruct{

	public static sBombingAniStruct bombingAniStruct[] = new sBombingAniStruct[26];
	public static int bombingAniMax;
	public static int bombingAniIdx;
	
	public CCSprite s_buum;
	public CCSprite s_blick;
	public CCSprite s_wave;
	public CCSprite s_debris[] = new CCSprite[3];
	public CCSprite s_bigClouds[] = new CCSprite[8];
	public CCSprite s_smallClouds[] = new CCSprite[5];
    
	public int aniTimer;
	public boolean isAni;
	public boolean isAniCombo;
	public boolean isAniShake; 
	public boolean isAniPlusTime;
	public boolean isAniCannon;
	public boolean isAniGameover;
    
	public float aniX;
	public float aniY;    
}

