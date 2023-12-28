
package com.reactlibrary;

import android.content.Intent;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

public class RNBase64NativeModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNBase64NativeModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNBase64Native";
  }

  @ReactMethod
  public void filePicker() {
    ReactApplicationContext context = getReactApplicationContext();
    Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
    intent.setType("file/*");
    context.startActivity(intent);
  }
}