package com.next.micrm_module_3.model;

public class People extends Entidad {
	String email;
	
	public People(){
		super();
		email = "";
	}
	public People(String n,String t, String e){
		super(n,t);
		email = e;
	}
	public String getEmail(){return email;}
	public void setEmail(String e){email = e;isEmpty =false; }
	
	
}
