package br.com.italocosta.biritashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.italocosta.biritashop.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  
}
