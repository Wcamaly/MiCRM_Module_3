package com.next.micrm_module_3.model;

public class Organization extends Entidad {
	private String address;
	public Organization(){
		super();
		setAddress("");
	}
	Organization(String n, String t, String a){
		super(n,t);
		address = a;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
		isEmpty =false;
	}
}
