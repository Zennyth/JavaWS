package com.example.manager;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter.Listener;

@SpringBootApplication
public class ManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
    System.out.println("Bonjour le monde !");

    try {
      Gson gson = new Gson();  

      IO.Options options = IO.Options.builder()
        .setQuery("token=4739f58f-5e35-4235-8ac5-4fdba549d641")
        .build();

      Socket socket = IO.socket("ws://localhost:3000", options);

      socket.on("onUpdateSensors", new Listener() {
        @Override
        public void call(Object... args) {

          JSONArray content = (JSONArray)args[0];
          try {
            Sensor sensor = gson.fromJson(content.get(0).toString(), Sensor.class);
            System.out.println(sensor.id);
          } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      });

      socket.connect();
    } catch (Exception e) {
      //TODO: handle exception
    }
	}

}
