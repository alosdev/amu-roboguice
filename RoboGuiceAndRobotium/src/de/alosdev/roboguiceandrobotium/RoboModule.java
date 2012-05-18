package de.alosdev.roboguiceandrobotium;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

import de.alosdev.roboguiceandrobotium.service.IService;
import de.alosdev.roboguiceandrobotium.service.Service;

public class RoboModule extends AbstractModule {

  @Override
  protected void configure() {
    bind(String.class).annotatedWith(Names.named("defaultText")).toInstance("you pressed the toast button");
    bind(IService.class).to(Service.class);
  }

}
