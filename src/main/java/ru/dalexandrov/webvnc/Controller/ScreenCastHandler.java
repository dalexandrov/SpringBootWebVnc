package ru.dalexandrov.webvnc.Controller;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.awt.*;
import java.io.IOException;
import java.util.stream.IntStream;

/**
 * Created by mitia on 25.11.15.
 */
public class ScreenCastHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage textMessage)  {
        try {

            while(session.isOpen()) {
                session.sendMessage(new TextMessage(ScreenShooter.getScreen()));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }


}
