package org.example.repositories;

import org.example.DTO.CategoriaProdutoDTO;
import org.example.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("SELECT p.categoria AS categoria, COUNT(p) AS quantidade FROM Produto p GROUP BY p.categoria")
    List<CategoriaProdutoDTO> findQuantidadePorCategoria();
}
