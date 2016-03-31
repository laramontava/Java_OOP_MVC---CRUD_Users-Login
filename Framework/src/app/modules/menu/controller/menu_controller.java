/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.menu.controller;

import app.classes.singleton_global;
import app.modules.config.view.config_view;
import static app.modules.config.view.config_view.conf_currency;
import static app.modules.config.view.config_view.conf_data;
import static app.modules.config.view.config_view.conf_decimal;
import static app.modules.config.view.config_view.conf_format;
import static app.modules.config.view.config_view.conf_language;
import static app.modules.config.view.config_view.conf_theme;
import app.modules.menu.view.main_view;
import static app.modules.menu.view.main_view.btnadmin_main;
import static app.modules.menu.view.main_view.btnclient_main;
import static app.modules.menu.view.main_view.btnconf_main;
import static app.modules.menu.view.main_view.btnreguser_main;
import app.modules.users.admin.controller.admin_controller;
import app.modules.users.admin.view.adminmanage_view;
import app.modules.users.client.controller.client_controller;
import app.modules.users.client.view.clientmanage_view;
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

    public menu_controller(JFrame maincontroller, int op) {
        if (op == 0) {
            mainview = (main_view) maincontroller;
        }
        if (op == 1) {
            conf = (config_view) maincontroller;
        }
    }

    public enum Option {
        btn_adminmain,
        btn_clientmain,
        btn_regusermain,
        btn_confmain,
        btn_currency,
        btn_data,
        btn_decimal,
        btn_dummies,
        btn_format,
        btn_language,
        btn_theme,
        conf_data1,
        conf_data2,
        conf_data3,
        conf_data4,
        conf_decimal1,
        conf_decimal2,
        conf_decimal3,
        conf_theme1,
        conf_theme2,
        conf_format1,
        conf_format2,
        conf_format3,
        conf_currency1,
        conf_currency2,
        conf_currency3,
        conf_language1,
        conf_language2,
        conf_language3,
        conf_dummieson,
        conf_dummiesoff,
        btn_return,
    }

    public void Iniciar(int op) {
        if (op == 0) {
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
        } else if (op == 1) {
            ppalmain.singleton_vtna = "config_view";
            conf.setVisible(true);
            conf.setLocationRelativeTo(null);

            config_view.languageformat.setSize(280, 220);
            config_view.languageformat.setLocationRelativeTo(null);

            conf_data.setText(singleton_global.translate.getProperty("date"));
            conf_decimal.setText(singleton_global.translate.getProperty("decimal"));
            conf_theme.setText(singleton_global.translate.getProperty("theme"));
            conf_format.setText(singleton_global.translate.getProperty("format"));
            conf_currency.setText(singleton_global.translate.getProperty("currency"));
            conf_language.setText(singleton_global.translate.getProperty("language"));

            config_view.conf_currency.setActionCommand("btn_currency");
            config_view.conf_currency.addActionListener(this);
            config_view.conf_data.setActionCommand("btn_data");
            config_view.conf_data.addActionListener(this);
            config_view.conf_decimal.setActionCommand("btn_decimal");
            config_view.conf_decimal.addActionListener(this);
            config_view.conf_dummies.setActionCommand("btn_dummies");
            config_view.conf_dummies.addActionListener(this);
            config_view.conf_format.setActionCommand("btn_format");
            config_view.conf_format.addActionListener(this);
            config_view.conf_language.setActionCommand("btn_language");
            config_view.conf_language.addActionListener(this);
            config_view.conf_theme.setActionCommand("btn_theme");
            config_view.conf_theme.addActionListener(this);

            config_view.dateformat1.setActionCommand("conf_data1");
            config_view.dateformat1.addActionListener(this);
            config_view.dateformat2.setActionCommand("conf_data2");
            config_view.dateformat2.addActionListener(this);
            config_view.dateformat3.setActionCommand("conf_data3");
            config_view.dateformat3.addActionListener(this);
            config_view.dateformat4.setActionCommand("conf_data4");
            config_view.dateformat4.addActionListener(this);

            config_view.decimals1.setActionCommand("conf_decimal1");
            config_view.decimals1.addActionListener(this);
            config_view.decimals2.setActionCommand("conf_decimal2");
            config_view.decimals2.addActionListener(this);
            config_view.decimals3.setActionCommand("conf_decimal3");
            config_view.decimals3.addActionListener(this);

            config_view.metal.setActionCommand("conf_theme1");
            config_view.metal.addActionListener(this);
            config_view.nimbus.setActionCommand("conf_theme2");
            config_view.nimbus.addActionListener(this);

            config_view.json.setActionCommand("conf_format1");
            config_view.json.addActionListener(this);
            config_view.xml.setActionCommand("conf_format2");
            config_view.xml.addActionListener(this);
            config_view.txt.setActionCommand("conf_format3");
            config_view.txt.addActionListener(this);

            config_view.euro.setActionCommand("conf_currency1");
            config_view.euro.addActionListener(this);
            config_view.dolar.setActionCommand("conf_currency2");
            config_view.dolar.addActionListener(this);
            config_view.libra.setActionCommand("conf_currency3");
            config_view.libra.addActionListener(this);

            config_view.english.setActionCommand("conf_language1");
            config_view.english.addActionListener(this);
            config_view.castellano.setActionCommand("conf_language2");
            config_view.castellano.addActionListener(this);
            config_view.valencia.setActionCommand("conf_language3");
            config_view.valencia.addActionListener(this);

            config_view.dummieon.setActionCommand("conf_dummieson");
            config_view.dummieon.addActionListener(this);
            config_view.dummieoff.setActionCommand("conf_dummiesoff");
            config_view.dummieoff.addActionListener(this);

            config_view.return_main.setActionCommand("btn_return");
            config_view.return_main.addActionListener(this);

            conf.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    conf.dispose();
                    new menu_controller(new main_view(), 0).Iniciar(0);
                }
            });
        } 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (Option.valueOf(e.getActionCommand())) {
            case btn_adminmain:
                new admin_controller(new adminmanage_view(),0).Iniciar(0);
                mainview.dispose();
                break;
            case btn_clientmain:
                new client_controller(new clientmanage_view(),0).Iniciar(0);
                mainview.dispose();
                break;
            case btn_regusermain:
                JOptionPane.showMessageDialog(null, "reg");
                break;
            case btn_confmain:
                mainview.dispose();
                new menu_controller(new config_view(), 1).Iniciar(1);
                break;
            case btn_data:
                config_view.dateformat.setVisible(true);
                config_view.dateformat.setSize(280, 220);
                config_view.dateformat.setLocationRelativeTo(null);
                break;
            case conf_data1:
                JOptionPane.showMessageDialog(null, "data1");
                break;
            case conf_data2:
                JOptionPane.showMessageDialog(null, "data2");
                break;
            case conf_data3:
                JOptionPane.showMessageDialog(null, "data3");
                break;
            case conf_data4:
                JOptionPane.showMessageDialog(null, "data4");
                break;
            case btn_decimal:
                config_view.decimalsformat.setVisible(true);
                config_view.decimalsformat.setSize(280, 220);
                config_view.decimalsformat.setLocationRelativeTo(null);
                break;
            case conf_decimal1:
                JOptionPane.showMessageDialog(null, "decimal1");
                break;
            case conf_decimal2:
                JOptionPane.showMessageDialog(null, "decimal2");
                break;
            case conf_decimal3:
                JOptionPane.showMessageDialog(null, "decimal3");
                break;
            case btn_theme:
                config_view.themeformat.setVisible(true);
                config_view.themeformat.setSize(280, 220);
                config_view.themeformat.setLocationRelativeTo(null);
                break;
            case conf_theme1:
                JOptionPane.showMessageDialog(null, "theme1");
                break;
            case conf_theme2:
                JOptionPane.showMessageDialog(null, "theme2");
                break;
            case btn_format:
                config_view.fileformat.setVisible(true);
                config_view.fileformat.setSize(280, 220);
                config_view.fileformat.setLocationRelativeTo(null);
                break;
            case conf_format1:
                JOptionPane.showMessageDialog(null, "format1");
                break;
            case conf_format2:
                JOptionPane.showMessageDialog(null, "format2");
                break;
            case conf_format3:
                JOptionPane.showMessageDialog(null, "format3");
                break;
            case btn_currency:
                config_view.currencyformat.setVisible(true);
                config_view.currencyformat.setSize(280, 220);
                config_view.currencyformat.setLocationRelativeTo(null);
                break;
            case conf_currency1:
                JOptionPane.showMessageDialog(null, "euro");
                break;
            case conf_currency2:
                JOptionPane.showMessageDialog(null, "dolar");
                break;
            case conf_currency3:
                JOptionPane.showMessageDialog(null, "libra");
                break;
            case btn_language:
                config_view.languageformat.setVisible(true);
                config_view.languageformat.setSize(280, 220);
                config_view.languageformat.setLocationRelativeTo(null);
                break;
            case conf_language1:
                singleton_global.conf.setLanguage("english");
                singleton_global.translate.setIdioma("english");
                singleton_global.translate.getIdioma();

                conf_data.setText(singleton_global.translate.getProperty("date"));
                conf_decimal.setText(singleton_global.translate.getProperty("decimal"));
                conf_theme.setText(singleton_global.translate.getProperty("theme"));
                conf_format.setText(singleton_global.translate.getProperty("format"));
                conf_currency.setText(singleton_global.translate.getProperty("currency"));
                conf_language.setText(singleton_global.translate.getProperty("language"));
                break;
            case conf_language2:
                singleton_global.conf.setLanguage("castellano");
                singleton_global.translate.setIdioma("castellano");
                singleton_global.translate.getIdioma();

                conf_data.setText(singleton_global.translate.getProperty("date"));
                conf_decimal.setText(singleton_global.translate.getProperty("decimal"));
                conf_theme.setText(singleton_global.translate.getProperty("theme"));
                conf_format.setText(singleton_global.translate.getProperty("format"));
                conf_currency.setText(singleton_global.translate.getProperty("currency"));
                conf_language.setText(singleton_global.translate.getProperty("language"));
                break;
            case conf_language3:
                singleton_global.conf.setLanguage("valencia");
                singleton_global.translate.setIdioma("valencia");
                singleton_global.translate.getIdioma();

                conf_data.setText(singleton_global.translate.getProperty("date"));
                conf_decimal.setText(singleton_global.translate.getProperty("decimal"));
                conf_theme.setText(singleton_global.translate.getProperty("theme"));
                conf_format.setText(singleton_global.translate.getProperty("format"));
                conf_currency.setText(singleton_global.translate.getProperty("currency"));
                conf_language.setText(singleton_global.translate.getProperty("language"));
                break;
            case btn_dummies:
                config_view.dummiesactivate.setVisible(true);
                config_view.dummiesactivate.setSize(280, 220);
                config_view.dummiesactivate.setLocationRelativeTo(null);
                break;
            case conf_dummieson:
                JOptionPane.showMessageDialog(null, "on");
                break;
            case conf_dummiesoff:
                JOptionPane.showMessageDialog(null, "off");
                break;
            case btn_return:
                conf.dispose();
                new menu_controller(new main_view(), 0).Iniciar(0);
                break;
        }
    }
}
