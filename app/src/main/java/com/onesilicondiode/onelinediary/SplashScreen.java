package com.onesilicondiode.onelinediary;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.VibrationEffect;
import android.os.Vibrator;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fireSplashScreen();
        vibrateDevice();
    }
    private void fireSplashScreen() {
        int splash_screen_time_out = 4500;
        new Handler().postDelayed(() -> {
            Intent i=new Intent(SplashScreen.this,Landing.class);
            startActivity(i);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            finish();
        }, splash_screen_time_out);
    }
    private void vibrateDevice() {
        Vibrator v3 = (Vibrator) this.getSystemService(Context.VIBRATOR_SERVICE);
        long[] pattern = {0,25,50,35,100};
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            v3.vibrate(VibrationEffect.createWaveform(pattern,-1));
        } else {
            v3.vibrate(pattern,-1);
        }
    }
}