
package com.reactlibrarypowermanager;

import android.content.Context;
import android.os.Build;
import android.os.PowerManager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNPowerManagerModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNPowerManagerModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @ReactMethod 
  public void isAppIgnoringBatteryOptimization(Callback callback){
    String packageName = getReactApplicationContext().getPackageName();
    PowerManager pm = (PowerManager) getReactApplicationContext().getSystemService(Context.POWER_SERVICE);
    if(pm != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // Version Marshmallow(6)
        callback.invoke(pm.isIgnoringBatteryOptimizations(packageName));
    }else{
        callback.invoke(true);
    }
  }

//   @ReactMethod 
//   public void getLocationPowerSaveMode(Callback callback){
//     PowerManager pm = (PowerManager) getReactApplicationContext().getSystemService(Context.POWER_SERVICE);
//     if(pm != null && pm.getLocationPowerSaveMode && Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) { // Version Marshmallow(6)
//         callback.invoke(pm.getLocationPowerSaveMode());
//     }else{
//         callback.invoke(PowerManager.LOCATION_MODE_NO_CHANGE);
//     }
//   }

  @ReactMethod 
  public void isPowerSaveMode(Callback callback){
    PowerManager pm = (PowerManager) getReactApplicationContext().getSystemService(Context.POWER_SERVICE);
    if(pm != null && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // Version Lollipop(5)
        callback.invoke(pm.isPowerSaveMode());
    }else{
        callback.invoke(false);
    }
  }

  @Override
  public String getName() {
    return "RNPowerManager";
  }
}