package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Embeddable
public class Membre_Pub_Ids  implements Serializable {
	private Long publication_id;
	private Long auteur_id;
	public Long getPublication_id() {
		return publication_id;
	}
	public void setPublication_id(Long publication_id) {
		this.publication_id = publication_id;
	}
	public Long getAuteur_id() {
		return auteur_id;
	}
	public void setAuteur_id(Long auteur_id) {
		this.auteur_id = auteur_id;
	}
	@Override
	public int hashCode() {
		return Objects.hash(auteur_id, publication_id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre_Pub_Ids other = (Membre_Pub_Ids) obj;
		return Objects.equals(auteur_id, other.auteur_id) && Objects.equals(publication_id, other.publication_id);
	}
	public Membre_Pub_Ids(Long publication_id, Long auteur_id) {
		super();
		this.publication_id = publication_id;
		this.auteur_id = auteur_id;
	}
	public Membre_Pub_Ids() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
