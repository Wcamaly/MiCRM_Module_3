package com.next.micrm_module_3.model;

import com.next.micrm_module_3.model.interfaces.Entidad;
/*
* This class is the model to Activitys
*/



public class ActivityAction implements Entidad {

	private String description;
	private String type;
	private String date;
	private String hour;
	private String duration;
	private Entidad entidad;
	private boolean empty = true;

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
			empty = false;
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
		empty = false;
		this.duration = duration;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		empty = false;
		this.hour = hour;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		empty = false;
		this.date = date;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		empty = false;
		this.type = type;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {

		empty = false;
		this.description = description;
	}
	public void removeAsign(){
		asign = false;
		entidad = null;
	}

	@Override
	public boolean isEmpty() {
		return empty;
	}
}
	