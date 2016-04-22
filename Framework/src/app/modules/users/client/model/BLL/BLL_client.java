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

    public static void DniValidate() {
        DAO_client.pidedni();
    }

    public static void NameValidate() {
        DAO_client.pidenombre();
    }

    public static void SurnameValidate() {
        DAO_client.pideapellidos();
    }

    public static void MobileValidate() {
        DAO_client.pidetelefono();
    }

    public static void EmailValidate() {
        DAO_client.pideemail();
    }

    public static void UserNameValidate() {
        DAO_client.pideusuario();
    }

    public static void PasswordValidate() {
        DAO_client.pidecontrasenya();
    }

    public static boolean adminsave() {
        return DAO_client.saveclient();
    }

    public static void DateBirthdayValidate() {
        DAO_client.pidefechanacimiento();
    }

    public static void SalaryValidate() {
        DAO_client.pidecompras();
    }

    public static void ActivityValidate() {
        DAO_client.pidetipo();
    }

    public static void Contratacion() {
        DAO_client.pidefecharegistro();
    }
    
    public static void TypeValidate() {
        DAO_client.pidetipo();
    }
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
    public static boolean Modificaradmin(){
        return DAO_client.saveeditclient();
    }
    public static void LlenarCampos() {
        int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
        int selected1 = inicio + selected;
        DAO_client.fillfields(selected1);
    }

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
    
    public static void CreateClientMongo(client c){
        DAO_Mongo.create_client(c);
    }
    
    public static void DeleteClientMongo(String dni){
        DAO_Mongo.delete_client(dni);
    }
    
    public static void UpdateClientMongo(String dni){
        DAO_Mongo.update_client(dni);
    }
}
