package com.next.micrm_module_3.model;

import com.next.micrm_module_3.model.interfaces.Entidad;

public class People implements Entidad {
	String email;
	private String name;
	private String tel;
	private boolean is =true;


	public People(){
		name ="";
		tel="";
		email = "";
	}
	public People(String n,String t, String e){
		name = n;
		tel = t;
		email = e;
	}
	public String getName(){return name;}
	public String getTel(){return tel;}
	public void setName(String n){name=n;is =false;}
	public void setTel(String t){tel = t;is =false;}
	public String getEmail(){return email;}
	public void setEmail(String e){email = e;is =false; }


	@Override
	public boolean isEmpty() {
		return is;
	}
}
