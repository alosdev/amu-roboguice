package de.alosdev.roboguiceandrobotium;

import de.alosdev.roboguiceandrobotium.service.Service;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class RoboGuiceAndRobotiumActivity extends Activity implements OnClickListener {
  private static final String EXTRA_COUNTER= "extra.counter";
  String helloMessage;
  TextView helloMessageView;
  TextView messageView;
  Button button;
  Button switchButton;
  Button toastButton;
  int counter;
  Service service;
  
  
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    helloMessage = getString(R.string.hello);
    helloMessageView = (TextView) findViewById(R.id.hello_message_view);
    helloMessageView.setText(helloMessage);
    button = (Button) findViewById(R.id.button);
    button.setOnClickListener(this);
    switchButton = (Button) findViewById(R.id.switchButton);
    switchButton.setOnClickListener(this);
    toastButton = (Button) findViewById(R.id.toastButton);
    toastButton.setOnClickListener(this);
    messageView = (TextView) findViewById(R.id.message);
    
    counter = getIntent().getIntExtra(EXTRA_COUNTER, 1);
    
    service = new Service("you pressed the toast button");
  }

  @Override
  public void onClick(View v) {
    if (v == button) {
      messageView.setText(getString(R.string.button_pressed_text, counter++));
    } else if (v == switchButton) {
      Intent intent = new Intent(this, this.getClass());
      intent.putExtra(EXTRA_COUNTER, counter + 100);
      startActivity(intent);
    } else if (v == toastButton) {
      service.showToast(this);
    }
  }
}
