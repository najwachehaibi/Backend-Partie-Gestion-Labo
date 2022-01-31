package com.example.demo.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Membre_Event_Ids implements Serializable {
	private Long event_id;
	private Long auteur_id;

	public Membre_Event_Ids() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(auteur_id, event_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Membre_Event_Ids other = (Membre_Event_Ids) obj;
		return Objects.equals(auteur_id, other.auteur_id) && Objects.equals(event_id, other.event_id);
	}

	public Long getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Long event_id) {
		this.event_id = event_id;
	}

	public Long getAuteur_id() {
		return auteur_id;
	}

	public void setAuteur_id(Long auteur_id) {
		this.auteur_id = auteur_id;
	}

	public Membre_Event_Ids(Long event_id, Long auteur_id) {
		super();
		this.event_id = event_id;
		this.auteur_id = auteur_id;
	}

}
