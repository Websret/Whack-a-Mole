package myGame;

import javax.swing.*;
import java.awt.*;

public class RegulationsMenu {
    RegulationsButton button1 = new RegulationsButton(315, 490, 400, 100, "Back");

    public void draw(Graphics2D graphics2D){
        button1.draw(graphics2D);
    }

    public void moveButton(RegulationsMenu.RegulationsButton buttonMenu) {
        if (Panel.mouseX > buttonMenu.getX() && Panel.mouseX < buttonMenu.getX()+buttonMenu.getW() &&
                Panel.mouseY > buttonMenu.getY() && Panel.mouseY < buttonMenu.getY()+buttonMenu.getH()){
            if (buttonMenu.equals(button1)) {
                if (Menu.click){
                    Panel.buttMenu = true;
                    Panel.regulationsMenu= false;
                }
            }
        }
    }

    class RegulationsButton{
        private double x;
        private double y;
        private double w;
        private double h;

        private Color color;
        public String title;

        public RegulationsButton(int x, int y, int w, int h, String title){
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
            graphics2D.drawString("You need to score as many points as", 100, 200);
            graphics2D.drawString("possible by hitting the moles in the", 100, 270);
            graphics2D.drawString("allowed 30 seconds. At the end time,", 100, 340);
            graphics2D.drawString("you will see your result", 100, 410);

            graphics2D.drawImage(resizeButtonImg, (int) x, (int) y, null);
            graphics2D.setColor(color);
            Font font1 = new Font("Arial", Font.ITALIC, 60);
            graphics2D.setFont(font1);

            long length = (int) graphics2D.getFontMetrics().getStringBounds(title, graphics2D).getWidth();
            graphics2D.drawString(title, (int)(x+w/2)-(int)(length/2),(int)y+(int)(h/3)*2);
        }
    }
}
