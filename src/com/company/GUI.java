package com.company;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;

    //TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;

    //TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;

    //FILE MENU
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;

    //EDIT MENU
    JMenuItem iUndo, iRedo;

    //FORMAT MENU
    JMenuItem iWrap;
    boolean wordWrapON = false;
    JMenuItem iFontArial, iFontCSMS, iFontTNR; //fonts
    JMenuItem iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28; //fontSize
    JMenu menuFont, menuFontSize;

    //COLOR MENU
    JMenuItem iColor1, iColor2, iColor3, iColor4;


    Function_File file = new Function_File(this);
    Function_Edit edit = new Function_Edit(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);

    KeyHandler keyShortcuts = new KeyHandler(this);

    UndoManager undoManager = new UndoManager();

    public static void main(String[] args) {
        new GUI();
    }

    public GUI(){


        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        colorMenu();

        //default settings
        format.selectedFont = "Arial";
        format.font(16);
        format.wordWrap();
        color.changeColor("Grey");

        window.setVisible(true);
    }

    public void createWindow(){

        window = new JFrame("SNotes");// name of application
        window.setSize(600, 500);//default size of window
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea(){

        textArea = new JTextArea();

        //implements key-shortcuts in the text area
        textArea.addKeyListener(keyShortcuts);

        //to do undo-redo
        textArea.getDocument().addUndoableEditListener(e -> undoManager.addEdit(e.getEdit()));

        //when text reaches the boundary line of default size window, a scroll bar will appear
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());//disable borders from edges
        window.add(scrollPane);
    }

    public void createMenuBar(){
        //menu bar
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        //menu bar options
        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu(){

        iNew = new JMenuItem("New");
        iNew.addActionListener(this);// 'New' option will work now
        iNew.setActionCommand("NEW");//action in 'New' option
        menuFile.add(iNew);

        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("OPEN");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("SAVE");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("Save As");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("SAVE_AS");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("EXIT");
        menuFile.add(iExit);


    }

    public void createEditMenu(){

        iUndo = new JMenuItem("Undo ↩️");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("UNDO");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo ↪️");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("REDO");
        menuEdit.add(iRedo);
    }

    public void createFormatMenu(){

        iWrap = new JMenuItem("Word Wrap: OFF");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("WORD_WRAP");
        menuFormat.add(iWrap);


        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        menuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        menuFont.add(iFontTNR);


        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        menuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        menuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        menuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        menuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        menuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        menuFontSize.add(iFontSize28);

    }

    public void colorMenu(){

        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Hacking");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Hacking");
        menuColor.add(iColor3);

        iColor4 = new JMenuItem("Grey");
        iColor4.addActionListener(this);
        iColor4.setActionCommand("Grey");
        menuColor.add(iColor4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String command = e.getActionCommand();

        if ("NEW".equals(command)) {
            file.newFile();
        }else if("OPEN".equals(command)){
            file.openFIle();
        }else if("SAVE".equals(command)){
            file.save();
        }else if("SAVE_AS".equals(command)){
            file.saveAs();
        }else if("EXIT".equals(command)){
            file.exit();
        }

        else if ("UNDO".equals(command)){
            edit.undo();
        }else if ("REDO".equals(command)){
            edit.redo();
        }

        else  if ("WORD_WRAP".equals(command)){
            format.wordWrap();
        }

        else if("Arial".equals(command)){
            format.setFont("Arial");
        }else if("Comic Sans MS".equals(command)){
            format.setFont(command);
        }else if("Times New Roman".equals(command)){
            format.setFont(command);
        }

        else if ("size8".equals(command)){
            format.font(8);
        }else if ("size12".equals(command)){
            format.font(12);
        }else if ("size16".equals(command)){
            format.font(16);
        }else if ("size20".equals(command)){
            format.font(20);
        }else if ("size24".equals(command)){
            format.font(24);
        }else if ("size28".equals(command)){
            format.font(28);
        }

        else if ("White".equals(command)){
            color.changeColor(command);
        }else if ("Black".equals(command)){
            color.changeColor(command);
        }else if ("Hacking".equals(command)){
            color.changeColor(command);
        }else if ("Grey".equals(command)){
            color.changeColor(command);
        }


    }
}
