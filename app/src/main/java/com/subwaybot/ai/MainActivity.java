package com.subwaybot.ai;

import android.app.Activity;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static final int REQUEST_CODE_SCREEN_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Button startBtn = new Button(this);
        startBtn.setText("Start AI Bot");
        setContentView(startBtn);

        startBtn.setOnClickListener(v -> {
            // Screen capture ki permission maango
            MediaProjectionManager mpm = (MediaProjectionManager) getSystemService(MEDIA_PROJECTION_SERVICE);
            startActivityForResult(mpm.createScreenCaptureIntent(), REQUEST_CODE_SCREEN_CAPTURE);
            
            // User ko bolo Accessibility on karne ke liye
            Toast.makeText(this, "Settings > Accessibility mein jaakar 'Subway AI Bot' ON karo", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_SCREEN_CAPTURE && resultCode == RESULT_OK) {
            // Screen capture permission mil gayi
            Toast.makeText(this, "Screen Capture ON! Ab game kholo.", Toast.LENGTH_SHORT).show();
            
            // Yahan hum baad mein screen dekhne ka service start karenge
            // Abhi ke liye bas permission le liya hai
        }
    }
}
