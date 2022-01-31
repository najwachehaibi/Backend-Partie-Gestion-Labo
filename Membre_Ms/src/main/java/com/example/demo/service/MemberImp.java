package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.beans.EventBean;
import com.example.demo.beans.OutilBean;
import com.example.demo.beans.PublicationBean;
import com.example.demo.beans.UserBean;
import com.example.demo.dao.EnseignantChercheurRepository;
import com.example.demo.dao.EtudiantRepository;
import com.example.demo.dao.MembreEventrepository;
import com.example.demo.dao.MembreOutilrepository;
import com.example.demo.dao.MembreRepository;
import com.example.demo.dao.Membrepubrepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.entities.Membre_Event;
import com.example.demo.entities.Membre_Event_Ids;
import com.example.demo.entities.Membre_Outil;
import com.example.demo.entities.Membre_Outil_Ids;
import com.example.demo.entities.Membre_Pub_Ids;
import com.example.demo.entities.Membre_Publication;
import com.example.demo.proxies.EventProxyService;
import com.example.demo.proxies.OutilProxyService;
import com.example.demo.proxies.PublicationProxyService;
import com.example.demo.proxies.UserProxyService;

@Service
public class MemberImp implements IMemberService {
	@Autowired
	MembreRepository memberRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	MembreEventrepository membreEventrepository;
	@Autowired
	EnseignantChercheurRepository enseignantRechercheur;
	@Autowired
	Membrepubrepository membrepubrepository;
	@Autowired
	PublicationProxyService publicationProxyService;
	@Autowired
	MembreOutilrepository membreoutilrepository;
	@Autowired
	OutilProxyService outilProxyService;
	@Autowired
	EventProxyService eventProxyService;
	@Autowired 
	UserProxyService userProxyService;
	
	
	@Override
	public Membre addMember(Membre m) {
		memberRepository.save(m);
		return m;

	}

	@Override
	public void deleteMember(Long id) {
		// get()!=null hiya nafssa isPresent()
		if(memberRepository.findById(id).isPresent())
			memberRepository.deleteById(id);	
	}
		

	

	@Override
	public Membre updateMember(Membre p) {
		return memberRepository.saveAndFlush(p);

	}

	@Override
	public Membre findMember(Long id) {
		Membre m = (Membre) memberRepository.findById(id).get();
		return m;

	}
	
	@Override
	public Membre findByCompteID(Long c) {
		Membre m = (Membre) memberRepository.findByCompteID(c);
		return m;

	}

	@Override
	public List<Membre> findAll() {

		return memberRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {

		return memberRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {

		return memberRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {

		return memberRepository.findByNomStartingWith(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {

		List<Etudiant> etds = etudiantRepository.findByDiplome(diplome);
		return etds;
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {

		List<EnseignantChercheur> engs = enseignantRechercheur.findByGrade(grade);
		return engs;
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		List<EnseignantChercheur> enseignants = enseignantRechercheur.findByEtablissement(etablissement);
		return enseignants;
	}

	@Override
	public Etudiant affecterEtudiantEnseignant(long idEtd, long idEnsg) {
		Etudiant etd = etudiantRepository.findById(idEtd).get();
		EnseignantChercheur ensg = enseignantRechercheur.findById(idEnsg).get();
		etd.setEncadrant(ensg);
		memberRepository.save(etd);
		return etd;
	}

	@Override
	public List<Etudiant> findByEncadrant(Long idEnsg) {
		EnseignantChercheur ensg = enseignantRechercheur.findById(idEnsg).get();
		List<Etudiant> etds = etudiantRepository.findByEncadrant(ensg);
        return etds;
	}

	@Override
	public Etudiant affecterencadrantToetudiant(Long idetd, Long idens) {
		Etudiant etd= etudiantRepository.findById(idetd).get();
		EnseignantChercheur ens=enseignantRechercheur.findById(idens).get();
		etd.setEncadrant(ens);
		return etudiantRepository.save(etd);
	}

	@Override
	public List<Etudiant> findEtudiantsByEncadrant(Long idens) {
		EnseignantChercheur ens=enseignantRechercheur.findById(idens).get();
		return etudiantRepository.findByEncadrant(ens);
	}

	@Override
	public void affecterauteurTopublication(Long idauteur, Long idpub) {
		Membre mbr= memberRepository.findById(idauteur).get();
		Membre_Publication mbs= new Membre_Publication();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Pub_Ids(idpub, idauteur));
		membrepubrepository.save(mbs);
		
	}

	@Override
	public List<PublicationBean> findPublicationparauteur(Long idauteur) {
		List<PublicationBean> pubs= new ArrayList<PublicationBean>();
		List< Membre_Publication> idpubs=membrepubrepository.findpubId(idauteur);

		idpubs.forEach(s->
		
		pubs.add(publicationProxyService.findPublicationById(s.getId().getPublication_id())));
		
		return pubs;
	}

	@Override
	public void affecterauteurToOutil(Long idauteur, Long idOutil) {
		Membre mbr= memberRepository.findById(idauteur).get();
		Membre_Outil mbs= new Membre_Outil();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Outil_Ids ());
		membreoutilrepository.save(mbs);
		
		
	}

	@Override
	public List<OutilBean> findOutilparauteur(Long idauteur) {
		List<OutilBean> outils= new ArrayList<OutilBean>();
		List< Membre_Outil> idpubs=membreoutilrepository.findOutilId(idauteur);

		idpubs.forEach(s->
		
		outils.add(outilProxyService.findOneOutilById(s.getId().getOutil_id())));
		
		return outils;
	
	}

	@Override
	public void affecterauteurToEvent(Long idauteur, Long idEvent) {
		Membre mbr= memberRepository.findById(idauteur).get();
		Membre_Event mbs= new Membre_Event();
		mbs.setAuteur(mbr);
		mbs.setId(new Membre_Event_Ids ());
		membreEventrepository.save(mbs);
		
	}

	@Override
	public List<EventBean> findEventparauteur(Long idauteur) {
		List<EventBean> events= new ArrayList<EventBean>();
		List< Membre_Event> idpubs=membreEventrepository.findEventId(idauteur);

		idpubs.forEach(s->
		
		events.add(eventProxyService.findOneEventById(s.getId().getEvent_id())));
		
		return  events ;
	}

	@Override
	public Membre affecteCompteMembre(Long idmembre, Long idcompte) {
		Membre mbr= memberRepository.findById(idmembre).get();
		Long mbs= userProxyService.findOneUserById(idcompte).getId();

		//Membre_Event mbs= new Membre_Event();
		mbr.setCompteID(mbs);
		//mbs.setId(new Membre_Event_Ids ());
		return memberRepository.save(mbr);		
	}

}
