package com.healthconnect;

import androidx.annotation.NonNull;
import android.app.Activity;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.ReactContext;


@ReactModule(name = HealthConnectModule.NAME)
public class HealthConnectModule extends ReactContextBaseJavaModule {
  public static final String NAME = "HealthConnect";
  private  HealthConnectManager healthConnectManager = null;
  private ReactApplicationContext mReactContext;

  public HealthConnectModule(ReactApplicationContext reactContext) {
    super(reactContext);
    mReactContext = reactContext;
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }


  @ReactMethod
  public void multiply(double a, double b, Promise promise) {
    promise.resolve(a * b);
  }

  @ReactMethod
  public void authorize(Promise promise) {
    if(healthConnectManager == null) {
      healthConnectManager = new HealthConnectManager(mReactContext);
      if(healthConnectManager.isAppInstalled()) {
       promise.resolve(healthConnectManager.hasAllPermissions());
      }
    }
  
    promise.resolve(null);
  }
}
