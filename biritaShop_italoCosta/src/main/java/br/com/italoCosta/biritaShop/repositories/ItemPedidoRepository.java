package br.com.italocosta.biritashop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.italocosta.biritashop.model.ItemPedido;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
  
}
