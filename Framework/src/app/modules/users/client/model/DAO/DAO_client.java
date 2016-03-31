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
import app.modules.users.client.model.classes.client;
import app.modules.users.client.model.classes.singleton_client;
import app.modules.users.client.model.utils.pager.pagina;
import static app.modules.users.client.view.clientmanage_view.TABLA;
import app.modules.users.client.view.regusernew_view;
import static app.modules.users.client.view.regusernew_view.*;
import app.utils.validate;
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
        s = regusernew_view.adddni.getText();
        correct = validate.validatedni(s);
        if (correct == false) {
            val = false;
            regusernew_view.dni_validate.setIcon(cancel);
            regusernew_view.adddni.setForeground(Color.RED);
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
                regusernew_view.dni_validate.setIcon(ok);
                regusernew_view.adddni.setForeground(Green);
            } else {
                val = false;
                regusernew_view.dni_validate.setIcon(cancel);
                regusernew_view.adddni.setForeground(Color.RED);
            }

        }
        return val;
    }

    public static boolean pidenombre() {
        boolean val = false;
        if (regusernew_view.addname.getText().isEmpty()) {
            regusernew_view.name_validate.setIcon(cancel);
            regusernew_view.addname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(regusernew_view.addname.getText())) {
            regusernew_view.name_validate.setIcon(cancel);
            regusernew_view.addname.setForeground(Color.RED);
            val = false;
        } else {
            regusernew_view.name_validate.setIcon(ok);
            regusernew_view.addname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideapellidos() {
        boolean val = false;
        if (regusernew_view.addsurname.getText().isEmpty()) {
            regusernew_view.surname_validate.setIcon(cancel);
            regusernew_view.addsurname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(regusernew_view.addsurname.getText())) {
            regusernew_view.surname_validate.setIcon(cancel);
            regusernew_view.addsurname.setForeground(Color.RED);
            val = false;
        } else {
            regusernew_view.surname_validate.setIcon(ok);
            regusernew_view.addsurname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidetelefono() {
        boolean val = false;
        if (regusernew_view.addmobile.getText().isEmpty()) {
            regusernew_view.mobile_validate.setIcon(cancel);
            regusernew_view.addmobile.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaTelefono(regusernew_view.addmobile.getText())) {
            regusernew_view.mobile_validate.setIcon(cancel);
            regusernew_view.addmobile.setForeground(Color.RED);
            val = false;
        } else {
            regusernew_view.mobile_validate.setIcon(ok);
            regusernew_view.addmobile.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideemail() {
        boolean val = false;
        if (regusernew_view.addemail.getText().isEmpty()) {
            regusernew_view.email_validate.setIcon(cancel);
            regusernew_view.addemail.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaEmail(regusernew_view.addemail.getText())) {
            regusernew_view.email_validate.setIcon(cancel);
            regusernew_view.addemail.setForeground(Color.RED);
            val = false;
        } else {
            regusernew_view.email_validate.setIcon(ok);
            regusernew_view.addemail.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideusuario() {
        boolean val = false;
        if (regusernew_view.addnameuser.getText().isEmpty()) {
            regusernew_view.nameuser_validate.setIcon(cancel);
            regusernew_view.addnameuser.setForeground(Color.RED);
            val = false;
        } else {
            regusernew_view.nameuser_validate.setIcon(ok);
            regusernew_view.addnameuser.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidecontrasenya() {
        boolean val = false;
        if (regusernew_view.addpassword.getText().isEmpty()) {
            regusernew_view.password_validate.setIcon(cancel);
            regusernew_view.addpassword.setForeground(Color.RED);
            val = false;
        } else {
            regusernew_view.password_validate.setIcon(ok);
            regusernew_view.addpassword.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidecompras() {
        boolean val = false;
        if (regusernew_view.addshopping.getText().isEmpty()) {
            regusernew_view.validatesalary.setIcon(cancel);
        } else if (!validate.validaCompras(regusernew_view.addshopping.getText())) {
            regusernew_view.validatesalary.setIcon(cancel);
            regusernew_view.addshopping.setForeground(Color.RED);
        } else {
            regusernew_view.validatesalary.setIcon(ok);
            regusernew_view.addshopping.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidetipo() {
        boolean val = false;
        if (regusernew_view.addtype.getText().isEmpty()) {
            regusernew_view.validateactivity.setIcon(cancel);
        } else if (!validate.validaTipo(regusernew_view.addtype.getText())) {
            regusernew_view.validateactivity.setIcon(cancel);
            regusernew_view.addtype.setForeground(Color.RED);
        } else {
            regusernew_view.validateactivity.setIcon(ok);
            regusernew_view.addtype.setForeground(Green);
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
            Calendar date = regusernew_view.adddatebirthday.getCalendar();
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
            regusernew_view.validatebirthday.setIcon(ok);
        } else {
            regusernew_view.validatebirthday.setIcon(cancel);
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
            Calendar date = regusernew_view.addreg.getCalendar();
            fecha fe = new fecha();
            //Calendar datesystem = new GregorianCalendar();
            Calendar datesystem = fe.fechasystem();
            fecha diferencia = new fecha();
            Calendar datebirthday = regusernew_view.adddatebirthday.getCalendar();

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
            regusernew_view.validate_cont.setIcon(ok);
        } else {
            regusernew_view.validate_cont.setIcon(cancel);
        }
        return val;

    }

    public static boolean saveclient() {
        boolean val = false;
        if (pidedni() && pidenombre() && pideapellidos() && pidefechanacimiento()
                && pidetelefono() && pideemail() && pideusuario() && pidecontrasenya()
                && pidefecharegistro() && pidecompras() && pidetipo()) {

            String dni = regusernew_view.adddni.getText();
            String name = regusernew_view.addname.getText();
            String surname = regusernew_view.addsurname.getText();
            String mobile = regusernew_view.addmobile.getText();
            String email = regusernew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 0);
            String nameuser = regusernew_view.addnameuser.getText();
            String passwd = regusernew_view.addpassword.getText();
            String avatar = regusernew_view.addavatar.getText();
            String status = regusernew_view.add_status.getSelectedItem().toString();
            String up_date = aux.calendartostring(regusernew_view.addreg.getCalendar(), 0);
            float shopping = Float.parseFloat(regusernew_view.addshopping.getText());
            String premium = regusernew_view.addpremium.getSelectedItem().toString();
            String clienttype = regusernew_view.addtype.getText();

            client clientcreate = new client(dni, name, surname, mobile, email, datebirthday,
			nameuser, passwd, avatar, status, up_date, shopping,
			premium, clienttype);
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

            String dni = regusernew_view.adddni.getText();
            String name = regusernew_view.addname.getText();
            String surname = regusernew_view.addsurname.getText();
            String mobile = regusernew_view.addmobile.getText();
            String email = regusernew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 0);
            String nameuser = regusernew_view.addnameuser.getText();
            String passwd = regusernew_view.addpassword.getText();
            String avatar = regusernew_view.addavatar.getText();
            String status = regusernew_view.add_status.getSelectedItem().toString();
            String update = aux.calendartostring(regusernew_view.addreg.getCalendar(), 0);
            float shopping = Float.parseFloat(regusernew_view.addshopping.getText());
            String premium = regusernew_view.addpremium.getSelectedItem().toString();
            String type = regusernew_view.addtype.getText();
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
