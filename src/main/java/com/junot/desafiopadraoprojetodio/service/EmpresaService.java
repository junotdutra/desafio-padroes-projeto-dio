package com.junot.desafiopadraoprojetodio.service;

import com.junot.desafiopadraoprojetodio.model.Empresa;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "cnpjws", url = "https://publica.cnpj.ws/")
public interface EmpresaService {


    @GetMapping("cnpj/{cnpj}")
    Empresa consultarCnpj(@PathVariable("cnpj") String cnpjEmpresa);

}
