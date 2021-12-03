package com.teste.teste;

import javax.persistence.*;
//import lombok.*;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Compras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descricao;
    Double preco;
    Double quantidade;
    Double preco_total;

    public Compras(){
        
    }
    public Compras(Long id, String descricao, Double preco, Double quantidade, Double preco_total) {
        this.id = id;
        this.descricao = descricao;
        this.preco = preco;
        this.quantidade = quantidade;
        this.preco_total = preco_total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco_total() {
        return preco_total;
    }

    public void setPreco_total(Double preco_total) {
        this.preco_total = preco_total;
    }
}
