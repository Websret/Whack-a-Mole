package myGame;

import javax.swing.*;
import java.awt.*;

public class Menu {
    public static boolean click = false;

    ButtonMenu button1 = new ButtonMenu(315, 130, 400, 100,"Play");
    ButtonMenu button2 = new ButtonMenu(315, 260, 400, 100,"Regulations");
    ButtonMenu button3 = new ButtonMenu(315, 390, 400, 100,"Exit");

    public void draw(Graphics2D graphics2D){
        button1.draw(graphics2D);
        button2.draw(graphics2D);
        button3.draw(graphics2D);
    }

    public void moveButton(Menu.ButtonMenu buttonMenu) {
        if (Panel.mouseX > buttonMenu.getX() && Panel.mouseX < buttonMenu.getX()+buttonMenu.getW() &&
                Panel.mouseY > buttonMenu.getY() && Panel.mouseY < buttonMenu.getY()+buttonMenu.getH()){
            if (buttonMenu.equals(button1)) {
                if (Menu.click){
                    Panel.states = Panel.STATES.PLAY;
                    Menu.click = false;
                }
            }
            if (buttonMenu.equals(button2)){
                if (Menu.click){
                    Panel.regulationsMenu = true;
                    Panel.buttMenu = false;
                }
            }
            if (buttonMenu.equals(button3)){
                if (Menu.click){
                    System.exit(0);
                }
            }
        }
    }

    class ButtonMenu{
        private double x;
        private double y;
        private double w;
        private double h;

        public Color color;
        public String title;
        Image buttonImg = new ImageIcon("image/button.png").getImage();
        Image resizeButtonImg = buttonImg.getScaledInstance(400, 100, Image.SCALE_DEFAULT);

        public ButtonMenu(int x, int y,int w, int h, String title){
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
            this.title = title;

            color = Color.WHITE;
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
        public double getH() {
            return h;
        }

        public void draw(Graphics2D graphics2D){
            graphics2D.drawImage(resizeButtonImg, (int) x, (int) y, null);
            graphics2D.setColor(color);
            Font font = new Font("Arial", Font.ITALIC, 60);
            graphics2D.setFont(font);
            graphics2D.drawString("Best score: "+Result.getBestCount(), 50, 600);

            long length = (int) graphics2D.getFontMetrics().getStringBounds(title, graphics2D).getWidth();
            graphics2D.drawString(title, (int) (x+w/2) - (int) (length/2), (int) y+(int) (h/3)*2);
        }
    }
}
