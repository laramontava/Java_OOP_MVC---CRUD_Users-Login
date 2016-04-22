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
        s = clientnew_view.adddni.getText();
        correct = validate.validatedni(s);
        if (correct == false) {
            val = false;
            clientnew_view.dni_validate.setIcon(cancel);
            clientnew_view.adddni.setForeground(Color.RED);
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
                clientnew_view.adddni.setForeground(Green);
            } else {
                val = false;
                clientnew_view.dni_validate.setIcon(cancel);
                clientnew_view.adddni.setForeground(Color.RED);
            }

        }
        return val;
    }

    public static boolean pidenombre() {
        boolean val = false;
        if (clientnew_view.addname.getText().isEmpty()) {
            clientnew_view.name_validate.setIcon(cancel);
            clientnew_view.addname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(clientnew_view.addname.getText())) {
            clientnew_view.name_validate.setIcon(cancel);
            clientnew_view.addname.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.name_validate.setIcon(ok);
            clientnew_view.addname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideapellidos() {
        boolean val = false;
        if (clientnew_view.addsurname.getText().isEmpty()) {
            clientnew_view.surname_validate.setIcon(cancel);
            clientnew_view.addsurname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(clientnew_view.addsurname.getText())) {
            clientnew_view.surname_validate.setIcon(cancel);
            clientnew_view.addsurname.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.surname_validate.setIcon(ok);
            clientnew_view.addsurname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidetelefono() {
        boolean val = false;
        if (clientnew_view.addmobile.getText().isEmpty()) {
            clientnew_view.mobile_validate.setIcon(cancel);
            clientnew_view.addmobile.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaTelefono(clientnew_view.addmobile.getText())) {
            clientnew_view.mobile_validate.setIcon(cancel);
            clientnew_view.addmobile.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.mobile_validate.setIcon(ok);
            clientnew_view.addmobile.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideemail() {
        boolean val = false;
        if (clientnew_view.addemail.getText().isEmpty()) {
            clientnew_view.email_validate.setIcon(cancel);
            clientnew_view.addemail.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaEmail(clientnew_view.addemail.getText())) {
            clientnew_view.email_validate.setIcon(cancel);
            clientnew_view.addemail.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.email_validate.setIcon(ok);
            clientnew_view.addemail.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideusuario() {
        boolean val = false;
        if (clientnew_view.addnameuser.getText().isEmpty()) {
            clientnew_view.nameuser_validate.setIcon(cancel);
            clientnew_view.addnameuser.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.nameuser_validate.setIcon(ok);
            clientnew_view.addnameuser.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidecontrasenya() {
        boolean val = false;
        if (clientnew_view.addpassword.getText().isEmpty()) {
            clientnew_view.password_validate.setIcon(cancel);
            clientnew_view.addpassword.setForeground(Color.RED);
            val = false;
        } else {
            clientnew_view.password_validate.setIcon(ok);
            clientnew_view.addpassword.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidecompras() {
        boolean val = false;
        if (clientnew_view.addshopping.getText().isEmpty()) {
            clientnew_view.validatesalary.setIcon(cancel);
        } else if (!validate.validaCompras(clientnew_view.addshopping.getText())) {
            clientnew_view.validatesalary.setIcon(cancel);
            clientnew_view.addshopping.setForeground(Color.RED);
        } else {
            clientnew_view.validatesalary.setIcon(ok);
            clientnew_view.addshopping.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidetipo() {
        boolean val = false;
        if (clientnew_view.addtype.getText().isEmpty()) {
            clientnew_view.validateactivity.setIcon(cancel);
        } else if (!validate.validaTipo(clientnew_view.addtype.getText())) {
            clientnew_view.validateactivity.setIcon(cancel);
            clientnew_view.addtype.setForeground(Color.RED);
        } else {
            clientnew_view.validateactivity.setIcon(ok);
            clientnew_view.addtype.setForeground(Green);
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
            Calendar date = clientnew_view.adddatebirthday.getCalendar();
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
            Calendar date = clientnew_view.addreg.getCalendar();
            fecha fe = new fecha();
            //Calendar datesystem = new GregorianCalendar();
            Calendar datesystem = fe.fechasystem();
            fecha diferencia = new fecha();
            Calendar datebirthday = clientnew_view.adddatebirthday.getCalendar();

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

            String dni = clientnew_view.adddni.getText();
            String name = clientnew_view.addname.getText();
            String surname = clientnew_view.addsurname.getText();
            String mobile = clientnew_view.addmobile.getText();
            String email = clientnew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(clientnew_view.adddatebirthday.getCalendar(), 0);
            String nameuser = clientnew_view.addnameuser.getText();
            String passwd = clientnew_view.addpassword.getText();
            String avatar = clientnew_view.addavatar.getText();
            String status = clientnew_view.add_status.getSelectedItem().toString();
            String up_date = aux.calendartostring(clientnew_view.addreg.getCalendar(), 0);
            float shopping = Float.parseFloat(clientnew_view.addshopping.getText());
            String premium = clientnew_view.addpremium.getSelectedItem().toString();
            String clienttype = clientnew_view.addtype.getText();

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

            String dni = clientnew_view.adddni.getText();
            String name = clientnew_view.addname.getText();
            String surname = clientnew_view.addsurname.getText();
            String mobile = clientnew_view.addmobile.getText();
            String email = clientnew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(clientnew_view.adddatebirthday.getCalendar(), 0);
            String nameuser = clientnew_view.addnameuser.getText();
            String passwd = clientnew_view.addpassword.getText();
            String avatar = clientnew_view.addavatar.getText();
            String status = clientnew_view.add_status.getSelectedItem().toString();
            String update = aux.calendartostring(clientnew_view.addreg.getCalendar(), 0);
            float shopping = Float.parseFloat(clientnew_view.addshopping.getText());
            String premium = clientnew_view.addpremium.getSelectedItem().toString();
            String type = clientnew_view.addtype.getText();
            int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selectedcli = TABLA.getSelectedRow();
            int selected1 = inicio + selectedcli;
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
            BLL_client.UpdateClientMongo(dni);
            val = true;
        }
        return val;
    }

    public static void fillfields(int pos) {
        fecha aux = new fecha();
        adddni.setText(singleton_client.client.getClient(pos).getDni());
        addname.setText(singleton_client.client.getClient(pos).getName());
        addsurname.setText(singleton_client.client.getClient(pos).getSubname());
        addmobile.setText(singleton_client.client.getClient(pos).getMobile());
        addemail.setText(singleton_client.client.getClient(pos).getEmail());
        adddatebirthday.setCalendar(aux.stringtocalendar(singleton_client.client.getClient(pos).getDate_birthday()));
        addnameuser.setText(singleton_client.client.getClient(pos).getUser());
        addpassword.setText(singleton_client.client.getClient(pos).getPass());
        addavatar.setText(singleton_client.client.getClient(pos).getAvatar());
        add_status.setSelectedItem(singleton_client.client.getClient(pos).getState());
        addreg.setCalendar(aux.stringtocalendar(singleton_client.client.getClient(pos).getUp_date()));
        addshopping.setText(String.valueOf(singleton_client.client.getClient(pos).getShopping()));
        addpremium.setSelectedItem(singleton_client.client.getClient(pos).getPremium());
        addtype.setText(String.valueOf(singleton_client.client.getClient(pos).getClient_type()));
        if("Premium".equals(singleton_client.client.getClient(pos).getPremium())){
            adddesc.setText("10%");
        }else{
            adddesc.setText("0%");
        }
        fecha years = new fecha();
	addyearsservice.setText(Integer.toString(years.restafechas(years.stringtocalendar(singleton_client.client.getClient(pos).getUp_date()), years.fechasystem(), "years")));
      
    }
}
