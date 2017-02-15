package com.zombieglider;

import org.cocos2d.nodes.CCSprite;

public class eTurtleCoinAniStruct{
	public CCSprite s_graphic[] = new CCSprite[10];
	public float posX[] = new float[10];
	public float posY[] = new float[10];
	public float vx[] = new float[10];
	public float vy[] = new float[10];
	public float rv[] = new float[10];
	public float opacity[] = new float[10];
	public float ov[] = new float[10];
	public int aniTimer;
	public boolean isAni;
	public int numElements;
};