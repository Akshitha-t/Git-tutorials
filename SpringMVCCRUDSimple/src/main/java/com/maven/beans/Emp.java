package com.maven.beans;

import org.apache.log4j.LogManager;  


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;  

public class Emp {  
    

private int id;  
private String name;  
private float salary;  
private String designation;  
private static final Logger logger = LogManager.getLogger(Emp.class);  
public static void main(String args[]) {
    DOMConfigurator.configure("log4j.xml");  
   
}

public int getId() {  
	
    return id;  
}  
public void setId(int id) {  
    this.id = id;  
}  
public String getName() {  
    return name;  
}  
public void setName(String name) {  
    this.name = name;  
}  
public float getSalary() {  
    return salary;  
}  
public void setSalary(float salary) {  
    this.salary = salary;  
}  
public String getDesignation() {  
    return designation;  
}  
public void setDesignation(String designation) {  
    this.designation = designation;  
}  
}