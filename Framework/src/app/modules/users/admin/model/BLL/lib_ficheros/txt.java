package app.modules.users.admin.model.BLL.lib_ficheros;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.classes.singleton_global;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.singleton;

public class txt {
	public static void Generatetxt() {
		String PATH = null;
	       try {
	           File f;
	           JFileChooser fileChooser = new JFileChooser();
	           int seleccion = fileChooser.showSaveDialog(null);
	           if (seleccion == JFileChooser.APPROVE_OPTION) {
	               File JFC = fileChooser.getSelectedFile();
	               PATH = JFC.getAbsolutePath();
	               PATH=PATH+ ".txt";
	               f = new File(PATH);
	               
	               FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(singleton.admin.getAdmins());
				o.close();
	               JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
	           }
	       } catch (Exception e) {
	       	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
	       }
    }
    
    @SuppressWarnings("unchecked")
	public static void Opentxt() {
    	String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setAcceptAllFileFilterUsed(false);
            fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Text (*.txt)", "txt"));
            int seleccion = fileChooser.showOpenDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                f = new File(PATH);
                
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			singleton.admin.setAdmins((ArrayList<admin>)oi.readObject());
    			oi.close();
            }
        } catch (Exception e) {
        	JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    	
    }
    
    public static void Generatetxtauto() {
		String PATH = null;
	       try {
	           File f;
	           if(!singleton_global.conf.getDummies())
	               PATH=new java.io.File(".").getCanonicalPath()+"/src/app/modules/users/files/files_admin/admin.txt";
	           else
	        	   PATH=new java.io.File(".").getCanonicalPath()+"/src/app/modules/users/files/files_dummies_admin/admin.txt";
	               f = new File(PATH);
	               
	               FileOutputStream fo=new FileOutputStream(f);
				ObjectOutputStream o=new ObjectOutputStream(fo);
				o.writeObject(singleton.admin.getAdmins());
				o.close();
	               //JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
	           
	       } catch (Exception e) {
	       	JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
	       }
    }
    @SuppressWarnings("unchecked")
    public static void Opentxtauto() {
    	String PATH = null;
        try {
            File f;
            if(!singleton_global.conf.getDummies())
            	PATH = new java.io.File(".").getCanonicalPath()+"/src/app/modules/users/files/files_admin/admin.txt";
            else
            	PATH=new java.io.File(".").getCanonicalPath()+"/src/app/modules/users/files/files_dummies_admin/admin.txt";
                f = new File(PATH);
                FileInputStream fi=new FileInputStream(f);
    			ObjectInputStream oi=new ObjectInputStream(fi);
    			singleton.admin.setAdmins((ArrayList<admin>)oi.readObject());
    			oi.close();
            
        } catch (Exception e) {
        	
        }
    }
    /*Client-----*/
    }
