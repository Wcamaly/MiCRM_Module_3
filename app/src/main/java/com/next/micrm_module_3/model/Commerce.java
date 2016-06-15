package com.next.micrm_module_3.model;

import com.next.micrm_module_3.model.interfaces.Entidad;

import java.util.ArrayList;
import java.util.List;

public class Commerce implements Entidad {
	private String description;
	private String title;
	private String dateFinish;
	private String status;
	private double value;
	private List<Entidad> org = new ArrayList<Entidad>();
	private boolean is = true;

	public Commerce(){
		description ="";
		title="";
		value = 0;
		dateFinish="";
		status="";
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
		is=false;
	}
	
	public double getValue() {
		return value;
		
	}
	public void setValue(double value) {
		this.value = value;
		is =false;
	}
	
	public String getDateFinish() {
		return dateFinish;
	}
	public void setDateFinish(String dateFinish) {
		this.dateFinish = dateFinish;
		is =false;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		is =false;
	}
	public Organization getOrg(int i) {
		return org.get(i);
	}
	public void setOrg(Organization org) {
		this.org.add(org);
		is =false;
	}
	public People getPeoples(int i) {
		return peoples.get(i);
	}
	public void setPeoples(People peoples) {
		this.peoples.add(peoples);
	}
	public boolean isExit(People p){
		if(p != null)
			return peoples.contains(p);
		else 
			return true;
	}
	public boolean isExit(Organization o){
		if(o != null)
			return org.contains(o);
		else
			return true;
	}
	public void removePeopleOrganization(People p){
		if(p != null)
			peoples.remove(p);
	}
	public void removePeopleOrganization(Organization o){
		if(o != null)
			org.remove(o);
	}

	@Override
	public boolean isEmpty() {
		return is;
	}
}
