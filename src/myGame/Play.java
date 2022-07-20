package myGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.TimerTask;


public class Play {
    public static boolean click = false;
    public ArrayList<HolePlay> buttons;

    public void initialized(){
        buttons = new ArrayList<HolePlay>();
        buttons.add(new HolePlay(130, 150, 160, 80));
        buttons.add(new HolePlay(130, 300, 160, 80));
        buttons.add(new HolePlay(130, 450, 160, 80));
        buttons.add(new HolePlay(410, 150, 160, 80));
        buttons.add(new HolePlay(410, 300, 160, 80));
        buttons.add(new HolePlay(410, 450, 160, 80));
        buttons.add(new HolePlay(680, 150, 160, 80));
        buttons.add(new HolePlay(680, 300, 160, 80));
        buttons.add(new HolePlay(680, 450, 160, 80));
    }

    //-------
    public static int count = Result.getCount();
    public void movePlay(Graphics2D graphics2D){
        for(int i = 0; i < buttons.size(); i++){
            buttons.get(i).draw(graphics2D);
        }
    }
    public void moveHole(Graphics2D graphics2D) {
        count = 0;
        for (int i = 0; i < buttons.size(); i++) {
            int n = (int) Math.round(Math.random() * 10);
            if (n != i) {
                buttons.get(i).src = "";
            } else {
                buttons.get(i).src = "image/mole1.png";
                if (Panel.mouseX > buttons.get(i).getX() && Panel.mouseX < buttons.get(i).getX() + buttons.get(i).getW() &&
                        Panel.mouseY > buttons.get(i).getY() && Panel.mouseY < buttons.get(i).getY() + buttons.get(i).getH()) {
                    count++;
                    Result.setCount(count);
                }
            }
        }
    }
    private static int timeEndGame = 30;
    private static long delay = 60000L;
    public static int getTimeEndGame() {
        return timeEndGame;
    }
    public static void setTimeEndGame(int timeEndGame) {
        Play.timeEndGame = timeEndGame;
    }
    public static void setDelay(long delay){
        Play.delay = delay;
    }

    public void gameOver() {
        java.util.Timer timer = new java.util.Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                timeEndGame--;

                if (timeEndGame < 0) {
                    Panel.states = Panel.STATES.MENU;
                    Panel.resultMenu = true;
                    Panel.buttMenu = false;
                }
            }
        }, 0, delay);
    }
    //------

    class HolePlay{
        private double x;
        private double y;
        private double w;
        private double h;
        public Color color = Color.BLACK;
        public String src;

        public HolePlay(int x, int y, int w, int h){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }

        public double getX(){
            return x;
        }
        public double getY() {
            return y;
        }
        public double getW() {
            return w;
        }
        public double getH() {
            return h;
        }

        Image img = new ImageIcon("image/hole.png").getImage();
        Image resizeHoleImg = img.getScaledInstance(160, 80,Image.SCALE_DEFAULT);

        public void draw(Graphics2D graphics2D){
            graphics2D.setColor(color);
            Font font = new Font("Arial", Font.ITALIC, 60);
            graphics2D.setFont(font);
            graphics2D.drawString("Score: "+Result.getCount(), 30, 50);
            graphics2D.drawString("Time: "+timeEndGame, 550, 50);

            graphics2D.drawImage(resizeHoleImg, (int) x, (int) y, null);
            graphics2D.drawImage(new ImageIcon(src).getImage(), (int) x, (int) y, null);
        }
    }
}