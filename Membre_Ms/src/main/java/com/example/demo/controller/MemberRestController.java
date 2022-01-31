package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.beans.UserBean;
import com.example.demo.entities.EnseignantChercheur;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Membre;
import com.example.demo.proxies.UserProxyService;
import com.example.demo.service.IMemberService;

@CrossOrigin
@RestController
public class MemberRestController {
	@Autowired
	IMemberService memberService;
	
	@Autowired 
	UserProxyService userProxyService;

	@RequestMapping(value = "/membres", method = RequestMethod.GET)
	public List<Membre> findMembres() {
		return memberService.findAll();
	}

	@GetMapping(value = "/membre/{id}")
	public Membre findOneMemberById(@PathVariable Long id) {
		return memberService.findMember(id);
	}

	@GetMapping(value = "/membre/search/cin")
	public Membre findOneMemberByCin(@RequestParam String cin) {
		return memberService.findByCin(cin);
	}

	@GetMapping(value = "/membre/search/email")
	public Membre findOneMemberByEmail(@RequestParam String email) {
		return memberService.findByEmail(email);
	}
	@GetMapping("/MemberCompte/{id}")
	public Membre getMemberCompte(@PathVariable Long id) {
	Membre b=memberService.findMember(id);
	b.setUserBean(userProxyService.findOneUserById(b.getCompteID()));

	return b;

	

	}
	@GetMapping("/Compte/{id}")
	public Membre getCompte(@PathVariable Long id) {
	//Membre b=memberService.findMember(id);
	//UserBean bb = userProxyService.findOneUserById(id);
	//Membre bb
	return memberService.findByCompteID(id);
	
	//return b;

	

	}

	@PostMapping(value = "/membres/enseignant")
	public Membre addMembre(@RequestBody EnseignantChercheur m) {
		return memberService.addMember(m);
	}

	@PostMapping(value = "/membres/etudiant")
	public Membre addMembre(@RequestBody Etudiant e) {
		return memberService.addMember(e);
	}

	@PutMapping(value = "/membres/etudiant/{id}")
	public Membre updatemembre(@PathVariable Long id, @RequestBody Etudiant p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@PutMapping(value = "/membres/enseignant/{id}")
	public Membre updateMembre(@PathVariable Long id, @RequestBody EnseignantChercheur p) {
		p.setId(id);
		return memberService.updateMember(p);
	}

	@DeleteMapping(value = "/membres/{id}")
	public void deleteMembre(@PathVariable Long id) {
		memberService.deleteMember(id);
	}
	@GetMapping("/fullmember/{id}")
	public Membre findAFullMember(@PathVariable(name="id") Long id){
	Membre mbr =memberService.findMember(id);
	mbr.setPubs(memberService.findPublicationparauteur(id));
    mbr.setEvents(memberService.findEventparauteur(id));
    mbr.setOutils(memberService.findOutilparauteur(id));
	return mbr ;}
	
	@PutMapping(value = "/compte")
	public Membre compte(@PathVariable Long idm,@RequestBody Membre p) {
		p.setId(idm);
		return memberService.updateMember(p);
		//return memberService.affecteCompteMembre(idm, idc);
		
	}
	
	

}
