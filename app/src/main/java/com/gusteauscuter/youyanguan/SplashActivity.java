package com.gusteauscuter.youyanguan;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.TextView;


public class SplashActivity extends Activity {

    private Handler handler = new Handler();
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        PackageManager pm = getPackageManager();
        try {
            PackageInfo pi = pm.getPackageInfo(this.getPackageName(), 0);
            TextView versionNumber = (TextView) findViewById(R.id.versionNumber);
            versionNumber.setText("Version: " + pi.versionName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        handler.postDelayed(runnable = new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, NavigationActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {

        if(event.getAction()==MotionEvent.ACTION_UP)
        {
            Intent intent = new Intent(SplashActivity.this, NavigationActivity.class);
            startActivity(intent);
            finish();
            if (runnable != null)
                handler.removeCallbacks(runnable);
        }

        return super.onTouchEvent(event);
    }


}
