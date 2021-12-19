package com.example.manager.models;

import java.util.Date;

public class Team {
  public String id;
  public float latitude;
  public float longitude;
  public float intensity;
  public float level;
  public Boolean isHandlingEmergency;

  public String stationId;
  public String emergencyId;
  
  public Date createdAt;
  public Date updatedAt;
  public Date deletedAt;
}
