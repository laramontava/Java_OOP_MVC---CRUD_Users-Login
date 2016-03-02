/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.table.AbstractTableModel;
import app.modules.users.view.manageadmin_view;
import  app.modules.users.model.classes.admin;
import app.modules.pager.pagina;
import app.modules.users.model.classes.singleton;
import static app.modules.users.model.classes.singleton.admin;
import app.utils.functions.*;
import static app.utils.functions.getCadenaAleatoria1;
import static app.utils.functions.getCadenaAleatoria2;

public class miniSimpleTableModel_admin extends AbstractTableModel {
    public static ArrayList<admin> datos = new ArrayList<admin>();
    public static ArrayList<admin> datosaux = new ArrayList<admin>();
    String[] columnas = {"actor_id", "first_name", "last_name", "last_update"};

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
                dev = new Integer(fila.getDni());
                break;

            case 1:
                dev = fila.getName();
                break;

            case 2:
                dev = fila.getSubname();
                break;

            case 3:
                dev = fila.getEmail();
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
                //fila.setActor_id(Integer.parseInt(value.toString()));
                fila.setDni(value.toString());
                break;

            case 1:
                fila.setName(value.toString());
                break;

            case 2:
                fila.setSubname(value.toString());
                break;
            
            case 3:
                //fila.setLast_update((Timestamp) value);
                fila.setEmail(value.toString());
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
        
        admin _admin = null;
        java.util.Date date= new java.util.Date();
        for(int i=1;i<=2000;i++) {
            //_admin = new admin(i, getCadenaAleatoria1(4), getCadenaAleatoria2(8), new Timestamp(date.getTime()));
            addRow(_admin);
            datosaux.add(_admin);
            //singleton.admin.add(_admin);
            singleton.admin.AddAdmin(_admin);
            try {
                Thread.sleep(1); //1 milliseconds
            } catch (Exception e) {
              System.out.println(e);
            }
        }
    }

    /*public void filtrar() {
        datos.clear();
        int cont=0;
        
        String nom=(String) ((JComboBox)combo).getSelectedItem();   
        if(nom!=null){
            for(int i=0;i<datosaux.size();i++) {
                //if(datosaux.get(i).getFirst_name().contains(nom)){
                if(datosaux.get(i).getName().toLowerCase().startsWith(nom.toLowerCase())){
                    addRow(datosaux.get(i));
                    cont++;
                }
            }
            manageadmin_view.jLabel3.setText(String.valueOf(cont));
            System.out.println("word selected: " + nom);
            pagina.initLinkBox();
        }
    }*/

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
        fireTableDataChanged();
    }
}

