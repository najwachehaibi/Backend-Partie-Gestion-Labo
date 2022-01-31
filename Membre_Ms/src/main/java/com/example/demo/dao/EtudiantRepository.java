package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant,Long>
{

	List<Etudiant> findByDiplome(String diplome);

	List<Etudiant> findByDiplomeOrderByInscriptionDesc(String diplome);
	//findByNomAttribut w lezem il attribut ikoun fil entity yebda bil miniscule
	List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);
	
	
}