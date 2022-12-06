package com.junot.desafiopadraoprojetodio.repository;

import com.junot.desafiopadraoprojetodio.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}