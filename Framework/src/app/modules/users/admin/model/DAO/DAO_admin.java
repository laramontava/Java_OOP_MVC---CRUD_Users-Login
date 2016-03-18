/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.admin.model.DAO;

import app.classes.fecha;
import app.classes.singleton_global;
import static app.classes.singleton_global.Green;
import static app.classes.singleton_global.cancel;
import static app.classes.singleton_global.ok;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.singleton;
import app.modules.users.admin.model.utils.pager.pagina;
import static app.modules.users.admin.view.adminmain_view.selected;
import static app.modules.users.admin.view.adminmanage_view.TABLA;
import app.modules.users.admin.view.adminnew_view;
import static app.modules.users.admin.view.adminnew_view.*;
import app.utils.validate;
import java.awt.Color;
import java.util.Calendar;

/**
 *
 * @author Lara
 */
public class DAO_admin {

    public static boolean pidedni() {
        int modulo, dninum;
        char numcalc;
        String s = "", dnicad = "", dniletra = "";
        boolean val = false, correct = false;
        String caracter = "TRWAGMYFPDXBNJZSQVHLCKET";

        dnicad = "";
        dniletra = "";
        dninum = 0;
        s = adminnew_view.adddni.getText();
        correct = validate.validatedni(s);
        if (correct == false) {
            val = false;
            adminnew_view.dni_validate.setIcon(cancel);
            adminnew_view.adddni.setForeground(Color.RED);
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
                adminnew_view.dni_validate.setIcon(ok);
                adminnew_view.adddni.setForeground(Green);
            } else {
                val = false;
                adminnew_view.dni_validate.setIcon(cancel);
                adminnew_view.adddni.setForeground(Color.RED);
            }

        }
        return val;
    }

    public static boolean pidenombre() {
        boolean val = false;
        if (adminnew_view.addname.getText().isEmpty()) {
            adminnew_view.name_validate.setIcon(cancel);
            adminnew_view.addname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(adminnew_view.addname.getText())) {
            adminnew_view.name_validate.setIcon(cancel);
            adminnew_view.addname.setForeground(Color.RED);
            val = false;
        } else {
            adminnew_view.name_validate.setIcon(ok);
            adminnew_view.addname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideapellidos() {
        boolean val = false;
        if (adminnew_view.addsurname.getText().isEmpty()) {
            adminnew_view.surname_validate.setIcon(cancel);
            adminnew_view.addsurname.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaNombre(adminnew_view.addsurname.getText())) {
            adminnew_view.surname_validate.setIcon(cancel);
            adminnew_view.addsurname.setForeground(Color.RED);
            val = false;
        } else {
            adminnew_view.surname_validate.setIcon(ok);
            adminnew_view.addsurname.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pidetelefono() {
        boolean val = false;
        if (adminnew_view.addmobile.getText().isEmpty()) {
            adminnew_view.mobile_validate.setIcon(cancel);
            adminnew_view.addmobile.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaTelefono(adminnew_view.addmobile.getText())) {
            adminnew_view.mobile_validate.setIcon(cancel);
            adminnew_view.addmobile.setForeground(Color.RED);
            val = false;
        } else {
            adminnew_view.mobile_validate.setIcon(ok);
            adminnew_view.addmobile.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideemail() {
        boolean val = false;
        if (adminnew_view.addemail.getText().isEmpty()) {
            adminnew_view.email_validate.setIcon(cancel);
            adminnew_view.addemail.setForeground(Color.RED);
            val = false;
        } else if (!validate.validaEmail(adminnew_view.addemail.getText())) {
            adminnew_view.email_validate.setIcon(cancel);
            adminnew_view.addemail.setForeground(Color.RED);
            val = false;
        } else {
            adminnew_view.email_validate.setIcon(ok);
            adminnew_view.addemail.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideusuario() {
        boolean val = false;
        if (adminnew_view.addnameuser.getText().isEmpty()) {
            adminnew_view.nameuser_validate.setIcon(cancel);
            adminnew_view.addnameuser.setForeground(Color.RED);
            val = false;
        } else {
            adminnew_view.nameuser_validate.setIcon(ok);
            adminnew_view.addnameuser.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidecontrasenya() {
        boolean val = false;
        if (adminnew_view.addpassword.getText().isEmpty()) {
            adminnew_view.password_validate.setIcon(cancel);
            adminnew_view.addpassword.setForeground(Color.RED);
            val = false;
        } else {
            adminnew_view.password_validate.setIcon(ok);
            adminnew_view.addpassword.setForeground(Green);
            val = true;

        }
        return val;
    }

    public static boolean pidesalario() {
        boolean val = false;
        if (adminnew_view.addsalary.getText().isEmpty()) {
            adminnew_view.validatesalary.setIcon(cancel);
        } else if (!validate.validatesalary(adminnew_view.addsalary.getText())) {
            adminnew_view.validatesalary.setIcon(cancel);
            adminnew_view.addsalary.setForeground(Color.RED);
        } else {
            adminnew_view.validatesalary.setIcon(ok);
            adminnew_view.addsalary.setForeground(Green);
            val = true;
        }
        return val;
    }

    public static boolean pideactividad() {
        boolean val = false;
        if (adminnew_view.addactivity.getText().isEmpty()) {
            adminnew_view.validateactivity.setIcon(cancel);
        } else if (!validate.validateactivity(adminnew_view.addactivity.getText())) {
            adminnew_view.validateactivity.setIcon(cancel);
            adminnew_view.addactivity.setForeground(Color.RED);
        } else {
            adminnew_view.validateactivity.setIcon(ok);
            adminnew_view.addactivity.setForeground(Green);
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
            Calendar date = adminnew_view.adddatebirthday.getCalendar();
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
            adminnew_view.validatebirthday.setIcon(ok);
        } else {
            adminnew_view.validatebirthday.setIcon(cancel);
        }

        return val;
    }

    public static boolean pidefechacontratacion() {
        String s = "";
        boolean val = true;
        int years = 0;
        try {
            val = true;
            //s = validatefecha(message, title);
            fecha datefecha = new fecha();
            Calendar date = adminnew_view.addcontr.getCalendar();
            fecha fe = new fecha();
            //Calendar datesystem = new GregorianCalendar();
            Calendar datesystem = fe.fechasystem();
            fecha diferencia = new fecha();
            Calendar datebirthday = adminnew_view.adddatebirthday.getCalendar();

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
            adminnew_view.validate_cont.setIcon(ok);
        } else {
            adminnew_view.validate_cont.setIcon(cancel);
        }
        return val;

    }

    public static boolean saveadmin() {
        boolean val = false;
        if (pidedni() && pidenombre() && pideapellidos() && pidefechanacimiento()
                && pidetelefono() && pideemail() && pideusuario() && pidecontrasenya()
                && pidefechacontratacion() && pidesalario() && pideactividad()) {

            String dni = adminnew_view.adddni.getText();
            String name = adminnew_view.addname.getText();
            String surname = adminnew_view.addsurname.getText();
            String mobile = adminnew_view.addmobile.getText();
            String email = adminnew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(adminnew_view.adddatebirthday.getCalendar(), 0);
            String nameuser = adminnew_view.addnameuser.getText();
            String passwd = adminnew_view.addpassword.getText();
            String avatar = adminnew_view.addavatar.getText();
            String status = adminnew_view.add_status.getSelectedItem().toString();
            String datecont = aux.calendartostring(adminnew_view.addcontr.getCalendar(), 0);
            float salary = Float.parseFloat(adminnew_view.addsalary.getText());
            int activity = Integer.parseInt(adminnew_view.addactivity.getText());

            admin admincreate = new admin(dni, name, surname, mobile, email, datebirthday,
                    nameuser, passwd, avatar, status, datecont, salary, activity);
            singleton.admin.AddAdmin(admincreate);

            val = true;
        }
        return val;
    }

    public static boolean saveeditadmin() {
        boolean val = false;
        if (pidedni() && pidenombre() && pideapellidos() && pidefechanacimiento()
                && pidetelefono() && pideemail() && pideusuario() && pidecontrasenya()
                && pidefechacontratacion() && pidesalario() && pideactividad()) {

            String dni = adminnew_view.adddni.getText();
            String name = adminnew_view.addname.getText();
            String surname = adminnew_view.addsurname.getText();
            String mobile = adminnew_view.addmobile.getText();
            String email = adminnew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday = aux.calendartostring(adminnew_view.adddatebirthday.getCalendar(), 0);
            String nameuser = adminnew_view.addnameuser.getText();
            String passwd = adminnew_view.addpassword.getText();
            String avatar = adminnew_view.addavatar.getText();
            String status = adminnew_view.add_status.getSelectedItem().toString();
            String datecont = aux.calendartostring(adminnew_view.addcontr.getCalendar(), 0);
            float salary = Float.parseFloat(adminnew_view.addsalary.getText());
            int activity = Integer.parseInt(adminnew_view.addactivity.getText());
            int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selected = TABLA.getSelectedRow();
            int selected1 = inicio + selected;
            singleton.admin.getAdmin(selected1).setDni(dni);
            singleton.admin.getAdmin(selected1).setName(name);
            singleton.admin.getAdmin(selected1).setSubname(surname);
            singleton.admin.getAdmin(selected1).setMobile(mobile);
            singleton.admin.getAdmin(selected1).setEmail(email);
            singleton.admin.getAdmin(selected1).setDate_birthday(datebirthday);
            singleton.admin.getAdmin(selected1).setUser(nameuser);
            singleton.admin.getAdmin(selected1).setPass(passwd);
            singleton.admin.getAdmin(selected1).setAvatar(avatar);
            singleton.admin.getAdmin(selected1).setState(status);
            singleton.admin.getAdmin(selected1).setHiring_date(datecont);
            singleton.admin.getAdmin(selected1).setSalary(salary);
            singleton.admin.getAdmin(selected1).setActivity(activity);
            val = true;
        }
        return val;
    }

    public static void fillfields(int pos) {
        fecha aux = new fecha();
        adddni.setText(singleton.admin.getAdmin(pos).getDni());
        addname.setText(singleton.admin.getAdmin(pos).getName());
        addsurname.setText(singleton.admin.getAdmin(pos).getSubname());
        addmobile.setText(singleton.admin.getAdmin(pos).getMobile());
        addemail.setText(singleton.admin.getAdmin(pos).getEmail());
        adddatebirthday.setCalendar(aux.stringtocalendar(singleton.admin.getAdmin(pos).getDate_birthday()));
        addnameuser.setText(singleton.admin.getAdmin(pos).getUser());
        addpassword.setText(singleton.admin.getAdmin(pos).getPass());
        addavatar.setText(singleton.admin.getAdmin(pos).getAvatar());
        add_status.setSelectedItem(singleton.admin.getAdmin(pos).getState());
        addcontr.setCalendar(aux.stringtocalendar(singleton.admin.getAdmin(pos).getHiring_date()));
        addsalary.setText(String.valueOf(singleton.admin.getAdmin(pos).getSalary()));
        addactivity.setText(String.valueOf(singleton.admin.getAdmin(pos).getActivity()));
    }
}
