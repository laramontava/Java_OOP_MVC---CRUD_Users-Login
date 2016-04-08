package app.modules.users.admin.model.utils;

import app.classes.ConnectionBBDD;
import app.modules.users.admin.model.classes.admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dummiesbbdd {

    public static void cargarDatosEF() throws SQLException {
        Connection _con = null;
        ConnectionBBDD _conexion_DB = new ConnectionBBDD();
        PreparedStatement stmt = null;
        int resultado = 0;

        _con = _conexion_DB.AbrirConexion();
            admin admind = new admin("00000000T", "Nana", "Maya", "666666666", "asd@asd.asd", "12/12/1900",
                    "miau", "123", "av.jpg", "offline", "12/02/2016", 53423, 999);
            
            stmt = _con.prepareStatement("INSERT INTO admin"
                    + "(dni,name,subname,mobile,email,date_birthday,age,user,pass"
                    + ",avatar,state,hiring_date,years_service,salary,activity) "
                    + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, admind.getDni());
            stmt.setString(2, admind.getName());
            stmt.setString(3, admind.getSubname());
            stmt.setString(4, admind.getMobile());
            stmt.setString(5, admind.getEmail());
            stmt.setString(6, admind.getDate_birthday());
            stmt.setInt(7, admind.getAge());
            stmt.setString(8, admind.getUser());
            stmt.setString(9, admind.getPass());
            stmt.setString(10, admind.getAvatar());
            stmt.setString(11, admind.getState());
            stmt.setString(12, admind.getHiring_date());
            stmt.setInt(13, admind.getYears_service());
            stmt.setFloat(14, admind.getSalary());
            stmt.setInt(15, admind.getActivity());

            stmt.executeUpdate();
        
        _conexion_DB.CerrarConexion(_con);
    }
}
