package app.modules.users.admin.model.utils;

import app.classes.ConnectionBBDD;
import app.modules.users.admin.model.classes.admin;
import app.modules.users.admin.model.classes.singleton;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dummiesbbdd {

    //DAOBD, BLLBD, simpletablemodel, controller
    public static void cargarDatosAdmin() throws SQLException {
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        PreparedStatement stmt = null;
        int resultado = 0;

        _con = _conexion_DB.AbrirConexion(); 
        for (int i = 0; i < singleton.admin.getAdmins().size(); i++) {
            stmt = _con.prepareStatement("INSERT INTO admin"
                    + "(dni,name,subname,mobile,email,date_birthday,age,user,pass"
                    + ",avatar,state,hiring_date,years_service,salary,activity) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, singleton.admin.getAdmins().get(i).getDni());
            stmt.setString(2, singleton.admin.getAdmins().get(i).getName());
            stmt.setString(3, singleton.admin.getAdmins().get(i).getSubname());
            stmt.setString(4, singleton.admin.getAdmins().get(i).getMobile());
            stmt.setString(5, singleton.admin.getAdmins().get(i).getEmail());
            stmt.setString(6, singleton.admin.getAdmins().get(i).getDate_birthday());
            stmt.setInt(7, singleton.admin.getAdmins().get(i).getAge());
            stmt.setString(8, singleton.admin.getAdmins().get(i).getUser());
            stmt.setString(9, singleton.admin.getAdmins().get(i).getPass());
            stmt.setString(10, singleton.admin.getAdmins().get(i).getAvatar());
            stmt.setString(11, singleton.admin.getAdmins().get(i).getState());
            stmt.setString(12, singleton.admin.getAdmins().get(i).getHiring_date());
            stmt.setInt(13, singleton.admin.getAdmins().get(i).getYears_service());
            stmt.setFloat(14, singleton.admin.getAdmins().get(i).getSalary());
            stmt.setInt(15, singleton.admin.getAdmins().get(i).getActivity());

            stmt.executeUpdate();
        }
        _conexion_DB.CerrarConexion(_con);
    }
}
