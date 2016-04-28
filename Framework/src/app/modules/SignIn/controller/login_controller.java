/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.SignIn.controller;

import app.classes.singleton_global;
import app.modules.SignIn.model.BLL_Login;
import app.modules.SignIn.view.login;
import static app.modules.SignIn.view.login.btnadmin;
import static app.modules.SignIn.view.login.btnclient;
import static app.modules.SignIn.view.login.btnruser;
import app.modules.menu.controller.menu_controller;
import app.modules.menu.view.main_view;
import app.modules.users.registered_user.controller.reguser_controller;
import app.modules.users.registered_user.view.regusernew_view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Lara
 */
public class login_controller implements ActionListener {
    public static login LogIn;
    public login_controller(JFrame log) {
        LogIn = (login) log;
    }
    
    public void Iniciar() {
        LogIn.setVisible(true);
        
        btnadmin.setEnabled(false);
        singleton_global.type = "admin";
        LogIn.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                    System.exit(0);
                }
            });
            
            login.btnadmin.setActionCommand("btnAdmin");
            login.btnadmin.addActionListener(this);
            login.btnclient.setActionCommand("btnClient");
            login.btnclient.addActionListener(this);
            login.btnruser.setActionCommand("btnRUser");
            login.btnruser.addActionListener(this);
            login.signin.setActionCommand("btnLogIn");
            login.signin.addActionListener(this);
            login.exit.setActionCommand("btnExit");
            login.exit.addActionListener(this);
    }
    public enum Option {
        btnAdmin,
        btnClient,
        btnRUser,
        btnLogIn,
        btnExit
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        switch(login_controller.Option.valueOf(e.getActionCommand())){
            case btnAdmin:
                btnadmin.setEnabled(false);
                btnclient.setEnabled(true);
                btnruser.setEnabled(true);
                singleton_global.type = "admin";
                break;
            case btnClient:
                btnadmin.setEnabled(true);
                btnclient.setEnabled(false);
                btnruser.setEnabled(true);
                singleton_global.type = "client";
                break;
            case btnRUser:
                btnadmin.setEnabled(true);
                btnclient.setEnabled(true);
                btnruser.setEnabled(false);
                singleton_global.type = "ruser";
                break;
            case btnLogIn:
                if ("admin".equals(singleton_global.type)){
                    if(BLL_Login.SignInAdmin()){
                        new menu_controller(new main_view(),0).Iniciar(0);
                        LogIn.dispose();
                    }
                } else if ("ruser".equals(singleton_global.type)){
                    if(BLL_Login.SignInRUser()){
                        LogIn.dispose();
                    }
                }
                break;
            case btnExit:
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                System.exit(0);
                break;
        }
    }

}
