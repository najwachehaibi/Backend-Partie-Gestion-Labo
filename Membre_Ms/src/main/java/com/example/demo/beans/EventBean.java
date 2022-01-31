package com.example.demo.beans;

import java.util.Date;

public class EventBean {private Long id;

private String titre;

private String lieu;

private Date date;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getTitre() {
	return titre;
}

public void setTitre(String titre) {
	this.titre = titre;
}

public String getLieu() {
	return lieu;
}

public void setLieu(String lieu) {
	this.lieu = lieu;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date = date;
}

public EventBean(Long id, String titre, String lieu, Date date) {
	super();
	this.id = id;
	this.titre = titre;
	this.lieu = lieu;
	this.date = date;
}

public EventBean() {
	super();
	// TODO Auto-generated constructor stub
}


}
