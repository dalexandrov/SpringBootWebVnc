package ru.dalexandrov.webvnc.config;

import org.springframework.context.annotation.ComponentScan;
import ru.dalexandrov.webvnc.Controller.ScreenCastHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Created by mitia on 25.11.15.
 */
@Configuration
@EnableWebSocket
@ComponentScan("ru.dalexandrov.webvnc")
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry){
        registry.addHandler(new ScreenCastHandler(),"/screen");
    }

}
