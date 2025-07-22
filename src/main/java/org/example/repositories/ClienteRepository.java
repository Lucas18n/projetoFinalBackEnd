package org.example.repositories;

import org.example.entities.Cliente;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @EntityGraph(attributePaths = {"enderecos", "contatos"})
    Optional<Cliente> findById(Long id);

    @EntityGraph(attributePaths = {"enderecos", "contatos"})
    List<Cliente> findAll();
}