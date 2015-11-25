package ru.dalexandrov.webvnc.Controller;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

/**
 * Created by mitia on 25.11.15.
 */
public class ScreenShooter {

    static {
        System.setProperty("java.awt.headless", "false");
    }

    public static String getScreen() throws AWTException, IOException {
        BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(image, "png", Base64.getEncoder().wrap(os));
        return "data:image/png;base64,"+os.toString("UTF-8");
    }
}
