package com.wkteste.main.services;

import com.wkteste.main.models.dtos.PessoaDTO;
import com.wkteste.main.models.entities.Pessoa;

import java.util.List;
import java.util.Map;

public interface PessoaService {

    PessoaDTO savePessoa(PessoaDTO pessoa);
    List<PessoaDTO> saveAllPessoas(List<PessoaDTO> pessoa);
    List<Map<String, Integer>> qtdPessoaPorEstado();

    List<PessoaDTO> buscarDoadores();

    List<Map<String, Long>> qtdDoadorTipoReceptor();

}
