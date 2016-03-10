/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.model.BLL;

import app.modules.users.admin.model.DAO.DAO_admin;

/**
 *
 * @author 1º DAW
 */
public class BLL_admin {
    public static void DniValidate(){
        DAO_admin.pidedni();
    }
    
    public static void NameValidate(){
        DAO_admin.pidenombre();
    }
    
    public static void SurnameValidate(){
        DAO_admin.pideapellidos();
    }
    
    public static void MobileValidate(){
        DAO_admin.pidetelefono();
    }
    
    public static void EmailValidate(){
        DAO_admin.pideemail();
    }
    
    public static void UserNameValidate(){
        DAO_admin.pideusuario();
    }
    
    public static void PasswordValidate(){
        DAO_admin.pidecontrasenya();
    }
    
    public static boolean adminsave(){
        return DAO_admin.saveadmin();
    }
    
    public static void DateBirthdayValidate(){
        DAO_admin.pidefechanacimiento();
    }
    
    public static void SalaryValidate(){
        DAO_admin.pidesalario();
    }
    
    public static void ActivityValidate(){
        DAO_admin.pideactividad();
    }
    
    public static void Contratacion(){
        DAO_admin.pidefechacontratacion();
    }
    
    public static boolean Modificar(){
        return DAO_admin.saveeditadmin();
    }
    
}
