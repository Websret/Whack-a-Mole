package myGame;

import javax.swing.*;
import java.awt.*;

public class Result {
    ResultButton button1 = new ResultButton(315, 330, 400, 100, "Play again");
    ResultButton button2 = new ResultButton(314, 460, 400, 100, "Menu");

    public void draw(Graphics2D graphics2D){
        button1.draw(graphics2D);
        button2.draw(graphics2D);
    }

    public void moveButton(Result.ResultButton resultButton){
        if (Panel.mouseX > resultButton.getX() && Panel.mouseX < resultButton.getX()+resultButton.getW() &&
                Panel.mouseY > resultButton.getY() && Panel.mouseY < resultButton.getY()+resultButton.getH()){
            if (resultButton.equals(button1)) {
                if (Menu.click){
                    Panel.states = Panel.STATES.PLAY;
                    Menu.click = false;
                    count = 0;
                    Play.setTimeEndGame(30);
                    Play.setDelay(60000L);
                }
            }
            if (resultButton.equals(button2)) {
                if (Menu.click){
                    Panel.states = Panel.STATES.MENU;
                    Panel.buttMenu = true;
                    Panel.resultMenu= false;
                    count = 0;
                    Play.setTimeEndGame(30);
                    Play.setDelay(60000L);
                }
            }
        }
    }

    public static int count;
    public static int bestCount;
    public static int getCount() {
        return count;
    }
    public static void setCount(int count) {
        Result.count = count;
    }
    public static int getBestCount() {
        return bestCount;
    }
    public static void setBestCount(int bestCount) {
        Result.bestCount = bestCount;
    }

    class ResultButton{
        private double x;
        private double y;
        private double w;
        private double h;

        private Color color;
        public String title;


        public ResultButton(int x, int y, int w, int h, String title){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            color = Color.BLACK;
            this.title = title;
        }

        public double getX(){
            return x;
        }
        public double getY(){
            return y;
        }
        public double getW(){
            return w;
        }
        public double getH(){
            return h;
        }

        Image buttonImg = new ImageIcon("image/button.png").getImage();
        Image resizeButtonImg = buttonImg.getScaledInstance(400, 100, Image.SCALE_DEFAULT);


        public void draw(Graphics2D graphics2D){
            graphics2D.setColor(Color.BLACK);
            Font font = new Font("Arial", Font.ITALIC, 50);
            graphics2D.setFont(font);
            graphics2D.drawString("Your result: "+count, 350, 200);
            if (count > bestCount){
                bestCount = count;
            }
            graphics2D.drawString("Your best result: "+bestCount, 350, 250);

            graphics2D.drawImage(resizeButtonImg, (int) x, (int) y, null);
            graphics2D.setColor(color);
            Font font1 = new Font("Arial", Font.ITALIC, 60);
            graphics2D.setFont(font1);

            long length = (int) graphics2D.getFontMetrics().getStringBounds(title, graphics2D).getWidth();
            graphics2D.drawString(title, (int)(x+w/2)-(int)(length/2), (int)y+(int)(h/3)*2);
        }
    }
}