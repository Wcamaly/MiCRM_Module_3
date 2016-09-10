package com.next.micrm_module_3.model;

import com.next.micrm_module_3.model.interfaces.Entidad;
/*
* This class is the model to Organization
*/
public class Organization implements Entidad {
	private String address;
	private String name;
	private String tel;
	private boolean is = true;
	public Organization(){
		name="";
		tel="";
		address="";
	}
	Organization(String n, String t, String a){
		setName(n);
		setTel(t);
		setAddress(a);
	}
	public String getName(){return name;}
	public String getTel(){return tel;}
	public void setName(String n){name=n;is =false;}
	public void setTel(String t){tel = t;is =false;}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		is =false;
	}

	@Override
	public boolean isEmpty() {
		return is;
	}
}
