package app.classes;

import app.modules.menu.model.idioma;
import app.modules.menu.model.configuration;
import java.awt.Color;
import javax.swing.ImageIcon;

public class singleton_global {
	public static configuration conf;
	public static idioma translate;
        public static ImageIcon cancel = new ImageIcon("src/app/modules/users/admin/view/img/error.png");
        public static ImageIcon ok = new ImageIcon("src/app/modules/users/admin/view/img/done.png");
        public static Color Green = new Color(3, 133, 3);
}
