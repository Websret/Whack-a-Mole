package myGame;

import javax.swing.*;
import java.awt.*;

public class Window {
    public static void main(String[] args) {
        JFrame startFrame = new JFrame("Whack-a-Mole");//создаем окно с названием
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// закрытие окна при нажатии крестика
        startFrame.setLocation(0, 0);//изменение месторасположения фрейма
        startFrame.setSize(1024, 680);
        startFrame.add(new Panel());

        //окно видимо
        startFrame.setVisible(true);
    }
}
