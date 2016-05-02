/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.model.BLL;

import app.classes.ConnectionBBDD;
import app.modules.users.admin.model.DAO.DAO_admin;
import app.modules.users.admin.model.classes.miniSimpleTableModel_admin;
import app.modules.users.admin.model.classes.singleton;
import app.modules.users.admin.model.utils.pager.pagina;
import static app.modules.users.admin.view.adminmanage_view.TABLA;
import static app.modules.users.admin.view.adminmanage_view.selected;
import static app.modules.users.admin.view.adminmanage_view.statusnewadmin;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Lara
 */
public class BLL_admin {
    /**
     * Ejecuta el DAO que comprueba que el DNI sea válido
     */
    public static void DniValidate() {
        DAO_admin.pidedni();
    }
    /**
     * Ejecuta el DAO que comprueba que el nombre sea válido
     */
    public static void NameValidate() {
        DAO_admin.pidenombre();
    }
    /**
     * Ejecuta el DAO que comprueba que el apellido sea válido
     */
    public static void SurnameValidate() {
        DAO_admin.pideapellidos();
    }
    /**
     * Ejecuta el DAO que comprueba que el teléfono sea válido
     */
    public static void MobileValidate() {
        DAO_admin.pidetelefono();
    }
    /**
     * Ejecuta el DAO que comprueba que el correo sea válido
     */
    public static void EmailValidate() {
        DAO_admin.pideemail();
    }
    /**
     * Ejecuta el DAO que comprueba que el nombre de usuario sea válido
     */
    public static void UserNameValidate() {
        DAO_admin.pideusuario();
    }
    /**
     * Ejecuta el DAO que comprueba que la contraseña sea válida
     */
    public static void PasswordValidate() {
        DAO_admin.pidecontrasenya();
    }
    /**
     * Ejecuta el DAO que guarda el admin en el array
     * @return True si se ha guardado correctamente
     */
    public static boolean adminsave() {
        return DAO_admin.saveadmin();
    }
    /**
     * Ejecuta el DAO que comprueba que la fecha de aniversario sea correcta
     */
    public static void DateBirthdayValidate() {
        DAO_admin.pidefechanacimiento();
    }
    /**
     * Ejecuta el DAO que comprueba que el salario sea válido
     */
    public static void SalaryValidate() {
        DAO_admin.pidesalario();
    }
    /**
     * Ejecuta el DAO que comprueba que el valor de la actividad sea válido
     */
    public static void ActivityValidate() {
        DAO_admin.pideactividad();
    }
    /**
     * Ejecuta el DAO que comprueba que la fecha de contratación sea correcta
     */
    public static void Contratacion() {
        DAO_admin.pidefechacontratacion();
    }
    /**
     * Devuelve si se ha seleccionado un admin para modificarlo
     * @return True si se ha seleccionado uno, False si no se ha seleccionado o no hay ninguno
     */
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
    /**
     * Guarda los campos modificados del admin
     * @return Devuelve true si se ha modificado correctamente
     */
    public static boolean Modificaradmin(){
        return DAO_admin.saveeditadmin();
    }
    /**
     * Saca la posición del admin en la tabla para rellenar los campos del formulario
     */
    public static void LlenarCampos() {
        int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
        int selected1 = inicio + selected;
        DAO_admin.fillfields(selected1);
    }
    /**
     * Saca la posición del admin para luego eliminarlo del array
     */
    public static void Delete() {
        String dni = "";
        int pos = 0;
        String ID;
        int n, selected, inicio, selected1;
        if (((miniSimpleTableModel_admin) TABLA.getModel()).getRowCount() != 0) {
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
    /**
     * Guarda los cambios realizados de un admin en la bbdd
     * @return True si se ha guardado correctamente
     * @throws SQLException 
     */
    public static boolean guardarDatosAdminBBDD() throws SQLException{
        boolean e = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        
        //_con = _conexion_DB.AbrirConexion();
        _con = _conexion_DB.getConexion();
        DAO_admin.guardarDatosAdmin(_con);
        //_conexion_DB.CerrarConexion(_con);
        _conexion_DB.liberaConexion(_con);
        return e;
    }
    /**
     * Crea un nuevo admin y lo añade a la bbdd
     * @return True si se ha creado correctamente
     * @throws SQLException 
     */
    public static boolean crearAdminBBDD() throws SQLException{
        boolean correct = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        _con = _conexion_DB.getConexion();
        //_con = _conexion_DB.AbrirConexion();
        correct = DAO_admin.crearAdmin(_con);
        _conexion_DB.liberaConexion(_con);
        //_conexion_DB.CerrarConexion(_con);
        return correct;
    }
    /**
     * Lee toda la tabla de admins y los añade al array
     * @return True si se han podido leer los datos de la bbdd
     */
    public static boolean mostrarAdminBBDD(){
        boolean correct = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        //_con = _conexion_DB.AbrirConexion();
        _con = _conexion_DB.getConexion();
        correct = DAO_admin.mostrarAdmin(_con);
        //_conexion_DB.CerrarConexion(_con);
        _conexion_DB.liberaConexion(_con);
        return correct;
    }
    /**
     * Guarda los cambios de un admin en la bbdd
     * @return True si se ha modificado correctamente
     */
    public static boolean modificarAdminBBDD(){
        boolean correct = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        //_con = _conexion_DB.AbrirConexion();
        _con = _conexion_DB.getConexion();
        correct = DAO_admin.modificarAdmin(_con);
        //_conexion_DB.CerrarConexion(_con);
        _conexion_DB.liberaConexion(_con);
        return correct;
    }
    /**
     * Elimina un admin de la bbdd
     * @return True si se ha eliminado correctamente
     */
    public static boolean eliminarAdminBBDD(){
        boolean correct = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        //_con = _conexion_DB.AbrirConexion();
        _con = _conexion_DB.getConexion();
        correct = DAO_admin.eliminarAdmin(_con);
        //_conexion_DB.CerrarConexion(_con);
        _conexion_DB.liberaConexion(_con);
        return correct;
    }
}
