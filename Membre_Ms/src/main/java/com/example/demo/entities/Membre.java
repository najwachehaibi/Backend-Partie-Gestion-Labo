package com.example.demo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.beans.UserBean;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type_mbr", discriminatorType = DiscriminatorType.STRING, length = 3)

public abstract class Membre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cin;
	
	private String email;
	
	@Transient
	Collection<PublicationBean> pubs;
	@Transient
	Collection<OutilBean> outils;
	@Transient
	Collection<EventBean> events;
	@Transient
	private UserBean userBean; 
	
	private Long compteID;
	

	public Collection<EventBean> getEvents() {
		return events;
	}

	public void setEvents(Collection<EventBean> events) {
		this.events = events;
	}

	public Collection<OutilBean> getOutils() {
		return outils;
	}

	public void setOutils(Collection<OutilBean> outils) {
		this.outils = outils;
	}

	public Collection<PublicationBean> getPubs() {
		return pubs;
	}

	public void setPubs(Collection<PublicationBean> pubs) {
		this.pubs = pubs;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public Long getCompteID() {
		return compteID;
	}

	public void setCompteID(Long compteID) {
		this.compteID = compteID;
	}

	private String nom;

	private String prenom;
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	private String cv;
	private byte[] photo;
 
	public Membre() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membre(String cin, String nom, String prenom, Date dateNaissance, String cv, byte[] photo,String email) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.cv = cv;
		this.photo = photo;
		this.email=email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
}
