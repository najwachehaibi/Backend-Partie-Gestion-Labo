package com.example.demo.service;

import java.util.List;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;

public interface IMemberService {
	// Crud sur les membres
	public Membre addMember(Membre m);

	public void deleteMember(Long id);

	public Membre updateMember(Membre p);

	public Membre findMember(Long id);

	public List<Membre> findAll();

	// Filtrage par propriété
	public Membre findByCin(String cin);

	public Membre findByEmail(String email);
	
	public Membre findByCompteID(Long id);

	public List<Membre> findByNom(String nom);

	// recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);

	// recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);

	public List<EnseignantChercheur> findByEtablissement(String etablissement);
	 public Etudiant  affecterEtudiantEnseignant(long idEtd,long idEnsg);
	 public List<Etudiant> findByEncadrant(Long idEnsg);
	 public Etudiant affecterencadrantToetudiant(Long idetd, Long idens);
		
		public List<Etudiant> findEtudiantsByEncadrant(Long idens);
		
		
		//• Affecter une publication à un auteur
		public void affecterauteurTopublication(Long idauteur, Long idpub);
		
		
        //Récupérer les publications d’un auteur
		public List<PublicationBean> findPublicationparauteur (Long idauteur);
		
		public void affecterauteurToOutil(Long idauteur, Long idOutil);
		public List<OutilBean> findOutilparauteur (Long idauteur);
		
		
		public void affecterauteurToEvent(Long idauteur, Long idEvent);
		public List<EventBean> findEventparauteur (Long idauteur);

		public Membre affecteCompteMembre(Long idmembre, Long idcompte);

		
	}


