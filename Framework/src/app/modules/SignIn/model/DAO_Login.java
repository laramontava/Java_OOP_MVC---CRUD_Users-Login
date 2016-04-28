/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.SignIn.model;

import app.classes.fecha;
import app.classes.singleton_global;
import static app.modules.SignIn.view.login.addusername;
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
import static app.modules.SignIn.view.login.statuslog;
import app.modules.users.client.controller.client_controller;
import app.modules.users.client.model.classes.client;
import app.modules.users.client.view.clientnew_view;
import static app.modules.users.client.view.clientnew_view.*;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

/**
 *
 * @author Lara
 */
public class DAO_Login {

    /**
     * Compara el nombre de usuario y la contraseña con los admins de la base de
     * datos, cuando encuentra que ambos campos coinciden devuelve true y
     * permite iniciar sesión.
     *
     * @param _con
     * @return login
     */
    public static boolean SignInAdmin(Connection _con) {
        boolean login = false;
        ResultSet rs = null;
        PreparedStatement stmt = null;
        try {
            stmt = _con.prepareStatement("SELECT * FROM admin WHERE user='" + addusername.getText() + "' AND pass='" + addpass.getText() + "'");
            rs = stmt.executeQuery();
            while (rs.next()) {
                login = true;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ha habido un problema al iniciar sesión");
        }
        if (!login) {
            statuslog.setText("El usuario no existe o ha introducido mal los datos");
        }
        return login;
    }

    public static boolean SignInClient() {
        boolean login = false;
        DBCursor cursor = null;
        client c = new client();
        try {
            cursor = singleton_global.collection.find(new BasicDBObject().append("user", addusername.getText()));
            if (cursor.count() != 0) {
                for (int i = 0; i < cursor.size(); i++) {
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    c = c.BBDD_to_client(document);
                    fecha aux = new fecha();
                    if (c.getPass().equals(addpass.getText())) {
                        new client_controller(new clientnew_view(), 2).Iniciar(2);
                        adddnic.setText(c.getDni());
                        caddname.setText(c.getName());
                        caddsurname.setText(c.getSubname());
                        caddmobile.setText(c.getMobile());
                        caddemail.setText(c.getEmail());
                        cadddatebirthday.setCalendar(aux.stringtocalendar(c.getDate_birthday()));
                        caddnameuser.setText(c.getUser());
                        caddpassword.setText(c.getPass());
                        caddavatar.setText(c.getAvatar());
                        cadd_status.setSelectedItem(c.getState());
                        caddreg.setCalendar(aux.stringtocalendar(c.getUp_date()));
                        caddshopping.setText(Float.toString(c.getShopping()));
                        caddpremium.setSelectedItem(c.getPremium());
                        caddtype.setText(c.getClient_type());
                        login = true;
                        if ("Premium".equals(c.getPremium())) {
                            cadddesc.setText("10%");
                        } else {
                            cadddesc.setText("0%");
                        }
                        caddyearsservice.setText(Integer.toString(aux.restafechas(aux.stringtocalendar(c.getUp_date()), aux.fechasystem(), "years")));
                    }
                }
            } else {
                System.out.println("NOT DATA");
            }
        } catch (Exception e) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return login;
    }

    /**
     * Compara el nombre de usuario y la contraseña con los usuarios registrados
     * en el array, cuando encuentra que ambos campos coinciden devuelve true y
     * permite iniciar sesión, mostrando el perfil de ese usuario.
     *
     * @return login
     */
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
            } else {
                statuslog.setText("El usuario no existe o ha introducido mal los datos");
            }
        }
        return login;
    }
}
