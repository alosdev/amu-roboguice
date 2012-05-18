package de.alosdev.roboguiceandrobotium.service;

import android.app.Application;
import android.widget.Toast;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

@Singleton
public class Service implements IService {
  final String message;
  final Application context;

  @Inject
  public Service(@Named("defaultText") String message, Application context) {
    this.message = message;
    this.context = context;
  }

  /* (non-Javadoc)
   * @see de.alosdev.roboguiceandrobotium.service.IService#showToast()
   */
  public void showToast() {
    Toast.makeText(context, message, Toast.LENGTH_LONG).show();
  }
}
