package app;


import app.modules.users.classes.admin;
import app.modules.users.classes.client;
import app.modules.users.classes.registered_user;


public class Dummies {

	public static admin dummieadmin() {
		String dni = "", name = "", subname = "", mobile = "", email = "", user = "", pass = "", avatar = "",
				state = "";
		String date_birthday = "26/09/1997", hiring_date = "01/01/2016";
		float salary = 0;
		int activity = 0;

		admin admin = new admin( dni, name, subname, mobile, email, date_birthday, 
				 user, pass, avatar, state, hiring_date, salary, activity);
		admin.setDni("12345678Z");
		admin.setName("Lara");
		admin.setSubname("Montava");
		admin.setMobile("654566645");
		admin.setEmail("lara@gmail.com");
		admin.setUser("laramt");
		admin.setPass("12345");
		admin.setAvatar("avatar.jpg");
		admin.setState("Online");
		admin.setDate_birthday("12/12/1990");
		admin.setActivity(123);
		admin.setHiring_date("12/12/2000");

		return admin;

	}

	
}


