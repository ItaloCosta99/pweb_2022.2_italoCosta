package br.com.italocosta.biritashop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.italocosta.biritashop.model.Cliente;
import br.com.italocosta.biritashop.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
  List<Pedido> findByClientePedido(Cliente cliente);
}
