package com.next.micrm_module_3.model;

import com.next.micrm_module_3.model.interfaces.Entidad;

public class ActivityAction {

	private String description;
	private String type;
	private String date;
	private String hour;
	private String duration;
	private Entidad entidad;


	private boolean asign;
	public ActivityAction(){
		description ="";
		type= "";
		date ="";
		hour ="";
		duration="";
		entidad= null;
		asign=false;
	}
	public void asignActivity (Entidad p){
		if (!asign){
			entidad = p;
			asign=true;
		}
	}
	public Entidad whoAsign(){
		if(asign){
			return entidad;
		}	
		return null;
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
		entidad = null;
	}
}
	