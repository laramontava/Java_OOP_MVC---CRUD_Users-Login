/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.registered_user.model.classes;

import static app.modules.users.registered_user.controller.reguser_controller.combo;
import static app.modules.users.registered_user.model.classes.singleton_reguser.reguser;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import app.modules.users.registered_user.model.utils.pager.pagina;
import app.modules.users.registered_user.view.regusermanage_view;
import static app.modules.users.registered_user.view.regusermanage_view.jLabel3;

public class miniSimpleTableModel_reguser extends AbstractTableModel {

    public static ArrayList<registered_user> datos = new ArrayList<registered_user>();
    public static ArrayList<registered_user> datosaux = new ArrayList<registered_user>();
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
        registered_user fila = (registered_user) datos.get(row);

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
        registered_user fila = (registered_user) datos.get(row);

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

    public void addRow(registered_user usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        System.out.println("Entra cargar");
        datos.clear();
        datosaux.clear();
       for (int i = 0; i < singleton_reguser.reguser.getUserreg().size(); i++) {
            addRow(singleton_reguser.reguser.getUserreg().get(i));
            datosaux.add(singleton_reguser.reguser.getUserreg().get(i));
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
                regusermanage_view.jLabel3.setText(String.valueOf(cont));
                //        System.out.println("word selected: " + nom);
                pagina.initLinkBox();
            } 
    }

    public registered_user buscar(String u) {
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

    public int buscaUsuario(registered_user u) {
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
        jLabel3.setText(String.valueOf(reguser.getUserreg().size()-1));
        fireTableDataChanged();
        pagina.initLinkBox();
    }
}
