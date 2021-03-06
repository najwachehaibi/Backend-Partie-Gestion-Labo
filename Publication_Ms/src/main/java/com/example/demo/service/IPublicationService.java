package com.example.demo.service;

import java.util.List;

import com.example.demo.entities.Publication;

public interface IPublicationService {
	public Publication addPublication(Publication p);

	public void deletePublication(Long id);

	public Publication updatePublication(Publication p);

	public Publication  findPublication (Long id);

	public List<Publication > findAll();

	// Filtrage par propriété
	public Publication findBytitre(String titre);

	public Publication  findBytype(String type);

	

}
