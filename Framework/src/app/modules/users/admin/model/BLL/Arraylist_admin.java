package app.modules.users.admin.model.BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import app.classes.singleton_global;
import app.modules.users.admin.model.BLL.lib_ficheros.json;
import app.modules.users.admin.model.BLL.lib_ficheros.txt;
import app.modules.users.admin.model.BLL.lib_ficheros.xml;
import app.modules.users.admin.model.DAO.functions_users;
import app.modules.users.admin.model.classes.admin;

public class Arraylist_admin {

    private ArrayList<admin> admins = new ArrayList<admin>();

    public Arraylist_admin() {
    }

    public ArrayList<admin> getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList<admin> admins) {
        this.admins = admins;
    }

    public admin getAdmin(int pos) {
        return admins.get(pos);
    }
    /**
     * Añade un nuevo admin al array
     * @param admind 
     */
    public void AddAdmin(admin admind) {
        boolean asd = true;
        
        for (int i = 0; i <= admins.size() - 1; i++) {
            if ((admins.get(i)).equals(admind)) {
                JOptionPane.showMessageDialog(null, "Ya existe ese DNI");
                asd = false;
            }
        }
        if (asd) {
            admins.add(admind);
        }
    }
    /**
     * Añade dummies al array
     * @param admind Recoge el nuevo objeto
     */
    public void AddDummies(admin admind) {
        admins.add(admind);
    }
    
    public void editadmin(admin admind) {
        int pos = -1;
        if (admins.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
        } else {
            pos = -1;
            pos = adminfind(admind);
            if (pos != -1) {
               
            } else {
                JOptionPane.showMessageDialog(null, "Existe");
            }
        }
    }

    public void printadmin() {
        if (admins.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
        } else {
            for (int i = 0; i < admins.size(); i++) {
                JOptionPane.showMessageDialog(null, admins.get(i).toString());
            }
        }
    }

    public void adminsearch(admin pideadmin) {
        if (admins.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
        } else {
            pideadmin = functions_users.finddniadmin();
            for (int i = 0; i <= admins.size() - 1; i++) {
                if ((admins.get(i)).equals(pideadmin)) {
                    JOptionPane.showMessageDialog(null, admins.get(i).toString());
                }
            }
        }
    }

    public int buscarDniAdmin(String dni) {
        int pos = 0;
        for (int i = 0; i <= admins.size() - 1; i++) {
            if (admins.get(i).getDni().equals(dni)) {
                pos = i;
            }
        }
        return pos;
    }

    public int adminfind(admin admind) {
        for (int i = 0; i <= admins.size() - 1; i++) {
            if ((admins.get(i)).equals(admind)) {
                return i;
            }
        }
        return -1;
    }

    public void deleteadmin(admin pideadmin) {
        if (admins.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
        } else {
            for (int i = 0; i <= admins.size() - 1; i++) {
                if ((admins.get(i)).equals(pideadmin)) {
                    admins.remove(i);
                }
            }
        }
    }
    public void DeleteA(admin pideadmin) {
        for (int i = 0; i <= admins.size() - 1; i++) {
            if ((admins.get(i)).equals(pideadmin)) {
                admins.remove(i);
            }
        }
    }
    public void openfiles() {
        switch (singleton_global.conf.getFormat()) {
            case "json":
                json.OpenJson();
                break;
            case "txt":
                txt.Opentxt();
                break;
            case "xml":
                xml.Openxml();
                break;
        }
    }

    public void savefiles() {
        if (admins.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
        } else {
            switch (singleton_global.conf.getFormat()) {
                case "json":
                    json.GenerateJson();
                    break;
                case "txt":
                    txt.Generatetxt();
                    break;
                case "xml":
                    xml.Generatexml();
                    break;
            }
        }
    }
    
    public void savejson(){
        json.GenerateJson();
    }
    public void savetxt(){
        txt.Generatetxt();
    }
    public void savexml(){
        xml.Generatexml();
    }
}
