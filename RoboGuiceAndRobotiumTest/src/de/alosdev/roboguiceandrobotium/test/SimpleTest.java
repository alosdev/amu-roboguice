package de.alosdev.roboguiceandrobotium.test;

import android.test.ActivityInstrumentationTestCase2;
import com.jayway.android.robotium.solo.Solo;
import de.alosdev.roboguiceandrobotium.R;
import de.alosdev.roboguiceandrobotium.RoboGuiceAndRobotiumActivity;


public class SimpleTest extends ActivityInstrumentationTestCase2<RoboGuiceAndRobotiumActivity> {
  private Solo solo;

  public SimpleTest() {
    super(RoboGuiceAndRobotiumActivity.class);
  }

  @Override
  protected void setUp() throws Exception {
    solo = new Solo(getInstrumentation(), getActivity());
  }

  public void testStart() throws Exception {
    assertTrue(solo.searchButton(getActivity().getString(R.string.button_text)));
    assertTrue(solo.searchButton(getActivity().getString(R.string.toast_text)));
    assertTrue(solo.searchButton(getActivity().getString(R.string.switch_text)));
    solo.clickOnButton(0);
    solo.searchText(getActivity().getString(R.string.button_pressed_text, 1));
    solo.clickOnButton(2);
    solo.clickOnButton(0);
    solo.searchText(getActivity().getString(R.string.button_pressed_text, 102));
    solo.goBack();
    solo.searchText(getActivity().getString(R.string.button_pressed_text, 1));
    solo.goBack();
  }

  @Override
  protected void tearDown() throws Exception {
    solo.finishInactiveActivities();
    solo.finishOpenedActivities();
  }
}
