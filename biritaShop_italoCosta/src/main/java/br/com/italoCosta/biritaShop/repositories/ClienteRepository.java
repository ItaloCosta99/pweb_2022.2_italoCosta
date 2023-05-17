package br.com.italocosta.biritashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.italocosta.biritashop.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
  
}
