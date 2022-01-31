package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.example.demo.beans.PublicationBean;
import com.example.demo.dao.MembreRepository;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.proxies.PublicationProxyService;
import com.example.demo.service.IMemberService;
import java.util.List;



@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class MembreMsApplication implements CommandLineRunner {
	@Autowired
	MembreRepository m;
	@Autowired
	IMemberService memberService;
	@Autowired
	PublicationProxyService publicationProxyService;

	@Autowired
	IMemberService iMemberService;
	public static void main(String[] args) {
		SpringApplication.run(MembreMsApplication.class, args);
	}

	public void run(String... args) throws Exception {
		
        //iMemberService.affecteCompteMembre(2L, 2L);

		/*Membre etd1 = new Etudiant();

		etd1.setNom("Islem");
		etd1.setPrenom("abid");
		etd1.setCin("11113051");
		etd1.setCv("is");
		etd1.setDateNaissance(new Date(12, 8, 2021));
		etd1.setEmail("islem.abidàenis.tn");
		etd1.setPhoto(null);
		m.save(etd1);
		Membre etd2 = new Etudiant();

		etd2.setNom("Islem");
		etd2.setPrenom("abid");
		etd2.setCin("11113051");
		etd2.setCv("is");
		etd2.setDateNaissance(new Date(12, 8, 2021));
		etd2.setEmail("islem.abidàenis.tn");
		etd2.setPhoto(null);
		memberService.addMember(etd2);

		Membre ensg = new EnseignantChercheur();
		ensg.setNom("Islem");
		ensg.setPrenom("abid");
		ensg.setCin("11113051");
		ensg.setCv("is");
		ensg.setDateNaissance(new Date(12, 8, 2021));
		ensg.setEmail("islem.abidàenis.tn");
		ensg.setPhoto(null);
		m.save(ensg);

		// Update a Member

		Membre m = memberService.findMember(etd1.getId());
		m.setCv("cv1.pdf");
		memberService.updateMember(m);
		// Delete a Member
		// memberService.deleteMember(etd1.getId());
		// tester proxies
		PublicationBean publicationBean = publicationProxyService.findPublicationById(1L);
        System.out.println(publicationBean.getTitre() + " " + publicationBean.getType());
        iMemberService.affecterauteurTopublication(1L, 1L);
		 iMemberService.affecterauteurTopublication(1L, 2L);
		 iMemberService.affecterauteurTopublication(3L, 3L);
		// recupérer pub par auteur id =1
		 */
		//PublicationBean publicationBean = publicationProxyService.findPublicationById(1L);
        //System.out.println(publicationBean.getTitre() + " " + publicationBean.getType());
        //iMemberService.affecteCompteMembre(2L, 2L);
	}
}