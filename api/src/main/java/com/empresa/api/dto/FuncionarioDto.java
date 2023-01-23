package com.empresa.api.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class FuncionarioDto {

    private String nome;
    private Integer idade;
    private String cpf;
    private String celular;
    private String cargo;
    private String setor;
    private BigDecimal salario;

}
