/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.SignIn.model;

/**
 *
 * @author Lara
 */
public class BLL_Login {
    public static boolean SignInRUser(){
        return DAO_Login.SignInRUser();
    }
}
