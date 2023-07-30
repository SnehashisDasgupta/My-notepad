package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {

    GUI gui;
    String fileName, fileAddress;

    public Function_File(GUI gui){
        this.gui = gui;
    }

    public void newFile(){
        gui.textArea.setText(""); //generate a new window with no text.
        gui.window.setTitle("New Notes");//title will be 'New'
        fileName = null;
        fileAddress = null;

        System.out.println("NEW FILE CREATED");
    }

    public void openFIle(){

        //select your file by the  location
        FileDialog fileDialog = new FileDialog(gui.window, "Open", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if(fileDialog.getFile() != null){
            fileName = fileDialog.getFile();
            fileAddress = fileDialog.getDirectory();
            gui.window.setTitle(fileName);//loads the name of destination file
        }

        //prints the file name and address in terminal
        System.out.println("Open-> FILE NAME: " + fileName + "     FILE ADDRESS: " + fileAddress);

        try {

            //you need file address to read a file
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileAddress+fileName));

            gui.textArea.setText("");
            String line = null;

            //reads the file line by line from the file
            while ((line = bufferedReader.readLine()) != null){

                //adds the lines from the file to the notepad
                gui.textArea.append(line + "\n");
            }

            bufferedReader.close();
        } catch (Exception e){

            System.out.println("FILE NOT OPENED");
        }
    }

    public void save(){

        if (fileName == null){
            saveAs();
        }else{
            try {

                FileWriter fileWriter = new FileWriter(fileAddress + fileName);
                fileWriter.write(gui.textArea.getText());
                gui.window.setTitle(fileName);
                fileWriter.close();

                //prints the file name and address in terminal
                System.out.println("Save-> FILE NAME: " + fileName + "     FILE ADDRESS: " + fileAddress);

            }catch (Exception e){
                System.out.println("SOMETHING WEST WRONG!!");
            }
        }

    }

    public void saveAs(){

        //return the dialog box to insert name and location of the current file[where you want to save the file].
        FileDialog fileDialog = new FileDialog(gui.window, "Save As", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null){
            fileName = fileDialog.getFile();//name of the saving file
            fileAddress = fileDialog.getDirectory();//address of the saving file[location]
            gui.window.setTitle(fileName);
        }

        //prints the file name and address in terminal
        System.out.println("Save As-> FILE NAME: " + fileName + "     FILE ADDRESS: " + fileAddress);

        try{

            FileWriter fileWriter = new FileWriter(fileAddress + fileName);
            fileWriter.write(gui.textArea.getText());
            fileWriter.close();

        }catch (Exception e){
            System.out.println("SOMETHING WEST WRONG!!");
        }
    }

    public void exit(){
        System.exit(0);
    }
}
