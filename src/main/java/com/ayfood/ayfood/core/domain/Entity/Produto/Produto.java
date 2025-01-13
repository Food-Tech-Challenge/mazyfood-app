package com.ayfood.ayfood.core.domain.Entity.Produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@AllArgsConstructor

public class Produto {

    private final IdProduto id;
    private String nome;
    private String descricao;
    private double preco;


}
