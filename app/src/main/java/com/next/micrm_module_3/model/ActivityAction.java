package com.next.micrm_module_3.model;

public class ActivityAction {

	private String description;
	private String type;
	private String date;
	private String hour;
	private String duration;
	private People people;
	private Organization org;
	private Commerce commerce;

	private boolean asign;
	public ActivityAction(){
		description ="";
		type= "";
		date ="";
		hour ="";
		duration="";
		people = null;
		org = null;
		commerce = null;
		asign=false;
	}
	private String getNameCommerce() {	
		if (commerce != null)
			return  commerce.getTitle();
		return null;	
	}
	private String getNameOrganization() {
		if(org != null)
			return org.getName();
		return null;
		
	}
	
	private String getNamePeople() {
		if(people != null)
			return people.getName();
		return null;
	}
	public void asignActivity (People p){
		if (!asign){
			people = p;
			System.out.println("Quedo asignada a"+p.getName()+".");
		}else{
			System.out.println("Ya esta asiganada esta Actividad.");
		}
	}
	public void asignActivity (Organization o){
		if (!asign){
			org = o;
			System.out.println("Quedo asignada a"+o.getName()+".");
		}else{
			System.out.println("Ya esta asiganada esta Actividad.");
		}
	}
	public void asignActivity (Commerce c){
		if (!asign){
			commerce = c;
			System.out.println("Quedo asignado a "+c.getTitle()+".");
		}else{
			System.out.println("Ya esta asiganada esta Actividad.");
		}
	}
	public String whoAsign(){
		if(asign){
			if (!getNamePeople().isEmpty()){
				return "Esta asignado a la persona: "+getNamePeople();
			}else if(!getNameOrganization().isEmpty()){
				return "Esta asignado a la organisaci�n: "+getNameOrganization();
			}else {
				return "Esta asignado al negocio: "+getNameCommerce();
			}		
		}	
		return "Esta Actividad no esta asiganada";
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void removeAsign(){
		asign = false;
		if (people != null ){
			people = null;
		}if(org != null)
			org = null;
		if(commerce != null)
			commerce=null;		
	}
}
	