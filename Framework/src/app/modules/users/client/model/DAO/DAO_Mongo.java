/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules.users.client.model.DAO;

import app.classes.fecha;
import app.classes.singleton_global;
import app.modules.users.client.model.classes.client;
import app.modules.users.client.model.classes.singleton_client;
import app.modules.users.client.view.clientnew_view;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

/**
 *
 * @author Lara
 */
public class DAO_Mongo {
    //Crear
    public static void create_client(client c) {
        singleton_global.collection.insert(c.Client_to_BBDD());
    }
    //Modificar
    public static void update_client(String dni) {
        fecha aux = new fecha();
        //Prepara para insertar un nuevo campo
        BasicDBObject updateDni = new BasicDBObject(),updateName = new BasicDBObject(),
                updateSurname = new BasicDBObject(),updateMobile = new BasicDBObject(),
                updateEmail = new BasicDBObject(),updateDate_birthday = new BasicDBObject(),
                updateName_user = new BasicDBObject(),updatePasswd = new BasicDBObject(),
                updateAvatar = new BasicDBObject(),updateState = new BasicDBObject(),
                updateUp_date = new BasicDBObject(),updateShopping = new BasicDBObject(),
                updatePremium = new BasicDBObject(), updateClient_type = new BasicDBObject();
        updateDni.append("$set", new BasicDBObject().append("dni", clientnew_view.adddni.getText()));
        updateName.append("$set", new BasicDBObject().append("name", clientnew_view.addname.getText()));
        updateSurname.append("$set", new BasicDBObject().append("subname", clientnew_view.addsurname.getText()));
        updateMobile.append("$set", new BasicDBObject().append("mobile", clientnew_view.addmobile.getText()));
        updateEmail.append("$set", new BasicDBObject().append("email", clientnew_view.addemail.getText()));
        updateDate_birthday.append("$set", new BasicDBObject().append("date_birthday", aux.calendartostring(clientnew_view.adddatebirthday.getCalendar(), 0)));
        updateName_user.append("$set", new BasicDBObject().append("user", clientnew_view.addnameuser.getText()));
        updatePasswd.append("$set", new BasicDBObject().append("pass", clientnew_view.addpassword.getText()));
        updateAvatar.append("$set", new BasicDBObject().append("avatar", clientnew_view.addavatar.getText()));
        updateState.append("$set", new BasicDBObject().append("state", clientnew_view.add_status.getSelectedItem().toString()));
        updateUp_date.append("$set", new BasicDBObject().append("up_date", aux.calendartostring(clientnew_view.addreg.getCalendar(), 0)));
        updateShopping.append("$set", new BasicDBObject().append("shopping", Float.parseFloat(clientnew_view.addshopping.getText())));
        updatePremium.append("$set", new BasicDBObject().append("premium", clientnew_view.addpremium.getSelectedItem().toString()));
        updateClient_type.append("$set", new BasicDBObject().append("client_type", clientnew_view.addtype.getText()));
        //Busca el/los registro/s con el nombre indicado
        BasicDBObject searchById = new BasicDBObject();
        searchById.append("dni", dni);
 
        //Realiza la actualización
        singleton_global.collection.updateMulti(searchById, updateDni);
        singleton_global.collection.updateMulti(searchById, updateName);
        singleton_global.collection.updateMulti(searchById, updateSurname);
        singleton_global.collection.updateMulti(searchById, updateMobile);
        singleton_global.collection.updateMulti(searchById, updateEmail);
        singleton_global.collection.updateMulti(searchById, updateDate_birthday);
        singleton_global.collection.updateMulti(searchById, updateName_user);
        singleton_global.collection.updateMulti(searchById, updatePasswd);
        singleton_global.collection.updateMulti(searchById, updateAvatar);
        singleton_global.collection.updateMulti(searchById, updateState);
        singleton_global.collection.updateMulti(searchById, updateUp_date);
        singleton_global.collection.updateMulti(searchById, updateShopping);
        singleton_global.collection.updateMulti(searchById, updatePremium);
        singleton_global.collection.updateMulti(searchById, updateClient_type);
    }
    public static void delete_client(String dni) {
        singleton_global.collection.remove(new BasicDBObject().append("dni", dni));
    }
   
    public static void read_client() {
        DBCursor cursor = null;
        client c = new client();
        try {
            cursor = singleton_global.collection.find();
            if(cursor.count()!=0){
                for(int i = 0;i < cursor.size();i++){
                    System.out.println("01");
                    BasicDBObject document = (BasicDBObject) cursor.next();
                    System.out.println("02");
                    c = c.BBDD_to_client(document);
                    System.out.println("03");
                    client j = new client(c.getDni(),c.getName(),c.getSubname(),c.getMobile(),c.getEmail(),c.getDate_birthday(),
                    c.getUser(),c.getPass(),c.getAvatar(),c.getState(),c.getUp_date(),c.getShopping(),c.getPremium(),c.getClient_type());
                    singleton_client.client.AddClient(j);
                    
                }
            }else{
                System.out.println("NOT DATA"); 
            }
        } finally {
            if (cursor != null){
		cursor.close();
            }
	}	
    }
}
