package app.classes;

import app.bbdd_mongo.Mongo_DB;
import app.modules.menu.model.idioma;
import app.modules.menu.model.configuration;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import java.awt.Color;
import javax.swing.ImageIcon;

public class singleton_global {
	public static configuration conf;
	public static idioma translate;
        public static ImageIcon cancel = new ImageIcon("src/app/modules/users/admin/view/img/error.png");
        public static ImageIcon ok = new ImageIcon("src/app/modules/users/admin/view/img/done.png");
        public static Color Green = new Color(3, 133, 3);
        
        public static Mongo_DB mongo = null;
        public static Mongo client = null;
        public static String nom_bd = null;
        public static DB db = null;
        public static String nom_table = "";
        public static DBCollection collection = null;
        
        public static String type="";
}
