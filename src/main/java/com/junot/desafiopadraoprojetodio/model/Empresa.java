package com.junot.desafiopadraoprojetodio.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Empresa {

    @Id
    public String cnpj_raiz;
    public String razao_social;
    public String capital_social;
    public String responsavel_federativo;
    public Date atualizado_em;

    public String getCnpj_raiz() {
        return cnpj_raiz;
    }

    public void setCnpj_raiz(String cnpj_raiz) {
        this.cnpj_raiz = cnpj_raiz;
    }

    public String getRazao_social() {
        return razao_social;
    }

    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }

    public String getCapital_social() {
        return capital_social;
    }

    public void setCapital_social(String capital_social) {
        this.capital_social = capital_social;
    }

    public String getResponsavel_federativo() {
        return responsavel_federativo;
    }

    public void setResponsavel_federativo(String responsavel_federativo) {
        this.responsavel_federativo = responsavel_federativo;
    }

    public Date getAtualizado_em() {
        return atualizado_em;
    }

    public void setAtualizado_em(Date atualizado_em) {
        this.atualizado_em = atualizado_em;
    }


}
