package com.example.manager.socket;

public enum Events {
  SENSORS("onUpdateSensors"),
  EMERGENCIES("onUpdateEmergencies"),
  TEAMS("onUpdateTeams"),
  STATIONS("onUpdateStations");

  private String event;

  Events(String envUrl) {
    this.event = envUrl;
  }

  public String getEvent() {
    return event;
  }
}
