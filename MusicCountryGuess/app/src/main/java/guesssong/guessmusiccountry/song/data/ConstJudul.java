package guesssong.guessmusiccountry.song.data;

public class ConstJudul {
    public static final int WEIHTANDHIGHT=40;
    public static final int DELETETIME =5;

    public static final String SONG_INFO[][] = {
            {"michael_jackson_black_or_white.mp3","2","BLACK OR WHITE"},
            {"ariana_grande_side_ to_side.mp3"   , "1", "SIDE TO SIDE"},
            {"jessie_j_flashlight.mp3","1","FLASHLIGHT"},
            {"alan_walker_faded.mp3","1","FADED"},//1
            {"john_legend_all_of_me.mp3","1","ALL OF ME"},
            {"eminem_rap_god.mp3","1","RAP GOD"},//1
            {"katy_perry_roar.mp3","1","ROAR"},
            {"justin_bieber_let_me_love_you.mp3","1","LET ME LOVE YOU"},
            {"fifth_harmony_work_from_home.mp3","1","WORK FROM HOME"},
            {"Flo_Rida_GDFR.mp3","1","GDFR"},
            {"wiz_khalifa_see_you_again.mp3"    , "1", "SEE YOU AGAIN"},         //3
            {"magic_rude.mp3"    , "1", "RUDE"},    //2
            {"justin_bieber_cold_water.mp3", "1", "COLD WATER"},
            {"one_direction_one_thing.mp3", "1", "ONE THING"},
            {"bruno_mars_uptown_funk.mp3", "1", "UPTOWN FUNK"},          //5
            {"maroon_5_animals.mp3" , "1", "ANIMALS"},    //6
            {"meghan_trainor_no.mp3", "1", "NO"},       //7
            {"maroon_5_sugar.mp3", "1", "SUGAR"},     //8
            {"psy_gangnam_style.mp3", "2", "GANGNAM STYLE"},   //21
            {"omi_cheerleader.mp3"   , "1", "CHEERLEADER"},          //9
            {"passenger_let_her_go.mp3", "1", "LET HER GO"},       //10
            {"r_city_locked_away.mp3", "1", "LOCKED AWAY"},        //11
            {"taylor_swift_blank_space.mp3" , "1", "BLANK SPACE"},        //12
            {"adele_someone_like_you.mp3", "2", "SOMEONE LIKE YOU"}, //29
            {"the_chainsmokers_closer.mp3", "1", "CLOSER"},    //13
            {"ariana_grande_focus.mp3", "2", "FOCUS"},       //14
            {"ariana_grande_into_you.mp3", "1", "INTO YOU"},                   //16
            {"ed_sheeran_thinking_out_loud.mp3", "1", "THINKING OUT LOUD"},   //17
            {"justin_bieber_sorry.mp3", "2", "SORRY"},     //18
            {"meghan_trainor_me_too.mp3", "1", "ME TOO"},   //19
            {"naughty_boy_la_la_la.mp3","1","LA LA LA"},
            {"one_direction_you_and_i.mp3", "2", "YOU & I"},   //21
            {"one_republic_counting_stars.mp3", "2", "COUNTING STARS"},   //21
            {"psy_gentle_man.mp3", "1", "GENTLEMAN"}, //22
            {"sam_smith_lay_me_down.mp3", "2", "LAY ME DOWN"},       //23
            {"sam_smith_stay_with_me.mp3", "1", "STAY WITH ME"},             //24
            {"shawn_mendes_treat_you_better.mp3","2","TREAT YOU BETTER"},
            {"silento_watch_me.mp3", "1", "WATCH ME"}, //26
            {"shawn_mendes _stitches.mp3", "1", "STITCHES"},               //27
            {"adele_hello.mp3", "3", "HELLO"},             //28
            {"avicii_wake_me_up.mp3", "2", "WAKE ME UP"}, //30
            {"bruno_mars_the_lazy_song.mp3", "1", "THE "},     //31
            {"dawin_dessert.mp3","1", "DESSERT"},        //32
            {"drake_hotline_bling.mp3","1", "HOTLINE BLING"},       //33
            {"ellie_goulding_burn.mp3"    , "1", "BURN"},    //2
            {"imagine_dragons_radioactive.mp3","1", "RADIOACTIVE"},   //34
            {"justin_bieber_love_yourself.mp3","3","LOVE YOURSELF"},     //35
            {"michael_jackson_heal_the_world.mp3","2","HEAL THE WORLD"},     //38
            {"the_weeknd_the_hills.mp3","2","THE HILLS"},
            {"avenged_sevenfold_dear_god.mp3","2","DEAR GOD"},
            {"avenged_sevenfold_so_far_away.mp3","2","SO FAR AWAY"},
            {"bob_marley_a_lalala_long.mp3","2","A LALALA LONG"},
            {"bon_jovi_Its_my_life.mp3","2","ITS MY LIFE"},
            {"linkin_park_numb.mp3","2","NUMB"},
            /*{"malam_terakhir.mp3","2","MALAM TERAKHIR"},
            {"hitam_manis.mp3","2","HITAM MANIS"},

            {"kopi_susu.mp3","1","KOPI SUSU"},
            {"air_tuba.mp3","2","AIR TUBA"},
            {"khana.mp3","2","KHANA"},
            {"katanya.mp3","2","KATANYA"},
            {"rujuk_.mp3","2","RUJUK"},*/



    };


    public static boolean hasMoreMusic(int done) {
        return done < SONG_INFO.length;
    }

}
