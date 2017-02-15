package com.zombieglider.Main;


import org.cocos2d.types.CGPoint;
import org.cocos2d.nodes.CCNode;
//
//  BombScript2.m
//  TurtlesHuh
//
//  Created by  on 2012/5/20.
//  Copyright 2012??__MyCompanyName__. All rights reserved.
//

import com.zombieglider.sBombingAniStruct;

//ByRCH#import "BombScript2.h"
//ByRCH#import "BombScriptGlobal.h"

public class BombScript2 extends CCNode
{
	float wholeBombOffsetX = 0;
    float wholeBombOffsetY = 0;
    
	public void  manage()
	{
	    this.manageBombCannonAni();
	}
	
	public void  manageBombCannonAni()
	{
	    for(int i = 0 ; i < sBombingAniStruct.bombingAniMax ; i++){
	        
	        if(sBombingAniStruct.bombingAniStruct[i].isAniCannon){
	            
	            wholeBombOffsetX = sBombingAniStruct.bombingAniStruct[i].aniX;
	            wholeBombOffsetY = sBombingAniStruct.bombingAniStruct[i].aniY;
	            
	            sBombingAniStruct.bombingAniStruct[i].aniTimer++;
	            
	            //Frame 3
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 1){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(356.4 + wholeBombOffsetX, -259.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)25.8);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(0.522 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(0.522 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.064);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(0.335 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(367.3 + wholeBombOffsetX, -273.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.598 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.598 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(367.6 + wholeBombOffsetX, -247.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(2.091 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(2.091 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(345.4 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)43.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.321 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.321 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(79/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -277.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)151.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(2.117 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(2.117 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(330.0 + wholeBombOffsetX, -247.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-9.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(2.015 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(2.015 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(79.0/100.0 * 255.0);
	            }
	            
	            //Frame 4
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 2){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(360.1 + wholeBombOffsetX, -264.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)51.9);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(0.859 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.527);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(0.5 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(79.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(368.9 + wholeBombOffsetX, -277.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)113.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.856 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.856 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(369.2 + wholeBombOffsetX, -247.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(2.392 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(2.392 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.7 + wholeBombOffsetX, -246.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)39.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.508 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.508 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -279.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)154.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(2.414 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(2.414 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(327.1 + wholeBombOffsetX, -246.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-12.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(2.273 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(2.273 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 5
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 3){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353.6 + wholeBombOffsetX, -266.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setRotation((float)86.2);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleX(0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setScaleY(0.534 * 1.537);
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setOpacity(50.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.991);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(0.554 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(75/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(370.6 + wholeBombOffsetX, -280.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)116.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.8 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.8 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(370.3 + wholeBombOffsetX, -246.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(2.342 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(2.342 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.+ + wholeBombOffsetX, -244.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)35.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.479 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.479 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -281.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)157.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(2.365 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(2.365 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(325.2 + wholeBombOffsetX, -245.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-14.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(2.227 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(2.227 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            //Frame 6
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 4){
	                sBombingAniStruct.bombingAniStruct[i].s_buum.setPosition(CGPoint.ccp(353000, 10000));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(1.492);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(67.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(0.639 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(71.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(372.6 + wholeBombOffsetX, -283.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)121.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.734 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(372.2 + wholeBombOffsetX, -244.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(2.26 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(2.26 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.4 + wholeBombOffsetX, -241.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)29.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.431 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.431 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -283.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)163.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(2.281 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(2.281 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(321.9 + wholeBombOffsetX, -244.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-19.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(2.146 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(2.146 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 7
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 5){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(350.5 + wholeBombOffsetX, -261.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleX(0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setScaleY(0.994);
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setOpacity(33.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(0.753 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(64.0/100.0 * 255.0);
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(375.0 + wholeBombOffsetX, -286.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)127.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.657 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(374.9 + wholeBombOffsetX, -242.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(2.153 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(2.153 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(344.1 + wholeBombOffsetX, -236.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)20.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.37 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(350.9 + wholeBombOffsetX, -287.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)170.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(2.173 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(2.173 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(317.4 + wholeBombOffsetX, -243.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-24.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(2.043 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(2.043 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 8
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 6){
	                sBombingAniStruct.bombingAniStruct[i].s_blick.setPosition(CGPoint.ccp(10000 , 261.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(0.89 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(56.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(377.6 + wholeBombOffsetX, -290.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)134.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.568 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.568 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(378 + wholeBombOffsetX, -240.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(2.029 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(2.029 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.8 + wholeBombOffsetX, -232.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)11.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.299 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.299 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -291.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)178.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(2.048 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(2.048 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(312.4 + wholeBombOffsetX, -241.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-31.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.922 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.922 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 9
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 7){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.045 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.015 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(47.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(380.8 + wholeBombOffsetX, -294.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)141.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.471 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.471 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(381.1 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.892 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.892 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.4 + wholeBombOffsetX, -226.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)0.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.22 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.22 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.1 + wholeBombOffsetX, -296.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-172.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.908 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.908 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(100.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(306.9 + wholeBombOffsetX, -239.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-38.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.792 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.792 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(100.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 10
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 8){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.213 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(38.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(394.1 + wholeBombOffsetX, -298.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)149.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.361 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.361 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(385.1 + wholeBombOffsetX, -234.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.742 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.742 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(343.1 + wholeBombOffsetX, -220.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-11.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.133 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.133 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.3 + wholeBombOffsetX, -301.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-162.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.75 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.75 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(91.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(300.9 + wholeBombOffsetX, -237.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-46.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.647 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.647 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(91.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 11
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 9){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.386 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(28.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(387.9 + wholeBombOffsetX, -303.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)158.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(82.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(389.1 + wholeBombOffsetX, -230.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.583 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.583 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.7 + wholeBombOffsetX, -214.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-23.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(1.041 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(1.041 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -306.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-151.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.595 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.595 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(80.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(294.6 + wholeBombOffsetX, -234.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-54.9);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.496 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.496 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(80.0/100.0 * 255.0);
	                
	            }
	            
	            //Frame 12
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 10){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.558 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(18.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(391.6 + wholeBombOffsetX, -309.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)167.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(1.118 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(1.118 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(72.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(393.1 + wholeBombOffsetX, -227.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.416 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.416 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(342.2 + wholeBombOffsetX, -208.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-36.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(0.946 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(0.946 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.6 + wholeBombOffsetX, -312.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-140.6);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.427 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.427 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(70.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(287.8 + wholeBombOffsetX, -232.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-63.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.338 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.338 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(70.0/100.0 * 255.0);
	            }
	            
	            
	            //Frame 13
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 11){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(351.5 + wholeBombOffsetX, -265.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleX(1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setScaleY(1.72 * 2.099);
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setOpacity(9.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(395.9 + wholeBombOffsetX, -314.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)177.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(0.983 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(0.983 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(62.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(397.4 + wholeBombOffsetX, -223.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.244 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.9 + wholeBombOffsetX, -201.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-50.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(0.846 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(0.846 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.7 + wholeBombOffsetX, -318.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-129.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.253 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.253 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(59.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(280.9 + wholeBombOffsetX, -230.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-72.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.174 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.174 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(59.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 14
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 12){
	                sBombingAniStruct.bombingAniStruct[i].s_wave.setPosition(CGPoint.ccp(10000 , 265));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(257.8 + wholeBombOffsetX, -319.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setRotation((float)132.6);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleX(0.383);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setScaleY(0.635);
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setOpacity(5.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(400.4 + wholeBombOffsetX, -321.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)171.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(0.84 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(0.84 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(51.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(401.8 + wholeBombOffsetX, -219.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(1.066 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(1.066 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(341.3 + wholeBombOffsetX, -194.6 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-64.2);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(0.744 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(0.744 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.8 + wholeBombOffsetX, -324.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-117.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(1.074 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(1.074 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(48.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(273.8 + wholeBombOffsetX, -227.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-82.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(1.005 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(1.005 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(48.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 15
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 13){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_debris[0].setPosition(CGPoint.ccp(10000, 319.5));
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(404.9 + wholeBombOffsetX, -327.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)160.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(0.688 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(0.688 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(39.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(406.4 + wholeBombOffsetX, -215.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(0.884 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(0.884 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.9 + wholeBombOffsetX, -187.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-78.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(0.639 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(0.639 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(351.9 + wholeBombOffsetX, -330.5 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-104.8);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(0.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(0.889 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(36.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(266.4 + wholeBombOffsetX, -224.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-91.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(0.83 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(0.83 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(36.0/100.0 * 255.0);
	                
	            }
	            
	            
	            //Frame 16
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 14){
	                
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(409.9 + wholeBombOffsetX, -334.2 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-148.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(0.529 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(0.529 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(27.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(411.1 + wholeBombOffsetX, -212.0 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(0.696 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(0.696 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(340.3 + wholeBombOffsetX, -180.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-93.0);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(0.531 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(0.531 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -336.9 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-92.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(0.699 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(0.699 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(25.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(258.8 + wholeBombOffsetX, -222.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-101.3);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(0.65 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(0.65 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(25.0/100.0 * 255.0);
	                
	                
	            }
	            
	            
	            //Frame 17
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 15){
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(415.0 + wholeBombOffsetX, -341.1 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setRotation((float)-136.4);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleX(0.364 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setScaleY(0.364 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setOpacity(14.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(415.8 + wholeBombOffsetX, -207.8 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleX(0.503 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setScaleY(0.503 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(339.8 + wholeBombOffsetX, -172.7 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setRotation((float)-108.1);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleX(0.42 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setScaleY(0.42 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(352.1 + wholeBombOffsetX, -343.4 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setRotation((float)-79.7);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleX(0.505 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setScaleY(0.505 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setOpacity(13.0/100.0 * 255.0);
	                
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(251.0 + wholeBombOffsetX, -219.3 + wholeBombOffsetY));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setRotation((float)-111.5);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleX(0.466 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setScaleY(0.466 * 0.492);
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setOpacity(13.0/100.0 * 255.0);
	                
	            }
	            
	            
	            if(sBombingAniStruct.bombingAniStruct[i].aniTimer == 16){
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[0].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[1].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[2].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[3].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[4].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                sBombingAniStruct.bombingAniStruct[i].s_bigClouds[7].setPosition(CGPoint.ccp(34900.8 , -256.2));
	                
	                sBombingAniStruct.bombingAniStruct[i].isAniCannon = false;
	            }
	            
	        }//end if sBombingAniStruct.bombingAniStrut i isAni
	        
	        
	    }
	}

}
