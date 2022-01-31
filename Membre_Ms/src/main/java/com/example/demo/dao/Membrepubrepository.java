package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Membre_Pub_Ids;
import com.example.demo.entities.Membre_Publication;

public interface Membrepubrepository extends JpaRepository<Membre_Publication, Membre_Pub_Ids> {
	 
	//récuper la liste de publications d'un auteur donné 
	
	@Query("select m from Membre_Publication m where auteur_id=:x")
	List<Membre_Publication> findpubId(@Param ("x") Long autId);
	//JpaRepository<Membre_Publication, Membre_Pub_Ids>càd type de l'id c'est Membre_Pub_Ids
}