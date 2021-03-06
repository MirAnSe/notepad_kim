import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.print.PrinterException;
import java.io.*;

class Viewer {
    JTextArea textArea;
    boolean hasChanges = false;
    private printDocument PD = new printDocument();

    Viewer(){
        Controller controller = new Controller (this);
        JFrame frame = new JFrame("Notepad-- All Right reserved by Banderas © Copyright 1888-2019");
        textArea = new JTextArea();
        JScrollPane scroll = new JScrollPane(textArea);
        JMenuBar jMenuBar = new JMenuBar();
        JFileChooser fileOpen = new JFileChooser();
        JMenu menuFile = new JMenu("File");


        ImageIcon createMenuItemIcon = new ImageIcon("src/icons/new.png");
        JMenuItem createMenuItem = new JMenuItem("New", createMenuItemIcon);
        createMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        createMenuItem.addActionListener(controller);
        createMenuItem.setActionCommand("New");


        ImageIcon openMenuItemIcon = new ImageIcon("src/icons/open.png");
        JMenuItem openMenuItem = new JMenuItem("Open", openMenuItemIcon);
        openMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openMenuItem.addActionListener(controller);
        openMenuItem.setActionCommand("Open");


        ImageIcon saveMenuItemIcon = new ImageIcon("src/icons/save.png");
        JMenuItem saveMenuItem = new JMenuItem("Save", saveMenuItemIcon);
        saveMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveMenuItem.addActionListener(controller);
        saveMenuItem.setActionCommand("Save");

        ImageIcon saveAsMenuItemIcon = new ImageIcon("src/icons/saveas.png");
        JMenuItem saveAsMenuItem = new JMenuItem("Save As ...", saveAsMenuItemIcon);
        saveAsMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK+ InputEvent.ALT_MASK));
        saveAsMenuItem.addActionListener(controller);
        saveAsMenuItem.setActionCommand("SaveAs");

//        JMenuItem pageSetupMenuItem = new JMenuItem("Page Setup ...");

        ImageIcon printMenuItemIcon = new ImageIcon("src/icons/print.png");
        JMenuItem printMenuItem = new JMenuItem("Print ...", printMenuItemIcon);
        printMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        printMenuItem.addActionListener(controller);
        printMenuItem.setActionCommand("Print");


        JMenuItem closeMenuItem = new JMenuItem("Exit");
        closeMenuItem.addActionListener(controller);
        closeMenuItem.setActionCommand("Exit");


        menuFile.add(createMenuItem);
        menuFile.add(openMenuItem);
        menuFile.add(saveMenuItem);
        menuFile.add(saveAsMenuItem);
        menuFile.add(new JSeparator());
//        menuFile.add(pageSetupMenuItem);
        menuFile.add(printMenuItem);
        menuFile.add(new JSeparator());
        menuFile.add(closeMenuItem);

        JMenu menuEdit = new JMenu("Edit");

        ImageIcon undoMenuItemIcon = new ImageIcon("src/icons/undo.png");
        JMenuItem undoMenuItem = new JMenuItem("Undo", undoMenuItemIcon);
        undoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
        undoMenuItem.addActionListener(controller);
        undoMenuItem.setActionCommand("Undo");

        ImageIcon redoMenuItemIcon = new ImageIcon("src/icons/redo.png");
        JMenuItem redoMenuItem = new JMenuItem("Redo", redoMenuItemIcon);
        redoMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK+ InputEvent.ALT_MASK));
        redoMenuItem.addActionListener(controller);
        redoMenuItem.setActionCommand("Redo");

        ImageIcon cutMenuItemIcon = new ImageIcon("src/icons/cut.png");
        JMenuItem cutMenuItem = new JMenuItem("Cut", cutMenuItemIcon);
        cutMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
        cutMenuItem.addActionListener(controller);
        cutMenuItem.setActionCommand("Cut");

        ImageIcon copyMenuItemIcon = new ImageIcon("src/icons/copy.png");
        JMenuItem copyMenuItem = new JMenuItem("Copy", copyMenuItemIcon);
        copyMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        copyMenuItem.addActionListener(controller);
        copyMenuItem.setActionCommand("Copy");

        ImageIcon pastMenuItemIcon = new ImageIcon("src/icons/past.png");
        JMenuItem pastMenuItem = new JMenuItem("Past", pastMenuItemIcon);
        pastMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        pastMenuItem.addActionListener(controller);
        pastMenuItem.setActionCommand("Past");

        ImageIcon deleteMenuItemIcon = new ImageIcon("src/icons/delete.png");
        JMenuItem deleteMenuItem = new JMenuItem("Delete", deleteMenuItemIcon);
        deleteMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
        deleteMenuItem.addActionListener(controller);
        deleteMenuItem.setActionCommand("Delete");

        ImageIcon findMenuItemIcon = new ImageIcon("src/icons/find.png");
        JMenuItem findMenuItem = new JMenuItem("Find", findMenuItemIcon);
        findMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
        findMenuItem.addActionListener(controller);
        findMenuItem.setActionCommand("Find");

        ImageIcon findNextMenuItemIcon = new ImageIcon("src/icons/null.png");
        JMenuItem findNextMenuItem = new JMenuItem("Find Next", findNextMenuItemIcon);
        findNextMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, 0));
        findNextMenuItem.addActionListener(controller);
        findNextMenuItem.setActionCommand("FindNext");

        ImageIcon replaceMenuItemIcon = new ImageIcon("src/icons/replace.png");
        JMenuItem replaceMenuItem = new JMenuItem("Replace ...", replaceMenuItemIcon);
        replaceMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
        replaceMenuItem.addActionListener(controller);
        replaceMenuItem.setActionCommand("Replace");

        ImageIcon goToMenuItemIcon = new ImageIcon("src/icons/goto.png");
        JMenuItem goToMenuItem = new JMenuItem("Go To...", goToMenuItemIcon);
        goToMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
        goToMenuItem.addActionListener(controller);
        goToMenuItem.setActionCommand("GoTo");

        ImageIcon selectAllMenuItemIcon = new ImageIcon("src/icons/select.png");
        JMenuItem selectAllMenuItem = new JMenuItem("Select All", selectAllMenuItemIcon);
        selectAllMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        selectAllMenuItem.addActionListener(controller);
        selectAllMenuItem.setActionCommand("Select");

        ImageIcon timeDateMenuItemIcon = new ImageIcon("src/icons/time.png");
        JMenuItem timeDateMenuItem = new JMenuItem("Time/Date", timeDateMenuItemIcon);
        timeDateMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0));
        timeDateMenuItem.addActionListener(controller);
        timeDateMenuItem.setActionCommand("Time/Date");


        menuEdit.add(undoMenuItem);
//        menuEdit.add(redoMenuItem);
        menuEdit.add(new JSeparator());
        menuEdit.add(cutMenuItem);
        menuEdit.add(copyMenuItem);
        menuEdit.add(pastMenuItem);
        menuEdit.add(deleteMenuItem);
        menuEdit.add(new JSeparator());
        menuEdit.add(findMenuItem);
        menuEdit.add(findNextMenuItem);
        menuEdit.add(replaceMenuItem);
        menuEdit.add(goToMenuItem);
        menuEdit.add(new JSeparator());
        menuEdit.add(selectAllMenuItem);
        menuEdit.add(timeDateMenuItem);

        JMenu menuFormat = new JMenu("Format");

        ImageIcon wordWrapMenuItemIcon = new ImageIcon("src/icons/warp.png");
        JMenuItem wordWrapMenuItem = new JMenuItem("Word wrap", wordWrapMenuItemIcon);

        ImageIcon fontMenuItemIcon = new ImageIcon("src/icons/font.png");
        JMenuItem fontMenuItem = new JMenuItem("Font", fontMenuItemIcon);


        menuFormat.add(wordWrapMenuItem);
        menuFormat.add(fontMenuItem);


        JMenu menuView = new JMenu("View");

        ImageIcon statusBarMenuItemIcon = new ImageIcon("src/icons/status.png");
        JMenuItem statusBarMenuItem = new JMenuItem("Status Bar", statusBarMenuItemIcon);
        menuView.add(statusBarMenuItem);

        JMenu menuHelp = new JMenu("Help");

        ImageIcon viewHelpMenuItemIcon = new ImageIcon("src/icons/help.png");
        JMenuItem viewHelpMenuItem = new JMenuItem("View help", viewHelpMenuItemIcon);

        ImageIcon aboutTheProgramMenuItemIcon = new ImageIcon("src/icons/about.png");
        JMenuItem aboutTheProgramMenuItem = new JMenuItem("About the program", aboutTheProgramMenuItemIcon);
        menuHelp.add(viewHelpMenuItem);
        menuHelp.add(new JSeparator());
        menuHelp.add(aboutTheProgramMenuItem);


        jMenuBar.add(menuFile);
        jMenuBar.add(menuEdit);
        jMenuBar.add(menuFormat);
        jMenuBar.add(menuView);
        jMenuBar.add(menuHelp);


        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
//        frame.setLocation(100,100);
        frame.add("Center", scroll);
        frame.setJMenuBar(jMenuBar);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close program after exit

    }

    File file; //File name

    public void newFile(){
//         проверка на внесение изменений в текущем файле
//        if (hasChanges){
//            System.out.println("Файл был изменен!");
//        }
//        System.out.println(hasChanges);
        update("");

    }

    public void openFile(){ //open file
        // проверка на внесение изменений в текущем файле

        String text = "";
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text files only", "txt");
        fileChooser.setFileFilter(filter);
        int ret = fileChooser.showDialog(null, "Открыть файл");
        if (ret == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            FileInputStream inF;
            try{

                inF = new FileInputStream(file);
                BufferedReader  in = new BufferedReader(new InputStreamReader(inF, "UTF8"));
                int words;
                while ((words = in.read()) != -1){
                    text = text + (char)words;
                }
                update(text);

            }catch(IOException e){
                System.out.println("Error");
            }
        }
    }

    public void saveFile() { // Save opened file

        try{
            FileWriter fw = new FileWriter(file);
            fw.write(sendText().toString());
            fw.close();

        }catch(IOException e){
            // Окно с ошибкой доступа к файлу (not work)
            saveAsFile();
            System.out.println("Error");

        }catch(NullPointerException e){
            // Save new document
            saveAsFile();
            System.out.println("Error");
        }

    }

    public void saveAsFile(){ // Save As
        String text = "test тест";
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Text files only", "txt");
        fileChooser.setFileFilter(filter);
        int retrival = fileChooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION){
            try{
                FileWriter fw = new FileWriter(fileChooser.getSelectedFile());
                fw.write(sendText().toString());
                fw.close();

            }catch(IOException e){
                System.out.println("Error");
            }
        }

    }

    public void printFile(){
        PD.startPrint();

        /*
        try{
            boolean complite = textArea.print();
            if(complite){
                JOptionPane.showMessageDialog(null, "Done printing", "Information", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "Printing", "Printer", JOptionPane.ERROR_MESSAGE);
            }
        }catch(PrinterException e){
            JOptionPane.showMessageDialog(null, e);
        }*/
    }

    public void exit(){
        System.out.println("GoodBye!");
        System.exit(1);
    }


    public void update(String text){ //Changes in file
        hasChanges = true;
        textArea.setText(text);
    }

    public String sendText(){ // Send text to save action
        String text;
        text = textArea.getText();
        return text;
    }



}