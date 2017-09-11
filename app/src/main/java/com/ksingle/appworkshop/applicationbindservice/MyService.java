package com.ksingle.appworkshop.applicationbindservice;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Ksingle on 2017/9/11.
 */

public class MyService extends Service {

    private String TAG = "Report";

    @Override
    public void onCreate() {
        Log.i(TAG, "Service onCreate");
        super.onCreate();
    }

    @Override
    public void onDestroy() {
        Log.i(TAG, "Service onDestroy");
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return new MyBinder();
    }

    class MyBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
}
