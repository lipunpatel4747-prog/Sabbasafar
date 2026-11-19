package com.subwaybot.ai;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.graphics.Path;
import android.view.accessibility.AccessibilityEvent;
import android.util.Log;

public class MyAccessibilityService extends AccessibilityService {
    private static final String TAG = "SubwayBot";

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        // Abhi ke liye hum ise manual test karenge
    }

    @Override
    public void onInterrupt() {
        Log.d(TAG, "Service Interrupted");
    }

    // Yeh function swipe karne ke liye hai
    public void doSwipe(int startX, int startY, int endX, int endY) {
        Path swipePath = new Path();
        swipePath.moveTo(startX, startY);
        swipePath.lineTo(endX, endY);

        GestureDescription.Builder gestureBuilder = new GestureDescription.Builder();
        gestureBuilder.addStroke(new GestureDescription.StrokeDescription(swipePath, 0, 200));

        dispatchGesture(gestureBuilder.build(), new GestureResultCallback() {
            @Override
            public void onCompleted(GestureDescription gestureDescription) {
                Log.d(TAG, "Swipe Completed!");
            }
        }, null);
    }

    // Test ke liye ek left swipe
    public void swipeLeft() {
        doSwipe(500, 1000, 100, 1000); // Coordinates phone ke hisaab se change honge
    }

    // Test ke liye ek right swipe
    public void swipeRight() {
        doSwipe(500, 1000, 900, 1000);
    }
}
