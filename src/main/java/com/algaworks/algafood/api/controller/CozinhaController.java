package com.algaworks.algafood.api.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.repository.CozinhaRepository;




@RestController
@RequestMapping(value ="/cozinhas")
public class CozinhaController {

   @Autowired
   private CozinhaRepository cozinhaRepository;	
	
   @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE )
   public List<Cozinha> listar(){
	   return cozinhaRepository.todas();
	}
	
   @GetMapping("/{cozinhaId}")
   public Cozinha porId(@PathVariable Long cozinhaId) {
	   return cozinhaRepository.porId(cozinhaId);
	   
   }
}