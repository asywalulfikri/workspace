package guesssong.guessmusiccountry.song.data;

public class ConstPenyanyi {
    public static final int WEIHTANDHIGHT=40;
    public static final int DELETETIME =5;

    public static final String SONG_INFO[][] = {
            {"maroon_5_animals.mp3" , "1", "MAROON 5"},    //6
            {"meghan_trainor_no.mp3", "1", "MEGHAN TRAINOR"},       //7
            {"maroon_5_sugar.mp3", "1", "MAROON 5"},
            {"katy_perry_roar.mp3","1","KATY PERRY"},
            {"justin_bieber_let_me_love_you.mp3","1","JUSTIN BIEBER"},
           // {"Flo_Rida_GDFR.mp3","1","GDFR"},
            {"wiz_khalifa_see_you_again.mp3"    , "1", "WIZ KHALIFA"},         //3
            {"magic_rude.mp3"    , "1", "MAGIC"},    //2
            {"justin_bieber_cold_water.mp3", "1", "JUSTIN BIEBER"},
            {"one_direction_one_thing.mp3", "1", "ONE DIRECTION"},
            {"eminem_rap_god.mp3","1","EMINEM"},//1
            {"bruno_mars_uptown_funk.mp3", "1", "BRUNO MARS"},          //5
            {"ed_sheeran_thinking_out_loud.mp3", "1", "ED SHEEREN"},   //17
            {"justin_bieber_sorry.mp3", "2", "JUSTIN BIEBER"},     //18
            {"meghan_trainor_me_too.mp3", "1", "MEGHAN TRAINOR"},   //19
            {"naughty_boy_la_la_la.mp3","1","NAUGHTY BOY"},
            {"one_direction_you_and_i.mp3", "2", "ONE DIRECTION"},   //21
            {"one_republic_counting_stars.mp3", "2", "ONE REPUBLIC"},   //21
            {"avicii_wake_me_up.mp3", "2", "AVICII"}, //30
            {"bruno_mars_the_lazy_song.mp3", "1", "BRUNO MARS"},     //31
            {"dawin_dessert.mp3","1", "DAWIN"},        //32
            {"drake_hotline_bling.mp3","1", "DRAKE"},       //33
            {"michael_jackson_black_or_white.mp3","2","MICHAEL JACKSON"},
            {"ariana_grande_side_ to_side.mp3"   , "1", "ARIANA GRANDE"},
            {"sam_smith_stay_with_me.mp3", "1", "SAM SMITH"},
            //8
            {"psy_gangnam_style.mp3", "2", "PSY"},   //21
            {"omi_cheerleader.mp3"   , "1", "OMI"},          //9
            {"passenger_let_her_go.mp3", "1", "PASSENGER"},       //10
            {"r_city_locked_away.mp3", "1", "LOCKED AWAY"},        //11
            {"taylor_swift_blank_space.mp3" , "1", "TAYLOR SWIFT"},        //12
            {"adele_someone_like_you.mp3", "2", "ADELE"}, //29
            {"the_chainsmokers_closer.mp3", "1", "THE CHAINSMOKERS"},    //13
            {"ariana_grande_focus.mp3", "2", "ARIANA GRANDE"},       //14
            {"ariana_grande_into_you.mp3", "1", "ARIANA GRANDE"},                   //16

            {"psy_gentle_man.mp3", "1", "PSY"}, //22
            {"avenged_sevenfold_so_far_away.mp3","2","AVENGED SEVENFOLD"},
            {"sam_smith_lay_me_down.mp3", "2", "SAM SMITH"},       //23
            //24
            {"shawn_mendes_treat_you_better.mp3","2","SHAWN MENDES"},
            {"silento_watch_me.mp3", "1", "SILENTO"}, //26
            {"shawn_mendes _stitches.mp3", "1", "SHAWN MENDES"},               //27
            {"adele_hello.mp3", "3", "ADELE"},             //28

            {"jessie_j_flashlight.mp3","1","JESSIE J"},
            {"alan_walker_faded.mp3","1","ALAN WALKER"},//1
            {"john_legend_all_of_me.mp3","1","JHON LEGEND"},
            {"ellie_goulding_burn.mp3"    , "1", "ELLIE GOULDING"},    //2
            {"imagine_dragons_radioactive.mp3","1", "IMAGINE DRAGON"},   //34
            {"justin_bieber_love_yourself.mp3","3","JUSTIN BIEBER"},     //35
            {"michael_jackson_heal_the_world.mp3","2","MICHAEL JACKSON"},     //38
            {"the_weeknd_the_hills.mp3","2","THE WEEKEND"},
            {"avenged_sevenfold_dear_god.mp3","2","AVENGED SEVENFOLD"},
            {"bob_marley_a_lalala_long.mp3","2","BOB MARLEY"},
            {"bon_jovi_Its_my_life.mp3","2","BON JOVI"},
            {"linkin_park_numb.mp3","2","LINKIN PARK"},



    };

    public static boolean hasMoreMusic(int done) {
        return done < SONG_INFO.length;
    }

}
