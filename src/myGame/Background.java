package myGame;

import javax.swing.*;
import java.awt.*;

public class Background {

    Image playBackground = new ImageIcon("image/playFont.jpg").getImage();
    Image resizePlayBackground = playBackground.getScaledInstance(1024, 680, Image.SCALE_DEFAULT);

    public void draw(Graphics2D graphics2D){
        Color backColor = new Color(37, 255, 38);
        graphics2D.setColor(backColor);

        if (Panel.states.equals(Panel.STATES.MENU)) graphics2D.drawImage(resizePlayBackground, (int) 0, (int) 0, null);
        if (Panel.states.equals(Panel.STATES.PLAY)) graphics2D.drawImage(resizePlayBackground, (int) 0, (int) 0, null);
    }
}
