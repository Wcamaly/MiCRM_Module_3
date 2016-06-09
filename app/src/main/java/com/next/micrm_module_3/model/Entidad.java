package com.next.micrm_module_3.model;

public class Entidad {
	private String name;
	private String tel;
	boolean isEmpty =true;
	public  Entidad(){
		name ="";
		tel="";
	}
	public  Entidad(String n, String t){
		name = n;
		tel = t;
		isEmpty =false;
	}
	public String getName(){return name;}
	public String getTel(){return tel;}
	public void setName(String n){name=n;isEmpty =false;}
	public void setTel(String t){tel = t;isEmpty =false;}
	
	
}
