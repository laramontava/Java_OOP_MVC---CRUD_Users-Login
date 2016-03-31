package app.modules.users.client.model.BLL;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import app.classes.singleton_global;
import app.modules.users.client.model.BLL.lib_ficheros.json;
import app.modules.users.client.model.classes.client;
import app.modules.users.client.model.BLL.lib_ficheros.txt;
import app.modules.users.client.model.BLL.lib_ficheros.xml;

public class Arraylist_client {

    private ArrayList<client> clients = new ArrayList<client>();

    public Arraylist_client() {

    }

    public ArrayList<client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<client> clients) {
        this.clients = clients;
    }

    public void AddClient(client clientd) {
        boolean asd = true;
        /*    int pos = -1;
        clientd = functions_users.finddniclient();
        pos = ClientFind(clientd);
        if (pos != -1) {
            JOptionPane.showMessageDialog(null, "Existe");
        } else {
            clientd = functions_users.pideclient();
            clients.add(clientd);
        }*/
        for (int i = 0; i <= clients.size() - 1; i++) {
            if ((clients.get(i)).equals(clientd)) {
                JOptionPane.showMessageDialog(null, "Ya existe ese DNI");
                asd = false;
            }
        }
        if (asd) {
            clients.add(clientd);
        }
    }
    
    public client getClient(int pos) {
        return clients.get(pos);
    }
    
    public void AddDummies(client clientd) {
        clients.add(clientd);
    }

/*    public void EditClient(client clientd) {
        int pos = -1;
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
        } else {
            clientd = functions_users.finddniclient();
            pos = ClientFind(clientd);
            if (pos != -1) {
                functions_users.cambiauser(clients.get(pos));
            } else {
                JOptionPane.showMessageDialog(null, "Existe");
            }
        }

    }*/
    
  /*  public void editClient(client clientd) {
        int pos = -1;
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
        } else {
            pos = -1;
            pos = clientfind(clientd);
            if (pos != -1) {
                functions_users.cambiauser(clients.get(pos));
            } else {
                JOptionPane.showMessageDialog(null, "Existe");
            }
        }
    }*/
    
    public int clientfind(client clientd) {
        for (int i = 0; i <= clients.size() - 1; i++) {
            if ((clients.get(i)).equals(clientd)) {
                return i;
            }
        }
        return -1;
    }
    
    public void PrintClient() {
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ning�n cliente creado");
        } else {
            for (int i = 0; i < clients.size(); i++) {
                JOptionPane.showMessageDialog(null, clients.get(i).toString());
            }
        }
    }

/*    public void orderby(int i) {
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ningún cliente creado");
        } else {
            switch (i) {
                case 0:
                    Collections.sort(clients);
                    break;
                case 1:
                    Collections.sort(clients, new ordername());
                    break;
                case 2:
                    Collections.sort(clients, new orderdatebirthday());
                    break;
            }
        }
    }*/

 /*   public void clientsearch(client pidecliente) {
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ning�n cliente creado");
        } else {
            pidecliente = functions_users.finddniclient();

            for (int i = 0; i <= clients.size() - 1; i++) {
                if ((clients.get(i)).equals(pidecliente)) {
                    JOptionPane.showMessageDialog(null, clients.get(i).toString());
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha encontrado");
                }
            }
        }
    }*/

    public int ClientFind(client clientd) {
        for (int i = 0; i <= clients.size() - 1; i++) {
            if ((clients.get(i)).equals(clientd)) {
                return i;
            }
        }
        return -1;
    }

/*    public void DeleteClient(client pidecliente) {
        if (clients.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay ning�n cliente creado");
        } else {
            pidecliente = functions_users.finddniclient();
            //pidecliente.setDni(kernel.pedirdatos("dni", "Introduce DNI que quieres buscar", "Buscar", translate));
            for (int i = 0; i <= clients.size() - 1; i++) {
                if ((clients.get(i)).equals(pidecliente)) {
                    clients.remove(i);
                }
            }
        }
    }*/

    public int buscarDniClient(String dni) {
        int pos = 0;
        for (int i = 0; i <= clients.size() - 1; i++) {
            if (clients.get(i).getDni().equals(dni)) {
                pos = i;
            }
        }
        return pos;
    }
    
    public void DeleteC(client pideclient) {
        for (int i = 0; i <= clients.size() - 1; i++) {
            if ((clients.get(i)).equals(pideclient)) {
                clients.remove(i);
            }
        }
    }
    
    public void openfiles() {
        switch (singleton_global.conf.getFormat()) {
            case "json":
                json.OpenJsonauto();
                break;
            case "txt":
                //txt.Opentxt();
                break;
            case "xml":
                //xml.Openxml();
                break;
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
