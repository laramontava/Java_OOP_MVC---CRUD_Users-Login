package app;

/*import javax.swing.JOptionPane;

import app.modules.config.model.configuration;
import app.modules.config.model.idioma;
import app.classes.singleton_global;
import app.modules.users.admin.model.BLL.Arraylist_admin;
import app.modules.users.client.model.BLL.Arraylist_client;
import app.modules.users.admin.model.BLL.Arraylist_userreg;
import app.modules.users.admin.model.BLL.lib_ficheros.json;
import app.modules.users.admin.model.BLL.lib_ficheros.txt;
import app.modules.users.admin.model.BLL.lib_ficheros.xml;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.client;
import app.modules.users.admin.model.classes.registered_user;
import app.modules.users.admin.model.classes.singleton;
import app.modules.users.admin.model.utils.dummies;
import app.modules.users.client.model.classes.singleton_client;
import app.utils.config_save;
import app.utils.menus;
import app.utils.theme;

public class Main {

    public static void main(String[] args) {
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

        do {
            String[] tipo = {singleton_global.translate.getProperty("admin"),
                singleton_global.translate.getProperty("client"),
                singleton_global.translate.getProperty("registered_user"),
                singleton_global.translate.getProperty("config"),
                singleton_global.translate.getProperty("exit")};
            String[] tipo2 = {singleton_global.translate.getProperty("creat"),
                singleton_global.translate.getProperty("change_data"),
                singleton_global.translate.getProperty("print"),
                singleton_global.translate.getProperty("buscar"),
                singleton_global.translate.getProperty("order"),
                singleton_global.translate.getProperty("delete"),
                singleton_global.translate.getProperty("open"),
                singleton_global.translate.getProperty("save"),
                singleton_global.translate.getProperty("return")};
            String[] tipo3 = {singleton_global.translate.getProperty("date"),
                singleton_global.translate.getProperty("currency"),
                singleton_global.translate.getProperty("decimal"),
                singleton_global.translate.getProperty("language"),
                singleton_global.translate.getProperty("format"),
                singleton_global.translate.getProperty("theme"), "Dummies",
                singleton_global.translate.getProperty("return")};
            String[] tipo4 = {"€", "$", "£"};
            String[] tipo5 = {"dd/MM/yyyy", "dd-MM-yyyy", "yyyy/MM/dd", "yyyy-MM-dd"};
            String[] tipo6 = {"English", "Castellano", "Valencià"};
            String[] tipo7 = {"0,1", "0,12", "0,123"};
            String[] tipo8 = {"DNI", singleton_global.translate.getProperty("nameorder"),
                singleton_global.translate.getProperty("birthdayorder")};
            String[] tipo9 = {".json", ".txt", ".xml"};
            String[] tipo10 = {"Metal", "GTK - WINDOWS", "CDE/Motif", "Nimbus"};
            String[] tipo11 = {"Activar", "Desactivar"};
            String[] tipo12 = {"Crear un admin manual", "Crear un admin automáticamente"};

            theme.temaElegido(singleton_global.conf.getTheme());

            option = menus.mainmenu(tipo, singleton_global.translate.getProperty("Pregcrear"),
                    singleton_global.translate.getProperty("CreateuserT"));
            switch (option) {
                case 0: //administrator

                    do {
                        option2 = menus.mainmenu(tipo2, singleton_global.translate.getProperty("Preghacer"), "Admin main");
                        switch (option2) {
                            case 0: //create administrator ---
                                if (!singleton_global.conf.getDummies())//normal
                                {
                                    singleton.admin.AddAdmin(pideadmin);
                                } else {//dummies
                                    option2 = menus.mainmenu(tipo12, singleton_global.translate.getProperty("dummieadmincreate"), "Create admin");
                                    switch (option2) {
                                        case 0: //manual
                                            singleton.admin.AddAdmin(pideadmin);
                                            break;
                                        case 1: //automatic
                                            dummies.LoadDummies();
                                            break;
                                    }
                                }
                                break;
                            case 1: //change administrator ----
                                singleton.admin.editadmin(pideadmin);
                                break;
                            case 2: //print out ---
                                singleton.admin.printadmin();
                                break;
                            case 3://search ---
                                singleton.admin.adminsearch(pideadmin);
                                break;
                            case 4://order ---
                                option2 = menus.mainmenu(tipo8, singleton_global.translate.getProperty("ordenar"), "Ordenar");
                                switch (option2) {
                                    case 0://DNI
                                        singleton.admin.orderby(0);
                                        break;
                                    case 1://name
                                        singleton.admin.orderby(1);
                                        break;
                                    case 2: //age
                                        singleton.admin.orderby(2);
                                        break;
                                }
                                break;
                            case 5://delete ---
                                singleton.admin.deleteadmin(pideadmin);
                                break;
                            case 6://open ---
                                singleton.admin.openfiles();
                                break;
                            case 7://save ---
                                singleton.admin.savefiles();
                                break;
                        }
                    } while (option2 != 8);
                    break;
                case 1: //client
                    do {
                        option2 = menus.mainmenu(tipo2, singleton_global.translate.getProperty("Preghacer"), "Client main");
                        switch (option2) {
                            case 0:
                                singleton_client.client.AddClient(pidecliente);
                                //pidecliente=functions_users.pideclient(conf, translate);
                                break;
                            case 1:
                                singleton_client.client.EditClient(pidecliente);
                                /*if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						functions_users.cambiauser(pidecliente, conf, translate);
					}*
                                break;
                            case 2:
                                singleton_client.client.PrintClient();
                                /*	if(pidecliente==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatc"));
					}
					else{
						JOptionPane.showMessageDialog(null, pidecliente.toString());
					}*
                                break;
                            case 3://search ---
                                singleton_client.client.clientsearch(pidecliente);
                                break;
                            case 4://order  ---
                                option2 = menus.mainmenu(tipo8, "¿Por qué quieres ordenar?", "Ordenar");
                                switch (option2) {
                                    case 0://DNI
                                        singleton_client.client.orderby(0);
                                        break;
                                    case 1://name
                                        singleton_client.client.orderby(1);
                                        break;
                                    case 2:
                                        singleton_client.client.orderby(2);
                                        break;
                                }
                                break;
                            case 5://delete ---
                                singleton_client.client.DeleteClient(pidecliente);
                                break;
                            case 6://open
                                singleton_client.client.openfiles();
                                break;
                            case 7://save

                                break;
                        }
                    } while (option2 != 8);
                    break;
                case 2: //registered user
                    do {
                        option2 = menus.mainmenu(tipo2, singleton_global.translate.getProperty("Preghacer"),
                                "Registered main");
                        switch (option2) {
                            case 0://create  ---
                                singleton.reguser.AddUserreg(pideregistrado);
                                //pideregistrado=functions_users.pideregistrado(singleton_global.conf, translate);
                                break;
                            case 1://change data  ---
                                singleton.reguser.EditUserreg(pideregistrado);
                                /*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						functions_users.cambiauser(pideregistrado, singleton_global.conf, translate);
					}*
                                break;
                            case 2://print out  ---
                                singleton.reguser.PrintUserreg();
                                /*if(pideregistrado==null){
						JOptionPane.showMessageDialog(null, translate.getProperty("creatu"));
					}
					else{
						JOptionPane.showMessageDialog(null, pideregistrado.toString());
					}*
                                break;
                            case 3://search ---
                                singleton.reguser.UserregSearch(pideregistrado);
                                break;
                            case 4://order  ---
                                option2 = menus.mainmenu(tipo8, singleton_global.translate.getProperty("ordenar"), "Order");
                                switch (option2) {
                                    case 0://DNI
                                        singleton.reguser.orderby(0);
                                        break;
                                    case 1://name
                                        singleton.reguser.orderby(1);
                                        break;
                                    case 2:
                                        singleton.reguser.orderby(2);
                                        break;
                                }
                                break;
                            case 5://delete ---
                                singleton.reguser.DeleteUserreg(pideregistrado);
                                break;
                            case 6:
                                break;
                            case 7:
                                break;
                        }
                    } while (option2 != 8);//return
                    break;
                case 3: //configuration
                    do {
                        option2 = menus.mainmenu(tipo3, singleton_global.translate.getProperty("confmain"),
                                "Configuration main");
                        switch (option2) {
                            case 0://data
                                option2 = menus.mainmenu(tipo5, singleton_global.translate.getProperty("formatdate"),
                                        "Date format");
                                switch (option2) {
                                    case 0:
                                        singleton_global.conf.setDate('a');
                                        break;
                                    case 1:
                                        singleton_global.conf.setDate('b');
                                        break;
                                    case 2:
                                        singleton_global.conf.setDate('c');
                                        break;
                                    case 3:
                                        singleton_global.conf.setDate('d');
                                        break;
                                }
                                break;
                            case 1://currency
                                option2 = menus.mainmenu(tipo4, singleton_global.translate.getProperty("formatcurrency"),
                                        "Currency format");
                                switch (option2) {
                                    case 0:
                                        moneda = singleton_global.conf.getCurrency();
                                        singleton_global.conf.setCurrency('€');
                                        pideadmin.currency(moneda);
                                        break;
                                    case 1:
                                        moneda = singleton_global.conf.getCurrency();
                                        singleton_global.conf.setCurrency('$');
                                        pideadmin.currency(moneda);
                                        break;
                                    case 2:
                                        moneda = singleton_global.conf.getCurrency();
                                        singleton_global.conf.setCurrency('£');//�
                                        pideadmin.currency(moneda);
                                        break;
                                }
                                break;
                            case 2://decimal
                                option2 = menus.mainmenu(tipo7, singleton_global.translate.getProperty("formatdecimals"),
                                        "Decimal format");
                                switch (option2) {
                                    case 0:
                                        singleton_global.conf.setDecimal(1);
                                        break;
                                    case 1:
                                        singleton_global.conf.setDecimal(2);
                                        break;
                                    case 2:
                                        singleton_global.conf.setDecimal(3);
                                        break;
                                }
                                break;
                            case 3://language
                                option2 = menus.mainmenu(tipo6, singleton_global.translate.getProperty("Pregidioma"),
                                        "Language");
                                switch (option2) {
                                    case 0:
                                        singleton_global.conf.setLanguage("english");
                                        singleton_global.translate.setIdioma("english");
                                        singleton_global.translate.getIdioma();
                                        break;
                                    case 1:
                                        singleton_global.conf.setLanguage("castellano");
                                        singleton_global.translate.setIdioma("castellano");
                                        singleton_global.translate.getIdioma();
                                        break;
                                    case 2:
                                        singleton_global.conf.setLanguage("valencia");
                                        singleton_global.translate.setIdioma("valencia");
                                        singleton_global.translate.getIdioma();
                                        break;
                                }
                                break;
                            case 4://data format
                                option2 = menus.mainmenu(tipo9, "¿Qué formato de archivos quiere utilizar?", "Formato");
                                switch (option2) {
                                    case 0:
                                        singleton_global.conf.setFormat("json");
                                        break;
                                    case 1:
                                        singleton_global.conf.setFormat("txt");
                                        break;
                                    case 2:
                                        singleton_global.conf.setFormat("xml");
                                        break;
                                }
                                break;
                            case 5: //theme
                                option2 = menus.mainmenu(tipo10, "Selecciona un tema", "Theme");
                                switch (option2) {
                                    case 0:
                                        singleton_global.conf.setTheme(0);
                                        theme.temaElegido(singleton_global.conf.getTheme());
                                        break;
                                    case 1:
                                        singleton_global.conf.setTheme(1);
                                        theme.temaElegido(singleton_global.conf.getTheme());
                                        break;
                                    case 2:
                                        singleton_global.conf.setTheme(2);
                                        theme.temaElegido(singleton_global.conf.getTheme());
                                        break;
                                    case 3:
                                        singleton_global.conf.setTheme(3);
                                        theme.temaElegido(singleton_global.conf.getTheme());
                                        break;
                                }
                                break;
                            case 6: //dummies
                                dummies1 = menus.mainmenu(tipo11, "Activar o desactivar dummies", "Dummies");
                                switch (dummies1) {
                                    case 0:
                                        json.GenerateJsonauto();
                                        txt.Generatetxtauto();
                                        xml.Generatexmlauto();
                                        singleton_global.conf.setDummies(true);
                                        singleton.admin = new Arraylist_admin();
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
                                        break;
                                    case 1:
                                        json.GenerateJsonauto();
                                        txt.Generatetxtauto();
                                        xml.Generatexmlauto();
                                        singleton_global.conf.setDummies(false);
                                        singleton.admin = new Arraylist_admin();
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
                                        break;
                                }
                                break;
                        }
                    } while (option2 != 7);//return
                    break;
                case 4:
                    exit = true;
            }
        } while ((!exit));
        config_save.GenerateJsonautoconf();
        json.GenerateJsonauto();
        txt.Generatetxtauto();
        xml.Generatexmlauto();

        JOptionPane.showMessageDialog(null, singleton_global.translate.getProperty("goodbye"));
    }
}*/
