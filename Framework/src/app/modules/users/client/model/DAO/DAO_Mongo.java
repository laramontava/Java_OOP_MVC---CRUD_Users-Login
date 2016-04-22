/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.client.model.DAO;

import app.classes.singleton_global;
import app.modules.users.client.model.classes.client;
import app.modules.users.client.view.clientnew_view;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;

/**
 *
 * @author Lara
 */
public class DAO_Mongo {
    public static void create_client(client c) {
        singleton_global.collection.insert(c.Client_to_BBDD());
    }
    public static void update_worker(String dni) {
        //Prepara para insertar un nuevo campo
        BasicDBObject updateClient = new BasicDBObject();
        updateClient.append("$set", new BasicDBObject().append("dni", clientnew_view.adddni.getText()));
        updateClient.append("$set", new BasicDBObject().append("name", clientnew_view.addname.getText()));
        updateClient.append("$set", new BasicDBObject().append("subname", clientnew_view.addsurname.getText()));
        updateClient.append("$set", new BasicDBObject().append("date_birthday", clientnew_view.adddatebirthday));
        updateClient.append("$set", new BasicDBObject().append("mobile", clientnew_view.addmobile.getText()));
        updateClient.append("$set", new BasicDBObject().append("email", clientnew_view.addemail.getText()));
        updateClient.append("$set", new BasicDBObject().append("user", clientnew_view.addnameuser.getText()));
        updateClient.append("$set", new BasicDBObject().append("pass", clientnew_view.addpassword.getText()));
        updateClient.append("$set", new BasicDBObject().append("avatar", clientnew_view.addavatar.getText()));
        updateClient.append("$set", new BasicDBObject().append("state", clientnew_view.add_status));
        updateClient.append("$set", new BasicDBObject().append("hiring_date", clientnew_view.addreg));
        updateClient.append("$set", new BasicDBObject().append("years_service", clientnew_view.addyearsservice.getText()));
        updateClient.append("$set", new BasicDBObject().append("premium", clientnew_view.addpremium));
        updateClient.append("$set", new BasicDBObject().append("shopping", clientnew_view.addshopping.getText()));
        updateClient.append("$set", new BasicDBObject().append("", clientnew_view.adddesc.getText()));
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", dni);
 
        //Realiza la actualización
        singleton_global.collection.updateMulti(searchById, updateClient);
    }
    public static void delete_client(String dni) {
        singleton_global.collection.remove(new BasicDBObject().append("dni", dni));
    }
}
