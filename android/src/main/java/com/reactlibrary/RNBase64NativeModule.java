
package com.reactlibrary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNBase64NativeModule extends ReactContextBaseJavaModule implements ActivityEventListener {

  private final ReactApplicationContext reactContext;

  public RNBase64NativeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNBase64Native";
  }

  private Promise pickerPromise;
  private int R_VALUE = 1;

  @ReactMethod
  public void filePicker(final Promise promise) {
    final Activity currentActivity = getCurrentActivity();
    if (currentActivity == null) {
      promise.reject("E_ACTIVITY_DOES_NOT_EXIST", "Activity doesn't exist");
      return;
    }
    pickerPromise = promise;
    try {
      final Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
      intent.addCategory(Intent.CATEGORY_OPENABLE);
      intent.setType("*/*");
      final Intent pickerIntent = Intent.createChooser(intent, "Choose file");
      currentActivity.startActivityForResult(pickerIntent, R_VALUE);
    } catch (Exception ex) {
      pickerPromise.reject("E_UNKNOWN_ERROR", ex.getMessage());
      pickerPromise = null;
    } finally {
      pickerPromise = null;
    }
  }

  public void onActivityResult(final Activity activity, final int requestCode, final int resultCode, final Intent data) {
    onActivityResult(requestCode, resultCode, data);
  }

  public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (R_VALUE == requestCode) {
      if (pickerPromise != null) {
        if (requestCode == Activity.RESULT_CANCELED) {
          pickerPromise.reject("E_CANCELLED", "Action is cancelled");
        } else if (resultCode == Activity.RESULT_OK) {
          Uri uri = data.getData();
          if (uri != null) {
            pickerPromise.resolve(uri.toString());
          } else {
            pickerPromise.reject("E_NOT_FOUND", "File not found");
          }
        }
        pickerPromise = null;
      }
    }
  }

  public void onNewIntent(Intent intent) {}
}