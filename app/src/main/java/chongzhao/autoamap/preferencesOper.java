package chongzhao.autoamap;

import android.content.Context;
import android.content.SharedPreferences;

public class preferencesOper {
    private SharedPreferences sp;
    private String SPname = "settings";
    private String yanchishijian_30 ="yanchishijian";
    private String shifoukaiqi_true ="shifoukaiqi";
    preferencesOper(Context c){
        sp = c.getSharedPreferences(SPname,Context.MODE_PRIVATE);
    }

   void savePrefer_yanchi(int value){
       SharedPreferences.Editor edit = sp.edit();
       edit.putInt(yanchishijian_30,value);
       edit.commit();
   }
    void savePrefer_shifoukaiqi(boolean value){
        SharedPreferences.Editor edit = sp.edit();
        edit.putBoolean(shifoukaiqi_true,value);
        edit.commit();
    }
    int radePrefer_yanchi(){
       return sp.getInt(yanchishijian_30,30);
    }
    Boolean radePrefer_shifoukaiqi(){

        return sp.getBoolean(shifoukaiqi_true,true);
    }
}
