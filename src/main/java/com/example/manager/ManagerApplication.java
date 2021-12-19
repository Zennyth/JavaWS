package com.example.manager;

import com.example.manager.socket.Events;
import com.example.manager.socket.WebSocket;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
    
    TestManager manager = new TestManager();
    WebSocket ws = new WebSocket("ws://localhost:3000", "4739f58f-5e35-4235-8ac5-4fdba549d641");

    ws.subscribe(manager, Events.SENSORS.getEvent());
	}

}
