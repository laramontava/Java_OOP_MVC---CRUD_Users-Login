/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.registered_user.model.DAO;

import app.classes.fecha;
import app.classes.singleton_global;
import static app.classes.singleton_global.Green;
import static app.classes.singleton_global.cancel;
import static app.classes.singleton_global.ok;
import app.modules.users.registered_user.model.classes.registered_user;
import app.modules.users.registered_user.model.classes.singleton_reguser;
import app.modules.users.registered_user.model.utils.pager.pagina;
import static app.modules.users.registered_user.view.regusermanage_view.TABLA;
import app.modules.users.registered_user.view.regusernew_view;
import static app.modules.users.registered_user.view.regusernew_view.*;
import app.utils.validate;
import java.awt.Color;
import java.util.Calendar;

/**
 *
 * @author Lara
 */
public class DAO_reguser {
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

    public static boolean pideactividad() {
        boolean val = false;
        if (regusernew_view.addactivity.getText().isEmpty()) {
            regusernew_view.validatesalary.setIcon(cancel);
        } else if (!validate.validaCompras(regusernew_view.addactivity.getText())) {
            regusernew_view.validatesalary.setIcon(cancel);
            regusernew_view.addactivity.setForeground(Color.RED);
        } else {
            regusernew_view.validatesalary.setIcon(ok);
            regusernew_view.addactivity.setForeground(Green);
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

    

    public static boolean savereguser() {
        boolean val = false;
        if (pidedni() && pidenombre() && pideapellidos() && pidefechanacimiento()
                && pidetelefono() && pideemail() && pideusuario() && pidecontrasenya()
                && pideactividad()) {

            String dni = regusernew_view.adddni.getText();
            String name = regusernew_view.addname.getText();
            String surname = regusernew_view.addsurname.getText();
            String mobile = regusernew_view.addmobile.getText();
            String email = regusernew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday="";
            if(singleton_global.conf.getDate()=='a'){
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 0);
            } else if(singleton_global.conf.getDate()=='b'){
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 1);
            } else if(singleton_global.conf.getDate()=='c'){
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 2);
            } else {
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 3);
            }
            
            String nameuser = regusernew_view.addnameuser.getText();
            String passwd = regusernew_view.addpassword.getText();
            String avatar = regusernew_view.addavatar.getText();
            String status = regusernew_view.add_status.getSelectedItem().toString();
            int activity = Integer.parseInt(regusernew_view.addactivity.getText());

            registered_user regusercreate = new registered_user(dni, name, surname, mobile, email, datebirthday,
			nameuser, passwd, avatar, status, activity);
            singleton_reguser.reguser.AddUserreg(regusercreate);

            val = true;
        }
        return val;
    }

    public static boolean saveeditreguser() {
        boolean val = false;
        if (pidedni() && pidenombre() && pideapellidos() && pidefechanacimiento()
                && pidetelefono() && pideemail() && pideusuario() && pidecontrasenya()
                && pideactividad()) {

            String dni = regusernew_view.adddni.getText();
            String name = regusernew_view.addname.getText();
            String surname = regusernew_view.addsurname.getText();
            String mobile = regusernew_view.addmobile.getText();
            String email = regusernew_view.addemail.getText();
            fecha aux = new fecha();
            String datebirthday = "";
            if(singleton_global.conf.getDate()=='a'){
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 0);
            } else if(singleton_global.conf.getDate()=='b'){
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 1);
            } else if(singleton_global.conf.getDate()=='c'){
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 2);
            } else {
                datebirthday = aux.calendartostring(regusernew_view.adddatebirthday.getCalendar(), 3);
            }
            String nameuser = regusernew_view.addnameuser.getText();
            String passwd = regusernew_view.addpassword.getText();
            String avatar = regusernew_view.addavatar.getText();
            String status = regusernew_view.add_status.getSelectedItem().toString();
            int activity = Integer.parseInt(regusernew_view.addactivity.getText());
            int inicio = (pagina.currentPageIndex - 1) * pagina.itemsPerPage;
            selectedcli = TABLA.getSelectedRow();
            int selected1 = inicio + selectedcli;
            singleton_reguser.reguser.getClient(selected1).setDni(dni);
            singleton_reguser.reguser.getClient(selected1).setName(name);
            singleton_reguser.reguser.getClient(selected1).setSubname(surname);
            singleton_reguser.reguser.getClient(selected1).setMobile(mobile);
            singleton_reguser.reguser.getClient(selected1).setEmail(email);
            singleton_reguser.reguser.getClient(selected1).setDate_birthday(datebirthday);
            singleton_reguser.reguser.getClient(selected1).setUser(nameuser);
            singleton_reguser.reguser.getClient(selected1).setPass(passwd);
            singleton_reguser.reguser.getClient(selected1).setAvatar(avatar);
            singleton_reguser.reguser.getClient(selected1).setState(status);
            singleton_reguser.reguser.getClient(selected1).setActivity(activity);
            val = true;
        }
        return val;
    }

    public static void fillfields(int pos) {
        fecha aux = new fecha();
        adddni.setText(singleton_reguser.reguser.getClient(pos).getDni());
        addname.setText(singleton_reguser.reguser.getClient(pos).getName());
        addsurname.setText(singleton_reguser.reguser.getClient(pos).getSubname());
        addmobile.setText(singleton_reguser.reguser.getClient(pos).getMobile());
        addemail.setText(singleton_reguser.reguser.getClient(pos).getEmail());
        adddatebirthday.setCalendar(aux.stringtocalendar(singleton_reguser.reguser.getClient(pos).getDate_birthday()));
        addnameuser.setText(singleton_reguser.reguser.getClient(pos).getUser());
        addpassword.setText(singleton_reguser.reguser.getClient(pos).getPass());
        addavatar.setText(singleton_reguser.reguser.getClient(pos).getAvatar());
        add_status.setSelectedItem(singleton_reguser.reguser.getClient(pos).getState());
        addactivity.setText(Integer.toString(singleton_reguser.reguser.getClient(pos).getActivity()));
        
        if(singleton_reguser.reguser.getClient(pos).getActivity()<=999){
            addkarma.setSelectedItem("Bajo");
            addpoints.setText(Integer.toString(singleton_reguser.reguser.getClient(pos).getActivity()*5));
        }else if((singleton_reguser.reguser.getClient(pos).getActivity()>=1000)&&
                (singleton_reguser.reguser.getClient(pos).getActivity()<=4999)){
            addkarma.setSelectedItem("Medio");
            addpoints.setText(Integer.toString(singleton_reguser.reguser.getClient(pos).getActivity()*7));
        }else if(singleton_reguser.reguser.getClient(pos).getActivity()>=5000){
            addkarma.setSelectedItem("Alto");
            addpoints.setText(Integer.toString(singleton_reguser.reguser.getClient(pos).getActivity()*10));
        }
    }
}
