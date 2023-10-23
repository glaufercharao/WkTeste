package com.wkteste.main.models.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String cpf;
    private String rg;
    private LocalDate dataNasc;
    private String sexo;
    private double peso;
    private double altura;
    private String tipoSanguineo;
    private String nomePai;
    private String nomeMae;
    private String cep;
    private String endereco;
    private int numero;
    private String bairro;
    private String cidade;
    private String estado;
    private String email;
    private String telefoneFixo;
    private String celular;

}
