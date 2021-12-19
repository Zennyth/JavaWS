package com.example.manager.socket;

import java.util.ArrayList;

import com.example.manager.models.Emergency;
import com.example.manager.models.Sensor;
import com.example.manager.models.Station;
import com.example.manager.models.Team;

public class Subscriber {
  public void onUpdateSensors (ArrayList<Sensor> sensors) {}
  public void onUpdateEmergencies (ArrayList<Emergency> emergencies) {}
  public void onUpdateTeams (ArrayList<Team> teams) {}
  public void onUpdateStations (ArrayList<Station> stations) {}
}