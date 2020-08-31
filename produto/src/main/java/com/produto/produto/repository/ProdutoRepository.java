package com.produto.produto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.produto.produto.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>
{

}
