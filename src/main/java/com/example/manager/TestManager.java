package com.example.manager;

import java.util.ArrayList;

import com.example.manager.models.Sensor;
import com.example.manager.socket.Subscriber;

public class TestManager extends Subscriber {
  
  @Override
  public void onUpdateSensors(ArrayList<Sensor> sensors) {
    
    for (Sensor sensor : sensors) {
      System.out.println(sensor.location);
    }
  }
}
