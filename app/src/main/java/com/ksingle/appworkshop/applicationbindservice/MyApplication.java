package com.ksingle.appworkshop.applicationbindservice;

import android.app.Application;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by Ksingle on 2017/9/11.
 */

public class MyApplication extends Application {

    private String TAG = "Report";

    public MyService myService;
    private ServiceConnection serviceConnection;
    private Intent serviceIntent;

    @Override
    public void onCreate() {
        super.onCreate();
        serviceIntent = new Intent(this,MyService.class);
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                myService = ((MyService.MyBinder)iBinder).getService();
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {

            }
        };
    }

    public void bindService(){
        Log.i(TAG, "Application BindService");
        startService(serviceIntent);
        bindService(serviceIntent,serviceConnection,BIND_AUTO_CREATE);
    }

    public void unBindService(){
        Log.i(TAG, "Application unBindService");
        stopService(serviceIntent);
        myService = null;
        unbindService(serviceConnection);
    }


}
