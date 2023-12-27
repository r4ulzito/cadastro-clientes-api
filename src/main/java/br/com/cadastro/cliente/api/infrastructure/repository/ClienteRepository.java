package br.com.cadastro.cliente.api.infrastructure.repository;

import br.com.cadastro.cliente.api.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
