/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.client.model.DAO;

import app.classes.fecha;
import app.classes.singleton_global;
import static app.classes.singleton_global.Green;
import static app.classes.singleton_global.cancel;
import static app.classes.singleton_global.ok;
import app.modules.users.client.model.BLL.BLL_client;
import app.modules.users.client.model.classes.client;
import app.modules.users.client.model.classes.singleton_client;
import app.modules.users.client.model.utils.pager.pagina;
import static app.modules.users.client.view.clientmanage_view.TABLA;
import app.modules.users.client.view.clientnew_view;
import static app.modules.users.client.view.clientnew_view.*;
import app.utils.validate;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import java.awt.Color;
import java.util.Calendar;

/**
 *
 * @author Lara
 */
public class DAO_client {
    public static int selectedcli;
    public static boolean pidedni() {
        int modulo, dninum;
        char numcalc;
        String s = "", dnicad = "", dniletra = "";
        boolean val = false, correct = false;
        String caracter = "TRWAGMYFPDXBNJZSQVHLCKET";

        dnicad = "";
        dniletra = "";
        dninum = 0;
        s = clientnew_view.adddnic.getText();
        correct = validate.validatedni(s);
        if (correct == false) {
            val = false;
            clientnew_view.dni_validate.setIcon(cancel);
            clientnew_view.adddnic.setForeground(Color.RED);
        }
        if (correct == true) {
            for (int i = 0; i < 8; i++) {
                dnicad += s.charAt(i);
            }
            dniletra += s.charAt(8);
            dninum = Integer.parseInt(dnicad);
            modulo = dninum % 23;
            numcalc = caracter.charAt(modulo);
            if (String.valueOf(numcalc).equals(dniletra)) {
                val = true;
                clientnew_view.dni_validate.setIcon(ok);
                clientnew_view.adddnic.setForeground(Green);
            } else {
                val = false;
                clientnew_view.dni_validate.setIcon(cancel);
                clientnew_view.adddnic.setForeground(Color.RED);
            }

        }
        return val;
    }

    public static boolean pidenombre() {
        boolean val = false;
        if (clientnew_view.caddname.getText().isEmpty()) {
            clientnew_view.name_validate.setIcon(cancel);
            clientnew_view.caddname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(clientnew_view.caddname.getText())) {
            clientnew_view.name_validate.setIcon(cancel);
            clientnew_view.caddname.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.name_validate.setIcon(ok);
            clientnew_view.caddname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideapellidos() {
        boolean val = false;
        if (clientnew_view.caddsurname.getText().isEmpty()) {
            clientnew_view.surname_validate.setIcon(cancel);
            clientnew_view.caddsurname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(clientnew_view.caddsurname.getText())) {
            clientnew_view.surname_validate.setIcon(cancel);
            clientnew_view.caddsurname.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.surname_validate.setIcon(ok);
            clientnew_view.caddsurname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidetelefono() {
        boolean val = false;
        if (clientnew_view.caddmobile.getText().isEmpty()) {
            clientnew_view.mobile_validate.setIcon(cancel);
            clientnew_view.caddmobile.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaTelefono(clientnew_view.caddmobile.getText())) {
            clientnew_view.mobile_validate.setIcon(cancel);
            clientnew_view.caddmobile.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.mobile_validate.setIcon(ok);
            clientnew_view.caddmobile.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideemail() {
        boolean val = false;
        if (clientnew_view.caddemail.getText().isEmpty()) {
            clientnew_view.email_validate.setIcon(cancel);
            clientnew_view.caddemail.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaEmail(clientnew_view.caddemail.getText())) {
            clientnew_view.email_validate.setIcon(cancel);
            clientnew_view.caddemail.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.email_validate.setIcon(ok);
            clientnew_view.caddemail.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideusuario() {
        boolean val = false;
        if (clientnew_view.caddnameuser.getText().isEmpty()) {
            clientnew_view.nameuser_validate.setIcon(cancel);
            clientnew_view.caddnameuser.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.nameuser_validate.setIcon(ok);
            clientnew_view.caddnameuser.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidecontrasenya() {
        boolean val = false;
        if (clientnew_view.caddpassword.getText().isEmpty()) {
            clientnew_view.password_validate.setIcon(cancel);
            clientnew_view.caddpassword.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.password_validate.setIcon(ok);
            clientnew_view.caddpassword.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidecompras() {
        boolean val = false;
        if (clientnew_view.caddshopping.getText().isEmpty()) {
            clientnew_view.validatesalary.setIcon(cancel);
        } else if (!validate.validaCompras(clientnew_view.caddshopping.getText())) {
            clientnew_view.validatesalary.setIcon(cancel);
            clientnew_view.caddshopping.setForeground(Color.RED);
        } else {
            clientnew_view.validatesalary.setIcon(ok);
            clientnew_view.caddshopping.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidetipo() {
        boolean val = false;
        if (clientnew_view.caddtype.getText().isEmpty()) {
            clientnew_view.validateactivity.setIcon(cancel);
        } else if (!validate.validaTipo(clientnew_view.caddtype.getText())) {
            clientnew_view.validateactivity.setIcon(cancel);
            clientnew_view.caddtype.setForeground(Color.RED);
        } else {
            clientnew_view.validateactivity.setIcon(ok);
            clientnew_view.caddtype.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidefechanacimiento() {
        String s = "";
        boolean val = true;
        int resultado = 0;
        try {
            val = true;
            Calendar date = clientnew_view.cadddatebirthday.getCalendar();
            fecha fe = new fecha();
            Calendar datesystem = fe.fechasystem();

            if (date.after(datesystem)) {
                jlblcreate.setText(singleton_global.translate.getProperty("future"));
                val = false;
            }
            if (val == true) {
                fecha resta = new fecha();
                resultado = resta.restafechas(date, datesystem, "years");

                if (resultado < 18) {
                    val = false;
                    jlblcreate.setText(singleton_global.translate.getProperty("menor"));
                }
            }
        } catch (Exception e) {
            val = false;
        }
        if (val) {
            clientnew_view.validatebirthday.setIcon(ok);
        } else {
            clientnew_view.validatebirthday.setIcon(cancel);
        }

        return val;
    }

    public static boolean pidefecharegistro() {
        String s = "";
        boolean val = true;
        int years = 0;
        try {
            val = true;
            //s = validatefecha(message, title);
            fecha datefecha = new fecha();
            Calendar date = clientnew_view.caddreg.getCalendar();
            fecha fe = new fecha();
            //Calendar datesystem = new GregorianCalendar();
            Calendar datesystem = fe.fechasystem();
            fecha diferencia = new fecha();
            Calendar datebirthday = clientnew_view.cadddatebirthday.getCalendar();

            if (date.after(datesystem)) {
                jlblcreate.setText(singleton_global.translate.getProperty("future"));
                val = false;
            }

            years = diferencia.restafechas(date, datebirthday, "years");
            if (diferencia.restafechas(date, datebirthday, "years") <= 18) {
                jlblcreate.setText(singleton_global.translate.getProperty("menor"));
                val = false;
            }
            if (val == true) {
                fecha resta = new fecha();
                resta.restafechas(date, datesystem, "years");
            }
        } catch (Exception e) {
            val = false;
        }
        if (val) {
            clientnew_view.validate_cont.setIcon(ok);
        } else {
            clientnew_view.validate_cont.setIcon(cancel);
        }
        return val;

    }

    public static boolean saveclient() {
        boolean val = false;
        if (pidedni() && pidenombre() && pideapellidos() && pidefechanacimiento()
                && pidetelefono() && pideemail() && pideusuario() && pidecontrasenya()
                && pidefecharegistro() && pidecompras() && pidetipo()) {

            String dni = clientnew_view.adddnic.getText();
            String name = clientnew_view.caddname.getText();
            String surname = clientnew_view.caddsurname.getText();
            String mobile = clientnew_view.caddmobile.getText();
            String email = clientnew_view.caddemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(clientnew_view.cadddatebirthday.getCalendar(), 0);
            String nameuser = clientnew_view.caddnameuser.getText();
            String passwd = clientnew_view.caddpassword.getText();
            String avatar = clientnew_view.caddavatar.getText();
            String status = clientnew_view.cadd_status.getSelectedItem().toString();
            String up_date = aux.calendartostring(clientnew_view.caddreg.getCalendar(), 0);
            float shopping = Float.parseFloat(clientnew_view.caddshopping.getText());
            String premium = clientnew_view.caddpremium.getSelectedItem().toString();
            String clienttype = clientnew_view.caddtype.getText();

            client clientcreate = new client(dni, name, surname, mobile, email, datebirthday,
			nameuser, passwd, avatar, status, up_date, shopping,
			premium, clienttype);
            BLL_client.CreateClientMongo(clientcreate);
            singleton_client.client.AddClient(clientcreate);

            val = true;
        }
        return val;
    }

    public static boolean saveeditclient() {
        boolean val = false;
        if (pidedni() && pidenombre() && pideapellidos() && pidefechanacimiento()
                && pidetelefono() && pideemail() && pideusuario() && pidecontrasenya()
                && pidefecharegistro() && pidecompras() && pidetipo()) {

            String dni = clientnew_view.adddnic.getText();
            String name = clientnew_view.caddname.getText();
            String surname = clientnew_view.caddsurname.getText();
            String mobile = clientnew_view.caddmobile.getText();
            String email = clientnew_view.caddemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(clientnew_view.cadddatebirthday.getCalendar(), 0);
            String nameuser = clientnew_view.caddnameuser.getText();
            String passwd = clientnew_view.caddpassword.getText();
            String avatar = clientnew_view.caddavatar.getText();
            String status = clientnew_view.cadd_status.getSelectedItem().toString();
            String update = aux.calendartostring(clientnew_view.caddreg.getCalendar(), 0);
            float shopping = Float.parseFloat(clientnew_view.caddshopping.getText());
            String premium = clientnew_view.caddpremium.getSelectedItem().toString();
            String type = clientnew_view.caddtype.getText();
            int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selectedcli = TABLA.getSelectedRow();
            int selected1 = inicio + selectedcli;
            BLL_client.UpdateClientMongo(singleton_client.client.getClient(selected1).getDni());
            singleton_client.client.getClient(selected1).setDni(dni);
            singleton_client.client.getClient(selected1).setName(name);
            singleton_client.client.getClient(selected1).setSubname(surname);
            singleton_client.client.getClient(selected1).setMobile(mobile);
            singleton_client.client.getClient(selected1).setEmail(email);
            singleton_client.client.getClient(selected1).setDate_birthday(datebirthday);
            singleton_client.client.getClient(selected1).setUser(nameuser);
            singleton_client.client.getClient(selected1).setPass(passwd);
            singleton_client.client.getClient(selected1).setAvatar(avatar);
            singleton_client.client.getClient(selected1).setState(status);
            singleton_client.client.getClient(selected1).setUp_date(update);
            singleton_client.client.getClient(selected1).setShopping(shopping);
            singleton_client.client.getClient(selected1).setPremium(premium);
            singleton_client.client.getClient(selected1).setClient_type(type);
            
            val = true;
        }
        return val;
    }

    public static void fillfields(int pos) {
        fecha aux = new fecha();
        adddnic.setText(singleton_client.client.getClient(pos).getDni());
        caddname.setText(singleton_client.client.getClient(pos).getName());
        caddsurname.setText(singleton_client.client.getClient(pos).getSubname());
        caddmobile.setText(singleton_client.client.getClient(pos).getMobile());
        caddemail.setText(singleton_client.client.getClient(pos).getEmail());
        cadddatebirthday.setCalendar(aux.stringtocalendar(singleton_client.client.getClient(pos).getDate_birthday()));
        caddnameuser.setText(singleton_client.client.getClient(pos).getUser());
        caddpassword.setText(singleton_client.client.getClient(pos).getPass());
        caddavatar.setText(singleton_client.client.getClient(pos).getAvatar());
        cadd_status.setSelectedItem(singleton_client.client.getClient(pos).getState());
        caddreg.setCalendar(aux.stringtocalendar(singleton_client.client.getClient(pos).getUp_date()));
        caddshopping.setText(String.valueOf(singleton_client.client.getClient(pos).getShopping()));
        caddpremium.setSelectedItem(singleton_client.client.getClient(pos).getPremium());
        caddtype.setText(String.valueOf(singleton_client.client.getClient(pos).getClient_type()));
        if("Premium".equals(singleton_client.client.getClient(pos).getPremium())){
            cadddesc.setText("10%");
        }else{
            cadddesc.setText("0%");
        }
        fecha years = new fecha();
	caddyearsservice.setText(Integer.toString(years.restafechas(years.stringtocalendar(singleton_client.client.getClient(pos).getUp_date()), years.fechasystem(), "years")));
      
    }
}
