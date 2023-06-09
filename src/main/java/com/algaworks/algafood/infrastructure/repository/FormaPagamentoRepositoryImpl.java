package com.algaworks.algafood.infrastructure.repository;

import java.util.List;


import org.springframework.stereotype.Repository;

import com.algaworks.algafood.domain.model.FormaPagamento;

import com.algaworks.algafood.domain.repository.FormaPagamentoRepository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Repository
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<FormaPagamento> todas() {
	   return manager.createQuery("from FormaPagamento", FormaPagamento.class)
			  .getResultList();
	}
	
	@Override
	public FormaPagamento porId(Long id) {
		return manager.find(FormaPagamento.class, id);
	}
	
	@Override
	@Transactional
	public FormaPagamento adicionar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	} 
	
	@Override
	@Transactional
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = porId(formaPagamento.getId());
		manager.remove(formaPagamento);
	}

}
