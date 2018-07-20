package chongzhao.autoamap;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class broadcastReceiver extends BroadcastReceiver {
    private preferencesOper preferencesoper;
    int requestCode=1;
    @Override
    public void onReceive(Context context, Intent intent) {

        preferencesoper = new preferencesOper(context);

        if(preferencesoper.radePrefer_shifoukaiqi()){
            //高德地图车机版本 使用该包名
            String pkgName = "com.autonavi.amapauto";
            Intent launchIntent = new Intent();
            launchIntent.setComponent(
                    new ComponentName(pkgName,
                            "com.autonavi.auto.remote.fill.UsbFillActivity"));
            PendingIntent pi = PendingIntent.getActivity(context,requestCode,launchIntent,PendingIntent.FLAG_CANCEL_CURRENT);
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            int yanchi= preferencesoper.radePrefer_yanchi();
            am.set(AlarmManager.ELAPSED_REALTIME,yanchi*1000,pi);
            Toast.makeText(context,yanchi+String.valueOf(R.string.tishi),Toast.LENGTH_LONG).show();
        }
    }
}
