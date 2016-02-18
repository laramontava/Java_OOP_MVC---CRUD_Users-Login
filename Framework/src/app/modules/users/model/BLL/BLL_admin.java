/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.model.BLL;

import app.modules.users.model.DAO.DAO_admin;

/**
 *
 * @author 1º DAW
 */
public class BLL_admin {
    public static void NameValidate(){
        DAO_admin.pidenombre();
    }
}
