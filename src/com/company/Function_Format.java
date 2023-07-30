package com.company;

import java.awt.*;

public class Function_Format {

    GUI gui;
    Font arial, comicSansMS, timesNewRoman;
    String selectedFont;

    public Function_Format(GUI gui){
        this.gui = gui;
    }

    // if the line is long enough to reach the boundary of the window, then the line can be wrapped in window
    public void wordWrap(){

        //checks if the wordWrap is FALSE or not
        if (!gui.wordWrapON){
            gui.wordWrapON = true;
            gui.textArea.setLineWrap(true);//func for wrapping the line
            gui.textArea.setWrapStyleWord(true);//wraps the line between two words
            gui.iWrap.setText("Word Wrap: ON");//set the text from OFF to ON
        }else{
            gui.wordWrapON = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.iWrap.setText("Word Wrap: OFF");//set the text from ON to OFF
        }
    }

    public void font(int fontSize){

        arial = new Font("Arial", Font.PLAIN, fontSize);
        comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
        timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);

        setFont(selectedFont);
    }

    public void setFont(String font){

        selectedFont = font;

        switch (selectedFont) {
            case "Arial" -> gui.textArea.setFont(arial);
            case "Comic Sans MS" -> gui.textArea.setFont(comicSansMS);
            case "Times New Roman" -> gui.textArea.setFont(timesNewRoman);
        }
    }
}
