package com.healthconnect;

import androidx.annotation.NonNull;
import android.app.Activity;

import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.PermissionController;

import java.util.*;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.ReactContext;

public class HealthConnectManager {
    private ReactContext mReactContext;
    private final HealthConnectClient healthConnectClient = null;

    public HealthConnectManager(ReactContext reactContext) {
        mReactContext = reactContext;
    }

    public boolean isAppInstalled() {
     boolean appInstalled = false;

     try {
        appInstalled = HealthConnectClient.isProviderAvailable(mReactContext);
     } catch (Exception e) {
        appInstalled = false;
     }

     return appInstalled;
    }

    public boolean hasAllPermissions() {
        Set<String> permissions = new HashSet<String>();
        permissions.add("READ_HEART_RATE");
        return healthConnectClient.permissionController.getGrantedPermissions().containsAll(permissions);
    }
}
