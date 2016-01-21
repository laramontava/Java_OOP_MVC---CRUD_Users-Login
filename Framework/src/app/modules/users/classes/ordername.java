package app.modules.users.classes;

import java.util.Comparator;

public class ordername implements Comparator <users>{
	public int compare(users u1,users u2){
		if(u1.getName().compareTo(u2.getName())>0)
			return 1;
		if(u1.getName().compareTo(u2.getName())<0)
			return -1;
		return 0;
	}
}
