/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.registered_user.model.BLL;

import app.modules.users.registered_user.model.DAO.DAO_reguser;
import app.modules.users.registered_user.model.utils.pager.pagina;
import static app.modules.users.registered_user.view.regusermanage_view.TABLA;
import static app.modules.users.admin.view.adminmanage_view.selected;
import app.modules.users.registered_user.model.BLL.lib_ficheros.json;
import app.modules.users.registered_user.model.BLL.lib_ficheros.txt;
import app.modules.users.registered_user.model.BLL.lib_ficheros.xml;
import static app.modules.users.registered_user.view.regusermanage_view.statusnewadmin;
import app.modules.users.registered_user.model.classes.miniSimpleTableModel_reguser;
import app.modules.users.registered_user.model.classes.singleton_reguser;

/**
 *
 * @author Lara
 */
public class BLL_reguser {
    /**
     * Llama al DAO que comprueba que esté correcto el DNI
    */
    public static void DniValidate() {
        DAO_reguser.pidedni();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el nombre
    */
    public static void NameValidate() {
        DAO_reguser.pidenombre();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el apellido
    */
    public static void SurnameValidate() {
        DAO_reguser.pideapellidos();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el teléfono
    */
    public static void MobileValidate() {
        DAO_reguser.pidetelefono();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el correo
    */
    public static void EmailValidate() {
        DAO_reguser.pideemail();
    }
    /**
     * Llama al DAO que comprueba que esté correcto el nombre de usuario
    */
    public static void UserNameValidate() {
        DAO_reguser.pideusuario();
    }
    /**
     * Llama al DAO que comprueba que esté correcta la contraseña
    */
    public static void PasswordValidate() {
        DAO_reguser.pidecontrasenya();
    }
    /**
     * Llama al DAO que guarda un registrado y comprueba que se haya guardado con éxito
     * @return true si se ha guardado correctamente
    */
    public static boolean adminsave() {
        return DAO_reguser.savereguser();
    }
    /**
     * Llama al DAO que comprueba que esté correcta la fecha de nacimiento
    */
    public static void DateBirthdayValidate() {
        DAO_reguser.pidefechanacimiento();
    }
    /**
     * Llama al DAO que comprueba que esté correcta la actividad
    */
    public static void ActivityValidate() {
        DAO_reguser.pideactividad();
    }
    /**
     * Saca la posición de un usuario registrado seleccionado en la tabla
     * @return true si se ha seleccionado un usuario
    */
    public static boolean Modificar() {
        String dni = "";
        int pos = 0;
        String ID;
        boolean correct = false;
        int n, selected, inicio, selected1;
        if (((miniSimpleTableModel_reguser) TABLA.getModel()).getRowCount() != 0) {
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
     * Llama al DAO que modifica al usuario registrado
     * @return true si se ha modificado con éxito 
    */    
    public static boolean Modificaradmin(){
        return DAO_reguser.saveeditreguser();
    }
    /**
     * Saca la posición de un usuario seleccionado en la tabla y llama al DAO para que rellene
     * el formulario con sus datos
    */    
    public static void LlenarCampos() {
        int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
        int selected1 = inicio + selected;
        DAO_reguser.fillfields(selected1);
    }
    /**
     * Saca la posición del usuario y lo elimina
    */
    public static void Delete() {
        String dni = "";
        int pos = 0;
        String ID;
        int n, selected, inicio, selected1;
        if (((miniSimpleTableModel_reguser) TABLA.getModel()).getRowCount() != 0) {
            //int selected = TABLA.getSelectedRow();//sustituir
            inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage; //nos situamos al inicio de la página en cuestión
            selected = TABLA.getSelectedRow(); //nos situamos en la fila
            selected1 = inicio + selected; //nos situamos en la fila correspondiente de esa página

            if (selected1 == -1) {
                statusnewadmin.setText("Debes seleccionar un admin para eliminarlo");
            } else {
                dni = (String) TABLA.getModel().getValueAt(selected1, 0);
                pos = singleton_reguser.reguser.buscarDniRegUser(dni);
                ((miniSimpleTableModel_reguser) TABLA.getModel()).removeRow(selected1);
                singleton_reguser.reguser.DeleteRU(singleton_reguser.reguser.getClient(pos));
                json.GenerateJsonauto();
                txt.Generatetxtauto();
                xml.Generatexmlauto();
                statusnewadmin.setText("Usuario eliminado correctamente");
            }
        } else {
            statusnewadmin.setText("No hay ningún usuario registrado");
        }
    }
}
