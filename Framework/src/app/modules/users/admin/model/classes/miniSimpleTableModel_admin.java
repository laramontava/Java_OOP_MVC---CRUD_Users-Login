/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.model.classes;

import app.classes.singleton_global;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import app.modules.users.admin.model.utils.pager.pagina;
import static app.modules.users.admin.model.classes.singleton.admin;
import app.modules.users.admin.view.adminmanage_view;
import static app.modules.users.admin.controller.admin_controller.combo;
import app.modules.users.admin.model.BLL.BLL_admin;
import static app.modules.users.admin.view.adminmanage_view.jLabel3;

public class miniSimpleTableModel_admin extends AbstractTableModel {

    public static ArrayList<admin> datos = new ArrayList<admin>();
    public static ArrayList<admin> datosaux = new ArrayList<admin>();
    String[] columnas = {"dni", "first_name", "last_name", "hiring_date"};

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
        admin fila = (admin) datos.get(row);

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

            case 3:
                String dia="", mes="", anyo="", fecha="";
                switch (singleton_global.conf.getDate()) {
                    case 'a': //dd/MM/yyyy
                        dev = fila.getHiring_date();
                        break;
                    case 'b': //dd-MM-yyyy
                        fecha=fila.getHiring_date();
                        dia+=fecha.charAt(0)+"";
                        dia+=fecha.charAt(1)+"";
                        mes+=fecha.charAt(3)+"";
                        mes+=fecha.charAt(4)+"";
                        anyo+=fecha.charAt(6)+"";
                        anyo+=fecha.charAt(7)+"";
                        anyo+=fecha.charAt(8)+"";
                        anyo+=fecha.charAt(9)+"";
                        dev = dia+"-"+mes+"-"+anyo;
                        break;
                    case 'c': //yyyy/MM/dd
                        fecha=fila.getHiring_date();
                        dia+=fecha.charAt(0)+"";
                        dia+=fecha.charAt(1)+"";
                        mes+=fecha.charAt(3)+"";
                        mes+=fecha.charAt(4)+"";
                        anyo+=fecha.charAt(6)+"";
                        anyo+=fecha.charAt(7)+"";
                        anyo+=fecha.charAt(8)+"";
                        anyo+=fecha.charAt(9)+"";
                        dev = anyo+"/"+mes+"/"+dia;
                        break;
                    case 'd': //yyyy-MM-dd
                        fecha=fila.getHiring_date();
                        dia+=fecha.charAt(0)+"";
                        dia+=fecha.charAt(1)+"";
                        mes+=fecha.charAt(3)+"";
                        mes+=fecha.charAt(4)+"";
                        anyo+=fecha.charAt(6)+"";
                        anyo+=fecha.charAt(7)+"";
                        anyo+=fecha.charAt(8)+"";
                        anyo+=fecha.charAt(9)+"";
                        dev = anyo+"-"+mes+"-"+dia;
                        break;
                }

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
        admin fila = (admin) datos.get(row);

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

            case 3:
                fila.setHiring_date(value.toString());
                break;

        }
        fireTableCellUpdated(row, col);
    }

    public void addRow(admin usu) {
        datos.add(usu);
        fireTableDataChanged();
    }

    public void cargar() {
        datos.clear();
        datosaux.clear();
        BLL_admin.mostrarAdminBBDD();
        for (int i = 0; i < singleton.admin.getAdmins().size(); i++) {
            addRow(singleton.admin.getAdmins().get(i));
            datosaux.add(singleton.admin.getAdmins().get(i));
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
            adminmanage_view.jLabel3.setText(String.valueOf(cont));
            //        System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }

    public admin buscar(String u) {
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

    public int buscaUsuario(admin u) {
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
        jLabel3.setText(String.valueOf(admin.getAdmins().size() - 1));
        fireTableDataChanged();
        pagina.initLinkBox();
    }
}
