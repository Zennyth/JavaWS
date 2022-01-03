package com.example.manager.models;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;

import org.springframework.boot.autoconfigure.jersey.JerseyProperties.Type;

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

class SensorDeserializer implements JsonDeserializer<Sensor> {
  @Override
  public Sensor deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    JsonParser parser = new JsonParser();
    JsonObject jsonObject = parser.parse(json.getAsString()).getAsJsonObject();

    SimpleDateFormat formatter =new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss");

    Date createdAt;
    try {
      createdAt = formatter.parse(jsonObject.get("createdAt").toString());
    } catch (ParseException e) {
      createdAt = null;
    }
    Date updatedAt;
    try {
      updatedAt = formatter.parse(jsonObject.get("updatedAt").toString());
    } catch (ParseException e) {
      updatedAt = null;
    }
    Date deletedAt;
    try {
      deletedAt = formatter.parse(jsonObject.get("deletedAt").toString());
    } catch (ParseException e) {
      deletedAt = null;
    }


    return new Sensor(
      jsonObject.get("id").toString(), 
      Float.parseFloat(jsonObject.get("latitude").toString()), 
      Float.parseFloat(jsonObject.get("longitude").toString()), 
      Integer.parseInt(jsonObject.get("intensity").toString()), 
      Integer.parseInt(jsonObject.get("radius").toString()), 
      jsonObject.get("emergencyId").toString(), 
      createdAt, 
      updatedAt, 
      deletedAt
    );
  }
}