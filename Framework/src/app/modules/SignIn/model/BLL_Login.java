/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.SignIn.model;

import app.classes.ConnectionBBDD;
import java.sql.Connection;

/**
 *
 * @author Lara
 */
public class BLL_Login {
    public static boolean SignInAdmin(){
        boolean login = false;
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        _con = _conexion_DB.getConexion();
        login = DAO_Login.SignInAdmin(_con);
        _conexion_DB.liberaConexion(_con);
        return login;
    }
    public static boolean SignInClient(){
        return DAO_Login.SignInClient();
    }
    public static boolean SignInRUser(){
        return DAO_Login.SignInRUser();
    }
}
