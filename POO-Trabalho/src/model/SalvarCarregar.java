package model;


import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;


import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ControladorTabuleiro;
public class SalvarCarregar {
	

	
public boolean saveGames(){
        
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save As");   
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Saved Games","sav");
        fileChooser.setFileFilter(filter);
 
        int userSelection = fileChooser.showSaveDialog(null);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try{
                FileOutputStream fos = new FileOutputStream(fileToSave.getAbsolutePath()+".sav");
                ObjectOutputStream oos = new ObjectOutputStream(fos);

                oos.writeObject(ControladorTabuleiro.getTabuleiro());
                oos.close();
                fos.close();
            }
            catch(IOException e){
              e.printStackTrace();
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
            return true;
        }
        return false;
    }

    public void loadGames(){
    	
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Open Saved Game");   
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Saved Games","sav");
        fileChooser.setFileFilter(filter);
 
        int userSelection = fileChooser.showOpenDialog(null);
 
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try{
                FileInputStream fis = new FileInputStream(fileToSave.getAbsolutePath());
                ObjectInputStream ois = new ObjectInputStream(fis);

                Tabuleiro boardLoaded=(Tabuleiro)ois.readObject();
                ControladorTabuleiro.setTabuleiro(boardLoaded);
                ois.close();
                fis.close();
            }
            catch(Exception e){
              e.printStackTrace();
            }
            System.out.println("Save as file: " + fileToSave.getAbsolutePath());
           
        }
       

    }
    
}
