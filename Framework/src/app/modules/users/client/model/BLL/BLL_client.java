/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.client.model.BLL;

import app.modules.users.client.model.DAO.DAO_client;
import app.modules.users.client.model.classes.miniSimpleTableModel_client;
import app.modules.users.client.model.classes.singleton_client;
import app.modules.users.client.model.utils.pager.pagina;
import static app.modules.users.client.view.clientmanage_view.TABLA;
import static app.modules.users.admin.view.adminmanage_view.selected;
import app.modules.users.client.model.DAO.DAO_Mongo;
import app.modules.users.client.model.classes.client;
import static app.modules.users.client.view.clientmanage_view.statusnewadmin;

/**
 *
 * @author Lara
 */
public class BLL_client {
    /**
     * Llama al DAO que comprueba que esté correcto el DNI
    */
    public static void DniValidate() {
        DAO_client.pidedni();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el nombre
    */
    public static void NameValidate() {
        DAO_client.pidenombre();
    }
    /**
     * Llama al DAO que comprueba que estén correctos los apellidos
    */
    public static void SurnameValidate() {
        DAO_client.pideapellidos();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el teléfono
    */
    public static void MobileValidate() {
        DAO_client.pidetelefono();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el email
    */
    public static void EmailValidate() {
        DAO_client.pideemail();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el nombre de usuario
    */
    public static void UserNameValidate() {
        DAO_client.pideusuario();
    }
    /**
     * Llama al DAO que comprueba que esté correcta la contraseña
    */
    public static void PasswordValidate() {
        DAO_client.pidecontrasenya();
    }
    /**
     * Llama al DAO que comprueba que se haya guardado bien el cliente
     * @return True si se ha guardado bien
    */
    public static boolean adminsave() {
        return DAO_client.saveclient();
    }
    /**
     * Llama al DAO que comprueba que esté correcta la fecha de nacimiento
    */
    public static void DateBirthdayValidate() {
        DAO_client.pidefechanacimiento();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el salario
    */
    public static void SalaryValidate() {
        DAO_client.pidecompras();
    }
    /**
     * Llama al DAO que comprueba que esté correcta la actividad
    */
    public static void ActivityValidate() {
        DAO_client.pidetipo();
    }
    /**
     * Llama al DAO que comprueba que esté correcta la fecha de contratación
    */
    public static void Contratacion() {
        DAO_client.pidefecharegistro();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el tipo de cliente
    */    
    public static void TypeValidate() {
        DAO_client.pidetipo();
    }
    /**
     * Comprueba que haya clientes o que se haya seleccionado uno para trabajar con su posición
     * @return True si se ha seleccionado un cliente en la tabla
    */    
    public static boolean Modificar() {
        String dni = "";
        int pos = 0;
        String ID;
        boolean correct = false;
        int n, selected, inicio, selected1;
        if (((miniSimpleTableModel_client) TABLA.getModel()).getRowCount() != 0) {
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
     * Llama al DAO que modifica y devuelve que se haya guardado correctamente
     * @return True si se ha modificado el cliente correctamente
    */    
    public static boolean Modificaradmin(){
        return DAO_client.saveeditclient();
    }
    /**
     * Saca la posición del cliente seleccionado y llama al DAO para que rellene los
     * campos del formulario con su información
    */    
    public static void LlenarCampos() {
        int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
        int selected1 = inicio + selected;
        DAO_client.fillfields(selected1);
    }
    /**
     * Saca la posición del cliente seleccionado y lo elimina del array
    */
    public static void Delete() {
        String dni = "";
        int pos = 0;
        String ID;
        int n, selected, inicio, selected1;
        if (((miniSimpleTableModel_client) TABLA.getModel()).getRowCount() != 0) {
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            selected = TABLA.getSelectedRow(); //nos situamos en la fila
            selected1 = inicio + selected; //nos situamos en la fila correspondiente de esa página

            if (selected1 == -1) {
                statusnewadmin.setText("Debes seleccionar un admin para eliminarlo");
            } else {
                dni = (String) TABLA.getModel().getValueAt(selected1, 0);
                pos = singleton_client.client.buscarDniClient(dni);
                ((miniSimpleTableModel_client) TABLA.getModel()).removeRow(selected1);
                DeleteClientMongo(dni);
                singleton_client.client.DeleteC(singleton_client.client.getClient(pos));
                statusnewadmin.setText("Usuario eliminado correctamente");
            }
        } else {
            statusnewadmin.setText("No hay ningún usuario administrador");
        }
    }
    /**
     * Llama al DAO para que cree un nuevo cliente en la bbdd
     * @param c cliente con toda su información
     */
    public static void CreateClientMongo(client c){
        DAO_Mongo.create_client(c);
    }
    /**
     * Llama al DAO para que elimine un cliente de la bbdd
     * @param dni 
     */
    public static void DeleteClientMongo(String dni){
        DAO_Mongo.delete_client(dni);
    }
    /**
     * Llama al DAO para que modifique un cliente en la bbdd
     * @param dni 
     */
    public static void UpdateClientMongo(String dni){
        DAO_Mongo.update_client(dni);
    }
    /**
     * Lee todos los clientes que hay en la bbdd para mostrarlos en la app
     */
    public static void ReadClientMongo(){
        DAO_Mongo.read_client();
    }
}
