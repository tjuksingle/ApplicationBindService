package com.ksingle.appworkshop.applicationbindservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    /**It's not really like bind service with application directly. In fact, I bind
     *  service with the application while main activity create, unbind the service
     *  while activity destroy.
     */

    private String TAG = "Report";

    private MyApplication myApplication;
    private Button bind,unbind;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myApplication = (MyApplication) getApplication();

        //myApplication.bindService();
        bind = (Button) findViewById(R.id.bind);
        unbind = (Button) findViewById(R.id.unbind);
        bind.setOnClickListener(this);
        unbind.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myApplication.myService != null){
            myApplication.unBindService();
        }
    }

    @Override
    public void onClick(View v) {
        if (v.equals(bind)){
            myApplication.bindService();
        }else if (v.equals(unbind)){
            if (myApplication.myService != null){
                myApplication.unBindService();
            }
        }
    }
}
