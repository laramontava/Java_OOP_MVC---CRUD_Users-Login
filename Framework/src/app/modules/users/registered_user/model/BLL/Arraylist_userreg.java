package app.modules.users.registered_user.model.BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import app.modules.users.admin.model.DAO.functions_users;
import app.modules.users.registered_user.model.BLL.lib_ficheros.json;
import app.modules.users.registered_user.model.BLL.lib_ficheros.txt;
import app.modules.users.registered_user.model.BLL.lib_ficheros.xml;
import app.modules.users.registered_user.model.classes.registered_user;

public class Arraylist_userreg {

    private ArrayList<registered_user> rusers = new ArrayList<registered_user>();

    public Arraylist_userreg() {

    }

    public ArrayList<registered_user> getUserreg() {
        return rusers;
    }

    public void setUserreg(ArrayList<registered_user> rusers) {
        this.rusers = rusers;
    }
    
    public void AddUserreg(registered_user ruserd) {
        boolean asd = true;
        /*int pos = -1;
		ruserd = functions_users.finddniuserreg();
		JOptionPane.showMessageDialog(null, ruserd);
		pos = UserregFind(ruserd);
		if(pos!=-1){
			JOptionPane.showMessageDialog(null, "Existe");
		}
		else{
			ruserd = functions_users.pideregistrado();
			rusers.add(ruserd);
		}*/

        for (int i = 0; i <= rusers.size() - 1; i++) {
            if ((rusers.get(i)).equals(ruserd)) {
                JOptionPane.showMessageDialog(null, "Ya existe ese DNI");
                asd = false;
            }
        }
        if (asd) {
            rusers.add(ruserd);
        }
    }
    
    public registered_user getClient(int pos) {
        return rusers.get(pos);
    }
    
    public void AddDummies(registered_user ruserd) {
        rusers.add(ruserd);
    }
    
/*    public void EditUserreg(registered_user ruserd) {
        int pos = -1;
        if (rusers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
        } else {
            pos = -1;
            ruserd = functions_users.finddniuserreg();
            pos = UserregFind(ruserd);
            if (pos != -1) {
                //admins.get(pos);
                functions_users.cambiauser(rusers.get(pos));
                //admins.set(pos, admind);
            } else {
                JOptionPane.showMessageDialog(null, "Existe");
            }
        }

    }*/

/*    public void PrintUserreg() {
        if (rusers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
        } else {
            for (int i = 0; i < rusers.size(); i++) {
                JOptionPane.showMessageDialog(null, rusers.get(i).toString());
            }
        }
    }*/

    //Collections.sort(AL_cli); compareto user => dni

 /*   public void UserregSearch(registered_user ruserd) {
        if (rusers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
        } else {
            ruserd = functions_users.finddniuserreg();
            for (int i = 0; i <= rusers.size() - 1; i++) {
                if ((rusers.get(i)).equals(ruserd)) {
                    JOptionPane.showMessageDialog(null, rusers.get(i).toString());
                }
            }
        }
    }*/

    public int UserregFind(registered_user ruserd) {
        for (int i = 0; i <= rusers.size() - 1; i++) {
            if ((rusers.get(i)).equals(ruserd)) {
                return i;
            }
        }
        return -1;
    }
    
    public int buscarDniRegUser(String dni) {
        int pos = 0;
        for (int i = 0; i <= rusers.size() - 1; i++) {
            if (rusers.get(i).getDni().equals(dni)) {
                pos = i;
            }
        }
        return pos;
    }

    public void DeleteRU(registered_user pidereguser) {
        for (int i = 0; i <= rusers.size() - 1; i++) {
            if ((rusers.get(i)).equals(pidereguser)) {
                rusers.remove(i);
            }
        }
    }
    
    
    
/*    public void DeleteUserreg(registered_user ruserd) {
        if (rusers.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ning�n usuario registrado creado");
        } else {
            ruserd = functions_users.finddniuserreg();
            for (int i = 0; i <= rusers.size() - 1; i++) {
                if ((rusers.get(i)).equals(ruserd)) {
                    rusers.remove(i);
                }
            }
        }
    }*/
    
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
