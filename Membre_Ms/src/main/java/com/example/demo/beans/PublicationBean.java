package com.example.demo.beans;

import java.util.Date;

public class PublicationBean {
	private Long id;
	private String type;
	private String titre;
	private String lien;
	private String Sourcepdf;
	private Date date;
	
	public PublicationBean(String type, String titre, String lien, String sourcepdf, Date date) {
		super();
		this.type = type;
		this.titre = titre;
		this.lien = lien;
		Sourcepdf = sourcepdf;
		this.date = date;
	}
	
	public PublicationBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}
	public String getSourcepdf() {
		return Sourcepdf;
	}
	public void setSourcepdf(String sourcepdf) {
		Sourcepdf = sourcepdf;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
