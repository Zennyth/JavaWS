package com.example.manager.socket;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;

import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.List;

import com.example.manager.models.Emergency;
import com.example.manager.models.Sensor;
import com.example.manager.models.Station;
import com.example.manager.models.Team;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

public class WebSocket {
  private String[] EVENTS = {"onUpdateSensors", "onUpdateEmergencies", "onUpdateTeams", "onUpdateStations"};

  private String URL;
  private String WS_KEY;

  public Socket socket;

  public WebSocket(String url, String key) {
    URL = url;
    WS_KEY = key;

    init();
  }

  private void init() {
    IO.Options options = IO.Options.builder()
      .setQuery("token=" + WS_KEY)
      .build();

    try {
      socket = IO.socket(URL, options);
      socket.connect();
    } catch (URISyntaxException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  public void subscribe(Subscriber subscriber, String eventToSubscribe) {

    if(eventToSubscribe == null) {
      subscribeToEvent(subscriber, eventToSubscribe);
    } else {
      for (String event : EVENTS) {
        subscribeToEvent(subscriber, event);
      }
    }
  }

  private void subscribeToEvent(Subscriber subscriber, String event) {
    Gson gson = new Gson();
    socket.on(event, new Listener() {
      @Override
      public void call(Object... args) {

        JSONArray content = (JSONArray)args[0];
        
        switch(event) {
          case "onUpdateSensors":
            Type typeSensors = new TypeToken<List<Sensor>>(){}.getType();
            subscriber.onUpdateSensors(gson.fromJson(content.toString(), typeSensors));
            break;
          case "onUpdateEmergencies":
            Type typeEmergencies = new TypeToken<List<Emergency>>(){}.getType();
            subscriber.onUpdateSensors(gson.fromJson(content.toString(), typeEmergencies));
            break;
          case "onUpdateTeams":
            Type typeTeams = new TypeToken<List<Team>>(){}.getType();
            subscriber.onUpdateSensors(gson.fromJson(content.toString(), typeTeams));
            break;
          case "onUpdateStations":
            Type typeStations = new TypeToken<List<Station>>(){}.getType();
            subscriber.onUpdateSensors(gson.fromJson(content.toString(), typeStations));
            break;
        }
      }
    });
  }
}
