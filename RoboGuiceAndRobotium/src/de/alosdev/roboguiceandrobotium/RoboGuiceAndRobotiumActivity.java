package de.alosdev.roboguiceandrobotium;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectExtra;
import roboguice.inject.InjectResource;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.inject.Inject;

import de.alosdev.roboguiceandrobotium.service.IService;


public class RoboGuiceAndRobotiumActivity extends RoboActivity  {
  private static final String EXTRA_COUNTER= "extra.counter";
  @InjectResource(R.string.hello)
  String helloMessage;
  @InjectView(R.id.hello_message_view)
  TextView helloMessageView;
  @InjectView(R.id.message)
  TextView messageView;
  @InjectView(R.id.button)
  Button button;
  @InjectView(R.id.switchButton)
  Button switchButton;
  @InjectView(R.id.toastButton)
  Button toastButton;
  @InjectExtra(value=EXTRA_COUNTER, optional=true)
  int counter = 1;
  @Inject
  IService service;
  
  
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    helloMessageView.setText(helloMessage);
  }

  public void pressHandler(View v) {
    if (v == button) {
      messageView.setText(getString(R.string.button_pressed_text, counter++));
    } else if (v == switchButton) {
      Intent intent = new Intent(this, this.getClass());
      intent.putExtra(EXTRA_COUNTER, counter + 100);
      startActivity(intent);
    } else if (v == toastButton) {
      service.showToast();
    }
  }
}
