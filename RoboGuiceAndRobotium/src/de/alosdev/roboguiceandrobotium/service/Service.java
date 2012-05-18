package de.alosdev.roboguiceandrobotium.service;

import android.content.Context;
import android.widget.Toast;

public class Service {
  String message;
  public Service(String message) {
   this.message = message;
  }
   public void showToast(Context context) {
     Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  } 
}
