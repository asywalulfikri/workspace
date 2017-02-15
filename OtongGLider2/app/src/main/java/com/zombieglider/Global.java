package com.zombieglider;

import java.util.ArrayList;
import java.util.List;

import org.cocos2d.actions.base.CCRepeatForever;
import org.cocos2d.actions.interval.CCRotateTo;
import org.cocos2d.actions.interval.CCScaleTo;
import org.cocos2d.actions.interval.CCSequence;
import org.cocos2d.layers.CCColorLayer;
import org.cocos2d.nodes.CCNode;
import org.cocos2d.nodes.CCSprite;
import org.cocos2d.types.CGPoint;

import com.zombieglider.Main.PlayScene;
import com.zombieglider.Main.UILayer;

public class Global
{
	public static boolean g_DebugAll = false;

	public static int g_Scale = 2;
	
	public static int VIRT_WIDTH = 480;
	public static int VIRT_HEIGHT = 320;
	public static int SCREEN_WIDTH;
	public static int SCREEN_HEIGHT;

	public static boolean isMusic = true;
	public static boolean isSound = true;	
	public static float musicVolumn;
	public static float soundVolumn;
	
	public static int g_bestScore[] = new int[10];

	public static int maxAchivements = 45;
	public static boolean hasFinishedThisAchivements[] = new boolean[maxAchivements];
	public static int ahievementReward[] = new int[maxAchivements];

	public static int currentAchivementIdx[] = new int[4];

	public static int maxMiniGames = 20;
	public static int maxTotalMiniChosen = 10;
	public static int maxTotalMissionGameChosen = 1;
	public static boolean hasPlayedMiniGames[] = new boolean[maxMiniGames];

	public static int maxMissions = 88;
	public static int maxMissionsShowForOneTime = 3;
	public static int missionCompleted;
	public static int missionIdxMatched[] = new int[maxMissions];
	public static boolean hasFinishedMission[] = new boolean[maxMissions];
	public static boolean hasPlayedThisMissionBefore[] = new boolean[maxMissions];
	public static int currentChosenMissionIdx[] = new int[5];
	public static int currentChosenMission[] = new int[5];
	public static boolean currentChosenMissionWon[] = new boolean[5];

	public static int maxUpgradeItems = 22;
	public static int upgradeItemLevel[] = new int[maxUpgradeItems];

	public static int maxONSUpgradeItems = 8;
	public static int onsUpgradeItemLevel[] = new int[maxONSUpgradeItems];
	public static boolean onsUpgradeItemIsEnable[] = new boolean[maxONSUpgradeItems];
	public static boolean permenanatUpgradeItemIsEnable[] = new boolean[8];

	public static float timeRunOut_Fast_Gain;
	public static float timeRunOut_Slow_Gain;
	public static float timeRunOut_Fast_MaxGain;
	public static float timeRunOut_Slow_MaxGain;


	public static boolean returnBackToSameMusic;
	public static boolean goToNullWithNewPlayMusic;

	public static boolean achivementIsGoingToCoverScene;
	public static boolean achivementIsGoingToStoreScene;
	public static boolean achivementIsGoingToSelectMiniScene;

	public static int miniGameOrder[] = new int[15];
	public static int miniGameIdx;

	public static boolean isEarningCoinsFromTapJoy;
	public static int earningCoinsFromTapjoyTimer;

	public static boolean isGoingFromMainPlayScene;
	public static boolean isGoingSelectMIniAfterPlay;
	public static boolean isGoingToNextMiniGame;

	public static boolean hasShownedExtra;
	public static int canShownExtra;
	public static int canShownExtra2;

	public static boolean hasRatedBefore;
	public static boolean isGoingToRate;
	public static int rateTimer;
	public static boolean isFreeChargesOnONS;

	public static boolean hasGameCenterSupport;


	public static int fromInstruction_GoToNextIdx;
	public static int storyType;


	//for ad use
	public static boolean ad_isClickingShowMore;
	public static boolean ad_isLocking;
	public static boolean ad_isLoading;
	public static int ad_chosenype;
	public static boolean ad_firstTime;
	public static boolean ad_revmobIsFirstLoad;
	public static boolean ad_isDirectLoaded;
	public static int ad_RevmobChartboostRatio;
	public static int ad_RevmobChartboostRatio2;
	public static int ad_howmanyRounds;
	public static int ad_howmanyGamesPlayed;
	public static int ad_howmanyMainGamePlayed;
	public static boolean ad_isInGaming;
	public static boolean ad_isLoadingFromBecomeActive;
	public static boolean ad_notShowAdTHisTime;

	//p4RC
	public static int lastFuckPoint;
	public static boolean p4rc_canDisplayScore;
	public static boolean p4rc_isInMiniGame;

	public static boolean burstly_viewedOffer;
	public static int burstly_coinsGained;
	public static boolean burstly_isOpenning;

	//burtsly
	public static boolean bustly_isdeleteControllerInMainGame;
	public static boolean isIphone5 = false;
	
	//GamePlayGlobal
	
	public static final int kWholeGameStatus_Playing = 0;
	public static final int kWholeGameStatus_Restarting = 1;
	
	public static int wholeGameStatus;
	public static boolean isStopping;
	public static CCColorLayer s_blackTranspancy_bg;
	public static CCSprite s_menu_instruction;
	public static CCSprite s_menu_restart;
	public static CCSprite s_menu_resume;
	public static CCSprite s_menu_exit;
	public static CCSprite s_gameover;
	public static CCSprite s_ingameInstruction;

	public static final int kDeapth_miniBasic = 0;
	public static final int kDeapth_ssCharacter = 1;
	public static final int kDeapth_ssExtra = 2;
    
	public static final int kDeapth_Extra1 = 3;
	public static final int kDeapth_Extra2 = 4;
    
	public static final int kDeapth_Equip_Fire = 5;
	public static final int kDeapth_Equip_Smoke = 6;
	public static final int kDeapth_Equip_Rocket = 7;
	public static final int kDeapth_Turtle_Neck = 8;
	public static final int kDeapth_Turtle_Shadow = 9;
	public static final int kDeapth_Turtle_Head = 10;
	public static final int kDeapth_Turtle_HeadAndNeck = 11;
	public static final int kDeapth_Turtle_Tail = 12;
	public static final int kDeapth_Turtle_Shell = 13;
	public static final int kDeapth_Turtle_LeftLeg = 14;
	public static final int kDeapth_Turtle_RightLeg = 15;
	public static final int kDeapth_Turtle_Eye = 16;
	public static final int kDeapth_Turtle_Spike = 17;
	public static final int kDeapth_Equip_Glide = 18;
    
	public static final int kDeapth_Penguin_MAIN = 19;
    
	public static final int kDeapth_Top = 20;
	public static final int kDeapth_Turtle_Bombing = 21;
    
	public static final int kDeapth_Penguin_Body = 22;
	public static final int kDeapth_Penguin_Eye = 23;
	public static final int kDeapth_Penguin_Mouth = 24;
	public static final int kDeapth_Penguin_Wing = 25;
	public static final int kDeapth_Penguin_BackLeg = 26;
	public static final int kDeapth_Penguin_FrongLeg = 27;
    
	public static final int kDeapth_Penguin_Bombing = 28;
    
	public static final int kDeapth_Bg_Element1 = 29;
    
	public static final int kDeapth_Btns = 30;
	public static final int kDeapth_Menu1 = 31;
	public static final int kDeapth_Menu = 32;
	public static final int kDeapth_Gameover = 33;
	public static final int kDeapth_Turtle_Bombing2 = 34;
	public static final int kDeapth_FUCKTOP = 35;

	public static CCSprite ss_Gameover;
	public static CCSprite ss_Character;
	public static CCSprite ss_Extra;

	public static float wholeTurtleScaleFromSocurce;
	public static float wholePenguinScaleFromSocurce;
	public static float wholeCannonScaleFromSocurce;

	public static int currentChosenMiniGame;

	public static int counterForAchivement;
	public static int currentTurtleCoin; //replaced by Bomb(B) number
	public static int turtleCoinAccum;
	public static int currentCombo;
	public static int maxCombo;
	public static float comboRemain;
	public static double comoboReduceSpeed;
	public static int comboToStart;

	public static boolean isShowingMenu;
	public static boolean isShowingInstruction;

	public static float timeRemain;
	public static float maxTime;

	public static float penguinJumpFinalX;
	public static float penguinJumpFinalY;
	public static float penguin_DynmaicJumpY;


	public static int next_jumpType;
	public static boolean next_isFacingRight;
	public static boolean next_hasNext;
	public static boolean isGoingToNext;

	public static int comboColorLimit[] = new int[11];
	public static int comboLevel;

	public static float turtleCoinShinning_angleSpeed;
	public static float turtleCoinShinning_angleAcceleration;

	public static int currentTurtleOnScreen;
	public static int maxTurtleOnScreen;

	public static float cannonAngle;

	public static UILayer uILayer;

	public static int turtle_detectHalfLeft;
	public static int turtle_detectHalfRight;
	public static int turtle_detectHalfUp;
	public static int turtle_detectHalfDown;


	public static PlayScene playLayer;


	public static int gameLevel;
	public static int gameLevel_Combo;
	public static int gameRound;
	public static int gameRoundFromBegin;


	public static boolean isTapWronglyAndDisableBtns;
	public static int tapWronglyAndDisableBtnsTimer;

	public static boolean isFuckingShootFirstTime;


	public static boolean cannotPlayTurtleHeadOutSound;

	public static float timeToBeGained;

	public static boolean isPlayingMiniGame;
	public static boolean isMainGameBeginning;
	public static float objVInCollision;
	
	public static FrameData frameData[];
	public static double frameDataTemp[][] = 
	{
	    // 0. sprite "shadow", frame 1
		{
			-15.399999999999977, // x
			-21.899999999999977, // y
			0, // rotation
			0.8482137157678381, // scaleX
			0.9326208959770526, // scaleY
		},
	    
		// 1. sprite "shadow", frame 2
		{
			-32.94999999999999, // x
			-21.899999999999977, // y
			0, // rotation
			1.0420259895319948, // scaleX
			0.8620410134427553, // scaleY
		},
	    
		// 2. sprite "shadow", frame 3
		{
			-48.75f, // x
			-21.899999999999977, // y
			0, // rotation
			1.2163001452502018, // scaleX
			0.7986362641951397, // scaleY
		},
	    
		// 3. sprite "shadow", frame 4
		{
			-60.85000000000002, // x
			-21.899999999999977, // y
			0, // rotation
			1.3498664019133577, // scaleX
			0.7500001566396444, // scaleY
		},
	    
		// 4. sprite "shadow", frame 5
		{
			-53.55000000000001, // x
			-21.899999999999977, // y
			0, // rotation
			1.3060416082235673, // scaleX
			0.7852273416389796, // scaleY
		},
	    
		// 5. sprite "shadow", frame 6
		{
			-44.30000000000001, // x
			-21.899999999999977, // y
			0, // rotation
			1.2507951737917122, // scaleX
			0.8295960229831539, // scaleY
		},
	    
		// 6. sprite "shadow", frame 7
		{
			-34.14999999999998, // x
			-21.899999999999977, // y
			0, // rotation
			1.1898588377447625, // scaleX
			0.8785249931217791, // scaleY
		},
	    
		// 7. sprite "shadow", frame 8
		{
			-24.25, // x
			-21.899999999999977, // y
			0, // rotation
			1.1303449771015865, // scaleX
			0.9263452691956984, // scaleY
		},
	    
		// 8. sprite "shadow", frame 9
		{
			-15.649999999999977, // x
			-21.850000000000023, // y
			0, // rotation
			1.0785710561554143, // scaleX
			0.967931756000139, // scaleY
		},
	    
		// 9. sprite "shadow", frame 10
		{
			-9, // x
			-21.899999999999977, // y
			0, // rotation
			1.0386371510700634, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 10. sprite "shadow", frame 11
		{
			-9, // x
			-21.899999999999977, // y
			0, // rotation
			1.0257511974123494, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 11. sprite "shadow", frame 12
		{
			-9, // x
			-21.899999999999977, // y
			0, // rotation
			1.0128861625105732, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 12. sprite "shadow", frame 13
		{
			-9, // x
			-21.899999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 13. sprite "neck", frame 1
		{
			-40.89999999999998, // x
			18.55000000000001, // y
			-1.2995440487065109, // rotation
			0.3035432902321794, // scaleX
			0.20525004270028277, // scaleY
		},
	    
		// 14. sprite "neck", frame 2
		{
			-46.89999999999998, // x
			24.75, // y
			-1.2601042308590915, // rotation
			0.5348099223600089, // scaleX
			0.4456991160562776, // scaleY
		},
	    
		// 15. sprite "neck", frame 3
		{
			-52.89999999999998, // x
			31.25, // y
			-1.2203453663130805, // rotation
			0.7662637646156559, // scaleX
			0.6863002816033811, // scaleY
		},
	    
		// 16. sprite "neck", frame 4
		{
			-59.30000000000001, // x
			38.55000000000001, // y
			-1.1769504879307842, // rotation
			0.9988211549170356, // scaleX
			0.9279145918326619, // scaleY
		},
	    
		// 17. sprite "neck", frame 5
		{
			-59, // x
			38.19999999999999, // y
			-1.0194934853248303, // rotation
			0.9974123553724437, // scaleX
			0.9197087871983947, // scaleY
		},
	    
		// 18. sprite "neck", frame 6
		{
			-57.69999999999999, // x
			37.25, // y
			-0.7785948520767318, // rotation
			0.9973598319110194, // scaleX
			0.9091987536059576, // scaleY
		},
	    
		// 19. sprite "neck", frame 7
		{
			-55, // x
			35.69999999999999, // y
			-0.493993479024324, // rotation
			0.89719798962314, // scaleY
			0.9977466508117024, // scaleX
		},
	    
		// 20. sprite "neck", frame 8
		{
			-51.39999999999998, // x
			33.19999999999999, // y
			-0.21041582509494258, // rotation
			0.9985523883736204, // scaleX
			0.8856995266120908, // scaleY
		},
	    
		// 21. sprite "neck", frame 9
		{
			-48, // x
			30.19999999999999, // y
			0.018293253527754287, // rotation
			0.9992679726945233, // scaleX
			0.8761616636562469, // scaleY
		},
	    
		// 22. sprite "neck", frame 10
		{
			-45.60000000000002, // x
			27.849999999999994, // y
			0.1717382039515038, // rotation
			0.9994119393328341, // scaleX
			0.8697097804734687, // scaleY
		},
	    
		// 23. sprite "neck", frame 11
		{
			-46.35000000000002, // x
			29.80000000000001, // y
			0.12289742745610462, // rotation
			0.9991679575567362, // scaleX
			0.9049715986018037, // scaleY
		},
	    
		// 24. sprite "neck", frame 12
		{
			-47.35000000000002, // x
			32.400000000000006, // y
			0.061461230585175684, // rotation
			0.9995864752583549, // scaleX
			0.9523669076852045, // scaleY
		},
	    
		// 25. sprite "neck", frame 13
		{
			-48.44999999999999, // x
			34.80000000000001, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 26. sprite "head", frame 1
		{
			-49.55000000000001, // x
			16.69999999999999, // y
			0, // rotation
			0.26911979514040735, // scaleX
			0.26911979514040735, // scaleY
		},
	    
		// 27. sprite "head", frame 2
		{
			-72.19999999999999, // x
			24.30000000000001, // y
			0, // rotation
			0.5743872005414151, // scaleX
			0.5377166213823685, // scaleY
		},
	    
		// 28. sprite "head", frame 3
		{
			-94.65, // x
			31.80000000000001, // y
			0, // rotation
			0.8777509991520788, // scaleX
			0.804639947149302, // scaleY
		},
	    
		// 29. sprite "head", frame 4
		{
			-111.1, // x
			37.55000000000001, // y
			0, // rotation
			1.0997826746763915, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 30. sprite "head", frame 5
		{
			-103.4, // x
			39.900000000000006, // y
			0, // rotation
			1.0862691583405422, // scaleX
			1.0111708245236697, // scaleY
		},
	    
		// 31. sprite "head", frame 6
		{
			-93.05000000000001, // x
			43.05000000000001, // y
			0, // rotation
			1.0681535156983661, // scaleX
			1.026106816263293, // scaleY
		},
	    
		// 32. sprite "head", frame 7
		{
			-81.39999999999998, // x
			46.650000000000006, // y
			0, // rotation
			1.0477786474149027, // scaleX
			1.0429254960373222, // scaleY
		},
	    
		// 33. sprite "head", frame 8
		{
			-70.10000000000002, // x
			50.099999999999994, // y
			0, // rotation
			1.0279685855417613, // scaleX
			1.059263044424781, // scaleY
		},
	    
		// 34. sprite "head", frame 9
		{
			-60.64999999999998, // x
			52.94999999999999, // y
			0, // rotation
			1.0114218495949239, // scaleX
			1.0729439108081333, // scaleY
		},
	    
		// 35. sprite "head", frame 10
		{
			-54.14999999999998, // x
			54.849999999999994, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0823573509801645, // scaleY
		},
	    
		// 36. sprite "head", frame 11
		{
			-57.39999999999998, // x
			56, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0619197264288875, // scaleY
		},
	    
		// 37. sprite "head", frame 12
		{
			-62.30000000000001, // x
			57.650000000000006, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0310436426646248, // scaleY
		},
	    
		// 38. sprite "head", frame 13
		{
			-67.25, // x
			59.400000000000006, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 39. sprite "tail", frame 1
		{
			45.85000000000002, // x
			6.100000000000023, // y
			0.5775397718973088, // rotation
			0.4874084866405413, // scaleX
			0.5021808698921247, // scaleY
		},
	    
		// 40. sprite "tail", frame 2
		{
			48.94999999999999, // x
			11.649999999999977, // y
			0.420488635041483, // rotation
			0.7312152442691479, // scaleX
			0.5708502228815115, // scaleY
		},
	    
		// 41. sprite "tail", frame 3
		{
			52.19999999999999, // x
			17.850000000000023, // y
			0.2670407551405344, // rotation
			0.9759559712624439, // scaleX
			0.6403458964458488, // scaleY
		},
	    
		// 42. sprite "tail", frame 4
		{
			55.44999999999999, // x
			24.69999999999999, // y
			0.11436678985236282, // rotation
			1.2214546767942032, // scaleX
			0.7102465974571845, // scaleY
		},
	    
		// 43. sprite "tail", frame 5
		{
			53.85000000000002, // x
			20.94999999999999, // y
			0.048317465341198615, // rotation
			1.1841910972467247, // scaleX
			0.7158168260559228, // scaleY
		},
	    
		// 44. sprite "tail", frame 6
		{
			52.19999999999999, // x
			17.100000000000023, // y
			-0.013808223935951842, // rotation
			1.1472729486311886, // scaleX
			0.7215775168362306, // scaleY
		},
	    
		// 45. sprite "tail", frame 7
		{
			50.55000000000001, // x
			13.300000000000011, // y
			-0.07916459393147741, // rotation
			1.1099736017769062, // scaleX
			0.7270916025901607, // scaleY
		},
	    
		// 46. sprite "tail", frame 8
		{
			48.85000000000002, // x
			9.5, // y
			-0.1445984619147243, // rotation
			1.0726959485461258, // scaleX
			0.7326047147350206, // scaleY
		},
	    
		// 47. sprite "tail", frame 9
		{
			47.10000000000002, // x
			5.550000000000011, // y
			-0.2100363246396063, // rotation
			1.0354320374106563, // scaleX
			0.738148936736873, // scaleY
		},
	    
		// 48. sprite "tail", frame 10
		{
			45.19999999999999, // x
			1.6499999999999773, // y
			-0.2764283979830637, // rotation
			0.9990842586010321, // scaleX
			0.7443012712697598, // scaleY
		},
	    
		// 49. sprite "tail", frame 11
		{
			45.44999999999999, // x
			4.25, // y
			-0.11367410165283319, // rotation
			0.9988320776170909, // scaleX
			0.8290258033104383, // scaleY
		},
	    
		// 50. sprite "tail", frame 12
		{
			45.60000000000002, // x
			6.850000000000023, // y
			0.04807378610145636, // rotation
			0.9990833861137333, // scaleX
			0.9141598065912675, // scaleY
		},
	    
		// 51. sprite "tail", frame 13
		{
			45.30000000000001, // x
			9.449999999999989, // y
			0.2105034430948062, // rotation
			0.9993208311301324, // scaleX
			0.9993208311301324, // scaleY
		},
	    
		// 52. sprite "shell", frame 1
		{
			0, // x
			10.949999999999989, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.1193626302342168, // scaleY
		},
	    
		// 53. sprite "shell", frame 2
		{
			0, // x
			18.399999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.2010085346596353, // scaleY
		},
	    
		// 54. sprite "shell", frame 3
		{
			0, // x
			24.44999999999999, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.2686388726066962, // scaleY
		},
	    
		// 55. sprite "shell", frame 4
		{
			0, // x
			28.69999999999999, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.3140953292596387, // scaleY
		},
	    
		// 56. sprite "shell", frame 5
		{
			0, // x
			26.099999999999994, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.2700613480104697, // scaleY
		},
	    
		// 57. sprite "shell", frame 6
		{
			0, // x
			21.69999999999999, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.1958834394548628, // scaleY
		},
	    
		// 58. sprite "shell", frame 7
		{
			0, // x
			16.19999999999999, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.102606706728001, // scaleY
		},
	    
		// 59. sprite "shell", frame 8
		{
			0, // x
			10.5, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0061084855867106, // scaleY
		},
	    
		// 60. sprite "shell", frame 9
		{
			0, // x
			5.5, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.9225798931268858, // scaleY
		},
	    
		// 61. sprite "shell", frame 10
		{
			0, // x
			2, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.8638609452093481, // scaleY
		},
	    
		// 62. sprite "shell", frame 11
		{
			0, // x
			4.100000000000023, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.8978957611202258, // scaleY
		},
	    
		// 63. sprite "shell", frame 12
		{
			0, // x
			7.199999999999989, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.9488538505848222, // scaleY
		},
	    
		// 64. sprite "shell", frame 13
		{
			0, // x
			10.350000000000023, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 65. sprite "leg_f", frame 1
		{
			-26.55000000000001, // x
			3.3999999999999773, // y
			0.12626259780952875, // rotation
			0.4335620068820316, // scaleX
			0.34969745589288165, // scaleY
		},
	    
		// 66. sprite "leg_f", frame 2
		{
			-28.25, // x
			5.649999999999977, // y
			0.35842286688885927, // rotation
			0.621071851648905, // scaleX
			0.5897353478362002, // scaleY
		},
	    
		// 67. sprite "leg_f", frame 3
		{
			-30.55000000000001, // x
			8.399999999999977, // y
			0.5905690212144125, // rotation
			0.8087472283236802, // scaleX
			0.8298079258419703, // scaleY
		},
	    
		// 68. sprite "leg_f", frame 4
		{
			-33.39999999999998, // x
			11.850000000000023, // y
			0.8235801702620233, // rotation
			0.9981382451393249, // scaleX
			1.0717520710783124, // scaleY
		},
	    
		// 69. sprite "leg_f", frame 5
		{
			-32.39999999999998, // x
			7.75, // y
			0.6866646617760687, // rotation
			0.9968369332437683, // scaleX
			1.0235625903912877, // scaleY
		},
	    
		// 70. sprite "leg_f", frame 6
		{
			-31.350000000000023, // x
			3.8500000000000227, // y
			0.5472068997135242, // rotation
			0.9973152490302042, // scaleX
			0.9772602590906739, // scaleY
		},
	    
		// 71. sprite "leg_f", frame 7
		{
			-30.399999999999977, // x
			-0.05000000000001137, // y
			0.4111031227278258, // rotation
			0.9978785879181906, // scaleX
			0.9310290910745823, // scaleY
		},
	    
		// 72. sprite "leg_f", frame 8
		{
			-29.399999999999977, // x
			-3.6499999999999773, // y
			0.2717620071210269, // rotation
			0.9985119184445346, // scaleX
			0.8848544829350502, // scaleY
		},
	    
		// 73. sprite "leg_f", frame 9
		{
			-28.5, // x
			-7.149999999999977, // y
			0.135816421904079, // rotation
			0.9992455536078814, // scaleX
			0.8387192022385067, // scaleY
		},
	    
		// 74. sprite "leg_f", frame 10
		{
			-27.69999999999999, // x
			-10.449999999999989, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.7925907437291018, // scaleY
		},
	    
		// 75. sprite "leg_f", frame 11
		{
			-27.69999999999999, // x
			-9.149999999999977, // y
			0, // rotation
			0.999623671245978, // scaleX
			0.861392532008682, // scaleY
		},
	    
		// 76. sprite "leg_f", frame 12
		{
			-27.69999999999999, // x
			-7.899999999999977, // y
			0, // rotation
			0.9992680523950346, // scaleX
			0.9302152390442001, // scaleY
		},
	    
		// 77. sprite "leg_f", frame 13
		{
			-27.69999999999999, // x
			-6.600000000000023, // y
			0, // rotation
			0.9988915147881533, // scaleX
			0.9990170273237804, // scaleY
		},
	    
		// 78. sprite "leg_b", frame 1
		{
			28.55000000000001, // x
			4.649999999999977, // y
			-0.18875074331103897, // rotation
			0.44883495524905304, // scaleX
			0.32694919921097343, // scaleY
		},
	    
		// 79. sprite "leg_b", frame 2
		{
			30.69999999999999, // x
			6.5, // y
			-0.43700955486378956, // rotation
			0.614963960289653, // scaleX
			0.5727105329802923, // scaleY
		},
	    
		// 80. sprite "leg_b", frame 3
		{
			33.69999999999999, // x
			9.050000000000011, // y
			-0.6829391657271567, // rotation
			0.7813918140049624, // scaleX
			0.8186235268431764, // scaleY
		},
	    
		// 81. sprite "leg_b", frame 4
		{
			37.30000000000001, // x
			12.800000000000011, // y
			-0.9324131776853104, // rotation
			0.9495817167386916, // scaleX
			1.066381052344077, // scaleY
		},
	    
		// 82. sprite "leg_b", frame 5
		{
			36, // x
			8.350000000000023, // y
			-0.7783628907457859, // rotation
			0.956446299600772, // scaleX
			1.018883935567269, // scaleY
		},
	    
		// 83. sprite "leg_b", frame 6
		{
			34.75, // x
			4.100000000000023, // y
			-0.621204162181921, // rotation
			0.9648579909919176, // scaleX
			0.9732524274947473, // scaleY
		},
	    
		// 84. sprite "leg_b", frame 7
		{
			33.39999999999998, // x
			0.10000000000002274, // y
			-0.46409922947207555, // rotation
			0.9735065774311942, // scaleX
			0.9276756795350185, // scaleY
		},
	    
		// 85. sprite "leg_b", frame 8
		{
			31.94999999999999, // x
			-3.5500000000000114, // y
			-0.31035999974787226, // rotation
			0.9822460922368007, // scaleX
			0.882219588920935, // scaleY
		},
	    
		// 86. sprite "leg_b", frame 9
		{
			30.75, // x
			-7.050000000000011, // y
			-0.153462260970835, // rotation
			0.9910839004000179, // scaleX
			0.8368540981825091, // scaleY
		},
	    
		// 87. sprite "leg_b", frame 10
		{
			29.600000000000023, // x
			-10.399999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.7914402121525203, // scaleY
		},
	    
		// 88. sprite "leg_b", frame 11
		{
			29.600000000000023, // x
			-9.149999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.8609532381339873, // scaleY
		},
	    
		// 89. sprite "leg_b", frame 12
		{
			29.600000000000023, // x
			-7.899999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			0.9304871828713922, // scaleY
		},
	    
		// 90. sprite "leg_b", frame 13
		{
			29.600000000000023, // x
			-6.649999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 91. sprite "shadow", frame 1
		{
			-9, // x
			-21.899999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 92. sprite "shadow", frame 2
		{
			-25.55000000000001, // x
			-21.899999999999977, // y
			0, // rotation
			1.18172144168494, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 93. sprite "shadow", frame 3
		{
			-41.85000000000002, // x
			-21.899999999999977, // y
			0, // rotation
			1.3616645802623037, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 94. sprite "shadow", frame 4
		{
			-51.60000000000002, // x
			-21.899999999999977, // y
			0, // rotation
			1.468705854396269, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 95. sprite "shadow", frame 5
		{
			-38.94999999999999, // x
			-21.899999999999977, // y
			0, // rotation
			1.2188103959627434, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 96. sprite "shadow", frame 6
		{
			-26.350000000000023, // x
			-21.899999999999977, // y
			0, // rotation
			0.9689149375292179, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 97. sprite "shadow", frame 7
		{
			-19.149999999999977, // x
			-21.899999999999977, // y
			0, // rotation
			0.9175175541899268, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 98. sprite "shadow", frame 8
		{
			-12, // x
			-21.899999999999977, // y
			0, // rotation
			0.8661201708506355, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 99. sprite "shadow", frame 9
		{
			-4.800000000000011, // x
			-21.899999999999977, // y
			0, // rotation
			0.8147227875113444, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 100. sprite "shadow", frame 10
		{
			2.3500000000000227, // x
			-21.899999999999977, // y
			0, // rotation
			0.7633254041720532, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 101. sprite "shadow", frame 11
		{
			1.6999999999999886, // x
			-21.850000000000023, // y
			0, // rotation
			0.7220945362185559, // scaleX
			0.9775334649756111, // scaleY
		},
	    
		// 102. sprite "shadow", frame 12
		{
			1, // x
			-21.899999999999977, // y
			0, // rotation
			0.6808636682650586, // scaleX
			0.9550876398543008, // scaleY
		},
	    
		// 103. sprite "shadow", frame 13
		{
			0.35000000000002274, // x
			-21.899999999999977, // y
			0, // rotation
			0.6396328003115613, // scaleX
			0.9326208959770526, // scaleY
		},
	    
		// 104. sprite "neck", frame 1
		{
			-48.44999999999999, // x
			34.80000000000001, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 105. sprite "neck", frame 2
		{
			-54.35000000000002, // x
			37.75, // y
			-0.5685225747624095, // rotation
			0.9972375949295047, // scaleX
			0.9972375949295047, // scaleY
		},
	    
		// 106. sprite "neck", frame 3
		{
			-55.55000000000001, // x
			37.150000000000006, // y
			-1.098797628897428, // rotation
			0.9961900181380687, // scaleX
			0.9961900181380687, // scaleY
		},
	    
		// 107. sprite "neck", frame 4
		{
			-54.64999999999998, // x
			36.650000000000006, // y
			-1.3133773063567094, // rotation
			0.9970385620535005, // scaleX
			0.9970385620535005, // scaleY
		},
	    
		// 108. sprite "neck", frame 5
		{
			-53.14999999999998, // x
			34, // y
			-1.316419168953798, // rotation
			0.751962855545921, // scaleX
			0.751962855545921, // scaleY
		},
	    
		// 109. sprite "neck", frame 6
		{
			-51.60000000000002, // x
			31.400000000000006, // y
			-1.313391421110487, // rotation
			0.5081445000530552, // scaleX
			0.5081445000530552, // scaleY
		},
	    
		// 110. sprite "neck", frame 7
		{
			-40.60000000000002, // x
			20.69999999999999, // y
			-1.3164047878839116, // rotation
			0.4076468278987822, // scaleX
			0.4076468278987822, // scaleY
		},
	    
		// 111. sprite "neck", frame 8
		{
			-29.649999999999977, // x
			10.100000000000023, // y
			-1.3131203113115169, // rotation
			0.3075779467970311, // scaleX
			0.3075779467970311, // scaleY
		},
	    
		// 112. sprite "neck", frame 9
		{
			-18.649999999999977, // x
			-0.6000000000000227, // y
			-1.3133344294631593, // rotation
			0.20768646685406775, // scaleX
			0.20768646685406775, // scaleY
		},
	    
		// 113. sprite "head", frame 1
		{
			-67.25, // x
			59.400000000000006, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 114. sprite "head", frame 2
		{
			-93.10000000000002, // x
			51.05000000000001, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 115. sprite "head", frame 3
		{
			-103, // x
			40.099999999999994, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 116. sprite "head", frame 4
		{
			-106, // x
			31.400000000000006, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 117. sprite "head", frame 5
		{
			-91.85000000000002, // x
			30.099999999999994, // y
			0, // rotation
			0.7548323892612872, // scaleX
			0.7548323892612872, // scaleY
		},
	    
		// 118. sprite "head", frame 6
		{
			-77.80000000000001, // x
			28.75, // y
			0, // rotation
			0.5096645696697151, // scaleX
			0.5096645696697151, // scaleY
		},
	    
		// 119. sprite "head", frame 7
		{
			-61.64999999999998, // x
			18.600000000000023, // y
			0, // rotation
			0.4092127036561717, // scaleX
			0.4092127036561717, // scaleY
		},
	    
		// 120. sprite "head", frame 8
		{
			-45.44999999999999, // x
			8.5, // y
			0, // rotation
			0.3087608376426283, // scaleX
			0.3087608376426283, // scaleY
		},
	    
		// 121. sprite "head", frame 9
		{
			-29.350000000000023, // x
			-1.6499999999999773, // y
			0, // rotation
			0.20830897162908485, // scaleX
			0.20830897162908485, // scaleY
		},
	    
		// 122. sprite "tail", frame 1
		{
			45.30000000000001, // x
			9.449999999999989, // y
			0.2105034430948062, // rotation
			0.9993208311301324, // scaleX
			0.9993208311301324, // scaleY
		},
	    
		// 123. sprite "tail", frame 2
		{
			44.80000000000001, // x
			13.449999999999989, // y
			0.3807377599787422, // rotation
			0.9963316271826465, // scaleX
			0.9963316271826465, // scaleY
		},
	    
		// 124. sprite "tail", frame 3
		{
			44.10000000000002, // x
			17.44999999999999, // y
			0.5514248142479917, // rotation
			0.994191803908775, // scaleX
			0.994191803908775, // scaleY
		},
	    
		// 125. sprite "tail", frame 4
		{
			43.5, // x
			20.350000000000023, // y
			0.6740239676620075, // rotation
			0.9943259105831554, // scaleX
			0.9943259105831554, // scaleY
		},
	    
		// 126. sprite "tail", frame 5
		{
			40.19999999999999, // x
			22.399999999999977, // y
			0.6698840837474793, // rotation
			0.7814662302812118, // scaleX
			0.7814662302812118, // scaleY
		},
	    
		// 127. sprite "tail", frame 6
		{
			36.94999999999999, // x
			24.25, // y
			0.6694151010795164, // rotation
			0.5711316361548427, // scaleX
			0.5711316361548427, // scaleY
		},
	    
		// 128. sprite "tail", frame 7
		{
			37.14999999999998, // x
			17.850000000000023, // y
			0.035492214163595014, // rotation
			0.40624697178057556, // scaleX
			0.40624697178057556, // scaleY
		},
	    
		// 129. sprite "tail", frame 8
		{
			35.89999999999998, // x
			9.850000000000023, // y
			-0.5952391405019755, // rotation
			0.24142000539408245, // scaleX
			0.24142000539408245, // scaleY
		},
	    
		// 130. sprite "shell", frame 1
		{
			0, // x
			10.350000000000023, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 131. sprite "shell", frame 2
		{
			0, // x
			17.25, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0486781539202301, // scaleY
		},
	    
		// 132. sprite "shell", frame 3
		{
			0.05000000000001137, // x
			24, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0962055674110196, // scaleY
		},
	    
		// 133. sprite "shell", frame 4
		{
			0, // x
			27.75, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.1224586061130182, // scaleY
		},
	    
		// 134. sprite "shell", frame 5
		{
			0, // x
			27.099999999999994, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0937371542103536, // scaleY
		},
	    
		// 135. sprite "shell", frame 6
		{
			0, // x
			26.400000000000006, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0649947835517513, // scaleY
		},
	    
		// 136. sprite "shell", frame 7
		{
			-0.05000000000001137, // x
			20.44999999999999, // y
			0, // rotation
			1.009497324048642, // scaleX
			1.0125723811715055, // scaleY
		},
	    
		// 137. sprite "shell", frame 8
		{
			-0.05000000000001137, // x
			10.5, // y
			0, // rotation
			1.0253328222935925, // scaleX
			0.9250692250834897, // scaleY
		},
	    
		// 138. sprite "shell", frame 9
		{
			-0.05000000000001137, // x
			0.5500000000000114, // y
			0, // rotation
			1.0412519955622943, // scaleX
			0.8370640188529654, // scaleY
		},
	    
		// 139. sprite "shell", frame 10
		{
			-0.05000000000001137, // x
			-5.850000000000023, // y
			0, // rotation
			1.0515231047277775, // scaleX
			0.7803532715054611, // scaleY
		},
	    
		// 140. sprite "shell", frame 11
		{
			-0.05000000000001137, // x
			-3.6000000000000227, // y
			0, // rotation
			1.032110499217455, // scaleX
			0.8631287887515234, // scaleY
		},
	    
		// 141. sprite "shell", frame 12
		{
			-0.05000000000001137, // x
			-1.4499999999999886, // y
			0, // rotation
			1.0128443249986976, // scaleX
			0.9452139870516367, // scaleY
		},
	    
		// 142. sprite "shell", frame 13
		{
			0, // x
			0, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 143. sprite "leg_f", frame 1
		{
			-27.69999999999999, // x
			-6.600000000000023, // y
			0, // rotation
			0.9988915147881533, // scaleX
			0.9990170273237804, // scaleY
		},
	    
		// 144. sprite "leg_f", frame 2
		{
			-30.5, // x
			1, // y
			0.4379360686070281, // rotation
			0.9964284495073502, // scaleX
			0.996568730422254, // scaleY
		},
	    
		// 145. sprite "leg_f", frame 3
		{
			-32.64999999999998, // x
			9.649999999999977, // y
			0.8751994227227022, // rotation
			0.9949406627739332, // scaleX
			0.9950585203944577, // scaleY
		},
	    
		// 146. sprite "leg_f", frame 4
		{
			-33.5, // x
			16.100000000000023, // y
			1.1680059950936441, // rotation
			0.9957437609726586, // scaleX
			0.9958645840544007, // scaleY
		},
	    
		// 147. sprite "leg_f", frame 5
		{
			-31.850000000000023, // x
			16.55000000000001, // y
			1.1684837661932044, // rotation
			0.8313558087166432, // scaleX
			0.8314602424371017, // scaleY
		},
	    
		// 148. sprite "leg_f", frame 6
		{
			-30.350000000000023, // x
			17, // y
			1.1679929456043028, // rotation
			0.6689244294315898, // scaleX
			0.6689985634239736, // scaleY
		},
	    
		// 149. sprite "leg_f", frame 7
		{
			-28.19999999999999, // x
			12, // y
			1.3472404648815028, // rotation
			0.40611876480265713, // scaleX
			0.40615492474571996, // scaleY
		},
	    
		// 150. sprite "leg_f", frame 8
		{
			-25.94999999999999, // x
			6.399999999999977, // y
			1.5217787164031162, // rotation
			0.14388465494848948, // scaleX
			0.1439045253375012, // scaleY
		},
	    
		// 151. sprite "leg_b", frame 1
		{
			29.600000000000023, // x
			-6.649999999999977, // y
			0, // rotation
			1.0000002088528592, // scaleX
			1.0000002088528592, // scaleY
		},
	    
		// 152. sprite "leg_b", frame 2
		{
			33.64999999999998, // x
			0.6000000000000227, // y
			-0.47700916917234365, // rotation
			0.9972733489013131, // scaleX
			0.9972733489013131, // scaleY
		},
	    
		// 153. sprite "leg_b", frame 3
		{
			36.64999999999998, // x
			9.600000000000023, // y
			-0.9499857798220893, // rotation
			0.995704531592714, // scaleX
			0.995704531592714, // scaleY
		},
	    
		// 154. sprite "leg_b", frame 4
		{
			37.75, // x
			16.55000000000001, // y
			-1.2689405993559744, // rotation
			0.9963505240405258, // scaleX
			0.9963505240405258, // scaleY
		},
	    
		// 155. sprite "leg_b", frame 5
		{
			34.94999999999999, // x
			17.649999999999977, // y
			-1.26920478493611, // rotation
			0.8324866025424916, // scaleX
			0.8324866025424916, // scaleY
		},
	    
		// 156. sprite "leg_b", frame 6
		{
			32, // x
			18.75, // y
			-1.2689264846021968, // rotation
			0.6701882801762542, // scaleX
			0.6701882801762542, // scaleY
		},
	    
		// 157. sprite "leg_b", frame 7
		{
			30.149999999999977, // x
			12.649999999999977, // y
			-1.4004509560935041, // rotation
			0.39325408363098086, // scaleX
			0.39325408363098086, // scaleY
		},
	    
		// 158. sprite "leg_b", frame 8
		{
			28.25, // x
			5.949999999999989, // y
			-1.5317232262295812, // rotation
			0.11675299667392991, // scaleX
			0.11675299667392991, // scaleY
		},
	    
	    // 159. sprite "shadow", frame 2
	    {
	        340.95, // x
	        -301.9, // y
	        0, // rotation
	        1.0008997153581867, // scaleX
	        1.0041630412844909, // scaleY
	    },
	    
	    // 160. sprite "shadow", frame 3
	    {
	        340.85, // x
	        -301.9, // y
	        0, // rotation
	        1.0022803532500846, // scaleX
	        1.0105641806014722, // scaleY
	    },
	    
	    // 161. sprite "shadow", frame 4
	    {
	        340.7, // x
	        -301.9, // y
	        0, // rotation
	        1.0040793662607395, // scaleX
	        1.0189944392444248, // scaleY
	    },
	    
	    // 162. sprite "shadow", frame 5
	    {
	        340.5, // x
	        -301.9, // y
	        0, // rotation
	        1.0063176731460892, // scaleX
	        1.02924462965397, // scaleY
	    },
	    
	    // 163. sprite "shadow", frame 6
	    {
	        340.3, // x
	        -301.9, // y
	        0, // rotation
	        1.0088697613705064, // scaleX
	        1.041021889246978, // scaleY
	    },
	    
	    // 164. sprite "shadow", frame 7
	    {
	        340.1, // x
	        -301.9, // y
	        0, // rotation
	        1.011672874666178, // scaleX
	        1.0539705991725057, // scaleY
	    },
	    
	    // 165. sprite "shadow", frame 8
	    {
	        339.9, // x
	        -301.9, // y
	        0, // rotation
	        1.0146433380093525, // scaleX
	        1.067756059335547, // scaleY
	    },
	    
	    // 166. sprite "shadow", frame 9
	    {
	        339.65, // x
	        -301.9, // y
	        0, // rotation
	        1.017718395132216, // scaleX
	        1.0819808133732833, // scaleY
	    },
	    
	    // 167. sprite "shadow", frame 10
	    {
	        339.45, // x
	        -301.9, // y
	        0, // rotation
	        1.0207725334991418, // scaleX
	        1.0962264861669575, // scaleY
	    },
	    
	    // 168. sprite "shadow", frame 11
	    {
	        339.2, // x
	        -301.9, // y
	        0, // rotation
	        1.0237639155982539, // scaleX
	        1.1101165401096882, // scaleY
	    },
	    
	    // 169. sprite "shadow", frame 12
	    {
	        339, // x
	        -301.85, // y
	        0, // rotation
	        1.026629785161739, // scaleX
	        1.1232953563505321, // scaleY
	    },
	    
	    // 170. sprite "shadow", frame 13
	    {
	        338.8, // x
	        -301.9, // y
	        0, // rotation
	        1.0292655484099078, // scaleX
	        1.1354282347944835, // scaleY
	    },
	    
	    // 171. sprite "shadow", frame 14
	    {
	        338.6, // x
	        -301.9, // y
	        0, // rotation
	        1.0316084490749466, // scaleX
	        1.1462432316143507, // scaleY
	    },
	    
	    // 172. sprite "shadow", frame 15
	    {
	        338.45, // x
	        -301.9, // y
	        0, // rotation
	        1.0335748121331043, // scaleX
	        1.1555102404948172, // scaleY
	    },
	    
	    // 173. sprite "shadow", frame 16
	    {
	        338.35, // x
	        -301.9, // y
	        0, // rotation
	        1.0352273938521943, // scaleX
	        1.16306191138838, // scaleY
	    },
	    
	    // 174. sprite "shadow", frame 17
	    {
	        338.25, // x
	        -301.9, // y
	        0, // rotation
	        1.0364616004525273, // scaleX
	        1.1687518130034746, // scaleY
	    },
	    
	    // 175. sprite "shadow", frame 18
	    {
	        338.3, // x
	        -301.9, // y
	        0, // rotation
	        1.0355620939472, // scaleX
	        1.1645889805718428, // scaleY
	    },
	    
	    // 176. sprite "shadow", frame 19
	    {
	        338.4, // x
	        -301.85, // y
	        0, // rotation
	        1.034181456055302, // scaleX
	        1.1581878412548616, // scaleY
	    },
	    
	    // 177. sprite "shadow", frame 20
	    {
	        338.55, // x
	        -301.9, // y
	        0, // rotation
	        1.0323615242887092, // scaleX
	        1.149757582611909, // scaleY
	    },
	    
	    // 178. sprite "shadow", frame 21
	    {
	        338.75, // x
	        -301.9, // y
	        0, // rotation
	        1.0301441361592973, // scaleX
	        1.1395073922023637, // scaleY
	    },
	    
	    // 179. sprite "shadow", frame 22
	    {
	        338.9, // x
	        -301.9, // y
	        0, // rotation
	        1.02759204793488, // scaleX
	        1.1277301326093556, // scaleY
	    },
	    
	    // 180. sprite "shadow", frame 23
	    {
	        339.15, // x
	        -301.85, // y
	        0, // rotation
	        1.0247889346392085, // scaleX
	        1.1147814226838282, // scaleY
	    },
	    
	    // 181. sprite "shadow", frame 24
	    {
	        339.35, // x
	        -301.9, // y
	        0, // rotation
	        1.021818471296034, // scaleX
	        1.1009959625207866, // scaleY
	    },
	    
	    // 182. sprite "shadow", frame 25
	    {
	        339.6, // x
	        -301.85, // y
	        0, // rotation
	        1.0187434141731706, // scaleX
	        1.0867712084830503, // scaleY
	    },
	    
	    // 183. sprite "shadow", frame 26
	    {
	        339.8, // x
	        -301.9, // y
	        0, // rotation
	        1.015668357050307, // scaleX
	        1.0725255356893764, // scaleY
	    },
	    
	    // 184. sprite "shadow", frame 27
	    {
	        340.05, // x
	        -301.85, // y
	        0, // rotation
	        1.0126769749511948, // scaleX
	        1.0586354817466457, // scaleY
	    },
	    
	    // 185. sprite "shadow", frame 28
	    {
	        340.25, // x
	        -301.9, // y
	        0, // rotation
	        1.0098320241436476, // scaleX
	        1.0454566655058017, // scaleY
	    },
	    
	    // 186. sprite "shadow", frame 29
	    {
	        340.45, // x
	        -301.85, // y
	        0, // rotation
	        1.0071962608954788, // scaleX
	        1.0333237870618501, // scaleY
	    },
	    
	    // 187. sprite "shadow", frame 30
	    {
	        340.65, // x
	        -301.9, // y
	        0, // rotation
	        1.00485336023044, // scaleX
	        1.0225087902419832, // scaleY
	    },
	    
	    // 188. sprite "shadow", frame 31
	    {
	        340.8, // x
	        -301.9, // y
	        0, // rotation
	        1.0028660784163443, // scaleX
	        1.0132417813615167, // scaleY
	    },
	    
	    // 189. sprite "shadow", frame 32
	    {
	        340.9, // x
	        -301.9, // y
	        0, // rotation
	        1.0012344154531923, // scaleX
	        1.0056901104679536, // scaleY
	    },
	    
	    // 190. sprite "shadow", frame 33
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 191. sprite "shadow", frame 34
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 192. sprite "shadow", frame 35
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 193. sprite "shadow", frame 36
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 194. sprite "shadow", frame 37
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 195. sprite "shadow", frame 38
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 196. sprite "shadow", frame 39
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 197. sprite "shadow", frame 40
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 198. sprite "shadow", frame 41
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 199. sprite "shadow", frame 42
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 200. sprite "shadow", frame 43
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 201. sprite "shadow", frame 44
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 202. sprite "shadow", frame 45
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 203. sprite "shadow", frame 46
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 204. sprite "shadow", frame 47
	    {
	        341, // x
	        -301.9, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 205. sprite "neck", frame 2
	    {
	        301.55, // x
	        -245.15, // y
	        0.0005187837803474355, // rotation
	        0.9999794268479784, // scaleX
	        0.9999794268479784, // scaleY
	    },
	    
	    // 206. sprite "neck", frame 3
	    {
	        301.65, // x
	        -245.1, // y
	        0.004501274874451928, // rotation
	        0.999947567065943, // scaleX
	        0.999947567065943, // scaleY
	    },
	    
	    // 207. sprite "neck", frame 4
	    {
	        301.65, // x
	        -245.05, // y
	        0.005371063286471808, // rotation
	        0.9999519047191683, // scaleX
	        0.9999519047191683, // scaleY
	    },
	    
	    // 208. sprite "neck", frame 5
	    {
	        301.7, // x
	        -244.9, // y
	        0.009734919048675647, // rotation
	        0.999901092779639, // scaleX
	        0.999901092779639, // scaleY
	    },
	    
	    // 209. sprite "neck", frame 6
	    {
	        301.8, // x
	        -244.8, // y
	        0.017484717820806232, // rotation
	        0.9998812113606592, // scaleX
	        0.9998812113606592, // scaleY
	    },
	    
	    // 210. sprite "neck", frame 7
	    {
	        301.95, // x
	        -244.7, // y
	        0.02207600754010284, // rotation
	        0.9998672599733833, // scaleX
	        0.9998672599733833, // scaleY
	    },
	    
	    // 211. sprite "neck", frame 8
	    {
	        302.1, // x
	        -244.6, // y
	        0.02678793845678003, // rotation
	        0.9998149291576959, // scaleX
	        0.9998149291576959, // scaleY
	    },
	    
	    // 212. sprite "neck", frame 9
	    {
	        302.15, // x
	        -244.5, // y
	        0.031514250443343654, // rotation
	        0.9997854407837397, // scaleX
	        0.9997854407837397, // scaleY
	    },
	    
	    // 213. sprite "neck", frame 10
	    {
	        302.3, // x
	        -244.35, // y
	        0.039530099008373155, // rotation
	        0.9997355214102872, // scaleX
	        0.9997355214102872, // scaleY
	    },
	    
	    // 214. sprite "neck", frame 11
	    {
	        302.35, // x
	        -244.35, // y
	        0.044252149937192654, // rotation
	        0.9997027381360049, // scaleX
	        0.9997027381360049, // scaleY
	    },
	    
	    // 215. sprite "neck", frame 12
	    {
	        302.4, // x
	        -244.2, // y
	        0.04888072391175037, // rotation
	        0.999688075134216, // scaleX
	        0.999688075134216, // scaleY
	    },
	    
	    // 216. sprite "neck", frame 13
	    {
	        302.5, // x
	        -244.05, // y
	        0.053370280877405946, // rotation
	        0.9996452450944724, // scaleX
	        0.9996452450944724, // scaleY
	    },
	    
	    // 217. sprite "neck", frame 14
	    {
	        302.6, // x
	        -244, // y
	        0.057720820834159386, // rotation
	        0.9996152857165324, // scaleX
	        0.9996152857165324, // scaleY
	    },
	    
	    // 218. sprite "neck", frame 15
	    {
	        302.65, // x
	        -243.95, // y
	        0.0619627038184376, // rotation
	        0.9995965591445038, // scaleX
	        0.9995965591445038, // scaleY
	    },
	    
	    // 219. sprite "neck", frame 16
	    {
	        302.75, // x
	        -243.9, // y
	        0.06598993601885543, // rotation
	        0.9995610798047966, // scaleX
	        0.9995610798047966, // scaleY
	    },
	    
	    // 220. sprite "neck", frame 17
	    {
	        302.85, // x
	        -243.8, // y
	        0.06998441133786527, // rotation
	        0.999769903605157, // scaleX
	        0.999769903605157, // scaleY
	    },
	    
	    // 221. sprite "neck", frame 18
	    {
	        302.8, // x
	        -243.9, // y
	        0.06608101612813613, // rotation
	        0.999566601152927, // scaleX
	        0.999566601152927, // scaleY
	    },
	    
	    // 222. sprite "neck", frame 19
	    {
	        302.7, // x
	        -243.85, // y
	        0.06208441028025422, // rotation
	        0.9995834607325361, // scaleX
	        0.9995834607325361, // scaleY
	    },
	    
	    // 223. sprite "neck", frame 20
	    {
	        302.75, // x
	        -243.95, // y
	        0.061202637643328985, // rotation
	        0.9995919677920818, // scaleX
	        0.9995919677920818, // scaleY
	    },
	    
	    // 224. sprite "neck", frame 21
	    {
	        302.65, // x
	        -244.1, // y
	        0.05683878188112515, // rotation
	        0.9996276351466907, // scaleX
	        0.9996276351466907, // scaleY
	    },
	    
	    // 225. sprite "neck", frame 22
	    {
	        302.55, // x
	        -244.1, // y
	        0.05238118284855053, // rotation
	        0.9996768437719711, // scaleX
	        0.9996768437719711, // scaleY
	    },
	    
	    // 226. sprite "neck", frame 23
	    {
	        302.4, // x
	        -244.25, // y
	        0.044495829176934905, // rotation
	        0.9996929757383736, // scaleX
	        0.9996929757383736, // scaleY
	    },
	    
	    // 227. sprite "neck", frame 24
	    {
	        302.3, // x
	        -244.35, // y
	        0.039804404600651315, // rotation
	        0.9997254050029263, // scaleX
	        0.9997254050029263, // scaleY
	    },
	    
	    // 228. sprite "neck", frame 25
	    {
	        302.2, // x
	        -244.55, // y
	        0.035080755775177774, // rotation
	        0.9997992858617616, // scaleX
	        0.9997992858617616, // scaleY
	    },
	    
	    // 229. sprite "neck", frame 26
	    {
	        302.1, // x
	        -244.65, // y
	        0.027062510365167203, // rotation
	        0.9998222490323073, // scaleX
	        0.9998222490323073, // scaleY
	    },
	    
	    // 230. sprite "neck", frame 27
	    {
	        301.95, // x
	        -244.75, // y
	        0.02236575946670346, // rotation
	        0.9998319399220132, // scaleX
	        0.9998319399220132, // scaleY
	    },
	    
	    // 231. sprite "neck", frame 28
	    {
	        301.85, // x
	        -244.85, // y
	        0.017744109710979946, // rotation
	        0.9998647178659309, // scaleX
	        0.9998647178659309, // scaleY
	    },
	    
	    // 232. sprite "neck", frame 29
	    {
	        301.8, // x
	        -244.95, // y
	        0.013228720082750601, // rotation
	        0.9999202624372311, // scaleX
	        0.9999202624372311, // scaleY
	    },
	    
	    // 233. sprite "neck", frame 30
	    {
	        301.75, // x
	        -245, // y
	        0.008834504284119858, // rotation
	        0.9999345826576737, // scaleX
	        0.9999345826576737, // scaleY
	    },
	    
	    // 234. sprite "neck", frame 31
	    {
	        301.65, // x
	        -245.05, // y
	        0.004623247652377558, // rotation
	        0.9999481394692017, // scaleX
	        0.9999481394692017, // scaleY
	    },
	    
	    // 235. sprite "neck", frame 32
	    {
	        301.6, // x
	        -245.15, // y
	        0.0006103965218461614, // rotation
	        1.000000392861228, // scaleX
	        1.000000392861228, // scaleY
	    },
	    
	    // 236. sprite "neck", frame 33
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 237. sprite "neck", frame 34
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 238. sprite "neck", frame 35
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 239. sprite "neck", frame 36
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 240. sprite "neck", frame 37
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 241. sprite "neck", frame 38
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 242. sprite "neck", frame 39
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 243. sprite "neck", frame 40
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 244. sprite "neck", frame 41
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 245. sprite "neck", frame 42
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 246. sprite "neck", frame 43
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 247. sprite "neck", frame 44
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 248. sprite "neck", frame 45
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 249. sprite "neck", frame 46
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 250. sprite "neck", frame 47
	    {
	        301.55, // x
	        -245.2, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 251. sprite "head", frame 2
	    {
	        282.9, // x
	        -220.5, // y
	        0, // rotation
	        0.9997073462697293, // scaleX
	        1.0004185839716162, // scaleY
	    },
	    
	    // 252. sprite "head", frame 3
	    {
	        283.1, // x
	        -220.35, // y
	        0, // rotation
	        0.9993308086628481, // scaleX
	        1.0009624716260002, // scaleY
	    },
	    
	    // 253. sprite "head", frame 4
	    {
	        283.4, // x
	        -220.2, // y
	        0, // rotation
	        0.9988287585203398, // scaleX
	        1.001673709327887, // scaleY
	    },
	    
	    // 254. sprite "head", frame 5
	    {
	        283.7, // x
	        -219.95, // y
	        0, // rotation
	        0.99824303335408, // scaleX
	        1.0025313783213388, // scaleY
	    },
	    
	    // 255. sprite "head", frame 6
	    {
	        284.1, // x
	        -219.65, // y
	        0, // rotation
	        0.9975736331640689, // scaleX
	        1.0034936410944797, // scaleY
	    },
	    
	    // 256. sprite "head", frame 7
	    {
	        284.5, // x
	        -219.45, // y
	        0, // rotation
	        0.9968414767062442, // scaleX
	        1.00456049764731, // scaleY
	    },
	    
	    // 257. sprite "head", frame 8
	    {
	        285, // x
	        -219.15, // y
	        0, // rotation
	        0.9960465639806061, // scaleX
	        1.0056901104679536, // scaleY
	    },
	    
	    // 258. sprite "head", frame 9
	    {
	        285.4, // x
	        -218.9, // y
	        0, // rotation
	        0.9952516512549678, // scaleX
	        1.0068406420445353, // scaleY
	    },
	    
	    // 259. sprite "head", frame 10
	    {
	        285.9, // x
	        -218.55, // y
	        0, // rotation
	        0.9944358197733918, // scaleX
	        1.0080120923770548, // scaleY
	    },
	    
	    // 260. sprite "head", frame 11
	    {
	        286.25, // x
	        -218.3, // y
	        0, // rotation
	        0.9936409070477535, // scaleX
	        1.0091417051976985, // scaleY
	    },
	    
	    // 261. sprite "head", frame 12
	    {
	        286.7, // x
	        -218.05, // y
	        0, // rotation
	        0.9928878318339911, // scaleX
	        1.0102294805064667, // scaleY
	    },
	    
	    // 262. sprite "head", frame 13
	    {
	        287.05, // x
	        -217.75, // y
	        0, // rotation
	        0.9922184316439799, // scaleX
	        1.0112126620355455, // scaleY
	    },
	    
	    // 263. sprite "head", frame 14
	    {
	        287.45, // x
	        -217.55, // y
	        0, // rotation
	        0.9916117877217824, // scaleX
	        1.0120703310289971, // scaleY
	    },
	    
	    // 264. sprite "head", frame 15
	    {
	        287.75, // x
	        -217.35, // y
	        0, // rotation
	        0.9910888188233362, // scaleX
	        1.0128234062427597, // scaleY
	    },
	    
	    // 265. sprite "head", frame 16
	    {
	        287.9, // x
	        -217.2, // y
	        0, // rotation
	        0.9906704437045792, // scaleX
	        1.0134300501649574, // scaleY
	    },
	    
	    // 266. sprite "head", frame 17
	    {
	        288.1, // x
	        -217.1, // y
	        0, // rotation
	        0.9903357436095737, // scaleX
	        1.0139111815515278, // scaleY
	    },
	    
	    // 267. sprite "head", frame 18
	    {
	        287.95, // x
	        -217.2, // y
	        0, // rotation
	        0.9906286061927035, // scaleX
	        1.0134928064327708, // scaleY
	    },
	    
	    // 268. sprite "head", frame 19
	    {
	        287.75, // x
	        -217.35, // y
	        0, // rotation
	        0.9910051437995848, // scaleX
	        1.0129489187783869, // scaleY
	    },
	    
	    // 269. sprite "head", frame 20
	    {
	        287.45, // x
	        -217.5, // y
	        0, // rotation
	        0.9915071939420932, // scaleX
	        1.0122376810765, // scaleY
	    },
	    
	    // 270. sprite "head", frame 21
	    {
	        287.15, // x
	        -217.75, // y
	        0, // rotation
	        0.9920929191083528, // scaleX
	        1.0113800120830483, // scaleY
	    },
	    
	    // 271. sprite "head", frame 22
	    {
	        286.75, // x
	        -218, // y
	        0, // rotation
	        0.992762319298364, // scaleX
	        1.0104177493099071, // scaleY
	    },
	    
	    // 272. sprite "head", frame 23
	    {
	        286.35, // x
	        -218.25, // y
	        0, // rotation
	        0.9934944757561887, // scaleX
	        1.0093508927570771, // scaleY
	    },
	    
	    // 273. sprite "head", frame 24
	    {
	        285.9, // x
	        -218.55, // y
	        0, // rotation
	        0.9942893884818269, // scaleX
	        1.0082212799364332, // scaleY
	    },
	    
	    // 274. sprite "head", frame 25
	    {
	        285.45, // x
	        -218.8, // y
	        0, // rotation
	        0.995084301207465, // scaleX
	        1.0070707483598516, // scaleY
	    },
	    
	    // 275. sprite "head", frame 26
	    {
	        285, // x
	        -219.1, // y
	        0, // rotation
	        0.9959001326890411, // scaleX
	        1.0058992980273322, // scaleY
	    },
	    
	    // 276. sprite "head", frame 27
	    {
	        284.6, // x
	        -219.4, // y
	        0, // rotation
	        0.9966950454146793, // scaleX
	        1.0047696852066885, // scaleY
	    },
	    
	    // 277. sprite "head", frame 28
	    {
	        284.15, // x
	        -219.65, // y
	        0, // rotation
	        0.9974481206284418, // scaleX
	        1.0036819098979204, // scaleY
	    },
	    
	    // 278. sprite "head", frame 29
	    {
	        283.8, // x
	        -219.9, // y
	        0, // rotation
	        0.998117520818453, // scaleX
	        1.0027196471247795, // scaleY
	    },
	    
	    // 279. sprite "head", frame 30
	    {
	        283.45, // x
	        -220.15, // y
	        0, // rotation
	        0.9987241647406505, // scaleX
	        1.0018410593753897, // scaleY
	    },
	    
	    // 280. sprite "head", frame 31
	    {
	        283.15, // x
	        -220.35, // y
	        0, // rotation
	        0.9992471336390967, // scaleX
	        1.0010879841616274, // scaleY
	    },
	    
	    // 281. sprite "head", frame 32
	    {
	        282.95, // x
	        -220.5, // y
	        0, // rotation
	        0.9996655087578536, // scaleX
	        1.0004813402394297, // scaleY
	    },
	    
	    // 282. sprite "head", frame 33
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 283. sprite "head", frame 34
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 284. sprite "head", frame 35
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 285. sprite "head", frame 36
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 286. sprite "head", frame 37
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 287. sprite "head", frame 38
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 288. sprite "head", frame 39
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 289. sprite "head", frame 40
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 290. sprite "head", frame 41
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 291. sprite "head", frame 42
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 292. sprite "head", frame 43
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 293. sprite "head", frame 44
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 294. sprite "head", frame 45
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 295. sprite "head", frame 46
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 296. sprite "head", frame 47
	    {
	        282.75, // x
	        -220.6, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 297. sprite "eye", frame 2
	    {
	        231.65, // x
	        -183.15, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 298. sprite "eye", frame 3
	    {
	        231.9, // x
	        -182.95, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 299. sprite "eye", frame 4
	    {
	        232.2, // x
	        -182.75, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 300. sprite "eye", frame 5
	    {
	        232.55, // x
	        -182.5, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 301. sprite "eye", frame 6
	    {
	        232.95, // x
	        -182.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 302. sprite "eye", frame 7
	    {
	        233.4, // x
	        -181.9, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 303. sprite "eye", frame 8
	    {
	        233.85, // x
	        -181.6, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 304. sprite "eye", frame 9
	    {
	        234.35, // x
	        -181.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 305. sprite "eye", frame 10
	    {
	        234.85, // x
	        -180.9, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 306. sprite "eye", frame 11
	    {
	        235.35, // x
	        -180.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 307. sprite "eye", frame 12
	    {
	        235.8, // x
	        -180.2, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 308. sprite "eye", frame 13
	    {
	        236.25, // x
	        -179.9, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 309. sprite "eye", frame 14
	    {
	        236.65, // x
	        -179.6, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 310. sprite "eye", frame 15
	    {
	        237, // x
	        -179.35, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 311. sprite "eye", frame 16
	    {
	        237.25, // x
	        -179.15, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 312. sprite "eye", frame 17
	    {
	        237.5, // x
	        -179, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 313. sprite "eye", frame 18
	    {
	        237.35, // x
	        -179.1, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 314. sprite "eye", frame 19
	    {
	        237.1, // x
	        -179.3, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 315. sprite "eye", frame 20
	    {
	        236.8, // x
	        -179.5, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 316. sprite "eye", frame 21
	    {
	        236.45, // x
	        -179.75, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 317. sprite "eye", frame 22
	    {
	        236.05, // x
	        -180, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 318. sprite "eye", frame 23
	    {
	        235.6, // x
	        -180.35, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 319. sprite "eye", frame 24
	    {
	        235.15, // x
	        -180.65, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 320. sprite "eye", frame 25
	    {
	        234.65, // x
	        -181, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 321. sprite "eye", frame 26
	    {
	        234.15, // x
	        -181.4, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 322. sprite "eye", frame 27
	    {
	        233.65, // x
	        -181.7, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 323. sprite "eye", frame 28
	    {
	        233.2, // x
	        -182.05, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 324. sprite "eye", frame 29
	    {
	        232.75, // x
	        -182.35, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 325. sprite "eye", frame 30
	    {
	        232.35, // x
	        -182.65, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 326. sprite "eye", frame 31
	    {
	        232, // x
	        -182.9, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 327. sprite "eye", frame 32
	    {
	        231.75, // x
	        -183.1, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 328. sprite "eye", frame 33
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 329. sprite "eye", frame 34
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 330. sprite "eye", frame 35
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 331. sprite "eye", frame 36
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 332. sprite "eye", frame 37
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 333. sprite "eye", frame 38
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 334. sprite "eye", frame 39
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 335. sprite "eye", frame 40
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 336. sprite "eye", frame 41
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 337. sprite "eye", frame 42
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 338. sprite "eye", frame 43
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 339. sprite "eye", frame 44
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 340. sprite "eye", frame 45
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 341. sprite "eye", frame 46
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 342. sprite "eye", frame 47
	    {
	        231.5, // x
	        -183.25, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 343. sprite "instance58", frame 2
	    {
	        298.9, // x
	        -207.45, // y
	        0.00015259913046154034, // rotation
	        0.9962139247899156, // scaleX
	        0.9999793008182049, // scaleY
	    },
	    
	    // 344. sprite "instance58", frame 3
	    {
	        299.1, // x
	        -207.3, // y
	        0.0003661846498858952, // rotation
	        0.9910679638696682, // scaleX
	        0.9999584345759974, // scaleY
	    },
	    
	    // 345. sprite "instance58", frame 4
	    {
	        299.3, // x
	        -207.2, // y
	        0.0005952165036327097, // rotation
	        0.9846250974540888, // scaleX
	        0.9999585553570509, // scaleY
	    },
	    
	    // 346. sprite "instance58", frame 5
	    {
	        299.55, // x
	        -206.9, // y
	        0.0009155947827692422, // rotation
	        0.9769481539112264, // scaleX
	        0.9999587949498588, // scaleY
	    },
	    
	    // 347. sprite "instance58", frame 6
	    {
	        299.95, // x
	        -206.75, // y
	        0.004562261263414743, // rotation
	        0.968171923668615, // scaleX
	        0.9999268375762117, // scaleY
	    },
	    
	    // 348. sprite "instance58", frame 7
	    {
	        300.35, // x
	        -206.45, // y
	        0.004928445913300638, // rotation
	        0.9585090561716906, // scaleX
	        0.999928720899512, // scaleY
	    },
	    
	    // 349. sprite "instance58", frame 8
	    {
	        300.7, // x
	        -206.2, // y
	        0.005340436933935896, // rotation
	        0.9481979641646688, // scaleX
	        0.9999307622017762, // scaleY
	    },
	    
	    // 350. sprite "instance58", frame 9
	    {
	        301.15, // x
	        -206, // y
	        0.00903290978533076, // rotation
	        0.9374495746813879, // scaleX
	        0.9999155334044216, // scaleY
	    },
	    
	    // 351. sprite "instance58", frame 10
	    {
	        301.55, // x
	        -205.65, // y
	        0.009460080824179469, // rotation
	        0.9266377485570761, // scaleX
	        0.9999194020577643, // scaleY
	    },
	    
	    // 352. sprite "instance58", frame 11
	    {
	        302, // x
	        -205.4, // y
	        0.013182913712001235, // rotation
	        0.916007255496205, // scaleX
	        0.999898517716476, // scaleY
	    },
	    
	    // 353. sprite "instance58", frame 12
	    {
	        302.4, // x
	        -205.15, // y
	        0.013549098361887132, // rotation
	        0.9058653610195799, // scaleX
	        0.9998829100834749, // scaleY
	    },
	    
	    // 354. sprite "instance58", frame 13
	    {
	        302.75, // x
	        -204.9, // y
	        0.01393046302998648, // rotation
	        0.8964556845985797, // scaleX
	        0.999888377356109, // scaleY
	    },
	    
	    // 355. sprite "instance58", frame 14
	    {
	        303.1, // x
	        -204.7, // y
	        0.01788126250711903, // rotation
	        0.8879967125916176, // scaleX
	        0.9999293252602052, // scaleY
	    },
	    
	    // 356. sprite "instance58", frame 15
	    {
	        303.1, // x
	        -204.3, // y
	        0.008926117025618583, // rotation
	        0.8812376959724759, // scaleX
	        0.99987275774827, // scaleY
	    },
	    
	    // 357. sprite "instance58", frame 16
	    {
	        303.15, // x
	        -203.8, // y
	        -0.00013741911224808868, // rotation
	        0.8730442880881693, // scaleX
	        0.9998956257953507, // scaleY
	    },
	    
	    // 358. sprite "instance58", frame 17
	    {
	        303.3, // x
	        -203.55, // y
	        -0.008056594929707712, // rotation
	        0.8670267422714599, // scaleX
	        0.999865294911979, // scaleY
	    },
	    
	    // 359. sprite "instance58", frame 18
	    {
	        303.25, // x
	        -203.95, // y
	        0.00007616640717626622, // rotation
	        0.8732953063921954, // scaleX
	        0.9999165357984466, // scaleY
	    },
	    
	    // 360. sprite "instance58", frame 19
	    {
	        303.1, // x
	        -204.3, // y
	        0.009170328897578848, // rotation
	        0.8808839839779259, // scaleX
	        0.9998748398661559, // scaleY
	    },
	    
	    // 361. sprite "instance58", frame 20
	    {
	        303.15, // x
	        -204.55, // y
	        0.01794251521219085, // rotation
	        0.8864284320790257, // scaleX
	        0.9999308219375392, // scaleY
	    },
	    
	    // 362. sprite "instance58", frame 21
	    {
	        302.8, // x
	        -204.8, // y
	        0.013976269400735842, // rotation
	        0.8946571387654004, // scaleX
	        0.999888669482903, // scaleY
	    },
	    
	    // 363. sprite "instance58", frame 22
	    {
	        302.45, // x
	        -205, // y
	        0.013625264769063398, // rotation
	        0.9039624987804241, // scaleX
	        0.9998837628355508, // scaleY
	    },
	    
	    // 364. sprite "instance58", frame 23
	    {
	        302.15, // x
	        -205.3, // y
	        0.013228720082750601, // rotation
	        0.9140204230735087, // scaleX
	        0.9998993455098525, // scaleY
	    },
	    
	    // 365. sprite "instance58", frame 24
	    {
	        301.65, // x
	        -205.55, // y
	        0.009521067213142284, // rotation
	        0.9246300355635702, // scaleX
	        0.9999409152609265, // scaleY
	    },
	    
	    // 366. sprite "instance58", frame 25
	    {
	        301.2, // x
	        -205.8, // y
	        0.009109342508616034, // rotation
	        0.9354209182579372, // scaleX
	        0.9999159123930689, // scaleY
	    },
	    
	    // 367. sprite "instance58", frame 26
	    {
	        300.8, // x
	        -206.1, // y
	        0.00541686965722117, // rotation
	        0.946169211669268, // scaleX
	        0.9999312120798155, // scaleY
	    },
	    
	    // 368. sprite "instance58", frame 27
	    {
	        300.4, // x
	        -206.4, // y
	        0.005004878636585912, // rotation
	        0.9565848662949831, // scaleX
	        0.9999290327076631, // scaleY
	    },
	    
	    // 369. sprite "instance58", frame 28
	    {
	        300.05, // x
	        -206.7, // y
	        0.004608067634164106, // rotation
	        0.9663312843174263, // scaleX
	        0.9999270283812898, // scaleY
	    },
	    
	    // 370. sprite "instance58", frame 29
	    {
	        299.65, // x
	        -206.95, // y
	        0.0009917611899455084, // rotation
	        0.9752747140466567, // scaleX
	        0.9999588546839472, // scaleY
	    },
	    
	    // 371. sprite "instance58", frame 30
	    {
	        299.45, // x
	        -207.15, // y
	        0.0006562028925955243, // rotation
	        0.9832026616910926, // scaleX
	        0.9999795003653391, // scaleY
	    },
	    
	    // 372. sprite "instance58", frame 31
	    {
	        299.1, // x
	        -207.3, // y
	        0.0003968110024218065, // rotation
	        0.9900011232980971, // scaleX
	        0.9999793690843342, // scaleY
	    },
	    
	    // 373. sprite "instance58", frame 32
	    {
	        299, // x
	        -207.5, // y
	        0.000167779148674992, // rotation
	        0.995607284170713, // scaleX
	        0.9999793008182049, // scaleY
	    },
	    
	    // 374. sprite "instance58", frame 33
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 375. sprite "instance58", frame 34
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 376. sprite "instance58", frame 35
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 377. sprite "instance58", frame 36
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 378. sprite "instance58", frame 37
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 379. sprite "instance58", frame 38
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 380. sprite "instance58", frame 39
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 381. sprite "instance58", frame 40
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 382. sprite "instance58", frame 41
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 383. sprite "instance58", frame 42
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 384. sprite "instance58", frame 43
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 385. sprite "instance58", frame 44
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 386. sprite "instance58", frame 45
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 387. sprite "instance58", frame 46
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 388. sprite "instance58", frame 47
	    {
	        298.75, // x
	        -207.55, // y
	        0, // rotation
	        0.9999792900969213, // scaleX
	        0.9999792900969213, // scaleY
	    },
	    
	    // 389. sprite "tail", frame 2
	    {
	        395.35, // x
	        -270.5, // y
	        0.214833476711166, // rotation
	        0.998607363750661, // scaleX
	        0.998607363750661, // scaleY
	    },
	    
	    // 390. sprite "tail", frame 3
	    {
	        395.4, // x
	        -270.6, // y
	        0.22707869140335038, // rotation
	        0.9985673066638926, // scaleX
	        0.9985673066638926, // scaleY
	    },
	    
	    // 391. sprite "tail", frame 4
	    {
	        395.55, // x
	        -270.65, // y
	        0.23673291667099663, // rotation
	        0.9984769251633498, // scaleX
	        0.9984769251633498, // scaleY
	    },
	    
	    // 392. sprite "tail", frame 5
	    {
	        395.5, // x
	        -270.7, // y
	        0.2535481157937569, // rotation
	        0.9983882935066956, // scaleX
	        0.9983882935066956, // scaleY
	    },
	    
	    // 393. sprite "tail", frame 6
	    {
	        395.65, // x
	        -270.8, // y
	        0.27098303250217864, // rotation
	        0.9982730775309298, // scaleX
	        0.9982730775309298, // scaleY
	    },
	    
	    // 394. sprite "tail", frame 7
	    {
	        395.8, // x
	        -270.85, // y
	        0.2889098350639381, // rotation
	        0.9981732752822498, // scaleX
	        0.9981732752822498, // scaleY
	    },
	    
	    // 395. sprite "tail", frame 8
	    {
	        395.9, // x
	        -270.95, // y
	        0.3104292419362143, // rotation
	        0.9980630327543129, // scaleX
	        0.9980630327543129, // scaleY
	    },
	    
	    // 396. sprite "tail", frame 9
	    {
	        396, // x
	        -271.05, // y
	        0.3321465216774835, // rotation
	        0.9979139939888768, // scaleX
	        0.9979139939888768, // scaleY
	    },
	    
	    // 397. sprite "tail", frame 10
	    {
	        396.1, // x
	        -271.1, // y
	        0.3538653993154067, // rotation
	        0.9977926195718039, // scaleX
	        0.9977926195718039, // scaleY
	    },
	    
	    // 398. sprite "tail", frame 11
	    {
	        396.25, // x
	        -271.25, // y
	        0.3721466686182556, // rotation
	        0.9976911124247168, // scaleX
	        0.9976911124247168, // scaleY
	    },
	    
	    // 399. sprite "tail", frame 12
	    {
	        396.4, // x
	        -271.3, // y
	        0.3933643393390259, // rotation
	        0.9975794701589425, // scaleX
	        0.9975794701589425, // scaleY
	    },
	    
	    // 400. sprite "tail", frame 13
	    {
	        396.4, // x
	        -271.4, // y
	        0.4108724929774249, // rotation
	        0.9974788577664675, // scaleX
	        0.9974788577664675, // scaleY
	    },
	    
	    // 401. sprite "tail", frame 14
	    {
	        396.45, // x
	        -271.4, // y
	        0.42451240513248373, // rotation
	        0.9974057013573702, // scaleX
	        0.9974057013573702, // scaleY
	    },
	    
	    // 402. sprite "tail", frame 15
	    {
	        396.5, // x
	        -271.5, // y
	        0.4374854617505867, // rotation
	        0.9973479673084749, // scaleX
	        0.9973479673084749, // scaleY
	    },
	    
	    // 403. sprite "tail", frame 16
	    {
	        396.55, // x
	        -271.55, // y
	        0.4465239641742066, // rotation
	        0.9973118075133824, // scaleX
	        0.9973118075133824, // scaleY
	    },
	    
	    // 404. sprite "tail", frame 17
	    {
	        396.6, // x
	        -271.55, // y
	        0.4557552794607483, // rotation
	        0.9985438691706708, // scaleX
	        0.9985438691706708, // scaleY
	    },
	    
	    // 405. sprite "tail", frame 18
	    {
	        396.65, // x
	        -271.5, // y
	        0.44663555062388094, // rotation
	        0.9972913435488279, // scaleX
	        0.9972913435488279, // scaleY
	    },
	    
	    // 406. sprite "tail", frame 19
	    {
	        396.5, // x
	        -271.5, // y
	        0.4376732146074373, // rotation
	        0.9973430900631726, // scaleX
	        0.9973430900631726, // scaleY
	    },
	    
	    // 407. sprite "tail", frame 20
	    {
	        396.45, // x
	        -271.4, // y
	        0.42471507169143874, // rotation
	        0.9974070168960635, // scaleX
	        0.9974070168960635, // scaleY
	    },
	    
	    // 408. sprite "tail", frame 21
	    {
	        396.45, // x
	        -271.4, // y
	        0.4111545217368643, // rotation
	        0.997491626936581, // scaleX
	        0.997491626936581, // scaleY
	    },
	    
	    // 409. sprite "tail", frame 22
	    {
	        396.4, // x
	        -271.25, // y
	        0.3936897776242336, // rotation
	        0.9975758494846729, // scaleX
	        0.9975758494846729, // scaleY
	    },
	    
	    // 410. sprite "tail", frame 23
	    {
	        396.25, // x
	        -271.25, // y
	        0.3757962645761002, // rotation
	        0.9976828306121319, // scaleX
	        0.9976828306121319, // scaleY
	    },
	    
	    // 411. sprite "tail", frame 24
	    {
	        396.15, // x
	        -271.15, // y
	        0.3542680692722267, // rotation
	        0.997805444808909, // scaleX
	        0.997805444808909, // scaleY
	    },
	    
	    // 412. sprite "tail", frame 25
	    {
	        396.05, // x
	        -271.05, // y
	        0.3325417347832512, // rotation
	        0.9979181984051035, // scaleX
	        0.9979181984051035, // scaleY
	    },
	    
	    // 413. sprite "tail", frame 26
	    {
	        395.9, // x
	        -271, // y
	        0.31080261712104346, // rotation
	        0.9980323017692138, // scaleX
	        0.9980323017692138, // scaleY
	    },
	    
	    // 414. sprite "tail", frame 27
	    {
	        395.8, // x
	        -270.9, // y
	        0.28926030706339245, // rotation
	        0.9981684377989439, // scaleX
	        0.9981684377989439, // scaleY
	    },
	    
	    // 415. sprite "tail", frame 28
	    {
	        395.7, // x
	        -270.9, // y
	        0.2713231181733818, // rotation
	        0.9983022610029277, // scaleX
	        0.9983022610029277, // scaleY
	    },
	    
	    // 416. sprite "tail", frame 29
	    {
	        395.65, // x
	        -270.7, // y
	        0.2538770161883817, // rotation
	        0.9983658084243984, // scaleX
	        0.9983658084243984, // scaleY
	    },
	    
	    // 417. sprite "tail", frame 30
	    {
	        395.5, // x
	        -270.7, // y
	        0.24026267037978763, // rotation
	        0.9984946415225572, // scaleX
	        0.9984946415225572, // scaleY
	    },
	    
	    // 418. sprite "tail", frame 31
	    {
	        395.45, // x
	        -270.65, // y
	        0.2272379484365371, // rotation
	        0.9985391408501999, // scaleX
	        0.9985391408501999, // scaleY
	    },
	    
	    // 419. sprite "tail", frame 32
	    {
	        395.35, // x
	        -270.55, // y
	        0.21496450423679794, // rotation
	        0.9986341289295291, // scaleX
	        0.9986341289295291, // scaleY
	    },
	    
	    // 420. sprite "tail", frame 33
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 421. sprite "tail", frame 34
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 422. sprite "tail", frame 35
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 423. sprite "tail", frame 36
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 424. sprite "tail", frame 37
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 425. sprite "tail", frame 38
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 426. sprite "tail", frame 39
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 427. sprite "tail", frame 40
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 428. sprite "tail", frame 41
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 429. sprite "tail", frame 42
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 430. sprite "tail", frame 43
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 431. sprite "tail", frame 44
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 432. sprite "tail", frame 45
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 433. sprite "tail", frame 46
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 434. sprite "tail", frame 47
	    {
	        395.3, // x
	        -270.55, // y
	        0.2105034430948062, // rotation
	        0.9993208311301324, // scaleX
	        0.9993208311301324, // scaleY
	    },
	    
	    // 435. sprite "shell", frame 2
	    {
	        349.95, // x
	        -269.6, // y
	        0, // rotation
	        1.0001884776563, // scaleX
	        1.001527278036322, // scaleY
	    },
	    
	    // 436. sprite "shell", frame 3
	    {
	        350, // x
	        -269.6, // y
	        0, // rotation
	        1.0005440965072432, // scaleX
	        1.0038910974572988, // scaleY
	    },
	    
	    // 437. sprite "shell", frame 4
	    {
	        350, // x
	        -269.5, // y
	        0, // rotation
	        1.000983390381938, // scaleX
	        1.0070707483598516, // scaleY
	    },
	    
	    // 438. sprite "shell", frame 5
	    {
	        350, // x
	        -269.4, // y
	        0, // rotation
	        1.001527278036322, // scaleX
	        1.0109616369642913, // scaleY
	    },
	    
	    // 439. sprite "shell", frame 6
	    {
	        350, // x
	        -269.3, // y
	        0, // rotation
	        1.0021548407144576, // scaleX
	        1.01554284451468, // scaleY
	    },
	    
	    // 440. sprite "shell", frame 7
	    {
	        350, // x
	        -269.2, // y
	        0, // rotation
	        1.0028660784163443, // scaleX
	        1.020605183451639, // scaleY
	    },
	    
	    // 441. sprite "shell", frame 8
	    {
	        349.95, // x
	        -269.1, // y
	        0, // rotation
	        1.003619153630107, // scaleX
	        1.0260440599954792, // scaleY
	    },
	    
	    // 442. sprite "shell", frame 9
	    {
	        350, // x
	        -269, // y
	        0, // rotation
	        1.004414066355745, // scaleX
	        1.0316502865868225, // scaleY
	    },
	    
	    // 443. sprite "shell", frame 10
	    {
	        349.95, // x
	        -268.9, // y
	        0, // rotation
	        1.0051880603254453, // scaleX
	        1.0372774319341034, // scaleY
	    },
	    
	    // 444. sprite "shell", frame 11
	    {
	        350, // x
	        -268.8, // y
	        0, // rotation
	        1.0059411355392078, // scaleX
	        1.0427163084779436, // scaleY
	    },
	    
	    // 445. sprite "shell", frame 12
	    {
	        350, // x
	        -268.7, // y
	        0, // rotation
	        1.0066523732410948, // scaleX
	        1.0477995661708406, // scaleY
	    },
	    
	    // 446. sprite "shell", frame 13
	    {
	        350, // x
	        -268.65, // y
	        0, // rotation
	        1.007300854675168, // scaleX
	        1.0524435299890427, // scaleY
	    },
	    
	    // 447. sprite "shell", frame 14
	    {
	        350, // x
	        -268.55, // y
	        0, // rotation
	        1.00786566108549, // scaleX
	        1.0565017686409852, // scaleY
	    },
	    
	    // 448. sprite "shell", frame 15
	    {
	        349.95, // x
	        -268.45, // y
	        0, // rotation
	        1.0083467924720604, // scaleX
	        1.0599115258588543, // scaleY
	    },
	    
	    // 449. sprite "shell", frame 16
	    {
	        350, // x
	        -268.4, // y
	        0, // rotation
	        1.0087233300789415, // scaleX
	        1.06267280164265, // scaleY
	    },
	    
	    // 450. sprite "shell", frame 17
	    {
	        349.95, // x
	        -268.35, // y
	        0, // rotation
	        1.0090161926620715, // scaleX
	        1.0647228397245592, // scaleY
	    },
	    
	    // 451. sprite "shell", frame 18
	    {
	        349.95, // x
	        -268.35, // y
	        0, // rotation
	        1.008807005102693, // scaleX
	        1.0631957705410964, // scaleY
	    },
	    
	    // 452. sprite "shell", frame 19
	    {
	        349.95, // x
	        -268.35, // y
	        0, // rotation
	        1.0084723050076874, // scaleX
	        1.0608319511201196, // scaleY
	    },
	    
	    // 453. sprite "shell", frame 20
	    {
	        349.95, // x
	        -268.45, // y
	        0, // rotation
	        1.0080330111329927, // scaleX
	        1.0576523002175668, // scaleY
	    },
	    
	    // 454. sprite "shell", frame 21
	    {
	        349.95, // x
	        -268.55, // y
	        0, // rotation
	        1.0074891234786085, // scaleX
	        1.0537404928571894, // scaleY
	    },
	    
	    // 455. sprite "shell", frame 22
	    {
	        349.95, // x
	        -268.65, // y
	        0, // rotation
	        1.0068615608004732, // scaleX
	        1.0491802040627385, // scaleY
	    },
	    
	    // 456. sprite "shell", frame 23
	    {
	        349.95, // x
	        -268.75, // y
	        0, // rotation
	        1.0061503230985864, // scaleX
	        1.0441178651257794, // scaleY
	    },
	    
	    // 457. sprite "shell", frame 24
	    {
	        349.95, // x
	        -268.85, // y
	        0, // rotation
	        1.0053972478848239, // scaleX
	        1.0386789885819392, // scaleY
	    },
	    
	    // 458. sprite "shell", frame 25
	    {
	        349.95, // x
	        -268.95, // y
	        0, // rotation
	        1.0046232539151234, // scaleX
	        1.033072761990596, // scaleY
	    },
	    
	    // 459. sprite "shell", frame 26
	    {
	        349.95, // x
	        -269.05, // y
	        0, // rotation
	        1.0038283411894853, // scaleX
	        1.027445616643315, // scaleY
	    },
	    
	    // 460. sprite "shell", frame 27
	    {
	        349.95, // x
	        -269.15, // y
	        0, // rotation
	        1.0030752659757227, // scaleX
	        1.0220067400994748, // scaleY
	    },
	    
	    // 461. sprite "shell", frame 28
	    {
	        349.95, // x
	        -269.3, // y
	        0, // rotation
	        1.002364028273836, // scaleX
	        1.0169234824065778, // scaleY
	    },
	    
	    // 462. sprite "shell", frame 29
	    {
	        349.95, // x
	        -269.35, // y
	        0, // rotation
	        1.0017155468397627, // scaleX
	        1.0122795185883757, // scaleY
	    },
	    
	    // 463. sprite "shell", frame 30
	    {
	        349.95, // x
	        -269.45, // y
	        0, // rotation
	        1.0011507404294409, // scaleX
	        1.0082212799364332, // scaleY
	    },
	    
	    // 464. sprite "shell", frame 31
	    {
	        349.95, // x
	        -269.5, // y
	        0, // rotation
	        1.0006696090428704, // scaleX
	        1.0047906039626262, // scaleY
	    },
	    
	    // 465. sprite "shell", frame 32
	    {
	        350, // x
	        -269.55, // y
	        0, // rotation
	        1.000293071435989, // scaleX
	        1.0020502469347683, // scaleY
	    },
	    
	    // 466. sprite "shell", frame 33
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 467. sprite "shell", frame 34
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 468. sprite "shell", frame 35
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 469. sprite "shell", frame 36
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 470. sprite "shell", frame 37
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 471. sprite "shell", frame 38
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 472. sprite "shell", frame 39
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 473. sprite "shell", frame 40
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 474. sprite "shell", frame 41
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 475. sprite "shell", frame 42
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 476. sprite "shell", frame 43
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 477. sprite "shell", frame 44
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 478. sprite "shell", frame 45
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 479. sprite "shell", frame 46
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 480. sprite "shell", frame 47
	    {
	        350, // x
	        -269.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 481. sprite "leg_f", frame 2
	    {
	        322.3, // x
	        -286.55, // y
	        0, // rotation
	        0.9970297455096849, // scaleX
	        1.0003976652156783, // scaleY
	    },
	    
	    // 482. sprite "leg_f", frame 3
	    {
	        322.3, // x
	        -286.5, // y
	        0, // rotation
	        0.9939546883868213, // scaleX
	        1.0026778096129036, // scaleY
	    },
	    
	    // 483. sprite "leg_f", frame 4
	    {
	        322.3, // x
	        -286.45, // y
	        0, // rotation
	        0.9896454246636247, // scaleX
	        1.0058365417595188, // scaleY
	    },
	    
	    // 484. sprite "leg_f", frame 5
	    {
	        322.25, // x
	        -286.35, // y
	        0, // rotation
	        0.9842483856316601, // scaleX
	        1.0098529428995853, // scaleY
	    },
	    
	    // 485. sprite "leg_f", frame 6
	    {
	        322.3, // x
	        -286.3, // y
	        0, // rotation
	        0.9778472463146788, // scaleX
	        1.014580581741539, // scaleY
	    },
	    
	    // 486. sprite "leg_f", frame 7
	    {
	        322.3, // x
	        -286.2, // y
	        0, // rotation
	        0.970672113027997, // scaleX
	        1.0198730269938143, // scaleY
	    },
	    
	    // 487. sprite "leg_f", frame 8
	    {
	        322.3, // x
	        -286.1, // y
	        0, // rotation
	        0.9629321733309936, // scaleX
	        1.0256047661207846, // scaleY
	    },
	    
	    // 488. sprite "leg_f", frame 9
	    {
	        322.3, // x
	        -285.95, // y
	        0, // rotation
	        0.9549412085627358, // scaleX
	        1.0315038552952576, // scaleY
	    },
	    
	    // 489. sprite "leg_f", frame 10
	    {
	        322.3, // x
	        -285.85, // y
	        0, // rotation
	        0.9469502437944781, // scaleX
	        1.0374238632256683, // scaleY
	    },
	    
	    // 490. sprite "leg_f", frame 11
	    {
	        322.3, // x
	        -285.75, // y
	        0, // rotation
	        0.9392521416093502, // scaleX
	        1.043113764840763, // scaleY
	    },
	    
	    // 491. sprite "leg_f", frame 12
	    {
	        322.3, // x
	        -285.7, // y
	        0, // rotation
	        0.9320351708107929, // scaleX
	        1.0484480476049138, // scaleY
	    },
	    
	    // 492. sprite "leg_f", frame 13
	    {
	        322.25, // x
	        -285.6, // y
	        0, // rotation
	        0.9255085189581844, // scaleX
	        1.0532593614706187, // scaleY
	    },
	    
	    // 493. sprite "leg_f", frame 14
	    {
	        322.3, // x
	        -285.55, // y
	        0, // rotation
	        0.9197976985871521, // scaleX
	        1.057484950170064, // scaleY
	    },
	    
	    // 494. sprite "leg_f", frame 15
	    {
	        322.3, // x
	        -285.45, // y
	        0, // rotation
	        0.9149863847214472, // scaleX
	        1.061062057435436, // scaleY
	    },
	    
	    // 495. sprite "leg_f", frame 16
	    {
	        322.25, // x
	        -285.35, // y
	        0, // rotation
	        0.9110954961170076, // scaleX
	        1.063927926998921, // scaleY
	    },
	    
	    // 496. sprite "leg_f", frame 17
	    {
	        322.3, // x
	        -285.35, // y
	        0, // rotation
	        0.9081250327738333, // scaleX
	        1.066124396372395, // scaleY
	    },
	    
	    // 497. sprite "leg_f", frame 18
	    {
	        322.3, // x
	        -285.4, // y
	        0, // rotation
	        0.9099868020523016, // scaleX
	        1.064743758480497, // scaleY
	    },
	    
	    // 498. sprite "leg_f", frame 19
	    {
	        322.3, // x
	        -285.4, // y
	        0, // rotation
	        0.9130618591751652, // scaleX
	        1.0624636140832717, // scaleY
	    },
	    
	    // 499. sprite "leg_f", frame 20
	    {
	        322.3, // x
	        -285.55, // y
	        0, // rotation
	        0.9173711228983618, // scaleX
	        1.0593048819366566, // scaleY
	    },
	    
	    // 500. sprite "leg_f", frame 21
	    {
	        322.3, // x
	        -285.6, // y
	        0, // rotation
	        0.9227681619303264, // scaleX
	        1.05528848079659, // scaleY
	    },
	    
	    // 501. sprite "leg_f", frame 22
	    {
	        322.3, // x
	        -285.65, // y
	        0, // rotation
	        0.9291693012473078, // scaleX
	        1.0505608419546364, // scaleY
	    },
	    
	    // 502. sprite "leg_f", frame 23
	    {
	        322.3, // x
	        -285.75, // y
	        0, // rotation
	        0.9363444345339894, // scaleX
	        1.045268396702361, // scaleY
	    },
	    
	    // 503. sprite "leg_f", frame 24
	    {
	        322.3, // x
	        -285.9, // y
	        0, // rotation
	        0.944084374230993, // scaleX
	        1.0395366575753908, // scaleY
	    },
	    
	    // 504. sprite "leg_f", frame 25
	    {
	        322.3, // x
	        -285.95, // y
	        0, // rotation
	        0.9520753389992507, // scaleX
	        1.0336375684009178, // scaleY
	    },
	    
	    // 505. sprite "leg_f", frame 26
	    {
	        322.3, // x
	        -286.05, // y
	        0, // rotation
	        0.9600663037675085, // scaleX
	        1.027717560470507, // scaleY
	    },
	    
	    // 506. sprite "leg_f", frame 27
	    {
	        322.3, // x
	        -286.2, // y
	        0, // rotation
	        0.9677644059526364, // scaleX
	        1.0220276588554125, // scaleY
	    },
	    
	    // 507. sprite "leg_f", frame 28
	    {
	        322.3, // x
	        -286.3, // y
	        0, // rotation
	        0.9749813767511937, // scaleX
	        1.0166933760912615, // scaleY
	    },
	    
	    // 508. sprite "leg_f", frame 29
	    {
	        322.3, // x
	        -286.4, // y
	        0, // rotation
	        0.981508028603802, // scaleX
	        1.0118820622255567, // scaleY
	    },
	    
	    // 509. sprite "leg_f", frame 30
	    {
	        322.3, // x
	        -286.5, // y
	        0, // rotation
	        0.9872188489748345, // scaleX
	        1.0076564735261113, // scaleY
	    },
	    
	    // 510. sprite "leg_f", frame 31
	    {
	        322.3, // x
	        -286.5, // y
	        0, // rotation
	        0.9920301628405394, // scaleX
	        1.0040793662607395, // scaleY
	    },
	    
	    // 511. sprite "leg_f", frame 32
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.995921051444979, // scaleX
	        1.0012134966972543, // scaleY
	    },
	    
	    // 512. sprite "leg_f", frame 33
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 513. sprite "leg_f", frame 34
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 514. sprite "leg_f", frame 35
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 515. sprite "leg_f", frame 36
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 516. sprite "leg_f", frame 37
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 517. sprite "leg_f", frame 38
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 518. sprite "leg_f", frame 39
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 519. sprite "leg_f", frame 40
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 520. sprite "leg_f", frame 41
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 521. sprite "leg_f", frame 42
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 522. sprite "leg_f", frame 43
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 523. sprite "leg_f", frame 44
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 524. sprite "leg_f", frame 45
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 525. sprite "leg_f", frame 46
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 526. sprite "leg_f", frame 47
	    {
	        322.3, // x
	        -286.6, // y
	        0, // rotation
	        0.9988915147881533, // scaleX
	        0.9990170273237804, // scaleY
	    },
	    
	    // 527. sprite "leg_b", frame 2
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        0.9978664957471988, // scaleX
	        1.0017573843516383, // scaleY
	    },
	    
	    // 528. sprite "leg_b", frame 3
	    {
	        379.6, // x
	        -286.55, // y
	        0, // rotation
	        0.9943521447496404, // scaleX
	        1.0046860101829371, // scaleY
	    },
	    
	    // 529. sprite "leg_b", frame 4
	    {
	        379.6, // x
	        -286.5, // y
	        0, // rotation
	        0.9894362371042462, // scaleX
	        1.0087442488348795, // scaleY
	    },
	    
	    // 530. sprite "leg_b", frame 5
	    {
	        379.6, // x
	        -286.45, // y
	        0, // rotation
	        0.9832442853466434, // scaleX
	        1.013869344039652, // scaleY
	    },
	    
	    // 531. sprite "leg_b", frame 6
	    {
	        379.6, // x
	        -286.25, // y
	        0, // rotation
	        0.9759436395243346, // scaleX
	        1.0199357832616278, // scaleY
	    },
	    
	    // 532. sprite "leg_b", frame 7
	    {
	        379.6, // x
	        -286.1, // y
	        0, // rotation
	        0.9677225684407607, // scaleX
	        1.0267343789414283, // scaleY
	    },
	    
	    // 533. sprite "leg_b", frame 8
	    {
	        379.6, // x
	        -286, // y
	        0, // rotation
	        0.958894853434989, // scaleX
	        1.0340559435196748, // scaleY
	    },
	    
	    // 534. sprite "leg_b", frame 9
	    {
	        379.6, // x
	        -285.85, // y
	        0, // rotation
	        0.9497324383342118, // scaleX
	        1.0416285331691757, // scaleY
	    },
	    
	    // 535. sprite "leg_b", frame 10
	    {
	        379.6, // x
	        -285.7, // y
	        0, // rotation
	        0.9406118607453103, // scaleX
	        1.0492011228186764, // scaleY
	    },
	    
	    // 536. sprite "leg_b", frame 11
	    {
	        379.6, // x
	        -285.55, // y
	        0, // rotation
	        0.9317841457395387, // scaleX
	        1.0565017686409852, // scaleY
	    },
	    
	    // 537. sprite "leg_b", frame 12
	    {
	        379.65, // x
	        -285.4, // y
	        0, // rotation
	        0.9235421559000268, // scaleX
	        1.0633212830767234, // scaleY
	    },
	    
	    // 538. sprite "leg_b", frame 13
	    {
	        379.6, // x
	        -285.3, // y
	        0, // rotation
	        0.9160950787861531, // scaleX
	        1.0694923160783885, // scaleY
	    },
	    
	    // 539. sprite "leg_b", frame 14
	    {
	        379.6, // x
	        -285.2, // y
	        0, // rotation
	        0.9095684269335447, // scaleX
	        1.074910273866291, // scaleY
	    },
	    
	    // 540. sprite "leg_b", frame 15
	    {
	        379.6, // x
	        -285.1, // y
	        0, // rotation
	        0.9040458753659529, // scaleX
	        1.0794914814166796, // scaleY
	    },
	    
	    // 541. sprite "leg_b", frame 16
	    {
	        379.6, // x
	        -285.05, // y
	        0, // rotation
	        0.8995901803511914, // scaleX
	        1.0831731824617405, // scaleY
	    },
	    
	    // 542. sprite "leg_b", frame 17
	    {
	        379.6, // x
	        -285, // y
	        0, // rotation
	        0.8962013418892602, // scaleX
	        1.0859762957574122, // scaleY
	    },
	    
	    // 543. sprite "leg_b", frame 18
	    {
	        379.6, // x
	        -285.05, // y
	        0, // rotation
	        0.8983350549949206, // scaleX
	        1.084219120258633, // scaleY
	    },
	    
	    // 544. sprite "leg_b", frame 19
	    {
	        379.6, // x
	        -285.1, // y
	        0, // rotation
	        0.901849405992479, // scaleX
	        1.0812904944273343, // scaleY
	    },
	    
	    // 545. sprite "leg_b", frame 20
	    {
	        379.55, // x
	        -285.15, // y
	        0, // rotation
	        0.9067653136378732, // scaleX
	        1.077232255775392, // scaleY
	    },
	    
	    // 546. sprite "leg_b", frame 21
	    {
	        379.6, // x
	        -285.25, // y
	        0, // rotation
	        0.912957265395476, // scaleX
	        1.0721071605706194, // scaleY
	    },
	    
	    // 547. sprite "leg_b", frame 22
	    {
	        379.6, // x
	        -285.4, // y
	        0, // rotation
	        0.9202579112177848, // scaleX
	        1.0660407213486436, // scaleY
	    },
	    
	    // 548. sprite "leg_b", frame 23
	    {
	        379.55, // x
	        -285.55, // y
	        0, // rotation
	        0.9284789823013588, // scaleX
	        1.0592212069129052, // scaleY
	    },
	    
	    // 549. sprite "leg_b", frame 24
	    {
	        379.6, // x
	        -285.65, // y
	        0, // rotation
	        0.9373066973071305, // scaleX
	        1.0519205610905966, // scaleY
	    },
	    
	    // 550. sprite "leg_b", frame 25
	    {
	        379.6, // x
	        -285.85, // y
	        0, // rotation
	        0.9464691124079077, // scaleX
	        1.0443479714410957, // scaleY
	    },
	    
	    // 551. sprite "leg_b", frame 26
	    {
	        379.6, // x
	        -286, // y
	        0, // rotation
	        0.955589689996809, // scaleX
	        1.036775381791595, // scaleY
	    },
	    
	    // 552. sprite "leg_b", frame 27
	    {
	        379.6, // x
	        -286.15, // y
	        0, // rotation
	        0.9644174050025807, // scaleX
	        1.0294747359692862, // scaleY
	    },
	    
	    // 553. sprite "leg_b", frame 28
	    {
	        379.6, // x
	        -286.3, // y
	        0, // rotation
	        0.9726593948420926, // scaleX
	        1.0226343027776101, // scaleY
	    },
	    
	    // 554. sprite "leg_b", frame 29
	    {
	        379.6, // x
	        -286.35, // y
	        0, // rotation
	        0.9801064719559663, // scaleX
	        1.016484188531883, // scaleY
	    },
	    
	    // 555. sprite "leg_b", frame 30
	    {
	        379.6, // x
	        -286.5, // y
	        0, // rotation
	        0.9866331238085747, // scaleX
	        1.0110662307439806, // scaleY
	    },
	    
	    // 556. sprite "leg_b", frame 31
	    {
	        379.6, // x
	        -286.6, // y
	        0, // rotation
	        0.9921556753761664, // scaleX
	        1.006485023193592, // scaleY
	    },
	    
	    // 557. sprite "leg_b", frame 32
	    {
	        379.6, // x
	        -286.6, // y
	        0, // rotation
	        0.996611370390928, // scaleX
	        1.002782403392593, // scaleY
	    },
	    
	    // 558. sprite "leg_b", frame 33
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 559. sprite "leg_b", frame 34
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 560. sprite "leg_b", frame 35
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 561. sprite "leg_b", frame 36
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 562. sprite "leg_b", frame 37
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 563. sprite "leg_b", frame 38
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 564. sprite "leg_b", frame 39
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 565. sprite "leg_b", frame 40
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 566. sprite "leg_b", frame 41
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 567. sprite "leg_b", frame 42
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 568. sprite "leg_b", frame 43
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 569. sprite "leg_b", frame 44
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 570. sprite "leg_b", frame 45
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 571. sprite "leg_b", frame 46
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    // 572. sprite "leg_b", frame 47
	    {
	        379.6, // x
	        -286.65, // y
	        0, // rotation
	        1.0000002088528592, // scaleX
	        1.0000002088528592, // scaleY
	    },
	    
	    
	    //PENGUIN
	    // 573. sprite "leg_back", frame 1
		{
			7.100000000000023, // x
			6.550000000000011, // y
			0.5004527099322021, // rotation
			0.9983837298503534, // scaleX
			0.9983837298503534, // scaleY
		},
	    
		// 574. sprite "leg_back", frame 2
		{
			1.3000000000000114, // x
			4.150000000000006, // y
			0.8230384832963011, // rotation
			0.9509671117393682, // scaleX
			0.9957867359608534, // scaleY
		},
	    
		// 575. sprite "leg_back", frame 3
		{
			-5.399999999999977, // x
			1.5, // y
			1.1895983725797885, // rotation
			0.9007965838544876, // scaleX
			0.9963700867199176, // scaleY
		},
	    
		// 576. sprite "leg_back", frame 4
		{
			-7.550000000000011, // x
			3.8000000000000114, // y
			1.1638421427293053, // rotation
			0.7844642359539179, // scaleX
			0.9963208783414206, // scaleY
		},
	    
		// 577. sprite "leg_back", frame 5
		{
			-9.899999999999977, // x
			6.300000000000011, // y
			1.1328602581878684, // rotation
			0.6591440830505105, // scaleX
			0.9987335223728196, // scaleY
		},
	    
		// 578. sprite "leg_back", frame 6
		{
			-4.899999999999977, // x
			8.300000000000011, // y
			0.7179810393504193, // rotation
			0.663708267328341, // scaleX
			0.9960396991585143, // scaleY
		},
	    
		// 579. sprite "leg_back", frame 7
		{
			5, // x
			12.300000000000011, // y
			-0.08807419935833752, // rotation
			0.6758526534535138, // scaleX
			0.9955898155527216, // scaleY
		},
	    
		// 580. sprite "leg_back", frame 8
		{
			6.850000000000023, // x
			10.550000000000011, // y
			-0.18408009139125803, // rotation
			0.715565897920871, // scaleX
			0.994368529380381, // scaleY
		},
	    
		// 581. sprite "leg_back", frame 9
		{
			9.949999999999989, // x
			7.75, // y
			-0.3412132536086583, // rotation
			0.7796093011511617, // scaleX
			0.9939152996453415, // scaleY
		},
	    
		// 582. sprite "body", frame 1
		{
			9.800000000000011, // x
			56.75, // y
			0.26262044036322085, // rotation
			0.9998602042980665, // scaleX
			0.8698785677565223, // scaleY
		},
	    
		// 583. sprite "body", frame 2
		{
			19.25, // x
			66.05000000000001, // y
			0.27163444170481205, // rotation
			0.9041860989688852, // scaleX
			0.9817928557641119, // scaleY
		},
	    
		// 584. sprite "body", frame 3
		{
			24.05000000000001, // x
			67.44999999999999, // y
			0.29271895437107837, // rotation
			0.9134579731858615, // scaleX
			0.9906763034917296, // scaleY
		},
	    
		// 585. sprite "body", frame 4
		{
			29.80000000000001, // x
			68.9, // y
			0.31649086289334366, // rotation
			0.9257375736033867, // scaleX
			1.0027835781538603, // scaleY
		},
	    
		// 586. sprite "body", frame 5
		{
			23.350000000000023, // x
			81.45, // y
			0.08568134911890131, // rotation
			0.9681971433952714, // scaleX
			1.0480509159072082, // scaleY
		},
	    
		// 587. sprite "body", frame 6
		{
			16.94999999999999, // x
			81.35, // y
			0.048500158191978046, // rotation
			0.9645286831840159, // scaleX
			1.0417393824161358, // scaleY
		},
	    
		// 588. sprite "body", frame 7
		{
			2.6999999999999886, // x
			80.55, // y
			-0.03098055296089178, // rotation
			0.9566815687471962, // scaleX
			1.0279129754176959, // scaleY
		},
	    
		// 589. sprite "body", frame 8
		{
			0.8500000000000227, // x
			77.75, // y
			-0.083318059967565, // rotation
			0.9732703307293381, // scaleX
			1.016693829394918, // scaleY
		},
	    
		// 590. sprite "body", frame 9
		{
			7.199999999999989, // x
			73.6, // y
			-0.02569018345544937, // rotation
			1.0002233063369481, // scaleX
			0.9989717145947127, // scaleY
		},
	    
		// 591. sprite "wing", frame 1
		{
			1.8500000000000227, // x
			54.19999999999999, // y
			0.09772549514878466, // rotation
			0.9996729559055036, // scaleX
			0.5598142588964858, // scaleY
		},
	    
		// 592. sprite "wing", frame 2
		{
			13.350000000000023, // x
			64.65, // y
			0.08824064692646746, // rotation
			0.9989422741182071, // scaleX
			0.5343042349196898, // scaleY
		},
	    
		// 593. sprite "wing", frame 3
		{
			18.19999999999999, // x
			67.94999999999999, // y
			0.07506918480715356, // rotation
			0.9980963189191417, // scaleX
			0.4902106733880745, // scaleY
		},
	    
		// 594. sprite "wing", frame 4
		{
			23.600000000000023, // x
			71.85, // y
			0.06570124935669083, // rotation
			0.9976667733195681, // scaleX
			0.44034148916957216, // scaleY
		},
	    
		// 595. sprite "wing", frame 5
		{
			15.550000000000011, // x
			85.5, // y
			-0.2257455129616567, // rotation
			0.9979461393496394, // scaleX
			0.36931638878992706, // scaleY
		},
	    
		// 596. sprite "wing", frame 6
		{
			9.350000000000023, // x
			84.8, // y
			-0.2453663522928155, // rotation
			0.9968697545158713, // scaleX
			0.37523523356104965, // scaleY
		},
	    
		// 597. sprite "wing", frame 7
		{
			-4.399999999999977, // x
			82.95, // y
			-0.2976495308132511, // rotation
			0.9969646652884907, // scaleX
			0.3896461650476183, // scaleY
		},
	    
		// 598. sprite "wing", frame 8
		{
			-5.100000000000023, // x
			76.55, // y
			-0.24114044827507775, // rotation
			0.995885214761775, // scaleX
			0.5273568032556533, // scaleY
		},
	    
		// 599. sprite "wing", frame 9
		{
			1.6499999999999773, // x
			67.19999999999999, // y
			-0.012709936302403165, // rotation
			0.9956858240274804, // scaleX
			0.7492823012015741, // scaleY
		},
	    
		// 600. sprite "eye", frame 1
		{
			31.649999999999977, // x
			89.85, // y
			0.28257497377896656, // rotation
			0.9990632472491879, // scaleX
			0.8837866822626929, // scaleY
		},
	    
		// 601. sprite "eye", frame 2
		{
			40.94999999999999, // x
			104.2, // y
			0.29312455380509744, // rotation
			0.997725890163816, // scaleX
			0.8979180774246391, // scaleY
		},
	    
		// 602. sprite "eye", frame 3
		{
			46.39999999999998, // x
			105.15, // y
			0.31121753761887777, // rotation
			0.9964121178868035, // scaleX
			0.9234263407580382, // scaleY
		},
	    
		// 603. sprite "eye", frame 4
		{
			52.55000000000001, // x
			106.15, // y
			0.33806619614851163, // rotation
			0.9969815920887889, // scaleX
			0.9542575854297239, // scaleY
		},
	    
		// 604. sprite "eye", frame 5
		{
			39.05000000000001, // x
			124.15, // y
			0.10707185899441775, // rotation
			0.9973040466979647, // scaleX
			0.9980875724783046, // scaleY
		},
	    
		// 605. sprite "eye", frame 6
		{
			30.94999999999999, // x
			124.2, // y
			0.06141569053053532, // rotation
			1.000436434396098, // scaleX
			0.9779801817991255, // scaleY
		},
	    
		// 606. sprite "eye", frame 7
		{
			12.75, // x
			124.3, // y
			-0.03921025336145464, // rotation
			1.008251638808232, // scaleX
			0.9329370943602882, // scaleY
		},
	    
		// 607. sprite "eye", frame 8
		{
			7.949999999999989, // x
			122.75, // y
			-0.1579147999973385, // rotation
			1.0041630316573262, // scaleX
			0.8975653433283963, // scaleY
		},
	    
		// 608. sprite "eye", frame 9
		{
			16.600000000000023, // x
			119.55, // y
			-0.20943791234266548, // rotation
			0.9984734174533653, // scaleX
			0.841604527782281, // scaleY
		},
	    
		// 609. sprite "beak", frame 1
		{
			48.39999999999998, // x
			69.94999999999999, // y
			0.20208332667630266, // rotation
			0.9993396289656089, // scaleX
			0.9993396289656089, // scaleY
		},
	    
		// 610. sprite "beak", frame 2
		{
			54.35000000000002, // x
			82.35, // y
			0.21409045476703392, // rotation
			0.9983305137294952, // scaleX
			0.9983305137294952, // scaleY
		},
	    
		// 611. sprite "beak", frame 3
		{
			60, // x
			83.3, // y
			0.23243137887830065, // rotation
			0.9974181647753482, // scaleX
			0.9974181647753482, // scaleY
		},
	    
		// 612. sprite "beak", frame 4
		{
			66.39999999999998, // x
			84.4, // y
			0.259230502611659, // rotation
			0.9979257287304066, // scaleX
			0.9979257287304066, // scaleY
		},
	    
		// 613. sprite "beak", frame 5
		{
			58.10000000000002, // x
			106.3, // y
			0.02826705812621004, // rotation
			0.9983540588767303, // scaleX
			0.9983540588767303, // scaleY
		},
	    
		// 614. sprite "beak", frame 6
		{
			50.55000000000001, // x
			107.1, // y
			-0.009124522526829486, // rotation
			0.9981952538743123, // scaleX
			0.9981952538743123, // scaleY
		},
	    
		// 615. sprite "beak", frame 7
		{
			33.35000000000002, // x
			108.8, // y
			-0.09766504139203988, // rotation
			0.9979346096945351, // scaleX
			0.9979346096945351, // scaleY
		},
	    
		// 616. sprite "beak", frame 8
		{
			29.19999999999999, // x
			108.1, // y
			-0.17999187280187737, // rotation
			0.9967535138656971, // scaleX
			0.9967535138656971, // scaleY
		},
	    
		// 617. sprite "beak", frame 9
		{
			36.64999999999998, // x
			103.15, // y
			-0.17490630038426205, // rotation
			0.9959236042946674, // scaleX
			0.9959236042946674, // scaleY
		},
	    
		// 618. sprite "leg_front", frame 1
		{
			-0.8999999999999773, // x
			2.3499999999999943, // y
			0.49488004535121133, // rotation
			0.9983991593269823, // scaleX
			0.9983991593269823, // scaleY
		},
	    
		// 619. sprite "leg_front", frame 2
		{
			-7.350000000000023, // x
			-1.4000000000000057, // y
			0.8094222732749441, // rotation
			0.9510966935593214, // scaleX
			0.9959843595361296, // scaleY
		},
	    
		// 620. sprite "leg_front", frame 3
		{
			-15, // x
			-4.699999999999989, // y
			1.1639966060725297, // rotation
			0.9010623747647826, // scaleX
			0.9967233861539788, // scaleY
		},
	    
		// 621. sprite "leg_front", frame 4
		{
			-15.800000000000011, // x
			-0.8000000000000114, // y
			1.2254157587124823, // rotation
			0.7851189871682988, // scaleX
			0.9972286889028795, // scaleY
		},
	    
		// 622. sprite "leg_front", frame 5
		{
			-16.649999999999977, // x
			3.3499999999999943, // y
			1.2915457770046759, // rotation
			0.6599811719982838, // scaleX
			0.9999956703883932, // scaleY
		},
	    
		// 623. sprite "leg_front", frame 6
		{
			-9.899999999999977, // x
			4.25, // y
			0.8264209641968108, // rotation
			0.664691271320895, // scaleX
			0.9975285267651635, // scaleY
		},
	    
		// 624. sprite "leg_front", frame 7
		{
			0.5, // x
			8.300000000000011, // y
			-0.08737778273328178, // rotation
			0.6770365777019003, // scaleX
			0.9974747645659872, // scaleY
		},
	    
		// 625. sprite "leg_front", frame 8
		{
			2.75, // x
			7.349999999999994, // y
			-0.17985898106348241, // rotation
			0.7166690673494513, // scaleX
			0.9963126785782517, // scaleY
		},
	    
		// 626. sprite "leg_front", frame 9
		{
			6.199999999999989, // x
			6.050000000000011, // y
			-0.3326780886310633, // rotation
			0.7805119595699793, // scaleX
			0.9959968581712402, // scaleY
	        
		},
	    
	    // 627. sprite "cannon_back", frame 1
		{
			-43.75, // x
			23.30000000000001, // y
			-0.881045593947644, // rotation
			0.9976337311670699, // scaleX
			0.9976337311670699, // scaleY
		},
	    
		// 628. sprite "cannon_back", frame 2
		{
			-42.44999999999999, // x
			24.30000000000001, // y
			-0.8835204695486548, // rotation
			0.9834219643024005, // scaleX
			1.260429458499477, // scaleY
		},
	    
		// 629. sprite "cannon_back", frame 3
		{
			-41.30000000000001, // x
			25.19999999999999, // y
			-0.8837849214448995, // rotation
			0.9711309614833649, // scaleX
			1.518928469564148, // scaleY
		},
	    
		// 630. sprite "cannon_back", frame 4
		{
			-40.650000000000006, // x
			25.75, // y
			-0.8837939761926059, // rotation
			0.9663501887648057, // scaleX
			1.6552549154376237, // scaleY
		},
	    
		// 631. sprite "cannon_back", frame 5
		{
			-49.900000000000006, // x
			25.19999999999999, // y
			-0.8791238569050429, // rotation
			0.8942715584644482, // scaleX
			1.3310010632301508, // scaleY
		},
	    
		// 632. sprite "cannon_back", frame 6
		{
			-59, // x
			24.75, // y
			-0.8710414293127614, // rotation
			0.8241188693036325, // scaleX
			1.011210011400104, // scaleY
		},
	    
		// 633. sprite "cannon_back", frame 7
		{
			-65.94999999999999, // x
			24.399999999999977, // y
			-0.8670986193188992, // rotation
			0.7727926853951278, // scaleX
			0.7727926853951278, // scaleY
		},
	    
		// 634. sprite "cannon_back", frame 8
		{
			-57.55000000000001, // x
			24, // y
			-0.8712379706012092, // rotation
			0.856350390003255, // scaleX
			0.856350390003255, // scaleY
		},
	    
		// 635. sprite "cannon_back", frame 9
		{
			-49.25, // x
			23.5, // y
			-0.8791148021573366, // rotation
			0.9406639990155686, // scaleX
			0.9406639990155686, // scaleY
		},
	    
		// 636. sprite "cannon_back", frame 10
		{
			-43.75, // x
			23.30000000000001, // y
			-0.881045593947644, // rotation
			0.9976337311670699, // scaleX
			0.9976337311670699, // scaleY
		},
	    
		// 637. sprite "cannon_body", frame 1
		{
			31.05000000000001, // x
			113.94999999999999, // y
			-0.881045593947644, // rotation
			0.9976337311670699, // scaleX
			0.9976337311670699, // scaleY
		},
	    
		// 638. sprite "cannon_body", frame 2
		{
			22, // x
			102.94999999999999, // y
			-0.883529524296361, // rotation
			0.8558700452585134, // scaleX
			1.102649116429523, // scaleY
		},
	    
		// 639. sprite "cannon_body", frame 3
		{
			13.349999999999994, // x
			92.30000000000001, // y
			-0.8837849214448995, // rotation
			0.7188046712529683, // scaleX
			1.2068818295569623, // scaleY
		},
	    
		// 640. sprite "cannon_body", frame 4
		{
			8.800000000000011, // x
			86.94999999999999, // y
			-0.8838123520041274, // rotation
			0.6490052610825924, // scaleX
			1.262823165227632, // scaleY
		},
	    
		// 641. sprite "cannon_body", frame 5
		{
			13.800000000000011, // x
			102.89999999999998, // y
			-0.8791329116527493, // rotation
			0.8587260072876252, // scaleX
			1.0813439447641906, // scaleY
		},
	    
		// 642. sprite "cannon_body", frame 6
		{
			19.30000000000001, // x
			118.25, // y
			-0.8710592724920649, // rotation
			1.0683640798337857, // scaleX
			0.9028906234546219, // scaleY
		},
	    
		// 643. sprite "cannon_body", frame 7
		{
			23.69999999999999, // x
			129.95, // y
			-0.8670719877079983, // rotation
			1.2274695349610023, // scaleX
			0.770389535870714, // scaleY
		},
	    
		// 644. sprite "cannon_body", frame 8
		{
			26.399999999999977, // x
			123.69999999999999, // y
			-0.8712201274219058, // rotation
			1.1387808399589248, // scaleX
			0.8548343082548733, // scaleY
		},
	    
		// 645. sprite "cannon_body", frame 9
		{
			28.94999999999999, // x
			117.85000000000002, // y
			-0.8790966926619241, // rotation
			1.0526205318243993, // scaleX
			0.9400798789736897, // scaleY
		},
	    
		// 646. sprite "cannon_body", frame 10
		{
			31.05000000000001, // x
			113.94999999999999, // y
			-0.881045593947644, // rotation
			0.9976337311670699, // scaleX
			0.9976337311670699, // scaleY
		},
	    
		// 647. sprite "cannon_front", frame 1
		{
			99.30000000000001, // x
			196.7, // y
			-0.881045593947644, // rotation
			0.9976337311670699, // scaleX
			0.9976337311670699, // scaleY
		},
	    
		// 648. sprite "cannon_front", frame 2
		{
			82.44999999999999, // x
			176.25, // y
			-0.883529524296361, // rotation
			0.9959670313471743, // scaleX
			1.0609523992833585, // scaleY
		},
	    
		// 649. sprite "cannon_front", frame 3
		{
			65.85000000000002, // x
			156.35, // y
			-0.8838214067518336, // rotation
			0.9959301313955673, // scaleX
			1.1243731086772633, // scaleY
		},
	    
		// 650. sprite "cannon_front", frame 4
		{
			57.30000000000001, // x
			145.95, // y
			-0.8837849214448995, // rotation
			0.9975201889474579, // scaleX
			1.1590753012579176, // scaleY
		},
	    
		// 651. sprite "cannon_front", frame 5
		{
			75.85000000000002, // x
			176.5, // y
			-0.8791510211481618, // rotation
			0.9959693607799391, // scaleX
			0.9907998733641928, // scaleY
		},
	    
		// 652. sprite "cannon_front", frame 6
		{
			94.25, // x
			206.8, // y
			-0.8710414293127614, // rotation
			0.995990827329379, // scaleX
			0.8252676036307753, // scaleY
		},
	    
		// 653. sprite "cannon_front", frame 7
		{
			108.14999999999998, // x
			229.45, // y
			-0.8670719877079983, // rotation
			0.9976401709970689, // scaleX
			0.7023828061272321, // scaleY
		},
	    
		// 654. sprite "cannon_front", frame 8
		{
			104.80000000000001, // x
			217.05, // y
			-0.8712201274219058, // rotation
			0.9960056088289764, // scaleX
			0.8125990167676779, // scaleY
		},
	    
		// 655. sprite "cannon_front", frame 9
		{
			101.5, // x
			204.75, // y
			-0.8790966926619241, // rotation
			0.9960082906873309, // scaleX
			0.9233346846399558, // scaleY
		},
	    
		// 656. sprite "cannon_front", frame 10
		{
			99.30000000000001, // x
			196.7, // y
			-0.881045593947644, // rotation
			0.9976337311670699, // scaleX
			0.9976337311670699, // scaleY
		},
	    
		// 657. sprite "cannon_wood", frame 1
		{
			0, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 658. sprite "cannon_wood", frame 2
		{
			0, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 659. sprite "cannon_wood", frame 3
		{
			0, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 660. sprite "cannon_wood", frame 4
		{
			0, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 661. sprite "cannon_wood", frame 5
		{
			-6.75, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 662. sprite "cannon_wood", frame 6
		{
			-13.300000000000011, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 663. sprite "cannon_wood", frame 7
		{
			-17, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 664. sprite "cannon_wood", frame 8
		{
			-10.349999999999994, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 665. sprite "cannon_wood", frame 9
		{
			-3.8499999999999943, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
		},
	    
		// 666. sprite "cannon_wood", frame 10
		{
			0, // x
			58, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999114990234375, // scaleY
	        
		},
	    
	    
	    //NEW ADD
	    // 667. sprite "instance60", frame 1
		{
			0.04999999999999716, // x
			-0.09999999999999432, // y
			0, // rotation
			0.99908447265625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 668. sprite "instance60", frame 2
		{
			0.04999999999999716, // x
			-2.9000000000000057, // y
			0, // rotation
			0.9800872802734375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 669. sprite "instance60", frame 3
		{
			0.04999999999999716, // x
			-5.900000000000006, // y
			0, // rotation
			0.9599761962890625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 670. sprite "instance60", frame 4
		{
			0.04999999999999716, // x
			-9, // y
			0, // rotation
			0.93902587890625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 671. sprite "instance60", frame 5
		{
			0.04999999999999716, // x
			-12.150000000000006, // y
			0, // rotation
			0.91754150390625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 672. sprite "instance60", frame 6
		{
			0, // x
			-15.349999999999994, // y
			0, // rotation
			0.8958740234375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 673. sprite "instance60", frame 7
		{
			0.04999999999999716, // x
			-18.549999999999997, // y
			0, // rotation
			0.874359130859375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 674. sprite "instance60", frame 8
		{
			0.04999999999999716, // x
			-21.650000000000006, // y
			0, // rotation
			0.853363037109375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 675. sprite "instance60", frame 9
		{
			0.04999999999999716, // x
			-24.650000000000006, // y
			0, // rotation
			0.833160400390625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 676. sprite "instance60", frame 10
		{
			0, // x
			-27.450000000000003, // y
			0, // rotation
			0.8140716552734375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 677. sprite "instance60", frame 11
		{
			0.04999999999999716, // x
			-30.099999999999994, // y
			0, // rotation
			0.79632568359375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 678. sprite "instance60", frame 12
		{
			0, // x
			-32.5, // y
			0, // rotation
			0.7801361083984375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 679. sprite "instance60", frame 13
		{
			0, // x
			-34.650000000000006, // y
			0, // rotation
			0.7656402587890625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 680. sprite "instance60", frame 14
		{
			0.04999999999999716, // x
			-36.5, // y
			0, // rotation
			0.7529754638671875, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 681. sprite "instance60", frame 15
		{
			0, // x
			-38.099999999999994, // y
			0, // rotation
			0.7422027587890625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 682. sprite "instance60", frame 16
		{
			0, // x
			-35.44999999999999, // y
			0, // rotation
			0.760009765625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 683. sprite "instance60", frame 17
		{
			0, // x
			-32.599999999999994, // y
			0, // rotation
			0.7791900634765625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 684. sprite "instance60", frame 18
		{
			0, // x
			-29.599999999999994, // y
			0, // rotation
			0.799407958984375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 685. sprite "instance60", frame 19
		{
			0, // x
			-26.5, // y
			0, // rotation
			0.8203277587890625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 686. sprite "instance60", frame 20
		{
			0, // x
			-23.349999999999994, // y
			0, // rotation
			0.8415985107421875, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 687. sprite "instance60", frame 21
		{
			0, // x
			-20.200000000000003, // y
			0, // rotation
			0.862762451171875, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 688. sprite "instance60", frame 22
		{
			-0.04999999999999716, // x
			-17.150000000000006, // y
			0, // rotation
			0.8834228515625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 689. sprite "instance60", frame 23
		{
			-0.04999999999999716, // x
			-14.200000000000003, // y
			0, // rotation
			0.9032135009765625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 690. sprite "instance60", frame 24
		{
			-0.04999999999999716, // x
			-11.450000000000003, // y
			0, // rotation
			0.92181396484375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 691. sprite "instance60", frame 25
		{
			-0.04999999999999716, // x
			-8.900000000000006, // y
			0, // rotation
			0.9389495849609375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 692. sprite "instance60", frame 26
		{
			-0.04999999999999716, // x
			-6.599999999999994, // y
			0, // rotation
			0.9544525146484375, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 693. sprite "instance60", frame 27
		{
			-0.04999999999999716, // x
			-4.549999999999997, // y
			0, // rotation
			0.9681549072265625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 694. sprite "instance60", frame 28
		{
			-0.04999999999999716, // x
			-2.799999999999997, // y
			0, // rotation
			0.98004150390625, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 695. sprite "instance60", frame 29
		{
			-0.04999999999999716, // x
			-1.2999999999999972, // y
			0, // rotation
			0.9900360107421875, // scaleX
			0.999359130859375, // scaleY
		},
	    
		// 696. sprite "instance60", frame 30
		{
			0, // x
			-0.09999999999999432, // y
			0, // rotation
			0.9981689453125, // scaleX
			0.999359130859375, // scaleY
		},
	    
	    // 697. sprite "rocket", frame 1
		{
			0, // x
			0.8500000000000227, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 698. sprite "rocket", frame 2
		{
			0, // x
			0.8500000000000227, // y
			0.0008088020230570646, // rotation
			0.9999850682265129, // scaleX
			0.9999850682265129, // scaleY
		},
	    
		// 699. sprite "rocket", frame 3
		{
			0, // x
			0.8500000000000227, // y
			0.004882905858660283, // rotation
			0.9999661450364262, // scaleX
			0.9999661450364262, // scaleY
		},
	    
		// 700. sprite "rocket", frame 4
		{
			0, // x
			0.8999999999999773, // y
			0.009643306307176922, // rotation
			0.9999702075947823, // scaleX
			0.9999702075947823, // scaleY
		},
	    
		// 701. sprite "rocket", frame 5
		{
			-0.05000000000001137, // x
			0.8500000000000227, // y
			0.0044709148380250256, // rotation
			0.9999642181793447, // scaleX
			0.9999642181793447, // scaleY
		},
	    
		// 702. sprite "rocket", frame 6
		{
			0, // x
			0.8500000000000227, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 703. sprite "rocket", frame 7
		{
			0, // x
			0.8500000000000227, // y
			0.0008697884120198792, // rotation
			0.9999698606667272, // scaleX
			0.9999698606667272, // scaleY
		},
	    
		// 704. sprite "rocket", frame 8
		{
			0, // x
			0.8999999999999773, // y
			0.005020058654799364, // rotation
			0.9999668250411113, // scaleX
			0.9999668250411113, // scaleY
		},
	    
		// 705. sprite "rocket", frame 9
		{
			-0.05000000000001137, // x
			0.9499999999999886, // y
			0.009155148879365397, // rotation
			0.9999351015908693, // scaleX
			0.9999351015908693, // scaleY
		},
	    
		// 706. sprite "rocket", frame 10
		{
			0.05000000000001137, // x
			0.8999999999999773, // y
			0.01394564304819993, // rotation
			0.9999446751146785, // scaleX
			0.9999446751146785, // scaleY
		},
	    
		// 707. sprite "rocket", frame 11
		{
			0, // x
			0.8999999999999773, // y
			0.009155148879365397, // rotation
			0.9999198434414014, // scaleX
			0.9999198434414014, // scaleY
		},
	    
		// 708. sprite "rocket", frame 12
		{
			0, // x
			0.8500000000000227, // y
			0.005020058654799364, // rotation
			0.9999668250411113, // scaleX
			0.9999668250411113, // scaleY
		},
	    
		// 709. sprite "rocket", frame 13
		{
			0.05000000000001137, // x
			0.8500000000000227, // y
			0.0008697884120198792, // rotation
			0.9999698606667272, // scaleX
			0.9999698606667272, // scaleY
		},
	    
		// 710. sprite "rocket", frame 14
		{
			0, // x
			0.8500000000000227, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 711. sprite "neck", frame 1
		{
			68.05000000000001, // x
			43.44999999999999, // y
			-1.913160864942796, // rotation
			0.7286280861296182, // scaleX
			0.7286280861296182, // scaleY
		},
	    
		// 712. sprite "neck", frame 2
		{
			68, // x
			42.94999999999999, // y
			-1.8853843610893788, // rotation
			0.7277295408904828, // scaleX
			0.7277295408904828, // scaleY
		},
	    
		// 713. sprite "neck", frame 3
		{
			67.94999999999999, // x
			42.349999999999994, // y
			-1.8554807904733148, // rotation
			0.7275881782696547, // scaleX
			0.7275881782696547, // scaleY
		},
	    
		// 714. sprite "neck", frame 4
		{
			67.85000000000002, // x
			41.849999999999994, // y
			-1.8298129775710221, // rotation
			0.7280524134077322, // scaleX
			0.7280524134077322, // scaleY
		},
	    
		// 715. sprite "neck", frame 5
		{
			67.89999999999998, // x
			42.80000000000001, // y
			-1.8769168404034717, // rotation
			0.7274523390535923, // scaleX
			0.7274523390535923, // scaleY
		},
	    
		// 716. sprite "neck", frame 6
		{
			68.05000000000001, // x
			43.69999999999999, // y
			-1.9256415030753433, // rotation
			0.7282302805146049, // scaleX
			0.7282302805146049, // scaleY
		},
	    
		// 717. sprite "neck", frame 7
		{
			68, // x
			43.099999999999994, // y
			-1.8947517639076232, // rotation
			0.7274761736014299, // scaleX
			0.7274761736014299, // scaleY
		},
	    
		// 718. sprite "neck", frame 8
		{
			68.05000000000001, // x
			42.5, // y
			-1.8644662959912421, // rotation
			0.7275104149036257, // scaleX
			0.7275104149036257, // scaleY
		},
	    
		// 719. sprite "neck", frame 9
		{
			67.94999999999999, // x
			41.94999999999999, // y
			-1.8375246931395648, // rotation
			0.7275235632071124, // scaleX
			0.7275235632071124, // scaleY
		},
	    
		// 720. sprite "neck", frame 10
		{
			67.89999999999998, // x
			41.44999999999999, // y
			-1.8091867949283584, // rotation
			0.7280630928667393, // scaleX
			0.7280630928667393, // scaleY
		},
	    
		// 721. sprite "neck", frame 11
		{
			67.85000000000002, // x
			41.900000000000006, // y
			-1.8334878735592226, // rotation
			0.7276137348871761, // scaleX
			0.7276137348871761, // scaleY
		},
	    
		// 722. sprite "neck", frame 12
		{
			68, // x
			42.44999999999999, // y
			-1.859650235475943, // rotation
			0.7277040246546107, // scaleX
			0.7277040246546107, // scaleY
		},
	    
		// 723. sprite "neck", frame 13
		{
			68.05000000000001, // x
			42.94999999999999, // y
			-1.8858256468820047, // rotation
			0.7277707217533707, // scaleX
			0.7277707217533707, // scaleY
		},
	    
		// 724. sprite "neck", frame 14
		{
			68.05000000000001, // x
			43.44999999999999, // y
			-1.913160864942796, // rotation
			0.7286280861296182, // scaleX
			0.7286280861296182, // scaleY
		},
	    
		// 725. sprite "head", frame 1
		{
			104.55000000000001, // x
			30.150000000000006, // y
			3.088344079174204, // rotation
			0.7292900624094932, // scaleX
			0.7292900624094932, // scaleY
		},
	    
		// 726. sprite "head", frame 2
		{
			104.75, // x
			29.80000000000001, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 727. sprite "head", frame 3
		{
			104.94999999999999, // x
			29.5, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 728. sprite "head", frame 4
		{
			105.05000000000001, // x
			29.150000000000006, // y
			3.088344079174204, // rotation
			0.7292900624094932, // scaleX
			0.7292900624094932, // scaleY
		},
	    
		// 729. sprite "head", frame 5
		{
			104.80000000000001, // x
			29.900000000000006, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 730. sprite "head", frame 6
		{
			104.55000000000001, // x
			30.650000000000006, // y
			3.088344079174204, // rotation
			0.7292900624094932, // scaleX
			0.7292900624094932, // scaleY
		},
	    
		// 731. sprite "head", frame 7
		{
			104.69999999999999, // x
			30, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 732. sprite "head", frame 8
		{
			104.80000000000001, // x
			29.400000000000006, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 733. sprite "head", frame 9
		{
			104.94999999999999, // x
			28.75, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 734. sprite "head", frame 10
		{
			105.05000000000001, // x
			28.150000000000006, // y
			3.088344079174204, // rotation
			0.7292900624094932, // scaleX
			0.7292900624094932, // scaleY
		},
	    
		// 735. sprite "head", frame 11
		{
			104.94999999999999, // x
			28.650000000000006, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 736. sprite "head", frame 12
		{
			104.80000000000001, // x
			29.150000000000006, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 737. sprite "head", frame 13
		{
			104.69999999999999, // x
			29.650000000000006, // y
			3.088998417854036, // rotation
			0.7291575715088137, // scaleX
			0.7291575715088137, // scaleY
		},
	    
		// 738. sprite "head", frame 14
		{
			104.55000000000001, // x
			30.150000000000006, // y
			3.088344079174204, // rotation
			0.7292900624094932, // scaleX
			0.7292900624094932, // scaleY
		},
	    
		// 739. sprite "helmet", frame 1
		{
			104.30000000000001, // x
			70.65, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 740. sprite "helmet", frame 2
		{
			104.44999999999999, // x
			70.30000000000001, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 741. sprite "helmet", frame 3
		{
			104.64999999999998, // x
			69.9, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 742. sprite "helmet", frame 4
		{
			104.80000000000001, // x
			69.55000000000001, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 743. sprite "helmet", frame 5
		{
			104.60000000000002, // x
			70.35, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 744. sprite "helmet", frame 6
		{
			104.35000000000002, // x
			71.15, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 745. sprite "helmet", frame 7
		{
			104.44999999999999, // x
			70.44999999999999, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 746. sprite "helmet", frame 8
		{
			104.5, // x
			69.75, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 747. sprite "helmet", frame 9
		{
			104.60000000000002, // x
			69.05000000000001, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 748. sprite "helmet", frame 10
		{
			104.64999999999998, // x
			68.35, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 749. sprite "helmet", frame 11
		{
			104.55000000000001, // x
			68.9, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 750. sprite "helmet", frame 12
		{
			104.5, // x
			69.5, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 751. sprite "helmet", frame 13
		{
			104.39999999999998, // x
			70.05000000000001, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 752. sprite "helmet", frame 14
		{
			104.30000000000001, // x
			70.65, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 753. sprite "tail", frame 1
		{
			-40.150000000000006, // x
			38.69999999999999, // y
			-3.089257010795883, // rotation
			0.728322727940258, // scaleX
			0.728322727940258, // scaleY
		},
	    
		// 754. sprite "tail", frame 2
		{
			-40.150000000000006, // x
			38.80000000000001, // y
			-3.0804659160375314, // rotation
			0.7281359401904759, // scaleX
			0.7281359401904759, // scaleY
		},
	    
		// 755. sprite "tail", frame 3
		{
			-40.19999999999999, // x
			38.849999999999994, // y
			-3.071699322361208, // rotation
			0.7280956648168571, // scaleX
			0.7280956648168571, // scaleY
		},
	    
		// 756. sprite "tail", frame 4
		{
			-40.150000000000006, // x
			38.94999999999999, // y
			-3.0626099535607683, // rotation
			0.7282533979072258, // scaleX
			0.7282533979072258, // scaleY
		},
	    
		// 757. sprite "tail", frame 5
		{
			-40.150000000000006, // x
			38.5, // y
			-3.1100022367392732, // rotation
			0.7281311355816311, // scaleX
			0.7281311355816311, // scaleY
		},
	    
		// 758. sprite "tail", frame 6
		{
			-40.150000000000006, // x
			38.19999999999999, // y
			3.1319493472826165, // rotation
			0.7281832435340427, // scaleX
			0.7281832435340427, // scaleY
		},
	    
		// 759. sprite "tail", frame 7
		{
			-40.19999999999999, // x
			38.5, // y
			-3.1191203676794865, // rotation
			0.7281348063114023, // scaleX
			0.7281348063114023, // scaleY
		},
	    
		// 760. sprite "tail", frame 8
		{
			-40.099999999999994, // x
			38.80000000000001, // y
			-3.0844041986575403, // rotation
			0.7280425041994495, // scaleX
			0.7280425041994495, // scaleY
		},
	    
		// 761. sprite "tail", frame 9
		{
			-40.099999999999994, // x
			39.05000000000001, // y
			-3.0496590011797124, // rotation
			0.7279433057049555, // scaleX
			0.7279433057049555, // scaleY
		},
	    
		// 762. sprite "tail", frame 10
		{
			-40.150000000000006, // x
			39.349999999999994, // y
			-3.0147143329362383, // rotation
			0.7281423697886305, // scaleX
			0.7281423697886305, // scaleY
		},
	    
		// 763. sprite "tail", frame 11
		{
			-40.150000000000006, // x
			39.099999999999994, // y
			-3.035954107894056, // rotation
			0.7279193481141413, // scaleX
			0.7279193481141413, // scaleY
		},
	    
		// 764. sprite "tail", frame 12
		{
			-40.19999999999999, // x
			39, // y
			-3.053715261836012, // rotation
			0.7280132326233506, // scaleX
			0.7280132326233506, // scaleY
		},
	    
		// 765. sprite "tail", frame 13
		{
			-40.25, // x
			38.900000000000006, // y
			-3.071471622088007, // rotation
			0.7281074046561478, // scaleX
			0.7281074046561478, // scaleY
		},
	    
		// 766. sprite "tail", frame 14
		{
			-40.150000000000006, // x
			38.69999999999999, // y
			-3.089257010795883, // rotation
			0.728322727940258, // scaleX
			0.728322727940258, // scaleY
		},
	    
		// 767. sprite "shell", frame 1
		{
			5.300000000000011, // x
			37.349999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 768. sprite "shell", frame 2
		{
			5.300000000000011, // x
			37, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 769. sprite "shell", frame 3
		{
			5.300000000000011, // x
			36.69999999999999, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 770. sprite "shell", frame 4
		{
			5.300000000000011, // x
			36.349999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 771. sprite "shell", frame 5
		{
			5.300000000000011, // x
			36.849999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 772. sprite "shell", frame 6
		{
			5.300000000000011, // x
			37.349999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 773. sprite "shell", frame 7
		{
			5.300000000000011, // x
			37.099999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 774. sprite "shell", frame 8
		{
			5.300000000000011, // x
			36.849999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 775. sprite "shell", frame 9
		{
			5.300000000000011, // x
			36.599999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 776. sprite "shell", frame 10
		{
			5.300000000000011, // x
			36.349999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 777. sprite "shell", frame 11
		{
			5.300000000000011, // x
			36.599999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 778. sprite "shell", frame 12
		{
			5.300000000000011, // x
			36.849999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 779. sprite "shell", frame 13
		{
			5.300000000000011, // x
			37.099999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 780. sprite "shell", frame 14
		{
			5.300000000000011, // x
			37.349999999999994, // y
			3.141592653589793, // rotation
			0.72943115234375, // scaleX
			0.72943115234375, // scaleY
		},
	    
		// 781. sprite "rope", frame 1
		{
			4.100000000000023, // x
			26.900000000000006, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 782. sprite "rope", frame 2
		{
			4.100000000000023, // x
			26.650000000000006, // y
			0.004425108467275661, // rotation
			0.9999640145616402, // scaleX
			0.99561523474337, // scaleY
		},
	    
		// 783. sprite "rope", frame 3
		{
			4.050000000000011, // x
			26.44999999999999, // y
			0.008849950618442317, // rotation
			0.9999323540071857, // scaleX
			0.9912192514615839, // scaleY
		},
	    
		// 784. sprite "rope", frame 4
		{
			4.100000000000023, // x
			26.150000000000006, // y
			0.013854030306701204, // rotation
			0.9999434023911572, // scaleX
			0.9868805957399089, // scaleY
		},
	    
		// 785. sprite "rope", frame 5
		{
			4.100000000000023, // x
			26.75, // y
			0.005004878636585912, // rotation
			0.9999667485537045, // scaleX
			0.9977695871666481, // scaleY
		},
	    
		// 786. sprite "rope", frame 6
		{
			4.100000000000023, // x
			27.400000000000006, // y
			0, // rotation
			1, // scaleX
			1.008697509765625, // scaleY
		},
	    
		// 787. sprite "rope", frame 7
		{
			4.100000000000023, // x
			27.099999999999994, // y
			0.0008697884120198792, // rotation
			0.9999698606667272, // scaleX
			1.0043338726950595, // scaleY
		},
	    
		// 788. sprite "rope", frame 8
		{
			4.100000000000023, // x
			26.900000000000006, // y
			0.005004878636585912, // rotation
			0.9999667485537045, // scaleX
			0.9999667485537045, // scaleY
		},
	    
		// 789. sprite "rope", frame 9
		{
			4.050000000000011, // x
			26.69999999999999, // y
			0.009139702545042937, // rotation
			0.9999349619998292, // scaleX
			0.9955859703859916, // scaleY
		},
	    
		// 790. sprite "rope", frame 10
		{
			4.100000000000023, // x
			26.400000000000006, // y
			0.013838850288487753, // rotation
			0.9999431910853664, // scaleX
			0.9912448248919421, // scaleY
		},
	    
		// 791. sprite "rope", frame 11
		{
			4.050000000000011, // x
			26.5, // y
			0.009139702545042937, // rotation
			0.9999197038482315, // scaleX
			0.9933887966357644, // scaleY
		},
	    
		// 792. sprite "rope", frame 12
		{
			4.100000000000023, // x
			26.599999999999994, // y
			0.005004878636585912, // rotation
			0.9999667485537045, // scaleX
			0.995617971790788, // scaleY
		},
	    
		// 793. sprite "rope", frame 13
		{
			4.050000000000011, // x
			26.75, // y
			0.0008697884120198792, // rotation
			0.9999698606667272, // scaleX
			0.997803126858456, // scaleY
		},
	    
		// 794. sprite "rope", frame 14
		{
			4.100000000000023, // x
			26.900000000000006, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 795. sprite "leg_f", frame 1
		{
			28.19999999999999, // x
			21.5, // y
			-2.0943700686789484, // rotation
			0.6421457195627653, // scaleX
			0.7287207744781008, // scaleY
		},
	    
		// 796. sprite "leg_f", frame 2
		{
			27.94999999999999, // x
			21.599999999999994, // y
			-2.025788610603337, // rotation
			0.6411739135116334, // scaleX
			0.7276093481023165, // scaleY
		},
	    
		// 797. sprite "leg_f", frame 3
		{
			27.850000000000023, // x
			21.75, // y
			-1.959648472299001, // rotation
			0.6411070031659831, // scaleX
			0.7275483703657925, // scaleY
		},
	    
		// 798. sprite "leg_f", frame 4
		{
			27.55000000000001, // x
			21.849999999999994, // y
			-1.8917043086722458, // rotation
			0.6417057732572589, // scaleX
			0.7282273793588504, // scaleY
		},
	    
		// 799. sprite "leg_f", frame 5
		{
			27.899999999999977, // x
			21.55000000000001, // y
			-2.007906016515673, // rotation
			0.6410685989980345, // scaleX
			0.7274760689442209, // scaleY
		},
	    
		// 800. sprite "leg_f", frame 6
		{
			28.30000000000001, // x
			21.349999999999994, // y
			-2.1241119854168447, // rotation
			0.6420164338272061, // scaleX
			0.728579100701967, // scaleY
		},
	    
		// 801. sprite "leg_f", frame 7
		{
			28.149999999999977, // x
			21.349999999999994, // y
			-2.077744752941911, // rotation
			0.6410818753245644, // scaleX
			0.7275129204732133, // scaleY
		},
	    
		// 802. sprite "leg_f", frame 8
		{
			28.05000000000001, // x
			21.44999999999999, // y
			-2.029831289138077, // rotation
			0.6410884810616898, // scaleX
			0.727514624025178, // scaleY
		},
	    
		// 803. sprite "leg_f", frame 9
		{
			27.899999999999977, // x
			21.55000000000001, // y
			-1.9819380653585283, // rotation
			0.6410850615293839, // scaleX
			0.7275130840118148, // scaleY
		},
	    
		// 804. sprite "leg_f", frame 10
		{
			27.69999999999999, // x
			21.5, // y
			-1.935679756172179, // rotation
			0.6418005841105056, // scaleX
			0.7283312812640566, // scaleY
		},
	    
		// 805. sprite "leg_f", frame 11
		{
			27.80000000000001, // x
			21.5, // y
			-1.9735091605084276, // rotation
			0.6411181581897122, // scaleX
			0.727566685408207, // scaleY
		},
	    
		// 806. sprite "leg_f", frame 12
		{
			27.94999999999999, // x
			21.5, // y
			-2.012954038361918, // rotation
			0.6411751227394201, // scaleX
			0.7275923501411745, // scaleY
		},
	    
		// 807. sprite "leg_f", frame 13
		{
			28.100000000000023, // x
			21.44999999999999, // y
			-2.0524545762821913, // rotation
			0.6411856380227473, // scaleX
			0.7276726979215105, // scaleY
		},
	    
		// 808. sprite "leg_f", frame 14
		{
			28.19999999999999, // x
			21.5, // y
			-2.0943700686789484, // rotation
			0.6421457195627653, // scaleX
			0.7287207744781008, // scaleY
		},
	    
		// 809. sprite "leg_b", frame 1
		{
			-29.69999999999999, // x
			23.05000000000001, // y
			-1.9162306907313305, // rotation
			0.6564378104225282, // scaleX
			0.7286680328359971, // scaleY
		},
	    
		// 810. sprite "leg_b", frame 2
		{
			-29.849999999999994, // x
			23.099999999999994, // y
			-1.8729442030054007, // rotation
			0.6557427500852304, // scaleX
			0.7278938484478775, // scaleY
		},
	    
		// 811. sprite "leg_b", frame 3
		{
			-29.94999999999999, // x
			23.150000000000006, // y
			-1.8330894646601466, // rotation
			0.6557283231436215, // scaleX
			0.727849066216473, // scaleY
		},
	    
		// 812. sprite "leg_b", frame 4
		{
			-30, // x
			23.19999999999999, // y
			-1.792436044303978, // rotation
			0.656171506277431, // scaleX
			0.7283716331138039, // scaleY
		},
	    
		// 813. sprite "leg_b", frame 5
		{
			-29.80000000000001, // x
			23.19999999999999, // y
			-1.8464055364266518, // rotation
			0.655759901760024, // scaleX
			0.7278778204378176, // scaleY
		},
	    
		// 814. sprite "leg_b", frame 6
		{
			-29.75, // x
			23.150000000000006, // y
			-1.9026016975367408, // rotation
			0.6564074525028143, // scaleX
			0.7286451126528903, // scaleY
		},
	    
		// 815. sprite "leg_b", frame 7
		{
			-29.849999999999994, // x
			23.25, // y
			-1.8639349953537716, // rotation
			0.6557354493961586, // scaleX
			0.7278691858138719, // scaleY
		},
	    
		// 816. sprite "leg_b", frame 8
		{
			-30, // x
			23.349999999999994, // y
			-1.8250877308488946, // rotation
			0.6557139276642183, // scaleX
			0.7278566963201254, // scaleY
		},
	    
		// 817. sprite "leg_b", frame 9
		{
			-30.05000000000001, // x
			23.55000000000001, // y
			-1.7894863270806063, // rotation
			0.6557085213773768, // scaleX
			0.7278471008180513, // scaleY
		},
	    
		// 818. sprite "leg_b", frame 10
		{
			-30.150000000000006, // x
			23.5, // y
			-1.7531208623955743, // rotation
			0.6560772316441527, // scaleX
			0.7282611158504388, // scaleY
		},
	    
		// 819. sprite "leg_b", frame 11
		{
			-30.099999999999994, // x
			23.400000000000006, // y
			-1.7936411246972388, // rotation
			0.6557092633219128, // scaleX
			0.7278666699549611, // scaleY
		},
	    
		// 820. sprite "leg_b", frame 12
		{
			-29.94999999999999, // x
			23.19999999999999, // y
			-1.8333597755107898, // rotation
			0.6557276577387089, // scaleX
			0.7278670923575636, // scaleY
		},
	    
		// 821. sprite "leg_b", frame 13
		{
			-29.900000000000006, // x
			23.099999999999994, // y
			-1.8730416747012975, // rotation
			0.6557317806462722, // scaleX
			0.727892905153722, // scaleY
		},
	    
		// 822. sprite "leg_b", frame 14
		{
			-29.69999999999999, // x
			23.05000000000001, // y
			-1.9162306907313305, // rotation
			0.6564378104225282, // scaleX
			0.7286680328359971, // scaleY
		},
	    
		// 823. sprite "glider", frame 1
		{
			28, // x
			151, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 824. sprite "glider", frame 2
		{
			28.350000000000023, // x
			150.65, // y
			-0.0007781756705211533, // rotation
			0.9999850440117641, // scaleX
			0.9999850440117641, // scaleY
		},
	    
		// 825. sprite "glider", frame 3
		{
			28.75, // x
			150.35, // y
			-0.00483709948791092, // rotation
			0.9999659225591896, // scaleX
			0.9999659225591896, // scaleY
		},
	    
		// 826. sprite "glider", frame 4
		{
			29.19999999999999, // x
			150, // y
			-0.009399094435216656, // rotation
			0.999967882941677, // scaleX
			0.999967882941677, // scaleY
		},
	    
		// 827. sprite "glider", frame 5
		{
			28.44999999999999, // x
			150.75, // y
			0.00004580637074936289, // rotation
			0.9999847422586913, // scaleX
			0.9999847422586913, // scaleY
		},
	    
		// 828. sprite "glider", frame 6
		{
			27.75, // x
			151.55, // y
			0.009811085455851914, // rotation
			0.9999565823124228, // scaleX
			0.9999565823124228, // scaleY
		},
	    
		// 829. sprite "glider", frame 7
		{
			28.25, // x
			151, // y
			0.0010072075242679678, // rotation
			0.9999699895423643, // scaleX
			0.9999699895423643, // scaleY
		},
	    
		// 830. sprite "glider", frame 8
		{
			28.5, // x
			150.5, // y
			-0.0004426173731711694, // rotation
			0.9999543215425752, // scaleX
			0.9999543215425752, // scaleY
		},
	    
		// 831. sprite "glider", frame 9
		{
			28.850000000000023, // x
			150, // y
			-0.005172657785260904, // rotation
			0.9999523441360542, // scaleX
			0.9999523441360542, // scaleY
		},
	    
		// 832. sprite "glider", frame 10
		{
			29.30000000000001, // x
			149.45, // y
			-0.013396499231425591, // rotation
			0.9999524219051924, // scaleX
			0.9999524219051924, // scaleY
		},
	    
		// 833. sprite "glider", frame 11
		{
			28.899999999999977, // x
			149.85, // y
			-0.009063536137866672, // rotation
			0.9999342675370271, // scaleX
			0.9999342675370271, // scaleY
		},
	    
		// 834. sprite "glider", frame 12
		{
			28.600000000000023, // x
			150.2, // y
			-0.0049438922476230975, // rotation
			0.999951186329832, // scaleX
			0.999951186329832, // scaleY
		},
	    
		// 835. sprite "glider", frame 13
		{
			28.19999999999999, // x
			150.55, // y
			-0.000839162059483968, // rotation
			0.9999698345889088, // scaleX
			0.9999698345889088, // scaleY
		},
	    
		// 836. sprite "glider", frame 14
		{
			28, // x
			151, // y
			0, // rotation
			1, // scaleX
			1, // scaleY
		},
	    
		// 837. sprite "line", frame 1
		{
			48.39999999999998, // x
			142.6, // y
			0.3978339225965059, // rotation
			0.9988261604410976, // scaleX
			0.9988261604410976, // scaleY
		},
	    
		// 838. sprite "line", frame 2
		{
			48.89999999999998, // x
			142.2, // y
			0.40250617241294095, // rotation
			0.9976199726840478, // scaleX
			1.0008397168146992, // scaleY
		},
	    
		// 839. sprite "line", frame 3
		{
			49.25, // x
			141.85, // y
			0.40727589392527286, // rotation
			0.9975859167518195, // scaleX
			1.004011375261065, // scaleY
		},
	    
		// 840. sprite "line", frame 4
		{
			49.64999999999998, // x
			141.35, // y
			0.4155439438455329, // rotation
			0.9987537062086301, // scaleX
			1.008427537727804, // scaleY
		},
	    
		// 841. sprite "line", frame 5
		{
			49.19999999999999, // x
			142.25, // y
			0.41102642368843145, // rotation
			0.9975938362481842, // scaleX
			1.0069024530458057, // scaleY
		},
	    
		// 842. sprite "line", frame 6
		{
			48.64999999999998, // x
			143.1, // y
			0.4074431404417298, // rotation
			0.9987864665406074, // scaleX
			1.0078226008574394, // scaleY
		},
	    
		// 843. sprite "line", frame 7
		{
			48.89999999999998, // x
			142.4, // y
			0.40727589392527286, // rotation
			0.9975859167518195, // scaleX
			1.0020918968464116, // scaleY
		},
	    
		// 844. sprite "line", frame 8
		{
			49.14999999999998, // x
			141.8, // y
			0.41107755638136095, // rotation
			0.9975640669759837, // scaleX
			0.9975701643944476, // scaleY
		},
	    
		// 845. sprite "line", frame 9
		{
			49.44999999999999, // x
			141.2, // y
			0.41164161390023973, // rotation
			0.9975617228284803, // scaleX
			0.9930454923477808, // scaleY
		},
	    
		// 846. sprite "line", frame 10
		{
			49.64999999999998, // x
			140.6, // y
			0.41610560451943057, // rotation
			0.9987538956195717, // scaleX
			0.989715271405382, // scaleY
		},
	    
		// 847. sprite "line", frame 11
		{
			49.30000000000001, // x
			141.15, // y
			0.4110392068616638, // rotation
			0.9975798483706793, // scaleX
			0.9908015670719484, // scaleY
		},
	    
		// 848. sprite "line", frame 12
		{
			49, // x
			141.65, // y
			0.4065938583701036, // rotation
			0.9976045446927121, // scaleX
			0.9930705147874967, // scaleY
		},
	    
		// 849. sprite "line", frame 13
		{
			48.69999999999999, // x
			142.15, // y
			0.4021703477994819, // rotation
			0.9976408791926267, // scaleX
			0.9953708073967217, // scaleY
		},
	    
		// 850. sprite "line", frame 14
		{
			48.39999999999998, // x
			142.6, // y
			0.3978339225965059, // rotation
			0.9988261604410976, // scaleX
			0.9988261604410976, // scaleY
		},
	};

	public static AnimationData turtleOutAnim = new AnimationData();
	public static AnimationData turtleInAnim = new AnimationData();
	public static AnimationData IdleTurtleAnim = new AnimationData();
	public static AnimationData PenguinJumpAnim = new AnimationData();
	public static AnimationData CannonShootAnim = new AnimationData();
	public static AnimationData ArrowAnim = new AnimationData();
	public static AnimationData RocketAnim = new AnimationData();

	//Mainh
	public static int playTimer;
	public static int playFlightTime;

	public static boolean isClickingRocket;
	public static boolean isClickingAntiClockwise;
	public static boolean isClickingClockwise;
	public static boolean isClickingProtect;
	public static boolean hasApplyedProtect;
	public static int clickingRocketTimer;

	public static boolean isApplyingFuel;
	public static boolean isApplyingProtect;

	public static float characterMass;
	public static float characterIsFacingDirection;
	public static float characterX;
	public static float characterY;
	public static float characterVelocity;
	public static float characterVX;
	public static float characterPreVX;
	public static float character0To180VX;
	public static float characterVY;
	public static float characterAX;
	public static float characterAY;
	public static float character0To180FreeAX;
	public static float character0To180FreeAY;
	public static float characterSuddenVY;
	public static float characterVR;
	public static float characterRotation;
	public static float characterCollideVX;
	public static float characterCollideVY;
	public static float characterCollideVR;
	public static float screenX;
	public static float screenY;
	public static float wholeScale;

	public static float characterLastVY;
	public static float characterLastVX;

	public static float characterCollideAtX;
	public static float characterCollideAtY;
	public static float dragonBallCollideAtX;
	public static float dragonBallCollideAtY;
	public static boolean dragonBall_isCollidingAtDragonBall;

	public static float characterXRealityRatio;
	public static float characterYRealityRatio;
	public static float characterRealX;
	public static float characterRealY;

	public static boolean characterIsMagnet;
	public static float characterMagnetPower;


	public static float upgraded_maxVelocityX;
	public static float upgraded_maxVelocityY;
	public static float upgraded_gravity;
	
	public static final int kCharacterStatus_Flying = 0;
	public static int characterStatus;
	public static int characterFlyingStep;

	public static int characterDetectNumber;
	public static int characterDetectX[] = new int[5];
	public static int characterDetectY[] = new int[5];

	public static float minFloorY;
	public static float startToDeclineY;


	public static boolean isPlayingWithAccelator;

	public static boolean hasFinishedOneRound;

	public static boolean dragonBall_isCollidingOnPillar;
	public static boolean dragonBall_isInHittingRange;

	public static boolean isBeginningHeavyInvincible;
	public static boolean isHeavyInvincible;
	public static boolean isEndingHeavyInvincible;
	public static boolean isEndingRedDueToHeavyInvincible;
	public static int endingHeavyInvincibleTimer;

	//for recoprd
	//float record_continuing_height;
	//float record_cotinuing_attitude;

	public static float record_mission; //MEANINGNESS, just use for easy cal
	public static float record_height;  //VERTICAL, MAX
	public static float record_maxAttitude;
	public static float record_hitted;
	public static float record_coinsCollected;
	public static float record_speed;
	public static boolean record_hasHittedDragonBall[] = new boolean[7];
	public static float record_totalFlightTime;
	public static float record_destroyUseTime;
	public static float record_flyNearFloorTime;
	public static float record_flyStraightTime;

	public static boolean canDisplayTotalFlightTime;
	public static boolean canDisplayDestroyUseTime;
	public static boolean canDisplayFlyNearFloorTime;
	public static boolean canDisplayFlyStraightTime;

	public static boolean isUnderingTotalFlightTime;
	public static boolean isUnderingDestroyUseTime;
	public static boolean isUnderingFlyNearFloorTime;
	public static boolean isUnderingFlyStraightTime;

	public static float timeChosenToDisplay;


	public static boolean spin_pefect;
	public static float recordUse_flyStraightMinSpeed;
	public static boolean recordUse_flyStraightCanFuel;
	public static float recordUse_flyNearFloorMinSpeed;
	public static boolean recordUse_flyNearFloorCanFuel;
	public static float recordUse_maxSpeed;
	public static boolean recordUse_isClickingBtnFromHeavyInvincible;

	public static int recordUse_diamondGotInOneRound;
	public static int recordUse_GREENDiamondGotInOneRound;
	public static int recordUse_PURPLEDiamondGotInOneRound;
	public static int recordUse_diamondGotTotal;
	public static int recordUse_moneyEarnedFromDiamondsInOneRound;
	public static int recordUse_penguinHitInOneRound;
	public static int recordUse_penguinHitInYellowBlaze;
	public static int recordUse_penguinHitTotal;
	public static int recordUse_continuePerfectLaunchTIme;
	public static int recordUse_howmanyDragonBallHitted;
	public static int recordUse_howmanyDragonBallNeedToHit;
	public static int recordUse_targetDragonBall;
	public static int recordUse_moneyGainedTotal;
	public static int recordUse_pantsOfFireTime;
	public static boolean recordUse_hasAppliedFuel;
	public static boolean recordUse_breakWhileInHeavy;

	//ONEUSE
	//boolean oneUse_hardSpin;
	public static boolean oneUse_20Fuel;
	public static boolean oneUse_50Fuel;
	public static boolean oneUse_100Fuel;
	public static boolean oneUse_doubleYellow;
	public static boolean oneUse_superInitBoost;
	public static boolean oneUse_slowCannon;
	public static boolean oneUse_BreakLess;
	public static boolean oneUse_magnetic;

	public static boolean pemanent_fuel1;
	public static boolean pemanent_fuel2;
	public static boolean pemanent_perfectLuanch;
	public static boolean pemanent_magnet1;
	public static boolean pemanent_magnet2;
	public static boolean pemanent_breakless;
	public static boolean pemanent_extraYellow;
	public static boolean pemanent_moneyRatio;

	//LEVEL
	public static int playerGlider;
	public static int playerBoost;
	public static int playerCannon;
	public static int playerHelmet;

	public static int playerFuelAmount;
	public static int playerFuelConsumption;
	public static int playerAirResistance;
	public static int playerMaxSpeed;
	public static int playerAcceleration;
	public static int playerMoneyDensity;
	public static int playerMoneyRatio;
	public static int playerExtraYellow;
	public static int playerLongerYellow;
	public static int playerFasterToRedFrame;

	/*int playerDoubleFuel;
	int playerSpinIncrease;
	int playerMaxYellowObtaion;
	int playerInitRedFrame;*/


	public static float characterFuelRemain;
	public static float characterFuelReduceSpeed;
	public static int characterMaxSpinFlightTime;
	public static int characterMaxBeginHeavyTime;
	public static float characterGainInvincible;
	public static float characterGainInvincibleInterval;
	public static int characterLightInvincibleMax;
	public static int characterLightInvincibleMaxTime;
	public static float characterAirResistanceReduce;
	public static float characterMaxSpeedReduce;
	public static float characterAccelerationReduce;
	public static int moneyGenRadius;
	public static int moneyNumArea;
	public static float moneyExchangeRatio;

	//typedef enum{
	public static final int kTurtleShellColor_Brown = 0;
	public static final int kTurtleShellColor_Red = 1;
	public static final int kTurtleShellColor_Green = 2;
	public static final int kTurtleShellColor_Blue = 3;
	public static final int kTurtleShellColor_BrownOri = 4;
	//}eTurtleShellColor;


	//typedef enum{
	public static final int kTurtlePart_Shadow = 0;
	public static final int kTurtlePart_Neck = 1;
	public static final int kTurtlePart_Head = 2;
	    
	public static final int kTurtlePart_Eye = 3;
	public static final int kTurtlePart_Jaw = 4;
	    
	public static final int kTurtlePart_Tail = 5;
	public static final int kTurtlePart_Shell = 6;
	public static final int kTurtlePart_LeftLeg = 7;
	public static final int kTurtlePart_RightLeg = 8;
	    
	public static final int kTurtlePart_Glide = 9;
	public static final int kTurtlePart_Line = 10;
	public static final int kTurtlePart_Rocket = 11;
	public static final int kTurtlePart_Helmet = 12;
	public static final int kTurtlePart_Rope = 13;
	//}eTurtlePart;

	//typedef enum{
	public static final int kTurtleAniStatus_Normal_Out = 0;
	public static final int kTurtleAniStatus_Normal_In = 1;
	public static final int kTurtleAniStatus_Idle = 2;
	public static final int kTurtleAniStatus_In = 3;
	public static final int kTurtleAniStatus_Out = 4;
	public static final int kTurtleAniStatus_Bombing = 5;
	public static final int kTurtleAniStatus_Shaking = 6;
	public static final int kTurtleAniStatus_Flying = 7;
	public static final int kTurtleAniStatus_Colliding = 8;
	//}eTurtleAniStatus;


	//typedef enum{
	public static final int kTurtleBombOutType_backToOri = 0;
	public static final int kTurtleBombOutType_bombOutOffScreen = 1;
	public static final int kTurtleBombOutType_bombOutOffScreenWithGravity = 2;
	//}eTurtleBombOutType;



	//typedef enum{
	public static final int kBombOutOffScreenDirection_Left = 0;
	public static final int kBombOutOffScreenDirection_Right = 1;
	//}eBombOutOffScreenDirection;

	//typedef enum{
	public static final int kGrade_F = 0;
	public static final int kGrade_E = 1;
	public static final int kGrade_D = 2;
	public static final int kGrade_C = 3;
	public static final int kGrade_B = 4;
	public static final int kGrade_A = 5;
	public static final int kGrade_S = 6;
	public static final int kGrade_SS = 7;
	//}eGrade;


//enum mySoundIds {
	public static final int kSound_TurtleHeadOut = 0;
	public static final int kSound_TurtleExplode01 = 1;
	public static final int kSound_TurtleExplode02 = 2;
	public static final int kSound_TurtleExplode03 = 3;
	public static final int kSound_TimeRunOutSlow = 4;
	public static final int kSound_TimeRunOutMedium = 5;
	public static final int kSound_TimeRunOutFast = 6;
	public static final int kSound_ComboTime = 7;
	public static final int kSound_CrackShell = 8;
	public static final int kSound_ComboSmoke = 9;
	public static final int kSound_GameOver = 10;
	public static final int kSound_TapWrongly = 11;
	public static final int kSound_LoseCombo = 12;
	public static final int kSound_Arrows = 13;
	public static final int kSound_Minesweeper = 14;
	public static final int kSound_MinesweeperV2 = 15;
	public static final int kSound_PenguinJump = 16;
	public static final int kSound_AchivementUnlock = 17;
	public static final int kSound_ButtonTap = 18;
	public static final int kSound_ButtonTap2 = 20;
	public static final int kSound_Reward = 21;
	public static final int kSound_Score = 22;
	public static final int kSound_Score2 = 23;
	public static final int kSound_TurtleCoinsGain = 24;
	public static final int kSound_engine = 25;
	public static final int kSound_MAINCrash01 = 26;
	public static final int kSound_Diamond = 27;
	public static final int kSound_PenguinHit = 28;
	public static final int kSound_PerfectLaunch = 29;
	public static final int kSound_RedFlame = 30;
	public static final int kSound_YellowFlame = 31;
	public static final int kSound_ThurstBoost = 32;
	public static final int kSound_Buy = 33;
	public static final int kSound_PerfectLaunch02 = 34;

	public static int playerSoundIdx = -1;
	//};
	public static MusicController musicController;
	
	//OTHER DATA
	public static int mainOtherData_bestHeight;

	public static float LToD_X(float x)
	{
		return x;
	}
	public static float LToD_Y(float y)
	{
		return y;
	}
	public static float LToD_Size(float size)
	{
		return size;
	}
	
	public static ArrayList<String> componentsSeparatedByString( String srcStr,String sepStr )
	{
		ArrayList<String> arr = new ArrayList<String>();
		String src = srcStr;
		String sep = sepStr;
		String subStr;
		int n1 = 0;
		int n2 = src.indexOf(sep,n1);
		while ( n2 > 0 )
		{
			subStr = src.substring(n1,n2);
			if (subStr != "")
				arr.add(  subStr );
			n1 = n2+1;
			n2 = src.indexOf(sep,n1);
		}
		n2 = src.length();
		subStr = src.substring(n1,n2);
		
		if (subStr != "")
			arr.add( subStr );
	
		return arr;
	}
	
	public static String getResFileName(String path)
	{
		ArrayList<String> arr = componentsSeparatedByString( path,"/" );
		if ( arr.size() > 0 )
			return arr.get( arr.size()-1 );
		return path;
	}
	
	public static String getResPath(String path)
	{
		return path;
	}

	public static ArrayList<CCNode> getAllNodesWith( CCNode node )
	{
		ArrayList<CCNode> resList = new ArrayList<CCNode>();
		resList.add(node);
		List<CCNode> chList = node.getChildren();
		if ( chList != null )
		{
			for ( int i = 0; i < chList.size(); i++ )
			{
				resList.addAll(getAllNodesWith(chList.get(i)));
			}
		}
		
		return resList;
	}
	 
	public static float watchAngle(CGPoint ptStart, CGPoint ptEnd)
	{
		CGPoint ppp = CGPoint.ccp(ptEnd.x - ptStart.x,ptEnd.y - ptStart.y);
		float angle = (float) (Math.atan((float)ppp.y / (float)ppp.x) * 180 / 3.1415927);
	
		if (ppp.x < 0) angle += 180;
		if (ppp.x == 0 && ppp.y > 0) angle = 90;
		if (ppp.x == 0 && ppp.y < 0) angle = 270;
		if (ppp.x > 0 && ppp.y<0) angle +=360;
		if (ppp.x == 0 && ppp.y == 0) angle = 0;
		return angle;
	}
	
	public static float RandomFloat(float lo, float hi)
	{
		float r;
		r = (float) ((hi - lo) * Math.random() + lo);
		return r;
	}
	
	static float S;
	static float T;

	
	static boolean ccpLineIntersect(CGPoint A,CGPoint B, 
            CGPoint C, CGPoint D)
	{
	// FAIL: Line undefined
		if ( (A.x==B.x && A.y==B.y) || (C.x==D.x && C.y==D.y) )
		{
			return false;
		}
		float BAx = B.x - A.x;
		float BAy = B.y - A.y;
		float DCx = D.x - C.x;
		float DCy = D.y - C.y;
		float ACx = A.x - C.x;
		float ACy = A.y - C.y;
		
		float denom = DCy*BAx - DCx*BAy;
		
		S = DCx*ACy - DCy*ACx;
		T = BAx*ACy - BAy*ACx;
		
		if (denom == 0)
		{
		if (S == 0 || T == 0)
		{ 
		  // Lines incident
		  return true;   
		}
		// Lines parallel and not incident
		return false;
		}
		
		S = S / denom;
		T = T / denom;
		
		// Point of intersection
		// CGPoint P;
		// P.x = A.x + *S * (B.x - A.x);
		// P.y = A.y + *S * (B.y - A.y);
		
		return true;
	}
	
	public static boolean ccpSegmentIntersect(CGPoint A, CGPoint B, CGPoint C, CGPoint D)
	{
	    if( ccpLineIntersect(A, B, C, D )
	        && (S >= 0.0f && S <= 1.0f && T >= 0.0f && T <= 1.0f) )
	        return true;

	    return false;
	}
	
	public static CGPoint ccpRotateByAngle(CGPoint v, CGPoint pivot, float angle)
	{
	    CGPoint r = ccpSub(v, pivot);
	    float cosa = (float) Math.cos(angle), sina = (float) Math.sin(angle);
	    float t = r.x;
	    r.x = t*cosa - r.y*sina + pivot.x;
	    r.y = t*sina + r.y*cosa + pivot.y;
	    return r;
	}
	
	static CGPoint	ccpSub(CGPoint v1, CGPoint v2)
	{
	    return CGPoint.ccp(v1.x - v2.x, v1.y - v2.y);
	}


	public static float ccpDistance(CGPoint p1, CGPoint p2) {
		// TODO Auto-generated method stub
		float dis;
		CGPoint pp = ccpSub(p1,p2);
		dis = (float) Math.sqrt( pp.x*pp.x + pp.y*pp.y );
		return dis;
	}
	
	public static void addInfoIcon(CCNode node, CGPoint pos, float scale)
	{
		CCSprite spInfo = CCSprite.sprite(getResPath("images/selectlayers/info.png"));
		spInfo.setScaleX( scale );
		spInfo.setScaleY( scale );
		spInfo.setPosition(pos);
		node.addChild(spInfo,65536);

		float t = 0.2f;
		CCScaleTo sc1 = CCScaleTo.action(t,scale*1.2f);
		CCScaleTo sc2 = CCScaleTo.action(t,scale*1/1.2f);
		CCRotateTo ro1 = CCRotateTo.action(t,30.0f);
		CCRotateTo ro2 = CCRotateTo.action(t,-30.0f);

		CCRepeatForever repeat1 = CCRepeatForever.action( CCSequence.actions(sc1,sc2) );
		CCRepeatForever repeat2 = CCRepeatForever.action( CCSequence.actions(ro1,ro2) );
		spInfo.runAction(repeat1);
		spInfo.runAction(repeat2);
	}
	
	public static void initialize()
	{
		frameData = new FrameData[ frameDataTemp.length ];
		for ( int i = 0; i < frameDataTemp.length; i++ )
		{
			frameData[i] = new FrameData();
			frameData[i].x = (float) frameDataTemp[i][0];
			frameData[i].y = (float) frameDataTemp[i][1];
			frameData[i].rotation = (float) frameDataTemp[i][2];
			frameData[i].scaleX = (float) frameDataTemp[i][3];
			frameData[i].scaleY = (float) frameDataTemp[i][4];
		}
		
		//turtleOutAnim 
		turtleOutAnim.framesCount = 13;
		turtleOutAnim.spritesCount = 7;
		turtleOutAnim.spriteData[0] = new SpriteData();
		turtleOutAnim.spriteData[0].spriteName = "shadow";
		turtleOutAnim.spriteData[0].firstFrame = 0;
		turtleOutAnim.spriteData[0].framesCount = 13;
		turtleOutAnim.spriteData[1] = new SpriteData();
		turtleOutAnim.spriteData[1].spriteName = "neck";
		turtleOutAnim.spriteData[1].firstFrame = 13;
		turtleOutAnim.spriteData[1].framesCount = 13;
		turtleOutAnim.spriteData[2] = new SpriteData();
		turtleOutAnim.spriteData[2].spriteName = "head";
		turtleOutAnim.spriteData[2].firstFrame = 26;
		turtleOutAnim.spriteData[2].framesCount = 13;
		turtleOutAnim.spriteData[3] = new SpriteData();
		turtleOutAnim.spriteData[3].spriteName = "eye";
		turtleOutAnim.spriteData[3].firstFrame = 297;
		turtleOutAnim.spriteData[3].framesCount = 46;
		turtleOutAnim.spriteData[4] = new SpriteData();
		turtleOutAnim.spriteData[4].spriteName = "jaw";
		turtleOutAnim.spriteData[4].firstFrame = 343;
		turtleOutAnim.spriteData[4].framesCount = 46;
		turtleOutAnim.spriteData[5] = new SpriteData();
		turtleOutAnim.spriteData[5].spriteName = "tail";
		turtleOutAnim.spriteData[5].firstFrame = 39;
		turtleOutAnim.spriteData[5].framesCount = 13;
		turtleOutAnim.spriteData[6] = new SpriteData();
		turtleOutAnim.spriteData[6].spriteName = "shell";
		turtleOutAnim.spriteData[6].firstFrame = 52;
		turtleOutAnim.spriteData[6].framesCount = 13;
		turtleOutAnim.spriteData[7] = new SpriteData();
		turtleOutAnim.spriteData[7].spriteName = "leg_f";
		turtleOutAnim.spriteData[7].firstFrame = 65;
		turtleOutAnim.spriteData[7].framesCount = 13;
		turtleOutAnim.spriteData[8] = new SpriteData();
		turtleOutAnim.spriteData[8].spriteName = "leg_b";
		turtleOutAnim.spriteData[8].firstFrame = 78;
		turtleOutAnim.spriteData[8].framesCount = 13;

		//turtleInAnim
		turtleInAnim.framesCount = 13;
		turtleInAnim.spritesCount = 7;
		turtleInAnim.spriteData[0] = new SpriteData();
		turtleInAnim.spriteData[0].spriteName = "shadow";
		turtleInAnim.spriteData[0].firstFrame = 91;
		turtleInAnim.spriteData[0].framesCount = 13;
		turtleInAnim.spriteData[1] = new SpriteData();
		turtleInAnim.spriteData[1].spriteName = "neck";
		turtleInAnim.spriteData[1].firstFrame = 104;
		turtleInAnim.spriteData[1].framesCount = 9;
		turtleInAnim.spriteData[2] = new SpriteData();
		turtleInAnim.spriteData[2].spriteName = "head";
		turtleInAnim.spriteData[2].firstFrame = 113;
		turtleInAnim.spriteData[2].framesCount = 9;
		turtleInAnim.spriteData[3] = new SpriteData();
		turtleInAnim.spriteData[3].spriteName = "eye";
		turtleInAnim.spriteData[3].firstFrame = 297;
		turtleInAnim.spriteData[3].framesCount = 46;
		turtleInAnim.spriteData[4] = new SpriteData();
		turtleInAnim.spriteData[4].spriteName = "jaw";
		turtleInAnim.spriteData[4].firstFrame = 343;
		turtleInAnim.spriteData[4].framesCount = 46;
		turtleInAnim.spriteData[5] = new SpriteData();
		turtleInAnim.spriteData[5].spriteName = "tail";
		turtleInAnim.spriteData[5].firstFrame = 122;
		turtleInAnim.spriteData[5].framesCount = 8;
		turtleInAnim.spriteData[6] = new SpriteData();
		turtleInAnim.spriteData[6].spriteName = "shell";
		turtleInAnim.spriteData[6].firstFrame = 130;
		turtleInAnim.spriteData[6].framesCount = 13;
		turtleInAnim.spriteData[7] = new SpriteData();
		turtleInAnim.spriteData[7].spriteName = "leg_f";
		turtleInAnim.spriteData[7].firstFrame = 143;
		turtleInAnim.spriteData[7].framesCount = 8;
		turtleInAnim.spriteData[8] = new SpriteData();
		turtleInAnim.spriteData[8].spriteName = "leg_b";
		turtleInAnim.spriteData[8].firstFrame = 151;
		turtleInAnim.spriteData[8].framesCount = 8;

		//IdleTurtleAnim 
		IdleTurtleAnim.framesCount = 47;
		IdleTurtleAnim.spritesCount = 9;
		IdleTurtleAnim.spriteData[0] = new SpriteData();
		IdleTurtleAnim.spriteData[0].spriteName = "shadow";
		IdleTurtleAnim.spriteData[0].firstFrame = 159;
		IdleTurtleAnim.spriteData[0].framesCount = 46;
		IdleTurtleAnim.spriteData[1] = new SpriteData();
		IdleTurtleAnim.spriteData[1].spriteName = "neck";
		IdleTurtleAnim.spriteData[1].firstFrame = 205;
		IdleTurtleAnim.spriteData[1].framesCount = 46;
		IdleTurtleAnim.spriteData[2] = new SpriteData();
		IdleTurtleAnim.spriteData[2].spriteName = "head";
		IdleTurtleAnim.spriteData[2].firstFrame = 251;
		IdleTurtleAnim.spriteData[2].framesCount = 46;
		IdleTurtleAnim.spriteData[3] = new SpriteData();
		IdleTurtleAnim.spriteData[3].spriteName = "eye";
		IdleTurtleAnim.spriteData[3].firstFrame = 297;
		IdleTurtleAnim.spriteData[3].framesCount = 46;
		IdleTurtleAnim.spriteData[4] = new SpriteData();
		IdleTurtleAnim.spriteData[4].spriteName = "jaw";
		IdleTurtleAnim.spriteData[4].firstFrame = 343;
		IdleTurtleAnim.spriteData[4].framesCount = 46;
		IdleTurtleAnim.spriteData[5] = new SpriteData();
		IdleTurtleAnim.spriteData[5].spriteName = "tail";
		IdleTurtleAnim.spriteData[5].firstFrame = 389;
		IdleTurtleAnim.spriteData[5].framesCount = 46;
		IdleTurtleAnim.spriteData[6] = new SpriteData();
		IdleTurtleAnim.spriteData[6].spriteName = "shell";
		IdleTurtleAnim.spriteData[6].firstFrame = 435;
		IdleTurtleAnim.spriteData[6].framesCount = 46;
		IdleTurtleAnim.spriteData[7] = new SpriteData();
		IdleTurtleAnim.spriteData[7].spriteName = "leg_f";
		IdleTurtleAnim.spriteData[7].firstFrame = 481;
		IdleTurtleAnim.spriteData[7].framesCount = 46;
		IdleTurtleAnim.spriteData[8] = new SpriteData();
		IdleTurtleAnim.spriteData[8].spriteName = "leg_b";
		IdleTurtleAnim.spriteData[8].firstFrame = 527;
		IdleTurtleAnim.spriteData[8].framesCount = 46;

		//PenguinJumpAnim
		PenguinJumpAnim.framesCount = 9;
		PenguinJumpAnim.spritesCount = 6;    
		PenguinJumpAnim.spriteData[0] = new SpriteData();
		PenguinJumpAnim.spriteData[0].spriteName = "leg_back";
		PenguinJumpAnim.spriteData[0].firstFrame = 573;
		PenguinJumpAnim.spriteData[0].framesCount = 9;
		PenguinJumpAnim.spriteData[1] = new SpriteData();
		PenguinJumpAnim.spriteData[1].spriteName = "body";
		PenguinJumpAnim.spriteData[1].firstFrame = 582;
		PenguinJumpAnim.spriteData[1].framesCount = 9;
		PenguinJumpAnim.spriteData[2] = new SpriteData();
		PenguinJumpAnim.spriteData[2].spriteName = "wing";
		PenguinJumpAnim.spriteData[2].firstFrame = 591;
		PenguinJumpAnim.spriteData[2].framesCount = 9;
		PenguinJumpAnim.spriteData[3] = new SpriteData();
		PenguinJumpAnim.spriteData[3].spriteName = "eye";
		PenguinJumpAnim.spriteData[3].firstFrame = 600;
		PenguinJumpAnim.spriteData[3].framesCount = 9;
		PenguinJumpAnim.spriteData[4] = new SpriteData();
		PenguinJumpAnim.spriteData[4].spriteName = "beak";
		PenguinJumpAnim.spriteData[4].firstFrame = 609;
		PenguinJumpAnim.spriteData[4].framesCount = 9;
		PenguinJumpAnim.spriteData[5] = new SpriteData();
		PenguinJumpAnim.spriteData[5].spriteName = "leg_front";
		PenguinJumpAnim.spriteData[5].firstFrame = 618;
		PenguinJumpAnim.spriteData[5].framesCount = 9;

		//CannonShootAnim 
		CannonShootAnim.framesCount = 10;
		CannonShootAnim.spritesCount = 4;
		CannonShootAnim.spriteData[0] = new SpriteData();
		CannonShootAnim.spriteData[0].spriteName = "cannon_back";
		CannonShootAnim.spriteData[0].firstFrame = 627;
		CannonShootAnim.spriteData[0].framesCount = 10;
		CannonShootAnim.spriteData[1] = new SpriteData();
		CannonShootAnim.spriteData[1].spriteName = "cannon_body";
		CannonShootAnim.spriteData[1].firstFrame = 637;
		CannonShootAnim.spriteData[1].framesCount = 10;
		CannonShootAnim.spriteData[2] = new SpriteData();
		CannonShootAnim.spriteData[2].spriteName = "cannon_front";
		CannonShootAnim.spriteData[2].firstFrame = 647;
		CannonShootAnim.spriteData[2].framesCount = 10;
		CannonShootAnim.spriteData[3] = new SpriteData();
		CannonShootAnim.spriteData[3].spriteName = "cannon_wood";
		CannonShootAnim.spriteData[3].firstFrame = 657;
		CannonShootAnim.spriteData[3].framesCount = 10;
		CannonShootAnim.spriteData[4] = new SpriteData();
		CannonShootAnim.spriteData[4].spriteName = "cannon_back";
		CannonShootAnim.spriteData[4].firstFrame = 627;
		CannonShootAnim.spriteData[4].framesCount = 10;
		
		//ArrowAnim
		ArrowAnim.framesCount = 30;
		ArrowAnim.spritesCount = 1;
		ArrowAnim.spriteData[0] = new SpriteData();
		ArrowAnim.spriteData[0].spriteName = "arrow";
		ArrowAnim.spriteData[0].firstFrame = 667;
		ArrowAnim.spriteData[0].framesCount = 30;
		
		//RocketAnim 
		RocketAnim.framesCount = 14;
		RocketAnim.spritesCount = 11;
		RocketAnim.spriteData[0] = new SpriteData();
		RocketAnim.spriteData[0].spriteName = "null";
		RocketAnim.spriteData[0].firstFrame = 0;
		RocketAnim.spriteData[0].framesCount = 0;
		RocketAnim.spriteData[1] = new SpriteData();
		RocketAnim.spriteData[1].spriteName = "neck";
		RocketAnim.spriteData[1].firstFrame = 711;
		RocketAnim.spriteData[1].framesCount = 14;
		RocketAnim.spriteData[2] = new SpriteData();
		RocketAnim.spriteData[2].spriteName = "head";
		RocketAnim.spriteData[2].firstFrame = 725;
		RocketAnim.spriteData[2].framesCount = 14;
		RocketAnim.spriteData[3] = new SpriteData();
		RocketAnim.spriteData[3].spriteName = "null";
		RocketAnim.spriteData[3].firstFrame = 0;
		RocketAnim.spriteData[3].framesCount = 0;
		RocketAnim.spriteData[4] = new SpriteData();
		RocketAnim.spriteData[4].spriteName = "null";
		RocketAnim.spriteData[4].firstFrame = 0;
		RocketAnim.spriteData[4].framesCount = 0;
		RocketAnim.spriteData[5] = new SpriteData();
		RocketAnim.spriteData[5].spriteName = "tail";
		RocketAnim.spriteData[5].firstFrame = 753;
		RocketAnim.spriteData[5].framesCount = 14;
		RocketAnim.spriteData[6] = new SpriteData();
		RocketAnim.spriteData[6].spriteName = "shell";
		RocketAnim.spriteData[6].firstFrame = 767;
		RocketAnim.spriteData[6].framesCount = 14;
		RocketAnim.spriteData[7] = new SpriteData();
		RocketAnim.spriteData[7].spriteName = "leg_f";
		RocketAnim.spriteData[7].firstFrame = 795;
		RocketAnim.spriteData[7].framesCount = 14;
		RocketAnim.spriteData[8] = new SpriteData();
		RocketAnim.spriteData[8].spriteName = "leg_b";
		RocketAnim.spriteData[8].firstFrame = 809;
		RocketAnim.spriteData[8].framesCount = 14;
		RocketAnim.spriteData[9] = new SpriteData();
		RocketAnim.spriteData[9].spriteName = "glider";
		RocketAnim.spriteData[9].firstFrame = 823;
		RocketAnim.spriteData[9].framesCount = 14;
		RocketAnim.spriteData[10] = new SpriteData();
		RocketAnim.spriteData[10].spriteName = "line";
		RocketAnim.spriteData[10].firstFrame = 837;
		RocketAnim.spriteData[10].framesCount = 14;
		RocketAnim.spriteData[11] = new SpriteData();
		RocketAnim.spriteData[11].spriteName = "rocket";
		RocketAnim.spriteData[11].firstFrame = 697;
		RocketAnim.spriteData[11].framesCount = 14;
		RocketAnim.spriteData[12] = new SpriteData();
		RocketAnim.spriteData[12].spriteName = "helmet";
		RocketAnim.spriteData[12].firstFrame = 739;
		RocketAnim.spriteData[12].framesCount = 14;
		RocketAnim.spriteData[13] = new SpriteData();
		RocketAnim.spriteData[13].spriteName = "rope";
		RocketAnim.spriteData[13].firstFrame = 781;
		RocketAnim.spriteData[13].framesCount = 14;					        
	}
	
	public static void initSound()
	{
		musicController = new MusicController();
	}
}


//////////////////////////////////////////////////////////////////////////