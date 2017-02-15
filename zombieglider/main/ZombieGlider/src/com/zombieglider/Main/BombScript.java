package com.zombieglider.Main;


import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCNode;

import com.zombieglider.Global;
import com.zombieglider.sBombingAniStruct;
//
//  BombScript.m
//  TurtlesHuh
//
//  Created by  on 2012/5/20.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//
import com.zombieglider.sBombingAniStruct;

public class BombScript extends CCNode
{
	float wholeBombOffsetX = 0;
    float wholeBombOffsetY = 0;
    float plusTimeScale = 2.0f;
    
    public void  manage()
	{
	    this.manageBombAni();
	    this.manageBombComboAni();
	    this.manageBombShakeAni();
	    this.managePlusTimeAni();
	}
	
	public void  manageBombAni()
	{
	    for(int i = 0 ; i < sBombingAniStruct.bombingAniMax ; i++){
	        
	        if(sBombingAniStruct.bombingAniStruct[i].isAni){
	            
	            wholeBombOffsetX = sBombingAniStruct.bombingAniStruct[i].aniX;
	            wholeBombOffsetY = sBombingAniStruct.bombingAniStruct[i].aniY;
	            
	            sBombingAniStruct.bombingAniStruct[i].aniTimer++;
	            
	            //Frame 3
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 1){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(356.4f + wholeBombOffsetX, -259.7f + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)25.8);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*(float) (0.522 * 1.537));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*(float) (0.522 * 1.537));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity((int) (50.0/100.0 * 255.0));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(39.0/100.0 * 255.0);
	            }
	            
	            //Frame 4
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 2){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(360.1 + wholeBombOffsetX, -264.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)51.9);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            //Frame 5
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 3){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -266.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(75/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -267.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)139.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.419);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -254.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-124.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(367.8 + wholeBombOffsetX, -254.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 6
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 4){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353000, 10000));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(71.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(335.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)138.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(338.6 + wholeBombOffsetX, -239.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-123.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(384.5 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(364.1 + wholeBombOffsetX, -265.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.1113 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.1113 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(364.7 + wholeBombOffsetX, -248.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)51.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.528 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.528 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(346.6 + wholeBombOffsetX, -245.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)51.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.973 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.973 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.4 + wholeBombOffsetX, -272.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)144.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.559 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.559 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(335.6 + wholeBombOffsetX, -249.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.529 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.527 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(41.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-21.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.289 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.289 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(22.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-10.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.1185 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.1185 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(22.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 7
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 5){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(324.1 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)137.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(77.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(331.1 + wholeBombOffsetX, -224.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-121.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(402.1 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(367.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.598 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.598 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(367.6 + wholeBombOffsetX, -247.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.091 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.091 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(345.4 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.321 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.321 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(79/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -277.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)151.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.117 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.117 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(330.0 + wholeBombOffsetX, -247.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-9.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.015 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.015 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-14.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.613 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.613 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-22.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.499 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.499 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(46.0/100.0 * 255.0);
	            }
	            
	            //Frame 8
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 6){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(10000 , 261.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(313.1 + wholeBombOffsetX, -286.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.405);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(65.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(323.6 + wholeBombOffsetX, -209.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-119.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.925);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(73/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(419.8 + wholeBombOffsetX, -217.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(368.9 + wholeBombOffsetX, -277.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.856 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.856 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(369.2 + wholeBombOffsetX, -247.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.392 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.392 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.7 + wholeBombOffsetX, -246.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.508 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.508 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)154.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.414 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.414 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(327.1 + wholeBombOffsetX, -246.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-12.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.273 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.273 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-8.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.915 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.915 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-33.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.797 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.797 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(69.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(339 + wholeBombOffsetX, -258.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)47.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.801 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.801 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(347.0 + wholeBombOffsetX, -263.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-62.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.606 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.606 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(350.8 + wholeBombOffsetX, -245 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)78.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.956 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.956 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -251.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.226 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.226 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(358.8 + wholeBombOffsetX, -253.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.223 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.223 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 9
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 7){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.045 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.015 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(302.4 + wholeBombOffsetX, -293.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.401);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(316.1 + wholeBombOffsetX, -194.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-118.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.934);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(437 + wholeBombOffsetX, -205.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(57.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(370.6 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)116.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.8 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.8 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(370.3 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.342 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.342 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.+ + wholeBombOffsetX, -244.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.479 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.479 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -281.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)157.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.365 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.365 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(325.2 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-14.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.227 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.227 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-3.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.151 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.151 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(88.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-42.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.04 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.04 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(88.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(333.4 + wholeBombOffsetX, -258.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)53.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.722 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.722 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(344.6 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-64.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.57 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.57 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -241.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)83.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.91 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.91 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(337.1 + wholeBombOffsetX, -248.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.168 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.168 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(362.6 + wholeBombOffsetX, -253.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-4.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.174 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.174 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(96.0/100.0 * 255.0);
	            }
	            
	            //Frame 10
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 8){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(292.1 + wholeBombOffsetX, -299.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)135.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.397);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(42.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(308.8 + wholeBombOffsetX, -179.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-116.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.943);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(55.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(453.8 + wholeBombOffsetX, -193.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(372.6 + wholeBombOffsetX, -283.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)121.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -244.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.26 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.26 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.4 + wholeBombOffsetX, -241.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.431 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.431 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -283.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)163.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.281 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.281 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(321.9 + wholeBombOffsetX, -244.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-19.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.146 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.146 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.309 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.309 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-49.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.208 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.208 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -258.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)60.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.638 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.638 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(341.7 + wholeBombOffsetX, -267.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-67.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.531 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.531 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -237.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)89.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(334.1 + wholeBombOffsetX, -245.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.105 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.105 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(367.1 + wholeBombOffsetX, -253.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-9.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.11 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.11 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(93.0/100.0 * 255.0);
	            }
	            
	            //Frame 11
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 9){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(282.2 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)134.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.393);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(301.6 + wholeBombOffsetX, -164.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-115.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.952);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(46.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(469.9 + wholeBombOffsetX, -181.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(375.0 + wholeBombOffsetX, -286.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)127.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(374.9 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.153 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.153 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.1 + wholeBombOffsetX, -236.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -287.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)170.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.173 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.173 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -243.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-24.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.043 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.043 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)1.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.334 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.334 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-50.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.226 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.226 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(319.6 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)68.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.543 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.543 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(338.5 + wholeBombOffsetX, -269.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-70.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.487 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.487 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.2 + wholeBombOffsetX, -233.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)95.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.78 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.78 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(330.7 + wholeBombOffsetX, -241.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.034 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.034 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -252.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-15.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.038 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.038 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(89.0/100.0 * 255.0);
	            }
	            
	            //Frame 12
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 10){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(18.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(273.1 + wholeBombOffsetX, -310.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.389);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(22.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -150.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-113.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.96);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(485.1 + wholeBombOffsetX, -170.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(377.6 + wholeBombOffsetX, -290.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)134.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.568 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.568 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(378 + wholeBombOffsetX, -240.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.029 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.029 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.8 + wholeBombOffsetX, -232.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.299 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.299 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -291.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)178.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.048 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.048 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -241.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-31.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.922 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.922 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)3.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.366 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.366 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-53.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.262 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.262 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(311.4 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)76.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.437 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.437 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(334.9 + wholeBombOffsetX, -271.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-74.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.438 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.438 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.4 + wholeBombOffsetX, -228.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)102.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.731 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.731 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -236.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.955 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.955 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(84/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(377.8 + wholeBombOffsetX, -252.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-21.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.959 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.959 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(84.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 13
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 11){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(264.8 + wholeBombOffsetX, -315.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.386);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(288.1 + wholeBombOffsetX, -137.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-112.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.969);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(30.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(499.4 + wholeBombOffsetX, -160.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(380.8 + wholeBombOffsetX, -294.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)141.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.471 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.471 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(381.1 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.892 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.892 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.4 + wholeBombOffsetX, -226.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.22 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.22 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -296.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-172.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.908 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.908 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(306.9 + wholeBombOffsetX, -239.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-38.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.792 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.792 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)6.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.402 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.402 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-53.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.312 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.312 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(302.6 + wholeBombOffsetX, -257.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.32 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.32 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(330.9 + wholeBombOffsetX, -274.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-77.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.384 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.384 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -223.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)110.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.658 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.658 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(322.8 + wholeBombOffsetX, -232.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.868 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.868 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(383.9 + wholeBombOffsetX, -251.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-28.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.872 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.872 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 14
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 12){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(10000 , 265));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(257.8 + wholeBombOffsetX, -319.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)132.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.383);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(281.9 + wholeBombOffsetX, -125.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-111.0);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.976);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(23.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(512.2 + wholeBombOffsetX, -151.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(11.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(394.1 + wholeBombOffsetX, -298.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)149.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.361 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.361 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(385.1 + wholeBombOffsetX, -234.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.742 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.742 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.1 + wholeBombOffsetX, -220.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.133 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.133 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.3 + wholeBombOffsetX, -301.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-162.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.75 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.75 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(300.9 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-46.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.647 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.647 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)8.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.444 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.444 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-60.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.375 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.375 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(293.1 + wholeBombOffsetX, -257.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)96.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.196 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.196 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(326.6 + wholeBombOffsetX, -276.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-81.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.327 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.327 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -217.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)118.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.58 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.58 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(318.3 + wholeBombOffsetX, -226.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.775 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.775 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(390.6 + wholeBombOffsetX, -251.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-36.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.778 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.778 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(73.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 15
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 13){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(10000, 319.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -113.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-109.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.984);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(16.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(523.0 + wholeBombOffsetX, -143.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(5.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(387.9 + wholeBombOffsetX, -303.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)158.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(389.1 + wholeBombOffsetX, -230.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.583 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.583 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.7 + wholeBombOffsetX, -214.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.041 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.041 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -306.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-151.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.595 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.595 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -234.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-54.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.496 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.496 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)13.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.492 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.495 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-65.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.453 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.453 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(282.9 + wholeBombOffsetX, -257.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)107.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.06 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.06 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(322.1 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.265 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.265 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -211.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)127.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.497 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.497 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(313.6 + wholeBombOffsetX, -221.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.676 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.676 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(397.6 + wholeBombOffsetX, -250.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-44.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.678 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.678 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)-34.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*0.859 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*0.859 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(27.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 16
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 14){
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(270.9 + wholeBombOffsetX, -102.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-108.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.99);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(10000 , 143.9));
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(391.6 + wholeBombOffsetX, -309.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.118 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.118 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(72.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(393.1 + wholeBombOffsetX, -227.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.416 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.416 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.2 + wholeBombOffsetX, -208.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.946 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.946 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -312.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-140.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.427 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.427 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(287.8 + wholeBombOffsetX, -232.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-63.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.338 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.338 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)15.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.542 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.542 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-71.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.535 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.535 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(86.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(272.1 + wholeBombOffsetX, -257.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)118.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.918 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.918 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -282.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-90.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.20 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.20 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.3 + wholeBombOffsetX, -205.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)137.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.409 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.409 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(308.4 + wholeBombOffsetX, -215.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.571 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.571 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(405.1 + wholeBombOffsetX, -250.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-52.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.574 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.574 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)-20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.131 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.131 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(56.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 17
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 15){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -93.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-107.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.996);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(4.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(395.9 + wholeBombOffsetX, -314.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)177.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.983 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.983 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(62.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(397.4 + wholeBombOffsetX, -223.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.9 + wholeBombOffsetX, -201.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.846 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.846 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.7 + wholeBombOffsetX, -318.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-129.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.253 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.253 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(280.9 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-72.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.174 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.174 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)19.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.596 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.596 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-77.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.627 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.627 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(72.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(260.9 + wholeBombOffsetX, -257.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.771 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.771 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -285.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-95.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.132 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.132 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.6 + wholeBombOffsetX, -199.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)147.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.318 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.318 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(303.2 + wholeBombOffsetX, -209.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.462 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.462 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(412.8 + wholeBombOffsetX, -249.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-61.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.465 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.465 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)-8.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(82.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 18
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 16){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(10000, 93.9));
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(400.4 + wholeBombOffsetX, -321.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)171.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.84 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.84 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(51.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(401.8 + wholeBombOffsetX, -219.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.066 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.066 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.3 + wholeBombOffsetX, -194.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.744 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.744 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -324.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-117.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.074 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.074 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(273.8 + wholeBombOffsetX, -227.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-82.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.005 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.005 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)22.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.654 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.654 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-84.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.722 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.722 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(57.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(249.3 + wholeBombOffsetX, -257.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)142.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.619 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.619 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(307.3 + wholeBombOffsetX, -288.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-100.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.062 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.062 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.8 + wholeBombOffsetX, -192.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)157.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.225 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.225 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(297.9 + wholeBombOffsetX, -203.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.35 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.35 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(420.7 + wholeBombOffsetX, -248.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-71);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.353 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.353 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.544 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.544 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(100.0/100.0 * 255.0);
	                
	            }
	            
	            
	            
	            //Frame 19
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 17){
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(404.9 + wholeBombOffsetX, -327.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)160.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.688 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.688 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(406.4 + wholeBombOffsetX, -215.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.884 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.884 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.9 + wholeBombOffsetX, -187.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.639 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.639 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.9 + wholeBombOffsetX, -330.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-104.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -224.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-91.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.83 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.83 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)26.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.713 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.713 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-90.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.818 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.818 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(41.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(237.7 + wholeBombOffsetX, -257.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)155.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.466 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.466 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(302.1 + wholeBombOffsetX, -292.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-105.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.99 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.99 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.1 + wholeBombOffsetX, -185.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.13 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.13 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(292.4 + wholeBombOffsetX, -197.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.236 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.236 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(428.8 + wholeBombOffsetX, -248.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-80.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.239 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.239 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.592 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.592 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(91.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 20
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 18){
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(409.9 + wholeBombOffsetX, -334.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-148.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.529 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.529 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(27.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(411.1 + wholeBombOffsetX, -212.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.696 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.696 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.3 + wholeBombOffsetX, -180.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.531 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.531 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -336.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-92.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.699 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.699 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(258.8 + wholeBombOffsetX, -222.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-101.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.65 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.65 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)30.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.773 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.773 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(44.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-96.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.909 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.909 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(27.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(225.8 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.312 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.312 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(296.9 + wholeBombOffsetX, -295.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-110.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.919 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.919 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.4 + wholeBombOffsetX, -178.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)178.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.035 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.035 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(286.9 + wholeBombOffsetX, -190.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.122 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.122 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(436.9 + wholeBombOffsetX, -247.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-89.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.125 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.125 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)18.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(79.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 21
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 19){
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(415.0 + wholeBombOffsetX, -341.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-136.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.364 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.364 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(14.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(415.8 + wholeBombOffsetX, -207.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.503 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.503 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -172.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.42 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.42 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -343.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-79.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.505 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.505 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(251.0 + wholeBombOffsetX, -219.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-111.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.466 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.466 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)34.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.532 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.532 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-102.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.995 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.995 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(13.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(214.0 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)180);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.158 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.158 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(291.6 + wholeBombOffsetX, -298.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-115.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.847 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.847 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -171.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)171.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.939 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.939 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(281.4 + wholeBombOffsetX, -184.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.007 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.007 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(445.0 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-98.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.01 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.01 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)318);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(65.0/100.0 * 255.0);
	                
	            }
	            
	            
	            
	            //Frame 22
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 20){
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(41500.0, -341.1));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)38.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(21.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(202.5 + wholeBombOffsetX, -256.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.006 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.006 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(286.6 + wholeBombOffsetX, -302.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-119.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.777 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.777 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -164.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)161.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.844 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.844 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -178.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.895 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.895 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(453.0 + wholeBombOffsetX, -246.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-107.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.897 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.897 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)46.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.822 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.822 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(49.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 23
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 21){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)41.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.944 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.944 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(10.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(191.2 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)155.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(281.6 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-124.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.709 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.709 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -158.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)151.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.753 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.753 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(270.8 + wholeBombOffsetX, -172.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-133.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.786 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.786 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(460.8 + wholeBombOffsetX, -245.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-116.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.787 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.787 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)61.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*1.916 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*1.916 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(32.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 24
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 22){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(180.5 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)144.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.716 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.716 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(276.8 + wholeBombOffsetX, -308.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-129.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.644 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.644 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -151.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)142.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.665 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.665 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(265.8 + wholeBombOffsetX, -166.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-133.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.681 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.681 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(468.2 + wholeBombOffsetX, -244.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-125.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.682 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.682 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(351.0 + wholeBombOffsetX, -261.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setRotation((float)77.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleX(1.0f/Global.g_Scale*2.008 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setScaleY(1.0f/Global.g_Scale*2.008 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setOpacity(15.0/100.0 * 255.0);
	                
	            }
	            
	            
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 23){
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                sBombingAniStruct.bombingAniStruct[i].isAni = false;
	            }
	            
	        }//end if bombingAniStrut i isAni
	        
	        
	    }
	    
	    
	    
	}
	
	public void  manageBombComboAni()
	{
	    for(int i = 0 ; i < sBombingAniStruct.bombingAniMax ; i++){
	        
	        if(sBombingAniStruct.bombingAniStruct[i].isAniCombo){
	            
	            wholeBombOffsetX = sBombingAniStruct.bombingAniStruct[i].aniX;
	            wholeBombOffsetY = sBombingAniStruct.bombingAniStruct[i].aniY;
	            sBombingAniStruct.bombingAniStruct[i].aniTimer++;
	            
	            //Frame 3
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 1){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(356.4 + wholeBombOffsetX, -259.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)25.8);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.522 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.522 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(367.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.598 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.598 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(367.6 + wholeBombOffsetX, -247.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.091 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.091 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(345.4 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.321 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.321 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(79/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -277.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)151.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.117 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.117 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(330.0 + wholeBombOffsetX, -247.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-9.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.015 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.015 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-14.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.613 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.613 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-22.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.499 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.499 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(46.0/100.0 * 255.0);
	            }
	            
	            //Frame 4
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 2){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(360.1 + wholeBombOffsetX, -264.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)51.9);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(368.9 + wholeBombOffsetX, -277.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.856 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.856 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(369.2 + wholeBombOffsetX, -247.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.392 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.392 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.7 + wholeBombOffsetX, -246.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.508 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.508 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)154.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.414 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.414 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(327.1 + wholeBombOffsetX, -246.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-12.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.273 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.273 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-8.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.915 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.915 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-33.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.797 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.797 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(69.0/100.0 * 255.0);
	            }
	            
	            //Frame 5
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 3){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -266.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(75/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -267.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)139.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.419);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -254.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-124.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(367.8 + wholeBombOffsetX, -254.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(370.6 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)116.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.8 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.8 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(370.3 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.342 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.342 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.+ + wholeBombOffsetX, -244.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.479 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.479 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -281.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)157.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.365 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.365 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(325.2 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-14.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.227 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.227 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-3.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.151 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.151 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(88.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-42.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.04 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.04 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(88.0/100.0 * 255.0);
	            }
	            
	            //Frame 6
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 4){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353000, 10000));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(71.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(335.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)138.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(338.6 + wholeBombOffsetX, -239.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-123.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(384.5 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(372.6 + wholeBombOffsetX, -283.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)121.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -244.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.26 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.26 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.4 + wholeBombOffsetX, -241.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.431 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.431 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -283.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)163.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.281 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.281 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(321.9 + wholeBombOffsetX, -244.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-19.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.146 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.146 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.309 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.309 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-49.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.208 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.208 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 7
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 5){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(324.1 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)137.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(77.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(331.1 + wholeBombOffsetX, -224.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-121.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(402.1 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(375.0 + wholeBombOffsetX, -286.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)127.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(374.9 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.153 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.153 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.1 + wholeBombOffsetX, -236.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -287.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)170.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.173 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.173 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -243.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-24.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.043 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.043 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)1.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.334 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.334 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-50.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.226 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.226 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 8
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 6){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(10000 , 261.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(313.1 + wholeBombOffsetX, -286.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.405);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(65.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(323.6 + wholeBombOffsetX, -209.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-119.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.925);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(73/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(419.8 + wholeBombOffsetX, -217.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(377.6 + wholeBombOffsetX, -290.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)134.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.568 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.568 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(378 + wholeBombOffsetX, -240.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.029 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.029 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.8 + wholeBombOffsetX, -232.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.299 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.299 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -291.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)178.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.048 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.048 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -241.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-31.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.922 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.922 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)3.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.366 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.366 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-53.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.262 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.262 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(339 + wholeBombOffsetX, -258.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)47.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.801 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.801 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(347.0 + wholeBombOffsetX, -263.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-62.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.606 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.606 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(350.8 + wholeBombOffsetX, -245 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)78.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.956 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.956 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -251.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.226 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.226 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(358.8 + wholeBombOffsetX, -253.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.223 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.223 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 9
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 7){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.045 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.015 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(302.4 + wholeBombOffsetX, -293.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.401);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(316.1 + wholeBombOffsetX, -194.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-118.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.934);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(437 + wholeBombOffsetX, -205.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(57.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(380.8 + wholeBombOffsetX, -294.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)141.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.471 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.471 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(381.1 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.892 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.892 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.4 + wholeBombOffsetX, -226.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.22 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.22 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -296.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-172.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.908 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.908 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(306.9 + wholeBombOffsetX, -239.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-38.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.792 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.792 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)6.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.402 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.402 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-53.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.312 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.312 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(333.4 + wholeBombOffsetX, -258.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)53.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.722 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.722 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(344.6 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-64.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.57 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.57 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -241.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)83.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.91 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.91 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(337.1 + wholeBombOffsetX, -248.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.168 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.168 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(362.6 + wholeBombOffsetX, -253.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-4.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.174 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.174 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(96.0/100.0 * 255.0);
	            }
	            
	            //Frame 10
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 8){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(292.1 + wholeBombOffsetX, -299.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)135.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.397);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(42.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(308.8 + wholeBombOffsetX, -179.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-116.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.943);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(55.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(453.8 + wholeBombOffsetX, -193.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(394.1 + wholeBombOffsetX, -298.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)149.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.361 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.361 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(385.1 + wholeBombOffsetX, -234.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.742 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.742 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.1 + wholeBombOffsetX, -220.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.133 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.133 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.3 + wholeBombOffsetX, -301.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-162.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.75 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.75 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(300.9 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-46.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.647 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.647 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)8.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.444 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.444 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-60.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.375 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.375 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -258.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)60.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.638 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.638 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(341.7 + wholeBombOffsetX, -267.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-67.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.531 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.531 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -237.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)89.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(334.1 + wholeBombOffsetX, -245.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.105 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.105 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(367.1 + wholeBombOffsetX, -253.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-9.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.11 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.11 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(93.0/100.0 * 255.0);
	            }
	            
	            //Frame 11
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 9){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(282.2 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)134.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.393);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(301.6 + wholeBombOffsetX, -164.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-115.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.952);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(46.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(469.9 + wholeBombOffsetX, -181.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(387.9 + wholeBombOffsetX, -303.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)158.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(389.1 + wholeBombOffsetX, -230.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.583 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.583 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.7 + wholeBombOffsetX, -214.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.041 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.041 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -306.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-151.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.595 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.595 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -234.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-54.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.496 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.496 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)13.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.492 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.495 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-65.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.453 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.453 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(319.6 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)68.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.543 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.543 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(338.5 + wholeBombOffsetX, -269.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-70.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.487 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.487 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.2 + wholeBombOffsetX, -233.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)95.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.78 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.78 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(330.7 + wholeBombOffsetX, -241.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.034 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.034 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -252.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-15.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.038 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.038 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(89.0/100.0 * 255.0);
	            }
	            
	            //Frame 12
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 10){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(18.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(273.1 + wholeBombOffsetX, -310.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.389);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(22.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -150.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-113.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.96);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(485.1 + wholeBombOffsetX, -170.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(391.6 + wholeBombOffsetX, -309.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.118 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.118 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(72.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(393.1 + wholeBombOffsetX, -227.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.416 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.416 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.2 + wholeBombOffsetX, -208.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.946 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.946 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -312.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-140.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.427 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.427 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(287.8 + wholeBombOffsetX, -232.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-63.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.338 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.338 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)15.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.542 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.542 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-71.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.535 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.535 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(86.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(311.4 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)76.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.437 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.437 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(334.9 + wholeBombOffsetX, -271.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-74.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.438 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.438 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.4 + wholeBombOffsetX, -228.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)102.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.731 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.731 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -236.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.955 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.955 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(84/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(377.8 + wholeBombOffsetX, -252.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-21.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.959 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.959 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(84.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 13
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 11){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(264.8 + wholeBombOffsetX, -315.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.386);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(288.1 + wholeBombOffsetX, -137.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-112.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.969);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(30.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(499.4 + wholeBombOffsetX, -160.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(395.9 + wholeBombOffsetX, -314.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)177.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.983 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.983 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(62.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(397.4 + wholeBombOffsetX, -223.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.9 + wholeBombOffsetX, -201.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.846 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.846 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.7 + wholeBombOffsetX, -318.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-129.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.253 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.253 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(280.9 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-72.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.174 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.174 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)19.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.596 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.596 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-77.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.627 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.627 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(72.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(302.6 + wholeBombOffsetX, -257.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.32 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.32 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(330.9 + wholeBombOffsetX, -274.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-77.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.384 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.384 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -223.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)110.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.658 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.658 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(322.8 + wholeBombOffsetX, -232.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.868 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.868 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(383.9 + wholeBombOffsetX, -251.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-28.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.872 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.872 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 14
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 12){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(10000 , 265));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(257.8 + wholeBombOffsetX, -319.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)132.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.383);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(281.9 + wholeBombOffsetX, -125.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-111.0);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.976);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(23.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(512.2 + wholeBombOffsetX, -151.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(11.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(400.4 + wholeBombOffsetX, -321.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)171.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.84 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.84 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(51.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(401.8 + wholeBombOffsetX, -219.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.066 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.066 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.3 + wholeBombOffsetX, -194.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.744 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.744 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -324.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-117.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.074 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.074 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(273.8 + wholeBombOffsetX, -227.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-82.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.005 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.005 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)22.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.654 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.654 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-84.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.722 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.722 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(57.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(293.1 + wholeBombOffsetX, -257.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)96.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.196 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.196 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(326.6 + wholeBombOffsetX, -276.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-81.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.327 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.327 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -217.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)118.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.58 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.58 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(318.3 + wholeBombOffsetX, -226.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.775 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.775 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(390.6 + wholeBombOffsetX, -251.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-36.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.778 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.778 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(73.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 15
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 13){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(10000, 319.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -113.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-109.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.984);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(16.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(523.0 + wholeBombOffsetX, -143.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(404.9 + wholeBombOffsetX, -327.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)160.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.688 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.688 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(406.4 + wholeBombOffsetX, -215.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.884 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.884 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.9 + wholeBombOffsetX, -187.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.639 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.639 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.9 + wholeBombOffsetX, -330.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-104.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -224.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-91.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.83 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.83 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)26.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.713 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.713 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-90.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.818 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.818 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(41.0/100.0 * 255.0);
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(282.9 + wholeBombOffsetX, -257.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)107.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.06 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.06 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(322.1 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.265 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.265 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -211.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)127.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.497 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.497 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(313.6 + wholeBombOffsetX, -221.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.676 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.676 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(397.6 + wholeBombOffsetX, -250.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-44.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.678 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.678 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(67.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            //Frame 16
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 14){
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(270.9 + wholeBombOffsetX, -102.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-108.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.99);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(10000 , 143.9));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(409.9 + wholeBombOffsetX, -334.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-148.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.529 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.529 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(27.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(411.1 + wholeBombOffsetX, -212.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.696 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.696 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.3 + wholeBombOffsetX, -180.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.531 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.531 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -336.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-92.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.699 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.699 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(258.8 + wholeBombOffsetX, -222.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-101.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.65 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.65 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)30.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.773 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.773 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(44.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-96.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.909 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.909 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(27.0/100.0 * 255.0);
	                
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(272.1 + wholeBombOffsetX, -257.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)118.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.918 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.918 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -282.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-90.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.20 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.20 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.3 + wholeBombOffsetX, -205.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)137.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.409 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.409 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(308.4 + wholeBombOffsetX, -215.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.571 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.571 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(405.1 + wholeBombOffsetX, -250.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-52.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.574 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.574 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(60.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            //Frame 17
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 15){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -93.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-107.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.996);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(4.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(415.0 + wholeBombOffsetX, -341.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-136.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.364 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.364 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(14.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(415.8 + wholeBombOffsetX, -207.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.503 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.503 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -172.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.42 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.42 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -343.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-79.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.505 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.505 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(251.0 + wholeBombOffsetX, -219.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-111.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.466 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.466 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)34.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.532 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.532 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-102.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.995 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.995 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(13.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(260.9 + wholeBombOffsetX, -257.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.771 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.771 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -285.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-95.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.132 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.132 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.6 + wholeBombOffsetX, -199.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)147.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.318 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.318 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(303.2 + wholeBombOffsetX, -209.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.462 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.462 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(412.8 + wholeBombOffsetX, -249.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-61.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.465 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.465 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(54.0/100.0 * 255.0);
	                
	                
	                
	            }
	            
	            
	            //Frame 18
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 16){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(10000, 93.9));
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(41500.0, -341.1));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)38.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(21.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(249.3 + wholeBombOffsetX, -257.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)142.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.619 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.619 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(307.3 + wholeBombOffsetX, -288.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-100.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.062 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.062 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.8 + wholeBombOffsetX, -192.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)157.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.225 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.225 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(297.9 + wholeBombOffsetX, -203.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.35 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.35 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(420.7 + wholeBombOffsetX, -248.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-71);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.353 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.353 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(47.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            
	            //Frame 19
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 17){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)41.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.944 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.944 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(10.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(237.7 + wholeBombOffsetX, -257.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)155.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.466 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.466 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(302.1 + wholeBombOffsetX, -292.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-105.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.99 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.99 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.1 + wholeBombOffsetX, -185.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.13 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.13 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(292.4 + wholeBombOffsetX, -197.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.236 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.236 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(428.8 + wholeBombOffsetX, -248.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-80.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.239 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.239 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(40.0/100.0 * 255.0);
	                
	                
	                
	            }
	            
	            
	            //Frame 20
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 18){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(225.8 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.312 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.312 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(296.9 + wholeBombOffsetX, -295.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-110.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.919 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.919 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.4 + wholeBombOffsetX, -178.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)178.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.035 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.035 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(286.9 + wholeBombOffsetX, -190.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.122 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.122 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(436.9 + wholeBombOffsetX, -247.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-89.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.125 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.125 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(33.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 21
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 19){
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(214.0 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)180);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.158 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.158 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(291.6 + wholeBombOffsetX, -298.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-115.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.847 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.847 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -171.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)171.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.939 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.939 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(281.4 + wholeBombOffsetX, -184.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.007 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.007 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(445.0 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-98.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.01 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.01 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(26.0/100.0 * 255.0);
	                
	            }
	            
	            
	            
	            //Frame 22
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 20){
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(202.5 + wholeBombOffsetX, -256.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.006 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.006 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(286.6 + wholeBombOffsetX, -302.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-119.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.777 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.777 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -164.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)161.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.844 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.844 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -178.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.895 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.895 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(453.0 + wholeBombOffsetX, -246.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-107.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.897 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.897 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(19.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            //Frame 23
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 21){
	                
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(191.2 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)155.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.858 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(281.6 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-124.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.709 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.709 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -158.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)151.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.753 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.753 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(270.8 + wholeBombOffsetX, -172.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-133.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.786 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.786 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(460.8 + wholeBombOffsetX, -245.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-116.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.787 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.787 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                
	            }
	            
	            //Frame 24
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 22){
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(180.5 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)144.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.716 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.716 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(276.8 + wholeBombOffsetX, -308.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-129.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.644 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.644 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -151.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)142.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.665 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.665 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(265.8 + wholeBombOffsetX, -166.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-133.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.681 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.681 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(468.2 + wholeBombOffsetX, -244.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-125.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.682 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.682 * 0.527);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(6.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 23){
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                sBombingAniStruct.bombingAniStruct[i].isAniCombo = false;
	            }
	            
	        }//end if bombingAniStrut i isAni
	        
	        
	    }
	}
	
	public void  manageBombShakeAni()
	{
	    for(int i = 0 ; i < sBombingAniStruct.bombingAniMax ; i++){
	        
	        if(sBombingAniStruct.bombingAniStruct[i].isAniShake){
	            
	            wholeBombOffsetX = sBombingAniStruct.bombingAniStruct[i].aniX;
	            wholeBombOffsetY = sBombingAniStruct.bombingAniStruct[i].aniY;
	            
	            sBombingAniStruct.bombingAniStruct[i].aniTimer++;
	            
	            //Frame 3
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 1){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(356.4 + wholeBombOffsetX, -259.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)25.8);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.522 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.522 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(39.0/100.0 * 255.0);
	            }
	            
	            //Frame 4
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 2){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(360.1 + wholeBombOffsetX, -264.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)51.9);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            //Frame 5
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 3){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -266.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(75/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -267.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)139.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.419);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -254.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-124.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(367.8 + wholeBombOffsetX, -254.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 6
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 4){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353000, 10000));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(71.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(335.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)138.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(338.6 + wholeBombOffsetX, -239.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-123.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(384.5 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(90.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 7
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 5){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(324.1 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)137.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(77.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(331.1 + wholeBombOffsetX, -224.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-121.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(402.1 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            //Frame 8
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 6){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(10000 , 261.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(313.1 + wholeBombOffsetX, -286.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.405);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(65.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(323.6 + wholeBombOffsetX, -209.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-119.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.925);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(73/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(419.8 + wholeBombOffsetX, -217.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(68.0/100.0 * 255.0);
	            }
	            
	            //Frame 9
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 7){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.045 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.015 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(302.4 + wholeBombOffsetX, -293.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.401);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(316.1 + wholeBombOffsetX, -194.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-118.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.934);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(437 + wholeBombOffsetX, -205.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(57.0/100.0 * 255.0);
	            }
	            
	            //Frame 10
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 8){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(292.1 + wholeBombOffsetX, -299.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)135.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.397);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(42.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(308.8 + wholeBombOffsetX, -179.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-116.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.943);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(55.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(453.8 + wholeBombOffsetX, -193.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(47.0/100.0 * 255.0);
	            }
	            
	            //Frame 11
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 9){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(282.2 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)134.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.393);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(301.6 + wholeBombOffsetX, -164.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-115.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.952);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(46.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(469.9 + wholeBombOffsetX, -181.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(38.0/100.0 * 255.0);
	            }
	            
	            //Frame 12
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 10){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(18.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(273.1 + wholeBombOffsetX, -310.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.389);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(22.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -150.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-113.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.96);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(485.1 + wholeBombOffsetX, -170.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(28.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 13
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 11){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(264.8 + wholeBombOffsetX, -315.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.386);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(288.1 + wholeBombOffsetX, -137.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-112.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.969);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(30.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(499.4 + wholeBombOffsetX, -160.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(19.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 14
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 12){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(10000 , 265));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(257.8 + wholeBombOffsetX, -319.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)132.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.383);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(281.9 + wholeBombOffsetX, -125.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-111.0);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.976);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(23.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(512.2 + wholeBombOffsetX, -151.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(11.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 15
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 13){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(10000, 319.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -113.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-109.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.984);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(16.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(523.0 + wholeBombOffsetX, -143.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(5.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 16
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 14){
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(270.9 + wholeBombOffsetX, -102.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-108.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.99);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(10000 , 143.9));
	                
	            }
	            
	            
	            //Frame 17
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 15){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -93.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-107.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.996);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(4.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 18
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 16){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(10000, 93.9));
	            }
	            
	            
	            
	            
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 17){
	                sBombingAniStruct.bombingAniStruct[i].isAniShake = false;
	            }
	            
	        }//end if bombingAniStrut i isAni
	        
	        
	    }
	}
	
	public void  managePlusTimeAni()
	{
	    for(int i = 0 ; i < sBombingAniStruct.bombingAniMax ; i++){
	        
	        if(sBombingAniStruct.bombingAniStruct[i].isAniPlusTime){
	            
	            wholeBombOffsetX = sBombingAniStruct.bombingAniStruct[i].aniX;
	            wholeBombOffsetY = sBombingAniStruct.bombingAniStruct[i].aniY;
	            
	            sBombingAniStruct.bombingAniStruct[i].aniTimer++;
	            
	            //Frame 3
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 1){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(356.4 + wholeBombOffsetX, -259.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)25.8);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.522 * 1.537 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.522 * 1.537 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.064 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.064 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.335 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.335 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(367.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.598 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.598 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(367.6 + wholeBombOffsetX, -247.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.091 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.091 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(345.4 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.321 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.321 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(79/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -277.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)151.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.117 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.117 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(330.0 + wholeBombOffsetX, -247.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-9.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.015 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.015 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-14.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.613 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.613 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-22.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.499 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.499 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(46.0/100.0 * 255.0);
	            }
	            
	            //Frame 4
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 2){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(360.1 + wholeBombOffsetX, -264.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)51.9);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.859 * 1.537 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.859 * 1.537 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.5 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.5 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(368.9 + wholeBombOffsetX, -277.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.856 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.856 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(369.2 + wholeBombOffsetX, -247.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.392 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.392 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.7 + wholeBombOffsetX, -246.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.508 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.508 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)154.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.414 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.414 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(327.1 + wholeBombOffsetX, -246.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-12.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.273 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.273 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-8.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*1.915 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*1.915 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-33.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*1.797 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*1.797 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(69.0/100.0 * 255.0);
	            }
	            
	            //Frame 5
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 3){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -266.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(1.0f/Global.g_Scale*0.534 * 1.537 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(1.0f/Global.g_Scale*0.534 * 1.537 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.991 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.991 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.554 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.554 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(75/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -267.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)139.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.419 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(345.8 + wholeBombOffsetX, -254.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-124.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(367.8 + wholeBombOffsetX, -254.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(370.6 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)116.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.8 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.8 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(370.3 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.342 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.342 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.+ + wholeBombOffsetX, -244.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.479 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.479 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -281.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)157.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.365 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.365 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(325.2 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-14.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.227 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.227 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)-3.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.151 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.151 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(88.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-42.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.04 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.04 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(88.0/100.0 * 255.0);
	            }
	            
	            //Frame 6
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 4){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353000, 10000));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*1.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*1.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.639 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.639 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(71.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(335.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)138.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(338.6 + wholeBombOffsetX, -239.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-123.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(384.5 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(372.6 + wholeBombOffsetX, -283.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)121.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.734 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.734 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -244.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.26 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.26 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.4 + wholeBombOffsetX, -241.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.431 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.431 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -283.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)163.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.281 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.281 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(321.9 + wholeBombOffsetX, -244.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-19.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.146 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.146 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.309 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.309 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-49.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.208 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.208 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 7
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 5){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.0f/Global.g_Scale*0.994 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.0f/Global.g_Scale*0.994 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.753 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.753 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(324.1 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)137.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.424 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(77.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(331.1 + wholeBombOffsetX, -224.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-121.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.899 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(402.1 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(375.0 + wholeBombOffsetX, -286.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)127.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.657 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.657 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(374.9 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.153 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.153 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.1 + wholeBombOffsetX, -236.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.37 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.37 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -287.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)170.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.173 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.173 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -243.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-24.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*2.043 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*2.043 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)1.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.334 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.334 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-50.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.226 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.226 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 8
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 6){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(10000 , 261.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*0.89 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*0.89 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(313.1 + wholeBombOffsetX, -286.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.9);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.405 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(65.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(323.6 + wholeBombOffsetX, -209.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-119.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.925 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(73/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(419.8 + wholeBombOffsetX, -217.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(377.6 + wholeBombOffsetX, -290.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)134.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.568 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.568 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(378 + wholeBombOffsetX, -240.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*2.029 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*2.029 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.8 + wholeBombOffsetX, -232.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.299 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.299 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -291.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)178.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*2.048 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*2.048 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -241.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-31.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.922 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.922 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)3.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.366 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.366 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-53.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.262 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.262 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(339 + wholeBombOffsetX, -258.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)47.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.801 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.801 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(347.0 + wholeBombOffsetX, -263.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-62.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.606 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.606 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(350.8 + wholeBombOffsetX, -245 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)78.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.956 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.956 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -251.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.226 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.226 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(358.8 + wholeBombOffsetX, -253.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.223 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.223 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 9
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 7){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.045 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.015 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(302.4 + wholeBombOffsetX, -293.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)136.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.401 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(316.1 + wholeBombOffsetX, -194.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-118.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.934 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(64.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(437 + wholeBombOffsetX, -205.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(57.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(380.8 + wholeBombOffsetX, -294.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)141.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.471 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.471 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(381.1 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.892 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.892 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.4 + wholeBombOffsetX, -226.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.22 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.22 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -296.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-172.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.908 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.908 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(306.9 + wholeBombOffsetX, -239.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-38.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.792 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.792 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)6.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.402 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.402 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-53.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.312 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.312 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(333.4 + wholeBombOffsetX, -258.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)53.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.722 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.722 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(344.6 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-64.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.57 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.57 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -241.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)83.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.91 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.91 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(337.1 + wholeBombOffsetX, -248.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.168 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.168 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(96.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(362.6 + wholeBombOffsetX, -253.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-4.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.174 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.174 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(96.0/100.0 * 255.0);
	            }
	            
	            //Frame 10
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 8){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.213 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.213 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(292.1 + wholeBombOffsetX, -299.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)135.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.397 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(42.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(308.8 + wholeBombOffsetX, -179.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-116.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.943 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(55.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(453.8 + wholeBombOffsetX, -193.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(394.1 + wholeBombOffsetX, -298.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)149.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.361 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.361 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(385.1 + wholeBombOffsetX, -234.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.742 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.742 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.1 + wholeBombOffsetX, -220.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.133 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.133 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.3 + wholeBombOffsetX, -301.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-162.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.75 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.75 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(300.9 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-46.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.647 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.647 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)8.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.444 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.444 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-60.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.375 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.375 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -258.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)60.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.638 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.638 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(341.7 + wholeBombOffsetX, -267.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-67.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.531 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.531 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -237.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)89.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.858 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.858 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(334.1 + wholeBombOffsetX, -245.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.105 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.105 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(93.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(367.1 + wholeBombOffsetX, -253.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-9.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.11 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.11 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(93.0/100.0 * 255.0);
	            }
	            
	            //Frame 11
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 9){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.386 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.386 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(282.2 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)134.4);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.393 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(301.6 + wholeBombOffsetX, -164.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-115.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.952 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(46.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(469.9 + wholeBombOffsetX, -181.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(387.9 + wholeBombOffsetX, -303.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)158.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(389.1 + wholeBombOffsetX, -230.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.583 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.583 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.7 + wholeBombOffsetX, -214.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*1.041 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*1.041 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -306.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-151.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.595 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.595 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -234.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-54.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.496 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.496 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.7 + wholeBombOffsetX, -256.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)13.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.492 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.495 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-65.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.453 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.453 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(100.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(319.6 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)68.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.543 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.543 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(338.5 + wholeBombOffsetX, -269.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-70.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.487 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.487 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.2 + wholeBombOffsetX, -233.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)95.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.78 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.78 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(330.7 + wholeBombOffsetX, -241.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*2.034 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*2.034 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(89.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -252.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-15.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*2.038 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*2.038 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(89.0/100.0 * 255.0);
	            }
	            
	            //Frame 12
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 10){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.558 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.558 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(18.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(273.1 + wholeBombOffsetX, -310.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.389 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(22.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -150.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-113.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.96 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(485.1 + wholeBombOffsetX, -170.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(391.6 + wholeBombOffsetX, -309.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*1.118 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*1.118 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(72.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(393.1 + wholeBombOffsetX, -227.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.416 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.416 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.2 + wholeBombOffsetX, -208.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.946 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.946 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -312.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-140.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.427 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.427 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(287.8 + wholeBombOffsetX, -232.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-63.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.338 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.338 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)15.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.542 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.542 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(90.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.4 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-71.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.535 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.535 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(86.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(311.4 + wholeBombOffsetX, -258.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)76.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.437 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.437 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(334.9 + wholeBombOffsetX, -271.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-74.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.438 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.438 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.4 + wholeBombOffsetX, -228.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)102.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.731 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.731 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(84.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(326.9 + wholeBombOffsetX, -236.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-130.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.955 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.955 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(84/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(377.8 + wholeBombOffsetX, -252.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-21.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.959 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.959 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(84.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 13
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 11){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.0f/Global.g_Scale*1.72 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.0f/Global.g_Scale*1.72 * 2.099 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(264.8 + wholeBombOffsetX, -315.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)133.1);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.386 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(288.1 + wholeBombOffsetX, -137.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-112.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.969 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(30.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(499.4 + wholeBombOffsetX, -160.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(395.9 + wholeBombOffsetX, -314.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)177.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.983 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.983 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(62.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(397.4 + wholeBombOffsetX, -223.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.244 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.244 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.9 + wholeBombOffsetX, -201.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.846 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.846 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.7 + wholeBombOffsetX, -318.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-129.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.253 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.253 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(280.9 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-72.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.174 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.174 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)19.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.596 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.596 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-77.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.627 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.627 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(72.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(302.6 + wholeBombOffsetX, -257.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.32 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.32 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(330.9 + wholeBombOffsetX, -274.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-77.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.384 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.384 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -223.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)110.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.658 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.658 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(322.8 + wholeBombOffsetX, -232.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.868 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.868 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(383.9 + wholeBombOffsetX, -251.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-28.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.872 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.872 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 14
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 12){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(10000 , 265));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(257.8 + wholeBombOffsetX, -319.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)132.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(1.0f/Global.g_Scale*0.383 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(281.9 + wholeBombOffsetX, -125.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-111.0);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.976 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(23.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(512.2 + wholeBombOffsetX, -151.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(11.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(400.4 + wholeBombOffsetX, -321.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)171.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.84 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.84 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(51.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(401.8 + wholeBombOffsetX, -219.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*1.066 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*1.066 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.3 + wholeBombOffsetX, -194.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.744 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.744 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -324.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-117.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*1.074 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*1.074 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(273.8 + wholeBombOffsetX, -227.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-82.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*1.005 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*1.005 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)22.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.654 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.654 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(68.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-84.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.722 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.722 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(57.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(293.1 + wholeBombOffsetX, -257.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)96.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.196 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.196 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(326.6 + wholeBombOffsetX, -276.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-81.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.327 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.327 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -217.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)118.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.58 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.58 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(318.3 + wholeBombOffsetX, -226.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.775 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.775 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(73.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(390.6 + wholeBombOffsetX, -251.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-36.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.778 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.778 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(73.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 15
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 13){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(10000, 319.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -113.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-109.8);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.984 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(16.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(523.0 + wholeBombOffsetX, -143.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setRotation((float)-32.3);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleX(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setScaleY(1.0f/Global.g_Scale*0.636 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(404.9 + wholeBombOffsetX, -327.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)160.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.688 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.688 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(406.4 + wholeBombOffsetX, -215.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.884 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.884 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.9 + wholeBombOffsetX, -187.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.639 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.639 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.9 + wholeBombOffsetX, -330.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-104.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.889 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.889 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -224.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-91.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.83 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.83 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)26.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.713 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.713 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-90.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.818 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.818 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(41.0/100.0 * 255.0);
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(282.9 + wholeBombOffsetX, -257.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)107.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*2.06 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*2.06 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(322.1 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.265 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.265 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -211.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)127.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.497 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.497 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(313.6 + wholeBombOffsetX, -221.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.676 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.676 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(397.6 + wholeBombOffsetX, -250.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-44.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.678 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.678 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(67.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            //Frame 16
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 14){
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(270.9 + wholeBombOffsetX, -102.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-108.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.99 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[2].setPosition(CGPoint.ccp(10000 , 143.9));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(409.9 + wholeBombOffsetX, -334.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-148.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.529 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.529 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(27.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(411.1 + wholeBombOffsetX, -212.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.696 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.696 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.3 + wholeBombOffsetX, -180.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.531 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.531 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -336.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-92.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.699 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.699 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(258.8 + wholeBombOffsetX, -222.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-101.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.65 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.65 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)30.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.773 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.773 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(44.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-96.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.909 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.909 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(27.0/100.0 * 255.0);
	                
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(272.1 + wholeBombOffsetX, -257.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)118.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.918 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.918 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -282.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-90.5);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.20 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.20 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.3 + wholeBombOffsetX, -205.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)137.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.409 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.409 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(308.4 + wholeBombOffsetX, -215.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.571 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.571 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(60.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(405.1 + wholeBombOffsetX, -250.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-52.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.574 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.574 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(60.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            //Frame 17
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 15){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -93.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setRotation((float)-107.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleX(1.0f/Global.g_Scale*0.635 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setScaleY(1.0f/Global.g_Scale*0.996 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setOpacity(4.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(415.0 + wholeBombOffsetX, -341.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-136.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.0f/Global.g_Scale*0.364 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.0f/Global.g_Scale*0.364 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(14.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(415.8 + wholeBombOffsetX, -207.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.0f/Global.g_Scale*0.503 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.0f/Global.g_Scale*0.503 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -172.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.0f/Global.g_Scale*0.42 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.0f/Global.g_Scale*0.42 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -343.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-79.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.0f/Global.g_Scale*0.505 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.0f/Global.g_Scale*0.505 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(251.0 + wholeBombOffsetX, -219.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-111.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.0f/Global.g_Scale*0.466 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.0f/Global.g_Scale*0.466 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)34.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.532 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.532 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(32.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(341.6 + wholeBombOffsetX, -259.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setRotation((float)-102.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleX(1.0f/Global.g_Scale*2.995 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setScaleY(1.0f/Global.g_Scale*2.995 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setOpacity(13.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(260.9 + wholeBombOffsetX, -257.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)130.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.771 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.771 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -285.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-95.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.132 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.132 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.6 + wholeBombOffsetX, -199.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)147.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.318 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.318 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(303.2 + wholeBombOffsetX, -209.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-131.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.462 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.462 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(54.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(412.8 + wholeBombOffsetX, -249.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-61.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.465 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.465 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(54.0/100.0 * 255.0);
	                
	                
	                
	            }
	            
	            
	            //Frame 18
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 16){
	                sBombingAniStruct.bombingAniStruct[i].s_debris[1].setPosition(CGPoint.ccp(10000, 93.9));
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(41500.0, -341.1));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[6].setPosition(CGPoint.ccp(41500.0, -341.1));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)38.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.889 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.889 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(21.0/100.0 * 255.0);
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(249.3 + wholeBombOffsetX, -257.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)142.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.619 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.619 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(307.3 + wholeBombOffsetX, -288.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-100.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*1.062 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*1.062 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(352.8 + wholeBombOffsetX, -192.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)157.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.225 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.225 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(297.9 + wholeBombOffsetX, -203.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.35 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.35 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(420.7 + wholeBombOffsetX, -248.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-71);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.353 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.353 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(47.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            
	            //Frame 19
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 17){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(349.8 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setRotation((float)41.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleX(1.0f/Global.g_Scale*2.944 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setScaleY(1.0f/Global.g_Scale*2.944 * 0.492 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setOpacity(10.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(237.7 + wholeBombOffsetX, -257.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)155.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.466 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.466 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(302.1 + wholeBombOffsetX, -292.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-105.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.99 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.99 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.1 + wholeBombOffsetX, -185.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.13 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.13 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(292.4 + wholeBombOffsetX, -197.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.236 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.236 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(40.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(428.8 + wholeBombOffsetX, -248.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-80.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.239 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.239 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(40.0/100.0 * 255.0);
	                
	                
	                
	            }
	            
	            
	            //Frame 20
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 18){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[5].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(225.8 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.312 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.312 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(296.9 + wholeBombOffsetX, -295.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-110.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.919 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.919 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.4 + wholeBombOffsetX, -178.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)178.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*1.035 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*1.035 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(286.9 + wholeBombOffsetX, -190.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.122 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.122 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(436.9 + wholeBombOffsetX, -247.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-89.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.125 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.125 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(33.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 21
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 19){
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(214.0 + wholeBombOffsetX, -256.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)180);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.158 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.158 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(291.6 + wholeBombOffsetX, -298.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-115.0);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.847 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.847 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -171.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)171.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.939 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.939 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(281.4 + wholeBombOffsetX, -184.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*1.007 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*1.007 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(26.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(445.0 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-98.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*1.01 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*1.01 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(26.0/100.0 * 255.0);
	                
	            }
	            
	            
	            
	            //Frame 22
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 20){
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(202.5 + wholeBombOffsetX, -256.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*1.006 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*1.006 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(286.6 + wholeBombOffsetX, -302.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-119.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.777 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.777 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -164.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)161.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.844 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.844 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(276.1 + wholeBombOffsetX, -178.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-132.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.895 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.895 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(19.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(453.0 + wholeBombOffsetX, -246.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-107.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.897 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.897 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(19.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            //Frame 23
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 21){
	                
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(191.2 + wholeBombOffsetX, -256.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)155.7);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.858 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.858 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(281.6 + wholeBombOffsetX, -305.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-124.6);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.709 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.709 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -158.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)151.9);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.753 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.753 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(270.8 + wholeBombOffsetX, -172.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-133.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.786 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.786 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(460.8 + wholeBombOffsetX, -245.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-116.8);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.787 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.787 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	                
	            }
	            
	            //Frame 24
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 22){
	                
	                
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(180.5 + wholeBombOffsetX, -256.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setRotation((float)144.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleX(1.0f/Global.g_Scale*0.716 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setScaleY(1.0f/Global.g_Scale*0.716 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(276.8 + wholeBombOffsetX, -308.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setRotation((float)-129.1);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleX(1.0f/Global.g_Scale*0.644 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setScaleY(1.0f/Global.g_Scale*0.644 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(354.1 + wholeBombOffsetX, -151.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setRotation((float)142.4);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleX(1.0f/Global.g_Scale*0.665 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setScaleY(1.0f/Global.g_Scale*0.665 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(265.8 + wholeBombOffsetX, -166.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setRotation((float)-133.2);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleX(1.0f/Global.g_Scale*0.681 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setScaleY(1.0f/Global.g_Scale*0.681 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setOpacity(6.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(468.2 + wholeBombOffsetX, -244.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setRotation((float)-125.3);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleX(1.0f/Global.g_Scale*0.682 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setScaleY(1.0f/Global.g_Scale*0.682 * 0.527 * plusTimeScale);
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setOpacity(6.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 23){
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[0].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[1].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[2].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[3].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_smallClouds[4].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                sBombingAniStruct.bombingAniStruct[i].isAniPlusTime = false;
	            }
	            
	        }//end if bombingAniStrut i isAni
	        
	        
	    }
	}

}
