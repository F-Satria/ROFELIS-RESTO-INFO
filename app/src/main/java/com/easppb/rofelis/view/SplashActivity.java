package com.easppb.rofelis.view;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.easppb.rofelis.R;

public class SplashActivity extends AppCompatActivity {

    ProgressBar progressBar;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Toast.makeText(getApplicationContext(), "START", Toast.LENGTH_LONG).show();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        progressBar = findViewById(R.id.progress);
        textView = findViewById(R.id.txtload);

        progressBar.setMax(100);
        progressBar.setScaleY(3f);

        progressAnimation();
    }

    public void progressAnimation(){
        SplashAnimation anim = new SplashAnimation(this, progressBar, textView, 0f, 100f);
        anim.setDuration(3000);
        progressBar.setAnimation(anim);
    }
}
