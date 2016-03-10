package app.modules.users.admin.model.BLL;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JOptionPane;
import app.classes.singleton_global;
import app.modules.users.admin.model.BLL.lib_ficheros.json;
import app.modules.users.admin.model.BLL.lib_ficheros.txt;
import app.modules.users.admin.model.BLL.lib_ficheros.xml;
import app.modules.users.admin.model.DAO.functions_users;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.orderdatebirthday;
import app.modules.users.admin.model.classes.ordername;

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

    public void AddAdmin(admin admind) {
        boolean asd = true;
        /*int pos = -1;
        admind = functions_users.finddniadmin();
        pos = adminfind(admind);

        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "Existe");
        } else {
            admins.add(admind);
        }*/
        for (int i = 0; i <= admins.size() - 1; i++) {
            if ((admins.get(i)).equals(admind)) {
                JOptionPane.showMessageDialog(null, "Ya existe ese deneí");
                asd = false;
            }
        }
        if (asd) {
            admins.add(admind);
        }
    }

    public void AddDummies(admin admind) {
        admins.add(admind);
    }

    public void editadmin(admin admind) {
        int pos = -1;
        if (admins.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
        } else {
            pos = -1;
            //nipaadmind = functions_users.finddniadmin();
            pos = adminfind(admind);
            if (pos != -1) {
                //admins.get(pos);
                functions_users.cambiauser(admins.get(pos));
                //admins.set(pos, admind);
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

    public void orderby(int i) {
        if (admins.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún admin creado");
        } else {
            switch (i) {
                case 0:
                    Collections.sort(admins);
                    break;
                case 1:
                    Collections.sort(admins, new ordername());
                    break;
                case 2:
                    Collections.sort(admins, new orderdatebirthday());
                    break;
            }
        }
    }
    //Collections.sort(AL_cli); compareto user => dni

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
            if (admins.get(i).getDni()==dni) {
                System.out.println("Entra al if");
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
            pideadmin = functions_users.finddniadmin();
            //pideadmin = functions.validatestring("Introdudce DNI del admin que quiers eliminar", "Delete");
            for (int i = 0; i <= admins.size() - 1; i++) {
                if ((admins.get(i)).equals(pideadmin)) {
                    admins.remove(i);
                }
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
