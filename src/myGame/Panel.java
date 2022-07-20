package myGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class Panel extends JPanel implements ActionListener {
    //size panel
    public static int WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static int HEIGTH = Toolkit.getDefaultToolkit().getScreenSize().height;

    //mouse x & y
    public static int mouseX;
    public static int mouseY;

    public static boolean buttMenu = true;
    public static boolean regulationsMenu = false;
    public static boolean resultMenu = false;

    public static enum STATES{MENU, PLAY}
    public static STATES states = STATES.MENU;

    private BufferedImage image;
    private Graphics2D graphics;
    Timer mainTimer = new Timer(500, this);

    Background background = new Background();
    Menu menu = new Menu();
    RegulationsMenu regMenu = new RegulationsMenu();
    Result result = new Result();
    Play play = new Play();

    public Panel(){
        super();

        setFocusable(true); //передаем фокус
        requestFocus(); //активируем

        mainTimer.start();
        image = new BufferedImage(WIDTH, HEIGTH, BufferedImage.TYPE_INT_RGB); //object for save images
        graphics = (Graphics2D) image.getGraphics(); //graphics object = buffered element - image Graphics2D use method getGraphics()
        play.initialized();

        addMouseListener(new Listeners());//оброботчик клика мыши
        addKeyListener(new Listeners());//оброботчик событий клавиатуры
        addMouseMotionListener(new Listeners());//обработчик событий перемещения мыши

    }

    public void gameRender(){
        background.draw(graphics);
        play.movePlay(graphics);
        play.gameOver();
    }

    public void gameDraw(){
        Graphics graphics1 = this.getGraphics();
        graphics1.drawImage(image, 0, 0, null);//рисуем
        graphics1.dispose();//убираем мусор
    }

    public void actionPerformed (ActionEvent e){
        if (states.equals(STATES.MENU)){
            background.draw(graphics);
            if (buttMenu){
                menu.draw(graphics);
                menu.moveButton(menu.button1);
                menu.moveButton(menu.button2);
                menu.moveButton(menu.button3);
            }
            if (regulationsMenu){
                regMenu.draw(graphics);
                regMenu.moveButton(regMenu.button1);
            }
            if (resultMenu){
                result.draw(graphics);
                result.moveButton(result.button1);
                result.moveButton(result.button2);
            }

            gameDraw();
        }
        if (states.equals(STATES.PLAY)){
            gameRender();
            play.moveHole(graphics);
            gameDraw();

        }
    }
}