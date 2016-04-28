/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.SignIn.model;

import app.classes.fecha;
import app.modules.SignIn.view.login;
import static app.modules.SignIn.view.login.addusername;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.singleton;
import app.modules.users.registered_user.controller.reguser_controller;
import app.modules.users.registered_user.model.classes.singleton_reguser;
import app.modules.users.registered_user.view.regusernew_view;
import static app.modules.users.registered_user.view.regusernew_view.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static app.modules.SignIn.view.login.addpass;

/**
 *
 * @author Lara
 */
public class DAO_Login {

    //find_admin (MySQL)
    public static boolean SignInAdmin(Connection _con) {
        boolean login = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        singleton.admin.getAdmins().clear();
        try {
            stmt = _con.prepareStatement("SELECT * FROM admin WHERE user='"+addusername.getText()+"' AND pass='"+addpass.getText()+"'");
            rs = stmt.executeQuery();
            admin ad = null;
            while (rs.next()) {
                login = true;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al iniciar sesión");
        }
        return login;
    }

    //find_client (Mongo)
    public static boolean SignInClient() {
        boolean login = false;

        return login;
    }

    //find_UReg (AList)
    public static boolean SignInRUser() {
        boolean login = false;
        for (int i = 0; i < singleton_reguser.reguser.getUserreg().size(); i++) {
            if (singleton_reguser.reguser.getClient(i).getUser().equals(addusername.getText())
                    && singleton_reguser.reguser.getClient(i).getPass().equals(addpass.getText())) {
                new reguser_controller(new regusernew_view(), 2).Iniciar(2);
                adddni.setText(singleton_reguser.reguser.getUserreg().get(i).getDni());
                addname.setText(singleton_reguser.reguser.getUserreg().get(i).getName());
                addsurname.setText(singleton_reguser.reguser.getUserreg().get(i).getSubname());
                fecha aux = new fecha();
                adddatebirthday.setCalendar(aux.stringtocalendar(singleton_reguser.reguser.getUserreg().get(i).getDate_birthday()));
                addmobile.setText(singleton_reguser.reguser.getUserreg().get(i).getMobile());
                addemail.setText(singleton_reguser.reguser.getUserreg().get(i).getEmail());
                addnameuser.setText(singleton_reguser.reguser.getUserreg().get(i).getUser());
                addpassword.setText(singleton_reguser.reguser.getUserreg().get(i).getPass());
                addavatar.setText(singleton_reguser.reguser.getUserreg().get(i).getAvatar());
                add_status.setSelectedItem(singleton_reguser.reguser.getUserreg().get(i).getState());
                addactivity.setText(Integer.toString(singleton_reguser.reguser.getClient(i).getActivity()));
                if (singleton_reguser.reguser.getClient(i).getActivity() <= 999) {
                    addkarma.setSelectedItem("Bajo");
                    addpoints.setText(Integer.toString(singleton_reguser.reguser.getClient(i).getActivity() * 5));
                } else if ((singleton_reguser.reguser.getClient(i).getActivity() >= 1000)
                        && (singleton_reguser.reguser.getClient(i).getActivity() <= 4999)) {
                    addkarma.setSelectedItem("Medio");
                    addpoints.setText(Integer.toString(singleton_reguser.reguser.getClient(i).getActivity() * 7));
                } else if (singleton_reguser.reguser.getClient(i).getActivity() >= 5000) {
                    addkarma.setSelectedItem("Alto");
                    addpoints.setText(Integer.toString(singleton_reguser.reguser.getClient(i).getActivity() * 10));
                }
                login = true;
            }
        }
        return login;
    }
}
