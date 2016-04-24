package app;

import app.bbdd_mongo.Mongo_DB;
import app.classes.ConnectionBBDD;
import app.modules.menu.model.configuration;
import app.modules.menu.model.idioma;
import app.classes.singleton_global;
import app.modules.menu.controller.menu_controller;
import app.modules.menu.view.main_view;
import app.modules.users.admin.model.BLL.Arraylist_admin;
import app.modules.users.admin.model.BLL.lib_ficheros.json;
import app.modules.users.admin.model.BLL.lib_ficheros.txt;
import app.modules.users.admin.model.BLL.lib_ficheros.xml;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.singleton;

import app.modules.users.client.model.classes.client;
import app.modules.users.client.model.BLL.Arraylist_client;
import app.modules.users.client.model.classes.singleton_client;

import app.modules.users.registered_user.model.classes.registered_user;
import app.modules.users.registered_user.model.BLL.Arraylist_userreg;
import app.modules.users.registered_user.model.classes.singleton_reguser;
import app.utils.config_save;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lara
 */
public class ppalmain {
    
    public static String singleton_vtna="";
    public static void main(String[]args){
        ConnectionBBDD.inicializa_BasicDataSourceFactory();
        singleton_global.mongo = new Mongo_DB();
        singleton_global.nom_bd = singleton_global.mongo.getNom_bd();
        singleton_global.nom_table = singleton_global.mongo.getNom_table();
        
        singleton_global.client = Mongo_DB.connect();
        if (singleton_global.client != null) {
            singleton_global.db = singleton_global.mongo.getDb();
            singleton_global.collection = singleton_global.mongo.getCollection();
        }
        singleton_global.conf = new configuration();
        config_save.OpenJsonautoconf();
        int option, option2, dummies1;
        boolean exit = false;
        char moneda = ' ';

        singleton_global.translate = new idioma(singleton_global.conf.getLanguage());
        admin pideadmin = new admin();
        client pidecliente = new client();
        registered_user pideregistrado = new registered_user();
        singleton.admin = new Arraylist_admin();
        singleton_client.client = new Arraylist_client();
        singleton_reguser.reguser = new Arraylist_userreg();
        switch (singleton_global.conf.getFormat()) {
            case "json":
                json.OpenJsonauto();
                //app.modules.users.client.model.BLL.lib_ficheros.json.OpenJsonauto();
                app.modules.users.registered_user.model.BLL.lib_ficheros.json.OpenJsonauto();
                break;
            case "txt":
                txt.Opentxtauto();
                //app.modules.users.client.model.BLL.lib_ficheros.txt.Opentxtauto();
                app.modules.users.registered_user.model.BLL.lib_ficheros.txt.Opentxtauto();
                break;
            case "xml":
                xml.Openxmlauto();
                //app.modules.users.client.model.BLL.lib_ficheros.xml.Openxmlauto();
                app.modules.users.registered_user.model.BLL.lib_ficheros.xml.Openxmlauto();
                break;
        }
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main_view.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new menu_controller(new main_view(),0).Iniciar(0);
            }
        });
    }
}
