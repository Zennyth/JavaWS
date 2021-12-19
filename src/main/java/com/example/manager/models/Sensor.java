package com.example.manager.models;

import java.util.Date;

public class Sensor {
  public String id;
  public Coord location;
  public int intensity;
  public int radius;

  public String emergencyId;

  public Date createdAt;
  public Date updatedAt;
  public Date deletedAt;

  // public Sensor(String id, Coord location, int intensity, int radius, String emergencyId, Date createdAt, Date updatedAt, Date deletedAt) {
  //   this.id = id;
  //   this.location = location;
  //   this.intensity = intensity;
  //   this.radius = radius;
  //   this.emergencyId = emergencyId;
  //   this.createdAt = createdAt;
  //   this.updatedAt = updatedAt;
  //   this.deletedAt = deletedAt;
  // }

  public Sensor(String id, double latitude, double longitude, int intensity, int radius, String emergencyId, Date createdAt, Date updatedAt, Date deletedAt) {
    System.out.println(latitude);
    this.id = id;
    this.location = new Coord(latitude, longitude);
    this.intensity = intensity;
    this.radius = radius;
    this.emergencyId = emergencyId;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.deletedAt = deletedAt;
  }

  @Override
  public String toString() {
    return String.format("[SENSOR] => { id: %s, location: %s, intensity: %i }", this.id, this.location.toString(), this.intensity);
  }
}