package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Ids;
import com.example.demo.entities.Membre_Publication;


public interface MembreOutilrepository extends JpaRepository<Membre_Outil, Membre_Outil_Ids> {
	
	@Query("select m from Membre_Outil m where auteur_id=:x")
	List<Membre_Outil> findOutilId(@Param ("x") Long autId);
}
