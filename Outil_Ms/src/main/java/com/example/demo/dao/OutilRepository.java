package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Outil;


@Repository
public interface OutilRepository extends JpaRepository<Outil, Long> {
	List<Outil> findBySource(String source);
	List<Outil> findBySourceStartingWith(String caractere);

}
