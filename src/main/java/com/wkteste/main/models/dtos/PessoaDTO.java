package com.wkteste.main.models.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PessoaDTO {

    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    @JsonProperty("data_nasc")
    @JsonFormat(pattern="dd/MM/yyyy")
    private LocalDate dataNasc;
    private String sexo;
    private double peso;
    private double altura;
    @JsonProperty("tipo_sanguineo")
    private String tipoSanguineo;
    @JsonProperty("pai")
    private String nomePai;
    @JsonProperty("mae")
    private String nomeMae;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    @JsonProperty("telefone_fixo")
    private String telefoneFixo;
    private String celular;

}
