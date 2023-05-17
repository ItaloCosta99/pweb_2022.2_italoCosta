package br.com.italocosta.biritashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.italocosta.biritashop.model.Dependente;

@Repository
public interface DependenteRepository extends JpaRepository<Dependente, Long> {
  
}
