package app.modules.users.classes;

import java.util.Comparator;

public class orderdatebirthday implements Comparator <users> {
	public int compare(users u1, users u2){
		
		return u1.getDate_birthday().compareTo(u2.getDate_birthday());
		}
}
