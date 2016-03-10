package app;


import app.modules.config.model.configuration;
import app.modules.config.model.idioma;
import app.classes.singleton_global;
import app.modules.menu.view.main_view;
import app.modules.users.admin.model.BLL.Arraylist_admin;
import app.modules.users.admin.model.BLL.Arraylist_client;
import app.modules.users.admin.model.BLL.Arraylist_userreg;
import app.modules.users.admin.model.BLL.lib_ficheros.json;
import app.modules.users.admin.model.BLL.lib_ficheros.txt;
import app.modules.users.admin.model.BLL.lib_ficheros.xml;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.client;
import app.modules.users.admin.model.classes.registered_user;
import app.modules.users.admin.model.classes.singleton;
import app.utils.config_save;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1º DAW
 */
public class ppalmain {
    
    public static String singleton_vtna="";
    public static void main(String[]args){
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
        singleton.client = new Arraylist_client();
        singleton.reguser = new Arraylist_userreg();
        switch (singleton_global.conf.getFormat()) {
            case "json":
                json.OpenJsonauto();
                break;
            case "txt":
                txt.Opentxtauto();
                break;
            case "xml":
                xml.Openxmlauto();
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
                new main_view().setVisible(true);
            }
        });
    }
}
