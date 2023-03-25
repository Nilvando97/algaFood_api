package com.algaworks.algafood.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.domain.model.Cozinha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CadastroCozinha {
	
	@PersistenceContext
	private EntityManager manager;
	
	public List<Cozinha> todas(){
		return manager.createQuery("from Cozinha", Cozinha.class)
				.getResultList();
	}
	
	@Transactional
	public Cozinha adicionar(Cozinha cozinha) {
		return manager.merge(cozinha);
	}

}
