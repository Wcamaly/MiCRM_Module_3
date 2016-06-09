package com.next.micrm_module_3.model;

import java.util.ArrayList;
import java.util.List;

public class Commerce {
	private String description;
	private String title;
	private String dateFinish;
	private String status;
	private double value;
	private List<Organization> org = new ArrayList<Organization>();
	private List<People> peoples = new ArrayList<People>();
	
	boolean isEmpty =true;
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
	public Organization getOrg(int i) {
		return org.get(i);
	}
	public void setOrg(Organization org) {
		this.org.add(org);
		isEmpty =false;
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
	public void printPeople(){
		if(!peoples.isEmpty()){
			for(int i=0; i< peoples.size();i++){
				System.out.println(i+1 +"- "+peoples.get(i).getName()+"\n");
			}
		}else{
			System.out.println("0- No hay Persona cargada.\n");
		}
	}
	public void printOrganization(){
		if(!org.isEmpty()){
			for(int i=0; i< org.size();i++){
				System.out.println(i+1 +"- "+org.get(i).getName()+"\n");
			}
		}else{
			System.out.println("0- No hay Organizaciones Cargadas.\n");
		}
	}
	public void removePeopleOrganization(People p){
		if(p != null)
			peoples.remove(p);
	}
	public void removePeopleOrganization(Organization o){
		if(o != null)
			org.remove(o);
	}
}
