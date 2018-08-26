package id.revze.androidmvpsample;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class BaseApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
    }
}
