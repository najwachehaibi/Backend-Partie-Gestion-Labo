package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Membre_Event;
import com.example.demo.entities.Membre_Event_Ids;

public interface MembreEventrepository extends JpaRepository<Membre_Event, Membre_Event_Ids> {

	@Query("select m from Membre_Event m where auteur_id=:x")
	List<Membre_Event> findEventId(@Param("x") Long autId);
}
