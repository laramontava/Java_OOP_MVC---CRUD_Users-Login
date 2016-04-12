/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.model.BLL;

import app.classes.ConnectionBBDD;
import app.modules.users.admin.model.DAO.DAO_admin;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.miniSimpleTableModel_admin;
import app.modules.users.admin.model.classes.singleton;
import app.modules.users.admin.model.utils.pager.pagina;
//import static app.modules.users.admin.view.adminmain_view.selected;
import static app.modules.users.admin.view.adminmanage_view.TABLA;
import static app.modules.users.admin.view.adminmanage_view.selected;
import static app.modules.users.admin.view.adminmanage_view.statusnewadmin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lara
 */
public class BLL_admin {

    public static void DniValidate() {
        DAO_admin.pidedni();
    }

    public static void NameValidate() {
        DAO_admin.pidenombre();
    }

    public static void SurnameValidate() {
        DAO_admin.pideapellidos();
    }

    public static void MobileValidate() {
        DAO_admin.pidetelefono();
    }

    public static void EmailValidate() {
        DAO_admin.pideemail();
    }

    public static void UserNameValidate() {
        DAO_admin.pideusuario();
    }

    public static void PasswordValidate() {
        DAO_admin.pidecontrasenya();
    }

    public static boolean adminsave() {
        return DAO_admin.saveadmin();
    }

    public static void DateBirthdayValidate() {
        DAO_admin.pidefechanacimiento();
    }

    public static void SalaryValidate() {
        DAO_admin.pidesalario();
    }

    public static void ActivityValidate() {
        DAO_admin.pideactividad();
    }

    public static void Contratacion() {
        DAO_admin.pidefechacontratacion();
    }

    public static boolean Modificar() {
        String dni = "";
        int pos = 0;
        String ID;
        boolean correct = false;
        int n, selected, inicio, selected1;
        if (((miniSimpleTableModel_admin) TABLA.getModel()).getRowCount() != 0) {
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
            selected1 = inicio + selected;
            if (selected1 == -1) {
                statusnewadmin.setText("Debes seleccionar un admin para editarlo");
                correct = false;
            } else {

                correct = true;
            }
        } else {
            statusnewadmin.setText("No hay ningún usuario administrador");
            correct = false;
        }
        return correct;
    }
    public static boolean Modificaradmin(){
        return DAO_admin.saveeditadmin();
    }
    public static void LlenarCampos() {
        int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
        int selected1 = inicio + selected;
        DAO_admin.fillfields(selected1);
    }

    public static void Delete() {
        String dni = "";
        int pos = 0;
        String ID;
        int n, selected, inicio, selected1;
        if (((miniSimpleTableModel_admin) TABLA.getModel()).getRowCount() != 0) {
            //int selected = TABLA.getSelectedRow();//sustituir
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            selected = TABLA.getSelectedRow(); //nos situamos en la fila
            selected1 = inicio + selected; //nos situamos en la fila correspondiente de esa página

            if (selected1 == -1) {
                statusnewadmin.setText("Debes seleccionar un admin para eliminarlo");
            } else {
                dni = (String) TABLA.getModel().getValueAt(selected1, 0);
                pos = singleton.admin.buscarDniAdmin(dni);
                ((miniSimpleTableModel_admin) TABLA.getModel()).removeRow(selected1);
                singleton.admin.DeleteA(singleton.admin.getAdmin(pos));
                statusnewadmin.setText("Usuario eliminado correctamente");
            }
        } else {
            statusnewadmin.setText("No hay ningún usuario administrador");
        }
    }
    /*---- BBDD ----*/
    public static boolean guardarDatosAdminBBDD() throws SQLException{
        boolean e = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        
        _con = _conexion_DB.AbrirConexion();
        DAO_admin.guardarDatosAdmin(_con);
        _conexion_DB.CerrarConexion(_con);
        return e;
    }
    
    public static boolean crearAdminBBDD() throws SQLException{
        boolean correct = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        _con = _conexion_DB.AbrirConexion();
        correct = DAO_admin.crearAdmin(_con);
        _conexion_DB.CerrarConexion(_con);
        return correct;
    }
    
    public static boolean mostrarAdminBBDD(){
        boolean correct = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        _con = _conexion_DB.AbrirConexion();
        DAO_admin.mostrarAdmin(_con);
        _conexion_DB.CerrarConexion(_con);
        return correct;
    }
}
