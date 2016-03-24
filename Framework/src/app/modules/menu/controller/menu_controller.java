/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.menu.controller;

import app.classes.singleton_global;
import app.modules.config.view.config_view;
import app.modules.menu.view.main_view;
import static app.modules.menu.view.main_view.btnadmin_main;
import static app.modules.menu.view.main_view.btnclient_main;
import static app.modules.menu.view.main_view.btnconf_main;
import static app.modules.menu.view.main_view.btnreguser_main;
import app.modules.users.admin.view.adminmanage_view;
import app.ppalmain;
import app.utils.config_save;
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
public class menu_controller implements ActionListener {

    public static main_view mainview;
    public static config_view conf;
    public static adminmanage_view Admin = new adminmanage_view();

    public menu_controller(JFrame maincontroller) {
        mainview = (main_view) maincontroller;
    }

    public enum Option {
        btn_adminmain,
        btn_clientmain,
        btn_regusermain,
        btn_confmain,
    }

    public void Iniciar() {
        ppalmain.singleton_vtna = "main_view";
        mainview.setVisible(true);
        mainview.setSize(409, 343);
        mainview.setLocationRelativeTo(null);
        mainview.setResizable(false);

        btnadmin_main.setText(singleton_global.translate.getProperty("admin"));
        btnclient_main.setText(singleton_global.translate.getProperty("client"));
        btnreguser_main.setText(singleton_global.translate.getProperty("registered_user"));
        btnconf_main.setText(singleton_global.translate.getProperty("config"));

        main_view.btnadmin_main.setActionCommand("btn_adminmain");
        main_view.btnadmin_main.addActionListener(this);
        main_view.btnclient_main.setActionCommand("btn_clientmain");
        main_view.btnclient_main.addActionListener(this);
        main_view.btnreguser_main.setActionCommand("btn_regusermain");
        main_view.btnreguser_main.addActionListener(this);
        main_view.btnconf_main.setActionCommand("btn_confmain");
        main_view.btnconf_main.addActionListener(this);

        mainview.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JOptionPane.showMessageDialog(null, "Saliendo de la aplicación");
                config_save.GenerateJsonautoconf();

                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Option.valueOf(e.getActionCommand())) {
            case btn_adminmain:
                Admin.setVisible(true);
                break;
            case btn_clientmain:
                JOptionPane.showMessageDialog(null, "Cli");
                break;
            case btn_regusermain:
                JOptionPane.showMessageDialog(null, "reg");
                break;
            case btn_confmain:
                JOptionPane.showMessageDialog(null, "conf");
                break;
        }
    }
}
