/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.client.model.classes;

import static app.modules.users.client.controller.client_controller.combo;
import app.modules.users.client.model.BLL.BLL_client;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import app.modules.users.client.model.utils.pager.pagina;
import static app.modules.users.client.model.classes.singleton_client.client;
import app.modules.users.client.view.clientmanage_view;
import static app.modules.users.client.view.clientmanage_view.jLabel3;

public class miniSimpleTableModel_client extends AbstractTableModel {

    public static ArrayList<client> datos = new ArrayList<client>();
    public static ArrayList<client> datosaux = new ArrayList<client>();
    String[] columnas = {"dni", "first_name", "last_name"};

    ////////////////////estos métodos son necesarios para que jtable funcione/////////////////////
    @Override
    public String getColumnName(int col) {
        return columnas[col].toString();
    }
    
    //Devuelve el numero de filas
    @Override
    public int getRowCount() {
        return datos.size();
    }

    //Devuelve el numero de columnas
    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    //Devuelve el valor del objeto en la fila y columna
    @Override
    public Object getValueAt(int row, int col) {

        Object dev = null;
        client fila = (client) datos.get(row);

        switch (col) {
            case 0:
                dev = fila.getDni();
                break;

            case 1:
                dev = fila.getName();
                break;

            case 2:
                dev = fila.getSubname();
                break;


        }
        return dev;
    }

    //Determina si una fila y columna ha de ser editable
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }

    //Actualiza un objeto de una fila y columna
    @Override
    public void setValueAt(Object value, int row, int col) {
        client fila = (client) datos.get(row);

        switch (col) {
            case 0:
                fila.setDni(value.toString());
                break;

            case 1:
                fila.setName(value.toString());
                break;

            case 2:
                fila.setSubname(value.toString());
                break;


        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(client usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        singleton_client.client.getClients().clear();
        BLL_client.ReadClientMongo();
        for (int i = 0; i < singleton_client.client.getClients().size(); i++) {
            addRow(singleton_client.client.getClients().get(i));
            datosaux.add(singleton_client.client.getClients().get(i));
        }
    }

    public void filtrar() {
        datos.clear();
        int cont = 0;

        String nom = (String) ((JComboBox) combo).getSelectedItem();
        
            if (nom != null) {
                for (int i = 0; i < datosaux.size(); i++) {
                    if (datosaux.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())) {
                        addRow(datosaux.get(i));
                        cont++;
                    }
                }
                clientmanage_view.jLabel3.setText(String.valueOf(cont));
                pagina.initLinkBox();
            } 
    }

    public client buscar(String u) {
        datos.clear();
        cargar();

        String res;
        for (int i = 0; i < datos.size(); i++) {
            res = datos.get(i).toString();
            if (res.contains(u)) {
                return datos.get(i);
            }
        }
        return null;
    }

    public int buscaUsuario(client u) {
        datos.clear();
        cargar();

        for (int i = 0; i < datos.size(); i++) {
            if (datos.get(i).equals(u)) {
                return i;
            }
        }
        return -1;
    }

    public void removeRow(int fila) {
        datos.remove(fila);
        jLabel3.setText(String.valueOf(client.getClients().size()-1));
        fireTableDataChanged();
        pagina.initLinkBox();
    }
}
