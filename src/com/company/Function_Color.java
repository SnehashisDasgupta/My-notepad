package com.company;

import java.awt.*;

public class Function_Color {
    GUI gui;

    public Function_Color(GUI gui){
        this.gui = gui;
    }

    public void changeColor(String color){

        switch (color) {
            case "White" -> {
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white); // background color
                gui.textArea.setForeground(Color.black); // font color
            }
            case "Black" -> {
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black); // background color
                gui.textArea.setForeground(Color.white); // font color
            }
            case "Hacking" -> {
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black); // background color
                gui.textArea.setForeground(Color.green); // font color
            }
            case "Grey" -> {
                gui.window.getContentPane().setBackground(Color.gray);
                gui.textArea.setBackground(Color.lightGray); // background color
                gui.textArea.setForeground(Color.black); // font color
            }
        }
    }
}
