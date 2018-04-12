// Adapted from
// https://github.com/corbt/react-native-keep-awake

package com.kristiansorens.flagsecure;

import android.app.Activity;
import android.view.WindowManager;
import android.util.Log;

import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;

public class FlagSecure extends ReactContextBaseJavaModule {

    public FlagSecure(final ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.addLifecycleEventListener(new LifecycleEventListener() {
            @Override
            public void onHostResume() {
                final Activity activity = getCurrentActivity();
                if (activity == null) {
                    Log.w(getName(), "current activity is empty so FLAG_SECURE cannot be set");
                } else {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
                            Log.d(getName(), "FLAG_SECURE was set for current activity");
                        }
                    });
                }
            }

            @Override
            public void onHostPause() {}

            @Override
            public void onHostDestroy() {}
        });
    }

    @Override
    public String getName() {
        return "FlagSecure";
    }
}
