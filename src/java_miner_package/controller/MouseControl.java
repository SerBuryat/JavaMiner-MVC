package java_miner_package.controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseControl implements MouseListener {
    

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getButton() == MouseEvent.BUTTON1) {
            Point p = e.getPoint();
            GameController.GAME_CONTROLLER.openBlock(p);
        }
        if(e.getButton() == MouseEvent.BUTTON2) {
            GameController.GAME_CONTROLLER.openAllBlocks(); // test
        }
        if(e.getButton() == MouseEvent.BUTTON3) {
            Point p = e.getPoint();
            GameController.GAME_CONTROLLER.setFlag(p);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
