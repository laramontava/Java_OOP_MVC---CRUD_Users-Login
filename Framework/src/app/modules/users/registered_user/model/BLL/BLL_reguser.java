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

    public static void DniValidate() {
        DAO_reguser.pidedni();
    }

    public static void NameValidate() {
        DAO_reguser.pidenombre();
    }

    public static void SurnameValidate() {
        DAO_reguser.pideapellidos();
    }

    public static void MobileValidate() {
        DAO_reguser.pidetelefono();
    }

    public static void EmailValidate() {
        DAO_reguser.pideemail();
    }

    public static void UserNameValidate() {
        DAO_reguser.pideusuario();
    }

    public static void PasswordValidate() {
        DAO_reguser.pidecontrasenya();
    }

    public static boolean adminsave() {
        return DAO_reguser.savereguser();
    }

    public static void DateBirthdayValidate() {
        DAO_reguser.pidefechanacimiento();
    }

    public static void ActivityValidate() {
        DAO_reguser.pideactividad();
    }

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
    public static boolean Modificaradmin(){
        return DAO_reguser.saveeditreguser();
    }
    public static void LlenarCampos() {
        int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
        int selected1 = inicio + selected;
        DAO_reguser.fillfields(selected1);
    }

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
