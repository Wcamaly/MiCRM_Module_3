package com.next.micrm_module_3.model;

import com.next.micrm_module_3.model.interfaces.Entidad;

import java.util.ArrayList;
import java.util.List;
/*
* This class is the model to Commerce
*/
public class Commerce implements Entidad {
	private String description;
	private String title;
	private String dateFinish;
	private String status;
	private double value;
	private List<Organization> org = new ArrayList<Organization>();
	private List<People> peoples = new ArrayList<People>();
	private boolean isEmpty =true;
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
		isEmpty =false;
	}

	public double getValue() {
		return value;

	}
	public void setValue(double value) {
		this.value = value;
		isEmpty =false;
	}

	public String getDateFinish() {
		return dateFinish;
	}
	public void setDateFinish(String dateFinish) {
		this.dateFinish = dateFinish;
		isEmpty =false;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
		isEmpty =false;
	}
	public List<Organization> getOrganizations() {
		return org;
	}
	public void setOrg(Organization org) {
		this.org.add(org);
		isEmpty =false;
	}
	public List<People> getPeoples() {
		return peoples;
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
		return isEmpty;
	}
}
