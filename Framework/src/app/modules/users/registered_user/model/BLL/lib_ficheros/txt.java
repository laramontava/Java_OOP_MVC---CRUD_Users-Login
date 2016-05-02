package app.modules.users.registered_user.model.BLL.lib_ficheros;

import java.io.*;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import app.classes.singleton_global;
import app.modules.users.registered_user.model.classes.registered_user;
import app.modules.users.registered_user.model.classes.singleton_reguser;

public class txt {
    /**
     * Genera un fichero txt
     */
    public static void Generatetxt() {
        String PATH = null;
        try {
            File f;
            JFileChooser fileChooser = new JFileChooser();
            int seleccion = fileChooser.showSaveDialog(null);
            if (seleccion == JFileChooser.APPROVE_OPTION) {
                File JFC = fileChooser.getSelectedFile();
                PATH = JFC.getAbsolutePath();
                PATH = PATH + ".txt";
                f = new File(PATH);

                FileOutputStream fo = new FileOutputStream(f);
                ObjectOutputStream o = new ObjectOutputStream(fo);
                o.writeObject(singleton_reguser.reguser.getUserreg());
                o.close();
                JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Abre un fichero txt
     */
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

                FileInputStream fi = new FileInputStream(f);
                ObjectInputStream oi = new ObjectInputStream(fi);
                singleton_reguser.reguser.setUserreg((ArrayList<registered_user>) oi.readObject());
                oi.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al leer el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    /**
     * Genera un fichero txt automáticamente
     */
    public static void Generatetxtauto() {
        String PATH = null;
        try {
            File f;
            if (!singleton_global.conf.getDummies()) {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/registered_user/model/files/files_registereduser/reguser.txt";
            } else {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/registered_user/model/files/files_registereduser/reguser.txt";
            }
            f = new File(PATH);

            FileOutputStream fo = new FileOutputStream(f);
            ObjectOutputStream o = new ObjectOutputStream(fo);
            o.writeObject(singleton_reguser.reguser.getUserreg());
            o.close();
            //JOptionPane.showMessageDialog(null, "Archivo TXT guardado con exito", "Archivo TXT", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al grabar el TXT", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    /**
     * Abre un fichero txt automáticamente
     */
    @SuppressWarnings("unchecked")
    public static void Opentxtauto() {
        String PATH = null;
        try {
            File f;
            if (!singleton_global.conf.getDummies()) {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/registered_user/model/files/files_registereduser/reguser.txt";
            } else {
                PATH = new java.io.File(".").getCanonicalPath() + "/src/app/modules/users/registered_user/model/files/files_registereduser/reguser.txt";
            }
            f = new File(PATH);
            FileInputStream fi = new FileInputStream(f);
            ObjectInputStream oi = new ObjectInputStream(fi);
            singleton_reguser.reguser.setUserreg((ArrayList<registered_user>) oi.readObject());
            oi.close();

        } catch (Exception e) {

        }
    }
}
