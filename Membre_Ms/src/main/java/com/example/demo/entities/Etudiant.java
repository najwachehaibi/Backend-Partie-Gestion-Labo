package com.example.demo.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity 
@DiscriminatorValue("etd")

public class Etudiant extends Membre implements Serializable {

	private String diplome;
	@Temporal(TemporalType.DATE)
	private Date inscription;
	public Etudiant(String diplome, Date inscription, EnseignantChercheur encadrant) {
		super();
		this.diplome = diplome;
		inscription = inscription;
		this.encadrant = encadrant;
	}
	public Etudiant() {
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	private EnseignantChercheur encadrant;
	public String getDiplome() {
		return diplome;
	}
	public void setDiplome(String diplome) {
		this.diplome = diplome;
	}
	public Date getInscription() {
		return inscription;
	}
	public void setInscription(Date inscription) {
		inscription = inscription;
	}
	public EnseignantChercheur getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(EnseignantChercheur encadrant) {
		this.encadrant = encadrant;
	}
	

}
