package com.example.demo.entities;



import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Membre_Publication {
	@EmbeddedId
	private Membre_Pub_Ids id;
	@ManyToOne
	@MapsId("auteur_id")
	private Membre auteur;

	public Membre_Pub_Ids getId() {
		return id;
	}

	public void setId(Membre_Pub_Ids id) {
		this.id = id;
	}

	public Membre getAuteur() {
		return auteur;
	}

	public void setAuteur(Membre auteur) {
		this.auteur = auteur;
	}

	public Membre_Publication(Membre_Pub_Ids id, Membre auteur) {
		super();
		this.id = id;
		this.auteur = auteur;
	}

	public Membre_Publication() {
		super();
		// TODO Auto-generated constructor stub
	}

}
