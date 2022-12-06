package com.junot.desafiopadraoprojetodio.repository;

import com.junot.desafiopadraoprojetodio.model.Empresa;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends CrudRepository<Empresa,String> {
}
