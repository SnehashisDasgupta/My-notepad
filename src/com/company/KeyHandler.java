package com.company;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//key shortcuts
public class KeyHandler implements KeyListener {

    GUI gui;

    public KeyHandler(GUI gui){
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        //press CTRL+S to save
        if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S){
            gui.file.save();
        }
        //press CTRL+SHIFT+S to save_as
        else if(e.isControlDown() && e.isShiftDown() && e.getKeyCode() == KeyEvent.VK_CONTROL + KeyEvent.VK_SHIFT + KeyEvent.VK_S){
            gui.file.saveAs();
        }
        //press CTRL+N to open new file
        else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N){
            gui.file.newFile();
        }
        //press CTRL+O to open file
        else if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_O){
            gui.file.openFIle();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
