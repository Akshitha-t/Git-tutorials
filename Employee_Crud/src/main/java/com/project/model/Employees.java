package com.project.model;

import java.util.Locale;
import java.util.ResourceBundle;

//import java.util.Locale;

//import org.apache.log4j.Logger;


public class Employees {
	
	private int Id;
    private String name;
    private String password;
    private String designation;
   private float salary;
  // private static Logger logger = Logger.getLogger(Employees.class.getName());  
   public static void main(String args[]) {
	 //  Locale locale=Locale.getDefault();
	//   System.out.println("locale = "+locale);
	 //  System.out.println("DisplayCountry = " + locale.getDisplayCountry());
	 //  System.out.println("DisplayLanguage = " + locale.getDisplayLanguage());
	 //  System.out.println("DisplayName " + locale.getDisplayName());
	   String lang="in";
	   String country="ID";
	   Locale l= new Locale(lang,country);
	   ResourceBundle r=ResourceBundle.getBundle("MessageBundle",l);
	   //int ID=r.get("label.id");
	   String name=r.getString("label.name");
	   String password=r.getString("label.password");
	   
	   System.out.println(name);
	   System.out.println(password);
   }
 
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getDesignation() {
	return designation;
}
public void setDesignation(String designation) {
	this.designation = designation;
}
public float getSalary() {
	return salary;
}
public void setSalary(float salary) {
	this.salary = salary;
}
}


