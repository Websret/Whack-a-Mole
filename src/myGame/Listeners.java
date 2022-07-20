package myGame;

import java.awt.event.*;

public class Listeners implements MouseListener, KeyListener, MouseMotionListener {

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_ESCAPE){
            if (Panel.states != Panel.STATES.MENU) Panel.states = Panel.STATES.MENU; //exit in the menu
            if (Panel.buttMenu != true) {
                Panel.buttMenu = true;
                Panel.regulationsMenu = false;
                Panel.resultMenu = false;
            }
        }
    }
    //проверка отжатой клавиши
    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (Panel.states == Panel.STATES.MENU){
            Menu.click = true;
        }
        if (Panel.states == Panel.STATES.PLAY){
            Play.click = true;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (Panel.states == Panel.STATES.MENU){
            Menu.click = false;
        }
        if (Panel.states == Panel.STATES.PLAY){
            Play.click = false;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        Panel.mouseX = e.getX(); //получить координаты x
        Panel.mouseY = e.getY(); //получить координаты y
    }
}
